package com.bumptech.glide.load.c;

import android.net.Uri;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class x<Data> implements n<Uri, Data> {
    private static final Set<String> aKC = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    private final n<g, Data> aKE;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ boolean X(Uri uri) {
        AppMethodBeat.i(77324);
        boolean contains = aKC.contains(uri.getScheme());
        AppMethodBeat.o(77324);
        return contains;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ n.a b(Uri uri, int i2, int i3, i iVar) {
        AppMethodBeat.i(77325);
        n.a<Data> b2 = this.aKE.b(new g(uri.toString()), i2, i3, iVar);
        AppMethodBeat.o(77325);
        return b2;
    }

    static {
        AppMethodBeat.i(77326);
        AppMethodBeat.o(77326);
    }

    public x(n<g, Data> nVar) {
        this.aKE = nVar;
    }

    public static class a implements o<Uri, InputStream> {
        @Override // com.bumptech.glide.load.c.o
        public final n<Uri, InputStream> a(r rVar) {
            AppMethodBeat.i(77323);
            x xVar = new x(rVar.b(g.class, InputStream.class));
            AppMethodBeat.o(77323);
            return xVar;
        }
    }
}
