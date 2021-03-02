package com.google.a.a;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class f {
    public static <T extends e> String c(T t) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            a(null, t, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e2) {
            return "Error printing proto: " + e2.getMessage();
        } catch (InvocationTargetException e3) {
            return "Error printing proto: " + e3.getMessage();
        }
    }

    private static void a(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        if (obj == null) {
            return;
        }
        if (obj instanceof e) {
            int length = stringBuffer.length();
            if (str != null) {
                stringBuffer2.append(stringBuffer).append(cq(str)).append(" <\n");
                stringBuffer.append("  ");
            }
            Class<?> cls = obj.getClass();
            Field[] fields = cls.getFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                String name = field.getName();
                if ((modifiers & 1) == 1 && (modifiers & 8) != 8 && !name.startsWith("_") && !name.endsWith("_")) {
                    Class<?> type = field.getType();
                    Object obj2 = field.get(obj);
                    if (!type.isArray() || type.getComponentType() == Byte.TYPE) {
                        a(name, obj2, stringBuffer, stringBuffer2);
                    } else {
                        int length2 = obj2 == null ? 0 : Array.getLength(obj2);
                        for (int i2 = 0; i2 < length2; i2++) {
                            a(name, Array.get(obj2, i2), stringBuffer, stringBuffer2);
                        }
                    }
                }
            }
            for (Method method : cls.getMethods()) {
                String name2 = method.getName();
                if (name2.startsWith("set")) {
                    String substring = name2.substring(3);
                    try {
                        if (((Boolean) cls.getMethod("has".concat(String.valueOf(substring)), new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                            try {
                                a(substring, cls.getMethod("get".concat(String.valueOf(substring)), new Class[0]).invoke(obj, new Object[0]), stringBuffer, stringBuffer2);
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
                return;
            }
            return;
        }
        stringBuffer2.append(stringBuffer).append(cq(str)).append(": ");
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (!str2.startsWith("http") && str2.length() > 200) {
                str2 = str2.substring(0, 200) + "[...]";
            }
            stringBuffer2.append("\"").append(escapeString(str2)).append("\"");
        } else if (obj instanceof byte[]) {
            a((byte[]) obj, stringBuffer2);
        } else {
            stringBuffer2.append(obj);
        }
        stringBuffer2.append("\n");
    }

    private static String cq(String str) {
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
        return stringBuffer.toString();
    }

    private static String escapeString(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    private static void a(byte[] bArr, StringBuffer stringBuffer) {
        if (bArr == null) {
            stringBuffer.append("\"\"");
            return;
        }
        stringBuffer.append('\"');
        for (byte b2 : bArr) {
            if (b2 == 92 || b2 == 34) {
                stringBuffer.append('\\').append((char) b2);
            } else if (b2 < 32 || b2 >= Byte.MAX_VALUE) {
                stringBuffer.append(String.format("\\%03o", Integer.valueOf(b2)));
            } else {
                stringBuffer.append((char) b2);
            }
        }
        stringBuffer.append('\"');
    }
}
