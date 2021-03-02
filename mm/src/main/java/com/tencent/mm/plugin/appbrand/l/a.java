package com.tencent.mm.plugin.appbrand.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedList;

/* access modifiers changed from: package-private */
public final class a {
    static final String[] lvD;

    static {
        AppMethodBeat.i(138799);
        LinkedList linkedList = new LinkedList();
        Field[] declaredFields = android.support.e.a.class.getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                if (Modifier.isFinal(field.getModifiers()) && Modifier.isStatic(field.getModifiers()) && field.getName().startsWith("TAG_")) {
                    linkedList.add((String) field.get(null));
                }
            } catch (Exception e2) {
            }
        }
        lvD = (String[]) linkedList.toArray(new String[linkedList.size()]);
        AppMethodBeat.o(138799);
    }

    static void a(android.support.e.a aVar, android.support.e.a aVar2) {
        AppMethodBeat.i(138798);
        String[] strArr = lvD;
        for (String str : strArr) {
            String attribute = aVar.getAttribute(str);
            if (attribute != null) {
                aVar2.setAttribute(str, attribute);
            }
        }
        aVar2.saveAttributes();
        AppMethodBeat.o(138798);
    }
}
