package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class f {
    private static f duq;
    public volatile HashMap<String, d> cache = new HashMap<>();
    public volatile LinkedList<String> duo = new LinkedList<>();
    public volatile Object dup = new Object();

    private f() {
        AppMethodBeat.i(136740);
        AppMethodBeat.o(136740);
    }

    public static f YL() {
        AppMethodBeat.i(136741);
        if (duq == null) {
            synchronized (f.class) {
                try {
                    if (duq == null) {
                        duq = new f();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(136741);
                    throw th;
                }
            }
        }
        f fVar = duq;
        AppMethodBeat.o(136741);
        return fVar;
    }

    public final d gE(String str) {
        d dVar;
        AppMethodBeat.i(136742);
        synchronized (this.dup) {
            try {
                if (!this.duo.contains(str)) {
                    this.duo.add(str);
                }
                dVar = this.cache.get(str);
                if (dVar == null) {
                    dVar = new d(str);
                    this.cache.put(str, dVar);
                }
            } finally {
                AppMethodBeat.o(136742);
            }
        }
        return dVar;
    }

    public final int gF(String str) {
        AppMethodBeat.i(136743);
        synchronized (this.dup) {
            try {
                if (!this.duo.contains(str)) {
                    return 0;
                }
                d dVar = this.cache.get(str);
                if (dVar != null) {
                    int size = dVar.size();
                    AppMethodBeat.o(136743);
                    return size;
                }
                AppMethodBeat.o(136743);
                return 0;
            } finally {
                AppMethodBeat.o(136743);
            }
        }
    }

    public final boolean gG(String str) {
        AppMethodBeat.i(136744);
        synchronized (this.dup) {
            try {
                if (!this.duo.contains(str)) {
                    return false;
                }
                d dVar = this.cache.get(str);
                if (dVar == null || dVar.size() <= 0 || !dVar.aBQ) {
                    AppMethodBeat.o(136744);
                    return false;
                }
                AppMethodBeat.o(136744);
                return true;
            } finally {
                AppMethodBeat.o(136744);
            }
        }
    }

    public final long gH(String str) {
        AppMethodBeat.i(136746);
        synchronized (this.dup) {
            try {
                if (!this.duo.contains(str)) {
                    return 0;
                }
                d dVar = this.cache.get(str);
                if (dVar == null || !dVar.aBQ) {
                    AppMethodBeat.o(136746);
                    return 0;
                }
                long bufferSize = dVar.getBufferSize();
                AppMethodBeat.o(136746);
                return bufferSize;
            } finally {
                AppMethodBeat.o(136746);
            }
        }
    }

    public final long YM() {
        long j2;
        AppMethodBeat.i(136747);
        long j3 = 0;
        synchronized (this.dup) {
            try {
                Iterator<String> it = this.duo.iterator();
                while (it.hasNext()) {
                    d dVar = this.cache.get(it.next());
                    if (dVar == null || !dVar.aBQ || dVar.dtV) {
                        j2 = j3;
                    } else {
                        j2 = dVar.getBufferSize() + j3;
                    }
                    j3 = j2;
                }
            } finally {
                AppMethodBeat.o(136747);
            }
        }
        return j3;
    }

    public final ArrayList<String> YN() {
        ArrayList<String> arrayList;
        AppMethodBeat.i(136748);
        synchronized (this.dup) {
            try {
                arrayList = new ArrayList<>();
                arrayList.addAll(this.duo);
            } finally {
                AppMethodBeat.o(136748);
            }
        }
        return arrayList;
    }

    public final void clearCache() {
        AppMethodBeat.i(136745);
        synchronized (this.dup) {
            try {
                Iterator<String> it = this.duo.iterator();
                while (it.hasNext()) {
                    d dVar = this.cache.get(it.next());
                    if (dVar != null) {
                        dVar.reset();
                    }
                }
                this.duo.clear();
                this.cache.clear();
            } finally {
                AppMethodBeat.o(136745);
            }
        }
    }
}
