package com.tencent.mm.ui.chatting.n.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.b;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.n.f;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import org.xwalk.core.Log;

public abstract class a implements b.a {
    int PFA = 3;
    long PFi;
    long PFj;
    public d PFv;
    int PFw;
    int PFx;
    long PFy;
    long PFz;
    protected com.tencent.mm.ui.chatting.e.a dom;

    /* access modifiers changed from: protected */
    public abstract f a(d.a aVar, Bundle bundle, d.C2097d dVar);

    public a(com.tencent.mm.ui.chatting.e.a aVar, d dVar) {
        this.dom = aVar;
        this.PFv = dVar;
    }

    public void a(final d.a aVar, boolean z, final Bundle bundle) {
        Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] action:" + aVar + " isBlock:" + z + " username:" + this.dom.getTalkerUserName());
        if (Util.isNullOrNil(this.dom.getTalkerUserName())) {
            Log.w("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] username is null!");
            return;
        }
        g.Wl(13);
        ((k) this.dom.bh(k.class)).gOx();
        this.PFv.a(aVar, z, new d.c<ca>() {
            /* class com.tencent.mm.ui.chatting.n.a.a.AnonymousClass1 */

            @Override // com.tencent.mm.ui.chatting.h.d.c
            public final f b(d.C2097d<ca> dVar) {
                AppMethodBeat.i(36654);
                dVar.PDK = bundle;
                f a2 = a.this.a(aVar, bundle, dVar);
                AppMethodBeat.o(36654);
                return a2;
            }

            @Override // com.tencent.mm.ui.chatting.h.d.c
            public final void c(d.C2097d<ca> dVar) {
                AppMethodBeat.i(36655);
                a.this.PFw = dVar.gAZ;
                a.this.PFx = dVar.PDN;
                if (dVar.PDM.size() > 0) {
                    T t = dVar.PDM.get(0);
                    if (t != null) {
                        a.this.PFi = t.field_createTime;
                        a.this.PFz = t.field_msgSeq;
                    }
                    T t2 = dVar.PDM.get(dVar.PDM.size() - 1);
                    if (t2 != null) {
                        a.this.PFj = t2.field_createTime;
                        a.this.PFy = t2.field_msgSeq;
                    }
                }
                AppMethodBeat.o(36655);
            }
        });
    }

    public final com.tencent.mm.ui.chatting.e.a grq() {
        return this.dom;
    }

    @Override // com.tencent.mm.ui.chatting.h.b.a
    public void a(MMChattingListView mMChattingListView, d.C2097d<ca> dVar) {
        g.Wm(13);
        mMChattingListView.getBaseAdapter().notifyDataSetChanged();
        ((k) this.dom.bh(k.class)).gOy();
        if (dVar.PDL == d.a.ACTION_UPDATE) {
            this.dom.Pwc.eGg();
        }
    }

    public String toString() {
        return getClass().getName();
    }

    /* access modifiers changed from: protected */
    public final void any(final int i2) {
        this.PFA = 3;
        if (!this.dom.Pwg) {
            this.dom.amm(i2);
        } else {
            com.tencent.mm.ui.chatting.e.a aVar = this.dom;
            aVar.lf(i2, com.tencent.mm.cb.a.fromDPToPix((Context) aVar.Pwc.getContext(), 80));
        }
        this.dom.getListView().postDelayed(new Runnable() {
            /* class com.tencent.mm.ui.chatting.n.a.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(36656);
                if (a.this.grq().getFirstVisiblePosition() > i2 || i2 > a.this.grq().getLastVisiblePosition()) {
                    Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] pos:" + i2 + " reTryCount:" + a.this.PFA);
                    if (!a.this.dom.Pwg) {
                        a.this.grq().lf(i2, 0);
                    } else {
                        a.this.grq().lf(i2, com.tencent.mm.cb.a.fromDPToPix((Context) a.this.dom.Pwc.getContext(), 80));
                    }
                    a aVar = a.this;
                    aVar.PFA--;
                    if (a.this.PFA >= 0) {
                        a.this.grq().getListView().postDelayed(this, 20);
                        AppMethodBeat.o(36656);
                        return;
                    }
                } else {
                    Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] successfully! pos:" + i2);
                }
                AppMethodBeat.o(36656);
            }
        }, 200);
    }
}
