package com.bumptech.glide.load.c;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class s<Data> implements n<Integer, Data> {
    private final n<Uri, Data> aKx;
    private final Resources aKy;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.load.c.n
    public final /* bridge */ /* synthetic */ boolean X(Integer num) {
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.c.n
    public final /* bridge */ /* synthetic */ n.a b(Integer num, int i2, int i3, i iVar) {
        AppMethodBeat.i(77300);
        Uri b2 = b(num);
        if (b2 == null) {
            AppMethodBeat.o(77300);
            return null;
        }
        n.a<Data> b3 = this.aKx.b(b2, i2, i3, iVar);
        AppMethodBeat.o(77300);
        return b3;
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.aKy = resources;
        this.aKx = nVar;
    }

    private Uri b(Integer num) {
        AppMethodBeat.i(77299);
        try {
            Uri parse = Uri.parse("android.resource://" + this.aKy.getResourcePackageName(num.intValue()) + '/' + this.aKy.getResourceTypeName(num.intValue()) + '/' + this.aKy.getResourceEntryName(num.intValue()));
            AppMethodBeat.o(77299);
            return parse;
        } catch (Resources.NotFoundException e2) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                new StringBuilder("Received invalid resource id: ").append(num);
            }
            AppMethodBeat.o(77299);
            return null;
        }
    }

    public static class c implements o<Integer, InputStream> {
        private final Resources aKy;

        public c(Resources resources) {
            this.aKy = resources;
        }

        @Override // com.bumptech.glide.load.c.o
        public final n<Integer, InputStream> a(r rVar) {
            AppMethodBeat.i(77297);
            s sVar = new s(this.aKy, rVar.b(Uri.class, InputStream.class));
            AppMethodBeat.o(77297);
            return sVar;
        }
    }

    public static class b implements o<Integer, ParcelFileDescriptor> {
        private final Resources aKy;

        public b(Resources resources) {
            this.aKy = resources;
        }

        @Override // com.bumptech.glide.load.c.o
        public final n<Integer, ParcelFileDescriptor> a(r rVar) {
            AppMethodBeat.i(77296);
            s sVar = new s(this.aKy, rVar.b(Uri.class, ParcelFileDescriptor.class));
            AppMethodBeat.o(77296);
            return sVar;
        }
    }

    public static final class a implements o<Integer, AssetFileDescriptor> {
        private final Resources aKy;

        public a(Resources resources) {
            this.aKy = resources;
        }

        @Override // com.bumptech.glide.load.c.o
        public final n<Integer, AssetFileDescriptor> a(r rVar) {
            AppMethodBeat.i(77295);
            s sVar = new s(this.aKy, rVar.b(Uri.class, AssetFileDescriptor.class));
            AppMethodBeat.o(77295);
            return sVar;
        }
    }

    public static class d implements o<Integer, Uri> {
        private final Resources aKy;

        public d(Resources resources) {
            this.aKy = resources;
        }

        @Override // com.bumptech.glide.load.c.o
        public final n<Integer, Uri> a(r rVar) {
            AppMethodBeat.i(77298);
            s sVar = new s(this.aKy, v.pv());
            AppMethodBeat.o(77298);
            return sVar;
        }
    }
}
