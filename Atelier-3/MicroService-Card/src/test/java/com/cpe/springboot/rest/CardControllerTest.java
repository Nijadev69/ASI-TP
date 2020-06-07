package com.cpe.springboot.rest;

import com.cpe.springboot.card.CardController;
import com.cpe.springboot.card.CardService;
import com.cpe.springboot.model.Card;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CardController.class)
public class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardService cService;

    Card mockCard, mockCard2;
    List<Card> cards = new ArrayList<>();

    @Before
    public void setUp() {
        mockCard = new Card(1, "SpiderMan", "Homme araignée", "MARVEL", 100, 80, 75, 60, "https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg", false, 1);
        mockCard2 = new Card(2, "Thor", "Dieu d'Asgard", "MARVEL", 100, 80, 75, 60, "https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg", false, 1);
        cards.add(mockCard);
        cards.add(mockCard2);
    }

    @Test
    public void getCard() throws Exception {
        Mockito.when(
                cService.getCard(Mockito.anyInt())
        ).thenReturn(mockCard);


        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/id/50").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse().getContentAsString());
        String expectedResult="{\"id\":1,\"name\":\"SpiderMan\",\"description\":\"Homme araignée\",\"family\":\"MARVEL\",\"hp\":100,\"energy\":80,\"attack\":75,\"defence\":60,\"imgUrl\":\"https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg\",\"onSale\":false,\"userId\":1}";


        JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void getCardByName() throws Exception {
        Mockito.when(
                cService.getCardByName(Mockito.anyString())
        ).thenReturn(mockCard);


        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/by/test").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse().getContentAsString());
        String expectedResult="{\"id\":1,\"name\":\"SpiderMan\",\"description\":\"Homme araignée\",\"family\":\"MARVEL\",\"hp\":100,\"energy\":80,\"attack\":75,\"defence\":60,\"imgUrl\":\"https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg\",\"onSale\":false,\"userId\":1}";


        JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void getCards() throws Exception {
        Mockito.when(
                cService.getCards()
        ).thenReturn(cards);


        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/all").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse().getContentAsString());
        String expectedResult="[{\"id\":1,\"name\":\"SpiderMan\",\"description\":\"Homme araignée\",\"family\":\"MARVEL\",\"hp\":100,\"energy\":80,\"attack\":75,\"defence\":60,\"imgUrl\":\"https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg\",\"onSale\":false,\"userId\":1},{\"id\":2,\"name\":\"Thor\",\"description\":\"Dieu d'Asgard\",\"family\":\"MARVEL\",\"hp\":100,\"energy\":80,\"attack\":75,\"defence\":60,\"imgUrl\":\"https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg\",\"onSale\":false,\"userId\":1}]";


        JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
    }

}

