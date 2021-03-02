package com.tencent.luggage.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;

public class r {
    private static ConcurrentHashMap<Integer, p> ctR = new ConcurrentHashMap<>();

    static {
        AppMethodBeat.i(140441);
        AppMethodBeat.o(140441);
    }

    private r() {
    }

    public static Integer a(Context context, p pVar) {
        AppMethodBeat.i(140438);
        pVar.setContext(context);
        for (String str : pVar.ctA.keySet()) {
            pVar.getBridge().csL.remove(str);
        }
        pVar.ctA.clear();
        pVar.ctJ = null;
        pVar.ctB = null;
        pVar.ctL = true;
        ctR.put(Integer.valueOf(pVar.hashCode()), pVar);
        Log.i(r.class.getSimpleName(), "stash, holding size: %d", Integer.valueOf(ctR.size()));
        Integer valueOf = Integer.valueOf(pVar.hashCode());
        AppMethodBeat.o(140438);
        return valueOf;
    }

    public static p a(Context context, Integer num) {
        AppMethodBeat.i(140439);
        if (num == null || !ctR.containsKey(num)) {
            AppMethodBeat.o(140439);
            return null;
        }
        p remove = ctR.remove(num);
        remove.setContext(context);
        remove.LF();
        Log.i(r.class.getSimpleName(), "retrieve, holding size: %d", Integer.valueOf(ctR.size()));
        AppMethodBeat.o(140439);
        return remove;
    }

    public static p c(Integer num) {
        AppMethodBeat.i(140440);
        if (num == null || !ctR.containsKey(num)) {
            AppMethodBeat.o(140440);
            return null;
        }
        p remove = ctR.remove(num);
        remove.LF();
        AppMethodBeat.o(140440);
        return remove;
    }

    public static Integer b(Context context, Class<? extends a> cls) {
        AppMethodBeat.i(140437);
        p pVar = new p(context, cls);
        if (!TextUtils.isEmpty(null)) {
            pVar.loadUrl(null);
        }
        ctR.put(Integer.valueOf(pVar.hashCode()), pVar);
        Log.i(r.class.getSimpleName(), "preload, url: %s, holding size: %d", null, Integer.valueOf(ctR.size()));
        Integer valueOf = Integer.valueOf(pVar.hashCode());
        AppMethodBeat.o(140437);
        return valueOf;
    }
}
