package com.qq.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public final class a {
    public static String d(ArrayList<String> arrayList) {
        AppMethodBeat.i(187098);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str = arrayList.get(i2);
            if (str.equals("java.lang.Integer") || str.equals("int")) {
                str = "int32";
            } else if (str.equals("java.lang.Boolean") || str.equals(DownloadSetting.TYPE_BOOLEAN)) {
                str = "bool";
            } else if (str.equals("java.lang.Byte") || str.equals("byte")) {
                str = "char";
            } else if (str.equals("java.lang.Double") || str.equals("double")) {
                str = "double";
            } else if (str.equals("java.lang.Float") || str.equals("float")) {
                str = "float";
            } else if (str.equals("java.lang.Long") || str.equals("long")) {
                str = "int64";
            } else if (str.equals("java.lang.Short") || str.equals("short")) {
                str = "short";
            } else if (str.equals("java.lang.Character")) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("can not support java.lang.Character");
                AppMethodBeat.o(187098);
                throw illegalArgumentException;
            } else if (str.equals("java.lang.String")) {
                str = "string";
            } else if (str.equals("java.util.List")) {
                str = "list";
            } else if (str.equals("java.util.Map")) {
                str = "map";
            }
            arrayList.set(i2, str);
        }
        Collections.reverse(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str2 = arrayList.get(i3);
            if (str2.equals("list")) {
                arrayList.set(i3 - 1, "<" + arrayList.get(i3 - 1));
                arrayList.set(0, arrayList.get(0) + ">");
            } else if (str2.equals("map")) {
                arrayList.set(i3 - 1, "<" + arrayList.get(i3 - 1) + ",");
                arrayList.set(0, arrayList.get(0) + ">");
            } else if (str2.equals("Array")) {
                arrayList.set(i3 - 1, "<" + arrayList.get(i3 - 1));
                arrayList.set(0, arrayList.get(0) + ">");
            }
        }
        Collections.reverse(arrayList);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(187098);
        return stringBuffer2;
    }
}
