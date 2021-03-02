package com.tencent.mm.compatible.deviceinfo;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class n {
    private static Map<String, String> gHS = null;

    public static Map<String, String> aoq() {
        AppMethodBeat.i(155667);
        if (gHS == null) {
            gHS = aov();
        }
        Map<String, String> map = gHS;
        AppMethodBeat.o(155667);
        return map;
    }

    public static String aor() {
        AppMethodBeat.i(155668);
        if (gHS == null) {
            gHS = aov();
        }
        String str = ": " + a(gHS, "Features") + ": " + a(gHS, "Processor") + ": " + a(gHS, "CPU architecture") + ": " + a(gHS, "Hardware") + ": " + a(gHS, "Serial");
        AppMethodBeat.o(155668);
        return str;
    }

    public static boolean aos() {
        AppMethodBeat.i(155669);
        if (gHS == null) {
            gHS = aov();
        }
        if (gHS != null) {
            String a2 = a(gHS, "Features");
            if (a2 != null && a2.contains("neon")) {
                AppMethodBeat.o(155669);
                return true;
            } else if (a2 != null && a2.contains("asimd")) {
                AppMethodBeat.o(155669);
                return true;
            }
        }
        AppMethodBeat.o(155669);
        return false;
    }

    public static boolean aou() {
        AppMethodBeat.i(155671);
        if (gHS == null) {
            gHS = aov();
        }
        if (gHS != null) {
            String a2 = a(gHS, "CPU architecture");
            Log.d("CpuFeatures", "arch ".concat(String.valueOf(a2)));
            if (a2 != null) {
                try {
                    if (a2.length() > 0) {
                        int i2 = Util.getInt(DT(DS(a2)), 0);
                        Log.d("CpuFeatures", "armarch ".concat(String.valueOf(i2)));
                        if (i2 >= 6) {
                            AppMethodBeat.o(155671);
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("CpuFeatures", e2, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(155671);
        return false;
    }

    /* access modifiers changed from: package-private */
    public class a implements q {
        a() {
        }

        @Override // com.tencent.mm.vfs.q
        public final boolean accept(o oVar) {
            AppMethodBeat.i(175895);
            if (Pattern.matches("cpu[0-9]", oVar.getName())) {
                AppMethodBeat.o(175895);
                return true;
            }
            AppMethodBeat.o(175895);
            return false;
        }
    }

    public static int getNumCores() {
        AppMethodBeat.i(155672);
        try {
            int length = new o("/sys/devices/system/cpu/").a(new a()).length;
            AppMethodBeat.o(155672);
            return length;
        } catch (Exception e2) {
            AppMethodBeat.o(155672);
            return 1;
        }
    }

    private static boolean w(char c2) {
        if (c2 < '0' || c2 > '9') {
            return false;
        }
        return true;
    }

    private static String DS(String str) {
        AppMethodBeat.i(155673);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    while (!w(str.charAt(0))) {
                        if (str.length() == 1) {
                            AppMethodBeat.o(155673);
                            return null;
                        }
                        str = str.substring(1);
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("CpuFeatures", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(155673);
        return str;
    }

    private static String DT(String str) {
        int i2;
        AppMethodBeat.i(155674);
        int i3 = 0;
        while (true) {
            i2 = i3 + 1;
            try {
                if (!w(str.charAt(i3)) || str.length() <= i2) {
                    int i4 = i2 - 1;
                } else {
                    i3 = i2;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("CpuFeatures", e2, "", new Object[0]);
                AppMethodBeat.o(155674);
            }
        }
        int i42 = i2 - 1;
        if (str.length() > i42 + 1 && i42 > 0) {
            str = str.substring(0, i42);
        }
        AppMethodBeat.o(155674);
        return str;
    }

    private static String a(Map<String, String> map, String str) {
        AppMethodBeat.i(155675);
        String str2 = map.get(str);
        AppMethodBeat.o(155675);
        return str2;
    }

    public static HashMap<String, String> aov() {
        BufferedReader bufferedReader;
        Throwable th;
        AppMethodBeat.i(155676);
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(s.openRead("/proc/cpuinfo"), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split(":", 2);
                    if (split != null && split.length >= 2) {
                        String trim = split[0].trim();
                        String trim2 = split[1].trim();
                        if (hashMap.get(trim) == null) {
                            hashMap.put(trim, trim2);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        Log.printErrStackTrace("CpuFeatures", e, "getCpu() failed.", new Object[0]);
                        Util.qualityClose(bufferedReader);
                        AppMethodBeat.o(155676);
                        return hashMap;
                    } catch (Throwable th2) {
                        th = th2;
                        Util.qualityClose(bufferedReader);
                        AppMethodBeat.o(155676);
                        throw th;
                    }
                }
            }
            Util.qualityClose(bufferedReader);
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
            Log.printErrStackTrace("CpuFeatures", e, "getCpu() failed.", new Object[0]);
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(155676);
            return hashMap;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(155676);
            throw th;
        }
        AppMethodBeat.o(155676);
        return hashMap;
    }

    public static boolean aot() {
        boolean z;
        AppMethodBeat.i(155670);
        try {
            if (Build.VERSION.SDK_INT >= 4) {
                z = true;
            } else {
                z = false;
            }
            if (!z || !aos()) {
                AppMethodBeat.o(155670);
                return false;
            }
            AppMethodBeat.o(155670);
            return true;
        } catch (IncompatibleClassChangeError e2) {
            Log.printErrStackTrace("MicroMsg.Crash", e2, "May cause dvmFindCatchBlock crash!", new Object[0]);
            IncompatibleClassChangeError incompatibleClassChangeError = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2);
            AppMethodBeat.o(155670);
            throw incompatibleClassChangeError;
        } catch (Throwable th) {
            AppMethodBeat.o(155670);
            return false;
        }
    }
}
