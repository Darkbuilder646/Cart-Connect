package com.example.jspapp.mapper;

import com.example.jspapp.entity.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductCategoryMapper {

    @Insert("INSERT INTO product_category (name, description) VALUES (#{name}, #{description})")
    void save(ProductCategory productCategory);

    @Delete("DELETE FROM product_category WHERE category_id = #{id}")
    void deleteCategoryById(Long id);

    @Update("UPDATE product_category SET name = #{name}, description = #{description} WHERE category_id = #{categoryID}")
    void update(ProductCategory productCategory);

    @Select("SELECT * FROM product_category")
    @Results(id = "productCategory_Result", value = {
            @Result(property = "categoryID", column = "category_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description")
    })
    List<ProductCategory> getAllCategory();

    @Select("SELECT * FROM product_category WHERE category_id = #{id}")
    @ResultMap("productCategory_Result")
    ProductCategory getCategoryById(Long id);

    @Select("SELECT * FROM product_category WHERE LOWER(name) LIKE '%' || LOWER(#{name}) || '%' ")
    @ResultMap("productCategory_Result")
    ProductCategory getCategoryByName(String name);

}
