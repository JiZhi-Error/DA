package com.tencent.mm.vfs;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.util.Map;

public final class ContentsSchemeResolver extends SingletonSchemeResolver {
    public static final a CREATOR = new a((byte) 0);
    private final ContentProviderFileSystem Rbj;

    /* synthetic */ ContentsSchemeResolver(byte b2) {
        this();
    }

    public static SchemeResolver hdT() {
        return a.Rbl.Rds;
    }

    static final class ContentProviderFileSystem extends a implements FileSystem {
        public static final Parcelable.Creator<ContentProviderFileSystem> CREATOR = null;
        private final ContentResolver Rbk;

        ContentProviderFileSystem(Context context) {
            AppMethodBeat.i(13048);
            this.Rbk = context.getContentResolver();
            AppMethodBeat.o(13048);
        }

        @Override // com.tencent.mm.vfs.FileSystem
        public final FileSystem.b cj(Map<String, String> map) {
            return this;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final FileSystem hdQ() {
            return this;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final int hdR() {
            return 1;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final FileSystem.a boK(String str) {
            AppMethodBeat.i(13049);
            FileSystem.a aVar = new FileSystem.a();
            AppMethodBeat.o(13049);
            return aVar;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final InputStream openRead(String str) {
            AppMethodBeat.i(13050);
            try {
                InputStream openInputStream = this.Rbk.openInputStream(Uri.parse(str));
                if (openInputStream == null) {
                    FileNotFoundException fileNotFoundException = new FileNotFoundException("ContentResolver returns null");
                    AppMethodBeat.o(13050);
                    throw fileNotFoundException;
                }
                AppMethodBeat.o(13050);
                return openInputStream;
            } catch (SecurityException e2) {
                SecurityException securityException = (SecurityException) new FileNotFoundException(str + " cannot be opened: " + e2.getMessage()).initCause(e2);
                AppMethodBeat.o(13050);
                throw securityException;
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final OutputStream dw(String str, boolean z) {
            AppMethodBeat.i(13051);
            try {
                OutputStream openOutputStream = this.Rbk.openOutputStream(Uri.parse(str), z ? "wa" : "w");
                if (openOutputStream == null) {
                    FileNotFoundException fileNotFoundException = new FileNotFoundException("ContentResolver returns null");
                    AppMethodBeat.o(13051);
                    throw fileNotFoundException;
                }
                AppMethodBeat.o(13051);
                return openOutputStream;
            } catch (SecurityException e2) {
                SecurityException securityException = (SecurityException) new FileNotFoundException(str + " cannot be opened: " + e2.getMessage()).initCause(e2);
                AppMethodBeat.o(13051);
                throw securityException;
            }
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
        public final ByteChannel boJ(String str) {
            AppMethodBeat.i(13052);
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Not supported.");
            AppMethodBeat.o(13052);
            throw fileNotFoundException;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
        public final ParcelFileDescriptor nr(String str, String str2) {
            AppMethodBeat.i(13053);
            try {
                ParcelFileDescriptor openFileDescriptor = this.Rbk.openFileDescriptor(Uri.parse(str), str2);
                if (openFileDescriptor == null) {
                    FileNotFoundException fileNotFoundException = new FileNotFoundException("ContentResolver returns null");
                    AppMethodBeat.o(13053);
                    throw fileNotFoundException;
                }
                AppMethodBeat.o(13053);
                return openFileDescriptor;
            } catch (SecurityException e2) {
                SecurityException securityException = (SecurityException) new FileNotFoundException(str + " cannot be opened: " + e2.getMessage()).initCause(e2);
                AppMethodBeat.o(13053);
                throw securityException;
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final boolean boL(String str) {
            AppMethodBeat.i(13054);
            if (boM(str) != null) {
                AppMethodBeat.o(13054);
                return true;
            }
            AppMethodBeat.o(13054);
            return false;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final e boM(String str) {
            Cursor cursor;
            Throwable th;
            Cursor cursor2;
            AppMethodBeat.i(187632);
            try {
                cursor = this.Rbk.query(Uri.parse(str), null, null, null, null);
                if (cursor == null) {
                    aa.closeQuietly(cursor);
                    AppMethodBeat.o(187632);
                    return null;
                }
                try {
                    int columnIndex = cursor.getColumnIndex("_display_name");
                    int columnIndex2 = cursor.getColumnIndex("_size");
                    if (!cursor.moveToFirst()) {
                        aa.closeQuietly(cursor);
                        AppMethodBeat.o(187632);
                        return null;
                    }
                    e eVar = new e(this, str, cursor.getString(columnIndex), cursor.getLong(columnIndex2), 0, 0, false);
                    aa.closeQuietly(cursor);
                    AppMethodBeat.o(187632);
                    return eVar;
                } catch (SecurityException e2) {
                    cursor2 = cursor;
                    aa.closeQuietly(cursor2);
                    AppMethodBeat.o(187632);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    aa.closeQuietly(cursor);
                    AppMethodBeat.o(187632);
                    throw th;
                }
            } catch (SecurityException e3) {
                cursor2 = null;
                aa.closeQuietly(cursor2);
                AppMethodBeat.o(187632);
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                aa.closeQuietly(cursor);
                AppMethodBeat.o(187632);
                throw th;
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final boolean ck(String str, long j2) {
            return false;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final boolean gC(String str) {
            AppMethodBeat.i(13056);
            try {
                if (this.Rbk.delete(Uri.parse(str), null, null) > 0) {
                    AppMethodBeat.o(13056);
                    return true;
                }
                AppMethodBeat.o(13056);
                return false;
            } catch (SecurityException e2) {
                AppMethodBeat.o(13056);
                return false;
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final Iterable<e> dx(String str, boolean z) {
            return null;
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

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(13057);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(13057);
            throw unsupportedOperationException;
        }
    }

    private ContentsSchemeResolver() {
        AppMethodBeat.i(13059);
        this.Rbj = new ContentProviderFileSystem(g.hYQ().mContext);
        AppMethodBeat.o(13059);
    }

    @Override // com.tencent.mm.vfs.SchemeResolver.a
    public final Pair<FileSystem.b, String> a(k kVar, Uri uri) {
        AppMethodBeat.i(187633);
        StringBuilder sb = new StringBuilder();
        String scheme = uri.getScheme();
        if (scheme != null) {
            sb.append(scheme).append(':');
        }
        String authority = uri.getAuthority();
        if (authority != null) {
            sb.append("//").append(authority);
        }
        String path = uri.getPath();
        if (path != null) {
            sb.append(path);
        }
        Pair<FileSystem.b, String> create = Pair.create(this.Rbj, sb.toString());
        AppMethodBeat.o(187633);
        return create;
    }

    /* access modifiers changed from: package-private */
    public static class a implements Parcelable.Creator<ContentsSchemeResolver> {
        static final m Rbl = new m(new ContentsSchemeResolver((byte) 0));

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        static {
            AppMethodBeat.i(13058);
            AppMethodBeat.o(13058);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ContentsSchemeResolver[] newArray(int i2) {
            return new ContentsSchemeResolver[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ContentsSchemeResolver createFromParcel(Parcel parcel) {
            return (ContentsSchemeResolver) Rbl.Rds;
        }
    }

    static {
        AppMethodBeat.i(13061);
        AppMethodBeat.o(13061);
    }
}
