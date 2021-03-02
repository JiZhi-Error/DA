package com.tencent.mm.plugin.exdevice.model;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ev;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ccd;
import com.tencent.mm.protocal.protobuf.cce;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.protocal.protobuf.cch;
import com.tencent.mm.protocal.protobuf.cci;
import com.tencent.mm.protocal.protobuf.ccj;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.ejq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class g implements i {
    String dRP;
    long gof;
    long hmj;
    String iYT = "";
    public g.a iZc = new g.a() {
        /* class com.tencent.mm.plugin.exdevice.model.g.AnonymousClass2 */

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(23318);
            Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] sentToCloud:[%s]", g.this.iYT, Integer.valueOf(i2), cVar, dVar, Boolean.valueOf(g.this.rzy));
            if (cVar != null) {
                try {
                    int i3 = (int) ((((float) cVar.field_finishedLength) / ((float) cVar.field_toltalLength)) * 100.0f);
                    Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sent to cloud progress %d", Integer.valueOf(i3));
                    int i4 = i3 >= 100 ? 99 : i3;
                    for (String str2 : g.this.rzA.keySet()) {
                        g.a(g.this, str2, i4);
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdnCallback Exception %s", e2);
                    AppMethodBeat.o(23318);
                }
            }
            if (dVar != null && g.this.rzy) {
                cce cce = new cce();
                g.this.a(cce, g.this.gof);
                g.this.rzy = false;
                if (g.CO(g.this.gof).booleanValue() || g.CP(g.this.gof).booleanValue()) {
                    cce.Mid.LbJ = dVar.field_aesKey;
                    cce.Mid.Mih = new StringBuilder().append(g.this.rzC).toString();
                    cce.Mid.KMl = dVar.field_fileId;
                    cce.Mid.Url = dVar.field_fileUrl;
                    Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "image_msg.url:[%s]", cce.Mid.Url);
                } else if (g.CN(g.this.gof).booleanValue()) {
                    cce.Mie.LbJ = dVar.field_aesKey;
                    cce.Mie.KMl = dVar.field_fileId;
                    cce.Mie.Url = dVar.field_fileUrl;
                    Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file_msg.url:[%s]", cce.Mie.Url);
                } else if (g.CQ(g.this.gof).booleanValue()) {
                    cce.Mig.Url = dVar.field_fileUrl;
                    Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "video_msg.url:[%s]", cce.Mig.Url);
                }
                g.this.rzB = cce;
                for (String str3 : g.this.rzA.keySet()) {
                    bg.azz().a(new n(cce, g.this.rzA.get(str3), str3, 1), 0);
                }
                g.this.rzA.clear();
            }
            AppMethodBeat.o(23318);
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(23319);
            Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getCdnAuthInfo mediaId = ".concat(String.valueOf(str)));
            AppMethodBeat.o(23319);
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            AppMethodBeat.i(23320);
            Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "decodePrepareResponse ");
            AppMethodBeat.o(23320);
            return bArr;
        }
    };
    public HashMap<String, String> rzA = new HashMap<>();
    cce rzB;
    long rzC;
    List<b> rzD = null;
    List<b> rzE = new ArrayList();
    HashMap<String, String> rzF = new HashMap<>();
    HashMap<String, Integer> rzG = new HashMap<>();
    HashMap<String, Boolean> rzH = new HashMap<>();
    j.a rzI;
    j.a rzJ;
    j.a rzK;
    j.a rzL;
    Runnable rzM = new Runnable() {
        /* class com.tencent.mm.plugin.exdevice.model.g.AnonymousClass1 */

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00d1 A[SYNTHETIC, Splitter:B:28:0x00d1] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00e7 A[SYNTHETIC, Splitter:B:35:0x00e7] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0123  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 447
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.g.AnonymousClass1.run():void");
        }
    };
    cce rzN;
    String rzO;
    String rzP;
    int rzQ;
    HashMap<Integer, String> rzR = new HashMap<>();
    boolean rzp = false;
    boolean rzq = false;
    boolean rzr = false;
    String rzs;
    String rzt;
    String rzu;
    String rzv = "send_data_sucess";
    String rzw = "send_data_failed";
    private String rzx = "send_data_sending";
    boolean rzy = false;
    boolean rzz = false;

    public g() {
        AppMethodBeat.i(23327);
        this.rzE.clear();
        this.rzF.clear();
        this.rzH.clear();
        this.rzD = ad.cKL().cLA();
        if (this.rzD != null && this.rzD.size() > 0) {
            Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Bind Device Size is %d", Integer.valueOf(this.rzD.size()));
            int size = this.rzD.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.rzD.get(i2).fMh.contains("internet_to_device") && !this.rzD.get(i2).fMh.contains("wechat_to_device")) {
                    this.rzE.add(this.rzD.get(i2));
                }
            }
            this.rzL = new j.a() {
                /* class com.tencent.mm.plugin.exdevice.model.g.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.exdevice.model.j.a
                public final void h(int i2, Object... objArr) {
                    JSONException e2;
                    int i3;
                    AppMethodBeat.i(23321);
                    if (i2 != 15 || objArr == null || objArr.length < 2 || !(objArr[0] instanceof Integer) || !(objArr[1] instanceof byte[])) {
                        AppMethodBeat.o(23321);
                        return;
                    }
                    int intValue = ((Integer) objArr[0]).intValue();
                    try {
                        String str = new String((byte[]) objArr[1]);
                        Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file transfer update json %s", str);
                        int i4 = new JSONObject(str).getInt("progress");
                        try {
                            g.a(g.this, g.this.rzR.get(Integer.valueOf(intValue)), i4);
                            if (i4 >= 100) {
                                g.this.rzR.remove(Integer.valueOf(intValue));
                            }
                            i3 = i4;
                        } catch (JSONException e3) {
                            e2 = e3;
                            i3 = i4;
                            Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in file transfer update callback %s", e2);
                            Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", Integer.valueOf(i3));
                            AppMethodBeat.o(23321);
                        }
                    } catch (JSONException e4) {
                        e2 = e4;
                        i3 = 0;
                        Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in file transfer update callback %s", e2);
                        Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", Integer.valueOf(i3));
                        AppMethodBeat.o(23321);
                    }
                    Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", Integer.valueOf(i3));
                    AppMethodBeat.o(23321);
                }
            };
            this.rzI = new j.a() {
                /* class com.tencent.mm.plugin.exdevice.model.g.AnonymousClass4 */

                /* JADX WARNING: Removed duplicated region for block: B:29:0x0090  */
                @Override // com.tencent.mm.plugin.exdevice.model.j.a
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void h(int r12, java.lang.Object... r13) {
                    /*
                    // Method dump skipped, instructions count: 292
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.g.AnonymousClass4.h(int, java.lang.Object[]):void");
                }
            };
            this.rzJ = new j.a() {
                /* class com.tencent.mm.plugin.exdevice.model.g.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.exdevice.model.j.a
                public final void h(int i2, Object... objArr) {
                    String str;
                    AppMethodBeat.i(23323);
                    if (i2 != 12 || objArr == null || objArr.length < 2 || !(objArr[0] instanceof Integer) || !(objArr[1] instanceof byte[])) {
                        AppMethodBeat.o(23323);
                        return;
                    }
                    int intValue = ((Integer) objArr[0]).intValue();
                    byte[] bArr = (byte[]) objArr[1];
                    if (intValue <= 0 || (str = g.this.rzR.get(Integer.valueOf(intValue))) == null) {
                        Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive cmdId =".concat(String.valueOf(intValue)));
                        AppMethodBeat.o(23323);
                        return;
                    }
                    try {
                        String str2 = new String(bArr);
                        Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive response json %s", str2);
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.isNull("errcode") || jSONObject.getInt("errcode") == 0) {
                            g.fZ(str, g.this.rzv);
                            Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send data success!");
                            AppMethodBeat.o(23323);
                            return;
                        }
                        g.fZ(str, g.this.rzw);
                        Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send msg failed data %s", str2);
                        AppMethodBeat.o(23323);
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode mUseWCLanDeviceServiceCmdId failed %s", e2);
                        AppMethodBeat.o(23323);
                    }
                }
            };
            this.rzK = new j.a() {
                /* class com.tencent.mm.plugin.exdevice.model.g.AnonymousClass6 */

                @Override // com.tencent.mm.plugin.exdevice.model.j.a
                public final void h(int i2, Object... objArr) {
                    AppMethodBeat.i(23324);
                    if (i2 != 13 || objArr == null || objArr.length < 2 || !(objArr[0] instanceof String) || !(objArr[1] instanceof Integer)) {
                        AppMethodBeat.o(23324);
                        return;
                    }
                    String str = (String) objArr[0];
                    int intValue = ((Integer) objArr[1]).intValue();
                    String str2 = null;
                    try {
                        JSONObject jSONObject = new JSONObject(new String(str));
                        str2 = jSONObject.getString("deviceId");
                        jSONObject.getString("deviceType");
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                        Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in device ConnState notify callback");
                    }
                    switch (intValue) {
                        case -2:
                        case -1:
                        case 0:
                            g.this.rzH.put(str2, Boolean.FALSE);
                            Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device not connect stateCode = ".concat(String.valueOf(intValue)));
                            AppMethodBeat.o(23324);
                            return;
                        case 1:
                            g.this.rzH.put(str2, Boolean.TRUE);
                            Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device connect");
                            break;
                    }
                    AppMethodBeat.o(23324);
                }
            };
            bg.azz().a(1717, this);
            j.cKC().a(14, this.rzI);
            j.cKC().a(12, this.rzJ);
            j.cKC().a(13, this.rzK);
            j.cKC().a(15, this.rzL);
            Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "initWCLanDeviceLib...");
            Java2CExDevice.initWCLanDeviceLib();
        }
        AppMethodBeat.o(23327);
    }

    static Boolean CN(long j2) {
        k.b HD;
        AppMethodBeat.i(23328);
        boolean z = false;
        bg.aVF();
        ca Hb = com.tencent.mm.model.c.aSQ().Hb(j2);
        if (Hb.field_msgId == 0) {
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(23328);
            return bool;
        }
        String str = Hb.field_content;
        if (Hb.getType() == 49 && (HD = k.b.HD(str)) != null && HD.type == 6) {
            z = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        AppMethodBeat.o(23328);
        return valueOf;
    }

    static Boolean CO(long j2) {
        AppMethodBeat.i(23329);
        boolean z = false;
        bg.aVF();
        ca Hb = com.tencent.mm.model.c.aSQ().Hb(j2);
        if (Hb.field_msgId == 0) {
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(23329);
            return bool;
        }
        if (Hb.getType() == 3) {
            z = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        AppMethodBeat.o(23329);
        return valueOf;
    }

    static Boolean CP(long j2) {
        AppMethodBeat.i(23330);
        boolean z = false;
        bg.aVF();
        ca Hb = com.tencent.mm.model.c.aSQ().Hb(j2);
        if (Hb.field_msgId == 0) {
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(23330);
            return bool;
        }
        if (Hb.gDr()) {
            z = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        AppMethodBeat.o(23330);
        return valueOf;
    }

    static Boolean CQ(long j2) {
        AppMethodBeat.i(23331);
        boolean z = false;
        bg.aVF();
        ca Hb = com.tencent.mm.model.c.aSQ().Hb(j2);
        if (Hb.field_msgId == 0) {
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(23331);
            return bool;
        }
        if (Hb.getType() == 62) {
            z = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        AppMethodBeat.o(23331);
        return valueOf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A[SYNTHETIC, Splitter:B:21:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f A[SYNTHETIC, Splitter:B:24:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d7 A[SYNTHETIC, Splitter:B:54:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00dc A[SYNTHETIC, Splitter:B:57:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] anv(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 283
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.g.anv(java.lang.String):byte[]");
    }

    /* access modifiers changed from: package-private */
    public final cnb a(TimeLineObject timeLineObject) {
        AppMethodBeat.i(23333);
        Iterator<cnb> it = timeLineObject.ContentObj.LoV.iterator();
        while (it.hasNext()) {
            cnb next = it.next();
            if (next.Id.equals(this.rzu)) {
                AppMethodBeat.o(23333);
                return next;
            }
        }
        AppMethodBeat.o(23333);
        return null;
    }

    public final TimeLineObject cKA() {
        AppMethodBeat.i(23334);
        kf kfVar = new kf();
        kfVar.dPf.dHp = this.rzs;
        EventCenter.instance.publish(kfVar);
        TimeLineObject timeLineObject = kfVar.dPg.dPh;
        AppMethodBeat.o(23334);
        return timeLineObject;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(cce cce, long j2) {
        com.tencent.mm.pluginsdk.model.app.g gE;
        com.tencent.mm.pluginsdk.model.app.g gE2;
        AppMethodBeat.i(23335);
        int i2 = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        String CR = CR(j2);
        if (CR != null && CR.length() > 0) {
            o oVar = new o(CR);
            str2 = oVar.getName();
            i2 = (int) oVar.length();
            str3 = str2.substring(str2.lastIndexOf(".") + 1, str2.length());
            str = s.bhK(CR);
            Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "filePath %s", CR);
            Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileSize %s", Integer.valueOf(i2));
            Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileMd5 %s", str);
        }
        bg.aVF();
        ca Hb = com.tencent.mm.model.c.aSQ().Hb(j2);
        if (Hb.field_msgId == 0) {
            Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "msgInfo or msgInfo.getMsgId() = 0");
            AppMethodBeat.o(23335);
            return false;
        }
        switch (Hb.getType()) {
            case 3:
                ccf ccf = new ccf();
                ccf.Type = str3;
                ccf.Name = str2;
                ccf.oUq = i2;
                ccf.Md5 = str;
                cce.Mid = ccf;
                cce.Mia = 3;
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                bg.aVF();
                ca.b aEL = com.tencent.mm.model.c.aSQ().aEL(Hb.field_content);
                ccg ccg = new ccg();
                ccg.Mii = (float) aEL.yFu;
                ccg.Mij = (float) aEL.yFv;
                ccg.Mik = (float) aEL.dRt;
                ccg.Label = aEL.label;
                ccg.Mil = aEL.kHV;
                cce.Mic = ccg;
                cce.Mia = 2;
                break;
            case 49:
            case 268435505:
            case 1040187441:
                k.b HD = k.b.HD(Hb.field_content);
                if (HD != null) {
                    if (HD.type != 3 && HD.type != 76) {
                        if (HD.type != 6) {
                            if (HD.type != 5) {
                                if (HD.type == 2) {
                                    ccf ccf2 = new ccf();
                                    ccf2.Type = "jpg";
                                    ccf2.Name = str2;
                                    ccf2.oUq = i2;
                                    ccf2.Md5 = str;
                                    cce.Mid = ccf2;
                                    cce.Mia = 3;
                                    break;
                                }
                            } else {
                                cci cci = new cci();
                                cci.Url = HD.url;
                                cci.Title = HD.title;
                                cci.Mim = HD.description;
                                cci.xMq = HD.appName;
                                if (Util.isNullOrNil(cci.xMq) && (gE2 = h.gE(HD.appId, HD.appVersion)) != null) {
                                    cci.xMq = gE2.field_appName;
                                }
                                cce.Mif = cci;
                                cce.Mia = 5;
                                break;
                            }
                        } else {
                            ccd ccd = new ccd();
                            ccd.Type = HD.iwJ;
                            ccd.Name = HD.title;
                            ccd.oUq = i2;
                            ccd.Md5 = str;
                            cce.Mie = ccd;
                            cce.Mia = 4;
                            break;
                        }
                    } else {
                        cch cch = new cch();
                        cch.Title = HD.title;
                        cch.Mim = HD.description;
                        cch.Url = HD.url;
                        cch.Min = HD.iwH;
                        cch.Lkl = HD.ixd;
                        cch.Mio = HD.ixe;
                        cch.xMq = HD.appName;
                        if (Util.isNullOrNil(cch.xMq) && (gE = h.gE(HD.appId, HD.appVersion)) != null) {
                            cch.xMq = gE.field_appName;
                        }
                        cch.Mip = HD.iwX;
                        cch.Miq = HD.iwY;
                        cch.Mir = HD.ixb;
                        cce.Mib = cch;
                        cce.Mia = 1;
                        break;
                    }
                } else {
                    Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get content is null");
                    AppMethodBeat.o(23335);
                    return false;
                }
                break;
            case 62:
                ccj ccj = new ccj();
                ccj.Type = str3;
                ccj.oUq = i2;
                ccj.Md5 = str;
                ccj.Name = str2;
                cce.Mig = ccj;
                cce.Mia = 6;
                break;
        }
        AppMethodBeat.o(23335);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077 A[SYNTHETIC, Splitter:B:19:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007f A[SYNTHETIC, Splitter:B:22:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e0 A[SYNTHETIC, Splitter:B:42:0x00e0] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e8 A[SYNTHETIC, Splitter:B:45:0x00e8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String ab(java.lang.String r11, long r12) {
        /*
        // Method dump skipped, instructions count: 287
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.g.ab(java.lang.String, long):java.lang.String");
    }

    private String CR(long j2) {
        AppMethodBeat.i(23337);
        String str = "";
        bg.aVF();
        ca Hb = com.tencent.mm.model.c.aSQ().Hb(j2);
        if (Hb.field_msgId == 0) {
            AppMethodBeat.o(23337);
            return "";
        }
        int type = Hb.getType();
        String str2 = Hb.field_content;
        if (Hb.dOQ()) {
            k.b HD = k.b.HD(str2);
            if (HD != null && (HD.type == 6 || HD.type == 2)) {
                com.tencent.mm.pluginsdk.model.app.c bdx = ao.cgO().bdx(HD.dCK);
                if (bdx != null) {
                    str = bdx.field_fileFullPath;
                } else {
                    Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
                }
            } else if (HD != null && (HD.type == 3 || HD.type == 5)) {
                this.rzq = true;
            }
        } else if (type == 3) {
            com.tencent.mm.av.g U = q.bcR().U(Hb);
            if (U != null) {
                str = q.bcR().Oz(U.iXm);
                if (Util.isNullOrNil(str)) {
                    str = q.bcR().Oz(U.iXo);
                }
            }
        } else if (type == 62) {
            com.tencent.mm.modelvideo.o.bhj();
            str = t.Qw(Hb.field_imgPath);
        } else if (type == 48) {
            this.rzq = true;
        }
        AppMethodBeat.o(23337);
        return str;
    }

    static void fZ(String str, String str2) {
        AppMethodBeat.i(23338);
        ez ezVar = new ez();
        ezVar.dIp.dIr = str2;
        ezVar.dIp.dGL = str;
        EventCenter.instance.publish(ezVar);
        AppMethodBeat.o(23338);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        ejq ejq;
        String CR;
        AppMethodBeat.i(23339);
        Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar == null) {
            Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "scene is null.");
            AppMethodBeat.o(23339);
            return;
        }
        if (qVar instanceof n) {
            n nVar = (n) qVar;
            if (i2 == 0 && i3 == 0) {
                if (nVar.rr == null || nVar.rr.iLL.iLR == null) {
                    ejq = null;
                } else {
                    ejq = (ejq) nVar.rr.iLL.iLR;
                }
                String str2 = ejq.NiX;
                if (1 == nVar.rAw) {
                    fZ(nVar.dGL, this.rzv);
                    AppMethodBeat.o(23339);
                    return;
                }
                String str3 = nVar.dGL;
                String str4 = this.rzF.get(str3);
                fZ(str3, this.rzx);
                if (!this.rzr || this.rzs == null) {
                    CR = CR(this.gof);
                } else {
                    CR = this.rzt;
                }
                if (str4 == null || str4.length() == 0) {
                    Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mDeviceInfo error");
                    fZ(str3, this.rzw);
                    AppMethodBeat.o(23339);
                    return;
                }
                if (!this.rzp) {
                    Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onItemClick stop scan...");
                    Java2CExDevice.stopScanWCLanDevice();
                    this.rzp = true;
                }
                if (!this.rzH.containsKey(str3) || !this.rzH.get(str3).booleanValue()) {
                    Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice mDeviceInfo: ".concat(String.valueOf(str4)));
                    if (Java2CExDevice.connectWCLanDevice(str4.getBytes(), true) != 0) {
                        fZ(str3, this.rzw);
                        Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice error!");
                    }
                }
                if (this.rzq) {
                    int useWCLanDeviceService = Java2CExDevice.useWCLanDeviceService(str4.getBytes(), str2.getBytes());
                    if (useWCLanDeviceService != 0) {
                        this.rzR.put(Integer.valueOf(useWCLanDeviceService), str3);
                        this.rzG.put(str3, Integer.valueOf(useWCLanDeviceService));
                        Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get useWCLanDeviceService mCallBackCmdId: ".concat(String.valueOf(useWCLanDeviceService)));
                        AppMethodBeat.o(23339);
                        return;
                    }
                    fZ(str3, this.rzw);
                    Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "useWCLanDeviceService error!");
                    AppMethodBeat.o(23339);
                    return;
                } else if (CR == null || CR.length() == 0) {
                    Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file path is error");
                    fZ(str3, this.rzw);
                    AppMethodBeat.o(23339);
                    return;
                } else {
                    Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendDataToNearFieldDevice %s", CR);
                    int sendFileToWCLanDevice = Java2CExDevice.sendFileToWCLanDevice(str4.getBytes(), str2.getBytes(), com.tencent.mm.b.q.k(CR, false).getBytes());
                    if (sendFileToWCLanDevice != 0) {
                        this.rzR.put(Integer.valueOf(sendFileToWCLanDevice), str3);
                        this.rzG.put(str3, Integer.valueOf(sendFileToWCLanDevice));
                        Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get sendFileToWCLanDevice mCallBackCmdId =".concat(String.valueOf(sendFileToWCLanDevice)));
                        AppMethodBeat.o(23339);
                        return;
                    }
                    fZ(str3, this.rzw);
                    Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendFileToWCLanDevice error!");
                }
            } else {
                Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "NetSceneGetAppMsgInfo onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i2), Integer.valueOf(i3), str);
                fZ(nVar.dGL, this.rzw);
                AppMethodBeat.o(23339);
                return;
            }
        }
        AppMethodBeat.o(23339);
    }

    static String c(b bVar) {
        AppMethodBeat.i(23340);
        if (bVar == null) {
            AppMethodBeat.o(23340);
            return "";
        }
        String str = null;
        if (!Util.isNullOrNil(bVar.fMb)) {
            str = bVar.fMb;
        } else if (!Util.isNullOrNil(bVar.fMc)) {
            str = bVar.fMc;
        } else if (bVar.field_mac != 0) {
            str = com.tencent.mm.plugin.exdevice.k.b.Dj(bVar.field_mac);
        } else if (!Util.isNullOrNil(bVar.field_deviceID)) {
            str = bVar.field_deviceID;
        }
        String nullAsNil = Util.nullAsNil(str);
        AppMethodBeat.o(23340);
        return nullAsNil;
    }

    static /* synthetic */ void a(g gVar, String str, int i2) {
        AppMethodBeat.i(23341);
        ez ezVar = new ez();
        ezVar.dIp.dGL = str;
        if (i2 >= 100) {
            ezVar.dIp.dIr = gVar.rzv;
        } else {
            ezVar.dIp.dIr = gVar.rzx;
        }
        ezVar.dIp.progress = i2;
        EventCenter.instance.publish(ezVar);
        AppMethodBeat.o(23341);
    }

    static /* synthetic */ void dm(List list) {
        AppMethodBeat.i(23342);
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            HashMap hashMap = new HashMap();
            hashMap.put("deviceType", ((b) list.get(i2)).field_deviceType);
            hashMap.put("deviceID", ((b) list.get(i2)).field_deviceID);
            hashMap.put("displayName", c((b) list.get(i2)));
            hashMap.put("iconUrl", ((b) list.get(i2)).iconUrl);
            hashMap.put("ability", ((b) list.get(i2)).fMh);
            hashMap.put("abilityInf", ((b) list.get(i2)).fMi);
            arrayList.add(hashMap);
        }
        ev evVar = new ev();
        evVar.dIf.dHs = arrayList;
        EventCenter.instance.publish(evVar);
        AppMethodBeat.o(23342);
    }
}
