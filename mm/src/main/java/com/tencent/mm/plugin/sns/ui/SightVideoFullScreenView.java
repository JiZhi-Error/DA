package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.d.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.s;

public class SightVideoFullScreenView extends RelativeLayout implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener {
    private long AhP = 0;
    private int Aiv = 0;
    volatile boolean DXw = false;
    String DYR;
    VideoPlayerSeekBar EeP;
    ImageView EeQ;
    Runnable EeU = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView.AnonymousClass8 */

        public final void run() {
            AppMethodBeat.i(203371);
            SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
            AppMethodBeat.o(203371);
        }
    };
    private volatile boolean EeX = true;
    boolean EeY;
    private volatile boolean Efc = false;
    private int Efh = 0;
    private int Efi = 0;
    private int Efj = 0;
    View.OnClickListener Efl = ffU();
    ImageView Egd;
    View Ege;
    Runnable Egg = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView.AnonymousClass9 */

        public final void run() {
            AppMethodBeat.i(203372);
            SightVideoFullScreenView.this.Ege.setVisibility(8);
            AppMethodBeat.o(203372);
        }
    };
    private int Egh = 0;
    FrameLayout Esi;
    View Esj;
    View Esk;
    String Esm;
    int Esn;
    int Eso;
    String Esp;
    volatile boolean Est = false;
    private long Esu = 0;
    private a Esv;
    OfflineVideoView Ewn;
    View contentView = null;
    boolean gVd;
    volatile boolean isFirst = true;
    volatile boolean isInit = true;
    private GestureDetector jKk;
    int jqs;
    private String lPw;
    int length;
    Context mContext;
    int mEX;
    int mEY;
    b tni = ffV();
    private volatile boolean vbV = false;

    static /* synthetic */ void aA(Runnable runnable) {
        AppMethodBeat.i(203399);
        ay(runnable);
        AppMethodBeat.o(203399);
    }

    static /* synthetic */ void b(SightVideoFullScreenView sightVideoFullScreenView, boolean z) {
        AppMethodBeat.i(203398);
        sightVideoFullScreenView.vh(z);
        AppMethodBeat.o(203398);
    }

    static /* synthetic */ void c(SightVideoFullScreenView sightVideoFullScreenView, boolean z) {
        AppMethodBeat.i(203400);
        sightVideoFullScreenView.setFocus(z);
        AppMethodBeat.o(203400);
    }

    static /* synthetic */ int j(SightVideoFullScreenView sightVideoFullScreenView) {
        int i2 = sightVideoFullScreenView.Efh;
        sightVideoFullScreenView.Efh = i2 + 1;
        return i2;
    }

    static /* synthetic */ void p(SightVideoFullScreenView sightVideoFullScreenView) {
        AppMethodBeat.i(203401);
        sightVideoFullScreenView.fgM();
        AppMethodBeat.o(203401);
    }

    static /* synthetic */ int r(SightVideoFullScreenView sightVideoFullScreenView) {
        int i2 = sightVideoFullScreenView.Efi;
        sightVideoFullScreenView.Efi = i2 + 1;
        return i2;
    }

    public SightVideoFullScreenView(Context context) {
        super(context);
        AppMethodBeat.i(203373);
        this.mContext = context;
        this.jKk = new GestureDetector(this);
        AppMethodBeat.o(203373);
    }

    public SightVideoFullScreenView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(203374);
        this.mContext = context;
        this.jKk = new GestureDetector(this);
        AppMethodBeat.o(203374);
    }

    public SightVideoFullScreenView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(203375);
        this.mContext = context;
        this.jKk = new GestureDetector(this);
        AppMethodBeat.o(203375);
    }

    /* access modifiers changed from: package-private */
    public final void fda() {
        AppMethodBeat.i(203376);
        try {
            ap.aL((Activity) this.mContext);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Esj.getLayoutParams();
            layoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 64);
            layoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 64);
            ((RelativeLayout.LayoutParams) this.Esk.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
            ((RelativeLayout.LayoutParams) this.Egd.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
            ((RelativeLayout.LayoutParams) this.EeP.getLayoutParams()).width = this.mEY - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 232);
            AppMethodBeat.o(203376);
        } catch (Throwable th) {
            Log.e("SightVideoFullScreenView", th.toString());
            AppMethodBeat.o(203376);
        }
    }

    /* access modifiers changed from: package-private */
    public final void fdb() {
        AppMethodBeat.i(203377);
        try {
            ap.aL((Activity) this.mContext);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Esj.getLayoutParams();
            layoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 0);
            layoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 0);
            ((RelativeLayout.LayoutParams) this.Esk.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 10);
            ((RelativeLayout.LayoutParams) this.Egd.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 10);
            ((RelativeLayout.LayoutParams) this.EeP.getLayoutParams()).width = this.mEX - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 74);
            AppMethodBeat.o(203377);
        } catch (Throwable th) {
            Log.e("SightVideoFullScreenView", th.toString());
            AppMethodBeat.o(203377);
        }
    }

    public final void fcJ() {
        AppMethodBeat.i(203378);
        try {
            this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, R.raw.icon_volume_off));
            this.Ewn.setMute(true);
            this.EeY = true;
            AppMethodBeat.o(203378);
        } catch (Throwable th) {
            Log.e("SightVideoFullScreenView", th.toString());
            AppMethodBeat.o(203378);
        }
    }

    public final void fcK() {
        AppMethodBeat.i(203379);
        try {
            this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, R.raw.icon_volume_on));
            this.Ewn.setMute(false);
            this.EeY = false;
            AppMethodBeat.o(203379);
        } catch (Throwable th) {
            Log.e("SightVideoFullScreenView", th.toString());
            AppMethodBeat.o(203379);
        }
    }

    /* access modifiers changed from: package-private */
    public final void vh(boolean z) {
        AppMethodBeat.i(203380);
        try {
            this.EeP.setIsPlay(z);
            this.EeP.getPlayBtn().getLayoutParams().width = this.length;
            this.EeP.getPlayBtn().getLayoutParams().height = this.length;
            if (z) {
                Log.i("SightVideoFullScreenView", "startPlay");
                this.EeP.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, R.raw.media_player_btn_cur_status_on));
                AppMethodBeat.o(203380);
                return;
            }
            Log.i("SightVideoFullScreenView", "pausePlay");
            this.EeP.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, R.raw.media_player_btn_cur_status_off));
            AppMethodBeat.o(203380);
        } catch (Throwable th) {
            Log.e("SightVideoFullScreenView", th.toString());
            AppMethodBeat.o(203380);
        }
    }

    public final void fgL() {
        AppMethodBeat.i(203381);
        try {
            if (this.Efc) {
                Log.e("SightVideoFullScreenView", "last download fail, try again");
                this.Ewn.cWZ();
                AppMethodBeat.o(203381);
                return;
            }
            if (!this.vbV && !TextUtils.isEmpty(this.lPw)) {
                this.Ewn.asy(this.lPw);
                this.vbV = true;
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(203366);
                    try {
                        Log.i("SightVideoFullScreenView", "sightVideoStartPlay");
                        SightVideoFullScreenView.this.Ewn.start();
                        SightVideoFullScreenView.b(SightVideoFullScreenView.this, true);
                        MMHandlerThread.removeRunnable(SightVideoFullScreenView.this.Egg);
                        SightVideoFullScreenView.this.Ege.setVisibility(8);
                        AppMethodBeat.o(203366);
                    } catch (Throwable th) {
                        Log.e("SightVideoFullScreenView", th.toString());
                        AppMethodBeat.o(203366);
                    }
                }
            });
            this.AhP = System.currentTimeMillis();
            this.Aiv++;
            AppMethodBeat.o(203381);
        } catch (Throwable th) {
            Log.e("SightVideoFullScreenView", th.toString());
            AppMethodBeat.o(203381);
        }
    }

    /* access modifiers changed from: package-private */
    public final void fgM() {
        AppMethodBeat.i(203382);
        Log.d("SightVideoFullScreenView", "pause play");
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(203367);
                try {
                    Log.i("SightVideoFullScreenView", "sightVideoPausePlay");
                    SightVideoFullScreenView.this.Ewn.fgd();
                    SightVideoFullScreenView.b(SightVideoFullScreenView.this, false);
                    SightVideoFullScreenView.this.Ege.setVisibility(0);
                    SightVideoFullScreenView.aA(SightVideoFullScreenView.this.Egg);
                    AppMethodBeat.o(203367);
                } catch (Throwable th) {
                    Log.e("SightVideoFullScreenView", th.toString());
                    AppMethodBeat.o(203367);
                }
            }
        });
        if (this.AhP != 0) {
            this.Esu += System.currentTimeMillis() - this.AhP;
            this.AhP = 0;
            Log.i("SightVideoFullScreenView", "playTimeInterval update");
        }
        AppMethodBeat.o(203382);
    }

    private View.OnClickListener ffU() {
        AppMethodBeat.i(203383);
        AnonymousClass6 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(203368);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                try {
                    SightVideoFullScreenView.c(SightVideoFullScreenView.this, true);
                    if (SightVideoFullScreenView.this.Ewn.isPlaying()) {
                        SightVideoFullScreenView.p(SightVideoFullScreenView.this);
                    } else {
                        if (SightVideoFullScreenView.this.EeY) {
                            SightVideoFullScreenView.this.fcJ();
                        } else {
                            SightVideoFullScreenView.this.fcK();
                        }
                        SightVideoFullScreenView.this.fgL();
                    }
                    if (SightVideoFullScreenView.this.DXw) {
                        SightVideoFullScreenView.r(SightVideoFullScreenView.this);
                    }
                } catch (Throwable th) {
                    Log.e("SightVideoFullScreenView", th.toString());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203368);
            }
        };
        AppMethodBeat.o(203383);
        return r0;
    }

    private b ffV() {
        AppMethodBeat.i(203384);
        AnonymousClass7 r0 = new b() {
            /* class com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void aJq() {
                AppMethodBeat.i(203369);
                try {
                    if (SightVideoFullScreenView.this.Ewn != null) {
                        SightVideoFullScreenView.this.Ewn.fgd();
                    }
                    SightVideoFullScreenView.c(SightVideoFullScreenView.this, true);
                    AppMethodBeat.o(203369);
                } catch (Throwable th) {
                    Log.e("SightVideoFullScreenView", th.toString());
                    AppMethodBeat.o(203369);
                }
            }

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void rk(int i2) {
                AppMethodBeat.i(203370);
                try {
                    Log.i("SightVideoFullScreenView", "onSeek time ".concat(String.valueOf(i2)));
                    if (SightVideoFullScreenView.this.EeY) {
                        SightVideoFullScreenView.this.fcJ();
                    } else {
                        SightVideoFullScreenView.this.fcK();
                    }
                    SightVideoFullScreenView.this.Ewn.aU(i2 * 1000, true);
                    SightVideoFullScreenView.b(SightVideoFullScreenView.this, true);
                    MMHandlerThread.removeRunnable(SightVideoFullScreenView.this.Egg);
                    SightVideoFullScreenView.this.Ege.setVisibility(8);
                    AppMethodBeat.o(203370);
                } catch (Throwable th) {
                    Log.e("SightVideoFullScreenView", th.toString());
                    AppMethodBeat.o(203370);
                }
            }
        };
        AppMethodBeat.o(203384);
        return r0;
    }

    public final Intent fgN() {
        AppMethodBeat.i(203385);
        Intent intent = new Intent();
        try {
            if (this.Ewn.isPlaying() && this.AhP != 0) {
                this.Esu += System.currentTimeMillis() - this.AhP;
                this.AhP = 0;
                Log.i("SightVideoFullScreenView", "playTimeInterval update");
            }
            intent.putExtra("KComponentVideoType", this.jqs);
            intent.putExtra("KComponentCid", this.Esm);
            intent.putExtra("KComponentCurrentTime", this.Ewn.getCurrentPositionMs());
            intent.putExtra("KComponentVoiceType", this.EeY);
            intent.putExtra("KComponentProgressType", this.Ewn.isPlaying());
            intent.putExtra("KComponentClickPlayControlCount", this.Efi);
            intent.putExtra("KComponentDoubleClickCount", this.Egh);
            intent.putExtra("KComponentClickVoiceControlCount", this.Efj);
            intent.putExtra("KComponentPlayCompletedCount", this.Efh);
            intent.putExtra("KComponentPlayCount", this.Aiv);
            intent.putExtra("KComponentPlayTimeInterval", this.Esu);
        } catch (Throwable th) {
            Log.e("SightVideoFullScreenView", th.toString());
        }
        AppMethodBeat.o(203385);
        return intent;
    }

    public void onClick(View view) {
        AppMethodBeat.i(203386);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
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
            Log.e("SightVideoFullScreenView", th.toString());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203386);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(203387);
        super.onConfigurationChanged(configuration);
        try {
            if (configuration.orientation == 2) {
                Log.i("SightVideoFullScreenView", "ORIENTATION_LANDSCAPE");
                fda();
                AppMethodBeat.o(203387);
                return;
            }
            if (configuration.orientation == 1) {
                Log.i("SightVideoFullScreenView", "ORIENTATION_PORTRAIT");
                fdb();
            }
            AppMethodBeat.o(203387);
        } catch (Throwable th) {
            Log.e("SightVideoFullScreenView", th.toString());
            AppMethodBeat.o(203387);
        }
    }

    /* access modifiers changed from: package-private */
    public void setFocus(boolean z) {
        AppMethodBeat.i(203388);
        if (z) {
            try {
                if (this.Esv != null) {
                    this.Esv.vB(true);
                }
                this.EeP.setVisibility(0);
                this.EeQ.setVisibility(0);
                this.Egd.setVisibility(0);
                ay(this.EeU);
                AppMethodBeat.o(203388);
            } catch (Throwable th) {
                Log.e("SightVideoFullScreenView", th.toString());
                AppMethodBeat.o(203388);
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
            AppMethodBeat.o(203388);
        }
    }

    private static void ay(Runnable runnable) {
        AppMethodBeat.i(203389);
        try {
            MMHandlerThread.removeRunnable(runnable);
            MMHandlerThread.postToMainThreadDelayed(runnable, 4000);
            AppMethodBeat.o(203389);
        } catch (Throwable th) {
            Log.e("SightVideoFullScreenView", th.toString());
            AppMethodBeat.o(203389);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(203390);
        GestureDetector gestureDetector = this.jKk;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(203390);
        return a2;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        AppMethodBeat.i(203391);
        try {
            Log.i("SightVideoFullScreenView", "onSingleTapConfirmed");
            if (!this.EeX) {
                this.EeX = true;
                setFocus(true);
            } else {
                this.EeX = false;
                setFocus(false);
            }
        } catch (Throwable th) {
            Log.e("SightVideoFullScreenView", th.toString());
        }
        AppMethodBeat.o(203391);
        return false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        AppMethodBeat.i(203392);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        try {
            Log.i("SightVideoFullScreenView", "onDoubleTap");
            this.Egh++;
            ay(this.EeU);
            if (this.Ewn.isPlaying()) {
                fgM();
            } else {
                if (this.EeY) {
                    fcJ();
                } else {
                    fcK();
                }
                fgL();
            }
        } catch (Throwable th) {
            Log.e("SightVideoFullScreenView", th.toString());
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(203392);
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
        AppMethodBeat.i(203393);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(203393);
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(203394);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(203394);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public void setProgressBarStatusListener(a aVar) {
        this.Esv = aVar;
    }

    static /* synthetic */ void i(SightVideoFullScreenView sightVideoFullScreenView) {
        AppMethodBeat.i(203395);
        try {
            String kz = h.kz("adId", sightVideoFullScreenView.DYR);
            if (s.YS(kz)) {
                sightVideoFullScreenView.Ewn.aQV(kz);
                AppMethodBeat.o(203395);
                return;
            }
            h.a("adId", sightVideoFullScreenView.DYR, false, 1000000001, new f.a() {
                /* class com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWN() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWO() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void aNH(String str) {
                    AppMethodBeat.i(203357);
                    try {
                        SightVideoFullScreenView.this.Ewn.aQV(str);
                        AppMethodBeat.o(203357);
                    } catch (Throwable th) {
                        Log.e("SightVideoFullScreenView", th.toString());
                        AppMethodBeat.o(203357);
                    }
                }
            });
            AppMethodBeat.o(203395);
        } catch (Throwable th) {
            Log.e("SightVideoFullScreenView", th.toString());
            AppMethodBeat.o(203395);
        }
    }

    static /* synthetic */ void k(SightVideoFullScreenView sightVideoFullScreenView) {
        AppMethodBeat.i(203396);
        try {
            sightVideoFullScreenView.Ewn.aT(0, true);
            AppMethodBeat.o(203396);
        } catch (Throwable th) {
            Log.e("SightVideoFullScreenView", th.toString());
            AppMethodBeat.o(203396);
        }
    }

    static /* synthetic */ void a(SightVideoFullScreenView sightVideoFullScreenView, final int i2) {
        AppMethodBeat.i(203397);
        try {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(203365);
                    SightVideoFullScreenView.this.EeP.seek(i2);
                    SightVideoFullScreenView.b(SightVideoFullScreenView.this, SightVideoFullScreenView.this.Ewn.isPlaying());
                    AppMethodBeat.o(203365);
                }
            });
            AppMethodBeat.o(203397);
        } catch (Throwable th) {
            Log.e("SightVideoFullScreenView", th.toString());
            AppMethodBeat.o(203397);
        }
    }
}
