package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.a;
import com.tencent.mm.an.f;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.amk;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.protocal.protobuf.xy;
import com.tencent.mm.protocal.protobuf.xz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class aj extends q implements m {
    private i callback = null;
    private final d rr;
    private int tbq = 0;
    public g tbr;
    private boolean tbs = true;
    private boolean tbt = false;
    HashMap<aml, Boolean> tbu = new HashMap<>();

    public aj(g gVar) {
        AppMethodBeat.i(103471);
        d.a aVar = new d.a();
        aVar.iLN = new xy();
        aVar.iLO = new xz();
        aVar.uri = "/cgi-bin/micromsg-bin/checkcdn";
        aVar.funcId = 404;
        aVar.iLP = 197;
        aVar.respCmdId = 1000000197;
        this.rr = aVar.aXF();
        this.tbr = gVar;
        Iterator<aml> it = gVar.field_favProto.ppH.iterator();
        while (it.hasNext()) {
            this.tbu.put(it.next(), Boolean.FALSE);
        }
        AppMethodBeat.o(103471);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(103472);
        this.callback = iVar;
        int i2 = 0;
        for (aml aml : this.tbu.keySet()) {
            if (!this.tbu.get(aml).booleanValue()) {
                i2++;
            } else {
                i2 = i2;
            }
        }
        if (i2 == 0) {
            Log.e("MicroMsg.NetSceneCheckCDN", "klem doScene data list null");
            this.tbq = -100;
            AppMethodBeat.o(103472);
            return -100;
        }
        int i3 = 0;
        xy xyVar = (xy) this.rr.iLK.iLR;
        xyVar.oTA.clear();
        LinkedList<aml> linkedList = this.tbr.field_favProto.ppH;
        int i4 = 0;
        while (true) {
            int i5 = i3;
            if (i4 >= linkedList.size()) {
                i3 = i5;
                break;
            }
            aml aml2 = linkedList.get(i4);
            if (!this.tbu.get(aml2).booleanValue()) {
                if (!aml2.LvZ) {
                    xx xxVar = new xx();
                    xxVar.LiX = (int) aml2.LvI;
                    xxVar.LiV = aml2.LvE;
                    xxVar.LiW = aml2.LvG;
                    xxVar.LiU = String.valueOf(i4);
                    xxVar.LiZ = aml2.LvV;
                    xxVar.LiY = this.tbr.field_sourceType;
                    xxVar.Lja = 0;
                    xyVar.oTA.add(xxVar);
                    i5++;
                    Log.i("MicroMsg.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", xxVar.LiU, xxVar.LiZ, Integer.valueOf(xxVar.LiY), Integer.valueOf(xxVar.LiX), xxVar.LiV, xxVar.LiW);
                }
                if (!aml2.Lwb) {
                    xx xxVar2 = new xx();
                    xxVar2.LiX = (int) aml2.LvT;
                    xxVar2.LiV = aml2.LvP;
                    xxVar2.LiW = aml2.LvR;
                    xxVar2.LiZ = aml2.LvV;
                    xxVar2.LiY = this.tbr.field_sourceType;
                    xxVar2.LiU = i4 + "t";
                    xxVar2.Lja = 1;
                    xyVar.oTA.add(xxVar2);
                    i3 = i5 + 1;
                    Log.i("MicroMsg.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", xxVar2.LiU, xxVar2.LiZ, Integer.valueOf(xxVar2.LiY), Integer.valueOf(xxVar2.LiX), xxVar2.LiV, xxVar2.LiW);
                } else {
                    i3 = i5;
                }
                if (i3 >= 19) {
                    break;
                }
            } else {
                i3 = i5;
            }
            i4++;
        }
        Log.i("MicroMsg.NetSceneCheckCDN", "doScene:  usedCount %d, dataSize %d, nextBegIndex %d", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4 + 1));
        xyVar.oTz = i3;
        if (i3 == 0) {
            Log.w("MicroMsg.NetSceneCheckCDN", "no more data, must not check cdn!");
            this.tbq = -101;
            AppMethodBeat.o(103472);
            return -101;
        }
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(103472);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(103473);
        Log.i("MicroMsg.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(this.tbq), str);
        if (!(i3 == 0 && i4 == 0)) {
            if (i3 == 3 && this.tbq == -100) {
                Log.d("MicroMsg.NetSceneCheckCDN", "need not check cdn, add fav now");
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(9, this.tbr.field_localId);
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getSendService().run();
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(103473);
                return;
            } else if (i3 == 3 && this.tbq == -101) {
                i4 = 0;
            } else {
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(103473);
                return;
            }
        }
        if (this.tbq != -101 && i3 == 0 && i4 == 0) {
            LinkedList<amk> linkedList = ((xz) ((d) sVar).iLL.iLR).oTA;
            LinkedList<aml> linkedList2 = this.tbr.field_favProto.ppH;
            for (int i5 = 0; i5 < linkedList.size(); i5++) {
                amk amk = linkedList.get(i5);
                String str2 = amk.LiU;
                if (!Util.isNullOrNil(str2)) {
                    Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", Integer.valueOf(amk.oTW), str2);
                    if (amk.oTW == 1) {
                        if (!str2.endsWith("t")) {
                            aml aml = linkedList2.get(Util.getInt(str2, 0));
                            Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", amk.Lvf, amk.LbJ, amk.LiU, amk.LiV, Integer.valueOf(amk.LiX), amk.LiW);
                            aml.bgk(amk.LbJ);
                            aml.bgj(amk.Lvf);
                            if (!Util.isNullOrNil(amk.KSu)) {
                                aml.bgy(amk.KSu);
                            }
                            if (Util.isNullOrNil(aml.LvE)) {
                                Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
                                aml.bgq(amk.LiV);
                                aml.Mu((long) amk.LiX);
                                aml.bgr(amk.LiW);
                                b.a(aml, this.tbr, 1, false);
                            }
                            if (!Util.isNullOrNil(amk.LiV) && !amk.LiV.equals(aml.LvE)) {
                                Log.w("MicroMsg.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", amk.LiV, aml.LvE);
                                aml.bgq(amk.LiV);
                            }
                            if (!Util.isNullOrNil(amk.LiW) && !amk.LiW.equals(aml.LvG)) {
                                Log.w("MicroMsg.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", amk.LiW, aml.LvG);
                                aml.bgr(amk.LiW);
                            }
                            if (amk.LiX > 0 && ((long) amk.LiX) != aml.LvI) {
                                Log.w("MicroMsg.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", Integer.valueOf(amk.LiX), Long.valueOf(aml.LvI));
                                aml.Mu((long) amk.LiX);
                            }
                        } else {
                            aml aml2 = linkedList2.get(Util.getInt(str2.substring(0, str2.length() - 1), 0));
                            Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", amk.Lvf, amk.LbJ, amk.LiU, amk.LiV, Integer.valueOf(amk.LiX), amk.LiW);
                            aml2.bgi(amk.LbJ);
                            aml2.bgh(amk.Lvf);
                            if (amk.LiX > 0) {
                                aml2.Mv((long) amk.LiX);
                                if (!Util.isNullOrNil(amk.LiV) && !amk.LiV.equals(aml2.LvP)) {
                                    Log.w("MicroMsg.NetSceneCheckCDN", "svrThumbMd5 %s, localThumbMd5 %s", amk.LiV, aml2.LvP);
                                    aml2.bgv(amk.LiV);
                                }
                                if (!Util.isNullOrNil(amk.LiW) && !amk.LiW.equals(aml2.LvR)) {
                                    Log.w("MicroMsg.NetSceneCheckCDN", "svrThumbHead256md5 %s, localThumbHead256md5 %s", amk.LiW, aml2.LvR);
                                    aml2.bgw(amk.LiW);
                                }
                            }
                        }
                    }
                    if (!str2.endsWith("t")) {
                        this.tbu.put(linkedList2.get(Util.getInt(str2, 0)), Boolean.TRUE);
                    } else {
                        this.tbu.put(linkedList2.get(Util.getInt(str2.substring(0, str2.length() - 1), 0)), Boolean.TRUE);
                    }
                    if (!(amk.oTW == 1 || amk.oTW == 2)) {
                        if (!str2.endsWith("t")) {
                            aml aml3 = linkedList2.get(Util.getInt(str2, 0));
                            if (Util.isNullOrNil(aml3.LvE)) {
                                Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", aml3.LvE);
                            } else {
                                this.tbs = false;
                                if (Util.isNullOrNil(aml3.Lvp)) {
                                    f.baR();
                                    String baG = a.baG();
                                    aml3.bgk(baG);
                                    Log.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", baG);
                                }
                                Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s cdnkey:%s", aml3.LvE, aml3.Lvp);
                                b.a(aml3, this.tbr, 0, false);
                            }
                        } else {
                            aml aml4 = linkedList2.get(Util.getInt(str2.substring(0, str2.length() - 1), 0));
                            if (Util.isNullOrNil(aml4.LvP)) {
                                Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", aml4.LvP);
                            } else {
                                this.tbs = false;
                                if (Util.isNullOrNil(aml4.Lvp)) {
                                    f.baR();
                                    String baG2 = a.baG();
                                    aml4.bgk(baG2);
                                    Log.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", baG2);
                                }
                                Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s cdnkey:%s", aml4.LvE, aml4.Lvp);
                                b.a(aml4, this.tbr, 0);
                            }
                        }
                    }
                    if (amk.oTW == 2) {
                        this.tbt = true;
                        if (!str2.endsWith("t")) {
                            Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", Integer.valueOf(amk.Lvg), amk.Lvf, amk.LbJ);
                            aml aml5 = linkedList2.get(Util.getInt(str2, 0));
                            aml5.aje(amk.Lvg);
                            aml5.bgk(amk.LbJ);
                            aml5.bgj(amk.Lvf);
                            if (!Util.isNullOrNil(amk.KSu)) {
                                aml5.bgy(amk.KSu);
                            }
                            if (!Util.isNullOrNil(amk.LiV) && !amk.LiV.equals(aml5.LvE)) {
                                Log.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", amk.LiV, aml5.LvE);
                                aml5.bgq(amk.LiV);
                            }
                            if (!Util.isNullOrNil(amk.LiW) && !amk.LiW.equals(aml5.LvG)) {
                                Log.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", amk.LiW, aml5.LvG);
                                aml5.bgr(amk.LiW);
                            }
                            if (amk.LiX > 0 && ((long) amk.LiX) != aml5.LvI) {
                                Log.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", Integer.valueOf(amk.LiX), Long.valueOf(aml5.LvI));
                                aml5.Mu((long) amk.LiX);
                            }
                        } else {
                            Log.e("MicroMsg.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
                        }
                    }
                }
            }
            int i6 = 0;
            for (aml aml6 : this.tbu.keySet()) {
                if (!this.tbu.get(aml6).booleanValue()) {
                    i6++;
                } else {
                    i6 = i6;
                }
            }
            Log.i("MicroMsg.NetSceneCheckCDN", "onGYSceneEnd:  resultCount %d, dataSize %d", Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList2.size()));
            if (i6 > 0) {
                Log.w("MicroMsg.NetSceneCheckCDN", "check cdn list not end, continues");
                int doScene = doScene(dispatcher(), this.callback);
                if (!(doScene == -100 || doScene == -101)) {
                    AppMethodBeat.o(103473);
                    return;
                }
            }
        }
        if (this.tbt) {
            Log.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet waitServerUpload, send item now");
            this.tbr.field_itemStatus = 12;
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(this.tbr, ch.COL_LOCALID);
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getSendService().run();
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(103473);
            return;
        }
        if (this.tbs) {
            Log.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet all data exist, start send item");
            if (this.tbr.field_id > 0) {
                this.tbr.field_itemStatus = 17;
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(this.tbr, ch.COL_LOCALID);
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getModService().run();
            } else {
                if (this.tbr.field_type == 18) {
                    this.tbr.field_favProto.ajl(1);
                }
                this.tbr.field_itemStatus = 9;
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(this.tbr, ch.COL_LOCALID);
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getSendService().run();
            }
        } else {
            if (this.tbr.field_id > 0) {
                this.tbr.field_itemStatus = 15;
            } else {
                if (this.tbr.field_type == 18) {
                    this.tbr.field_favProto.ajl(1);
                }
                this.tbr.field_itemStatus = 4;
            }
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(this.tbr, ch.COL_LOCALID);
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(103473);
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 10;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 404;
    }
}
