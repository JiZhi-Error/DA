package com.tencent.mm.ui.chatting.d;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.gamelife.a.c;
import com.tencent.mm.plugin.i.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.ab;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.h;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.v;
import com.tencent.mm.ui.chatting.h.d;

@a(gRF = ab.class)
public class ae extends a implements ab {
    private View PrT;
    private TextView PrU;
    private int PrV;
    private int PrW = 0;
    private Runnable azA;

    @Override // com.tencent.mm.ui.chatting.d.b.ab
    public final int gQA() {
        return this.PrV;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ab
    public final void gQB() {
        AppMethodBeat.i(35437);
        if (this.PrT == null) {
            AppMethodBeat.o(35437);
            return;
        }
        this.PrV = -1;
        if (this.PrT.getVisibility() == 0) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (float) this.PrT.getWidth(), 0.0f, 0.0f);
            translateAnimation.setDuration(300);
            translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.dom.Pwc.getContext(), 17432581));
            this.PrT.startAnimation(translateAnimation);
        }
        this.PrT.setVisibility(8);
        AppMethodBeat.o(35437);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ab
    public final void gQC() {
        AppMethodBeat.i(35438);
        int i2 = gQF() ? 5 : 10;
        if (this.PrV <= i2) {
            Log.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] mUnreadMessageCount is smaller than threshold:".concat(String.valueOf(i2)));
            this.PrT.setVisibility(8);
            AppMethodBeat.o(35438);
        } else if (this.PrT.getVisibility() == 0) {
            Log.w("MicroMsg.HistoryMsgTongueComponent", "[showMsgTongue] has show!!!");
            AppMethodBeat.o(35438);
        } else {
            this.PrT.removeCallbacks(this.azA);
            View view = this.PrT;
            AnonymousClass2 r1 = new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.ae.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(35436);
                    Log.i("MicroMsg.HistoryMsgTongueComponent", "show animation! GoBackToHistoryMsgLayout!!!");
                    ae.this.PrT.setVisibility(0);
                    ae.this.PrW = 1;
                    as asVar = (as) ae.this.dom.bh(as.class);
                    if (asVar.gRh() || asVar.gRj() || asVar.gRi()) {
                        ae.this.amC(1);
                    } else if (ae.b(ae.this)) {
                        ae.this.amC(3);
                    } else {
                        ae.this.amC(0);
                    }
                    TranslateAnimation translateAnimation = new TranslateAnimation((float) ae.this.PrT.getWidth(), 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration(300);
                    translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(ae.this.dom.Pwc.getContext(), 17432581));
                    ae.this.PrT.startAnimation(translateAnimation);
                    AppMethodBeat.o(35436);
                }
            };
            this.azA = r1;
            view.postDelayed(r1, 100);
            AppMethodBeat.o(35438);
        }
    }

    @Override // com.tencent.mm.ui.l
    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AppMethodBeat.i(35439);
        super.onScroll(absListView, i2, i3, i4);
        if (this.PrV > 0 && i4 - (i2 + 1) >= this.PrV && this.PrT != null && this.PrT.getVisibility() == 0) {
            Log.i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr jacks onScroll dismissMsgTongue mUnreadMessage[%d] [%d,%d]", Integer.valueOf(this.PrV), Integer.valueOf(i4), Integer.valueOf(i2));
            gQB();
        }
        AppMethodBeat.o(35439);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ab
    public final void gQD() {
        this.PrW = 0;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ab
    public final int gQE() {
        return this.PrW;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.chatting.d.b.ab
    public final void amC(int i2) {
        int i3;
        int i4;
        AppMethodBeat.i(35440);
        if (this.PrV < (gQF() ? 5 : 10) || this.PrT == null) {
            AppMethodBeat.o(35440);
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.PrT.getLayoutParams();
        switch (i2) {
            case -2:
                if (!((as) this.dom.bh(as.class)).gRh()) {
                    layoutParams.setMargins(0, this.dom.Pwc.getMMResources().getDimensionPixelSize(R.dimen.hs), 0, 0);
                    break;
                }
                break;
            case 0:
                layoutParams.setMargins(0, this.dom.Pwc.getMMResources().getDimensionPixelSize(R.dimen.hs), 0, 0);
                AppMethodBeat.o(35440);
                return;
            case 1:
                as asVar = (as) this.dom.bh(as.class);
                int gRk = asVar.gRh() ? asVar.gRk() : 0;
                if (asVar.gRi()) {
                    i3 = this.dom.Pwc.getMMResources().getDimensionPixelSize(R.dimen.im);
                } else {
                    i3 = 0;
                }
                if (asVar.gRj()) {
                    i4 = this.dom.Pwc.getMMResources().getDimensionPixelSize(R.dimen.cn);
                } else {
                    i4 = 0;
                }
                if (i3 <= gRk) {
                    i3 = gRk > i4 ? gRk : i4;
                } else if (i3 <= i4) {
                    i3 = i4;
                }
                layoutParams.setMargins(0, this.dom.Pwc.getMMResources().getDimensionPixelSize(R.dimen.hs) + i3, 0, 0);
                AppMethodBeat.o(35440);
                return;
            case 3:
                layoutParams.setMargins(0, this.dom.Pwc.getMMResources().getDimensionPixelSize(R.dimen.hs) * 3, 0, 0);
                AppMethodBeat.o(35440);
                return;
        }
        AppMethodBeat.o(35440);
    }

    private boolean gQF() {
        AppMethodBeat.i(35441);
        d dVar = (d) this.dom.bh(d.class);
        if (com.tencent.mm.model.ab.Jx(this.dom.getTalkerUserName()) || com.tencent.mm.model.ab.JC(this.dom.getTalkerUserName())) {
            AppMethodBeat.o(35441);
            return true;
        } else if (!this.dom.GUe.gBM() || dVar.gOM() == null || ((!dVar.gOM().UD() || ((b) g.af(b.class)).clc()) && !dVar.gOM().UC())) {
            AppMethodBeat.o(35441);
            return false;
        } else {
            AppMethodBeat.o(35441);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        AppMethodBeat.i(35442);
        super.gIk();
        this.PrT = this.dom.findViewById(R.id.avj);
        this.PrT.setVisibility(8);
        if (((h) this.dom.bh(h.class)).gPu()) {
            this.PrV = ((n) g.af(n.class)).avf(this.dom.getTalkerUserName());
        } else if (((i) this.dom.bh(i.class)).gPw()) {
            this.PrV = ((c) g.af(c.class)).avf(this.dom.getTalkerUserName());
        } else {
            bg.aVF();
            az bjY = com.tencent.mm.model.c.aST().bjY(this.dom.getTalkerUserName());
            if (bjY != null) {
                this.PrV = bjY.field_unReadCount;
            }
        }
        Log.i("MicroMsg.HistoryMsgTongueComponent", "[onChattingInit] mUnreadMessageCount:%s", Integer.valueOf(this.PrV));
        AppMethodBeat.o(35442);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        boolean z;
        final int aEM;
        AppMethodBeat.i(35443);
        super.gIm();
        d dVar = (d) this.dom.bh(d.class);
        if (dVar.gOP()) {
            this.PrV = dVar.gOY();
        }
        d dVar2 = (d) this.dom.bh(d.class);
        if ((Util.isNullOrNil(this.dom.getTalkerUserName()) || this.dom.gRK() || com.tencent.mm.model.ab.JA(this.dom.getTalkerUserName()) || com.tencent.mm.model.ab.IT(this.dom.getTalkerUserName()) || com.tencent.mm.model.ab.Jv(this.dom.getTalkerUserName()) || com.tencent.mm.model.ab.IW(this.dom.getTalkerUserName())) && !this.dom.gRL() && !dVar2.gOP() && !gQF()) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            Log.w("MicroMsg.HistoryMsgTongueComponent", "[tryShowTongue] no show tongue! username:%s unreadCount:%s isBizChat:%s", this.dom.getTalkerUserName(), Integer.valueOf(this.PrV), Boolean.valueOf(dVar.gOP()));
            this.PrT.setVisibility(8);
            this.PrW = 0;
            AppMethodBeat.o(35443);
            return;
        }
        int i2 = this.PrV;
        int i3 = gQF() ? 5 : 10;
        Log.i("MicroMsg.HistoryMsgTongueComponent", "[update] threshold:%s fixUnreadMessage:%s", Integer.valueOf(i3), Integer.valueOf(i2));
        if (i2 >= i3) {
            Log.i("MicroMsg.HistoryMsgTongueComponent", "[update] mGoBackToHistoryMsgLayout VISIBLE");
            this.PrU = (TextView) this.dom.findViewById(R.id.avk);
            z zVar = z.gmQ;
            if (zVar.gmU == null) {
                zVar.gmV = 1;
            } else {
                zVar.gmU.gnl = 1;
            }
            if (i2 > 999) {
                this.PrU.setText(String.format(this.dom.Pwc.getMMResources().getString(R.string.ayv), 999));
            } else {
                this.PrU.setText(String.format(this.dom.Pwc.getMMResources().getString(R.string.ayv), Integer.valueOf(i2)));
            }
            if (dVar.gOP()) {
                bg.aVF();
                aEM = com.tencent.mm.model.c.aSR().cb(this.dom.getTalkerUserName(), dVar.gPc()) - this.PrV;
            } else {
                bg.aVF();
                aEM = com.tencent.mm.model.c.aSQ().aEM(this.dom.getTalkerUserName()) - this.PrV;
            }
            this.PrT.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.ae.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(35435);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/HistoryMsgTongueComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    ae.this.PrW = 2;
                    z zVar = z.gmQ;
                    if (zVar.gmU != null) {
                        zVar.gmU.gnl = 2;
                    }
                    if (((v) ae.this.dom.bh(v.class)).gQb()) {
                        ((v) ae.this.dom.bh(v.class)).gQc();
                    } else {
                        ae.b(ae.this, aEM);
                    }
                    if (com.tencent.mm.model.ab.JC(ae.this.dom.getTalkerUserName())) {
                        ((com.tencent.mm.ui.chatting.d.b.g) ae.this.dom.bh(com.tencent.mm.ui.chatting.d.b.g.class)).gPn();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/HistoryMsgTongueComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(35435);
                }
            });
            if (!((v) this.dom.bh(v.class)).gQb()) {
                gQC();
            }
        }
        AppMethodBeat.o(35443);
    }

    static /* synthetic */ void b(ae aeVar, int i2) {
        AppMethodBeat.i(35444);
        ((k) aeVar.dom.bh(k.class)).a(i2, d.a.ACTION_POSITION);
        aeVar.gQB();
        AppMethodBeat.o(35444);
    }

    static /* synthetic */ boolean b(ae aeVar) {
        AppMethodBeat.i(35445);
        if (!com.tencent.mm.model.ab.JE(aeVar.dom.getTalkerUserName()) && com.tencent.mm.model.ab.Eq(aeVar.dom.getTalkerUserName())) {
            bg.aVF();
            az bjY = com.tencent.mm.model.c.aST().bjY(aeVar.dom.getTalkerUserName());
            if (bjY == null || (bjY.field_showTips & 1) > 0) {
                AppMethodBeat.o(35445);
                return false;
            }
            bg.aVF();
            if (com.tencent.mm.model.c.aSN().Kn(aeVar.dom.getTalkerUserName()).fuH == 1 && ((com.tencent.mm.ui.chatting.d.b.ae) aeVar.dom.bh(com.tencent.mm.ui.chatting.d.b.ae.class)).aqG() >= 40) {
                AppMethodBeat.o(35445);
                return true;
            }
        }
        AppMethodBeat.o(35445);
        return false;
    }
}
