package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;

public final class j {
    private static LinkedList<s> IUb = new LinkedList<>();
    private static HashMap<String, s> IUc = new HashMap<>();
    private static Object lock = new Object();

    static {
        AppMethodBeat.i(78357);
        AppMethodBeat.o(78357);
    }

    public static void b(s sVar) {
        AppMethodBeat.i(78355);
        synchronized (lock) {
            try {
                if (!IUb.contains(sVar)) {
                    IUb.add(sVar);
                    IUc.put(d(sVar), sVar);
                }
            } finally {
                AppMethodBeat.o(78355);
            }
        }
    }

    public static void c(s sVar) {
        AppMethodBeat.i(78356);
        synchronized (lock) {
            try {
                IUb.remove(sVar);
                IUc.remove(d(sVar));
            } finally {
                AppMethodBeat.o(78356);
            }
        }
    }

    public static s aYs(String str) {
        AppMethodBeat.i(210917);
        s sVar = IUc.get(str);
        AppMethodBeat.o(210917);
        return sVar;
    }

    public static LinkedList<s> gbV() {
        LinkedList<s> linkedList;
        AppMethodBeat.i(210918);
        synchronized (lock) {
            try {
                linkedList = new LinkedList<>(IUb);
            } finally {
                AppMethodBeat.o(210918);
            }
        }
        return linkedList;
    }

    public static String d(s sVar) {
        AppMethodBeat.i(210919);
        String str = "luggage_page_" + sVar.hashCode();
        AppMethodBeat.o(210919);
        return str;
    }
}
