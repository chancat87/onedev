package io.onedev.server.model.support.issue;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import io.onedev.server.util.validation.annotation.LinkName;
import io.onedev.server.web.editable.annotation.Editable;
import io.onedev.server.web.editable.annotation.IssueQuery;
import io.onedev.server.web.editable.annotation.NameOfEmptyValue;

@Editable
public class LinkSpecOpposite implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private boolean multiple;
	
	private String issueQuery;
	
	@Editable(order=100, name="Name On the Other Side", description="Name of the link on the other side. "
			+ "For instance if name is <tt>child issues</tt>, name on the other side can be <tt>parent issue</tt>")
	@LinkName
	@NotEmpty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Editable(order=200, name="Multiple On the Other Side", description="Whether or not multiple issues can be linked "
			+ "on the other side. For instance child issues on the other side means parent issue, and multiple should "
			+ "be false on that side if only one parent is allowed")
	public boolean isMultiple() {
		return multiple;
	}

	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}

	@Editable(order=300, name="Linkable Issues On the Other Side", description="Optionally specify criteria of "
			+ "issues which can be linked on the other side")
	@IssueQuery(withCurrentBuildCriteria=false, withCurrentCommitCriteria=false, withCurrentPullRequestCriteria=false, 
				withCurrentUserCriteria=false, withOrder=false)
	@NameOfEmptyValue("All issues")
	public String getIssueQuery() {
		return issueQuery;
	}

	public void setIssueQuery(String issueQuery) {
		this.issueQuery = issueQuery;
	}

}
