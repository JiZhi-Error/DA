package com.tencent.mm.cr;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.p.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.svg.a.e;
import com.tencent.xweb.ISharedPreferenceProvider;
import com.tencent.xweb.af;
import com.tencent.xweb.util.IXWebLogClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class b {
    public static IXWebLogClient Rzh = new IXWebLogClient() {
        /* class com.tencent.mm.cr.b.AnonymousClass1 */
        final String TAG = "IXWebLogClient";

        @Override // com.tencent.xweb.util.IXWebLogClient
        public final void i(String str, String str2) {
            AppMethodBeat.i(152905);
            Log.i(str, str2);
            AppMethodBeat.o(152905);
        }

        @Override // com.tencent.xweb.util.IXWebLogClient
        public final void e(String str, String str2) {
            AppMethodBeat.i(152906);
            Log.e(str, str2);
            AppMethodBeat.o(152906);
        }

        @Override // com.tencent.xweb.util.IXWebLogClient
        public final void w(String str, String str2) {
            AppMethodBeat.i(152907);
            Log.w(str, str2);
            AppMethodBeat.o(152907);
        }

        @Override // com.tencent.xweb.util.IXWebLogClient
        public final void d(String str, String str2) {
            AppMethodBeat.i(152908);
            Log.d(str, str2);
            AppMethodBeat.o(152908);
        }

        @Override // com.tencent.xweb.util.IXWebLogClient
        public final void v(String str, String str2) {
            AppMethodBeat.i(152909);
            Log.v(str, str2);
            AppMethodBeat.o(152909);
        }
    };
    public static af Rzi = new af() {
        /* class com.tencent.mm.cr.b.AnonymousClass2 */
        final String TAG = "XWebIdkey";

        @Override // com.tencent.xweb.af
        public final void n(long j2, long j3, long j4) {
            AppMethodBeat.i(152910);
            Log.v("XWebIdkey", "callback: idkeyStat:" + j2 + ", " + j3 + ", " + j4);
            h.INSTANCE.idkeyStat(j2, j3, j4, true);
            AppMethodBeat.o(152910);
        }

        @Override // com.tencent.xweb.af
        public final void bc(int i2, int i3, int i4) {
            AppMethodBeat.i(152911);
            Log.v("XWebIdkey", "callback: idkeyForPair:577, " + i2 + ", 1, 577, " + i3 + ", " + i4);
            h.INSTANCE.a(ah.CTRL_INDEX, ah.CTRL_INDEX, i2, i3, 1, i4, true);
            AppMethodBeat.o(152911);
        }

        @Override // com.tencent.xweb.af
        public final void kvStat(int i2, String str) {
            AppMethodBeat.i(152912);
            Log.v("XWebIdkey", "callback: kvStat:" + i2 + ", " + str);
            h.INSTANCE.kvStat(i2, str);
            AppMethodBeat.o(152912);
        }

        @Override // com.tencent.xweb.af
        public final void a(int i2, int i3, String str, int i4, int i5, int i6, int i7, int i8) {
            AppMethodBeat.i(152913);
            Log.v("XWebIdkey", "callback: kvStat:15003, 201201," + i2 + ",0," + str + "," + i4 + ",-1," + i5 + "," + i6 + "," + i7);
            h.INSTANCE.a(15003, Integer.valueOf((int) XWalkEnvironment.SDK_VERSION), Integer.valueOf(i2), 0, Integer.valueOf(i3), str, Integer.valueOf(NetStatusUtil.getNetType(MMApplicationContext.getContext())), Integer.valueOf(i4), -1, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
            AppMethodBeat.o(152913);
        }
    };
    public static WebViewExtensionListener Rzj = new WebViewExtensionListener() {
        /* class com.tencent.mm.cr.b.AnonymousClass3 */

        @Override // org.xwalk.core.WebViewExtensionListener
        public final Object onMiscCallBack(String str, Object... objArr) {
            AppMethodBeat.i(152914);
            if (WebViewExtension.EXTENSION_ADD_FILTER_RESOURCES.equals(str)) {
                e.a((Resources) objArr[0], (Map) objArr[1]);
            }
            AppMethodBeat.o(152914);
            return null;
        }

        @Override // org.xwalk.core.WebViewExtensionListener
        public final int getHostByName(String str, List<String> list) {
            AppMethodBeat.i(152915);
            if (!c.axW().Fo(MainProcessIPCService.dkO)) {
                AppMethodBeat.o(152915);
                return 0;
            }
            Bundle bundle = (Bundle) XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(str), a.class);
            if (list == null || bundle == null) {
                AppMethodBeat.o(152915);
                return 0;
            }
            list.clear();
            ArrayList<String> stringArrayList = bundle.getStringArrayList("ipList");
            int i2 = bundle.getInt("result");
            list.addAll(stringArrayList);
            AppMethodBeat.o(152915);
            return i2;
        }
    };
    public static ISharedPreferenceProvider Rzk = new ISharedPreferenceProvider() {
        /* class com.tencent.mm.cr.b.AnonymousClass4 */

        @Override // com.tencent.xweb.ISharedPreferenceProvider
        public final SharedPreferences C(String str, int i2, boolean z) {
            int i3;
            MultiProcessMMKV mmkv;
            AppMethodBeat.i(152916);
            if (z) {
                mmkv = MultiProcessMMKV.getMMKVWithTransportByName(str);
            } else {
                if (i2 == 4) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                mmkv = MultiProcessMMKV.getMMKV(str, i3);
            }
            if (mmkv == null) {
                AppMethodBeat.o(152916);
                return null;
            }
            c cVar = new c(mmkv);
            AppMethodBeat.o(152916);
            return cVar;
        }
    };

    static {
        AppMethodBeat.i(152920);
        AppMethodBeat.o(152920);
    }

    public static String getModuleName() {
        AppMethodBeat.i(152919);
        String processName = MMApplicationContext.getProcessName();
        if (processName == null) {
            AppMethodBeat.o(152919);
            return "";
        } else if (processName.contains(":")) {
            String lowerCase = processName.substring(processName.lastIndexOf(":") + 1).toLowerCase();
            if (lowerCase.startsWith("appbrand")) {
                AppMethodBeat.o(152919);
                return "appbrand";
            }
            AppMethodBeat.o(152919);
            return lowerCase;
        } else if (processName.contains(".")) {
            String lowerCase2 = processName.substring(processName.lastIndexOf(".") + 1).toLowerCase();
            AppMethodBeat.o(152919);
            return lowerCase2;
        } else {
            AppMethodBeat.o(152919);
            return processName;
        }
    }

    static final class a implements k<IPCString, Bundle> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Bundle invoke(IPCString iPCString) {
            AppMethodBeat.i(152918);
            Bundle f2 = f(iPCString);
            AppMethodBeat.o(152918);
            return f2;
        }

        private static Bundle f(IPCString iPCString) {
            int i2;
            AppMethodBeat.i(152917);
            Bundle bundle = new Bundle();
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                if (!Util.isNullOrNil(iPCString.value)) {
                    i2 = g.aAg().hqi.iMw.getHostByName(iPCString.value, arrayList);
                } else {
                    i2 = 0;
                }
                bundle.putStringArrayList("ipList", arrayList);
                bundle.putInt("result", i2);
                AppMethodBeat.o(152917);
            } catch (Exception e2) {
                Log.printErrStackTrace("GetHostByNameTask", e2, "GetHostByNameTask", new Object[0]);
                AppMethodBeat.o(152917);
            }
            return bundle;
        }
    }
}
