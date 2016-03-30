import org.junit.Assert;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;

File suite01 = new File( basedir, "target/generated-test-sources/cucumber/Feature1.java" );
File suite02 = new File( basedir, "target/generated-test-sources/cucumber/Feature2.java" );

assert suite01.isFile()
// Only one file should be created
assert !suite02.isFile()

String expected01=
"""import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(strict = true, features = {"classpath:features/feature1.feature"}, plugin = {"json:target/cucumber-parallel/Feature1.json",
"pretty"}, monochrome = false, tags = {"@feature1"}, glue = { "foo", "bar" })
public class Feature1 extends cucumber.api.testng.AbstractTestNGCucumberTests {
}"""

Assert.assertThat(suite01.text, equalToIgnoringWhiteSpace(expected01))
