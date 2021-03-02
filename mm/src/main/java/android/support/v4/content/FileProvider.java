package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = {"_display_name", "_size"};
    private static final File DEVICE_ROOT = new File(FilePathGenerator.ANDROID_DIR_SEP);
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static HashMap<String, a> sCache = new HashMap<>();
    private a mStrategy;

    /* access modifiers changed from: package-private */
    public interface a {
        File c(Uri uri);

        Uri o(File file);
    }

    public boolean onCreate() {
        return true;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        } else {
            this.mStrategy = getPathStrategy(context, providerInfo.authority);
        }
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        return getPathStrategy(context, str).o(file);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i2;
        File c2 = this.mStrategy.c(uri);
        if (strArr == null) {
            strArr = COLUMNS;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int length = strArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            String str3 = strArr[i3];
            if ("_display_name".equals(str3)) {
                strArr3[i4] = "_display_name";
                i2 = i4 + 1;
                objArr[i4] = c2.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i4] = "_size";
                i2 = i4 + 1;
                objArr[i4] = Long.valueOf(c2.length());
            } else {
                i2 = i4;
            }
            i3++;
            i4 = i2;
        }
        String[] copyOf = copyOf(strArr3, i4);
        Object[] copyOf2 = copyOf(objArr, i4);
        MatrixCursor matrixCursor = new MatrixCursor(copyOf, 1);
        matrixCursor.addRow(copyOf2);
        return matrixCursor;
    }

    public String getType(Uri uri) {
        String mimeTypeFromExtension;
        File c2 = this.mStrategy.c(uri);
        int lastIndexOf = c2.getName().lastIndexOf(46);
        return (lastIndexOf < 0 || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(c2.getName().substring(lastIndexOf + 1))) == null) ? "application/octet-stream" : mimeTypeFromExtension;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.mStrategy.c(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(this.mStrategy.c(uri), modeToMode(str));
    }

    private static a getPathStrategy(Context context, String str) {
        a aVar;
        synchronized (sCache) {
            aVar = sCache.get(str);
            if (aVar == null) {
                try {
                    aVar = parsePathStrategy(context, str);
                    sCache.put(str, aVar);
                } catch (IOException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                } catch (XmlPullParserException e3) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e3);
                }
            }
        }
        return aVar;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 153
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    private static android.support.v4.content.FileProvider.a parsePathStrategy(android.content.Context r10, java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 240
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.FileProvider.parsePathStrategy(android.content.Context, java.lang.String):android.support.v4.content.FileProvider$a");
    }

    /* access modifiers changed from: package-private */
    public static class b implements a {
        private final String IZ;
        final HashMap<String, File> Ja = new HashMap<>();

        b(String str) {
            this.IZ = str;
        }

        @Override // android.support.v4.content.FileProvider.a
        public final Uri o(File file) {
            String substring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.Ja.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (!canonicalPath.startsWith(path) || (entry != null && path.length() <= entry.getValue().getPath().length())) {
                        entry2 = entry;
                    }
                    entry = entry2;
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains ".concat(String.valueOf(canonicalPath)));
                }
                String path2 = entry.getValue().getPath();
                if (path2.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                    substring = canonicalPath.substring(path2.length());
                } else {
                    substring = canonicalPath.substring(path2.length() + 1);
                }
                return new Uri.Builder().scheme("content").authority(this.IZ).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(substring, FilePathGenerator.ANDROID_DIR_SEP)).build();
            } catch (IOException e2) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file)));
            }
        }

        @Override // android.support.v4.content.FileProvider.a
        public final File c(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.Ja.get(decode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for ".concat(String.valueOf(uri)));
            }
            File file2 = new File(file, decode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException e2) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file2)));
            }
        }
    }

    private static int modeToMode(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: ".concat(String.valueOf(str)));
    }

    private static File buildPath(File file, String... strArr) {
        File file2;
        int length = strArr.length;
        int i2 = 0;
        File file3 = file;
        while (i2 < length) {
            String str = strArr[i2];
            if (str != null) {
                file2 = new File(file3, str);
            } else {
                file2 = file3;
            }
            i2++;
            file3 = file2;
        }
        return file3;
    }

    private static String[] copyOf(String[] strArr, int i2) {
        String[] strArr2 = new String[i2];
        System.arraycopy(strArr, 0, strArr2, 0, i2);
        return strArr2;
    }

    private static Object[] copyOf(Object[] objArr, int i2) {
        Object[] objArr2 = new Object[i2];
        System.arraycopy(objArr, 0, objArr2, 0, i2);
        return objArr2;
    }
}
