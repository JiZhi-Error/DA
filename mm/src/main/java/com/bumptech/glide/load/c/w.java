package com.bumptech.glide.load.c;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class w<Data> implements n<Uri, Data> {
    private static final Set<String> aKC = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));
    private final c<Data> aKD;

    public interface c<Data> {
        com.bumptech.glide.load.a.d<Data> l(Uri uri);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ boolean X(Uri uri) {
        AppMethodBeat.i(77320);
        boolean contains = aKC.contains(uri.getScheme());
        AppMethodBeat.o(77320);
        return contains;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ n.a b(Uri uri, int i2, int i3, i iVar) {
        AppMethodBeat.i(77321);
        Uri uri2 = uri;
        n.a aVar = new n.a(new com.bumptech.glide.f.b(uri2), this.aKD.l(uri2));
        AppMethodBeat.o(77321);
        return aVar;
    }

    static {
        AppMethodBeat.i(77322);
        AppMethodBeat.o(77322);
    }

    public w(c<Data> cVar) {
        this.aKD = cVar;
    }

    public static class d implements o<Uri, InputStream>, c<InputStream> {
        private final ContentResolver aFp;

        public d(ContentResolver contentResolver) {
            this.aFp = contentResolver;
        }

        @Override // com.bumptech.glide.load.c.w.c
        public final com.bumptech.glide.load.a.d<InputStream> l(Uri uri) {
            AppMethodBeat.i(77318);
            com.bumptech.glide.load.a.n nVar = new com.bumptech.glide.load.a.n(this.aFp, uri);
            AppMethodBeat.o(77318);
            return nVar;
        }

        @Override // com.bumptech.glide.load.c.o
        public final n<Uri, InputStream> a(r rVar) {
            AppMethodBeat.i(77319);
            w wVar = new w(this);
            AppMethodBeat.o(77319);
            return wVar;
        }
    }

    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {
        private final ContentResolver aFp;

        public b(ContentResolver contentResolver) {
            this.aFp = contentResolver;
        }

        @Override // com.bumptech.glide.load.c.w.c
        public final com.bumptech.glide.load.a.d<ParcelFileDescriptor> l(Uri uri) {
            AppMethodBeat.i(77316);
            com.bumptech.glide.load.a.i iVar = new com.bumptech.glide.load.a.i(this.aFp, uri);
            AppMethodBeat.o(77316);
            return iVar;
        }

        @Override // com.bumptech.glide.load.c.o
        public final n<Uri, ParcelFileDescriptor> a(r rVar) {
            AppMethodBeat.i(77317);
            w wVar = new w(this);
            AppMethodBeat.o(77317);
            return wVar;
        }
    }

    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {
        private final ContentResolver aFp;

        public a(ContentResolver contentResolver) {
            this.aFp = contentResolver;
        }

        @Override // com.bumptech.glide.load.c.o
        public final n<Uri, AssetFileDescriptor> a(r rVar) {
            AppMethodBeat.i(77314);
            w wVar = new w(this);
            AppMethodBeat.o(77314);
            return wVar;
        }

        @Override // com.bumptech.glide.load.c.w.c
        public final com.bumptech.glide.load.a.d<AssetFileDescriptor> l(Uri uri) {
            AppMethodBeat.i(77315);
            com.bumptech.glide.load.a.a aVar = new com.bumptech.glide.load.a.a(this.aFp, uri);
            AppMethodBeat.o(77315);
            return aVar;
        }
    }
}
