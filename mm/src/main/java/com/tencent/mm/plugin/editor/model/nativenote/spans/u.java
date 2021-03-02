package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;
import java.util.ArrayList;

public final class u {
    public static final b qTH = new b();
    public static final r qTI = new r();
    public static final c qTJ = new c();
    public static final j qTK = new j();
    public static final i qTL = new i();
    public static final ArrayList<t> qTM;

    static {
        AppMethodBeat.i(181970);
        ArrayList<t> arrayList = new ArrayList<>();
        qTM = arrayList;
        arrayList.add(qTH);
        qTM.add(qTJ);
        qTM.add(qTK);
        qTM.add(qTI);
        AppMethodBeat.o(181970);
    }

    public static void a(WXRTEditText wXRTEditText, t... tVarArr) {
        AppMethodBeat.i(181968);
        a(wXRTEditText, qTL, tVarArr);
        a(wXRTEditText, qTJ, tVarArr);
        a(wXRTEditText, qTK, tVarArr);
        a(wXRTEditText, qTI, tVarArr);
        AppMethodBeat.o(181968);
    }

    private static void a(WXRTEditText wXRTEditText, m mVar, t... tVarArr) {
        AppMethodBeat.i(181969);
        for (t tVar : tVarArr) {
            if (mVar == tVar) {
                AppMethodBeat.o(181969);
                return;
            }
        }
        mVar.a(wXRTEditText, (g) null, (Object) null);
        AppMethodBeat.o(181969);
    }
}
