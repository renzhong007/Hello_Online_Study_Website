package com.superz.study.action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sun.org.apache.regexp.internal.recompile;
import com.superz.study.bean.Item;
import com.superz.study.bean.Subject;
import com.superz.study.service.ExamService;
import com.superz.study.service.impl.ExamServiceImpl;

public class ItemAction implements RequestAware,ModelDriven<Item>,Preparable {

	private ExamService es = new ExamServiceImpl();

	// 封装上传文件域的属性
	private File fileText;
	// 封装上传文件类型的属性
	private String fileTextContentType;
	// 封装上传文件名的属性
	private String fileTextFileName;

	private int id;
	private Item item;
	private Integer sub_id;
	private int num;

	private Map<String, Object> request;
	
	public void prepareUpdateItem(){
		List<Subject> allSubject = es.getAllSubject();
		Subject subject = allSubject.get(num);
		this.item = es.getItemById(id, subject.getId());
		System.out.println(this.item);
	}
	
	public String updateItem(){
		es.updateItem(this.item);
		return "updateItem_success";
	}
	
	public void prepareEditItem(){
		List<Subject> allSubject = es.getAllSubject();
		Subject subject = allSubject.get(num);
		this.item = es.getItemById(id, subject.getId());
		System.out.println(this.item);
	}
	
	public String editItem(){
		request.put("num", num);
		request.put("id", id);
		return "editItem_success";
	}
	
	public String deleteItem(){
		List<Subject> allSubject = es.getAllSubject();
		Subject subject = allSubject.get(num);
		this.item = new Item();
		this.item.setId(id);
		this.item.setSubject_id(subject.getId());
		es.delect(this.item);
		return "deleteItem_success";
	}

	public String toAddItem(){
		List<Subject> allSubject = es.getAllSubject();
		Subject subject = allSubject.get(num);
		request.put("subject", subject);
		request.put("num", num);
		return "toAddItem_success";
	}
	
	public String displayItem() {
		List<Subject> allSubject = es.getAllSubject();
		Subject subject = allSubject.get(num);
		List<Item> itemList = es.getAllItemBySubjectId(subject.getId());
		int sub_list_size = allSubject.size()-1;
		request.put("itemList", itemList);
		request.put("allSubject", allSubject);
		request.put("num", num);
		request.put("sub_list_size", sub_list_size);
		return "displayItem_success";
	}

	public void prepareSaveItem(){
		this.item = new Item();
	}
	
	public String saveItem() {
		this.item.setSubject_id(this.sub_id);
		if (es.saveItem(this.item)) {
			return "saveItem_success";
		}
		return "error";

	}

	public String upload() {
		Subject subject = es.getSubjectBySubjectId(sub_id);
		FileOutputStream fos = null;
		FileInputStream fis = null;
		String path = null;
		try {
			path = ServletActionContext.getServletContext().getRealPath("temp");
			// 设置上传路径
			File saved = new File(path, getFileTextFileName());
			saved.getParentFile().mkdirs();
			// 建立文件上传流
			fis = new FileInputStream(getFileText());
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String str;
			while ((str = br.readLine()) != null) {
				this.item = new Item();
				item.setTitle(str);
				item.setOptionA(br.readLine());
				item.setOptionB(br.readLine());
				item.setOptionC(br.readLine());
				item.setOptionD(br.readLine());
				item.setAnswer(br.readLine());
				item.setSubject_id(this.sub_id);
				es.saveItem(item);
			}
			System.out.println("文件上传成功");
		} catch (Exception e) {
			System.out.println("文件上传失败");
			e.printStackTrace();
			return "error";
		} finally {
			close(fos, fis);
		}
		return "upload_success";
	}

	private void close(FileOutputStream fos, FileInputStream fis) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				System.out.println("FileInputStream关闭失败");
				e.printStackTrace();
			}
		}
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				System.out.println("FileOutputStream关闭失败");
				e.printStackTrace();
			}
		}
	}

	public File getFileText() {
		return fileText;
	}

	public void setFileText(File fileText) {
		this.fileText = fileText;
	}

	public String getFileTextContentType() {
		return fileTextContentType;
	}

	public void setFileTextContentType(String fileTextContentType) {
		this.fileTextContentType = fileTextContentType;
	}

	public String getFileTextFileName() {
		return fileTextFileName;
	}

	public void setFileTextFileName(String fileTextFileName) {
		this.fileTextFileName = fileTextFileName;
	}

	public Integer getSub_id() {
		return sub_id;
	}

	public void setSub_id(Integer sub_id) {
		this.sub_id = sub_id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public Item getModel() {
		return this.item;
	}

	@Override
	public void prepare() throws Exception {
	}

}
