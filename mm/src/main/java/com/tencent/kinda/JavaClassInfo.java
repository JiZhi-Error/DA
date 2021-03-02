package com.tencent.kinda;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class JavaClassInfo {
    public static String TAG = "JavaClassInfo";

    public static String getClassName(Object obj) {
        AppMethodBeat.i(135630);
        if (obj == null) {
            AppMethodBeat.o(135630);
            return "";
        }
        String str = "simple " + obj.toString();
        AppMethodBeat.o(135630);
        return str;
    }

    public static String getFullClassName(Object obj) {
        AppMethodBeat.i(135631);
        if (obj == null) {
            AppMethodBeat.o(135631);
            return "";
        }
        String obj2 = obj.toString();
        AppMethodBeat.o(135631);
        return obj2;
    }
}
