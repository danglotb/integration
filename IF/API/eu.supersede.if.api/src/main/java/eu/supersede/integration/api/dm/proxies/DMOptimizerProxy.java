/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A.
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
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
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.integration.api.dm.proxies;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import eu.supersede.integration.api.dm.types.FeatureConfiguration;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.properties.IntegrationProperty;

public class DMOptimizerProxy<T, S> extends IFServiceProxy<T, S> implements IDMOptimizer {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final static String SUPERSEDE_DM_OPTIMIZER_ENDPOINT = IntegrationProperty
			.getProperty("dm.optimizer.endpoint");

	@Override
	public FeatureConfiguration optimize(String modelURI, String currentConfig, String qualityAttributePath,
			String alertAttribute, String alertThresholdValue, boolean multiObjective) {
		try {
			Assert.notNull(modelURI, "Provide a valid modelURI");
			Assert.notNull(currentConfig, "Provide a valid currentConfig");
			Assert.notNull(qualityAttributePath, "Provide a valid qualityAttributePath");
			Assert.notNull(alertAttribute, "Provide a valid alertAttribute");
			Assert.notNull(alertThresholdValue, "Provide a valid alertThresholdValue");
			Assert.notNull(multiObjective, "Provide a valid multiObjective");
			String suri = SUPERSEDE_DM_OPTIMIZER_ENDPOINT + "optimize?";	
			Map<String, String> parameters = new HashMap<>();
			parameters.put("modelURI", modelURI);
			parameters.put("currentConfig", currentConfig);
			parameters.put("qualityAttributePath", qualityAttributePath);
			parameters.put("alertAttribute", alertAttribute);
			parameters.put("alertThresholdValue", alertThresholdValue);
			parameters.put("multiObjective", String.valueOf(multiObjective));
			suri = addURIQueryParameters (suri, parameters);
			log.debug("Sending message optimize with modelURI: " + modelURI 
					+ " for currentConfig: " + currentConfig 
					+ " for qualityAttributePath: " + qualityAttributePath 
					+ " for alertAttribute: " + alertAttribute 
					+ " for alertThresholdValue: " + alertThresholdValue 
					+ " for multiObjective: " + multiObjective 
					+ " to DMOptimizer at uri " + suri);
			return getJSONObjectForType(FeatureConfiguration.class, new URI (suri), HttpStatus.OK);
//			return getFormURLEncoded(suri, parameters, HttpStatus.OK, FeatureConfiguration.class);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	private String addURIQueryParameters(String uriString, Map<String, String> parameters) {
		boolean queryStarted = false;
		for (String parameterLabel : parameters.keySet()) {
			if (queryStarted) {
				uriString = uriString + "&";
			}
			uriString = uriString + parameterLabel + "=" + parameters.get(parameterLabel);
			queryStarted = true;
		}

		return uriString;
	}
}
