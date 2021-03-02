package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class AbstractVideoView extends RelativeLayout implements i, j.a, j.b, j.c, j.d, j.e {
    public VideoPlayerSeekBar KaT;
    protected h KaU;
    protected i.d KaV;
    private Runnable KaW;
    private i.c KaX;
    protected k KaY;
    public String TAG;
    protected boolean ZA;
    protected int bFM;
    protected MMHandler hAk;
    protected TextView hPF;
    private boolean isWaiting;
    protected Context mContext;
    protected TextView mEA;
    protected LinearLayout mEB;
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
    private View.OnClickListener mET;
    private Runnable mEU;
    protected boolean mEw;
    protected ImageView mEx;
    protected RelativeLayout mEy;
    protected ProgressBar mEz;
    public i.b pNj;
    public j qbJ;
    private b tni;

    /* access modifiers changed from: protected */
    public abstract int getReportIdkey();

    static /* synthetic */ void c(AbstractVideoView abstractVideoView) {
        Log.i(abstractVideoView.TAG, "%s reset error count ", abstractVideoView.bgQ());
        abstractVideoView.bFM = 0;
        abstractVideoView.yU((long) (abstractVideoView.getReportIdkey() + 91));
    }

    public AbstractVideoView(Context context) {
        this(context, null);
    }

    public AbstractVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.TAG = "MicroMsg.AbstractVideoView";
        this.mEw = true;
        this.mEG = true;
        this.mEH = 0;
        this.mEI = false;
        this.hAk = new MMHandler(Looper.getMainLooper()) {
            /* class com.tencent.mm.pluginsdk.ui.AbstractVideoView.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(208746);
                super.handleMessage(message);
                switch (message.what) {
                    case 1:
                        AbstractVideoView.this.mEU.run();
                        AppMethodBeat.o(208746);
                        return;
                    case 2:
                        AbstractVideoView.this.KaW.run();
                        break;
                }
                AppMethodBeat.o(208746);
            }
        };
        this.mEJ = 0;
        this.mEK = true;
        this.mEL = -1;
        this.bFM = 0;
        this.mEM = false;
        this.ZA = false;
        this.mEN = 0;
        this.mEO = 0;
        this.mEP = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.pluginsdk.ui.AbstractVideoView.AnonymousClass5 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(133983);
                if (!AbstractVideoView.this.isPlaying()) {
                    AppMethodBeat.o(133983);
                    return false;
                }
                if (AbstractVideoView.this.mEI) {
                    if (AbstractVideoView.this.pNj != null) {
                        AbstractVideoView.this.pNj.dK(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
                    }
                    AbstractVideoView.this.mEI = false;
                }
                AbstractVideoView.this.xI(AbstractVideoView.this.getCurrPosSec());
                AbstractVideoView.this.hP(AbstractVideoView.this.isPlaying());
                if (AbstractVideoView.this.dUD()) {
                    boolean gop = AbstractVideoView.this.gop();
                    AppMethodBeat.o(133983);
                    return gop;
                }
                AppMethodBeat.o(133983);
                return true;
            }
        }, true);
        this.mEQ = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.pluginsdk.ui.AbstractVideoView.AnonymousClass6 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(133984);
                boolean isPlaying = AbstractVideoView.this.isPlaying();
                int currPosMs = AbstractVideoView.this.getCurrPosMs();
                Log.i(AbstractVideoView.this.TAG, "%s prepare start checker isplaying[%b] currPosMs[%d]", AbstractVideoView.this.bgQ(), Boolean.valueOf(isPlaying), Integer.valueOf(currPosMs));
                if (AbstractVideoView.this.qbJ != null && currPosMs <= 50) {
                    AbstractVideoView.this.qbJ.q(0.0d);
                }
                AppMethodBeat.o(133984);
                return false;
            }
        }, false);
        this.mER = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.pluginsdk.ui.AbstractVideoView.AnonymousClass7 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(208748);
                if (AbstractVideoView.this.bFM <= 0) {
                    AppMethodBeat.o(208748);
                    return false;
                } else if (AbstractVideoView.this.isPlaying()) {
                    AbstractVideoView.c(AbstractVideoView.this);
                    AppMethodBeat.o(208748);
                    return false;
                } else {
                    AppMethodBeat.o(208748);
                    return true;
                }
            }
        }, true);
        this.tni = flf();
        this.mET = new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.AbstractVideoView.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(208750);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/pluginsdk/ui/AbstractVideoView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i(AbstractVideoView.this.TAG, "%s seek bar play button on click ", AbstractVideoView.this.bgQ());
                AbstractVideoView abstractVideoView = AbstractVideoView.this;
                if (abstractVideoView.qbJ != null) {
                    if (abstractVideoView.isPlaying()) {
                        abstractVideoView.pause();
                    } else if (Util.isNullOrNil(abstractVideoView.qbJ.getVideoPath())) {
                        abstractVideoView.start();
                    } else {
                        abstractVideoView.play();
                    }
                }
                a.a(this, "com/tencent/mm/pluginsdk/ui/AbstractVideoView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208750);
            }
        };
        this.isWaiting = false;
        this.mEU = new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.AbstractVideoView.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(133988);
                AbstractVideoView.this.isWaiting = true;
                if (!(AbstractVideoView.this.mEz == null || AbstractVideoView.this.mEz.getVisibility() == 0)) {
                    Log.i(AbstractVideoView.this.TAG, "%s show loading", AbstractVideoView.this.bgQ());
                    AbstractVideoView.this.mEz.setVisibility(0);
                }
                if (AbstractVideoView.this.pNj != null) {
                    AbstractVideoView.this.pNj.dL(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
                }
                AppMethodBeat.o(133988);
            }
        };
        this.KaW = new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.AbstractVideoView.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(133989);
                if (!AbstractVideoView.this.isWaiting) {
                    AppMethodBeat.o(133989);
                    return;
                }
                AbstractVideoView.this.isWaiting = false;
                if (AbstractVideoView.this.pNj != null) {
                    AbstractVideoView.this.pNj.dM(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
                }
                if (!(AbstractVideoView.this.mEz == null || AbstractVideoView.this.mEz.getVisibility() == 8)) {
                    Log.i(AbstractVideoView.this.TAG, "%s hide loading", AbstractVideoView.this.bgQ());
                    AbstractVideoView.this.mEz.setVisibility(8);
                }
                AppMethodBeat.o(133989);
            }
        };
        this.KaX = null;
        this.KaY = new k();
        this.mContext = context;
        initView();
    }

    /* access modifiers changed from: protected */
    public j di(Context context) {
        return null;
    }

    /* access modifiers changed from: protected */
    public int dEP() {
        return R.layout.vl;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        Log.i(this.TAG, "%s init view ", bgQ());
        LayoutInflater.from(this.mContext).inflate(dEP(), this);
        this.mEx = (ImageView) findViewById(R.id.j6m);
        this.mEy = (RelativeLayout) findViewById(R.id.j6e);
        this.hPF = (TextView) findViewById(R.id.j4l);
        this.mEz = (ProgressBar) findViewById(R.id.j59);
        this.mEA = (TextView) findViewById(R.id.j6r);
        this.mEB = (LinearLayout) findViewById(R.id.j4y);
        VideoPlayerSeekBar videoPlayerSeekBar = (VideoPlayerSeekBar) findViewById(R.id.j5y);
        this.KaT = videoPlayerSeekBar;
        this.KaU = videoPlayerSeekBar;
        if (this.KaT != null) {
            this.KaT.setIplaySeekCallback(this.tni);
            this.KaT.setOnClickListener(this.mET);
        }
        this.qbJ = di(this.mContext);
        this.qbJ.setVideoCallback(this);
        this.qbJ.setOnSeekCompleteCallback(this);
        this.qbJ.setOnInfoCallback(this);
        this.qbJ.setOnSurfaceCallback(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.mEy.addView((View) this.qbJ, 0, layoutParams);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setVideoFooterView(h hVar) {
        if (!(hVar instanceof View)) {
            Log.w(this.TAG, "%s set video footer view but is not view", bgQ());
            return;
        }
        dFl();
        this.KaU = hVar;
        this.mEG = false;
        this.mEB.addView((View) this.KaU);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void dFl() {
        if (this.KaU != null) {
            this.mEB.removeView((View) this.KaU);
        }
    }

    /* access modifiers changed from: protected */
    public void xv(int i2) {
        if (this.KaU != null) {
            this.KaU.xv(i2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void hP(boolean z) {
        if (this.KaU != null) {
            this.KaU.hP(z);
        }
    }

    /* access modifiers changed from: protected */
    public void setVideoTotalTime(int i2) {
        if (this.KaU != null && this.KaU.getVideoTotalTime() != i2) {
            this.KaU.setVideoTotalTime(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void fO(boolean z) {
        Log.d(this.TAG, "%s start timer rightNow[%b]", bgQ(), Boolean.valueOf(z));
        this.mEP.startTimer(500);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getCacheTimeSec() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void stopTimer() {
        this.mEP.stopTimer();
        this.mEQ.stopTimer();
    }

    public final void xI(int i2) {
        xv(i2);
    }

    /* access modifiers changed from: protected */
    public b flf() {
        return new b() {
            /* class com.tencent.mm.pluginsdk.ui.AbstractVideoView.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void aJq() {
            }

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void rk(int i2) {
                AppMethodBeat.i(208749);
                if (AbstractVideoView.this.c((double) i2, true)) {
                    AbstractVideoView.this.fO(false);
                }
                if (AbstractVideoView.this.KaT != null) {
                    AbstractVideoView.this.KaT.setIsPlay(true);
                }
                AppMethodBeat.o(208749);
            }
        };
    }

    /* access modifiers changed from: protected */
    public void showLoading() {
        BT(500);
    }

    /* access modifiers changed from: protected */
    public void BT(long j2) {
        if (!this.hAk.hasMessages(1) && !this.isWaiting) {
            this.hAk.sendEmptyMessageDelayed(1, j2);
        }
    }

    /* access modifiers changed from: protected */
    public void hideLoading() {
        this.hAk.removeMessages(1);
        this.hAk.sendEmptyMessage(2);
    }

    /* access modifiers changed from: protected */
    public final void goo() {
        this.hAk.post(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.AbstractVideoView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(133981);
                if (!(AbstractVideoView.this.mEB == null || AbstractVideoView.this.mEB.getVisibility() == 8)) {
                    AbstractVideoView.this.mEB.setVisibility(8);
                }
                AppMethodBeat.o(133981);
            }
        });
    }

    public String bgQ() {
        return new StringBuilder().append(hashCode()).toString();
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getPlayerType() {
        return this.mEJ;
    }

    public int getVideoSource() {
        return 0;
    }

    public boolean play() {
        if (!this.mEw) {
            Log.w(this.TAG, "%s ui on pause now, why u call me to play? [%s]", bgQ(), Util.getStack());
            return false;
        }
        yU((long) (getReportIdkey() + 3));
        if (this.qbJ == null) {
            return false;
        }
        boolean start = this.qbJ.start();
        Log.i(this.TAG, "%s video play [%b] isPlayOnUiPause[%b]", bgQ(), Boolean.valueOf(start), Boolean.valueOf(this.mEI));
        hP(start);
        if (start) {
            this.mEI = false;
            fO(false);
            if (this.pNj != null) {
                this.pNj.dK(getSessionId(), getMediaId());
            }
        }
        return start;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public boolean pause() {
        Log.i(this.TAG, "%s pause", bgQ());
        yU((long) (getReportIdkey() + 4));
        if (this.qbJ == null) {
            return false;
        }
        hP(false);
        this.qbJ.pause();
        stopTimer();
        if (this.pNj != null) {
            this.pNj.dJ(getSessionId(), getMediaId());
        }
        this.KaY.Euv = Util.nowMilliSecond();
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public boolean p(double d2) {
        return c(d2, isPlaying());
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public boolean c(double d2, boolean z) {
        boolean z2;
        boolean asa = asa();
        int videoDurationSec = getVideoDurationSec();
        int i2 = (int) d2;
        if (videoDurationSec > 0 && d2 > ((double) videoDurationSec)) {
            i2 = videoDurationSec;
        }
        if (this.qbJ != null) {
            z2 = !Util.isNullOrNil(this.qbJ.getVideoPath());
        } else {
            z2 = false;
        }
        Log.printInfoStack(this.TAG, "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", bgQ(), Integer.valueOf(i2), Double.valueOf(d2), Boolean.valueOf(z), Boolean.valueOf(asa), Integer.valueOf(videoDurationSec), Boolean.valueOf(z2));
        yU((long) (getReportIdkey() + 5));
        if (!asa) {
            this.mEL = i2;
            if (z2) {
                this.mEK = true;
            } else {
                this.mEK = z;
                start();
            }
        } else if (this.qbJ != null) {
            showLoading();
            xv(i2);
            this.qbJ.d((double) (i2 * 1000), z);
            return z;
        }
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getVideoDurationSec() {
        if (this.qbJ != null) {
            return Math.round((((float) this.qbJ.getDuration()) * 1.0f) / 1000.0f);
        }
        return -1;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getCurrPosMs() {
        if (this.qbJ != null) {
            return this.qbJ.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getCurrPosSec() {
        if (this.qbJ != null) {
            return Math.round((((float) this.qbJ.getCurrentPosition()) * 1.0f) / 1000.0f);
        }
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public boolean isPlaying() {
        boolean z;
        if (this.qbJ != null) {
            z = this.qbJ.isPlaying();
        } else {
            z = false;
        }
        Log.i(this.TAG, "%s is playing[%b]", bgQ(), Boolean.valueOf(z));
        return z;
    }

    /* access modifiers changed from: protected */
    public final boolean asa() {
        boolean z;
        if (this.qbJ != null) {
            z = !Util.isNullOrNil(this.qbJ.getVideoPath()) && this.ZA;
        } else {
            z = false;
        }
        Log.d(this.TAG, "%s is prepared [%b] isPrepared[%b]", bgQ(), Boolean.valueOf(z), Boolean.valueOf(this.ZA));
        return z;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setIsShowBasicControls(boolean z) {
        Log.i(this.TAG, "%s is show seek bar[%b]", bgQ(), Boolean.valueOf(z));
        this.mEF = z;
        if (this.mEF) {
            this.hAk.post(new Runnable() {
                /* class com.tencent.mm.pluginsdk.ui.AbstractVideoView.AnonymousClass12 */

                public final void run() {
                    AppMethodBeat.i(133990);
                    if (!(AbstractVideoView.this.mEB == null || AbstractVideoView.this.mEB.getVisibility() == 0)) {
                        AbstractVideoView.this.mEB.setVisibility(0);
                    }
                    AppMethodBeat.o(133990);
                }
            });
        } else {
            goo();
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setCover(Bitmap bitmap) {
        Log.i(this.TAG, "%s set cover", bgQ());
        if (bitmap != null && !bitmap.isRecycled() && this.mEx != null) {
            this.mEx.setImageBitmap(bitmap);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setFullDirection(int i2) {
    }

    public void setIMMVideoViewCallback(i.b bVar) {
        this.pNj = bVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setLoopCompletionCallback(i.d dVar) {
        this.KaV = dVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void stop() {
        long j2;
        int i2;
        int i3;
        Log.i(this.TAG, "%s stop", bgQ());
        yU((long) (getReportIdkey() + 6));
        if (this.qbJ != null) {
            this.qbJ.stop();
        }
        this.mEL = -1;
        this.mEK = true;
        this.ZA = false;
        this.mEO = 0;
        this.mEN = 0;
        stopTimer();
        this.hAk.postDelayed(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.AbstractVideoView.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(133982);
                try {
                    AbstractVideoView.this.xI(0);
                    AbstractVideoView.this.hP(AbstractVideoView.this.isPlaying());
                    AppMethodBeat.o(133982);
                } catch (Throwable th) {
                    AppMethodBeat.o(133982);
                }
            }
        }, 10);
        this.KaY.mNx = Util.nowMilliSecond();
        if (this.KaY.blockCount > 0) {
            if (NetStatusUtil.isWifi(this.mContext)) {
                i2 = 41;
                i3 = 45;
            } else if (NetStatusUtil.is4G(this.mContext)) {
                i2 = 46;
                i3 = 50;
            } else if (NetStatusUtil.is3G(this.mContext)) {
                i2 = 51;
                i3 = 55;
            } else if (NetStatusUtil.is2G(this.mContext)) {
                i2 = 56;
                i3 = 60;
            }
            int nullAsNil = Util.nullAsNil((Integer) e.a(this.KaY.blockCount, new int[]{1, 2, 3, 4}, i2 + getReportIdkey(), i3 + getReportIdkey()));
            Log.d(this.TAG, "%s rptBlockCount [%d]", bgQ(), Integer.valueOf(nullAsNil));
            yU((long) nullAsNil);
        }
        if (this.KaY.mvz != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.KaY.mvz).append(",");
            stringBuffer.append(this.KaY.KcW).append(",");
            stringBuffer.append(this.KaY.mNx).append(",");
            stringBuffer.append(this.KaY.Euv).append(",");
            stringBuffer.append(this.KaY.KcX).append(",");
            stringBuffer.append(this.KaY.KcY).append(",");
            stringBuffer.append(this.KaY.KcZ).append(",");
            stringBuffer.append(this.KaY.blockCount).append(",");
            stringBuffer.append(this.KaY.KcW > 0 ? this.KaY.KcW - this.KaY.mvz : 0).append(",");
            stringBuffer.append(this.KaY.url).append(",");
            stringBuffer.append(this.KaY.duration).append(",");
            stringBuffer.append(this.KaY.mNz).append(",");
            stringBuffer.append(this.KaY.mNA).append(",");
            stringBuffer.append(this.KaY.Eut).append(",");
            if (this.KaY.Eut > this.KaY.mvz) {
                j2 = this.KaY.Eut - this.KaY.mvz;
            } else {
                j2 = 0;
            }
            stringBuffer.append(j2).append(",");
            stringBuffer.append(getPlayerType()).append(",");
            stringBuffer.append(getVideoSource());
            String stringBuffer2 = stringBuffer.toString();
            Log.i(this.TAG, "%s rpt video kv stat{%s}", bgQ(), stringBuffer2);
            if (this.KaX != null) {
                this.KaX.DX(stringBuffer2);
            }
            k kVar = this.KaY;
            kVar.mvz = 0;
            kVar.KcW = 0;
            kVar.mNx = 0;
            kVar.Euv = 0;
            kVar.KcX = 0;
            kVar.KcY = 0;
            kVar.KcZ = 0;
            kVar.blockCount = 0;
            kVar.url = "";
            kVar.duration = 0;
            kVar.mNz = 0;
            kVar.mNA = 0;
            kVar.Eut = 0;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setMute(boolean z) {
        if (this.qbJ != null) {
            this.qbJ.setMute(z);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void onUIResume() {
        Log.i(this.TAG, "%s onUIResume %s", bgQ(), Util.getStack());
        this.mEw = true;
        yU((long) (getReportIdkey() + 10));
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void onUIPause() {
        Log.i(this.TAG, "%s onUIPause %s", bgQ(), Util.getStack());
        this.mEH = getCurrPosSec();
        this.mEI = isPlaying();
        this.mEO = 0;
        this.mEN = 0;
        pause();
        stopTimer();
        this.mEw = false;
        yU((long) (getReportIdkey() + 11));
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void onUIDestroy() {
        Log.i(this.TAG, "%s onUIDestroy", bgQ());
        stop();
        this.hAk.removeCallbacksAndMessages(null);
        stopTimer();
        this.mER.stopTimer();
        yU((long) (getReportIdkey() + 12));
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public void onError(int i2, int i3) {
        String str;
        Log.w(this.TAG, "%s onError info [%d %d] errorCount[%d]", bgQ(), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.bFM));
        yU((long) (getReportIdkey() + 90));
        this.bFM++;
        if (this.bFM > 5) {
            yU((long) (getReportIdkey() + 92));
            this.KaY.mNz = i2;
            this.KaY.mNA = i3;
            if (this.pNj != null) {
                i.b bVar = this.pNj;
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
                bVar.c(sessionId, mediaId, str, i2, i3);
            }
            stop();
            hideLoading();
            return;
        }
        int currPosSec = getCurrPosSec();
        final int i4 = this.mEL == -1 ? currPosSec : this.mEL;
        Log.i(this.TAG, "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", bgQ(), Integer.valueOf(i4), Integer.valueOf(this.mEL), Integer.valueOf(currPosSec));
        stop();
        showLoading();
        this.hAk.postDelayed(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.AbstractVideoView.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(208747);
                AbstractVideoView.this.mEM = true;
                AbstractVideoView.this.xI(i4);
                AbstractVideoView.this.c((double) i4, true);
                AbstractVideoView.this.mEM = false;
                AppMethodBeat.o(208747);
            }
        }, 200);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void tf() {
        int i2;
        int i3;
        Log.i(this.TAG, "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", bgQ(), Boolean.valueOf(this.mEK), Integer.valueOf(this.mEL), Boolean.valueOf(this.ZA));
        this.ZA = true;
        if (this.qbJ != null) {
            this.qbJ.setOneTimeVideoTextureUpdateCallback(this);
        }
        setVideoTotalTime(getVideoDurationSec());
        if (!this.mEK) {
            c(this.mEL < 0 ? 0.0d : (double) this.mEL, this.mEK);
        } else if (this.mEL < 0) {
            if (play() && efT()) {
                this.mEQ.startTimer(1000);
            }
        } else if (!isLive()) {
            c((double) this.mEL, this.mEK);
        } else {
            play();
        }
        this.mEL = -1;
        this.mEK = true;
        this.mEO = 0;
        this.mEN = 0;
        if (this.pNj != null) {
            this.pNj.dH(getSessionId(), getMediaId());
        }
        if (this.bFM > 0) {
            Log.d(this.TAG, "%s start error check timer", bgQ());
            this.mER.startTimer(5000);
        }
        yU((long) (getReportIdkey() + 2));
        if (this.KaY.KcW == 0) {
            this.KaY.KcW = Util.nowMilliSecond();
        }
        this.KaY.duration = getVideoDurationSec();
        if (this.KaY.mvz > 0 && this.KaY.KcW > 0) {
            int i4 = (int) ((this.KaY.KcW - this.KaY.mvz) / 1000);
            if (NetStatusUtil.isWifi(this.mContext)) {
                i2 = 20;
                i3 = 24;
            } else if (NetStatusUtil.is4G(this.mContext)) {
                i2 = 25;
                i3 = 29;
            } else if (NetStatusUtil.is3G(this.mContext)) {
                i2 = 30;
                i3 = 34;
            } else if (NetStatusUtil.is2G(this.mContext)) {
                i2 = 35;
                i3 = 39;
            } else {
                return;
            }
            int nullAsNil = Util.nullAsNil((Integer) e.a(i4, new int[]{1, 2, 3, 4}, i2 + getReportIdkey(), i3 + getReportIdkey()));
            Log.d(this.TAG, "%s rptFirstPlayTime [%d]", bgQ(), Integer.valueOf(nullAsNil));
            yU((long) nullAsNil);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.e
    public void bLh() {
        Log.i(this.TAG, "%s onTextureUpdate ", bgQ());
        hideLoading();
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public void onCompletion() {
        Log.i(this.TAG, "%s onCompletion, curMs %d, duration %d", bgQ(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()));
        xv(getVideoDurationSec());
        hideLoading();
        stopTimer();
        if (this.pNj != null) {
            this.pNj.dI(getSessionId(), getMediaId());
        }
        this.mEO = 0;
        this.mEN = 0;
        yU((long) (getReportIdkey() + 7));
    }

    public void fdO() {
        try {
            if (this.KaV != null) {
                this.KaV.fdO();
            }
        } catch (Throwable th) {
            Log.e(this.TAG, th.toString());
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final int fh(int i2, int i3) {
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public void eo(int i2, int i3) {
        Log.i(this.TAG, "%s on get video size [%d, %d]", bgQ(), Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.pNj != null) {
            this.pNj.d(getSessionId(), getMediaId(), i2, i3);
        }
        yU((long) (getReportIdkey() + 8));
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.c
    public void fN(boolean z) {
        Log.i(this.TAG, "%s on seek complete startPlay[%b]", bgQ(), Boolean.valueOf(z));
        if (this.qbJ != null) {
            this.qbJ.setOneTimeVideoTextureUpdateCallback(this);
        }
        hideLoading();
        hP(z);
        xv(getCurrPosSec());
        if (z) {
            fO(false);
            this.mEI = false;
            if (this.pNj != null) {
                this.pNj.dK(getSessionId(), getMediaId());
            }
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.d
    public void bgX() {
        Log.i(this.TAG, "%s on surface available", bgQ());
        fO(false);
    }

    public final boolean gop() {
        long lastSurfaceUpdateTime = this.qbJ.getLastSurfaceUpdateTime();
        int currentPosition = this.qbJ.getCurrentPosition();
        Log.d(this.TAG, "%s check surface is update surface[%d %d] playtime[%d %d]", bgQ(), Long.valueOf(this.mEN), Long.valueOf(lastSurfaceUpdateTime), Integer.valueOf(this.mEO), Integer.valueOf(currentPosition));
        if (lastSurfaceUpdateTime <= 0 || lastSurfaceUpdateTime != this.mEN || currentPosition == this.mEO) {
            this.mEN = lastSurfaceUpdateTime;
            this.mEO = currentPosition;
            return true;
        }
        Log.w(this.TAG, "%s check surface is update error", bgQ());
        c((double) (this.mEO / 1000), true);
        return false;
    }

    public boolean dUD() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean efT() {
        return true;
    }

    public void setReporter(i.c cVar) {
        this.KaX = cVar;
    }

    /* access modifiers changed from: protected */
    public final void yU(long j2) {
        if (this.KaX != null) {
            this.KaX.yU(j2);
        }
    }

    /* access modifiers changed from: protected */
    public final void fgB() {
        if (this.KaY.mvz == 0) {
            this.KaY.mvz = Util.nowMilliSecond();
        }
    }

    /* access modifiers changed from: protected */
    public final void goq() {
        if (this.KaY.Eut == 0) {
            this.KaY.Eut = Util.nowMilliSecond();
        }
    }

    /* access modifiers changed from: protected */
    public final void gor() {
        this.KaY.KcX = Util.nowMilliSecond();
    }

    /* access modifiers changed from: protected */
    public final void gos() {
        this.KaY.KcY = Util.nowMilliSecond();
        if (this.KaY.KcX > 0) {
            this.KaY.KcZ += this.KaY.KcY - this.KaY.KcX;
        }
    }

    /* access modifiers changed from: protected */
    public final void got() {
        this.KaY.blockCount++;
    }

    /* access modifiers changed from: protected */
    public final void bep(String str) {
        this.KaY.url = str;
    }

    /* access modifiers changed from: protected */
    public final void gou() {
        int i2;
        int i3;
        if (this.KaY.KcY > 0 && this.KaY.KcX > 0) {
            int i4 = (int) ((this.KaY.KcY - this.KaY.KcX) / 1000);
            if (NetStatusUtil.isWifi(this.mContext)) {
                i2 = 70;
                i3 = 74;
            } else if (NetStatusUtil.is4G(this.mContext)) {
                i2 = 75;
                i3 = 79;
            } else if (NetStatusUtil.is3G(this.mContext)) {
                i2 = 80;
                i3 = 84;
            } else if (NetStatusUtil.is2G(this.mContext)) {
                i2 = 85;
                i3 = 89;
            } else {
                return;
            }
            int nullAsNil = Util.nullAsNil((Integer) e.a(i4, new int[]{1, 2, 3, 4}, i2 + getReportIdkey(), i3 + getReportIdkey()));
            Log.d(this.TAG, "%s rptResumeTime [%d]", bgQ(), Integer.valueOf(nullAsNil));
            yU((long) nullAsNil);
        }
    }

    public String getSessionId() {
        return "";
    }

    /* access modifiers changed from: protected */
    public String getMediaId() {
        return "";
    }
}
