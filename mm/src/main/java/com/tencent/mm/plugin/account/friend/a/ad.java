package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.protocal.protobuf.cpb;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.smtt.sdk.TbsListener;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ad extends q implements m {
    private i callback = null;
    private List<String> kbT;
    private List<String> kfn;
    public d rr;

    public ad() {
        AppMethodBeat.i(131105);
        bom();
        bqd bqd = (bqd) this.rr.iLK.iLR;
        bqd.MD5 = "";
        bqd.LXY = null;
        bqd.LXX = 0;
        bqd.LXW = null;
        bqd.LXV = 0;
        bqd.him = 0;
        bqd.Scene = 1;
        AppMethodBeat.o(131105);
    }

    public ad(List<String> list, List<String> list2) {
        AppMethodBeat.i(131106);
        bom();
        if ((list == null || list.size() == 0) && (list2 == null || list2.size() == 0)) {
            AppMethodBeat.o(131106);
            return;
        }
        this.kbT = list;
        this.kfn = list2;
        bqd bqd = (bqd) this.rr.iLK.iLR;
        bqd.MD5 = "";
        bqd.him = 2;
        bqd.Scene = 1;
        AppMethodBeat.o(131106);
    }

    private void bom() {
        AppMethodBeat.i(131107);
        d.a aVar = new d.a();
        aVar.iLN = new bqd();
        aVar.iLO = new bqe();
        aVar.uri = "/cgi-bin/micromsg-bin/getmfriend";
        aVar.funcId = TbsListener.ErrorCode.NEEDDOWNLOAD_3;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(131107);
    }

    public final void bon() {
        AppMethodBeat.i(131108);
        bqd bqd = (bqd) this.rr.iLK.iLR;
        bqd.MD5 = (String) g.aAh().azQ().get(65828, (Object) null);
        bqd.him = 1;
        AppMethodBeat.o(131108);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(131109);
        this.callback = iVar;
        bqd bqd = (bqd) this.rr.iLK.iLR;
        if (bqd.him == 2) {
            if ((this.kbT == null || this.kbT.size() == 0) && (this.kfn == null || this.kfn.size() == 0)) {
                Log.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
                AppMethodBeat.o(131109);
                return -1;
            }
            if (this.kbT != null && this.kbT.size() > 0) {
                Log.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", Integer.valueOf(this.kbT.size()));
                LinkedList<cpb> linkedList = new LinkedList<>();
                for (String str : this.kbT) {
                    cpb cpb = new cpb();
                    cpb.v = str;
                    linkedList.add(cpb);
                }
                bqd.LXW = linkedList;
                bqd.LXV = linkedList.size();
            }
            if (this.kfn != null && this.kfn.size() > 0) {
                Log.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", Integer.valueOf(this.kfn.size()));
                LinkedList<cko> linkedList2 = new LinkedList<>();
                for (String str2 : this.kfn) {
                    cko cko = new cko();
                    cko.v = str2;
                    linkedList2.add(cko);
                }
                bqd.LXY = linkedList2;
                bqd.LXX = linkedList2.size();
            }
        }
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(131109);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 32;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z;
        AppMethodBeat.i(131110);
        bqe bqe = (bqe) this.rr.iLL.iLR;
        bqd bqd = (bqd) this.rr.iLK.iLR;
        if (i3 == 4 && i4 == -68) {
            this.callback.onSceneEnd(i3, i4, bqe.getBaseResponse().ErrMsg.MTo, this);
            AppMethodBeat.o(131110);
        } else if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
            String nullAsNil = Util.nullAsNil((String) g.aAh().azQ().get(65828, (Object) null));
            if (bqd.him == 1 && !Util.isNullOrNil(bqe.MD5) && !bqe.MD5.equals(nullAsNil)) {
                g.aAh().azQ().set(65828, bqe.MD5);
                ((h) ((a) g.ah(a.class)).getFacebookFrdStg()).bnU();
            }
            if (bqe.xMV == null) {
                Log.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
                AppMethodBeat.o(131110);
                return;
            }
            Log.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", Integer.valueOf(bqe.xMV.size()));
            long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
            for (int i5 = 0; i5 < bqe.xMV.size(); i5++) {
                ckp ckp = bqe.xMV.get(i5);
                if (ckp == null) {
                    Log.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
                } else {
                    a SU = ((b) ((a) g.ah(a.class)).getAddrUploadStg()).SU(ckp.kdX);
                    if (SU != null || bqd.him == 1) {
                        com.tencent.mm.plugin.c.a.bqE().aTp().mP(ckp.Username, ckp.LRO);
                        g gVar = new g();
                        if (bqd.him == 1) {
                            if (ckp.MpZ == null) {
                                Log.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
                            } else {
                                gVar.fuC = ckp.MpZ.oIi;
                                gVar.kes = ckp.MpZ.Lul;
                                c.LX(new StringBuilder().append(ckp.MpZ.oIi).toString());
                                gVar.ker = ckp.MpZ.Name;
                                gVar.fMb = ckp.ked;
                                gVar.fuK = ckp.kea;
                                gVar.fuJ = ckp.kdZ;
                                gVar.signature = ckp.keb;
                                gVar.fuI = ckp.kec;
                                gVar.fuA = ckp.kdY;
                                gVar.nickName = ckp.Nickname;
                                gVar.kdR = f.Si(ckp.MpZ.Name);
                                gVar.kdS = f.Sh(ckp.MpZ.Name);
                                gVar.username = ckp.Username;
                            }
                        } else if (Util.isNullOrNil(ckp.Username)) {
                            Log.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
                        }
                        j jVar = new j();
                        jVar.username = ckp.Username;
                        jVar.fuJ = ckp.kdZ;
                        jVar.fuK = ckp.kea;
                        jVar.signature = ckp.keb;
                        jVar.fuA = ckp.kdY;
                        jVar.fuI = ckp.kec;
                        as asVar = null;
                        if (!Util.isNullOrNil(ckp.Username)) {
                            as Kn = ((l) g.af(l.class)).aSN().Kn(ckp.Username);
                            if (Kn == null || !ckp.Username.equals(Kn.field_username)) {
                                asVar = null;
                            } else if (Util.isNullOrNil(ckp.ked) || ckp.ked.equals(Kn.ajx())) {
                                asVar = Kn;
                            } else {
                                Kn.BC(ckp.ked);
                                ((l) g.af(l.class)).aSN().c(Kn.field_username, Kn);
                                asVar = Kn;
                            }
                        }
                        if (Util.isNullOrNil(ckp.Username)) {
                            if (bqd.him == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            Assert.assertTrue("mobile friend never go here", z);
                            gVar.status = 102;
                        } else if (asVar == null || !com.tencent.mm.contact.c.oR(asVar.field_type)) {
                            gVar.status = 100;
                            if (SU != null) {
                                SU.status = 1;
                                SU.username = ckp.Username;
                                SU.nickName = ckp.Nickname;
                                SU.kdR = f.Si(ckp.MpZ.Name);
                                SU.kdS = f.Sh(ckp.MpZ.Name);
                                SU.kdW = SU.aqN();
                                a(SU, ckp);
                                SU.cSx = -1;
                                ((b) ((a) g.ah(a.class)).getAddrUploadStg()).a(SU.getMd5(), SU);
                                com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
                                iVar.username = ckp.Username;
                                iVar.iKX = ckp.Lir;
                                iVar.iKW = ckp.Lis;
                                iVar.fv(true);
                                iVar.fuz = 3;
                                p.aYB().b(iVar);
                            }
                        } else {
                            gVar.status = 101;
                            if (SU != null) {
                                SU.status = 2;
                                SU.username = ckp.Username;
                                SU.nickName = ckp.Nickname;
                                SU.kdW = SU.aqN();
                                a(SU, ckp);
                                SU.cSx = -1;
                                ((b) ((a) g.ah(a.class)).getAddrUploadStg()).a(SU.getMd5(), SU);
                                c.ap(ckp.Username, 3);
                            }
                        }
                        if (bqd.him == 1) {
                            ((h) ((a) g.ah(a.class)).getFacebookFrdStg()).a(gVar);
                        }
                        ((k) ((a) g.ah(a.class)).getFrdExtStg()).a(jVar);
                    } else {
                        Log.e("MicroMsg.NetSceneGetMFriend", "Err MD5 %s not found in AddrUploadStg, md5: ", ckp.kdX);
                    }
                }
            }
            g.aAh().hqK.endTransaction(beginTransaction);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(131110);
        } else {
            Log.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(131110);
        }
    }

    private static void a(a aVar, ckp ckp) {
        aVar.kdX = ckp.kdX;
        aVar.kdY = ckp.kdY;
        aVar.kdZ = ckp.kdZ;
        aVar.kea = ckp.kea;
        aVar.keb = ckp.keb;
        aVar.kec = ckp.kec;
        aVar.ked = ckp.ked;
        aVar.kee = ckp.kee;
        aVar.keg = ckp.keg;
        aVar.kef = ckp.kef;
        aVar.keh = ckp.keh;
        aVar.kei = ckp.kei;
        ebj ebj = ckp.MmQ;
        if (ebj != null) {
            aVar.kej = ebj.kej;
            aVar.kek = ebj.kek;
            aVar.kel = ebj.kel;
        }
        aeq aeq = ckp.MmR;
        if (aeq != null) {
            aVar.kem = aeq.kem;
            aVar.ken = aeq.ken;
            aVar.keo = aeq.keo;
            aVar.kep = aeq.kep;
        }
    }
}
