package com.bumptech.glide.load.b.a;

import android.graphics.Bitmap;
import com.bumptech.glide.g.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class c implements l {
    private final b aIj = new b();
    private final h<a, Bitmap> aIk = new h<>();

    c() {
        AppMethodBeat.i(77071);
        AppMethodBeat.o(77071);
    }

    @Override // com.bumptech.glide.load.b.a.l
    public final void g(Bitmap bitmap) {
        AppMethodBeat.i(77072);
        this.aIk.a(this.aIj.f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
        AppMethodBeat.o(77072);
    }

    @Override // com.bumptech.glide.load.b.a.l
    public final Bitmap b(int i2, int i3, Bitmap.Config config) {
        AppMethodBeat.i(77073);
        Bitmap b2 = this.aIk.b(this.aIj.f(i2, i3, config));
        AppMethodBeat.o(77073);
        return b2;
    }

    @Override // com.bumptech.glide.load.b.a.l
    public final Bitmap pa() {
        AppMethodBeat.i(77074);
        Bitmap removeLast = this.aIk.removeLast();
        AppMethodBeat.o(77074);
        return removeLast;
    }

    @Override // com.bumptech.glide.load.b.a.l
    public final String c(int i2, int i3, Bitmap.Config config) {
        AppMethodBeat.i(77076);
        String d2 = d(i2, i3, config);
        AppMethodBeat.o(77076);
        return d2;
    }

    @Override // com.bumptech.glide.load.b.a.l
    public final int i(Bitmap bitmap) {
        AppMethodBeat.i(77077);
        int k = k.k(bitmap);
        AppMethodBeat.o(77077);
        return k;
    }

    public final String toString() {
        AppMethodBeat.i(77078);
        String str = "AttributeStrategy:\n  " + this.aIk;
        AppMethodBeat.o(77078);
        return str;
    }

    static String d(int i2, int i3, Bitmap.Config config) {
        AppMethodBeat.i(77079);
        String str = "[" + i2 + "x" + i3 + "], " + config;
        AppMethodBeat.o(77079);
        return str;
    }

    static class b extends d<a> {
        b() {
        }

        /* access modifiers changed from: package-private */
        public final a f(int i2, int i3, Bitmap.Config config) {
            AppMethodBeat.i(77069);
            a aVar = (a) pd();
            aVar.e(i2, i3, config);
            AppMethodBeat.o(77069);
            return aVar;
        }

        /* Return type fixed from 'com.bumptech.glide.load.b.a.m' to match base method */
        /* access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.b.a.d
        public final /* synthetic */ a pc() {
            AppMethodBeat.i(77070);
            a aVar = new a(this);
            AppMethodBeat.o(77070);
            return aVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements m {
        private final b aIl;
        private Bitmap.Config aIm;
        private int height;
        private int width;

        public a(b bVar) {
            this.aIl = bVar;
        }

        public final void e(int i2, int i3, Bitmap.Config config) {
            this.width = i2;
            this.height = i3;
            this.aIm = config;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.width == aVar.width && this.height == aVar.height && this.aIm == aVar.aIm) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(77066);
            int hashCode = (this.aIm != null ? this.aIm.hashCode() : 0) + (((this.width * 31) + this.height) * 31);
            AppMethodBeat.o(77066);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(77067);
            String d2 = c.d(this.width, this.height, this.aIm);
            AppMethodBeat.o(77067);
            return d2;
        }

        @Override // com.bumptech.glide.load.b.a.m
        public final void pb() {
            AppMethodBeat.i(77068);
            this.aIl.a(this);
            AppMethodBeat.o(77068);
        }
    }

    @Override // com.bumptech.glide.load.b.a.l
    public final String h(Bitmap bitmap) {
        AppMethodBeat.i(77075);
        String d2 = d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        AppMethodBeat.o(77075);
        return d2;
    }
}
