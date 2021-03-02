package com.tencent.midas.comm.log.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

public class APLogFileUtil {
    private static final String DEBUG_CONF = "MidasLogDebug.ini";
    private static final int DEFAULT_MAX_LOG_FILE_NUM = 2;
    private static final int DEFAULT_MAX_LOG_FILE_SIZE_MB = 1;
    private static final int DEFAULT_MAX_LOG_KEEP_DAYS = 15;
    public static final String SEPARATOR_LINE = "\r\n";
    public static final String SEPARATOR_LOG = " | ";
    private static int maxDirSizeMB = ((maxLogFileNum * 15) * maxLogFileSizeMB);
    public static int maxLogFileNum = 2;
    public static int maxLogFileSizeMB = 1;
    public static int maxLogKeepDays = 15;
    public static int minSDCardSpace = 20;

    public static double getFileOrFilesSize(String str) {
        AppMethodBeat.i(193450);
        File file = new File(str);
        long j2 = 0;
        try {
            if (file.isDirectory()) {
                j2 = getFileSizes(file);
            } else {
                j2 = getFileSize(file);
            }
        } catch (Throwable th) {
        }
        double d2 = (double) ((j2 / 1024) / 1024);
        AppMethodBeat.o(193450);
        return d2;
    }

    private static long getFileSize(File file) {
        AppMethodBeat.i(193451);
        long j2 = 0;
        try {
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                j2 = (long) fileInputStream.available();
                fileInputStream.close();
            } else {
                file.createNewFile();
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(193451);
        return j2;
    }

    private static long getFileSizes(File file) {
        long fileSize;
        AppMethodBeat.i(193452);
        long j2 = 0;
        File[] listFiles = file.listFiles();
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (listFiles[i2].isDirectory()) {
                fileSize = getFileSizes(listFiles[i2]);
            } else {
                fileSize = getFileSize(listFiles[i2]);
            }
            j2 += fileSize;
        }
        AppMethodBeat.o(193452);
        return j2;
    }

