package com.example.jspapp.mapper;

import com.example.jspapp.entity.Product;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ProductMapper {

    @Insert("INSERT INTO product (name, description, price, fk_category_id) VALUES (#{name}, #{description}, #{price}, #{fk_categoryID})")
    void save(Product product);

    @Delete("DELETE FROM product WHERE product_id = #{id}")
    void deleteProductById(Long id);

    @Update("UPDATE product SET name = #{name}, description = #{description}, price = #{price}, fk_category_id = #{fk_categoryID} WHERE product_id = #{productID} ")
    void update(Product product);

    //? Get product
    @Select("SELECT * FROM product")
    @Results(id = "product_Result", value = {
            @Result(property = "productID", column = "product_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "price", column = "price"),
            @Result(property = "fk_categoryID", column = "fk_category_id")
    })
    List<Product> getAllProducts();

    @Select("SELECT * FROM product WHERE product_id = #{id}")
    @ResultMap("product_Result")
    Product getProductById(Long id);

    @Select("SELECT * FROM product WHERE LOWER(name) LIKE '%' || LOWER(#{productName}) || '%' ")
    @ResultMap("product_Result")
    List<Product> getProductByName(String productName);

    @Select("SELECT * FROM product WHERE fk_category_id = #{categoryId}")
    @ResultMap("product_Result")
    List<Product> getProductsByCategory(Long categoryId);

    @Select("SELECT * FROM product WHERE LOWER(name) LIKE '%' || LOWER(#{productName}) || '%' AND fk_category_id = #{productCategoryId}")
    @ResultMap("product_Result")
    List<Product> getProductsByNameAndCategory(String productName, Long productCategoryId);

    //? Get Price
    @Select("SELECT price FROM product WHERE product_id = #{id}")
    @ResultMap("product_Result")
    BigDecimal getPriceByProductId(Long id);

    @Select("SELECT price FROM product WHERE name = #{productName}")
    @ResultMap("product_Result")
    BigDecimal getPriceByProductName(String productName);

    //? Get Description
    @Select("SELECT description FROM product WHERE product_id = #{id}")
    @ResultMap("product_Result")
    String getDescriptionByProductId(Long id);

    @Select("SELECT description FROM product WHERE name = #{productName}")
    @ResultMap("product_Result")
    String getDescriptionByProductName(String productName);

}
