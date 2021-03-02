package com.tencent.mm.plugin.report.service;

import android.os.Build;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.b.h;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class j implements SmcLogic.ICallBack {
    public static IKVReportNotify Czl = null;

    @Override // com.tencent.mars.smc.SmcLogic.ICallBack
    public final void onReportDataReady(byte[] bArr, byte[] bArr2, int i2, String str) {
        AppMethodBeat.i(224162);
        try {
            if (!(Czl == null || bArr2 == null || bArr2.length <= 0)) {
                Czl.onReportKVDataReady(bArr, bArr2, i2);
            }
            AppMethodBeat.o(224162);
        } catch (Exception e2) {
            Log.e("KVReportJni", e2.getMessage());
            AppMethodBeat.o(224162);
        }
    }

    @Override // com.tencent.mars.smc.SmcLogic.ICallBack
    public final boolean onRequestGetStrategy(byte[] bArr, int i2) {
        AppMethodBeat.i(143922);
        try {
            if (!ChannelUtil.shouldShowGprsAlert || !MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("gprs_alert", true)) {
                synchronized (this) {
                    try {
                        if (h.isRunning()) {
                            Log.i("KVReportJni", "already running");
                            AppMethodBeat.o(143922);
                            return false;
                        }
                        g.aAg().hqi.a(new h(), 0);
                        AppMethodBeat.o(143922);
                        return true;
                    } catch (Throwable th) {
                        AppMethodBeat.o(143922);
                        throw th;
                    }
                }
            } else {
                Log.i("MicroMsg.SmcCallBack", "onRequestGetStrategy gprs alert return false");
                AppMethodBeat.o(143922);
                return false;
            }
        } catch (Exception e2) {
            Log.e("KVReportJni", "onRequestGetStrategy error: " + e2.getMessage());
            AppMethodBeat.o(143922);
            return false;
        }
    }

    @Override // com.tencent.mars.smc.SmcLogic.ICallBack
    public final boolean OnSelfMonitorOpLogReady(byte[] bArr) {
        AppMethodBeat.i(143923);
        g.aAf();
        if (!a.azo()) {
            Log.e("MicroMsg.SmcCallBack", "onReportKVDaSelfMonitorOpLogReady account not ready");
            AppMethodBeat.o(143923);
            return false;
        }
        try {
            k kVar = new k();
            kVar.parseFrom(bArr);
            ccs mMSelfMonitor = SmcProtoBufUtil.toMMSelfMonitor(kVar);
            if (mMSelfMonitor.Miz <= 0) {
                Log.e("KVReportJni", "error selfmonitor count");
                AppMethodBeat.o(143923);
                return true;
            }
            ((l) g.af(l.class)).aSM().d(new k.a(202, mMSelfMonitor));
            AppMethodBeat.o(143923);
            return true;
        } catch (Exception e2) {
            Log.e("KVReportJni", e2.getMessage());
            AppMethodBeat.o(143923);
            return false;
        }
    }

    @Override // com.tencent.mars.smc.SmcLogic.ICallBack
    public final int getSingleReportBufSizeB() {
        return 20480;
    }

    @Override // com.tencent.mars.smc.SmcLogic.ICallBack
    public final SmcLogic.BaseInfo getKVCommReqBaseInfo() {
        AppMethodBeat.i(143924);
        SmcLogic.BaseInfo baseInfo = new SmcLogic.BaseInfo();
        baseInfo.deviceModel = Build.MODEL + Build.CPU_ABI;
        baseInfo.deviceBrand = Build.BRAND;
        baseInfo.osName = "android-" + Build.MANUFACTURER;
        baseInfo.osVersion = new StringBuilder().append(Build.VERSION.SDK_INT).toString();
        baseInfo.languageVer = LocaleUtil.getApplicationLanguage();
        AppMethodBeat.o(143924);
        return baseInfo;
    }

    @Override // com.tencent.mars.smc.SmcLogic.ICallBack
    public final String getKVCommPath() {
        AppMethodBeat.i(143925);
        String str = AppLogic.getAppFilePath() + "/kvcomm/";
        Log.i("MicroMsg.SmcCallBack", "[TEST-PATH (Smc)]path:" + AppLogic.getAppFilePath());
        AppMethodBeat.o(143925);
        return str;
    }

    public static void aMu(String str) {
        AppMethodBeat.i(143926);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.SmcCallBack", "msg content is null");
            AppMethodBeat.o(143926);
            return;
        }
        Log.i("MicroMsg.SmcCallBack", "receive msg: ".concat(String.valueOf(str)));
        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
        if (parseXml == null || parseXml.size() == 0) {
            Log.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(str)));
            AppMethodBeat.o(143926);
            return;
        }
        String str2 = parseXml.get(".sysmsg.$type");
        if (Util.isNullOrNil(str2) || !str2.equalsIgnoreCase("getkvidkeystg")) {
            Log.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(str)));
            AppMethodBeat.o(143926);
            return;
        }
        long j2 = Util.getLong(parseXml.get(".sysmsg.getkvidkeystg.generalversion"), -1);
        long j3 = Util.getLong(parseXml.get(".sysmsg.getkvidkeystg.specialversion"), -1);
        long j4 = Util.getLong(parseXml.get(".sysmsg.getkvidkeystg.whiteorblackuinversion"), -1);
        long j5 = Util.getLong(parseXml.get(".sysmsg.getkvidkeystg.timeinterval"), -1);
        long j6 = Util.getLong(parseXml.get(".sysmsg.getkvidkeystg.kvgeneralversion"), -1);
        long j7 = Util.getLong(parseXml.get(".sysmsg.getkvidkeystg.kvspecialversion"), -1);
        long j8 = Util.getLong(parseXml.get(".sysmsg.getkvidkeystg.kvwhiteorblackuinversion"), -1);
        if (j2 == -1 || j3 == -1 || j4 == -1 || j5 == -1 || -1 == j6 || -1 == j7 || -1 == j8) {
            Log.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(str)));
            AppMethodBeat.o(143926);
            return;
        }
        Log.i("MicroMsg.SmcCallBack", "plugin msg version:" + j2 + ", " + j3 + ", " + j4);
        SmcLogic.OnPluginMsg(j6, j7, j8, j2, j3, j5);
        AppMethodBeat.o(143926);
    }
}
