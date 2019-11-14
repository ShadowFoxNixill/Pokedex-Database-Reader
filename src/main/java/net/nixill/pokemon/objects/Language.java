package net.nixill.pokemon.objects;

import java.sql.ResultSet;
import java.util.HashMap;

public class Language extends DBObject {
  private static HashMap<String, Class<?>> types;
  
  static {
    types = new HashMap<>();
    types.put("iso639", String.class);
    types.put("iso3166", String.class);
    types.put("official", boolean.class);
    types.put("order", int.class);
  }
  
  private HashMap<Language, String> names;
  
  private Language(int id, String identifier) {
    super(id, identifier);
  }
  
  public void complete(ResultSet res) {
    if (complete(res, types)) {
      names = getLangTable("language_names", "language_id", "name");
    }
  }
  
  public String getName(Language lang) {
    complete();
    return names.get(lang);
  }
}