package com.tencent.mm.openim.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.openim.room.a.b;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.brk;
import com.tencent.mm.protocal.protobuf.brl;
import com.tencent.mm.protocal.protobuf.cvs;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;

public final class f extends q implements m {
    private i callback;
    private final String dOe;
    private final d rr;
    private final int version;

    public f(String str, int i2) {
        AppMethodBeat.i(151193);
        d.a aVar = new d.a();
        aVar.iLN = new brk();
        aVar.iLO = new brl();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenimchatroommemberdetail";
        aVar.funcId = 942;
        this.rr = aVar.aXF();
        this.dOe = str;
        this.version = i2;
        brk brk = (brk) this.rr.iLK.iLR;
        brk.jHa = str;
        brk.LYO = i2;
        Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "get roomname:%s, version=%d", str, Integer.valueOf(i2));
        AppMethodBeat.o(151193);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        int i5;
        int startPerformance;
        AppMethodBeat.i(151194);
        Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s, %d", Integer.valueOf(i3), Integer.valueOf(i4), str, this.dOe, Integer.valueOf(this.version));
        if (i4 == 0) {
            brl brl = (brl) ((d) sVar).iLL.iLR;
            ah Ke = ((c) g.af(c.class)).aSX().Ke(this.dOe);
            long j2 = Util.MAX_32BIT_VALUE & ((long) brl.LYP);
            Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail svrVer:%d, localVer:%d", Integer.valueOf(brl.LYP), Integer.valueOf(this.version));
            if (((long) this.version) < j2) {
                Ke.akd(brl.LYP);
                LinkedList<cvv> linkedList = brl.LYQ == null ? null : brl.LYQ.KHx;
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
                Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail memInfoList size[%d]", objArr);
                Ke.I(z.aTY(), b.c.aN(linkedList));
                ((c) g.af(c.class)).aSX().replace(Ke);
                cvs cvs = brl.LYQ;
                com.tencent.mm.openim.room.a.c cVar = new com.tencent.mm.openim.room.a.c();
                if (cvs != null) {
                    LinkedList<cvv> linkedList2 = cvs.KHx;
                    bv aSN = ((l) g.af(l.class)).aSN();
                    j aYB = p.aYB();
                    LinkedList linkedList3 = new LinkedList();
                    LinkedList linkedList4 = new LinkedList();
                    int size = linkedList2 == null ? -1 : linkedList2.size();
                    Log.i("OpenIMChatRoomContactLogic", "updateMemberDetail memInfoList size[%d]", Integer.valueOf(size));
                    if (size >= 0) {
                        if (((long) size) > WXHardCoderJNI.hcUpdateChatroomMemberCount) {
                            startPerformance = 0;
                        } else {
                            boolean z = WXHardCoderJNI.hcUpdateChatroomEnable;
                            int i6 = WXHardCoderJNI.hcUpdateChatroomDelay;
                            int i7 = WXHardCoderJNI.hcUpdateChatroomCPU;
                            int i8 = WXHardCoderJNI.hcUpdateChatroomIO;
                            if (WXHardCoderJNI.hcUpdateChatroomThr) {
                                i5 = g.aAk().getProcessTid();
                            } else {
                                i5 = 0;
                            }
                            startPerformance = WXHardCoderJNI.startPerformance(z, i6, i7, i8, i5, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "PerfTrace");
                        }
                        cVar.gsi = startPerformance;
                        for (cvv cvv : linkedList2) {
                            if (cvs.MBn == 0 && !Util.isNullOrNil(cvv.userName) && !Util.isNullOrNil(cvv.LpI)) {
                                com.tencent.mm.aj.i Mx = aYB.Mx(cvv.userName);
                                if (Mx == null) {
                                    Mx = new com.tencent.mm.aj.i();
                                    Mx.username = cvv.userName;
                                }
                                Mx.iKX = cvv.LpH;
                                Mx.iKW = cvv.LpI;
                                Mx.fuz = 3;
                                Mx.fv(!Util.isNullOrNil(cvv.LpH));
                                linkedList4.add(Mx);
                            }
                            as Kn = aSN.Kn(cvv.userName);
                            if (Kn == null) {
                                Log.e("OpenIMChatRoomContactLogic", "updateMemberDetail memberlist username is null");
                            } else {
                                if (Kn.arx()) {
                                    Kn.setNickname(cvv.nickName);
                                    linkedList3.add(new Pair(cvv.userName, Kn));
                                }
                                if (!Util.isNullOrNil(cvv.appId)) {
                                    Kn.BN(cvv.appId);
                                }
                                if (!Util.isNullOrNil(cvv.MBp)) {
                                    Kn.BM(cvv.MBp);
                                }
                                aSN.ao(Kn);
                                if (!Util.isNullOrNil(cvv.appId)) {
                                    ((a) g.af(a.class)).s(cvv.appId, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), cvv.MBp);
                                }
                            }
                        }
                        Log.d("OpenIMChatRoomContactLogic", "updateMemberDetail update newImgFlagList size:%d, updateList size:%d", Integer.valueOf(linkedList4.size()), Integer.valueOf(linkedList3.size()));
                        if (!linkedList4.isEmpty()) {
                            cVar.uD(1);
                            new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack(linkedList4, cVar, aYB) {
                                /* class com.tencent.mm.openim.room.a.a.AnonymousClass1 */
                                final /* synthetic */ LinkedList gsj;
                                final /* synthetic */ j gsk;
                                final /* synthetic */ c jHP;

                                {
                                    this.gsj = r1;
                                    this.jHP = r2;
                                    this.gsk = r3;
                                }

                                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                                public final boolean onTimerExpired() {
                                    AppMethodBeat.i(151311);
                                    int size = this.gsj.size() < 25 ? this.gsj.size() : 25;
                                    Log.d("OpenIMChatRoomContactLogic", "updateMemberDetail update img list size:%d, loopCount:%d", Integer.valueOf(this.gsj.size()), Integer.valueOf(size));
                                    if (size == 0) {
                                        if (this.jHP != null) {
                                            this.jHP.uE(1);
                                        }
                                        Log.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done loopCount is 0");
                                        AppMethodBeat.o(151311);
                                        return false;
                                    } else if (this.gsj.isEmpty()) {
                                        if (this.jHP != null) {
                                            this.jHP.uE(1);
                                        }
                                        Log.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done newImgFlagList is empty");
                                        AppMethodBeat.o(151311);
                                        return false;
                                    } else {
                                        long currentTimeMillis = System.currentTimeMillis();
                                        long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
                                        for (int i2 = 0; i2 < size; i2++) {
                                            com.tencent.mm.aj.i iVar = (com.tencent.mm.aj.i) this.gsj.poll();
                                            if (iVar == null) {
                                                break;
                                            }
                                            this.gsk.b(iVar);
                                        }
                                        g.aAh().hqK.endTransaction(beginTransaction);
                                        Log.d("OpenIMChatRoomContactLogic", "updateMemberDetail update img loopCount:%d, take time:%d(ms)", Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                        if (this.gsj.isEmpty()) {
                                            if (this.jHP != null) {
                                                this.jHP.uE(1);
                                            }
                                            Log.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done newImgFlagList is empty");
                                            AppMethodBeat.o(151311);
                                            return false;
                                        }
                                        AppMethodBeat.o(151311);
                                        return true;
                                    }
                                }
                            }, true).startTimer(100);
                        }
                        if (!linkedList3.isEmpty()) {
                            cVar.uD(2);
                            new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack(linkedList3, cVar, aSN) {
                                /* class com.tencent.mm.openim.room.a.a.AnonymousClass2 */
                                final /* synthetic */ LinkedList gso;
                                final /* synthetic */ bv gsp;
                                final /* synthetic */ c jHP;

                                {
                                    this.gso = r1;
                                    this.jHP = r2;
                                    this.gsp = r3;
                                }

                                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                                public final boolean onTimerExpired() {
                                    AppMethodBeat.i(151312);
                                    int size = this.gso.size() < 25 ? this.gso.size() : 25;
                                    Log.d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg list size:%d, loopCount:%d", Integer.valueOf(this.gso.size()), Integer.valueOf(size));
                                    if (size == 0) {
                                        if (this.jHP != null) {
                                            this.jHP.uE(2);
                                        }
                                        Log.i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done loopCount is 0");
                                        AppMethodBeat.o(151312);
                                        return false;
                                    }
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
                                    for (int i2 = 0; i2 < size; i2++) {
                                        Pair pair = (Pair) this.gso.poll();
                                        this.gsp.c((String) pair.first, (as) pair.second);
                                    }
                                    g.aAh().hqK.endTransaction(beginTransaction);
                                    Log.d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg loopCount:%d, take time:%d(ms)", Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    if (this.gso.isEmpty()) {
                                        if (this.jHP != null) {
                                            this.jHP.uE(2);
                                        }
                                        Log.i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done updateList is empty");
                                        AppMethodBeat.o(151312);
                                        return false;
                                    }
                                    AppMethodBeat.o(151312);
                                    return true;
                                }
                            }, true).startTimer(100);
                        }
                    }
                }
            }
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(151194);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 942;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(151195);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151195);
        return dispatch;
    }
}
