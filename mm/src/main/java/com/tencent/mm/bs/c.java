package com.tencent.mm.bs;

import android.os.StatFs;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.s;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class c {
    private static String bfY(String str) {
        AppMethodBeat.i(32073);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(32073);
            return "";
        }
        String trim = str.replaceAll(" ", "").trim().replaceAll("kB", "").trim().replaceAll("\\t", "").trim();
        AppMethodBeat.o(32073);
        return trim;
    }

    public static String gsZ() {
        BufferedReader bufferedReader;
        Throwable th;
        AppMethodBeat.i(32074);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(s.openRead("/proc/cpuinfo"), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            try {
                StringBuilder sb = new StringBuilder(256);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        String replace = sb.toString().replace(',', '_');
                        Util.qualityClose(bufferedReader);
                        AppMethodBeat.o(32074);
                        return replace;
                    } else if (!Util.isNullOrNil(readLine)) {
                        sb.append(bfY(readLine)).append(';');
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    Log.printErrStackTrace("MicroMsg.PostTaskHardwareInfo", th, "unexpected exception occurred.", new Object[0]);
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(32074);
                    return "";
                } catch (Throwable th3) {
                    th = th3;
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(32074);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(32074);
            throw th;
        }
    }

    public static String gta() {
        BufferedReader bufferedReader;
        Throwable th;
        AppMethodBeat.i(32075);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(s.openRead("/proc/meminfo"), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            try {
                StringBuilder sb = new StringBuilder(256);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        String replace = sb.toString().replace(',', '_');
                        Util.qualityClose(bufferedReader);
                        AppMethodBeat.o(32075);
                        return replace;
                    } else if (!Util.isNullOrNil(readLine)) {
                        sb.append(bfY(readLine)).append(';');
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    Log.printErrStackTrace("MicroMsg.PostTaskHardwareInfo", th, "unexpected exception occurred.", new Object[0]);
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(32075);
                    return "";
                } catch (Throwable th3) {
                    th = th3;
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(32075);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(32075);
            throw th;
        }
    }

    public static String gtb() {
        AppMethodBeat.i(32076);
        String str = "";
        try {
            new DisplayMetrics();
            DisplayMetrics displayMetrics = MMApplicationContext.getContext().getResources().getDisplayMetrics();
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            float f2 = displayMetrics.density;
            float f3 = displayMetrics.xdpi;
            float f4 = displayMetrics.ydpi;
            str = (((("" + "width:" + String.valueOf(i2) + ";") + "height:" + String.valueOf(i3) + ";") + "density:" + String.valueOf(f2) + ";") + "xd:" + String.valueOf(f3) + ";") + "yd:" + String.valueOf(f4) + ";";
        } catch (Exception e2) {
            Log.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", Util.stackTraceToString(e2));
        }
        String replace = str.replace(",", "_");
        AppMethodBeat.o(32076);
        return replace;
    }

    public static String getRomInfo() {
        AppMethodBeat.i(32077);
        String str = "";
        try {
            StatFs statFs = new StatFs(g.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str = ((str + "AvailableSizes:" + (((long) statFs.getAvailableBlocks()) * blockSize) + ";") + "FreeSizes:" + (((long) statFs.getFreeBlocks()) * blockSize) + ";") + "AllSize:" + (blockSize * ((long) statFs.getBlockCount())) + ";";
        } catch (Exception e2) {
            Log.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", Util.stackTraceToString(e2));
        }
        String replace = str.replace(",", "_");
        AppMethodBeat.o(32077);
        return replace;
    }

    public static String gtc() {
        AppMethodBeat.i(32078);
        String str = "";
        try {
            StatFs statFs = new StatFs(b.aKJ());
            long blockSize = (long) statFs.getBlockSize();
            str = ((str + "AvailableSizes:" + (((long) statFs.getAvailableBlocks()) * blockSize) + ";") + "FreeSizes:" + (((long) statFs.getFreeBlocks()) * blockSize) + ";") + "AllSize:" + (blockSize * ((long) statFs.getBlockCount())) + ";";
        } catch (Exception e2) {
            Log.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", Util.stackTraceToString(e2));
        }
        String replace = str.replace(",", "_");
        AppMethodBeat.o(32078);
        return replace;
    }

    public static String gtd() {
        AppMethodBeat.i(32079);
        bg.aVF();
        String str = (String) com.tencent.mm.model.c.azQ().get(71, (Object) null);
        AppMethodBeat.o(32079);
        return str;
    }
}
