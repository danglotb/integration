/*******************************************************************************
 * Copyright (c) 2016 Universitat Politécnica de Catalunya (UPC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * 	Quim Motger (UPC) - main development
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/
package eu.supersede.integration.api.monitoring.orchestrator.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import ch.uzh.ifi.feedback.library.rest.validation.Id;
import ch.uzh.ifi.feedback.library.rest.validation.NotNull;
import eu.supersede.integration.api.feedback.orchestrator.types.OrchestratorItem;

//@Serialize(MonitorConfigurationSerializationService.class)
@JsonInclude(Include.NON_NULL)
public class MonitorConfiguration extends OrchestratorItem<MonitorConfiguration> {

	@Id
	@DbAttribute("monitor_configuration_id")
	private Integer id;
	
	@DbAttribute("monitor_tool_id")
	private Integer monitorToolId;
	
	@NotNull
	@DbAttribute("config_sender")
	private String configSender;
	@NotNull
	@DbAttribute("timestamp")
	private String timeStamp;
	@NotNull
	@DbAttribute("time_slot")
	private String timeSlot;
	@NotNull
	@DbAttribute("kafka_endpoint")
	private String kafkaEndpoint;
	@NotNull
	@DbAttribute("kafka_topic")
	private String kafkaTopic;
	@NotNull
	private String state;
	
	@DbAttribute("keyword_expression")
	private String keywordExpression;
	
	//private List<String> accounts;
	
	@DbAttribute("package_name")
	private String packageName;
	@DbAttribute("app_id")
	private String appId;
	
	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	public String getKeywordExpression() {
		return keywordExpression;
	}

	public void setKeywordExpression(String keywordExpression) {
		this.keywordExpression = keywordExpression;
	}

	/*public List<String> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<String> accounts) {
		this.accounts = accounts;
	}*/
	
	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getKafkaEndpoint() {
		return kafkaEndpoint;
	}

	public void setKafkaEndpoint(String kafkaEndpoint) {
		this.kafkaEndpoint = kafkaEndpoint;
	}

	public String getKafkaTopic() {
		return kafkaTopic;
	}

	public void setKafkaTopic(String kafkaTopic) {
		this.kafkaTopic = kafkaTopic;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getMonitorToolId() {
		return monitorToolId;
	}

	public void setMonitorToolId(Integer monitorToolId) {
		this.monitorToolId = monitorToolId;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getConfigSender() {
		return configSender;
	}

	public void setConfigSender(String configSender) {
		this.configSender = configSender;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}
