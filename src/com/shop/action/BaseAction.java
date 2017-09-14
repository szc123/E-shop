package com.shop.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.model.FileImage;
import com.shop.service.AccountService;
import com.shop.service.CategoryService;
import com.shop.service.ForderService;
import com.shop.service.PayService;
import com.shop.service.ProductService;
import com.shop.service.SorderService;
import com.shop.service.UserService;
import com.shop.utils.EmailUtil;
import com.shop.utils.FileUpload;
import com.shop.utils.MessageUtil;
@Controller("baseAction")
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware, ApplicationAware,ModelDriven<T>{
	
	private static final long serialVersionUID = 1L;
	//封装了图片信息的类  
    protected FileImage fileImage;  
    //上传文件工具类  
    @Resource  
    protected FileUpload fileUpload;  
    //发送邮件工具类
    @Resource
    protected EmailUtil emailUtil;
    //发送手机信息工具类
    @Resource
    protected MessageUtil messageUtil;
    
  
    public FileImage getFileImage() {  
        return fileImage;  
    }  
    public void setFileImage(FileImage fileImage) {  
        this.fileImage = fileImage;  
    } 
	protected List<T> jsonList=null;
	protected String ids;
	protected InputStream inputStream; 
	protected Integer page;
	protected Integer rows;
	protected Map<String, Object> pageMap=null;
	public List<T> getJsonList() {
		return jsonList;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Map<String, Object> getPageMap() {
		return pageMap;
	}
	//service对象
	@Resource
	protected CategoryService categoryService;
	@Resource
	protected AccountService accountService;
	@Resource
	protected ProductService productService;
	@Resource
	protected SorderService sorderService;
	@Resource
	protected ForderService forderService;
	@Resource
	protected UserService userService;
	@Resource
	protected PayService payService;
	//域对象
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	
	protected T model;
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
	//模型驱动
	@Override
	public T getModel() {
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz=(Class) type.getActualTypeArguments()[0];
		try {
			model=(T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return model;
	}
}
