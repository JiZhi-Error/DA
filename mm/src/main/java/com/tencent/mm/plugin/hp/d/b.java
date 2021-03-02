package com.tencent.mm.plugin.hp.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.crl;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    public String clientVersion;
    public final String cri;
    public final int fileSize;
    public final Integer pkH;
    public Integer pkI;
    public final Integer pkJ;
    public final String pkK;
    public final String pkL;
    public int versionCode;
    public HashMap<Integer, LinkedList<crl>> ynu = new HashMap<>();
    public String ynv;
    public String ynw;
    public String ynx;
    public String yny;
    public String ynz;

    public b(cxz cxz) {
        AppMethodBeat.i(117514);
        if (cxz == null) {
            this.pkH = 1;
            this.pkK = "";
            this.pkL = "";
            this.pkI = -1;
            this.pkJ = -1;
            this.cri = "";
            this.fileSize = 0;
            this.ynv = "";
            this.ynw = "";
            this.versionCode = 0;
            this.clientVersion = "";
            this.ynx = "";
            this.yny = "";
            this.ynz = "";
            AppMethodBeat.o(117514);
            return;
        }
        if (cxz.MCT != null) {
            this.pkL = cxz.MCT.MD5;
            this.pkK = cxz.MCT.Url;
            this.fileSize = cxz.MCT.FileSize;
        } else {
            this.pkL = "";
            this.pkK = "";
            this.fileSize = 0;
        }
        this.pkH = Integer.valueOf(cxz.state);
        this.pkJ = Integer.valueOf(cxz.MCS);
        if (cxz.MCQ != null && !cxz.MCQ.isEmpty()) {
            int size = cxz.MCQ.size();
            for (int i2 = 0; i2 < size; i2++) {
                cxy cxy = cxz.MCQ.get(i2);
                if (cxy.MCP != null && !cxy.MCP.isEmpty()) {
                    this.ynu.put(Integer.valueOf(cxy.type), cxy.MCP);
                }
            }
        }
        this.pkI = Integer.valueOf(cxz.MCR);
        this.cri = cxz.APx;
        if (cxz.MCV == null || cxz.MCV.isEmpty()) {
            this.ynv = "";
            this.ynw = "";
            this.versionCode = 0;
            this.clientVersion = "";
            this.ynx = "";
            this.yny = "";
            this.ynz = "";
            AppMethodBeat.o(117514);
            return;
        }
        Iterator<cxx> it = cxz.MCV.iterator();
        while (it.hasNext()) {
            cxx next = it.next();
            if (next != null && !Util.isNullOrNil(next.key)) {
                if (next.key.equalsIgnoreCase("newApkMd5")) {
                    this.ynv = next.value;
                } else if (next.key.equalsIgnoreCase("oldApkMd5")) {
                    this.ynw = next.value;
                } else if (next.key.equalsIgnoreCase(AssistantStore.DownloadInfos.DownloadInfoColumns.VERSIONCODE)) {
                    this.versionCode = Util.safeParseInt(next.value);
                } else if (next.key.equalsIgnoreCase("clientVersion")) {
                    this.clientVersion = next.value;
                } else if (next.key.equalsIgnoreCase("alphaTitle")) {
                    this.ynx = c.aBL(next.value);
                } else if (next.key.equalsIgnoreCase("alphaContent")) {
                    this.yny = c.aBL(next.value);
                } else if (next.key.equalsIgnoreCase("alphaUrl")) {
                    this.ynz = next.value;
                }
            }
        }
        AppMethodBeat.o(117514);
    }

    public final boolean dZs() {
        AppMethodBeat.i(117515);
        Context context = MMApplicationContext.getContext();
        if (!NetStatusUtil.isConnected(context)) {
            AppMethodBeat.o(117515);
            return false;
        } else if (this.pkJ.intValue() == 1) {
            AppMethodBeat.o(117515);
            return true;
        } else if (this.pkJ.intValue() == 3) {
            boolean isWifi = NetStatusUtil.isWifi(context);
            AppMethodBeat.o(117515);
            return isWifi;
        } else {
            AppMethodBeat.o(117515);
            return true;
        }
    }

    public final boolean dZt() {
        AppMethodBeat.i(117516);
        if (this.pkH.intValue() == 2 || this.pkH.intValue() == 4) {
            AppMethodBeat.o(117516);
            return true;
        }
        AppMethodBeat.o(117516);
        return false;
    }

    public final boolean dZu() {
        AppMethodBeat.i(117517);
        if (this.ynu == null || this.ynu.isEmpty() || !this.ynu.containsKey(4)) {
            AppMethodBeat.o(117517);
            return false;
        }
        AppMethodBeat.o(117517);
        return true;
    }

    public static String a(HashMap<Integer, LinkedList<crl>> hashMap, int i2) {
        String str;
        AppMethodBeat.i(117518);
        if (hashMap == null || hashMap.isEmpty()) {
            AppMethodBeat.o(117518);
            return "";
        }
        String str2 = "";
        LinkedList<crl> linkedList = hashMap.get(Integer.valueOf(i2));
        if (linkedList != null && !linkedList.isEmpty()) {
            int size = linkedList.size();
            int i3 = 0;
            while (i3 < size) {
                crl crl = linkedList.get(i3);
                if (crl.lang.equalsIgnoreCase(BuildConfig.KINDA_DEFAULT)) {
                    str = new String(Base64.decode(crl.content, 0));
                } else if (crl.lang.equalsIgnoreCase(LocaleUtil.getApplicationLanguage())) {
                    String str3 = new String(Base64.decode(crl.content, 0));
                    AppMethodBeat.o(117518);
                    return str3;
                } else {
                    str = str2;
                }
                i3++;
                str2 = str;
            }
        }
        AppMethodBeat.o(117518);
        return str2;
    }

    public final String dZv() {
        AppMethodBeat.i(117519);
        if (dZu()) {
            String a2 = a(this.ynu, 4);
            AppMethodBeat.o(117519);
            return a2;
        }
        AppMethodBeat.o(117519);
        return "";
    }

    public final boolean dZw() {
        AppMethodBeat.i(196799);
        if (this.pkH.intValue() > 4 || this.pkH.intValue() <= 0) {
            Log.e("Tinker.TinkerSyncResponse", "responseState: %d must between %d and %d", this.pkH, 1, 4);
            h.INSTANCE.idkeyStat(614, 24, 1, false);
            AppMethodBeat.o(196799);
            return false;
        }
        if (dZt()) {
            if (TextUtils.isEmpty(this.cri)) {
                Log.e("Tinker.TinkerSyncResponse", "sync response patchId should not be null");
                h.INSTANCE.idkeyStat(614, 25, 1, false);
                AppMethodBeat.o(196799);
                return false;
            } else if (TextUtils.isEmpty(this.pkK)) {
                Log.e("Tinker.TinkerSyncResponse", "sync response cdnUrl should not be null");
                h.INSTANCE.idkeyStat(614, 26, 1, false);
                AppMethodBeat.o(196799);
                return false;
            } else if (TextUtils.isEmpty(this.pkL)) {
                Log.e("Tinker.TinkerSyncResponse", "sync response fileMd5 should not be null");
                h.INSTANCE.idkeyStat(614, 27, 1, false);
                AppMethodBeat.o(196799);
                return false;
            }
        }
        AppMethodBeat.o(196799);
        return true;
    }

    public final boolean dZx() {
        AppMethodBeat.i(196800);
        if (this.pkH.intValue() == 3) {
            AppMethodBeat.o(196800);
            return true;
        }
        AppMethodBeat.o(196800);
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(117520);
        String str = "responseState:" + this.pkH + "\ncdnUrl:" + this.pkK + "\nfileMd5:" + this.pkL + "\npackageType:" + this.pkI + "\nnetworkType:" + this.pkJ + "\npatchId:" + this.cri;
        AppMethodBeat.o(117520);
        return str;
    }

    public final boolean dZy() {
        AppMethodBeat.i(117521);
        Object[] objArr = new Object[2];
        objArr[0] = this.clientVersion == null ? "" : this.clientVersion;
        objArr[1] = BuildInfo.CLIENT_VERSION;
        Log.i("Tinker.TinkerSyncResponse", "clientVersion %s currentVersion %s", objArr);
        if (!Util.isNullOrNil(this.clientVersion)) {
            try {
                if ((Integer.decode(this.clientVersion).intValue() & -256) < (Integer.decode(BuildInfo.CLIENT_VERSION).intValue() & -256)) {
                    AppMethodBeat.o(117521);
                    return true;
                }
                AppMethodBeat.o(117521);
                return false;
            } catch (Exception e2) {
                Log.printErrStackTrace("Tinker.TinkerSyncResponse", e2, "isLowerClientVersion", new Object[0]);
            }
        }
        AppMethodBeat.o(117521);
        return false;
    }
}
