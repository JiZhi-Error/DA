package com.tencent.mm.plugin.appbrand.ad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.smtt.sdk.WebView;

@SuppressLint({"ViewConstructor"})
public final class f extends FrameLayout {
    private AppBrandRuntime kGM;
    private FrameLayout kGN;
    private LinearLayout kGO;
    public a kGP;
    private a kGQ;

    public interface a {
        void UB(String str);
    }

    static /* synthetic */ void a(f fVar) {
        AppMethodBeat.i(134649);
        fVar.btN();
        AppMethodBeat.o(134649);
    }

    static /* synthetic */ void a(f fVar, String str) {
        AppMethodBeat.i(134651);
        fVar.UA(str);
        AppMethodBeat.o(134651);
    }

    static /* synthetic */ void a(f fVar, boolean z, String str) {
        AppMethodBeat.i(134650);
        fVar.l(z, str);
        AppMethodBeat.o(134650);
    }

    public f(Context context, AppBrandRuntime appBrandRuntime) {
        super(context);
        AppMethodBeat.i(134634);
        this.kGM = appBrandRuntime;
        if (j.cDv.isDarkMode()) {
            setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        } else {
            setBackgroundColor(-1);
        }
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.kGN = new FrameLayout(context);
        addView(this.kGN, new ViewGroup.LayoutParams(-1, -1));
        this.kGO = new LinearLayout(context);
        this.kGO.setOrientation(1);
        addView(this.kGO, new ViewGroup.LayoutParams(-1, -2));
        if (this.kGO.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            c.C0789c statusBar = appBrandRuntime.getWindowAndroid().getStatusBar();
            int i2 = statusBar == null ? 0 : statusBar.height;
            ((ViewGroup.MarginLayoutParams) this.kGO.getLayoutParams()).topMargin = i2;
            Log.i("MicroMsg.AppBrandRuntimeAdViewContainer[AppBrandSplashAd]", "fakeActionBarLayout topMargin=%d", Integer.valueOf(i2));
        }
        AppMethodBeat.o(134634);
    }

    public final ViewGroup getContentContainer() {
        return this.kGN;
    }

    public final void btL() {
        AppMethodBeat.i(134635);
        this.kGO.removeAllViews();
        this.kGP = new a(getContext());
        this.kGO.addView(this.kGP.getActionView());
        this.kGP.setFullscreenMode(true);
        this.kGP.gx(false);
        this.kGP.gy(false);
        this.kGP.gz(false);
        this.kGP.setBackgroundColor(0);
        AppMethodBeat.o(134635);
    }

    public final void setActionBarFullscreenMode(boolean z) {
        AppMethodBeat.i(134636);
        if (this.kGP != null) {
            this.kGP.setFullscreenMode(z);
        }
        AppMethodBeat.o(134636);
    }

    public final void setBackButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(134637);
        if (this.kGP != null) {
            this.kGP.setBackButtonClickListener(onClickListener);
        }
        AppMethodBeat.o(134637);
    }

    public final void setOptionButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(134638);
        if (this.kGP != null) {
            this.kGP.kGn.setOptionButtonClickListener(onClickListener);
        }
        AppMethodBeat.o(134638);
    }

    public final void setCloseButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(134639);
        if (this.kGP != null) {
            this.kGP.setCloseButtonClickListener(onClickListener);
        }
        AppMethodBeat.o(134639);
    }

    public final void setTitle(String str) {
        AppMethodBeat.i(134640);
        if (this.kGP != null) {
            this.kGP.setMainTitle(str);
        }
        AppMethodBeat.o(134640);
    }

    public final void btM() {
        AppMethodBeat.i(134641);
        if (this.kGP != null) {
            this.kGP.gz(true);
        }
        AppMethodBeat.o(134641);
    }

    public final void setForegroundStyle(boolean z) {
        AppMethodBeat.i(134642);
        if (this.kGP != null) {
            this.kGP.kGn.setForegroundStyle(z);
        }
        AppMethodBeat.o(134642);
    }

    public final void btN() {
        AppMethodBeat.i(134644);
        setVisibility(0);
        bringToFront();
        AppMethodBeat.o(134644);
    }

    public final void k(final boolean z, final String str) {
        AppMethodBeat.i(134645);
        if (MMHandlerThread.isMainThread()) {
            l(z, str);
            AppMethodBeat.o(134645);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ad.f.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(134631);
                f.a(f.this, z, str);
                AppMethodBeat.o(134631);
            }
        });
        AppMethodBeat.o(134645);
    }

    private void l(boolean z, final String str) {
        int i2;
        int i3;
        AppMethodBeat.i(134646);
        Log.i("MicroMsg.AppBrandRuntimeAdViewContainer[AppBrandSplashAd]", "hideOnMainThread, animation:%s, source:%s", Boolean.valueOf(z), str);
        if (z) {
            AppBrandOptionButton appBrandOptionButton = null;
            if (this.kGM != null && this.kGM.kAx != null) {
                appBrandOptionButton = this.kGM.kAx.btD();
            } else if (this.kGP != null) {
                appBrandOptionButton = this.kGP.btD();
            }
            if (appBrandOptionButton != null) {
                int width = appBrandOptionButton.getWidth();
                int height = appBrandOptionButton.getHeight();
                int[] iArr = new int[2];
                appBrandOptionButton.getLocationInWindow(iArr);
                int i4 = (width / 2) + iArr[0];
                i2 = iArr[1] + (height / 2);
                i3 = i4;
            } else {
                i2 = 0;
                i3 = 0;
            }
            if (i3 <= 0 || i2 <= 0) {
                UA(str);
                AppMethodBeat.o(134646);
                return;
            }
            a(this, i3, i2, new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ad.f.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(134632);
                    f.a(f.this, str);
                    AppMethodBeat.o(134632);
                }
            });
            AppMethodBeat.o(134646);
            return;
        }
        UA(str);
        AppMethodBeat.o(134646);
    }

    private void UA(String str) {
        AppMethodBeat.i(134647);
        setVisibility(8);
        if (this.kGQ != null) {
            this.kGQ.UB(str);
        }
        AppMethodBeat.o(134647);
    }

    private void a(View view, int i2, int i3, final Runnable runnable) {
        AppMethodBeat.i(134648);
        if (Build.VERSION.SDK_INT >= 21) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, (float) Math.hypot((double) i2, (double) i3), 0.0f);
            createCircularReveal.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.appbrand.ad.f.AnonymousClass5 */

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(219296);
                    if (runnable != null) {
                        runnable.run();
                    }
                    AppMethodBeat.o(219296);
                }
            });
            createCircularReveal.setDuration(300).setInterpolator(new DecelerateInterpolator());
            createCircularReveal.start();
            AppMethodBeat.o(134648);
            return;
        }
        runnable.run();
        AppMethodBeat.o(134648);
    }

    public final void setOnHideListener(a aVar) {
        this.kGQ = aVar;
    }
}
