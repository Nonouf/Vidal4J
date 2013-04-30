package models;

import org.joda.time.DateTime;
import org.junit.Test;
import utils.APIResultTools;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIResultFromXMLResource;

public class APIResultTest {

   @Test
   public void shouldReturnTheTitleOfTheFeed() throws FileNotFoundException {
      APIResult apiResult = getAPIResultFromXMLResource("productByName_Long.xml");
      assertThat(apiResult.getTitle()).isEqualTo("Search Products - Query :asp");
   }

   @Test
   public void shouldReturnTheSelfLink() throws FileNotFoundException {
      APIResult apiResult = getAPIResultFromXMLResource("productByName_Long.xml");
      assertThat(apiResult.getSelfLink().getHref().toString())
              .isEqualTo("/rest/api/products?q=asp&start-page=1&page-size=25");
   }

   @Test
   public void shouldReturnNextLinkIfItExists() throws FileNotFoundException {
      APIResult apiResult = getAPIResultFromXMLResource("productByName_Long.xml");
      assertThat(apiResult.getNextPageLink().getHref().toString())
              .isEqualTo("/rest/api/products?q=asp&start-page=2&page-size=25");
   }

   @Test
   public void shouldReturnNullIfNextLinkDoesntExist() throws FileNotFoundException {
      APIResult apiResult = getAPIResultFromXMLResource("aspegic_Short.xml");
      assertThat(apiResult.getNextPageLink()).isNull();
   }

   @Test
   public void shouldReturnTheIdOftheFeed() throws FileNotFoundException {
      APIResult apiResult = getAPIResultFromXMLResource("productByName_Long.xml");
      assertThat(apiResult.getId().toString())
              .isEqualTo("/rest/api/products?q=asp&start-page=1&page-size=25");
   }

   @Test
   public void shouldReturnTheDateOfLastUpdate() throws FileNotFoundException {
      APIResult apiResult = getAPIResultFromXMLResource("productByName_Long.xml");
      DateTime lastUpdate = apiResult.getLastUpdate();
      assertThat(lastUpdate.getMillis()).isEqualTo(1361404800000L);
   }

   @Test
   public void shouldReturnTheTotalNumberOfResults() throws FileNotFoundException {
      APIResult apiResult = getAPIResultFromXMLResource("productByName_Long.xml");
      assertThat(apiResult.getTotalResultsNumber()).isEqualTo(29);
   }

   @Test
   public void shouldReturnTheNumberOfResultsPerPage() throws FileNotFoundException {
      APIResult apiResult = getAPIResultFromXMLResource("productByName_Long.xml");
      assertThat(apiResult.getResultsNumberPerPage()).isEqualTo(25);
   }

   @Test
   public void shouldReturnTheCurrentPageNumber() throws FileNotFoundException {
      APIResult apiResult = getAPIResultFromXMLResource("productByName_Long.xml");
      assertThat(apiResult.getCurrentPageNumber()).isEqualTo(1);
   }
}
