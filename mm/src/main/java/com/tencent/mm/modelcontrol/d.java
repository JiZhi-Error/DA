package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class d implements bd {
    public static synchronized d baW() {
        d dVar;
        synchronized (d.class) {
            AppMethodBeat.i(150449);
            dVar = (d) y.at(d.class);
            AppMethodBeat.o(150449);
        }
        return dVar;
    }

    public static boolean baX() {
        long j2;
        AppMethodBeat.i(150450);
        if (b.baS()) {
            Log.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C image.");
            AppMethodBeat.o(150450);
            return false;
        }
        int i2 = Util.getInt(((a) g.af(a.class)).aqJ().getValue("ChatImgAutoDownload"), 1);
        if (i2 == 3) {
            Log.i("MicroMsg.SubCoreAutoDownload", "settings is not auto download C2C image. ChatImgAutoDownload : ".concat(String.valueOf(i2)));
            AppMethodBeat.o(150450);
            return false;
        }
        Context context = MMApplicationContext.getContext();
        if (i2 == 2 && NetStatusUtil.isWifi(context)) {
            Log.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
            AppMethodBeat.o(150450);
            return true;
        } else if (i2 != 1 || !NetStatusUtil.isWifi(context)) {
            long j3 = (long) Util.getInt(((a) g.af(a.class)).aqJ().getValue("ChatImgAutoDownloadMax"), 0);
            long nullAs = Util.nullAs((Long) g.aAh().azQ().get(ar.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, (Object) null), 0);
            long safeParseLong = Util.safeParseLong((String) DateFormat.format("M", System.currentTimeMillis()));
            long nullAs2 = Util.nullAs((Long) g.aAh().azQ().get(ar.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, (Object) null), 0);
            Log.d("MicroMsg.SubCoreAutoDownload", "currentmonth " + safeParseLong + " month " + nullAs2 + " maxcount " + j3 + " current " + nullAs + " downloadMode: " + i2);
            if (safeParseLong != nullAs2) {
                Log.i("MicroMsg.SubCoreAutoDownload", "update month %d ", Long.valueOf(safeParseLong));
                g.aAh().azQ().set(ar.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, (Object) 0L);
                g.aAh().azQ().set(ar.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(safeParseLong));
                j2 = 0;
            } else {
                j2 = nullAs;
            }
            if (j2 > j3 && j3 > 0) {
                Log.i("MicroMsg.SubCoreAutoDownload", "this month had auto download " + j2 + " C2C image, can not auto download.");
                AppMethodBeat.o(150450);
                return false;
            } else if (i2 != 1 || (!NetStatusUtil.isWifi(context) && !NetStatusUtil.is3G(context) && !NetStatusUtil.is4G(context))) {
                Log.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C image.");
                AppMethodBeat.o(150450);
                return false;
            } else {
                Log.i("MicroMsg.SubCoreAutoDownload", "it is wifi or 3,4G now, auto download C2C image.");
                AppMethodBeat.o(150450);
                return true;
            }
        } else {
            Log.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
            AppMethodBeat.o(150450);
            return true;
        }
    }

    public static boolean a(PInt pInt, PInt pInt2, PInt pInt3) {
        int i2;
        AppMethodBeat.i(150452);
        pInt.value = 0;
        int i3 = Util.getInt(((a) g.af(a.class)).aqJ().getValue("SIGHTAutoLoadNetwork"), 1);
        pInt2.value = i3;
        if (i3 == 3) {
            Log.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video");
            AppMethodBeat.o(150452);
            return false;
        }
        boolean isWifi = NetStatusUtil.isWifi(MMApplicationContext.getContext());
        if (i3 == 2 && !isWifi) {
            Log.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video.");
            AppMethodBeat.o(150452);
            return false;
        } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            Log.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video.");
            AppMethodBeat.o(150452);
            return false;
        } else {
            String value = ((a) g.af(a.class)).aqJ().getValue("SnsSightNoAutoDownload");
            if (!Util.isNullOrNil(value)) {
                try {
                    Log.i("MicroMsg.SubCoreAutoDownload", "dynamicConfigValSeq ".concat(String.valueOf(value)));
                    long j2 = Util.getLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), 0) - ((((long) (((int) b.baU()) - 8)) * 60) / 1000);
                    String[] split = value.split(",");
                    long j3 = Util.getLong(split[0], 0);
                    if (j2 <= Util.getLong(split[1], 0) && j2 >= j3) {
                        Log.i("MicroMsg.SubCoreAutoDownload", "config settings can not auto download SNS short video");
                        pInt3.value = 1;
                        AppMethodBeat.o(150452);
                        return false;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.SubCoreAutoDownload", "paser error %s msg: %s", value, e2.getMessage());
                }
            }
            String value2 = ((a) g.af(a.class)).aqJ().getValue("SnsSightNotAutoDownloadTimeRange");
            Log.i("MicroMsg.BusyTimeControlLogic", "SnsSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(value2)));
            if (b.Of(value2)) {
                Log.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download(but need check again) SNS short video");
                if (i3 == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                pInt.value = i2;
                AppMethodBeat.o(150452);
                return false;
            }
            Log.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download.");
            AppMethodBeat.o(150452);
            return true;
        }
    }

    public static boolean a(PInt pInt, PInt pInt2) {
        int i2;
        AppMethodBeat.i(150453);
        pInt.value = 0;
        int i3 = Util.getInt(((a) g.af(a.class)).aqJ().getValue("SIGHTAutoLoadNetwork"), 1);
        pInt2.value = i3;
        if (i3 == 3) {
            Log.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video[AD]");
            AppMethodBeat.o(150453);
            return false;
        }
        boolean isWifi = NetStatusUtil.isWifi(MMApplicationContext.getContext());
        if (i3 == 2 && !isWifi) {
            Log.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video[AD].");
            AppMethodBeat.o(150453);
            return false;
        } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            Log.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video[AD].");
            AppMethodBeat.o(150453);
            return false;
        } else {
            String value = ((a) g.af(a.class)).aqJ().getValue("SnsAdSightNotAutoDownloadTimeRange");
            Log.i("MicroMsg.BusyTimeControlLogic", "isSnsAdSightNotAutoDownload value: ".concat(String.valueOf(value)));
            if (b.Of(value)) {
                Log.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto(but need check again) download SNS short video[AD]");
                if (i3 == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                pInt.value = i2;
                AppMethodBeat.o(150453);
                return false;
            }
            Log.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download[AD].");
            AppMethodBeat.o(150453);
            return true;
        }
    }

    public static boolean T(ca caVar) {
        AppMethodBeat.i(150454);
        if (caVar == null) {
            Log.w("MicroMsg.SubCoreAutoDownload", "this message is null.");
            AppMethodBeat.o(150454);
            return false;
        }
        bp.b Ky = bp.Ky(caVar.fqK);
        if (Ky == null) {
            Log.i("MicroMsg.SubCoreAutoDownload", "this message had no msg source.");
            AppMethodBeat.o(150454);
            return true;
        }
        String str = Ky.iED;
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.SubCoreAutoDownload", "this message had no not auto download time range config.");
            AppMethodBeat.o(150454);
            return true;
        } else if (b.Of(str)) {
            Log.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download. timeRange : ".concat(String.valueOf(str)));
            AppMethodBeat.o(150454);
            return false;
        } else {
            Log.i("MicroMsg.SubCoreAutoDownload", "this message need control, but it is not the time. timeRange: ".concat(String.valueOf(str)));
            AppMethodBeat.o(150454);
            return true;
        }
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
    }

    public static boolean baY() {
        AppMethodBeat.i(150451);
        String value = ((a) g.af(a.class)).aqJ().getValue("SnsImgPreLoadingAroundTimeLimit");
        Log.i("MicroMsg.BusyTimeControlLogic", "SnsImgPreLoadingAroundTimeLimit value: ".concat(String.valueOf(value)));
        if (b.Of(value)) {
            Log.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download SNS image.");
            AppMethodBeat.o(150451);
            return false;
        }
        Log.i("MicroMsg.SubCoreAutoDownload", "it is not busy time, can auto download SNS image.");
        AppMethodBeat.o(150451);
        return true;
    }
}
