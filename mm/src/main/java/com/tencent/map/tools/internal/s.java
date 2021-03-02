package com.tencent.map.tools.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public class s {

    /* renamed from: c  reason: collision with root package name */
    private static Context f1395c;

    /* renamed from: d  reason: collision with root package name */
    private static s f1396d;

    /* renamed from: a  reason: collision with root package name */
    public int f1397a = 4;

    /* renamed from: b  reason: collision with root package name */
    private String f1398b = "JudeCpuAbiHandler";

    /* renamed from: e  reason: collision with root package name */
    private String f1399e = "armeabi";

    private s(Context context) {
        AppMethodBeat.i(193537);
        f1395c = context;
        this.f1399e = b(context);
        this.f1397a = a(this.f1399e);
        AppMethodBeat.o(193537);
    }

    public static s a(Context context) {
        AppMethodBeat.i(193538);
        synchronized (s.class) {
            try {
                if (f1396d == null) {
                    f1396d = new s(context);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(193538);
                throw th;
            }
        }
        s sVar = f1396d;
        AppMethodBeat.o(193538);
        return sVar;
    }

    private static String b(Context context) {
        boolean z = true;
        AppMethodBeat.i(193539);
        String str = "armeabi";
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                z = Process.is64Bit();
            } else {
                if (Build.VERSION.SDK_INT >= 21) {
                    String[] strArr = Build.SUPPORTED_ABIS;
                    String str2 = "";
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        str2 = str2 + strArr[i2] + ",";
                    }
                    if (str2.contains("64")) {
                        String c2 = c(context);
                        if (c2 != null) {
                            if (c2.equals("getError")) {
                                Exception exc = new Exception("getError");
                                AppMethodBeat.o(193539);
                                throw exc;
                            } else if (!c2.contains("64")) {
                                z = false;
                            }
                        }
                    }
                }
                z = false;
            }
            if (z) {
                str = Build.SUPPORTED_64_BIT_ABIS[0];
            } else {
                str = Build.CPU_ABI;
            }
            AppMethodBeat.o(193539);
        } catch (Throwable th) {
            AppMethodBeat.o(193539);
        }
        return str;
    }

    private static int a(String str) {
        AppMethodBeat.i(193540);
        if (str == null) {
            AppMethodBeat.o(193540);
            return 4;
        }
        for (int i2 = 0; i2 < t.F.length; i2++) {
            if (str.equals(t.F[i2])) {
                AppMethodBeat.o(193540);
                return i2;
            }
        }
        AppMethodBeat.o(193540);
        return -1;
    }

    private static String c(Context context) {
        AppMethodBeat.i(193541);
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 0);
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            String str = (String) declaredField.get(applicationInfo);
            AppMethodBeat.o(193541);
            return str;
        } catch (Throwable th) {
            AppMethodBeat.o(193541);
            return "getError";
        }
    }
}
