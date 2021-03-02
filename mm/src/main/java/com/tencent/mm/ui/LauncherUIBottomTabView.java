package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aam;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.c;
import com.tencent.mm.ui.tools.v;
import com.tencent.smtt.sdk.WebView;

public class LauncherUIBottomTabView extends RelativeLayout implements c {
    private int BTn = -1;
    private int OEA = 0;
    private int OEB = 0;
    private boolean OEC = false;
    private boolean OED = false;
    private int OEE = 0;
    private boolean OEF = false;
    private c.a OEg;
    protected a OEh;
    protected a OEi;
    protected a OEj;
    protected a OEk;
    private int OEl = 0;
    private int OEm;
    private int OEn;
    private int OEo;
    private int OEp;
    private int OEq;
    private int OEr;
    private int OEs;
    private int OEt;
    private int OEu;
    private int OEv = 0;
    protected View.OnClickListener OEw = new View.OnClickListener() {
        /* class com.tencent.mm.ui.LauncherUIBottomTabView.AnonymousClass1 */
        private final long EKO = 300;

        public final void onClick(View view) {
            AppMethodBeat.i(33335);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            int intValue = ((Integer) view.getTag()).intValue();
            if (LauncherUIBottomTabView.this.BTn == intValue && intValue == 0 && System.currentTimeMillis() - LauncherUIBottomTabView.this.xUW <= 300) {
                Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
                LauncherUIBottomTabView.this.OEx.removeMessages(0);
                mh mhVar = new mh();
                mhVar.dRG.dRH = LauncherUIBottomTabView.this.OEz;
                EventCenter.instance.publish(mhVar);
                LauncherUIBottomTabView.this.xUW = System.currentTimeMillis();
                LauncherUIBottomTabView.this.BTn = intValue;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(33335);
                return;
            }
            if (intValue == 0) {
                com.tencent.mm.plugin.report.business.a.a(1, (long) LauncherUIBottomTabView.this.OEz, 0, "");
            }
            if (LauncherUIBottomTabView.this.OEg != null) {
                if (intValue == 0 && LauncherUIBottomTabView.this.BTn == 0) {
                    Log.v("MicroMsg.LauncherUITabView", "do double click check");
                    LauncherUIBottomTabView.this.OEx.sendEmptyMessageDelayed(0, 300);
                } else {
                    Log.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
                    LauncherUIBottomTabView.this.xUW = System.currentTimeMillis();
                    LauncherUIBottomTabView.this.BTn = intValue;
                    LauncherUIBottomTabView.this.OEg.onTabClick(intValue);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(33335);
                    return;
                }
            }
            LauncherUIBottomTabView.this.xUW = System.currentTimeMillis();
            LauncherUIBottomTabView.this.BTn = intValue;
            Log.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", (Integer) view.getTag());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUIBottomTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33335);
        }
    };
    private MMHandler OEx = new MMHandler() {
        /* class com.tencent.mm.ui.LauncherUIBottomTabView.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(33336);
            Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
            LauncherUIBottomTabView.this.OEg.onTabClick(0);
            AppMethodBeat.o(33336);
        }
    };
    private LinearLayout OEy;
    private int OEz = 0;
    private int ddP = 0;
    private Context mContext;
    protected int sTB = 0;
    private long xUW = 0;

    /* access modifiers changed from: protected */
    public class a implements com.tencent.mm.plugin.newtips.a.a {
        View OEH;
        TabIconView OEI;
        TextView OEJ;
        TextView OEK;
        ImageView OEL;
        String path;

        protected a() {
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final String getPath() {
            return this.path;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean ehp() {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final View getRoot() {
            return this.OEH;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final void a(k kVar, boolean z) {
            AppMethodBeat.i(33337);
            g.a(this, kVar, z);
            AppMethodBeat.o(33337);
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean qV(boolean z) {
            AppMethodBeat.i(258906);
            boolean a2 = g.a(z, this);
            AppMethodBeat.o(258906);
            return a2;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean qW(boolean z) {
            int i2 = 4;
            AppMethodBeat.i(33339);
            this.OEK.setVisibility(4);
            ImageView imageView = this.OEL;
            if (z) {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            AppMethodBeat.o(33339);
            return true;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean qX(boolean z) {
            AppMethodBeat.i(33340);
            if (z) {
                this.OEK.setText(LauncherUIBottomTabView.this.getResources().getString(R.string.hrt));
                this.OEK.setBackgroundResource(R.drawable.amr);
                this.OEK.setTextSize(0, (float) com.tencent.mm.cb.a.aH(LauncherUIBottomTabView.this.getContext(), R.dimen.bn));
                this.OEK.setVisibility(0);
                this.OEL.setVisibility(4);
            } else {
                this.OEK.setText("");
                this.OEK.setVisibility(4);
            }
            AppMethodBeat.o(33340);
            return true;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean a(boolean z, ehv ehv) {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean b(boolean z, ehv ehv) {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean c(boolean z, ehv ehv) {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean d(boolean z, ehv ehv) {
            AppMethodBeat.i(33341);
            if (!z) {
                this.OEK.setText("");
                this.OEK.setVisibility(4);
            } else if (ehv.ibS > 99) {
                this.OEK.setText("");
                this.OEK.setBackgroundResource(R.raw.badge_count_more);
                this.OEK.setTextSize(0, (float) com.tencent.mm.cb.a.aH(LauncherUIBottomTabView.this.getContext(), R.dimen.ane));
                this.OEK.setVisibility(0);
                this.OEL.setVisibility(4);
            } else {
                this.OEK.setText(String.valueOf(ehv.ibS));
                this.OEK.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(LauncherUIBottomTabView.this.getContext(), R.dimen.ane)) * com.tencent.mm.cb.a.ji(LauncherUIBottomTabView.this.getContext()));
                this.OEK.setVisibility(0);
                this.OEK.setBackgroundResource(v.aQ(LauncherUIBottomTabView.this.getContext(), ehv.ibS));
                this.OEL.setVisibility(4);
            }
            AppMethodBeat.o(33341);
            return true;
        }
    }

    public LauncherUIBottomTabView(Context context) {
        super(context);
        AppMethodBeat.i(33342);
        this.mContext = context;
        init();
        AppMethodBeat.o(33342);
    }

    public LauncherUIBottomTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(33343);
        this.mContext = context;
        init();
        AppMethodBeat.o(33343);
    }

    public LauncherUIBottomTabView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(33344);
        this.mContext = context;
        init();
        AppMethodBeat.o(33344);
    }

    @Override // com.tencent.mm.ui.c
    public void setOnTabClickListener(c.a aVar) {
        this.OEg = aVar;
    }

    private a akR(int i2) {
        AppMethodBeat.i(33345);
        a aVar = new a();
        if (com.tencent.mm.cb.a.jl(getContext())) {
            com.tencent.mm.kiss.a.b.aBh();
            aVar.OEH = com.tencent.mm.kiss.a.b.c((Activity) getContext(), R.layout.b7t);
        } else {
            com.tencent.mm.kiss.a.b.aBh();
            aVar.OEH = com.tencent.mm.kiss.a.b.c((Activity) getContext(), R.layout.b7s);
        }
        aVar.OEI = (TabIconView) aVar.OEH.findViewById(R.id.dtx);
        aVar.OEJ = (TextView) aVar.OEH.findViewById(R.id.dub);
        aVar.OEK = (TextView) aVar.OEH.findViewById(R.id.j0_);
        aVar.OEK.setBackgroundResource(v.kH(getContext()));
        aVar.OEL = (ImageView) aVar.OEH.findViewById(R.id.bt8);
        aVar.OEH.setTag(Integer.valueOf(i2));
        aVar.OEH.setOnClickListener(this.OEw);
        aVar.OEJ.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.kc)) * com.tencent.mm.cb.a.ji(getContext()));
        AppMethodBeat.o(33345);
        return aVar;
    }

    private a b(LinearLayout linearLayout) {
        AppMethodBeat.i(33346);
        a akR = akR(0);
        akR.OEH.setId(-16777215);
        akR.OEJ.setText(R.string.evi);
        akR.OEJ.setTextColor(getResources().getColor(R.color.FG_0));
        akR.OEI.i(R.raw.icons_filled_chats_hl, R.raw.icons_outlined_chats_middle, R.raw.icons_outlined_chats, com.tencent.mm.cb.a.jl(getContext()));
        akR.OEK.setVisibility(4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, this.OEv);
        layoutParams.weight = 1.0f;
        linearLayout.addView(akR.OEH, layoutParams);
        AppMethodBeat.o(33346);
        return akR;
    }

    private a c(LinearLayout linearLayout) {
        AppMethodBeat.i(33347);
        a akR = akR(1);
        akR.OEH.setId(-16777214);
        akR.OEJ.setText(R.string.euc);
        akR.OEJ.setTextColor(getResources().getColor(R.color.FG_0));
        akR.OEI.i(R.raw.icons_filled_contacts_hl, R.raw.icons_outlined_contacts_middle, R.raw.icons_outlined_contacts, com.tencent.mm.cb.a.jl(getContext()));
        akR.OEK.setVisibility(4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, this.OEv);
        layoutParams.weight = 1.0f;
        linearLayout.addView(akR.OEH, layoutParams);
        AppMethodBeat.o(33347);
        return akR;
    }

    private a d(LinearLayout linearLayout) {
        AppMethodBeat.i(33348);
        a akR = akR(2);
        akR.OEH.setId(-16777213);
        akR.OEJ.setText(R.string.eua);
        akR.OEJ.setTextColor(getResources().getColor(R.color.FG_0));
        akR.OEI.i(R.raw.icons_filled_discover_hl, R.raw.icons_outlined_discover_middle, R.raw.icons_outlined_discover, com.tencent.mm.cb.a.jl(getContext()));
        akR.OEK.setVisibility(4);
        akR.path = "discovery";
        com.tencent.mm.plugin.newtips.a.exl().h(akR);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, this.OEv);
        layoutParams.weight = 1.0f;
        linearLayout.addView(akR.OEH, layoutParams);
        AppMethodBeat.o(33348);
        return akR;
    }

    private a e(LinearLayout linearLayout) {
        AppMethodBeat.i(33349);
        a akR = akR(3);
        akR.OEH.setId(-16777212);
        akR.OEJ.setText(R.string.evc);
        akR.OEJ.setTextColor(getResources().getColor(R.color.FG_0));
        akR.OEI.i(R.raw.icons_filled_me_hl, R.raw.icons_outlined_me, R.raw.icons_outlined_me, com.tencent.mm.cb.a.jl(getContext()));
        akR.OEK.setVisibility(4);
        akR.path = "me";
        com.tencent.mm.plugin.newtips.a.exl().h(akR);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, this.OEv);
        layoutParams.weight = 1.0f;
        linearLayout.addView(akR.OEH, layoutParams);
        AppMethodBeat.o(33349);
        return akR;
    }

    private void init() {
        AppMethodBeat.i(33350);
        this.OEy = new LinearLayout(getContext());
        this.OEy.setBackgroundColor(getResources().getColor(R.color.f3044b));
        this.OEy.setOrientation(0);
        addView(this.OEy, new RelativeLayout.LayoutParams(-1, -2));
        this.OEv = (int) (((float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.bc)) * com.tencent.mm.cb.a.ji(getContext()));
        this.OEh = b(this.OEy);
        this.OEj = c(this.OEy);
        this.OEi = d(this.OEy);
        this.OEk = e(this.OEy);
        this.OEl = getResources().getColor(R.color.a2f);
        this.OEm = (this.OEl & 16711680) >> 16;
        this.OEn = (this.OEl & 65280) >> 8;
        this.OEo = this.OEl & 255;
        this.ddP = getResources().getColor(R.color.FG_0);
        this.OEp = (this.ddP & 16711680) >> 16;
        this.OEq = (this.ddP & 65280) >> 8;
        this.OEr = this.ddP & 255;
        this.OEs = this.OEm - this.OEp;
        this.OEt = this.OEn - this.OEq;
        this.OEu = this.OEo - this.OEr;
        AppMethodBeat.o(33350);
    }

    @Override // com.tencent.mm.ui.c
    public final void akH(int i2) {
        AppMethodBeat.i(33351);
        Log.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", Integer.valueOf(i2));
        this.OEz = i2;
        if (i2 <= 0) {
            this.OEh.OEK.setText("");
            this.OEh.OEK.setVisibility(4);
        } else if (i2 > 99) {
            this.OEh.OEK.setText("");
            this.OEh.OEK.setBackgroundResource(R.raw.badge_count_more);
            this.OEh.OEK.setTextSize(0, (float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.ane));
            this.OEh.OEK.setVisibility(0);
            this.OEh.OEL.setVisibility(4);
        } else {
            this.OEh.OEK.setText(String.valueOf(i2));
            this.OEh.OEK.setBackgroundResource(v.aQ(getContext(), i2));
            this.OEh.OEK.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.ane)) * com.tencent.mm.cb.a.ji(getContext()));
            this.OEh.OEK.setVisibility(0);
            this.OEh.OEL.setVisibility(4);
        }
        akS(0);
        AppMethodBeat.o(33351);
    }

    @Override // com.tencent.mm.ui.c
    public final void gGO() {
        if (this.OEh == null || this.OEj == null || this.OEi == null) {
        }
    }

    @Override // com.tencent.mm.ui.c
    public final void akI(int i2) {
        AppMethodBeat.i(33352);
        this.OEA = i2;
        if (i2 <= 0) {
            this.OEj.OEK.setText("");
            this.OEj.OEK.setVisibility(4);
        } else if (i2 > 99) {
            this.OEj.OEK.setText("");
            this.OEj.OEK.setBackgroundResource(R.raw.badge_count_more);
            this.OEj.OEK.setTextSize(0, (float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.ane));
            this.OEj.OEK.setVisibility(0);
            this.OEj.OEL.setVisibility(4);
        } else {
            this.OEj.OEK.setText(String.valueOf(i2));
            this.OEj.OEK.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.ane)) * com.tencent.mm.cb.a.ji(getContext()));
            this.OEj.OEK.setBackgroundResource(v.aQ(getContext(), i2));
            this.OEj.OEK.setVisibility(0);
            this.OEj.OEL.setVisibility(4);
        }
        akS(1);
        AppMethodBeat.o(33352);
    }

    @Override // com.tencent.mm.ui.c
    public final void akJ(int i2) {
        boolean z;
        AppMethodBeat.i(33353);
        this.OEB = i2;
        a aVar = this.OEi;
        if (i2 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (g.a(z, aVar)) {
            AppMethodBeat.o(33353);
            return;
        }
        if (i2 > 0) {
            if (i2 > 99) {
                this.OEi.OEK.setText("");
                this.OEi.OEK.setBackgroundResource(R.raw.badge_count_more);
                this.OEi.OEK.setTextSize(0, (float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.ane));
                this.OEi.OEK.setVisibility(0);
                this.OEi.OEL.setVisibility(4);
            } else {
                this.OEi.OEK.setText(String.valueOf(i2));
                this.OEi.OEK.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.ane)) * com.tencent.mm.cb.a.ji(getContext()));
                this.OEi.OEK.setVisibility(0);
                this.OEi.OEK.setBackgroundResource(v.aQ(getContext(), i2));
                this.OEi.OEL.setVisibility(4);
            }
            this.OEi.a(k.MMNEWTIPS_SHOWTYPE_COUNTER, true);
        } else {
            this.OEi.OEK.setText("");
            this.OEi.OEK.setVisibility(4);
            this.OEi.a(k.MMNEWTIPS_SHOWTYPE_COUNTER, false);
        }
        akS(2);
        AppMethodBeat.o(33353);
    }

    @Override // com.tencent.mm.ui.c
    public final void AT(boolean z) {
        int i2 = 4;
        AppMethodBeat.i(33354);
        if (g.a(z, this.OEi)) {
            AppMethodBeat.o(33354);
            return;
        }
        this.OEC = z;
        this.OEi.OEK.setVisibility(4);
        ImageView imageView = this.OEi.OEL;
        if (z) {
            i2 = 0;
        }
        imageView.setVisibility(i2);
        this.OEi.a(k.MMNEWTIPS_SHOWTYPE_REDPOINT, z);
        akS(2);
        AppMethodBeat.o(33354);
    }

    @Override // com.tencent.mm.ui.c
    public final void akK(int i2) {
        boolean z;
        AppMethodBeat.i(33355);
        if (this.OED) {
            AppMethodBeat.o(33355);
            return;
        }
        this.OEE = i2;
        a aVar = this.OEk;
        if (i2 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (g.a(z, aVar)) {
            AppMethodBeat.o(33355);
            return;
        }
        if (i2 > 0) {
            if (i2 > 99) {
                this.OEk.OEK.setText("");
                this.OEk.OEK.setBackgroundResource(R.raw.badge_count_more);
                this.OEk.OEK.setTextSize(0, (float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.ane));
                this.OEk.OEK.setVisibility(0);
                this.OEk.OEL.setVisibility(4);
            } else {
                this.OEk.OEK.setText(String.valueOf(i2));
                this.OEk.OEK.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.ane)) * com.tencent.mm.cb.a.ji(getContext()));
                this.OEk.OEK.setVisibility(0);
                this.OEk.OEK.setBackgroundResource(v.aQ(getContext(), i2));
                this.OEk.OEL.setVisibility(4);
            }
            this.OEk.a(k.MMNEWTIPS_SHOWTYPE_COUNTER, true);
        } else {
            this.OEk.OEK.setText("");
            this.OEk.OEK.setVisibility(4);
            this.OEk.a(k.MMNEWTIPS_SHOWTYPE_COUNTER, false);
        }
        akS(3);
        AppMethodBeat.o(33355);
    }

    @Override // com.tencent.mm.ui.c
    public final void AU(boolean z) {
        int i2;
        AppMethodBeat.i(33356);
        if (this.OED) {
            AppMethodBeat.o(33356);
        } else if (g.a(z, this.OEk)) {
            AppMethodBeat.o(33356);
        } else {
            h hVar = h.FuH;
            h.Ks(z ? 1 : 0);
            this.OEF = z;
            this.OEk.OEK.setVisibility(4);
            ImageView imageView = this.OEk.OEL;
            if (z) {
                i2 = 0;
            } else {
                i2 = 4;
            }
            imageView.setVisibility(i2);
            this.OEk.a(k.MMNEWTIPS_SHOWTYPE_REDPOINT, z);
            AppMethodBeat.o(33356);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.c
    public final void p(int i2, float f2) {
        AppMethodBeat.i(33357);
        int i3 = (int) (255.0f * f2);
        int i4 = 255 - i3;
        int i5 = (((int) ((((float) this.OEs) * f2) + ((float) this.OEp))) << 16) + (((int) ((((float) this.OEt) * f2) + ((float) this.OEq))) << 8) + ((int) ((((float) this.OEu) * f2) + ((float) this.OEr))) + (this.ddP & WebView.NIGHT_MODE_COLOR);
        int i6 = (((int) ((((float) this.OEs) * (1.0f - f2)) + ((float) this.OEp))) << 16) + (((int) ((((float) this.OEt) * (1.0f - f2)) + ((float) this.OEq))) << 8) + ((int) ((((float) this.OEu) * (1.0f - f2)) + ((float) this.OEr))) + (this.ddP & WebView.NIGHT_MODE_COLOR);
        switch (i2) {
            case 0:
                this.OEh.OEI.setFocusAlpha(i4);
                this.OEj.OEI.setFocusAlpha(i3);
                this.OEh.OEJ.setTextColor(i6);
                this.OEj.OEJ.setTextColor(i5);
                AppMethodBeat.o(33357);
                return;
            case 1:
                this.OEj.OEI.setFocusAlpha(i4);
                this.OEi.OEI.setFocusAlpha(i3);
                this.OEj.OEJ.setTextColor(i6);
                this.OEi.OEJ.setTextColor(i5);
                AppMethodBeat.o(33357);
                return;
            case 2:
                this.OEi.OEI.setFocusAlpha(i4);
                this.OEk.OEI.setFocusAlpha(i3);
                this.OEi.OEJ.setTextColor(i6);
                this.OEk.OEJ.setTextColor(i5);
                break;
        }
        AppMethodBeat.o(33357);
    }

    @Override // com.tencent.mm.ui.c
    public int getCurIdx() {
        return this.sTB;
    }

    @Override // com.tencent.mm.ui.c
    public void setTo(int i2) {
        AppMethodBeat.i(33358);
        this.sTB = i2;
        switch (i2) {
            case 0:
                this.OEh.OEI.setFocusAlpha(255);
                this.OEi.OEI.setFocusAlpha(0);
                this.OEj.OEI.setFocusAlpha(0);
                this.OEk.OEI.setFocusAlpha(0);
                this.OEh.OEJ.setTextColor(this.OEl);
                this.OEi.OEJ.setTextColor(this.ddP);
                this.OEj.OEJ.setTextColor(this.ddP);
                this.OEk.OEJ.setTextColor(this.ddP);
                break;
            case 1:
                this.OEh.OEI.setFocusAlpha(0);
                this.OEi.OEI.setFocusAlpha(0);
                this.OEj.OEI.setFocusAlpha(255);
                this.OEk.OEI.setFocusAlpha(0);
                this.OEh.OEJ.setTextColor(this.ddP);
                this.OEi.OEJ.setTextColor(this.ddP);
                this.OEj.OEJ.setTextColor(this.OEl);
                this.OEk.OEJ.setTextColor(this.ddP);
                break;
            case 2:
                this.OEh.OEI.setFocusAlpha(0);
                this.OEi.OEI.setFocusAlpha(255);
                this.OEj.OEI.setFocusAlpha(0);
                this.OEk.OEI.setFocusAlpha(0);
                this.OEh.OEJ.setTextColor(this.ddP);
                this.OEi.OEJ.setTextColor(this.OEl);
                this.OEj.OEJ.setTextColor(this.ddP);
                this.OEk.OEJ.setTextColor(this.ddP);
                break;
            case 3:
                this.OEh.OEI.setFocusAlpha(0);
                this.OEi.OEI.setFocusAlpha(0);
                this.OEj.OEI.setFocusAlpha(0);
                this.OEk.OEI.setFocusAlpha(255);
                this.OEh.OEJ.setTextColor(this.ddP);
                this.OEi.OEJ.setTextColor(this.ddP);
                this.OEj.OEJ.setTextColor(this.ddP);
                this.OEk.OEJ.setTextColor(this.OEl);
                break;
        }
        this.xUW = System.currentTimeMillis();
        this.BTn = this.sTB;
        AppMethodBeat.o(33358);
    }

    @Override // com.tencent.mm.ui.c
    public int getMainTabUnread() {
        return this.OEz;
    }

    @Override // com.tencent.mm.ui.c
    public int getContactTabUnread() {
        return this.OEA;
    }

    @Override // com.tencent.mm.ui.c
    public int getFriendTabUnread() {
        return this.OEB;
    }

    @Override // com.tencent.mm.ui.c
    public int getSettingsTabUnread() {
        return this.OEE;
    }

    @Override // com.tencent.mm.ui.c
    public boolean getShowFriendPoint() {
        return this.OEC;
    }

    @Override // com.tencent.mm.ui.c
    public boolean getSettingsPoint() {
        return this.OEF;
    }

    private void akS(int i2) {
        a aVar;
        AppMethodBeat.i(232601);
        switch (i2) {
            case 0:
                aVar = this.OEh;
                break;
            case 1:
                aVar = this.OEj;
                break;
            case 2:
                aVar = this.OEi;
                break;
            case 3:
                aVar = this.OEk;
                break;
            default:
                aVar = null;
                break;
        }
        if (aVar != null) {
            try {
                String trim = aVar.OEK.getText().toString().trim();
                aam aam = new aam();
                aam.ehm.ehn = i2;
                aam.ehm.ehp = Util.getInt(trim, 0);
                aam.ehm.eho = aVar.OEL.getVisibility() == 0;
                EventCenter.instance.publish(aam);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.LauncherUITabView", e2, "notify tab reddot tabIndex [%d]", Integer.valueOf(i2));
                AppMethodBeat.o(232601);
                return;
            }
        }
        AppMethodBeat.o(232601);
    }
}
