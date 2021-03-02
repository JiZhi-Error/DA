package com.bumptech.glide.load.c;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.h;
import com.bumptech.glide.load.a.m;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class a<Data> implements n<Uri, Data> {
    private static final int aJE = 22;
    private final AssetManager aFb;
    private final AbstractC0070a<Data> aJF;

    /* renamed from: com.bumptech.glide.load.c.a$a  reason: collision with other inner class name */
    public interface AbstractC0070a<Data> {
        d<Data> b(AssetManager assetManager, String str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ boolean X(Uri uri) {
        AppMethodBeat.i(77203);
        Uri uri2 = uri;
        if (!"file".equals(uri2.getScheme()) || uri2.getPathSegments().isEmpty() || !"android_asset".equals(uri2.getPathSegments().get(0))) {
            AppMethodBeat.o(77203);
            return false;
        }
        AppMethodBeat.o(77203);
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ n.a b(Uri uri, int i2, int i3, i iVar) {
        AppMethodBeat.i(77204);
        Uri uri2 = uri;
        n.a aVar = new n.a(new com.bumptech.glide.f.b(uri2), this.aJF.b(this.aFb, uri2.toString().substring(aJE)));
        AppMethodBeat.o(77204);
        return aVar;
    }

    public a(AssetManager assetManager, AbstractC0070a<Data> aVar) {
        this.aFb = assetManager;
        this.aJF = aVar;
    }

    public static class c implements AbstractC0070a<InputStream>, o<Uri, InputStream> {
        private final AssetManager aFb;

        public c(AssetManager assetManager) {
            this.aFb = assetManager;
        }

        @Override // com.bumptech.glide.load.c.o
        public final n<Uri, InputStream> a(r rVar) {
            AppMethodBeat.i(77201);
            a aVar = new a(this.aFb, this);
            AppMethodBeat.o(77201);
            return aVar;
        }

        @Override // com.bumptech.glide.load.c.a.AbstractC0070a
        public final d<InputStream> b(AssetManager assetManager, String str) {
            AppMethodBeat.i(77202);
            m mVar = new m(assetManager, str);
            AppMethodBeat.o(77202);
            return mVar;
        }
    }

    public static class b implements AbstractC0070a<ParcelFileDescriptor>, o<Uri, ParcelFileDescriptor> {
        private final AssetManager aFb;

        public b(AssetManager assetManager) {
            this.aFb = assetManager;
        }

        @Override // com.bumptech.glide.load.c.o
        public final n<Uri, ParcelFileDescriptor> a(r rVar) {
            AppMethodBeat.i(77199);
            a aVar = new a(this.aFb, this);
            AppMethodBeat.o(77199);
            return aVar;
        }

        @Override // com.bumptech.glide.load.c.a.AbstractC0070a
        public final d<ParcelFileDescriptor> b(AssetManager assetManager, String str) {
            AppMethodBeat.i(77200);
            h hVar = new h(assetManager, str);
            AppMethodBeat.o(77200);
            return hVar;
        }
    }
}
