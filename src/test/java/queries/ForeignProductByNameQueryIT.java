package queries;

import api.VidalAPIFactory;
import items.ForeignProduct;
import org.junit.Test;
import results.APIForeignProductByNameResult;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class ForeignProductByNameQueryIT {

   @Test
   public void withoutParamsShouldReturnANonEmptyResult() {
      ForeignProductByNameQuery byNameQuery = VidalAPIFactory.getDevInstance()
              .searchForeignProduct()
              .byName("asp");

      APIForeignProductByNameResult byNameResult = byNameQuery.execQuery();
      List<ForeignProduct> eqFrenchProducts = byNameResult.getForeignProducts();
      assertThat(eqFrenchProducts.size()).isGreaterThan(1);
   }

   @Test
   public void withParamsShouldReturnANonEmptyResult() {
      ForeignProductByNameQuery byNameQuery = VidalAPIFactory.getDevInstance()
                                                              .searchForeignProduct()
                                                              .byName("asp");

      APIForeignProductByNameResult byNameResult = byNameQuery.setCountry("DZ").execQuery();
      List<ForeignProduct> eqFrenchProducts = byNameResult.getForeignProducts();
      assertThat(eqFrenchProducts.size()).isGreaterThan(1);
   }

}
