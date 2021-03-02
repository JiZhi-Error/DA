package com.tencent.mm.plugin.audio.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/audio/util/XSettingWithAudioUtil;", "", "()V", "getForbidRefreshTime", "", "getForbidRequestTimes", "getForbidStrategy", "isAvailableToResponse", "", "plugin-audio_release"})
public final class f {
    public static final f oIs = new f();

    static {
        AppMethodBeat.i(224039);
        AppMethodBeat.o(224039);
    }

    private f() {
    }

    public static final boolean cew() {
        AppMethodBeat.i(224035);
        if (BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(224035);
            return true;
        }
        switch (ae.gKu.gDT) {
            case -1:
                boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_audio_bluetooth_forbid_use_sco, false);
                AppMethodBeat.o(224035);
                return a2;
            case 0:
            default:
                boolean a3 = ((b) g.af(b.class)).a(b.a.clicfg_audio_bluetooth_forbid_use_sco, false);
                AppMethodBeat.o(224035);
                return a3;
            case 1:
                AppMethodBeat.o(224035);
                return true;
            case 2:
                AppMethodBeat.o(224035);
                return false;
        }
    }

    public static final int cex() {
        AppMethodBeat.i(224036);
        if (BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(224036);
            return 1;
        }
        switch (ae.gKu.gDU) {
            case -1:
                int a2 = ((b) g.af(b.class)).a(b.a.clicfg_audio_bluetooth_forbid_use_sco_strategy, 1);
                AppMethodBeat.o(224036);
                return a2;
            default:
                int i2 = ae.gKu.gDU;
                AppMethodBeat.o(224036);
                return i2;
        }
    }

    public static final int cey() {
        AppMethodBeat.i(224037);
        if (BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(224037);
            return 50;
        }
        switch (ae.gKu.gDV) {
            case -1:
                int a2 = ((b) g.af(b.class)).a(b.a.clicfg_audio_bluetooth_forbid_use_sco_refresh_time, 50);
                AppMethodBeat.o(224037);
                return a2;
            default:
                int i2 = ae.gKu.gDV;
                AppMethodBeat.o(224037);
                return i2;
        }
    }

    public static final int cez() {
        AppMethodBeat.i(224038);
        if (BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(224038);
            return 2;
        }
        switch (ae.gKu.gDW) {
            case -1:
                int a2 = ((b) g.af(b.class)).a(b.a.clicfg_audio_bluetooth_forbid_use_sco_request_times, 2);
                AppMethodBeat.o(224038);
                return a2;
            default:
                int i2 = ae.gKu.gDW;
                AppMethodBeat.o(224038);
                return i2;
        }
    }
}
