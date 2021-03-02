package com.google.b.a.a;

import com.google.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

/* access modifiers changed from: package-private */
public final class f {
    static final f ccs = new f(g.ccw, 0, 0, 0);
    private final g cct;
    final int ccu;
    final int ccv;
    final int mode;

    static {
        AppMethodBeat.i(12368);
        AppMethodBeat.o(12368);
    }

    private f(g gVar, int i2, int i3, int i4) {
        this.cct = gVar;
        this.mode = i2;
        this.ccu = i3;
        this.ccv = i4;
    }

    /* access modifiers changed from: package-private */
    public final f bD(int i2, int i3) {
        g gVar;
        AppMethodBeat.i(12362);
        int i4 = this.ccv;
        g gVar2 = this.cct;
        if (i2 != this.mode) {
            int i5 = d.ccm[this.mode][i2];
            i4 += i5 >> 16;
            gVar = gVar2.bF(65535 & i5, i5 >> 16);
        } else {
            gVar = gVar2;
        }
        int i6 = i2 == 2 ? 4 : 5;
        f fVar = new f(gVar.bF(i3, i6), i2, 0, i6 + i4);
        AppMethodBeat.o(12362);
        return fVar;
    }

    /* access modifiers changed from: package-private */
    public final f bE(int i2, int i3) {
        int i4;
        AppMethodBeat.i(12363);
        g gVar = this.cct;
        if (this.mode == 2) {
            i4 = 4;
        } else {
            i4 = 5;
        }
        f fVar = new f(gVar.bF(d.cco[this.mode][i2], i4).bF(i3, 5), this.mode, 0, i4 + this.ccv + 5);
        AppMethodBeat.o(12363);
        return fVar;
    }

    /* access modifiers changed from: package-private */
    public final f hd(int i2) {
        f fVar;
        AppMethodBeat.i(12364);
        g gVar = this.cct;
        int i3 = this.mode;
        int i4 = this.ccv;
        if (this.mode == 4 || this.mode == 2) {
            int i5 = d.ccm[i3][0];
            gVar = gVar.bF(65535 & i5, i5 >> 16);
            i4 += i5 >> 16;
            i3 = 0;
        }
        f fVar2 = new f(gVar, i3, this.ccu + 1, i4 + ((this.ccu == 0 || this.ccu == 31) ? 18 : this.ccu == 62 ? 9 : 8));
        if (fVar2.ccu == 2078) {
            fVar = fVar2.he(i2 + 1);
        } else {
            fVar = fVar2;
        }
        AppMethodBeat.o(12364);
        return fVar;
    }

    /* access modifiers changed from: package-private */
    public final f he(int i2) {
        AppMethodBeat.i(12365);
        if (this.ccu == 0) {
            AppMethodBeat.o(12365);
            return this;
        }
        f fVar = new f(this.cct.bG(i2 - this.ccu, this.ccu), this.mode, 0, this.ccv);
        AppMethodBeat.o(12365);
        return fVar;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(f fVar) {
        int i2 = this.ccv + (d.ccm[this.mode][fVar.mode] >> 16);
        if (fVar.ccu > 0 && (this.ccu == 0 || this.ccu > fVar.ccu)) {
            i2 += 10;
        }
        return i2 <= fVar.ccv;
    }

    /* access modifiers changed from: package-private */
    public final a J(byte[] bArr) {
        AppMethodBeat.i(12366);
        LinkedList<g> linkedList = new LinkedList();
        for (g gVar = he(bArr.length).cct; gVar != null; gVar = gVar.ccx) {
            linkedList.addFirst(gVar);
        }
        a aVar = new a();
        for (g gVar2 : linkedList) {
            gVar2.a(aVar, bArr);
        }
        AppMethodBeat.o(12366);
        return aVar;
    }

    public final String toString() {
        AppMethodBeat.i(12367);
        String format = String.format("%s bits=%d bytes=%d", d.ccl[this.mode], Integer.valueOf(this.ccv), Integer.valueOf(this.ccu));
        AppMethodBeat.o(12367);
        return format;
    }
}
