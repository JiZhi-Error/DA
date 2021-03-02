package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.d;
import com.tencent.mm.plugin.topstory.ui.video.h;

public final class c extends d {
    @Override // com.tencent.mm.plugin.topstory.ui.video.d
    public final void a(b bVar) {
        int i2;
        AppMethodBeat.i(126245);
        RecyclerView recyclerView = bVar.getRecyclerView();
        h c2 = c(bVar);
        if (c2 instanceof g) {
            g gVar = (g) c2;
            if (gVar != null) {
                i2 = gVar.lR();
            } else {
                i2 = -1;
            }
            if (i2 != bVar.fyH() && bVar.fyF().GnZ) {
                bVar.fyF().stopPlay();
                if (gVar != null) {
                    bVar.fyB().j(gVar.GjH);
                }
            }
            bVar.fyy();
            for (int i3 = 0; i3 < recyclerView.getChildCount(); i3++) {
                View childAt = recyclerView.getChildAt(i3);
                if (childAt.getTag() != null) {
                    g gVar2 = (g) bVar.getRecyclerView().bi(childAt);
                    if (gVar2.lR() == i2) {
                        gVar2.fyx();
                        if (!bVar.fyF().GnZ) {
                            gVar2.GoY.fyV();
                        }
                    } else {
                        gVar2.GoY.fyW();
                    }
                }
            }
            AppMethodBeat.o(126245);
            return;
        }
        AppMethodBeat.o(126245);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.d
    public final void b(b bVar) {
        AppMethodBeat.i(126246);
        h c2 = c(bVar);
        if (c2 != null && (c2 instanceof g)) {
            if (!bVar.fyF().GnZ) {
                if (bVar.fyA().isConnected()) {
                    bVar.a(c2.GjH);
                    c2.wu(true);
                } else {
                    c2.fzk().fyZ();
                    bVar.fyF().stopPlay();
                }
            }
            c2.fyx();
            bVar.abV(c2.fyz());
        }
        bVar.fyB().fzB();
        AppMethodBeat.o(126246);
    }
}
