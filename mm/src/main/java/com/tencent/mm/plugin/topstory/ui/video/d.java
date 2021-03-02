package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d {
    public void a(b bVar) {
    }

    public void b(b bVar) {
    }

    public void a(b bVar, int i2) {
    }

    public static final h c(b bVar) {
        int end;
        RecyclerView.v bi;
        AppMethodBeat.i(126068);
        int childCount = bVar.getLayoutManager().getChildCount();
        if (childCount == 0) {
            bi = null;
        } else {
            if (bVar.getLayoutManager().getClipToPadding()) {
                end = bVar.fyG().kH() + (bVar.fyG().kJ() / 2);
            } else {
                end = bVar.fyG().getEnd() / 2;
            }
            int i2 = Integer.MAX_VALUE;
            int i3 = 0;
            View view = null;
            while (i3 < childCount) {
                View childAt = bVar.getLayoutManager().getChildAt(i3);
                int abs = Math.abs((bVar.fyG().bo(childAt) + (bVar.fyG().bs(childAt) / 2)) - end);
                if (abs >= i2) {
                    abs = i2;
                    childAt = view;
                }
                i3++;
                i2 = abs;
                view = childAt;
            }
            bi = bVar.getRecyclerView().bi(view);
        }
        if (!(bi instanceof h)) {
            AppMethodBeat.o(126068);
            return null;
        }
        h hVar = (h) bi;
        AppMethodBeat.o(126068);
        return hVar;
    }
}
