package com.minesweeper.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.provider.RequestDispatcherProvider;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.apache.cxf.message.Message;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.*;

import static org.springframework.util.CollectionUtils.isEmpty;

public class ApiServerBuilder {

	private Bus bus;
	private String jaxrsClassesPackagePrefix;
	protected String applicationName;
	private List<Object> services;
	private List<Interceptor<Message>> inInterceptors;
	private List<Interceptor<Message>> outInterceptors;
	private ExceptionMapper<? extends Throwable> exceptionMapper;
	private List<Object> providers;
	private String basePath;

	public ApiServerBuilder(Bus springBus) {
		bus = springBus;
		services = new ArrayList<>();
		inInterceptors = new ArrayList<>();
		outInterceptors = new ArrayList<>();
		providers = new ArrayList<>();
		basePath = "/";
	}

	private Server createServerFor() {

		final JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();

		List<Object> allProviders = new ArrayList<Object>();
		if (providers != null)
			allProviders.addAll(Arrays.asList(providers));

		if (!isEmpty(inInterceptors))
			factory.getInInterceptors().addAll(inInterceptors);

		if (!isEmpty(outInterceptors))
			factory.getOutInterceptors().addAll(outInterceptors);

		if (jaxrsClassesPackagePrefix == null)
			jaxrsClassesPackagePrefix = "com";

		if (exceptionMapper == null) {
			exceptionMapper = new ExceptionMapper<Exception>() {
				public Response toResponse(Exception exception) {
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception.getMessage())
							.build();
				}
			};
		}

		RequestDispatcherProvider requestDispatcherProvider = new RequestDispatcherProvider();

		Map<String, String> map = new HashMap<>();
		map.put("info", "/monitor/info");
		requestDispatcherProvider.setResourcePaths(map);

		allProviders.add(requestDispatcherProvider);

		allProviders.add(exceptionMapper);
		customizeProviders(allProviders);

		factory.setServiceBeanObjects(services);
		factory.setProviders(allProviders);
		factory.setBus(bus);
		factory.setAddress(basePath);

		Swagger2Feature swagger2Feature = new Swagger2Feature();
		swagger2Feature.setResourcePackage(jaxrsClassesPackagePrefix);
		factory.setFeatures(Arrays.asList(swagger2Feature));

		Server server = factory.create();

		customizeInterceptors(server.getEndpoint());

		return server;
	}

	protected void customizeInterceptors(Endpoint endpoint) {
	}

	protected void customizeProviders(List<Object> allProviders) {
	}

	public ApiServerBuilder withJaxrsClassesPackagePrefix(String jaxrsClassesPackagePrefix) {
		this.jaxrsClassesPackagePrefix = jaxrsClassesPackagePrefix;
		return this;
	}

	public ApiServerBuilder withApplicationName(String applicationName) {
		this.applicationName = applicationName;
		return this;
	}

	public ApiServerBuilder forServices(Object... services) {
		this.services = Arrays.asList(services);
		return this;
	}

	public ApiServerBuilder withProviders(Object... providers) {
		this.providers = Arrays.asList(providers);
		return this;
	}

	public ApiServerBuilder withExceptionMapper(ExceptionMapper<? extends Throwable> exceptionMapper) {
		this.exceptionMapper = exceptionMapper;
		return this;
	}

	public ApiServerBuilder withInInterceptors(Interceptor<Message>... inInterceptors) {
		this.inInterceptors.addAll(Arrays.asList(inInterceptors));
		return this;
	}

	public ApiServerBuilder withOutInterceptors(Interceptor<Message>... outInterceptors) {
		this.outInterceptors.addAll(Arrays.asList(outInterceptors));
		return this;
	}

	public Server build() {
		return createServerFor();
	}

	public ApiServerBuilder withBasePath(String address) {
		if (StringUtils.isNotBlank(address)) {
			basePath = address;
		}
		return this;
	}
}