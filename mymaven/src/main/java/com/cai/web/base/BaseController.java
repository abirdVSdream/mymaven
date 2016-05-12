package com.cai.web.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

//import com.google.gson.Gson;
import com.imes.domain.admin.CmUserBean;
import com.imes.domain.config.CmStatusBean;
import com.imes.domain.config.PtRunStatusBean;
import com.imes.frame.exception.ImesBussinessException;
import com.imes.frame.service.BaseServiceI;
import com.imes.frame.util.BeanMapUtil;
import com.imes.frame.util.UserInf;

public abstract class BaseController
{
    
    public static final String STATUS_KEY = "status";
    
    SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static final String RESULT_KEY = "result";
    
    public static final String JSON_STATUS_KEY = "status";
    
    public static final String JSON_RESULT_KEY = "result";
    
    public static final String JSON_MESSAGE_KEY = "message";
    
    public static final String JSON_STATUS_SUCCESS = "Y";
    
    public static final String JSON_STATUS_FAILURE = "N";
    
    public BaseController()
    {
        super();
    }
    
    public abstract BaseServiceI getService();
    
    /**
     * 跳转页面
     * 
     * @param urls 页面路径
     * @return
     */
    public ModelAndView doJump(String urls)
    {
        return new ModelAndView(urls);
    }
    
    /**
     * 跳转到对应操作页面
     * 
     * @param request
     * @param response
     * @param urlMap
     * @return
     */
    public ModelAndView gotoIndexPage(HttpServletRequest request, HttpServletResponse response,
        Map<String, String> urlMap)
    {
        String OPER = request.getParameter("OPER");
        String PAGE_URL = urlMap.get("SEARCH");
        if (OPER != null)
        {
            PAGE_URL = urlMap.get(OPER);
        }
        return new ModelAndView(PAGE_URL);
    }
    
    /**
     * 简单的输出文本格式内容，适用于Ajax请求。
     * 
     * @param content
     * @throws
     * @throws IOException
     */
    public void simpleResponse(String content, HttpServletResponse response)
    {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = null;
        try
        {
            out = response.getWriter();
            out.print(content);
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        finally
        {
            if (out != null)
            {
                out.flush();
                out.close();
            }
        }
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public String getJsonText(Object obj)
    {
        JSONObject res = new JSONObject();
        res.put(STATUS_KEY, true);
        if (obj instanceof Exception)
        {
            res.put(RESULT_KEY, ((Exception)obj).getMessage());
        }
        else
        {
            res.put(RESULT_KEY, obj);
        }
        return res.toString();
    }
    
    /**
     * 打印错误信息
     * 
     * @param obj
     * @return
     */
    public String getErrorJsonText(Object obj)
    {
        JSONObject res = new JSONObject();
        res.put(STATUS_KEY, false);
        if (obj instanceof Exception)
        {
            res.put(RESULT_KEY, ((Exception)obj).getMessage());
        }
        else
        {
            res.put(RESULT_KEY, obj);
        }
        return res.toString();
    }
    
    public void outPrintJsonText(HttpServletRequest request, HttpServletResponse response, Object obj)
    {
        Map<String, Object> m = new HashMap<String, Object>();
        m.put(JSON_STATUS_KEY, JSON_STATUS_SUCCESS);
        m.put(JSON_RESULT_KEY, obj);
        this.outPrintText(request, response, JSONObject.fromObject(m).toString());
    }
    
    public void outPrintJsonException(HttpServletRequest request, HttpServletResponse response, Exception ex)
    {
        outPrintJsonError(request, response, ex.getMessage());
    }
    
    /**
     * 输出报错的JSON数据
     * 
     * @author dingyanwen
     * @param request
     * @param response
     * @param message
     */
    public void outPrintJsonError(HttpServletRequest request, HttpServletResponse response, String message)
    {
        Map<String, String> m = new HashMap<String, String>();
        m.put(JSON_STATUS_KEY, JSON_STATUS_FAILURE);
        m.put(JSON_MESSAGE_KEY, message);
        this.outPrintText(request, response, JSONObject.fromObject(m).toString());
    }
    
    public void outPrintJsonRight(HttpServletRequest request, HttpServletResponse response, String message)
    {
        Map<String, String> m = new HashMap<String, String>();
        m.put(JSON_STATUS_KEY, JSON_STATUS_SUCCESS);
        m.put(JSON_MESSAGE_KEY, message);
        this.outPrintText(request, response, JSONObject.fromObject(m).toString());
    }
    
    public void outPrintText(HttpServletRequest request, HttpServletResponse response, String text)
    {
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = null;
        try
        {
            out = response.getWriter();
            out.print(text);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (out != null)
            {
                out.flush();
                out.close();
            }
        }
    }
    
    public CmStatusBean getStatusBo(HttpServletRequest request, String status, String statusGroup)
    {
        CmStatusBean cmStatusBo = new CmStatusBean();
        if (!StringUtils.isEmpty(status))
        {
            cmStatusBo.setCompany(this.getCompany(request));
            cmStatusBo.setStatus(status);
            cmStatusBo.setStatusGroup(statusGroup);
        }
        return cmStatusBo;
    }
    
    public PtRunStatusBean getRunStatusBo(HttpServletRequest request, String runStatus, String statusGroup)
    {
        PtRunStatusBean runStatusBo = new PtRunStatusBean();
        runStatusBo.setCompany(this.getCompany(request));
        runStatusBo.setRunStatus(runStatus);
        ;
        runStatusBo.setStatusGroup(statusGroup);
        runStatusBo.setPlant(this.getPlant(request));
        return runStatusBo;
    }
    
    public CmUserBean getUserBo(HttpServletRequest request)
    {
        CmUserBean cmUserBo = new CmUserBean();
        UserInf userInf = new UserInf();
        cmUserBo.setCompany(userInf.getCompany());
        cmUserBo.setUserid(userInf.getUser());
        
        return cmUserBo;
    }
    
    public Object toBean(String jsonObj, Class<?> type)
    {
//        Gson g = new Gson();
        JSONObject JsonO = JSONObject.fromObject(jsonObj);
        Map mp = (Map)JSONObject.toBean(JsonO,  Map.class);
        try {
			return this.toBean(mp, type);
		} catch (Exception e) {
			e.printStackTrace();
		} 
//     	  Object obj =JSONObject.toBean(JsonO, type);
//        Object obj = g.fromJson(jsonObj, type);
        return null;
    }
    
    public Object toBean(Map<String, ? extends Object> map, Class<?> type)
        throws Exception
    {
        
        return BeanMapUtil.toBean(type, map);
    }
    
    public String getCompany(HttpServletRequest request)
    {
        UserInf useri = new UserInf();
        return useri.getCompany();
    }
    
    public String getPlant(HttpServletRequest request)
    {
        UserInf useri = new UserInf();
        String plant=useri.getPlant(request);
        if(plant.equals("*"))
        {
        	CmUserBean cmUserBo=new CmUserBean();
        	cmUserBo.setCompany(useri.getCompany());
        	cmUserBo.setUserid(useri.getUser());
        	try {
				Map<String,Object> userMap=this.getService().retrieve(cmUserBo);
				String defaultPlant=(String)userMap.get("DEFAULT_PLANT");
				if(!StringUtils.isEmpty(defaultPlant))
				{
					useri.setPlant(request, defaultPlant);
					plant=useri.getPlant(request);
				}
			} catch (ImesBussinessException e) {
				e.printStackTrace();
			}
        }
        return plant;
    }
    
    public String getUser(HttpServletRequest request)
    {
        UserInf useri = new UserInf();
        return useri.getUser();
    }
    
}
