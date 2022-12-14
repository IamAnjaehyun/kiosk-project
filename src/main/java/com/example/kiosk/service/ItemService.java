package com.example.kiosk.service;

import com.example.kiosk.domain.cartitem.CartItem;
import com.example.kiosk.domain.item.Item;
import com.example.kiosk.domain.item.ItemRepository;
import com.example.kiosk.md5generator.MD5Generator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final CartService cartService;
    private final SaleService saleService;

    // 상품 등록
    public void saveItem(Item item, MultipartFile imgFile) throws Exception {
        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/img/";

        String imgName = new MD5Generator(imgFile.getOriginalFilename()).toString();

        File saveFile = new File(projectPath, imgName);

        imgFile.transferTo(saveFile);

        item.setImgName(imgName);

        item.setImgPath("/img/" + imgName);

        itemRepository.save(item);
    }

    // 상품 개별 불러오기
    public Item itemView(Integer id) {
        return itemRepository.findById(id).get();
    }

    // 상품 리스트 불러오기
    public List<Item> allItemView() {
        return itemRepository.findAll();
    }

    // 상품 리스트 페이지용 불러오기
    public Page<Item> allItemViewPage(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

    // 상품 수정
    @Transactional
    public void itemModify(Item item, Integer id, MultipartFile imgFile) throws Exception {

        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/img/";
        String fileName = new MD5Generator(imgFile.getOriginalFilename()).toString();
        File saveFile = new File(projectPath, fileName);
        imgFile.transferTo(saveFile);

        Item update = itemRepository.findItemById(id);
        update.setName(item.getName());
        update.setText(item.getText());
        update.setPrice(item.getPrice());
        update.setStock(item.getStock());
        update.setIsSoldout(item.getIsSoldout());
        update.setImgName(fileName);
        update.setImgPath("/img/"+fileName);
        itemRepository.save(update);
    }

    // 상품 삭제
    @Transactional
    public void itemDelete(Integer id) {
        // cartItem 중에 해당 id 를 가진 item 찾기
        List<CartItem> items = cartService.findCartItemByItemId(id);

        for(CartItem item : items) {
            cartService.cartItemDelete(item.getId());
        }

        itemRepository.deleteById(id);
    }

    // 상품 검색
    public Page<Item> itemSearchList(String searchKeyword, Pageable pageable) {

        return itemRepository.findByNameContaining(searchKeyword, pageable);
    }

}