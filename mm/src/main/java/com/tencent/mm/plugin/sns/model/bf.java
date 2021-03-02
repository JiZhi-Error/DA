package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.recordvideo.e.d;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.protocal.protobuf.cwz;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.eam;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.protocal.protobuf.fc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class bf {
    private static final Pattern PATTERN = Pattern.compile("(\n){3,}");
    int DEA;
    int DEB;
    List<q> DOY;
    String DOZ;
    String DPa;
    LinkedList<ebm> DPb;
    LinkedList<Long> DPc;
    public TimeLineObject DPd;
    public cnc DPe;
    public SnsInfo DPf;
    SnsObject DPg;
    public eep DPh;
    private int DPi;
    private String DPj;
    private boolean DPk;
    be actionInfo;
    public int beK;
    public cly eck;
    private String gna;
    private WeakReference<Context> mContextRef;
    public fat webSearchInfo;

    public bf(int i2) {
        this(i2, null);
        AppMethodBeat.i(96035);
        AppMethodBeat.o(96035);
    }

    public bf(int i2, Context context) {
        AppMethodBeat.i(202797);
        this.DPd = n.bfM();
        this.DPe = new cnc();
        this.DPf = new SnsInfo();
        this.DPg = null;
        be beVar = new be();
        beVar.KEw = new bc();
        beVar.KEy = new ek();
        beVar.KEz = new fc();
        this.actionInfo = beVar;
        this.DPh = new eep();
        this.eck = new cly();
        this.webSearchInfo = null;
        this.gna = "";
        this.DPi = 1;
        this.DPj = "";
        this.DPk = false;
        this.gna = aj.fau();
        this.beK = i2;
        this.DPd.ContentObj.LoU = i2;
        if (context != null) {
            this.mContextRef = new WeakReference<>(context);
        }
        Log.d("MicroMsg.UploadPackHelper", "contentType ".concat(String.valueOf(i2)));
        this.DPd.Privated = 0;
        this.DPd.UserName = this.gna;
        this.DPe.izX = g.getMessageDigest((aj.fau() + Util.currentTicks() + System.currentTimeMillis()).getBytes());
        this.DPe.MsU = 0;
        this.DPe.MsV = 0;
        this.DPe.Privated = 0;
        this.DPe.MsY = 0;
        this.DPe.ibG = 0;
        this.DPe.Mta = 0;
        this.DPe.Mtc = 0;
        SnsObject snsObject = new SnsObject();
        snsObject.Id = 0;
        snsObject.CreateTime = 0;
        snsObject.LikeFlag = 0;
        snsObject.Username = aj.fau();
        snsObject.LikeUserList = new LinkedList<>();
        snsObject.LikeCount = 0;
        snsObject.LikeUserListCount = 0;
        snsObject.WithUserList = new LinkedList<>();
        snsObject.WithUserCount = 0;
        snsObject.WithUserListCount = 0;
        snsObject.CommentUserList = new LinkedList<>();
        snsObject.CommentCount = 0;
        snsObject.CommentUserListCount = 0;
        snsObject.ExtFlag = 1;
        snsObject.LikeFlag = 0;
        snsObject.NoChange = 0;
        snsObject.ObjectDesc = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        this.DPg = snsObject;
        this.DPf.setPostWaiting();
        this.DPf.setCreateTime((int) (System.currentTimeMillis() / 1000));
        this.DPf.setTypeFlag(i2);
        this.DPf.setUserName(this.gna);
        this.DPf.setPravited(0);
        this.DPf.setStringSeq("0000099999999999999999999");
        this.DPf.addSourceFlag(2);
        this.DPf.setExtFlag();
        if (i2 == 1 || i2 == 2) {
            this.DPf.addSourceFlag(4);
        }
        if (i2 == 7) {
            this.DPf.removeSourceFlag(2);
        }
        this.DPc = new LinkedList<>();
        this.DPe.Mtb = this.DPc;
        Iterator<Long> it = this.DPc.iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            dzw dzw = new dzw();
            dzw.MZv = longValue;
            this.DPg.GroupList.add(dzw);
        }
        this.DPg.GroupCount = this.DPc.size();
        AppMethodBeat.o(202797);
    }

    public final int getContentType() {
        return this.beK;
    }

    static {
        AppMethodBeat.i(96061);
        AppMethodBeat.o(96061);
    }

    private static String aPv(String str) {
        String str2;
        AppMethodBeat.i(96036);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        try {
            str2 = PATTERN.matcher(str2.trim().replace(APLogFileUtil.SEPARATOR_LINE, "\n")).replaceAll("\n\n");
            AppMethodBeat.o(96036);
        } catch (Exception e2) {
            Log.e("MicroMsg.UploadPackHelper", "filter desc error ");
            AppMethodBeat.o(96036);
        }
        return str2;
    }

    public final bf aPw(String str) {
        AppMethodBeat.i(96037);
        this.DOZ = aPv(str);
        this.DPd.ContentDesc = this.DOZ;
        AppMethodBeat.o(96037);
        return this;
    }

    public final bf kl(String str, String str2) {
        this.DPe.token = str;
        this.DPe.Mte = str2;
        return this;
    }

    public final bf YF(int i2) {
        this.DPd.contentDescShowType = 1;
        this.DPd.contentDescScene = i2;
        return this;
    }

    public final bf YG(int i2) {
        this.DPd.contentattr = i2;
        return this;
    }

    public final bf aPx(String str) {
        this.DPd.statisticsData = str;
        this.actionInfo.KEw.KEq = str;
        return this;
    }

    public final bf aPy(String str) {
        this.DPd.canvasInfo = str;
        return this;
    }

    public final bf aO(String str, String str2, String str3) {
        AppMethodBeat.i(96038);
        bc bcVar = this.actionInfo.KEw;
        if (Util.isNullOrNil(str)) {
            str = "";
        }
        bcVar.jfi = str;
        bc bcVar2 = this.actionInfo.KEw;
        if (Util.isNullOrNil(str2)) {
            str2 = "";
        }
        bcVar2.KEr = str2;
        bc bcVar3 = this.actionInfo.KEw;
        if (Util.isNullOrNil(str3)) {
            str3 = "";
        }
        bcVar3.KEs = str3;
        AppMethodBeat.o(96038);
        return this;
    }

    public final bf aPz(String str) {
        this.DPa = str;
        this.DPd.ContentObj.Desc = str;
        return this;
    }

    public final bf aPA(String str) {
        this.DPd.ContentObj.Url = str;
        return this;
    }

    public final bf aPB(String str) {
        this.DPd.ContentObj.Title = str;
        return this;
    }

    public final bf ct(int i2, String str) {
        this.DPi = i2;
        this.DPj = str;
        return this;
    }

    public final void YH(int i2) {
        AppMethodBeat.i(96039);
        Log.d("MicroMsg.UploadPackHelper", "set post form ".concat(String.valueOf(i2)));
        this.DPe.Mta = i2;
        AppMethodBeat.o(96039);
    }

    public final bf a(cjy cjy) {
        if (cjy != null) {
            this.DPd.Location = cjy;
        }
        return this;
    }

    public final bf YI(int i2) {
        AppMethodBeat.i(96040);
        this.DEB = i2;
        this.DPe.Privated = i2;
        this.DPd.Privated = i2;
        if (i2 > 0) {
            this.DPf.setPravited(i2);
            this.DPf.setLocalPrivate();
            this.DPf.removeSourceFlag(2);
            this.DPf.unSetExtFlag();
        }
        AppMethodBeat.o(96040);
        return this;
    }

    public final bf YJ(int i2) {
        this.DEA = i2;
        this.DPe.MsV = i2;
        return this;
    }

    public final bf bq(LinkedList<ebm> linkedList) {
        AppMethodBeat.i(96041);
        this.DPb = linkedList;
        this.DPe.MsX = linkedList;
        Iterator<ebm> it = this.DPb.iterator();
        while (it.hasNext()) {
            dzo dzo = new dzo();
            dzo.Username = it.next().UserName;
            this.DPg.WithUserList.add(dzo);
        }
        this.DPg.WithUserCount = this.DPb.size();
        this.DPg.WithUserListCount = this.DPb.size();
        AppMethodBeat.o(96041);
        return this;
    }

    public final bf fbU() {
        return this;
    }

    public final bf YK(int i2) {
        this.DPe.Mtc = i2;
        return this;
    }

    public final bf aPC(String str) {
        AppMethodBeat.i(96042);
        fa faVar = this.DPd.AppInfo;
        if (faVar == null) {
            faVar = new fa();
        }
        faVar.Id = str;
        this.DPd.AppInfo = faVar;
        AppMethodBeat.o(96042);
        return this;
    }

    public final bf aPD(String str) {
        AppMethodBeat.i(96043);
        fa faVar = this.DPd.AppInfo;
        if (faVar == null) {
            faVar = new fa();
        }
        faVar.xMq = str;
        this.DPd.AppInfo = faVar;
        AppMethodBeat.o(96043);
        return this;
    }

    public final bf aPE(String str) {
        AppMethodBeat.i(96044);
        this.DPd.sourceUserName = Util.nullAsNil(str);
        AppMethodBeat.o(96044);
        return this;
    }

    public final bf aPF(String str) {
        AppMethodBeat.i(96045);
        this.DPd.sourceNickName = Util.nullAsNil(str);
        AppMethodBeat.o(96045);
        return this;
    }

    public final bf gR(List<String> list) {
        AppMethodBeat.i(96046);
        if (list == null || list.size() == 0) {
            this.DPg.ExtFlag = 1;
            AppMethodBeat.o(96046);
        } else {
            LinkedList<dqi> linkedList = new LinkedList<>();
            for (String str : list) {
                dqi dqi = new dqi();
                dqi.bhy(str);
                linkedList.add(dqi);
            }
            this.DPe.GroupUser = linkedList;
            if (this.DPg.ExtFlag == 3) {
                this.DPg.BlackList = linkedList;
                this.DPg.BlackListCount = linkedList.size();
            } else if (this.DPg.ExtFlag == 5) {
                this.DPg.GroupUser = linkedList;
                this.DPg.GroupUserCount = linkedList.size();
            }
            AppMethodBeat.o(96046);
        }
        return this;
    }

    public final bf YL(int i2) {
        if (i2 == 1) {
            this.DPg.ExtFlag = 3;
        } else if (i2 == 0) {
            this.DPg.ExtFlag = 5;
        }
        this.DPe.Mtf = i2;
        return this;
    }

    private static cnb v(String str, byte[] bArr) {
        AppMethodBeat.i(96047);
        if (Util.isNullOrNil(bArr)) {
            Log.e("MicroMsg.UploadPackHelper", f.apq() + " attachBuf is null");
            AppMethodBeat.o(96047);
            return null;
        }
        String str2 = aj.getAccSnsTmpPath() + g.getMessageDigest((" " + System.currentTimeMillis()).getBytes());
        s.boN(aj.getAccSnsTmpPath());
        Log.d("MicroMsg.UploadPackHelper", f.apq() + " buildUploadAttachInfo file:" + str2);
        if (s.f(str2, bArr, bArr.length) < 0) {
            Log.e("MicroMsg.UploadPackHelper", f.apq() + " writeFile error file:" + str2);
            AppMethodBeat.o(96047);
            return null;
        }
        cnb km = km(str, str2);
        AppMethodBeat.o(96047);
        return km;
    }

    public static cnb b(String str, String str2, String str3, String str4, String str5, String str6) {
        cnd cnd;
        AppMethodBeat.i(96048);
        cnb bfN = n.bfN();
        bfN.Id = str;
        Log.i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s,cdnUrl %s,cdnThumbUrl %s", 6, str2, str4, str5, str6);
        bfN.oUv = 6;
        if (s.boW(str2) <= 0) {
            AppMethodBeat.o(96048);
            return null;
        }
        q qVar = new q(str2, 6);
        qVar.DEE = str4;
        q a2 = aj.faD().a(qVar, str2, str3, str5, str6);
        if (a2.height <= 0 || a2.width <= 0 || a2.fileSize <= 0) {
            cnd = null;
        } else {
            cnd = new cnd();
            cnd.Mtp = (float) a2.height;
            cnd.Mto = (float) a2.width;
            cnd.Mtq = (float) a2.fileSize;
        }
        bfN.Id = "Locall_path" + a2.ecf;
        bfN.MsB = cnd;
        bfN.ecf = a2.ecf;
        AppMethodBeat.o(96048);
        return bfN;
    }

    private static cnb km(String str, String str2) {
        cnd cnd = null;
        AppMethodBeat.i(96049);
        cnb bfN = n.bfN();
        bfN.Id = str;
        Log.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
        bfN.oUv = 2;
        if (s.boW(str2) <= 0) {
            AppMethodBeat.o(96049);
            return null;
        }
        String str3 = aj.getAccSnsTmpPath() + g.getMessageDigest((str2 + System.currentTimeMillis()).getBytes());
        s.nw(str2, str3);
        q qVar = new q(str3, 2);
        LinkedList linkedList = new LinkedList();
        linkedList.add(qVar);
        List<q> gW = aj.faD().gW(linkedList);
        if (gW == null || gW.size() == 0) {
            AppMethodBeat.o(96049);
            return null;
        }
        q qVar2 = gW.get(0);
        if (qVar2.height > 0 && qVar2.width > 0 && qVar2.fileSize > 0) {
            cnd = new cnd();
            cnd.Mtp = (float) qVar2.height;
            cnd.Mto = (float) qVar2.width;
            cnd.Mtq = (float) qVar2.fileSize;
        }
        bfN.Id = "Locall_path" + qVar2.ecf;
        bfN.MsB = cnd;
        bfN.ecf = qVar2.ecf;
        AppMethodBeat.o(96049);
        return bfN;
    }

    private static cnb aP(String str, String str2, String str3) {
        AppMethodBeat.i(96050);
        cnb bfN = n.bfN();
        bfN.Id = str;
        Log.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
        bfN.oUv = 2;
        bfN.Url = str2;
        bfN.Mcw = 0;
        bfN.Msz = str3;
        bfN.MsA = 0;
        bfN.MsE = 1;
        AppMethodBeat.o(96050);
        return bfN;
    }

    public final boolean D(String str, String str2, String str3, String str4) {
        float f2;
        AppMethodBeat.i(96051);
        d dVar = d.Cin;
        d.a aLQ = d.aLQ(str);
        if (aLQ != null) {
            Log.i("MicroMsg.UploadPackHelper", "addSightObjectByPath commit video_info:".concat(String.valueOf(aLQ)));
            f2 = ((float) aLQ.duration) / 1000.0f;
        } else {
            f2 = 0.0f;
        }
        String str5 = aj.getAccSnsTmpPath() + g.getMessageDigest(str.getBytes());
        aPG(str5);
        s.nw(str, str5);
        String str6 = aj.getAccSnsTmpPath() + g.getMessageDigest(str2.getBytes());
        s.nw(str2, str6);
        cnb b2 = b("", str5, str6, str4, "", "");
        if (b2 == null) {
            Log.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
            AppMethodBeat.o(96051);
            return false;
        }
        b2.Desc = str3;
        if (Util.isNullOrNil(b2.Title)) {
            b2.Title = str3;
        }
        b2.MsT = f2;
        this.DPd.ContentObj.LoV.add(b2);
        cjs cjs = new cjs();
        cjs.Mpj = b2.ecf;
        this.DPe.MsW.add(cjs);
        AppMethodBeat.o(96051);
        return true;
    }

    public static void aPG(String str) {
        AppMethodBeat.i(96052);
        s.boN(s.boZ(str));
        AppMethodBeat.o(96052);
    }

    public final boolean kn(String str, String str2) {
        AppMethodBeat.i(96053);
        String str3 = aj.getAccSnsTmpPath() + g.getMessageDigest(str.getBytes());
        aPG(str3);
        s.nw(str, str3);
        cnb km = km("", str3);
        if (km == null) {
            Log.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
            AppMethodBeat.o(96053);
            return false;
        }
        km.Desc = str2;
        if (Util.isNullOrNil(km.Title)) {
            km.Title = str2;
        }
        this.DPd.ContentObj.LoV.add(km);
        cjs cjs = new cjs();
        cjs.Mpj = km.ecf;
        this.DPe.MsW.add(cjs);
        AppMethodBeat.o(96053);
        return true;
    }

    @Deprecated
    public final boolean c(String str, String str2, String str3, int i2, String str4) {
        AppMethodBeat.i(96054);
        cnb aP = aP("", str, str2);
        if (aP == null) {
            Log.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
            AppMethodBeat.o(96054);
            return false;
        }
        aP.Desc = str3;
        if (i2 > 0) {
            aP.subType = i2;
        }
        if (!Util.isNullOrNil(str4)) {
            aP.EpK = str4;
        }
        this.DPd.ContentObj.LoV.add(aP);
        AppMethodBeat.o(96054);
        return true;
    }

    public final boolean b(byte[] bArr, String str, String str2) {
        AppMethodBeat.i(96055);
        boolean a2 = a(bArr, str, str2, -1, "");
        AppMethodBeat.o(96055);
        return a2;
    }

    public final boolean a(byte[] bArr, String str, String str2, int i2, String str3) {
        AppMethodBeat.i(96056);
        cnb v = v("", bArr);
        if (v == null) {
            Log.e("MicroMsg.UploadPackHelper", "share img o.data is null!");
            AppMethodBeat.o(96056);
            return false;
        }
        v.Desc = str;
        if (i2 > 0) {
            v.subType = i2;
        }
        if (!Util.isNullOrNil(str3)) {
            v.EpK = str3;
        }
        if (!Util.isNullOrNil(str2)) {
            v.Title = str2;
        }
        if (!Util.isNullOrNil(str)) {
            v.Desc = str;
        }
        this.DPd.ContentObj.LoV.add(v);
        cjs cjs = new cjs();
        cjs.Mpj = v.ecf;
        this.DPe.MsW.add(cjs);
        AppMethodBeat.o(96056);
        return true;
    }

    public final boolean a(byte[] bArr, String str, String str2, String str3, int i2, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(96057);
        cnb v = v("", bArr);
        if (v == null || (Util.isNullOrNil(str2) && Util.isNullOrNil(str3))) {
            Log.e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
            AppMethodBeat.o(96057);
            return false;
        }
        if (!Util.isNullOrNil(str)) {
            this.DPd.ContentObj.Url = str;
        }
        if (!Util.isNullOrNil(str3)) {
            v.Url = str3;
            v.Mcw = 0;
        } else if (!Util.isNullOrNil(str2)) {
            v.Url = str2;
            v.Mcw = 0;
        }
        if (!Util.isNullOrNil(str2)) {
            v.MsC = str2;
            v.MsD = 0;
        }
        v.oUv = i2;
        v.Title = Util.nullAs(str4, "");
        v.Desc = Util.nullAs(str5, "");
        v.songAlbumUrl = str6;
        v.songLyric = str7;
        this.DPd.ContentObj.LoV.add(v);
        cjs cjs = new cjs();
        cjs.Mpj = v.ecf;
        this.DPe.MsW.add(cjs);
        AppMethodBeat.o(96057);
        return true;
    }

    public final void gS(List<q> list) {
        AppMethodBeat.i(96058);
        this.DOY = list;
        List<q> gW = aj.faD().gW(this.DOY);
        LinkedList<cjs> linkedList = new LinkedList<>();
        if (gW == null) {
            AppMethodBeat.o(96058);
            return;
        }
        for (q qVar : gW) {
            cjs cjs = new cjs();
            cjs.Mpj = qVar.ecf;
            linkedList.add(cjs);
        }
        this.DPe.MsW = linkedList;
        for (q qVar2 : gW) {
            cnd cnd = new cnd();
            cnd.Mtp = 0.0f;
            cnd.Mto = 0.0f;
            cnd.Mtq = 0.0f;
            if (qVar2.height > 0 && qVar2.width > 0 && qVar2.fileSize > 0) {
                cnd.Mtp = (float) qVar2.height;
                cnd.Mto = (float) qVar2.width;
                cnd.Mtq = (float) qVar2.fileSize;
            }
            this.DPd.ContentObj.LoV.add(n.a("Locall_path" + qVar2.ecf, qVar2.type, "", "", 0, 0, this.DEB, "", cnd));
        }
        AppMethodBeat.o(96058);
    }

    public final void g(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(96059);
        eam eam = new eam();
        eam.KIC = str;
        eam.KID = str2;
        eam.KIE = str3;
        eam.Etq = i2;
        eam.Etr = i3;
        this.DPe.Mtg = eam;
        AppMethodBeat.o(96059);
    }

    public final void aPH(String str) {
        this.DPe.eam = str;
    }

    public final void setSessionId(String str) {
        this.DPe.sessionId = str;
    }

    public final int commit() {
        int i2;
        cne cne;
        int i3;
        AppMethodBeat.i(96060);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.DPe.MsZ = System.currentTimeMillis();
            this.DPe.ibG = 0;
            cwz cwz = new cwz();
            cwz.KIF = this.DPi;
            cwz.xuk = this.DPj;
            this.DPe.Mtn = cwz;
            this.DPf.setAttrBuf(this.DPg.toByteArray());
            this.DPf.setPostBuf(this.DPe.toByteArray());
            Log.d("MicroMsg.UploadPackHelper", "snsObj " + this.DPg.toString());
            Log.d("MicroMsg.UploadPackHelper", "postinfo " + this.DPe.toString());
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.UploadPackHelper", e2, "", new Object[0]);
        }
        Log.d("MicroMsg.UploadPackHelper", "timelineObj " + this.DPd.toString());
        if (this.DPd.ContentObj.LoV != null) {
            Log.d("MicroMsg.UploadPackHelper", "timelineObj MeidaCount %d ", Integer.valueOf(this.DPd.ContentObj.LoV.size()));
            for (int i4 = 0; i4 < this.DPd.ContentObj.LoV.size(); i4++) {
                cnb cnb = this.DPd.ContentObj.LoV.get(i4);
                if (cnb != null) {
                    Log.d("MicroMsg.UploadPackHelper", "timelineObj media %d %s", Integer.valueOf(cnb.ecf), Util.nullAs(cnb.Url, ""));
                }
            }
        }
        if (this.actionInfo != null) {
            this.DPd.actionInfo = this.actionInfo;
        }
        if (this.webSearchInfo != null) {
            this.DPd.webSearchInfo = this.webSearchInfo;
        }
        this.DPf.setTimeLine(this.DPd);
        int R = aj.faO().R(this.DPf);
        k faV = aj.faV();
        j jVar = null;
        Cursor rawQuery = faV.db.rawQuery("select *,rowid from snsDraft  where " + k.Emm + k.Emn + " limit 1", null, 2);
        try {
            if (rawQuery.moveToFirst()) {
                jVar = new j();
                jVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            if (jVar != null) {
                faV.b("draft_sent_".concat(String.valueOf(R)), jVar.field_draft, 0);
                faV.b(jVar.field_key, null, 0);
            }
            Iterator<cjs> it = this.DPe.MsW.iterator();
            int i5 = 0;
            String str = null;
            while (it.hasNext()) {
                cjs next = it.next();
                com.tencent.mm.plugin.sns.storage.q JK = aj.faD().JK((long) next.Mpj);
                try {
                    cne cne2 = (cne) new cne().parseFrom(JK.EmR);
                    if (this.DPd.AppInfo != null) {
                        cne2.dNI = this.DPd.AppInfo.Id;
                    }
                    if (this.eck != null) {
                        this.eck.vUh = 0;
                    }
                    cne2.Mtx = this.eck;
                    cne2.beK = this.DPd.ContentObj.LoU;
                    if (cne2.beK == 1 || cne2.beK == 15) {
                        if (!Util.isNullOrNil(cne2.dNI)) {
                            i2 = 5;
                            cne = cne2;
                        } else if (cne2.Mtx != null && cne2.beK == 15) {
                            if (cne2.Mtx.Mrn) {
                                i3 = 1;
                            } else {
                                i3 = 2;
                            }
                            cne2.Mty = i3;
                        } else if (this.DOY.get(i5).DEF) {
                            i2 = 1;
                            cne = cne2;
                        } else {
                            i2 = 2;
                            cne = cne2;
                        }
                        cne.Mty = i2;
                    }
                    JK.EmR = cne2.toByteArray();
                    aj.faD().a(next.Mpj, JK);
                    i5++;
                    str = cne2.md5;
                } catch (Exception e3) {
                    Log.e("MicroMsg.UploadPackHelper", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
                }
            }
            Log.i("MicroMsg.UploadPackHelper", "commit sns info ret %d, typeFlag %d sightMd5 %s", Integer.valueOf(R), Integer.valueOf(this.DPf.getTypeFlag()), str);
            if (R > 0 && this.DPf.getTypeFlag() == 15) {
                ay.kk(y.bp("sns_table_", (long) R), str);
            }
            Log.d("MicroMsg.UploadPackHelper", "pack commit result " + R + " cost " + (System.currentTimeMillis() - currentTimeMillis));
            if (!(R <= 0 || this.mContextRef == null || this.mContextRef.get() == null)) {
                SecDataUIC.a aVar = SecDataUIC.CWq;
                com.tencent.mm.plugin.sns.j.j jVar2 = (com.tencent.mm.plugin.sns.j.j) SecDataUIC.a.c(this.mContextRef.get(), 2, com.tencent.mm.plugin.sns.j.j.class);
                if (jVar2 != null) {
                    jVar2.ecf = R;
                }
            }
            AppMethodBeat.o(96060);
            return R;
        } catch (Throwable th) {
            rawQuery.close();
            AppMethodBeat.o(96060);
            throw th;
        }
    }

    public final void a(e eVar) {
        if (eVar != null) {
            this.DPd.ContentObj.dME = eVar.jlg;
        }
    }

    public final void a(com.tencent.mm.modelsns.g gVar) {
        if (gVar != null) {
            this.DPd.ContentObj.Lpd = gVar.jlh;
        }
    }

    public final void a(com.tencent.mm.modelsns.f fVar) {
        if (fVar != null) {
            this.DPd.ContentObj.LoZ = fVar.jld;
        }
    }

    public final void a(com.tencent.mm.modelsns.d dVar) {
        if (dVar != null) {
            this.DPd.ContentObj.Lpc = dVar.jlf;
        }
    }

    @Deprecated
    public final boolean i(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(259442);
        cnb aP = aP("", str, str);
        if (aP == null) {
            Log.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
            AppMethodBeat.o(259442);
            return false;
        }
        aP.Desc = str2;
        if (i2 > 0 && i3 > 0) {
            cnd cnd = new cnd();
            cnd.Mtp = (float) i3;
            cnd.Mto = (float) i2;
            aP.MsB = cnd;
        }
        if (!Util.isNullOrNil(str3)) {
            aP.Title = str3;
        }
        if (!Util.isNullOrNil(str2)) {
            aP.Desc = str2;
        }
        this.DPd.ContentObj.LoV.add(aP);
        AppMethodBeat.o(259442);
        return true;
    }
}
