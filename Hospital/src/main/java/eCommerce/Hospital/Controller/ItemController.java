package eCommerce.Hospital.Controller;

import eCommerce.Hospital.Model.Item;
import eCommerce.Hospital.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping
    public HashMap<String, Object> getItemByPage(@RequestParam int pageNo){
        List<Item> items = itemService.getItemByPage(pageNo);

        int total = itemService.getItemCount();
        int totalPage = (int) Math.ceil((double) total / (double) 10);

        HashMap<String,Object> map = new HashMap<>();
        map.put("Items",items);
        map.put("total",total);
        map.put("totalPage",totalPage);
        map.put("Pages",pageNo);
        return  map;
    }

}
