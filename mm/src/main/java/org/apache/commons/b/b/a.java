package org.apache.commons.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.b.h;

public final class a {
    private static final Object Uhp = new Object();
    private static String[] Uhq = {"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};
    private static final Method Uhr;
    private static final Method Uhs;
    static Class Uht;

    static {
        Method method;
        Class cls;
        Class<?> cls2;
        Class cls3;
        Method method2 = null;
        AppMethodBeat.i(40719);
        try {
            if (Uht == null) {
                cls3 = bvc("java.lang.Throwable");
                Uht = cls3;
            } else {
                cls3 = Uht;
            }
            method = cls3.getMethod("getCause", null);
        } catch (Exception e2) {
            method = null;
        }
        Uhr = method;
        try {
            if (Uht == null) {
                Class bvc = bvc("java.lang.Throwable");
                Uht = bvc;
                cls = bvc;
            } else {
                cls = Uht;
            }
            Class<?>[] clsArr = new Class[1];
            if (Uht == null) {
                cls2 = bvc("java.lang.Throwable");
                Uht = cls2;
            } else {
                cls2 = Uht;
            }
            clsArr[0] = cls2;
            method2 = cls.getMethod("initCause", clsArr);
        } catch (Exception e3) {
        }
        Uhs = method2;
        AppMethodBeat.o(40719);
    }

    private static Class bvc(String str) {
        AppMethodBeat.i(40718);
        try {
            Class<?> cls = Class.forName(str);
            AppMethodBeat.o(40718);
            return cls;
        } catch (ClassNotFoundException e2) {
            NoClassDefFoundError noClassDefFoundError = new NoClassDefFoundError(e2.getMessage());
            AppMethodBeat.o(40718);
            throw noClassDefFoundError;
        }
    }

    public static Throwable J(Throwable th) {
        Throwable a2;
        AppMethodBeat.i(40712);
        synchronized (Uhp) {
            try {
                a2 = a(th, Uhq);
            } finally {
                AppMethodBeat.o(40712);
            }
        }
        return a2;
    }

    private static Throwable a(Throwable th, String[] strArr) {
        Throwable th2 = null;
        AppMethodBeat.i(40713);
        if (th == null) {
            AppMethodBeat.o(40713);
        } else {
            if (th instanceof b) {
                th2 = ((b) th).getCause();
            } else if (th instanceof SQLException) {
                th2 = ((SQLException) th).getNextException();
            } else if (th instanceof InvocationTargetException) {
                th2 = ((InvocationTargetException) th).getTargetException();
            }
            if (th2 == null) {
                if (strArr == null) {
                    synchronized (Uhp) {
                        try {
                            strArr = Uhq;
                        } catch (Throwable th3) {
                            AppMethodBeat.o(40713);
                            throw th3;
                        }
                    }
                }
                int i2 = 0;
                while (i2 < strArr.length && ((r2 = strArr[i2]) == null || (th2 = f(th, r2)) == null)) {
                    i2++;
                }
                if (th2 == null) {
                    th2 = g(th, "detail");
                }
            }
            AppMethodBeat.o(40713);
        }
        return th2;
    }

    private static Throwable f(Throwable th, String str) {
        Method method;
        Class cls;
        AppMethodBeat.i(40714);
        try {
            method = th.getClass().getMethod(str, null);
        } catch (NoSuchMethodException e2) {
            method = null;
        } catch (SecurityException e3) {
            method = null;
        }
        if (method != null) {
            if (Uht == null) {
                cls = bvc("java.lang.Throwable");
                Uht = cls;
            } else {
                cls = Uht;
            }
            if (cls.isAssignableFrom(method.getReturnType())) {
                try {
                    Throwable th2 = (Throwable) method.invoke(th, org.apache.commons.b.a.UeK);
                    AppMethodBeat.o(40714);
                    return th2;
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e4) {
                }
            }
        }
        AppMethodBeat.o(40714);
        return null;
    }

    private static Throwable g(Throwable th, String str) {
        Field field;
        Class cls;
        AppMethodBeat.i(40715);
        try {
            field = th.getClass().getField(str);
        } catch (NoSuchFieldException e2) {
            field = null;
        } catch (SecurityException e3) {
            field = null;
        }
        if (field != null) {
            if (Uht == null) {
                cls = bvc("java.lang.Throwable");
                Uht = cls;
            } else {
                cls = Uht;
            }
            if (cls.isAssignableFrom(field.getType())) {
                try {
                    Throwable th2 = (Throwable) field.get(th);
                    AppMethodBeat.o(40715);
                    return th2;
                } catch (IllegalAccessException | IllegalArgumentException e4) {
                }
            }
        }
        AppMethodBeat.o(40715);
        return null;
    }

    public static boolean hPO() {
        return Uhr != null;
    }

    public static void J(List list, List list2) {
        AppMethodBeat.i(40716);
        int size = list.size() - 1;
        int size2 = list2.size() - 1;
        for (int i2 = size; i2 >= 0 && size2 >= 0; i2--) {
            if (((String) list.get(i2)).equals((String) list2.get(size2))) {
                list.remove(i2);
            }
            size2--;
        }
        AppMethodBeat.o(40716);
    }

    static String[] bvn(String str) {
        AppMethodBeat.i(40717);
        StringTokenizer stringTokenizer = new StringTokenizer(str, h.TTr);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        AppMethodBeat.o(40717);
        return strArr;
    }
}
