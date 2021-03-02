package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class AbstractVideoView extends RelativeLayout implements e, a.AbstractC0719a, a.b, a.c, a.d, a.e {
    protected boolean ZA;
    protected int bFM;
    protected MMHandler hAk;
    protected TextView hPF;
    private boolean isWaiting;
    protected Context mContext;
    protected TextView mEA;
    protected LinearLayout mEB;
    protected VideoPlayerSeekBar mEC;
    protected e.b mED;
    protected a mEE;
    protected boolean mEF;
    protected boolean mEG;
    protected int mEH;
    protected boolean mEI;
    protected int mEJ;
    protected boolean mEK;
    protected int mEL;
    protected boolean mEM;
    protected long mEN;
    protected int mEO;
    protected MTimerHandler mEP;
    protected MTimerHandler mEQ;
    protected MTimerHandler mER;
    private e.d mES;
    private View.OnClickListener mET;
    private Runnable mEU;
    protected boolean mEw;
    protected ImageView mEx;
    protected RelativeLayout mEy;
    protected ProgressBar mEz;
    protected e.c mwz;

    public AbstractVideoView(Context context) {
        this(context, null);
    }

    public AbstractVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mEw = true;
        this.mEG = true;
        this.mEH = 0;
        this.mEI = false;
        this.hAk = new MMHandler(Looper.getMainLooper());
        this.mEJ = 0;
        this.mEK = true;
        this.mEL = -1;
        this.bFM = 0;
        this.mEM = false;
        this.ZA = false;
        this.mEN = 0;
        this.mEO = 0;
        this.mEP = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(235178);
                if (!AbstractVideoView.this.isPlaying()) {
                    AppMethodBeat.o(235178);
                    return false;
                }
                if (AbstractVideoView.this.mEI) {
                    if (AbstractVideoView.this.mwz != null) {
                        AbstractVideoView.this.mwz.dK(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
                    }
                    AbstractVideoView.this.mEI = false;
                }
                AbstractVideoView.this.xI(AbstractVideoView.this.getCurrPosSec());
                AbstractVideoView.this.hP(AbstractVideoView.this.isPlaying());
                AppMethodBeat.o(235178);
                return true;
            }
        }, true);
        this.mEQ = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.AnonymousClass4 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(235181);
                boolean isPlaying = AbstractVideoView.this.isPlaying();
                int currPosMs = AbstractVideoView.this.getCurrPosMs();
                Log.i("MicroMsg.Video.AbstractVideoView", "%s prepare start checker isplaying[%b] currPosMs[%d]", AbstractVideoView.this.bgQ(), Boolean.valueOf(isPlaying), Integer.valueOf(currPosMs));
                if (AbstractVideoView.this.mEE != null && currPosMs <= 50) {
                    AbstractVideoView.this.mEE.q(0.0d);
                }
                AppMethodBeat.o(235181);
                return false;
            }
        }, false);
        this.mER = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.AnonymousClass5 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(235182);
                if (AbstractVideoView.this.bFM <= 0) {
                    AppMethodBeat.o(235182);
                    return false;
                } else if (AbstractVideoView.this.isPlaying()) {
                    AbstractVideoView.a(AbstractVideoView.this);
                    AppMethodBeat.o(235182);
                    return false;
                } else {
                    AppMethodBeat.o(235182);
                    return true;
                }
            }
        }, true);
        this.mES = new e.d() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.d
            public final void aJq() {
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.d
            public final void rk(int i2) {
                AppMethodBeat.i(235183);
                if (AbstractVideoView.this.c((double) i2, true)) {
                    AbstractVideoView.this.bLf();
                }
                if (AbstractVideoView.this.mEC != null) {
                    AbstractVideoView.this.mEC.setIsPlay(true);
                }
                AppMethodBeat.o(235183);
            }
        };
        this.mET = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(235184);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/videoview/AbstractVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.Video.AbstractVideoView", "%s seek bar play button on click ", AbstractVideoView.this.bgQ());
                AbstractVideoView.this.bLg();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/videoview/AbstractVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235184);
            }
        };
        this.isWaiting = false;
        this.mEU = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(235185);
                AbstractVideoView.this.isWaiting = true;
                if (!(AbstractVideoView.this.mEz == null || AbstractVideoView.this.mEz.getVisibility() == 0)) {
                    Log.i("MicroMsg.Video.AbstractVideoView", "%s show loading", AbstractVideoView.this.bgQ());
                    AbstractVideoView.this.mEz.setVisibility(0);
                }
                if (AbstractVideoView.this.mwz != null) {
                    AbstractVideoView.this.mwz.dL(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
                }
                AppMethodBeat.o(235185);
            }
        };
        this.mContext = context;
        Log.i("MicroMsg.Video.AbstractVideoView", "%s init abstract video view", bgQ());
        LayoutInflater.from(this.mContext).inflate(R.layout.cx, this);
        this.mEx = (ImageView) findViewById(R.id.j6m);
        this.mEy = (RelativeLayout) findViewById(R.id.j6e);
        this.hPF = (TextView) findViewById(R.id.j4l);
        this.mEz = (ProgressBar) findViewById(R.id.j59);
        this.mEA = (TextView) findViewById(R.id.j6r);
        this.mEB = (LinearLayout) findViewById(R.id.j4y);
        VideoPlayerSeekBar videoPlayerSeekBar = (VideoPlayerSeekBar) findViewById(R.id.j5y);
        this.mEC = videoPlayerSeekBar;
        this.mED = videoPlayerSeekBar;
        if (this.mEC != null) {
            this.mEC.setIplaySeekCallback(this.mES);
            this.mEC.setOnClickListener(this.mET);
        }
        this.mEE = dZ(this.mContext);
        this.mEE.setVideoCallback(this);
        this.mEE.setOnSeekCompleteCallback(this);
        this.mEE.setOnInfoCallback(this);
        this.mEE.setOnSurfaceCallback(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.mEy.addView((View) this.mEE, 0, layoutParams);
    }

    /* access modifiers changed from: protected */
    public a dZ(Context context) {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void setVideoFooterView(e.b bVar) {
        if (!(bVar instanceof View)) {
            Log.w("MicroMsg.Video.AbstractVideoView", "%s set video footer view but is not view", bgQ());
            return;
        }
        if (this.mED != null) {
            this.mEB.removeView((View) this.mED);
        }
        this.mED = bVar;
        this.mEG = false;
        this.mEB.addView((View) this.mED);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void hP(boolean z) {
        if (this.mED != null) {
            this.mED.hP(z);
        }
    }

    /* access modifiers changed from: protected */
    public void setVideoTotalTime(int i2) {
        if (this.mED != null && this.mED.getVideoTotalTime() != i2) {
            this.mED.setVideoTotalTime(i2);
        }
    }

    /* access modifiers changed from: protected */
    public final void bLf() {
        Log.d("MicroMsg.Video.AbstractVideoView", "%s start timer rightNow[%b]", bgQ(), Boolean.FALSE);
        this.mEP.startTimer(500);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public int getCacheTimeSec() {
        return 0;
    }

    private void stopTimer() {
        this.mEP.stopTimer();
        this.mEQ.stopTimer();
    }

    /* access modifiers changed from: protected */
    public void hideLoading() {
        this.hAk.removeCallbacks(this.mEU);
        this.hAk.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(235186);
                if (!AbstractVideoView.this.isWaiting) {
                    AppMethodBeat.o(235186);
                    return;
                }
                AbstractVideoView.this.isWaiting = false;
                if (AbstractVideoView.this.mwz != null) {
                    AbstractVideoView.this.mwz.dM(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
                }
                if (!(AbstractVideoView.this.mEz == null || AbstractVideoView.this.mEz.getVisibility() == 8)) {
                    Log.i("MicroMsg.Video.AbstractVideoView", "%s hide loading", AbstractVideoView.this.bgQ());
                    AbstractVideoView.this.mEz.setVisibility(8);
                }
                AppMethodBeat.o(235186);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final String bgQ() {
        return new StringBuilder().append(hashCode()).toString();
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public int getPlayerType() {
        return this.mEJ;
    }

    public int getVideoSource() {
        return 0;
    }

    public final boolean bLg() {
        if (this.mEE == null) {
            return false;
        }
        if (isPlaying()) {
            pause();
        } else if (Util.isNullOrNil(this.mEE.getVideoPath())) {
            start();
        } else {
            play();
        }
        return true;
    }

    public final boolean play() {
        if (!this.mEw) {
            Log.w("MicroMsg.Video.AbstractVideoView", "%s ui on pause now, why u call me to play? [%s]", bgQ(), Util.getStack());
            return false;
        } else if (this.mEE == null) {
            return false;
        } else {
            boolean start = this.mEE.start();
            Log.i("MicroMsg.Video.AbstractVideoView", "%s video play [%b] isPlayOnUiPause[%b]", bgQ(), Boolean.valueOf(start), Boolean.valueOf(this.mEI));
            hP(start);
            if (start) {
                this.mEI = false;
                bLf();
                if (this.mwz != null) {
                    this.mwz.dK(getSessionId(), getMediaId());
                }
            }
            return start;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean pause() {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s pause", bgQ());
        if (this.mEE == null) {
            return false;
        }
        hP(false);
        this.mEE.pause();
        stopTimer();
        if (this.mwz == null) {
            return true;
        }
        this.mwz.dJ(getSessionId(), getMediaId());
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean p(double d2) {
        return c(d2, isPlaying());
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public boolean c(double d2, boolean z) {
        boolean z2;
        boolean asa = asa();
        int videoDurationSec = getVideoDurationSec();
        int i2 = (int) d2;
        if (videoDurationSec > 0 && d2 > ((double) videoDurationSec)) {
            i2 = videoDurationSec;
        }
        if (this.mEE != null) {
            z2 = !Util.isNullOrNil(this.mEE.getVideoPath());
        } else {
            z2 = false;
        }
        Log.printInfoStack("MicroMsg.Video.AbstractVideoView", "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", bgQ(), Integer.valueOf(i2), Double.valueOf(d2), Boolean.valueOf(z), Boolean.valueOf(asa), Integer.valueOf(videoDurationSec), Boolean.valueOf(z2));
        if (!asa) {
            this.mEL = i2;
            this.mEK = z;
        } else if (this.mEE != null) {
            showLoading();
            xI(i2);
            this.mEE.d((double) (i2 * 1000), z);
            return z;
        }
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public int getVideoDurationSec() {
        if (this.mEE != null) {
            return Math.round((((float) this.mEE.getDuration()) * 1.0f) / 1000.0f);
        }
        return -1;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public int getCurrPosMs() {
        if (this.mEE != null) {
            return this.mEE.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public int getCurrPosSec() {
        if (this.mEE != null) {
            return Math.round((((float) this.mEE.getCurrentPosition()) * 1.0f) / 1000.0f);
        }
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean isPlaying() {
        if (this.mEE != null) {
            return this.mEE.isPlaying();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean asa() {
        if (this.mEE == null || Util.isNullOrNil(this.mEE.getVideoPath()) || !this.ZA) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void setIsShowBasicControls(boolean z) {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s is show seek bar[%b]", bgQ(), Boolean.valueOf(z));
        this.mEF = z;
        if (this.mEF) {
            this.hAk.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(235187);
                    if (!(AbstractVideoView.this.mEB == null || AbstractVideoView.this.mEB.getVisibility() == 0)) {
                        AbstractVideoView.this.mEB.setVisibility(0);
                    }
                    AppMethodBeat.o(235187);
                }
            });
        } else {
            this.hAk.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.AnonymousClass11 */

                public final void run() {
                    AppMethodBeat.i(235188);
                    if (!(AbstractVideoView.this.mEB == null || AbstractVideoView.this.mEB.getVisibility() == 8)) {
                        AbstractVideoView.this.mEB.setVisibility(8);
                    }
                    AppMethodBeat.o(235188);
                }
            });
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void setCover(Bitmap bitmap) {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s set cover", bgQ());
        if (bitmap != null && !bitmap.isRecycled() && this.mEx != null) {
            this.mEx.setImageBitmap(bitmap);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void setFullDirection(int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void setIMMVideoViewCallback(e.c cVar) {
        this.mwz = cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void stop() {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s stop", bgQ());
        if (this.mEE != null) {
            this.mEE.stop();
        }
        this.mEL = -1;
        this.mEK = true;
        this.ZA = false;
        this.mEO = 0;
        this.mEN = 0;
        stopTimer();
        this.hAk.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(235179);
                try {
                    AbstractVideoView.this.xI(0);
                    AbstractVideoView.this.hP(AbstractVideoView.this.isPlaying());
                    AppMethodBeat.o(235179);
                } catch (Throwable th) {
                    AppMethodBeat.o(235179);
                }
            }
        }, 10);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void setMute(boolean z) {
        if (this.mEE != null) {
            this.mEE.setMute(z);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void onUIResume() {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s onUIResume %s", bgQ(), Util.getStack());
        this.mEw = true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void onUIPause() {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s onUIPause %s", bgQ(), Util.getStack());
        this.mEH = getCurrPosSec();
        this.mEI = isPlaying();
        this.mEO = 0;
        this.mEN = 0;
        pause();
        stopTimer();
        this.mEw = false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void onUIDestroy() {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s onUIDestroy", bgQ());
        stop();
        this.hAk.removeCallbacksAndMessages(null);
        stopTimer();
        this.mER.stopTimer();
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.AbstractC0719a
    public final void onError(int i2, int i3) {
        String str;
        Log.w("MicroMsg.Video.AbstractVideoView", "%s onError info [%d %d] errorCount[%d]", bgQ(), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.bFM));
        this.bFM++;
        if (this.bFM > 5) {
            if (this.mwz != null) {
                e.c cVar = this.mwz;
                String sessionId = getSessionId();
                String mediaId = getMediaId();
                if (i2 == -1010) {
                    str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
                } else if (i2 == -1007) {
                    str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
                } else if (i2 == -1004) {
                    if (!NetStatusUtil.isConnected(this.mContext)) {
                        str = "MEDIA_ERR_NETWORK";
                    } else {
                        str = "MEDIA_ERR_DECODE";
                    }
                } else if (!NetStatusUtil.isConnected(this.mContext)) {
                    str = "MEDIA_ERR_NETWORK";
                } else {
                    str = "MEDIA_ERR_DECODE";
                }
                cVar.c(sessionId, mediaId, str, i2, i3);
            }
            stop();
            hideLoading();
            return;
        }
        int currPosSec = getCurrPosSec();
        final int i4 = this.mEL == -1 ? currPosSec : this.mEL;
        Log.i("MicroMsg.Video.AbstractVideoView", "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", bgQ(), Integer.valueOf(i4), Integer.valueOf(this.mEL), Integer.valueOf(currPosSec));
        stop();
        showLoading();
        this.hAk.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(235180);
                AbstractVideoView.this.mEM = true;
                AbstractVideoView.this.xI(i4);
                AbstractVideoView.this.c((double) i4, true);
                AbstractVideoView.this.mEM = false;
                AppMethodBeat.o(235180);
            }
        }, 200);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.AbstractC0719a
    public final void tf() {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", bgQ(), Boolean.valueOf(this.mEK), Integer.valueOf(this.mEL), Boolean.valueOf(this.ZA));
        this.ZA = true;
        if (this.mEE != null) {
            this.mEE.setOneTimeVideoTextureUpdateCallback(this);
        }
        setVideoTotalTime(getVideoDurationSec());
        if (this.mEK) {
            if (this.mEL < 0) {
                if (play()) {
                    this.mEQ.startTimer(1000);
                }
            } else if (!isLive()) {
                c((double) this.mEL, this.mEK);
            } else {
                play();
            }
        } else if (this.mEL >= 0) {
            c((double) this.mEL, false);
        }
        this.mEL = -1;
        this.mEK = true;
        this.mEO = 0;
        this.mEN = 0;
        if (this.mwz != null) {
            this.mwz.dH(getSessionId(), getMediaId());
        }
        if (this.bFM > 0) {
            Log.d("MicroMsg.Video.AbstractVideoView", "%s start error check timer", bgQ());
            this.mER.startTimer(5000);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.e
    public final void bLh() {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s onTextureUpdate ", bgQ());
        hideLoading();
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.AbstractC0719a
    public void onCompletion() {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s onCompletion, curMs %d, duration %d", bgQ(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()));
        xI(getVideoDurationSec());
        hideLoading();
        stopTimer();
        if (this.mwz != null) {
            this.mwz.dI(getSessionId(), getMediaId());
        }
        this.mEO = 0;
        this.mEN = 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.AbstractC0719a
    public final void eo(int i2, int i3) {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s on get video size [%d, %d]", bgQ(), Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.mwz != null) {
            this.mwz.d(getSessionId(), getMediaId(), i2, i3);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c
    public final void fN(boolean z) {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s on seek complete startPlay[%b]", bgQ(), Boolean.valueOf(z));
        if (this.mEE != null) {
            this.mEE.setOneTimeVideoTextureUpdateCallback(this);
        }
        hideLoading();
        hP(z);
        xI(getCurrPosSec());
        if (z) {
            bLf();
            this.mEI = false;
            if (this.mwz != null) {
                this.mwz.dK(getSessionId(), getMediaId());
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.d
    public final void bgX() {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s on surface available", bgQ());
        bLf();
    }

    public String getSessionId() {
        return "";
    }

    /* access modifiers changed from: protected */
    public String getMediaId() {
        return "";
    }

    /* access modifiers changed from: protected */
    public final void xI(int i2) {
        if (this.mED != null) {
            this.mED.xv(i2);
        }
    }

    /* access modifiers changed from: protected */
    public final void showLoading() {
        this.hAk.removeCallbacks(this.mEU);
        this.hAk.postDelayed(this.mEU, 500);
    }

    static /* synthetic */ void a(AbstractVideoView abstractVideoView) {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s reset error count ", abstractVideoView.bgQ());
        abstractVideoView.bFM = 0;
    }
}