    public static double getSDCardSpace() {
        long j2;
        AppMethodBeat.i(193453);
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            j2 = ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024) / 1024;
        } catch (Throwable th) {
            new StringBuilder("getSDCardSpace: ").append(th.toString());
            j2 = 0;
        }
        double d2 = (double) j2;
        AppMethodBeat.o(193453);
        return d2;
    }

    public static void deleteOldFileToday(String str) {
        AppMethodBeat.i(193454);
        deleteOldFileToday(str, maxLogFileNum);
        AppMethodBeat.o(193454);
    }

    public static void deleteOldFileToday(String str, int i2) {
        AppMethodBeat.i(193455);
        ArrayList<File> logFiles = getLogFiles(str, getToday() + "_");
        int size = logFiles.size();
        if (size >= i2 && i2 > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                File file = logFiles.get(i3);
                if (file != null) {
                    new StringBuilder("get: ").append(file.getName());
                    if (i3 < size - i2) {
                        new StringBuilder("delete: ").append(file.getName());
                        file.delete();
                    }
                }
            }
        }
        AppMethodBeat.o(193455);
    }

    public static String getLastLogFileName(String str) {
        AppMethodBeat.i(193456);
        ArrayList<File> logFiles = getLogFiles(str, getToday());
        if (logFiles.size() > 0) {
            String name = logFiles.get(logFiles.size() - 1).getName();
            AppMethodBeat.o(193456);
            return name;
        }
        AppMethodBeat.o(193456);
        return "";
    }

    public static ArrayList<File> getLogFiles(String str, final String str2) {
        AppMethodBeat.i(193457);
        File file = new File(str);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new FilenameFilter() {
                /* class com.tencent.midas.comm.log.util.APLogFileUtil.AnonymousClass1 */

                public final boolean accept(File file, String str) {
                    AppMethodBeat.i(193446);
                    boolean startsWith = str.startsWith(str2);
                    AppMethodBeat.o(193446);
                    return startsWith;
                }
            });
            Arrays.sort(listFiles, new Comparator<File>() {
                /* class com.tencent.midas.comm.log.util.APLogFileUtil.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(File file, File file2) {
                    AppMethodBeat.i(193449);
                    int compare = compare(file, file2);
                    AppMethodBeat.o(193449);
                    return compare;
                }

                public final int compare(File file, File file2) {
                    AppMethodBeat.i(193447);
                    int extractNumber = extractNumber(file.getName()) - extractNumber(file2.getName());
                    AppMethodBeat.o(193447);
                    return extractNumber;
                }

                private int extractNumber(String str) {
                    int i2;
                    AppMethodBeat.i(193448);
                    try {
                        i2 = Integer.parseInt(str.substring(str.indexOf(95) + 1, str.lastIndexOf(46)));
                    } catch (Throwable th) {
                        i2 = 0;
                    }
                    AppMethodBeat.o(193448);
                    return i2;
                }
            });
            ArrayList<File> arrayList = new ArrayList<>(Arrays.asList(listFiles));
            AppMethodBeat.o(193457);
            return arrayList;
        }
        ArrayList<File> arrayList2 = new ArrayList<>();
        AppMethodBeat.o(193457);
        return arrayList2;
    }

    public static String getToday() {
        AppMethodBeat.i(193458);
        String format = new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date(System.currentTimeMillis()));
        AppMethodBeat.o(193458);
        return format;
    }

    public static void deleteFileUpMaxInDir(String str, long j2, long j3, int i2) {
        AppMethodBeat.i(193459);
        try {
            File file = new File(str);
            if (!file.exists() || file.isFile()) {
                AppMethodBeat.o(193459);
                return;
            }
            boolean z = getFileOrFilesSize(str) >= ((double) j3);
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                AppMethodBeat.o(193459);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            for (File file2 : listFiles) {
                long lastModified = file2.lastModified();
                if (!file2.getName().equals("MidasLog.mmap") && file2.isFile() && (z || currentTimeMillis - lastModified > ((long) (i2 * 24 * LocalCache.TIME_HOUR * 1000)) || (getFileSize(file2) / 1024) / 1024 >= j2)) {
                    file2.delete();
                }
            }
            AppMethodBeat.o(193459);
        } catch (Throwable th) {
            AppMethodBeat.o(193459);
        }
    }

    public static boolean initLogDir(String str) {
        AppMethodBeat.i(193460);
        try {
            File file = new File(str);
            if (!file.exists()) {
                boolean mkdirs = file.mkdirs();
                AppMethodBeat.o(193460);
                return mkdirs;
            }
            deleteFileUpMaxInDir(str, (long) maxLogFileSizeMB, (long) maxDirSizeMB, maxLogKeepDays);
            deleteOldFileToday(str, maxLogFileNum);
            AppMethodBeat.o(193460);
            return true;
        } catch (Throwable th) {
            new StringBuilder("init log dir error: ").append(th.toString());
            AppMethodBeat.o(193460);
            return false;
        }
    }

    public static boolean isDebugMode(String str) {
        AppMethodBeat.i(193461);
        boolean exists = new File(str + DEBUG_CONF).exists();
        AppMethodBeat.o(193461);
        return exists;
    }

    private static int getConfValue(SharedPreferences sharedPreferences, String str, int i2) {
        AppMethodBeat.i(193462);
        String string = sharedPreferences.getString(str, null);
        if (!TextUtils.isEmpty(string)) {
            try {
                String.format(Locale.CHINA, "Read log conf[%s]: %s", str, string);
                int parseInt = Integer.parseInt(string);
                if (parseInt > 0) {
                    i2 = parseInt;
                }
            } catch (Throwable th) {
                String.format(Locale.CHINA, "Read log conf[%s] error: %s", str, th.getMessage());
            }
        }
        AppMethodBeat.o(193462);
        return i2;
    }

    public static void readLogKeepConf(Context context) {
        int i2;
        AppMethodBeat.i(193463);
        maxLogFileSizeMB = maxLogFileSizeMB > 0 ? maxLogFileSizeMB : 1;
        if (maxLogFileNum > 0) {
            i2 = maxLogFileNum;
        } else {
            i2 = 2;
        }
        maxLogFileNum = i2;
        maxLogKeepDays = maxLogKeepDays > 0 ? maxLogKeepDays : 15;
        maxDirSizeMB = maxLogFileSizeMB * maxLogFileNum * maxLogKeepDays;
        String.format(Locale.CHINA, "current config: max log size: %d MB, max log num: %d, max keep %d DAYS", Integer.valueOf(maxLogFileSizeMB), Integer.valueOf(maxLogFileNum), Integer.valueOf(maxLogKeepDays));
        SharedPreferences sharedPreferences = context.getSharedPreferences(APPluginDataInterface.SHARE_PREFERENCE_NAME, 4);
        maxLogFileSizeMB = getConfValue(sharedPreferences, "size", maxLogFileSizeMB);
        maxLogFileNum = getConfValue(sharedPreferences, "num", maxLogFileNum);
        maxLogKeepDays = getConfValue(sharedPreferences, "log_keep_time", maxLogKeepDays);
        maxDirSizeMB = maxLogFileSizeMB * maxLogFileNum * maxLogKeepDays;
        String.format(Locale.CHINA, "final config: max log size: %d MB, max log num: %d, max keep %d DAYS", Integer.valueOf(maxLogFileSizeMB), Integer.valueOf(maxLogFileNum), Integer.valueOf(maxLogKeepDays));
        AppMethodBeat.o(193463);
    }
}
