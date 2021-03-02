package com.tencent.mm.plugin.account.friend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bte;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.dgk;
import com.tencent.mm.protocal.protobuf.dgm;
import com.tencent.mm.protocal.protobuf.dgn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashMap;

public final class af extends q implements m {
    private i callback = null;
    public final d rr;

    public af(int i2) {
        AppMethodBeat.i(131111);
        d.a aVar = new d.a();
        aVar.iLN = new bte();
        aVar.iLO = new btf();
        aVar.uri = "/cgi-bin/micromsg-bin/getqqgroup";
        aVar.funcId = TbsListener.ErrorCode.NEEDDOWNLOAD_4;
        aVar.iLP = 38;
        aVar.respCmdId = 1000000038;
        this.rr = aVar.aXF();
        bte bte = (bte) this.rr.iLK.iLR;
        bte.him = 1;
        bte.LPy = i2;
        AppMethodBeat.o(131111);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(131112);
        this.callback = iVar;
        bte bte = (bte) this.rr.iLK.iLR;
        if (bte.him == 1 && ((ar) ((a) com.tencent.mm.kernel.g.ah(a.class)).getQQGroupStg()).vi(bte.LPy) == null) {
            Log.e("MicroMsg.NetSceneGetQQGroup", "Err group not exist");
            AppMethodBeat.o(131112);
            return -1;
        }
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(131112);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.NEEDDOWNLOAD_4;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z;
        as asVar;
        AppMethodBeat.i(131113);
        if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
            bte bte = (bte) this.rr.iLK.iLR;
            btf btf = (btf) this.rr.iLL.iLR;
            if (bte.him == 0) {
                a(btf.LZP);
            } else {
                ArrayList<as> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (int i5 = 0; i5 < btf.LZQ.oTz; i5++) {
                    dgk dgk = btf.LZQ.MLd.get(i5);
                    int i6 = bte.LPy;
                    Log.v("MicroMsg.NetSceneGetQQGroup", "friend");
                    as asVar2 = new as();
                    asVar2.kfN = new p(dgk.MKZ).longValue();
                    c.e(asVar2.kfN, 3);
                    asVar2.kfP = i6;
                    asVar2.kfO = dgk.MLb;
                    if (dgk.MLb != 0) {
                        if (dgk.UserName == null || dgk.UserName.equals("")) {
                            asVar = null;
                            arrayList.add(asVar);
                            j jVar = new j();
                            jVar.fuA = dgk.kdY;
                            jVar.fuI = dgk.kec;
                            jVar.fuJ = dgk.kdZ;
                            jVar.fuK = dgk.kea;
                            jVar.signature = dgk.keb;
                            jVar.username = dgk.UserName;
                            arrayList2.add(jVar);
                            com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
                            iVar.fuz = 3;
                            iVar.fv(true);
                            iVar.username = dgk.UserName;
                            iVar.iKX = dgk.Lir;
                            iVar.iKW = dgk.Lis;
                            arrayList3.add(iVar);
                        } else {
                            as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(dgk.UserName);
                            if (Kn == null || !Kn.field_username.equals(dgk.UserName) || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                                asVar2.kfO = 1;
                            } else {
                                asVar2.kfO = 2;
                            }
                        }
                    }
                    asVar2.username = dgk.UserName;
                    asVar2.nickname = dgk.oUJ;
                    asVar2.kfV = dgk.MLc;
                    asVar2.kfW = f.Si(dgk.MLc);
                    asVar2.kfX = f.Sh(dgk.MLc);
                    asVar2.kfQ = f.Si(dgk.oUJ);
                    asVar2.kfR = f.Sh(dgk.oUJ);
                    asVar2.kfS = dgk.MLa;
                    asVar2.kfT = f.Si(dgk.MLa);
                    asVar2.kfU = f.Sh(dgk.MLa);
                    char c2 = ' ';
                    if (!Util.isNullOrNil(asVar2.boA())) {
                        c2 = asVar2.boA().charAt(0);
                    } else if (!Util.isNullOrNil(asVar2.boB())) {
                        c2 = asVar2.boB().charAt(0);
                    } else if (!Util.isNullOrNil(asVar2.box())) {
                        c2 = asVar2.box().charAt(0);
                    } else if (!Util.isNullOrNil(asVar2.boy())) {
                        c2 = asVar2.boy().charAt(0);
                    }
                    if (c2 >= 'a' && c2 <= 'z') {
                        c2 = (char) (c2 - ' ');
                    } else if (c2 < 'A' || c2 > 'Z') {
                        c2 = '{';
                    }
                    asVar2.iKT = c2;
                    com.tencent.mm.plugin.c.a.bqE().aTp().mP(dgk.UserName, dgk.LRO);
                    Log.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + asVar2.bow() + "  remark: " + asVar2.boz());
                    asVar = asVar2;
                    arrayList.add(asVar);
                    j jVar2 = new j();
                    jVar2.fuA = dgk.kdY;
                    jVar2.fuI = dgk.kec;
                    jVar2.fuJ = dgk.kdZ;
                    jVar2.fuK = dgk.kea;
                    jVar2.signature = dgk.keb;
                    jVar2.username = dgk.UserName;
                    arrayList2.add(jVar2);
                    com.tencent.mm.aj.i iVar2 = new com.tencent.mm.aj.i();
                    iVar2.fuz = 3;
                    iVar2.fv(true);
                    iVar2.username = dgk.UserName;
                    iVar2.iKX = dgk.Lir;
                    iVar2.iKW = dgk.Lis;
                    arrayList3.add(iVar2);
                }
                HashMap hashMap = new HashMap();
                int i7 = bte.LPy;
                Log.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:".concat(String.valueOf(i7)));
                Cursor rawQuery = ((at) ((a) com.tencent.mm.kernel.g.ah(a.class)).getQQListStg()).iFy.rawQuery("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + i7 + "\"", null);
                while (rawQuery.moveToNext()) {
                    as asVar3 = new as();
                    asVar3.convertFrom(rawQuery);
                    hashMap.put(Long.valueOf(asVar3.kfN), asVar3);
                }
                rawQuery.close();
                for (as asVar4 : arrayList) {
                    if (hashMap.containsKey(Long.valueOf(asVar4.kfN))) {
                        as asVar5 = (as) hashMap.get(Long.valueOf(asVar4.kfN));
                        if (!Util.compare(Long.valueOf(asVar5.kfN), Long.valueOf(asVar4.kfN))) {
                            z = false;
                        } else if (!Util.compare(Integer.valueOf(asVar5.kfO), Integer.valueOf(asVar4.kfO))) {
                            z = false;
                        } else if (!Util.compare(Integer.valueOf(asVar5.kfP), Integer.valueOf(asVar4.kfP))) {
                            z = false;
                        } else if (!Util.compare(asVar5.username, asVar4.username)) {
                            z = false;
                        } else if (!Util.compare(asVar5.nickname, asVar4.nickname)) {
                            z = false;
                        } else if (!Util.compare(asVar5.kfQ, asVar4.kfQ)) {
                            z = false;
                        } else if (!Util.compare(asVar5.kfR, asVar4.kfR)) {
                            z = false;
                        } else if (!Util.compare(asVar5.kfS, asVar4.kfS)) {
                            z = false;
                        } else if (!Util.compare(asVar5.kfT, asVar4.kfT)) {
                            z = false;
                        } else if (!Util.compare(asVar5.kfU, asVar4.kfU)) {
                            z = false;
                        } else if (!Util.compare(asVar5.kfV, asVar4.kfV)) {
                            z = false;
                        } else if (!Util.compare(asVar5.kfW, asVar4.kfW)) {
                            z = false;
                        } else if (!Util.compare(asVar5.kfX, asVar4.kfX)) {
                            z = false;
                        } else if (!Util.compare(asVar5.iKR, asVar4.iKR)) {
                            z = false;
                        } else if (!Util.compare(asVar5.iKS, asVar4.iKS)) {
                            z = false;
                        } else if (!Util.compare(Integer.valueOf(asVar5.iKT), Integer.valueOf(asVar4.iKT))) {
                            z = false;
                        } else if (!Util.compare(Integer.valueOf(asVar5.iKU), Integer.valueOf(asVar4.iKU))) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            ((at) ((a) com.tencent.mm.kernel.g.ah(a.class)).getQQListStg()).a(asVar4.kfN, asVar4);
                            hashMap.remove(Long.valueOf(asVar4.kfN));
                        }
                    } else {
                        ((at) ((a) com.tencent.mm.kernel.g.ah(a.class)).getQQListStg()).a(asVar4);
                    }
                }
                for (Long l : hashMap.keySet()) {
                    long longValue = l.longValue();
                    at atVar = (at) ((a) com.tencent.mm.kernel.g.ah(a.class)).getQQListStg();
                    Log.d("MicroMsg.QQListStorage", "delete: QQ:".concat(String.valueOf(longValue)));
                    if (atVar.iFy.delete("qqlist", "qq= ?", new String[]{String.valueOf(longValue)}) > 0) {
                        atVar.doNotify(5, atVar, String.valueOf(longValue));
                    }
                }
                ((k) ((a) com.tencent.mm.kernel.g.ah(a.class)).getFrdExtStg()).av(arrayList2);
                com.tencent.mm.aj.p.aYB().av(arrayList3);
                aq aqVar = new aq();
                aqVar.kfF = bte.LPy;
                aqVar.kfK = 0;
                aqVar.kfJ = (int) Util.nowSecond();
                aqVar.cSx = 48;
                ((ar) ((a) com.tencent.mm.kernel.g.ah(a.class)).getQQGroupStg()).a(aqVar);
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(131113);
            return;
        }
        Log.e("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(131113);
    }

    private static void a(dgn dgn) {
        HashMap hashMap;
        boolean z;
        aq aqVar;
        boolean z2;
        AppMethodBeat.i(131114);
        Cursor rawQuery = ((ar) ((a) com.tencent.mm.kernel.g.ah(a.class)).getQQGroupStg()).iFy.rawQuery("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null);
        if (rawQuery == null) {
            hashMap = null;
        } else if (rawQuery.getCount() <= 0) {
            rawQuery.close();
            hashMap = null;
        } else {
            hashMap = new HashMap();
            for (int i2 = 0; i2 < rawQuery.getCount(); i2++) {
                rawQuery.moveToPosition(i2);
                aq aqVar2 = new aq();
                aqVar2.convertFrom(rawQuery);
                hashMap.put(Integer.valueOf(aqVar2.kfF), aqVar2);
            }
            rawQuery.close();
        }
        for (int i3 = 0; i3 < dgn.oTz; i3++) {
            dgm dgm = dgn.MLf.get(i3);
            Log.d("MicroMsg.NetSceneGetQQGroup", "id:" + dgm.LPy + " name:" + dgm.LPg + " mem:" + dgm.Ltc + " wei:" + dgm.MLe + " md5:" + dgm.MD5);
            if (dgm.LPy < 0) {
                aqVar = null;
            } else {
                aqVar = new aq();
                aqVar.kfF = dgm.LPy;
                aqVar.kfM = dgm.LPg;
                aqVar.kfG = dgm.Ltc;
                aqVar.kfH = dgm.MLe;
                aqVar.kfL = dgm.MD5;
            }
            if (aqVar == null) {
                Log.e("MicroMsg.NetSceneGetQQGroup", "Error Resp Group Info index:".concat(String.valueOf(i3)));
            } else if (aqVar.kfG != 0) {
                aq aqVar3 = hashMap != null ? (aq) hashMap.get(Integer.valueOf(aqVar.kfF)) : null;
                if (aqVar3 == null) {
                    aqVar.kfI = (int) Util.nowSecond();
                    aqVar.kfJ = (int) Util.nowSecond();
                    aqVar.kfK = 1;
                    ar arVar = (ar) ((a) com.tencent.mm.kernel.g.ah(a.class)).getQQGroupStg();
                    if (aqVar != null) {
                        Log.d("MicroMsg.QQGroupStorage", "insert: name:" + aqVar.bou());
                        aqVar.cSx = -1;
                        if (((int) arVar.iFy.insert("qqgroup", "grouopid", aqVar.bos())) >= 0) {
                            arVar.doNotify();
                            z2 = true;
                            Log.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + aqVar.bou() + " ret:" + z2);
                        }
                    }
                    z2 = false;
                    Log.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + aqVar.bou() + " ret:" + z2);
                } else {
                    aqVar3.kfK = -1;
                    Log.d("MicroMsg.NetSceneGetQQGroup", aqVar.bot() + " " + aqVar3.bot() + " " + aqVar.kfF);
                    if (!aqVar3.bot().equals(aqVar.bot())) {
                        aqVar.kfJ = (int) Util.nowSecond();
                        aqVar.kfK = 1;
                        aqVar.cSx = -1;
                        Log.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + aqVar.bou() + " ret:" + ((ar) ((a) com.tencent.mm.kernel.g.ah(a.class)).getQQGroupStg()).a(aqVar));
                    }
                }
            }
        }
        if (hashMap != null) {
            for (Object obj : hashMap.keySet()) {
                aq aqVar4 = (aq) hashMap.get(obj);
                if (aqVar4.kfK == 0) {
                    ar arVar2 = (ar) ((a) com.tencent.mm.kernel.g.ah(a.class)).getQQGroupStg();
                    int i4 = aqVar4.kfF;
                    Log.d("MicroMsg.QQGroupStorage", "delete: id:".concat(String.valueOf(i4)));
                    if (arVar2.iFy.delete("qqgroup", "grouopid= ?", new String[]{String.valueOf(i4)}) > 0) {
                        arVar2.doNotify();
                        z = true;
                    } else {
                        z = false;
                    }
                    Log.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + aqVar4.bou() + " ret:" + z);
                    int i5 = aqVar4.kfF;
                    Log.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i5)));
                    Log.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + aqVar4.bou() + " ret:" + (((at) ((a) com.tencent.mm.kernel.g.ah(a.class)).getQQListStg()).iFy.delete("qqlist", "groupid= ?", new String[]{String.valueOf(i5)}) > 0));
                }
            }
        }
        AppMethodBeat.o(131114);
    }
}
