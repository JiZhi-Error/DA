package com.tencent.mm.ui.chatting.n.a;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.n.f;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public class e extends a {
    private int PFD = 0;
    private volatile long PFN = 0;
    private volatile long PFO = 0;
    private volatile long wZu = 0;

    public e(a aVar, com.tencent.mm.ui.chatting.h.e eVar) {
        super(aVar, eVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.n.a.a
    public final f a(d.a aVar, Bundle bundle, d.C2097d dVar) {
        int i2;
        AppMethodBeat.i(36672);
        f fVar = null;
        bg.aVF();
        int aEM = c.aSQ().aEM(grq().getTalkerUserName());
        switch (aVar) {
            case ACTION_ENTER:
                fVar = new com.tencent.mm.ui.chatting.n.c(grq().getTalkerUserName(), 16, aEM);
                break;
            case ACTION_TOP:
                fVar = new com.tencent.mm.ui.chatting.n.c(grq().getTalkerUserName(), this.PFx + 48, aEM);
                break;
            case ACTION_UPDATE:
                int i3 = aEM - this.PFD;
                String talkerUserName = grq().getTalkerUserName();
                int i4 = this.PFx;
                if (i3 <= 0) {
                    i3 = 0;
                }
                fVar = new com.tencent.mm.ui.chatting.n.c(talkerUserName, i3 + i4, aEM);
                break;
            case ACTION_POSITION:
                if (bundle != null) {
                    if (bundle.getInt("SCENE", 0) != 1) {
                        if (bundle.getInt("SCENE", 0) == 2) {
                            if (bundle != null) {
                                int i5 = bundle.getInt("MSG_POSITION");
                                int i6 = aEM - i5;
                                Log.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] totalCount:%s position:%s count:%s", Integer.valueOf(aEM), Integer.valueOf(i5), Integer.valueOf(i6));
                                fVar = new com.tencent.mm.ui.chatting.n.c(grq().getTalkerUserName(), i6, aEM);
                                break;
                            } else {
                                Log.e("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] sourceArgs == null");
                                fVar = new com.tencent.mm.ui.chatting.n.c(grq().getTalkerUserName(), this.PFx, aEM);
                                break;
                            }
                        }
                    } else {
                        Log.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForSearch]");
                        if (bundle != null) {
                            String talkerUserName2 = grq().getTalkerUserName();
                            long j2 = bundle.getLong("MSG_ID");
                            boolean z = bundle.getBoolean("IS_LOAD_ALL", false);
                            bg.aVF();
                            ca Hb = c.aSQ().Hb(j2);
                            if (Hb.field_msgId == j2) {
                                long j3 = Hb.field_createTime;
                                if (j3 < this.PFN || j3 > this.PFO) {
                                    this.PFN = j3;
                                    this.wZu = ((l) g.af(l.class)).eiy().aEQ(talkerUserName2);
                                    if (z) {
                                        this.PFO = this.wZu;
                                    } else {
                                        bg.aVF();
                                        this.PFO = c.aSQ().j(talkerUserName2, j3, 48);
                                    }
                                    bg.aVF();
                                    int E = c.aSQ().E(talkerUserName2, this.PFN, this.PFO);
                                    Log.v("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reset position, reload count %d", Integer.valueOf(E));
                                    if (E < 48) {
                                        Log.d("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", Long.valueOf(this.PFN), 0);
                                        bg.aVF();
                                        this.PFN = c.aSQ().i(talkerUserName2, this.PFN, 48);
                                        bg.aVF();
                                        i2 = c.aSQ().E(talkerUserName2, this.PFN, j3);
                                    } else {
                                        i2 = 0;
                                    }
                                } else {
                                    bg.aVF();
                                    i2 = c.aSQ().E(talkerUserName2, this.PFN, j3);
                                }
                                dVar.selection = i2;
                                fVar = new com.tencent.mm.ui.chatting.n.d(grq().getTalkerUserName(), this.PFN, this.PFO);
                                break;
                            } else {
                                Log.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "get msg info by id %d error", Long.valueOf(j2));
                                fVar = new com.tencent.mm.ui.chatting.n.d(grq().getTalkerUserName(), this.PFN, this.PFO);
                                break;
                            }
                        } else {
                            Log.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handleEnter] sourceArgs is null!");
                            fVar = new com.tencent.mm.ui.chatting.n.d(grq().getTalkerUserName(), this.PFN, this.PFO);
                            break;
                        }
                    }
                } else {
                    Log.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "null == sourceArgs!");
                    AppMethodBeat.o(36672);
                    return null;
                }
                break;
        }
        this.PFD = aEM;
        AppMethodBeat.o(36672);
        return fVar;
    }

    @Override // com.tencent.mm.ui.chatting.h.b.a, com.tencent.mm.ui.chatting.n.a.a
    public final void a(MMChattingListView mMChattingListView, d.C2097d<ca> dVar) {
        int i2;
        final int i3;
        boolean z;
        AppMethodBeat.i(36673);
        super.a(mMChattingListView, dVar);
        d.a aVar = dVar.PDL;
        SparseArray<T> sparseArray = dVar.PDO;
        int size = dVar.PDM.size();
        int i4 = dVar.gAZ;
        int i5 = dVar.selection;
        final Bundle bundle = dVar.PDK;
        T t = sparseArray.get(0);
        T t2 = sparseArray.get(sparseArray.size() - 1);
        if (t != null) {
            this.PFN = t.field_createTime;
        }
        if (t2 != null) {
            this.PFO = t2.field_createTime;
        }
        switch (aVar) {
            case ACTION_ENTER:
                grq().BN(false);
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
            case ACTION_POSITION:
                if (bundle == null) {
                    i2 = -1;
                } else {
                    i2 = bundle.getInt("MSG_POSITION", -1);
                }
                if (i2 != -1) {
                    i3 = Math.max(0, mMChattingListView.getCurCount() - (dVar.gAZ - i2));
                    dVar.selection = i3;
                } else {
                    i3 = i5;
                }
                mMChattingListView.getListView().post(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.n.a.e.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(36670);
                        k kVar = (k) e.this.grq().bh(k.class);
                        if (bundle == null || bundle.getInt("SCENE", 0) != 1) {
                            if (bundle != null && bundle.getInt("SCENE", 0) == 2) {
                                kVar.amu(i3);
                                a grq = e.this.grq();
                                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i3, new com.tencent.mm.hellhoundlib.b.a());
                                com.tencent.mm.hellhoundlib.a.a.a(grq, a2.axQ(), "com/tencent/mm/ui/chatting/source/presenter/ChattingNormalDataPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                                grq.scrollToPosition(((Integer) a2.pG(0)).intValue());
                                com.tencent.mm.hellhoundlib.a.a.a(grq, "com/tencent/mm/ui/chatting/source/presenter/ChattingNormalDataPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                            }
                            AppMethodBeat.o(36670);
                            return;
                        }
                        e.this.grq().Pwf = i3;
                        e.this.any(i3);
                        AppMethodBeat.o(36670);
                    }
                });
                i5 = i3;
                break;
            case ACTION_BOTTOM:
                mMChattingListView.By(false);
                p.a(mMChattingListView.getListView(), mMChattingListView.getPreCount() + 1, (mMChattingListView.getListView().getHeight() - gTR()) - mMChattingListView.getBottomHeight(), false);
                break;
        }
        if (aVar != d.a.ACTION_ENTER) {
            Log.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[onViewUpdate] mode:%s lastTopMsgCreateTime:%s lastBottomMsgCreateTime:%s loadedCount:%s allCount:%s selection:%s", aVar, Long.valueOf(this.PFN), Long.valueOf(this.PFO), Integer.valueOf(size), Integer.valueOf(i4), Integer.valueOf(i5));
            String talkerUserName = grq().getTalkerUserName();
            long aEk = ((l) g.af(l.class)).aTq().aEk(talkerUserName);
            bg.aVF();
            int E = c.aSQ().E(talkerUserName, 0, aEk);
            Log.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", talkerUserName, Long.valueOf(aEk), Integer.valueOf(E));
            if (i4 - E <= size) {
                z = true;
            } else {
                z = false;
            }
            mMChattingListView.setIsTopShowAll(z);
            mMChattingListView.setIsBottomShowAll(true);
        }
        AppMethodBeat.o(36673);
    }

    private int gTR() {
        AppMethodBeat.i(36674);
        int gQy = ((aa) grq().bh(aa.class)).gQy();
        AppMethodBeat.o(36674);
        return gQy;
    }
}
