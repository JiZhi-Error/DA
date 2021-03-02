package com.tencent.mm.ui.chatting.n.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ab;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.n.b;
import com.tencent.mm.ui.chatting.n.f;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.lang.ref.WeakReference;

public final class d extends a {
    private boolean PFE = false;
    private boolean PFF = false;

    public d(com.tencent.mm.ui.chatting.e.a aVar, com.tencent.mm.ui.chatting.h.d dVar) {
        super(aVar, dVar);
    }

    @Override // com.tencent.mm.ui.chatting.n.a.a
    public final void a(d.a aVar, boolean z, Bundle bundle) {
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(36666);
        if (aVar == d.a.ACTION_UPDATE) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (this.PFE) {
                Log.w("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position before");
                bundle.putBoolean("has_position_tongue", true);
            } else if (this.PFF) {
                bundle.putBoolean("has_position_search", true);
            }
        } else if (aVar == d.a.ACTION_POSITION) {
            if (bundle == null || bundle.getInt("SCENE") != 2) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.PFE = z2;
            if (bundle == null || bundle.getInt("SCENE") != 1) {
                z3 = false;
            }
            this.PFF = z3;
            Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position!");
        }
        super.a(aVar, z, bundle);
        AppMethodBeat.o(36666);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.n.a.a
    public final f a(d.a aVar, Bundle bundle, d.C2097d dVar) {
        AppMethodBeat.i(36667);
        b bVar = new b(grq().getTalkerUserName(), aVar, bundle, this.PFy, this.PFi, this.PFj, this.PFx, dVar, bundle != null && bundle.getInt("SCENE") == 1);
        AppMethodBeat.o(36667);
        return bVar;
    }

