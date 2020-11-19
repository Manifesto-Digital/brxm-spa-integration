package uk.co.manifesto.brxm.components;

import org.bloomreach.forge.brut.common.repository.utils.ImporterUtils;
import org.bloomreach.forge.brut.components.exception.SetupTeardownException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.co.manifesto.brxm.beans.NewsDocument;

import javax.jcr.RepositoryException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewsComponentTest extends ManifestoBaseComponentTest {

    private final NewsComponent component = new NewsComponent();

    @BeforeEach
    public void setup() {
        try {
            super.setup();

            registerNodeType(NewsDocument.DOCUMENT_TYPE);
            registerMixinType("hippo:versionInfo");

            ImporterUtils.importYaml(getClass().getResource("/news.yaml"), rootNode, DOCUMENT_ROOT_PATH, "hippostd:folder");

            setContentBean("/content/documents/spaintegration/news/2020/11/the-medusa-news");

            recalculateHippoPaths();
            setSiteContentBase(DOCUMENT_ROOT_PATH);
            component.init(null, componentConfiguration);
        } catch (RepositoryException e) {
            throw new SetupTeardownException(e);
        }
    }

    @Test
    public void setCustomModelAttribute() {
        component.doBeforeRender(request, response);
        String attributeValue = getRequestAttribute("customModelAttribute");
        assertEquals(attributeValue, "Custom Model Attribute");
    }
}
