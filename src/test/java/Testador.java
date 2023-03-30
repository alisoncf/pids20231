
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import model.Usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Administrador
 */
public class Testador {

    public static void main(String[] args)  {
        Usuario obj = new Usuario();
        Class clazz = obj.getClass();

        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();
        for (Field f : fields) {
            System.out.println(f.toString());
            String campo = f.getName();
            campo = campo.substring(0, 1).toUpperCase() + campo.substring(1);
            try {
                Method method=obj.getClass().getMethod("set" +  campo ,  f.getType()  );
                if (method!=null){
                    method.invoke(obj, 1L);
            }
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(Testador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        for (Method m : methods) {
            System.out.println(m.toString());

        }

    }
}
