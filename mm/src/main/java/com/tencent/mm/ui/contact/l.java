package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.bj.d;
import com.tencent.mm.br.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.v;
import java.util.List;

public final class l extends RelativeLayout {
    public static Boolean PVD = Boolean.TRUE;
    private View PVE = null;
    MStorage.IOnStorageChange PVF = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.ui.contact.l.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(37832);
            Log.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
            if (!l.this.PlP.stopped()) {
                l.this.PlP.stopTimer();
            }
            l.this.PlP.startTimer(l.this.PVG ? 500 : 1000);
            AppMethodBeat.o(37832);
        }
    };
    private boolean PVG = false;
    private final MTimerHandler PlP = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.ui.contact.l.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(37831);
            Log.d("MicroMsg.FMessageContactView", "refresh timer expired, update");
            l.gUL();
            l.a(l.this);
            AppMethodBeat.o(37831);
            return false;
        }
    }, true);
    private Context context = null;
    private boolean isVisible = true;
    private View jxm = null;

    static /* synthetic */ void a(l lVar) {
        AppMethodBeat.i(37846);
        lVar.init();
        AppMethodBeat.o(37846);
    }

    static /* synthetic */ void gUL() {
        AppMethodBeat.i(37845);
        gUJ();
        AppMethodBeat.o(37845);
    }

    public l(Context context2) {
        super(context2);
        AppMethodBeat.i(37837);
        this.context = context2;
        d.bgN().add(this.PVF);
        gUJ();
        init();
        AppMethodBeat.o(37837);
    }

    private void init() {
        int i2;
        AppMethodBeat.i(37838);
        List<bl> gCP = d.bgN().gCP();
        int size = gCP.size();
        Log.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", Integer.valueOf(size));
        removeAllViews();
        if (size <= 0) {
            gUI();
        } else if (size == 1) {
            a(gCP.get(0));
        } else {
            jI(gCP);
        }
        View findViewById = this.jxm.findViewById(R.id.d6o);
        if (findViewById != null) {
            if (this.isVisible) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            findViewById.setVisibility(i2);
        }
        this.PVE.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.contact.l.AnonymousClass3 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(37833);
                if (l.this.context instanceof MMActivity) {
                    ((MMActivity) l.this.context).hideVKB();
                }
                AppMethodBeat.o(37833);
                return false;
            }
        });
        int gCR = d.bgN().gCR();
        Log.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", Integer.valueOf(gCR));
        TextView textView = (TextView) this.jxm.findViewById(R.id.d6z);
        textView.setBackgroundResource(v.kH(this.context));
        if (gCR <= 0) {
            textView.setVisibility(8);
            PVD = Boolean.FALSE;
            AppMethodBeat.o(37838);
            return;
        }
        textView.setVisibility(0);
        PVD = Boolean.TRUE;
        if (gCR > 99) {
            textView.setText("");
            textView.setBackgroundResource(R.raw.badge_count_more);
            AppMethodBeat.o(37838);
            return;
        }
        textView.setText(String.valueOf(gCR));
        textView.setBackgroundResource(v.aQ(this.context, gCR));
        AppMethodBeat.o(37838);
    }

    private void gUI() {
        AppMethodBeat.i(37839);
        if (this.context == null) {
            Log.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
            AppMethodBeat.o(37839);
            return;
        }
        this.jxm = View.inflate(this.context, R.layout.alx, this);
        this.PVE = this.jxm.findViewById(R.id.d71);
        ViewGroup.LayoutParams layoutParams = this.PVE.getLayoutParams();
        layoutParams.height = (int) (((float) a.aH(this.context, R.dimen.az)) * a.jj(this.context));
        this.PVE.setLayoutParams(layoutParams);
        this.jxm.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.l.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(37834);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/FMessageContactView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
                c.b(l.this.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/FMessageContactView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37834);
            }
        });
        p.aYn();
        ((ImageView) ((MaskLayout) this.jxm.findViewById(R.id.d6j)).getContentView()).setImageBitmap(e.Mp("fmessage"));
        AppMethodBeat.o(37839);
    }

    private void a(bl blVar) {
        AppMethodBeat.i(37840);
        if (this.context == null) {
            Log.w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
            AppMethodBeat.o(37840);
            return;
        }
        if (a.jk(this.context)) {
            this.jxm = View.inflate(this.context, R.layout.am0, this);
        } else {
            this.jxm = View.inflate(this.context, R.layout.alz, this);
        }
        ((TextView) this.jxm.findViewById(R.id.d76)).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.context, blVar.field_displayName));
        TextView textView = (TextView) this.jxm.findViewById(R.id.d75);
        bn aEm = d.bgM().aEm(blVar.field_talker);
        String a2 = com.tencent.mm.pluginsdk.ui.preference.b.a(this.context, aEm.field_type, blVar.field_addScene, aEm.field_msgContent, !aEm.gCT());
        if (Util.isNullOrNil(a2)) {
            textView.setVisibility(8);
        } else {
            textView.setText(a2);
        }
        this.PVE = this.jxm.findViewById(R.id.d6o);
        this.jxm.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.l.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(37835);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/FMessageContactView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.FMessageContactView", "initSingleNew, not goto ContactInfoUI, goto FMessageConversationUI");
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(143618, (Object) 0);
                c.b(l.this.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/FMessageContactView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37835);
            }
        });
        a.b.c((ImageView) ((MaskLayout) this.jxm.findViewById(R.id.d6j)).getContentView(), blVar.field_talker);
        AppMethodBeat.o(37840);
    }

    private void jI(List<bl> list) {
        AppMethodBeat.i(37841);
        if (this.context == null) {
            Log.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
            AppMethodBeat.o(37841);
            return;
        }
        this.jxm = View.inflate(this.context, R.layout.aly, this);
        int size = list.size();
        Log.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", Integer.valueOf(size));
        MaskLayout maskLayout = (MaskLayout) this.jxm.findViewById(R.id.d6j);
        a.b.c((ImageView) maskLayout.getContentView(), list.get(0).field_talker);
        maskLayout.setVisibility(0);
        MaskLayout maskLayout2 = (MaskLayout) this.jxm.findViewById(R.id.d6k);
        a.b.c((ImageView) maskLayout2.getContentView(), list.get(1).field_talker);
        maskLayout2.setVisibility(0);
        if (size > 2) {
            MaskLayout maskLayout3 = (MaskLayout) this.jxm.findViewById(R.id.d6l);
            a.b.c((ImageView) maskLayout3.getContentView(), list.get(2).field_talker);
            maskLayout3.setVisibility(0);
        }
        if (size > 3) {
            MaskLayout maskLayout4 = (MaskLayout) this.jxm.findViewById(R.id.d6m);
            a.b.c((ImageView) maskLayout4.getContentView(), list.get(3).field_talker);
            maskLayout4.setVisibility(0);
        }
        this.PVE = this.jxm.findViewById(R.id.d6o);
        this.PVE.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.l.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(37836);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/FMessageContactView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.FMessageContactView", "initMultiNew, goto FMessageConversationUI");
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(143618, (Object) 0);
                c.b(l.this.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/FMessageContactView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37836);
            }
        });
        AppMethodBeat.o(37841);
    }

    public final void setVisible(boolean z) {
        AppMethodBeat.i(37842);
        Log.d("MicroMsg.FMessageContactView", "setVisible visible = ".concat(String.valueOf(z)));
        View findViewById = this.jxm.findViewById(R.id.d6o);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 0 : 8);
        }
        this.isVisible = z;
        AppMethodBeat.o(37842);
    }

    private static void gUJ() {
        AppMethodBeat.i(37843);
        int gCR = d.bgN().gCR();
        Log.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", Integer.valueOf(gCR));
        if (gCR > 0) {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(143618, Integer.valueOf(gCR));
        }
        AppMethodBeat.o(37843);
    }

    public final void setFrontGround(boolean z) {
        this.PVG = z;
    }

    public static void gUK() {
        AppMethodBeat.i(37844);
        bg.aVF();
        if (com.tencent.mm.model.c.azn()) {
            bg.aVF();
            if (com.tencent.mm.model.c.azQ().getInt(143618, 0) > 0) {
                ab.av("fmessage", 2);
            }
        }
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(143618, (Object) 0);
        AppMethodBeat.o(37844);
    }
}
