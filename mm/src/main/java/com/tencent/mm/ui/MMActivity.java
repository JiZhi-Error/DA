package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.widget.AlbumChooserView;
import com.tencent.mm.ui.widget.a.c;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;

@com.tencent.mm.ui.base.a(0)
public abstract class MMActivity extends MMFragmentActivity implements ad, h.c, c {
    private static final int ANDROID_API_LEVEL_11 = 11;
    protected static final int DEFAULT_TOAST_TIME = 3000;
    public static final String FLAG_OVERRIDE_ENTER_ANIMATION = "MMActivity.OverrideEnterAnimation";
    public static final String FLAG_OVERRIDE_EXIT_ANIMATION = "MMActivity.OverrideExitAnimation";
    private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
    private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
    private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
    private static final String TAG = "MicroMsg.MMActivity";
    private static final String TAG2 = "MicroMsg.INIT";
    private static String sNavBarOverride;
    private byte _hellAccFlag_;
    String className;
    boolean customfixStatusbar = false;
    boolean fixStatusbar = false;
    protected boolean landscapeMode = false;
    private long lastBrowseTime = 0;
    private long lastOnPauseTicks = 0;
    private long lastOnResumeTicks = 0;
    public t mController = new t() {
        /* class com.tencent.mm.ui.MMActivity.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final int getLayoutId() {
            AppMethodBeat.i(141317);
            int layoutId = MMActivity.this.getLayoutId();
            if (layoutId == 0) {
                layoutId = MMActivity.this.getLayoutUIC().getLayoutId();
            }
            AppMethodBeat.o(141317);
            return layoutId;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final void dealContentView(View view) {
            AppMethodBeat.i(141318);
            MMActivity.this.dealContentView(view);
            AppMethodBeat.o(141318);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final String getIdentString() {
            AppMethodBeat.i(141319);
            String identString = MMActivity.this.getIdentString();
            AppMethodBeat.o(141319);
            return identString;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final View getLayoutView() {
            AppMethodBeat.i(141320);
            View layoutView = MMActivity.this.getLayoutView();
            AppMethodBeat.o(141320);
            return layoutView;
        }

        @Override // com.tencent.mm.ui.t
        public final void onKeyboardStateChanged() {
            AppMethodBeat.i(141321);
            MMActivity.this.onKeyboardStateChanged();
            AppMethodBeat.o(141321);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final void onCreateBeforeSetContentView() {
            AppMethodBeat.i(141322);
            MMActivity.this.onCreateBeforeSetContentView();
            AppMethodBeat.o(141322);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final String getClassName() {
            AppMethodBeat.i(141323);
            String name = MMActivity.this.getClass().getName();
            AppMethodBeat.o(141323);
            return name;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final boolean fromFullScreenActivity() {
            AppMethodBeat.i(141324);
            boolean fromFullScreenActivity = MMActivity.this.fromFullScreenActivity();
            AppMethodBeat.o(141324);
            return fromFullScreenActivity;
        }

        @Override // com.tencent.mm.ui.t
        public final boolean noActionBar() {
            AppMethodBeat.i(141325);
            boolean noActionBar = MMActivity.this.noActionBar();
            AppMethodBeat.o(141325);
            return noActionBar;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final boolean needResetStatusBarColorOnActivityCreate() {
            AppMethodBeat.i(141326);
            boolean needResetStatusBarColorOnActivityCreate = MMActivity.this.needResetStatusBarColorOnActivityCreate();
            AppMethodBeat.o(141326);
            return needResetStatusBarColorOnActivityCreate;
        }

        @Override // com.tencent.mm.ui.t
        public final boolean needShowIdcError() {
            AppMethodBeat.i(141327);
            boolean needShowIdcError = MMActivity.this.needShowIdcError();
            AppMethodBeat.o(141327);
            return needShowIdcError;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final View provideCustomActivityContentView() {
            AppMethodBeat.i(141328);
            View provideCustomActivityContentView = MMActivity.this.provideCustomActivityContentView();
            AppMethodBeat.o(141328);
            return provideCustomActivityContentView;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final boolean isActionbarCenterLayoutMode() {
            AppMethodBeat.i(259377);
            boolean isActionbarCenterLayoutMode = MMActivity.this.isActionbarCenterLayoutMode();
            AppMethodBeat.o(259377);
            return isActionbarCenterLayoutMode;
        }
    };
    private boolean mIsPaused = false;
    private boolean mIsStopped = false;
    private View mSelfNavigationBar;
    private ViewGroup mWrappingFrame = null;
    private a onActResult = null;
    boolean transparentTheme = false;

    public interface a {
        void d(int i2, int i3, Intent intent);
    }

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void initView() {
    }

    public void setBackGroundColorResource(int i2) {
        this.mController.setBackGroundColorResource(i2);
    }

    public t getController() {
        return this.mController;
    }

    public static Locale initLanguage(Context context) {
        return t.initLanguage(context);
    }

    public static Locale initLanguage(Context context, String str) {
        return t.initLanguage(context, str);
    }

    @Deprecated
    public void fixStatusbar(boolean z) {
        this.fixStatusbar = z;
    }

    public void setTransparentTheme(boolean z) {
        this.transparentTheme = z;
    }

    @Deprecated
    public void customfixStatusbar(boolean z) {
        this.customfixStatusbar = z;
    }

    /* access modifiers changed from: protected */
    public void onCreateBeforeSetContentView() {
    }

    /* access modifiers changed from: protected */
    public boolean fromFullScreenActivity() {
        return false;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        if (!this.customfixStatusbar) {
            this.fixStatusbar = true;
        }
        getController().OGy = R.layout.bi;
        super.onCreate(bundle);
        if (isHideStatusBar()) {
            this.fixStatusbar = false;
        }
        this.mController.a(getApplicationContext(), this);
        initNavigationSwipeBack();
        if (!noActionBar()) {
            setActionbarColor(getResources().getColor(R.color.a2r));
            setMMTitleSize(((float) com.tencent.mm.cb.a.aH(this, R.dimen.f3058c)) * com.tencent.mm.cb.a.ji(this));
        }
    }

    /* access modifiers changed from: protected */
    public void dealContentView(View view) {
        setContentView(view);
    }

    /* access modifiers changed from: protected */
    public boolean needResetStatusBarColorOnActivityCreate() {
        return true;
    }

    public boolean noActionBar() {
        return false;
    }

    public int keyboardState() {
        return this.mController.OGC;
    }

    public void onKeyboardStateChanged() {
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        if (Build.VERSION.SDK_INT < 11) {
            super.onSaveInstanceState(bundle);
        }
    }

    public boolean isScreenEnable() {
        return this.mController.OFT;
    }

    public void setScreenEnable(boolean z) {
        this.mController.setScreenEnable(z);
    }

    /* access modifiers changed from: protected */
    public final void setBodyView(int i2) {
        this.mController.setBodyView(i2);
    }

    public View getBodyView() {
        return this.mController.GDE;
    }

    public final View getContentView() {
        return this.mController.contentView;
    }

    public void setContentViewVisibility(int i2) {
        getContentView().setVisibility(i2);
        if (i2 == 0) {
            showTitleView();
        } else {
            hideTitleView();
        }
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public void onSwipeBack() {
        if (!onSwipeBackFinish()) {
            this.mController.callBackMenu();
        }
        super.onSwipeBack();
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.MMFragmentActivity
    public void initSwipeBack() {
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            if (this.fixStatusbar) {
                this.mWrappingFrame = new b(this);
            } else {
                this.mWrappingFrame = new FrameLayout(this);
            }
            this.mWrappingFrame.addView(childAt, new FrameLayout.LayoutParams(-1, -1));
            getSwipeBackLayout().addView(this.mWrappingFrame);
            getSwipeBackLayout().setContentView(this.mWrappingFrame);
        }
    }

    public int getStatusBarHeight(int i2) {
        if (this.mWrappingFrame instanceof b) {
            return ((b) this.mWrappingFrame).getDrawnStatusBarHeight();
        }
        return au.D(this, i2);
    }

    public boolean onSwipeBackFinish() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int getForceOrientation() {
        return -1;
    }

    /* access modifiers changed from: protected */
    public void setMMOrientation() {
        if (getForceOrientation() == -1) {
            this.landscapeMode = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("settings_landscape_mode", false);
            if (this.landscapeMode) {
                setRequestedOrientation(-1);
            } else {
                setRequestedOrientation(1);
            }
        } else {
            setRequestedOrientation(getForceOrientation());
        }
    }

    public boolean isStopped() {
        return this.mIsStopped;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        setMMOrientation();
        this.mIsStopped = false;
        super.onStart();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        this.mIsStopped = true;
        super.onStop();
    }

    public int getStreamVolume(int i2) {
        return this.mController.getStreamVolume(i2);
    }

    public int getStreamMaxVolume(int i2) {
        return this.mController.getStreamMaxVolume(i2);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    @TargetApi(17)
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.mController.onKeyUp(i2, keyEvent)) {
            return true;
        }
        try {
            return super.onKeyUp(i2, keyEvent);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState", new Object[0]);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.mController.onKeyDown(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean needShowIdcError() {
        return true;
    }

    /* access modifiers changed from: protected */
    public View provideCustomActivityContentView() {
        return null;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        am.dl(1, this.className);
        this.mIsPaused = false;
        super.onResume();
        Log.v(TAG2, "KEVIN MMActivity super.onResume " + (System.currentTimeMillis() - currentTimeMillis));
        this.mController.onResume();
        Log.v(TAG2, "KEVIN MMActivity onResume :%dms, hash:#0x%x", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(hashCode()));
        noteOnResumeTicks();
    }

    @Override // com.tencent.mm.ui.base.h.c
    public void addDialog(Dialog dialog) {
        this.mController.addDialog(dialog);
    }

    public boolean isShowDialog() {
        boolean z;
        t tVar = this.mController;
        if (tVar.ogl == null) {
            return false;
        }
        Iterator<Dialog> it = tVar.ogl.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().isShowing()) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        return z;
    }

    @Override // com.tencent.mm.ui.widget.a.c
    public void onDialogDismiss(Dialog dialog) {
    }

    public AppCompatActivity getContext() {
        return this.mController.OGe;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        this.mController.jM(this);
    }

    public void hideAllManagedDialogs() {
        this.mController.hideAllManagedDialogs();
    }

    public void activateBroadcast(boolean z) {
        this.mController.activateBroadcast(z);
    }

    public static void setMainProcess() {
        t.setMainProcess();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        long currentTimeMillis = System.currentTimeMillis();
        am.dl(2, this.className);
        this.mIsPaused = true;
        super.onPause();
        this.mController.onPause();
        Log.v(TAG2, "KEVIN MMActivity onPause: %d ms, isFinishing %B, hash:#0x%x", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(isFinishing()), Integer.valueOf(hashCode()));
        noteOnPauseTicks();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.mController.onCreateOptionsMenu(menu)) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.mController.onPrepareOptionsMenu(menu);
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mController.onOptionsItemSelected(menuItem);
    }

