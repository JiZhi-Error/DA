package com.bumptech.glide.load.c.a;

import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.net.URL;

public final class e implements n<URL, InputStream> {
    private final n<g, InputStream> aKH;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.load.c.n
    public final /* bridge */ /* synthetic */ boolean X(URL url) {
        return true;
    }

    /* Return type fixed from 'com.bumptech.glide.load.c.n$a' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ n.a<InputStream> b(URL url, int i2, int i3, i iVar) {
        AppMethodBeat.i(77344);
        n.a<InputStream> b2 = this.aKH.b(new g(url), i2, i3, iVar);
        AppMethodBeat.o(77344);
        return b2;
    }

    public e(n<g, InputStream> nVar) {
        this.aKH = nVar;
    }

    public static class a implements o<URL, InputStream> {
        @Override // com.bumptech.glide.load.c.o
        public final n<URL, InputStream> a(r rVar) {
            AppMethodBeat.i(77343);
            e eVar = new e(rVar.b(g.class, InputStream.class));
            AppMethodBeat.o(77343);
            return eVar;
        }
    }
}
