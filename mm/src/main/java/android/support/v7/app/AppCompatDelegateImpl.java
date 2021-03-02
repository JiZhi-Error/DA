package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.q;
import android.support.v4.view.ac;
import android.support.v4.view.e;
import android.support.v4.view.p;
import android.support.v4.view.u;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v7.a.a;
import android.support.v7.app.a;
import android.support.v7.view.b;
import android.support.v7.view.f;
import android.support.v7.view.i;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.aa;
import android.support.v7.widget.az;
import android.support.v7.widget.be;
import android.support.v7.widget.bh;
import android.support.v7.widget.t;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* access modifiers changed from: package-private */
public final class AppCompatDelegateImpl extends d implements h.a, LayoutInflater.Factory2 {
    private static final boolean Yw = (Build.VERSION.SDK_INT < 21);
    private static final int[] Yx = {16842836};
    private static boolean Yy = true;
    private CharSequence Hn;
    final Window WZ;
    private TextView Xy;
    final Window.Callback YA;
    final c YB;
    MenuInflater YC;
    private t YD;
    private b YE;
    private g YF;
    android.support.v7.view.b YG;
    ActionBarContextView YH;
    PopupWindow YI;
    Runnable YJ;
    y YK = null;
    boolean YL = true;
    private boolean YM;
    private ViewGroup YN;
    private View YO;
    private boolean YP;
    private boolean YQ;
    boolean YR;
    boolean YS;
    boolean YT;
    boolean YU;
    boolean YV;
    private boolean YW;
    private PanelFeatureState[] YX;
    private PanelFeatureState YY;
    private boolean YZ;
    final Window.Callback Yz;
    private int Za = -100;
    private boolean Zb;
    private e Zc;
    boolean Zd;
    int Ze;
    private final Runnable Zf = new Runnable() {
        /* class android.support.v7.app.AppCompatDelegateImpl.AnonymousClass2 */

        public final void run() {
            if ((AppCompatDelegateImpl.this.Ze & 1) != 0) {
                AppCompatDelegateImpl.this.bk(0);
            }
            if ((AppCompatDelegateImpl.this.Ze & 4096) != 0) {
                AppCompatDelegateImpl.this.bk(108);
            }
            AppCompatDelegateImpl.this.Zd = false;
            AppCompatDelegateImpl.this.Ze = 0;
        }
    };
    private boolean Zg;
    private Rect Zh;
    private Rect Zi;
    private AppCompatViewInflater Zj;
    ActionBar mActionBar;
    final Context mContext;
    boolean mIsDestroyed;

