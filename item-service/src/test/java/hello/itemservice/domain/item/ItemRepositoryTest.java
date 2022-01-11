package hello.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    public void save() throws Exception {
        //given
        Item item = new Item("itemA", 10000, 10);
        //when
        Item saveItem = itemRepository.save(item);
        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(saveItem).isEqualTo(findItem);
    }

    @Test
    public void findALL() throws Exception {
        //given
        Item item1 = new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 20000, 20);
        itemRepository.save(item1);
        itemRepository.save(item2);

        //when
        List<Item> items = itemRepository.findAll();

        //then
        assertThat(items.size()).isEqualTo(2);
        assertThat(items).contains(item1, item2);

    }

    @Test
    public void updateItem() throws Exception {
        //given
        Item item1 = new Item("itemA", 10000, 10);
        Item savedItem = itemRepository.save(item1);

        //when
        Item updateItem = new Item("itemB", 20000, 20);
        itemRepository.update(item1.getId(),updateItem);

        //then
        Item findItem = itemRepository.findById(item1.getId());
        assertThat(updateItem.getItemName()).isEqualTo(findItem.getItemName());
        assertThat(updateItem.getPrice()).isEqualTo(findItem.getPrice());
        assertThat(updateItem.getQuantity()).isEqualTo(findItem.getQuantity());

    }

}