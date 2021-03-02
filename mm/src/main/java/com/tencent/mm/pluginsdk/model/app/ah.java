package com.tencent.mm.pluginsdk.model.app;

import android.graphics.BitmapFactory;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.g.a.aax;
import com.tencent.mm.g.a.p;
import com.tencent.mm.i.d;
import com.tencent.mm.m.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.protocal.protobuf.dth;
import com.tencent.mm.protocal.protobuf.dti;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.fd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Locale;

public final class ah extends q implements m {
    private aax DIA;
    private a JWD;
    private p JWE;
    private c JWI;
    private boolean JWJ;
    private a JWK;
    private i callback;
    private ca dTX;
    private int dYz;
    private d hmq;
    private String mSessionId;
    private long msgId;
    private com.tencent.mm.ak.d rr;

    interface a {
        void dq(int i2, int i3);
    }

    public ah(long j2, boolean z, d dVar, a aVar, String str, c cVar) {
        AppMethodBeat.i(31057);
        this.msgId = 0;
        this.hmq = null;
        this.JWI = null;
        this.dTX = null;
        this.JWJ = false;
        this.dYz = 0;
        this.JWK = null;
        this.msgId = j2;
        this.mSessionId = str;
        this.hmq = dVar;
        this.JWK = aVar;
        this.JWJ = z;
        this.JWI = cVar;
        d.a aVar2 = new d.a();
        aVar2.iLN = new dth();
        aVar2.iLO = new dti();
        aVar2.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar2.funcId = TbsListener.ErrorCode.UNLZMA_FAIURE;
        aVar2.iLP = 107;
        aVar2.respCmdId = 1000000107;
        this.rr = aVar2.aXF();
        Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", Long.valueOf(j2), dVar, str, cVar, Util.getStack());
        AppMethodBeat.o(31057);
    }

