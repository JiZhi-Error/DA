package com.tencent.xweb.util;

import android.content.res.AssetFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.xwalk.core.Log;

public final class c {
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d A[SYNTHETIC, Splitter:B:29:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0072 A[SYNTHETIC, Splitter:B:32:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077 A[SYNTHETIC, Splitter:B:35:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007c A[SYNTHETIC, Splitter:B:38:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008c A[SYNTHETIC, Splitter:B:44:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0091 A[SYNTHETIC, Splitter:B:47:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0096 A[SYNTHETIC, Splitter:B:50:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009b A[SYNTHETIC, Splitter:B:53:0x009b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFile(java.lang.String r12, java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 241
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.util.c.copyFile(java.lang.String, java.lang.String):boolean");
    }

    public static boolean g(File file, File file2) {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        Throwable th;
        AppMethodBeat.i(156992);
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                bufferedOutputStream = null;
                fileOutputStream = null;
                bufferedInputStream = null;
                try {
                    Log.e("FileUtils", "copyFile error:" + e.getMessage());
                    tryClose(bufferedInputStream);
                    tryClose(bufferedOutputStream);
                    tryClose(fileInputStream);
                    tryClose(fileOutputStream);
                    AppMethodBeat.o(156992);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    tryClose(bufferedInputStream);
                    tryClose(bufferedOutputStream);
                    tryClose(fileInputStream);
                    tryClose(fileOutputStream);
                    AppMethodBeat.o(156992);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                fileOutputStream = null;
                bufferedInputStream = null;
                tryClose(bufferedInputStream);
                tryClose(bufferedOutputStream);
                tryClose(fileInputStream);
                tryClose(fileOutputStream);
                AppMethodBeat.o(156992);
                throw th;
            }
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                } catch (Exception e3) {
                    e = e3;
                    bufferedOutputStream = null;
                    Log.e("FileUtils", "copyFile error:" + e.getMessage());
                    tryClose(bufferedInputStream);
                    tryClose(bufferedOutputStream);
                    tryClose(fileInputStream);
                    tryClose(fileOutputStream);
                    AppMethodBeat.o(156992);
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedOutputStream = null;
                    tryClose(bufferedInputStream);
                    tryClose(bufferedOutputStream);
                    tryClose(fileInputStream);
                    tryClose(fileOutputStream);
                    AppMethodBeat.o(156992);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            bufferedOutputStream.write(bArr, 0, read);
                        } else {
                            bufferedOutputStream.flush();
                            tryClose(bufferedInputStream);
                            tryClose(bufferedOutputStream);
                            tryClose(fileInputStream);
                            tryClose(fileOutputStream);
                            AppMethodBeat.o(156992);
                            return true;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    Log.e("FileUtils", "copyFile error:" + e.getMessage());
                    tryClose(bufferedInputStream);
                    tryClose(bufferedOutputStream);
                    tryClose(fileInputStream);
                    tryClose(fileOutputStream);
                    AppMethodBeat.o(156992);
                    return false;
                }
            } catch (Exception e5) {
                e = e5;
                bufferedOutputStream = null;
                fileOutputStream = null;
                Log.e("FileUtils", "copyFile error:" + e.getMessage());
                tryClose(bufferedInputStream);
                tryClose(bufferedOutputStream);
                tryClose(fileInputStream);
                tryClose(fileOutputStream);
                AppMethodBeat.o(156992);
                return false;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
                fileOutputStream = null;
                tryClose(bufferedInputStream);
                tryClose(bufferedOutputStream);
                tryClose(fileInputStream);
                tryClose(fileOutputStream);
                AppMethodBeat.o(156992);
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedOutputStream = null;
            fileOutputStream = null;
            bufferedInputStream = null;
            fileInputStream = null;
            Log.e("FileUtils", "copyFile error:" + e.getMessage());
            tryClose(bufferedInputStream);
            tryClose(bufferedOutputStream);
            tryClose(fileInputStream);
            tryClose(fileOutputStream);
            AppMethodBeat.o(156992);
            return false;
        } catch (Throwable th6) {
            th = th6;
            bufferedOutputStream = null;
            fileOutputStream = null;
            bufferedInputStream = null;
            fileInputStream = null;
            tryClose(bufferedInputStream);
            tryClose(bufferedOutputStream);
            tryClose(fileInputStream);
            tryClose(fileOutputStream);
            AppMethodBeat.o(156992);
            throw th;
        }
    }

    public static boolean og(String str, String str2) {
        AppMethodBeat.i(156993);
        File file = new File(str2);
        if (!file.isDirectory() || !file.exists()) {
            file.mkdirs();
        }
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            AppMethodBeat.o(156993);
            return false;
        }
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (!listFiles[i2].isFile() || g(listFiles[i2], new File(new File(str2).getAbsolutePath() + File.separator + listFiles[i2].getName()))) {
                listFiles[i2].isDirectory();
            } else {
                AppMethodBeat.o(156993);
                return false;
            }
        }
        AppMethodBeat.o(156993);
        return true;
    }

    public static boolean oh(String str, String str2) {
        AppMethodBeat.i(156994);
        File file = new File(str2);
        if (!file.isDirectory() || !file.exists()) {
            file.mkdirs();
        }
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            AppMethodBeat.o(156994);
            return false;
        }
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (listFiles[i2].isFile() && !g(listFiles[i2], new File(new File(str2).getAbsolutePath() + File.separator + listFiles[i2].getName()))) {
                AppMethodBeat.o(156994);
                return false;
            } else if (listFiles[i2].isDirectory() && !oh(str + FilePathGenerator.ANDROID_DIR_SEP + listFiles[i2].getName(), str2 + FilePathGenerator.ANDROID_DIR_SEP + listFiles[i2].getName())) {
                AppMethodBeat.o(156994);
                return false;
            }
        }
        AppMethodBeat.o(156994);
        return true;
    }

    public static boolean deleteFile(String str) {
        AppMethodBeat.i(156995);
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            AppMethodBeat.o(156995);
            return false;
        }
        file.delete();
        AppMethodBeat.o(156995);
        return true;
    }

    public static boolean bsB(String str) {
        AppMethodBeat.i(156996);
        try {
            deleteAll(new File(str));
            AppMethodBeat.o(156996);
            return true;
        } catch (Exception e2) {
            Log.i("FileUtils", String.format("delete all files.(%s)", str));
            AppMethodBeat.o(156996);
            return false;
        }
    }

    public static boolean ak(File file) {
        AppMethodBeat.i(219074);
        try {
            deleteAll(file);
            AppMethodBeat.o(219074);
            return true;
        } catch (Exception e2) {
            Log.i("FileUtils", String.format("safeDeleteAll all files.(%s)", file.getAbsolutePath()));
            AppMethodBeat.o(219074);
            return false;
        }
    }

    public static void deleteAll(File file) {
        AppMethodBeat.i(156997);
        if (file == null || !file.exists()) {
            AppMethodBeat.o(156997);
        } else if (file.isFile()) {
            file.delete();
            AppMethodBeat.o(156997);
        } else {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2 != null && file2.exists()) {
                            if (file2.isFile()) {
                                file2.delete();
                            } else {
                                deleteAll(file2);
                            }
                        }
                    }
                }
                file.delete();
            }
            AppMethodBeat.o(156997);
        }
    }

    public static void tryClose(Closeable closeable) {
        AppMethodBeat.i(156998);
        if (closeable == null) {
            AppMethodBeat.o(156998);
            return;
        }
        try {
            closeable.close();
            AppMethodBeat.o(156998);
        } catch (Exception e2) {
            Log.e("FileUtils", "closeable close  failed " + e2.getMessage());
            AppMethodBeat.o(156998);
        }
    }

    public static void a(AssetFileDescriptor assetFileDescriptor) {
        AppMethodBeat.i(156999);
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
                AppMethodBeat.o(156999);
                return;
            } catch (Exception e2) {
                Log.e("FileUtils", "tryClose AssetFileDescriptor error: " + e2.getMessage());
            }
        }
        AppMethodBeat.o(156999);
    }

    public static boolean a(AssetFileDescriptor assetFileDescriptor, File file) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        AppMethodBeat.i(157000);
        if (assetFileDescriptor == null) {
            Log.e("FileUtils", "copyFileFromDescriptorAndClose wrong param");
            AppMethodBeat.o(157000);
            return false;
        }
        try {
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                fileInputStream = assetFileDescriptor.createInputStream();
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
                try {
                    Log.e("FileUtils", "copyFileFromDescriptorAndClose error: " + e.getMessage());
                    tryClose(fileOutputStream);
                    tryClose(fileInputStream);
                    a(assetFileDescriptor);
                    AppMethodBeat.o(157000);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    tryClose(fileOutputStream);
                    tryClose(fileInputStream);
                    a(assetFileDescriptor);
                    AppMethodBeat.o(157000);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                tryClose(fileOutputStream);
                tryClose(fileInputStream);
                a(assetFileDescriptor);
                AppMethodBeat.o(157000);
                throw th;
            }
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        tryClose(fileOutputStream);
                        tryClose(fileInputStream);
                        a(assetFileDescriptor);
                        AppMethodBeat.o(157000);
                        return true;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                Log.e("FileUtils", "copyFileFromDescriptorAndClose error: " + e.getMessage());
                tryClose(fileOutputStream);
                tryClose(fileInputStream);
                a(assetFileDescriptor);
                AppMethodBeat.o(157000);
                return false;
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            fileOutputStream = null;
            Log.e("FileUtils", "copyFileFromDescriptorAndClose error: " + e.getMessage());
            tryClose(fileOutputStream);
            tryClose(fileInputStream);
            a(assetFileDescriptor);
            AppMethodBeat.o(157000);
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            fileOutputStream = null;
            tryClose(fileOutputStream);
            tryClose(fileInputStream);
            a(assetFileDescriptor);
            AppMethodBeat.o(157000);
            throw th;
        }
    }

    public static boolean b(InputStream inputStream, File file) {
        Throwable th;
        AppMethodBeat.i(157001);
        if (inputStream == null) {
            Log.e("FileUtils", "copyFileFromStreamAndClose wrong param");
            AppMethodBeat.o(157001);
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        fileOutputStream2.flush();
                        tryClose(fileOutputStream2);
                        tryClose(inputStream);
                        AppMethodBeat.o(157001);
                        return true;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                try {
                    Log.e("FileUtils", "copyFileFromStreamAndClose error: " + e.getMessage());
                    tryClose(fileOutputStream);
                    tryClose(inputStream);
                    AppMethodBeat.o(157001);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    tryClose(fileOutputStream);
                    tryClose(inputStream);
                    AppMethodBeat.o(157001);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                tryClose(fileOutputStream);
                tryClose(inputStream);
                AppMethodBeat.o(157001);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            Log.e("FileUtils", "copyFileFromStreamAndClose error: " + e.getMessage());
            tryClose(fileOutputStream);
            tryClose(inputStream);
            AppMethodBeat.o(157001);
            return false;
        }
    }
}
