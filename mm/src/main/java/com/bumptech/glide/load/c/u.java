package com.bumptech.glide.load.c;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;

public final class u<Data> implements n<String, Data> {
    private final n<Uri, Data> aKx;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.load.c.n
    public final /* bridge */ /* synthetic */ boolean X(String str) {
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ n.a b(String str, int i2, int i3, i iVar) {
        Uri parse;
        AppMethodBeat.i(77307);
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            parse = null;
        } else if (str2.charAt(0) == '/') {
            parse = S(str2);
        } else {
            parse = Uri.parse(str2);
            if (parse.getScheme() == null) {
                parse = S(str2);
            }
        }
        if (parse == null || !this.aKx.X(parse)) {
            AppMethodBeat.o(77307);
            return null;
        }
        n.a<Data> b2 = this.aKx.b(parse, i2, i3, iVar);
        AppMethodBeat.o(77307);
        return b2;
    }

    public u(n<Uri, Data> nVar) {
        this.aKx = nVar;
    }

    private static Uri S(String str) {
        AppMethodBeat.i(77306);
        Uri fromFile = Uri.fromFile(new File(str));
        AppMethodBeat.o(77306);
        return fromFile;
    }

    public static class c implements o<String, InputStream> {
        @Override // com.bumptech.glide.load.c.o
        public final n<String, InputStream> a(r rVar) {
            AppMethodBeat.i(77305);
            u uVar = new u(rVar.b(Uri.class, InputStream.class));
            AppMethodBeat.o(77305);
            return uVar;
        }
    }

    public static class b implements o<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.c.o
        public final n<String, ParcelFileDescriptor> a(r rVar) {
            AppMethodBeat.i(77304);
            u uVar = new u(rVar.b(Uri.class, ParcelFileDescriptor.class));
            AppMethodBeat.o(77304);
            return uVar;
        }
    }

    public static final class a implements o<String, AssetFileDescriptor> {
        @Override // com.bumptech.glide.load.c.o
        public final n<String, AssetFileDescriptor> a(r rVar) {
            AppMethodBeat.i(77303);
            u uVar = new u(rVar.b(Uri.class, AssetFileDescriptor.class));
            AppMethodBeat.o(77303);
            return uVar;
        }
    }
}
