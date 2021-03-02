package com.tencent.mm.plugin.topstory.ui.video.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;

public final class d extends com.tencent.mm.plugin.topstory.ui.video.d {
    @Override // com.tencent.mm.plugin.topstory.ui.video.d
    public final void a(b bVar) {
        AppMethodBeat.i(126417);
        RecyclerView recyclerView = bVar.getRecyclerView();
        RecyclerView.v f2 = f(bVar);
        if (f2 instanceof h) {
            h hVar = (h) f2;
            int fyz = hVar != null ? hVar.fyz() : -1;
            if (fyz != bVar.fyH() && bVar.fyF().GnZ) {
                bVar.fyF().stopPlay();
            }
            bVar.fyy();
            for (int i2 = 0; i2 < recyclerView.getChildCount(); i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (childAt.getTag() != null) {
                    h hVar2 = (h) bVar.getRecyclerView().bi(childAt);
                    if (hVar2.fyz() == fyz) {
                        hVar2.fzR();
                        hVar2.fyx();
                        if (!bVar.fyF().GnZ) {
                            hVar2.GpP.fyV();
                        }
                    } else {
                        hVar2.dhM();
                        hVar2.GpP.fyW();
                    }
                }
            }
            AppMethodBeat.o(126417);
            return;
        }
        AppMethodBeat.o(126417);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.d
    public final void b(b bVar) {
        AppMethodBeat.i(126418);
        RecyclerView.v f2 = f(bVar);
        if (f2 instanceof h) {
            h hVar = (h) f2;
            if (!bVar.fyF().GnZ) {
                if (bVar.fyA().isConnected()) {
                    hVar.wu(true);
                } else {
                    hVar.GpP.fyZ();
                    bVar.fyF().stopPlay();
                }
            }
            hVar.fyx();
            bVar.abV(hVar.fyz());
            bVar.fyB().fzB();
            AppMethodBeat.o(126418);
            return;
        }
        AppMethodBeat.o(126418);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.d
    public final void a(b bVar, int i2) {
        AppMethodBeat.i(126419);
        View view = null;
        for (int i3 = 0; i3 < bVar.getRecyclerView().getChildCount(); i3++) {
            view = bVar.getRecyclerView().getChildAt(i3);
            if (RecyclerView.bw(view) == i2) {
                break;
            }
        }
        if (view != null) {
            bVar.getRecyclerView().a(0, bVar.fyG().bo(view) - bVar.fyN(), (Interpolator) null);
        }
        AppMethodBeat.o(126419);
    }

    private static View e(b bVar) {
        AppMethodBeat.i(126420);
        for (int i2 = 0; i2 < bVar.getRecyclerView().getChildCount(); i2++) {
            View childAt = bVar.getRecyclerView().getChildAt(i2);
            RecyclerView.v bi = bVar.getRecyclerView().bi(childAt);
            if (childAt.getTag() != null && childAt.getTag().equals("video") && childAt.getTop() > 0 && bi.lR() >= 0) {
                AppMethodBeat.o(126420);
                return childAt;
            }
        }
        AppMethodBeat.o(126420);
        return null;
    }

    public static RecyclerView.v f(b bVar) {
        AppMethodBeat.i(126421);
        View e2 = e(bVar);
        if (e2 != null) {
            RecyclerView.v bi = bVar.getRecyclerView().bi(e2);
            AppMethodBeat.o(126421);
            return bi;
        }
        AppMethodBeat.o(126421);
        return null;
    }
}
