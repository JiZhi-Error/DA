package com.tencent.mm.vfs;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.vfs.FileSystem;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;

public final class AssetsSchemeResolver extends SingletonSchemeResolver {
    public static final a CREATOR = new a((byte) 0);
    private final AssetsFileSystem RaT;

    /* synthetic */ AssetsSchemeResolver(byte b2) {
        this();
    }

    public static AssetsSchemeResolver hdP() {
        return a.RaV;
    }

    static final class AssetsFileSystem extends a implements FileSystem {
        public static final Parcelable.Creator<AssetsFileSystem> CREATOR = null;
        private final AssetManager RaU;

        AssetsFileSystem(Context context) {
            AppMethodBeat.i(13024);
            this.RaU = context.getAssets();
            AppMethodBeat.o(13024);
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final FileSystem hdQ() {
            return this;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final int hdR() {
            return 12;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final FileSystem.a boK(String str) {
            AppMethodBeat.i(13025);
            FileSystem.a aVar = new FileSystem.a();
            AppMethodBeat.o(13025);
            return aVar;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final InputStream openRead(String str) {
            AppMethodBeat.i(13026);
            try {
                InputStream open = this.RaU.open(str);
                AppMethodBeat.o(13026);
                return open;
            } catch (IOException e2) {
                if (e2 instanceof FileNotFoundException) {
                    FileNotFoundException fileNotFoundException = (FileNotFoundException) e2;
                    AppMethodBeat.o(13026);
                    throw fileNotFoundException;
                }
                FileNotFoundException fileNotFoundException2 = new FileNotFoundException(e2.getMessage());
                AppMethodBeat.o(13026);
                throw fileNotFoundException2;
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final OutputStream dw(String str, boolean z) {
            AppMethodBeat.i(13027);
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Cannot open files for writing on read-only filesystems");
            AppMethodBeat.o(13027);
            throw fileNotFoundException;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final boolean boL(String str) {
            AppMethodBeat.i(13028);
            try {
                openRead(str).close();
                AppMethodBeat.o(13028);
                return true;
            } catch (IOException e2) {
                AppMethodBeat.o(13028);
                return false;
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final e boM(String str) {
            AppMethodBeat.i(187623);
            try {
                InputStream openRead = openRead(str);
                int available = openRead.available();
                openRead.close();
                int lastIndexOf = str.lastIndexOf(47);
                e eVar = new e(this, str, lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1), (long) available, 0, 0, false);
                AppMethodBeat.o(187623);
                return eVar;
            } catch (IOException e2) {
                AppMethodBeat.o(187623);
                return null;
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final boolean ck(String str, long j2) {
            return false;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final boolean gC(String str) {
            return false;
        }

        private void c(String str, String str2, ArrayList<e> arrayList) {
            String str3;
            AppMethodBeat.i(13030);
            if (str2 == null || str2.isEmpty()) {
                str3 = str;
            } else {
                str3 = str.isEmpty() ? str2 : str + '/' + str2;
            }
            String[] list = this.RaU.list(str3);
            if (list != null && list.length != 0) {
                if (str2 != null) {
                    arrayList.add(new e(this, str3, str2, 0, 0, 0, true));
                }
                for (String str4 : list) {
                    if (str4 != null && !str4.isEmpty()) {
                        c(str3, str4, arrayList);
                    }
                }
            } else if (str2 != null) {
                arrayList.add(new e(this, str3, str2, 0, 0, 0, false));
                AppMethodBeat.o(13030);
                return;
            }
            AppMethodBeat.o(13030);
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final Iterable<e> dx(String str, boolean z) {
            AppMethodBeat.i(13031);
            if (str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                str = str.substring(0, str.length() - 1);
            }
            if (z) {
                try {
                    ArrayList<e> arrayList = new ArrayList<>();
                    c(str, (String) null, arrayList);
                    AppMethodBeat.o(13031);
                    return arrayList;
                } catch (IOException e2) {
                    AppMethodBeat.o(13031);
                    return null;
                }
            } else {
                String[] list = this.RaU.list(str);
                if (list == null) {
                    AppMethodBeat.o(13031);
                    return null;
                }
                String str2 = str + '/';
                ArrayList arrayList2 = new ArrayList(list.length);
                for (String str3 : list) {
                    String str4 = str2 + str3;
                    String[] list2 = this.RaU.list(str4);
                    arrayList2.add(new e(this, str4, str3, 0, 0, 0, list2 != null && list2.length > 0));
                }
                AppMethodBeat.o(13031);
                return arrayList2;
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final boolean boN(String str) {
            return false;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final boolean dy(String str, boolean z) {
            return false;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final String dz(String str, boolean z) {
            return null;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.vfs.a
        public final boolean b(String str, FileSystem.b bVar, String str2) {
            AppMethodBeat.i(187624);
            IOException iOException = new IOException("Not implemented");
            AppMethodBeat.o(187624);
            throw iOException;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.vfs.a
        public final long d(String str, FileSystem.b bVar, String str2) {
            AppMethodBeat.i(187625);
            IOException iOException = new IOException("Not implemented");
            AppMethodBeat.o(187625);
            throw iOException;
        }

        public final String toString() {
            return "AssetsFS";
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(13034);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(13034);
            throw unsupportedOperationException;
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public final FileSystem.b cj(Map<String, String> map) {
            return this;
        }
    }

    private AssetsSchemeResolver() {
        AppMethodBeat.i(13036);
        this.RaT = new AssetsFileSystem(g.hYQ().mContext);
        AppMethodBeat.o(13036);
    }

    @Override // com.tencent.mm.vfs.SchemeResolver.a
    public final Pair<FileSystem.b, String> a(k kVar, Uri uri) {
        AppMethodBeat.i(187626);
        String path = uri.getPath();
        Pair<FileSystem.b, String> create = Pair.create(this.RaT, path == null ? "" : aa.q(path, true, true));
        AppMethodBeat.o(187626);
        return create;
    }

    /* access modifiers changed from: package-private */
    public static class a implements Parcelable.Creator<AssetsSchemeResolver> {
        static final AssetsSchemeResolver RaV = new AssetsSchemeResolver((byte) 0);

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        static {
            AppMethodBeat.i(13035);
            AppMethodBeat.o(13035);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AssetsSchemeResolver[] newArray(int i2) {
            return new AssetsSchemeResolver[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AssetsSchemeResolver createFromParcel(Parcel parcel) {
            return RaV;
        }
    }

    static {
        AppMethodBeat.i(13038);
        AppMethodBeat.o(13038);
    }
}
