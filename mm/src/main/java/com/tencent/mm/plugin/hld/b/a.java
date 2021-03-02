package com.tencent.mm.plugin.hld.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/hld/utils/WxImeUtil;", "", "()V", "TAG", "", "checkPermission", "", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "([Ljava/lang/String;)Z", "getCPUInfo", "getCurIme", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getTotalMemory", "", "getTotalRAMMemory", "getTotalROMMemory", "plugin-hld_release"})
public final class a {
    public static final a UXp = new a();

    static {
        AppMethodBeat.i(260032);
        AppMethodBeat.o(260032);
    }

    private a() {
    }

    public static String hVT() {
        AppMethodBeat.i(260025);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
        AppMethodBeat.o(260025);
        return string;
    }

    public static long hVU() {
        long j2;
        IOException e2;
        AppMethodBeat.i(260026);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String readLine = bufferedReader.readLine();
            p.g(readLine, "localBufferedReader.readLine()");
            Object[] array = new k("\\s+").q(readLine, 0).toArray(new String[0]);
            if (array == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(260026);
                throw tVar;
            }
            String[] strArr = (String[]) array;
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                Log.i(readLine, strArr[i2] + "\t");
            }
            Integer valueOf = Integer.valueOf(strArr[1]);
            p.g(valueOf, "Integer.valueOf(arrayOfString[1])");
            j2 = ((long) valueOf.intValue()) * 1024;
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                e2 = e3;
            }
            AppMethodBeat.o(260026);
            return j2;
        } catch (IOException e4) {
            e2 = e4;
            j2 = 0;
            Log.i("WxIme.WxImeUtil", "getTotalMemory " + e2.getMessage());
            AppMethodBeat.o(260026);
            return j2;
        }
    }

    public static boolean ao(String[] strArr) {
        AppMethodBeat.i(260027);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        boolean z = true;
        for (String str : strArr) {
            z = z && b.k(MMApplicationContext.getContext(), str, false);
        }
        AppMethodBeat.o(260027);
        return z;
    }

    public static long hVV() {
        AppMethodBeat.i(260028);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        Object systemService = MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.ActivityManager");
            AppMethodBeat.o(260028);
            throw tVar;
        }
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        long j2 = memoryInfo.totalMem;
        AppMethodBeat.o(260028);
        return j2;
    }

    public static long hVW() {
        AppMethodBeat.i(260029);
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSizeLong = statFs.getBlockSizeLong() * statFs.getBlockCountLong();
        AppMethodBeat.o(260029);
        return blockSizeLong;
    }

    public static String hVX() {
        AppMethodBeat.i(260030);
        StringBuilder sb = new StringBuilder();
        try {
            String[] strArr = Build.SUPPORTED_ABIS;
            for (String str : strArr) {
                if (!(sb.length() == 0)) {
                    sb.append(";");
                }
                sb.append(str);
            }
        } catch (Exception e2) {
            sb = new StringBuilder();
        }
        String sb2 = sb.toString();
        p.g(sb2, "cpuInfo.toString()");
        AppMethodBeat.o(260030);
        return sb2;
    }

    public static MultiProcessMMKV getKV() {
        AppMethodBeat.i(260031);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("wx_ime");
        AppMethodBeat.o(260031);
        return mmkv;
    }
}
