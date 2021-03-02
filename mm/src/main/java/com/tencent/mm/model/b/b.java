package com.tencent.mm.model.b;

import android.os.Build;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.soter.core.biometric.FingerprintManagerProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class b {
    private boolean iGI = false;
    public ArrayList<a> mListeners = new ArrayList<>();

    public interface a {
        void aXg();
    }

    public b() {
        AppMethodBeat.i(CdnLogic.kMediaTypeEmojiNormal);
        AppMethodBeat.o(CdnLogic.kMediaTypeEmojiNormal);
    }

    /* renamed from: com.tencent.mm.model.b.b$b  reason: collision with other inner class name */
    public enum EnumC0443b {
        Main,
        Chatting;

        public static EnumC0443b valueOf(String str) {
            AppMethodBeat.i(20399);
            EnumC0443b bVar = (EnumC0443b) Enum.valueOf(EnumC0443b.class, str);
            AppMethodBeat.o(20399);
            return bVar;
        }

        static {
            AppMethodBeat.i(20400);
            AppMethodBeat.o(20400);
        }
    }

    public static String aWW() {
        AppMethodBeat.i(CdnLogic.kMediaTypeEmojiGIF);
        bg.aVF();
        String str = (String) c.azQ().get(ar.a.USERINFO_MAIN_MONITOR_MAIN_WORDING_STRING_SYNC, "");
        AppMethodBeat.o(CdnLogic.kMediaTypeEmojiGIF);
        return str;
    }

    public static String aWX() {
        AppMethodBeat.i(CdnLogic.kMediaTypeEmojiWXAM);
        bg.aVF();
        String str = (String) c.azQ().get(ar.a.USERINFO_MAIN_MONITOR_MAIN_URL_STRING_SYNC, "");
        AppMethodBeat.o(CdnLogic.kMediaTypeEmojiWXAM);
        return str;
    }

    public static boolean aWY() {
        AppMethodBeat.i(20404);
        bg.aVF();
        boolean booleanValue = ((Boolean) c.azQ().get(ar.a.USERINFO_MAIN_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(20404);
        return booleanValue;
    }

    public static String aWZ() {
        AppMethodBeat.i(20405);
        bg.aVF();
        String str = (String) c.azQ().get(ar.a.USERINFO_CHATTING_MONITOR_MAIN_WORDING_STRING_SYNC, "");
        AppMethodBeat.o(20405);
        return str;
    }

    public static String aXa() {
        AppMethodBeat.i(20406);
        bg.aVF();
        String str = (String) c.azQ().get(ar.a.USERINFO_CHATTING_MONITOR_MAIN_URL_STRING_SYNC, "");
        AppMethodBeat.o(20406);
        return str;
    }

    public static boolean aXb() {
        AppMethodBeat.i(20407);
        bg.aVF();
        boolean booleanValue = ((Boolean) c.azQ().get(ar.a.USERINFO_CHATTING_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(20407);
        return booleanValue;
    }

    private static boolean aXc() {
        AppMethodBeat.i(20408);
        bg.aVF();
        boolean booleanValue = ((Boolean) c.azQ().get(ar.a.USERINFO_CHATTING_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(20408);
        return booleanValue;
    }

    private static boolean aXd() {
        AppMethodBeat.i(20409);
        bg.aVF();
        boolean booleanValue = ((Boolean) c.azQ().get(ar.a.USERINFO_MONITOR_IS_TRIGGERED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(20409);
        return booleanValue;
    }

    private void a(String str, String str2, long j2, boolean z, boolean z2, String str3, String str4, long j3, boolean z3, boolean z4, String str5) {
        AppMethodBeat.i(20410);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_CHATTING_MONITOR_MAIN_WORDING_STRING_SYNC, str3);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_CHATTING_MONITOR_MAIN_URL_STRING_SYNC, str4);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_CHATTING_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(j3));
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_CHATTING_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.valueOf(z3));
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_CHATTING_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.valueOf(z4));
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_CHATTING_MONITOR_FINGER_PRINT_STRING_SYNC, str5);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_MAIN_MONITOR_MAIN_WORDING_STRING_SYNC, str);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_MAIN_MONITOR_MAIN_URL_STRING_SYNC, str2);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_MAIN_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(j2));
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_MAIN_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.valueOf(z));
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_MAIN_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.valueOf(z2));
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_MONITOR_BANNER_MSG_COME_TIME_TICKS_LONG_SYNC, Long.valueOf(Util.nowSecond()));
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_MAIN_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_MONITOR_IS_TRIGGERED_BOOLEAN_SYNC, Boolean.FALSE);
        bg.aVF();
        c.azQ().gBI();
        aXe();
        AppMethodBeat.o(20410);
    }

    public final void C(Map<String, String> map) {
        AppMethodBeat.i(20411);
        if (map == null) {
            AppMethodBeat.o(20411);
            return;
        }
        h.INSTANCE.idkeyStat(633, 3, 1, false);
        Log.d("MicroMsg.ChattingMonitoredBannerStorage", "origin values: ".concat(String.valueOf(map)));
        i(".sysmsg.banner.monitorbanner_n.", map);
        i(".sysmsg.banner.monitorbanner_o.", map);
        AppMethodBeat.o(20411);
    }

    private void i(String str, Map<String, String> map) {
        AppMethodBeat.i(20412);
        String str2 = str + "chatting.";
        String nullAsNil = Util.nullAsNil(map.get(str2 + FingerprintManagerProxy.FINGERPRINT_SERVICE));
        if (!str2.equals(".sysmsg.banner.monitorbanner_n.") || Util.isNullOrNil(nullAsNil)) {
            String nullAsNil2 = Util.nullAsNil(map.get(str2 + "url"));
            String nullAsNil3 = Util.nullAsNil(map.get(str2 + "wording"));
            long j2 = Util.getLong(map.get(str2 + FFmpegMetadataRetriever.METADATA_KEY_DURATION), 0);
            boolean z = Util.getInt(map.get(new StringBuilder().append(str2).append("autotrigger").toString()), 0) == 1;
            boolean z2 = Util.getInt(map.get(new StringBuilder().append(str2).append("closable").toString()), 0) == 1;
            String str3 = str + "mainframe.";
            String nullAsNil4 = Util.nullAsNil(map.get(str3 + "url"));
            String nullAsNil5 = Util.nullAsNil(map.get(str3 + "wording"));
            long j3 = Util.getLong(map.get(str3 + FFmpegMetadataRetriever.METADATA_KEY_DURATION), 0);
            boolean z3 = Util.getInt(map.get(new StringBuilder().append(str3).append("autotrigger").toString()), 0) == 1;
            boolean z4 = Util.getInt(map.get(new StringBuilder().append(str3).append("closable").toString()), 0) == 1;
            if (!Util.isNullOrNil(nullAsNil5) || !Util.isNullOrNil(nullAsNil3)) {
                Log.d("MicroMsg.ChattingMonitoredBannerStorage", "received msg:\nchattingUrl = " + nullAsNil2 + "\nchattingWording = " + nullAsNil3 + "\nchattingDuration = " + j2 + "\nchattingAutotrigger = " + z + "\nchattingCloseable = " + z2 + "\nfingerPrint = " + nullAsNil);
                a(nullAsNil5, nullAsNil4, j3, z4, z3, nullAsNil3, nullAsNil2, j2, z2, z, nullAsNil);
            }
            AppMethodBeat.o(20412);
            return;
        }
        Log.e("MicroMsg.ChattingMonitoredBannerStorage", "monitorbanner_n must NOT contain fingerprint.");
        AppMethodBeat.o(20412);
    }

    public static boolean a(EnumC0443b bVar) {
        long longValue;
        boolean booleanValue;
        boolean booleanValue2;
        String aWW;
        AppMethodBeat.i(20413);
        Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", bVar);
        long nowSecond = Util.nowSecond();
        bg.aVF();
        long longValue2 = ((Long) c.azQ().get(ar.a.USERINFO_MONITOR_BANNER_MSG_COME_TIME_TICKS_LONG_SYNC, (Object) -1L)).longValue();
        bg.aVF();
        String str = (String) c.azQ().get(ar.a.USERINFO_CHATTING_MONITOR_FINGER_PRINT_STRING_SYNC, "");
        if (bVar == EnumC0443b.Chatting) {
            bg.aVF();
            longValue = ((Long) c.azQ().get(ar.a.USERINFO_CHATTING_MONITOR_MAIN_INTERVAL_LONG_SYNC, (Object) 0L)).longValue();
            bg.aVF();
            booleanValue = ((Boolean) c.azQ().get(ar.a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
            booleanValue2 = aXc();
            aWW = aWZ();
        } else {
            bg.aVF();
            longValue = ((Long) c.azQ().get(ar.a.USERINFO_MAIN_MONITOR_MAIN_INTERVAL_LONG_SYNC, (Object) 0L)).longValue();
            bg.aVF();
            booleanValue = ((Boolean) c.azQ().get(ar.a.USERINFO_MAIN_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
            bg.aVF();
            booleanValue2 = ((Boolean) c.azQ().get(ar.a.USERINFO_MAIN_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
            aWW = aWW();
        }
        if (!Util.isNullOrNil(str)) {
            if (!str.equals(Build.FINGERPRINT)) {
                h.INSTANCE.idkeyStat(633, 5, 1, false);
                Log.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] NOT equals current device's [%s] , should NOT show banner", str, Build.FINGERPRINT);
                AppMethodBeat.o(20413);
                return false;
            }
            Log.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] equals current device's [%s] , should show banner", str, Build.FINGERPRINT);
        }
        if (Util.isNullOrNil(aWW)) {
            Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not get wording");
            AppMethodBeat.o(20413);
            return false;
        } else if (booleanValue) {
            Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not check trigger and already closed");
            AppMethodBeat.o(20413);
            return false;
        } else if (longValue2 < 0) {
            Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: no msg occurs");
            AppMethodBeat.o(20413);
            return false;
        } else if (booleanValue2 && !aXd()) {
            Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: should check triggered but not triggered");
            AppMethodBeat.o(20413);
            return false;
        } else if (longValue == -1) {
            Log.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: should always show");
            AppMethodBeat.o(20413);
            return true;
        } else if (longValue2 + longValue > nowSecond) {
            Log.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: still in show time. show banner");
            AppMethodBeat.o(20413);
            return true;
        } else {
            Log.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: expired.");
            AppMethodBeat.o(20413);
            return false;
        }
    }

    private void aXe() {
        AppMethodBeat.i(20414);
        synchronized (b.class) {
            try {
                Iterator<a> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    it.next().aXg();
                }
            } finally {
                AppMethodBeat.o(20414);
            }
        }
    }

    public final void aXf() {
        AppMethodBeat.i(20415);
        if (!aXd()) {
            Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_MONITOR_BANNER_MSG_COME_TIME_TICKS_LONG_SYNC, Long.valueOf(Util.nowSecond()));
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_MONITOR_IS_TRIGGERED_BOOLEAN_SYNC, Boolean.TRUE);
            aXe();
        }
        AppMethodBeat.o(20415);
    }

    public final void b(EnumC0443b bVar) {
        AppMethodBeat.i(20416);
        if (bVar == EnumC0443b.Main) {
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_MAIN_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE);
        } else {
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE);
        }
        aXe();
        AppMethodBeat.o(20416);
    }

    public final void c(EnumC0443b bVar) {
        AppMethodBeat.i(20417);
        if (bVar == EnumC0443b.Main) {
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_MAIN_MONITOR_MAIN_INTERVAL_LONG_SYNC, (Object) 0L);
        } else {
            if (bVar == EnumC0443b.Chatting) {
                if (!aXc()) {
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_CHATTING_MONITOR_MAIN_INTERVAL_LONG_SYNC, (Object) 0L);
                } else {
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.TRUE);
                }
            }
            AppMethodBeat.o(20417);
        }
        aXe();
        AppMethodBeat.o(20417);
    }
}
