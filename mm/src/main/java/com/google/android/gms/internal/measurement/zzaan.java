package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzzq;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

final class zzaan {
    static String zza(zzaal zzaal, String str) {
        AppMethodBeat.i(40130);
        StringBuilder sb = new StringBuilder();
        sb.append("# ").append(str);
        zza(zzaal, sb, 0);
        String sb2 = sb.toString();
        AppMethodBeat.o(40130);
        return sb2;
    }

    private static void zza(zzaal zzaal, StringBuilder sb, int i2) {
        AppMethodBeat.i(40131);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        Method[] declaredMethods = zzaal.getClass().getDeclaredMethods();
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
                String valueOf = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i2, zzfk(concat), zzzq.zza(method2, zzaal, new Object[0]));
                }
            }
            if (replaceFirst.endsWith("Map") && !replaceFirst.equals("Map")) {
                String valueOf3 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 3));
                String concat2 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i2, zzfk(concat2), zzzq.zza(method3, zzaal, new Object[0]));
                }
            }
            String valueOf5 = String.valueOf(replaceFirst);
            if (((Method) hashMap2.get(valueOf5.length() != 0 ? "set".concat(valueOf5) : new String("set"))) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    String valueOf6 = String.valueOf(replaceFirst.substring(0, replaceFirst.length() - 5));
                    if (hashMap.containsKey(valueOf6.length() != 0 ? "get".concat(valueOf6) : new String("get"))) {
                    }
                }
                String valueOf7 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf8 = String.valueOf(replaceFirst.substring(1));
                String concat3 = valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7);
                String valueOf9 = String.valueOf(replaceFirst);
                Method method4 = (Method) hashMap.get(valueOf9.length() != 0 ? "get".concat(valueOf9) : new String("get"));
                String valueOf10 = String.valueOf(replaceFirst);
                Method method5 = (Method) hashMap.get(valueOf10.length() != 0 ? "has".concat(valueOf10) : new String("has"));
                if (method4 != null) {
                    Object zza = zzzq.zza(method4, zzaal, new Object[0]);
                    if (method5 == null ? !(zza instanceof Boolean ? !((Boolean) zza).booleanValue() : zza instanceof Integer ? ((Integer) zza).intValue() == 0 : zza instanceof Float ? (((Float) zza).floatValue() > 0.0f ? 1 : (((Float) zza).floatValue() == 0.0f ? 0 : -1)) == 0 : zza instanceof Double ? (((Double) zza).doubleValue() > 0.0d ? 1 : (((Double) zza).doubleValue() == 0.0d ? 0 : -1)) == 0 : zza instanceof String ? zza.equals("") : zza instanceof zzyw ? zza.equals(zzyw.zzbqx) : zza instanceof zzaal ? zza == ((zzaal) zza).zztz() : zza instanceof Enum ? ((Enum) zza).ordinal() == 0 : false) : ((Boolean) zzzq.zza(method5, zzaal, new Object[0])).booleanValue()) {
                        zzb(sb, i2, zzfk(concat3), zza);
                    }
                }
            }
        }
        if (zzaal instanceof zzzq.zza) {
            Iterator<Map.Entry<Object, Object>> it = ((zzzq.zza) zzaal).zzbsb.iterator();
            if (it.hasNext()) {
                it.next().getKey();
                NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
                AppMethodBeat.o(40131);
                throw noSuchMethodError;
            }
        }
        AppMethodBeat.o(40131);
    }

    static final void zzb(StringBuilder sb, int i2, String str, Object obj) {
        int i3 = 0;
        AppMethodBeat.i(40132);
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                zzb(sb, i2, str, obj2);
            }
            AppMethodBeat.o(40132);
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                zzb(sb, i2, str, entry);
            }
            AppMethodBeat.o(40132);
        } else {
            sb.append('\n');
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"").append(zzabg.zza(zzyw.zzfi((String) obj))).append('\"');
                AppMethodBeat.o(40132);
            } else if (obj instanceof zzyw) {
                sb.append(": \"").append(zzabg.zza((zzyw) obj)).append('\"');
                AppMethodBeat.o(40132);
            } else if (obj instanceof zzzq) {
                sb.append(" {");
                zza((zzzq) obj, sb, i2 + 2);
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
                AppMethodBeat.o(40132);
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                zzb(sb, i2 + 2, "key", entry2.getKey());
                zzb(sb, i2 + 2, "value", entry2.getValue());
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
                AppMethodBeat.o(40132);
            } else {
                sb.append(": ").append(obj.toString());
                AppMethodBeat.o(40132);
            }
        }
    }

    private static final String zzfk(String str) {
        AppMethodBeat.i(40133);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(40133);
        return sb2;
    }
}