    public ah(long j2, com.tencent.mm.i.d dVar, a aVar, String str, int i2, a aVar2) {
        this(j2, false, dVar, aVar, str, (c) null);
        this.dYz = i2;
        this.JWD = aVar2;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.UNLZMA_FAIURE;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        BitmapFactory.Options imageOptions;
        AppMethodBeat.i(31058);
        this.callback = iVar;
        bg.aVF();
        this.dTX = c.aSQ().Hb(this.msgId);
        if (this.dTX == null || this.dTX.field_msgId != this.msgId) {
            Log.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", Long.valueOf(this.msgId));
            this.JWK.dq(3, -1);
            AppMethodBeat.o(31058);
            return -1;
        }
        k.b HD = k.b.HD(this.dTX.field_content);
        if (HD == null) {
            Log.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", Long.valueOf(this.msgId));
            this.JWK.dq(3, -1);
        }
        dth dth = (dth) this.rr.iLK.iLR;
        fd fdVar = new fd();
        fdVar.jfi = HD.appId;
        fdVar.KIz = this.dTX.field_talker + this.dTX.field_msgId + "T" + this.dTX.field_createTime;
        fdVar.CreateTime = (int) Util.nowSecond();
        fdVar.xNG = this.dTX.field_talker;
        fdVar.xNH = z.aTY();
        fdVar.oUv = HD.type;
        fdVar.KIy = HD.sdkVer;
        fdVar.xub = HD.iwL;
        String o = a.C0409a.anC().o(this.dTX);
        if (!Util.isNullOrNil(o)) {
            fdVar.KHq = o;
        } else {
            fdVar.KHq = br.ajw();
        }
        fdVar.KIC = HD.eaj;
        fdVar.KID = HD.eak;
        fdVar.KIE = HD.eal;
        if (this.JWD != null) {
            fdVar.KIF = this.JWD.JVJ;
            fdVar.xuk = this.JWD.pkgName;
        }
        dth.MVy = this.dYz;
        ad.b bnX = com.tencent.mm.ui.transmit.c.bnX(this.mSessionId);
        if (bnX != null) {
            this.DIA = new aax();
            this.DIA.ehN.url = HD.url;
            this.DIA.ehN.ehO = bnX.getString("prePublishId", "");
            this.DIA.ehN.ehQ = bnX.getString("preUsername", "");
            this.DIA.ehN.ehR = bnX.getString("preChatName", "");
            this.DIA.ehN.ehS = bnX.getInt("preMsgIndex", 0);
            this.DIA.ehN.ehW = bnX.getInt("sendAppMsgScene", 0);
            this.DIA.ehN.ehX = bnX.getInt("getA8KeyScene", 0);
            this.DIA.ehN.ehY = bnX.getString("referUrl", null);
            this.DIA.ehN.ehZ = bnX.getString("adExtStr", null);
            this.DIA.ehN.ehT = this.dTX.field_talker;
            this.DIA.ehN.eia = HD.title;
            this.DIA.ehN.eic = HD.description;
            bg.aVF();
            as Kn = c.aSN().Kn(this.dTX.field_talker);
            if (Kn != null) {
                this.DIA.ehN.ehU = Kn.arI();
            }
            this.DIA.ehN.ehV = v.Ie(this.dTX.field_talker);
            String str = "";
            if (HD.ean != null) {
                eco eco = new eco();
                try {
                    eco.parseFrom(Base64.decode(HD.ean, 0));
                    if (eco.NcJ != null) {
                        str = eco.NcJ.xEN;
                    }
                } catch (Exception e2) {
                }
            }
            dth.MVw = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", this.DIA.ehN.ehO, this.DIA.ehN.ehQ, this.DIA.ehN.ehR, Integer.valueOf(ac.aJ(this.DIA.ehN.ehQ, this.DIA.ehN.ehR)), Integer.valueOf(this.DIA.ehN.ehX), str);
        }
        if (bnX != null && HD.type == 33) {
            this.JWE = new p();
            int i2 = bnX.getInt("fromScene", 1);
            this.JWE.dCt.scene = i2;
            this.JWE.dCt.cyo = bnX.getInt("appservicetype", 0);
            String string = bnX.getString("preChatName", "");
            if (2 == i2) {
                this.JWE.dCt.dCw = string + ":" + bnX.getString("preUsername", "");
            } else {
                this.JWE.dCt.dCw = string;
            }
            String str2 = this.dTX.field_talker;
            boolean z = bnX.getBoolean("moreRetrAction", false);
            if (str2.endsWith("@chatroom")) {
                this.JWE.dCt.action = z ? 5 : 2;
            } else {
                this.JWE.dCt.action = z ? 4 : 1;
            }
            this.JWE.dCt.dCv = HD.izz + 1;
            this.JWE.dCt.dCx = HD.izh;
            this.JWE.dCt.dCu = HD.izi;
            this.JWE.dCt.appId = HD.izj;
            this.JWE.dCt.appVersion = HD.izA;
            this.JWE.dCt.dCz = Util.nowSecond();
            this.JWE.dCt.dCA = 1;
            this.JWE.dCt.dCC = HD.izn;
        }
        Log.d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", HD.eaj, HD.eak, HD.eal);
        int i3 = 0;
        int i4 = 0;
        if (!Util.isNullOrNil(this.dTX.field_imgPath) && (imageOptions = BitmapUtil.getImageOptions(com.tencent.mm.av.q.bcR().Oz(this.dTX.field_imgPath))) != null) {
            i3 = imageOptions.outWidth;
            i4 = imageOptions.outHeight;
        }
        if (this.hmq.alL()) {
            Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", Integer.valueOf(this.hmq.field_filecrc), Boolean.valueOf(this.hmq.field_upload_by_safecdn), Integer.valueOf(this.hmq.field_UploadHitCacheType), this.hmq.field_aesKey);
            this.hmq.field_aesKey = "";
            dth.MVx = 1;
        }
        dth.LbL = this.hmq.field_filecrc;
        String str3 = null;
        if (this.JWJ) {
            str3 = "@cdn_" + this.hmq.field_fileId + "_" + this.hmq.field_aesKey + "_1";
        }
        fdVar.iAc = k.b.a(HD, str3, this.hmq, i3, i4);
        dth.MVu = fdVar;
        if (this.JWI != null && (HD.iwM != 0 || HD.iwI > 26214400)) {
            dth.keb = this.JWI.field_signature;
            dth.KKA = com.tencent.mm.i.a.gpO;
        }
        dth.Md5 = HD.filemd5;
        if (Util.isNullOrNil(this.hmq.field_filemd5)) {
            Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", HD.filemd5);
        } else {
            dth.Md5 = this.hmq.field_filemd5;
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(this.dTX.field_talker)) {
            dth.LbN = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(this.dTX.field_talker);
        }
        Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", dth.Md5, Integer.valueOf(dth.MVx), Util.secPrint(dth.keb), Integer.valueOf(dth.KKA), this.hmq, dth.MVw);
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(31058);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(31059);
        Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(this.msgId), this.dTX.field_content, ((dth) ((com.tencent.mm.ak.d) sVar).iLK.iLR).MVu.iAc);
        dti dti = (dti) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        if (dti != null && (i3 == 4 || (i3 == 0 && i4 == 0))) {
            ((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(dti.LbO);
        }
        if (i3 == 0 && i4 == 0) {
            Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn svrid[%d]. aeskey[%s], old content[%s]", Long.valueOf(dti.Brn), dti.LbJ, this.dTX.field_content);
            if (this.hmq != null && this.hmq.alL()) {
                if (!Util.isNullOrNil(dti.LbJ)) {
                    k.b HD = k.b.HD(this.dTX.field_content);
                    HD.aesKey = dti.LbJ;
                    this.dTX.setContent(k.b.a(HD, null, null));
                    Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", dti.LbJ, this.dTX.field_content);
                } else {
                    Log.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
                }
            }
            this.dTX.setStatus(2);
            this.dTX.yF(dti.Brn);
            bg.aVF();
            c.aSQ().a(this.dTX.field_msgId, this.dTX);
            ((f) com.tencent.mm.kernel.g.af(f.class)).HQ(this.dTX.field_msgId);
            b.jmd.b(this.dTX, com.tencent.mm.ag.l.t(this.dTX));
            this.callback.onSceneEnd(i3, i4, str, this);
            this.JWK.dq(i3, i4);
            if (this.DIA != null && !Util.isNullOrNil(this.DIA.ehN.url)) {
                this.DIA.ehN.ehP = "msg_" + Long.toString(dti.Brn);
                EventCenter.instance.publish(this.DIA);
            }
            if (this.JWE != null) {
                this.JWE.dCt.dCy = "msg_" + this.dTX.field_msgSvrId;
                EventCenter.instance.publish(this.JWE);
            }
            k.b HD2 = k.b.HD(this.dTX.field_content);
            if (HD2 != null && ab.Ix(this.dTX.field_talker)) {
                com.tencent.mm.ag.a aVar = (com.tencent.mm.ag.a) HD2.as(com.tencent.mm.ag.a.class);
                if (aVar != null && aVar.ivq) {
                    y.a(this.dTX, HD2);
                }
                if (aa.ame()) {
                    ((com.tencent.mm.chatroom.plugin.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(this.dTX);
                }
            }
            AppMethodBeat.o(31059);
        } else if (i3 == 4 && i4 == 102) {
            Log.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
            this.callback.onSceneEnd(i3, i4, str, this);
            this.JWK.dq(i3, i4);
            AppMethodBeat.o(31059);
        } else {
            this.dTX.setStatus(5);
            bg.aVF();
            c.aSQ().a(this.dTX.field_msgId, this.dTX);
            Log.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + i3 + "," + i4);
            this.callback.onSceneEnd(i3, i4, str, this);
            this.JWK.dq(i3, i4);
            AppMethodBeat.o(31059);
        }
    }
}
