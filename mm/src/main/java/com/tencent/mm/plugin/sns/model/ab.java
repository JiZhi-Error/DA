package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.gk;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.ebk;
import com.tencent.mm.protocal.protobuf.ebl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Vector;

public final class ab extends q implements m, b {
    private static Vector<String> DJt = new Vector<>();
    private String DIL = "";
    private boolean DIe;
    private long DIf = 0;
    long DIg = 0;
    public int DIi = 0;
    private boolean DJA = false;
    public long DJB;
    public int DJC = -1;
    public int DJD = 0;
    private long DJd = 0;
    private boolean DJg = false;
    private int DJu = 0;
    private boolean DJv = false;
    private String DJw = "";
    public long DJx = 0;
    private boolean DJy = false;
    private boolean DJz = false;
    public i callback;
    private boolean dJM;
    private d rr;
    private int sourceType;
    String userName;

    static {
        AppMethodBeat.i(95688);
        AppMethodBeat.o(95688);
    }

    public static synchronized boolean aPd(String str) {
        boolean z;
        synchronized (ab.class) {
            AppMethodBeat.i(95681);
            if (DJt.contains(str)) {
                z = false;
                AppMethodBeat.o(95681);
            } else {
                DJt.add(str);
                z = true;
                AppMethodBeat.o(95681);
            }
        }
        return z;
    }

    public static synchronized boolean aPe(String str) {
        synchronized (ab.class) {
            AppMethodBeat.i(95682);
            DJt.remove(str);
            AppMethodBeat.o(95682);
        }
        return true;
    }

