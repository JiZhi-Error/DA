package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.ui.d.a;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class LongVideoFullScreenView extends RelativeLayout implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, i.b, i.d {
    private long AhP = 0;
    private int Aiv = 0;
    volatile boolean DXw = false;
    String DYR;
    VideoPlayerSeekBar EeP;
    ImageView EeQ;
    Runnable EeU = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.LongVideoFullScreenView.AnonymousClass5 */

        public final void run() {
            AppMethodBeat.i(203267);
            LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
            AppMethodBeat.o(203267);
        }
    };
    private volatile boolean EeX = true;
    boolean EeY;
    private volatile boolean Efc = false;
    private int Efh = 0;
    private int Efi = 0;
    private int Efj = 0;
    View.OnClickListener Efl = ffU();
    int EgO;
    ImageView Egd;
    View Ege;
    Runnable Egg = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.LongVideoFullScreenView.AnonymousClass6 */

        public final void run() {
            AppMethodBeat.i(203268);
            try {
                LongVideoFullScreenView.this.Ege.setVisibility(8);
                AppMethodBeat.o(203268);
            } catch (Throwable th) {
                Log.e("LongVideoFullScreenView", th.toString());
                AppMethodBeat.o(203268);
            }
        }
    };
    private int Egh = 0;
    FrameLayout Esi;
    View Esj;
    View Esk;
    AdLandingVideoWrapper Esl;
    String Esm;
    int Esn;
    int Eso;
    String Esp;
    int Esq;
    private volatile boolean Esr = false;
    private volatile int Ess = 0;
    volatile boolean Est = false;
    private long Esu = 0;
    private a Esv;
    View contentView = null;
    boolean gVd;
    volatile boolean htU = true;
    volatile boolean isFirst = true;
    boolean isWaiting;
    private GestureDetector jKk;
    int jqs;
    int length;
    Context mContext;
    int mEX;
    int mEY;
    b tni = ffV();

    static /* synthetic */ void a(LongVideoFullScreenView longVideoFullScreenView, boolean z) {
        AppMethodBeat.i(203295);
        longVideoFullScreenView.vh(z);
        AppMethodBeat.o(203295);
    }

    static /* synthetic */ void az(Runnable runnable) {
        AppMethodBeat.i(203296);
        ay(runnable);
        AppMethodBeat.o(203296);
    }

    static /* synthetic */ void b(LongVideoFullScreenView longVideoFullScreenView, boolean z) {
        AppMethodBeat.i(203297);
        longVideoFullScreenView.setFocus(z);
        AppMethodBeat.o(203297);
    }

    static /* synthetic */ int k(LongVideoFullScreenView longVideoFullScreenView) {
        int i2 = longVideoFullScreenView.Aiv;
        longVideoFullScreenView.Aiv = i2 + 1;
        return i2;
    }

    static /* synthetic */ void n(LongVideoFullScreenView longVideoFullScreenView) {
        AppMethodBeat.i(203298);
        longVideoFullScreenView.cXa();
        AppMethodBeat.o(203298);
    }

    static /* synthetic */ void p(LongVideoFullScreenView longVideoFullScreenView) {
        AppMethodBeat.i(203299);
        longVideoFullScreenView.czw();
        AppMethodBeat.o(203299);
    }

    static /* synthetic */ int r(LongVideoFullScreenView longVideoFullScreenView) {
        int i2 = longVideoFullScreenView.Efi;
        longVideoFullScreenView.Efi = i2 + 1;
        return i2;
    }

    public LongVideoFullScreenView(Context context) {
        super(context);
        AppMethodBeat.i(203269);
        this.mContext = context;
        this.jKk = new GestureDetector(this);
        AppMethodBeat.o(203269);
    }

    public LongVideoFullScreenView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(203270);
        this.mContext = context;
        this.jKk = new GestureDetector(this);
        AppMethodBeat.o(203270);
    }

    public LongVideoFullScreenView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(203271);
        this.mContext = context;
        this.jKk = new GestureDetector(this);
        AppMethodBeat.o(203271);
    }

    /* access modifiers changed from: package-private */
    public final void fda() {
        AppMethodBeat.i(203272);
        try {
            ViewParent parent = this.EeP.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.EeP);
            }
            ap.aL((Activity) this.mContext);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Esj.getLayoutParams();
            layoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 64);
            layoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 64);
            ((RelativeLayout.LayoutParams) this.Esk.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
            ((RelativeLayout.LayoutParams) this.Egd.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
            ((ViewGroup) this.Esj).addView(this.EeP, new RelativeLayout.LayoutParams(this.mEY - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 232), -2));
            AppMethodBeat.o(203272);
        } catch (Throwable th) {
            Log.e("LongVideoFullScreenView", th.toString());
            AppMethodBeat.o(203272);
        }
    }

    /* access modifiers changed from: package-private */
    public final void fdb() {
        AppMethodBeat.i(203273);
        try {
            ViewParent parent = this.EeP.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.EeP);
            }
            ap.aL((Activity) this.mContext);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Esj.getLayoutParams();
            layoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 0);
            layoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 0);
            ((RelativeLayout.LayoutParams) this.Esk.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 10);
            ((RelativeLayout.LayoutParams) this.Egd.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 10);
            ((ViewGroup) this.Esj).addView(this.EeP, new RelativeLayout.LayoutParams(this.mEX - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 74), -2));
            AppMethodBeat.o(203273);
        } catch (Throwable th) {
            Log.e("LongVideoFullScreenView", th.toString());
            AppMethodBeat.o(203273);
        }
    }

    public void onClick(View view) {
        AppMethodBeat.i(203274);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        try {
            if (view.getId() == R.id.hw8) {
                this.Efj++;
                setFocus(true);
                if (this.EeY) {
                    fcK();
                } else {
                    fcJ();
                }
            } else if (view.getId() == R.id.hw7) {
                MMHandlerThread.removeRunnable(this.Egg);
                this.Ege.setVisibility(8);
                ((Activity) this.mContext).finish();
            }
        } catch (Throwable th) {
            Log.e("LongVideoFullScreenView", th.toString());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203274);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(203275);
        super.onConfigurationChanged(configuration);
        try {
            if (configuration.orientation == 2) {
                Log.i("LongVideoFullScreenView", "ORIENTATION_LANDSCAPE");
                fda();
                AppMethodBeat.o(203275);
                return;
            }
            if (configuration.orientation == 1) {
                Log.i("LongVideoFullScreenView", "ORIENTATION_PORTRAIT");
                fdb();
            }
            AppMethodBeat.o(203275);
        } catch (Throwable th) {
            Log.e("LongVideoFullScreenView", th.toString());
            AppMethodBeat.o(203275);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dH(String str, String str2) {
        this.Efc = false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dI(String str, String str2) {
        AppMethodBeat.i(203276);
        try {
            this.Efh++;
            this.Esl.Ehq.stopTimer();
            this.Esl.onUIPause();
            AppMethodBeat.o(203276);
        } catch (Throwable th) {
            Log.e("LongVideoFullScreenView", th.toString());
            AppMethodBeat.o(203276);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.d
    public final void fdO() {
        AppMethodBeat.i(203277);
        try {
            if (this.Esl.getCurrPosSec() >= this.Eso) {
                Log.i("LongVideoFullScreenView", "onLoopCompletion");
                this.Efh++;
                this.Esl.c(0.0d, true);
            }
            AppMethodBeat.o(203277);
        } catch (Throwable th) {
            Log.e("LongVideoFullScreenView", th.toString());
            AppMethodBeat.o(203277);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dJ(String str, String str2) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dK(String str, String str2) {
        AppMethodBeat.i(203278);
        try {
            MMHandlerThread.removeRunnable(this.Egg);
            this.Ege.setVisibility(8);
            vh(true);
            AppMethodBeat.o(203278);
        } catch (Throwable th) {
            Log.e("LongVideoFullScreenView", th.toString());
            AppMethodBeat.o(203278);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void d(String str, String str2, int i2, int i3) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void c(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(203279);
        Log.e("LongVideoFullScreenView", "online play error, %s", str3);
        this.Efc = true;
        AppMethodBeat.o(203279);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dL(String str, String str2) {
        this.Esr = true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dM(String str, String str2) {
        this.Esr = false;
        this.Ess = 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void fo(String str, String str2) {
    }

    private void vh(boolean z) {
        AppMethodBeat.i(203280);
        try {
            this.EeP.setIsPlay(z);
            this.EeP.getPlayBtn().getLayoutParams().width = this.length;
            this.EeP.getPlayBtn().getLayoutParams().height = this.length;
            if (z) {
                Log.i("LongVideoFullScreenView", "startPlay");
                this.EeP.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, R.raw.media_player_btn_cur_status_on));
                AppMethodBeat.o(203280);
                return;
            }
            Log.i("LongVideoFullScreenView", "pausePlay");
            this.EeP.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, R.raw.media_player_btn_cur_status_off));
            AppMethodBeat.o(203280);
        } catch (Throwable th) {
            Log.e("LongVideoFullScreenView", th.toString());
            AppMethodBeat.o(203280);
        }
    }

    /* access modifiers changed from: package-private */
    public final void czw() {
        AppMethodBeat.i(203281);
        try {
            Log.i("LongVideoFullScreenView", "starting play, downFailed=" + this.Efc);
            if (this.Efc) {
                try {
                    Log.e("LongVideoFullScreenView", "last download fail ,try again");
                    if (!(this.EeP == null || this.EeP.getParent() == null)) {
                        ((ViewGroup) this.EeP.getParent()).removeView(this.EeP);
                    }
                    this.Esl.setFullScreen(true);
                    this.Esl.c(false, this.Esp, 0);
                    if (this.mContext.getResources().getConfiguration().orientation == 2) {
                        Log.i("LongVideoFullScreenView", "ORIENTATION_LANDSCAPE");
                        fda();
                    } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                        Log.i("LongVideoFullScreenView", "ORIENTATION_PORTRAIT");
                        fdb();
                    }
                    this.Esl.c(0.0d, true);
                    this.Esl.fdQ();
                    AppMethodBeat.o(203281);
                    return;
                } catch (Throwable th) {
                    Log.e("LongVideoFullScreenView", th.toString());
                }
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.LongVideoFullScreenView.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(203262);
                    try {
                        if (LongVideoFullScreenView.this.htU) {
                            LongVideoFullScreenView.this.htU = false;
                            if (LongVideoFullScreenView.this.isWaiting) {
                                if (LongVideoFullScreenView.this.EgO <= 0 || LongVideoFullScreenView.this.EgO > LongVideoFullScreenView.this.Eso) {
                                    LongVideoFullScreenView.this.EeP.seek(0);
                                    LongVideoFullScreenView.this.Esl.c(0.0d, true);
                                } else {
                                    LongVideoFullScreenView.this.EeP.seek(LongVideoFullScreenView.this.Esq);
                                    LongVideoFullScreenView.this.Esl.c((double) LongVideoFullScreenView.this.Esq, true);
                                }
                                LongVideoFullScreenView.this.AhP = System.currentTimeMillis();
                                LongVideoFullScreenView.a(LongVideoFullScreenView.this, true);
                                AppMethodBeat.o(203262);
                                return;
                            }
                            if (LongVideoFullScreenView.this.Esn >= LongVideoFullScreenView.this.Eso || LongVideoFullScreenView.this.Esn < 0) {
                                LongVideoFullScreenView.this.EeP.seek(0);
                                LongVideoFullScreenView.this.Esl.c(0.0d, LongVideoFullScreenView.this.gVd);
                            } else {
                                LongVideoFullScreenView.this.EeP.seek(LongVideoFullScreenView.this.Esn / 1000);
                                LongVideoFullScreenView.this.Esl.c((double) LongVideoFullScreenView.this.Esn, LongVideoFullScreenView.this.gVd);
                            }
                            LongVideoFullScreenView.this.AhP = System.currentTimeMillis();
                            LongVideoFullScreenView.a(LongVideoFullScreenView.this, LongVideoFullScreenView.this.gVd);
                            LongVideoFullScreenView.this.Esl.fdQ();
                            AppMethodBeat.o(203262);
                            return;
                        }
                        if (!LongVideoFullScreenView.this.Esl.isPlaying()) {
                            if (LongVideoFullScreenView.this.Esl.getCurrPosSec() == LongVideoFullScreenView.this.Esl.getVideoDurationSec()) {
                                LongVideoFullScreenView.this.Esl.c(0.0d, true);
                            } else {
                                LongVideoFullScreenView.this.Esl.c((double) LongVideoFullScreenView.this.Esl.getCurrPosSec(), true);
                            }
                            LongVideoFullScreenView.a(LongVideoFullScreenView.this, true);
                            LongVideoFullScreenView.this.Esl.fdQ();
                        }
                        LongVideoFullScreenView.k(LongVideoFullScreenView.this);
                        LongVideoFullScreenView.this.AhP = System.currentTimeMillis();
                        AppMethodBeat.o(203262);
                    } catch (Throwable th) {
                        Log.e("LongVideoFullScreenView", th.toString());
                        AppMethodBeat.o(203262);
                    }
                }
            });
            AppMethodBeat.o(203281);
        } catch (Throwable th2) {
            Log.e("LongVideoFullScreenView", th2.toString());
            AppMethodBeat.o(203281);
        }
    }

    /* access modifiers changed from: package-private */
    public final void cXa() {
        AppMethodBeat.i(203282);
        try {
            Log.d("LongVideoFullScreenView", "pause play");
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.LongVideoFullScreenView.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(203263);
                    try {
                        LongVideoFullScreenView.this.Esl.pause();
                        LongVideoFullScreenView.this.Ege.setVisibility(0);
                        LongVideoFullScreenView.az(LongVideoFullScreenView.this.Egg);
                        LongVideoFullScreenView.a(LongVideoFullScreenView.this, false);
                        AppMethodBeat.o(203263);
                    } catch (Throwable th) {
                        Log.e("LongVideoFullScreenView", th.toString());
                        AppMethodBeat.o(203263);
                    }
                }
            });
            if (this.AhP != 0) {
                this.Esu += System.currentTimeMillis() - this.AhP;
                this.AhP = 0;
                Log.i("LongVideoFullScreenView", "playTimeInterval update");
            }
            AppMethodBeat.o(203282);
        } catch (Throwable th) {
            Log.e("LongVideoFullScreenView", th.toString());
            AppMethodBeat.o(203282);
        }
    }

    public final void fcJ() {
        AppMethodBeat.i(203283);
        try {
            this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, R.raw.icon_volume_off));
            this.Esl.setMute(true);
            this.EeY = true;
            AppMethodBeat.o(203283);
        } catch (Throwable th) {
            Log.e("LongVideoFullScreenView", th.toString());
            AppMethodBeat.o(203283);
        }
    }

    public final void fcK() {
        AppMethodBeat.i(203284);
        try {
            this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, R.raw.icon_volume_on));
            this.Esl.setMute(false);
            this.EeY = false;
            AppMethodBeat.o(203284);
        } catch (Throwable th) {
            Log.e("LongVideoFullScreenView", th.toString());
            AppMethodBeat.o(203284);
        }
    }

    private View.OnClickListener ffU() {
        AppMethodBeat.i(203285);
        AnonymousClass3 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.LongVideoFullScreenView.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(203264);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                try {
                    Log.i("LongVideoFullScreenView", "play btn onclick isPlaying[%b]", Boolean.valueOf(LongVideoFullScreenView.this.Esl.isPlaying()));
                    LongVideoFullScreenView.b(LongVideoFullScreenView.this, true);
                    if (LongVideoFullScreenView.this.Esl.isPlaying()) {
                        LongVideoFullScreenView.n(LongVideoFullScreenView.this);
                    } else {
                        if (LongVideoFullScreenView.this.EeY) {
                            LongVideoFullScreenView.this.fcJ();
                        } else {
                            LongVideoFullScreenView.this.fcK();
                        }
                        LongVideoFullScreenView.p(LongVideoFullScreenView.this);
                    }
                    if (LongVideoFullScreenView.this.DXw) {
                        LongVideoFullScreenView.r(LongVideoFullScreenView.this);
                    }
                } catch (Throwable th) {
                    Log.e("LongVideoFullScreenView", th.toString());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203264);
            }
        };
        AppMethodBeat.o(203285);
        return r0;
    }

    private b ffV() {
        AppMethodBeat.i(203286);
        AnonymousClass4 r0 = new b() {
            /* class com.tencent.mm.plugin.sns.ui.LongVideoFullScreenView.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void aJq() {
                AppMethodBeat.i(203265);
                try {
                    LongVideoFullScreenView.b(LongVideoFullScreenView.this, true);
                    AppMethodBeat.o(203265);
                } catch (Throwable th) {
                    Log.e("LongVideoFullScreenView", th.toString());
                    AppMethodBeat.o(203265);
                }
            }

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void rk(int i2) {
                AppMethodBeat.i(203266);
                try {
                    Log.i("LongVideoFullScreenView", "onSeek time ".concat(String.valueOf(i2)));
                    LongVideoFullScreenView.this.Ess = i2;
                    if (LongVideoFullScreenView.this.EeY) {
                        LongVideoFullScreenView.this.fcJ();
                    } else {
                        LongVideoFullScreenView.this.fcK();
                    }
                    LongVideoFullScreenView.this.Esl.c((double) i2, true);
                    MMHandlerThread.removeRunnable(LongVideoFullScreenView.this.Egg);
                    LongVideoFullScreenView.this.Ege.setVisibility(8);
                    AppMethodBeat.o(203266);
                } catch (Throwable th) {
                    Log.e("LongVideoFullScreenView", th.toString());
                    AppMethodBeat.o(203266);
                }
            }
        };
        AppMethodBeat.o(203286);
        return r0;
    }

    public final Intent ffW() {
        AppMethodBeat.i(203287);
        Intent intent = new Intent();
        try {
            if (this.Esl.isPlaying() && this.AhP != 0) {
                this.Esu += System.currentTimeMillis() - this.AhP;
                this.AhP = 0;
                Log.i("LongVideoFullScreenView", "playTimeInterval update");
            }
            intent.putExtra("KComponentVideoType", this.jqs);
            intent.putExtra("KComponentCid", this.Esm);
            intent.putExtra("KComponentCurrentTime", this.Esl.getCurrPosSec());
            intent.putExtra("KComponentVoiceType", this.EeY);
            intent.putExtra("KComponentProgressType", this.Esl.isPlaying());
            intent.putExtra("KComponentClickPlayControlCount", this.Efi);
            intent.putExtra("KComponentDoubleClickCount", this.Egh);
            intent.putExtra("KComponentClickVoiceControlCount", this.Efj);
            intent.putExtra("KComponentPlayCompletedCount", this.Efh);
            intent.putExtra("KComponentPlayCount", this.Aiv);
            intent.putExtra("KComponentPlayTimeInterval", this.Esu);
            intent.putExtra("KComponentIsWaiting", this.Esr);
            intent.putExtra("KComponentSeekTimeDueWaiting", this.Ess);
        } catch (Throwable th) {
            Log.e("LongVideoFullScreenView", th.toString());
        }
        AppMethodBeat.o(203287);
        return intent;
    }

    /* access modifiers changed from: package-private */
    public void setFocus(boolean z) {
        AppMethodBeat.i(203288);
        if (z) {
            try {
                if (this.Esv != null) {
                    this.Esv.vB(true);
                }
                this.EeP.setVisibility(0);
                this.EeQ.setVisibility(0);
                this.Egd.setVisibility(0);
                ay(this.EeU);
                AppMethodBeat.o(203288);
            } catch (Throwable th) {
                Log.e("LongVideoFullScreenView", th.toString());
                AppMethodBeat.o(203288);
            }
        } else {
            this.EeX = false;
            this.EeP.setVisibility(4);
            this.EeQ.setVisibility(8);
            this.Egd.setVisibility(8);
            MMHandlerThread.removeRunnable(this.EeU);
            if (this.Esv != null) {
                this.Esv.vB(false);
            }
            AppMethodBeat.o(203288);
        }
    }

    private static void ay(Runnable runnable) {
        AppMethodBeat.i(203289);
        try {
            MMHandlerThread.removeRunnable(runnable);
            MMHandlerThread.postToMainThreadDelayed(runnable, 4000);
            AppMethodBeat.o(203289);
        } catch (Throwable th) {
            Log.e("LongVideoFullScreenView", th.toString());
            AppMethodBeat.o(203289);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(203290);
        GestureDetector gestureDetector = this.jKk;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(203290);
        return a2;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        AppMethodBeat.i(203291);
        try {
            Log.i("LongVideoFullScreenView", "onSingleTapConfirmed");
            if (!this.EeX) {
                this.EeX = true;
                setFocus(true);
            } else {
                this.EeX = false;
                setFocus(false);
            }
        } catch (Throwable th) {
            Log.e("LongVideoFullScreenView", th.toString());
        }
        AppMethodBeat.o(203291);
        return false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        AppMethodBeat.i(203292);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        try {
            Log.i("LongVideoFullScreenView", "onDoubleTap");
            if (!this.Efc) {
                this.Egh++;
            }
            ay(this.EeU);
            if (this.Esl.isPlaying()) {
                cXa();
            } else {
                if (this.EeY) {
                    fcJ();
                } else {
                    fcK();
                }
                czw();
            }
        } catch (Throwable th) {
            Log.e("LongVideoFullScreenView", th.toString());
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(203292);
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(203293);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(203293);
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(203294);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(203294);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public void setProgressBarStatusListener(a aVar) {
        this.Esv = aVar;
    }
}
