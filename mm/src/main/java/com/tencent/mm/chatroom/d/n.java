package com.tencent.mm.chatroom.d;

import android.util.Pair;
import com.tencent.f.h;
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
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.blf;
import com.tencent.mm.protocal.protobuf.xh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;
import java.util.List;

public final class n extends q implements m {
    private i callback = null;
    final String chatroomName;
    private int gsh = 0;
    private int gsi;
    private final d rr;

    public n(String str, int i2) {
        int i3;
        AppMethodBeat.i(12478);
        d.a aVar = new d.a();
        aVar.iLN = new ble();
        aVar.iLO = new blf();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
        aVar.funcId = 551;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.chatroomName = str;
        int gBt = ((c) g.af(c.class)).aSX().Ke(str).gBt();
        ((ble) this.rr.iLK.iLR).LUh = str;
        ble ble = (ble) this.rr.iLK.iLR;
        if (gBt < i2) {
            i3 = i2;
        } else {
            i3 = gBt;
        }
        ble.KOj = i3;
        Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", str, Integer.valueOf(i2), Integer.valueOf(gBt), Util.getStack());
        AppMethodBeat.o(12478);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(12479);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(12479);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 551;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        int i5;
        int startPerformance;
        AppMethodBeat.i(12480);
        if (i3 == 0 && i4 == 0) {
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str);
            final blf blf = (blf) this.rr.iLL.iLR;
            ah Ke = ((c) g.af(c.class)).aSX().Ke(this.chatroomName);
            long gBt = (long) Ke.gBt();
            long j2 = ((long) blf.oTw) & Util.MAX_32BIT_VALUE;
            Object[] objArr = new Object[4];
            objArr[0] = this.chatroomName;
            objArr[1] = Integer.valueOf(blf.oTw);
            objArr[2] = Integer.valueOf(blf.LUi == null ? 0 : blf.LUi.gsq);
            objArr[3] = Long.valueOf(gBt);
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s svrVer:%d, modCnt:%d， localVer:%d", objArr);
            if (gBt >= j2) {
                Log.e("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom localVer[%d] serverVer[%d] is new and return", Long.valueOf(gBt), Long.valueOf(j2));
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(12480);
                return;
            }
            final LinkedList<xh> linkedList = blf.LUi == null ? null : blf.LUi.Lin;
            int size = linkedList == null ? -1 : linkedList.size();
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", Integer.valueOf(size));
            final bv aSN = ((l) g.af(l.class)).aSN();
            final j aYB = p.aYB();
            final LinkedList linkedList2 = new LinkedList();
            final LinkedList linkedList3 = new LinkedList();
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
                startPerformance = WXHardCoderJNI.startPerformance(z, i6, i7, i8, i5, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "MicroMsg.NetSceneGetChatroomMemberDetail");
            }
            this.gsi = startPerformance;
            for (xh xhVar : linkedList) {
                if (!Util.isNullOrNil(xhVar.Lis) && !Util.isNullOrNil(xhVar.UserName)) {
                    com.tencent.mm.aj.i Mx = aYB.Mx(xhVar.UserName);
                    if (Mx == null) {
                        Mx = new com.tencent.mm.aj.i();
                        Mx.username = xhVar.UserName;
                    } else {
                        Mx.aYu().equals(xhVar.Lis);
                    }
                    Mx.iKX = xhVar.Lir;
                    Mx.iKW = xhVar.Lis;
                    Mx.fuz = 3;
                    Mx.fv(!Util.isNullOrNil(xhVar.Lir));
                    linkedList3.add(Mx);
                }
                as Kn = aSN.Kn(xhVar.UserName);
                if (Kn == null) {
                    Log.e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
                } else if (Kn.arx()) {
                    Kn.setNickname(xhVar.oUJ);
                    linkedList2.add(new Pair(xhVar.UserName, Kn));
                    Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail username:%s nickname:%s", Util.nullAs(xhVar.UserName, ""), Util.secPrint(xhVar.oUJ));
                } else {
                    Log.w("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail isChatRoomContact == false, username %s nickname %s", Util.nullAs(xhVar.UserName, ""), Util.nullAs(xhVar.oUJ, ""));
                }
            }
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", Integer.valueOf(linkedList3.size()), Integer.valueOf(linkedList2.size()));
            if (!linkedList3.isEmpty()) {
                this.gsh |= 1;
                h.RTc.a(new Runnable() {
                    /* class com.tencent.mm.chatroom.d.n.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(194027);
                        int size = linkedList3.size() < 25 ? linkedList3.size() : 25;
                        Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img list size:%d, loopCount:%d", n.this.chatroomName, Integer.valueOf(linkedList3.size()), Integer.valueOf(size));
                        if (size == 0) {
                            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done loopCount is 0", n.this.chatroomName);
                        } else if (linkedList3.isEmpty()) {
                            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done newImgFlagList is empty", n.this.chatroomName);
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
                            for (int i2 = 0; i2 < size; i2++) {
                                com.tencent.mm.aj.i iVar = (com.tencent.mm.aj.i) linkedList3.poll();
                                if (iVar == null) {
                                    break;
                                }
                                aYB.b(iVar);
                            }
                            g.aAh().hqK.endTransaction(beginTransaction);
                            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img loopCount:%d, take time:%d(ms), img list size:%d", n.this.chatroomName, Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(linkedList3.size()));
                            if (!linkedList3.isEmpty()) {
                                h.RTc.a(this, 100, "chatroom_member_detail");
                                AppMethodBeat.o(194027);
                                return;
                            }
                        }
                        n.a(n.this, 1, n.this.chatroomName, blf.oTw, linkedList);
                        Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done newImgFlagList is empty", n.this.chatroomName);
                        AppMethodBeat.o(194027);
                    }
                }, 100, "chatroom_member_detail");
            }
            if (!linkedList2.isEmpty()) {
                this.gsh |= 2;
                h.RTc.a(new Runnable() {
                    /* class com.tencent.mm.chatroom.d.n.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(194028);
                        int size = linkedList2.size() < 25 ? linkedList2.size() : 25;
                        Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg list size:%d, loopCount:%d", n.this.chatroomName, Integer.valueOf(linkedList2.size()), Integer.valueOf(size));
                        if (size == 0) {
                            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg done loopCount is 0", n.this.chatroomName);
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
                            for (int i2 = 0; i2 < size; i2++) {
                                Pair pair = (Pair) linkedList2.poll();
                                aSN.c((String) pair.first, (as) pair.second);
                            }
                            g.aAh().hqK.endTransaction(beginTransaction);
                            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg loopCount:%d, take time:%d(ms), img list size:%d", n.this.chatroomName, Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(linkedList2.size()));
                            if (!linkedList2.isEmpty()) {
                                h.RTc.a(this, 100, "chatroom_member_detail");
                                AppMethodBeat.o(194028);
                                return;
                            }
                        }
                        n.a(n.this, 2, n.this.chatroomName, blf.oTw, linkedList);
                        Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg done updateList is empty", n.this.chatroomName);
                        AppMethodBeat.o(194028);
                    }
                }, 100, "chatroom_member_detail");
            }
            if (linkedList3.isEmpty() && linkedList2.isEmpty()) {
                a(Ke, blf.oTw, linkedList);
                ((c) g.af(c.class)).aSX().replace(Ke);
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(12480);
            return;
        }
        Log.e("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(12480);
    }

    private static void a(ah ahVar, int i2, List<xh> list) {
        AppMethodBeat.i(194029);
        ahVar.akd(i2);
        ahVar.I(z.aTY(), list);
        AppMethodBeat.o(194029);
    }

    static /* synthetic */ void a(n nVar, int i2, String str, int i3, List list) {
        AppMethodBeat.i(194030);
        nVar.gsh &= i2 ^ -1;
        if (nVar.gsh == 0) {
            ah Ke = ((c) g.af(c.class)).aSX().Ke(str);
            a(Ke, i3, list);
            ((c) g.af(c.class)).aSX().replace(Ke);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcUpdateChatroomEnable, nVar.gsi);
            nVar.gsi = 0;
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "updateDone(%s)", str);
        }
        AppMethodBeat.o(194030);
    }
}
