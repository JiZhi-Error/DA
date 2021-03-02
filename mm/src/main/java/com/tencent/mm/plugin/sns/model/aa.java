package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cmw;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.protocal.protobuf.ebg;
import com.tencent.mm.protocal.protobuf.ebh;
import com.tencent.mm.protocal.protobuf.ekv;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;

public final class aa extends q implements m {
    private String DJk;
    private ebg DJl;
    private String DJm;
    private boolean DJn;
    private boolean DJo;
    private boolean DJp;
    private boolean DJq;
    int DJr;
    public i callback;
    private int ecf;
    int gVY;
    private int iKP;
    public String iYT;
    private g.a iZc;
    private int iZm;
    long jSo;
    private int offset;
    private String path;
    private d rr;
    long startTime;

    public aa(int i2, String str, boolean z, int i3) {
        boolean z2;
        AppMethodBeat.i(95672);
        this.iZm = 8192;
        this.offset = 0;
        this.path = "";
        this.DJk = "";
        this.ecf = 0;
        this.DJm = "";
        this.iYT = "";
        this.DJn = false;
        this.DJo = false;
        this.DJp = false;
        this.DJq = false;
        this.jSo = 0;
        this.startTime = 0;
        this.gVY = 0;
        this.DJr = 0;
        this.iZc = new g.a() {
            /* class com.tencent.mm.plugin.sns.model.aa.AnonymousClass1 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, c cVar, com.tencent.mm.i.d dVar, boolean z) {
                AppMethodBeat.i(95671);
                if (i2 == -21005) {
                    Log.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", aa.this.iYT, Integer.valueOf(i2), cVar, dVar);
                    aa.this.callback.onSceneEnd(3, -1, "doScene failed", aa.this);
                    AppMethodBeat.o(95671);
                    return 0;
                } else if (dVar != null && dVar.field_retCode == 0) {
                    Log.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", aa.this.iYT, Integer.valueOf(i2), cVar, dVar);
                    aa.this.a(dVar.field_fileUrl, 1, dVar.field_thumbUrl, 1, "upload_" + aa.this.iYT, dVar.field_filemd5);
                    Log.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns cdndone pass: " + (System.currentTimeMillis() - aa.this.jSo) + " " + dVar.field_filemd5);
                    new y(a.t(0, 1, Long.valueOf(aa.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(aa.this.gVY), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                    aa.this.callback.onSceneEnd(0, 0, "doScene", aa.this);
                    AppMethodBeat.o(95671);
                    return 0;
                } else if (dVar != null && dVar.field_retCode != 0) {
                    Log.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", aa.this.iYT, Integer.valueOf(i2), cVar, dVar);
                    if (aa.this.DJr == 21) {
                        if (dVar.field_retCode <= -10000 && dVar.field_retCode > -20000) {
                            b.pl(10);
                        } else if (dVar.field_retCode <= -20000 && dVar.field_retCode >= -22000) {
                            b.pl(11);
                        } else if (dVar.field_retCode > -5103000 || dVar.field_retCode < -5103087) {
                            b.pl(15);
                        } else {
                            b.pl(9);
                        }
                    }
                    aa.a(aa.this, dVar.field_retCode);
                    String t = a.t(Integer.valueOf(dVar.field_retCode), 1, Long.valueOf(aa.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(aa.this.gVY), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk);
                    new y(t).bfK();
                    new w(t).bfK();
                    aa.this.callback.onSceneEnd(3, -1, "doScene failed", aa.this);
                    AppMethodBeat.o(95671);
                    return 0;
                } else if (i2 != 0) {
                    Log.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", aa.this.iYT, Integer.valueOf(i2), cVar, dVar);
                    aa.this.Ys(0);
                    if (dVar != null) {
                        new y(a.t(Integer.valueOf(i2), 1, Long.valueOf(aa.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(aa.this.gVY), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                    }
                    aa.this.callback.onSceneEnd(3, -1, "doScene failed", aa.this);
                    AppMethodBeat.o(95671);
                    return 0;
                } else {
                    Log.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", aa.this.iYT, Integer.valueOf(i2), cVar, dVar);
                    AppMethodBeat.o(95671);
                    return 0;
                }
            }

            @Override // com.tencent.mm.i.g.a
            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            @Override // com.tencent.mm.i.g.a
            public final byte[] f(String str, byte[] bArr) {
                return null;
            }
        };
        this.jSo = System.currentTimeMillis();
        this.ecf = i2;
        this.DJm = str;
        this.DJr = i3;
        d.a aVar = new d.a();
        aVar.iLN = new ebg();
        aVar.iLO = new ebh();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsupload";
        aVar.funcId = 207;
        aVar.iLP = 95;
        aVar.respCmdId = 1000000095;
        this.rr = aVar.aXF();
        this.DJl = (ebg) this.rr.iLK.iLR;
        com.tencent.mm.plugin.sns.storage.q JK = aj.faD().JK((long) i2);
        this.DJq = z;
        Log.i("MicroMsg.NetSceneMMSnsUpload", "start snsupload netscene localId " + i2 + "  offset " + JK.offset + " path " + JK.EmN + " totallen " + JK.EmM);
        if (!z) {
            this.DJl.ExtFlag = 1;
            Log.i("MicroMsg.NetSceneMMSnsUpload", "this is single upload");
        }
        try {
            cne cne = (cne) new cne().parseFrom(JK.EmR);
            this.DJk = r.aOj(JK.EmN);
            this.path = ar.ki(aj.getAccSnsPath(), JK.EmN) + this.DJk;
            this.iKP = (int) s.boW(this.path);
            this.DJn = r.aOu(this.path);
            Log.i("MicroMsg.NetSceneMMSnsUpload", "totallen " + this.iKP + " isLongPic: " + this.DJn);
            String str2 = cne.Mtu;
            if (Util.isNullOrNil(str2)) {
                str2 = com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(Util.currentTicks()).toString().getBytes());
                cne.Mtu = str2;
                try {
                    JK.EmR = cne.toByteArray();
                    aj.faD().a(JK.localid, JK);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneMMSnsUpload", e2, "", new Object[0]);
                }
            }
            this.DJl.BsF = this.iKP;
            this.DJl.BsG = JK.offset;
            this.DJl.izX = str2;
            this.iYT = str2;
            Log.d("MicroMsg.NetSceneMMSnsUpload", "filter style " + cne.MsU);
            this.DJl.MsU = cne.MsU;
            Log.d("MicroMsg.NetSceneMMSnsUpload", "syncWeibo " + cne.MsV);
            this.DJl.KHk = cne.Desc;
            this.DJl.MsV = cne.MsV;
            Log.i("MicroMsg.NetSceneMMSnsUpload", "request upload type " + JK.type + " md5: " + cne.md5 + " appid " + cne.dNI + " contenttype " + cne.beK);
            this.DJl.oUv = JK.type;
            ekv ekv = new ekv();
            ekv.Nke = cne.token;
            ekv.Nkf = cne.Mte;
            this.DJl.MID = ekv;
            if (!Util.isNullOrNil(cne.md5)) {
                this.DJl.MD5 = cne.md5;
            }
            if (!Util.isNullOrNil(cne.dNI)) {
                this.DJl.jfi = cne.dNI;
            }
            this.DJl.NaZ = cne.beK;
            if (ac.jOe) {
                this.DJl.oUv = 0;
            }
            if (this.startTime == 0) {
                this.startTime = Util.nowMilliSecond();
                this.gVY = com.tencent.mm.i.a.MediaType_FRIENDS;
            }
            ebg ebg = this.DJl;
            f.baQ();
            if (!com.tencent.mm.an.b.sS(32)) {
                f.baQ();
                Log.w("MicroMsg.NetSceneMMSnsUpload", "cdntra not use cdn flag:%b", Boolean.valueOf(com.tencent.mm.an.b.sS(32)));
                z2 = false;
            } else if (ac.jOU == 2) {
                z2 = false;
            } else {
                this.iYT = ebg.izX;
                if (Util.isNullOrNil(this.iYT)) {
                    Log.w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            if (z2) {
                this.DJo = true;
                AppMethodBeat.o(95672);
                return;
            }
            if (!fal()) {
                onError();
            }
            AppMethodBeat.o(95672);
        } catch (Exception e3) {
            Log.e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            AppMethodBeat.o(95672);
        }
    }

    private boolean fal() {
        AppMethodBeat.i(95673);
        com.tencent.mm.plugin.sns.storage.q JK = aj.faD().JK((long) this.ecf);
        int i2 = JK.EmM - JK.offset;
        if (i2 > this.iZm) {
            i2 = this.iZm;
        }
        this.offset = JK.offset;
        byte[] aW = s.aW(this.path, this.offset, i2);
        if (aW == null || aW.length <= 0) {
            AppMethodBeat.o(95673);
            return false;
        }
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(aW);
        this.DJl.KMS = sKBuiltinBuffer_t;
        this.DJl.BsG = this.offset;
        AppMethodBeat.o(95673);
        return true;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        if (this.DJn) {
            return 675;
        }
        return 100;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 207;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        boolean z;
        AppMethodBeat.i(95674);
        Log.i("MicroMsg.NetSceneMMSnsUpload", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        ebh ebh = (ebh) ((d) sVar).iLL.iLR;
        if (i3 == 4) {
            Ys(i4);
            if (this.DJr == 21) {
                b.pl(12);
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(95674);
        } else if (i3 == 0 && i4 == 0) {
            com.tencent.mm.plugin.sns.storage.q JK = aj.faD().JK((long) this.ecf);
            if (ebh.BsG < 0 || (ebh.BsG > JK.EmM && JK.EmM > 0)) {
                onError();
                if (i3 == 3) {
                    b.pl(14);
                }
                AppMethodBeat.o(95674);
            } else if (ebh.BsG < JK.offset) {
                onError();
                if (i3 == 3) {
                    b.pl(14);
                }
                AppMethodBeat.o(95674);
            } else {
                Log.d("MicroMsg.NetSceneMMSnsUpload", " bufferUrl: " + ebh.Nba.Url + " bufferUrlType: " + ebh.Nba.oUv + "  id:" + ebh.Id + " thumb Count: " + ebh.Mts + "  type " + ebh.oUv + " startPos : " + ebh.BsG);
                JK.offset = ebh.BsG;
                aj.faD().a(this.ecf, JK);
                if (JK.offset != JK.EmM || JK.EmM == 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    Log.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns done pass: " + (System.currentTimeMillis() - this.jSo));
                    if (ebh.Mtt.size() == 0 || ebh.Mtt.size() <= 0) {
                        a(ebh.Nba.Url, ebh.Nba.oUv, "", 0, new StringBuilder().append(ebh.Id).toString(), this.DJl.MD5);
                    } else {
                        a(ebh.Nba.Url, ebh.Nba.oUv, ebh.Mtt.get(0).Url, ebh.Mtt.get(0).oUv, new StringBuilder().append(ebh.Id).toString(), this.DJl.MD5);
                    }
                    this.callback.onSceneEnd(i3, i4, str, this);
                    AppMethodBeat.o(95674);
                    return;
                }
                if (fal() && doScene(dispatcher(), this.callback) < 0) {
                    this.callback.onSceneEnd(3, -1, "doScene failed", this);
                }
                AppMethodBeat.o(95674);
            }
        } else {
            onError();
            if (this.DJr == 21) {
                b.pl(13);
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(95674);
        }
    }

    public final boolean a(String str, int i2, String str2, int i3, String str3, String str4) {
        cne cne;
        AppMethodBeat.i(95675);
        com.tencent.mm.plugin.sns.storage.q JK = aj.faD().JK((long) this.ecf);
        Log.i("MicroMsg.NetSceneMMSnsUpload", "upload ok " + str + "  " + str3 + "  " + i2 + " thumbUrl: " + str2);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapUtil.decodeFile(this.path, options);
        String lowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
        int i4 = -1;
        if ((lowerCase.endsWith("jpg") || lowerCase.endsWith("jpeg")) && (i4 = MMNativeJpeg.queryQuality(this.path)) == 0) {
            i4 = -1;
        }
        com.tencent.mm.plugin.sns.k.c.c(str, options.outMimeType, options.outWidth, options.outHeight, i4, s.boW(this.path));
        JK.EmQ = str3;
        try {
            cne = (cne) new cne().parseFrom(JK.EmR);
        } catch (Exception e2) {
            cne = null;
        }
        if (cne == null) {
            cne = new cne();
        }
        cmw cmw = new cmw();
        cmw.oUv = i2;
        cmw.Url = str;
        cne.Mtr = cmw;
        cne.Mpa = 0;
        cne.md5 = str4;
        if (!Util.isNullOrNil(str2)) {
            cmw cmw2 = new cmw();
            cmw2.oUv = i3;
            cmw2.Url = str2;
            cne.Mtt.add(cmw2);
        }
        try {
            JK.EmR = cne.toByteArray();
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.NetSceneMMSnsUpload", e3, "", new Object[0]);
        }
        JK.ffa();
        aj.faD().a(this.ecf, JK);
        aj.faN().Yx(this.ecf);
        if (aj.faK() != null) {
            aj.faK().eZn();
        }
        AppMethodBeat.o(95675);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void Ys(int i2) {
        AppMethodBeat.i(95676);
        com.tencent.mm.plugin.sns.storage.q JK = aj.faD().JK((long) this.ecf);
        try {
            cne cne = (cne) new cne().parseFrom(JK.EmR);
            cne.Mpa = 1;
            cne.Mtd = i2;
            JK.EmR = cne.toByteArray();
        } catch (Exception e2) {
        }
        aj.faN().Yx(this.ecf);
        aj.faD().a(this.ecf, JK);
        AppMethodBeat.o(95676);
    }

    private void onError() {
        AppMethodBeat.i(95677);
        com.tencent.mm.plugin.sns.storage.q JK = aj.faD().JK((long) this.ecf);
        JK.offset = 0;
        try {
            cne cne = (cne) new cne().parseFrom(JK.EmR);
            cne.Mtu = "";
            JK.EmR = cne.toByteArray();
            aj.faD().a(this.ecf, JK);
            aj.faN().Yx(this.ecf);
            AppMethodBeat.o(95677);
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            AppMethodBeat.o(95677);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final void cancel() {
        AppMethodBeat.i(95678);
        super.cancel();
        if (this.DJo && !Util.isNullOrNil(this.iYT)) {
            Log.i("MicroMsg.NetSceneMMSnsUpload", "cancel by cdn " + this.iYT);
            f.baQ().Ob(this.iYT);
        }
        AppMethodBeat.o(95678);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        int i2;
        int i3 = 108;
        AppMethodBeat.i(95679);
        this.callback = iVar;
        if (this.DJo) {
            this.iYT = this.DJl.izX;
            if (Util.isNullOrNil(this.iYT)) {
                Log.w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
            } else {
                g gVar2 = new g();
                gVar2.taskName = "task_NetSceneSnsUpload_1";
                gVar2.gqy = this.iZc;
                gVar2.field_mediaId = this.iYT;
                gVar2.field_fullpath = this.path;
                gVar2.field_thumbpath = "";
                gVar2.field_fileType = com.tencent.mm.i.a.MediaType_FRIENDS;
                gVar2.field_talker = "";
                gVar2.field_priority = com.tencent.mm.i.a.gpM;
                gVar2.field_needStorage = true;
                gVar2.field_isStreamMedia = false;
                if (com.tencent.mm.plugin.sns.storage.r.ffd()) {
                    if (this.DJq) {
                        i2 = 114;
                    } else {
                        i2 = 113;
                    }
                    gVar2.field_appType = i2;
                } else if (com.tencent.mm.plugin.sns.storage.r.ffe()) {
                    if (!this.DJq) {
                        i3 = 107;
                    }
                    gVar2.field_appType = i3;
                } else if (com.tencent.mm.plugin.sns.storage.r.ffc()) {
                    if (!this.DJq) {
                        i3 = 107;
                    }
                    gVar2.field_appType = i3;
                } else {
                    f.baQ();
                    if (com.tencent.mm.an.b.sS(64)) {
                        gVar2.field_appType = this.DJq ? 104 : 103;
                    } else {
                        gVar2.field_appType = this.DJq ? 101 : 100;
                    }
                }
                gVar2.field_bzScene = 1;
                if (!f.baQ().f(gVar2)) {
                    Log.e("MicroMsg.NetSceneMMSnsUpload", "cdntra addSendTask failed. clientid:%s", this.iYT);
                    this.iYT = "";
                }
            }
            AppMethodBeat.o(95679);
            return 0;
        }
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95679);
        return dispatch;
    }

    static /* synthetic */ void a(aa aaVar, int i2) {
        AppMethodBeat.i(95680);
        for (int i3 = 0; i3 < com.tencent.mm.i.a.gqj.length; i3++) {
            if (i2 == com.tencent.mm.i.a.gqj[i3]) {
                aaVar.Ys(0);
                AppMethodBeat.o(95680);
                return;
            }
        }
        aaVar.onError();
        AppMethodBeat.o(95680);
    }
}
