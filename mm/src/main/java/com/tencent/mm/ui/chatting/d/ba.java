package com.tencent.mm.ui.chatting.d;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ab;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.ap;
import com.tencent.mm.ui.chatting.d.b.k;

@a(gRF = ap.class)
@Deprecated
public final class ba extends a implements bw.a, ap {
    public static int PtY = 350;
    public boolean PtZ;
    public boolean Pua;
    public boolean Pub;
    private IListener Puc;
    private boolean Pud;

    @Override // com.tencent.mm.storage.bw.a
    public final void a(final az azVar, bw bwVar) {
        long j2;
        long j3;
        View view;
        AppMethodBeat.i(35617);
        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", azVar.field_username, Long.valueOf(Thread.currentThread().getId()));
        if (!this.dom.cQp) {
            Log.w("MicroMsg.ChattingUI.SilenceMsgComponent", "[onMsgChangeNotify] ChattingUI is not in Foreground!!");
            AppMethodBeat.o(35617);
            return;
        }
        if (this.dom.gRM() && this.dom.GUe.field_username.equals(azVar.field_username)) {
            final k kVar = (k) this.dom.bh(k.class);
            int i2 = azVar.field_msgCount;
            int cZm = kVar.cZm();
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify newCvsCount[%d], total[%d], dealHistoryGetMsg[%b], UnDeliverCount[%d]", Integer.valueOf(i2), Integer.valueOf(cZm), Boolean.valueOf(this.PtZ), Integer.valueOf(azVar.field_UnDeliverCount));
            if (i2 > cZm) {
                ca caVar = azVar.OoM;
                if (caVar == null || caVar.field_msgId == 0) {
                    AppMethodBeat.o(35617);
                    return;
                }
                if (i2 - cZm > 1) {
                    this.Pud = true;
                }
                int i3 = caVar.field_flag;
                Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify receive get msg svrId[%d], seq[%d], flag[%d], stack[%s]", Long.valueOf(caVar.field_msgSvrId), Long.valueOf(caVar.field_msgSeq), Integer.valueOf(i3), Util.getStack());
                if ((i3 & 2) == 0) {
                    AppMethodBeat.o(35617);
                    return;
                } else if (this.dom.getListView() == null || kVar == null || this.dom.Pwe == null) {
                    Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr something is null %s %s %s", this.dom.getListView(), kVar, this.dom.Pwe);
                    AppMethodBeat.o(35617);
                    return;
                } else if ((i3 & 4) == 0) {
                    Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down dealHistoryGetMsg: %b", Boolean.valueOf(this.PtZ));
                    if (this.PtZ) {
                        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down but dealHistoryGetMsg so ignore");
                        AppMethodBeat.o(35617);
                        return;
                    }
                    final int firstVisiblePosition = this.dom.getFirstVisiblePosition();
                    int count = kVar.getCount();
                    int count2 = kVar.getCount();
                    int i4 = count2 - count;
                    Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down talker[%s],firstVisiblePosition:%d, new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d, needCheckHistoryTips:%b", this.dom.GUe.field_username, Integer.valueOf(firstVisiblePosition), Integer.valueOf(i2), Integer.valueOf(cZm), Integer.valueOf(i2 - cZm), Integer.valueOf(count2), Integer.valueOf(count), Integer.valueOf(i4), 0, Boolean.valueOf(this.Pua));
                    if (i4 > 1) {
                        ListView listView = this.dom.getListView();
                        int firstVisiblePosition2 = listView.getFirstVisiblePosition();
                        int childCount = (listView.getChildCount() + firstVisiblePosition2) - 1;
                        if (firstVisiblePosition < firstVisiblePosition2 || firstVisiblePosition > childCount) {
                            view = listView.getAdapter().getView(firstVisiblePosition, null, listView);
                        } else {
                            view = listView.getChildAt(firstVisiblePosition - firstVisiblePosition2);
                        }
                        int top = view == null ? 0 : view.getTop();
                        final int bottomHeight = top - this.dom.Pwe.getBottomHeight();
                        this.dom.getListView().setAdapter(this.dom.getListView().getAdapter());
                        this.dom.lf(firstVisiblePosition, bottomHeight);
                        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s firstView %s scrollY %s %s", Integer.valueOf(firstVisiblePosition), view, Integer.valueOf(top), Integer.valueOf(bottomHeight));
                        this.dom.getListView().post(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.d.ba.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(35613);
                                ba.this.dom.lf(firstVisiblePosition, bottomHeight);
                                Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 111 %s %s %s", Integer.valueOf(ba.this.dom.getFirstVisiblePosition()), Integer.valueOf(ba.this.dom.getLastVisiblePosition()), Integer.valueOf(kVar.getCount()));
                                AppMethodBeat.o(35613);
                            }
                        });
                        this.dom.getListView().postDelayed(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.d.ba.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(35614);
                                ba.this.dom.lf(firstVisiblePosition, bottomHeight);
                                Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 222 %s %s %s", Integer.valueOf(ba.this.dom.getFirstVisiblePosition()), Integer.valueOf(ba.this.dom.getLastVisiblePosition()), Integer.valueOf(kVar.getCount()));
                                AppMethodBeat.o(35614);
                            }
                        }, 200);
                    }
                    AppMethodBeat.o(35617);
                    return;
                } else {
                    int firstVisiblePosition3 = this.dom.getFirstVisiblePosition();
                    int lastVisiblePosition = this.dom.getLastVisiblePosition();
                    ca amt = kVar.amt(firstVisiblePosition3);
                    ca amt2 = kVar.amt(lastVisiblePosition);
                    int count3 = kVar.getCount();
                    int count4 = kVar.getCount();
                    int i5 = i2 - cZm;
                    final int i6 = count4 - count3;
                    Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up talker[%s],new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d needCheckHistoryTips:%b", this.dom.GUe.field_username, Integer.valueOf(i2), Integer.valueOf(cZm), Integer.valueOf(i5), Integer.valueOf(count4), Integer.valueOf(count3), Integer.valueOf(i6), 0, Boolean.valueOf(this.Pua));
                    if (amt2 != null && amt2.field_msgId != 0 && amt2.field_createTime < caVar.field_createTime) {
                        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr lastVisibleMsg getCreateTime < lastInsert msg");
                    } else if (i6 > 0) {
                        kVar.amv(i6);
                        Object[] objArr = new Object[5];
                        objArr[0] = Integer.valueOf(firstVisiblePosition3);
                        objArr[1] = Integer.valueOf(lastVisiblePosition);
                        if (amt == null) {
                            j2 = -1;
                        } else {
                            j2 = amt.field_createTime;
                        }
                        objArr[2] = Long.valueOf(j2);
                        if (amt2 == null) {
                            j3 = -1;
                        } else {
                            j3 = amt2.field_createTime;
                        }
                        objArr[3] = Long.valueOf(j3);
                        objArr[4] = Long.valueOf(caVar.field_createTime);
                        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s, lastVisiblePosition %s, createtime[%s, %s, %s]", objArr);
                        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up nowCount > preCount on set select:%d position %d, firstVisiblePosition %s", Integer.valueOf(i6), Integer.valueOf(i6 + 1), Integer.valueOf(firstVisiblePosition3));
                        this.dom.lf(i6 + 1, ((aa) this.dom.bh(aa.class)).gQy() + this.dom.Pwe.getTopHeight());
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.d.ba.AnonymousClass4 */

                            public final void run() {
                                AppMethodBeat.i(35615);
                                ba.this.dom.lf(i6 + 1, ((aa) ba.this.dom.bh(aa.class)).gQy() + ba.this.dom.Pwe.getTopHeight());
                                AppMethodBeat.o(35615);
                            }
                        });
                    } else {
                        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up incTotal incCount[%d, %d, %d] keep same", Integer.valueOf(i5), Integer.valueOf(i6), 0);
                    }
                    this.dom.Pwe.gOb();
                    if (azVar.field_UnDeliverCount <= 0) {
                        ((ab) this.dom.bh(ab.class)).gQB();
                    }
                    if (this.Pua) {
                        this.Pua = false;
                        this.dom.Pwe.setIsBottomShowAll(false);
                        this.dom.Pwe.setBottomViewVisible(((am) this.dom.bh(am.class)).gQZ());
                        this.dom.Pwe.By(false);
                        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify set needCheckHistoryTips[%b]", Boolean.valueOf(this.Pua));
                        com.tencent.mm.ui.chatting.e.a.gRP().postDelayed(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.d.ba.AnonymousClass5 */

                            public final void run() {
                                AppMethodBeat.i(35616);
                                Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify updateGoBackToHistoryMessage up UnDeliver:%d, UnRead:%d", Integer.valueOf(azVar.field_UnDeliverCount), Integer.valueOf(azVar.field_unReadCount));
                                AppMethodBeat.o(35616);
                            }
                        }, 500);
                    }
                }
            }
        }
        AppMethodBeat.o(35617);
    }

    public final void cg(ca caVar) {
        int i2;
        long j2;
        ca aX;
        AppMethodBeat.i(35618);
        if (!(caVar == null || caVar.field_msgId == 0)) {
            long j3 = caVar.field_msgSeq;
            boolean z = (caVar.field_flag & 4) != 0;
            bg.aVF();
            az bjY = c.aST().bjY(this.dom.GUe.field_username);
            if (bjY != null) {
                if (z) {
                    j2 = bjY.field_firstUnDeliverSeq;
                } else {
                    j2 = bjY.field_lastSeq;
                }
                if (!z || j2 != 0) {
                    i2 = 0;
                } else {
                    i2 = bjY.field_UnDeliverCount;
                }
                if (z && j2 > j3 && (aX = ((l) g.af(l.class)).eiy().aX(this.dom.GUe.field_username, j3)) != null && aX.field_msgSeq < j3) {
                    Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg revised filterSeq[%d] to [%d]", Long.valueOf(j2), Long.valueOf(aX.field_msgSeq));
                    j2 = aX.field_msgSeq;
                }
            } else {
                i2 = 0;
                j2 = 0;
            }
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg filterSeq[%d], lastSeq[%d], needCount[%d], flag[%d], up[%b]", Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(caVar.field_flag), Boolean.valueOf(z));
            this.PtZ = false;
            new com.tencent.mm.plugin.chatroom.a.a(this.dom.GUe.field_username, (int) j2, (int) j3, i2, z ? 1 : 0);
        }
        AppMethodBeat.o(35618);
    }

    @Override // com.tencent.mm.ui.l
    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        final ca caVar;
        boolean z;
        AppMethodBeat.i(35619);
        super.onScrollStateChanged(absListView, i2);
        if (i2 == 0) {
            try {
                View childAt = this.dom.getChildAt(this.dom.getFirstVisiblePosition());
                if (childAt != null && childAt.getTop() == 0) {
                    Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceTopLoadData true");
                    if (this.dom.gRM()) {
                        ca amt = ((k) this.dom.bh(k.class)).amt(0);
                        if (!(amt == null || amt.field_msgId == 0)) {
                            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(amt.field_flag), Integer.valueOf(amt.field_isSend), Long.valueOf(amt.field_msgId), Long.valueOf(amt.field_msgSvrId), Long.valueOf(amt.field_msgSeq), Long.valueOf(amt.field_createTime), Integer.valueOf(amt.getType()), amt.field_talker);
                            if (!((amt.field_flag & 1) == 0 || (amt.field_flag & 4) == 0)) {
                                this.dom.Pwe.gOa();
                            }
                        }
                        AppMethodBeat.o(35619);
                        return;
                    }
                } else if (this.dom.gRM() && this.dom.getChildAt(this.dom.getListView().getChildCount() - 1) != null) {
                    k kVar = (k) this.dom.bh(k.class);
                    if (this.dom.getLastVisiblePosition() == this.dom.getListView().getAdapter().getCount() - 1) {
                        ca caVar2 = null;
                        int i3 = 1;
                        while (true) {
                            if (i3 >= 5) {
                                caVar = caVar2;
                                break;
                            }
                            caVar2 = ((k) this.dom.bh(k.class)).amt(kVar.getCount() - i3);
                            if (caVar2 != null && caVar2.field_msgId != 0 && (caVar2.field_flag & 1) != 0) {
                                Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found i[%s]", Integer.valueOf(i3));
                                caVar = caVar2;
                                break;
                            }
                            i3++;
                        }
                        if (caVar == null || caVar.field_msgId == 0) {
                            if (caVar != null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (((caVar.field_flag & 2) != 0) && z) {
                                bg.aVF();
                                ca aEx = c.aSQ().aEx(caVar.field_talker);
                                if (!(aEx == null || aEx.field_msgId == 0 || aEx.field_createTime <= caVar.field_createTime)) {
                                    Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s] not need notify", Integer.valueOf(aEx.field_flag), Integer.valueOf(aEx.field_isSend), Long.valueOf(aEx.field_msgId), Long.valueOf(aEx.field_msgSvrId), Long.valueOf(aEx.field_msgSeq), Long.valueOf(aEx.field_createTime), Integer.valueOf(aEx.getType()), aEx.field_talker);
                                }
                            }
                        } else {
                            ca aK = ((l) g.af(l.class)).eiy().aK(caVar.field_talker, caVar.field_msgSeq);
                            if (aK.field_msgId != 0 && aK.field_msgId == caVar.field_msgId && (aK.field_flag & 1) == 0) {
                                Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange found msg not fault msgId[%s] flag[%s]", Long.valueOf(aK.field_msgId), Integer.valueOf(aK.field_flag));
                                AppMethodBeat.o(35619);
                                return;
                            }
                            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(caVar.field_flag), Integer.valueOf(caVar.field_isSend), Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId), Long.valueOf(caVar.field_msgSeq), Long.valueOf(caVar.field_createTime), Integer.valueOf(caVar.getType()), caVar.field_talker);
                            if ((caVar.field_flag & 1) == 0 || (caVar.field_flag & 4) != 0) {
                                AppMethodBeat.o(35619);
                                return;
                            }
                            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceBottomLoadData");
                            this.dom.Pwe.setIsBottomShowAll(false);
                            this.dom.Pwe.setBottomViewVisible(true);
                            this.dom.Pwe.By(true);
                            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found");
                            bg.aAk().postToWorker(new Runnable() {
                                /* class com.tencent.mm.ui.chatting.d.ba.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(35612);
                                    e.INSTANCE.idkeyStat(403, 7, 1, false);
                                    ba.this.cg(caVar);
                                    AppMethodBeat.o(35612);
                                }
                            });
                            AppMethodBeat.o(35619);
                            return;
                        }
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ChattingUI.SilenceMsgComponent", e2, "silenceMsgImp handleIdelScrollChange", new Object[0]);
                AppMethodBeat.o(35619);
                return;
            }
        }
        AppMethodBeat.o(35619);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        AppMethodBeat.i(35620);
        this.PtZ = false;
        this.Pub = this.dom.gRM();
        this.PtZ = false;
        this.Pua = false;
        AppMethodBeat.o(35620);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35621);
        EventCenter.instance.removeListener(this.Puc);
        bg.aVF();
        c.aST().b(this);
        AppMethodBeat.o(35621);
    }
}
