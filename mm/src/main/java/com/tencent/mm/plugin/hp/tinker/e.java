package com.tencent.mm.plugin.hp.tinker;

import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.e.c;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tinkerboots.sdk.a;

public final class e {
    private static boolean ynm = false;

    public static void b(ApplicationLike applicationLike) {
        a aVar;
        String str;
        AppMethodBeat.i(117482);
        Log.i("Tinker.TinkerPatchManager", "try installing tinker");
        if (ynm) {
            Log.w("Tinker.TinkerPatchManager", "install tinker, but has installed, ignore");
            AppMethodBeat.o(117482);
            return;
        }
        long j2 = 0;
        try {
            j2 = ((long) com.tencent.mm.kernel.a.azs()) & Util.MAX_32BIT_VALUE;
            Log.i("Tinker.TinkerPatchManager", "uin is %s", Util.secPrint(String.valueOf(j2)));
        } catch (Exception e2) {
            Log.printErrStackTrace("Tinker.TinkerPatchManager", e2, "tinker patch manager get uin failed.", new Object[0]);
        }
        a.C2238a aVar2 = new a.C2238a(applicationLike);
        d dVar = new d(applicationLike.getApplication());
        if (aVar2.SjU != null) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("loadReporter is already set.");
            AppMethodBeat.o(117482);
            throw tinkerRuntimeException;
        }
        aVar2.SjU = dVar;
        a.C2238a a2 = aVar2.a(new f(applicationLike.getApplication()));
        c cVar = new c(applicationLike.getApplication());
        if (a2.SjT != null) {
            TinkerRuntimeException tinkerRuntimeException2 = new TinkerRuntimeException("listener is already set.");
            AppMethodBeat.o(117482);
            throw tinkerRuntimeException2;
        }
        a2.SjT = cVar;
        if (a2.SKC != null) {
            TinkerRuntimeException tinkerRuntimeException3 = new TinkerRuntimeException("resultServiceClass is already set.");
            AppMethodBeat.o(117482);
            throw tinkerRuntimeException3;
        }
        a2.SKC = TinkerPatchResultService.class;
        a.a(a2.hvY());
        a atk = a.hvX().atk(h.go(applicationLike.getApplication()));
        boolean hasDebuger = CrashReportFactory.hasDebuger();
        if (atk.SKy == null || atk.SKx == null) {
            ShareTinkerLog.v("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
            aVar = a.SKw;
        } else {
            ShareTinkerLog.v("Tinker.TinkerClient", "set debugger to %b", Boolean.valueOf(hasDebuger));
            atk.SKy.cWq = hasDebuger;
            aVar = a.SKw;
        }
        a ol = aVar.ol(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(j2)).ol("code-version", BuildInfo.CLIENT_VERSION).ol("code-reversion", BuildInfo.REV).ol(TencentLocation.NETWORK_PROVIDER, String.valueOf(NetStatusUtil.isWifi(applicationLike.getApplication()) ? 3 : 2)).ol(ServerProtocol.DIALOG_PARAM_SDK_VERSION, String.valueOf(Build.VERSION.SDK_INT)).ol("os-name", d.KyL).ol("device-brand", d.KyI).ol("device-name", d.DEVICE_NAME).ol("support-64-bit", Build.SUPPORTED_64_BIT_ABIS.length > 0 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (q.is64BitRuntime()) {
            str = "1";
        } else {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        a ol2 = ol.ol("device-is-64-bit-runtime", str);
        g gVar = new g();
        if (ol2.SKy == null || ol2.SKx == null) {
            ShareTinkerLog.v("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
        } else {
            ShareTinkerLog.v("Tinker.TinkerClient", "setPatchRequestCallback with hashcode %d", Integer.valueOf(gVar.hashCode()));
            ol2.SKy.SKD = gVar;
        }
        Log.i("Tinker.TinkerPatchManager", "try installing end");
        ynm = true;
        AppMethodBeat.o(117482);
    }

    public static void dZm() {
        AppMethodBeat.i(117483);
        ShareTinkerLog.setTinkerLogImp(new com.tencent.tinker.lib.f.a() {
            /* class com.tencent.mm.plugin.hp.tinker.e.AnonymousClass1 */

            @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
            public final void v(String str, String str2, Object... objArr) {
                AppMethodBeat.i(196795);
                Log.v(str, str2, objArr);
                AppMethodBeat.o(196795);
            }

            @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
            public final void i(String str, String str2, Object... objArr) {
                AppMethodBeat.i(117478);
                Log.i(str, str2, objArr);
                AppMethodBeat.o(117478);
            }

            @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
            public final void w(String str, String str2, Object... objArr) {
                AppMethodBeat.i(117479);
                Log.w(str, str2, objArr);
                AppMethodBeat.o(117479);
            }

            @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
            public final void d(String str, String str2, Object... objArr) {
                AppMethodBeat.i(196796);
                Log.d(str, str2, objArr);
                AppMethodBeat.o(196796);
            }

            @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
            public final void e(String str, String str2, Object... objArr) {
                AppMethodBeat.i(117480);
                Log.e(str, str2, objArr);
                AppMethodBeat.o(117480);
            }

            @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                AppMethodBeat.i(117481);
                Log.printErrStackTrace(str, th, str2, objArr);
                AppMethodBeat.o(117481);
            }
        });
        AppMethodBeat.o(117483);
    }

    public static void dZn() {
        AppMethodBeat.i(117484);
        if (!ynm) {
            RuntimeException runtimeException = new RuntimeException("cleanPatch but tinker is not installed");
            AppMethodBeat.o(117484);
            throw runtimeException;
        }
        com.tencent.tinker.lib.e.a.lk(com.tencent.mm.app.d.dks.getApplication()).dZn();
        AppMethodBeat.o(117484);
    }

    public static void aBJ(String str) {
        AppMethodBeat.i(117485);
        if (!ynm) {
            RuntimeException runtimeException = new RuntimeException("upgrade patch but tinker is not installed");
            AppMethodBeat.o(117485);
            throw runtimeException;
        }
        c.cY(com.tencent.mm.app.d.dks.getApplication(), str);
        AppMethodBeat.o(117485);
    }
}
