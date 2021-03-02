package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v implements g {
    private final f bFS;
    private final g bxs;

    public v(g gVar, f fVar) {
        AppMethodBeat.i(93102);
        this.bxs = (g) a.checkNotNull(gVar);
        this.bFS = (f) a.checkNotNull(fVar);
        AppMethodBeat.o(93102);
    }

    @Override // com.google.android.exoplayer2.h.g
    public final long a(j jVar) {
        AppMethodBeat.i(93103);
        long a2 = this.bxs.a(jVar);
        if (jVar.length == -1 && a2 != -1) {
            jVar = new j(jVar.uri, jVar.bEP, jVar.position, a2, jVar.key, jVar.flags);
        }
        this.bFS.b(jVar);
        AppMethodBeat.o(93103);
        return a2;
    }

    @Override // com.google.android.exoplayer2.h.g
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(93104);
        int read = this.bxs.read(bArr, i2, i3);
        if (read > 0) {
            this.bFS.write(bArr, i2, read);
        }
        AppMethodBeat.o(93104);
        return read;
    }

    @Override // com.google.android.exoplayer2.h.g
    public final Uri getUri() {
        AppMethodBeat.i(93105);
        Uri uri = this.bxs.getUri();
        AppMethodBeat.o(93105);
        return uri;
    }

    @Override // com.google.android.exoplayer2.h.g
    public final void close() {
        AppMethodBeat.i(93106);
        try {
            this.bxs.close();
        } finally {
            this.bFS.close();
            AppMethodBeat.o(93106);
        }
    }
}
