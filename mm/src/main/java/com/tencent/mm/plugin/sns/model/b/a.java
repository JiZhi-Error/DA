package com.tencent.mm.plugin.sns.model.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a {
    private static int DPZ = 6;
    private static int DQa = 3;
    private static int DQb = 1000;
    private static boolean DQc = true;
    private static String DQd = "";
    private static int DQe = 0;
    private static int DQf = 60;
    private static int DQg = 1200;
    private static float DQh = 4.0f;
    private static float DQi = 8.0f;
    private static int DQj = 1;
    private static int DQk = 3;
    private static String DQl = "20:00-23:59";

    public static void fcd() {
        AppMethodBeat.i(96078);
        DQc = ((b) g.af(b.class)).a(b.a.clicfg_timeline_preload_switch, true);
        DQd = ((b) g.af(b.class)).a(b.a.clicfg_timeline_preload_time, "20:00-23:59");
        DQe = ((b) g.af(b.class)).a(b.a.clicfg_timeline_preload_nettype, 1);
        DPZ = ((b) g.af(b.class)).a(b.a.clicfg_timeline_preload_in_queue, 6);
        DQa = ((b) g.af(b.class)).a(b.a.clicfg_timeline_parallel_in_queue, 3);
        DQb = ((b) g.af(b.class)).a(b.a.clicfg_timeline_max_preload, 1000);
        DQf = ((b) g.af(b.class)).a(b.a.clicfg_timeline_preload_percent, 60);
        DQh = ((b) g.af(b.class)).a(b.a.clicfg_timeline_preload_time_min, 4.0f);
        DQi = ((b) g.af(b.class)).a(b.a.clicfg_timeline_preload_time_max, 8.0f);
        DQj = fcj();
        DQk = fck();
        Log.printInfoStack("MicroMsg.SnsPreloadSwitch", "TIMELINE_MAIN_SWITCH:%b\nTIMELINE_DAY_UNABLE_PRELOAD_TIME_INTERVAL:%s\nTIMELINE_PRELOAD_NET_TYPE:%d\nTIMELINE_MAX_PRELOAD_IN_QUEUE:%d\nTIMELINE_MAX_PARALLEL_IN_QUEUE:%d\n TIMELINE_MAX_PRELOAD_COUNT:%d\nTIMELINE_PRELOAD_PERCENT:%d\nTIMELINE_OUT_PRELOAD_INTERVAL:%d\nSNS_RED_DOT_PRELOAD:%d\n SNS_PRELOAD_VIDEO_EXPIRED_TIME:%d\nSNS_RED_DOT_PRELOAD_BUSY_TIME:%s", Boolean.valueOf(DQc), DQd, Integer.valueOf(DQe), Integer.valueOf(DPZ), Integer.valueOf(DQa), Integer.valueOf(DQb), Integer.valueOf(DQf), Integer.valueOf(DQg), Integer.valueOf(DQj), Integer.valueOf(DQk), DQl);
        AppMethodBeat.o(96078);
    }

    public static boolean fce() {
        AppMethodBeat.i(96079);
        if (!DQc) {
            Log.printInfoStack("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_MAIN_SWITCH", new Object[0]);
            AppMethodBeat.o(96079);
            return false;
        }
        int iOSNetType = NetStatusUtil.getIOSNetType(MMApplicationContext.getContext());
        switch (DQe) {
            case 1:
                if (iOSNetType != 1) {
                    AppMethodBeat.o(96079);
                    return false;
                }
                break;
            case 2:
                if (iOSNetType != 4) {
                    AppMethodBeat.o(96079);
                    return false;
                }
                break;
            case 3:
                if (!(iOSNetType == 1 || iOSNetType == 4)) {
                    AppMethodBeat.o(96079);
                    return false;
                }
            case 4:
                if (iOSNetType != 3) {
                    AppMethodBeat.o(96079);
                    return false;
                }
                break;
        }
        if (!TextUtils.isEmpty(DQd) && com.tencent.mm.modelcontrol.b.Of(DQd)) {
            Log.printInfoStack("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_DAY_UNABLE_PRELOAD_TIME_INTERVAL %s", DQd);
            AppMethodBeat.o(96079);
            return false;
        } else if (!YO(0)) {
            Log.printInfoStack("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_MAX_PRELOAD_COUNT", new Object[0]);
            AppMethodBeat.o(96079);
            return false;
        } else {
            AppMethodBeat.o(96079);
            return true;
        }
    }

    public static boolean YO(int i2) {
        AppMethodBeat.i(96080);
        String format = SimpleDateFormat.getDateInstance().format(new Date());
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("MicroMsg.SnsPreloadSwitch");
        String decodeString = mmkv.decodeString("SnsPreloadSwitch_KEY_DATE");
        if (TextUtils.isEmpty(decodeString) || !decodeString.equals(format)) {
            Log.i("MicroMsg.SnsPreloadSwitch", "yesterday preload count:%d", Integer.valueOf(mmkv.decodeInt("SnsPreloadSwitch_KEY_COUNT")));
            mmkv.encode("SnsPreloadSwitch_KEY_DATE", format);
            mmkv.encode("SnsPreloadSwitch_KEY_COUNT", i2);
            AppMethodBeat.o(96080);
            return true;
        }
        int decodeInt = mmkv.decodeInt("SnsPreloadSwitch_KEY_COUNT", 0);
        if (i2 + decodeInt < DQb) {
            mmkv.encode("SnsPreloadSwitch_KEY_COUNT", decodeInt + i2);
            AppMethodBeat.o(96080);
            return true;
        }
        AppMethodBeat.o(96080);
        return false;
    }

    public static int fcf() {
        return DPZ;
    }

    public static int fcg() {
        return DQa;
    }

    public static int fch() {
        return DQf;
    }

    public static int fci() {
        AppMethodBeat.i(96081);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_timeline_out_preload_interval, 1200);
        DQg = a2;
        AppMethodBeat.o(96081);
        return a2;
    }

    public static int a(cnb cnb, int i2) {
        AppMethodBeat.i(96082);
        if (cnb.MsT > 0.0f) {
            float f2 = (cnb.MsT * ((float) i2)) / 100.0f;
            if (f2 < DQh) {
                int min = (int) ((Math.min(DQh, cnb.MsT) * 100.0f) / cnb.MsT);
                AppMethodBeat.o(96082);
                return min;
            } else if (f2 > DQi) {
                int i3 = (int) ((DQi * 100.0f) / cnb.MsT);
                AppMethodBeat.o(96082);
                return i3;
            }
        }
        AppMethodBeat.o(96082);
        return i2;
    }

    public static int fcj() {
        AppMethodBeat.i(96083);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_red_dot_preload, 1);
        DQj = a2;
        AppMethodBeat.o(96083);
        return a2;
    }

    public static int fck() {
        AppMethodBeat.i(96084);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_sns_preload_video_expired_time, 3);
        DQk = a2;
        AppMethodBeat.o(96084);
        return a2;
    }
}
