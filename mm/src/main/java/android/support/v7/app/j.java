package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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
import android.support.v7.widget.ar;
import android.support.v7.widget.u;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class j extends ActionBar implements ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean $assertionsDisabled = (!j.class.desiredAssertionStatus());
    private static final Interpolator aap = new AccelerateInterpolator();
    private static final Interpolator aaq = new DecelerateInterpolator();
    private ArrayList<Object> Ep = new ArrayList<>();
    u ZU;
    private boolean ZY;
    private ArrayList<Object> ZZ = new ArrayList<>();
    b.a aaA;
    private boolean aaB;
    private int aaC = 0;
    boolean aaD = true;
    boolean aaE;
    boolean aaF;
    private boolean aaG;
    private boolean aaH = true;
    h aaI;
    private boolean aaJ;
    boolean aaK;
    final z aaL = new aa() {
        /* class android.support.v7.app.j.AnonymousClass1 */

        @Override // android.support.v4.view.aa, android.support.v4.view.z
        public final void aJ(View view) {
            if (j.this.aaD && j.this.mContentView != null) {
                j.this.mContentView.setTranslationY(0.0f);
                j.this.aat.setTranslationY(0.0f);
            }
            j.this.aat.setVisibility(8);
            j.this.aat.setTransitioning(false);
            j.this.aaI = null;
            j jVar = j.this;
            if (jVar.aaA != null) {
                jVar.aaA.a(jVar.aaz);
                jVar.aaz = null;
                jVar.aaA = null;
            }
            if (j.this.aas != null) {
                android.support.v4.view.u.ap(j.this.aas);
            }
        }
    };
    final z aaM = new aa() {
        /* class android.support.v7.app.j.AnonymousClass2 */

        @Override // android.support.v4.view.aa, android.support.v4.view.z
        public final void aJ(View view) {
            j.this.aaI = null;
            j.this.aat.requestLayout();
        }
    };
    final ab aaN = new ab() {
        /* class android.support.v7.app.j.AnonymousClass3 */

        @Override // android.support.v4.view.ab
        public final void fH() {
            ((View) j.this.aat.getParent()).invalidate();
        }
    };
    private Context aar;
    ActionBarOverlayLayout aas;
    ActionBarContainer aat;
    ActionBarContextView aau;
    ar aav;
    private int aaw = -1;
    private boolean aax;
    a aay;
    b aaz;
    private Activity mActivity;
    View mContentView;
    Context mContext;
    private Dialog mDialog;

    public j(Activity activity, boolean z) {
        this.mActivity = activity;
        View decorView = activity.getWindow().getDecorView();
        ba(decorView);
        if (!z) {
            this.mContentView = decorView.findViewById(16908290);
        }
    }

    public j(Dialog dialog) {
        this.mDialog = dialog;
        ba(dialog.getWindow().getDecorView());
    }

    private void ba(View view) {
        this.aas = (ActionBarOverlayLayout) view.findViewById(R.id.bl6);
        if (this.aas != null) {
            this.aas.setActionBarVisibilityCallback(this);
        }
        this.ZU = bb(view.findViewById(R.id.c7));
        this.aau = (ActionBarContextView) view.findViewById(R.id.cn);
        this.aat = (ActionBarContainer) view.findViewById(R.id.c_);
        if (this.ZU == null || this.aau == null || this.aat == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.mContext = this.ZU.getContext();
        if ((this.ZU.getDisplayOptions() & 4) != 0) {
            this.aax = true;
        }
        android.support.v7.view.a ab = android.support.v7.view.a.ab(this.mContext);
        ab.hD();
        S(ab.hC());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, a.C0040a.ActionBar, R.attr.a1, 0);
        if (obtainStyledAttributes.getBoolean(14, false)) {
            gv();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private static u bb(View view) {
        if (view instanceof u) {
            return (u) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + (view != null ? view.getClass().getSimpleName() : BuildConfig.COMMAND));
    }

    @Override // android.support.v7.app.ActionBar
    public final void setElevation(float f2) {
        android.support.v4.view.u.l(this.aat, f2);
    }

    @Override // android.support.v7.app.ActionBar
    public final void onConfigurationChanged(Configuration configuration) {
        S(android.support.v7.view.a.ab(this.mContext).hC());
    }

    private void S(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        this.aaB = z;
        if (!this.aaB) {
            this.ZU.a(null);
            this.aat.setTabContainer(this.aav);
        } else {
            this.aat.setTabContainer(null);
            this.ZU.a(this.aav);
        }
        if (getNavigationMode() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.aav != null) {
            if (z2) {
                this.aav.setVisibility(0);
                if (this.aas != null) {
                    android.support.v4.view.u.ap(this.aas);
                }
            } else {
                this.aav.setVisibility(8);
            }
        }
        u uVar = this.ZU;
        if (this.aaB || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        uVar.setCollapsible(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.aas;
        if (this.aaB || !z2) {
            z4 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z4);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public final void onWindowVisibilityChanged(int i2) {
        this.aaC = i2;
    }

    @Override // android.support.v7.app.ActionBar
    public final void Q(boolean z) {
        this.aaJ = z;
        if (!z && this.aaI != null) {
            this.aaI.cancel();
        }
    }

    @Override // android.support.v7.app.ActionBar
    public final void R(boolean z) {
        if (z != this.ZY) {
            this.ZY = z;
            int size = this.ZZ.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.ZZ.get(i2);
            }
        }
    }

    @Override // android.support.v7.app.ActionBar
    public final void setCustomView(int i2) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i2, this.ZU.jC(), false));
    }

    @Override // android.support.v7.app.ActionBar
    public final void gs() {
        setDisplayOptions(0, 2);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    @Override // android.support.v7.app.ActionBar
    public final void gt() {
        setDisplayOptions(0, 8);
    }

    @Override // android.support.v7.app.ActionBar
    public final void gu() {
        setDisplayOptions(16, 16);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setTitle(CharSequence charSequence) {
        this.ZU.setTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setWindowTitle(CharSequence charSequence) {
        this.ZU.setWindowTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setDisplayOptions(int i2) {
        if ((i2 & 4) != 0) {
            this.aax = true;
        }
        this.ZU.setDisplayOptions(i2);
    }

    private void setDisplayOptions(int i2, int i3) {
        int displayOptions = this.ZU.getDisplayOptions();
        if ((i3 & 4) != 0) {
            this.aax = true;
        }
        this.ZU.setDisplayOptions((displayOptions & (i3 ^ -1)) | (i2 & i3));
    }

    @Override // android.support.v7.app.ActionBar
    public final void setBackgroundDrawable(Drawable drawable) {
        this.aat.setPrimaryBackground(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public final View getCustomView() {
        return this.ZU.getCustomView();
    }

    @Override // android.support.v7.app.ActionBar
    public final CharSequence getTitle() {
        return this.ZU.getTitle();
    }

    private int getNavigationMode() {
        return this.ZU.getNavigationMode();
    }

    @Override // android.support.v7.app.ActionBar
    public final int getDisplayOptions() {
        return this.ZU.getDisplayOptions();
    }

    @Override // android.support.v7.app.ActionBar
    public final b a(b.a aVar) {
        if (this.aay != null) {
            this.aay.finish();
        }
        this.aas.setHideOnContentScrollEnabled(false);
        this.aau.iy();
        a aVar2 = new a(this.aau.getContext(), aVar);
        if (!aVar2.hb()) {
            return null;
        }
        this.aay = aVar2;
        aVar2.invalidate();
        this.aau.c(aVar2);
        X(true);
        this.aau.sendAccessibilityEvent(32);
        return aVar2;
    }

    @Override // android.support.v7.app.ActionBar
    public final int getHeight() {
        return this.aat.getHeight();
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public final void T(boolean z) {
        this.aaD = z;
    }

    @Override // android.support.v7.app.ActionBar
    public final void show() {
        if (this.aaE) {
            this.aaE = false;
            U(false);
        }
    }

    private void gW() {
        if (!this.aaG) {
            this.aaG = true;
            if (this.aas != null) {
                this.aas.setShowingForActionMode(true);
            }
            U(false);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public final void gX() {
        if (this.aaF) {
            this.aaF = false;
            U(true);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public final void hide() {
        if (!this.aaE) {
            this.aaE = true;
            U(false);
        }
    }

    private void gY() {
        if (this.aaG) {
            this.aaG = false;
            if (this.aas != null) {
                this.aas.setShowingForActionMode(false);
            }
            U(false);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public final void gZ() {
        if (!this.aaF) {
            this.aaF = true;
            U(true);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public final void gv() {
        if (!this.aas.ahX) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.aaK = true;
        this.aas.setHideOnContentScrollEnabled(true);
    }

    static boolean c(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void U(boolean z) {
        if (c(this.aaE, this.aaF, this.aaG)) {
            if (!this.aaH) {
                this.aaH = true;
                V(z);
            }
        } else if (this.aaH) {
            this.aaH = false;
            W(z);
        }
    }

    private void V(boolean z) {
        if (this.aaI != null) {
            this.aaI.cancel();
        }
        this.aat.setVisibility(0);
        if (this.aaC != 0 || (!this.aaJ && !z)) {
            this.aat.setAlpha(1.0f);
            this.aat.setTranslationY(0.0f);
            if (this.aaD && this.mContentView != null) {
                this.mContentView.setTranslationY(0.0f);
            }
            this.aaM.aJ(null);
        } else {
            this.aat.setTranslationY(0.0f);
            float f2 = (float) (-this.aat.getHeight());
            if (z) {
                int[] iArr = {0, 0};
                this.aat.getLocationInWindow(iArr);
                f2 -= (float) iArr[1];
            }
            this.aat.setTranslationY(f2);
            h hVar = new h();
            y z2 = android.support.v4.view.u.ah(this.aat).z(0.0f);
            z2.a(this.aaN);
            hVar.a(z2);
            if (this.aaD && this.mContentView != null) {
                this.mContentView.setTranslationY(f2);
                hVar.a(android.support.v4.view.u.ah(this.mContentView).z(0.0f));
            }
            hVar.b(aaq);
            hVar.hI();
            hVar.b(this.aaM);
            this.aaI = hVar;
            hVar.start();
        }
        if (this.aas != null) {
            android.support.v4.view.u.ap(this.aas);
        }
    }

    private void W(boolean z) {
        if (this.aaI != null) {
            this.aaI.cancel();
        }
        if (this.aaC != 0 || (!this.aaJ && !z)) {
            this.aaL.aJ(null);
            return;
        }
        this.aat.setAlpha(1.0f);
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
    }

    public final void X(boolean z) {
        y c2;
        y c3;
        if (z) {
            gW();
        } else {
            gY();
        }
        if (android.support.v4.view.u.az(this.aat)) {
            if (z) {
                c3 = this.ZU.c(4, 100);
                c2 = this.aau.c(0, 200);
            } else {
                c2 = this.ZU.c(0, 200);
                c3 = this.aau.c(8, 100);
            }
            h hVar = new h();
            hVar.a(c3, c2);
            hVar.start();
        } else if (z) {
            this.ZU.setVisibility(4);
            this.aau.setVisibility(0);
        } else {
            this.ZU.setVisibility(0);
            this.aau.setVisibility(8);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public final Context getThemedContext() {
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
        return this.aar;
    }

    @Override // android.support.v7.app.ActionBar
    public final void setHomeActionContentDescription(int i2) {
        this.ZU.setNavigationContentDescription(i2);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public final void ha() {
        if (this.aaI != null) {
            this.aaI.cancel();
            this.aaI = null;
        }
    }

    @Override // android.support.v7.app.ActionBar
    public final boolean collapseActionView() {
        if (this.ZU == null || !this.ZU.hasExpandedActionView()) {
            return false;
        }
        this.ZU.collapseActionView();
        return true;
    }

    public class a extends b implements h.a {
        private final Context aaP;
        final android.support.v7.view.menu.h aaQ;
        private b.a aaR;
        private WeakReference<View> aaS;

        public a(Context context, b.a aVar) {
            this.aaP = context;
            this.aaR = aVar;
            android.support.v7.view.menu.h hVar = new android.support.v7.view.menu.h(context);
            hVar.agw = 1;
            this.aaQ = hVar;
            this.aaQ.a(this);
        }

        @Override // android.support.v7.view.b
        public final MenuInflater getMenuInflater() {
            return new g(this.aaP);
        }

        @Override // android.support.v7.view.b
        public final Menu getMenu() {
            return this.aaQ;
        }

        @Override // android.support.v7.view.b
        public final void finish() {
            if (j.this.aay == this) {
                if (!j.c(j.this.aaE, j.this.aaF, false)) {
                    j.this.aaz = this;
                    j.this.aaA = this.aaR;
                } else {
                    this.aaR.a(this);
                }
                this.aaR = null;
                j.this.X(false);
                j.this.aau.ix();
                j.this.ZU.jC().sendAccessibilityEvent(32);
                j.this.aas.setHideOnContentScrollEnabled(j.this.aaK);
                j.this.aay = null;
            }
        }

        @Override // android.support.v7.view.b
        public final void invalidate() {
            if (j.this.aay == this) {
                this.aaQ.ia();
                try {
                    this.aaR.b(this, this.aaQ);
                } finally {
                    this.aaQ.ib();
                }
            }
        }

        public final boolean hb() {
            this.aaQ.ia();
            try {
                return this.aaR.a(this, this.aaQ);
            } finally {
                this.aaQ.ib();
            }
        }

        @Override // android.support.v7.view.b
        public final void setCustomView(View view) {
            j.this.aau.setCustomView(view);
            this.aaS = new WeakReference<>(view);
        }

        @Override // android.support.v7.view.b
        public final void setSubtitle(CharSequence charSequence) {
            j.this.aau.setSubtitle(charSequence);
        }

        @Override // android.support.v7.view.b
        public final void setTitle(CharSequence charSequence) {
            j.this.aau.setTitle(charSequence);
        }

        @Override // android.support.v7.view.b
        public final void setTitle(int i2) {
            setTitle(j.this.mContext.getResources().getString(i2));
        }

        @Override // android.support.v7.view.b
        public final void setSubtitle(int i2) {
            setSubtitle(j.this.mContext.getResources().getString(i2));
        }

        @Override // android.support.v7.view.b
        public final CharSequence getTitle() {
            return j.this.aau.getTitle();
        }

        @Override // android.support.v7.view.b
        public final CharSequence getSubtitle() {
            return j.this.aau.getSubtitle();
        }

        @Override // android.support.v7.view.b
        public final void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            j.this.aau.setTitleOptional(z);
        }

        @Override // android.support.v7.view.b
        public final boolean isTitleOptional() {
            return j.this.aau.ahO;
        }

        @Override // android.support.v7.view.b
        public final View getCustomView() {
            if (this.aaS != null) {
                return this.aaS.get();
            }
            return null;
        }

        @Override // android.support.v7.view.menu.h.a
        public final boolean a(android.support.v7.view.menu.h hVar, MenuItem menuItem) {
            if (this.aaR != null) {
                return this.aaR.a(this, menuItem);
            }
            return false;
        }

        @Override // android.support.v7.view.menu.h.a
        public final void b(android.support.v7.view.menu.h hVar) {
            if (this.aaR != null) {
                invalidate();
                j.this.aau.showOverflowMenu();
            }
        }
    }

    @Override // android.support.v7.app.ActionBar
    public final void setCustomView(View view) {
        this.ZU.setCustomView(view);
    }

    @Override // android.support.v7.app.ActionBar
    public final void a(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.ZU.setCustomView(view);
    }

    @Override // android.support.v7.app.ActionBar
    public final void gr() {
        this.ZU.setIcon(R.drawable.b0w);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setLogo(Drawable drawable) {
        this.ZU.setLogo(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public final void P(boolean z) {
        if (!this.aax) {
            setDisplayHomeAsUpEnabled(z);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public final boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        android.support.v7.view.menu.h hVar;
        boolean z;
        if (this.aay == null || (hVar = this.aay.aaQ) == null) {
            return false;
        }
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
            z = true;
        } else {
            z = false;
        }
        hVar.setQwertyMode(z);
        return hVar.performShortcut(i2, keyEvent, 0);
    }

    @Override // android.support.v7.app.ActionBar
    public final boolean isShowing() {
        int height = this.aat.getHeight();
        return this.aaH && (height == 0 || this.aas.getActionBarHideOffset() < height);
    }
}
