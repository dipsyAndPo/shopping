package cn.yyt.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;


import cn.yyt.pojo.Category;
import cn.yyt.service.CategoryService;
import cn.yyt.util.ImageUtil;
import cn.yyt.util.Page;


public class CategoryAction extends Action4Result{
	
	@Action("admin_category_findAll")
	public String findAll(){
		if(page == null){
			page=new Page();
		}
		int total=categoryService.gettotal();
		page.setTotal(total);
		categorys=categoryService.findByPage(page);
		return "listCategory";
	}
	
	@Action("admin_category_delete")
	public String delete(){
		categoryService.delete(category);
		return "listCategoryPage";
	}

	@Action("admin_category_edit")
	public String edit(){
		t2p(category);
		return "editCategory";
	}
	
	@Action("admin_category_add")
	public String add(){
		categoryService.add(category);
		if(null!=img){
			 File  imageFolder= new File(ServletActionContext.getServletContext().getRealPath("img/category"));
		        File file = new File(imageFolder,category.getId()+".jpg");
		        try {
		            FileUtils.copyFile(img, file);
		            BufferedImage img = ImageUtil.change2jpg(file);
		            ImageIO.write(img, "jpg", file);           
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			}
		return "listCategoryPage";
	}
	
	@Action("admin_category_update")
	public String update(){
		categoryService.update(category);
		if(null!=img){
			 File  imageFolder= new File(ServletActionContext.getServletContext().getRealPath("img/category"));
		        File file = new File(imageFolder,category.getId()+".jpg");
		        try {
		            FileUtils.copyFile(img, file);
		            BufferedImage img = ImageUtil.change2jpg(file);
		            ImageIO.write(img, "jpg", file);           
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			}
		
		return "listCategoryPage";
	}
}
