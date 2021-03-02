package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public class OfflineVideoView extends RelativeLayout implements j.a {
    protected boolean EtA;
    private int EtB;
    private int EtC;
    private boolean EtD;
    private j.e EtE;
    private a Ety;
    private boolean Etz;
    private int bFM;
    private int duration;
    private boolean guh;
    private Context mContext;
    private ProgressBar mEz;
    private MMHandler qaC;
    private j qbJ;
    private MTimerHandler qbP;
    protected ImageView tiQ;
    private RelativeLayout tjk;
    protected boolean tmZ;
    private boolean tna;

    public interface a {
        boolean a(PString pString);

        void onCompletion();

        void onStart(int i2);

        void xv(int i2);
    }

    static /* synthetic */ void d(OfflineVideoView offlineVideoView) {
        AppMethodBeat.i(179156);
        offlineVideoView.hideLoading();
        AppMethodBeat.o(179156);
    }

    public OfflineVideoView(Context context) {
        this(context, null);
    }

    public OfflineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OfflineVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        boolean z;
        AppMethodBeat.i(98021);
        this.mContext = null;
        this.guh = false;
        this.tmZ = false;
        this.Etz = false;
        this.EtA = true;
        this.EtB = -1;
        this.bFM = 0;
        this.duration = 0;
        this.qaC = new MMHandler(Looper.getMainLooper());
        this.EtC = 1000;
        this.EtD = false;
        this.qbP = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.sns.ui.OfflineVideoView.AnonymousClass6 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(203316);
                if (OfflineVideoView.this.qbJ == null) {
                    AppMethodBeat.o(203316);
                    return false;
                }
                if (((View) OfflineVideoView.this.qbJ).getAlpha() < 1.0f) {
                    OfflineVideoView.this.d(true, 1.0f);
                }
                if (OfflineVideoView.this.qbJ.isPlaying()) {
                    OfflineVideoView.d(OfflineVideoView.this);
                    OfflineVideoView.this.Zz(OfflineVideoView.this.qbJ.getCurrentPosition());
                }
                AppMethodBeat.o(203316);
                return true;
            }
        }, true);
        this.EtE = new j.e() {
            /* class com.tencent.mm.plugin.sns.ui.OfflineVideoView.AnonymousClass7 */

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.e
            public final void bLh() {
                AppMethodBeat.i(203317);
                Log.i("MicroMsg.OfflineVideoView", "%d on texture update.", Integer.valueOf(OfflineVideoView.this.hashCode()));
                try {
                    OfflineVideoView.this.d(true, 1.0f);
                    AppMethodBeat.o(203317);
                } catch (Exception e2) {
                    Log.e("MicroMsg.OfflineVideoView", "texture view update. error " + e2.toString());
                    AppMethodBeat.o(203317);
                }
            }
        };
        this.mContext = context;
        Log.i("MicroMsg.OfflineVideoView", "%d ui init view.", Integer.valueOf(hashCode()));
        LayoutInflater.from(this.mContext).inflate(R.layout.by6, this);
        this.tiQ = (ImageView) findViewById(R.id.j6m);
        this.tjk = (RelativeLayout) findViewById(R.id.j6e);
        this.mEz = (ProgressBar) findViewById(R.id.j59);
        if (d.oE(18)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.tna = true;
            this.qbJ = new VideoPlayerTextureView(this.mContext);
        } else {
            this.tna = false;
            this.qbJ = new VideoTextureView(this.mContext);
        }
        this.qbJ.setVideoCallback(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.tjk.addView((View) this.qbJ, layoutParams);
        d(false, 0.0f);
        AppMethodBeat.o(98021);
    }

    public void setVideoCallback(a aVar) {
        this.Ety = aVar;
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(98022);
        this.guh = z;
        this.qbJ.setMute(this.guh);
        AppMethodBeat.o(98022);
    }

    private void onResume() {
        AppMethodBeat.i(98023);
        Log.d("MicroMsg.OfflineVideoView", "%d on resume %s", Integer.valueOf(hashCode()), Util.getStack());
        if (!this.tmZ) {
            cWZ();
        }
        this.Etz = true;
        AppMethodBeat.o(98023);
    }

    public void pause() {
        AppMethodBeat.i(179146);
        Log.i("MicroMsg.OfflineVideoView", "%d on pause %s ", Integer.valueOf(hashCode()), Util.getStack());
        if (this.qbJ.isPlaying()) {
            this.EtB = this.qbJ.getCurrentPosition();
            Log.i("MicroMsg.OfflineVideoView", "%d pause play", Integer.valueOf(hashCode()));
            this.qbJ.pause();
        }
        AppMethodBeat.o(179146);
    }

    public void start() {
        AppMethodBeat.i(179147);
        Log.i("MicroMsg.OfflineVideoView", "%d start curPos [%d], duration [%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.qbJ.getCurrentPosition()), Integer.valueOf(this.qbJ.getDuration()));
        if (!Util.isNullOrNil(this.qbJ.getVideoPath())) {
            if (this.qbJ.getCurrentPosition() >= this.qbJ.getDuration()) {
                this.qbJ.d(0.0d, true);
                if (this.Ety != null) {
                    this.Ety.onStart(this.duration);
                }
            } else {
                this.qbJ.start();
            }
            startTimer();
        }
        AppMethodBeat.o(179147);
    }

    public final void onDestroy() {
        AppMethodBeat.i(179148);
        Log.d("MicroMsg.OfflineVideoView", "%d on destroy %s", Integer.valueOf(hashCode()), Util.getStack());
        Log.i("MicroMsg.OfflineVideoView", "%d logic unInit", Integer.valueOf(hashCode()));
        this.qaC.removeCallbacksAndMessages(null);
        fgc();
        if (this.qbJ != null) {
            this.qbJ.stop();
        }
        AppMethodBeat.o(179148);
    }

    public final void cWZ() {
        AppMethodBeat.i(98024);
        if (this.Ety != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            if (this.Ety.a(pString)) {
                if (!Util.isNullOrNil(pString2.value)) {
                    aQV(pString2.value);
                }
                if (!Util.isNullOrNil(pString.value)) {
                    asy(pString.value);
                    AppMethodBeat.o(98024);
                    return;
                }
            } else {
                showLoading();
                d(false, 0.0f);
            }
            AppMethodBeat.o(98024);
            return;
        }
        Log.w("MicroMsg.OfflineVideoView", "%d toggle video but video callback is null", Integer.valueOf(hashCode()));
        AppMethodBeat.o(98024);
    }

    public final void aQV(final String str) {
        AppMethodBeat.i(98025);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(98025);
            return;
        }
        this.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.OfflineVideoView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(98013);
                if (OfflineVideoView.this.tiQ != null) {
                    Log.i("MicroMsg.OfflineVideoView", "%d fresh thumb image", Integer.valueOf(hashCode()));
                    OfflineVideoView.this.tiQ.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(str, 1.0f));
                }
                AppMethodBeat.o(98013);
            }
        });
        AppMethodBeat.o(98025);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public void onError(int i2, int i3) {
        long j2;
        int i4 = 1;
        AppMethodBeat.i(98026);
        Log.e("MicroMsg.OfflineVideoView", "%d on play video error what %d extra %d isMMVideoPlayer %b errorCount %d", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.tna), Integer.valueOf(this.bFM));
        this.bFM++;
        final String videoPath = this.qbJ.getVideoPath();
        this.qbJ.stop();
        this.tmZ = true;
        d(false, 0.0f);
        if (this.bFM <= 3) {
            this.qaC.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.OfflineVideoView.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(98014);
                    OfflineVideoView.this.asy(videoPath);
                    AppMethodBeat.o(98014);
                }
            }, 200);
            AppMethodBeat.o(98026);
            return;
        }
        try {
            if (Util.isNullOrNil(videoPath)) {
                Log.e("MicroMsg.OfflineVideoView", "onError, filepath==null");
                j2 = -1;
                i4 = 3;
            } else if (s.YS(videoPath)) {
                long boW = s.boW(videoPath);
                Log.i("MicroMsg.OfflineVideoView", "onError, fileLen=" + boW + ", delRet=" + s.deleteFile(videoPath));
                j2 = boW;
            } else {
                Log.e("MicroMsg.OfflineVideoView", "onError, file not exists");
                j2 = -1;
                i4 = 2;
            }
            if (!this.EtD) {
                com.tencent.mm.plugin.sns.data.j.b(com.tencent.mm.plugin.sns.data.j.DDW, this.tna ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO, i4, (int) j2, getClass().getSimpleName());
                this.EtD = true;
            }
            AppMethodBeat.o(98026);
        } catch (Throwable th) {
            Log.e("MicroMsg.OfflineVideoView", "onError, exp=" + th.toString());
            AppMethodBeat.o(98026);
        }
    }

    public void d(final boolean z, final float f2) {
        AppMethodBeat.i(98027);
        this.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.OfflineVideoView.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(98015);
                Log.i("MicroMsg.OfflineVideoView", "%d switch video model isVideoPlay %b %f", Integer.valueOf(OfflineVideoView.this.hashCode()), Boolean.valueOf(z), Float.valueOf(f2));
                View view = (View) OfflineVideoView.this.qbJ;
                if (z) {
                    view.setAlpha(f2);
                    view.setVisibility(0);
                    OfflineVideoView.this.tjk.setVisibility(0);
                    OfflineVideoView.this.tjk.setAlpha(f2);
                    if (((double) f2) >= 1.0d) {
                        OfflineVideoView.this.tiQ.setVisibility(8);
                        AppMethodBeat.o(98015);
                        return;
                    }
                } else {
                    view.setVisibility(0);
                    OfflineVideoView.this.tjk.setVisibility(0);
                    OfflineVideoView.this.tjk.setAlpha(0.0f);
                    OfflineVideoView.this.tiQ.setVisibility(0);
                }
                AppMethodBeat.o(98015);
            }
        });
        AppMethodBeat.o(98027);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public void tf() {
        AppMethodBeat.i(98028);
        d(true, 0.0f);
        this.tmZ = false;
        hideLoading();
        this.duration = this.qbJ.getDuration() / 1000;
        Log.i("MicroMsg.OfflineVideoView", "%d on prepared. shouldPlayWhenPrepared [%b] shouldSeekTimeWhenPrepared[%d]", Integer.valueOf(hashCode()), Boolean.valueOf(this.EtA), Integer.valueOf(this.EtB));
        if (this.EtA) {
            if (this.EtB <= 0) {
                this.qbJ.start();
            } else {
                aT(this.EtB, true);
            }
            startTimer();
            if (this.Ety != null) {
                this.Ety.onStart(this.duration);
            }
        } else {
            aT(this.EtB > 0 ? this.EtB : 0, false);
        }
        this.EtB = -1;
        AppMethodBeat.o(98028);
    }

    /* access modifiers changed from: protected */
    public void showLoading() {
        AppMethodBeat.i(98029);
        this.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.OfflineVideoView.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(98016);
                Log.i("MicroMsg.OfflineVideoView", "%d show loading. downloadMode %d", Integer.valueOf(OfflineVideoView.this.hashCode()), Integer.valueOf(OfflineVideoView.this.hashCode()));
                if (!(OfflineVideoView.this.mEz == null || OfflineVideoView.this.mEz.getVisibility() == 0)) {
                    OfflineVideoView.this.mEz.setVisibility(0);
                }
                AppMethodBeat.o(98016);
            }
        });
        AppMethodBeat.o(98029);
    }

    private void hideLoading() {
        AppMethodBeat.i(98030);
        this.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.OfflineVideoView.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(98017);
                if (!(OfflineVideoView.this.mEz == null || OfflineVideoView.this.mEz.getVisibility() == 8)) {
                    Log.i("MicroMsg.OfflineVideoView", "%d hide loading.", Integer.valueOf(OfflineVideoView.this.hashCode()));
                    OfflineVideoView.this.mEz.setVisibility(8);
                }
                AppMethodBeat.o(98017);
            }
        });
        AppMethodBeat.o(98030);
    }

    public void startTimer() {
        AppMethodBeat.i(98031);
        this.qbP.startTimer((long) this.EtC);
        AppMethodBeat.o(98031);
    }

    /* access modifiers changed from: protected */
    public void fgc() {
        AppMethodBeat.i(179149);
        this.qbP.stopTimer();
        AppMethodBeat.o(179149);
    }

    public void Zz(int i2) {
        AppMethodBeat.i(179150);
        if (this.Ety != null) {
            this.Ety.xv(i2);
        }
        AppMethodBeat.o(179150);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void onCompletion() {
        AppMethodBeat.i(98032);
        Log.i("MicroMsg.OfflineVideoView", "%d on completion", Integer.valueOf(hashCode()));
        if (this.Ety != null) {
            this.Ety.onCompletion();
        } else if (d.oF(18) || !this.tna) {
            aT(0, true);
            AppMethodBeat.o(98032);
            return;
        } else if (this.qbJ != null) {
            String videoPath = this.qbJ.getVideoPath();
            this.qbJ.stop();
            asy(videoPath);
            AppMethodBeat.o(98032);
            return;
        }
        AppMethodBeat.o(98032);
    }

    public final void asy(String str) {
        AppMethodBeat.i(98033);
        Log.i("MicroMsg.OfflineVideoView", "%d prepare video  filePath %s", Integer.valueOf(hashCode()), str);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.OfflineVideoView", "%d prepare video but filepath is null.", Integer.valueOf(hashCode()));
            AppMethodBeat.o(98033);
            return;
        }
        if (this.qbJ != null) {
            this.qbJ.setOneTimeVideoTextureUpdateCallback(this.EtE);
            this.qbJ.setVideoPath(str);
        }
        AppMethodBeat.o(98033);
    }

    public void aT(int i2, boolean z) {
        AppMethodBeat.i(98034);
        Log.i("MicroMsg.OfflineVideoView", "%d seek second %d afterSeekPlay %b", Integer.valueOf(hashCode()), Integer.valueOf(i2), Boolean.valueOf(z));
        hideLoading();
        this.qbJ.d((double) i2, z);
        startTimer();
        AppMethodBeat.o(98034);
    }

    public final void fgd() {
        AppMethodBeat.i(179151);
        Log.i("MicroMsg.OfflineVideoView", "%d pause", Integer.valueOf(hashCode()));
        Log.i("MicroMsg.OfflineVideoView", "%d on pause %s ", Integer.valueOf(hashCode()), Util.getStack());
        this.EtA = false;
        if (this.qbJ.isPlaying()) {
            this.EtB = this.qbJ.getCurrentPosition();
            Log.i("MicroMsg.OfflineVideoView", "%d pause play", Integer.valueOf(hashCode()));
            this.qbJ.pause();
        }
        hideLoading();
        fgc();
        AppMethodBeat.o(179151);
    }

    public final void fge() {
        AppMethodBeat.i(179152);
        Log.i("MicroMsg.OfflineVideoView", "%d start hasResumed[%b], curPos [%d], duration [%d], shouldSeek [%d]", Integer.valueOf(hashCode()), Boolean.valueOf(this.Etz), Integer.valueOf(this.qbJ.getCurrentPosition()), Integer.valueOf(this.qbJ.getDuration()), Integer.valueOf(this.EtB));
        this.EtA = true;
        if (!this.Etz) {
            onResume();
        } else if (Util.isNullOrNil(this.qbJ.getVideoPath())) {
            onResume();
        } else if (this.qbJ.getCurrentPosition() >= this.qbJ.getDuration()) {
            this.qbJ.d(0.0d, true);
            if (this.Ety != null) {
                this.Ety.onStart(this.duration);
            }
        } else {
            this.qbJ.start();
        }
        startTimer();
        AppMethodBeat.o(179152);
    }

    public final void aU(int i2, boolean z) {
        AppMethodBeat.i(203318);
        Log.i("MicroMsg.OfflineVideoView", "%d ui touch seek second %d afterSeekPlay %b", Integer.valueOf(hashCode()), Integer.valueOf(i2), Boolean.valueOf(z));
        aT(i2, z);
        startTimer();
        AppMethodBeat.o(203318);
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(179153);
        if (this.qbJ != null) {
            boolean isPlaying = this.qbJ.isPlaying();
            AppMethodBeat.o(179153);
            return isPlaying;
        }
        AppMethodBeat.o(179153);
        return false;
    }

    public final boolean fgf() {
        AppMethodBeat.i(179154);
        if (!(this.qbJ instanceof VideoPlayerTextureView)) {
            boolean isPlaying = isPlaying();
            AppMethodBeat.o(179154);
            return isPlaying;
        } else if (!((VideoPlayerTextureView) this.qbJ).gsG() || !isPlaying()) {
            AppMethodBeat.o(179154);
            return false;
        } else {
            AppMethodBeat.o(179154);
            return true;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final int fh(int i2, int i3) {
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void eo(int i2, int i3) {
    }

    public int getCurrentPosition() {
        AppMethodBeat.i(98035);
        if (this.qbJ != null) {
            int currentPosition = this.qbJ.getCurrentPosition() / 1000;
            AppMethodBeat.o(98035);
            return currentPosition;
        }
        AppMethodBeat.o(98035);
        return 0;
    }

    public int getCurrentPositionMs() {
        AppMethodBeat.i(98036);
        if (this.qbJ != null) {
            int currentPosition = this.qbJ.getCurrentPosition();
            AppMethodBeat.o(98036);
            return currentPosition;
        }
        AppMethodBeat.o(98036);
        return 0;
    }

    public int getDurationMs() {
        AppMethodBeat.i(98037);
        if (this.qbJ != null) {
            int duration2 = this.qbJ.getDuration();
            AppMethodBeat.o(98037);
            return duration2;
        }
        AppMethodBeat.o(98037);
        return 0;
    }

    public View getInnerVideoView() {
        if (this.qbJ instanceof View) {
            return (View) this.qbJ;
        }
        return null;
    }

    public String getVideoPath() {
        AppMethodBeat.i(179155);
        if (this.qbJ != null) {
            String videoPath = this.qbJ.getVideoPath();
            AppMethodBeat.o(179155);
            return videoPath;
        }
        AppMethodBeat.o(179155);
        return "";
    }

    public void setTimerInterval(int i2) {
        if (i2 < 200) {
            i2 = 200;
        }
        this.EtC = i2;
    }

    public int getTimerInterval() {
        return this.EtC;
    }

    public void setOnSeekCompleteCallback(j.c cVar) {
        AppMethodBeat.i(203319);
        if (this.qbJ != null) {
            this.qbJ.setOnSeekCompleteCallback(cVar);
        }
        AppMethodBeat.o(203319);
    }
}
