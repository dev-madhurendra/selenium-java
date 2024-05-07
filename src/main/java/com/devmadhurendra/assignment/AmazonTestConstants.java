package com.devmadhurendra.assignment;

public interface AmazonTestConstants {
    String AMAZON_URI = "https://www.amazon.in";
    String TODAY_DEAL_XPATH = "//a[@href='/deals?ref_=nav_cs_gb']";
    String TOP_3_RD_DEAL = "/html/body/div[1]/div[1]/div[15]/div/div/div/div[3]/div[3]/div/div[3]";
    String ADD_TO_CART_BUTTON_ELEMENT = "(//input[@id='add-to-cart-button'])[2]";
    String CART_BUTTON_ELEMENT = "/html/body/div[8]/div[3]/div[3]/div/div[1]/div[3]/div[1]/div[2]/div[3]/form/span";
    String PRODUCT_HAVE_TO_ADD_IN_CART = "productTitle";
    String ADDED_ITEM_IN_CART_PRODUCT = "/html/body/div[1]/div[1]/div[3]/div[5]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/ul/li/span/a/span[1]/span/span[2]";
    String QUANTITY_ELEMENT = "//span[@class='a-dropdown-prompt']";
    String SEARCH_INPUT_ELEMENT = "/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input";
    String VALUE_TO_SEARCH = "Mobiles";
}
