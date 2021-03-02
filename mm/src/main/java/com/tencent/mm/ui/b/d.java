package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.aa;
import android.support.v4.view.ab;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v7.a.a;
import android.support.v7.app.ActionBar;
import android.support.v7.view.b;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.view.menu.h;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.u;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d extends ActionBar implements ActionBarOverlayLayout.a {
    private static final boolean OMf = (Build.VERSION.SDK_INT >= 14);
    private static final Interpolator aap = new AccelerateInterpolator();
    private static final Interpolator aaq = new DecelerateInterpolator();
    a OMg;
    u ZU;
    private boolean ZY;
    private ArrayList<Object> ZZ = new ArrayList<>();
    b.a aaA;
    private int aaC = 0;
    private boolean aaD = true;
    private boolean aaE;
    private boolean aaF;
    private boolean aaG;
    private boolean aaH = true;
    private h aaI;
    private boolean aaJ;
    final z aaL = new aa() {
        /* class com.tencent.mm.ui.b.d.AnonymousClass1 */

        @Override // android.support.v4.view.aa, android.support.v4.view.z
        public final void aJ(View view) {
            AppMethodBeat.i(141518);
            if (d.this.aaD && d.this.mContentView != null) {
                android.support.v4.view.u.f(d.this.mContentView, 0.0f);
                android.support.v4.view.u.f(d.this.aat, 0.0f);
            }
            d.this.aat.setVisibility(8);
            d.this.aat.setTransitioning(false);
            d.this.aaI = null;
            d dVar = d.this;
            if (dVar.aaA != null) {
                dVar.aaA.a(dVar.aaz);
                dVar.aaz = null;
                dVar.aaA = null;
            }
            AppMethodBeat.o(141518);
        }
    };
    final z aaM = new aa() {
        /* class com.tencent.mm.ui.b.d.AnonymousClass2 */

        @Override // android.support.v4.view.aa, android.support.v4.view.z
        public final void aJ(View view) {
            AppMethodBeat.i(141519);
            d.this.aaI = null;
            d.this.aat.requestLayout();
            AppMethodBeat.o(141519);
        }
    };
    final ab aaN = new ab() {
        /* class com.tencent.mm.ui.b.d.AnonymousClass3 */

        @Override // android.support.v4.view.ab
        public final void fH() {
            AppMethodBeat.i(141520);
            ((View) d.this.aat.getParent()).invalidate();
            AppMethodBeat.o(141520);
        }
    };
    private Context aar;
    private ActionBarContainer aat;
    private ActionBarContextView aau;
    private boolean aax;
    b aaz;
    private Activity mActivity;
    private View mContentView;
    private Context mContext;

    static /* synthetic */ boolean bd(boolean z, boolean z2) {
        AppMethodBeat.i(141576);
        boolean c2 = c(z, z2, false);
        AppMethodBeat.o(141576);
        return c2;
    }

    static {
        AppMethodBeat.i(141577);
        AppMethodBeat.o(141577);
    }

    public d(Activity activity, ViewGroup viewGroup) {
        u wrapper;
        AppMethodBeat.i(141538);
        this.mActivity = activity;
        View findViewById = viewGroup.findViewById(R.id.c7);
        if (findViewById instanceof u) {
            wrapper = (u) findViewById;
        } else if (findViewById instanceof Toolbar) {
            wrapper = ((Toolbar) findViewById).getWrapper();
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Can't make a decor toolbar out of ".concat(String.valueOf(findViewById)) != null ? findViewById.getClass().getSimpleName() : BuildConfig.COMMAND);
            AppMethodBeat.o(141538);
            throw illegalStateException;
        }
        this.ZU = wrapper;
        this.aau = (ActionBarContextView) viewGroup.findViewById(R.id.cn);
        this.aat = (ActionBarContainer) viewGroup.findViewById(R.id.c_);
        if (this.ZU == null || this.aau == null || this.aat == null) {
            IllegalStateException illegalStateException2 = new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
            AppMethodBeat.o(141538);
            throw illegalStateException2;
        }
        this.mContext = this.ZU.getContext();
        if ((this.ZU.getDisplayOptions() & 4) != 0) {
            this.aax = true;
        }
        android.support.v7.view.a.ab(this.mContext).hD();
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, a.C0040a.ActionBar, R.attr.a1, 0);
        obtainStyledAttributes.getBoolean(14, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
        this.mContentView = null;
        AppMethodBeat.o(141538);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setElevation(float f2) {
        AppMethodBeat.i(141539);
        android.support.v4.view.u.l(this.aat, f2);
        AppMethodBeat.o(141539);
    }

    @Override // android.support.v7.app.ActionBar
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(141540);
        ViewGroup.LayoutParams layoutParams = this.ZU.jC().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = com.tencent.mm.compatible.util.a.cy(this.mActivity);
        }
        this.ZU.jC().setLayoutParams(layoutParams);
        AppMethodBeat.o(141540);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public final void onWindowVisibilityChanged(int i2) {
        this.aaC = i2;
    }

    @Override // android.support.v7.app.ActionBar
    public final void Q(boolean z) {
        AppMethodBeat.i(141541);
        this.aaJ = z;
        if (!z && this.aaI != null) {
            this.aaI.cancel();
        }
        AppMethodBeat.o(141541);
    }

    @Override // android.support.v7.app.ActionBar
    public final void R(boolean z) {
        AppMethodBeat.i(141542);
        if (z == this.ZY) {
            AppMethodBeat.o(141542);
            return;
        }
        this.ZY = z;
        int size = this.ZZ.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.ZZ.get(i2);
        }
        AppMethodBeat.o(141542);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setCustomView(int i2) {
        AppMethodBeat.i(141543);
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i2, this.ZU.jC(), false));
        AppMethodBeat.o(141543);
    }

    @Override // android.support.v7.app.ActionBar
    public final void gs() {
        AppMethodBeat.i(141544);
        setDisplayOptions(0, 2);
        AppMethodBeat.o(141544);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setDisplayHomeAsUpEnabled(boolean z) {
        AppMethodBeat.i(141545);
        setDisplayOptions(z ? 4 : 0, 4);
        AppMethodBeat.o(141545);
    }

    @Override // android.support.v7.app.ActionBar
    public final void gt() {
        AppMethodBeat.i(141546);
        setDisplayOptions(0, 8);
        AppMethodBeat.o(141546);
    }

    @Override // android.support.v7.app.ActionBar
    public final void gu() {
        AppMethodBeat.i(141547);
        setDisplayOptions(16, 16);
        AppMethodBeat.o(141547);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setTitle(CharSequence charSequence) {
        AppMethodBeat.i(205157);
        this.ZU.setTitle(charSequence);
        AppMethodBeat.o(205157);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setWindowTitle(CharSequence charSequence) {
        AppMethodBeat.i(141548);
        this.ZU.setWindowTitle(charSequence);
        AppMethodBeat.o(141548);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setDisplayOptions(int i2) {
        AppMethodBeat.i(141549);
        if ((i2 & 4) != 0) {
            this.aax = true;
        }
        this.ZU.setDisplayOptions(i2);
        AppMethodBeat.o(141549);
    }

    private void setDisplayOptions(int i2, int i3) {
        AppMethodBeat.i(141550);
        int displayOptions = this.ZU.getDisplayOptions();
        if ((i3 & 4) != 0) {
            this.aax = true;
        }
        this.ZU.setDisplayOptions((displayOptions & (i3 ^ -1)) | (i2 & i3));
        AppMethodBeat.o(141550);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setBackgroundDrawable(Drawable drawable) {
        AppMethodBeat.i(141551);
        this.aat.setPrimaryBackground(drawable);
        AppMethodBeat.o(141551);
    }

    @Override // android.support.v7.app.ActionBar
    public final View getCustomView() {
        AppMethodBeat.i(141552);
        View customView = this.ZU.getCustomView();
        AppMethodBeat.o(141552);
        return customView;
    }

    @Override // android.support.v7.app.ActionBar
    public final CharSequence getTitle() {
        AppMethodBeat.i(141553);
        CharSequence title = this.ZU.getTitle();
        AppMethodBeat.o(141553);
        return title;
    }

    @Override // android.support.v7.app.ActionBar
    public final int getDisplayOptions() {
        AppMethodBeat.i(141554);
        int displayOptions = this.ZU.getDisplayOptions();
        AppMethodBeat.o(141554);
        return displayOptions;
    }

    @Override // android.support.v7.app.ActionBar
    public final b a(b.a aVar) {
        AppMethodBeat.i(141555);
        if (this.OMg != null) {
            this.OMg.finish();
        }
        this.aau.iy();
        a aVar2 = new a(this.aau.getContext(), aVar);
        if (aVar2.hb()) {
            aVar2.invalidate();
            this.aau.c(aVar2);
            X(true);
            this.aau.sendAccessibilityEvent(32);
            this.OMg = aVar2;
            AppMethodBeat.o(141555);
            return aVar2;
        }
        AppMethodBeat.o(141555);
        return null;
    }

    @Override // android.support.v7.app.ActionBar
    public final int getHeight() {
        AppMethodBeat.i(141556);
        int height = this.aat.getHeight();
        AppMethodBeat.o(141556);
        return height;
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public final void T(boolean z) {
        this.aaD = z;
    }

    @Override // android.support.v7.app.ActionBar
    public final void show() {
        AppMethodBeat.i(141557);
        if (this.aaE) {
            this.aaE = false;
            U(false);
        }
        AppMethodBeat.o(141557);
    }

    private void gW() {
        AppMethodBeat.i(141558);
        if (!this.aaG) {
            this.aaG = true;
            U(false);
        }
        AppMethodBeat.o(141558);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public final void gX() {
        AppMethodBeat.i(141559);
        if (this.aaF) {
            this.aaF = false;
            U(true);
        }
        AppMethodBeat.o(141559);
    }

    @Override // android.support.v7.app.ActionBar
    public final void hide() {
        AppMethodBeat.i(141560);
        if (!this.aaE) {
            this.aaE = true;
            U(false);
        }
        AppMethodBeat.o(141560);
    }

    private void gY() {
        AppMethodBeat.i(141561);
        if (this.aaG) {
            this.aaG = false;
            U(false);
        }
        AppMethodBeat.o(141561);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public final void gZ() {
        AppMethodBeat.i(141562);
        if (!this.aaF) {
            this.aaF = true;
            U(true);
        }
        AppMethodBeat.o(141562);
    }

    @Override // android.support.v7.app.ActionBar
    public final void gv() {
    }

    private static boolean c(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void U(boolean z) {
        AppMethodBeat.i(141563);
        if (c(this.aaE, this.aaF, this.aaG)) {
            if (!this.aaH) {
                this.aaH = true;
                V(z);
                AppMethodBeat.o(141563);
                return;
            }
        } else if (this.aaH) {
            this.aaH = false;
            W(z);
        }
        AppMethodBeat.o(141563);
    }

    private void V(boolean z) {
        AppMethodBeat.i(141564);
        if (this.aaI != null) {
            this.aaI.cancel();
        }
        this.aat.setVisibility(0);
        if (this.aaC != 0 || !OMf || (!this.aaJ && !z)) {
            android.support.v4.view.u.g(this.aat, 1.0f);
            android.support.v4.view.u.f(this.aat, 0.0f);
            if (this.aaD && this.mContentView != null) {
                android.support.v4.view.u.f(this.mContentView, 0.0f);
            }
            this.aaM.aJ(null);
            AppMethodBeat.o(141564);
            return;
        }
        android.support.v4.view.u.f(this.aat, 0.0f);
        float f2 = (float) (-this.aat.getHeight());
        if (z) {
            int[] iArr = {0, 0};
            this.aat.getLocationInWindow(iArr);
            f2 -= (float) iArr[1];
        }
        android.support.v4.view.u.f(this.aat, f2);
        h hVar = new h();
        y z2 = android.support.v4.view.u.ah(this.aat).z(0.0f);
        z2.a(this.aaN);
        hVar.a(z2);
        if (this.aaD && this.mContentView != null) {
            android.support.v4.view.u.f(this.mContentView, f2);
            hVar.a(android.support.v4.view.u.ah(this.mContentView).z(0.0f));
        }
        hVar.b(aaq);
        hVar.hI();
        hVar.b(this.aaM);
        this.aaI = hVar;
        hVar.start();
        AppMethodBeat.o(141564);
    }

    private void W(boolean z) {
        AppMethodBeat.i(141565);
        if (this.aaI != null) {
            this.aaI.cancel();
        }
        if (this.aaC != 0 || !OMf || (!this.aaJ && !z)) {
            this.aaL.aJ(null);
            AppMethodBeat.o(141565);
            return;
        }
        android.support.v4.view.u.g(this.aat, 1.0f);
        this.aat.setTransitioning(true);
        h hVar = new h();
        float f2 = (float) (-this.aat.getHeight());
        if (z) {
            int[] iArr = {0, 0};
            this.aat.getLocationInWindow(iArr);
            f2 -= (float) iArr[1];
        }
        y z2 = android.support.v4.view.u.ah(this.aat).z(f2);
        z2.a(this.aaN);
        hVar.a(z2);
        if (this.aaD && this.mContentView != null) {
            hVar.a(android.support.v4.view.u.ah(this.mContentView).z(f2));
        }
        hVar.b(aap);
        hVar.hI();
        hVar.b(this.aaL);
        this.aaI = hVar;
        hVar.start();
        AppMethodBeat.o(141565);
    }

    public final void X(boolean z) {
        y c2;
        y c3;
        AppMethodBeat.i(141567);
        if (z) {
            gW();
        } else {
            gY();
        }
        if (z) {
            c3 = this.ZU.c(8, 100);
            c2 = this.aau.c(0, 200);
        } else {
            c2 = this.ZU.c(0, 200);
            c3 = this.aau.c(8, 100);
        }
        h hVar = new h();
        hVar.a(c3, c2);
        hVar.start();
        AppMethodBeat.o(141567);
    }

    @Override // android.support.v7.app.ActionBar
    public final Context getThemedContext() {
        AppMethodBeat.i(141568);
        if (this.aar == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.a6, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.aar = new ContextThemeWrapper(this.mContext, i2);
            } else {
                this.aar = this.mContext;
            }
        }
        Context context = this.aar;
        AppMethodBeat.o(141568);
        return context;
    }

    @Override // android.support.v7.app.ActionBar
    public final void setHomeActionContentDescription(int i2) {
        AppMethodBeat.i(141569);
        this.ZU.setNavigationContentDescription(i2);
        AppMethodBeat.o(141569);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public final void ha() {
        AppMethodBeat.i(141570);
        if (this.aaI != null) {
            this.aaI.cancel();
            this.aaI = null;
        }
        AppMethodBeat.o(141570);
    }

    @Override // android.support.v7.app.ActionBar
    public final boolean collapseActionView() {
        AppMethodBeat.i(141571);
        if (this.ZU == null || !this.ZU.hasExpandedActionView()) {
            AppMethodBeat.o(141571);
            return false;
        }
        this.ZU.collapseActionView();
        AppMethodBeat.o(141571);
        return true;
    }

    public class a extends b implements h.a {
        private final Context aaP;
        private final android.support.v7.view.menu.h aaQ;
        private b.a aaR;
        private WeakReference<View> aaS;

        public a(Context context, b.a aVar) {
            AppMethodBeat.i(141521);
            this.aaP = context;
            this.aaR = aVar;
            android.support.v7.view.menu.h hVar = new android.support.v7.view.menu.h(context);
            hVar.agw = 1;
            this.aaQ = hVar;
            this.aaQ.a(this);
            AppMethodBeat.o(141521);
        }

        @Override // android.support.v7.view.b
        public final MenuInflater getMenuInflater() {
            AppMethodBeat.i(141522);
            g gVar = new g(this.aaP);
            AppMethodBeat.o(141522);
            return gVar;
        }

        @Override // android.support.v7.view.b
        public final Menu getMenu() {
            return this.aaQ;
        }

        @Override // android.support.v7.view.b
        public final void finish() {
            AppMethodBeat.i(141523);
            if (d.this.OMg != this) {
                AppMethodBeat.o(141523);
                return;
            }
            if (!d.bd(d.this.aaE, d.this.aaF)) {
                d.this.aaz = this;
                d.this.aaA = this.aaR;
            } else {
                this.aaR.a(this);
            }
            this.aaR = null;
            d.this.X(false);
            d.this.aau.ix();
            d.this.ZU.jC().sendAccessibilityEvent(32);
            d.this.OMg = null;
            AppMethodBeat.o(141523);
        }

        @Override // android.support.v7.view.b
        public final void invalidate() {
            AppMethodBeat.i(141524);
            if (d.this.OMg != this) {
                AppMethodBeat.o(141524);
                return;
            }
            this.aaQ.ia();
            try {
                this.aaR.b(this, this.aaQ);
            } finally {
                this.aaQ.ib();
                AppMethodBeat.o(141524);
            }
        }

        public final boolean hb() {
            AppMethodBeat.i(141525);
            this.aaQ.ia();
            try {
                return this.aaR.a(this, this.aaQ);
            } finally {
                this.aaQ.ib();
                AppMethodBeat.o(141525);
            }
        }

        @Override // android.support.v7.view.b
        public final void setCustomView(View view) {
            AppMethodBeat.i(141526);
            d.this.aau.setCustomView(view);
            this.aaS = new WeakReference<>(view);
            AppMethodBeat.o(141526);
        }

        @Override // android.support.v7.view.b
        public final void setSubtitle(CharSequence charSequence) {
            AppMethodBeat.i(141527);
            d.this.aau.setSubtitle(charSequence);
            AppMethodBeat.o(141527);
        }

        @Override // android.support.v7.view.b
        public final void setTitle(CharSequence charSequence) {
            AppMethodBeat.i(141528);
            d.this.aau.setTitle(charSequence);
            AppMethodBeat.o(141528);
        }

        @Override // android.support.v7.view.b
        public final void setTitle(int i2) {
            AppMethodBeat.i(141529);
            setTitle(d.this.mContext.getResources().getString(i2));
            AppMethodBeat.o(141529);
        }

        @Override // android.support.v7.view.b
        public final void setSubtitle(int i2) {
            AppMethodBeat.i(141530);
            setSubtitle(d.this.mContext.getResources().getString(i2));
            AppMethodBeat.o(141530);
        }

        @Override // android.support.v7.view.b
        public final CharSequence getTitle() {
            AppMethodBeat.i(141531);
            CharSequence title = d.this.aau.getTitle();
            AppMethodBeat.o(141531);
            return title;
        }

        @Override // android.support.v7.view.b
        public final CharSequence getSubtitle() {
            AppMethodBeat.i(141532);
            CharSequence subtitle = d.this.aau.getSubtitle();
            AppMethodBeat.o(141532);
            return subtitle;
        }

        @Override // android.support.v7.view.b
        public final void setTitleOptionalHint(boolean z) {
            AppMethodBeat.i(141533);
            super.setTitleOptionalHint(z);
            d.this.aau.setTitleOptional(z);
            AppMethodBeat.o(141533);
        }

        @Override // android.support.v7.view.b
        public final boolean isTitleOptional() {
            AppMethodBeat.i(141534);
            boolean z = d.this.aau.ahO;
            AppMethodBeat.o(141534);
            return z;
        }

        @Override // android.support.v7.view.b
        public final View getCustomView() {
            AppMethodBeat.i(141535);
            if (this.aaS != null) {
                View view = this.aaS.get();
                AppMethodBeat.o(141535);
                return view;
            }
            AppMethodBeat.o(141535);
            return null;
        }

        @Override // android.support.v7.view.menu.h.a
        public final boolean a(android.support.v7.view.menu.h hVar, MenuItem menuItem) {
            AppMethodBeat.i(141536);
            if (this.aaR != null) {
                boolean a2 = this.aaR.a(this, menuItem);
                AppMethodBeat.o(141536);
                return a2;
            }
            AppMethodBeat.o(141536);
            return false;
        }

        @Override // android.support.v7.view.menu.h.a
        public final void b(android.support.v7.view.menu.h hVar) {
            AppMethodBeat.i(141537);
            if (this.aaR == null) {
                AppMethodBeat.o(141537);
                return;
            }
            invalidate();
            d.this.aau.showOverflowMenu();
            AppMethodBeat.o(141537);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public final void setCustomView(View view) {
        AppMethodBeat.i(141572);
        this.ZU.setCustomView(view);
        AppMethodBeat.o(141572);
    }

    @Override // android.support.v7.app.ActionBar
    public final void a(View view, ActionBar.LayoutParams layoutParams) {
        AppMethodBeat.i(205158);
        view.setLayoutParams(layoutParams);
        this.ZU.setCustomView(view);
        AppMethodBeat.o(205158);
    }

    @Override // android.support.v7.app.ActionBar
    public final void gr() {
        AppMethodBeat.i(141573);
        this.ZU.setIcon(R.drawable.b0w);
        AppMethodBeat.o(141573);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setLogo(Drawable drawable) {
        AppMethodBeat.i(141574);
        this.ZU.setLogo(drawable);
        AppMethodBeat.o(141574);
    }

    @Override // android.support.v7.app.ActionBar
    public final void P(boolean z) {
        AppMethodBeat.i(141575);
        if (!this.aax) {
            setDisplayHomeAsUpEnabled(z);
        }
        AppMethodBeat.o(141575);
    }

    @Override // android.support.v7.app.ActionBar
    public final boolean isShowing() {
        AppMethodBeat.i(141566);
        int height = this.aat.getHeight();
        if (!this.aaH || (height != 0 && height <= 0)) {
            AppMethodBeat.o(141566);
            return false;
        }
        AppMethodBeat.o(141566);
        return true;
    }
}
