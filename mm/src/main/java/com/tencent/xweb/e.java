package com.tencent.xweb;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class e {
    private static final Object SyQ = new Object();

    static {
        AppMethodBeat.i(156731);
        AppMethodBeat.o(156731);
    }

    public static void onStart(String str) {
        AppMethodBeat.i(156727);
        if (str == null || str.isEmpty()) {
            Log.e("XFilesReaderCrashDetect", "onStart param is empty");
            AppMethodBeat.o(156727);
            return;
        }
        String lowerCase = str.toLowerCase();
        synchronized (SyQ) {
            try {
                SharedPreferences sharedPreferencesForFileReaderRecord = XWalkEnvironment.getSharedPreferencesForFileReaderRecord();
                if (sharedPreferencesForFileReaderRecord == null) {
                    Log.e("XFilesReaderCrashDetect", "onStart sp is null");
                    return;
                }
                long j2 = sharedPreferencesForFileReaderRecord.getLong(lowerCase + XWalkEnvironment.SP_KEY_FILE_READER_POSTFIX_COUNT, 0);
                SharedPreferences.Editor edit = sharedPreferencesForFileReaderRecord.edit();
                if (edit == null) {
                    Log.e("XFilesReaderCrashDetect", "onStart editor is null");
                    AppMethodBeat.o(156727);
                    return;
                }
                edit.putLong(lowerCase + XWalkEnvironment.SP_KEY_FILE_READER_POSTFIX_COUNT, j2 + 1);
                edit.putLong(lowerCase + XWalkEnvironment.SP_KEY_FILE_READER_POSTFIX_TIME, System.currentTimeMillis());
                edit.commit();
                AppMethodBeat.o(156727);
            } finally {
                AppMethodBeat.o(156727);
            }
        }
    }

    public static void Hn(String str) {
        AppMethodBeat.i(156728);
        if (str == null || str.isEmpty()) {
            Log.e("XFilesReaderCrashDetect", "onFinish param is empty");
            AppMethodBeat.o(156728);
            return;
        }
        String lowerCase = str.toLowerCase();
        synchronized (SyQ) {
            try {
                SharedPreferences sharedPreferencesForFileReaderRecord = XWalkEnvironment.getSharedPreferencesForFileReaderRecord();
                if (sharedPreferencesForFileReaderRecord == null) {
                    Log.e("XFilesReaderCrashDetect", "onFinish sp is null");
                    return;
                }
                SharedPreferences.Editor edit = sharedPreferencesForFileReaderRecord.edit();
                if (edit == null) {
                    Log.e("XFilesReaderCrashDetect", "onFinish editor is null");
                    AppMethodBeat.o(156728);
                    return;
                }
                edit.putLong(lowerCase + XWalkEnvironment.SP_KEY_FILE_READER_POSTFIX_COUNT, 0);
                edit.putLong(lowerCase + XWalkEnvironment.SP_KEY_FILE_READER_POSTFIX_TIME, System.currentTimeMillis());
                edit.commit();
                AppMethodBeat.o(156728);
            } finally {
                AppMethodBeat.o(156728);
            }
        }
    }

    public static boolean brV(String str) {
        boolean z = false;
        AppMethodBeat.i(156729);
        if (str == null || str.isEmpty()) {
            Log.e("XFilesReaderCrashDetect", "isRecentCrashed fileExt is empty");
            AppMethodBeat.o(156729);
        } else {
            String lowerCase = str.toLowerCase();
            synchronized (SyQ) {
                try {
                    SharedPreferences sharedPreferencesForFileReaderRecord = XWalkEnvironment.getSharedPreferencesForFileReaderRecord();
                    if (sharedPreferencesForFileReaderRecord == null) {
                        Log.e("XFilesReaderCrashDetect", "isRecentCrashed sp is null");
                    } else {
                        long j2 = sharedPreferencesForFileReaderRecord.getLong(lowerCase + XWalkEnvironment.SP_KEY_FILE_READER_POSTFIX_COUNT, 0);
                        long j3 = sharedPreferencesForFileReaderRecord.getLong(lowerCase + XWalkEnvironment.SP_KEY_FILE_READER_POSTFIX_TIME, 0);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (j2 < 3 || currentTimeMillis - j3 >= Util.MILLSECONDS_OF_DAY) {
                            AppMethodBeat.o(156729);
                        } else {
                            z = true;
                            AppMethodBeat.o(156729);
                        }
                    }
                } finally {
                    AppMethodBeat.o(156729);
                }
            }
        }
        return z;
    }

    public static void ah(String[] strArr) {
        AppMethodBeat.i(156730);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(156730);
            return;
        }
        synchronized (SyQ) {
            try {
                SharedPreferences sharedPreferencesForFileReaderRecord = XWalkEnvironment.getSharedPreferencesForFileReaderRecord();
                if (sharedPreferencesForFileReaderRecord == null) {
                    Log.e("XFilesReaderCrashDetect", "resetCrashInfo sp is null");
                    return;
                }
                SharedPreferences.Editor edit = sharedPreferencesForFileReaderRecord.edit();
                if (edit == null) {
                    Log.e("XFilesReaderCrashDetect", "resetCrashInfo editor is null");
                    AppMethodBeat.o(156730);
                    return;
                }
                for (String str : strArr) {
                    if (str != null && !str.isEmpty()) {
                        String lowerCase = str.toLowerCase();
                        edit.remove(lowerCase + XWalkEnvironment.SP_KEY_FILE_READER_POSTFIX_COUNT);
                        edit.remove(lowerCase + XWalkEnvironment.SP_KEY_FILE_READER_POSTFIX_TIME);
                    }
                }
                edit.commit();
                AppMethodBeat.o(156730);
            } finally {
                AppMethodBeat.o(156730);
            }
        }
    }
}
