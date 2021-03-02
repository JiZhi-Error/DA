package com.tencent.mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.b;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.aax;
import com.tencent.mm.g.a.aay;
import com.tencent.mm.g.a.p;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.m.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.ah;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dth;
import com.tencent.mm.protocal.protobuf.dti;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.fd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.smtt.sdk.TbsListener;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class ag extends q implements m {
    private aax DIA;
    aay DIB;
    a JWD;
    private p JWE;
    long JWF;
    i callback;
    ca dTX;
    int dYz;
    String iYT;
    private g.a iZc;
    String mSessionId;
    private String mSignature;
    long msgId;
    private d rr;
    long startTime;

    public ag(long j2, String str, String str2) {
        AppMethodBeat.i(31053);
        this.dTX = null;
        this.msgId = 0;
        this.dYz = 0;
        this.startTime = 0;
        this.iYT = "";
        this.JWF = 0;
        this.iZc = new g.a() {
            /* class com.tencent.mm.pluginsdk.model.app.ag.AnonymousClass1 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, c cVar, final com.tencent.mm.i.d dVar, boolean z) {
                AppMethodBeat.i(31052);
                Log.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ag.this.iYT, Integer.valueOf(i2), cVar, dVar);
                if (i2 == -21005) {
                    Log.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", ag.this.iYT);
                    AppMethodBeat.o(31052);
                    return 0;
                } else if (i2 != 0) {
                    ag.this.dTX.setStatus(5);
                    e.INSTANCE.idkeyStat(111, 34, 1, true);
                    bg.aVF();
                    com.tencent.mm.model.c.aSQ().a(ag.this.dTX.field_msgId, ag.this.dTX);
                    new y(a.t(Integer.valueOf(i2), 1, Long.valueOf(ag.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), 0, "")).bfK();
                    ag.this.callback.onSceneEnd(3, i2, "", ag.this);
                    AppMethodBeat.o(31052);
                    return 0;
                } else {
                    if (dVar != null) {
                        if (dVar.field_retCode != 0) {
                            Log.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", Integer.valueOf(dVar.field_retCode), dVar.field_arg, dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk);
                            ag.this.dTX.setStatus(5);
                            e.INSTANCE.idkeyStat(111, 34, 1, true);
                            bg.aVF();
                            com.tencent.mm.model.c.aSQ().a(ag.this.dTX.field_msgId, ag.this.dTX);
                            String t = a.t(Integer.valueOf(dVar.field_retCode), 1, Long.valueOf(ag.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk);
                            new y(t).bfK();
                            new w(t).bfK();
                            ag.this.callback.onSceneEnd(3, dVar.field_retCode, "", ag.this);
                        } else {
                            if (ag.this.JWF > 0 && dVar.field_fileLength > 0 && ag.this.dTX.getType() != 738197553) {
                                MMUncaughtExceptionHandler.assertTrue("SendAppMsgThumbTooBig", ag.this.JWF + "," + dVar.field_fileLength + "," + dVar.field_fileId, ag.this.JWF * 2 > dVar.field_fileLength);
                            }
                            Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", Integer.valueOf(dVar.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(dVar.field_exist_whencheck), Util.secPrint(dVar.field_aesKey), dVar.field_filemd5);
                            if (ag.this.dTX.getType() == 738197553) {
                                m.a(ag.this.dTX.field_msgId, "", dVar, false);
                            }
                            bg.azz().a(new ah(ag.this.msgId, dVar, new ah.a() {
                                /* class com.tencent.mm.pluginsdk.model.app.ag.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.pluginsdk.model.app.ah.a
                                public final void dq(int i2, int i3) {
                                    AppMethodBeat.i(31051);
                                    Log.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", Integer.valueOf(i2), Integer.valueOf(i3));
                                    new y(a.t(Integer.valueOf(i3), 1, Long.valueOf(ag.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                                    ag.this.callback.onSceneEnd(i2, i3, "", ag.this);
                                    AppMethodBeat.o(31051);
                                }
                            }, ag.this.mSessionId, ag.this.dYz, ag.this.JWD), 0);
                        }
                    }
                    if (!(str == null || !str.equals(ag.this.iYT) || ag.this.DIB == null || ag.this.DIB.eid.eie == -1)) {
                        EventCenter.instance.publish(ag.this.DIB);
                        ag.this.DIB = null;
                    }
                    AppMethodBeat.o(31052);
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
        this.msgId = j2;
        this.mSessionId = str;
        this.mSignature = str2;
        d.a aVar = new d.a();
        aVar.iLN = new dth();
        aVar.iLO = new dti();
        aVar.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar.funcId = TbsListener.ErrorCode.UNLZMA_FAIURE;
        aVar.iLP = 107;
        aVar.respCmdId = 1000000107;
        this.rr = aVar.aXF();
        Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", Long.valueOf(j2), str, Util.secPrint(str2), Util.getStack());
        AppMethodBeat.o(31053);
    }

    public ag(long j2, String str, int i2, a aVar) {
        this(j2, str, null);
        AppMethodBeat.i(31054);
        this.dYz = i2;
        this.JWD = aVar;
        Log.i("MicroMsg.NetSceneSendAppMsg", "NetSceneSendAppMsg directShare[%d]", Integer.valueOf(i2));
        if (this.JWD != null) {
            Log.i("MicroMsg.NetSceneSendAppMsg", "NetSceneSendAppMsg tokenValid[%d], pkgName[%s]", Integer.valueOf(this.JWD.JVJ), this.JWD.pkgName);
        }
        AppMethodBeat.o(31054);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        k.b bVar;
        String str;
        boolean z;
        AppMethodBeat.i(31055);
        this.callback = iVar;
        if (this.startTime == 0) {
            this.startTime = Util.nowMilliSecond();
        }
        bg.aVF();
        this.dTX = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
        if (this.dTX == null || this.dTX.field_msgId != this.msgId) {
            AppMethodBeat.o(31055);
            return -1;
        }
        k.b HD = k.b.HD(this.dTX.field_content);
        if (HD == null) {
            be bkr = be.bkr(this.dTX.field_content);
            if (Util.isNullOrNil(bkr.Oph)) {
                k.b bVar2 = new k.b();
                bVar2.iwK = bkr.md5;
                bVar2.type = 8;
                Log.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
                bVar = bVar2;
            } else {
                bVar = k.b.HD(bkr.Oph);
            }
        } else {
            bVar = HD;
        }
        Assert.assertTrue("content != null [[" + this.dTX.field_content + "]]", bVar != null);
        if (bVar == null) {
            this.dTX = null;
            AppMethodBeat.o(31055);
            return -1;
        }
        String str2 = "";
        if (this.dTX.cWK()) {
            s QN = u.QN(this.dTX.field_imgPath);
            if (QN != null) {
                str2 = QN.jsw.ize;
            }
            str = str2;
        } else if (!Util.isNullOrNil(this.dTX.field_imgPath)) {
            str = com.tencent.mm.av.q.bcR().Oz(this.dTX.field_imgPath);
        } else {
            str = str2;
        }
        if (bVar.type == 8 || bVar.type == 9) {
            Log.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", Integer.valueOf(bVar.type));
            z = false;
        } else if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", Integer.valueOf(bVar.type));
            z = false;
        } else {
            this.JWF = (long) ((int) com.tencent.mm.vfs.s.boW(str));
            boolean z2 = bVar.type == 33 || bVar.type == 36 || bVar.type == 46 || bVar.type == 44 || bVar.type == 48;
            if (z2 || this.JWF < 262144) {
                Log.i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", Integer.valueOf(bVar.type), str, Long.valueOf(this.JWF));
                if (!Util.isNullOrNil(bVar.dCK)) {
                    Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", Long.valueOf(this.msgId));
                    z = false;
                } else {
                    if (!z2) {
                        f.baQ();
                        if (!b.sS(4)) {
                            f.baQ();
                            Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", Boolean.valueOf(b.sS(4)));
                            z = false;
                        }
                    }
                    this.iYT = com.tencent.mm.an.c.a("upappmsg", this.dTX.field_createTime, this.dTX.field_talker, new StringBuilder().append(this.dTX.field_msgId).toString());
                    if (Util.isNullOrNil(this.iYT)) {
                        Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", Long.valueOf(this.dTX.field_msgId));
                        z = false;
                    } else {
                        g aSv = bVar.aSv();
                        if ((BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED) && (aSv.gqy != null || !Util.isNullOrNil(aSv.field_mediaId) || !Util.isNullOrNil(aSv.field_thumbpath) || !Util.isNullOrNil(aSv.field_talker))) {
                            RuntimeException runtimeException = new RuntimeException("Do not fill reserved fields!");
                            AppMethodBeat.o(31055);
                            throw runtimeException;
                        }
                        aSv.gqy = this.iZc;
                        aSv.field_mediaId = this.iYT;
                        aSv.field_thumbpath = str;
                        aSv.field_talker = this.dTX.field_talker;
                        Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", Integer.valueOf(bVar.type), str, this.iYT, Integer.valueOf(aSv.field_fileType), Boolean.valueOf(aSv.field_enable_hitcheck), Boolean.valueOf(aSv.field_onlycheckexist), Boolean.valueOf(aSv.field_force_aeskeycdn), Boolean.valueOf(aSv.field_trysafecdn));
                        if (!f.baQ().f(aSv)) {
                            Log.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                            this.iYT = "";
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                }
            } else {
                Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", str, Long.valueOf(this.JWF));
                z = false;
            }
        }
        if (z) {
            Log.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", this.iYT);
            AppMethodBeat.o(31055);
            return 0;
        }
        ad.b bnX = com.tencent.mm.ui.transmit.c.bnX(this.mSessionId);
        if (bnX != null && bnX.containsKey("_tmpl_webview_transfer_scene")) {
            this.DIB = new aay();
            this.DIB.eid.eie = bnX.getInt("_tmpl_webview_transfer_scene", -1);
        }
        dth dth = (dth) this.rr.iLK.iLR;
        fd fdVar = new fd();
        fdVar.jfi = bVar.appId;
        fdVar.KIz = this.dTX.field_talker + this.dTX.field_msgId + "T" + this.dTX.field_createTime;
        fdVar.iAc = k.b.a(bVar, null, null, 0, 0);
        fdVar.CreateTime = (int) Util.nowSecond();
        fdVar.xNG = this.dTX.field_talker;
        fdVar.xNH = z.aTY();
        fdVar.oUv = bVar.type;
        fdVar.KIy = bVar.sdkVer;
        fdVar.xub = bVar.iwL;
        String o = a.C0409a.anC().o(this.dTX);
        if (!Util.isNullOrNil(o)) {
            fdVar.KHq = o;
        } else {
            fdVar.KHq = br.ajw();
        }
        fdVar.KIC = bVar.eaj;
        fdVar.KID = bVar.eak;
        fdVar.KIE = bVar.eal;
        if (this.JWD != null) {
            fdVar.KIF = this.JWD.JVJ;
            fdVar.xuk = this.JWD.pkgName;
        }
        if (bnX != null) {
            this.DIA = new aax();
            this.DIA.ehN.url = bVar.url;
            this.DIA.ehN.ehO = bnX.getString("prePublishId", "");
            this.DIA.ehN.ehQ = bnX.getString("preUsername", "");
            this.DIA.ehN.ehR = bnX.getString("preChatName", "");
            this.DIA.ehN.ehS = bnX.getInt("preMsgIndex", 0);
            this.DIA.ehN.ehW = bnX.getInt("sendAppMsgScene", 0);
            this.DIA.ehN.ehX = bnX.getInt("getA8KeyScene", 0);
            this.DIA.ehN.ehY = bnX.getString("referUrl", null);
            this.DIA.ehN.ehZ = bnX.getString("adExtStr", null);
            this.DIA.ehN.ehT = this.dTX.field_talker;
            this.DIA.ehN.eia = bVar.title;
            this.DIA.ehN.eic = bVar.description;
            bg.aVF();
            as Kn = com.tencent.mm.model.c.aSN().Kn(this.dTX.field_talker);
            if (Kn != null) {
                this.DIA.ehN.ehU = Kn.arI();
            }
            this.DIA.ehN.ehV = v.Ie(this.dTX.field_talker);
            String str3 = "";
            if (bVar.ean != null) {
                eco eco = new eco();
                try {
                    eco.parseFrom(Base64.decode(bVar.ean, 0));
                    if (eco.NcJ != null) {
                        str3 = eco.NcJ.xEN;
                    }
                } catch (Exception e2) {
                }
            }
            dth.MVw = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", this.DIA.ehN.ehO, this.DIA.ehN.ehQ, this.DIA.ehN.ehR, Integer.valueOf(ac.aJ(this.DIA.ehN.ehQ, this.DIA.ehN.ehR)), Integer.valueOf(this.DIA.ehN.ehX), str3);
        }
        if (bnX != null && bVar.type == 33) {
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
            String str4 = this.dTX.field_talker;
            boolean z3 = bnX.getBoolean("moreRetrAction", false);
            if (str4.endsWith("@chatroom")) {
                this.JWE.dCt.action = z3 ? 5 : 2;
            } else {
                this.JWE.dCt.action = z3 ? 4 : 1;
            }
            this.JWE.dCt.dCv = bVar.izz + 1;
            this.JWE.dCt.dCx = bVar.izh;
            this.JWE.dCt.dCu = bVar.izi;
            this.JWE.dCt.appId = bVar.izj;
            this.JWE.dCt.appVersion = bVar.izA;
            this.JWE.dCt.dCz = Util.nowSecond();
            this.JWE.dCt.dCA = 1;
            this.JWE.dCt.dCC = bVar.izn;
        }
        Log.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", bVar.eaj, bVar.eak, bVar.eal);
        if (!Util.isNullOrNil(str)) {
            byte[] aW = com.tencent.mm.vfs.s.aW(str, 0, -1);
            if (!Util.isNullOrNil(aW)) {
                fdVar.KIA = new SKBuiltinBuffer_t().setBuffer(aW);
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(fdVar.KIA != null ? fdVar.KIA.getILen() : -1);
        Log.d("MicroMsg.NetSceneSendAppMsg", "doScene thumbFile:[%s] thumbdata:%d", objArr);
        dth.MVu = fdVar;
        if (bVar.iwM != 0 || bVar.iwI > 26214400) {
            dth.KKA = com.tencent.mm.i.a.gpO;
        }
        dth.Md5 = bVar.filemd5;
        dth.keb = this.mSignature;
        dth.MVy = this.dYz;
        if (((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(this.dTX.field_talker)) {
            dth.LbN = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(this.dTX.field_talker);
        }
        Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", dth.Md5, Util.secPrint(dth.keb), Integer.valueOf(dth.KKA), dth.MVw);
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(31055);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(31056);
        Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(this.msgId), this.dTX.field_content);
        dti dti = (dti) ((d) sVar).iLL.iLR;
        dth dth = (dth) ((d) sVar).iLK.iLR;
        if (dti != null && (i3 == 4 || (i3 == 0 && i4 == 0))) {
            ((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(dti.LbO);
        }
        if (i3 == 3 && i4 == -1 && !Util.isNullOrNil(this.iYT)) {
            Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.iYT);
            AppMethodBeat.o(31056);
        } else if (i3 == 0 && i4 == 0) {
            this.dTX.setStatus(2);
            this.dTX.yF(dti.Brn);
            bg.aVF();
            com.tencent.mm.model.c.aSQ().a(this.dTX.field_msgId, this.dTX);
            ((com.tencent.mm.plugin.record.a.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.record.a.f.class)).HQ(this.dTX.field_msgId);
            com.tencent.mm.modelstat.b.jmd.b(this.dTX, com.tencent.mm.ag.l.t(this.dTX));
            if (this.DIA != null && !Util.isNullOrNil(this.DIA.ehN.url)) {
                this.DIA.ehN.ehP = "msg_" + Long.toString(dti.Brn);
                EventCenter.instance.publish(this.DIA);
            }
            if (!(this.DIB == null || this.DIB.eid.eie == -1)) {
                EventCenter.instance.publish(this.DIB);
            }
            k.b HD = k.b.HD(this.dTX.field_content);
            if (HD != null && "wx4310bbd51be7d979".equals(HD.appId)) {
                boolean z = !Util.isNullOrNil(this.dTX.field_talker) && ab.Eq(this.dTX.field_talker);
                String str2 = "";
                try {
                    str2 = URLEncoder.encode(HD.description, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneSendAppMsg", e2, "", new Object[0]);
                }
                String str3 = "1," + (z ? 2 : 1) + ",," + str2;
                Log.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", str3);
                h.INSTANCE.kvStat(13717, str3);
            }
            if (HD != null) {
                switch (HD.type) {
                    case 53:
                        com.tencent.mm.plugin.groupsolitaire.b.d groupSolitatireReportManager = ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                        ca caVar = this.dTX;
                        if (caVar != null && caVar.field_msgSvrId > 0) {
                            com.tencent.f.h.RTc.b(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x033a: INVOKE  
                                  (wrap: com.tencent.f.i : 0x0330: SGET  (r3v24 com.tencent.f.i) =  com.tencent.f.h.RTc com.tencent.f.i)
                                  (wrap: com.tencent.mm.plugin.groupsolitaire.b.d$1 : 0x0334: CONSTRUCTOR  (r5v13 com.tencent.mm.plugin.groupsolitaire.b.d$1) = 
                                  (r0v45 'groupSolitatireReportManager' com.tencent.mm.plugin.groupsolitaire.b.d)
                                  (r2v28 'caVar' com.tencent.mm.storage.ca)
                                 call: com.tencent.mm.plugin.groupsolitaire.b.d.1.<init>(com.tencent.mm.plugin.groupsolitaire.b.d, com.tencent.mm.storage.ca):void type: CONSTRUCTOR)
                                  ("GroupSolitaireReport")
                                 type: INTERFACE call: com.tencent.f.i.b(java.lang.Runnable, java.lang.String):com.tencent.f.i.d in method: com.tencent.mm.pluginsdk.model.app.ag.onGYNetEnd(int, int, int, java.lang.String, com.tencent.mm.network.s, byte[]):void, file: classes5.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0334: CONSTRUCTOR  (r5v13 com.tencent.mm.plugin.groupsolitaire.b.d$1) = 
                                  (r0v45 'groupSolitatireReportManager' com.tencent.mm.plugin.groupsolitaire.b.d)
                                  (r2v28 'caVar' com.tencent.mm.storage.ca)
                                 call: com.tencent.mm.plugin.groupsolitaire.b.d.1.<init>(com.tencent.mm.plugin.groupsolitaire.b.d, com.tencent.mm.storage.ca):void type: CONSTRUCTOR in method: com.tencent.mm.pluginsdk.model.app.ag.onGYNetEnd(int, int, int, java.lang.String, com.tencent.mm.network.s, byte[]):void, file: classes5.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 36 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.groupsolitaire.b.d, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 42 more
                                */
                            /*
                            // Method dump skipped, instructions count: 862
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.model.app.ag.onGYNetEnd(int, int, int, java.lang.String, com.tencent.mm.network.s, byte[]):void");
                        }

                        @Override // com.tencent.mm.ak.q
                        public final int getType() {
                            return TbsListener.ErrorCode.UNLZMA_FAIURE;
                        }

                        @Override // com.tencent.mm.ak.q
                        public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
                            return q.b.EOk;
                        }
                    }