    public boolean callBackMenu() {
        return this.mController.callBackMenu();
    }

    /* access modifiers changed from: protected */
    public String getIdentString() {
        return "";
    }

    /* access modifiers changed from: protected */
    public View getLayoutView() {
        return null;
    }

    @Deprecated
    public void setToTop(View.OnClickListener onClickListener) {
    }

    @Deprecated
    public void setTitleClickAction(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
    }

    @Deprecated
    public void setRedDotVisibilty(int i2) {
    }

    public void fullScreenNoTitleBar(boolean z) {
        this.mController.fullScreenNoTitleBar(z);
    }

    public void fullScreenNoTitleBar(boolean z, long j2) {
        this.mController.fullScreenNoTitleBar(z, j2);
    }

    public void fullScreenWithTitleBar(boolean z) {
        this.mController.fullScreenWithTitleBar(z);
    }

    public void setTitleVisibility(int i2) {
        this.mController.setTitleVisibility(i2);
    }

    public void setMMTitleColor(int i2) {
        t tVar = this.mController;
        if (tVar.mActionBar != null) {
            tVar.OGj.setTextColor(i2);
        }
    }

    public void setMMTitle(String str) {
        this.mController.setMMTitle(str);
    }

    public void setMMTitle(CharSequence charSequence) {
        this.mController.setMMTitle(charSequence);
    }

