package items;

import api.VidalAPI;
import items.key_values.DispensationPlace;
import items.key_values.MarketStatus;
import items.key_values.VidalList;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;
import results.APIProductByIdResult;

import static utils.AtomTool.getVidalTagContent;

public class OfNameProduct extends Item {

   public OfNameProduct(Entry entry, VidalAPI vidalAPI) {
      super(entry, vidalAPI);
   }


   public String getName() {
      return this.entry.getSummary();
   }

   public boolean shouldBeCarefull() {
      String beCareful = getVidalTagContent("beCareful", this.entry).getText();
      return Boolean.parseBoolean(beCareful);
   }

   public Company getProvider() {
      Element company = getVidalTagContent("company", this.entry);
      int vidalId = Integer.parseInt(company.getAttributeValue("vidalId"));
      String name = company.getText();
      String type = company.getAttributeValue("type");

      return new Company(vidalId, name, type);
   }

   // Carefull: there might not be a "dispensationPlace" tag.
   public DispensationPlace getDispensationPlace() {
      Element element = getVidalTagContent("dispensationPlace", this.entry);
      String name = element.getAttributeValue("name");
      String text = element.getText();
      return new DispensationPlace(name, text);
   }

   public boolean isDopingProduct() {
      String drugInSport = getVidalTagContent("drugInSport", this.entry).getText();
      return Boolean.parseBoolean(drugInSport);
   }

   public boolean isExceptional() {
      String exceptional = getVidalTagContent("exceptional", this.entry).getText();
      return Boolean.parseBoolean(exceptional);
   }

   public boolean isOutOfGHS() {
      String horsGHS = getVidalTagContent("horsGHS", this.entry).getText();
      return Boolean.parseBoolean(horsGHS);
   }

   public int getVidalId() {
      String id = getVidalTagContent("id", this.entry).getText();
      return Integer.parseInt(id);
   }

   // Carefull: there might not be a "list" tag.
   public VidalList getVidalList() {
      Element element = getVidalTagContent("list", this.entry);
      String name = element.getAttributeValue("name");
      String text = element.getText();
      return new VidalList(name, text);
   }

   public MarketStatus getMarketStatus() {
      Element element = getVidalTagContent("marketStatus", this.entry);
      String name = element.getAttributeValue("name");
      String text = element.getText();
      return new MarketStatus(name, text);
   }

   public boolean IsPrescriptivableByMidWife() {
      String midwife = getVidalTagContent("midwife", this.entry).getText();
      return Boolean.parseBoolean(midwife);
   }

   // Carefull: there might not be a "refund" tag.
   public String getRefundRate() {
      return getVidalTagContent("refundRate", this.entry).getText();
   }

   public boolean isRetrocedable() {
      String retrocession = getVidalTagContent("retrocession", this.entry).getText();
      return Boolean.parseBoolean(retrocession);
   }

   public APIProductByIdResult openProduct() {
      int vidalId = this.getVidalId();
      return this.vidalAPI.searchProduct().byId(vidalId).execQuery();
   }
}