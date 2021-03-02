package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;

public final class u {
    public static final b JJh = new b();
    public static final j JJi = new j();
    public static final c JJj = new c();
    public static final l JJk = new l();
    public static final h JJl = new h();
    public static final ArrayList<t> qTM;

    static {
        AppMethodBeat.i(30669);
        ArrayList<t> arrayList = new ArrayList<>();
        qTM = arrayList;
        arrayList.add(JJh);
        qTM.add(JJj);
        qTM.add(JJk);
        qTM.add(JJi);
        AppMethodBeat.o(30669);
    }

    public static void a(WXRTEditText wXRTEditText, t... tVarArr) {
        AppMethodBeat.i(30667);
        a(wXRTEditText, JJl, tVarArr);
        a(wXRTEditText, JJj, tVarArr);
        a(wXRTEditText, JJk, tVarArr);
        a(wXRTEditText, JJi, tVarArr);
        AppMethodBeat.o(30667);
    }

    private static void a(WXRTEditText wXRTEditText, o oVar, t... tVarArr) {
        AppMethodBeat.i(30668);
        for (t tVar : tVarArr) {
            if (oVar == tVar) {
                AppMethodBeat.o(30668);
                return;
            }
        }
        oVar.a(wXRTEditText, (e) null, (Object) null);
        AppMethodBeat.o(30668);
    }
}
