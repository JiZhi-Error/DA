package com.bumptech.glide.load.c.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.a.a.b;
import com.bumptech.glide.load.a.a.c;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class c implements n<Uri, InputStream> {
    private final Context context;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ boolean X(Uri uri) {
        AppMethodBeat.i(77337);
        Uri uri2 = uri;
        if (!b.f(uri2) || b.g(uri2)) {
            AppMethodBeat.o(77337);
            return false;
        }
        AppMethodBeat.o(77337);
        return true;
    }

    /* Return type fixed from 'com.bumptech.glide.load.c.n$a' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ n.a<InputStream> b(Uri uri, int i2, int i3, i iVar) {
        AppMethodBeat.i(77338);
        Uri uri2 = uri;
        if (b.aO(i2, i3)) {
            com.bumptech.glide.f.b bVar = new com.bumptech.glide.f.b(uri2);
            Context context2 = this.context;
            n.a aVar = new n.a(bVar, com.bumptech.glide.load.a.a.c.a(context2, uri2, new c.a(context2.getContentResolver())));
            AppMethodBeat.o(77338);
            return aVar;
        }
        AppMethodBeat.o(77338);
        return null;
    }

    public c(Context context2) {
        AppMethodBeat.i(77336);
        this.context = context2.getApplicationContext();
        AppMethodBeat.o(77336);
    }

    public static class a implements o<Uri, InputStream> {
        private final Context context;

        public a(Context context2) {
            this.context = context2;
        }

        @Override // com.bumptech.glide.load.c.o
        public final n<Uri, InputStream> a(r rVar) {
            AppMethodBeat.i(77335);
            c cVar = new c(this.context);
            AppMethodBeat.o(77335);
            return cVar;
        }
    }
}
