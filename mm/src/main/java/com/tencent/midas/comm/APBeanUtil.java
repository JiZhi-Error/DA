package com.tencent.midas.comm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class APBeanUtil {
    public static void copyProperties(Object obj, Object obj2) {
        AppMethodBeat.i(193230);
        try {
            copyPropertiesExclude(obj, obj2, null, true);
            AppMethodBeat.o(193230);
        } catch (Exception e2) {
            AppMethodBeat.o(193230);
        }
    }

    public static void copyPropertiesExclude(Object obj, Object obj2, String[] strArr, boolean z) {
        Method[] declaredMethods;
        Method[] methodArr;
        Method findMethodByName;
        Object invoke;
        AppMethodBeat.i(193231);
        List asList = (strArr == null || strArr.length <= 0) ? null : Arrays.asList(strArr);
        if (z) {
            Method[] methods = obj.getClass().getMethods();
            declaredMethods = obj2.getClass().getMethods();
            methodArr = methods;
        } else {
            Method[] declaredMethods2 = obj.getClass().getDeclaredMethods();
            declaredMethods = obj2.getClass().getDeclaredMethods();
            methodArr = declaredMethods2;
        }
        for (Method method : methodArr) {
            String name = method.getName();
            if (name.contains("get") && ((asList == null || !asList.contains(name.substring(3).toLowerCase())) && (findMethodByName = findMethodByName(declaredMethods, "set" + name.substring(3))) != null && (invoke = method.invoke(obj, new Object[0])) != null && (!(invoke instanceof Collection) || ((Collection) invoke).size() > 0))) {
                findMethodByName.invoke(obj2, invoke);
            }
        }
        AppMethodBeat.o(193231);
    }

    public static void copyPropertiesInclude(Object obj, Object obj2, String[] strArr, boolean z) {
        Method[] declaredMethods;
        Method[] methodArr;
        Method findMethodByName;
        Object invoke;
        AppMethodBeat.i(193232);
        if (strArr == null || strArr.length <= 0) {
            AppMethodBeat.o(193232);
            return;
        }
        List asList = Arrays.asList(strArr);
        if (z) {
            Method[] methods = obj.getClass().getMethods();
            declaredMethods = obj2.getClass().getMethods();
            methodArr = methods;
        } else {
            Method[] declaredMethods2 = obj.getClass().getDeclaredMethods();
            declaredMethods = obj2.getClass().getDeclaredMethods();
            methodArr = declaredMethods2;
        }
        for (Method method : methodArr) {
            String name = method.getName();
            if (name.contains("get")) {
                String substring = name.substring(3);
                if (asList.contains(substring.substring(0, 1).toLowerCase() + substring.substring(1)) && (findMethodByName = findMethodByName(declaredMethods, "set" + name.substring(3))) != null && (invoke = method.invoke(obj, new Object[0])) != null && (!(invoke instanceof Collection) || ((Collection) invoke).size() > 0)) {
                    findMethodByName.invoke(obj2, invoke);
                }
            }
        }
        AppMethodBeat.o(193232);
    }

    public static Method findMethodByName(Method[] methodArr, String str) {
        AppMethodBeat.i(193233);
        for (int i2 = 0; i2 < methodArr.length; i2++) {
            if (methodArr[i2].getName().equals(str)) {
                Method method = methodArr[i2];
                AppMethodBeat.o(193233);
                return method;
            }
        }
        AppMethodBeat.o(193233);
        return null;
    }
}
