package khmerhowto.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import khmerhowto.Repository.Model.Category;
import khmerhowto.Service.ServiceImplement.CategoryServiceImp;

/**
 * CategoryController
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryServiceImp categoryService;

    @GetMapping("/categories")
    public List<Category> index(){
        return categoryService.findCategoryByStatus(1);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Map<String, Object>> find(@PathVariable("id") Integer id){
        // System.out.println(id);
        Map<String, Object> response = new HashMap<>();
        Category category = categoryService.findCategoryById(id);
        response.put("category", category);
        System.out.println(response);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}