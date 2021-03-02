package com.tencent.mm.vfs;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.vfs.g;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class VFSFileProvider extends ContentProvider {
    private static final String[] COLUMNS = {"_display_name", "_size"};
    private static final Pattern RdL = Pattern.compile(FilePathGenerator.ANDROID_DIR_SEP);
    private String IZ;

    static {
        AppMethodBeat.i(13316);
        AppMethodBeat.o(13316);
    }

    private static Uri y(Uri uri) {
        AppMethodBeat.i(13308);
        String path = uri.getPath();
        if (path == null || path.isEmpty()) {
            AppMethodBeat.o(13308);
            return null;
        }
        if (path.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            path = path.substring(1);
        }
        String[] split = RdL.split(path, 3);
        if (split.length < 2) {
            AppMethodBeat.o(13308);
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        String str = split[0];
        if (!str.startsWith("@")) {
            builder.scheme("wcf").authority(str).path(path.substring(str.length() + 1));
        } else if (split.length < 3) {
            AppMethodBeat.o(13308);
            return null;
        } else {
            builder.scheme(str.substring(1));
            if (split[1].equals("@")) {
                builder.authority(null);
            } else {
                builder.authority(split[1]);
            }
            builder.path(split[2]);
        }
        Uri build = builder.build();
        AppMethodBeat.o(13308);
        return build;
    }

    public boolean onCreate() {
        return true;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        AppMethodBeat.i(13309);
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            SecurityException securityException = new SecurityException("Provider must not be exported");
            AppMethodBeat.o(13309);
            throw securityException;
        } else if (!providerInfo.grantUriPermissions) {
            SecurityException securityException2 = new SecurityException("Provider must grant uri permissions");
            AppMethodBeat.o(13309);
            throw securityException2;
        } else {
            this.IZ = providerInfo.authority;
            AppMethodBeat.o(13309);
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i2;
        AppMethodBeat.i(13310);
        Uri y = y(uri);
        if (y == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No mapping found for ".concat(String.valueOf(uri)));
            AppMethodBeat.o(13310);
            throw illegalArgumentException;
        }
        o oVar = new o(y);
        if (strArr == null) {
            strArr = COLUMNS;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i3 = 0;
        int length = strArr.length;
        int i4 = 0;
        while (i4 < length) {
            String str3 = strArr[i4];
            if ("_display_name".equals(str3)) {
                strArr3[i3] = "_display_name";
                i2 = i3 + 1;
                objArr[i3] = oVar.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i3] = "_size";
                i2 = i3 + 1;
                objArr[i3] = Long.valueOf(oVar.length());
            } else {
                i2 = i3;
            }
            i4++;
            i3 = i2;
        }
        Object[] copyOf = Arrays.copyOf(objArr, i3);
        MatrixCursor matrixCursor = new MatrixCursor((String[]) Arrays.copyOf(strArr3, i3), 1);
        matrixCursor.addRow(copyOf);
        AppMethodBeat.o(13310);
        return matrixCursor;
    }

    public String getType(Uri uri) {
        String mimeTypeFromExtension;
        Context context;
        AppMethodBeat.i(13311);
        Uri y = y(uri);
        if (y == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No mapping found for ".concat(String.valueOf(uri)));
            AppMethodBeat.o(13311);
            throw illegalArgumentException;
        }
        String scheme = y.getScheme();
        if (scheme == null || !scheme.equals("content") || (context = getContext()) == null) {
            o oVar = new o(y);
            int lastIndexOf = oVar.getName().lastIndexOf(46);
            if (lastIndexOf < 0 || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(oVar.getName().substring(lastIndexOf + 1))) == null) {
                AppMethodBeat.o(13311);
                return "application/octet-stream";
            }
            AppMethodBeat.o(13311);
            return mimeTypeFromExtension;
        }
        String type = context.getContentResolver().getType(y);
        AppMethodBeat.o(13311);
        return type;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        AppMethodBeat.i(13312);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("No external inserts");
        AppMethodBeat.o(13312);
        throw unsupportedOperationException;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        AppMethodBeat.i(13313);
        Uri y = y(uri);
        if (y == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No mapping found for ".concat(String.valueOf(uri)));
            AppMethodBeat.o(13313);
            throw illegalArgumentException;
        } else if (new o(y).delete()) {
            AppMethodBeat.o(13313);
            return 1;
        } else {
            AppMethodBeat.o(13313);
            return 0;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AppMethodBeat.i(13314);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("No external updates");
        AppMethodBeat.o(13314);
        throw unsupportedOperationException;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        AppMethodBeat.i(13315);
        Uri y = y(uri);
        if (y == null) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("File not found: ".concat(String.valueOf(uri)));
            AppMethodBeat.o(13315);
            throw fileNotFoundException;
        }
        g.e a2 = g.hYQ().a(y, (g.e) null);
        if (a2.valid()) {
            ParcelFileDescriptor nr = a2.Rcl.nr(a2.path, str);
            AppMethodBeat.o(13315);
            return nr;
        }
        FileNotFoundException fileNotFoundException2 = new FileNotFoundException("File not found: ".concat(String.valueOf(uri)));
        AppMethodBeat.o(13315);
        throw fileNotFoundException2;
    }
}
