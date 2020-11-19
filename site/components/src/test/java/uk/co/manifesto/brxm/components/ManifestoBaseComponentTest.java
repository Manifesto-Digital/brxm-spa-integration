package uk.co.manifesto.brxm.components;

import org.bloomreach.forge.brut.components.BaseComponentTest;
import org.junit.jupiter.api.AfterEach;

public abstract class ManifestoBaseComponentTest extends BaseComponentTest {
    protected static final String DOCUMENT_ROOT_PATH = "/content/documents/spaintegration";

    @Override
    protected String getAnnotatedClassesResourcePath() {
        return "classpath*:org/onehippo/forge/**/*.class, " +
                "classpath*:com/onehippo/**/*.class, " +
                "classpath*:org/onehippo/cms7/hst/beans/**/*.class, " +
                "classpath*:uk/co/manifesto/brxm/**/*.class";
    }

    @AfterEach
    public void teardown() {
        super.teardown();
    }
}
