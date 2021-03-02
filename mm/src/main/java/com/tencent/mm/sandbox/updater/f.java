package com.tencent.mm.sandbox.updater;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.i;
import com.tencent.mm.protocal.protobuf.crl;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f {
    public String clientVersion;
    public final String cri;
    public final int fileSize;
    public final Integer pkH;
    public final Integer pkI;
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

    public f(cxz cxz) {
        AppMethodBeat.i(32708);
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
            AppMethodBeat.o(32708);
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
            AppMethodBeat.o(32708);
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
                    this.ynx = aBL(next.value);
                } else if (next.key.equalsIgnoreCase("alphaContent")) {
                    this.yny = aBL(next.value);
                } else if (next.key.equalsIgnoreCase("alphaUrl")) {
                    this.ynz = next.value;
                }
            }
        }
        AppMethodBeat.o(32708);
    }

    public final String gwj() {
        AppMethodBeat.i(32709);
        String substring = this.pkK.substring(0, this.pkK.lastIndexOf(47) + 1);
        String substring2 = this.pkK.substring(this.pkK.lastIndexOf(47) + 1);
        i iVar = new i(substring, this.versionCode);
        iVar.a(new i.a(this.ynw, this.ynv, this.pkL, substring2, this.fileSize));
        String VO = iVar.VO();
        AppMethodBeat.o(32709);
        return VO;
    }

    public final String toString() {
        AppMethodBeat.i(32710);
        String str = "responseState:" + this.pkH + "\ncdnUrl:" + this.pkK + "\nfileMd5:" + this.pkL + "\npackageType:" + this.pkI + "\nnetworkType:" + this.pkJ + "\npatchId:" + this.cri;
        AppMethodBeat.o(32710);
        return str;
    }

    public static boolean aBK(String str) {
        AppMethodBeat.i(32711);
        if (!Util.isNullOrNil(str) && str.length() == 10) {
            try {
                int intValue = Integer.decode(str).intValue();
                if ((intValue & 255) < 0 || (intValue & 255) > 31) {
                    AppMethodBeat.o(32711);
                    return false;
                }
                AppMethodBeat.o(32711);
                return true;
            } catch (Exception e2) {
                Log.printErrStackTrace("Tinker.TinkerSyncResponse", e2, "checkAplhVersion failed.", new Object[0]);
            }
        }
        AppMethodBeat.o(32711);
        return false;
    }

    private static String aBL(String str) {
        AppMethodBeat.i(32712);
        if (!Util.isNullOrNil(str)) {
            String str2 = new String(Base64.decode(str, 0));
            AppMethodBeat.o(32712);
            return str2;
        }
        AppMethodBeat.o(32712);
        return "";
    }
}
