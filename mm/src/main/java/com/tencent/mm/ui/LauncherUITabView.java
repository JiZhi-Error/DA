package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.c;

public class LauncherUITabView extends RelativeLayout implements c {
    private int BTn = -1;
    private int OEA = 0;
    private int OEB = 0;
    private boolean OEC = false;
    private int OEE = 0;
    private boolean OEF = false;
    private int OEN;
    private Bitmap OEO;
    private ImageView OEP;
    protected a OEQ;
    protected a OER;
    protected a OES;
    protected a OET;
    private c.a OEg;
    protected View.OnClickListener OEw = new View.OnClickListener() {
        /* class com.tencent.mm.ui.LauncherUITabView.AnonymousClass1 */
        private final long EKO = 300;

        public final void onClick(View view) {
            AppMethodBeat.i(33369);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            int intValue = ((Integer) view.getTag()).intValue();
            if (LauncherUITabView.this.BTn == intValue && intValue == 0 && System.currentTimeMillis() - LauncherUITabView.this.xUW <= 300) {
                Log.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
                LauncherUITabView.this.OEx.removeMessages(0);
                EventCenter.instance.publish(new mh());
                LauncherUITabView.this.xUW = System.currentTimeMillis();
                LauncherUITabView.this.BTn = intValue;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(33369);
                return;
            }
            if (LauncherUITabView.this.OEg != null) {
                if (intValue == 0 && LauncherUITabView.this.BTn == 0) {
                    LauncherUITabView.this.OEx.sendEmptyMessageDelayed(0, 300);
                } else {
                    LauncherUITabView.this.xUW = System.currentTimeMillis();
                    LauncherUITabView.this.BTn = intValue;
                    LauncherUITabView.this.OEg.onTabClick(intValue);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(33369);
                    return;
                }
            }
            LauncherUITabView.this.xUW = System.currentTimeMillis();
            LauncherUITabView.this.BTn = intValue;
            Log.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", (Integer) view.getTag());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUITabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33369);
        }
    };
    private MMHandler OEx = new MMHandler() {
        /* class com.tencent.mm.ui.LauncherUITabView.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(33370);
            Log.v("MicroMsg.LauncherUITabView", "onMainTabClick");
            LauncherUITabView.this.OEg.onTabClick(0);
            AppMethodBeat.o(33370);
        }
    };
    private LinearLayout OEy;
    private int OEz = 0;
    private Matrix gT = new Matrix();
    protected int sTB = 0;
    private long xUW = 0;

    /* access modifiers changed from: protected */
    public class a {
        MMTabView OEV;

        protected a() {
        }
    }

    public LauncherUITabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(33371);
        init();
        AppMethodBeat.o(33371);
    }

