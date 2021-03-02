package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.Util;

/* access modifiers changed from: package-private */
public final class f {
    private int afB = -1;
    private d xqr;

    public f(d dVar) {
        this.xqr = dVar;
    }

    private void NU(int i2) {
        AppMethodBeat.i(111557);
        d dVar = this.xqr;
        if (dVar.xno == null || dVar.xno.size() <= i2 || i2 < 0) {
            AppMethodBeat.o(111557);
            return;
        }
        long j2 = dVar.xno.get(i2).xiZ;
        String str = dVar.xno.get(i2).sUB;
        String str2 = dVar.xno.get(i2).xiW;
        if (Util.isNullOrNil(str)) {
            str = str2;
        }
        e.dQJ().a(str, dVar.xno.get(i2).getType(), str2, j2, dVar.xno.get(i2).xja);
        AppMethodBeat.o(111557);
    }

    public final void onPageSelected(int i2) {
        AppMethodBeat.i(111558);
        if (this.afB == -1) {
            int i3 = 0;
            while (true) {
                if (i3 != 0) {
                    if (i2 + i3 > i2 + 3 && i2 - i3 < Math.max(i2 - 3, 0)) {
                        break;
                    }
                    if (i2 + i3 <= i2 + 3) {
                        NU(i2 + i3);
                    }
                    if (i2 - i3 >= Math.max(i2 - 3, 0)) {
                        NU(i2 - i3);
                    }
                } else {
                    NU(i2);
                }
                i3++;
            }
        } else if (this.afB > i2) {
            NU(Math.max(i2 - 3, 0));
        } else if (this.afB < i2) {
            NU(i2 + 3);
        }
        this.afB = i2;
        AppMethodBeat.o(111558);
    }
}
