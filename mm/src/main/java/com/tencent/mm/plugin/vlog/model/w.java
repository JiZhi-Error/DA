package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0006\u0010\u0006\u001a\u00020\u0001¨\u0006\u0007"}, hxF = {"enableFallbackFailedSoftEncode", "", "enableHevcHardwareEncode", "enableHevcSoftEncode", "enableImageAddMusic", "enableMagic", "enableVideoTemplate", "plugin-vlog_release"})
public final class w {
    public static final boolean fBr() {
        AppMethodBeat.i(190629);
        if (!BuildInfo.IS_FLAVOR_PURPLE) {
            boolean z = BuildInfo.DEBUG;
        }
        if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_EDITOR_MAGIC_INT_SYNC", 0) == 1) {
            AppMethodBeat.o(190629);
            return true;
        }
        AppMethodBeat.o(190629);
        return false;
    }

    public static final boolean fBs() {
        AppMethodBeat.i(190630);
        MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_EDITOR_VIDEO_TEMPLATE_INT_SYNC", 0);
        AppMethodBeat.o(190630);
        return false;
    }

    public static final boolean fBt() {
        AppMethodBeat.i(190631);
        int i2 = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("FINDER_FOLLOW_PAT_ENTRANCE", 0);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_finder_follow_pat_entrance, 0);
        if (i2 == 1 || a2 == 1) {
            AppMethodBeat.o(190631);
            return true;
        }
        AppMethodBeat.o(190631);
        return false;
    }

    public static final boolean fBu() {
        AppMethodBeat.i(190632);
        m mVar = m.Gyi;
        if (m.fAU()) {
            m mVar2 = m.Gyi;
            if (m.fAX() == 1) {
                AppMethodBeat.o(190632);
                return true;
            }
            AppMethodBeat.o(190632);
            return false;
        }
        int i2 = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_HEVC_ENCODE_OPTION_INT_SYNC", 0);
        o oVar = o.Gyk;
        boolean fBg = o.fBg();
        if (i2 == 1 || fBg) {
            AppMethodBeat.o(190632);
            return true;
        }
        AppMethodBeat.o(190632);
        return false;
    }

    public static final boolean fBv() {
        AppMethodBeat.i(190633);
        m mVar = m.Gyi;
        if (m.fAU()) {
            m mVar2 = m.Gyi;
            if (m.fAX() == 2) {
                AppMethodBeat.o(190633);
                return true;
            }
            AppMethodBeat.o(190633);
            return false;
        }
        int i2 = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_HEVC_ENCODE_OPTION_INT_SYNC", 0);
        o oVar = o.Gyk;
        boolean fBh = o.fBh();
        if (i2 == 2 || fBh) {
            AppMethodBeat.o(190633);
            return true;
        }
        AppMethodBeat.o(190633);
        return false;
    }

    public static final boolean fBw() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(190634);
        m mVar = m.Gyi;
        if (m.fAU()) {
            m mVar2 = m.Gyi;
            if (m.fAY() == 1) {
                AppMethodBeat.o(190634);
                return true;
            }
            AppMethodBeat.o(190634);
            return false;
        }
        if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_ENABLE_SOFT_ENCODE_FALLBACK_INT_SYNC", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (((b) g.af(b.class)).a(b.a.clicfg_finder_enable_soft_encode_fallback, 0) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z || z2) {
            AppMethodBeat.o(190634);
            return true;
        }
        AppMethodBeat.o(190634);
        return false;
    }
}