    @Override // com.tencent.mm.ui.chatting.h.b.a, com.tencent.mm.ui.chatting.n.a.a
    public final void a(MMChattingListView mMChattingListView, d.C2097d<ca> dVar) {
        int i2;
        AppMethodBeat.i(36668);
        int size = dVar.PDM.size();
        int i3 = dVar.gAZ;
        int i4 = dVar.selection;
        SparseArray<T> sparseArray = dVar.PDO;
        d.a aVar = dVar.PDL;
        T t = sparseArray.get(0);
        T t2 = sparseArray.get(sparseArray.size() - 1);
        super.a(mMChattingListView, dVar);
        if (dVar.PDL != d.a.ACTION_UPDATE) {
            mMChattingListView.getListView().setTranscriptMode(0);
        }
        if (sparseArray.size() <= 6 && i3 > 6) {
            Log.e("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] may be err! talker:%s", grq().getTalkerUserName());
        }
        switch (dVar.PDL) {
            case ACTION_ENTER:
                mMChattingListView.By(false);
                grq().BN(true);
                break;
            case ACTION_UPDATE:
                if (dVar.PDK != null && dVar.PDK.getBoolean("need_scroll_to_bottom", false)) {
                    mMChattingListView.By(false);
                    grq().BN(true);
                    this.PFE = false;
                }
                this.PFF = false;
                break;
            case ACTION_BOTTOM:
                if (dVar.PDK == null || !dVar.PDK.getBoolean("load_bottom", false)) {
                    int preCount = mMChattingListView.getPreCount() + 1;
                    int height = (mMChattingListView.getListView().getHeight() - gTR()) - mMChattingListView.getBottomHeight();
                    grq().lf(preCount, height);
                    Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "selection:" + preCount + " offset:" + height + " curCount:" + mMChattingListView.getCurCount() + " preCount:" + mMChattingListView.getPreCount());
                } else {
                    mMChattingListView.getListView().setTranscriptMode(1);
                    grq().BN(true);
                    ((ab) grq().bh(ab.class)).gQC();
                    Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "after enter load bottom!");
                }
                mMChattingListView.By(false);
                break;
            case ACTION_POSITION:
                if (!(dVar.PDK != null && dVar.PDK.getInt("SCENE") == 1)) {
                    if (dVar.PDK != null) {
                        mMChattingListView.c(false, null);
                        long j2 = dVar.PDK.getLong("MSG_ID", 0);
                        int size2 = sparseArray.size() - 1;
                        while (true) {
                            if (size2 < 0) {
                                i2 = 0;
                            } else {
                                T t3 = sparseArray.get(size2);
                                if (t3 == null || t3.field_msgId != j2) {
                                    size2--;
                                } else {
                                    i2 = size2;
                                }
                            }
                        }
                        int max = Math.max(0, i2);
                        dVar.selection = max;
                        ((k) grq().bh(k.class)).amu(dVar.selection);
                        any(dVar.selection);
                        Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "pos:" + max + " msgId:" + j2);
                        break;
                    }
                } else {
                    any(dVar.selection);
                    Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "isFromSearch! selection:" + dVar.selection);
                    break;
                }
                break;
            case ACTION_TOP:
                mMChattingListView.Bx(false);
                int curCount = mMChattingListView.getCurCount() - mMChattingListView.getPreCount();
                grq().lf(curCount + 1, gTR() + mMChattingListView.getTopHeight());
                int curCount2 = mMChattingListView.getCurCount() - mMChattingListView.getPreCount();
                Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "select:" + curCount + " curCount:" + mMChattingListView.getCurCount() + " preCount:" + mMChattingListView.getPreCount());
                if (curCount2 > 0) {
                    ((k) grq().bh(k.class)).amv(curCount2);
                    break;
                }
                break;
        }
        mMChattingListView.setIsTopShowAll(true);
        mMChattingListView.setIsBottomShowAll(true);
        long j3 = 0;
        if (t != null) {
            j3 = t.field_createTime;
        }
        long j4 = 0;
        if (t2 != null) {
            j4 = t2.field_createTime;
        }
        Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] talker:%s action:%s loadedCount:%s allCount:%s selection:%s lastTopCreateTime:%s lastBottomCreateTime:%s", grq().getTalkerUserName(), aVar, Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j3), Long.valueOf(j4));
        g.aAk().postToWorker(new a(this, mMChattingListView, grq().getTalkerUserName(), j3, j4, (byte) 0));
        AppMethodBeat.o(36668);
    }

    class a implements Runnable {
        private long PFG;
        private long PFH;
        WeakReference<MMChattingListView> PFI;
        private String username;
        private View view;

        /* synthetic */ a(d dVar, MMChattingListView mMChattingListView, String str, long j2, long j3, byte b2) {
            this(mMChattingListView, str, j2, j3);
        }

        private a(MMChattingListView mMChattingListView, String str, long j2, long j3) {
            AppMethodBeat.i(36664);
            this.view = mMChattingListView;
            this.username = str;
            this.PFI = new WeakReference<>(mMChattingListView);
            this.PFG = j3;
            this.PFH = j2;
            AppMethodBeat.o(36664);
        }

        public final void run() {
            int i2;
            int i3;
            AppMethodBeat.i(36665);
            com.tencent.mm.plugin.messenger.foundation.a.a.b eit = ((l) g.af(l.class)).eit();
            int E = ((l) g.af(l.class)).eiy().E(this.username, 0, this.PFH - 1);
            if (E <= 0) {
                i2 = eit.A(this.username, 0, this.PFH - 1);
            } else {
                i2 = 0;
            }
            final boolean z = E <= 0 && i2 <= 0;
            int E2 = ((l) g.af(l.class)).eiy().E(this.username, this.PFG + 1, MAlarmHandler.NEXT_FIRE_INTERVAL);
            if (E2 <= 0) {
                i3 = eit.A(this.username, this.PFG + 1, MAlarmHandler.NEXT_FIRE_INTERVAL);
            } else {
                i3 = 0;
            }
            final boolean z2 = E2 <= 0 && i3 <= 0;
            if (z2) {
                aj aEh = eit.aEh(this.username);
                z2 = aEh.field_lastLocalSeq == aEh.field_lastPushSeq;
            }
            Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[CheckEdgeTask#run] isShowTopAll:%s topCount:%s topBlockCount:%s isShowBottomAll:%s bottomCount:%s bottomBlockCount:%s", Boolean.valueOf(z), Integer.valueOf(E), Integer.valueOf(i2), Boolean.valueOf(z2), Integer.valueOf(E2), Integer.valueOf(i3));
            this.view.postDelayed(new Runnable() {
                /* class com.tencent.mm.ui.chatting.n.a.d.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(36663);
                    MMChattingListView mMChattingListView = a.this.PFI.get();
                    if (mMChattingListView != null) {
                        mMChattingListView.getListView().setTranscriptMode(1);
                        mMChattingListView.setIsTopShowAll(z);
                        mMChattingListView.setIsBottomShowAll(z2);
                    }
                    AppMethodBeat.o(36663);
                }
            }, 60);
            AppMethodBeat.o(36665);
        }
    }

    private int gTR() {
        AppMethodBeat.i(36669);
        int gQy = ((aa) grq().bh(aa.class)).gQy();
        AppMethodBeat.o(36669);
        return gQy;
    }
}
