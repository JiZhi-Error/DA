package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzu {
    private static void zza(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        AppMethodBeat.i(100763);
        if (obj != null) {
            if (obj instanceof zzt) {
                int length = stringBuffer.length();
                if (str != null) {
                    stringBuffer2.append(stringBuffer).append(zzh(str)).append(" <\n");
                    stringBuffer.append("  ");
                }
                Class<?> cls = obj.getClass();
                Field[] fields = cls.getFields();
                for (Field field : fields) {
                    int modifiers = field.getModifiers();
                    String name = field.getName();
                    if (!"cachedSize".equals(name) && (modifiers & 1) == 1 && (modifiers & 8) != 8 && !name.startsWith("_") && !name.endsWith("_")) {
                        Class<?> type = field.getType();
                        Object obj2 = field.get(obj);
                        if (!type.isArray() || type.getComponentType() == Byte.TYPE) {
                            zza(name, obj2, stringBuffer, stringBuffer2);
                        } else {
                            int length2 = obj2 == null ? 0 : Array.getLength(obj2);
                            for (int i2 = 0; i2 < length2; i2++) {
                                zza(name, Array.get(obj2, i2), stringBuffer, stringBuffer2);
                            }
                        }
                    }
                }
                for (Method method : cls.getMethods()) {
                    String name2 = method.getName();
                    if (name2.startsWith("set")) {
                        String substring = name2.substring(3);
                        try {
                            String valueOf = String.valueOf(substring);
                            if (((Boolean) cls.getMethod(valueOf.length() != 0 ? "has".concat(valueOf) : new String("has"), new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                                try {
                                    String valueOf2 = String.valueOf(substring);
                                    zza(substring, cls.getMethod(valueOf2.length() != 0 ? "get".concat(valueOf2) : new String("get"), new Class[0]).invoke(obj, new Object[0]), stringBuffer, stringBuffer2);
                                } catch (NoSuchMethodException e2) {
                                }
                            }
                        } catch (NoSuchMethodException e3) {
                        }
                    }
                }
                if (str != null) {
                    stringBuffer.setLength(length);
                    stringBuffer2.append(stringBuffer).append(">\n");
                }
                AppMethodBeat.o(100763);
                return;
            }
            stringBuffer2.append(stringBuffer).append(zzh(str)).append(": ");
            if (obj instanceof String) {
                String str2 = (String) obj;
                if (!str2.startsWith("http") && str2.length() > 200) {
                    str2 = String.valueOf(str2.substring(0, 200)).concat("[...]");
                }
                int length3 = str2.length();
                StringBuilder sb = new StringBuilder(length3);
                for (int i3 = 0; i3 < length3; i3++) {
                    char charAt = str2.charAt(i3);
                    if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                        sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                    } else {
                        sb.append(charAt);
                    }
                }
                stringBuffer2.append("\"").append(sb.toString()).append("\"");
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if (bArr == null) {
                    stringBuffer2.append("\"\"");
                } else {
                    stringBuffer2.append('\"');
                    for (byte b2 : bArr) {
                        int i4 = b2 & 255;
                        if (i4 == 92 || i4 == 34) {
                            stringBuffer2.append('\\').append((char) i4);
                        } else if (i4 < 32 || i4 >= 127) {
                            stringBuffer2.append(String.format("\\%03o", Integer.valueOf(i4)));
                        } else {
                            stringBuffer2.append((char) i4);
                        }
                    }
                    stringBuffer2.append('\"');
                }
            } else {
                stringBuffer2.append(obj);
            }
            stringBuffer2.append("\n");
        }
        AppMethodBeat.o(100763);
    }

    public static <T extends zzt> String zzc(T t) {
        AppMethodBeat.i(100762);
        if (t == null) {
            AppMethodBeat.o(100762);
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            zza(null, t, new StringBuffer(), stringBuffer);
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(100762);
            return stringBuffer2;
        } catch (IllegalAccessException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                String concat = "Error printing proto: ".concat(valueOf);
                AppMethodBeat.o(100762);
                return concat;
            }
            String str = new String("Error printing proto: ");
            AppMethodBeat.o(100762);
            return str;
        } catch (InvocationTargetException e3) {
            String valueOf2 = String.valueOf(e3.getMessage());
            if (valueOf2.length() != 0) {
                String concat2 = "Error printing proto: ".concat(valueOf2);
                AppMethodBeat.o(100762);
                return concat2;
            }
            String str2 = new String("Error printing proto: ");
            AppMethodBeat.o(100762);
            return str2;
        }
    }

    private static String zzh(String str) {
        AppMethodBeat.i(100764);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (i2 == 0) {
                stringBuffer.append(Character.toLowerCase(charAt));
            } else if (Character.isUpperCase(charAt)) {
                stringBuffer.append('_').append(Character.toLowerCase(charAt));
            } else {
                stringBuffer.append(charAt);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(100764);
        return stringBuffer2;
    }
}
