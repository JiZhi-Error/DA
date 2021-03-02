package com.tencent.mm.plugin.editor.adapter.a;

import android.util.SparseIntArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;

public final class c {
    private static final int qOn = R.layout.a17;
    private static final int qOo = R.layout.a10;
    public SparseIntArray qOp = new SparseIntArray();

    public c() {
        AppMethodBeat.i(181646);
        this.qOp.put(1, qOn);
        this.qOp.put(2, qOo);
        this.qOp.put(4, qOo);
        this.qOp.put(6, qOo);
        this.qOp.put(0, qOo);
        this.qOp.put(-1, qOo);
        AppMethodBeat.o(181646);
    }

    public static a a(int i2, View view, j jVar) {
        AppMethodBeat.i(181647);
        switch (i2) {
            case -1:
                e eVar = new e(view, jVar);
                AppMethodBeat.o(181647);
                return eVar;
            case 0:
                g gVar = new g(view, jVar);
                AppMethodBeat.o(181647);
                return gVar;
            case 1:
                f fVar = new f(view, jVar);
                AppMethodBeat.o(181647);
                return fVar;
            case 2:
                b bVar = new b(view, jVar);
                AppMethodBeat.o(181647);
                return bVar;
            case 3:
            case 5:
            default:
                AppMethodBeat.o(181647);
                return null;
            case 4:
                i iVar = new i(view, jVar);
                AppMethodBeat.o(181647);
                return iVar;
            case 6:
                h hVar = new h(view, jVar);
                AppMethodBeat.o(181647);
                return hVar;
        }
    }
}
