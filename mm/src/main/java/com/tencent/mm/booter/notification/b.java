package com.tencent.mm.booter.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* access modifiers changed from: package-private */
public final class b {
    static Field findField(Class<?> cls, String str) {
        AppMethodBeat.i(231499);
        try {
            Method declaredMethod = Class.class.getDeclaredMethod(CX("«¨º­ª¦ª¶ ¢©¤®§"), String.class);
            Class<? super Object> cls2 = cls;
            while (true) {
                try {
                    Field field = (Field) declaredMethod.invoke(cls2, str);
                    field.setAccessible(true);
                    AppMethodBeat.o(231499);
                    return field;
                } catch (IllegalAccessException e2) {
                    NoSuchFieldException noSuchFieldException = new NoSuchFieldException("E2: " + cls.getName() + "," + str);
                    AppMethodBeat.o(231499);
                    throw noSuchFieldException;
                } catch (InvocationTargetException e3) {
                    if (e3.getTargetException() instanceof NoSuchFieldException) {
                        Class<? super Object> superclass = cls2.getSuperclass();
                        if (superclass == Object.class || superclass == null) {
                            NoSuchFieldException noSuchFieldException2 = new NoSuchFieldException(CX("«å ®¥­¦ã") + str + CX("ê¢ªå¥«¡²±ã") + cls.getName() + CX("ö¸¢ñ»§¿í½º¸¬¸ë§©§´³¤±í"));
                            AppMethodBeat.o(231499);
                            throw noSuchFieldException2;
                        }
                        cls2 = superclass;
                    } else {
                        NoSuchFieldException noSuchFieldException3 = new NoSuchFieldException("E3: " + cls.getName() + "," + str);
                        AppMethodBeat.o(231499);
                        throw noSuchFieldException3;
                    }
                }
            }
            NoSuchFieldException noSuchFieldException22 = new NoSuchFieldException(CX("«å ®¥­¦ã") + str + CX("ê¢ªå¥«¡²±ã") + cls.getName() + CX("ö¸¢ñ»§¿í½º¸¬¸ë§©§´³¤±í"));
            AppMethodBeat.o(231499);
            throw noSuchFieldException22;
        } catch (NoSuchMethodException e4) {
            NoSuchFieldException noSuchFieldException4 = new NoSuchFieldException("E1: " + cls.getName() + "," + str);
            AppMethodBeat.o(231499);
            throw noSuchFieldException4;
        }
    }

    private static String CX(String str) {
        AppMethodBeat.i(231500);
        try {
            int length = str.length();
            StringBuilder sb = null;
            int i2 = 9;
            byte b2 = 0;
            int i3 = 0;
            while (true) {
                switch (i2) {
                    case 1:
                        String sb2 = sb.toString();
                        AppMethodBeat.o(231500);
                        return sb2;
                    case 2:
                    case 4:
                    case 6:
                    case 8:
                    case 10:
                    case 12:
                    case 14:
                    case 16:
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException();
                        AppMethodBeat.o(231500);
                        throw illegalStateException;
                    case 3:
                        i2 = i3 >= length ? i2 - 2 : i2 + 2;
                    case 5:
                        i2 += 10;
                        b2 = (byte) str.charAt(i3);
                    case 7:
                        i2 -= 4;
                        i3++;
                    case 9:
                        sb = new StringBuilder();
                        i2 -= 6;
                    case 11:
                        sb.append((char) b2);
                        i2 -= 4;
                    case 13:
                        i2 += 4;
                        b2 = (byte) (b2 ^ 60);
                    case 15:
                        i2 -= 2;
                        b2 = (byte) ((i3 - length) ^ b2);
                    case 17:
                        i2 -= 6;
                        b2 = (byte) (b2 & 255);
                }
            }
        } catch (Throwable th) {
            AppMethodBeat.o(231500);
            return str;
        }
    }
}
