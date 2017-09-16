package com.cbn.ins.core.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ContextConfiguration(locations = {"/test-service.xml"})
public class BaseSpringTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	public static final Logger LOGGER =  LoggerFactory.getLogger(BaseSpringTest.class);
	
}
