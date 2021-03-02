package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ab;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.cvq;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwp;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.io.IOException;
import java.util.Iterator;

public final class r extends q implements m {
    private i callback;
    private final d rr;

    public r() {
        AppMethodBeat.i(151228);
        d.a aVar = new d.a();
        aVar.iLN = new cwp();
        aVar.iLO = new cwq();
        aVar.uri = "/cgi-bin/micromsg-bin/openimsync";
        aVar.funcId = 810;
        this.rr = aVar.aXF();
        ((cwp) this.rr.iLK.iLR).dML = TPMediaCodecProfileLevel.HEVCHighTierLevel6;
        Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "opim sync init:%d", Integer.valueOf(hashCode()));
        AppMethodBeat.o(151228);
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 20;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final boolean uniqueInNetsceneQueue() {
        return true;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 810;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(151229);
        com.tencent.mm.kernel.g.aAi();
        byte[] decodeHexString = Util.decodeHexString(Util.nullAsNil((String) com.tencent.mm.kernel.g.aAh().azQ().get(8195, (Object) null)));
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(decodeHexString);
        ((cwp) this.rr.iLK.iLR).MBy = sKBuiltinBuffer_t;
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151229);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151230);
        Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(hashCode()));
        if (i3 == 0 && i4 == 0) {
            cwp cwp = (cwp) this.rr.iLK.iLR;
            cwq cwq = (cwq) this.rr.iLL.iLR;
            if (cwq.MBz != null && cwq.MBz.oTA.size() > 0) {
                Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd, cmd size:%d", Integer.valueOf(cwq.MBz.oTA.size()));
                Iterator<abn> it = cwq.MBz.oTA.iterator();
                while (it.hasNext()) {
                    abn next = it.next();
                    if (next.Lms == 400) {
                        cvw cvw = new cvw();
                        try {
                            cvw.parseFrom(next.Lmt.getBufferToBytes());
                            Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact %s", cvw.jGZ);
                            as a2 = s.a(cvw);
                            Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", a2.field_username, a2.field_nickname, a2.field_conRemark, Integer.valueOf(a2.getSource()), Integer.valueOf(a2.fuA), a2.field_openImAppid, a2.fvb, Integer.valueOf(a2.fva), Integer.valueOf(a2.field_type), a2.field_descWordingId);
                            ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().ao(a2);
                            if (a2.arE()) {
                                ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bke(a2.field_username);
                            } else {
                                ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bkf(a2.field_username);
                            }
                            ((a) com.tencent.mm.kernel.g.af(a.class)).bM(cvw.app_id, cvw.MBp);
                            s.b(cvw);
                            com.tencent.mm.kernel.g.aAi();
                            cn aEZ = ((l) com.tencent.mm.kernel.g.af(l.class)).aSO().aEZ(a2.field_username);
                            if (aEZ != null && !Util.isNullOrNil(aEZ.field_encryptUsername)) {
                                ((com.tencent.mm.plugin.messenger.foundation.a.r) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.r.class)).am(a2.field_username, aEZ.field_conRemark);
                                com.tencent.mm.kernel.g.aAi();
                                ((l) com.tencent.mm.kernel.g.af(l.class)).aSO().aFa(a2.field_username);
                                a2.BD(aEZ.field_conRemark);
                                ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().ao(a2);
                            }
                        } catch (IOException e2) {
                            Log.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact error:%s", e2);
                        }
                    } else if (next.Lms == 402) {
                        afw afw = new afw();
                        try {
                            afw.parseFrom(next.Lmt.getBufferToBytes());
                            Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact user:%s", afw.jGZ);
                            ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bjW(afw.jGZ);
                            ab.IV(afw.jGZ);
                        } catch (IOException e3) {
                            Log.e("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact error:%s", e3);
                        }
                    } else if (next.Lms == 403) {
                        try {
                            cvq cvq = new cvq();
                            cvq.parseFrom(next.Lmt.getBufferToBytes());
                            Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact %s", cvq.jHa);
                            com.tencent.mm.openim.room.a.a.a(cvq, -1, cvq.MAZ);
                        } catch (IOException e4) {
                            Log.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact error:%s", e4);
                        }
                    } else if (next.Lms == 404) {
                        cvw cvw2 = new cvw();
                        try {
                            cvw2.parseFrom(next.Lmt.getBufferToBytes());
                            Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact %s", cvw2.jGZ);
                            com.tencent.mm.kernel.g.aAg().hqi.a(new h(cvw2.jGZ, "", ""), 0);
                        } catch (IOException e5) {
                            Log.e("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact error:%s", e5);
                        }
                    }
                }
            }
            byte[] byteArray = cwq.MBy.getBuffer().toByteArray();
            com.tencent.mm.kernel.g.aAi();
            byte[] l = ad.l(Util.decodeHexString(Util.nullAsNil((String) com.tencent.mm.kernel.g.aAh().azQ().get(8195, (Object) null))), byteArray);
            if (l != null && l.length > 0) {
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(8195, Util.encodeHexString(l));
            }
            if ((cwp.dML & cwq.tUC) == 0) {
                Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd end");
                this.callback.onSceneEnd(0, 0, "", this);
                AppMethodBeat.o(151230);
                return;
            }
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(151230);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(151230);
    }
}
