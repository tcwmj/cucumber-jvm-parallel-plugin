import org.junit.Assert;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;

File suite01 = new File( basedir, "target/generated-test-sources/cucumber/Feature1.java" );
File suite02 = new File( basedir, "target/generated-test-sources/cucumber/Feature2.java" );

assert suite01.isFile()
assert suite02.isFile()

String expected01=
"""import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
    features = {"classpath:features/feature1.feature"},
    plugin = {"html:target/cucumber-parallel/Feature1.html", "json:target/cucumber-parallel/Feature1.json", "pretty"},
    monochrome = false,
    tags = {"@complete", "@accepted"},
    glue = { "foo" })
public class Feature1 {
}"""

String expected02=
"""import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
    features = {"classpath:features/feature2.feature"},
    plugin = {"html:target/cucumber-parallel/Feature2.html", "json:target/cucumber-parallel/Feature2.json", "pretty"},
    monochrome = false,
    tags = {"@complete", "@accepted"},
    glue = { "foo" })
public class Feature2 {
}"""

// Depending on the OS, listFiles can list files in different order.  The actual order of files isn't necessary

if(suite01.text.contains("feature1") ){
	Assert.assertThat(suite01.text, equalToIgnoringWhiteSpace(expected01))
	Assert.assertThat(suite02.text, equalToIgnoringWhiteSpace(expected02))
}else{
	Assert.assertThat(suite02.text, equalToIgnoringWhiteSpace(expected01))
	Assert.assertThat(suite01.text, equalToIgnoringWhiteSpace(expected02))
}

