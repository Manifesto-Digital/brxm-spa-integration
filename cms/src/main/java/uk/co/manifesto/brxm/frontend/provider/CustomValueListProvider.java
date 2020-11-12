package uk.co.manifesto.brxm.frontend.provider;

import org.hippoecm.frontend.plugin.IPluginContext;
import org.hippoecm.frontend.plugin.Plugin;
import org.hippoecm.frontend.plugin.config.IPluginConfig;
import org.onehippo.forge.selection.frontend.model.ListItem;
import org.onehippo.forge.selection.frontend.model.ValueList;
import org.onehippo.forge.selection.frontend.provider.IValueListProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CustomValueListProvider extends Plugin implements IValueListProvider {
    /**
     * Construct a new Plugin.
     *
     * @param context the plugin context
     * @param config  the plugin config
     */
    public CustomValueListProvider(IPluginContext context, IPluginConfig config) {
        super(context, config);
        String name = config.getString("valuelist.provider", "custom.valuelist.provider");
        context.registerService(this, name);
    }

    @Override
    public ValueList getValueList(IPluginConfig iPluginConfig) {
        throw new IllegalArgumentException("This method should not be used");
    }

    @Override
    public ValueList getValueList(String s) {
        throw new IllegalArgumentException("This method should not be used");
    }

    @Override
    public ValueList getValueList(String s, Locale locale) {
        ValueList valuelist = new ValueList();
        valuelist.add(new ListItem("custom1", "Custom Value 1"));
        valuelist.add(new ListItem("custom2", "Custom Value 2"));
        valuelist.add(new ListItem("custom3", "Custom Value 3"));
        return valuelist;
    }

    @Override
    public List<String> getValueListNames() {
        return new ArrayList<>();
    }
}
