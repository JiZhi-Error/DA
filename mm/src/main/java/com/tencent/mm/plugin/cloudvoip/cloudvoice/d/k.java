package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;

public final class k {
    final ArrayList<b> qsr = new ArrayList<>(10);
    ArrayList<b> qss = new ArrayList<>(10);
    final ArrayList<a> qst = new ArrayList<>(2);
    Timer qsu;

    /* access modifiers changed from: package-private */
    public interface a {
        void Q(ArrayList<b> arrayList);
    }

    public k() {
        AppMethodBeat.i(90816);
        AppMethodBeat.o(90816);
    }

    /* access modifiers changed from: package-private */
    public final String ET(int i2) {
        AppMethodBeat.i(184466);
        if (this.qsr != null) {
            Iterator<b> it = this.qsr.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && i2 == next.qrD) {
                    String str = next.openId;
                    AppMethodBeat.o(184466);
                    return str;
                }
            }
        }
        AppMethodBeat.o(184466);
        return null;
    }

    static /* synthetic */ boolean a(k kVar, ArrayList arrayList) {
        AppMethodBeat.i(90817);
        if (kVar.qss == null) {
            AppMethodBeat.o(90817);
            return true;
        } else if (arrayList.size() != kVar.qss.size()) {
            AppMethodBeat.o(90817);
            return false;
        } else {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (((b) arrayList.get(i2)).qrD != kVar.qss.get(i2).qrD) {
                    AppMethodBeat.o(90817);
                    return false;
                }
            }
            AppMethodBeat.o(90817);
            return true;
        }
    }
}
