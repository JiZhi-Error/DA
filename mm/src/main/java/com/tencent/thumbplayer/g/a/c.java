package com.tencent.thumbplayer.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class c implements b {
    private ArrayList<a> SbP = new ArrayList<>();

    public c() {
        AppMethodBeat.i(189518);
        AppMethodBeat.o(189518);
    }

    @Override // com.tencent.thumbplayer.g.a.b
    public final b a(a aVar) {
        AppMethodBeat.i(189519);
        if (this.SbP == null) {
            this.SbP = new ArrayList<>();
        }
        if (!this.SbP.contains(aVar)) {
            aVar.aSs();
            this.SbP.add(aVar);
        }
        AppMethodBeat.o(189519);
        return this;
    }

    @Override // com.tencent.thumbplayer.g.a.a
    public final void aSs() {
    }

    @Override // com.tencent.thumbplayer.g.a.a
    public final void onDetach() {
    }

    @Override // com.tencent.thumbplayer.g.a.a
    public final void b(int i2, int i3, int i4, String str, Object obj) {
        AppMethodBeat.i(189520);
        if (this.SbP != null) {
            Iterator<a> it = this.SbP.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.b(i2, i3, i4, str, obj);
                }
            }
        }
        AppMethodBeat.o(189520);
    }

    @Override // com.tencent.thumbplayer.g.a.b
    public final void release() {
        AppMethodBeat.i(189521);
        if (this.SbP != null) {
            Iterator<a> it = this.SbP.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onDetach();
                }
                it.remove();
            }
        }
        this.SbP = null;
        AppMethodBeat.o(189521);
    }
}
