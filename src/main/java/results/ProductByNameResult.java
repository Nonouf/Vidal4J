package results;

import api.FullVidalAPI;
import items.FromNameProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

import java.util.ArrayList;
import java.util.List;

public class ProductByNameResult extends PaginatedResults<ProductByNameResult> {

   public ProductByNameResult(Feed feed, FullVidalAPI fullVidalAPI) {
      super(feed, fullVidalAPI, ProductByNameResult.class);
   }


   public List<FromNameProduct> getProducts() {
      List<Entry> entries = this.feed.getEntries();
      List<FromNameProduct> fromNameProducts = new ArrayList<FromNameProduct>();

      for(Entry entry : entries) {
         fromNameProducts.add(new FromNameProduct(entry, this.fullVidalAPI));
      }

      return fromNameProducts;
   }
}
