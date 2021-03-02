package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsLogReport;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.zip.ZipEntry;

@SuppressLint({"NewApi"})
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static String f2244a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final a f2245b = new a() {
        /* class com.tencent.smtt.utils.f.AnonymousClass2 */

        @Override // com.tencent.smtt.utils.f.a
        public final boolean a(File file, File file2) {
            AppMethodBeat.i(54043);
            if (file.length() == file2.length() && file.lastModified() == file2.lastModified()) {
                AppMethodBeat.o(54043);
                return true;
            }
            AppMethodBeat.o(54043);
            return false;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final int f2246c = 4;

    /* renamed from: d  reason: collision with root package name */
    private static RandomAccessFile f2247d = null;

    public interface a {
        boolean a(File file, File file2);
    }

    public interface b {
        boolean a(InputStream inputStream, ZipEntry zipEntry, String str);
    }

    static /* synthetic */ boolean a(InputStream inputStream, ZipEntry zipEntry, String str, String str2) {
        AppMethodBeat.i(53914);
        boolean b2 = b(inputStream, zipEntry, str, str2);
        AppMethodBeat.o(53914);
        return b2;
    }

    static {
        AppMethodBeat.i(53915);
        AppMethodBeat.o(53915);
    }

    public static String a(Context context, int i2) {
        AppMethodBeat.i(53882);
        String a2 = a(context, context.getApplicationInfo().packageName, i2, true);
        AppMethodBeat.o(53882);
        return a2;
    }

    public static String a(Context context, String str, int i2, boolean z) {
        AppMethodBeat.i(53883);
        if (context == null) {
            AppMethodBeat.o(53883);
            return "";
        }
        String str2 = "";
        try {
            str2 = Environment.getExternalStorageDirectory() + File.separator;
        } catch (Exception e2) {
        }
        switch (i2) {
            case 1:
                if (str2.equals("")) {
                    AppMethodBeat.o(53883);
                    return str2;
                }
                String str3 = str2 + "tencent" + File.separator + "tbs" + File.separator + str;
                AppMethodBeat.o(53883);
                return str3;
            case 2:
                if (str2.equals("")) {
                    AppMethodBeat.o(53883);
                    return str2;
                }
                String str4 = str2 + "tbs" + File.separator + "backup" + File.separator + str;
                AppMethodBeat.o(53883);
                return str4;
            case 3:
                if (str2.equals("")) {
                    AppMethodBeat.o(53883);
                    return str2;
                }
                String str5 = str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + str;
                AppMethodBeat.o(53883);
                return str5;
            case 4:
                if (str2.equals("")) {
                    String b2 = b(context, "backup");
                    AppMethodBeat.o(53883);
                    return b2;
                }
                String str6 = str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + str;
                if (z) {
                    File file = new File(str6);
                    if (!file.exists() || !file.canWrite()) {
                        if (!file.exists()) {
                            file.mkdirs();
                            if (!file.canWrite()) {
                                str6 = b(context, "backup");
                            }
                        } else {
                            str6 = b(context, "backup");
                        }
                    }
                }
                AppMethodBeat.o(53883);
                return str6;
            case 5:
                if (str2.equals("")) {
                    AppMethodBeat.o(53883);
                    return str2;
                }
                String str7 = str2 + "tencent" + File.separator + "tbs" + File.separator + str;
                AppMethodBeat.o(53883);
                return str7;
            case 6:
                if (f2244a != null) {
                    String str8 = f2244a;
                    AppMethodBeat.o(53883);
                    return str8;
                }
                String b3 = b(context, "tbslog");
                f2244a = b3;
                AppMethodBeat.o(53883);
                return b3;
            case 7:
                if (str2.equals("")) {
                    AppMethodBeat.o(53883);
                    return str2;
                }
                String str9 = str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + "core";
                AppMethodBeat.o(53883);
                return str9;
            default:
                AppMethodBeat.o(53883);
                return "";
        }
    }

    private static String b(Context context, String str) {
        String str2;
        AppMethodBeat.i(53884);
        if (context == null) {
            AppMethodBeat.o(53884);
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        try {
            str2 = context.getExternalFilesDir(str).getAbsolutePath();
        } catch (Throwable th) {
            try {
                str2 = Environment.getExternalStorageDirectory() + File.separator + "Android" + File.separator + "data" + File.separator + context.getApplicationInfo().packageName + File.separator + "files" + File.separator + str;
            } catch (Exception e2) {
                AppMethodBeat.o(53884);
                return "";
            }
        }
        AppMethodBeat.o(53884);
        return str2;
    }

    public static boolean a(Context context) {
        boolean z = true;
        AppMethodBeat.i(53885);
        if (Build.VERSION.SDK_INT < 23) {
            AppMethodBeat.o(53885);
        } else {
            if (context == null) {
                z = false;
            } else if (context.getApplicationContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                z = false;
            }
            AppMethodBeat.o(53885);
        }
        return z;
    }

    public static boolean a(File file, File file2) {
        AppMethodBeat.i(53886);
        boolean a2 = a(file.getPath(), file2.getPath());
        AppMethodBeat.o(53886);
        return a2;
    }

    @SuppressLint({"InlinedApi"})
    public static boolean a(String str, String str2) {
        AppMethodBeat.i(53887);
        boolean a2 = a(str, str2, Build.CPU_ABI, Build.VERSION.SDK_INT >= 8 ? Build.CPU_ABI2 : null, j.a("ro.product.cpu.upgradeabi", "armeabi"));
        AppMethodBeat.o(53887);
        return a2;
    }

    private static boolean a(String str, final String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(53888);
        boolean a2 = a(str, str3, str4, str5, new b() {
            /* class com.tencent.smtt.utils.f.AnonymousClass1 */

            @Override // com.tencent.smtt.utils.f.b
            public final boolean a(InputStream inputStream, ZipEntry zipEntry, String str) {
                AppMethodBeat.i(54004);
                try {
                    boolean a2 = f.a(inputStream, zipEntry, str2, str);
                    AppMethodBeat.o(54004);
                    return a2;
                } catch (Exception e2) {
                    Exception exc = new Exception("copyFileIfChanged Exception", e2);
                    AppMethodBeat.o(54004);
                    throw exc;
                }
            }
        });
        AppMethodBeat.o(53888);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, com.tencent.smtt.utils.f.b r14) {
        /*
        // Method dump skipped, instructions count: 396
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.f.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.tencent.smtt.utils.f$b):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006a  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(java.io.InputStream r10, java.util.zip.ZipEntry r11, java.lang.String r12, java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 197
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.f.b(java.io.InputStream, java.util.zip.ZipEntry, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.lang.String r9, long r10, long r12, long r14) {
        /*
        // Method dump skipped, instructions count: 170
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.f.a(java.lang.String, long, long, long):boolean");
    }

    public static boolean b(File file, File file2) {
        AppMethodBeat.i(53892);
        boolean a2 = a(file, file2, (FileFilter) null);
        AppMethodBeat.o(53892);
        return a2;
    }

    public static boolean a(File file, File file2, FileFilter fileFilter) {
        AppMethodBeat.i(53893);
        boolean a2 = a(file, file2, fileFilter, f2245b);
        AppMethodBeat.o(53893);
        return a2;
    }

    public static boolean a(File file, File file2, FileFilter fileFilter, a aVar) {
        AppMethodBeat.i(53894);
        if (file == null || file2 == null) {
            AppMethodBeat.o(53894);
            return false;
        } else if (!file.exists()) {
            AppMethodBeat.o(53894);
            return false;
        } else if (file.isFile()) {
            boolean b2 = b(file, file2, fileFilter, aVar);
            AppMethodBeat.o(53894);
            return b2;
        } else {
            File[] listFiles = file.listFiles(fileFilter);
            if (listFiles == null) {
                AppMethodBeat.o(53894);
                return false;
            }
            boolean z = true;
            for (File file3 : listFiles) {
                if (!a(file3, new File(file2, file3.getName()), fileFilter)) {
                    z = false;
                }
            }
            AppMethodBeat.o(53894);
            return z;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(java.io.File r9, java.io.File r10, java.io.FileFilter r11, com.tencent.smtt.utils.f.a r12) {
        /*
        // Method dump skipped, instructions count: 225
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.f.b(java.io.File, java.io.File, java.io.FileFilter, com.tencent.smtt.utils.f$a):boolean");
    }

    public static boolean a(File file) {
        AppMethodBeat.i(53896);
        if (file == null) {
            AppMethodBeat.o(53896);
            return false;
        } else if (!file.exists() || !file.isDirectory()) {
            b(file);
            boolean mkdirs = file.mkdirs();
            AppMethodBeat.o(53896);
            return mkdirs;
        } else {
            AppMethodBeat.o(53896);
            return true;
        }
    }

    public static void b(File file) {
        AppMethodBeat.i(53897);
        a(file, false);
        AppMethodBeat.o(53897);
    }

    public static void a(File file, boolean z) {
        AppMethodBeat.i(53898);
        TbsLog.i("FileUtils", "delete file,ignore=" + z + file + Log.getStackTraceString(new Throwable()));
        if (file == null || !file.exists()) {
            AppMethodBeat.o(53898);
        } else if (file.isFile()) {
            file.delete();
            AppMethodBeat.o(53898);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.o(53898);
                return;
            }
            for (File file2 : listFiles) {
                a(file2, z);
            }
            if (!z) {
                file.delete();
            }
            AppMethodBeat.o(53898);
        }
    }

    public static void a(File file, boolean z, String str) {
        AppMethodBeat.i(53899);
        TbsLog.i("FileUtils", "delete file,ignore=" + z + "except" + str + file + Log.getStackTraceString(new Throwable()));
        if (file == null || !file.exists()) {
            AppMethodBeat.o(53899);
        } else if (file.isFile()) {
            file.delete();
            AppMethodBeat.o(53899);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.o(53899);
                return;
            }
            for (File file2 : listFiles) {
                if (!file2.getName().equals(str)) {
                    a(file2, z);
                }
            }
            if (!z) {
                file.delete();
            }
            AppMethodBeat.o(53899);
        }
    }

    public static boolean c(File file) {
        AppMethodBeat.i(53900);
        if (file == null || !file.exists() || !file.isFile() || file.length() <= 0) {
            AppMethodBeat.o(53900);
            return false;
        }
        AppMethodBeat.o(53900);
        return true;
    }

    public static FileOutputStream d(File file) {
        AppMethodBeat.i(53901);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                IOException iOException = new IOException("File '" + file + "' could not be created");
                AppMethodBeat.o(53901);
                throw iOException;
            }
        } else if (file.isDirectory()) {
            IOException iOException2 = new IOException("File '" + file + "' exists but is a directory");
            AppMethodBeat.o(53901);
            throw iOException2;
        } else if (!file.canWrite()) {
            IOException iOException3 = new IOException("File '" + file + "' cannot be written to");
            AppMethodBeat.o(53901);
            throw iOException3;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        AppMethodBeat.o(53901);
        return fileOutputStream;
    }

    public static boolean b(Context context) {
        AppMethodBeat.i(53902);
        long a2 = q.a();
        boolean z = a2 >= TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
        if (!z) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = ".concat(String.valueOf(a2)));
        }
        AppMethodBeat.o(53902);
        return z;
    }

    public static String c(Context context) {
        AppMethodBeat.i(53903);
        String str = Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "file_locks";
        AppMethodBeat.o(53903);
        return str;
    }

    static String d(Context context) {
        AppMethodBeat.i(53904);
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            String absolutePath = file.getAbsolutePath();
            AppMethodBeat.o(53904);
            return absolutePath;
        }
        AppMethodBeat.o(53904);
        return null;
    }

    public static File a(Context context, boolean z, String str) {
        String c2;
        AppMethodBeat.i(53905);
        if (z) {
            c2 = d(context);
        } else {
            c2 = c(context);
        }
        if (c2 == null) {
            AppMethodBeat.o(53905);
            return null;
        }
        File file = new File(c2);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canWrite()) {
            AppMethodBeat.o(53905);
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e2) {
                AppMethodBeat.o(53905);
                return null;
            }
        }
        AppMethodBeat.o(53905);
        return file2;
    }

    public static File a(Context context, String str) {
        AppMethodBeat.i(53906);
        File file = new File(context.getFilesDir(), "tbs");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canWrite()) {
            TbsLog.e("FileHelper", "getPermanentTbsFile -- no permission!");
            AppMethodBeat.o(53906);
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e2) {
                TbsLog.e("FileHelper", "getPermanentTbsFile -- exception: ".concat(String.valueOf(e2)));
                AppMethodBeat.o(53906);
                return null;
            }
        }
        AppMethodBeat.o(53906);
        return file2;
    }

    public static FileOutputStream b(Context context, boolean z, String str) {
        AppMethodBeat.i(53907);
        File a2 = a(context, z, str);
        if (a2 != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(a2);
                AppMethodBeat.o(53907);
                return fileOutputStream;
            } catch (FileNotFoundException e2) {
            }
        }
        AppMethodBeat.o(53907);
        return null;
    }

    public static FileLock a(Context context, FileOutputStream fileOutputStream) {
        AppMethodBeat.i(53908);
        if (fileOutputStream == null) {
            AppMethodBeat.o(53908);
            return null;
        }
        try {
            FileLock tryLock = fileOutputStream.getChannel().tryLock();
            if (tryLock.isValid()) {
                AppMethodBeat.o(53908);
                return tryLock;
            }
        } catch (Exception | OverlappingFileLockException e2) {
        }
        AppMethodBeat.o(53908);
        return null;
    }

    public static void a(FileLock fileLock, FileOutputStream fileOutputStream) {
        AppMethodBeat.i(53909);
        if (fileLock != null) {
            try {
                FileChannel channel = fileLock.channel();
                if (channel != null && channel.isOpen()) {
                    fileLock.release();
                }
            } catch (Exception e2) {
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
                AppMethodBeat.o(53909);
                return;
            } catch (Exception e3) {
            }
        }
        AppMethodBeat.o(53909);
    }

    public static FileLock e(Context context) {
        boolean z;
        FileLock fileLock = null;
        AppMethodBeat.i(53910);
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #1");
        try {
            z = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable th) {
            z = true;
        }
        if (!z) {
            FileOutputStream b2 = b(context, true, "tbs_rename_lock");
            if (b2 == null) {
                TbsLog.i("FileHelper", "init -- failed to get rename fileLock#1!");
            } else {
                fileLock = a(context, b2);
                if (fileLock == null) {
                    TbsLog.i("FileHelper", "init -- failed to get rename fileLock#2!");
                } else {
                    TbsLog.i("FileHelper", "init -- get rename fileLock success!");
                }
            }
            TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #2 renameFileLock is ".concat(String.valueOf(fileLock)));
            AppMethodBeat.o(53910);
        } else {
            TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #3");
            File a2 = a(context, "tbs_rename_lock");
            TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #4 ".concat(String.valueOf(a2)));
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(a2.getAbsolutePath(), "r");
                f2247d = randomAccessFile;
                fileLock = randomAccessFile.getChannel().tryLock(0, MAlarmHandler.NEXT_FIRE_INTERVAL, true);
            } catch (Throwable th2) {
                TbsLog.e("FileHelper", "getTbsCoreLoadFileLock -- exception: ".concat(String.valueOf(th2)));
            }
            if (fileLock == null) {
                fileLock = g(context);
            }
            if (fileLock == null) {
                TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- failed: ".concat(String.valueOf("tbs_rename_lock")));
            } else {
                TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- success: ".concat(String.valueOf("tbs_rename_lock")));
            }
            AppMethodBeat.o(53910);
        }
        return fileLock;
    }

    private static FileLock g(Context context) {
        boolean z;
        AppMethodBeat.i(53911);
        FileLock fileLock = null;
        try {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            tbsLogInfo.setErrorCode(803);
            File a2 = a(context, "tbs_rename_lock");
            if (TbsDownloadConfig.getInstance(context).getTbsCoreLoadRenameFileLockWaitEnable()) {
                int i2 = 0;
                while (i2 < 20 && fileLock == null) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e2) {
                    }
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(a2.getAbsolutePath(), "r");
                        f2247d = randomAccessFile;
                        fileLock = randomAccessFile.getChannel().tryLock(0, MAlarmHandler.NEXT_FIRE_INTERVAL, true);
                    } catch (Throwable th) {
                    }
                    i2++;
                }
                if (fileLock != null) {
                    tbsLogInfo.setErrorCode(802);
                } else {
                    tbsLogInfo.setErrorCode(801);
                }
                TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, tbsLogInfo);
                StringBuilder append = new StringBuilder("getTbsCoreLoadFileLock,retry num=").append(i2).append("success=");
                if (fileLock == null) {
                    z = true;
                } else {
                    z = false;
                }
                TbsLog.i("FileHelper", append.append(z).toString());
            }
        } catch (Exception e3) {
        }
        AppMethodBeat.o(53911);
        return fileLock;
    }

    public static FileLock f(Context context) {
        AppMethodBeat.i(53912);
        TbsLog.d("FileHelper", "getTbsCoreRenameFileLock begin");
        FileLock fileLock = null;
        File a2 = a(context, "tbs_rename_lock");
        TbsLog.i("FileHelper", "getTbsCoreRenameFileLock #1 ".concat(String.valueOf(a2)));
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(a2.getAbsolutePath(), "rw");
            f2247d = randomAccessFile;
            fileLock = randomAccessFile.getChannel().tryLock(0, MAlarmHandler.NEXT_FIRE_INTERVAL, false);
        } catch (Throwable th) {
            TbsLog.e("FileHelper", "getTbsCoreRenameFileLock -- excpetion: ".concat(String.valueOf("tbs_rename_lock")));
        }
        if (fileLock == null) {
            TbsLog.i("FileHelper", "getTbsCoreRenameFileLock -- failed: ".concat(String.valueOf("tbs_rename_lock")));
        } else {
            TbsLog.i("FileHelper", "getTbsCoreRenameFileLock -- success: ".concat(String.valueOf("tbs_rename_lock")));
        }
        AppMethodBeat.o(53912);
        return fileLock;
    }

    public static synchronized void a(Context context, FileLock fileLock) {
        synchronized (f.class) {
            AppMethodBeat.i(53913);
            TbsLog.i("FileHelper", "releaseTbsCoreRenameFileLock -- lock: ".concat(String.valueOf(fileLock)));
            FileChannel channel = fileLock.channel();
            if (channel != null && channel.isOpen()) {
                try {
                    fileLock.release();
                    AppMethodBeat.o(53913);
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(53913);
        }
    }
}
