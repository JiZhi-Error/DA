package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.k;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class c implements k {
    @Override // com.tencent.mm.plugin.appbrand.service.k
    public final boolean bVs() {
        AppMethodBeat.i(50046);
        int decodeInt = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_preload_command_value", -1);
        if (decodeInt >= 0) {
            Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openWeishiVideoPreload, command value:%s", Integer.valueOf(decodeInt));
            if (decodeInt == 1) {
                AppMethodBeat.o(50046);
                return true;
            }
            AppMethodBeat.o(50046);
            return false;
        } else if (((b) g.af(b.class)).a(b.a.clicfg_android_weishi_video_preload, 0) == 1) {
            AppMethodBeat.o(50046);
            return true;
        } else {
            AppMethodBeat.o(50046);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.service.k
    public final int bVt() {
        AppMethodBeat.i(50047);
        int decodeInt = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_weishi_ps_command_value", -1);
        if (decodeInt >= 0) {
            Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getWeishiVideoPreloadSize, command value:%s", Integer.valueOf(decodeInt));
            AppMethodBeat.o(50047);
            return decodeInt;
        }
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_weishi_video_preload_size, -1);
        AppMethodBeat.o(50047);
        return a2;
    }
}
