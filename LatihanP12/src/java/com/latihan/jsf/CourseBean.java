package com.latihan.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Hadi
 */

@ManagedBean
@ViewScoped
public class CourseBean implements Serializable {

    private String selectedCategory;
    private String selectedCourse;
    private List<String> categories;
    private List<String> courses;
    private Map<String, List<String>> courseData = new HashMap<>();

    @PostConstruct
    public void init() {

        categories = new ArrayList<>();

        // Kategori berdasarkan SKS
        categories.add("3 SKS");
        categories.add("2 SKS");

        
        List<String> sks3List = new ArrayList<>();
        sks3List.add("Pemorgraman II");
        sks3List.add("Basis Data II");
        sks3List.add("Mobile Programming");
        sks3List.add("Rekayasa Perangkat Lunak");

        
        List<String> sks2List = new ArrayList<>();
        sks2List.add("Sistem Pendukung Keputusan");
        sks2List.add("Teknologi Internet of Things");
        sks2List.add("Teknik Komplikasi");
        sks2List.add("Kerja Praktek");

       
        courseData.put("3 SKS", sks3List);
        courseData.put("2 SKS", sks2List);

        // Default kosong
        selectedCategory = "";
        courses = new ArrayList<>();
    }

    public void onCategoryChange() {

        if (selectedCategory != null && !selectedCategory.equals("")) {
            courses = courseData.get(selectedCategory);
        } else {
            courses = new ArrayList<>();
        }
    }

    public String getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public String getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(String selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<String> getCourses() {
        return courses;
    }
}