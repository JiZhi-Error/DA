package com.bumptech.glide.load.c.a;

import android.net.Uri;
import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class b implements n<Uri, InputStream> {
    private static final Set<String> aKC = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    private final n<g, InputStream> aKE;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ boolean X(Uri uri) {
        AppMethodBeat.i(77332);
        boolean contains = aKC.contains(uri.getScheme());
        AppMethodBeat.o(77332);
        return contains;
    }

    /* Return type fixed from 'com.bumptech.glide.load.c.n$a' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ n.a<InputStream> b(Uri uri, int i2, int i3, i iVar) {
        AppMethodBeat.i(77333);
        n.a<InputStream> b2 = this.aKE.b(new g(uri.toString()), i2, i3, iVar);
        AppMethodBeat.o(77333);
        return b2;
    }

    static {
        AppMethodBeat.i(77334);
        AppMethodBeat.o(77334);
    }

    public b(n<g, InputStream> nVar) {
        this.aKE = nVar;
    }

    public static class a implements o<Uri, InputStream> {
        @Override // com.bumptech.glide.load.c.o
        public final n<Uri, InputStream> a(r rVar) {
            AppMethodBeat.i(77331);
            b bVar = new b(rVar.b(g.class, InputStream.class));
            AppMethodBeat.o(77331);
            return bVar;
        }
    }
}
