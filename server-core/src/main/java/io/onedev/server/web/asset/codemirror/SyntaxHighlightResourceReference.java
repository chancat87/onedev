package io.onedev.server.web.asset.codemirror;

import java.util.List;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import io.onedev.server.web.page.base.BaseDependentResourceReference;
import io.onedev.server.web.resourcebundle.ResourceBundle;

@ResourceBundle
public class SyntaxHighlightResourceReference extends BaseDependentResourceReference {

	private static final long serialVersionUID = 1L;

	public SyntaxHighlightResourceReference() {
		// must use CodeMirrorResourceLocator.class as resource scope to 
		// make sure it is only loaded once
		super(CodeMirrorResourceLocator.class, "codemirror-integration.js");
	}

	@Override
	public List<HeaderItem> getDependencies() {
		List<HeaderItem> dependencies = super.getDependencies();
		
		// must use CodeMirrorResourceLocator.class as resource scope to 
		// make sure it is only loaded once
		dependencies.add(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(
				CodeMirrorResourceLocator.class, "lib/codemirror.js")));
		dependencies.add(JavaScriptHeaderItem.forReference(new BaseDependentResourceReference(
				CodeMirrorResourceLocator.class, "addon/runmode/runmode.js"))); 
		dependencies.add(JavaScriptHeaderItem.forReference(new BaseDependentResourceReference(
				CodeMirrorResourceLocator.class, "addon/mode/loadmode.js"))); 
		dependencies.add(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(
				CodeMirrorResourceLocator.class, "mode/meta.js")));
		dependencies.add(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(
				CodeMirrorResourceLocator.class, "addon/mode/simple.js")));
		dependencies.add(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(
				CodeMirrorResourceLocator.class, "addon/mode/overlay.js")));
		dependencies.add(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(
				CodeMirrorResourceLocator.class, "addon/mode/multiplex.js")));
		dependencies.add(JavaScriptHeaderItem.forReference(new ModeUrlResourceReference()));
		dependencies.add(CssHeaderItem.forReference(new CodeThemeCssResourceReference()));

		return dependencies;
	}
	
}