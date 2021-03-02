package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ConfigFile;
import com.tencent.mm.vfs.o;

public final class g {
    private final String dataPath;
    private a joa = null;

    public static class a {
        public String extraInfo = "";
        public String ispName = "";
        public int job = 0;
        boolean joc = false;
        public int subType = 0;
    }

    public g(String str) {
        this.dataPath = str;
    }

    public final a bgh() {
        a aVar;
        a aVar2 = null;
        AppMethodBeat.i(151078);
        if (this.joa != null) {
            a aVar3 = this.joa;
            AppMethodBeat.o(151078);
            return aVar3;
        }
        String str = this.dataPath + "mobileinfo.ini";
        o oVar = new o(str);
        if (!oVar.exists()) {
            Log.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig file not exist :%s", str);
            aVar = null;
        } else {
            ConfigFile configFile = new ConfigFile(str);
            aVar = new a();
            aVar.job = Util.nullAsNil(configFile.getIntegerValue("ispCode"));
            aVar.ispName = configFile.getValue("ispName");
            aVar.subType = Util.nullAsNil(configFile.getIntegerValue("subType"));
            aVar.extraInfo = configFile.getValue("extraInfo");
            long lastModified = oVar.lastModified();
            if (10011 == ac.jOC && ac.jOD > 0) {
                lastModified = Util.nowMilliSecond() - ((long) ac.jOD);
                Log.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig DK_TEST_MOBILEINFOFILE_MODTIME val:%d lm:%d", Integer.valueOf(ac.jOD), Long.valueOf(lastModified));
                ac.jOD = 0;
            }
            if (lastModified > 0 && Util.milliSecondsToNow(lastModified) > 259200000) {
                Log.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig  diff:%d file:%s cache expired remove!", Long.valueOf(Util.milliSecondsToNow(lastModified)), str);
                aVar.joc = true;
            }
            Log.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig MobileInfo subType:%d ispCode:%d ispName:%s extraInfo:%s expired:%b", Integer.valueOf(aVar.subType), Integer.valueOf(aVar.job), aVar.ispName, aVar.extraInfo, Boolean.valueOf(aVar.joc));
        }
        this.joa = aVar;
        if (this.joa == null || this.joa.joc) {
            Context context = MMApplicationContext.getContext();
            if (context == null) {
                Log.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem MMApplicationContext is null");
            } else {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    Log.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem ConnectivityManager is null");
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        Log.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem getActiveNetworkInfo is null");
                    } else if (activeNetworkInfo.getType() == 1) {
                        Log.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem net type is wifi");
                    } else {
                        aVar2 = new a();
                        aVar2.subType = activeNetworkInfo.getSubtype();
                        aVar2.job = NetStatusUtil.getISPCode(context);
                        aVar2.ispName = NetStatusUtil.getISPName(context);
                        aVar2.extraInfo = activeNetworkInfo.getExtraInfo();
                        Log.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem subType:%d ispCode:%d ispName:%s extraInfo:%s", Integer.valueOf(aVar2.subType), Integer.valueOf(aVar2.job), aVar2.ispName, aVar2.extraInfo);
                    }
                }
            }
            if (aVar2 == null) {
                Log.v("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem failed , use old.");
                a aVar4 = this.joa;
                AppMethodBeat.o(151078);
                return aVar4;
            }
            this.joa = aVar2;
            a aVar5 = this.joa;
            if (aVar5 == null) {
                Log.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig info is null");
            } else if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig path is null");
            } else {
                ConfigFile configFile2 = new ConfigFile(str);
                configFile2.saveValue("ispCode", aVar5.job);
                configFile2.saveValue("ispName", aVar5.ispName);
                configFile2.saveValue("subType", aVar5.subType);
                configFile2.saveValue("extraInfo", aVar5.extraInfo);
            }
            a aVar6 = this.joa;
            AppMethodBeat.o(151078);
            return aVar6;
        }
        Log.v("MicroMsg.MobileInfoStorage ReportDataFlow", "checkInfo mobile info cache Read file succ.");
        a aVar7 = this.joa;
        AppMethodBeat.o(151078);
        return aVar7;
    }
}