    /* access modifiers changed from: protected */
    public void updateDescription(String str) {
        this.mController.updateDescription(str);
    }

    public void setMMTitle(int i2) {
        this.mController.setMMTitle(i2);
    }

    public void setProgressIcon(int i2) {
        t tVar = this.mController;
        if (tVar.mActionBar != null) {
            tVar.OGm.setIndeterminateDrawable(tVar.OGe.getDrawable(i2));
        }
    }

    public void setProgressVisibility(int i2) {
        t tVar = this.mController;
        if (tVar.mActionBar != null) {
            tVar.OGm.setVisibility(i2);
        }
    }

    public void setMMTitleSize(float f2) {
        t tVar = this.mController;
        if (tVar.mActionBar != null && tVar.OGj != null) {
            tVar.OGj.setTextSize(0, f2);
        }
    }

    public void setMMSubTitle(String str) {
        this.mController.setMMSubTitle(str);
    }

    public void setMMSubTitle(int i2) {
        this.mController.setMMSubTitle(i2);
    }

    public void setMMTitleVisibility(int i2) {
        this.mController.setMMTitleVisibility(i2);
    }

    public void supportLightStatusBar() {
        t tVar = this.mController;
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = tVar.OGe.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
        }
    }

    public void updataStatusBarIcon(boolean z) {
        this.mController.updataStatusBarIcon(z);
    }

    @Deprecated
    public void setMMSubTitleColor(int i2) {
    }

    public void setTitleLogo(int i2, int i3) {
        this.mController.setTitleLogo(i2, i3);
    }

    public void setTitleDividerVis(boolean z) {
    }

    public void setTitleDividerColor(int i2) {
    }

    public void showHomeBtn(boolean z) {
        this.mController.showHomeBtn(z);
    }

    public void enableBackMenu(boolean z) {
        this.mController.enableBackMenu(z);
    }

    public void enableOptionMenu(boolean z) {
        this.mController.c(true, -1, z);
    }

    public void enableOptionMenu(int i2, boolean z) {
        this.mController.c(false, i2, z);
    }

    public void showOptionMenu(boolean z) {
        this.mController.d(true, -1, z);
    }

    public void showOptionMenu(int i2, boolean z) {
        this.mController.d(false, i2, z);
    }

    public boolean isOptionMenuEnable(int i2) {
        Iterator<t.a> it = this.mController.OxV.iterator();
        while (it.hasNext()) {
            t.a next = it.next();
            if (next.Oye == i2) {
                return next.enable;
            }
        }
        return false;
    }

    public boolean isOptionMenuShow(int i2) {
        Iterator<t.a> it = this.mController.OxV.iterator();
        while (it.hasNext()) {
            t.a next = it.next();
            if (next.Oye == i2) {
                return next.visible;
            }
        }
        return false;
    }

    public void addSearchMenu(boolean z, s sVar) {
        this.mController.addSearchMenu(z, sVar);
    }

    public void removeSearchMenu() {
        t tVar = this.mController;
        t.a aVar = new t.a();
        aVar.Oye = R.id.fdi;
        aVar.text = tVar.mContext.getString(R.string.yn);
        aVar.Oyf = R.raw.actionbar_icon_dark_search;
        aVar.kjh = null;
        aVar.tib = null;
        tVar.removeOptionMenu(aVar.Oye);
        tVar.supportInvalidateOptionsMenu();
    }

    public void addTextOptionMenu(int i2, String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addTextOptionMenu(i2, str, onMenuItemClickListener);
    }

    public void addTextOptionMenu(int i2, String str, int i3, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        t tVar = this.mController;
        t.b bVar = t.b.NORMAL;
        t.a aVar = new t.a();
        aVar.Oye = i2;
        aVar.text = str;
        aVar.textColor = i3;
        aVar.kjh = onMenuItemClickListener;
        aVar.tib = null;
        aVar.OGS = bVar;
        tVar.akW(aVar.Oye);
        tVar.OxV.add(aVar);
        new MMHandler().postDelayed(new Runnable() {
            /* class com.tencent.mm.ui.t.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(205118);
                t.this.supportInvalidateOptionsMenu();
                AppMethodBeat.o(205118);
            }
        }, 200);
    }

    public void addTextOptionMenu(int i2, String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener) {
        this.mController.addTextOptionMenu(i2, str, onMenuItemClickListener, onLongClickListener);
    }

    public void addTextOptionMenu(int i2, String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener, t.b bVar) {
        this.mController.addTextOptionMenu(i2, str, onMenuItemClickListener, onLongClickListener, bVar);
    }

    public void addTextOptionMenu(int i2, String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener, View.OnTouchListener onTouchListener, t.b bVar) {
        t tVar = this.mController;
        t.a aVar = new t.a();
        aVar.Oye = i2;
        aVar.Oyf = 0;
        aVar.text = str;
        aVar.kjh = onMenuItemClickListener;
        aVar.tib = onLongClickListener;
        aVar.uwC = onTouchListener;
        aVar.OGS = bVar;
        aVar.eho = false;
        if (aVar.Oyf == R.drawable.aii && Util.isNullOrNil(str)) {
            aVar.text = tVar.mContext.getString(R.string.wp);
        }
        tVar.akW(aVar.Oye);
        tVar.OxV.add(aVar);
        tVar.supportInvalidateOptionsMenu();
    }

    public void addIconOptionMenu(int i2, int i3, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i2, i3, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i2, int i3, Drawable drawable, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i2, getString(i3), drawable, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i2, String str, Drawable drawable, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i2, str, drawable, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i2, String str, int i3, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i2, str, i3, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i2, int i3, int i4, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i2, i3, i4, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i2, int i3, int i4, boolean z, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i2, i3, i4, z, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i2, int i3, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener) {
        this.mController.addIconOptionMenu(i2, i3, onMenuItemClickListener, onLongClickListener);
    }

    public void addIconOptionMenu(int i2, int i3, int i4, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener) {
        this.mController.addIconOptionMenu(i2, i3, i4, onMenuItemClickListener, onLongClickListener);
    }

    public void updateOptionMenuIcon(int i2, int i3) {
        this.mController.updateOptionMenuIcon(i2, i3);
    }

    public void updateOptionMenuStyle(int i2, t.b bVar) {
        t tVar = this.mController;
        t.a akX = tVar.akX(i2);
        if (akX != null) {
            akX.OGS = bVar;
            tVar.supportInvalidateOptionsMenu();
        }
    }

    public void updateOptionMenuText(int i2, String str) {
        this.mController.updateOptionMenuText(i2, str);
    }

    public void updateOptionMenuListener(int i2, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener) {
        this.mController.updateOptionMenuListener(i2, onMenuItemClickListener, onLongClickListener);
    }

    public void setTitleBarDoubleClickListener(Runnable runnable) {
        this.mController.setTitleBarDoubleClickListener(runnable);
    }

    public void setTitleBarClickListener(Runnable runnable, Runnable runnable2) {
        t tVar = this.mController;
        if (tVar.mActionBar != null) {
            tVar.mActionBar.getCustomView().setOnClickListener(new View.OnClickListener(runnable, runnable2) {
                /* class com.tencent.mm.ui.t.AnonymousClass10 */
                final /* synthetic */ Runnable OGM;
                final /* synthetic */ Runnable OGN;

                {
                    this.OGM = r2;
                    this.OGN = r3;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(205114);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MMActivityController$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (SystemClock.elapsedRealtime() - t.this.EKP < 300) {
                        if (this.OGM != null) {
                            this.OGM.run();
                        }
                    } else if (this.OGN != null) {
                        this.OGN.run();
                    }
                    t.this.EKP = SystemClock.elapsedRealtime();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivityController$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(205114);
                }
            });
        }
    }

    public void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.setBackBtn(onMenuItemClickListener, 0);
    }

    public void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener, int i2) {
        this.mController.setBackBtn(onMenuItemClickListener, i2);
    }

    public void setBackBtnColorFilter(int i2) {
        this.mController.setBackBtnColorFilter(i2);
    }

    public void setActionbarColor(int i2) {
        this.mController.setActionbarColor(i2);
    }

    public void setLightNavigationbarIcon() {
        t tVar = this.mController;
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = tVar.OGe.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & -17);
        }
    }

    public void setNavigationbarColor(int i2) {
        this.mController.setNavigationbarColor(i2);
    }

    public void setActionbarHeight(int i2) {
        this.mController.akY(i2);
    }

    public void setIconAlpha(float f2) {
        this.mController.setIconAlpha(f2);
    }

    public int getCurrentActionbarHeight() {
        return this.mController.bIs;
    }

    public void expendActionbar() {
        t tVar = this.mController;
        if (!tVar.noActionBar() && tVar.bIs < tVar.OxT) {
            ValueAnimator duration = ValueAnimator.ofInt(tVar.bIs, tVar.OxT).setDuration(200L);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.ui.t.AnonymousClass15 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(205119);
                    t.this.akY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    AppMethodBeat.o(205119);
                }
            });
            duration.start();
        }
    }

    public void setIsDarkActionbarBg(boolean z) {
        this.mController.Bi(z);
    }

    public void setActionbarElementColor(int i2) {
        t tVar = this.mController;
        tVar.OGn = i2;
        tVar.OGt = true;
        if (tVar.OGl != null) {
            tVar.OGl.setIconColor(i2);
        }
        if (tVar.OGj != null && tVar.OGj.getVisibility() == 0) {
            tVar.OGj.setTextColor(i2);
        }
        if (tVar.orb != null && tVar.orb.getVisibility() == 0) {
            tVar.orb.setTextColor(i2);
        }
        if (tVar.OxJ != null && tVar.OxJ.getVisibility() == 0) {
            tVar.OxJ.getDrawable().setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
        } else if (tVar.OxL != null && tVar.OxL.getVisibility() == 0) {
            tVar.OxL.setTextColor(i2);
        }
    }

    public void setTitleAlpha(float f2) {
        t tVar = this.mController;
        if (tVar.OGj != null) {
            tVar.OGj.setAlpha(f2);
        }
    }

    public void hideActionbarLine() {
        this.mController.hideActionbarLine();
    }

    public void showActionbarLine() {
        this.mController.showActionbarLine();
    }

    public void updateBackBtn(Drawable drawable) {
        this.mController.updateBackBtn(drawable);
    }

    public void setBackBtnVisible(boolean z) {
        this.mController.setBackBtnVisible(z);
    }

    public void removeAllOptionMenu() {
        this.mController.removeAllOptionMenu();
    }

    public boolean removeOptionMenu(int i2) {
        return this.mController.removeOptionMenu(i2);
    }

    public CharSequence getMMTitle() {
        return this.mController.getMMTitle();
    }

    public TextView getMMSubTitle() {
        return this.mController.orb;
    }

    public int getActionbarColor() {
        return this.mController.gIN();
    }

    public void hideTitleView() {
        this.mController.hideTitleView();
    }

    public void showTitleView() {
        this.mController.showTitleView();
    }

    public boolean isTitleShowing() {
        return this.mController.isTitleShowing();
    }

    public int getTitleLocation() {
        return this.mController.getTitleLocation();
    }

    public void setTitlePhoneIconVisibility(int i2) {
        this.mController.setTitlePhoneIconVisibility(i2);
    }

    public void setTitleMuteIconVisibility(int i2) {
        this.mController.setTitleMuteIconVisibility(i2);
    }

    public void setTitleForceNotifyIconVisibility(int i2) {
        t tVar = this.mController;
        tVar.OGc = i2 == 0;
        tVar.gIQ();
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ad
    public boolean hideVKBHavingResult() {
        return this.mController.hideVKB();
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ad, com.tencent.mm.ui.MMFragmentActivity
    public void hideVKB() {
        this.mController.hideVKB();
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ad, com.tencent.mm.ui.MMFragmentActivity
    public void hideVKB(View view) {
        this.mController.hideVKB(view);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ad, com.tencent.mm.ui.MMFragmentActivity
    public void showVKB() {
        t.showVKB(this.mController.OGe);
    }

    public static void showVKB(Activity activity) {
        View currentFocus;
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null && (currentFocus = activity.getCurrentFocus()) != null && currentFocus.getWindowToken() != null) {
            inputMethodManager.toggleSoftInput(0, 2);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public Resources getResources() {
        if (getBaseContext() != null) {
            Resources resources = getBaseContext().getResources();
            Resources resources2 = super.getResources();
            if (!(resources2 instanceof com.tencent.mm.cc.b) || resources == null) {
                return resources2;
            }
            com.tencent.mm.cc.b bVar = (com.tencent.mm.cc.b) resources2;
            Configuration g2 = bVar.NDo.g(resources.getConfiguration());
            com.tencent.mm.cc.c.a(g2, ao.f(resources2));
            bVar.getConfiguration().updateFrom(g2);
            return bVar;
        }
        Log.printInfoStack(TAG, "no base context!!", new Object[0]);
        return super.getResources();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        super.finish();
        int intExtra = IntentUtil.getIntExtra(getIntent(), "MMActivity.OverrideEnterAnimation", -1);
        int intExtra2 = IntentUtil.getIntExtra(getIntent(), "MMActivity.OverrideExitAnimation", -1);
        if (intExtra != -1) {
            super.overridePendingTransition(intExtra, intExtra2);
        }
    }

    public void startActivity(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/MMActivity", "startActivity", "(Ljava/lang/Class;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivity", "startActivity", "(Ljava/lang/Class;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }

    public void startActivity(Class<?> cls, Intent intent) {
        intent.setClass(this, cls);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/MMActivity", "startActivity", "(Ljava/lang/Class;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMActivity", "startActivity", "(Ljava/lang/Class;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }

    public void mmStartActivityForResult(a aVar, Intent intent, int i2) {
        this.onActResult = aVar;
        startActivityForResult(intent, i2);
    }

    public void mmSetOnActivityResultCallback(a aVar) {
        this.onActResult = aVar;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (this.onActResult != null) {
            this.onActResult.d(i2, i3, intent);
        }
        this.onActResult = null;
    }

    public void showMMLogo() {
        t tVar = this.mController;
        tVar.OGl.setVisibility(8);
        tVar.OGk.setVisibility(8);
    }

    public void setMMSingleTitle(String str) {
        this.mController.setMMSingleTitle(str, null);
    }

    public void setMMSingleTitle(String str, Animation animation) {
        this.mController.setMMSingleTitle(str, animation);
    }

    public boolean isSingleTitleView() {
        t tVar = this.mController;
        if (tVar.mActionBar == null || tVar.mActionBar.getCustomView() == null || tVar.mActionBar.getCustomView().findViewById(R.id.cd) == null) {
            return false;
        }
        return true;
    }

    public void setMMNormalView() {
        this.mController.setMMNormalView();
    }

    @Deprecated
    public boolean activityHasDestroyed() {
        return isDestroyed();
    }

    /* access modifiers changed from: protected */
    public <T> T $(int i2) {
        return (T) findViewById(i2);
    }

    public void setSelfNavigationBarColor(int i2) {
        if (!au.aA(getContext())) {
            Log.w(TAG, "has not NavigationBar!");
            return;
        }
        if (this.mSelfNavigationBar == null) {
            this.mSelfNavigationBar = new View(getContext());
            ((ViewGroup) getWindow().getDecorView()).addView(this.mSelfNavigationBar);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, au.aD(getContext()));
        layoutParams.gravity = 80;
        this.mSelfNavigationBar.setLayoutParams(layoutParams);
        this.mSelfNavigationBar.setBackgroundColor(i2);
        this.mSelfNavigationBar.setVisibility(8);
    }

    public void setSelfNavigationBarVisible(int i2) {
        if (this.mSelfNavigationBar != null) {
            this.mSelfNavigationBar.setVisibility(i2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                sNavBarOverride = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable th) {
                sNavBarOverride = null;
            }
        }
    }

    private int getInternalDimensionSize(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public String getCallerPackage() {
        Uri referrer;
        String str = "";
        ComponentName callingActivity = getCallingActivity();
        if (callingActivity != null) {
            str = callingActivity.getPackageName();
            Log.i(TAG, "get calling activity, %s", str);
        }
        String str2 = str;
        if (Util.isNullOrNil(str2) && Build.VERSION.SDK_INT >= 22) {
            try {
                Object obj = new com.tencent.mm.compatible.loader.c(this, "mReferrer", null).get();
                if (obj != null) {
                    str2 = (String) obj;
                }
                Log.i(TAG, "get referrer, %s", str2);
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "get mReferrer error", new Object[0]);
            }
        }
        if (!Util.isNullOrNil(str2) || Build.VERSION.SDK_INT < 22 || (referrer = getReferrer()) == null) {
            return str2;
        }
        String authority = referrer.getAuthority();
        Log.i(TAG, "get referrer, %s", authority);
        return authority;
    }

    private void noteOnResumeTicks() {
        if (this.lastOnPauseTicks > this.lastOnResumeTicks) {
            this.lastBrowseTime += this.lastOnPauseTicks - this.lastOnResumeTicks;
        }
        this.lastOnResumeTicks = Util.currentTicks();
        this.lastOnPauseTicks = 0;
    }

    private void noteOnPauseTicks() {
        this.lastOnPauseTicks = Util.currentTicks();
    }

    public long getActivityBrowseTimeMs() {
        long currentTicks;
        if (this.lastOnPauseTicks != 0) {
            currentTicks = (this.lastOnPauseTicks - this.lastOnResumeTicks) + this.lastBrowseTime;
        } else {
            currentTicks = (Util.currentTicks() - this.lastOnResumeTicks) + this.lastBrowseTime;
        }
        if (currentTicks < 0) {
            Log.w(TAG, "%d get activity browse time is error, may be something warn here.[%d %d %d %d]", Integer.valueOf(hashCode()), Long.valueOf(currentTicks), Long.valueOf(this.lastOnResumeTicks), Long.valueOf(this.lastOnPauseTicks), Long.valueOf(this.lastBrowseTime));
        }
        Log.v(TAG, "%d get activity browse time [%d]", Integer.valueOf(hashCode()), Long.valueOf(currentTicks));
        return currentTicks;
    }

    public void initActionBarOperationArea() {
        if (this.mController != null) {
            t tVar = this.mController;
            if (tVar.OGq != null) {
                tVar.OGq.setVisibility(0);
            }
            if (tVar.OxH != null) {
                tVar.OxH.setVisibility(8);
            }
        }
    }

    public void hideActionBarOperationArea() {
        if (this.mController != null) {
            t tVar = this.mController;
            if (tVar.OGq != null) {
                tVar.OGq.setVisibility(8);
            }
            if (tVar.OxH != null) {
                tVar.OxH.setVisibility(0);
            }
        }
    }

    public void initActionBarOperationAreaTxt(String str) {
        if (this.mController != null) {
            t tVar = this.mController;
            if (tVar.OGr != null) {
                tVar.OGr.QBA.setText(str);
            }
        }
    }

    public void initActionBarOperationAreaTxt(String str, int i2, int i3, int i4, int i5) {
        if (this.mController != null) {
            t tVar = this.mController;
            if (tVar.OGr != null) {
                AlbumChooserView albumChooserView = tVar.OGr;
                albumChooserView.QBA.setText(str);
                albumChooserView.QBA.setTextColor(albumChooserView.getContext().getResources().getColor(i2));
                ((LinearLayout) albumChooserView.QBA.getParent()).setBackground(albumChooserView.getContext().getResources().getDrawable(i5));
                albumChooserView.QBB.setIconColor(albumChooserView.getContext().getResources().getColor(i3));
                ((FrameLayout) albumChooserView.QBB.getParent()).setBackground(albumChooserView.getContext().getResources().getDrawable(i4));
            }
        }
    }

    public void updateActionBarOperationAreaTxt(String str) {
        if (this.mController != null) {
            t tVar = this.mController;
            if (tVar.OGr != null) {
                AlbumChooserView albumChooserView = tVar.OGr;
                if (!albumChooserView.QBC) {
                    albumChooserView.QBC = true;
                    albumChooserView.QBB.animate().rotationBy(180.0f).setDuration(200).withEndAction(new Runnable(str) {
                        /* class com.tencent.mm.ui.widget.AlbumChooserView.AnonymousClass3 */
                        final /* synthetic */ String QBF;

                        {
                            this.QBF = r2;
                        }

                        public final void run() {
                            AppMethodBeat.i(159260);
                            AlbumChooserView.this.QBC = false;
                            AlbumChooserView.this.QBA.setText(this.QBF);
                            AppMethodBeat.o(159260);
                        }
                    }).start();
                }
            }
        }
    }

    public void playActionBarOperationAreaAnim() {
        if (this.mController != null) {
            t tVar = this.mController;
            if (tVar.OGr != null) {
                AlbumChooserView albumChooserView = tVar.OGr;
                if (!albumChooserView.QBC) {
                    albumChooserView.QBC = true;
                    albumChooserView.QBB.animate().rotationBy(180.0f).setDuration(200).withEndAction(new Runnable() {
                        /* class com.tencent.mm.ui.widget.AlbumChooserView.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(159259);
                            AlbumChooserView.this.QBC = false;
                            AppMethodBeat.o(159259);
                        }
                    }).start();
                }
            }
        }
    }

    public void setActionBarOperationAreaClickListener(AlbumChooserView.a aVar) {
        if (this.mController != null) {
            t tVar = this.mController;
            if (tVar.OGr != null) {
                tVar.OGr.setOnAlbumChooserViewClick(aVar);
            }
        }
    }

    public void setSmartGalleryEntryVisibility(boolean z) {
        if (this.mController != null) {
            t tVar = this.mController;
            Log.d("MicroMsg.MMActivityController", "set smart gallery entry valid.");
            tVar.OGf = z;
            tVar.supportInvalidateOptionsMenu();
        }
    }

    public boolean isActionbarCenterLayoutMode() {
        return true;
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public boolean isPaused() {
        return this.mIsPaused;
    }
}
