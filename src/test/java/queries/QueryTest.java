package queries;

import org.junit.Before;
import org.junit.Test;
import results.APIResult;

import static org.fest.assertions.Assertions.assertThat;

public class QueryTest {

   private QueryTestImpl query;

   @Before
   public void setUp() {
      query = new QueryTestImpl();
   }

   @Test
   public void paramsBuilderShouldBeEmptyIfNoParams() {
      String s = this.query.buildParams().toString();
      assertThat(s).isEqualTo("");
   }

   @Test
   public void paramsBuilderShouldStartWithIntegPointIfThereAreParams() {
      QueryTestImpl withParams = this.query.addParam("name", "toto");
      assertThat(withParams.buildParams().toString()).startsWith("?");
   }

   @Test
   public void paramsBuilderShouldBeKeyValue() {
      QueryTestImpl withParams = this.query.addParam("name", "toto");
      assertThat(withParams.buildParams().toString()).contains("name=toto");
   }

   @Test
   public void paramsBuilderShouldBeSeperatedByECom() {
      QueryTestImpl withParams = this.query.addParam("name", "toto").addParam("city", "paris");
      assertThat(withParams.buildParams().toString()).contains("name=toto&city=paris");
   }

   @Test
   public void paramsBuilderShouldNotEndWithECom() {
      QueryTestImpl withParams = this.query.addParam("name", "toto").addParam("city", "paris");
      assertThat(withParams.buildParams().toString()).endsWith("name=toto&city=paris");
   }

   private class QueryTestImpl extends Query<QueryTestImpl> {
      @Override
      public APIResult execQuery() {
         return null;  //To change body of implemented methods use File | Settings | File Templates.
      }

      @Override
      protected StringBuilder buildUrl() {
         return null;
      }
   }
}
