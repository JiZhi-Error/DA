package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.b.b.l;
import com.tencent.mm.plugin.choosemsgfile.b.b.n;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import java.util.List;

public final class d extends a {
    public d(c cVar, List<a> list) {
        super(cVar, list);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(123309);
        switch (i2) {
            case 0:
                RecyclerView.v o = l.o(viewGroup);
                AppMethodBeat.o(123309);
                return o;
            default:
                RecyclerView.v o2 = n.o(viewGroup);
                AppMethodBeat.o(123309);
                return o2;
        }
    }
}