    static {
        if (Yw && !Yy) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                /* class android.support.v7.app.AppCompatDelegateImpl.AnonymousClass1 */

                public final void uncaughtException(Thread thread, Throwable th) {
                    String message;
                    boolean z = false;
                    if ((th instanceof Resources.NotFoundException) && (message = th.getMessage()) != null && (message.contains("drawable") || message.contains("Drawable"))) {
                        z = true;
                    }
                    if (z) {
                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            });
        }
    }

    AppCompatDelegateImpl(Context context, Window window, c cVar) {
        this.mContext = context;
        this.WZ = window;
        this.YB = cVar;
        this.Yz = this.WZ.getCallback();
        if (this.Yz instanceof d) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.YA = new d(this.Yz);
        this.WZ.setCallback(this.YA);
        az a2 = az.a(context, (AttributeSet) null, Yx);
        Drawable cU = a2.cU(0);
        if (cU != null) {
            this.WZ.setBackgroundDrawable(cU);
        }
        a2.ayy.recycle();
    }

    @Override // android.support.v7.app.d
    public final void onCreate(Bundle bundle) {
        String str;
        if (this.Yz instanceof Activity) {
            try {
                str = q.i((Activity) this.Yz);
            } catch (IllegalArgumentException e2) {
                str = null;
            }
            if (str != null) {
                ActionBar actionBar = this.mActionBar;
                if (actionBar == null) {
                    this.Zg = true;
                } else {
                    actionBar.P(true);
                }
            }
        }
        if (bundle != null && this.Za == -100) {
            this.Za = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    @Override // android.support.v7.app.d
    public final void gA() {
        gF();
    }

    @Override // android.support.v7.app.d
    public final ActionBar getSupportActionBar() {
        gD();
        return this.mActionBar;
    }

    private void gD() {
        gF();
        if (this.YR && this.mActionBar == null) {
            if (this.Yz instanceof Activity) {
                this.mActionBar = new j((Activity) this.Yz, this.YS);
            } else if (this.Yz instanceof Dialog) {
                this.mActionBar = new j((Dialog) this.Yz);
            }
            if (this.mActionBar != null) {
                this.mActionBar.P(this.Zg);
            }
        }
    }

    @Override // android.support.v7.app.d
    public final void setSupportActionBar(Toolbar toolbar) {
        if (this.Yz instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar instanceof j) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.YC = null;
            if (supportActionBar != null) {
                supportActionBar.onDestroy();
            }
            if (toolbar != null) {
                g gVar = new g(toolbar, ((Activity) this.Yz).getTitle(), this.YA);
                this.mActionBar = gVar;
                this.WZ.setCallback(gVar.ZW);
            } else {
                this.mActionBar = null;
                this.WZ.setCallback(this.YA);
            }
            invalidateOptionsMenu();
        }
    }

    private Context gE() {
        Context context = null;
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            context = supportActionBar.getThemedContext();
        }
        if (context == null) {
            return this.mContext;
        }
        return context;
    }

    @Override // android.support.v7.app.d
    public final MenuInflater getMenuInflater() {
        if (this.YC == null) {
            gD();
            this.YC = new android.support.v7.view.g(this.mActionBar != null ? this.mActionBar.getThemedContext() : this.mContext);
        }
        return this.YC;
    }

    @Override // android.support.v7.app.d
    public final <T extends View> T findViewById(int i2) {
        gF();
        return (T) this.WZ.findViewById(i2);
    }

    @Override // android.support.v7.app.d
    public final void onConfigurationChanged(Configuration configuration) {
        ActionBar supportActionBar;
        if (this.YR && this.YM && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.onConfigurationChanged(configuration);
        }
        android.support.v7.widget.g.jk().ac(this.mContext);
        gC();
    }

    @Override // android.support.v7.app.d
    public final void onStart() {
        gC();
    }

    @Override // android.support.v7.app.d
    public final void onStop() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.Q(false);
        }
        if (this.Zc != null) {
            this.Zc.cleanup();
        }
    }

    @Override // android.support.v7.app.d
    public final void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.Q(true);
        }
    }

    @Override // android.support.v7.app.d
    public final void setContentView(View view) {
        gF();
        ViewGroup viewGroup = (ViewGroup) this.YN.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.Yz.onContentChanged();
    }

    @Override // android.support.v7.app.d
    public final void setContentView(int i2) {
        gF();
        ViewGroup viewGroup = (ViewGroup) this.YN.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i2, viewGroup);
        this.Yz.onContentChanged();
    }

    @Override // android.support.v7.app.d
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        gF();
        ViewGroup viewGroup = (ViewGroup) this.YN.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.Yz.onContentChanged();
    }

    @Override // android.support.v7.app.d
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        gF();
        ((ViewGroup) this.YN.findViewById(16908290)).addView(view, layoutParams);
        this.Yz.onContentChanged();
    }

    @Override // android.support.v7.app.d
    public final void onSaveInstanceState(Bundle bundle) {
        if (this.Za != -100) {
            bundle.putInt("appcompat:local_night_mode", this.Za);
        }
    }

    @Override // android.support.v7.app.d
    public final void onDestroy() {
        if (this.Zd) {
            this.WZ.getDecorView().removeCallbacks(this.Zf);
        }
        this.mIsDestroyed = true;
        if (this.mActionBar != null) {
            this.mActionBar.onDestroy();
        }
        if (this.Zc != null) {
            this.Zc.cleanup();
        }
    }

    private void gF() {
        if (!this.YM) {
            this.YN = gG();
            CharSequence title = getTitle();
            if (!TextUtils.isEmpty(title)) {
                if (this.YD != null) {
                    this.YD.setWindowTitle(title);
                } else if (this.mActionBar != null) {
                    this.mActionBar.setWindowTitle(title);
                } else if (this.Xy != null) {
                    this.Xy.setText(title);
                }
            }
            gH();
            this.YM = true;
            PanelFeatureState bj = bj(0);
            if (this.mIsDestroyed) {
                return;
            }
            if (bj == null || bj.kE == null) {
                invalidatePanelMenu(108);
            }
        }
    }

    private ViewGroup gG() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        Context context;
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(a.C0040a.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(111)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(120, false)) {
            requestWindowFeature(1);
        } else if (obtainStyledAttributes.getBoolean(111, false)) {
            requestWindowFeature(108);
        }
        if (obtainStyledAttributes.getBoolean(112, false)) {
            requestWindowFeature(109);
        }
        if (obtainStyledAttributes.getBoolean(113, false)) {
            requestWindowFeature(10);
        }
        this.YU = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        this.WZ.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (this.YV) {
            if (this.YT) {
                viewGroup = (ViewGroup) from.inflate(R.layout.b3, (ViewGroup) null);
            } else {
                viewGroup = (ViewGroup) from.inflate(R.layout.b2, (ViewGroup) null);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                u.a(viewGroup, new p() {
                    /* class android.support.v7.app.AppCompatDelegateImpl.AnonymousClass3 */

                    @Override // android.support.v4.view.p
                    public final ac a(View view, ac acVar) {
                        int systemWindowInsetTop = acVar.getSystemWindowInsetTop();
                        int bl = AppCompatDelegateImpl.this.bl(systemWindowInsetTop);
                        if (systemWindowInsetTop != bl) {
                            acVar = acVar.f(acVar.getSystemWindowInsetLeft(), bl, acVar.getSystemWindowInsetRight(), acVar.getSystemWindowInsetBottom());
                        }
                        return u.a(view, acVar);
                    }
                });
                viewGroup2 = viewGroup;
            } else {
                ((aa) viewGroup).setOnFitSystemWindowsListener(new aa.a() {
                    /* class android.support.v7.app.AppCompatDelegateImpl.AnonymousClass4 */

                    @Override // android.support.v7.widget.aa.a
                    public final void f(Rect rect) {
                        rect.top = AppCompatDelegateImpl.this.bl(rect.top);
                    }
                });
                viewGroup2 = viewGroup;
            }
        } else if (this.YU) {
            this.YS = false;
            this.YR = false;
            viewGroup2 = (ViewGroup) from.inflate(R.layout.at, (ViewGroup) null);
        } else if (this.YR) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.a5, typedValue, true);
            if (typedValue.resourceId != 0) {
                context = new android.support.v7.view.d(this.mContext, typedValue.resourceId);
            } else {
                context = this.mContext;
            }
            ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.b4, (ViewGroup) null);
            this.YD = (t) viewGroup3.findViewById(R.id.bl6);
            this.YD.setWindowCallback(this.WZ.getCallback());
            if (this.YS) {
                this.YD.bw(109);
            }
            if (this.YP) {
                this.YD.bw(2);
            }
            if (this.YQ) {
                this.YD.bw(5);
            }
            viewGroup2 = viewGroup3;
        } else {
            viewGroup2 = null;
        }
        if (viewGroup2 == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.YR + ", windowActionBarOverlay: " + this.YS + ", android:windowIsFloating: " + this.YU + ", windowActionModeOverlay: " + this.YT + ", windowNoTitle: " + this.YV + " }");
        }
        if (this.YD == null) {
            this.Xy = (TextView) viewGroup2.findViewById(R.id.ipm);
        }
        bh.bS(viewGroup2);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup2.findViewById(R.id.c8);
        ViewGroup viewGroup4 = (ViewGroup) this.WZ.findViewById(16908290);
        if (viewGroup4 != null) {
            while (viewGroup4.getChildCount() > 0) {
                View childAt = viewGroup4.getChildAt(0);
                viewGroup4.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup4.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup4 instanceof FrameLayout) {
                ((FrameLayout) viewGroup4).setForeground(null);
            }
        }
        this.WZ.setContentView(viewGroup2);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.a() {
            /* class android.support.v7.app.AppCompatDelegateImpl.AnonymousClass5 */

            @Override // android.support.v7.widget.ContentFrameLayout.a
            public final void onDetachedFromWindow() {
                AppCompatDelegateImpl.this.gM();
            }
        });
        return viewGroup2;
    }

    private void gH() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.YN.findViewById(16908290);
        View decorView = this.WZ.getDecorView();
        contentFrameLayout.j(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(a.C0040a.AppCompatTheme);
        obtainStyledAttributes.getValue(118, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(119, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(116)) {
            obtainStyledAttributes.getValue(116, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(117)) {
            obtainStyledAttributes.getValue(117, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(114)) {
            obtainStyledAttributes.getValue(114, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(115)) {
            obtainStyledAttributes.getValue(115, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    @Override // android.support.v7.app.d
    public final boolean requestWindowFeature(int i2) {
        int bm = bm(i2);
        if (this.YV && bm == 108) {
            return false;
        }
        if (this.YR && bm == 1) {
            this.YR = false;
        }
        switch (bm) {
            case 1:
                gL();
                this.YV = true;
                return true;
            case 2:
                gL();
                this.YP = true;
                return true;
            case 5:
                gL();
                this.YQ = true;
                return true;
            case 10:
                gL();
                this.YT = true;
                return true;
            case 108:
                gL();
                this.YR = true;
                return true;
            case 109:
                gL();
                this.YS = true;
                return true;
            default:
                return this.WZ.requestFeature(bm);
        }
    }

    @Override // android.support.v7.app.d
    public final void setTitle(CharSequence charSequence) {
        this.Hn = charSequence;
        if (this.YD != null) {
            this.YD.setWindowTitle(charSequence);
        } else if (this.mActionBar != null) {
            this.mActionBar.setWindowTitle(charSequence);
        } else if (this.Xy != null) {
            this.Xy.setText(charSequence);
        }
    }

    private CharSequence getTitle() {
        if (this.Yz instanceof Activity) {
            return ((Activity) this.Yz).getTitle();
        }
        return this.Hn;
    }

    /* access modifiers changed from: package-private */
    public final void bi(int i2) {
        if (i2 == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.R(false);
            }
        } else if (i2 == 0) {
            PanelFeatureState bj = bj(i2);
            if (bj.VC) {
                a(bj, false);
            }
        }
    }

    @Override // android.support.v7.view.menu.h.a
    public final void b(h hVar) {
        if (this.YD == null || !this.YD.iB() || (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() && !this.YD.iC())) {
            PanelFeatureState bj = bj(0);
            bj.ZD = true;
            a(bj, false);
            a(bj, (KeyEvent) null);
            return;
        }
        Window.Callback callback = this.WZ.getCallback();
        if (this.YD.isOverflowMenuShowing()) {
            this.YD.hideOverflowMenu();
            if (!this.mIsDestroyed) {
                callback.onPanelClosed(108, bj(0).kE);
            }
        } else if (callback != null && !this.mIsDestroyed) {
            if (this.Zd && (this.Ze & 1) != 0) {
                this.WZ.getDecorView().removeCallbacks(this.Zf);
                this.Zf.run();
            }
            PanelFeatureState bj2 = bj(0);
            if (bj2.kE != null && !bj2.ZE && callback.onPreparePanel(0, bj2.Zx, bj2.kE)) {
                callback.onMenuOpened(108, bj2.kE);
                this.YD.showOverflowMenu();
            }
        }
    }

    @Override // android.support.v7.app.d
    public final android.support.v7.view.b startSupportActionMode(b.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.YG != null) {
            this.YG.finish();
        }
        c cVar = new c(aVar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            this.YG = supportActionBar.a(cVar);
            if (!(this.YG == null || this.YB == null)) {
                this.YB.onSupportActionModeStarted(this.YG);
            }
        }
        if (this.YG == null) {
            this.YG = b(cVar);
        }
        return this.YG;
    }

    @Override // android.support.v7.app.d
    public final void invalidateOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.gy()) {
            invalidatePanelMenu(0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.support.v7.view.b b(android.support.v7.view.b.a r9) {
        /*
        // Method dump skipped, instructions count: 379
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImpl.b(android.support.v7.view.b$a):android.support.v7.view.b");
    }

    /* access modifiers changed from: package-private */
    public final boolean gI() {
        return this.YM && this.YN != null && u.az(this.YN);
    }

    /* access modifiers changed from: package-private */
    public final void gJ() {
        if (this.YK != null) {
            this.YK.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i2, keyEvent)) {
            return true;
        }
        if (this.YY == null || !a(this.YY, keyEvent.getKeyCode(), keyEvent)) {
            if (this.YY == null) {
                PanelFeatureState bj = bj(0);
                b(bj, keyEvent);
                boolean a2 = a(bj, keyEvent.getKeyCode(), keyEvent);
                bj.ZA = false;
                if (a2) {
                    return true;
                }
            }
            return false;
        } else if (this.YY == null) {
            return true;
        } else {
            this.YY.ZB = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        AudioManager audioManager;
        View decorView;
        if (((this.Yz instanceof e.a) || (this.Yz instanceof e)) && (decorView = this.WZ.getDecorView()) != null && android.support.v4.view.e.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.Yz.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            switch (keyCode) {
                case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                    if (keyEvent.getRepeatCount() != 0) {
                        return true;
                    }
                    PanelFeatureState bj = bj(0);
                    if (bj.VC) {
                        return true;
                    }
                    b(bj, keyEvent);
                    return true;
                case 4:
                    this.YZ = (keyEvent.getFlags() & 128) != 0;
                    break;
            }
            return false;
        }
        switch (keyCode) {
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                if (this.YG != null) {
                    return true;
                }
                PanelFeatureState bj2 = bj(0);
                if (this.YD == null || !this.YD.iB() || ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) {
                    if (bj2.VC || bj2.ZB) {
                        z3 = bj2.VC;
                        a(bj2, true);
                    } else {
                        if (bj2.ZA) {
                            if (bj2.ZE) {
                                bj2.ZA = false;
                                z4 = b(bj2, keyEvent);
                            } else {
                                z4 = true;
                            }
                            if (z4) {
                                a(bj2, keyEvent);
                                z3 = true;
                            }
                        }
                        z3 = false;
                    }
                } else if (!this.YD.isOverflowMenuShowing()) {
                    if (!this.mIsDestroyed && b(bj2, keyEvent)) {
                        z3 = this.YD.showOverflowMenu();
                    }
                    z3 = false;
                } else {
                    z3 = this.YD.hideOverflowMenu();
                }
                if (!z3 || (audioManager = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) == null) {
                    return true;
                }
                audioManager.playSoundEffect(0);
                return true;
            case 4:
                boolean z5 = this.YZ;
                this.YZ = false;
                PanelFeatureState bj3 = bj(0);
                if (bj3 == null || !bj3.VC) {
                    if (this.YG != null) {
                        this.YG.finish();
                        z2 = true;
                    } else {
                        ActionBar supportActionBar = getSupportActionBar();
                        if (supportActionBar == null || !supportActionBar.collapseActionView()) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        return true;
                    }
                } else if (z5) {
                    return true;
                } else {
                    a(bj3, true);
                    return true;
                }
                break;
        }
        return false;
    }

    private View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean a2;
        if (this.Zj == null) {
            String string = this.mContext.obtainStyledAttributes(a.C0040a.AppCompatTheme).getString(110);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.Zj = new AppCompatViewInflater();
            } else {
                try {
                    this.Zj = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    new StringBuilder("Failed to instantiate custom view inflater ").append(string).append(". Falling back to default.");
                    this.Zj = new AppCompatViewInflater();
                }
            }
        }
        if (Yw) {
            if (!(attributeSet instanceof XmlPullParser)) {
                a2 = a((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                a2 = true;
            } else {
                a2 = false;
            }
            z = a2;
        } else {
            z = false;
        }
        return this.Zj.createView(view, str, context, attributeSet, z, Yw, true, be.nk());
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.WZ.getDecorView();
        for (ViewParent viewParent2 = viewParent; viewParent2 != null; viewParent2 = viewParent2.getParent()) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || u.aD((View) viewParent2)) {
                return false;
            }
        }
        return true;
    }

    @Override // android.support.v7.app.d
    public final void gB() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            android.support.v4.view.f.b(from, this);
        } else {
            from.getFactory2();
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        int i2 = -1;
        if (!panelFeatureState.VC && !this.mIsDestroyed) {
            if (panelFeatureState.Zu == 0) {
                if ((this.mContext.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback callback = this.WZ.getCallback();
            if (callback == null || callback.onMenuOpened(panelFeatureState.Zu, panelFeatureState.kE)) {
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                if (windowManager != null && b(panelFeatureState, keyEvent)) {
                    if (panelFeatureState.Zv == null || panelFeatureState.ZD) {
                        if (panelFeatureState.Zv == null) {
                            a(panelFeatureState);
                            if (panelFeatureState.Zv == null) {
                                return;
                            }
                        } else if (panelFeatureState.ZD && panelFeatureState.Zv.getChildCount() > 0) {
                            panelFeatureState.Zv.removeAllViews();
                        }
                        if (c(panelFeatureState) && panelFeatureState.gQ()) {
                            ViewGroup.LayoutParams layoutParams3 = panelFeatureState.Zw.getLayoutParams();
                            if (layoutParams3 == null) {
                                layoutParams = new ViewGroup.LayoutParams(-2, -2);
                            } else {
                                layoutParams = layoutParams3;
                            }
                            panelFeatureState.Zv.setBackgroundResource(panelFeatureState.background);
                            ViewParent parent = panelFeatureState.Zw.getParent();
                            if (parent != null && (parent instanceof ViewGroup)) {
                                ((ViewGroup) parent).removeView(panelFeatureState.Zw);
                            }
                            panelFeatureState.Zv.addView(panelFeatureState.Zw, layoutParams);
                            if (!panelFeatureState.Zw.hasFocus()) {
                                panelFeatureState.Zw.requestFocus();
                            }
                            i2 = -2;
                        } else {
                            return;
                        }
                    } else if (panelFeatureState.Zx == null || (layoutParams2 = panelFeatureState.Zx.getLayoutParams()) == null || layoutParams2.width != -1) {
                        i2 = -2;
                    }
                    panelFeatureState.ZB = false;
                    WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.x, panelFeatureState.y, 1002, 8519680, -3);
                    layoutParams4.gravity = panelFeatureState.gravity;
                    layoutParams4.windowAnimations = panelFeatureState.windowAnimations;
                    windowManager.addView(panelFeatureState.Zv, layoutParams4);
                    panelFeatureState.VC = true;
                    return;
                }
                return;
            }
            a(panelFeatureState, true);
        }
    }

    private boolean a(PanelFeatureState panelFeatureState) {
        panelFeatureState.Z(gE());
        panelFeatureState.Zv = new f(panelFeatureState.Zz);
        panelFeatureState.gravity = 81;
        return true;
    }

    private boolean b(PanelFeatureState panelFeatureState) {
        Context context;
        Context context2 = this.mContext;
        if ((panelFeatureState.Zu == 0 || panelFeatureState.Zu == 108) && this.YD != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context2.getTheme();
            theme.resolveAttribute(R.attr.a5, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context2.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R.attr.a6, typedValue, true);
            } else {
                theme.resolveAttribute(R.attr.a6, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context2.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                context = new android.support.v7.view.d(context2, 0);
                context.getTheme().setTo(theme2);
                h hVar = new h(context);
                hVar.a(this);
                panelFeatureState.e(hVar);
                return true;
            }
        }
        context = context2;
        h hVar2 = new h(context);
        hVar2.a(this);
        panelFeatureState.e(hVar2);
        return true;
    }

    private boolean c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.Zx != null) {
            panelFeatureState.Zw = panelFeatureState.Zx;
            return true;
        } else if (panelFeatureState.kE == null) {
            return false;
        } else {
            if (this.YF == null) {
                this.YF = new g();
            }
            panelFeatureState.Zw = (View) panelFeatureState.b(this.YF);
            return panelFeatureState.Zw != null;
        }
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        boolean z;
        if (this.mIsDestroyed) {
            return false;
        }
        if (panelFeatureState.ZA) {
            return true;
        }
        if (!(this.YY == null || this.YY == panelFeatureState)) {
            a(this.YY, false);
        }
        Window.Callback callback = this.WZ.getCallback();
        if (callback != null) {
            panelFeatureState.Zx = callback.onCreatePanelView(panelFeatureState.Zu);
        }
        boolean z2 = panelFeatureState.Zu == 0 || panelFeatureState.Zu == 108;
        if (z2 && this.YD != null) {
            this.YD.iD();
        }
        if (panelFeatureState.Zx == null && (!z2 || !(this.mActionBar instanceof g))) {
            if (panelFeatureState.kE == null || panelFeatureState.ZE) {
                if (panelFeatureState.kE == null) {
                    b(panelFeatureState);
                    if (panelFeatureState.kE == null) {
                        return false;
                    }
                }
                if (z2 && this.YD != null) {
                    if (this.YE == null) {
                        this.YE = new b();
                    }
                    this.YD.a(panelFeatureState.kE, this.YE);
                }
                panelFeatureState.kE.ia();
                if (!callback.onCreatePanelMenu(panelFeatureState.Zu, panelFeatureState.kE)) {
                    panelFeatureState.e(null);
                    if (!z2 || this.YD == null) {
                        return false;
                    }
                    this.YD.a(null, this.YE);
                    return false;
                }
                panelFeatureState.ZE = false;
            }
            panelFeatureState.kE.ia();
            if (panelFeatureState.ZF != null) {
                panelFeatureState.kE.g(panelFeatureState.ZF);
                panelFeatureState.ZF = null;
            }
            if (!callback.onPreparePanel(0, panelFeatureState.Zx, panelFeatureState.kE)) {
                if (z2 && this.YD != null) {
                    this.YD.a(null, this.YE);
                }
                panelFeatureState.kE.ib();
                return false;
            }
            if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                z = true;
            } else {
                z = false;
            }
            panelFeatureState.ZC = z;
            panelFeatureState.kE.setQwertyMode(panelFeatureState.ZC);
            panelFeatureState.kE.ib();
        }
        panelFeatureState.ZA = true;
        panelFeatureState.ZB = false;
        this.YY = panelFeatureState;
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void c(h hVar) {
        if (!this.YW) {
            this.YW = true;
            this.YD.gM();
            Window.Callback callback = this.WZ.getCallback();
            if (callback != null && !this.mIsDestroyed) {
                callback.onPanelClosed(108, hVar);
            }
            this.YW = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void gK() {
        a(bj(0), true);
    }

    /* access modifiers changed from: package-private */
    public final void a(PanelFeatureState panelFeatureState, boolean z) {
        if (!z || panelFeatureState.Zu != 0 || this.YD == null || !this.YD.isOverflowMenuShowing()) {
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.VC || panelFeatureState.Zv == null)) {
                windowManager.removeView(panelFeatureState.Zv);
                if (z) {
                    a(panelFeatureState.Zu, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.ZA = false;
            panelFeatureState.ZB = false;
            panelFeatureState.VC = false;
            panelFeatureState.Zw = null;
            panelFeatureState.ZD = true;
            if (this.YY == panelFeatureState) {
                this.YY = null;
                return;
            }
            return;
        }
        c(panelFeatureState.kE);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i2 >= 0 && i2 < this.YX.length) {
                panelFeatureState = this.YX[i2];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.kE;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.VC) && !this.mIsDestroyed) {
            this.Yz.onPanelClosed(i2, menu);
        }
    }

    /* access modifiers changed from: package-private */
    public final PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.YX;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
            if (panelFeatureState != null && panelFeatureState.kE == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final PanelFeatureState bj(int i2) {
        PanelFeatureState[] panelFeatureStateArr = this.YX;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i2) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i2 + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.YX = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i2);
        panelFeatureStateArr[i2] = panelFeatureState2;
        return panelFeatureState2;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i2, KeyEvent keyEvent) {
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.ZA || b(panelFeatureState, keyEvent)) && panelFeatureState.kE != null) {
            return panelFeatureState.kE.performShortcut(i2, keyEvent, 1);
        }
        return false;
    }

    private void invalidatePanelMenu(int i2) {
        this.Ze |= 1 << i2;
        if (!this.Zd) {
            u.b(this.WZ.getDecorView(), this.Zf);
            this.Zd = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void bk(int i2) {
        PanelFeatureState bj;
        PanelFeatureState bj2 = bj(i2);
        if (bj2.kE != null) {
            Bundle bundle = new Bundle();
            bj2.kE.f(bundle);
            if (bundle.size() > 0) {
                bj2.ZF = bundle;
            }
            bj2.kE.ia();
            bj2.kE.clear();
        }
        bj2.ZE = true;
        bj2.ZD = true;
        if ((i2 == 108 || i2 == 0) && this.YD != null && (bj = bj(0)) != null) {
            bj.ZA = false;
            b(bj, null);
        }
    }

    /* access modifiers changed from: package-private */
    public final int bl(int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        int i3 = 0;
        if (this.YH == null || !(this.YH.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.YH.getLayoutParams();
            if (this.YH.isShown()) {
                if (this.Zh == null) {
                    this.Zh = new Rect();
                    this.Zi = new Rect();
                }
                Rect rect = this.Zh;
                Rect rect2 = this.Zi;
                rect.set(0, i2, 0, 0);
                bh.a(this.YN, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i2 : 0)) {
                    marginLayoutParams.topMargin = i2;
                    if (this.YO == null) {
                        this.YO = new View(this.mContext);
                        this.YO.setBackgroundColor(this.mContext.getResources().getColor(R.color.az));
                        this.YN.addView(this.YO, -1, new ViewGroup.LayoutParams(-1, i2));
                        z2 = true;
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.YO.getLayoutParams();
                        if (layoutParams.height != i2) {
                            layoutParams.height = i2;
                            this.YO.setLayoutParams(layoutParams);
                        }
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
                if (this.YO == null) {
                    z4 = false;
                }
                if (!this.YT && z4) {
                    i2 = 0;
                }
                z3 = z4;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = true;
                z3 = false;
            } else {
                z2 = false;
                z3 = false;
            }
            if (z2) {
                this.YH.setLayoutParams(marginLayoutParams);
            }
            z = z3;
        }
        if (this.YO != null) {
            View view = this.YO;
            if (!z) {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
        return i2;
    }

    private void gL() {
        if (this.YM) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private static int bm(int i2) {
        if (i2 == 8) {
            return 108;
        }
        if (i2 == 9) {
            return 109;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final void gM() {
        if (this.YD != null) {
            this.YD.gM();
        }
        if (this.YI != null) {
            this.WZ.getDecorView().removeCallbacks(this.YJ);
            if (this.YI.isShowing()) {
                try {
                    this.YI.dismiss();
                } catch (IllegalArgumentException e2) {
                }
            }
            this.YI = null;
        }
        gJ();
        PanelFeatureState bj = bj(0);
        if (bj != null && bj.kE != null) {
            bj.kE.close();
        }
    }

    @Override // android.support.v7.app.d
    public final boolean gC() {
        boolean z = false;
        int nightMode = getNightMode();
        int bn = bn(nightMode);
        if (bn != -1) {
            z = bo(bn);
        }
        if (nightMode == 0) {
            gN();
            this.Zc.setup();
        }
        this.Zb = true;
        return z;
    }

    private int bn(int i2) {
        switch (i2) {
            case -100:
                return -1;
            case 0:
                if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) this.mContext.getSystemService(UiModeManager.class)).getNightMode() == 0) {
                    return -1;
                }
                gN();
                return this.Zc.gP();
            default:
                return i2;
        }
    }

    private int getNightMode() {
        return this.Za != -100 ? this.Za : d.Yv;
    }

    private boolean bo(int i2) {
        Resources resources = this.mContext.getResources();
        Configuration configuration = resources.getConfiguration();
        int i3 = configuration.uiMode & 48;
        int i4 = i2 == 2 ? 32 : 16;
        if (i3 == i4) {
            return false;
        }
        if (gO()) {
            ((Activity) this.mContext).recreate();
        } else {
            Configuration configuration2 = new Configuration(configuration);
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration2.uiMode = i4 | (configuration2.uiMode & -49);
            resources.updateConfiguration(configuration2, displayMetrics);
            if (Build.VERSION.SDK_INT < 26) {
                f.a(resources);
            }
        }
        return true;
    }

    private void gN() {
        if (this.Zc == null) {
            this.Zc = new e(i.aa(this.mContext));
        }
    }

    private boolean gO() {
        if (!this.Zb || !(this.mContext instanceof Activity)) {
            return false;
        }
        try {
            return (this.mContext.getPackageManager().getActivityInfo(new ComponentName(this.mContext, this.mContext.getClass()), 0).configChanges & 512) == 0;
        } catch (PackageManager.NameNotFoundException e2) {
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements b.a {
        private b.a Zn;

        public c(b.a aVar) {
            this.Zn = aVar;
        }

        @Override // android.support.v7.view.b.a
        public final boolean a(android.support.v7.view.b bVar, Menu menu) {
            return this.Zn.a(bVar, menu);
        }

        @Override // android.support.v7.view.b.a
        public final boolean b(android.support.v7.view.b bVar, Menu menu) {
            return this.Zn.b(bVar, menu);
        }

        @Override // android.support.v7.view.b.a
        public final boolean a(android.support.v7.view.b bVar, MenuItem menuItem) {
            return this.Zn.a(bVar, menuItem);
        }

        @Override // android.support.v7.view.b.a
        public final void a(android.support.v7.view.b bVar) {
            this.Zn.a(bVar);
            if (AppCompatDelegateImpl.this.YI != null) {
                AppCompatDelegateImpl.this.WZ.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.YJ);
            }
            if (AppCompatDelegateImpl.this.YH != null) {
                AppCompatDelegateImpl.this.gJ();
                AppCompatDelegateImpl.this.YK = u.ah(AppCompatDelegateImpl.this.YH).y(0.0f);
                AppCompatDelegateImpl.this.YK.a(new android.support.v4.view.aa() {
                    /* class android.support.v7.app.AppCompatDelegateImpl.c.AnonymousClass1 */

                    @Override // android.support.v4.view.aa, android.support.v4.view.z
                    public final void aJ(View view) {
                        AppCompatDelegateImpl.this.YH.setVisibility(8);
                        if (AppCompatDelegateImpl.this.YI != null) {
                            AppCompatDelegateImpl.this.YI.dismiss();
                        } else if (AppCompatDelegateImpl.this.YH.getParent() instanceof View) {
                            u.ap((View) AppCompatDelegateImpl.this.YH.getParent());
                        }
                        AppCompatDelegateImpl.this.YH.removeAllViews();
                        AppCompatDelegateImpl.this.YK.a((z) null);
                        AppCompatDelegateImpl.this.YK = null;
                    }
                });
            }
            if (AppCompatDelegateImpl.this.YB != null) {
                AppCompatDelegateImpl.this.YB.onSupportActionModeFinished(AppCompatDelegateImpl.this.YG);
            }
            AppCompatDelegateImpl.this.YG = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final class g implements o.a {
        g() {
        }

        @Override // android.support.v7.view.menu.o.a
        public final void a(h hVar, boolean z) {
            h ii = hVar.ii();
            boolean z2 = ii != hVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                hVar = ii;
            }
            PanelFeatureState a2 = appCompatDelegateImpl.a(hVar);
            if (a2 == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImpl.this.a(a2.Zu, a2, ii);
                AppCompatDelegateImpl.this.a(a2, true);
                return;
            }
            AppCompatDelegateImpl.this.a(a2, z);
        }

        @Override // android.support.v7.view.menu.o.a
        public final boolean d(h hVar) {
            Window.Callback callback;
            if (hVar != null || !AppCompatDelegateImpl.this.YR || (callback = AppCompatDelegateImpl.this.WZ.getCallback()) == null || AppCompatDelegateImpl.this.mIsDestroyed) {
                return true;
            }
            callback.onMenuOpened(108, hVar);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final class b implements o.a {
        b() {
        }

        @Override // android.support.v7.view.menu.o.a
        public final boolean d(h hVar) {
            Window.Callback callback = AppCompatDelegateImpl.this.WZ.getCallback();
            if (callback == null) {
                return true;
            }
            callback.onMenuOpened(108, hVar);
            return true;
        }

        @Override // android.support.v7.view.menu.o.a
        public final void a(h hVar, boolean z) {
            AppCompatDelegateImpl.this.c(hVar);
        }
    }

    /* access modifiers changed from: protected */
    public static final class PanelFeatureState {
        boolean VC;
        boolean ZA;
        boolean ZB;
        public boolean ZC;
        boolean ZD = false;
        boolean ZE;
        Bundle ZF;
        int Zu;
        ViewGroup Zv;
        View Zw;
        View Zx;
        android.support.v7.view.menu.f Zy;
        Context Zz;
        int background;
        int gravity;
        h kE;
        int windowAnimations;
        int x;
        int y;

        PanelFeatureState(int i2) {
            this.Zu = i2;
        }

        public final boolean gQ() {
            if (this.Zw == null) {
                return false;
            }
            if (this.Zx != null) {
                return true;
            }
            return this.Zy.getAdapter().getCount() > 0;
        }

        /* access modifiers changed from: package-private */
        public final void Z(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.y, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(R.attr.wm, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(R.style.xp, true);
            }
            android.support.v7.view.d dVar = new android.support.v7.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.Zz = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(a.C0040a.AppCompatTheme);
            this.background = obtainStyledAttributes.getResourceId(80, 0);
            this.windowAnimations = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public final void e(h hVar) {
            if (hVar != this.kE) {
                if (this.kE != null) {
                    this.kE.b(this.Zy);
                }
                this.kE = hVar;
                if (hVar != null && this.Zy != null) {
                    hVar.a(this.Zy);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final android.support.v7.view.menu.p b(o.a aVar) {
            if (this.kE == null) {
                return null;
            }
            if (this.Zy == null) {
                this.Zy = new android.support.v7.view.menu.f(this.Zz);
                this.Zy.afg = aVar;
                this.kE.a(this.Zy);
            }
            return this.Zy.c(this.Zv);
        }

        static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
                /* class android.support.v7.app.AppCompatDelegateImpl.PanelFeatureState.SavedState.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public final /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.b(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                    return new SavedState[i2];
                }

                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return SavedState.b(parcel, null);
                }
            };
            boolean VC;
            int Zu;
            Bundle tl;

            SavedState() {
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.Zu);
                parcel.writeInt(this.VC ? 1 : 0);
                if (this.VC) {
                    parcel.writeBundle(this.tl);
                }
            }

            static SavedState b(Parcel parcel, ClassLoader classLoader) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.Zu = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.VC = z;
                if (savedState.VC) {
                    savedState.tl = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class f extends ContentFrameLayout {
        public f(Context context) {
            super(context);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            boolean z;
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    AppCompatDelegateImpl.this.gK();
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public final void setBackgroundResource(int i2) {
            setBackgroundDrawable(android.support.v7.c.a.a.l(getContext(), i2));
        }
    }

    class d extends i {
        d(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.i
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.support.v7.view.i
        public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.support.v7.view.i
        public final boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof h)) {
                return super.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        @Override // android.support.v7.view.i
        public final void onContentChanged() {
        }

        @Override // android.support.v7.view.i
        public final boolean onPreparePanel(int i2, View view, Menu menu) {
            h hVar;
            if (menu instanceof h) {
                hVar = (h) menu;
            } else {
                hVar = null;
            }
            if (i2 == 0 && hVar == null) {
                return false;
            }
            if (hVar != null) {
                hVar.agK = true;
            }
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (hVar == null) {
                return onPreparePanel;
            }
            hVar.agK = false;
            return onPreparePanel;
        }

        @Override // android.support.v7.view.i
        public final boolean onMenuOpened(int i2, Menu menu) {
            ActionBar supportActionBar;
            super.onMenuOpened(i2, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (i2 == 108 && (supportActionBar = appCompatDelegateImpl.getSupportActionBar()) != null) {
                supportActionBar.R(true);
            }
            return true;
        }

        @Override // android.support.v7.view.i
        public final void onPanelClosed(int i2, Menu menu) {
            super.onPanelClosed(i2, menu);
            AppCompatDelegateImpl.this.bi(i2);
        }

        @Override // android.support.v7.view.i
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.YL) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        private ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.mContext, callback);
            android.support.v7.view.b startSupportActionMode = AppCompatDelegateImpl.this.startSupportActionMode(aVar);
            if (startSupportActionMode != null) {
                return aVar.b(startSupportActionMode);
            }
            return null;
        }

        @Override // android.support.v7.view.i
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            if (AppCompatDelegateImpl.this.YL) {
                switch (i2) {
                    case 0:
                        return a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i2);
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            PanelFeatureState bj = AppCompatDelegateImpl.this.bj(0);
            if (bj == null || bj.kE == null) {
                super.onProvideKeyboardShortcuts(list, menu, i2);
            } else {
                super.onProvideKeyboardShortcuts(list, bj.kE, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final class e {
        i Zp;
        boolean Zq;
        private BroadcastReceiver Zr;
        private IntentFilter Zs;

        e(i iVar) {
            this.Zp = iVar;
            this.Zq = iVar.gT();
        }

        /* access modifiers changed from: package-private */
        public final int gP() {
            this.Zq = this.Zp.gT();
            return this.Zq ? 2 : 1;
        }

        /* access modifiers changed from: package-private */
        public final void setup() {
            cleanup();
            if (this.Zr == null) {
                this.Zr = new BroadcastReceiver() {
                    /* class android.support.v7.app.AppCompatDelegateImpl.e.AnonymousClass1 */

                    public final void onReceive(Context context, Intent intent) {
                        e eVar = e.this;
                        boolean gT = eVar.Zp.gT();
                        if (gT != eVar.Zq) {
                            eVar.Zq = gT;
                            AppCompatDelegateImpl.this.gC();
                        }
                    }
                };
            }
            if (this.Zs == null) {
                this.Zs = new IntentFilter();
                this.Zs.addAction("android.intent.action.TIME_SET");
                this.Zs.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.Zs.addAction("android.intent.action.TIME_TICK");
            }
            AppCompatDelegateImpl.this.mContext.registerReceiver(this.Zr, this.Zs);
        }

        /* access modifiers changed from: package-private */
        public final void cleanup() {
            if (this.Zr != null) {
                AppCompatDelegateImpl.this.mContext.unregisterReceiver(this.Zr);
                this.Zr = null;
            }
        }
    }

    @Override // android.support.v7.app.d
    public final a.AbstractC0041a getDrawerToggleDelegate() {
        return new a();
    }

    class a implements a.AbstractC0041a {
        a() {
        }

        @Override // android.support.v7.app.a.AbstractC0041a
        public final void bh(int i2) {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i2);
            }
        }
    }

    @Override // android.support.v7.view.menu.h.a
    public final boolean a(h hVar, MenuItem menuItem) {
        PanelFeatureState a2;
        Window.Callback callback = this.WZ.getCallback();
        if (callback == null || this.mIsDestroyed || (a2 = a(hVar.ii())) == null) {
            return false;
        }
        return callback.onMenuItemSelected(a2.Zu, menuItem);
    }
}
