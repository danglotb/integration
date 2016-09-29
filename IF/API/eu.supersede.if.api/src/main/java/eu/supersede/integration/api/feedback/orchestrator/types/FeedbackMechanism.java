package eu.supersede.integration.api.feedback.orchestrator.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import ch.uzh.ifi.feedback.library.rest.Service.IDbItem;
import ch.uzh.ifi.feedback.library.rest.Service.ItemBase;
import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import ch.uzh.ifi.feedback.library.rest.annotations.DbIgnore;
import ch.uzh.ifi.feedback.library.rest.annotations.Serialize;
import ch.uzh.ifi.feedback.library.rest.validation.Id;
import ch.uzh.ifi.feedback.library.rest.validation.NotNull;
import ch.uzh.ifi.feedback.library.rest.validation.Validate;
//import ch.uzh.ifi.feedback.orchestrator.model.FeedbackMechanism;
//import ch.uzh.ifi.feedback.orchestrator.model.FeedbackParameter;
//import ch.uzh.ifi.feedback.orchestrator.model.OrchestratorItem;
//import ch.uzh.ifi.feedback.orchestrator.serialization.ApplicationSerializationService;
//import ch.uzh.ifi.feedback.orchestrator.serialization.MechanismSerializationService;
//import ch.uzh.ifi.feedback.orchestrator.validation.MechanismValidator;
//
//@Validate(MechanismValidator.class)
//@Serialize(MechanismSerializationService.class)
@JsonInclude(Include.NON_NULL)
public class FeedbackMechanism extends OrchestratorItem<FeedbackMechanism> {
	
	@Id
	@DbAttribute("mechanisms_id")
	private Integer id;
	
	@DbAttribute("configurations_id")
	private Integer configurationsId;
	
	@NotNull
	@DbAttribute("name")
	private String type;
	
	@NotNull
	private Boolean active;
	
	@NotNull
	private Integer order;
	
	@NotNull
	@DbAttribute("can_be_activated")
	private Boolean canBeActivated;

	@DbIgnore
	private List<FeedbackParameter> parameters;
	
	public FeedbackMechanism(){
		parameters = new ArrayList<>();
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<FeedbackParameter> getParameters() {
		if (parameters == null)
			parameters = new ArrayList<>();
		
		return parameters;
	}

	public void setParameters(List<FeedbackParameter> parameters) {
		this.parameters = parameters;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Boolean isCanBeActivated() {
		return canBeActivated;
	}

	public void setCanBeActivated(Boolean canBeActivated) {
		this.canBeActivated = canBeActivated;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
//	@Override
//	public FeedbackMechanism Merge(FeedbackMechanism original) {
//		
//		for(FeedbackParameter param : original.getParameters())
//		{
//			Optional<FeedbackParameter> newParam = getParameters().stream().filter(p -> p.getId().equals(param.getId())).findFirst();
//			if(!newParam.isPresent())
//			{
//				getParameters().add(param);
//			}else{ 
//				newParam.get().Merge(param);
//			}
//		}
//		
//		super.Merge(original);
//		
//		return this;
//	}
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConfigurationsId() {
		return configurationsId;
	}

	public void setConfigurationsId(Integer configurationsid) {
		this.configurationsId = configurationsid;
	}
}
