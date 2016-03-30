import org.junit.Assert;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;

File suite01 = new File( basedir, "target/generated-test-sources/cucumber/Feature1.java" );

assert suite01.isFile()

String expected01=
"""import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(strict = true, features = {"classpath:features/feature1.feature"}, plugin = {"json:target/cucumber-reports/Feature1.json",
"pretty"}, monochrome = false, tags = {"@complete", "@accepted"}, glue = { "foo", "bar" })
public class Feature1 extends cucumber.api.testng.AbstractTestNGCucumberTests {
}"""

Assert.assertThat(suite01.text, equalToIgnoringWhiteSpace(expected01))
