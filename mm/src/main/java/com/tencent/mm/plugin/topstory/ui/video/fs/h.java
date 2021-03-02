package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.d;

public final class h extends d {
    @Override // com.tencent.mm.plugin.topstory.ui.video.d
    public final void a(b bVar) {
        int i2;
        AppMethodBeat.i(126390);
        RecyclerView recyclerView = bVar.getRecyclerView();
        com.tencent.mm.plugin.topstory.ui.video.h c2 = c(bVar);
        if (c2 instanceof j) {
            j jVar = (j) c2;
            if (jVar != null) {
                i2 = jVar.lR();
            } else {
                i2 = -1;
            }
            if (i2 != bVar.fyH() && bVar.fyF().GnZ) {
                bVar.fyF().stopPlay();
                if (jVar != null) {
                    bVar.fyB().j(jVar.GjH);
                }
            }
            bVar.fyy();
            for (int i3 = 0; i3 < recyclerView.getChildCount(); i3++) {
                View childAt = recyclerView.getChildAt(i3);
                if (childAt.getTag() != null) {
                    j jVar2 = (j) bVar.getRecyclerView().bi(childAt);
                    if (jVar2.lR() == i2) {
                        jVar2.fyx();
                        if (!bVar.fyF().GnZ) {
                            jVar2.GoY.fyV();
                        }
                    } else {
                        jVar2.GoY.fyW();
                    }
                }
            }
            AppMethodBeat.o(126390);
            return;
        }
        AppMethodBeat.o(126390);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.d
    public final void b(b bVar) {
        AppMethodBeat.i(126391);
        com.tencent.mm.plugin.topstory.ui.video.h c2 = c(bVar);
        if (c2 instanceof j) {
            if (!bVar.fyF().GnZ) {
                if (bVar.fyA().isConnected()) {
                    c2.wu(true);
                } else {
                    c2.fzk().fyZ();
                    bVar.fyF().stopPlay();
                }
            }
            c2.fyx();
            bVar.abV(c2.fyz());
            bVar.fyB().fzB();
        }
        AppMethodBeat.o(126391);
    }
}