    public LauncherUITabView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(33372);
        init();
        AppMethodBeat.o(33372);
    }

    @Override // com.tencent.mm.ui.c
    public void setOnTabClickListener(c.a aVar) {
        this.OEg = aVar;
    }

    private a akT(int i2) {
        AppMethodBeat.i(33373);
        a aVar = new a();
        aVar.OEV = new MMTabView(getContext(), i2);
        aVar.OEV.setTag(Integer.valueOf(i2));
        aVar.OEV.setOnClickListener(this.OEw);
        AppMethodBeat.o(33373);
        return aVar;
    }

    private a f(LinearLayout linearLayout) {
        AppMethodBeat.i(33374);
        a akT = akT(0);
        akT.OEV.setText(R.string.eub);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.amu));
        layoutParams.weight = 1.0f;
        linearLayout.addView(akT.OEV, layoutParams);
        AppMethodBeat.o(33374);
        return akT;
    }

    private a g(LinearLayout linearLayout) {
        AppMethodBeat.i(33375);
        a akT = akT(1);
        akT.OEV.setText(R.string.euc);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.amu));
        layoutParams.weight = 1.0f;
        linearLayout.addView(akT.OEV, layoutParams);
        AppMethodBeat.o(33375);
        return akT;
    }

    private a h(LinearLayout linearLayout) {
        AppMethodBeat.i(33376);
        a akT = akT(2);
        akT.OEV.setText(R.string.eua);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.amu));
        layoutParams.weight = 1.0f;
        linearLayout.addView(akT.OEV, layoutParams);
        AppMethodBeat.o(33376);
        return akT;
    }

    private a i(LinearLayout linearLayout) {
        AppMethodBeat.i(33377);
        a akT = akT(3);
        akT.OEV.setText(R.string.evc);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.amu));
        layoutParams.weight = 1.0f;
        linearLayout.addView(akT.OEV, layoutParams);
        AppMethodBeat.o(33377);
        return akT;
    }

    private void gIA() {
        AppMethodBeat.i(33378);
        this.OEP = new ImageView(getContext());
        this.OEP.setImageMatrix(this.gT);
        this.OEP.setScaleType(ImageView.ScaleType.MATRIX);
        this.OEP.setId(2307142);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, 2307141);
        addView(this.OEP, layoutParams);
        AppMethodBeat.o(33378);
    }

    private void init() {
        AppMethodBeat.i(33379);
        this.OEy = new LinearLayout(getContext());
        this.OEy.setBackgroundColor(getContext().getResources().getColor(R.color.f3044b));
        this.OEy.setId(2307141);
        this.OEy.setOrientation(0);
        addView(this.OEy, new RelativeLayout.LayoutParams(-1, -2));
        gIA();
        this.OEQ = f(this.OEy);
        this.OER = g(this.OEy);
        this.OES = h(this.OEy);
        this.OET = i(this.OEy);
        AppMethodBeat.o(33379);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(33380);
        super.onLayout(z, i2, i3, i4, i5);
        Log.d("MicroMsg.LauncherUITabView", "on layout, width %d", Integer.valueOf(i4 - i2));
        this.OEN = (i4 - i2) / 4;
        int i6 = this.OEN;
        if (this.OEO == null || this.OEO.getWidth() != i6) {
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.OEO == null ? -1 : this.OEO.getWidth());
            objArr[1] = Integer.valueOf(i6);
            Log.w("MicroMsg.LauncherUITabView", "sharp width changed, from %d to %d", objArr);
            this.OEO = Bitmap.createBitmap(i6, com.tencent.mm.cb.a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
            new Canvas(this.OEO).drawColor(getResources().getColor(R.color.afp));
            p(this.sTB, 0.0f);
            this.OEP.setImageBitmap(this.OEO);
        }
        setTo(this.sTB);
        AppMethodBeat.o(33380);
    }

    @Override // com.tencent.mm.ui.c
    public final void akH(int i2) {
        AppMethodBeat.i(33381);
        Log.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", Integer.valueOf(i2));
        this.OEz = i2;
        if (i2 <= 0) {
            this.OEQ.OEV.setUnread(null);
            AppMethodBeat.o(33381);
        } else if (i2 > 99) {
            this.OEQ.OEV.setUnread(getContext().getString(R.string.hsg));
            AppMethodBeat.o(33381);
        } else {
            this.OEQ.OEV.setUnread(String.valueOf(i2));
            AppMethodBeat.o(33381);
        }
    }

    @Override // com.tencent.mm.ui.c
    public final void gGO() {
        AppMethodBeat.i(33382);
        if (this.OEQ == null || this.OER == null || this.OES == null || this.OET == null) {
            AppMethodBeat.o(33382);
            return;
        }
        this.OEQ.OEV.gIW();
        this.OER.OEV.gIW();
        this.OES.OEV.gIW();
        this.OET.OEV.gIW();
        AppMethodBeat.o(33382);
    }

    @Override // com.tencent.mm.ui.c
    public final void akI(int i2) {
        AppMethodBeat.i(33383);
        this.OEA = i2;
        if (i2 <= 0) {
            this.OER.OEV.setUnread(null);
            AppMethodBeat.o(33383);
        } else if (i2 > 99) {
            this.OER.OEV.setUnread(getContext().getString(R.string.hsg));
            AppMethodBeat.o(33383);
        } else {
            this.OER.OEV.setUnread(String.valueOf(i2));
            AppMethodBeat.o(33383);
        }
    }

    @Override // com.tencent.mm.ui.c
    public final void akJ(int i2) {
        AppMethodBeat.i(33384);
        this.OEB = i2;
        if (i2 <= 0) {
            this.OES.OEV.setUnread(null);
            AppMethodBeat.o(33384);
        } else if (i2 > 99) {
            this.OES.OEV.setUnread(getContext().getString(R.string.hsg));
            AppMethodBeat.o(33384);
        } else {
            this.OES.OEV.setUnread(String.valueOf(i2));
            AppMethodBeat.o(33384);
        }
    }

    @Override // com.tencent.mm.ui.c
    public final void akK(int i2) {
        AppMethodBeat.i(33385);
        this.OEE = i2;
        if (i2 <= 0) {
            this.OET.OEV.setUnread(null);
            AppMethodBeat.o(33385);
        } else if (i2 > 99) {
            this.OET.OEV.setUnread(getContext().getString(R.string.hsg));
            AppMethodBeat.o(33385);
        } else {
            this.OET.OEV.setUnread(String.valueOf(i2));
            AppMethodBeat.o(33385);
        }
    }

    @Override // com.tencent.mm.ui.c
    public final void AT(boolean z) {
        AppMethodBeat.i(33386);
        this.OEC = z;
        this.OES.OEV.Bk(z);
        AppMethodBeat.o(33386);
    }

    @Override // com.tencent.mm.ui.c
    public final void AU(boolean z) {
        AppMethodBeat.i(33387);
        this.OEF = z;
        this.OET.OEV.Bk(z);
        AppMethodBeat.o(33387);
    }

    @Override // com.tencent.mm.ui.c
    public final void p(int i2, float f2) {
        AppMethodBeat.i(33388);
        this.gT.setTranslate(((float) this.OEN) * (((float) i2) + f2), 0.0f);
        this.OEP.setImageMatrix(this.gT);
        AppMethodBeat.o(33388);
    }

    @Override // com.tencent.mm.ui.c
    public int getCurIdx() {
        return this.sTB;
    }

    @Override // com.tencent.mm.ui.c
    public void setTo(int i2) {
        AppMethodBeat.i(33389);
        this.sTB = i2;
        this.OEQ.OEV.setTextColor(i2 == 0 ? getResources().getColor(R.color.afp) : getContext().getResources().getColor(R.color.FG_0));
        this.OER.OEV.setTextColor(i2 == 1 ? getResources().getColor(R.color.afp) : getContext().getResources().getColor(R.color.FG_0));
        this.OES.OEV.setTextColor(i2 == 2 ? getResources().getColor(R.color.afp) : getContext().getResources().getColor(R.color.FG_0));
        this.OET.OEV.setTextColor(i2 == 3 ? getResources().getColor(R.color.afp) : getContext().getResources().getColor(R.color.FG_0));
        this.xUW = System.currentTimeMillis();
        this.BTn = this.sTB;
        AppMethodBeat.o(33389);
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
}
