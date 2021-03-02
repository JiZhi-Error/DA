package com.google.android.exoplayer2.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.DataInputStream;
import java.util.TreeSet;

/* access modifiers changed from: package-private */
public final class i {
    final TreeSet<m> bGu;
    public final int id;
    public final String key;
    long length;

    public i(DataInputStream dataInputStream) {
        this(dataInputStream.readInt(), dataInputStream.readUTF(), dataInputStream.readLong());
        AppMethodBeat.i(92976);
        AppMethodBeat.o(92976);
    }

    public i(int i2, String str, long j2) {
        AppMethodBeat.i(92977);
        this.id = i2;
        this.key = str;
        this.length = j2;
        this.bGu = new TreeSet<>();
        AppMethodBeat.o(92977);
    }

    public final void a(m mVar) {
        AppMethodBeat.i(92978);
        this.bGu.add(mVar);
        AppMethodBeat.o(92978);
    }

    public final m am(long j2) {
        AppMethodBeat.i(92979);
        m k = m.k(this.key, j2);
        m floor = this.bGu.floor(k);
        if (floor == null || floor.position + floor.length <= j2) {
            m ceiling = this.bGu.ceiling(k);
            if (ceiling == null) {
                m l = m.l(this.key, j2);
                AppMethodBeat.o(92979);
                return l;
            }
            m g2 = m.g(this.key, j2, ceiling.position - j2);
            AppMethodBeat.o(92979);
            return g2;
        }
        AppMethodBeat.o(92979);
        return floor;
    }

    public final int wT() {
        AppMethodBeat.i(92980);
        int hashCode = (((this.id * 31) + this.key.hashCode()) * 31) + ((int) (this.length ^ (this.length >>> 32)));
        AppMethodBeat.o(92980);
        return hashCode;
    }
}
