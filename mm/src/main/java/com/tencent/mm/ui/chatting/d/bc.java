package com.tencent.mm.ui.chatting.d;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.u;

public class bc extends a implements af {
    private View Put;
    private ViewGroup Puu;
    private boolean Puv;
    private boolean Puw;
    private final long Pux = 259200000;
    private ChatFooter.c Puy = new ChatFooter.c() {
        /* class com.tencent.mm.ui.chatting.d.bc.AnonymousClass2 */

        @Override // com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c
        public final void a(Boolean bool, Boolean bool2) {
            AppMethodBeat.i(35642);
            if (bool.booleanValue()) {
                if (bool2.booleanValue()) {
                    bc bcVar = bc.this;
                    Boolean bool3 = Boolean.TRUE;
                    bc.a(bcVar, bool3, bool3);
                    AppMethodBeat.o(35642);
                    return;
                }
                bc.a(bc.this, Boolean.FALSE, Boolean.TRUE);
            }
            AppMethodBeat.o(35642);
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c
        public final void b(Boolean bool, Boolean bool2) {
            AppMethodBeat.i(35643);
            if (bool.booleanValue()) {
                if (bool2.booleanValue()) {
                    bc.a(bc.this, Boolean.TRUE, Boolean.FALSE);
                    AppMethodBeat.o(35643);
                    return;
                }
                bc bcVar = bc.this;
                Boolean bool3 = Boolean.FALSE;
                bc.a(bcVar, bool3, bool3);
            }
            AppMethodBeat.o(35643);
        }
    };

    public bc() {
        AppMethodBeat.i(35644);
        AppMethodBeat.o(35644);
    }

    static /* synthetic */ void a(bc bcVar, Boolean bool, Boolean bool2) {
        AppMethodBeat.i(35649);
        bcVar.c(bool, bool2);
        AppMethodBeat.o(35649);
    }

    private void s(final Boolean bool) {
        FrameLayout.LayoutParams layoutParams;
        AppMethodBeat.i(35645);
        this.Puu = (ViewGroup) this.dom.findViewById(R.id.auh);
        this.Put = View.inflate(this.dom.Pwc.getContext(), R.layout.bg0, null);
        TextView textView = (TextView) this.Put.findViewById(R.id.fxn);
        if (bool.booleanValue()) {
            textView.setText(this.dom.Pwc.getContext().getString(R.string.gkd));
            this.Put.setBackgroundResource(R.drawable.cjd);
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
        } else {
            textView.setText(this.dom.Pwc.getContext().getString(R.string.gkh));
            this.Put.setBackgroundResource(R.drawable.cjc);
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 83);
        }
        if (!(this.Puu == null || this.Put == null)) {
            this.Puu.addView(this.Put, layoutParams);
            this.Put.startAnimation(AnimationUtils.loadAnimation(this.dom.Pwc.getContext(), R.anim.ed));
            this.Put.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.bc.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(35641);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/ui/chatting/component/TipsBubbleComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (bool.booleanValue()) {
                        bc bcVar = bc.this;
                        Boolean bool = Boolean.TRUE;
                        bc.a(bcVar, bool, bool);
                        ((u) bc.this.dom.bh(u.class)).gPO().go(null);
                    } else {
                        bc.a(bc.this, Boolean.TRUE, Boolean.FALSE);
                        ((u) bc.this.dom.bh(u.class)).gPO().setMode(2);
                    }
                    a.a(this, "com/tencent/mm/ui/chatting/component/TipsBubbleComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(35641);
                }
            });
        }
        AppMethodBeat.o(35645);
    }

    private void c(Boolean bool, Boolean bool2) {
        AppMethodBeat.i(35646);
        if (this.Put != null) {
            this.Put.clearAnimation();
            this.Put.setVisibility(8);
            if (bool2.booleanValue()) {
                if (bool.booleanValue()) {
                    bg.aVF();
                    c.azQ().set(340228, Boolean.TRUE);
                    h.INSTANCE.idkeyStat(232, 1, 1, false);
                    AppMethodBeat.o(35646);
                    return;
                }
            } else if (bool.booleanValue()) {
                bg.aVF();
                c.azQ().set(340229, Boolean.TRUE);
                h.INSTANCE.idkeyStat(232, 2, 1, false);
            }
        }
        AppMethodBeat.o(35646);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        AppMethodBeat.i(35647);
        if (z.aUQ().booleanValue()) {
            if (!this.dom.GUe.gBM()) {
                bg.aVF();
                this.Puv = Util.nullAsFalse((Boolean) c.azQ().get(340228, (Object) null));
                if (!this.Puv && !((f) this.dom.bh(f.class)).gPi() && !((d) this.dom.bh(d.class)).gOV()) {
                    s(Boolean.TRUE);
                }
                bg.aVF();
                this.Puw = Util.nullAsFalse((Boolean) c.azQ().get(340229, (Object) null));
                long currentTimeMillis = System.currentTimeMillis();
                bg.aVF();
                long nullAs = currentTimeMillis - Util.nullAs((Long) c.azQ().get(340240, (Object) null), 0);
                if (this.Puv && !this.Puw && nullAs >= 259200000) {
                    s(Boolean.FALSE);
                }
            }
            if (((u) this.dom.bh(u.class)).gPO() != null) {
                ((u) this.dom.bh(u.class)).gPO().setTipsShowCallback(this.Puy);
            }
        }
        AppMethodBeat.o(35647);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(35648);
        if (!this.dom.GUe.gBM() && z.aUQ().booleanValue()) {
            Boolean bool = Boolean.FALSE;
            c(bool, bool);
        }
        AppMethodBeat.o(35648);
    }
}
