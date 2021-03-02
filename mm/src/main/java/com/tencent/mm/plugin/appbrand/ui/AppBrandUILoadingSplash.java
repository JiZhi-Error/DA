package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Keep;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.h.j;
import com.tencent.luggage.sdk.d.d;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.launching.q;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.statusbar.b;
import kotlin.x;

@SuppressLint({"ViewConstructor"})
public final class AppBrandUILoadingSplash extends b implements q, ab, ad, ae {
    AppBrandRuntime kEc;
    private ImageView nSS;
    private TextView nSV;
    private AppBrandCircleProgressView nSX;
    private TextView nTa;
    private Boolean nTp;
    private boolean nTq = false;
    private kotlin.g.a.a<x> nUt;
    private ViewStub nXA;
    private ViewStub nXB;
    private boolean nXC = true;
    private a nXD;
    private ViewGroup nXz;

    /* access modifiers changed from: package-private */
    public interface a {
        void a(ViewStub viewStub);

        void b(ViewStub viewStub);
    }

    static /* synthetic */ void a(AppBrandUILoadingSplash appBrandUILoadingSplash, int i2, boolean z) {
        AppMethodBeat.i(162236);
        super.S(i2, z);
        AppMethodBeat.o(162236);
    }

    static /* synthetic */ boolean c(AppBrandUILoadingSplash appBrandUILoadingSplash) {
        AppMethodBeat.i(162235);
        boolean isDarkMode = appBrandUILoadingSplash.isDarkMode();
        AppMethodBeat.o(162235);
        return isDarkMode;
    }

    @Keep
    public AppBrandUILoadingSplash(Context context) {
        super(context);
        AppMethodBeat.i(177512);
        init();
        AppMethodBeat.o(177512);
    }

    public AppBrandUILoadingSplash(Context context, AppBrandRuntime appBrandRuntime) {
        super(context);
        AppMethodBeat.i(147682);
        this.kEc = appBrandRuntime;
        init();
        AppMethodBeat.o(147682);
    }

