package org.xwalk.core;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.xweb.util.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class XWalkDecompressor {
    private static final int LZMA_OUTSIZE = 8;
    private static final int LZMA_PROP_SIZE = 5;
    private static final String[] MANDATORY_LIBRARIES = {"libxwalkcore.so"};
    private static final int STREAM_BUFFER_SIZE = 1048576;
    private static final String TAG = "XWalkLib";

    public static boolean extractResource(String str, String str2, String[] strArr) {
        ZipFile zipFile;
        Throwable th;
        ZipEntry entry;
        AppMethodBeat.i(207386);
        Log.i(TAG, "Extract resource from Apk ".concat(String.valueOf(str)));
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            zipFile = new ZipFile(str);
            try {
                for (String str3 : strArr) {
                    if (isNativeLibrary(str3)) {
                        entry = zipFile.getEntry(ShareConstants.SO_PATH + File.separator + "armeabi" + File.separator + str3);
                    } else if (isAsset(str3)) {
                        entry = zipFile.getEntry("assets" + File.separator + str3);
                    } else {
                        entry = zipFile.getEntry(str3);
                    }
                    if (entry != null) {
                        Log.d(TAG, "Extracting ".concat(String.valueOf(str3)));
                        File file = new File(str2, str3);
                        if (file.isFile() && file.exists()) {
                            file.delete();
                        }
                        extractStreamToFile(zipFile.getInputStream(entry), new File(str2, str3));
                    } else if (isClassesDex(str3)) {
                        Log.i(TAG, str3 + " not found, may be it is new version of package");
                    } else {
                        Log.e(TAG, str3 + " not found");
                        try {
                            zipFile.close();
                        } catch (IOException | NullPointerException e2) {
                        }
                        AppMethodBeat.o(207386);
                        return false;
                    }
                }
                try {
                    zipFile.close();
                } catch (IOException | NullPointerException e3) {
                }
                System.gc();
                Log.d(TAG, "Time to extract : " + (SystemClock.uptimeMillis() - uptimeMillis) + " ms");
                AppMethodBeat.o(207386);
                return true;
            } catch (IOException e4) {
                e = e4;
                try {
                    Log.e(TAG, "Extract error:" + e.getLocalizedMessage());
                    try {
                        zipFile.close();
                    } catch (IOException | NullPointerException e5) {
                    }
                    AppMethodBeat.o(207386);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        zipFile.close();
                    } catch (IOException | NullPointerException e6) {
                    }
                    AppMethodBeat.o(207386);
                    throw th;
                }
            }
        } catch (IOException e7) {
            e = e7;
            zipFile = null;
            Log.e(TAG, "Extract error:" + e.getLocalizedMessage());
            zipFile.close();
            AppMethodBeat.o(207386);
            return false;
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            zipFile.close();
            AppMethodBeat.o(207386);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e0 A[SYNTHETIC, Splitter:B:38:0x00e0] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e5 A[Catch:{ Exception -> 0x014f }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ea A[Catch:{ Exception -> 0x014f }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fa A[SYNTHETIC, Splitter:B:49:0x00fa] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ff A[Catch:{ Exception -> 0x0142 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0104 A[Catch:{ Exception -> 0x0142 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean decompressDownloadFullZip(java.lang.String r12, int r13) {
        /*
        // Method dump skipped, instructions count: 351
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xwalk.core.XWalkDecompressor.decompressDownloadFullZip(java.lang.String, int):boolean");
    }

    public static boolean decompressDownloadPatchZip(String str, String str2) {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        ZipFile zipFile;
        Throwable th;
        AppMethodBeat.i(154685);
        Log.d(TAG, "decompress from zip ".concat(String.valueOf(str)));
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            zipFile = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                fileOutputStream = null;
                inputStream = null;
                while (entries.hasMoreElements()) {
                    try {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        String encode = URLEncoder.encode(zipEntry.getName(), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                        if (!encode.contains("../") && !encode.contains("..\\") && !zipEntry.isDirectory()) {
                            c.tryClose(inputStream);
                            inputStream = zipFile.getInputStream(zipEntry);
                            File file = new File(str2, encode);
                            if (!file.exists()) {
                                File parentFile = file.getParentFile();
                                if (!parentFile.exists()) {
                                    parentFile.mkdirs();
                                }
                            } else {
                                file.delete();
                            }
                            c.tryClose(fileOutputStream);
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[1048576];
                                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                                    fileOutputStream2.write(bArr, 0, read);
                                }
                                fileOutputStream = fileOutputStream2;
                            } catch (IOException e2) {
                                e = e2;
                                fileOutputStream = fileOutputStream2;
                                try {
                                    Log.e(TAG, "decompressDownloadPatchZip error:" + e.getLocalizedMessage());
                                    try {
                                        zipFile.close();
                                    } catch (IOException | NullPointerException e3) {
                                    }
                                    c.tryClose(fileOutputStream);
                                    c.tryClose(inputStream);
                                    AppMethodBeat.o(154685);
                                    return false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        zipFile.close();
                                    } catch (IOException | NullPointerException e4) {
                                    }
                                    c.tryClose(fileOutputStream);
                                    c.tryClose(inputStream);
                                    AppMethodBeat.o(154685);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = fileOutputStream2;
                                zipFile.close();
                                c.tryClose(fileOutputStream);
                                c.tryClose(inputStream);
                                AppMethodBeat.o(154685);
                                throw th;
                            }
                        }
                    } catch (IOException e5) {
                        e = e5;
                        Log.e(TAG, "decompressDownloadPatchZip error:" + e.getLocalizedMessage());
                        zipFile.close();
                        c.tryClose(fileOutputStream);
                        c.tryClose(inputStream);
                        AppMethodBeat.o(154685);
                        return false;
                    }
                }
                try {
                    zipFile.close();
                } catch (IOException | NullPointerException e6) {
                }
                c.tryClose(fileOutputStream);
                c.tryClose(inputStream);
                System.gc();
                Log.d(TAG, "Time to decompress : " + (SystemClock.uptimeMillis() - uptimeMillis) + " ms");
                AppMethodBeat.o(154685);
                return true;
            } catch (IOException e7) {
                e = e7;
                fileOutputStream = null;
                inputStream = null;
                Log.e(TAG, "decompressDownloadPatchZip error:" + e.getLocalizedMessage());
                zipFile.close();
                c.tryClose(fileOutputStream);
                c.tryClose(inputStream);
                AppMethodBeat.o(154685);
                return false;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                inputStream = null;
                zipFile.close();
                c.tryClose(fileOutputStream);
                c.tryClose(inputStream);
                AppMethodBeat.o(154685);
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            fileOutputStream = null;
            inputStream = null;
            zipFile = null;
            Log.e(TAG, "decompressDownloadPatchZip error:" + e.getLocalizedMessage());
            zipFile.close();
            c.tryClose(fileOutputStream);
            c.tryClose(inputStream);
            AppMethodBeat.o(154685);
            return false;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            inputStream = null;
            zipFile = null;
            zipFile.close();
            c.tryClose(fileOutputStream);
            c.tryClose(inputStream);
            AppMethodBeat.o(154685);
            throw th;
        }
    }

    private static boolean isNativeLibrary(String str) {
        AppMethodBeat.i(154686);
        boolean endsWith = str.endsWith(".so");
        AppMethodBeat.o(154686);
        return endsWith;
    }

    private static boolean isAsset(String str) {
        AppMethodBeat.i(154687);
        if (str.endsWith(".dat") || str.endsWith(".pak") || str.endsWith(".js")) {
            AppMethodBeat.o(154687);
            return true;
        }
        AppMethodBeat.o(154687);
        return false;
    }

    private static boolean isClassesDex(String str) {
        AppMethodBeat.i(154688);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(154688);
            return false;
        }
        boolean endsWith = str.endsWith("classes.dex");
        AppMethodBeat.o(154688);
        return endsWith;
    }

    private static InputStream openRawResource(String str) {
        AppMethodBeat.i(154689);
        Context applicationContext = XWalkEnvironment.getApplicationContext();
        Resources resources = applicationContext.getResources();
        InputStream openRawResource = resources.openRawResource(resources.getIdentifier(str.split("\\.")[0], ShareConstants.DEXMODE_RAW, applicationContext.getPackageName()));
        AppMethodBeat.o(154689);
        return openRawResource;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A[Catch:{ all -> 0x0043 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void extractLzmaToFile(java.io.InputStream r11, java.io.File r12) {
        /*
        // Method dump skipped, instructions count: 215
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xwalk.core.XWalkDecompressor.extractLzmaToFile(java.io.InputStream, java.io.File):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025 A[Catch:{ all -> 0x002f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void extractStreamToFile(java.io.InputStream r5, java.io.File r6) {
        /*
        // Method dump skipped, instructions count: 107
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xwalk.core.XWalkDecompressor.extractStreamToFile(java.io.InputStream, java.io.File):void");
    }

    public static void copyApkToLocal(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Throwable th;
        AppMethodBeat.i(154692);
        Log.d(TAG, "Copy to local from Apk ".concat(String.valueOf(str)));
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            c.tryClose(fileInputStream);
                            c.tryClose(fileOutputStream);
                            AppMethodBeat.o(154692);
                            return;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.e("copyApkToLocal error:", e.getMessage());
                        c.tryClose(fileInputStream);
                        c.tryClose(fileOutputStream);
                        AppMethodBeat.o(154692);
                    } catch (Throwable th2) {
                        th = th2;
                        c.tryClose(fileInputStream);
                        c.tryClose(fileOutputStream);
                        AppMethodBeat.o(154692);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                Log.e("copyApkToLocal error:", e.getMessage());
                c.tryClose(fileInputStream);
                c.tryClose(fileOutputStream);
                AppMethodBeat.o(154692);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                c.tryClose(fileInputStream);
                c.tryClose(fileOutputStream);
                AppMethodBeat.o(154692);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            fileInputStream = null;
            Log.e("copyApkToLocal error:", e.getMessage());
            c.tryClose(fileInputStream);
            c.tryClose(fileOutputStream);
            AppMethodBeat.o(154692);
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            fileInputStream = null;
            c.tryClose(fileInputStream);
            c.tryClose(fileOutputStream);
            AppMethodBeat.o(154692);
            throw th;
        }
    }
}
