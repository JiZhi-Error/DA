package com.tencent.mm.plugin.appbrand.ui.wxa_container;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.t;
import java.util.ArrayList;

public abstract class BaseAppBrandUIClipped extends MMSecDataFragmentActivity implements ad, h.c {
    public View mContentView;
    protected a ogk = new a();
    private ArrayList<Dialog> ogl;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        t.initLanguage(MMApplicationContext.getContext());
    }

    public static final class a {
        public int ogm = MMFragmentActivity.a.ogm;
        public int ogn = MMFragmentActivity.a.ogn;
        public int ogo = MMFragmentActivity.a.ogo;
        public int ogp = MMFragmentActivity.a.ogp;

        protected a() {
        }
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean isNfcFilterEnabled() {
        return false;
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean initNavigationSwipeBack() {
        return false;
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean isSupportNavigationSwipeBack() {
        return false;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 28 && getWindow() != null) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
        onCreateBeforeSetContentView();
        FrameLayout frameLayout = new FrameLayout(this);
        this.mContentView = frameLayout;
        setContentView(frameLayout);
    }

    /* access modifiers changed from: protected */
    public final HalfScreenConfig bZi() {
        AppBrandInitConfigWC bsC = bsC();
        if (bsC == null) {
            return null;
        }
        return bsC.kHL;
    }

    /* access modifiers changed from: protected */
    public final AppBrandInitConfigWC bsC() {
        try {
            return (AppBrandInitConfigWC) getIntent().getParcelableExtra("key_appbrand_init_config");
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrand.BaseAppBrandUIClipped", "AppBrandInitConfigWC unmarshalling fail! " + e2.getMessage(), "");
            return null;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.ogl != null) {
            int size = this.ogl.size();
            for (int i2 = 0; i2 < size; i2++) {
                Dialog dialog = this.ogl.get(i2);
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
            this.ogl.clear();
            this.ogl = null;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ad, com.tencent.mm.ui.MMFragmentActivity
    public final void hideVKB() {
        hideVKBHavingResult();
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ad, com.tencent.mm.ui.MMFragmentActivity
    public final void hideVKB(View view) {
        cL(view);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ad
    public final boolean hideVKBHavingResult() {
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            return cL(this.mContentView);
        }
        return cL(currentFocus);
    }

    private boolean cL(View view) {
        InputMethodManager inputMethodManager;
        IBinder windowToken;
        boolean z;
        if (view == null || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null || (windowToken = view.getWindowToken()) == null) {
            return false;
        }
        try {
            z = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e2) {
            Log.e("MicroMsg.AppBrand.BaseAppBrandUIClipped", "hide VKB(View) exception %s", e2);
            z = false;
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ad, com.tencent.mm.ui.MMFragmentActivity
    public final void showVKB() {
        t.showVKB(this);
    }

    /* access modifiers changed from: protected */
    public void onCreateBeforeSetContentView() {
        com.tencent.luggage.sdk.g.a.b(this, 10);
        com.tencent.luggage.sdk.g.a.b(this, 1);
    }

    public final void setNavigationbarColor(int i2) {
        d(this, i2);
    }

    public static void d(Activity activity, int i2) {
        int i3;
        if (!activity.isFinishing() && !activity.isDestroyed() && activity.getWindow() != null && Build.VERSION.SDK_INT >= 26 && !r.gII()) {
            activity.getWindow().setNavigationBarColor(i2);
            boolean aln = ar.aln(i2);
            View decorView = activity.getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (aln) {
                i3 = systemUiVisibility & -17;
            } else {
                i3 = systemUiVisibility | 16;
            }
            decorView.setSystemUiVisibility(i3);
        }
    }

    @Override // com.tencent.mm.ui.base.h.c
    public void addDialog(Dialog dialog) {
        if (dialog != null) {
            if (this.ogl == null) {
                this.ogl = new ArrayList<>();
            }
            this.ogl.add(dialog);
        }
    }
}
