package pro.sky.k2hw11.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.k2hw11.model.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StoreRepository {
    private int idCounter = 1;
    private final Map<Integer, Item>store = new HashMap<>();

    @PostConstruct
    public void init(){
        store.put(idCounter, new Item(idCounter++,"Ноутбук"));
        store.put(idCounter, new Item(idCounter++,"Смартфон"));
        store.put(idCounter, new Item(idCounter++,"Электронная книга"));

    }
    public void add(Item item){
        store.put(item.getId(),item);
    }
    public Item get(int id){
        return store.get(id);
    }
    public List<Item> getALL(){
        return new ArrayList<>(store.values());
    }
    public void update(int id, Item item){
        if(store.containsKey(id)){
            store.replace(id,item);
        }
    }
}
