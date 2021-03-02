package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.g;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* access modifiers changed from: package-private */
public final class h implements g.d {
    static final h Rco = new h();
    private final LinkedHashSet<g.d> Rcp = new LinkedHashSet<>();

    static {
        AppMethodBeat.i(197233);
        AppMethodBeat.o(197233);
    }

    private h() {
        AppMethodBeat.i(197229);
        AppMethodBeat.o(197229);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(g.d dVar) {
        AppMethodBeat.i(197230);
        if (dVar != null) {
            this.Rcp.add(dVar);
        }
        AppMethodBeat.o(197230);
    }

    @Override // com.tencent.mm.vfs.g.d
    public final void hdV() {
        AppMethodBeat.i(197231);
        synchronized (this) {
            try {
                Iterator<g.d> it = this.Rcp.iterator();
                while (it.hasNext()) {
                    it.next().hdV();
                }
            } finally {
                AppMethodBeat.o(197231);
            }
        }
    }

    @Override // com.tencent.mm.vfs.g.d
    public final void bh(boolean z, boolean z2) {
        AppMethodBeat.i(197232);
        synchronized (this) {
            try {
                Iterator<g.d> it = this.Rcp.iterator();
                while (it.hasNext()) {
                    it.next().bh(z, z2);
                }
            } finally {
                AppMethodBeat.o(197232);
            }
        }
    }
}