    private void init() {
        AppMethodBeat.i(177513);
        setClickable(true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(R.layout.df, this);
        this.nSS = (ImageView) findViewById(R.id.p_);
        this.nSS.setImageDrawable(ak.bXP());
        this.nSV = (TextView) findViewById(R.id.pe);
        this.nSX = (AppBrandCircleProgressView) findViewById(R.id.b33);
        this.nSX.setCircleColor(android.support.v4.content.b.n(getContext(), R.color.BW_0_Alpha_0_1));
        this.nSX.setDotWidth((float) getResources().getDimensionPixelSize(R.dimen.qv));
        this.nSX.setDotColor(android.support.v4.content.b.n(getContext(), R.color.Brand));
        this.nSX.setCircleStrokeWidth((float) getResources().getDimensionPixelSize(R.dimen.qu));
        this.nSX.setProgressColor(android.support.v4.content.b.n(getContext(), R.color.Brand));
        this.nSX.setProgressWidth((float) getResources().getDimensionPixelSize(R.dimen.qw));
        if (MMApplicationContext.isMainProcess()) {
            this.nSX.setTransitionTimingMs(Integer.MAX_VALUE);
        }
        this.nXz = (ViewGroup) findViewById(R.id.pf);
        this.nXA = (ViewStub) findViewById(R.id.aam);
        this.nXB = (ViewStub) findViewById(R.id.e7g);
        c.a("AppBrandUILoadingSplash setupRightButton", new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(147675);
                LayoutInflater.from(AppBrandUILoadingSplash.this.getContext()).inflate(R.layout.de, AppBrandUILoadingSplash.this.nXz);
                AppMethodBeat.o(147675);
            }
        });
        this.nSV.getLayoutParams().height = com.tencent.mm.plugin.appbrand.widget.b.eu(getContext());
        btL();
        AppMethodBeat.o(177513);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void eo(String str, String str2) {
        AppMethodBeat.i(147683);
        com.tencent.mm.modelappbrand.a.b.aXY().a(this.nSS, str, (Drawable) null, g.iJB);
        this.nSV.setText(str2);
        AppMethodBeat.o(147683);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ae
    public final void setCanShowHideAnimation(boolean z) {
        this.nXC = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void z(final kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(230005);
        this.nTq = true;
        Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide mCanShowHideAnimation[%b]", Boolean.valueOf(this.nXC));
        if (!this.nXC) {
            Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, start hide without animation");
            final ViewParent parent = getParent();
            if (!(parent instanceof ViewGroup)) {
                Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, wrong ViewGroup");
                AppMethodBeat.o(230005);
                return;
            }
            post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(147679);
                    Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, remove splash");
                    AppBrandUILoadingSplash.this.setVisibility(8);
                    ((ViewGroup) parent).removeView(AppBrandUILoadingSplash.this);
                    if (aVar != null) {
                        aVar.invoke();
                    }
                    AppMethodBeat.o(147679);
                }
            });
            AppMethodBeat.o(230005);
            return;
        }
        post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(169536);
                Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, start hide with animation");
                final ViewParent parent = AppBrandUILoadingSplash.this.getParent();
                if (!(parent instanceof ViewGroup)) {
                    Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, wrong ViewGroup");
                    AppMethodBeat.o(169536);
                    return;
                }
                AppBrandUILoadingSplash.this.nSX.bWU();
                ValueAnimator ofInt = ValueAnimator.ofInt(255, 0);
                final int color = AppBrandUILoadingSplash.this.getResources().getColor(R.color.f3045c);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash.AnonymousClass3.AnonymousClass1 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(169534);
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        int argb = Color.argb(intValue, Color.red(color), Color.green(color), Color.blue(color));
                        AppBrandUILoadingSplash.this.nXz.setBackgroundColor(argb);
                        AppBrandUILoadingSplash.a(AppBrandUILoadingSplash.this, argb, !AppBrandUILoadingSplash.c(AppBrandUILoadingSplash.this));
                        if (intValue == 0) {
                            AppBrandUILoadingSplash.this.post(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(169533);
                                    Log.i("MicroMsg.AppBrandUILoadingSplash", "animateHide, hide ends && remove splash");
                                    AppBrandUILoadingSplash.this.setVisibility(8);
                                    ((ViewGroup) parent).removeView(AppBrandUILoadingSplash.this);
                                    if (aVar != null) {
                                        aVar.invoke();
                                    }
                                    AppMethodBeat.o(169533);
                                }
                            });
                        }
                        AppMethodBeat.o(169534);
                    }
                });
                ofInt.setStartDelay((long) Math.round(160.0f));
                ofInt.setDuration((long) Math.round(40.0f));
                ofInt.setInterpolator(new android.support.v4.view.b.a());
                ofInt.start();
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                ofFloat.setDuration((long) Math.round(160.0f));
                final int color2 = AppBrandUILoadingSplash.this.getResources().getColor(R.color.a2x);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash.AnonymousClass3.AnonymousClass2 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(169535);
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        AppBrandUILoadingSplash.this.nSV.setTextColor(Color.argb(Math.round(255.0f * floatValue), Color.red(color2), Color.green(color2), Color.blue(color2)));
                        AppBrandUILoadingSplash.this.nSX.setAlpha(floatValue);
                        AppBrandUILoadingSplash.this.nSS.setAlpha(floatValue);
                        AppBrandUILoadingSplash.this.nXB.setAlpha(floatValue);
                        AppBrandUILoadingSplash.this.S(AppBrandUILoadingSplash.this.getResources().getColor(R.color.f3045c), !AppBrandUILoadingSplash.c(AppBrandUILoadingSplash.this));
                        AppMethodBeat.o(169535);
                    }
                });
                ofFloat.setInterpolator(new android.support.v4.view.b.b());
                ofFloat.start();
                AppMethodBeat.o(169536);
            }
        });
        AppMethodBeat.o(230005);
    }

    /* access modifiers changed from: package-private */
    public final boolean isDarkMode() {
        AppMethodBeat.i(162234);
        if (this.nTp == null) {
            this.nTp = Boolean.valueOf(j.cDv.isDarkMode());
        }
        boolean booleanValue = this.nTp.booleanValue();
        AppMethodBeat.o(162234);
        return booleanValue;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final View getView() {
        return this;
    }

    @Override // com.tencent.mm.ui.statusbar.b
    public final void onAttachedToWindow() {
        AppMethodBeat.i(147685);
        super.onAttachedToWindow();
        S(getResources().getColor(R.color.f3045c), !isDarkMode());
        this.nSX.bWT();
        try {
            d(getContext().getResources().getConfiguration());
            AppMethodBeat.o(147685);
        } catch (Exception e2) {
            AppMethodBeat.o(147685);
        }
    }

    public final boolean hasOverlappingRendering() {
        return false;
    }

    private void btL() {
        int i2;
        int i3 = -1;
        AppMethodBeat.i(177514);
        AnonymousClass4 r4 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(169537);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandUILoadingSplash$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (AppBrandUILoadingSplash.this.kEc != null) {
                    if (AppBrandUILoadingSplash.this.nTq) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandUILoadingSplash$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(169537);
                        return;
                    }
                    h.a(AppBrandUILoadingSplash.this.kEc.mAppId, h.d.CLOSE);
                    AppBrandUILoadingSplash.this.kEc.finish();
                } else if (AppBrandUILoadingSplash.this.nUt != null) {
                    AppBrandUILoadingSplash.this.nUt.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandUILoadingSplash$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(169537);
            }
        };
        AppBrandOptionButton appBrandOptionButton = (AppBrandOptionButton) this.nXz.findViewById(R.id.dy);
        this.nXz.findViewById(R.id.du).setBackgroundResource(isDarkMode() ? R.drawable.cy : R.drawable.cz);
        appBrandOptionButton.reset();
        if (isDarkMode()) {
            i2 = -1;
        } else {
            i2 = -16777216;
        }
        appBrandOptionButton.setColor(i2);
        AppBrandOptionButton appBrandOptionButton2 = (AppBrandOptionButton) this.nXz.findViewById(R.id.dx);
        appBrandOptionButton2.reset();
        if (!isDarkMode()) {
            i3 = -16777216;
        }
        appBrandOptionButton2.setColor(i3);
        appBrandOptionButton2.setOnClickListener(r4);
        AppMethodBeat.o(177514);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void setProgress(int i2) {
        AppMethodBeat.i(230006);
        this.nSX.setProgress(i2);
        AppMethodBeat.o(230006);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void yu(int i2) {
        AppMethodBeat.i(147686);
        this.nXz.setBackgroundColor(i2);
        AppMethodBeat.o(147686);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.q
    public final void vy(final int i2) {
        AppMethodBeat.i(147687);
        if (this.kEc == null) {
            AppMethodBeat.o(147687);
            return;
        }
        this.kEc.i(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(169538);
                Log.i("MicroMsg.AppBrandUILoadingSplash", "onDataTransferState  state=" + i2);
                if (i2 == 3) {
                    if (AppBrandUILoadingSplash.this.nTa == null) {
                        ((ViewStub) AppBrandUILoadingSplash.this.findViewById(R.id.te)).inflate();
                        AppBrandUILoadingSplash.this.nTa = (TextView) AppBrandUILoadingSplash.this.findViewById(R.id.epb);
                    }
                    AppBrandUILoadingSplash.this.nTa.setVisibility(0);
                    AppBrandUILoadingSplash.this.nTa.setText(R.string.a0m);
                    AppBrandUILoadingSplash.this.nXA.setVisibility(8);
                }
                AppMethodBeat.o(169538);
            }
        }, 0);
        AppMethodBeat.o(147687);
    }

    /* access modifiers changed from: protected */
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(147688);
        super.onConfigurationChanged(configuration);
        try {
            d(configuration);
            AppMethodBeat.o(147688);
        } catch (Exception e2) {
            AppMethodBeat.o(147688);
        }
    }

    private void d(Configuration configuration) {
        boolean z;
        AppMethodBeat.i(147689);
        if (!(this.kEc.getWindowAndroid() instanceof o)) {
            AppMethodBeat.o(147689);
            return;
        }
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(((o) this.kEc.getWindowAndroid()).mContext);
        if (configuration.orientation == 2) {
            z = true;
        } else {
            z = false;
        }
        if (!z || castActivityOrNull == null || Build.VERSION.SDK_INT < 24 || !castActivityOrNull.isInMultiWindowMode() || castActivityOrNull.getRequestedOrientation() != 1) {
            if (castActivityOrNull != null) {
                Window window = castActivityOrNull.getWindow();
                View decorView = window.getDecorView();
                if (z) {
                    window.addFlags(1024);
                    decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 4 | 256);
                    AppMethodBeat.o(147689);
                    return;
                }
                y.a(window, false, false);
            }
            AppMethodBeat.o(147689);
            return;
        }
        AppMethodBeat.o(147689);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ad
    public final void C(kotlin.g.a.a<x> aVar) {
        this.nUt = aVar;
    }

    public final void setLabelInjector(a aVar) {
        AppMethodBeat.i(230007);
        this.nXD = aVar;
        if (this.nXD != null) {
            this.nXD.a(this.nXB);
            this.nXD.b(this.nXA);
        }
        AppMethodBeat.o(230007);
    }

    private boolean OS() {
        AppMethodBeat.i(230008);
        if (this.kEc == null || !(this.kEc instanceof d) || !((d) this.kEc).OS()) {
            AppMethodBeat.o(230008);
            return false;
        }
        AppMethodBeat.o(230008);
        return true;
    }

    public final boolean post(Runnable runnable) {
        AppMethodBeat.i(230009);
        if (runnable == null) {
            AppMethodBeat.o(230009);
            return false;
        } else if (u.aD(this) || !OS()) {
            boolean post = super.post(runnable);
            AppMethodBeat.o(230009);
            return post;
        } else {
            MMHandlerThread.postToMainThread(runnable);
            AppMethodBeat.o(230009);
            return true;
        }
    }

    public final boolean postDelayed(Runnable runnable, long j2) {
        AppMethodBeat.i(230010);
        if (runnable == null) {
            AppMethodBeat.o(230010);
            return false;
        } else if (u.aD(this) || !OS()) {
            boolean postDelayed = super.postDelayed(runnable, j2);
            AppMethodBeat.o(230010);
            return postDelayed;
        } else {
            MMHandlerThread.postToMainThreadDelayed(runnable, j2);
            AppMethodBeat.o(230010);
            return true;
        }
    }
}
