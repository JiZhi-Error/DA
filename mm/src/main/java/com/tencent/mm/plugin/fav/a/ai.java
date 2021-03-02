package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.ko;
import com.tencent.mm.protocal.protobuf.kp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public final class ai extends q implements m {
    private static AtomicInteger tbp = new AtomicInteger(0);
    private i callback = null;
    private final d rr;
    private LinkedList<Integer> tbl;
    private int tbm = 0;
    private boolean tbn = false;
    private boolean tbo = false;

    static {
        AppMethodBeat.i(103470);
        AppMethodBeat.o(103470);
    }

    public ai(LinkedList<Integer> linkedList) {
        AppMethodBeat.i(103463);
        d.a aVar = new d.a();
        aVar.iLN = new ko();
        aVar.iLO = new kp();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
        aVar.funcId = 402;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.tbl = linkedList;
        tbp.incrementAndGet();
        AppMethodBeat.o(103463);
    }

    public static void cVb() {
        AppMethodBeat.i(103464);
        tbp.set(0);
        AppMethodBeat.o(103464);
    }

    public static void cVc() {
        AppMethodBeat.i(103465);
        tbp.decrementAndGet();
        AppMethodBeat.o(103465);
    }

    public static int cVd() {
        AppMethodBeat.i(103466);
        int i2 = tbp.get();
        AppMethodBeat.o(103466);
        return i2;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(103467);
        Log.i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", Integer.valueOf(tbp.get()));
        if (this.tbl == null || this.tbl.isEmpty() || this.tbm >= this.tbl.size()) {
            Log.e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", Integer.valueOf(this.tbm));
            AppMethodBeat.o(103467);
            return -1;
        }
        Log.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", Integer.valueOf(this.tbl.size()), Integer.valueOf(this.tbm), this.tbl);
        if (Util.nullAsNil((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(8217, (Object) null)) == 0) {
            Log.w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
            AppMethodBeat.o(103467);
            return -1;
        }
        ko koVar = (ko) this.rr.iLK.iLR;
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(this.tbl.subList(this.tbm, Math.min(this.tbm + 15, this.tbl.size())));
        koVar.KOn = linkedList;
        koVar.oTz = linkedList.size();
        this.tbm += 15;
        Log.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene checkd size %d, %s", Integer.valueOf(linkedList.size()), linkedList);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(103467);
        return dispatch;
    }

    private boolean cVa() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(103468);
        if (Util.nullAsNil((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(8217, (Object) null)) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.tbl == null || this.tbm >= this.tbl.size()) {
            z2 = false;
        } else {
            z2 = true;
        }
        Log.i("MicroMsg.NetSceneBatchgetFav", "check needContinue, notInit %B indexOK %B", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z || !z2) {
            AppMethodBeat.o(103468);
            return false;
        }
        AppMethodBeat.o(103468);
        return true;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(103469);
        Log.i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(this.tbm), Integer.valueOf(this.tbl.size()), str);
        if (i3 == 0 && i4 == 0) {
            kp kpVar = (kp) ((d) sVar).iLL.iLR;
            int i5 = kpVar.oTz;
            int size = kpVar.KOH.size();
            if (i5 != size) {
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(size);
                objArr[1] = Integer.valueOf(i5);
                objArr[2] = Integer.valueOf(this.tbm > this.tbl.size() ? this.tbl.size() % 15 : 15);
                Log.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet resp list size:%d, return count %d, request count %d", objArr);
                if (cVa()) {
                    doScene(dispatcher(), this.callback);
                    AppMethodBeat.o(103469);
                    return;
                }
                tbp.decrementAndGet();
                this.callback.onSceneEnd(i3, -1, str, this);
                AppMethodBeat.o(103469);
                return;
            }
            for (int i6 = 0; i6 < size; i6++) {
                amw amw = kpVar.KOH.get(i6);
                Log.i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", Integer.valueOf(amw.KGZ), Integer.valueOf(amw.oTW));
                if (amw.oTW == 0) {
                    g DZ = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ((long) amw.KGZ);
                    if (DZ == null) {
                        Log.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", Integer.valueOf(amw.KGZ));
                    } else {
                        DZ.field_xml = amw.KHf;
                        DZ.arQ(amw.KHf);
                        DZ.field_flag = amw.KHa;
                        DZ.field_localSeq = amw.KHc;
                        DZ.field_updateTime = (((long) amw.KHb) * 1000) + ((long) i6);
                        Log.i("MicroMsg.NetSceneBatchgetFav", "huahuahailang:item field_xml batgch get :\n %s", DZ.field_xml);
                        int size2 = DZ.field_favProto.ppH.size();
                        if (size2 == 0) {
                            Log.v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", Integer.valueOf(DZ.field_id));
                        } else {
                            LinkedList<aml> linkedList = DZ.field_favProto.ppH;
                            for (int i7 = size2 - 1; i7 >= 0; i7--) {
                                aml aml = linkedList.get(i7);
                                if (!Util.isNullOrNil(aml.LvE)) {
                                    o oVar = new o(b.d(aml));
                                    Log.i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", oVar.getName());
                                    if (oVar.exists()) {
                                        if (aml.Lwd != 0) {
                                            Log.v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", aml.LvE);
                                            this.tbo = true;
                                            b.a(aml, DZ, 0, false);
                                        }
                                        Log.d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", Integer.valueOf(DZ.field_id), Integer.valueOf(i7));
                                    } else if (Util.isNullOrNil(aml.Lvp) || Util.isNullOrNil(aml.KuR)) {
                                        Log.e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", Integer.valueOf(DZ.field_id));
                                    } else {
                                        Log.d("MicroMsg.NetSceneBatchgetFav", "local data not exist, insert cdninfo, favId:%d, dataIndex:%d", Integer.valueOf(DZ.field_id), Integer.valueOf(i7));
                                        b.a(aml, DZ, 1, false);
                                        this.tbn = true;
                                    }
                                }
                                if (!Util.isNullOrNil(aml.LvP)) {
                                    if (new o(b.a(aml)).exists()) {
                                        Log.d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", Integer.valueOf(DZ.field_id), Integer.valueOf(i7));
                                    } else if (Util.isNullOrNil(aml.Lvk) || Util.isNullOrNil(aml.iwX)) {
                                        Log.w("MicroMsg.NetSceneBatchgetFav", "thumb key or url null. favId:%d", Integer.valueOf(DZ.field_id));
                                    } else {
                                        Log.d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", Integer.valueOf(DZ.field_id), Integer.valueOf(i7));
                                        b.a(aml, DZ, 1);
                                        this.tbn = true;
                                    }
                                }
                            }
                        }
                        Log.i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", Boolean.valueOf(this.tbo), Boolean.valueOf(this.tbn));
                        if (this.tbo) {
                            DZ.field_itemStatus = 15;
                            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(DZ, ch.COL_LOCALID);
                            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
                        } else if (this.tbn) {
                            DZ.field_itemStatus = 10;
                            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(DZ, ch.COL_LOCALID);
                        } else {
                            DZ.field_itemStatus = 10;
                            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(DZ, ch.COL_LOCALID);
                        }
                        b.j(DZ);
                        DZ.arR("MicroMsg.NetSceneBatchgetFav");
                    }
                }
                if ((amw.KHa & 1) != 0) {
                    Log.d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", Integer.valueOf(amw.KGZ));
                    b.a(((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ((long) amw.KGZ), (Runnable) null);
                }
            }
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
            if (cVa()) {
                doScene(dispatcher(), this.callback);
                AppMethodBeat.o(103469);
                return;
            }
            tbp.decrementAndGet();
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(103469);
        } else if (cVa()) {
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(103469);
        } else {
            tbp.decrementAndGet();
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(103469);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 100;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 402;
    }
}
