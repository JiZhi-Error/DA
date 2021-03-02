package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem;

public final class WcfSchemeResolver extends SingletonSchemeResolver {
    public static final a CREATOR = new a((byte) 0);

    /* synthetic */ WcfSchemeResolver(byte b2) {
        this();
    }

    static m hdX() {
        return a.Rbl;
    }

    private WcfSchemeResolver() {
    }

    @Override // com.tencent.mm.vfs.SchemeResolver.a
    public final Pair<FileSystem.b, String> a(k kVar, Uri uri) {
        AppMethodBeat.i(187768);
        FileSystem.b boT = ((l) kVar).boT(uri.getAuthority());
        String path = uri.getPath();
        Pair<FileSystem.b, String> pair = new Pair<>(boT, path == null ? "" : aa.q(path, true, true));
        AppMethodBeat.o(187768);
        return pair;
    }

    /* access modifiers changed from: package-private */
    public static class a implements Parcelable.Creator<WcfSchemeResolver> {
        static final m Rbl = new m(new WcfSchemeResolver((byte) 0));

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        static {
            AppMethodBeat.i(13335);
            AppMethodBeat.o(13335);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WcfSchemeResolver[] newArray(int i2) {
            return new WcfSchemeResolver[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WcfSchemeResolver createFromParcel(Parcel parcel) {
            return (WcfSchemeResolver) Rbl.Rds;
        }
    }

    static {
        AppMethodBeat.i(13337);
        AppMethodBeat.o(13337);
    }
}
