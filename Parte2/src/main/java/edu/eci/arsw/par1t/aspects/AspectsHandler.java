/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.arsw.par1t.aspects;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import sun.reflect.annotation.AnnotationType;

/**
 *
 * @author Nicolas Moreno Guataquira
 */
public class AspectsHandler {
    private PrintWriter pw =  new PrintWriter(new OutputStreamWriter(System.out));
    
    public Object analisis(ProceedingJoinPoint jp){
        
        long start=System.currentTimeMillis();
        
        Object object = null;
        try {
            
            MethodSignature signature = (MethodSignature)jp.getSignature();
            Method method = signature.getMethod();
            String nombre = method.getName();
            object= jp.proceed();
            start=System.currentTimeMillis()-start;
            if(jp.getTarget().toString().contains("DataLoaderOne")){
                pw.println("Nombre del componente de carga : DataLoaderOne Tiempo "+start+" ms.");
            }else if(jp.getTarget().toString().contains("DataLoaderTwo")){
                pw.println("Nombre del componente de carga : DataLoaderTwo Tiempo "+start+" ms.");
            }else if(jp.getTarget().toString().contains("SorterThree")){
                pw.println("Nombre del componente de ordenamiendo : SorterThree Tiempo "+start+" ms.");
            }else if(jp.getTarget().toString().contains("SorterTwo")){
                pw.println("Nombre del componente de ordenamiento: SorterTwo Tiempo "+start+" ms.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        pw.flush();
        return object;
    }
    
}
