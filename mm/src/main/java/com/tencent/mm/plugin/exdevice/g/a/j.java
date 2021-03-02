package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.g.b.a.c;
import com.tencent.mm.plugin.exdevice.g.b.a.d;
import com.tencent.mm.plugin.exdevice.g.b.a.e;
import com.tencent.mm.plugin.exdevice.g.b.f;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.bxd;
import com.tencent.mm.protocal.protobuf.bxe;
import com.tencent.mm.protocal.protobuf.ffl;
import com.tencent.mm.protocal.protobuf.ffm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends com.tencent.mm.plugin.exdevice.b.a<bxd, bxe> {
    public String appName;
    public String msN;
    public boolean rCA;
    public String rCB;
    public String rCC;
    public com.tencent.mm.plugin.exdevice.g.b.a.a rCD;
    public ArrayList<d> rCE;
    public ArrayList<c> rCF;
    public ArrayList<e> rCG;
    public ArrayList<String> rCH;
    public String rCI;
    public String rCJ;
    public boolean rCK;
    public boolean rCL;
    public String rCM;
    private final WeakReference<b<j>> rCN;
    public a rCO;
    public String rCq;
    public boolean rCz;

    public interface a {
        void a(j jVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* bridge */ /* synthetic */ void i(bxd bxd) {
        bxd bxd2 = bxd;
        bxd2.rJH = this.appName;
        bxd2.ixr = this.rCB;
        bxd2.McV = this.rCA;
        bxd2.McW = this.rCC;
    }

    public j(String str, String str2, String str3, boolean z, b<j> bVar) {
        AppMethodBeat.i(23526);
        this.rCN = new WeakReference<>(bVar);
        this.rCI = str;
        this.rCB = str;
        this.appName = Util.nullAsNil(str2);
        this.rCA = z;
        this.rCC = str3;
        AppMethodBeat.o(23526);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1042;
    }

    @Override // com.tencent.mm.plugin.exdevice.b.a, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        com.tencent.mm.plugin.exdevice.g.b.a.a aVar;
        f fVar;
        e eVar;
        d dVar;
        String str2;
        c cVar;
        AppMethodBeat.i(23527);
        Log.d("MicroMsg.NetSceneGetRankInfo", "hy: get rank info end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            bxe bxe = (bxe) cgq();
            String str3 = "";
            this.rCF = new ArrayList<>();
            if (bxe.KHh != null) {
                Iterator<bes> it = bxe.KHh.iterator();
                while (it.hasNext()) {
                    bes next = it.next();
                    bg.aVF();
                    if (com.tencent.mm.model.c.aSN().bjG(next.username)) {
                        String str4 = bxe.ixr;
                        String str5 = this.appName;
                        if (Util.isNullOrNil(str4) || next == null) {
                            Log.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                            cVar = null;
                        } else {
                            c cVar2 = new c();
                            cVar2.field_rankID = str4;
                            cVar2.field_username = next.username;
                            cVar2.field_step = next.lCq;
                            cVar2.field_appusername = str5;
                            cVar = cVar2;
                        }
                        if (cVar != null) {
                            this.rCF.add(cVar);
                        }
                    } else {
                        bg.azz().a(new h(next.username, null), 0);
                    }
                }
            }
            this.rCE = new ArrayList<>();
            if (bxe.McX != null) {
                Iterator<ffl> it2 = bxe.McX.iterator();
                while (it2.hasNext()) {
                    ffl next2 = it2.next();
                    String str6 = bxe.ixr;
                    String str7 = this.appName;
                    if (Util.isNullOrNil(str6) || next2 == null) {
                        Log.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                        dVar = null;
                    } else {
                        dVar = new d();
                        dVar.field_appusername = str7;
                        dVar.field_rankID = str6;
                        dVar.field_likecount = next2.Lqb;
                        dVar.field_ranknum = next2.NAI;
                        dVar.field_score = next2.score;
                        dVar.field_selfLikeState = next2.NAJ;
                        dVar.field_username = next2.username;
                        dVar.field_sportRecord = next2.NAK;
                    }
                    if (dVar != null) {
                        if (dVar.field_ranknum == 1) {
                            str2 = dVar.field_username;
                        } else {
                            str2 = str3;
                        }
                        this.rCE.add(dVar);
                        str3 = str2;
                    }
                }
            }
            this.rCG = new ArrayList<>();
            if (bxe.McY != null) {
                Iterator<ffm> it3 = bxe.McY.iterator();
                while (it3.hasNext()) {
                    ffm next3 = it3.next();
                    String str8 = bxe.ixr;
                    String str9 = this.appName;
                    if (Util.isNullOrNil(str8) || next3 == null) {
                        Log.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                        eVar = null;
                    } else {
                        e eVar2 = new e();
                        eVar2.field_appusername = str9;
                        eVar2.field_rankID = str8;
                        eVar2.field_timestamp = next3.qwL;
                        eVar2.field_username = next3.username;
                        eVar = eVar2;
                    }
                    if (eVar != null) {
                        this.rCG.add(eVar);
                    }
                }
            }
            this.rCH = new ArrayList<>();
            if (bxe.McO != null) {
                Iterator<String> it4 = bxe.McO.iterator();
                while (it4.hasNext()) {
                    this.rCH.add(it4.next());
                }
            }
            if (!Util.isNullOrNil(this.rCC)) {
                str3 = this.rCC;
            }
            String str10 = bxe.McZ;
            String str11 = bxe.Mda;
            if (Util.isNullOrNil(str3)) {
                Log.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                aVar = null;
            } else {
                aVar = new com.tencent.mm.plugin.exdevice.g.b.a.a();
                aVar.field_username = str3;
                aVar.field_championUrl = str10;
                aVar.field_championMotto = str11;
            }
            this.rCD = aVar;
            this.rCI = bxe.ixr;
            this.msN = bxe.McQ;
            this.rCq = bxe.McP;
            this.rCJ = bxe.Mdb;
            this.rCK = bxe.rCK;
            this.rCL = bxe.Mde == 1;
            this.rCM = bxe.Mdf;
            this.rCz = bxe.McS;
            Log.d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
            if ((this.rCB == null || !this.rCB.equals(this.rCI)) && (fVar = ad.cKT().rCX) != null) {
                fVar.anC(this.rCI);
            }
            if (this.rCO != null && this.rCA) {
                this.rCO.a(this);
            }
            if (this.rCA) {
                ad.cKN().dn(this.rCF);
            }
            com.tencent.mm.plugin.exdevice.g.b.b.d cKM = ad.cKM();
            String str12 = this.rCI;
            if (Util.isNullOrNil(str12)) {
                Log.w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
            } else {
                Log.i("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId (%s).(r : %d)", str12, Integer.valueOf(cKM.db.delete("HardDeviceRankInfo", "rankID = ? ", new String[]{str12})));
            }
            ad.cKM().g(this.rCI, this.rCE);
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(this.rCK);
            objArr[1] = Integer.valueOf(this.rCF != null ? this.rCF.size() : 0);
            objArr[2] = Integer.valueOf(this.rCE != null ? this.rCE.size() : 0);
            objArr[3] = Integer.valueOf(this.rCG != null ? this.rCG.size() : 0);
            Log.i("MicroMsg.NetSceneGetRankInfo", "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).", objArr);
            ad.cKQ().b(this.rCI, this.appName, this.rCG);
            if (this.rCD != null) {
                ad.cKP().a(this.rCD);
            }
        }
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        b<j> bVar = this.rCN.get();
        if (bVar != null) {
            bVar.a(i3, i4, str, this);
        }
        AppMethodBeat.o(23527);
    }

    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/rank/getuserranklike";
    }

    /* Return type fixed from 'com.tencent.mm.bw.a' to match base method */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* synthetic */ bxe cKd() {
        AppMethodBeat.i(23528);
        bxe bxe = new bxe();
        AppMethodBeat.o(23528);
        return bxe;
    }

    /* Return type fixed from 'com.tencent.mm.bw.a' to match base method */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* synthetic */ bxd cKc() {
        AppMethodBeat.i(23529);
        bxd bxd = new bxd();
        AppMethodBeat.o(23529);
        return bxd;
    }
}
