package uk.co.manifesto.brxm.frontend.plugins;

import org.apache.wicket.Component;
import org.apache.wicket.model.StringResourceModel;
import org.hippoecm.addon.workflow.StdWorkflow;
import org.hippoecm.addon.workflow.WorkflowDescriptorModel;
import org.hippoecm.frontend.plugin.IPluginContext;
import org.hippoecm.frontend.plugin.config.IPluginConfig;
import org.hippoecm.frontend.plugins.standards.icon.HippoIcon;
import org.hippoecm.frontend.service.render.RenderPlugin;
import org.hippoecm.frontend.skin.Icon;
import org.hippoecm.repository.api.WorkflowDescriptor;
import org.hippoecm.repository.standardworkflow.FolderWorkflow;

public class CustomWorkflowPlugin extends RenderPlugin<WorkflowDescriptor> {
    public CustomWorkflowPlugin(IPluginContext context, IPluginConfig config) {
        super(context, config);

        add(new StdWorkflow<FolderWorkflow>("index",
                new StringResourceModel("custom_action", this),
                (WorkflowDescriptorModel) getModel())  {
            @Override
            protected Component getIcon(final String id) {
                return HippoIcon.fromSprite(id, Icon.FILE);
            }

            @Override
            protected String execute(FolderWorkflow workflow) throws Exception {
                workflow.add("new-document", "spaintegration:newsdocument", "index");
                return null;
            }
        });
    }
}
