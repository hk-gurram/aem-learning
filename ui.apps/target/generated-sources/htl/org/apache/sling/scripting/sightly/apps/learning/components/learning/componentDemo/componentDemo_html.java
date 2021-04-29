/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.learning.components.learning.componentDemo;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class componentDemo_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_componentdemo = null;
Object _global_template = null;
Object _global_mytitle = null;
Collection var_collectionvar1_list_coerced$ = null;
_global_componentdemo = renderContext.call("use", com.adobe.aem.learning.core.models.ComponentDemoModel.class.getName(), obj());
_global_template = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
_global_mytitle = renderContext.getObjectModel().resolveProperty(_global_componentdemo, "myTitle");
if (renderContext.getObjectModel().toBoolean(_global_mytitle)) {
    out.write("\n    <h1>");
    {
        Object var_0 = renderContext.call("xss", _global_mytitle, "text");
        out.write(renderContext.getObjectModel().toString(var_0));
    }
    out.write("</h1>\n    ");
    {
        Object var_collectionvar1 = renderContext.getObjectModel().resolveProperty(_global_componentdemo, "links");
        {
            long var_size2 = ((var_collectionvar1_list_coerced$ == null ? (var_collectionvar1_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar1)) : var_collectionvar1_list_coerced$).size());
            {
                boolean var_notempty3 = (var_size2 > 0);
                if (var_notempty3) {
                    {
                        long var_end6 = var_size2;
                        {
                            boolean var_validstartstepend7 = (((0 < var_size2) && true) && (var_end6 > 0));
                            if (var_validstartstepend7) {
                                if (var_collectionvar1_list_coerced$ == null) {
                                    var_collectionvar1_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar1);
                                }
                                long var_index8 = 0;
                                for (Object link : var_collectionvar1_list_coerced$) {
                                    {
                                        boolean var_traversal10 = (((var_index8 >= 0) && (var_index8 <= var_end6)) && true);
                                        if (var_traversal10) {
                                            out.write("\n        ");
                                            {
                                                Object var_testvariable11 = renderContext.getObjectModel().resolveProperty(link, "label");
                                                if (renderContext.getObjectModel().toBoolean(var_testvariable11)) {
                                                    out.write("<h2>");
                                                    {
                                                        Object var_12 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(link, "label"), "text");
                                                        out.write(renderContext.getObjectModel().toString(var_12));
                                                    }
                                                    out.write("</h2>");
                                                }
                                            }
                                            out.write("\n        ");
                                            {
                                                Object var_testvariable13 = renderContext.getObjectModel().resolveProperty(link, "linkPath");
                                                if (renderContext.getObjectModel().toBoolean(var_testvariable13)) {
                                                    out.write("<h3>");
                                                    {
                                                        Object var_14 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(link, "linkPath"), "text");
                                                        out.write(renderContext.getObjectModel().toString(var_14));
                                                    }
                                                    out.write("</h3>");
                                                }
                                            }
                                            out.write("\n        ");
                                            {
                                                Object var_testvariable15 = renderContext.getObjectModel().resolveProperty(link, "target");
                                                if (renderContext.getObjectModel().toBoolean(var_testvariable15)) {
                                                    out.write("<h4>");
                                                    {
                                                        Object var_16 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(link, "target"), "text");
                                                        out.write(renderContext.getObjectModel().toString(var_16));
                                                    }
                                                    out.write("</h4>");
                                                }
                                            }
                                            out.write("\n        ");
                                            {
                                                Object var_testvariable17 = renderContext.getObjectModel().resolveProperty(link, "external");
                                                if (renderContext.getObjectModel().toBoolean(var_testvariable17)) {
                                                    out.write("<h5>");
                                                    {
                                                        Object var_18 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(link, "external"), "text");
                                                        out.write(renderContext.getObjectModel().toString(var_18));
                                                    }
                                                    out.write("</h5>");
                                                }
                                            }
                                            out.write("\n    ");
                                        }
                                    }
                                    var_index8++;
                                }
                            }
                        }
                    }
                }
            }
        }
        var_collectionvar1_list_coerced$ = null;
    }
    out.write("\n");
}
out.write("\n");
{
    Object var_templatevar19 = renderContext.getObjectModel().resolveProperty(_global_template, "placeholder");
    {
        boolean var_templateoptions20_field$_isempty = (!renderContext.getObjectModel().toBoolean(_global_mytitle));
        {
            String var_templateoptions20_field$_classappend = "cmp-title";
            {
                java.util.Map var_templateoptions20 = obj().with("isEmpty", var_templateoptions20_field$_isempty).with("classAppend", var_templateoptions20_field$_classappend);
                callUnit(out, renderContext, var_templatevar19, var_templateoptions20);
            }
        }
    }
}
out.write("\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

