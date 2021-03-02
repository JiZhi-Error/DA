package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sandbox.b;
import com.tencent.mm.sandbox.updater.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;

public abstract class c implements b {
    public static final String NEn = com.tencent.mm.loader.j.b.aKJ();
    protected int NEo;
    public int NEp;
    public int NEq;
    public String NEr;
    private boolean NEs = false;

    public c(int i2, String str, int i3, boolean z) {
        this.NEp = i2;
        this.NEr = str;
        this.NEo = i3;
        this.NEs = z;
        this.NEq = d.bhI(bhO());
        File file = new File(NEn);
        if (!file.exists()) {
            file.mkdirs();
        }
        Log.d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + bhO() + " packOffset = " + this.NEq);
    }

    public String bhO() {
        return NEn + this.NEr + ".temp";
    }

    public String gvY() {
        return NEn + this.NEr + ".apk";
    }

    public final void deleteTempFile() {
        try {
            Log.d("MM.GetUpdatePack", "deleteTempFile");
            File file = new File(bhO());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            Log.e("MM.GetUpdatePack", "error in deleteTempFile");
        }
    }

    public static boolean bhG(String str) {
        if (d.YS(NEn + str + ".temp")) {
            return true;
        }
        return false;
    }

    public static String bhH(String str) {
        String str2 = NEn + str + ".apk";
        if (!d.YS(str2) || !a.fP(str2)) {
            return null;
        }
        return str2;
    }

    public static String aFr(String str) {
        return df(str, false);
    }

    public static String df(String str, boolean z) {
        String str2 = NEn + str + ".temp";
        String str3 = NEn + str + ".apk";
        if (!d.YS(str2) || z || (!a.fP(str2) && !str.equalsIgnoreCase(d.bhK(str2)))) {
            if (d.YS(str3)) {
                if (a.fP(str3)) {
                    Log.i("MM.GetUpdatePack", "summertoken getReadyPack checkApkMd5 update pack ok");
                    return str3;
                }
                String str4 = null;
                try {
                    str4 = com.tencent.mm.d.c.B(new File(str3));
                    if (Util.isNullOrNil(str4)) {
                        h.INSTANCE.idkeyStat(322, 10, 1, false);
                        h.INSTANCE.a(11098, 4010);
                    }
                } catch (Exception e2) {
                    Log.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + e2.getMessage());
                    h.INSTANCE.idkeyStat(322, 9, 1, false);
                    h.INSTANCE.a(11098, 4009, e2.getMessage());
                }
                Log.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", str4);
                if (!Util.isNullOrNil(str4)) {
                    String gwm = j.gwm();
                    Log.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", str4, gwm);
                    if (str4.equals(gwm)) {
                        Log.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
                        return str3;
                    }
                    Log.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
                    h.INSTANCE.idkeyStat(322, 11, 1, false);
                    h.INSTANCE.a(11098, 4011, String.format("%s,%s", gwm, str4));
                } else if (str.equalsIgnoreCase(d.bhK(str3))) {
                    Log.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
                    return str3;
                }
                Log.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
                d.deleteFile(str3);
            }
            return null;
        }
        String str5 = NEn;
        String str6 = str + ".temp";
        String str7 = str + ".apk";
        if (!(str5 == null || str6 == null || str7 == null)) {
            File file = new File(str5 + str6);
            File file2 = new File(str5 + str7);
            if (file.exists()) {
                file.renameTo(file2);
            }
        }
        return str3;
    }

    public final boolean gvZ() {
        if (!this.NEs || NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            return false;
        }
        return true;
    }
}
