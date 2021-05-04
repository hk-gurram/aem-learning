package com.adobe.aem.learning.core.models;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.aem.learning.core.services.UserService;
import com.day.cq.wcm.api.Page;

@Model(adaptables = { Resource.class, SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MyTitleModel {

    @ValueMapValue
    @Default(values = StringUtils.EMPTY)
    private String myTitle;

    @ScriptVariable
    private Page currentPage;

    private String pagePath;

    private List<String> paths;

    public List<String> getPaths() {
        return this.paths;
    }

    @OSGiService
    private UserService userService;

    public String getPagePath() {
        return this.pagePath;
    }

    public String getMyTitle() {
        return this.myTitle;
    }

    @PostConstruct
    protected void init() {
        this.pagePath = this.currentPage.getPath();
        this.paths = this.userService.getChildPages();
    }

}
