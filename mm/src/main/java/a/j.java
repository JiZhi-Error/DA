package a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class j {
    h<?> aCe;

    public j(h<?> hVar) {
        this.aCe = hVar;
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(53011);
        try {
            h<?> hVar = this.aCe;
            if (!(hVar == null || h.nG() == null)) {
                new k(hVar.getError());
            }
        } finally {
            super.finalize();
            AppMethodBeat.o(53011);
        }
    }
}
