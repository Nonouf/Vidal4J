package queries;

public class EqFrenchProductSearch {

   private final String baseUrl;

   public EqFrenchProductSearch(String baseUrl) {
      this.baseUrl = baseUrl;
   }


   public EqFrenchProductByNameQuery byName(String name) {
      return new EqFrenchProductByNameQuery(this.baseUrl, name);
   }

   public EqFrenchProductByIdQuery byId(int id) {
      return null;
   }
}
