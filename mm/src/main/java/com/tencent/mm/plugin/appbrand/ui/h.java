package com.tencent.mm.plugin.appbrand.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.preload.a;
import com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.launching.q;
import com.tencent.mm.plugin.appbrand.page.capsulebar.d;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.WebView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.x;

/* access modifiers changed from: package-private */
@SuppressLint({"ViewConstructor"})
public final class h extends com.tencent.mm.ui.statusbar.b implements q, ab {
    private com.tencent.mm.plugin.appbrand.q kBw;
    private ImageView nSS;
    private ImageView nST;
    private ImageView nSU;
    private TextView nSV;
    private LinearLayout nSW;
    private AppBrandCircleProgressView nSX;
    private d nSY;
    private e.b nSZ = e.b.PORTRAIT;
    private TextView nTa;
    private boolean nTb;
    private Runnable nTc = null;
    private RelativeLayout nTd;
    private boolean nTe = false;
    private boolean nTf = false;
    private boolean nTg = false;
    private int nTh;
    private boolean nTi = false;
    private int nTj = 30;
    private RelativeLayout nTk;
    private ImageView nTl;
    private BootstrapProgressBar nTm;
    private boolean nTn;
    private boolean nTo;
    private Boolean nTp;
    private boolean nTq = false;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Context context, com.tencent.mm.plugin.appbrand.q qVar) {
        super(context);
        String str = null;
        AppMethodBeat.i(48602);
        this.kBw = qVar;
        Log.i("MicroMsg.AppBrandGameUILoadingSplash", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        setClickable(true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(R.layout.fr, this);
        this.nTk = (RelativeLayout) findViewById(R.id.nz);
        this.nTl = (ImageView) findViewById(R.id.o0);
        this.nTm = (BootstrapProgressBar) findViewById(R.id.o1);
        com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(999, 1);
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_game_splashscreen, false) && this.kBw != null) {
            final long currentTicks = Util.currentTicks();
            AppBrandInitConfigWC bsC = this.kBw.bsC();
            final String str2 = bsC.cyv.lgU == null ? null : bsC.cyv.lgU.lgQ;
            if (!Util.isNullOrNil(str2)) {
                this.nTe = true;
                Log.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingImgUrl:%s", str2);
                com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(1000, 1);
                final AnonymousClass1 r6 = new a.AbstractC0589a() {
                    /* class com.tencent.mm.plugin.appbrand.ui.h.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.game.preload.a.AbstractC0589a
                    public final void a(final Bitmap bitmap, final long j2) {
                        AppMethodBeat.i(227600);
                        Log.i("MicroMsg.AppBrandGameUILoadingSplash", "onLoadingImageLoaded");
                        h.this.nTf = true;
                        if (h.this.nTl != null) {
                            m.runOnUiThread(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.ui.h.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(48585);
                                    if (bitmap != null) {
                                        h.this.nTl.setImageBitmap(bitmap);
                                        if (h.this.nTg) {
                                            h.d(h.this);
                                        }
                                        com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(1002, (int) Util.ticksToNow(currentTicks));
                                        com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(1001, (int) j2);
                                    }
                                    AppMethodBeat.o(48585);
                                }
                            });
                        }
                        AppMethodBeat.o(227600);
                    }
                };
                com.tencent.mm.ch.a.post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.ui.h.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(227601);
                        com.tencent.mm.plugin.appbrand.game.preload.a.bDs();
                        String str = h.this.kBw.mAppId;
                        String str2 = str2;
                        a.AbstractC0589a aVar = r6;
                        if (!Util.isNullOrNil(str) && !Util.isNullOrNil(str2)) {
                            String str3 = com.tencent.mm.plugin.appbrand.game.preload.a.iIN + FilePathGenerator.ANDROID_DIR_SEP + str + FilePathGenerator.ANDROID_DIR_SEP;
                            FilePathGenerator.checkMkdir(str3);
                            String str4 = str3 + MD5Util.getMD5String(str2);
                            Log.i("MicroMsg.WAGameLoadingImgManager", "loadingImgPath:%s", str4);
                            InputStream inputStream = null;
                            if (new o(str4).exists()) {
                                try {
                                    inputStream = s.openRead(str4);
                                } catch (FileNotFoundException e2) {
                                    Log.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e2, "", new Object[0]);
                                }
                                if (inputStream != null) {
                                    try {
                                        aVar.a(BitmapUtil.decodeStream(inputStream), (long) inputStream.available());
                                    } catch (IOException e3) {
                                        Log.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e3, "read contentLength", new Object[0]);
                                    }
                                }
                            } else {
                                com.tencent.mm.plugin.appbrand.game.preload.a.dj(str4, str2);
                                try {
                                    inputStream = s.openRead(str4);
                                } catch (FileNotFoundException e4) {
                                    Log.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e4, "", new Object[0]);
                                }
                                if (inputStream != null) {
                                    try {
                                        aVar.a(BitmapUtil.decodeStream(inputStream), (long) inputStream.available());
                                    } catch (IOException e5) {
                                        Log.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", e5, "read contentLength", new Object[0]);
                                    }
                                }
                            }
                            Util.qualityClose(inputStream);
                        }
                        AppMethodBeat.o(227601);
                    }
                });
                str = bsC.cyv.lgU != null ? bsC.cyv.lgU.lgR : str;
                if (!Util.isNullOrNil(str)) {
                    this.nTh = Color.parseColor(str);
                    this.nTm.setProgressColor(this.nTh);
                    Log.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingProgressBarColor:%s", Integer.valueOf(this.nTh));
                } else {
                    this.nTh = getContext().getResources().getColor(R.color.d1);
                    this.nTm.setProgressColor(this.nTh);
                }
                this.nTm.setAnimated(true);
                this.nTm.setStriped(true);
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.ui.h.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(48590);
                        h.this.nTg = true;
                        Log.i("MicroMsg.AppBrandGameUILoadingSplash", "mCustomSplashScreenDelayTimeEnd");
                        if (h.this.nTf) {
                            h.d(h.this);
                        }
                        AppMethodBeat.o(48590);
                    }
                }, 1000);
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.ui.h.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(48591);
                        if (h.this.nTf) {
                            AppMethodBeat.o(48591);
                            return;
                        }
                        h.this.nTi = true;
                        h.this.nTd.setVisibility(0);
                        h.j(h.this);
                        AppMethodBeat.o(48591);
                    }
                }, 2000);
            } else {
                com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(1000, 0);
            }
        }
        this.nTd = (RelativeLayout) findViewById(R.id.o_);
        this.nSS = (ImageView) findViewById(R.id.o5);
        this.nSS.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aXX());
        this.nSV = (TextView) findViewById(R.id.o8);
        this.nST = (ImageView) findViewById(R.id.ob);
        this.nSU = (ImageView) findViewById(R.id.o9);
        this.nSW = (LinearLayout) findViewById(R.id.o3);
        this.nTa = (TextView) findViewById(R.id.epb);
        this.nSX = (AppBrandCircleProgressView) findViewById(R.id.o7);
        this.nSX.setCircleColor(getResources().getColor(R.color.BW_0_Alpha_0_1));
        this.nSX.setDotWidth((float) getResources().getDimensionPixelSize(R.dimen.qv));
        this.nSX.setDotColor(getResources().getColor(R.color.Brand));
        this.nSX.setCircleStrokeWidth((float) getResources().getDimensionPixelSize(R.dimen.qu));
        this.nSX.setProgressColor(getResources().getColor(R.color.Brand));
        this.nSX.setProgressWidth((float) getResources().getDimensionPixelSize(R.dimen.qw));
        if (MMApplicationContext.isMainProcess()) {
            this.nSX.setTransitionTimingMs(Integer.MAX_VALUE);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nSU.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nST.getLayoutParams();
        this.nSY = new d(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 21;
        layoutParams3.rightMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.po);
        layoutParams3.topMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pp);
        this.nSW.addView(this.nSY, layoutParams3);
        if (this.kBw.bsC().originalFlag == 1) {
            this.nSU.setVisibility(0);
        } else {
            this.nSU.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nTm.getLayoutParams();
        this.nSZ = this.kBw.getWindowAndroid().getOrientationHandler().btm();
        Log.i("MicroMsg.AppBrandGameUILoadingSplash", "mLastDeviceOrientation :%s", this.nSZ);
        if (this.nSZ == e.b.LANDSCAPE_SENSOR || this.nSZ == e.b.LANDSCAPE_LOCKED || this.nSZ == e.b.LANDSCAPE_LEFT || this.nSZ == e.b.LANDSCAPE_RIGHT) {
            if (this.nSU.getVisibility() == 0) {
                layoutParams2.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pq);
                layoutParams.topMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.px);
                this.nSU.setLayoutParams(layoutParams);
            } else {
                layoutParams2.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pr);
            }
            layoutParams4.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pk);
            layoutParams4.width = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pl);
        } else {
            if (this.nSU.getVisibility() == 0) {
                layoutParams2.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pr);
                layoutParams.topMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pz);
                this.nSU.setLayoutParams(layoutParams);
            } else {
                layoutParams2.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pr);
            }
            layoutParams4.width = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pn);
            layoutParams4.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pm);
        }
        this.nTm.setLayoutParams(layoutParams4);
        this.nST.setLayoutParams(layoutParams2);
        S(getResources().getColor(R.color.f3045c), true);
        this.nSY.setBackgroundColor(0);
        d dVar = this.nSY;
        if (this.nTp == null) {
            this.nTp = Boolean.valueOf(ao.isDarkMode());
        }
        dVar.setStyleColor(this.nTp.booleanValue() ? -1 : WebView.NIGHT_MODE_COLOR);
        this.nSY.setHomeButtonOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.h.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(227604);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (h.this.nTq) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(227604);
                    return;
                }
                com.tencent.mm.plugin.appbrand.h.a(h.this.kBw.mAppId, h.d.CLOSE);
                h.this.kBw.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(227604);
            }
        });
        y.x(getContext(), true);
        if (!this.nTe) {
            this.nSX.bWT();
        }
        AppMethodBeat.o(48602);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void eo(String str, String str2) {
        AppMethodBeat.i(48603);
        com.tencent.mm.modelappbrand.a.b.aXY().a(this.nSS, str, (Drawable) null, com.tencent.mm.modelappbrand.a.g.iJB);
        this.nSV.setText(str2);
        AppMethodBeat.o(48603);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void z(final kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(227605);
        this.nTq = true;
        Log.w("MicroMsg.AppBrandGameUILoadingSplash", "animateHide");
        post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.h.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(48592);
                final ViewParent parent = h.this.getParent();
                if (!(parent instanceof ViewGroup)) {
                    Log.i("MicroMsg.AppBrandGameUILoadingSplash", "animateHide, wrong ViewGroup");
                    AppMethodBeat.o(48592);
                    return;
                }
                h.this.nSX.bWU();
                ViewPropertyAnimator animate = h.this.animate();
                animate.setStartDelay((long) (((float) animate.getDuration()) * 0.8f));
                animate.setDuration((long) (((float) animate.getDuration()) * 1.0f));
                animate.setListener(new AnimatorListenerAdapter() {
                    /* class com.tencent.mm.plugin.appbrand.ui.h.AnonymousClass5.AnonymousClass1 */

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(227603);
                        h.this.post(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.ui.h.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(227602);
                                Log.i("MicroMsg.AppBrandGameUILoadingSplash", "animateHide, remove splash");
                                h.this.setVisibility(8);
                                ((ViewGroup) parent).removeView(h.this);
                                if (aVar != null) {
                                    aVar.invoke();
                                }
                                AppMethodBeat.o(227602);
                            }
                        });
                        AppMethodBeat.o(227603);
                    }
                });
                animate.alpha(0.0f).start();
                AppMethodBeat.o(48592);
            }
        });
        AppMethodBeat.o(227605);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final View getView() {
        return this;
    }

    @Override // com.tencent.mm.ui.statusbar.b
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(48605);
        super.onLayout(z, i2, i3, i4, i5);
        e.b btm = this.kBw.getWindowAndroid().getOrientationHandler().btm();
        if (btm != this.nSZ) {
            this.nSZ = btm;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nSU.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nTm.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nST.getLayoutParams();
            if (btm == e.b.LANDSCAPE_SENSOR || btm == e.b.LANDSCAPE_LOCKED || btm == e.b.LANDSCAPE_LEFT || btm == e.b.LANDSCAPE_RIGHT) {
                if (this.nSU.getVisibility() == 0) {
                    layoutParams3.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pq);
                    layoutParams.topMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.px);
                    this.nSU.setLayoutParams(layoutParams);
                } else {
                    layoutParams3.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pr);
                }
                layoutParams2.width = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pl);
                layoutParams2.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pk);
            } else {
                if (this.nSU.getVisibility() == 0) {
                    layoutParams3.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pr);
                    layoutParams.topMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pz);
                    this.nSU.setLayoutParams(layoutParams);
                } else {
                    layoutParams3.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pr);
                }
                layoutParams2.width = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pn);
                layoutParams2.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), R.dimen.pm);
            }
            this.nTm.setLayoutParams(layoutParams2);
            this.nST.setLayoutParams(layoutParams3);
            requestLayout();
        }
        AppMethodBeat.o(48605);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void setProgress(int i2) {
        AppMethodBeat.i(48606);
        if (!this.nTe) {
            if (i2 < 100) {
                this.nSX.setProgress(i2 / 2);
                AppMethodBeat.o(48606);
                return;
            } else if (!this.nTn) {
                this.nTn = true;
                new Timer(true).scheduleAtFixedRate(new b(), 0, 50);
                AppMethodBeat.o(48606);
                return;
            }
        } else if (this.nTf || !this.nTi) {
            if (i2 < 100) {
                if (this.nTk.getVisibility() == 0) {
                    this.nTm.setProgress((float) (i2 / 2));
                    AppMethodBeat.o(48606);
                    return;
                }
            } else if (!this.nTo) {
                this.nTo = true;
                new Timer(true).scheduleAtFixedRate(new a(), 0, (long) (1000 / this.nTj));
            }
        } else if (i2 < 100) {
            this.nSX.setProgress(i2 / 2);
            AppMethodBeat.o(48606);
            return;
        } else if (!this.nTn) {
            this.nTn = true;
            new Timer(true).scheduleAtFixedRate(new b(), 0, 100);
            AppMethodBeat.o(48606);
            return;
        }
        AppMethodBeat.o(48606);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void yu(int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.q
    public final void vy(final int i2) {
        AppMethodBeat.i(48607);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.h.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(48595);
                Log.i("MicroMsg.AppBrandGameUILoadingSplash", "onDataTransferState  state=" + i2);
                if (i2 == 3) {
                    if (h.this.nTb) {
                        h.this.nTa.setVisibility(0);
                        h.this.nTa.setText(R.string.a0m);
                        AppMethodBeat.o(48595);
                        return;
                    }
                    h.this.nTc = this;
                }
                AppMethodBeat.o(48595);
            }
        });
        AppMethodBeat.o(48607);
    }

    public class b extends TimerTask {
        private int progress = 50;

        public b() {
        }

        public final void run() {
            AppMethodBeat.i(48601);
            if (this.progress >= 100) {
                cancel();
                AppMethodBeat.o(48601);
                return;
            }
            this.progress++;
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.h.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(48600);
                    h.this.nSX.setProgress(b.this.progress);
                    if (b.this.progress == 100) {
                        h.this.nTb = true;
                        if (h.this.nTc != null) {
                            h.this.nTc.run();
                            h.this.nTc = null;
                        }
                    }
                    AppMethodBeat.o(48600);
                }
            });
            AppMethodBeat.o(48601);
        }
    }

    public class a extends TimerTask {
        private float progress = 50.0f;

        public a() {
        }

        public final void run() {
            AppMethodBeat.i(48599);
            if (this.progress >= 100.0f) {
                cancel();
                AppMethodBeat.o(48599);
                return;
            }
            this.progress += 0.33f;
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.h.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(48598);
                    if (h.this.nTk.getVisibility() == 0) {
                        h.this.nTm.setProgress(a.this.progress);
                    }
                    AppMethodBeat.o(48598);
                }
            });
            AppMethodBeat.o(48599);
        }
    }

    static /* synthetic */ void d(h hVar) {
        AppMethodBeat.i(227606);
        if (!hVar.nTg || !hVar.nTf) {
            AppMethodBeat.o(227606);
            return;
        }
        Log.i("MicroMsg.AppBrandGameUILoadingSplash", "showCutomView");
        hVar.nTk.setVisibility(0);
        hVar.nTd.setVisibility(4);
        hVar.nTm.bringToFront();
        hVar.nSW.bringToFront();
        AppMethodBeat.o(227606);
    }

    static /* synthetic */ void j(h hVar) {
        AppMethodBeat.i(227607);
        hVar.nSX.bWT();
        AppMethodBeat.o(227607);
    }
}
