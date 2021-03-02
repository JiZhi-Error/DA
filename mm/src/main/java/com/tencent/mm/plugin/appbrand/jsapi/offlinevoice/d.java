package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.HashSet;
import java.util.Set;

public final class d {
    public static final String mjC = (b.aKA() + "files/wxofflinevoicenew/");
    private static d mjE;
    private Object lock = new Object();
    private Set<String> mjD;

    public d() {
        AppMethodBeat.i(46661);
        AppMethodBeat.o(46661);
    }

    static {
        AppMethodBeat.i(46668);
        AppMethodBeat.o(46668);
    }

    public final boolean h(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(226914);
        synchronized (this.lock) {
            try {
                Log.i("MicroMsg.OfflineVoice.VoiceOffLineHelper", "saveVoiceOfflineLanguageResId, resId :%s、path:%s、md5:%s,version:%s", str, str2, str3, str4);
                if (this.mjD == null) {
                    this.mjD = new HashSet();
                    String str5 = (String) g.aAh().azQ().get(ar.a.USERINFO_VOICE_OFFLINE_RES_IDS_STRING_SYNC, "");
                    if (!Util.isNullOrNil(str5)) {
                        String[] split = str5.split(",");
                        for (String str6 : split) {
                            this.mjD.add(str6);
                        }
                    }
                }
                MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString(str, str2).commit();
                if (Util.isEqual(str, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString("0-1" + "_md5", str3).commit();
                    MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString("0-1" + "_version", Util.nullAs(str4, "")).commit();
                    return true;
                }
                MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString(str + "_md5", str3).commit();
                MultiProcessMMKV.getMMKV("voice_offline_res_new").edit().putString(str + "_version", Util.nullAs(str4, "")).commit();
                if (!this.mjD.contains(str)) {
                    StringBuilder sb = new StringBuilder((String) g.aAh().azQ().get(ar.a.USERINFO_VOICE_OFFLINE_RES_IDS_STRING_SYNC, ""));
                    if (this.mjD.size() <= 0) {
                        sb.append(str);
                    } else {
                        sb.append(",").append(str);
                    }
                    g.aAh().azQ().set(ar.a.USERINFO_VOICE_OFFLINE_RES_IDS_STRING_SYNC, sb.toString());
                    boolean add = this.mjD.add(str);
                    AppMethodBeat.o(226914);
                    return add;
                }
                AppMethodBeat.o(226914);
                return true;
            } finally {
                AppMethodBeat.o(226914);
            }
        }
    }

    public static String bIf() {
        AppMethodBeat.i(46663);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_VOICE_OFFLINE_RES_IDS_STRING_SYNC, "");
        AppMethodBeat.o(46663);
        return str;
    }

    public static String bIg() {
        AppMethodBeat.i(46666);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_VOICE_OFFLINE_RES_ID_STRING_SYNC, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        AppMethodBeat.o(46666);
        return str;
    }

    public static void aaw(String str) {
        AppMethodBeat.i(46664);
        g.aAh().azQ().set(ar.a.USERINFO_VOICE_OFFLINE_RES_ID_STRING_SYNC, str);
        EventCenter.instance.publish(new qk());
        AppMethodBeat.o(46664);
    }

    public static d bIh() {
        AppMethodBeat.i(46667);
        if (mjE == null) {
            mjE = new d();
        }
        d dVar = mjE;
        AppMethodBeat.o(46667);
        return dVar;
    }

    public static String aax(String str) {
        AppMethodBeat.i(46665);
        String string = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(str, "");
        AppMethodBeat.o(46665);
        return string;
    }

    public static String aay(String str) {
        AppMethodBeat.i(226915);
        String string = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(str + "_md5", "");
        AppMethodBeat.o(226915);
        return string;
    }

    public static String aaz(String str) {
        AppMethodBeat.i(226916);
        String string = MultiProcessMMKV.getMMKV("voice_offline_res_new").getString(str + "_version", "");
        AppMethodBeat.o(226916);
        return string;
    }
}
