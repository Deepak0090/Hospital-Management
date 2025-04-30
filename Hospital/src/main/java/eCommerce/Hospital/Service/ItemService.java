package eCommerce.Hospital.Service;

import eCommerce.Hospital.Model.Item;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.dialect.H2SqlAstTranslator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ItemService {

    private final HashMap<Integer, Item> itemmap=new HashMap<>();

    private static final Integer Item_Per_Page =10;

    public ItemService(){
        for(int i=0; i<100; i++){
            itemmap.put(i,new Item(i,"Items" + i));
        }
    }
    public List<Item> getItemByPage(int page){
        int offset = (page-1)*Item_Per_Page;
        List<Item> list = new ArrayList<>(itemmap.values());

        return list.subList(offset,Math.min(list.size(),offset+Item_Per_Page));
    }
    public int getItemCount(){
         return itemmap.size();
    }
}
