package items;

import api.FullVidalAPI;
import api.FullVidalAPIFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import results.APIForeignProductByIdResult;
import results.APIProductByIdResult;

import static org.fest.assertions.Assertions.assertThat;


public class FullProductIT {

   private static FullProduct fullProduct;

   @BeforeClass
   public static void setUpOnce() {
      FullVidalAPI fullVidalAPI = FullVidalAPIFactory.getDevInstance();
      APIProductByIdResult idResult = fullVidalAPI.searchProduct().byId(1147).execQuery();
      fullProduct = idResult.getFullProduct();
   }

   @Test
   public void shouldOpenForeignResults() {
      APIForeignProductByIdResult result = fullProduct.openFullForeignProduct();
      assertThat(result.getTitle()).isEqualTo("ForeignProducts for Product 1147");
      assertThat(result.getForeignProducts().size()).isGreaterThan(1);
   }
}