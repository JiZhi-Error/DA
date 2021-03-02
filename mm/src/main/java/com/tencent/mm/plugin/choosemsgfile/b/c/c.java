package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.b.b.l;
import com.tencent.mm.plugin.choosemsgfile.b.b.m;
import java.util.List;

public final class c extends a implements g {
    boolean qor;

    public c(com.tencent.mm.plugin.choosemsgfile.ui.c cVar, List<a> list) {
        super(cVar, list);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.c.a, com.tencent.mm.plugin.choosemsgfile.b.c.g
    public final boolean cyD() {
        return this.qor;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(123307);
        switch (i2) {
            case 0:
                RecyclerView.v o = l.o(viewGroup);
                AppMethodBeat.o(123307);
                return o;
            default:
                RecyclerView.v o2 = m.o(viewGroup);
                AppMethodBeat.o(123307);
                return o2;
        }
    }

    public final int BW(long j2) {
        AppMethodBeat.i(123308);
        int i2 = -1;
        for (a aVar : this.opg) {
            i2++;
            if (aVar.qnv != null && aVar.qnv.field_msgId == j2) {
                AppMethodBeat.o(123308);
                return i2;
            }
        }
        AppMethodBeat.o(123308);
        return -1;
    }
}
