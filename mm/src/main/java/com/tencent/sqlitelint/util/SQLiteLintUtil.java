package com.tencent.sqlitelint.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.sqlitelint.BuildConfig;
import com.tencent.sqlitelint.SQLiteLint;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;

public class SQLiteLintUtil {
    private static final int DEFAULT_MAX_STACK_LAYER = 6;
    private static final String TAG = "SQLiteLint.SQLiteLintUtil";
    public static final String YYYY_MM_DD_HH_mm = "yyyy-MM-dd HH:mm";

    public static boolean isNullOrNil(String str) {
        AppMethodBeat.i(52965);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(52965);
            return true;
        }
        AppMethodBeat.o(52965);
        return false;
    }

    public static String nullAsNil(String str) {
        return str == null ? "" : str;
    }

    public static String extractDbName(String str) {
        String str2 = null;
        AppMethodBeat.i(52966);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(52966);
        } else {
            String[] split = str.split(FilePathGenerator.ANDROID_DIR_SEP);
            if (split != null && split.length > 0) {
                str2 = split[split.length - 1];
            }
            AppMethodBeat.o(52966);
        }
        return str2;
    }

    public static int getInt(String str, int i2) {
        AppMethodBeat.i(52967);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i2 = Integer.parseInt(str);
                    AppMethodBeat.o(52967);
                    return i2;
                }
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(52967);
            }
        }
        AppMethodBeat.o(52967);
        return i2;
    }

    public static String formatTime(String str, long j2) {
        AppMethodBeat.i(52968);
        String format = new SimpleDateFormat(str).format(new Date(j2));
        AppMethodBeat.o(52968);
        return format;
    }

    public static void mkdirs(String str) {
        File parentFile;
        AppMethodBeat.i(52969);
        File file = new File(str);
        if (!file.exists() && (parentFile = file.getParentFile()) != null) {
            parentFile.mkdirs();
        }
        AppMethodBeat.o(52969);
    }

    public static String stackTraceToString(StackTraceElement[] stackTraceElementArr) {
        AppMethodBeat.i(52970);
        if (stackTraceElementArr == null) {
            AppMethodBeat.o(52970);
            return "";
        }
        ArrayList arrayList = new ArrayList(stackTraceElementArr.length);
        for (int i2 = 0; i2 < stackTraceElementArr.length; i2++) {
            if (!stackTraceElementArr[i2].getClassName().contains(BuildConfig.APPLICATION_ID)) {
                arrayList.add(stackTraceElementArr[i2]);
            }
        }
        if (arrayList.size() > 6 && SQLiteLint.sPackageName != null) {
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (listIterator.hasPrevious()) {
                if (!((StackTraceElement) listIterator.previous()).getClassName().contains(SQLiteLint.sPackageName)) {
                    listIterator.remove();
                }
                if (arrayList.size() <= 6) {
                    break;
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((StackTraceElement) it.next()).append('\n');
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(52970);
        return stringBuffer2;
    }

    public static String getThrowableStack(Throwable th) {
        AppMethodBeat.i(52971);
        if (th == null) {
            AppMethodBeat.o(52971);
            return "";
        }
        String stackTraceToString = stackTraceToString(th.getStackTrace());
        AppMethodBeat.o(52971);
        return stackTraceToString;
    }

    public static String getThrowableStack() {
        AppMethodBeat.i(52972);
        try {
            String throwableStack = getThrowableStack(new Throwable());
            AppMethodBeat.o(52972);
            return throwableStack;
        } catch (Throwable th) {
            SLog.e(TAG, "getThrowableStack ex %s", th.getMessage());
            AppMethodBeat.o(52972);
            return "";
        }
    }
}
