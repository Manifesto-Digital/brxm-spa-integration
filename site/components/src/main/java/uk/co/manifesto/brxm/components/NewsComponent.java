package uk.co.manifesto.brxm.components;

import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.onehippo.cms7.essentials.components.EssentialsContentComponent;

public class NewsComponent extends EssentialsContentComponent {
    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);

        request.setModel("customModelAttribute", "Custom Model Attribute");
    }
}
