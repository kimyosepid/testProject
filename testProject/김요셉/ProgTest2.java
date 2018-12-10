package ±è¿ä¼Á;

import java.util.*;


public class ProgTest2 {
   
   Map<String, MemberData> mapList = new Hashtable<>();
   
   void mapListadd(String memberID, String name, String tel, String gender) {
      mapList.put(memberID, new MemberData(memberID, name, tel, gender));
   }
  
   
   void mapListRemove(String memberID) {
      mapList.remove(memberID.trim());
   }
   
   
   
	   ArrayList<MemberData> getMapList() {
		      ArrayList<MemberData> list = new ArrayList<>();

		      Set<String> keyset = mapList.keySet();
		      Iterator<String> keyiterator = keyset.iterator();
		      while (keyiterator.hasNext()) {
		         String k = keyiterator.next();
		         MemberData v = mapList.get(k);
		         list.add(v);

		      }
		      return list;

		   
		   }
   }
