import org.junit.Assert;

File suite01 = new File( basedir, "target/generated-test-sources/cucumber/Feature1.java" );
File suite02 = new File( basedir, "target/generated-test-sources/cucumber/Feature2.java" );

assert suite01.isFile()
// Only one file should be created
assert !suite02.isFile()

String expected01="feature1.feature"

Assert.assertTrue(suite01.text.contains(expected01))
