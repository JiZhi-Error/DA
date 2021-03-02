package com.tencent.magicbrush.engine;

import android.support.annotation.Keep;
import android.webkit.JavascriptInterface;
import com.tencent.magicbrush.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;

@Keep
public class JsClassUtils {
    private static final int BOOLEAN = 1;
    private static final int BYTE = 3;
    private static final int CHAR = 2;
    private static final int DOUBLE = 8;
    private static final int FLOAT = 6;
    private static final int INT = 5;
    private static final int LONG = 7;
    private static final int SHORT = 4;
    private static final String TAG = "MicroMsg.JsClassUtils";
    private static final int VOID = 0;
    public static final int log_type_d = 0;
    public static final int log_type_e = 2;
    public static final int log_type_i = 1;
    private static final int string = 9;
    private static final int unknown = 10;

    public static boolean hasJavascriptInterface(Object obj) {
        AppMethodBeat.i(139977);
        try {
            for (Method method : obj.getClass().getMethods()) {
                if (method.isAnnotationPresent(JavascriptInterface.class)) {
                    AppMethodBeat.o(139977);
                    return true;
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(139977);
        return false;
    }

    @Keep
    public static Method[] getJavascriptInterfaceMethod(Object obj) {
        AppMethodBeat.i(139978);
        ArrayList arrayList = new ArrayList();
        try {
            Method[] methods = obj.getClass().getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(JavascriptInterface.class)) {
                    arrayList.add(method);
                }
            }
        } catch (Exception e2) {
        }
        Method[] methodArr = (Method[]) arrayList.toArray(new Method[arrayList.size()]);
        AppMethodBeat.o(139978);
        return methodArr;
    }

    @Keep
    public static String getMethodSignature(Method method) {
        AppMethodBeat.i(139979);
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (Class<?> cls : parameterTypes) {
            getDescriptor(sb, cls);
        }
        sb.append(')');
        getDescriptor(sb, method.getReturnType());
        String sb2 = sb.toString();
        AppMethodBeat.o(139979);
        return sb2;
    }

    @Keep
    public static String getMethodName(Method method) {
        AppMethodBeat.i(139980);
        String name = method.getName();
        AppMethodBeat.o(139980);
        return name;
    }

    private static void getDescriptor(StringBuilder sb, Class<?> cls) {
        char c2;
        AppMethodBeat.i(139981);
        while (!cls.isPrimitive()) {
            if (cls.isArray()) {
                sb.append('[');
                cls = cls.getComponentType();
            } else {
                sb.append('L');
                String name = cls.getName();
                int length = name.length();
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = name.charAt(i2);
                    if (charAt == '.') {
                        charAt = '/';
                    }
                    sb.append(charAt);
                }
                sb.append(';');
                AppMethodBeat.o(139981);
                return;
            }
        }
        if (cls == Integer.TYPE) {
            c2 = 'I';
        } else if (cls == Void.TYPE) {
            c2 = 'V';
        } else if (cls == Boolean.TYPE) {
            c2 = 'Z';
        } else if (cls == Byte.TYPE) {
            c2 = 'B';
        } else if (cls == Character.TYPE) {
            c2 = 'C';
        } else if (cls == Short.TYPE) {
            c2 = 'S';
        } else if (cls == Double.TYPE) {
            c2 = 'D';
        } else if (cls == Float.TYPE) {
            c2 = 'F';
        } else {
            c2 = 'J';
        }
        sb.append(c2);
        AppMethodBeat.o(139981);
    }

    private static int getJavaType(Class<?> cls) {
        AppMethodBeat.i(139982);
        if (cls == Integer.TYPE) {
            AppMethodBeat.o(139982);
            return 5;
        } else if (cls == Void.TYPE) {
            AppMethodBeat.o(139982);
            return 0;
        } else if (cls == Boolean.TYPE) {
            AppMethodBeat.o(139982);
            return 1;
        } else if (cls == Byte.TYPE) {
            AppMethodBeat.o(139982);
            return 3;
        } else if (cls == Character.TYPE) {
            AppMethodBeat.o(139982);
            return 2;
        } else if (cls == Short.TYPE) {
            AppMethodBeat.o(139982);
            return 4;
        } else if (cls == Double.TYPE) {
            AppMethodBeat.o(139982);
            return 8;
        } else if (cls == Float.TYPE) {
            AppMethodBeat.o(139982);
            return 6;
        } else if (cls.getCanonicalName().equals("java.lang.String")) {
            AppMethodBeat.o(139982);
            return 9;
        } else {
            AppMethodBeat.o(139982);
            return 10;
        }
    }

    @Keep
    public static int[] getMethodType(Method method) {
        AppMethodBeat.i(139983);
        Class<?>[] parameterTypes = method.getParameterTypes();
        int[] iArr = new int[(parameterTypes.length + 2)];
        iArr[0] = parameterTypes.length;
        iArr[1] = getJavaType(method.getReturnType());
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            iArr[i2 + 2] = getJavaType(parameterTypes[i2]);
        }
        AppMethodBeat.o(139983);
        return iArr;
    }

    @Keep
    public static void jsLog(int i2, String str) {
        AppMethodBeat.i(139984);
        switch (i2) {
            case 1:
                c.C0193c.i(TAG, str, new Object[0]);
                AppMethodBeat.o(139984);
                return;
            case 2:
                c.C0193c.e(TAG, str, new Object[0]);
                AppMethodBeat.o(139984);
                return;
            default:
                c.C0193c.d(TAG, str, new Object[0]);
                AppMethodBeat.o(139984);
                return;
        }
    }

    @Keep
    public static byte[] getStringUtf8(String str) {
        AppMethodBeat.i(139985);
        try {
            byte[] bytes = str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            AppMethodBeat.o(139985);
            return bytes;
        } catch (UnsupportedEncodingException e2) {
            AppMethodBeat.o(139985);
            return null;
        }
    }
}