    public ab(String str, long j2, boolean z, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(160650);
        this.userName = str;
        this.DIf = j2;
        this.dJM = z;
        this.DJC = i3;
        if (j2 == 0) {
            Log.i("MicroMsg.NetSceneSnsUserPage", "fp userName ".concat(String.valueOf(str)));
        } else {
            Log.i("MicroMsg.NetSceneSnsUserPage", "np userName ".concat(String.valueOf(str)));
        }
        this.sourceType = i5;
        this.DJD = i6;
        d.a aVar = new d.a();
        aVar.iLN = new ebk();
        aVar.iLO = new ebl();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
        aVar.funcId = 212;
        aVar.iLP = 99;
        aVar.respCmdId = 1000000099;
        this.rr = aVar.aXF();
        ebk ebk = (ebk) this.rr.iLK.iLR;
        ebk.Username = str;
        ebk.MZh = j2;
        ebk.Nbe = i4;
        this.DIe = j2 == 0;
        if (i3 == ax.DOe || i3 == ax.DOf || i3 == ax.DOd) {
            ebk.Nau = 0;
            ebk.xub = i2;
            if (i3 == ax.DOe) {
                ebk.NaA = 1;
            }
            this.sourceType = 16;
            Log.i("MicroMsg.NetSceneSnsUserPage", "maxId:%s, minId:%s, snsSource:%s, pullType:%s", r.Jb(j2), r.Jb(this.DIg), Integer.valueOf(i2), Integer.valueOf(ebk.NaA));
        } else {
            int aPn = aj.faE().aPn(str);
            this.DIg = aj.faO().b(this.DIe ? 0 : j2, aPn, str, z);
            ebk.Nau = this.DIg;
            int a2 = d.a(this.DIg, j2, str);
            ebk.Nav = a2;
            ebk.xub = i2;
            if (this.DIe) {
                if (fam()) {
                    this.DIL = aj.faS().aQr(str).field_albumMd5;
                } else {
                    this.DIL = aj.faS().aQr(str).field_md5;
                }
                if (this.DIL == null) {
                    this.DIL = "";
                }
                ebk.MZg = this.DIL;
            }
            Log.i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + aPn + " maxId:" + r.Jb(j2) + " minId:" + r.Jb(this.DIg) + " lastReqTime:" + a2 + " snsSource " + i2);
        }
        this.DJd = j2;
        AppMethodBeat.o(160650);
    }

    private void iu(int i2, int i3) {
        AppMethodBeat.i(95684);
        n faO = aj.faO();
        String str = this.userName;
        boolean z = this.dJM;
        StringBuilder sb = new StringBuilder();
        sb.append("select snsId from SnsInfo ").append(n.cn(str, z)).append(" AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26,28,29,30 , 34,43,38,33,37,36,39,41,42) and  (snsId != 0  )  limit 4");
        Cursor rawQuery = faO.iFy.rawQuery(sb.toString(), null);
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count > 3 || count <= 0 || i2 != 0 || i3 != 0) {
            if (count == 0) {
                this.DJy = true;
            }
            AppMethodBeat.o(95684);
            return;
        }
        this.DJg = true;
        AppMethodBeat.o(95684);
    }

    private void a(ebl ebl, String str) {
        AppMethodBeat.i(95685);
        an.a(this.userName, this.sourceType, ebl.KOH, str);
        if (this.DIf == 0) {
            this.DIf = ebl.KOH.getFirst().Id;
        } else {
            this.DIf = d.Jf(this.DIf);
        }
        this.DIg = ebl.KOH.getLast().Id;
        Log.i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", this.userName, Long.valueOf(this.DIf), Long.valueOf(this.DIg), Integer.valueOf(ebl.NaG));
        d.f(this.userName, this.DIf, this.DIg, ebl.NaG);
        AppMethodBeat.o(95685);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(95686);
        Log.i("MicroMsg.NetSceneSnsUserPage", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        ebl ebl = (ebl) ((d) sVar).iLL.iLR;
        if (this.DJC == -1) {
            if (this.rr.iLL.getRetCode() == 207 || this.rr.iLL.getRetCode() == 203 || this.rr.iLL.getRetCode() == 0 || this.rr.iLL.getRetCode() == 2001 || this.rr.iLL.getRetCode() == 2004 || this.rr.iLL.getRetCode() == 2005 || this.rr.iLL.getRetCode() == 2003) {
                if (this.rr.iLL.getRetCode() == 2003) {
                    n faO = aj.faO();
                    String str2 = this.userName;
                    Log.printInfoStack("MicroMsg.SnsInfoStorage", "deleteByUserName userName:%s", str2);
                    boolean execSQL = faO.iFy.execSQL(gk.TABLE_NAME, "DELETE FROM SnsInfo" + " where SnsInfo.userName=\"" + Util.escapeSqlValue(str2) + "\"");
                    Log.d("MicroMsg.SnsInfoStorage", "del snsinfo " + str2 + " res " + execSQL);
                    Boolean.valueOf(execSQL);
                }
                this.DJw = ebl.Nbi;
                this.DIi = ebl.MZk;
                Log.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + ebl.MZk + " , objCount:  " + ebl.MvM + ", retTips:" + this.DJw);
                this.DJB = ebl.Nbg;
                String Jc = r.Jc(this.DIf);
                if (!this.DIe) {
                    Log.d("MicroMsg.NetSceneSnsUserPage", "np  " + ebl.KOH.size());
                    if (ebl.KOH.isEmpty()) {
                        this.DJA = this.rr.iLL.getRetCode() == 203;
                        aj.faO().f(this.userName, this.dJM, Jc);
                        this.DJy = true;
                        this.DIg = this.DIf;
                    } else {
                        a(ebl, Jc);
                    }
                    aPe(this.userName);
                    this.callback.onSceneEnd(i3, i4, str, this);
                    AppMethodBeat.o(95686);
                    return;
                }
                aj.faS().D(this.userName, ebl.MZG);
                if (this.DIL.equals(ebl.MZg)) {
                    this.DIg = aj.faO().b(this.DIe ? 0 : this.DJd, this.DIi, this.userName, this.dJM);
                    Log.i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", Long.valueOf(this.DIg));
                    iu(i3, i4);
                    aPe(this.userName);
                    l aQr = aj.faS().aQr(this.userName);
                    this.callback.onSceneEnd(aQr.field_lastFirstPageRequestErrType, aQr.field_lastFirstPageRequestErrCode, str, this);
                    AppMethodBeat.o(95686);
                    return;
                }
                Log.i("MicroMsg.NetSceneSnsUserPage", "fp  " + ebl.KOH.size());
                if (this.DIe && !this.DIL.equals(ebl.MZg)) {
                    this.DJu = ebl.Nbf;
                    l aQr2 = aj.faS().aQr(this.userName);
                    aQr2.field_icount = this.DJu;
                    ebj ebj = ebl.MmQ;
                    if (ebj != null) {
                        String Jb = r.Jb(ebj.kel);
                        String accSnsPath = aj.getAccSnsPath();
                        String str3 = this.userName + "bg_";
                        String str4 = this.userName + "tbg_";
                        if (aQr2.field_bgUrl == null || !aQr2.field_bgId.equals(Jb)) {
                            aQr2.field_older_bgId = aQr2.field_bgId;
                            if (com.tencent.mm.vfs.s.YS(ar.ki(accSnsPath, this.userName) + str3)) {
                                com.tencent.mm.vfs.s.deleteFile(ar.ki(accSnsPath, this.userName) + str4);
                                com.tencent.mm.vfs.s.bo(ar.ki(accSnsPath, this.userName), str3, str4);
                            }
                            this.DJv = true;
                            aQr2.feI();
                            Log.d("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + ebj.kek);
                        }
                        aQr2.field_bgId = Jb;
                        aQr2.field_bgUrl = ebj.kek;
                        aQr2.field_snsBgId = ebj.kel;
                    }
                    aj.faS().a(aQr2);
                }
                if (fam()) {
                    aj.faS().p(this.userName, ebl.MZg, i3, i4);
                } else {
                    aj.faS().o(this.userName, ebl.MZg, i3, i4);
                }
                if (this.rr.iLL.getRetCode() == 207 || this.rr.iLL.getRetCode() == 2001 || this.rr.iLL.getRetCode() == 2004 || this.rr.iLL.getRetCode() == 2005) {
                    aj.faS().kK(this.userName, "");
                    if (ebl.KOH.isEmpty()) {
                        n faO2 = aj.faO();
                        String str5 = this.userName;
                        boolean z = this.dJM;
                        faO2.F(z, n.cn(str5, z) + " AND  (snsId != 0  ) ");
                        this.DIg = this.DIf;
                    } else {
                        n faO3 = aj.faO();
                        String str6 = this.userName;
                        boolean z2 = this.dJM;
                        String Jc2 = r.Jc(ebl.KOH.getFirst().Id);
                        String str7 = n.cn(str6, z2) + " AND  (snsId != 0  ) ";
                        if (n.aQw(Jc2)) {
                            str7 = str7 + " AND " + faO3.aQz(Jc2);
                        }
                        faO3.F(z2, str7);
                        aj.faO().f(this.userName, this.dJM, r.Jc(ebl.KOH.getLast().Id));
                        a(ebl, Jc);
                    }
                    iu(i3, i4);
                    aPe(this.userName);
                    this.callback.onSceneEnd(i3, i4, str, this);
                    AppMethodBeat.o(95686);
                } else if (ebl.KOH.size() == 0) {
                    Log.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
                    this.callback.onSceneEnd(i3, i4, str, this);
                    AppMethodBeat.o(95686);
                } else {
                    a(ebl, Jc);
                    aPe(this.userName);
                    this.callback.onSceneEnd(i3, i4, str, this);
                    AppMethodBeat.o(95686);
                }
            } else {
                aPe(this.userName);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(95686);
            }
        } else if (this.rr.iLL.getRetCode() == 207 || this.rr.iLL.getRetCode() == 203 || this.rr.iLL.getRetCode() == 0 || this.rr.iLL.getRetCode() == 2001 || this.rr.iLL.getRetCode() == 2004 || this.rr.iLL.getRetCode() == 2005 || this.rr.iLL.getRetCode() == 2003) {
            this.DJw = ebl.Nbi;
            this.DIi = ebl.MZk;
            Log.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + ebl.MZk + " , objCount:  " + ebl.MvM + ", retTips:" + this.DJw + ", prePageDayEndFlag:" + ebl.Nbj);
            this.DJB = ebl.Nbg;
            Log.d("MicroMsg.NetSceneSnsUserPage", "do search  " + ebl.KOH.size());
            if (ebl.KOH.size() == 0) {
                Log.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
                this.DJA = this.rr.iLL.getRetCode() == 203;
                if (this.DJC == ax.DOe) {
                    this.DJz = true;
                } else {
                    this.DJy = true;
                }
                aPe(this.userName);
                this.callback.onSceneEnd(i3, i4, str, this);
                this.DIg = this.DIf;
                AppMethodBeat.o(95686);
                return;
            }
            if (this.DJC == ax.DOe) {
                if (ebl.Nbj) {
                    this.DJx = ebl.KOH.getFirst().Id;
                }
            } else if (this.DJC == ax.DOd) {
                this.DJx = ebl.KOH.getFirst().Id;
            }
            an.a(this.userName, this.sourceType, ebl.KOH, r.Jc(ebl.KOH.getFirst().Id));
            an.j(ebl.KOH, this.DJC);
            Log.i("MicroMsg.NetSceneSnsUserPage", "insertSearchCacheList userName:%s maxId:%s minId:%s NewRequestTime:%s", this.userName, Long.valueOf(an.DIf), Long.valueOf(an.DIg), Integer.valueOf(ebl.NaG));
            aPe(this.userName);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(95686);
        } else {
            aPe(this.userName);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(95686);
        }
    }

    private boolean fam() {
        return this.sourceType == 64;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 212;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(95687);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95687);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.sns.b.b
    public final long eZd() {
        return this.DIg;
    }

    @Override // com.tencent.mm.plugin.sns.b.b
    public final String getUserName() {
        return this.userName;
    }

    @Override // com.tencent.mm.plugin.sns.b.b
    public final boolean eYW() {
        return this.DIe;
    }

    @Override // com.tencent.mm.plugin.sns.b.b
    public final boolean eYX() {
        return this.DJC == ax.DOd || this.DJC == ax.DOf || this.DJC == ax.DOe;
    }

    @Override // com.tencent.mm.plugin.sns.b.b
    public final int eYY() {
        return this.DJC;
    }

    @Override // com.tencent.mm.plugin.sns.b.b
    public final boolean eZa() {
        return this.DJy;
    }

    @Override // com.tencent.mm.plugin.sns.b.b
    public final boolean eYZ() {
        return this.DJz;
    }

    @Override // com.tencent.mm.plugin.sns.b.b
    public final boolean eZe() {
        return this.DJv;
    }

    @Override // com.tencent.mm.plugin.sns.b.b
    public final boolean eZc() {
        return this.DJA;
    }

    @Override // com.tencent.mm.plugin.sns.b.b
    public final boolean eZb() {
        return this.DJg;
    }

    @Override // com.tencent.mm.plugin.sns.b.b
    public final long eZf() {
        return this.DJB;
    }

    @Override // com.tencent.mm.plugin.sns.b.b
    public final String eZg() {
        return this.DJw;
    }

    @Override // com.tencent.mm.plugin.sns.b.b
    public final boolean eZh() {
        return false;
    }
}
