package com.tencent.mm.ui.chatting.n.a;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.n.e;
import com.tencent.mm.ui.chatting.n.f;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class g extends a {
    private int PFD = 0;
    private String talker = grq().Pwc.getStringExtra("key_notify_message_real_username");

    public g(a aVar, d dVar) {
        super(aVar, dVar);
        AppMethodBeat.i(233512);
        Log.i("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgPresenter", "[ChattingSingleNotifyMsgPresenter] talker:%s", this.talker);
        AppMethodBeat.o(233512);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.n.a.a
    public final f a(d.a aVar, Bundle bundle, d.C2097d dVar) {
        int i2;
        e eVar;
        AppMethodBeat.i(233513);
        bg.aVF();
        cf notifyMessageRecordStorage = c.getNotifyMessageRecordStorage();
        String str = this.talker;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*) FROM NotifyMessageRecord WHERE talker = '").append(Util.escapeSqlValue(str)).append("'");
        Cursor rawQuery = notifyMessageRecordStorage.kOg.rawQuery(sb.toString(), null);
        if (rawQuery.moveToLast()) {
            i2 = rawQuery.getInt(0);
        } else {
            i2 = 0;
        }
        rawQuery.close();
        switch (aVar) {
            case ACTION_ENTER:
                eVar = new e(this.talker, 16, i2);
                break;
            case ACTION_TOP:
                eVar = new e(this.talker, this.PFx + 48, i2);
                break;
            case ACTION_UPDATE:
                eVar = new e(this.talker, Math.max(i2 - this.PFD, 0) + this.PFx, i2);
                break;
            default:
                eVar = null;
                break;
        }
        this.PFD = i2;
        AppMethodBeat.o(233513);
        return eVar;
    }

    @Override // com.tencent.mm.ui.chatting.h.b.a, com.tencent.mm.ui.chatting.n.a.a
    public final void a(MMChattingListView mMChattingListView, d.C2097d<ca> dVar) {
        int i2;
        AppMethodBeat.i(233514);
        super.a(mMChattingListView, dVar);
        d.a aVar = dVar.PDL;
        final int i3 = dVar.selection;
        final Bundle bundle = dVar.PDK;
        switch (aVar) {
            case ACTION_ENTER:
                grq().BN(false);
                AppMethodBeat.o(233514);
                return;
            case ACTION_TOP:
                mMChattingListView.Bx(false);
                p.a(mMChattingListView.getListView(), (mMChattingListView.getCurCount() - mMChattingListView.getPreCount()) + 1, gTR() + mMChattingListView.getTopHeight(), false);
                int curCount = mMChattingListView.getCurCount() - mMChattingListView.getPreCount();
                if (curCount > 0) {
                    ((k) grq().bh(k.class)).amv(curCount);
                    AppMethodBeat.o(233514);
                    return;
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
                }
                mMChattingListView.getListView().post(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.n.a.g.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(233510);
                        k kVar = (k) g.this.grq().bh(k.class);
                        if (bundle == null || bundle.getInt("SCENE", 0) != 1) {
                            if (bundle != null && bundle.getInt("SCENE", 0) == 2) {
                                kVar.amu(i3);
                                a grq = g.this.grq();
                                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i3, new com.tencent.mm.hellhoundlib.b.a());
                                com.tencent.mm.hellhoundlib.a.a.a(grq, a2.axQ(), "com/tencent/mm/ui/chatting/source/presenter/ChattingSingleNotifyMsgPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                                grq.scrollToPosition(((Integer) a2.pG(0)).intValue());
                                com.tencent.mm.hellhoundlib.a.a.a(grq, "com/tencent/mm/ui/chatting/source/presenter/ChattingSingleNotifyMsgPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                            }
                            AppMethodBeat.o(233510);
                            return;
                        }
                        g.this.grq().Pwf = i3;
                        g.this.any(i3);
                        AppMethodBeat.o(233510);
                    }
                });
                break;
            case ACTION_BOTTOM:
                mMChattingListView.By(false);
                p.a(mMChattingListView.getListView(), mMChattingListView.getPreCount() + 1, (mMChattingListView.getListView().getHeight() - gTR()) - mMChattingListView.getBottomHeight(), false);
                AppMethodBeat.o(233514);
                return;
        }
        AppMethodBeat.o(233514);
    }

    private int gTR() {
        AppMethodBeat.i(233515);
        int gQy = ((aa) grq().bh(aa.class)).gQy();
        AppMethodBeat.o(233515);
        return gQy;
    }
}
