package com.tencent.toybrick.a;

import android.support.v7.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.g;
import java.util.List;

public final class a extends c.a {
    private List<g> pzI;
    private List<g> pzJ;

    public a(List<g> list, List<g> list2) {
        this.pzI = list;
        this.pzJ = list2;
    }

    @Override // android.support.v7.h.c.a
    public final int aB() {
        AppMethodBeat.i(159912);
        if (this.pzI == null) {
            AppMethodBeat.o(159912);
            return 0;
        }
        int size = this.pzI.size();
        AppMethodBeat.o(159912);
        return size;
    }

    @Override // android.support.v7.h.c.a
    public final int aC() {
        AppMethodBeat.i(159913);
        if (this.pzJ == null) {
            AppMethodBeat.o(159913);
            return 0;
        }
        int size = this.pzJ.size();
        AppMethodBeat.o(159913);
        return size;
    }

    @Override // android.support.v7.h.c.a
    public final boolean i(int i2, int i3) {
        AppMethodBeat.i(159914);
        g gVar = this.pzI.get(i2);
        g gVar2 = this.pzJ.get(i3);
        if (gVar == null || gVar2 == null) {
            AppMethodBeat.o(159914);
            return false;
        } else if (gVar.hashCode() == gVar2.hashCode()) {
            AppMethodBeat.o(159914);
            return true;
        } else {
            AppMethodBeat.o(159914);
            return false;
        }
    }

    @Override // android.support.v7.h.c.a
    public final boolean j(int i2, int i3) {
        AppMethodBeat.i(159915);
        g gVar = this.pzI.get(i2);
        g gVar2 = this.pzJ.get(i3);
        if (gVar == null || gVar2 == null) {
            AppMethodBeat.o(159915);
            return false;
        }
        boolean equals = gVar.equals(gVar2);
        AppMethodBeat.o(159915);
        return equals;
    }
}
