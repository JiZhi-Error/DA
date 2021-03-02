package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem;

public class FileSchemeResolver extends SingletonSchemeResolver {
    public static final a CREATOR = new a((byte) 0);

    /* synthetic */ FileSchemeResolver(byte b2) {
        this();
    }

    static m hdX() {
        return a.Rbl;
    }

    private FileSchemeResolver() {
    }

    @Override // com.tencent.mm.vfs.SchemeResolver.a
    public final Pair<FileSystem.b, String> a(k kVar, Uri uri) {
        AppMethodBeat.i(187651);
        String path = uri.getPath();
        if (path == null) {
            path = "";
        }
        Pair<FileSystem.b, String> boU = kVar.boU(path);
        AppMethodBeat.o(187651);
        return boU;
    }

    /* access modifiers changed from: package-private */
    public static class a implements Parcelable.Creator<FileSchemeResolver> {
        static final m Rbl = new m(new FileSchemeResolver((byte) 0));

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        static {
            AppMethodBeat.i(13098);
            AppMethodBeat.o(13098);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FileSchemeResolver[] newArray(int i2) {
            return new FileSchemeResolver[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FileSchemeResolver createFromParcel(Parcel parcel) {
            return (FileSchemeResolver) Rbl.Rds;
        }
    }

    static {
        AppMethodBeat.i(13101);
        AppMethodBeat.o(13101);
    }
}
