package com.google.android.exoplayer2.h;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;

public final class m implements g {
    private final w<? super g> bEI;
    private final g bFk;
    private g bFl;
    private g bFm;
    private g bFn;
    private g bFo;
    private g bhK;
    private final Context context;

    public m(Context context2, w<? super g> wVar, g gVar) {
        AppMethodBeat.i(93059);
        this.context = context2.getApplicationContext();
        this.bEI = wVar;
        this.bFk = (g) a.checkNotNull(gVar);
        AppMethodBeat.o(93059);
    }

    @Override // com.google.android.exoplayer2.h.g
    public final long a(j jVar) {
        AppMethodBeat.i(93060);
        a.checkState(this.bhK == null);
        String scheme = jVar.uri.getScheme();
        if (x.o(jVar.uri)) {
            if (jVar.uri.getPath().startsWith("/android_asset/")) {
                this.bhK = wJ();
            } else {
                if (this.bFl == null) {
                    this.bFl = new q(this.bEI);
                }
                this.bhK = this.bFl;
            }
        } else if ("asset".equals(scheme)) {
            this.bhK = wJ();
        } else if ("content".equals(scheme)) {
            if (this.bFn == null) {
                this.bFn = new e(this.context, this.bEI);
            }
            this.bhK = this.bFn;
        } else if ("rtmp".equals(scheme)) {
            this.bhK = wK();
        } else {
            this.bhK = this.bFk;
        }
        long a2 = this.bhK.a(jVar);
        AppMethodBeat.o(93060);
        return a2;
    }

    @Override // com.google.android.exoplayer2.h.g
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(93061);
        int read = this.bhK.read(bArr, i2, i3);
        AppMethodBeat.o(93061);
        return read;
    }

    @Override // com.google.android.exoplayer2.h.g
    public final Uri getUri() {
        AppMethodBeat.i(93062);
        if (this.bhK == null) {
            AppMethodBeat.o(93062);
            return null;
        }
        Uri uri = this.bhK.getUri();
        AppMethodBeat.o(93062);
        return uri;
    }

    @Override // com.google.android.exoplayer2.h.g
    public final void close() {
        AppMethodBeat.i(93063);
        if (this.bhK != null) {
            try {
                this.bhK.close();
            } finally {
                this.bhK = null;
                AppMethodBeat.o(93063);
            }
        } else {
            AppMethodBeat.o(93063);
        }
    }

    private g wJ() {
        AppMethodBeat.i(93064);
        if (this.bFm == null) {
            this.bFm = new c(this.context, this.bEI);
        }
        g gVar = this.bFm;
        AppMethodBeat.o(93064);
        return gVar;
    }

    private g wK() {
        AppMethodBeat.i(93065);
        if (this.bFo == null) {
            try {
                this.bFo = (g) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            }
            if (this.bFo == null) {
                this.bFo = this.bFk;
            }
        }
        g gVar = this.bFo;
        AppMethodBeat.o(93065);
        return gVar;
    }
}
