package queries;

import api.VidalAPIFactory;
import models.EqFrenchProductOfNameQuery;
import org.junit.Test;
import results.APIEqFrenchProductByNameResult;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class EqFrenchProductByNameQueryIT {

   @Test
   public void withoutParamsShouldReturnANonEmptyResult() {
      EqFrenchProductByNameQuery byNameQuery = VidalAPIFactory.getDevInstance()
              .searchEqFrenchProduct()
              .byName("asp");

      APIEqFrenchProductByNameResult byNameResult = byNameQuery.execQuery();
      List<EqFrenchProductOfNameQuery> eqFrenchProducts = byNameResult.getEqFrenchProducts();
      assertThat(eqFrenchProducts.size()).isGreaterThan(1);
   }

   @Test
   public void withParamsShouldReturnANonEmptyResult() {
      EqFrenchProductByNameQuery byNameQuery = VidalAPIFactory.getDevInstance()
                                                              .searchEqFrenchProduct()
                                                              .byName("asp");

      APIEqFrenchProductByNameResult byNameResult = byNameQuery.setCountry("DZ").execQuery();
      List<EqFrenchProductOfNameQuery> eqFrenchProducts = byNameResult.getEqFrenchProducts();
      assertThat(eqFrenchProducts.size()).isGreaterThan(1);
   }

}