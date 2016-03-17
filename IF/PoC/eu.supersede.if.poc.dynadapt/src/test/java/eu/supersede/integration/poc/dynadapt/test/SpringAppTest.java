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
package eu.supersede.integration.poc.dynadapt.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import eu.supersede.integration.poc.dynadapt.Dashboard;

@SpringBootApplication
public class SpringAppTest extends SpringBootServletInitializer {
	//implements ApplicationListener<ApplicationPreparedEvent>{
		private static final Logger log = LoggerFactory.getLogger(SpringAppTest.class);
		
		public static void main(String[] args) {
			SpringApplication app = new SpringApplication (SpringAppTest.class);
			ConfigurableApplicationContext ctx = app.run(args);
			ctx.publishEvent(new ApplicationPreparedEvent(app, args, ctx));
		}
		
		@Override
		protected SpringApplicationBuilder configure (SpringApplicationBuilder application){
			return application.sources(SpringAppTest.class);
		}
	}