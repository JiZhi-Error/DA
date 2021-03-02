package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0006R\u001c\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000bj\b\u0012\u0004\u0012\u00020\u0005`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/NonStandardAppConstants;", "", "()V", "APPID_2_SCENE", "", "", "", "APPID_2_USERNAME", "getAPPID_2_USERNAME", "()Ljava/util/Map;", "APPID_ARRAY", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAPPID_ARRAY", "()Ljava/util/ArrayList;", "TAG", "register", "", ch.COL_USERNAME, "appId", "scene", "api-protocol_release"})
public final class t {
    private static final ArrayList<String> lfI = j.ac("wxfedb0854e2b1820d", "wx97b7aebac2183fd2", "wxa06c02b5c00ff39b", "wxf337cbaa27790d8e");
    private static final Map<String, String> lfJ = ae.f(s.U("wxfedb0854e2b1820d", "gh_a23053671f48@app"), s.U("wx97b7aebac2183fd2", "gh_232f4c80080c@app"), s.U("wxa06c02b5c00ff39b", "gh_f93dfd4799d3@app"), s.U("wxf337cbaa27790d8e", "gh_c9d570035c3b@app"));
    public static final Map<String, Integer> lfK = ae.f(s.U("wxfedb0854e2b1820d", Integer.valueOf((int) TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR)), s.U("wx97b7aebac2183fd2", Integer.valueOf((int) TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR)), s.U("wxa06c02b5c00ff39b", Integer.valueOf((int) TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR)), s.U("wxf337cbaa27790d8e", Integer.valueOf((int) TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR)));
    public static final t lfL = new t();

    static {
        AppMethodBeat.i(194322);
        AppMethodBeat.o(194322);
    }

    private t() {
    }

    public static ArrayList<String> bAf() {
        return lfI;
    }

    public static Map<String, String> bAg() {
        return lfJ;
    }

    public static void x(String str, String str2, int i2) {
        AppMethodBeat.i(194321);
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "appId");
        Log.i("MicroMsg.AppBrand.NonStandardAppConstants", "register, username:" + str + ", appId:" + str2 + ", scene:" + i2);
        lfI.add(str2);
        lfJ.put(str2, str);
        lfK.put(str2, Integer.valueOf(i2));
        AppMethodBeat.o(194321);
    }
}
