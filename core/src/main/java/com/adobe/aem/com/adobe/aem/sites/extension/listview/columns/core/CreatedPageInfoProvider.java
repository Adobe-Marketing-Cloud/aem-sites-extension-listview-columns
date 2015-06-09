package com.adobe.aem.com.adobe.aem.sites.extension.listview.columns.core;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageInfoProvider;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

import java.util.Calendar;

@Component(
        metatype = false,
        immediate = true
)
@Service
@Properties(value = {
        @Property(name = "pageInfoProviderType", value = "sites.listView.info.provider." + CreatedPageInfoProvider.providerType)
})
public class CreatedPageInfoProvider implements PageInfoProvider {
    public static final String providerType = "created";

    public void updatePageInfo(SlingHttpServletRequest request, JSONObject info, Resource resource) throws JSONException {
        Page page = resource.adaptTo(Page.class);
        JSONObject myProjectInfo = new JSONObject();

        if (page != null) {
            ValueMap vm = page.getContentResource().adaptTo(ValueMap.class);
            myProjectInfo.put("created", vm.get("jcr:created", Calendar.class));
            myProjectInfo.put("createdBy", vm.get("jcr:createdBy", String.class));
        }

        info.put(providerType, myProjectInfo);
    }
}
