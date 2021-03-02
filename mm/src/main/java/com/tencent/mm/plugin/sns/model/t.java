package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.aax;
import com.tencent.mm.g.a.aay;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.g.a.vz;
import com.tencent.mm.g.a.wa;
import com.tencent.mm.g.b.a.dz;
import com.tencent.mm.g.b.a.ht;
import com.tencent.mm.g.b.a.kb;
import com.tencent.mm.g.b.a.ke;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cmz;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.protocal.protobuf.cwz;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.eam;
import com.tencent.mm.protocal.protobuf.ean;
import com.tencent.mm.protocal.protobuf.eao;
import com.tencent.mm.protocal.protobuf.ear;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.ekv;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.protocal.protobuf.tt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ar;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class t extends q implements m {
    private aax DIA;
    private aay DIB;
    int DIC;
    private HashMap<Integer, Integer> DID = new HashMap<>();
    String DIE = "";
    HashMap<String, cnb> DIF = new HashMap<>();
    HashMap<String, Integer> DIG = new HashMap<>();
    private HashMap<Integer, Integer> DIH = new HashMap<>();
    String DII = "";
    private TimeLineObject DIx;
    private TimeLineObject DIy;
    private int DIz = 0;
    long Dyz = 0;
    public i callback;
    int ecf;
    boolean gyp = false;
    int hmp = 0;
    private IListener hms = new IListener<qz>() {
        /* class com.tencent.mm.plugin.sns.model.t.AnonymousClass2 */

        {
            AppMethodBeat.i(160648);
            this.__eventId = qz.class.getName().hashCode();
            AppMethodBeat.o(160648);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qz qzVar) {
            AppMethodBeat.i(95609);
            boolean a2 = a(qzVar);
            AppMethodBeat.o(95609);
            return a2;
        }

        private boolean a(qz qzVar) {
            String str;
            AppMethodBeat.i(95608);
            if (!t.this.DIG.containsKey(qzVar.dXz.filePath)) {
                Log.e("MicroMsg.NetSceneSnsPost", "recog succ, but not found %s", qzVar.dXz.filePath);
                AppMethodBeat.o(95608);
            } else {
                int intValue = t.this.DIG.remove(qzVar.dXz.filePath).intValue();
                try {
                    str = URLEncoder.encode(qzVar.dXz.result, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneSnsPost", e2, "", new Object[0]);
                    str = "";
                }
                cnb cnb = null;
                if (t.this.hmp != 0) {
                    cnb = t.this.DIF.get(qzVar.dXz.filePath);
                    t.this.DIE += String.format("position=%d&qrUrl=%s&md5=%s&imgUrl=%s&codeType=%d|", Integer.valueOf(intValue), str, cnb.MsM, cnb.Url, Integer.valueOf(qzVar.dXz.dFL));
                }
                if (t.this.DIC == 12) {
                    String concat = "2,3,,".concat(String.valueOf(str));
                    if (intValue == 0) {
                        try {
                            concat = concat + "," + URLEncoder.encode(t.this.DII, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                        } catch (UnsupportedEncodingException e3) {
                            Log.e("MicroMsg.NetSceneSnsPost", "", e3.getMessage());
                        }
                    }
                    Log.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", Integer.valueOf(intValue), concat);
                    h.INSTANCE.kvStat(13717, concat);
                }
                t.a(t.this);
                t.a(t.this, qzVar.dXz.filePath, qzVar.dXz.result, cnb != null ? cnb.MsG : "", t.a(t.this, intValue) == 1 ? 3 : 2);
                AppMethodBeat.o(95608);
            }
            return false;
        }
    };
    private IListener hmt = new IListener<qy>() {
        /* class com.tencent.mm.plugin.sns.model.t.AnonymousClass3 */

        {
            AppMethodBeat.i(160649);
            this.__eventId = qy.class.getName().hashCode();
            AppMethodBeat.o(160649);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qy qyVar) {
            AppMethodBeat.i(95611);
            boolean a2 = a(qyVar);
            AppMethodBeat.o(95611);
            return a2;
        }

        private boolean a(qy qyVar) {
            cnb cnb;
            int i2 = 2;
            AppMethodBeat.i(95610);
            if (!t.this.DIG.containsKey(qyVar.dXy.filePath)) {
                Log.e("MicroMsg.NetSceneSnsPost", "recog succ, but not found %s", qyVar.dXy.filePath);
                AppMethodBeat.o(95610);
            } else {
                Integer remove = t.this.DIG.remove(qyVar.dXy.filePath);
                if (remove == null) {
                    AppMethodBeat.o(95610);
                } else {
                    int intValue = remove.intValue();
                    if (t.this.DIC == 12) {
                        String str = "2,3,,";
                        if (intValue == 0) {
                            try {
                                str = str + "," + URLEncoder.encode(t.this.DII, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                            } catch (UnsupportedEncodingException e2) {
                                Log.e("MicroMsg.NetSceneSnsPost", "", e2.getMessage());
                            }
                        }
                        Log.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", Integer.valueOf(intValue), str);
                        h.INSTANCE.kvStat(13717, str);
                    }
                    t.a(t.this);
                    if (t.this.hmp != 0) {
                        cnb = t.this.DIF.get(qyVar.dXy.filePath);
                    } else {
                        cnb = null;
                    }
                    t tVar = t.this;
                    String str2 = qyVar.dXy.filePath;
                    String str3 = cnb != null ? cnb.MsG : "";
                    if (t.a(t.this, intValue) == 1) {
                        i2 = 3;
                    }
                    t.a(tVar, str2, null, str3, i2);
                    AppMethodBeat.o(95610);
                }
            }
            return false;
        }
    };
    private d rr;

    public t(String str, int i2, int i3, List<String> list, TimeLineObject timeLineObject, int i4, String str2, int i5, LinkedList<Long> linkedList, int i6, cnc cnc, boolean z, LinkedList<dqi> linkedList2, eam eam, b bVar, String str3, int i7, String str4) {
        int length;
        AppMethodBeat.i(95612);
        this.DIx = timeLineObject;
        this.ecf = i4;
        this.DIC = i6;
        d.a aVar = new d.a();
        aVar.iLN = new ean();
        aVar.iLO = new eao();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnspost";
        aVar.funcId = 209;
        aVar.iLP = 97;
        aVar.respCmdId = 1000000097;
        this.rr = aVar.aXF();
        ean ean = (ean) this.rr.iLK.iLR;
        if (!TextUtils.isEmpty(timeLineObject.actionInfo.KEw.KEr)) {
            tt ttVar = new tt();
            ttVar.Lcd = timeLineObject.actionInfo.KEw.KEr;
            ean.MZX = ttVar;
        }
        ad.b JW = ad.aVe().JW(cnc.sessionId);
        if (JW != null) {
            this.DIA = new aax();
            this.DIA.ehN.ehO = JW.getString("prePublishId", "");
            this.DIA.ehN.url = JW.getString("url", "");
            this.DIA.ehN.ehQ = JW.getString("preUsername", "");
            this.DIA.ehN.ehR = JW.getString("preChatName", "");
            this.DIA.ehN.ehS = JW.getInt("preMsgIndex", 0);
            this.DIA.ehN.ehW = JW.getInt("sendAppMsgScene", 0);
            this.DIA.ehN.ehX = JW.getInt("getA8KeyScene", 0);
            this.DIA.ehN.ehY = JW.getString("referUrl", null);
            this.DIA.ehN.ehZ = JW.getString("adExtStr", null);
            this.DIA.ehN.eia = str3;
            if (JW.containsKey("_tmpl_webview_transfer_scene")) {
                this.DIB = new aay();
                this.DIB.eid.eie = JW.getInt("_tmpl_webview_transfer_scene", -1);
            }
            String str5 = "";
            if (timeLineObject.statExtStr != null) {
                eco eco = new eco();
                try {
                    eco.parseFrom(Base64.decode(timeLineObject.statExtStr, 0));
                    if (eco.NcJ != null) {
                        str5 = eco.NcJ.xEN;
                    }
                } catch (Exception e2) {
                }
            }
            if (Util.isNullOrNil(str5) && timeLineObject.AppInfo != null) {
                str5 = timeLineObject.AppInfo.Id;
            }
            ean.MZW = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", this.DIA.ehN.ehO, this.DIA.ehN.ehQ, this.DIA.ehN.ehR, Integer.valueOf(ac.aJ(this.DIA.ehN.ehQ, this.DIA.ehN.ehR)), Integer.valueOf(this.DIA.ehN.ehX), str5);
        }
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(str.getBytes());
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(str.length());
        objArr[1] = Integer.valueOf(sKBuiltinBuffer_t.getILen());
        if (bVar == null) {
            length = 0;
        } else {
            length = bVar.zy.length;
        }
        objArr[2] = Integer.valueOf(length);
        Log.i("MicroMsg.NetSceneSnsPost", "len:%d   skb:%d ctx.len:%d", objArr);
        ean.ObjectDesc = sKBuiltinBuffer_t;
        ean.MZR = i2;
        ean.MsV = i3;
        ean.izX = str2;
        this.DIz = i2;
        if (com.tencent.mm.platformtools.ac.jOd) {
            ean.ObjectDesc = new SKBuiltinBuffer_t();
            Log.e("MicroMsg.NetSceneSnsPost", "post error setObjectDesc is null!");
        }
        LinkedList<dqi> linkedList3 = new LinkedList<>();
        if (list != null && list.size() > 0) {
            String str6 = "";
            for (String str7 : list) {
                dqi dqi = new dqi();
                dqi.bhy(str7);
                linkedList3.add(dqi);
                str6 = str6 + "; + " + str7;
            }
            Log.d("MicroMsg.NetSceneSnsPost", "post with list : ".concat(String.valueOf(str6)));
        }
        ean.WithUserList = linkedList3;
        ean.WithUserListCount = linkedList3.size();
        ean.MZS = i5;
        Object[] objArr2 = new Object[6];
        objArr2[0] = Integer.valueOf(i6);
        objArr2[1] = str2;
        objArr2[2] = ean.MZW;
        objArr2[3] = Integer.valueOf(cnc.Mtm != null ? cnc.Mtm.MZf : 0);
        objArr2[4] = Integer.valueOf(i7);
        objArr2[5] = str4;
        Log.i("MicroMsg.NetSceneSnsPost", "setObjectSource: %d, clientid:%s fromScene:%s, score:%d, sdkTokenValid:%s, sdkPkgName:%s", objArr2);
        if (linkedList2 != null && linkedList2.size() > 0) {
            if (z) {
                ean.BlackList = linkedList2;
                ean.BlackListCount = linkedList2.size();
            } else {
                ean.GroupUser = linkedList2;
                ean.GroupUserCount = linkedList2.size();
            }
        }
        Log.d("MicroMsg.NetSceneSnsPost", "setObjectSource ".concat(String.valueOf(i6)));
        ean.MZT = i6;
        ekv ekv = new ekv();
        if (!Util.isNullOrNil(cnc.token)) {
            ekv.Nke = cnc.token;
            ekv.Nkf = cnc.Mte;
            ean.MID = ekv;
        }
        if (linkedList != null && !linkedList.isEmpty()) {
            ean.GroupCount = linkedList.size();
            Iterator<Long> it = linkedList.iterator();
            while (it.hasNext()) {
                dzw dzw = new dzw();
                dzw.MZv = it.next().longValue();
                ean.Mtb.add(dzw);
            }
            Log.d("MicroMsg.NetSceneSnsPost", "tagid " + linkedList.size() + " " + ean.Mtb.toString());
        }
        ean.Mtg = eam;
        if (!Util.isNullOrNil(cnc.Mti)) {
            ean.SnsRedEnvelops = new ear();
        }
        if (eam != null) {
            Log.d("MicroMsg.NetSceneSnsPost", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", eam.KIC, eam.KID, eam.KIE);
        }
        if (bVar != null) {
            ean.MZV = new SKBuiltinBuffer_t().setBuffer(bVar);
        }
        ean.Naa = cnc.Mtm;
        SnsInfo Zr = aj.faO().Zr(this.ecf);
        if (Zr != null && ((Zr.getTypeFlag() == 1 || Zr.getTypeFlag() == 15) && timeLineObject.ContentObj != null && timeLineObject.ContentObj.LoV != null && timeLineObject.ContentObj.LoV.size() > 0 && cnc.MsW != null && cnc.MsW.size() == timeLineObject.ContentObj.LoV.size())) {
            String accSnsPath = aj.getAccSnsPath();
            int i8 = 0;
            Iterator<cnb> it2 = timeLineObject.ContentObj.LoV.iterator();
            while (it2.hasNext()) {
                cnb next = it2.next();
                if (next.oUv == 2 || next.oUv == 6) {
                    cmz cmz = new cmz();
                    cmz.xuT = next.oUv == 2 ? 2 : 1;
                    if (next.oUv == 6) {
                        a aNx = e.aNx(ar.ki(accSnsPath, next.Id) + r.p(next));
                        if (aNx != null) {
                            cmz.Msw = (int) Math.round(((double) aNx.videoDuration) / 1000.0d);
                        }
                    }
                    com.tencent.mm.plugin.sns.storage.q JK = aj.faD().JK((long) cnc.MsW.get(i8).Mpj);
                    try {
                        cne cne = (cne) new cne().parseFrom(JK.EmR);
                        cmz.xub = cne.Mty;
                        this.DID.put(Integer.valueOf(JK.localid), Integer.valueOf(cne.Mty));
                    } catch (Exception e3) {
                    }
                    cmz.SessionId = cnc.sessionId;
                    Log.i("MicroMsg.NetSceneSnsPost", "post add mediaInfo, Source: %s, videoPlayLength: %s, MediaType: %s, SessionId: %s", Integer.valueOf(cmz.xub), Integer.valueOf(cmz.Msw), Integer.valueOf(cmz.xuT), cmz.SessionId);
                    ean.MZZ.add(cmz);
                }
                i8++;
            }
            ean.MZY = ean.MZZ.size();
            Log.i("MicroMsg.NetSceneSnsPost", "post mediaCount: %s", Integer.valueOf(ean.MZY));
        }
        if (com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIO("ie_sns_upload")) {
            com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIN("ie_sns_upload");
        }
        try {
            ewf ewf = new ewf();
            ewf.NtO = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIP("ie_sns_upload"));
            Object[] objArr3 = new Object[1];
            objArr3[0] = Integer.valueOf(ewf.NtO != null ? ewf.NtO.getILen() : -1);
            Log.d("MicroMsg.NetSceneSnsPost", "[debug] wcstf set on snspost, len: %s", objArr3);
            ewf.NtP = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIS("ce_sns_upload"));
            Object[] objArr4 = new Object[1];
            objArr4[0] = Integer.valueOf(ewf.NtP != null ? ewf.NtP.getILen() : -1);
            Log.d("MicroMsg.NetSceneSnsPost", "[debug] wcste set on snspost, len: %s", objArr4);
            ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.exJ());
            Object[] objArr5 = new Object[1];
            objArr5[0] = Integer.valueOf(ewf.NtQ != null ? ewf.NtQ.getILen() : -1);
            Log.d("MicroMsg.NetSceneSnsPost", "[debug] ccData set on snspost, len: %s", objArr5);
            ean.KLQ = new SKBuiltinBuffer_t().setBuffer(ewf.toByteArray());
        } catch (Throwable th) {
        }
        if (!(cnc == null || cnc.Mth == null)) {
            int i9 = 0;
            Iterator<eas> it3 = cnc.Mth.iterator();
            while (it3.hasNext()) {
                this.DIH.put(Integer.valueOf(i9), Integer.valueOf(it3.next().Nam));
                i9++;
            }
        }
        cwz cwz = new cwz();
        cwz.KIF = i7;
        cwz.xuk = str4;
        ean.Nab = cwz;
        AppMethodBeat.o(95612);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(95613);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95613);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        SnsInfo snsInfo;
        String str2;
        int i5;
        cnb cnb;
        AppMethodBeat.i(95614);
        Log.i("MicroMsg.NetSceneSnsPost", "post netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        eao eao = (eao) ((d) sVar).iLL.iLR;
        if (i3 == 4) {
            SnsInfo Zr = aj.faO().Zr(this.ecf);
            try {
                cnc cnc = (cnc) new cnc().parseFrom(Zr.field_postBuf);
                cnc.Mtd = i4;
                cnc.Mtk = eao.Mtk;
                cnc.Mtl = false;
                Zr.setPostBuf(cnc.toByteArray());
            } catch (Exception e2) {
            }
            if (Zr != null) {
                Zr.setItemDie();
                aj.faO().d(this.ecf, Zr);
                aj.faN().Yv(this.ecf);
                Log.d("MicroMsg.NetSceneSnsPost", "onErrorServer, publish SnsPostFailEvent, snsInfoLocalId: " + Zr.getLocalid());
                vy vyVar = new vy();
                vyVar.ecb.ecc = (long) this.ecf;
                EventCenter.instance.publish(vyVar);
            }
            if (!(this.DIx == null || this.DIx.ContentObj == null || this.DIx.ContentObj.LoU != 21)) {
                com.tencent.mm.plugin.sns.lucky.a.b.pl(8);
                switch (i4) {
                    case -1:
                        com.tencent.mm.plugin.sns.lucky.a.b.pl(19);
                        break;
                    case 201:
                        com.tencent.mm.plugin.sns.lucky.a.b.pl(17);
                        break;
                    case 211:
                        com.tencent.mm.plugin.sns.lucky.a.b.pl(18);
                        break;
                    default:
                        com.tencent.mm.plugin.sns.lucky.a.b.pl(20);
                        break;
                }
            }
            if (com.tencent.mm.plugin.sns.k.e.DUQ.DVD == this.ecf) {
                com.tencent.mm.plugin.sns.k.e.DUQ.DVE.esJ = 1;
                com.tencent.mm.plugin.sns.k.e.DUQ.fcF();
                com.tencent.mm.plugin.sns.k.e.DUQ.DVD = 0;
            }
            if (com.tencent.mm.plugin.sns.k.e.DUQ.DVF == this.ecf) {
                com.tencent.mm.plugin.sns.k.e.DUQ.DVG.esJ = 1;
                com.tencent.mm.plugin.sns.k.e.DUQ.fcG();
                com.tencent.mm.plugin.sns.k.e.DUQ.DVF = 0;
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(95614);
        } else if (i4 != 0) {
            aj.faN().Yv(this.ecf);
            if (!(this.DIx == null || this.DIx.ContentObj == null || this.DIx.ContentObj.LoU != 21)) {
                com.tencent.mm.plugin.sns.lucky.a.b.pl(8);
                com.tencent.mm.plugin.sns.lucky.a.b.pl(16);
            }
            if (com.tencent.mm.plugin.sns.k.e.DUQ.DVD == this.ecf) {
                com.tencent.mm.plugin.sns.k.e.DUQ.DVE.esJ = 1;
                com.tencent.mm.plugin.sns.k.e.DUQ.fcF();
                com.tencent.mm.plugin.sns.k.e.DUQ.DVD = 0;
            }
            if (com.tencent.mm.plugin.sns.k.e.DUQ.DVF == this.ecf) {
                com.tencent.mm.plugin.sns.k.e.DUQ.DVG.esJ = 1;
                com.tencent.mm.plugin.sns.k.e.DUQ.fcG();
                com.tencent.mm.plugin.sns.k.e.DUQ.DVF = 0;
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(95614);
        } else if (eao.MYH == null || eao.MYH.ObjectDesc == null || eao.MYH.ObjectDesc.getBuffer() == null) {
            Log.e("MicroMsg.NetSceneSnsPost", "err respone buffer is null ignore");
            aj.faN().Yv(this.ecf);
            SnsInfo Zr2 = aj.faO().Zr(this.ecf);
            if (Zr2 != null) {
                Zr2.clearItemDie();
                aj.faO().d(this.ecf, Zr2);
                wa waVar = new wa();
                waVar.ech.ecc = (long) this.ecf;
                EventCenter.instance.publish(waVar);
            }
            if (com.tencent.mm.plugin.sns.k.e.DUQ.DVD == this.ecf) {
                com.tencent.mm.plugin.sns.k.e.DUQ.DVE.esJ = 1;
                com.tencent.mm.plugin.sns.k.e.DUQ.fcF();
                com.tencent.mm.plugin.sns.k.e.DUQ.DVD = 0;
            }
            if (com.tencent.mm.plugin.sns.k.e.DUQ.DVF == this.ecf) {
                com.tencent.mm.plugin.sns.k.e.DUQ.DVG.esJ = 1;
                com.tencent.mm.plugin.sns.k.e.DUQ.fcG();
                com.tencent.mm.plugin.sns.k.e.DUQ.DVF = 0;
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(95614);
        } else {
            String str3 = new String(eao.MYH.ObjectDesc.getBuffer().toByteArray());
            if (this.DIz == 0) {
                Log.d("MicroMsg.NetSceneSnsPost", "resp " + str3 + "  ");
            }
            this.DIy = n.PM(str3);
            if (this.DIy.streamvideo != null) {
                String str4 = this.DIy.Id;
                String str5 = this.DIy.streamvideo.izg;
                String str6 = this.DIy.streamvideo.izf;
                com.tencent.mm.modelsns.m mVar = new com.tencent.mm.modelsns.m();
                mVar.n("20CurrPublishId", str4 + ",");
                mVar.n("20SourcePublishId", str5 + ",");
                mVar.n("20SourceAdUxInfo", str6 + ",");
                Log.i("MicroMsg.SnsVideoStatistic", "report snsad_shareReport: " + mVar.abW());
                h.INSTANCE.a(13004, mVar);
            }
            SnsInfo Zr3 = aj.faO().Zr(this.ecf);
            if (Zr3 == null) {
                Log.e("MicroMsg.NetSceneSnsPost", "the item has delete");
                snsInfo = new SnsInfo();
            } else {
                snsInfo = Zr3;
            }
            snsInfo.setCreateTime(eao.MYH.CreateTime);
            snsInfo.setContent(str3);
            snsInfo.setPostFinish();
            snsInfo.setSnsId(eao.MYH.Id);
            snsInfo.setStringSeq(eao.MYH.Id);
            if ((eao.MYH.ExtFlag & 1) > 0) {
                snsInfo.setExtFlag();
            }
            this.Dyz = eao.MYH.Id;
            if (this.DIA != null) {
                this.DIA.ehN.ehP = "sns_" + r.Jb(this.Dyz);
                EventCenter.instance.publish(this.DIA);
            }
            if (!(this.DIB == null || this.DIB.eid.eie == -1)) {
                EventCenter.instance.publish(this.DIB);
            }
            SnsObject snsObject = eao.MYH;
            snsObject.ObjectDesc.setBuffer(new byte[0]);
            try {
                if (snsObject.CommentUserListCount == 0 && snsObject.LikeUserListCount == 0 && snsObject.WithUserListCount == 0 && snsObject.GroupCount == 0) {
                    Log.d("MicroMsg.NetSceneSnsPost", "no use! this buf");
                } else {
                    snsInfo.setAttrBuf(snsObject.toByteArray());
                }
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.NetSceneSnsPost", e3, "", new Object[0]);
            }
            snsInfo.clearItemDie();
            aj.faO().delete(this.Dyz);
            aj.faO().d(this.ecf, snsInfo);
            aj.faN().Yv(this.ecf);
            if (((this.DIx.ContentObj.LoU == 1 && this.DIx.showFlag == 0 && this.DIy.showFlag == 1) || (this.DIx.ContentObj.LoU == 15 && this.DIx.sightFolded == 0 && this.DIy.sightFolded == 1)) && com.tencent.mm.plugin.sns.storage.g.JG(y.aOa(snsInfo.getSnsId()))) {
                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.model.t.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(95607);
                        v.fai();
                        AppMethodBeat.o(95607);
                    }
                });
            }
            k dR = com.tencent.mm.plugin.sns.k.g.DVR.dR(Integer.valueOf(this.ecf));
            if (!(dR == null || this.DIy == null)) {
                dR.bfH();
                dR.bfI();
                dR.PJ(this.DIy.Id);
                dR.tR(this.DIy.ContentObj.LoU);
                dR.bfK();
            }
            k dR2 = com.tencent.mm.plugin.sns.k.h.DVR.dR(Integer.valueOf(this.ecf));
            if (!(dR2 == null || this.DIy == null)) {
                dR2.bfH();
                dR2.bfI();
                dR2.PJ(this.DIy.Id);
                dR2.tR(this.DIy.ContentObj.LoU);
                dR2.bfK();
            }
            wa waVar2 = new wa();
            waVar2.ech.ecc = (long) this.ecf;
            EventCenter.instance.publish(waVar2);
            if (snsInfo.getTypeFlag() == 21) {
                snsInfo.getPravited();
                com.tencent.mm.plugin.sns.lucky.a.b.pl(7);
                System.currentTimeMillis();
            }
            a(this.DIx, this.DIy);
            if (this.DIy == null) {
                str2 = "";
            } else {
                str2 = this.DIy.ContentDesc;
            }
            aPc(str2);
            if (aj.faK() != null) {
                aj.faK().eZn();
            }
            try {
                if (snsInfo.getTypeFlag() == 15 && (i5 = ((cnc) new cnc().parseFrom(snsInfo.getPostBuf())).MsW.getFirst().Mpj) > 0 && (cnb = this.DIy.ContentObj.LoV.get(0)) != null) {
                    String str7 = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.j(cnb);
                    com.tencent.mm.modelvideo.n bhh = com.tencent.mm.modelvideo.n.bhh();
                    String str8 = cnb.Url;
                    long j2 = snsObject.Id;
                    if (!Util.isNullOrNil(str8) && !Util.isNullOrNil(str7)) {
                        String valueOf = String.valueOf(i5);
                        Log.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", valueOf, str8, Long.valueOf(j2), str7);
                        n.a aVar = bhh.jrv.get(valueOf);
                        if (aVar != null) {
                            aVar.jrM = String.valueOf(j2);
                            aVar.jrL = str7;
                            aVar.dRP = str8;
                            bhh.a(aVar.jaC, valueOf, "", j2);
                        }
                    }
                }
            } catch (Exception e4) {
            }
            long j3 = snsObject.Id;
            vz vzVar = new vz();
            vzVar.ecd.ece = j3;
            vzVar.ecd.ecf = this.ecf;
            vzVar.ecd.ecg = this.DID;
            EventCenter.instance.publish(vzVar);
            long j4 = snsObject.Id;
            String str9 = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_SNS_POST_BIZ_ID_STRING, "");
            if (!Util.isNullOrNil(str9)) {
                ((c) com.tencent.mm.kernel.g.af(c.class)).aa("snspublicid", r.Jb(j4), str9);
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_SNS_POST_BIZ_ID_STRING, "");
            }
            kb kbVar = com.tencent.mm.plugin.sns.k.e.DUQ.DVa;
            kbVar.eTz = kbVar.x("Published", r.Jb(eao.MYH.Id), true);
            com.tencent.mm.plugin.sns.k.e.DUQ.fcw();
            if (com.tencent.mm.plugin.sns.k.e.DUQ.DVA.eUb == 1) {
                ke keVar = com.tencent.mm.plugin.sns.k.e.DUQ.DVA;
                keVar.eUd = keVar.x("NextPublishId", r.Jc(snsObject.Id), true);
                com.tencent.mm.plugin.sns.k.e.DUQ.fcE();
            }
            if (com.tencent.mm.plugin.sns.k.e.DUQ.DVC == this.ecf) {
                com.tencent.mm.plugin.sns.k.e eVar = com.tencent.mm.plugin.sns.k.e.DUQ;
                com.tencent.mm.plugin.sns.k.e.a(9, "", 0, 0, cl.aWz(), snsObject.Id, com.tencent.mm.plugin.sns.k.e.DUQ.Aqq, 0);
                com.tencent.mm.plugin.sns.k.e.DUQ.DVC = 0;
            }
            if (com.tencent.mm.plugin.sns.k.e.DUQ.DVD == this.ecf) {
                com.tencent.mm.plugin.sns.k.e.DUQ.DVE.esJ = 2;
                dz dzVar = com.tencent.mm.plugin.sns.k.e.DUQ.DVE;
                dzVar.epf = dzVar.x("Publishid", r.Jc(snsInfo.field_snsId), true);
                com.tencent.mm.plugin.sns.k.e.DUQ.fcF();
                com.tencent.mm.plugin.sns.k.e.DUQ.DVD = 0;
            }
            if (com.tencent.mm.plugin.sns.k.e.DUQ.DVF == this.ecf) {
                com.tencent.mm.plugin.sns.k.e.DUQ.DVG.esJ = 2;
                ht htVar = com.tencent.mm.plugin.sns.k.e.DUQ.DVG;
                htVar.epf = htVar.x("Publishid", r.Jc(snsInfo.field_snsId), true);
                com.tencent.mm.plugin.sns.k.e.DUQ.fcG();
                com.tencent.mm.plugin.sns.k.e.DUQ.DVF = 0;
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(95614);
        }
    }

    private void aPc(String str) {
        AppMethodBeat.i(95615);
        this.DII = str;
        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100132");
        if (Fu.isValid()) {
            this.hmp = Util.getInt(Fu.gzz().get("needUploadData"), 1);
        }
        if (this.DIC == 12 || this.hmp != 0) {
            if (!(this.DIy == null || this.DIy.ContentObj == null || this.DIy.ContentObj.LoV == null || this.DIy.ContentObj.LoV.size() <= 0)) {
                LinkedList<cnb> linkedList = this.DIy.ContentObj.LoV;
                EventCenter.instance.addListener(this.hms);
                EventCenter.instance.addListener(this.hmt);
                Iterator<cnb> it = linkedList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    cnb next = it.next();
                    if (next.oUv == 2) {
                        String D = g.D(next);
                        if (!Util.isNullOrNil(D)) {
                            this.DIG.put(D, Integer.valueOf(i2));
                            this.DIF.put(D, next);
                            int i3 = i2 + 1;
                            qx qxVar = new qx();
                            qxVar.dXu.dDZ = System.nanoTime();
                            qxVar.dXu.filePath = D;
                            EventCenter.instance.publish(qxVar);
                            i2 = i3;
                        }
                    }
                }
            }
            AppMethodBeat.o(95615);
            return;
        }
        AppMethodBeat.o(95615);
    }

    private static boolean a(TimeLineObject timeLineObject, TimeLineObject timeLineObject2) {
        AppMethodBeat.i(95616);
        if (timeLineObject == null || timeLineObject2 == null || timeLineObject.ContentObj == null || timeLineObject2.ContentObj == null) {
            AppMethodBeat.o(95616);
            return false;
        }
        String accSnsPath = aj.getAccSnsPath();
        int i2 = 0;
        while (i2 < timeLineObject.ContentObj.LoV.size() && i2 < timeLineObject2.ContentObj.LoV.size()) {
            cnb cnb = timeLineObject.ContentObj.LoV.get(i2);
            cnb cnb2 = timeLineObject2.ContentObj.LoV.get(i2);
            String m = r.m(cnb);
            String n = r.n(cnb);
            String o = r.o(cnb);
            String p = r.p(cnb);
            String l = r.l(cnb2);
            String e2 = r.e(cnb2);
            String f2 = r.f(cnb2);
            String j2 = r.j(cnb2);
            Log.d("MicroMsg.NetSceneSnsPost", "updateMediaFileName " + m + "  - " + l);
            String ki = ar.ki(accSnsPath, cnb.Id);
            String ki2 = ar.ki(accSnsPath, cnb2.Id);
            com.tencent.mm.vfs.s.boN(ki2);
            com.tencent.mm.vfs.s.nx(ki + m, ki2 + l);
            com.tencent.mm.vfs.s.nx(ki + n, ki2 + e2);
            com.tencent.mm.vfs.s.nx(ki + o, ki2 + f2);
            if (com.tencent.mm.vfs.s.YS(ki + p)) {
                Log.i("MicroMsg.NetSceneSnsPost", "post done copy file %s", ki2 + j2);
                com.tencent.mm.vfs.s.nx(ki + p, ki2 + j2);
            }
            i2++;
        }
        AppMethodBeat.o(95616);
        return true;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 209;
    }

    static /* synthetic */ void a(t tVar) {
        AppMethodBeat.i(95617);
        if (tVar.DIG.isEmpty()) {
            EventCenter.instance.removeListener(tVar.hms);
            EventCenter.instance.removeListener(tVar.hmt);
            if (tVar.hmp != 0 && !Util.isNullOrNil(tVar.DIE)) {
                String str = tVar.DIy.AppInfo == null ? "" : tVar.DIy.AppInfo.Id;
                int size = tVar.DIy.ContentObj.LoV.size();
                Log.i("MicroMsg.NetSceneSnsPost", "report qrCodeImgSns(13627), snsId:%s, size:%d, info:%s, appId:%s", tVar.DIy.Id, Integer.valueOf(size), tVar.DIE, str);
                o.O(13627, String.format(Locale.US, "%s,%d,%s,%s", tVar.DIy.Id, Integer.valueOf(size), tVar.DIE, str));
            }
        }
        AppMethodBeat.o(95617);
    }

    static /* synthetic */ int a(t tVar, int i2) {
        AppMethodBeat.i(202726);
        Integer num = tVar.DIH.get(Integer.valueOf(i2));
        if (num == null) {
            AppMethodBeat.o(202726);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(202726);
        return intValue;
    }

    static /* synthetic */ void a(t tVar, String str, String str2, String str3, int i2) {
        AppMethodBeat.i(202727);
        com.tencent.mm.plugin.multimediareport.d dVar = new com.tencent.mm.plugin.multimediareport.d();
        dVar.zGI = tVar.Dyz;
        dVar.zGJ = 1;
        dVar.source = i2;
        dVar.zGL = tVar.DIF.get(str).Url;
        dVar.md5 = str3;
        SnsObject snsObject = ((eao) tVar.rr.iLL.iLR).MYH;
        if (snsObject != null) {
            dVar.createtime = (long) snsObject.CreateTime;
        }
        dVar.zGN = 0;
        dVar.zGO = 0;
        dVar.qwo = str2;
        SnsInfo Zr = aj.faO().Zr(tVar.ecf);
        if (Zr != null) {
            com.tencent.mm.plugin.multimediareport.g.a(dVar, 3, (long) Zr.getCreateTime(), str);
            AppMethodBeat.o(202727);
            return;
        }
        Log.e("MicroMsg.NetSceneSnsPost", "report error");
        AppMethodBeat.o(202727);
    }
}
