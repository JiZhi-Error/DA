package com.tencent.mm.ui.chatting.n.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class f extends a {
    private volatile long PFN = 0;
    private volatile long PFO = 0;
    private boolean PFR;
    private Runnable PFS;
    private String talker = grq().getTalkerUserName();
    private volatile long wZu = 0;

    public f(a aVar, d dVar) {
        super(aVar, dVar);
        AppMethodBeat.i(36677);
        Log.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[ChattingSearchDataPresenter] talker:%s", this.talker);
        AppMethodBeat.o(36677);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.n.a.a
    public final com.tencent.mm.ui.chatting.n.f a(d.a aVar, Bundle bundle, d.C2097d dVar) {
        int max;
        int i2;
        int i3;
        AppMethodBeat.i(36678);
        switch (aVar) {
            case ACTION_POSITION:
            case ACTION_ENTER:
                if (bundle != null) {
                    long j2 = bundle.getLong("MSG_ID");
                    this.PFR = bundle.getBoolean("IS_LOAD_ALL", false);
                    bg.aVF();
                    ca Hb = c.aSQ().Hb(j2);
                    if (Hb.field_msgId == j2) {
                        long j3 = Hb.field_createTime;
                        if (j3 < this.PFN || j3 > this.PFO) {
                            this.PFN = j3;
                            this.wZu = ((l) g.af(l.class)).eiy().aEQ(this.talker);
                            if (this.PFR) {
                                this.PFO = this.wZu;
                            } else {
                                bg.aVF();
                                this.PFO = c.aSQ().j(this.talker, j3, 48);
                            }
                            bg.aVF();
                            int E = c.aSQ().E(this.talker, this.PFN, this.PFO);
                            Log.v("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reset position, reload count %d", Integer.valueOf(E));
                            if (E < 48) {
                                Log.d("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", Long.valueOf(this.PFN), 0);
                                bg.aVF();
                                this.PFN = c.aSQ().i(this.talker, this.PFN, 48);
                                bg.aVF();
                                i3 = c.aSQ().E(this.talker, this.PFN, j3);
                            } else {
                                i3 = 0;
                            }
                        } else {
                            bg.aVF();
                            i3 = c.aSQ().E(this.talker, this.PFN, j3);
                        }
                        dVar.selection = i3;
                        max = 0;
                        i2 = 0;
                        break;
                    } else {
                        Log.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "get msg info by id %d error", Long.valueOf(j2));
                        max = 0;
                        i2 = 0;
                        break;
                    }
                } else {
                    Log.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[handleEnter] sourceArgs is null!");
                    max = 0;
                    i2 = 0;
                    break;
                }
                break;
            case ACTION_TOP:
                bg.aVF();
                long i4 = c.aSQ().i(this.talker, this.PFN, 48);
                bg.aVF();
                i2 = Math.max(0, c.aSQ().E(this.talker, i4, this.PFN) - 1);
                this.PFN = i4;
                max = 0;
                break;
            case ACTION_BOTTOM:
                bg.aVF();
                long j4 = c.aSQ().j(this.talker, this.PFO, 48);
                bg.aVF();
                max = Math.max(0, c.aSQ().E(this.talker, this.PFO, j4) - 1);
                this.PFO = j4;
                i2 = 0;
                break;
            case ACTION_UPDATE:
                ca aEx = ((l) g.af(l.class)).eiy().aEx(this.talker);
                this.wZu = aEx.field_createTime;
                bg.aVF();
                max = Math.max(0, c.aSQ().E(this.talker, this.PFO, this.wZu) - 1);
                if (this.PFR || max <= 480) {
                    this.PFO = this.wZu;
                } else if (aEx.field_isSend == 1 && this.wZu != aEx.field_createTime) {
                    this.wZu = aEx.field_createTime;
                    bg.aVF();
                    this.PFN = c.aSQ().i(this.talker, this.PFN, 48);
                    this.PFO = this.wZu;
                }
                i2 = 0;
                break;
            default:
                max = 0;
                i2 = 0;
                break;
        }
        Log.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "mode[%s] query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]", aVar, Long.valueOf(this.PFN), Long.valueOf(this.PFO), Long.valueOf(this.wZu), Integer.valueOf(i2), Integer.valueOf(max));
        com.tencent.mm.ui.chatting.n.d dVar2 = new com.tencent.mm.ui.chatting.n.d(grq().getTalkerUserName(), this.PFN, this.PFO);
        AppMethodBeat.o(36678);
        return dVar2;
    }

    @Override // com.tencent.mm.ui.chatting.h.b.a, com.tencent.mm.ui.chatting.n.a.a
    public final void a(final MMChattingListView mMChattingListView, d.C2097d<ca> dVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(36679);
        super.a(mMChattingListView, dVar);
        d.a aVar = dVar.PDL;
        final int i2 = dVar.selection;
        mMChattingListView.getListView().setTranscriptMode(0);
        switch (aVar) {
            case ACTION_POSITION:
            case ACTION_ENTER:
                if (i2 >= 0) {
                    boolean booleanValue = grq().Pwc.getBooleanExtra("need_hight_item", false).booleanValue();
                    any(i2);
                    if (booleanValue) {
                        grq().Pwc.getLongExtra("msg_local_id", -1);
                        Log.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[matteHighLightItem] position:%s", Integer.valueOf(i2));
                        MMHandlerThread.removeRunnable(this.PFS);
                        AnonymousClass1 r0 = new Runnable() {
                            /* class com.tencent.mm.ui.chatting.n.a.f.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(36675);
                                int max = Math.max(0, i2 - f.this.grq().getFirstVisiblePosition());
                                f.this.any(i2);
                                mMChattingListView.setHighLightChild(max);
                                bg.aVF();
                                c.azQ().set(ar.a.USERINFO_POSITION_AT_CHATRECORD_FIRST_IN_BOOLEAN, Boolean.FALSE);
                                AppMethodBeat.o(36675);
                            }
                        };
                        this.PFS = r0;
                        MMHandlerThread.postToMainThreadDelayed(r0, 500);
                        break;
                    }
                }
                break;
            case ACTION_TOP:
                mMChattingListView.Bx(false);
                p.a(mMChattingListView.getListView(), (mMChattingListView.getCurCount() - mMChattingListView.getPreCount()) + 1, gTR() + mMChattingListView.getTopHeight(), false);
                int curCount = mMChattingListView.getCurCount() - mMChattingListView.getPreCount();
                if (curCount > 0) {
                    ((k) grq().bh(k.class)).amv(curCount);
                    break;
                }
                break;
            case ACTION_BOTTOM:
                mMChattingListView.By(false);
                p.a(mMChattingListView.getListView(), mMChattingListView.getPreCount() + 1, (mMChattingListView.getListView().getHeight() - gTR()) - mMChattingListView.getBottomHeight(), false);
                break;
        }
        if (grq().getLastVisiblePosition() == dVar.PDN - 1) {
            mMChattingListView.getListView().setTranscriptMode(1);
        }
        mMChattingListView.setBottomViewVisible(true);
        long aEP = ((l) g.af(l.class)).eiy().aEP(this.talker);
        Log.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[isShowTopAll] firstMsgCreateTime:%s lastTopMsgCreateTime:%s", Long.valueOf(aEP), Long.valueOf(this.PFN));
        if (this.PFN <= aEP) {
            z = true;
        } else {
            z = false;
        }
        mMChattingListView.setIsTopShowAll(z);
        if (this.PFO < this.wZu) {
            z2 = false;
        }
        mMChattingListView.setIsBottomShowAll(z2);
        AppMethodBeat.o(36679);
    }

    private int gTR() {
        AppMethodBeat.i(36680);
        int gQy = ((aa) grq().bh(aa.class)).gQy();
        AppMethodBeat.o(36680);
        return gQy;
    }
}
