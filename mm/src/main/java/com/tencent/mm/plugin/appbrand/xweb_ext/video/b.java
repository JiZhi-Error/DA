package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class b {
    public static void AP(int i2) {
        AppMethodBeat.i(50038);
        MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_preload_command_value", i2);
        AppMethodBeat.o(50038);
    }

    public static void AQ(int i2) {
        AppMethodBeat.i(50039);
        MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_player_command_value", i2);
        AppMethodBeat.o(50039);
    }

    public static void AR(int i2) {
        AppMethodBeat.i(175095);
        MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_hls_video_player_command_value", i2);
        AppMethodBeat.o(175095);
    }

    public static boolean cdM() {
        boolean z;
        AppMethodBeat.i(50040);
        int cdN = cdN();
        if (cdN >= 0) {
            Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openXWebVideoProxy, command value:%s", Integer.valueOf(cdN));
            if (cdN == 1) {
                AppMethodBeat.o(50040);
                return true;
            }
            AppMethodBeat.o(50040);
            return false;
        } else if (g.af(com.tencent.mm.plugin.expt.b.b.class) != null) {
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_xweb_video_proxy, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openXWebVideoProxy, expt is %s", Boolean.valueOf(z));
            AppMethodBeat.o(50040);
            return z;
        } else {
            AppMethodBeat.o(50040);
            return false;
        }
    }

    public static void AS(int i2) {
        AppMethodBeat.i(50041);
        MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_proxy_command_value", i2);
        AppMethodBeat.o(50041);
    }

    private static int cdN() {
        AppMethodBeat.i(50042);
        int decodeInt = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_proxy_command_value", -1);
        AppMethodBeat.o(50042);
        return decodeInt;
    }

    public static boolean cdO() {
        boolean z;
        AppMethodBeat.i(50043);
        int cdP = cdP();
        if (cdP >= 0) {
            Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openXWebVideoHlsProxy, command value:%s", Integer.valueOf(cdP));
            if (cdP == 1) {
                AppMethodBeat.o(50043);
                return true;
            }
            AppMethodBeat.o(50043);
            return false;
        } else if (g.af(com.tencent.mm.plugin.expt.b.b.class) != null) {
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_xweb_video_hls_proxy, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openXWebVideoHlsProxy, expt is %s", Boolean.valueOf(z));
            AppMethodBeat.o(50043);
            return z;
        } else {
            AppMethodBeat.o(50043);
            return false;
        }
    }

    public static void AT(int i2) {
        AppMethodBeat.i(50044);
        MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_hls_proxy_command_value", i2);
        AppMethodBeat.o(50044);
    }

    private static int cdP() {
        AppMethodBeat.i(50045);
        int decodeInt = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_hls_proxy_command_value", -1);
        AppMethodBeat.o(50045);
        return decodeInt;
    }
}
