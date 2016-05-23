package com.unique.demo.controller;


import org.unique.web.annotation.Controller;
import org.unique.web.annotation.PathVariable;
import org.unique.web.annotation.Route;
import org.unique.web.core.R;

/**
 * 测试控制器
 * @author biezhi
 * @version 1.0
 */
@Controller("/")
public class IndexController {
	
	
	@Route("/show_post/$1")
	public String showPost(@PathVariable String user_id){
		System.out.println("userid = " + user_id);
		R.setAttr("user_id", user_id);
		return "single";
	}
	
	@Route("/show_cat_post/$1_$2")
	public String showCatPost(@PathVariable Integer cat_id, @PathVariable Integer post_id){
		System.out.println("cat_id = " + cat_id);
		System.out.println("post_id = " + post_id);
		return "single";
	}
	
	@Route("/show_cat_post2")
	public String show_cat_post2(){
		System.out.println("show_cat_post2");
		String cat = R.getPara("cat");
		String post_id = R.getPara("post_id");
		System.out.println("cat = " + cat);
		System.out.println("post_id = " + post_id);
		return "single";
	}
	
	@Route
	public String tag(){
		String tag = R.getPara("tag");
		Integer qq = R.getParaToInt("qq");
		System.out.println(qq > 2);
		System.out.println("tag = " + tag);
		System.out.println("qq = " + qq);
		return "single";
	}
}
