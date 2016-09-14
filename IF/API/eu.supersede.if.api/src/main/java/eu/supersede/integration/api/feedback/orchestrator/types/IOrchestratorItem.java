package eu.supersede.integration.api.feedback.orchestrator.types;

import java.sql.Timestamp;

import ch.uzh.ifi.feedback.library.rest.Service.IDbItem;


public interface IOrchestratorItem<T> extends IDbItem<T> {
	
	public boolean isCurrentVersion();

	public void setCurrentVersion(boolean currentVersion);

	public Timestamp getCreatedAt();

	public void setCreatedAt(Timestamp createdAt);
}
