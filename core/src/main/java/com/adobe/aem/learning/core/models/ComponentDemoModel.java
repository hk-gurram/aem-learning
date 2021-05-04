package com.adobe.aem.learning.core.models;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Model(adaptables = { Resource.class, SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
@JsonSerialize(as = ComponentDemoModel.class)
public class ComponentDemoModel implements ComponentExporter {

    private static final Logger logger = LoggerFactory.getLogger(ComponentDemoModel.class);

    /*@ValueMapValue
    @Default(values = StringUtils.EMPTY)
    private String myTitle;*/

    @Self
    private MyTitleModel myTitleModel;

    public MyTitleModel getMyTitleModel() {
        return this.myTitleModel;
    }

    @ChildResource
    private List<LinkModel> links;

    /*public String getMyTitle() {
        return this.myTitle;
    }*/

    public List<LinkModel> getLinks() {
        return this.links;
    }

    @Override
    public String getExportedType() {
        return "This is my resource Type";
    }

}
