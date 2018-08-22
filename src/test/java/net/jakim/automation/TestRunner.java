package net.jakim.automation;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith( JUnitPlatform.class)
@SelectPackages( {"net.jakim.automation.t2", "net.jakim.automation.t1"})
public class TestRunner
{
}
