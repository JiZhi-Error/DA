package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.support.v7.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class b extends c.a {
    private List<c> pzI;
    private List<c> pzJ;
    boolean pzK = false;

    public b(List<c> list, List<c> list2) {
        this.pzI = list;
        this.pzJ = list2;
    }

    @Override // android.support.v7.h.c.a
    public final int aB() {
        AppMethodBeat.i(195014);
        if (this.pzI != null) {
            int size = this.pzI.size();
            AppMethodBeat.o(195014);
            return size;
        }
        AppMethodBeat.o(195014);
        return 0;
    }

    @Override // android.support.v7.h.c.a
    public final int aC() {
        AppMethodBeat.i(195015);
        if (this.pzJ != null) {
            int size = this.pzJ.size();
            AppMethodBeat.o(195015);
            return size;
        }
        AppMethodBeat.o(195015);
        return 0;
    }

    @Override // android.support.v7.h.c.a
    public final boolean i(int i2, int i3) {
        AppMethodBeat.i(195016);
        c n = n(this.pzI, i2);
        c n2 = n(this.pzJ, i3);
        if (n == null || n2 == null) {
            AppMethodBeat.o(195016);
            return false;
        }
        boolean isEqual = Util.isEqual(n.KJV, n2.KJV);
        AppMethodBeat.o(195016);
        return isEqual;
    }

    @Override // android.support.v7.h.c.a
    public final boolean j(int i2, int i3) {
        boolean z;
        AppMethodBeat.i(195017);
        c n = n(this.pzI, i2);
        c n2 = n(this.pzJ, i3);
        if (!(n instanceof e) || !(n2 instanceof e)) {
            if (n.pzL == n2.pzL) {
                if (n.iwv == null || !n.iwv.equalsIgnoreCase(n2.iwv)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z && n.oJs == n2.oJs && n.weight == n2.weight) {
                    AppMethodBeat.o(195017);
                    return true;
                }
            }
            AppMethodBeat.o(195017);
            return false;
        } else if (this.pzK) {
            AppMethodBeat.o(195017);
            return false;
        } else {
            AppMethodBeat.o(195017);
            return true;
        }
    }

    private static c n(List<c> list, int i2) {
        AppMethodBeat.i(195018);
        if (i2 < list.size()) {
            c cVar = list.get(i2);
            AppMethodBeat.o(195018);
            return cVar;
        }
        AppMethodBeat.o(195018);
        return null;
    }
}
