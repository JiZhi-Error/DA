package com.bumptech.glide.load.b;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.f;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;

final class c implements d.a<Object>, f {
    private final List<g> aFK;
    private final g<?> aFL;
    private final f.a aFM;
    private int aFN;
    private g aFO;
    private List<n<File, ?>> aFP;
    private int aFQ;
    private volatile n.a<?> aFR;
    private File aFS;

    c(g<?> gVar, f.a aVar) {
        this(gVar.oB(), gVar, aVar);
        AppMethodBeat.i(76921);
        AppMethodBeat.o(76921);
    }

    c(List<g> list, g<?> gVar, f.a aVar) {
        this.aFN = -1;
        this.aFK = list;
        this.aFL = gVar;
        this.aFM = aVar;
    }

    @Override // com.bumptech.glide.load.b.f
    public final boolean ow() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(76922);
        while (true) {
            if (this.aFP == null || !ox()) {
                this.aFN++;
                if (this.aFN >= this.aFK.size()) {
                    AppMethodBeat.o(76922);
                    break;
                }
                g gVar = this.aFK.get(this.aFN);
                this.aFS = this.aFL.oz().c(new d(gVar, this.aFL.aFT));
                if (this.aFS != null) {
                    this.aFO = gVar;
                    this.aFP = this.aFL.t(this.aFS);
                    this.aFQ = 0;
                }
            } else {
                this.aFR = null;
                while (!z2 && ox()) {
                    List<n<File, ?>> list = this.aFP;
                    int i2 = this.aFQ;
                    this.aFQ = i2 + 1;
                    this.aFR = list.get(i2).b(this.aFS, this.aFL.width, this.aFL.height, this.aFL.aFV);
                    if (this.aFR == null || !this.aFL.l(this.aFR.aKh.os())) {
                        z = z2;
                    } else {
                        z = true;
                        this.aFR.aKh.a(this.aFL.aGc, this);
                    }
                    z2 = z;
                }
                AppMethodBeat.o(76922);
            }
        }
        return z2;
    }

    private boolean ox() {
        AppMethodBeat.i(76923);
        if (this.aFQ < this.aFP.size()) {
            AppMethodBeat.o(76923);
            return true;
        }
        AppMethodBeat.o(76923);
        return false;
    }

    @Override // com.bumptech.glide.load.b.f
    public final void cancel() {
        AppMethodBeat.i(76924);
        n.a<?> aVar = this.aFR;
        if (aVar != null) {
            aVar.aKh.cancel();
        }
        AppMethodBeat.o(76924);
    }

    @Override // com.bumptech.glide.load.a.d.a
    public final void S(Object obj) {
        AppMethodBeat.i(76925);
        this.aFM.a(this.aFO, obj, this.aFR.aKh, a.DATA_DISK_CACHE, this.aFO);
        AppMethodBeat.o(76925);
    }

    @Override // com.bumptech.glide.load.a.d.a
    public final void e(Exception exc) {
        AppMethodBeat.i(76926);
        this.aFM.a(this.aFO, exc, this.aFR.aKh, a.DATA_DISK_CACHE);
        AppMethodBeat.o(76926);
    }
}
