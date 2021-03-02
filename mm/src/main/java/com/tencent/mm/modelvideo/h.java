package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.f;
import com.tencent.mm.i.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.protocal.protobuf.eoc;
import com.tencent.mm.protocal.protobuf.eod;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import junit.framework.Assert;

public final class h extends q implements m {
    private i callback;
    String fileName = null;
    private int jaB = 0;
    public d jaC = null;
    public f jaD = null;
    private com.tencent.mm.ak.d rr;

    public final String getFileName() {
        return this.fileName;
    }

    public h(String str, int i2, d dVar, f fVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(240867);
        Assert.assertTrue(str != null);
        if (dVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        Assert.assertTrue(fVar == null ? false : z2);
        this.fileName = str;
        this.jaC = dVar;
        this.jaD = fVar;
        this.jaB = i2;
        AppMethodBeat.o(240867);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(126872);
        s QN = u.QN(this.fileName);
        if (QN == null) {
            Log.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fileName);
            this.jaD.dq(3, -1);
            AppMethodBeat.o(126872);
            return -1;
        }
        a(QN, iVar);
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(126872);
        return dispatch;
    }

    public final eoc a(s sVar, i iVar) {
        int length;
        AppMethodBeat.i(240868);
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.iLN = new eoc();
        aVar.iLO = new eod();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvideo";
        aVar.funcId = 149;
        aVar.iLP = 39;
        aVar.respCmdId = 1000000039;
        this.rr = aVar.aXF();
        eoc eoc = (eoc) this.rr.iLK.iLR;
        eoc.NlQ = 0;
        eoc.NlP = (int) this.jaC.field_fileLength;
        eoc.NlR = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        eoc.MrU = 0;
        eoc.MrT = this.jaC.field_thumbimgLength;
        eoc.MrV = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        eoc.xNH = z.aTY();
        eoc.xNG = this.jaC.field_toUser;
        eoc.KIz = this.fileName;
        if (sVar.jsr == 1) {
            eoc.KTf = 2;
        }
        if (sVar.jsu == 3) {
            eoc.KTf = 3;
        }
        eoc.MXo = sVar.iFw;
        eoc.LrC = ag.dm(MMApplicationContext.getContext()) ? 1 : 2;
        eoc.MrW = 2;
        eoc.NlH = this.jaC.field_thumbimgLength;
        eoc.NlS = this.jaC.field_fileId;
        eoc.Mip = this.jaC.field_fileId;
        eoc.LbK = 1;
        if (this.jaC.alL()) {
            Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", bgZ(), Boolean.valueOf(this.jaC.field_upload_by_safecdn), Integer.valueOf(this.jaC.field_UploadHitCacheType), Integer.valueOf(this.jaC.field_filecrc), this.jaC.field_aesKey);
            eoc.MVx = 1;
            eoc.LbJ = "";
            eoc.Mir = "";
        } else {
            eoc.LbJ = this.jaC.field_aesKey;
            eoc.Mir = this.jaC.field_aesKey;
        }
        eoc.NlU = this.jaC.field_filemd5;
        eoc.Nme = this.jaC.field_mp4identifymd5;
        eoc.LbL = this.jaC.field_filecrc;
        eoc.KHq = bhb();
        eoc.Nmd = sVar.ean;
        if (((s) com.tencent.mm.kernel.g.ah(s.class)).ifAddTicketByActionFlag(this.jaC.field_toUser)) {
            eoc.LbN = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(this.jaC.field_toUser);
        }
        eeq eeq = sVar.jsw;
        if (eeq != null && !Util.isNullOrNil(eeq.iyZ)) {
            eoc.NlV = Util.nullAs(eeq.iyZ, "");
            eoc.NlW = eeq.LxJ;
            eoc.NlX = Util.nullAs(eeq.izb, "");
            eoc.NlZ = Util.nullAs(eeq.izd, "");
            eoc.NlY = Util.nullAs(eeq.izc, "");
            eoc.Nma = Util.nullAs(eeq.ize, "");
        } else if (eeq != null && !Util.isNullOrNil(eeq.izd) && !Util.isNullOrNil(eeq.izc)) {
            eoc.NlZ = eeq.izd;
            eoc.NlY = eeq.izc;
        }
        if (eeq != null) {
            eoc.Nmc = Util.nullAs(eeq.izf, "");
            eoc.Nmb = Util.nullAs(eeq.izg, "");
        }
        o.bhj();
        String Qx = t.Qx(this.fileName);
        BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(Qx);
        if (imageOptions != null) {
            eoc.NlJ = imageOptions.outWidth;
            eoc.NlI = imageOptions.outHeight;
        } else {
            Log.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", Qx);
        }
        o.bhj();
        switch (n.bhh().Qj(t.Qw(this.fileName))) {
            case 1:
                eoc.LbM = 1;
                eoc.xub = 2;
                break;
            case 2:
                eoc.LbM = 1;
                eoc.xub = 1;
                break;
            case 3:
            case 6:
                eoc.LbM = 2;
                eoc.xub = 3;
                break;
            case 4:
            case 5:
            default:
                eoc.LbM = 0;
                eoc.xub = 0;
                break;
            case 7:
                eoc.LbM = 3;
                eoc.xub = 4;
                break;
            case 8:
                eoc.LbM = 1;
                eoc.xub = 5;
                break;
        }
        Object[] objArr = new Object[22];
        objArr[0] = bgZ();
        objArr[1] = this.fileName;
        objArr[2] = this.jaC.field_toUser;
        if (this.jaC.field_aesKey == null) {
            length = -1;
        } else {
            length = this.jaC.field_aesKey.length();
        }
        objArr[3] = Integer.valueOf(length);
        objArr[4] = this.jaC.field_fileId;
        objArr[5] = Integer.valueOf(this.jaC.field_thumbimgLength);
        objArr[6] = Integer.valueOf(eoc.NlJ);
        objArr[7] = Integer.valueOf(eoc.NlI);
        objArr[8] = Util.secPrint(eoc.Mir);
        objArr[9] = Integer.valueOf(eoc.KTf);
        objArr[10] = eoc.NlU;
        objArr[11] = Integer.valueOf(eoc.MVx);
        objArr[12] = Integer.valueOf(eoc.LbL);
        objArr[13] = eoc.Nme;
        objArr[14] = Util.secPrint(eoc.LbJ);
        objArr[15] = eoc.NlV;
        objArr[16] = Integer.valueOf(eoc.NlW);
        objArr[17] = eoc.NlX;
        objArr[18] = eoc.Nma;
        objArr[19] = eoc.KHq;
        objArr[20] = Integer.valueOf(eoc.LbM);
        objArr[21] = Integer.valueOf(eoc.xub);
        Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]", objArr);
        AppMethodBeat.o(240868);
        return eoc;
    }

    private String bhb() {
        AppMethodBeat.i(240869);
        s QN = u.QN(this.fileName);
        String str = null;
        if (QN != null) {
            if (!Util.isNullOrNil(QN.jsz)) {
                str = QN.jsz;
            } else if (QN.jsy > 0) {
                str = br.KB(((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb((long) QN.jsy).fqK);
            } else {
                String bhK = com.tencent.mm.vfs.s.bhK(QN.bhu());
                v vVar = v.jNy;
                str = v.Ss(bhK);
            }
        }
        Log.i("MicroMsg.NetSceneUploadVideoForCdn", "createVideoMsgSource preLoadLength: %s, forward uuid %s", Integer.valueOf(this.jaB), str);
        if (this.jaB > 0 && this.jaB <= 1048576) {
            StringBuilder sb = new StringBuilder();
            sb.append("<msgsource>");
            sb.append("<videopreloadlen>").append(this.jaB).append("</videopreloadlen>");
            if (!Util.isNullOrNil(str)) {
                sb.append("<sec_msg_node><uuid>").append(str).append("</uuid></sec_msg_node>");
            }
            sb.append("</msgsource>");
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 35, 1, false);
            String sb2 = sb.toString();
            AppMethodBeat.o(240869);
            return sb2;
        } else if (Util.isNullOrNil(str)) {
            String ajw = br.ajw();
            AppMethodBeat.o(240869);
            return ajw;
        } else {
            String KC = br.KC(str);
            AppMethodBeat.o(240869);
            return KC;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 1;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
        AppMethodBeat.i(126873);
        u.QE(this.fileName);
        AppMethodBeat.o(126873);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(126874);
        Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", bgZ(), Integer.valueOf(i3), Integer.valueOf(i4));
        a(i3, i4, str, (eod) ((com.tencent.mm.ak.d) sVar).iLL.iLR, this);
        AppMethodBeat.o(126874);
    }

    public final void a(int i2, int i3, String str, eod eod, q qVar) {
        int i4;
        AppMethodBeat.i(240870);
        if (eod != null && (i2 == 4 || (i2 == 0 && i3 == 0))) {
            ((s) com.tencent.mm.kernel.g.ah(s.class)).setEnSendMsgActionFlag(eod.LbO);
        }
        s QN = u.QN(this.fileName);
        if (QN == null) {
            Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
            this.callback.onSceneEnd(i2, i3, str, qVar);
            this.jaD.dq(3, -1);
            AppMethodBeat.o(240870);
        } else if (i2 == 4 && i3 == 102) {
            Log.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + QN.getUser());
            this.callback.onSceneEnd(i2, i3, str, qVar);
            this.jaD.dq(i2, i3);
            AppMethodBeat.o(240870);
        } else if (i2 == 4 && i3 == -22) {
            Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + QN.getUser());
            u.QF(this.fileName);
            this.callback.onSceneEnd(i2, i3, str, qVar);
            this.jaD.dq(i2, i3);
            AppMethodBeat.o(240870);
        } else if (i2 == 4 && i3 != 0) {
            Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + QN.getUser());
            u.QE(this.fileName);
            this.callback.onSceneEnd(i2, i3, str, qVar);
            this.jaD.dq(i2, i3);
            AppMethodBeat.o(240870);
        } else if (i2 == 0 && i3 == 0) {
            QN.jsm = Util.nowSecond();
            QN.dTS = eod.Brn;
            Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", bgZ(), Long.valueOf(QN.dTS), Integer.valueOf(ac.jOD));
            if (!(10007 != ac.jOC || ac.jOD == 0 || QN.dTS == 0)) {
                QN.dTS = (long) ac.jOD;
                ac.jOD = 0;
            }
            QN.status = 199;
            QN.cSx = 1284;
            if (this.jaC.alL()) {
                Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", bgZ(), eod.LbJ, QN.bhv());
                if (!Util.isNullOrNil(eod.LbJ)) {
                    String str2 = ((("<msg><videomsg aeskey=\"" + eod.LbJ + "\" cdnthumbaeskey=\"" + eod.LbJ + "\" cdnvideourl=\"" + this.jaC.field_fileId + "\" ") + "cdnthumburl=\"" + this.jaC.field_fileId + "\" ") + "length=\"" + this.jaC.field_fileLength + "\" ") + "cdnthumblength=\"" + this.jaC.field_thumbimgLength + "\"/></msg>";
                    Log.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", str2);
                    QN.jst = str2;
                    t bhj = o.bhj();
                    o.bhj();
                    boolean q = bhj.q(t.Qw(this.fileName), this.jaC.field_fileId, eod.LbJ);
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                    Object[] objArr = new Object[2];
                    if (q) {
                        i4 = 1;
                    } else {
                        i4 = 2;
                    }
                    objArr[0] = Integer.valueOf(i4 + TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
                    objArr[1] = Integer.valueOf(QN.iKP);
                    hVar.a(12696, objArr);
                    Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", bgZ(), eod.LbJ, QN.bhv(), Boolean.valueOf(q));
                } else {
                    Log.w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", bgZ());
                }
            }
            u.f(QN);
            u.d(QN);
            ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb((long) QN.jso);
            Hb.BB(eod.KHq);
            ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(Hb.field_msgId, Hb);
            b.jmd.s(Hb);
            if (Qg(QN.getUser()) || ab.Jf(QN.getUser())) {
                Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", bgZ(), QN.getUser());
                if (QN.dTS < 0) {
                    Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + QN.dTS + " file:" + this.fileName + " toUser:" + QN.getUser());
                    u.QE(this.fileName);
                    this.jaD.dq(3, -1);
                }
            } else {
                Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", bgZ());
                if (QN.dTS <= 0) {
                    Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + QN.dTS + " file:" + this.fileName + " toUser:" + QN.getUser());
                    u.QE(this.fileName);
                    this.jaD.dq(3, -1);
                }
            }
            this.callback.onSceneEnd(i2, i3, str, qVar);
            this.jaD.dq(0, 0);
            AppMethodBeat.o(240870);
        } else {
            Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + QN.getUser());
            u.QE(this.fileName);
            this.callback.onSceneEnd(i2, i3, str, qVar);
            this.jaD.dq(i2, i3);
            AppMethodBeat.o(240870);
        }
    }

    private static boolean Qg(String str) {
        AppMethodBeat.i(240871);
        as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str);
        if (Kn == null || ((int) Kn.gMZ) <= 0) {
            AppMethodBeat.o(240871);
            return false;
        }
        boolean gBM = Kn.gBM();
        AppMethodBeat.o(240871);
        return gBM;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 149;
    }

    private String bgZ() {
        AppMethodBeat.i(126875);
        String str = this.fileName + "_" + hashCode();
        AppMethodBeat.o(126875);
        return str;
    }
}
