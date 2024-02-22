package com.ohgiraffers.mybatisspring.section01.factorybean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MenuServiceTests {

    @Autowired
    private MenuService menuService;

    @DisplayName("주문가능 상태별 메뉴 조회 확인 테스트")   // 테스트케이스 이름
    @ParameterizedTest                                // 여러가지값을 매개변수로 활용가능
    @ValueSource(strings = {"Y", "N"})                // 한번은 Y, 한번은 N을 넣어 두번다 true가 떠야 통과
    void testFindAllMenus(String orderableStatus){
        Assertions.assertDoesNotThrow(
                () -> {
                    List<MenuDTO> menus = menuService.findAllMenuByOrderableStatus(orderableStatus);
                    menus.forEach(System.out::println);
                }
        );
    }
}
