package com.bumptech.glide.load.c.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.a.a.b;
import com.bumptech.glide.load.a.a.c;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.d.a.s;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class d implements n<Uri, InputStream> {
    private final Context context;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ boolean X(Uri uri) {
        AppMethodBeat.i(77341);
        Uri uri2 = uri;
        if (!b.f(uri2) || !b.g(uri2)) {
            AppMethodBeat.o(77341);
            return false;
        }
        AppMethodBeat.o(77341);
        return true;
    }

    /* Return type fixed from 'com.bumptech.glide.load.c.n$a' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ n.a<InputStream> b(Uri uri, int i2, int i3, i iVar) {
        boolean z;
        AppMethodBeat.i(77342);
        Uri uri2 = uri;
        if (b.aO(i2, i3)) {
            Long l = (Long) iVar.a(s.aLA);
            if (l == null || l.longValue() != -1) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                com.bumptech.glide.f.b bVar = new com.bumptech.glide.f.b(uri2);
                Context context2 = this.context;
                n.a aVar = new n.a(bVar, c.a(context2, uri2, new c.b(context2.getContentResolver())));
                AppMethodBeat.o(77342);
                return aVar;
            }
        }
        AppMethodBeat.o(77342);
        return null;
    }

    public d(Context context2) {
        AppMethodBeat.i(77340);
        this.context = context2.getApplicationContext();
        AppMethodBeat.o(77340);
    }

    public static class a implements o<Uri, InputStream> {
        private final Context context;

        public a(Context context2) {
            this.context = context2;
        }

        @Override // com.bumptech.glide.load.c.o
        public final n<Uri, InputStream> a(r rVar) {
            AppMethodBeat.i(77339);
            d dVar = new d(this.context);
            AppMethodBeat.o(77339);
            return dVar;
        }
    }
}
