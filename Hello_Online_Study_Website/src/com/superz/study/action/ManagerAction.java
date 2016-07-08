package com.superz.study.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.superz.study.bean.User;
import com.superz.study.service.UserService;
import com.superz.study.service.impl.UserServiceImpl;

public class ManagerAction implements RequestAware, ParameterAware, ModelDriven<User>, Preparable {

	private User user;
	private Integer id;
	// 封装上传文件域的属性
	private File imgUpload;
	// 封装上传文件类型的属性
	private String imgUploadContentType;
	// 封装上传文件名的属性
	private String imgUploadFileName;

	private Map<String, Object> request;
	private Map<String, String[]> parameters;

	UserService es = new UserServiceImpl();

	/**
	 * 显示所有学生
	 */
	public String displayStudent() {
		List<User> userBill = es.getAllStudent();
		request.put("userBill", userBill);
		return "Student_success";
	}

	/**
	 * 显示所有老师
	 * 
	 * @return
	 */
	/////////////////////////////////////////
	public String displayTeacher() {
		List<User> userBill = es.getAllTeacher();
		request.put("userBill", userBill);
		return "Teacher_success";
	}

	////////////////////////////////////////////////////
	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteStudent() {
		if (es.deleteUserById(id))
			return "delete_Student_success";
		else
			return "error";
	}

	public String deleteTeacher() {
		if (es.deleteUserById(id))
			return "delete_Teacher_success";
		else
			return "error";
	}

	/**
	 * 修改
	 */
	public void prepareEditTeacher() {
		this.user = es.getUserById(id);
		request.put("user", this.user);
	}

	public String editTeacher() {
		return "edit_Teacher_success";
	}

	public void prepareEditStudent() {
		this.user = es.getUserById(id);
		request.put("user", this.user);
	}

	public String editStudent() {
		return "edit_Student_success";
	}

	/**
	 * 更新
	 */
	public void prepareUpdateStudent() {
		this.user = es.getUserById(this.id);
	}

	public String updateStudent() {
		// System.out.println(this.user);
		if (this.imgUpload != null) {
			this.user.setImg(this.upload());
		}
		if (es.upadateInf(this.user) != null)
			return "update_Student_success";
		else
			return "error";
	}

	public void prepareUpdateTeacher() {
		this.user = es.getUserById(this.id);
	}

	public String updateTeacher() {
		if (this.imgUpload != null) {
			this.user.setImg(this.upload());
		}
		if (es.upadateInf(this.user) != null)
			return "update_Teacher_success";
		else
			return "error";
	}

	/**
	 * 添加
	 */
	public void prepareAddTeacher() {
		this.user = new User();
	}

	public String addTeacher() {
		String addr = ServletActionContext.getRequest().getLocalAddr();
		this.user.setDateCreated(new Date());
		this.user.setIpCreated(addr);
		this.user.setStatus(2);
		this.user.setImg("/static/img/default.jpg");
		if (es.regist(user))
			return "add_Teacher_success";
		else
			return "error";
	}

	public void prepareAddStudent() {
		this.user = new User();
	}

	public String addStudent() {
		String addr = ServletActionContext.getRequest().getLocalAddr();
		this.user.setDateCreated(new Date());
		this.user.setIpCreated(addr);
		this.user.setStatus(3);
		this.user.setImg("/static/img/default.jpg");
		if (es.regist(user))
			return "add_Student_success";
		else
			return "error";
	}

	private String upload() {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		String path = null;
		try {
			path = ServletActionContext.getServletContext().getRealPath("upload");
			// path =
			// ServletActionContext.getRequest().getContextPath()+"/upload";
			System.out.println(path + this.getImgUploadFileName());
			// 设置上传路径
			File saved = new File(path, getImgUploadFileName());
			saved.getParentFile().mkdirs();
			// 建立文件输出流
			fos = new FileOutputStream(saved);
			// 建立文件上传流
			fis = new FileInputStream(getImgUpload());
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			System.out.println("文件上传成功");
		} catch (Exception e) {
			System.out.println("文件上传失败");
			e.printStackTrace();
			return "error";
		} finally {
			close(fos, fis);
		}
		// 返回相对路径
		// path = ServletActionContext.getRequest().getContextPath()+"/upload";
		return "/upload" + "/" + this.getImgUploadFileName();
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

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;

	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;

	}

	@Override
	public User getModel() {
		// System.out.println(this.user+"压栈");
		return this.user;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	// get、set方法
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public File getImgUpload() {
		return imgUpload;
	}

	public void setImgUpload(File imgUpload) {
		this.imgUpload = imgUpload;
	}

	public String getImgUploadContentType() {
		return imgUploadContentType;
	}

	public void setImgUploadContentType(String imgUploadContentType) {
		this.imgUploadContentType = imgUploadContentType;
	}

	public String getImgUploadFileName() {
		return imgUploadFileName;
	}

	public void setImgUploadFileName(String imgUploadFileName) {
		this.imgUploadFileName = imgUploadFileName;
	}

}
