package IndexTest.ParticularTests;

import IndexTest.DefaultPageTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import webpages.gismeteo.IndexPageGismeteo;

public class SearchToolExactPagesTest extends DefaultPageTest {
    @ParameterizedTest
    @ValueSource(strings = {"Москва", "Санкт-Петербург", "", " ", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,."})
    public void searchFieldTest(String searchRequest) {
        defaultPage.openWebPages("https://www.gismeteo.ru/");
        indexPage.searchFieldWithText(searchRequest);
        clickElement(IndexPageGismeteo.firstItemInSearch);
        driver.quit();
    }
}
