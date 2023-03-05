/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author Administrador
 */
public class Util {

    public static String chaveMD5 = "abe6db4c9f5484fae8d79f2e868a673c";
    public static String _AD = "\"";

    public final void Response200Json(HttpServletResponse response, Object object) throws IOException {
        response.setContentType("text/json;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            response.setStatus(200);
           
            
            out.println(new Gson().toJson(object));
        }
    }
    
    public final void ResponseMsg(HttpServletResponse response, int status, Object object) throws IOException {
        response.setContentType("text/json;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            response.setStatus(status);
            out.println(new Gson().toJson(object));
        }
    }
    
    public Object RequestToObject(HttpServletRequest request, Object obj) {

        Class clazz = obj.getClass();
        String param;
        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();
        for (Field f : fields) {
            System.out.println(f.toString());
            String campo = f.getName();

            campo = campo.substring(0, 1).toUpperCase() + campo.substring(1);
            try {
                Method method = obj.getClass().getMethod("set" + campo, f.getType());

                if (method == null) {
                    method = obj.getClass().getMethod("is" + campo, f.getType());
                }
                if (method != null) {
                    param = request.getParameter(campo.toLowerCase());
                    String tipo = f.getType().getName();
                    if (param != null && param != "") {
                        if (tipo.equals("java.lang.Long")) {
                            method.invoke(obj, Long.parseLong(param));
                        }
                        if (tipo.equals("java.lang.Double")) {
                            method.invoke(obj, Double.parseDouble(param));
                        }
                        if (tipo.equals("java.lang.Double")) {
                            method.invoke(obj, Integer.parseInt(param));
                        }
                        if (tipo.equals("java.lang.String")) {
                            method.invoke(obj, param);
                        }
                        if (tipo.equals("int")) {
                            method.invoke(obj, Integer.parseInt(param));
                        }
                        if (tipo.equals("boolean")) {
                            boolean b;
                            if (param.equals("1") || param.equals("true") || param.equals("t")) {
                                method.invoke(obj, true);
                            } else {
                                method.invoke(obj, true);
                            }

                        }
                    }
                }
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return obj;
    }
}
