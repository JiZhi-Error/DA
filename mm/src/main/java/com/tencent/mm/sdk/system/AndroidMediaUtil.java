package com.tencent.mm.sdk.system;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Locale;

public class AndroidMediaUtil {
    private static final String TAG = "Luggage.AndroidMediaUtil";

    public static void refreshMediaScannerAsync(final String str, final Context context) {
        AppMethodBeat.i(214362);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.sdk.system.AndroidMediaUtil.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(214359);
                AndroidMediaUtil.refreshMediaScanner(str, context);
                AppMethodBeat.o(214359);
            }
        });
        AppMethodBeat.o(214362);
    }

    public static void refreshMediaScanner(String str, Context context) {
        AppMethodBeat.i(153460);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(153460);
            return;
        }
        String k = s.k(str, false);
        if (k != null) {
            try {
                updateMediaDatabase(context, k);
            } catch (Throwable th) {
                Log.printErrStackTrace(TAG, th, "Cannot update media database", new Object[0]);
            }
            try {
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", FileProviderHelper.getUriForFile(context, new o(k))));
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        Log.i(TAG, "refreshing media scanner on path=%s", str);
        if (Build.VERSION.SDK_INT > 28) {
            try {
                String mimeTypeByFilePath = MimeTypeUtil.getMimeTypeByFilePath(str);
                MediaScannerConnection.scanFile(context.getApplicationContext(), new String[]{k}, new String[]{mimeTypeByFilePath}, null);
                AppMethodBeat.o(153460);
            } catch (Throwable th2) {
                Log.e(TAG, "refresh by MediaScannerConnection, path = %s, thr = %s", str, th2);
                AppMethodBeat.o(153460);
            }
        } else {
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", FileProviderHelper.getUriForFile(context, new o(str))).addFlags(1));
            Log.i(TAG, "refreshing media scanner on path=%s", str);
            AppMethodBeat.o(153460);
        }
    }

    public static void refreshMediaScannerWithoutVFSRemapAsync(final String str, final Context context) {
        AppMethodBeat.i(214363);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.sdk.system.AndroidMediaUtil.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(214360);
                AndroidMediaUtil.refreshMediaScannerWithoutVFSRemap(str, context);
                AppMethodBeat.o(214360);
            }
        });
        AppMethodBeat.o(214363);
    }

    public static void refreshMediaScannerWithoutVFSRemap(String str, Context context) {
        AppMethodBeat.i(214364);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(214364);
            return;
        }
        try {
            updateMediaDatabase(context, str);
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "Cannot update media database", new Object[0]);
        }
        try {
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", FileProviderHelper.getUriForFileWithoutVFSRemap(context, new File(str))));
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        Log.i(TAG, "refreshing media scanner on path=%s", str);
        if (Build.VERSION.SDK_INT > 28) {
            try {
                String mimeTypeByFilePath = MimeTypeUtil.getMimeTypeByFilePath(str);
                MediaScannerConnection.scanFile(context.getApplicationContext(), new String[]{str}, new String[]{mimeTypeByFilePath}, null);
                AppMethodBeat.o(214364);
            } catch (Throwable th2) {
                Log.e(TAG, "refresh by MediaScannerConnection, path = %s, thr = %s", str, th2);
                AppMethodBeat.o(214364);
            }
        } else {
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", FileProviderHelper.getUriForFileWithoutVFSRemap(context, new File(str))).addFlags(1));
            Log.i(TAG, "refreshing media scanner on path=%s", str);
            AppMethodBeat.o(214364);
        }
    }

    public static void insertPathIntoMediaStoreAsync(final Context context, final String str) {
        AppMethodBeat.i(214365);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.sdk.system.AndroidMediaUtil.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(214361);
                AndroidMediaUtil.insertPathIntoMediaStore(context, str);
                AppMethodBeat.o(214361);
            }
        });
        AppMethodBeat.o(214365);
    }

    public static void insertPathIntoMediaStore(Context context, String str) {
        AppMethodBeat.i(214366);
        updateMediaDatabase(context, str);
        AppMethodBeat.o(214366);
    }

    @TargetApi(8)
    public static String getSysCameraDirPath() {
        AppMethodBeat.i(175928);
        String aKV = b.aKV();
        AppMethodBeat.o(175928);
        return aKV;
    }

    public static String getExportImagePath(String str) {
        AppMethodBeat.i(153461);
        String str2 = getSysCameraDirPath() + String.format(Locale.US, "%s%d.%s", "mmexport", Long.valueOf(System.currentTimeMillis()), str);
        AppMethodBeat.o(153461);
        return str2;
    }

    public static String getFriendlySdcardPath(String str) {
        String str2;
        int i2;
        AppMethodBeat.i(214367);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(214367);
            return "";
        }
        try {
            str2 = new File(str).getCanonicalPath();
        } catch (Throwable th) {
            str2 = str;
        }
        if (str2.startsWith(b.aKF())) {
            i2 = b.aKF().length();
        } else if (str2.startsWith(b.aKE())) {
            i2 = b.aKE().length();
        } else {
            i2 = -1;
        }
        if (i2 < 0) {
            AppMethodBeat.o(214367);
            return str;
        }
        String substring = str.substring(i2);
        if (substring.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            String concat = "/sdcard".concat(String.valueOf(substring));
            AppMethodBeat.o(214367);
            return concat;
        }
        String concat2 = "/sdcard/".concat(String.valueOf(substring));
        AppMethodBeat.o(214367);
        return concat2;
    }

    public static String getToastSysCameraPath() {
        String aKE;
        AppMethodBeat.i(153462);
        String aKD = b.aKD();
        if (aKD.startsWith(b.aKF())) {
            aKE = new File(aKD).getParentFile().getParentFile().getParentFile().getAbsolutePath();
        } else {
            aKE = b.aKE();
        }
        try {
            aKE = new File(aKE).getCanonicalPath();
        } catch (Throwable th) {
        }
        String k = s.k(getSysCameraDirPath(), true);
        int indexOf = k.indexOf(aKE);
        if (indexOf >= 0) {
            String substring = k.substring(aKE.length() + indexOf);
            if (substring.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                String concat = "/sdcard".concat(String.valueOf(substring));
                AppMethodBeat.o(153462);
                return concat;
            }
            String concat2 = "/sdcard/".concat(String.valueOf(substring));
            AppMethodBeat.o(153462);
            return concat2;
        }
        AppMethodBeat.o(153462);
        return k;
    }

    private static BitmapFactory.Options getImageOptionsJustDecodeBounds(String str) {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2;
        AppMethodBeat.i(175929);
        try {
            inputStream = s.openRead(str);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                MMBitmapFactory.decodeStream(inputStream, null, options);
                Util.qualityClose(inputStream);
                AppMethodBeat.o(175929);
                return options;
            } catch (FileNotFoundException e2) {
                inputStream2 = inputStream;
                Util.qualityClose(inputStream2);
                AppMethodBeat.o(175929);
                return null;
            } catch (Throwable th2) {
                th = th2;
                Util.qualityClose(inputStream);
                AppMethodBeat.o(175929);
                throw th;
            }
        } catch (FileNotFoundException e3) {
            inputStream2 = null;
            Util.qualityClose(inputStream2);
            AppMethodBeat.o(175929);
            return null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            Util.qualityClose(inputStream);
            AppMethodBeat.o(175929);
            throw th;
        }
    }

    private static void updateMediaDatabase(Context context, String str) {
        Uri contentUri;
        AppMethodBeat.i(175930);
        try {
            String mimeTypeByFilePath = MimeTypeUtil.getMimeTypeByFilePath(str);
            if (mimeTypeByFilePath == null) {
                AppMethodBeat.o(175930);
                return;
            }
            ContentValues contentValues = new ContentValues();
            if (mimeTypeByFilePath.contains("image")) {
                Uri contentUri2 = MediaStore.Images.Media.getContentUri("external");
                BitmapFactory.Options imageOptionsJustDecodeBounds = getImageOptionsJustDecodeBounds(str);
                if (imageOptionsJustDecodeBounds == null) {
                    AppMethodBeat.o(175930);
                    return;
                }
                contentValues.put("width", Integer.valueOf(imageOptionsJustDecodeBounds.outWidth));
                contentValues.put("height", Integer.valueOf(imageOptionsJustDecodeBounds.outHeight));
                if (mimeTypeByFilePath.contains("jpeg") || mimeTypeByFilePath.contains("jpg")) {
                    contentValues.put("orientation", Integer.valueOf(getExifOrientation(str)));
                }
                contentUri = contentUri2;
            } else if (mimeTypeByFilePath.contains("video")) {
                Uri contentUri3 = MediaStore.Video.Media.getContentUri("external");
                d dVar = new d();
                dVar.setDataSource(str);
                contentValues.put("width", dVar.extractMetadata(18));
                contentValues.put("height", dVar.extractMetadata(19));
                contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, dVar.extractMetadata(9));
                contentValues.put("orientation", dVar.extractMetadata(24));
                contentUri = contentUri3;
            } else {
                contentUri = MediaStore.Files.getContentUri("external");
            }
            String k = s.k(str, false);
            if (k == null) {
                k = str;
            }
            contentValues.put("_data", k);
            contentValues.put("_display_name", new o(str).getName());
            contentValues.put("title", s.bpb(str));
            contentValues.put("_size", Long.valueOf(s.boW(str)));
            contentValues.put("mime_type", mimeTypeByFilePath);
            context.getContentResolver().insert(contentUri, contentValues);
            AppMethodBeat.o(175930);
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "[-] Failed when updateMediaDatabase", new Object[0]);
            AppMethodBeat.o(175930);
        }
    }

    private static int getExifOrientation(String str) {
        AppMethodBeat.i(175931);
        if (Util.isNullOrNil(str)) {
            Log.d(TAG, "filepath is null or nil");
            AppMethodBeat.o(175931);
            return 0;
        } else if (!s.YS(str)) {
            Log.d(TAG, "file not exist:[%s]", str);
            AppMethodBeat.o(175931);
            return 0;
        } else {
            int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
            AppMethodBeat.o(175931);
            return orientationInDegree;
        }
    }
}
