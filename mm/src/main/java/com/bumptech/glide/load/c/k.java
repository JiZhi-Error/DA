package com.bumptech.glide.load.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.g;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;

public final class k implements n<Uri, File> {
    private final Context context;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ boolean X(Uri uri) {
        AppMethodBeat.i(77257);
        boolean f2 = com.bumptech.glide.load.a.a.b.f(uri);
        AppMethodBeat.o(77257);
        return f2;
    }

    /* Return type fixed from 'com.bumptech.glide.load.c.n$a' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ n.a<File> b(Uri uri, int i2, int i3, i iVar) {
        AppMethodBeat.i(77258);
        Uri uri2 = uri;
        n.a aVar = new n.a(new com.bumptech.glide.f.b(uri2), new b(this.context, uri2));
        AppMethodBeat.o(77258);
        return aVar;
    }

    public k(Context context2) {
        this.context = context2;
    }

    static class b implements d<File> {
        private static final String[] PROJECTION = {"_data"};
        private final Context context;
        private final Uri uri;

        b(Context context2, Uri uri2) {
            this.context = context2;
            this.uri = uri2;
        }

        @Override // com.bumptech.glide.load.a.d
        public final void a(g gVar, d.a<? super File> aVar) {
            String str = null;
            AppMethodBeat.i(77256);
            Cursor query = this.context.getContentResolver().query(this.uri, PROJECTION, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                    query.close();
                } catch (Throwable th) {
                    query.close();
                    AppMethodBeat.o(77256);
                    throw th;
                }
            }
            if (TextUtils.isEmpty(str)) {
                aVar.e(new FileNotFoundException("Failed to find file path for: " + this.uri));
                AppMethodBeat.o(77256);
                return;
            }
            aVar.S(new File(str));
            AppMethodBeat.o(77256);
        }

        @Override // com.bumptech.glide.load.a.d
        public final void cleanup() {
        }

        @Override // com.bumptech.glide.load.a.d
        public final void cancel() {
        }

        @Override // com.bumptech.glide.load.a.d
        public final Class<File> os() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.a.d
        public final com.bumptech.glide.load.a ot() {
            return com.bumptech.glide.load.a.LOCAL;
        }
    }

    public static final class a implements o<Uri, File> {
        private final Context context;

        public a(Context context2) {
            this.context = context2;
        }

        @Override // com.bumptech.glide.load.c.o
        public final n<Uri, File> a(r rVar) {
            AppMethodBeat.i(77255);
            k kVar = new k(this.context);
            AppMethodBeat.o(77255);
            return kVar;
        }
    }
}
