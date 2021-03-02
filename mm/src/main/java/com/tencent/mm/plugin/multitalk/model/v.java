package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.ui.widget.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.List;

public final class v {
    public static String g(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(114579);
        if (multiTalkGroup == null) {
            AppMethodBeat.o(114579);
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        List<MultiTalkGroupMember> list = multiTalkGroup.RHa;
        stringBuffer.append("->[usernamelist]");
        if (list != null) {
            for (MultiTalkGroupMember multiTalkGroupMember : list) {
                stringBuffer.append(multiTalkGroupMember.RHb + "|");
                stringBuffer.append(multiTalkGroupMember.status + ", ");
            }
        }
        stringBuffer.append(" ->createname:" + multiTalkGroup.RGZ);
        stringBuffer.append(" ->talkgroupId:" + multiTalkGroup.zHD);
        stringBuffer.append(" ->wxGroupId:" + multiTalkGroup.zHE);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(114579);
        return stringBuffer2;
    }

    public static boolean h(MultiTalkGroup multiTalkGroup) {
        boolean z;
        AppMethodBeat.i(114581);
        if (multiTalkGroup == null) {
            AppMethodBeat.o(114581);
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.RHa) {
            if (multiTalkGroupMember.RHb.equals(z.aTY())) {
                if (multiTalkGroupMember.status == 10) {
                    if (z2) {
                        AppMethodBeat.o(114581);
                        return true;
                    }
                    z3 = true;
                }
                z = z2;
            } else {
                if (multiTalkGroupMember.status == 10) {
                    if (z3) {
                        AppMethodBeat.o(114581);
                        return true;
                    }
                    z = true;
                }
                z = z2;
            }
            z2 = z;
        }
        AppMethodBeat.o(114581);
        return false;
    }

    public static boolean i(MultiTalkGroup multiTalkGroup) {
        int i2;
        AppMethodBeat.i(239428);
        int i3 = 0;
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.RHa) {
            if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            i3 = i2;
        }
        if (i3 > 1) {
            AppMethodBeat.o(239428);
            return true;
        }
        AppMethodBeat.o(239428);
        return false;
    }

    public static boolean c(o oVar) {
        if (oVar == o.Starting || oVar == o.Talking || oVar == o.Inviting) {
            return true;
        }
        return false;
    }

    public static boolean j(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(114583);
        boolean equals = multiTalkGroup.RGZ.equals(z.aTY());
        AppMethodBeat.o(114583);
        return equals;
    }

    public static String k(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(114584);
        if (multiTalkGroup == null) {
            AppMethodBeat.o(114584);
            return "";
        }
        String str = multiTalkGroup.zHD;
        if (Util.isNullOrNil(str)) {
            str = multiTalkGroup.RGY;
        }
        String nullAs = Util.nullAs(str, "");
        AppMethodBeat.o(114584);
        return nullAs;
    }

    public static String enW() {
        AppMethodBeat.i(114585);
        String k = k(ac.eom().zME);
        AppMethodBeat.o(114585);
        return k;
    }

    public static String l(MultiTalkGroup multiTalkGroup) {
        String str;
        AppMethodBeat.i(114586);
        String str2 = null;
        int i2 = 0;
        while (i2 < multiTalkGroup.RHa.size()) {
            if (multiTalkGroup.RHa.get(i2).RHb.equals(z.aTY())) {
                str = multiTalkGroup.RHa.get(i2).RHc;
            } else {
                str = str2;
            }
            i2++;
            str2 = str;
        }
        AppMethodBeat.o(114586);
        return str2;
    }

    public static String enX() {
        AppMethodBeat.i(114587);
        String l = l(ac.eom().zME);
        AppMethodBeat.o(114587);
        return l;
    }

    public static boolean Rl(int i2) {
        return i2 == 2 || i2 == 3;
    }

    public static boolean Rm(int i2) {
        return i2 == 1 || i2 == 3;
    }

    public enum a {
        WIFI,
        _4G,
        _3GOr_2G,
        None;

        public static a valueOf(String str) {
            AppMethodBeat.i(114577);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(114577);
            return aVar;
        }

        static {
            AppMethodBeat.i(114578);
            AppMethodBeat.o(114578);
        }
    }

    public static a enY() {
        AppMethodBeat.i(114589);
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            a aVar = a.WIFI;
            AppMethodBeat.o(114589);
            return aVar;
        } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
            a aVar2 = a._4G;
            AppMethodBeat.o(114589);
            return aVar2;
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext()) || NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            a aVar3 = a._3GOr_2G;
            AppMethodBeat.o(114589);
            return aVar3;
        } else {
            a aVar4 = a.None;
            AppMethodBeat.o(114589);
            return aVar4;
        }
    }

    public static boolean enZ() {
        AppMethodBeat.i(114590);
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, (Object) -1)).intValue();
        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, (Object) -1L)).longValue();
        if (intValue <= 0 || longValue <= 0) {
            g.aAh().azQ().set(ar.a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, (Object) -1);
            g.aAh().azQ().set(ar.a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, (Object) -1L);
            AppMethodBeat.o(114590);
            return true;
        }
        Log.i("MicroMsg.MultiTalkUtil", "checkMultiTalkAvailable, disableTime: %s, disableTimestamp: %s", Integer.valueOf(intValue), Long.valueOf(longValue));
        if (Util.ticksToNow(longValue) <= ((long) (intValue * 1000))) {
            AppMethodBeat.o(114590);
            return false;
        }
        g.aAh().azQ().set(ar.a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, (Object) -1);
        g.aAh().azQ().set(ar.a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, (Object) -1L);
        AppMethodBeat.o(114590);
        return true;
    }
}
