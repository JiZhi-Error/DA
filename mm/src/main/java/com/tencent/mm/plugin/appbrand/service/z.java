package com.tencent.mm.plugin.appbrand.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.e;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\b\u0001\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001 B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE;", "", "reportKeyInvoke", "", "reportKeyInvokeApplied", "(Ljava/lang/String;III)V", "getReportKeyInvoke", "()I", "getReportKeyInvokeApplied", "DEFAULT", "TEST_ONLY", "ACCOUNT_INIT", "APP_FOREGROUND", "APPBRAND_PROCESS_RESTART", "APPBRAND_RUNTIME_PRELOAD_NEXT", "MAIN_PULLDOWN", "APPBRAND_LAUNCHER", "SYNC_WXA_ATTRS_ON_APP_LAUNCH", "WXA_JSAPI_PRELOAD", "H5_JSAPI_PRELOAD", "QRCODE_LONG_PRESS", "OPEN_SDK_API_PRELOAD", "SNS_AD", "WXA_JSAPI_BATCH_PRELOAD", "FINDER_LIVING", "FIND_MORE_ENTRANCE_EXPOSED", "PRE_LAUNCH_REDIRECTING_PAGE", "FIND_MORE_NEARBY", "CHATTING_WEISHI", "KF_GUIDE", "BIZ_TIME_LINE", "SEARCH_WEAPP", "Companion", "api-protocol_release"})
public enum z {
    DEFAULT(21, 22),
    TEST_ONLY(23, 24),
    ACCOUNT_INIT(25, 26),
    APP_FOREGROUND(27, 28),
    APPBRAND_PROCESS_RESTART(29, 30),
    APPBRAND_RUNTIME_PRELOAD_NEXT(31, 32),
    MAIN_PULLDOWN(33, 34),
    APPBRAND_LAUNCHER(35, 36),
    SYNC_WXA_ATTRS_ON_APP_LAUNCH(37, 38),
    WXA_JSAPI_PRELOAD(39, 40),
    H5_JSAPI_PRELOAD(41, 42),
    QRCODE_LONG_PRESS(43, 44),
    OPEN_SDK_API_PRELOAD(45, 46),
    SNS_AD(47, 48),
    WXA_JSAPI_BATCH_PRELOAD(49, 50),
    FINDER_LIVING(51, 52),
    FIND_MORE_ENTRANCE_EXPOSED(53, 54),
    PRE_LAUNCH_REDIRECTING_PAGE(55, 56),
    FIND_MORE_NEARBY(57, 58),
    CHATTING_WEISHI(59, 60),
    KF_GUIDE(61, 62),
    BIZ_TIME_LINE(63, 64),
    SEARCH_WEAPP(65, 66);
    
    public static final a nMV = new a((byte) 0);
    public final int nMT;
    public final int nMU;

    public static final boolean d(z zVar) {
        AppMethodBeat.i(194327);
        boolean d2 = a.d(zVar);
        AppMethodBeat.o(194327);
        return d2;
    }

    public static z valueOf(String str) {
        AppMethodBeat.i(194326);
        z zVar = (z) Enum.valueOf(z.class, str);
        AppMethodBeat.o(194326);
        return zVar;
    }

    private z(int i2, int i3) {
        this.nMT = i2;
        this.nMU = i3;
    }

    static {
        AppMethodBeat.i(194324);
        AppMethodBeat.o(194324);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE$Companion;", "", "()V", "shouldIgnoreFrequencyLimit", "", "scene", "Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE;", "api-protocol_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean d(z zVar) {
            AppMethodBeat.i(194323);
            if (zVar == null) {
                AppMethodBeat.o(194323);
                return false;
            }
            if (e.contains(new z[]{z.ACCOUNT_INIT, z.APP_FOREGROUND, z.MAIN_PULLDOWN, z.APPBRAND_LAUNCHER, z.SYNC_WXA_ATTRS_ON_APP_LAUNCH, z.TEST_ONLY}, zVar)) {
                AppMethodBeat.o(194323);
                return true;
            }
            AppMethodBeat.o(194323);
            return false;
        }
    }
}
