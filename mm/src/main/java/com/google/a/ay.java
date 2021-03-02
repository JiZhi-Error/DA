package com.google.a;

import com.google.a.ab;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* access modifiers changed from: package-private */
public final class ay {
    static void a(aw awVar, StringBuilder sb, int i2) {
        boolean booleanValue;
        boolean z;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        Method[] declaredMethods = awVar.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String replaceFirst = str.replaceFirst("get", "");
            if (replaceFirst.endsWith("List") && !replaceFirst.endsWith("OrBuilderList") && !replaceFirst.equals("List")) {
                String str2 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1, replaceFirst.length() - 4);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    a(sb, i2, ck(str2), ab.a(method2, awVar, new Object[0]));
                }
            }
            if (replaceFirst.endsWith("Map") && !replaceFirst.equals("Map")) {
                String str3 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1, replaceFirst.length() - 3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    a(sb, i2, ck(str3), ab.a(method3, awVar, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set".concat(String.valueOf(replaceFirst)))) != null && (!replaceFirst.endsWith("Bytes") || !hashMap.containsKey("get" + replaceFirst.substring(0, replaceFirst.length() - 5)))) {
                String str4 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1);
                Method method4 = (Method) hashMap.get("get".concat(String.valueOf(replaceFirst)));
                Method method5 = (Method) hashMap.get("has".concat(String.valueOf(replaceFirst)));
                if (method4 != null) {
                    Object a2 = ab.a(method4, awVar, new Object[0]);
                    if (method5 == null) {
                        if (a2 instanceof Boolean) {
                            z = !((Boolean) a2).booleanValue();
                        } else if (a2 instanceof Integer) {
                            z = ((Integer) a2).intValue() == 0;
                        } else if (a2 instanceof Float) {
                            z = ((Float) a2).floatValue() == 0.0f;
                        } else if (a2 instanceof Double) {
                            z = ((Double) a2).doubleValue() == 0.0d;
                        } else if (a2 instanceof String) {
                            z = a2.equals("");
                        } else if (a2 instanceof g) {
                            z = a2.equals(g.bNg);
                        } else if (a2 instanceof aw) {
                            z = a2 == ((aw) a2).AP();
                        } else {
                            z = a2 instanceof Enum ? ((Enum) a2).ordinal() == 0 : false;
                        }
                        booleanValue = !z;
                    } else {
                        booleanValue = ((Boolean) ab.a(method5, awVar, new Object[0])).booleanValue();
                    }
                    if (booleanValue) {
                        a(sb, i2, ck(str4), a2);
                    }
                }
            }
        }
        if (awVar instanceof ab.b) {
            Iterator<Map.Entry<ab.d, Object>> it = ((ab.b) awVar).bWd.iterator();
            while (it.hasNext()) {
                Map.Entry<ab.d, Object> next = it.next();
                a(sb, i2, "[" + next.getKey().number + "]", next.getValue());
            }
        }
        if (((ab) awVar).bVX != null) {
            ((ab) awVar).bVX.a(sb, i2);
        }
    }

    static final void a(StringBuilder sb, int i2, String str, Object obj) {
        int i3 = 0;
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                a(sb, i2, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                a(sb, i2, str, entry);
            }
        } else {
            sb.append('\n');
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"").append(by.e(g.bZ((String) obj))).append('\"');
            } else if (obj instanceof g) {
                sb.append(": \"").append(by.e((g) obj)).append('\"');
            } else if (obj instanceof ab) {
                sb.append(" {");
                a((ab) obj, sb, i2 + 2);
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                a(sb, i2 + 2, "key", entry2.getKey());
                a(sb, i2 + 2, "value", entry2.getValue());
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else {
                sb.append(": ").append(obj.toString());
            }
        }
    }

    private static final String ck(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
