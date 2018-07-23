import ApiTests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@Suite.SuiteClasses({
        General_ItunesApiTest.class,
        ParameterAttribute_ItunesApiTest.class,
        ParameterCountry_ItunesApiTest.class,
        ParameterEntity_ItunesApiTest.class,
        ParameterExplicit_ItunesApiTest.class,
        ParameterLang_ItunesApiTest.class,
        ParameterLimit_ItunesApiTest.class,
        ParameterMedia_ItunesApiTest.class,
        ParameterTerm_ItunesApiTest.class,
        ParameterVersion_ItunesApiTest.class})
@RunWith(Suite.class)
public class TopLevelSuiteWithRightOrder {
}
