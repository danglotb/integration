package eu.supersede.integration.api.feedback.orchestrator.types;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ch.uzh.ifi.feedback.library.rest.Service.IDbItem;
import ch.uzh.ifi.feedback.library.rest.Service.ItemBase;
import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import ch.uzh.ifi.feedback.library.rest.annotations.Serialize;
import ch.uzh.ifi.feedback.library.rest.validation.Id;
import ch.uzh.ifi.feedback.library.rest.validation.NotNull;
import ch.uzh.ifi.feedback.library.rest.validation.Validate;
import eu.supersede.integration.api.json.CustomJsonTimestampDeserializer;
//import ch.uzh.ifi.feedback.orchestrator.serialization.ApplicationSerializationService;
//import ch.uzh.ifi.feedback.orchestrator.serialization.ParameterSerializationService;
//import ch.uzh.ifi.feedback.orchestrator.validation.ParameterValidator;
//
//@Validate(ParameterValidator.class)
//@Serialize(ParameterSerializationService.class)
public class FeedbackParameter extends ItemBase<FeedbackParameter> {
	
	@NotNull
	private String key;
	
	@NotNull
	private Object value;
	
	@DbAttribute("default_value")
	private Object defaultValue;
	@DbAttribute("editable_by_user")
	private Boolean editableByUser;
	@DbAttribute("created_at")
	private Timestamp createdAt;
	@DbAttribute("updated_at")
	private Timestamp updatedAt;
	private String language;

	@DbAttribute("parameters_id")
	private transient Integer parametersId;
	@DbAttribute("mechanism_id")
	private transient Integer mechanismId;
	@DbAttribute("general_configurations_id")
	private transient Integer generalConfigurationsId;
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	@JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
	@JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Object getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}
	public Boolean getEditableByUser() {
		return editableByUser;
	}
	public void setEditableByUser(Boolean editableByUser) {
		this.editableByUser = editableByUser;
	}
	
	public Integer getParentParameterId() {
		return parametersId;
	}
	public void setParentParameterId(Integer parentParameterId) {
		this.parametersId = parentParameterId;
	}
	public Integer getMechanismId() {
		return mechanismId;
	}
	public void setMechanismId(Integer mechanismId) {
		this.mechanismId = mechanismId;
	}
	public Integer getGenaralConfigurationId() {
		return generalConfigurationsId;
	}
	public void setGenaralConfigurationId(Integer genaralConfigurationId) {
		this.generalConfigurationsId = genaralConfigurationId;
	}
	
	@Override
	public FeedbackParameter Merge(FeedbackParameter original) {
		super.Merge(original);
		if(List.class.isAssignableFrom(original.getValue().getClass()))
		{
			List<FeedbackParameter> oldChildren = (List<FeedbackParameter>)original.getValue();
			if(List.class.isAssignableFrom(this.getValue().getClass()))
			{
				List<FeedbackParameter> newChildren = (List<FeedbackParameter>)this.getValue();
				for(FeedbackParameter param : oldChildren)
				{
					Optional<FeedbackParameter> newParam = newChildren.stream().filter(p -> p.getId().equals(param.getId())).findFirst();
					if(!newParam.isPresent())
					{
						newChildren.add(param);
					}else{ 
						newParam.get().Merge(param);
					}
				}
			}
		}
		
		return this;
	}
}