package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class h {
    public static final int JKT = R.layout.bgb;
    public static final int JKU = R.layout.bga;
    public static final int qOn = R.layout.bge;
    public static final int qOo = R.layout.bgd;
    public SparseArray<Integer> JKV = new SparseArray<>();

    public h() {
        AppMethodBeat.i(30862);
        this.JKV.put(1, Integer.valueOf(qOn));
        this.JKV.put(2, Integer.valueOf(qOo));
        this.JKV.put(4, Integer.valueOf(qOo));
        this.JKV.put(3, Integer.valueOf(qOo));
        this.JKV.put(5, Integer.valueOf(qOo));
        this.JKV.put(6, Integer.valueOf(qOo));
        this.JKV.put(0, Integer.valueOf(qOo));
        this.JKV.put(-1, Integer.valueOf(qOo));
        this.JKV.put(-3, Integer.valueOf(JKT));
        this.JKV.put(-2, Integer.valueOf(qOo));
        this.JKV.put(-4, Integer.valueOf(qOo));
        this.JKV.put(20, Integer.valueOf(qOo));
        this.JKV.put(30, Integer.valueOf(JKU));
        AppMethodBeat.o(30862);
    }

    public static a a(int i2, View view, k kVar) {
        AppMethodBeat.i(30863);
        switch (i2) {
            case -4:
                k kVar2 = new k(view, kVar);
                AppMethodBeat.o(30863);
                return kVar2;
            case -3:
                f fVar = new f(view, kVar);
                AppMethodBeat.o(30863);
                return fVar;
            case -2:
                b bVar = new b(view, kVar);
                AppMethodBeat.o(30863);
                return bVar;
            case -1:
                l lVar = new l(view, kVar);
                AppMethodBeat.o(30863);
                return lVar;
            case 0:
                n nVar = new n(view, kVar);
                AppMethodBeat.o(30863);
                return nVar;
            case 1:
                m mVar = new m(view, kVar);
                AppMethodBeat.o(30863);
                return mVar;
            case 2:
                g gVar = new g(view, kVar);
                AppMethodBeat.o(30863);
                return gVar;
            case 3:
                i iVar = new i(view, kVar);
                AppMethodBeat.o(30863);
                return iVar;
            case 4:
                p pVar = new p(view, kVar);
                AppMethodBeat.o(30863);
                return pVar;
            case 5:
                e eVar = new e(view, kVar);
                AppMethodBeat.o(30863);
                return eVar;
            case 6:
                o oVar = new o(view, kVar);
                AppMethodBeat.o(30863);
                return oVar;
            case 20:
                c cVar = new c(view, kVar);
                AppMethodBeat.o(30863);
                return cVar;
            case 30:
                d dVar = new d(view, kVar);
                AppMethodBeat.o(30863);
                return dVar;
            default:
                AppMethodBeat.o(30863);
                return null;
        }
    }
}
