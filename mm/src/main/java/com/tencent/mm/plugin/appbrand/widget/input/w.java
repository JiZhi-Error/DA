package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.page.ao;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;

public class w extends LinearLayout implements ac, u.b {
    private static final int VIEW_ID = R.id.p6;
    private static com.tencent.mm.plugin.appbrand.n.a otP = null;
    private static boolean otQ = false;
    private static boolean ouo = false;
    private static final b oup = new g((byte) 0);
    private Context context;
    private View otO;
    private List<d> otZ = new ArrayList();
    private int oua = 0;
    private final Runnable oub = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.w.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(136503);
            if (w.this.ouh == null || !android.support.v4.view.u.aD(w.this.ouh)) {
                AppMethodBeat.o(136503);
            } else if (w.this.oug.cbH()) {
                Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "postMeasure inLayout, skip");
                w.this.post(this);
                AppMethodBeat.o(136503);
            } else {
                w.c(w.this);
                AppMethodBeat.o(136503);
            }
        }
    };
    private e ouc;
    private c oud;
    private boolean oue = false;
    private f ouf;
    private com.tencent.mm.plugin.appbrand.widget.input.panel.e oug;
    private View ouh;
    private ImageButton oui;
    private boolean ouj;
    private View ouk;
    private boolean oul;
    public EditText oum;
    private final ad oun;
    private int state = 2;

    public interface a {
        void setIsHide(boolean z);
    }

    /* access modifiers changed from: package-private */
    public interface b {
        void c(w wVar, int i2);

        void m(w wVar);

        void n(w wVar);

        void o(w wVar);

        void p(w wVar);
    }

    public interface c {
        void cm(boolean z);
    }

    public interface d {
        EditText getEditText();

        void ig(int i2);
    }

    public interface e {
        boolean afZ(String str);
    }

    public interface f {
        void hJ(int i2);
    }

    static /* synthetic */ void b(w wVar, int i2) {
        AppMethodBeat.i(136550);
        wVar.setPanelHeightImpl(i2);
        AppMethodBeat.o(136550);
    }

    static /* synthetic */ void g(w wVar) {
        AppMethodBeat.i(136549);
        wVar.cbK();
        AppMethodBeat.o(136549);
    }

    static /* synthetic */ void j(w wVar) {
        AppMethodBeat.i(136551);
        wVar.cbM();
        AppMethodBeat.o(136551);
    }

    static /* synthetic */ void k(w wVar) {
        AppMethodBeat.i(136552);
        wVar.cbL();
        AppMethodBeat.o(136552);
    }

    static {
        AppMethodBeat.i(136553);
        AppMethodBeat.o(136553);
    }

    public static w dc(View view) {
        AppMethodBeat.i(136518);
        w wVar = (w) view.getRootView().findViewById(VIEW_ID);
        AppMethodBeat.o(136518);
        return wVar;
    }

    public void setComponentView(boolean z) {
        if (otQ != z) {
            otQ = z;
            ouo = true;
        }
    }

    public final void a(d dVar) {
        AppMethodBeat.i(230584);
        if (!this.otZ.contains(dVar)) {
            this.otZ.add(dVar);
        }
        AppMethodBeat.o(230584);
    }

    public final void b(d dVar) {
        AppMethodBeat.i(230585);
        this.otZ.remove(dVar);
        AppMethodBeat.o(230585);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006f, code lost:
        r0 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.plugin.appbrand.widget.input.w b(android.view.View r5, com.tencent.mm.plugin.appbrand.n.a r6) {
        /*
        // Method dump skipped, instructions count: 121
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.widget.input.w.b(android.view.View, com.tencent.mm.plugin.appbrand.n.a):com.tencent.mm.plugin.appbrand.widget.input.w");
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ac
    public final boolean cbD() {
        AppMethodBeat.i(136520);
        boolean cbD = this.oug.cbD();
        AppMethodBeat.o(136520);
        return cbD;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.u.c
    public final void hF(int i2) {
        AppMethodBeat.i(136521);
        Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] refreshHeight %d", Integer.valueOf(i2));
        oup.c(this, i2);
        AppMethodBeat.o(136521);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(136522);
        super.onLayout(z, i2, i3, i4, i5);
        int measuredHeight = getMeasuredHeight();
        if (measuredHeight != this.oua) {
            Log.i("MicroMsg.AppBrandSoftKeyboardPanel", "update panel height from %d to %d", Integer.valueOf(this.oua), Integer.valueOf(measuredHeight));
            this.oua = measuredHeight;
            for (d dVar : this.otZ) {
                if (dVar != null && dVar.getEditText() == this.oum) {
                    dVar.ig(this.oua);
                }
            }
        }
        Log.v("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] SoftKeyboardPanel onLayout measuredHeight = %d", Integer.valueOf(getMeasuredHeight()));
        AppMethodBeat.o(136522);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.u.c
    public final void bQ(boolean z) {
        AppMethodBeat.i(136523);
        Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "onKeyboardStateChanged, kbShown = %b", Boolean.valueOf(z));
        if (z) {
            Ai(0);
            cbM();
            AppMethodBeat.o(136523);
            return;
        }
        if (isShown()) {
            if (!this.ouj || 1 != this.state) {
                hide();
            } else {
                cbL();
                AppMethodBeat.o(136523);
                return;
            }
        }
        AppMethodBeat.o(136523);
    }

    private void setPanelHeightImpl(int i2) {
        AppMethodBeat.i(136524);
        if (this.oug.Af(i2)) {
            this.oub.run();
        }
        AppMethodBeat.o(136524);
    }

    public int getMinimumHeight() {
        AppMethodBeat.i(136525);
        if (getVisibility() != 0) {
            AppMethodBeat.o(136525);
            return 0;
        } else if (!otQ || otP == null) {
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), 48);
            AppMethodBeat.o(136525);
            return fromDPToPix;
        } else {
            ao customViewContainer = otP.getCustomViewContainer();
            if (customViewContainer == null || !(customViewContainer.getRootView() instanceof ViewGroup) || ((ViewGroup) customViewContainer.getRootView()).getChildCount() <= 0 || ((ViewGroup) customViewContainer.getRootView()).getChildAt(0).getLayoutParams() == null) {
                AppMethodBeat.o(136525);
                return 0;
            }
            int max = Math.max(((ViewGroup) customViewContainer.getRootView()).getChildAt(0).getLayoutParams().height, 0);
            AppMethodBeat.o(136525);
            return max;
        }
    }

    public void setOnSmileyChosenListener(e eVar) {
        this.ouc = eVar;
    }

    public void setOnDoneListener(c cVar) {
        this.oud = cVar;
    }

    /* access modifiers changed from: protected */
    public final void cm(boolean z) {
        AppMethodBeat.i(136526);
        if (!this.oue && this.oud != null) {
            this.oue = true;
            this.oud.cm(z);
            this.oue = false;
        }
        AppMethodBeat.o(136526);
    }

    public void setOnVisibilityChangedListener(f fVar) {
        this.ouf = fVar;
    }

    public w(Context context2, com.tencent.mm.plugin.appbrand.n.a aVar) {
        super(context2);
        ad aVar2;
        ViewGroup viewGroup;
        AppMethodBeat.i(230587);
        this.context = context2;
        if (context2 instanceof ad) {
            aVar2 = (ad) context2;
        } else {
            aVar2 = new com.tencent.mm.plugin.appbrand.widget.input.b.a();
        }
        this.oun = aVar2;
        Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "mComponentView is assigned");
        otP = aVar;
        Log.d("MicroMsg.AppBrandSoftKeyboardPanel", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        super.setId(VIEW_ID);
        setOrientation(1);
        if (otQ) {
            this.otO = otP;
        } else {
            this.otO = Ns();
        }
        if (!(this.otO == null || (viewGroup = (ViewGroup) this.otO.getParent()) == null)) {
            Log.i("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is already exsited in a layout,the class of the parent is %s  the id is : %d", viewGroup.getClass().toString(), Integer.valueOf(viewGroup.getId()));
            viewGroup.removeView(this.otO);
        }
        addView(this.otO);
        ouo = false;
        e.b bVar = (e.b) com.tencent.luggage.a.e.M(e.b.class);
        this.oug = bVar == null ? null : bVar.ec(this.context);
        if (this.oug == null) {
            this.oug = new e.a(this.context);
        }
        this.ouh = this.oug.getPanelView();
        this.ouh.setVisibility(8);
        this.ouh.setBackgroundColor(0);
        this.oug.setOnTextOperationListener(new com.tencent.mm.plugin.appbrand.widget.input.panel.f() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.w.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.f
            public final void append(String str) {
                AppMethodBeat.i(136506);
                if (w.this.ouc != null) {
                    w.this.ouc.afZ(str);
                }
                AppMethodBeat.o(136506);
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.f
            public final void aHC() {
                AppMethodBeat.i(136507);
                if (w.this.ouc != null) {
                    w.this.ouc.afZ("[DELETE_EMOTION]");
                }
                AppMethodBeat.o(136507);
            }
        });
        addView(this.ouh);
        Nq();
        AppMethodBeat.o(230587);
    }

    public void setId(int i2) {
    }

    /* access modifiers changed from: protected */
    public final void Ag(int i2) {
        AppMethodBeat.i(263545);
        super.setId(i2);
        AppMethodBeat.o(263545);
    }

    /* access modifiers changed from: protected */
    public <T extends View & a> T Ns() {
        AppMethodBeat.i(136529);
        h hVar = new h(getContext());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, MMApplicationContext.getResources().getDrawable(R.drawable.coz));
        stateListDrawable.addState(new int[0], MMApplicationContext.getResources().getDrawable(R.drawable.coy));
        this.oui = (ImageButton) hVar.findViewById(R.id.hto);
        this.oui.setSelected(false);
        this.oui.setImageDrawable(stateListDrawable);
        this.oui.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.w.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(136504);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.isSelected()) {
                    w.oup.o(w.this);
                    view.setSelected(false);
                } else {
                    w.oup.p(w.this);
                    view.setSelected(true);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(136504);
            }
        });
        this.ouk = hVar.findViewById(R.id.htn);
        this.ouk.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.w.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(136505);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                w.this.cm(true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(136505);
            }
        });
        AppMethodBeat.o(136529);
        return hVar;
    }

    /* access modifiers changed from: protected */
    public void Np() {
        AppMethodBeat.i(136530);
        b(this, otP);
        AppMethodBeat.o(136530);
    }

    private void cbI() {
        AppMethodBeat.i(136531);
        Np();
        ((u) n.cW(this).getOnLayoutListener()).otH = this;
        AppMethodBeat.o(136531);
    }

    private void cbJ() {
        AppMethodBeat.i(136532);
        n cW = n.cW(this);
        if (cW == null) {
            AppMethodBeat.o(136532);
        } else if (cW.getOnLayoutListener() == null) {
            AppMethodBeat.o(136532);
        } else {
            ((u) cW.getOnLayoutListener()).otH = null;
            AppMethodBeat.o(136532);
        }
    }

    private void Ah(final int i2) {
        AppMethodBeat.i(136533);
        final boolean z = this.oue;
        post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.w.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(136508);
                int i2 = w.this.state;
                if (!w.this.isShown()) {
                    w.this.state = 2;
                } else {
                    w.this.state = i2;
                }
                if (w.this.ouf == null) {
                    AppMethodBeat.o(136508);
                    return;
                }
                if (i2 != w.this.state && !z) {
                    w.this.ouf.hJ(w.this.state);
                }
                AppMethodBeat.o(136508);
            }
        });
        AppMethodBeat.o(136533);
    }

    private void cbK() {
        AppMethodBeat.i(136534);
        cbM();
        if (this.oum != null) {
            InputMethodManager dg = aj.dg(this.oum);
            if (!dg.showSoftInput(this.oum, 1)) {
                dg.showSoftInput(this.oum, 2);
            }
            AppMethodBeat.o(136534);
            return;
        }
        this.oun.showVKB();
        AppMethodBeat.o(136534);
    }

    private void cbL() {
        AppMethodBeat.i(136535);
        oup.n(this);
        if (this.oui != null) {
            this.oui.setSelected(true);
        }
        Ah(1);
        AppMethodBeat.o(136535);
    }

    private void cbM() {
        AppMethodBeat.i(136536);
        oup.m(this);
        if (this.oui != null) {
            this.oui.setSelected(false);
        }
        Ah(0);
        AppMethodBeat.o(136536);
    }

    private static void db(View view) {
        ViewGroup viewGroup;
        AppMethodBeat.i(230589);
        if (!(view == null || (viewGroup = (ViewGroup) view.getParent()) == null)) {
            viewGroup.removeView(view);
        }
        AppMethodBeat.o(230589);
    }

    public final void cbN() {
        AppMethodBeat.i(230590);
        if (this.otO == null) {
            AppMethodBeat.o(230590);
            return;
        }
        if (ouo) {
            db(this.otO);
            if (otQ) {
                this.otO = otP;
            } else {
                this.otO = Ns();
            }
            db(this.otO);
            addView(this.otO, 0);
            Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is changed in updateToolbar() because of toolbarChanged");
            ouo = false;
        }
        if (otQ && this.otO != otP) {
            db(this.otO);
            this.otO = otP;
            db(this.otO);
            addView(this.otO, 0);
            Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is changed in updateToolbar() because toolbar != mComponentView");
        }
        if (otQ && this.otO.getParent() != this) {
            db(this.otO);
            addView(this.otO, 0);
        }
        AppMethodBeat.o(230590);
    }

    /* access modifiers changed from: protected */
    public void Nq() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(136537);
        if (this.otO == null) {
            AppMethodBeat.o(136537);
            return;
        }
        if (this.otO instanceof a) {
            a aVar = (a) this.otO;
            if (!this.ouj) {
                z = true;
            } else {
                z = false;
            }
            if ((z && (!this.oul)) || y.cI(this)) {
                z2 = true;
            }
            aVar.setIsHide(z2);
        }
        AppMethodBeat.o(136537);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(136538);
        super.onMeasure(i2, i3);
        Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "smileyPanelWrapper, onMeasure");
        AppMethodBeat.o(136538);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(136539);
        super.onAttachedToWindow();
        cbI();
        AppMethodBeat.o(136539);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(136540);
        super.onDetachedFromWindow();
        Ai(8);
        if (this.context != null) {
            if (this.oum != null) {
                this.oun.hideVKB(this.oum);
            } else {
                this.oun.hideVKB();
            }
        }
        this.oug.onDestroy();
        if (this.oui != null) {
            this.oui.setOnClickListener(null);
        }
        this.ouc = null;
        removeAllViews();
        this.context = null;
        this.otZ.clear();
        cbJ();
        AppMethodBeat.o(136540);
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(136541);
        if (i2 == 8) {
            if (getVisibility() != i2) {
                cm(false);
            }
            hide();
            AppMethodBeat.o(136541);
        } else if (i2 == 0) {
            show();
            AppMethodBeat.o(136541);
        } else {
            Ai(i2);
            AppMethodBeat.o(136541);
        }
    }

    /* access modifiers changed from: package-private */
    public final void Ai(int i2) {
        AppMethodBeat.i(136542);
        if (i2 == 0 && y.cI(this)) {
            i2 = 8;
        }
        if (getVisibility() == i2) {
            AppMethodBeat.o(136542);
            return;
        }
        super.setVisibility(i2);
        if (i2 == 0) {
            cbI();
            AppMethodBeat.o(136542);
            return;
        }
        cbJ();
        AppMethodBeat.o(136542);
    }

    public void setCanSmileyInput(boolean z) {
        int i2 = 0;
        AppMethodBeat.i(136543);
        cbN();
        this.ouj = false;
        if (this.oui != null) {
            ImageButton imageButton = this.oui;
            if (!this.ouj) {
                i2 = 4;
            }
            imageButton.setVisibility(i2);
        }
        Nq();
        AppMethodBeat.o(136543);
    }

    public void setShowDoneButton(boolean z) {
        AppMethodBeat.i(136544);
        cbN();
        this.oul = z;
        if (this.ouk != null) {
            this.ouk.setVisibility(this.oul ? 0 : 4);
        }
        Nq();
        AppMethodBeat.o(136544);
    }

    public EditText getAttachedEditText() {
        return this.oum;
    }

    public final boolean b(EditText editText) {
        if (editText != this.oum) {
            return false;
        }
        this.oum = null;
        return true;
    }

    /* access modifiers changed from: protected */
    public void Nr() {
        AppMethodBeat.i(136545);
        setCanSmileyInput(this.ouj);
        setShowDoneButton(this.oul);
        Nq();
        AppMethodBeat.o(136545);
    }

    public void show() {
        AppMethodBeat.i(136546);
        if (this.oum != null) {
            cbK();
        }
        Nr();
        if (!isShown()) {
            Ai(0);
        }
        AppMethodBeat.o(136546);
    }

    public final void hide() {
        AppMethodBeat.i(136547);
        if (!isShown()) {
            AppMethodBeat.o(136547);
            return;
        }
        Ai(8);
        if (this.oum != null && !this.oun.hideVKBHavingResult()) {
            aj.dg(this).hideSoftInputFromWindow(getWindowToken(), 0);
        }
        cbM();
        AppMethodBeat.o(136547);
    }

    /* access modifiers changed from: package-private */
    public static final class h extends FrameLayout implements a {
        private boolean ouu = false;

        public h(Context context) {
            super(context);
            AppMethodBeat.i(136514);
            LayoutInflater.from(context).inflate(R.layout.h1, this);
            AppMethodBeat.o(136514);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.w.a
        public final void setIsHide(boolean z) {
            AppMethodBeat.i(136515);
            boolean z2 = z != this.ouu;
            this.ouu = z;
            if (z2 && (Build.VERSION.SDK_INT < 18 || !isInLayout())) {
                requestLayout();
            }
            AppMethodBeat.o(136515);
        }

        /* access modifiers changed from: protected */
        public final void onMeasure(int i2, int i3) {
            AppMethodBeat.i(136516);
            if (this.ouu || !isShown()) {
                i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
                i3 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            }
            super.onMeasure(i2, i3);
            AppMethodBeat.o(136516);
        }
    }

    static final class g implements b {
        private g() {
        }

        /* synthetic */ g(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.w.b
        public final void m(w wVar) {
            AppMethodBeat.i(136509);
            if (wVar.isShown()) {
                wVar.ouh.setVisibility(0);
            }
            wVar.oug.ccl();
            AppMethodBeat.o(136509);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.w.b
        public final void n(w wVar) {
            AppMethodBeat.i(136510);
            if (y.cI(wVar)) {
                wVar.Ai(8);
                w.g(wVar);
                AppMethodBeat.o(136510);
                return;
            }
            if (wVar.isShown()) {
                wVar.ouh.setVisibility(0);
            }
            if (!wVar.ouj) {
                wVar.oug.ccl();
                AppMethodBeat.o(136510);
                return;
            }
            wVar.oug.cck();
            AppMethodBeat.o(136510);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.w.b
        public final void c(w wVar, int i2) {
            AppMethodBeat.i(136511);
            if (y.cI(wVar)) {
                wVar.Ai(8);
                AppMethodBeat.o(136511);
            } else if (wVar.ouh == null || i2 <= 0) {
                AppMethodBeat.o(136511);
            } else {
                w.b(wVar, i2);
                AppMethodBeat.o(136511);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.w.b
        public final void o(w wVar) {
            AppMethodBeat.i(136512);
            wVar.oun.showVKB();
            w.j(wVar);
            AppMethodBeat.o(136512);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.w.b
        public final void p(w wVar) {
            AppMethodBeat.i(136513);
            wVar.oun.hideVKB();
            w.k(wVar);
            wVar.hF(KeyBoardUtil.getValidPanelHeight(wVar.context));
            AppMethodBeat.o(136513);
        }
    }

    static /* synthetic */ void c(w wVar) {
        AppMethodBeat.i(136548);
        Log.v("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] forceMeasurePanel enter");
        wVar.ouh.requestLayout();
        AppMethodBeat.o(136548);
    }
}
