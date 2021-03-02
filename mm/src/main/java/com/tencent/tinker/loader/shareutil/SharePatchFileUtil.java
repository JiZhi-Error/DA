package com.tencent.tinker.loader.shareutil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SharePatchFileUtil {
    private static final String TAG = "Tinker.PatchFileUtil";
    private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static File getPatchDirectory(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        return new File(applicationInfo.dataDir, (!"oppo".equalsIgnoreCase(Build.MANUFACTURER) || Build.VERSION.SDK_INT != 22) ? ShareConstants.PATCH_DIRECTORY_NAME : ShareConstants.PATCH_DIRECTORY_NAME_SPEC);
    }

    public static File getPatchTempDirectory(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        return new File(applicationInfo.dataDir, ShareConstants.PATCH_TEMP_DIRECTORY_NAME);
    }

    public static File getPatchLastCrashFile(Context context) {
        File patchTempDirectory = getPatchTempDirectory(context);
        if (patchTempDirectory == null) {
            return null;
        }
        return new File(patchTempDirectory, ShareConstants.PATCH_TEMP_LAST_CRASH_NAME);
    }

    public static File getPatchInfoFile(String str) {
        return new File(str + "/patch.info");
    }

    public static File getPatchInfoLockFile(String str) {
        return new File(str + "/info.lock");
    }

    public static String getPatchVersionDirectory(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ShareConstants.PATCH_BASE_NAME + str.substring(0, 8);
    }

    public static String getPatchVersionFile(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return getPatchVersionDirectory(str) + ".apk";
    }

    public static boolean checkIfMd5Valid(String str) {
        if (str == null || str.length() != 32) {
            return false;
        }
        return true;
    }

    public static String checkTinkerLastUncaughtCrash(Context context) {
        BufferedReader bufferedReader;
        Throwable th;
        File patchLastCrashFile = getPatchLastCrashFile(context);
        if (!isLegalFile(patchLastCrashFile)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(patchLastCrashFile)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuffer.append(readLine);
                        stringBuffer.append("\n");
                    } else {
                        closeQuietly(bufferedReader);
                        return stringBuffer.toString();
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ShareTinkerLog.e(TAG, "checkTinkerLastUncaughtCrash exception: ".concat(String.valueOf(e)), new Object[0]);
                        closeQuietly(bufferedReader);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        closeQuietly(bufferedReader);
                        throw th;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            ShareTinkerLog.e(TAG, "checkTinkerLastUncaughtCrash exception: ".concat(String.valueOf(e)), new Object[0]);
            closeQuietly(bufferedReader);
            return null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            closeQuietly(bufferedReader);
            throw th;
        }
    }

    @SuppressLint({"NewApi"})
    public static void closeQuietly(Object obj) {
        if (obj != null) {
            if (obj instanceof Closeable) {
                try {
                    ((Closeable) obj).close();
                } catch (Throwable th) {
                }
            } else if (Build.VERSION.SDK_INT >= 19 && (obj instanceof AutoCloseable)) {
                try {
                    ((AutoCloseable) obj).close();
                } catch (Throwable th2) {
                }
            } else if (obj instanceof ZipFile) {
                try {
                    ((ZipFile) obj).close();
                } catch (Throwable th3) {
                }
            } else {
                throw new IllegalArgumentException("obj: " + obj + " cannot be closed.");
            }
        }
    }

    public static final boolean isLegalFile(File file) {
        return file != null && file.exists() && file.canRead() && file.isFile() && file.length() > 0;
    }

    public static final boolean shouldAcceptEvenIfIllegal(File file) {
        boolean z;
        boolean z2;
        boolean z3 = "vivo".equalsIgnoreCase(Build.MANUFACTURER) || "oppo".equalsIgnoreCase(Build.MANUFACTURER) || "meizu".equalsIgnoreCase(Build.MANUFACTURER);
        if (Build.VERSION.SDK_INT >= 29 || ((Build.VERSION.SDK_INT >= 28 && Build.VERSION.PREVIEW_SDK_INT != 0) || ShareTinkerInternals.isArkHotRuning())) {
            z = true;
        } else {
            z = false;
        }
        if (!file.exists() || file.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        return (z3 || z) && z2;
    }

    public static long getFileOrDirectorySize(File file) {
        long length;
        long j2 = 0;
        if (file == null || !file.exists()) {
            return 0;
        }
        if (file.isFile()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                length = getFileOrDirectorySize(file2);
            } else {
                length = file2.length();
            }
            j2 += length;
        }
        return j2;
    }

    public static final boolean safeDeleteFile(File file) {
        boolean z = true;
        if (file != null && file.exists()) {
            ShareTinkerLog.i(TAG, "safeDeleteFile, try to delete path: " + file.getPath(), new Object[0]);
            z = file.delete();
            if (!z) {
                ShareTinkerLog.e(TAG, "Failed to delete file, try to delete when exit. path: " + file.getPath(), new Object[0]);
                file.deleteOnExit();
            }
        }
        return z;
    }

    public static final boolean deleteDir(String str) {
        if (str == null) {
            return false;
        }
        return deleteDir(new File(str));
    }

    public static final boolean deleteDir(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            safeDeleteFile(file);
        } else if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                deleteDir(file2);
            }
            safeDeleteFile(file);
        }
        return true;
    }

    public static boolean verifyFileMd5(File file, String str) {
        String md5;
        if (str == null || (md5 = getMD5(file)) == null) {
            return false;
        }
        return str.equals(md5);
    }

    public static boolean isRawDexFile(String str) {
        if (str == null) {
            return false;
        }
        return str.endsWith(ShareConstants.DEX_SUFFIX);
    }

    public static boolean verifyDexFileMd5(File file, String str) {
        return verifyDexFileMd5(file, "classes.dex", str);
    }

    public static boolean verifyDexFileMd5(File file, String str, String str2) {
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        InputStream inputStream = null;
        if (file == null || str2 == null || str == null) {
            return false;
        }
        String str3 = "";
        if (isRawDexFile(file.getName())) {
            str3 = getMD5(file);
        } else {
            try {
                zipFile = new ZipFile(file);
                try {
                    ZipEntry entry = zipFile.getEntry(str);
                    if (entry == null) {
                        ShareTinkerLog.e(TAG, "There's no entry named: classes.dex in " + file.getAbsolutePath(), new Object[0]);
                        closeZip(zipFile);
                        return false;
                    }
                    try {
                        inputStream = zipFile.getInputStream(entry);
                        str3 = getMD5(inputStream);
                    } catch (Throwable th) {
                        ShareTinkerLog.e(TAG, "exception occurred when get md5: " + file.getAbsolutePath(), th);
                    } finally {
                        closeQuietly(inputStream);
                    }
                    closeZip(zipFile);
                } catch (Throwable th2) {
                    th = th2;
                    closeZip(zipFile);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                zipFile = zipFile2;
                closeZip(zipFile);
                throw th;
            }
        }
        return str2.equals(str3);
    }

    public static void copyFileUsingStream(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        if (isLegalFile(file) && file2 != null && !file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2, false);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                    closeQuietly(fileInputStream);
                    closeQuietly(fileOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            closeQuietly(fileInputStream);
                            closeQuietly(fileOutputStream);
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(fileInputStream);
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                fileInputStream = null;
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream);
                throw th;
            }
        }
    }

    public static String loadDigestes(JarFile jarFile, JarEntry jarEntry) {
        BufferedInputStream bufferedInputStream;
        StringBuilder sb = new StringBuilder();
        try {
            byte[] bArr = new byte[16384];
            bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        sb.append(new String(bArr, 0, read));
                    } else {
                        closeQuietly(bufferedInputStream);
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(bufferedInputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            closeQuietly(bufferedInputStream);
            throw th;
        }
    }

    public static final String getMD5(InputStream inputStream) {
        byte[] digest;
        if (inputStream == null) {
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder(32);
            byte[] bArr = new byte[ShareConstants.MD5_FILE_BUF_LENGTH];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            for (byte b2 : instance.digest()) {
                sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e2) {
            return null;
        }
    }

    public static String getMD5(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr = new char[(length * 2)];
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                byte b2 = digest[i2];
                int i4 = i3 + 1;
                cArr[i3] = hexDigits[(b2 >>> 4) & 15];
                cArr[i4] = hexDigits[b2 & 15];
                i2++;
                i3 = i4 + 1;
            }
            return new String(cArr);
        } catch (Exception e2) {
            return null;
        }
    }

    public static String getMD5(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        Exception e2;
        String str = null;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    str = getMD5(fileInputStream);
                    closeQuietly(fileInputStream);
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        ShareTinkerLog.e(TAG, e2.getMessage(), new Object[0]);
                        closeQuietly(fileInputStream);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        closeQuietly(fileInputStream);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e2 = e4;
                fileInputStream = null;
                ShareTinkerLog.e(TAG, e2.getMessage(), new Object[0]);
                closeQuietly(fileInputStream);
                return str;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                closeQuietly(fileInputStream);
                throw th;
            }
        }
        return str;
    }

    public static String optimizedPathFor(File file, File file2) {
        if (ShareTinkerInternals.isAfterAndroidO()) {
            try {
                String currentInstructionSet = ShareTinkerInternals.getCurrentInstructionSet();
                File parentFile = file.getParentFile();
                String name = file.getName();
                int lastIndexOf = name.lastIndexOf(46);
                if (lastIndexOf > 0) {
                    name = name.substring(0, lastIndexOf);
                }
                return parentFile.getAbsolutePath() + "/oat/" + currentInstructionSet + FilePathGenerator.ANDROID_DIR_SEP + name + ShareConstants.ODEX_SUFFIX;
            } catch (Exception e2) {
                throw new TinkerRuntimeException("getCurrentInstructionSet fail:", e2);
            }
        } else {
            String name2 = file.getName();
            if (!name2.endsWith(ShareConstants.DEX_SUFFIX)) {
                int lastIndexOf2 = name2.lastIndexOf(".");
                if (lastIndexOf2 < 0) {
                    name2 = name2 + ShareConstants.DEX_SUFFIX;
                } else {
                    StringBuilder sb = new StringBuilder(lastIndexOf2 + 4);
                    sb.append((CharSequence) name2, 0, lastIndexOf2);
                    sb.append(ShareConstants.DEX_SUFFIX);
                    name2 = sb.toString();
                }
            }
            return new File(file2, name2).getPath();
        }
    }

    public static void closeZip(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e2) {
                ShareTinkerLog.w(TAG, "Failed to close resource", e2);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public static boolean checkResourceArscMd5(File file, String str) {
        Throwable th;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry(ShareConstants.RES_ARSC);
                if (entry == null) {
                    ShareTinkerLog.i(TAG, "checkResourceArscMd5 resources.arsc not found", new Object[0]);
                    closeZip(zipFile2);
                    return false;
                }
                try {
                    InputStream inputStream = zipFile2.getInputStream(entry);
                    String md5 = getMD5(inputStream);
                    if (md5 == null || !md5.equals(str)) {
                        closeQuietly(inputStream);
                        closeZip(zipFile2);
                        return false;
                    }
                    closeQuietly(inputStream);
                    closeZip(zipFile2);
                    return true;
                } catch (Throwable th2) {
                    closeQuietly(null);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                zipFile = zipFile2;
                closeZip(zipFile);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            ShareTinkerLog.i(TAG, "checkResourceArscMd5 throwable:" + th.getMessage(), new Object[0]);
            closeZip(zipFile);
            return false;
        }
    }

    public static void ensureFileDirectory(File file) {
        if (file != null) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
        }
    }
}
