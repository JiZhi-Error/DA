package com.google.android.gms.common.util;

import android.os.Binder;
import android.os.Process;
import android.os.StrictMode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

public class ProcessUtils {
    private static String zzaai = null;
    private static int zzaaj = 0;

    public static class SystemGroupsNotAvailableException extends Exception {
        SystemGroupsNotAvailableException(String str) {
            super(str);
        }

        SystemGroupsNotAvailableException(String str, Throwable th) {
            super(str, th);
        }
    }

    private ProcessUtils() {
    }

    @Nullable
    public static String getCallingProcessName() {
        AppMethodBeat.i(5277);
        int callingPid = Binder.getCallingPid();
        if (callingPid == zzde()) {
            String myProcessName = getMyProcessName();
            AppMethodBeat.o(5277);
            return myProcessName;
        }
        String zzl = zzl(callingPid);
        AppMethodBeat.o(5277);
        return zzl;
    }

    @Nullable
    public static String getMyProcessName() {
        AppMethodBeat.i(5278);
        if (zzaai == null) {
            zzaai = zzl(zzde());
        }
        String str = zzaai;
        AppMethodBeat.o(5278);
        return str;
    }

    public static boolean hasSystemGroups() {
        AppMethodBeat.i(5279);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = zzm(new StringBuilder(24).append("/proc/").append(zzde()).append("/status").toString());
            boolean zzk = zzk(bufferedReader);
            IOUtils.closeQuietly(bufferedReader);
            AppMethodBeat.o(5279);
            return zzk;
        } catch (IOException e2) {
            SystemGroupsNotAvailableException systemGroupsNotAvailableException = new SystemGroupsNotAvailableException("Unable to access /proc/pid/status.", e2);
            AppMethodBeat.o(5279);
            throw systemGroupsNotAvailableException;
        } catch (Throwable th) {
            IOUtils.closeQuietly(bufferedReader);
            AppMethodBeat.o(5279);
            throw th;
        }
    }

    private static int zzde() {
        AppMethodBeat.i(5283);
        if (zzaaj == 0) {
            zzaaj = Process.myPid();
        }
        int i2 = zzaaj;
        AppMethodBeat.o(5283);
        return i2;
    }

    private static boolean zzk(BufferedReader bufferedReader) {
        AppMethodBeat.i(5280);
        String readLine = bufferedReader.readLine();
        while (readLine != null) {
            String trim = readLine.trim();
            if (trim.startsWith("Groups:")) {
                String[] split = trim.substring(7).trim().split("\\s", -1);
                for (String str : split) {
                    try {
                        long parseLong = Long.parseLong(str);
                        if (parseLong >= 1000 && parseLong < 2000) {
                            AppMethodBeat.o(5280);
                            return true;
                        }
                    } catch (NumberFormatException e2) {
                    }
                }
                AppMethodBeat.o(5280);
                return false;
            }
            readLine = bufferedReader.readLine();
        }
        SystemGroupsNotAvailableException systemGroupsNotAvailableException = new SystemGroupsNotAvailableException("Missing Groups entry from proc/pid/status.");
        AppMethodBeat.o(5280);
        throw systemGroupsNotAvailableException;
    }

    @Nullable
    private static String zzl(int i2) {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2;
        String str = null;
        AppMethodBeat.i(5281);
        if (i2 <= 0) {
            AppMethodBeat.o(5281);
        } else {
            try {
                bufferedReader2 = zzm(new StringBuilder(25).append("/proc/").append(i2).append("/cmdline").toString());
                try {
                    str = bufferedReader2.readLine().trim();
                    IOUtils.closeQuietly(bufferedReader2);
                } catch (IOException e2) {
                    IOUtils.closeQuietly(bufferedReader2);
                    AppMethodBeat.o(5281);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    IOUtils.closeQuietly(bufferedReader);
                    AppMethodBeat.o(5281);
                    throw th;
                }
            } catch (IOException e3) {
                bufferedReader2 = null;
                IOUtils.closeQuietly(bufferedReader2);
                AppMethodBeat.o(5281);
                return str;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                IOUtils.closeQuietly(bufferedReader);
                AppMethodBeat.o(5281);
                throw th;
            }
            AppMethodBeat.o(5281);
        }
        return str;
    }

    private static BufferedReader zzm(String str) {
        AppMethodBeat.i(5282);
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            AppMethodBeat.o(5282);
        }
    }
}
