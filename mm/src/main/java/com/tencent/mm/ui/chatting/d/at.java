package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.widget.ListView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.d;

@a(gRF = aj.class)
public class at extends a implements aj {
    private IListener<tr> Ptf = new IListener<tr>() {
        /* class com.tencent.mm.ui.chatting.d.at.AnonymousClass1 */

        {
            AppMethodBeat.i(233178);
            this.__eventId = tr.class.getName().hashCode();
            AppMethodBeat.o(233178);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tr trVar) {
            boolean z;
            AppMethodBeat.i(233179);
            tr trVar2 = trVar;
            Log.i("MicroMsg.ChattingUI.RemittanceSearchComponent", "ScrollChattingUIConversationList: %s, %s", trVar2.eae.dkU, Long.valueOf(trVar2.eae.msgId));
            at atVar = at.this;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - atVar.lastClickTime >= 1200) {
                z = false;
            } else {
                z = true;
            }
            atVar.lastClickTime = currentTimeMillis;
            if (z) {
                AppMethodBeat.o(233179);
            } else {
                at.this.dom.Pwg = true;
                ((k) at.this.dom.bh(k.class)).a(trVar2.eae.msgId, true, d.a.ACTION_POSITION);
                if (at.this.dom.getListView() == null) {
                    AppMethodBeat.o(233179);
                } else {
                    at.this.dom.getListView().postDelayed(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.d.at.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(233177);
                            final int i2 = at.this.dom.Pwf;
                            if (at.b(at.this.dom.getListView(), i2)) {
                                int max = Math.max(1, i2 - at.this.dom.getFirstVisiblePosition());
                                if (at.this.dom.Pwe.gOd() != null) {
                                    at.this.dom.Pwe.gOd().setHighLightChildNew(max);
                                    at.this.dom.Pwg = false;
                                }
                                AppMethodBeat.o(233177);
                                return;
                            }
                            h.RTc.n(new Runnable() {
                                /* class com.tencent.mm.ui.chatting.d.at.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(233176);
                                    int max = Math.max(1, i2 - at.this.dom.getFirstVisiblePosition());
                                    if (at.this.dom.Pwe.gOd() != null) {
                                        at.this.dom.Pwe.gOd().setHighLightChildNew(max);
                                        at.this.dom.Pwg = false;
                                    }
                                    AppMethodBeat.o(233176);
                                }
                            }, 200);
                            AppMethodBeat.o(233177);
                        }
                    }, 220);
                    AppMethodBeat.o(233179);
                }
            }
            return false;
        }
    };
    long lastClickTime;

    public at() {
        AppMethodBeat.i(233180);
        AppMethodBeat.o(233180);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(233181);
        EventCenter.instance.add(this.Ptf);
        AppMethodBeat.o(233181);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(233182);
        EventCenter.instance.removeListener(this.Ptf);
        this.dom.Pwg = false;
        AppMethodBeat.o(233182);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(233183);
        super.gOK();
        EventCenter.instance.removeListener(this.Ptf);
        this.dom.Pwg = false;
        AppMethodBeat.o(233183);
    }

    @Override // com.tencent.mm.ui.l
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(233184);
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(233184);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
    }

    static /* synthetic */ boolean b(ListView listView, int i2) {
        AppMethodBeat.i(233185);
        int lastVisiblePosition = listView.getLastVisiblePosition();
        if (listView.getFirstVisiblePosition() >= i2 || i2 >= lastVisiblePosition) {
            AppMethodBeat.o(233185);
            return false;
        }
        AppMethodBeat.o(233185);
        return true;
    }
}
