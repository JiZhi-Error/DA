package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.smtt.sdk.WebView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandVideoView extends RelativeLayout {
    private int add = -1;
    private int atU;
    private boolean cEK;
    private boolean cEL;
    private boolean cEZ;
    private boolean cJg = false;
    private int lXF;
    private String mAppId;
    private boolean mIsMute;
    private boolean mLoop;
    private RelativeLayout mvI;
    public e mvJ;
    private TextView mvK;
    private DanmuView mvL;
    public e.a mvM;
    private View mvN;
    private View mvO;
    private TextView mvP;
    private LinearLayout mvQ;
    private AppBrandDotPercentIndicator mvR;
    private TextView mvS;
    private ImageView mvT;
    private ImageView mvU;
    private ImageView mvV;
    private ImageView mvW;
    private FrameLayout mvX;
    private String mvY;
    private int mvZ;
    private f mwa;
    private boolean mwb;
    public b mwc;
    private boolean mwd;
    private boolean mwe;
    private com.tencent.mm.plugin.appbrand.jsapi.video.ui.a mwf;
    private a mwg;
    private boolean mwh;
    private double mwi;
    private String mwj;
    private boolean mwk;
    private boolean mwl;
    private boolean mwm;
    private boolean mwn;
    private boolean mwo;
    private int mwp;
    private String mwq;
    private boolean mwr;
    private boolean mws;
    private boolean mwt = false;
    private boolean mwu = true;
    private boolean mwv = false;
    private MTimerHandler mww;
    private int mwx = 0;
    private int mwy = WebView.NIGHT_MODE_COLOR;
    private e.c mwz;

    public interface a {
        void bGL();

        boolean isFullScreen();

        void xd(int i2);
    }

    static /* synthetic */ boolean A(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.i(234609);
        boolean isLive = appBrandVideoView.isLive();
        AppMethodBeat.o(234609);
        return isLive;
    }

    static /* synthetic */ void j(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.i(234603);
        appBrandVideoView.bIZ();
        AppMethodBeat.o(234603);
    }

    static /* synthetic */ boolean l(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.i(234604);
        boolean bJd = appBrandVideoView.bJd();
        AppMethodBeat.o(234604);
        return bJd;
    }

    static /* synthetic */ boolean s(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.i(234606);
        boolean bJe = appBrandVideoView.bJe();
        AppMethodBeat.o(234606);
        return bJe;
    }

    static /* synthetic */ String xu(int i2) {
        AppMethodBeat.i(234610);
        String xs = xs(i2);
        AppMethodBeat.o(234610);
        return xs;
    }

    static /* synthetic */ void y(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.i(234608);
        appBrandVideoView.bJg();
        AppMethodBeat.o(234608);
    }

    public <T extends View & e> AppBrandVideoView(Context context, T t) {
        super(context);
        AppMethodBeat.i(137734);
        this.mvJ = t;
        init(context);
        this.mvI.addView(t);
        AppMethodBeat.o(137734);
    }

    public <T extends View & e> AppBrandVideoView(Context context, T t, byte b2) {
        super(context);
        AppMethodBeat.i(234597);
        this.mvJ = t;
        this.mwy = WebView.NIGHT_MODE_COLOR;
        init(context);
        this.mvI.addView(t);
        AppMethodBeat.o(234597);
    }

    public AppBrandVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(137735);
        init(context);
        AppMethodBeat.o(137735);
    }

    public AppBrandVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(137736);
        init(context);
        AppMethodBeat.o(137736);
    }

    private void init(Context context) {
        AppMethodBeat.i(137737);
        LayoutInflater.from(context).inflate(R.layout.g0, this);
        setBackgroundColor(this.mwy);
        this.mvI = (RelativeLayout) findViewById(R.id.j6y);
        this.mvK = (TextView) findViewById(R.id.gl7);
        this.mvN = findViewById(R.id.bgx);
        this.mvO = findViewById(R.id.bha);
        this.mvP = (TextView) findViewById(R.id.bhe);
        this.mvQ = (LinearLayout) findViewById(R.id.i1);
        this.mvR = (AppBrandDotPercentIndicator) findViewById(R.id.i2);
        this.mvS = (TextView) findViewById(R.id.hy);
        this.mvT = (ImageView) findViewById(R.id.i0);
        this.mvU = (ImageView) findViewById(R.id.bgv);
        this.mvV = (ImageView) findViewById(R.id.gcs);
        this.mvW = (ImageView) findViewById(R.id.gcr);
        this.mvX = (FrameLayout) findViewById(R.id.gct);
        this.mvR.setDotsNum(8);
        ((ImageView) findViewById(R.id.bh_)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(137698);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AppBrandVideoView.this.start();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(137698);
            }
        });
        bIY();
        bJa();
        AppMethodBeat.o(137737);
    }

    public void setComponent(f fVar) {
        AppMethodBeat.i(137738);
        this.mwa = fVar;
        this.mAppId = fVar.getAppId();
        AppMethodBeat.o(137738);
    }

    public void setConsumeTouchEvent(boolean z) {
        AppMethodBeat.i(137739);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setConsumeTouchEvent game=%s", Boolean.valueOf(z));
        this.mwk = z;
        AppMethodBeat.o(137739);
    }

    public void setVideoPlayerId(int i2) {
        this.mvZ = i2;
    }

    public void setShowMuteBtn(boolean z) {
        AppMethodBeat.i(137740);
        Log.i("MicroMsg.Video.AppBrandVideoView", "showMuteBtn %b", Boolean.valueOf(z));
        this.mvM.setShowMuteBtn(z);
        AppMethodBeat.o(137740);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(137741);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setTitle %s", str);
        this.mvM.setTitle(str);
        AppMethodBeat.o(137741);
    }

    public void setShowControlProgress(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(137742);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setShowControlProgress %b", Boolean.valueOf(z));
        e.a aVar = this.mvM;
        if (!z || isLive()) {
            z2 = false;
        }
        aVar.setShowControlProgress(z2);
        AppMethodBeat.o(137742);
    }

    public void setPlayBtnPosition(String str) {
        AppMethodBeat.i(137743);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setPlayBtnPosition %s", str);
        if (Util.isNullOrNil(str) || !str.equalsIgnoreCase("center")) {
            this.mvM.setPlayBtnInCenterPosition(false);
            AppMethodBeat.o(137743);
            return;
        }
        this.mvM.setPlayBtnInCenterPosition(true);
        AppMethodBeat.o(137743);
    }

    public void setEnablePlayGesture(boolean z) {
        AppMethodBeat.i(137744);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setEnablePlayGesture %b", Boolean.valueOf(z));
        this.mws = z;
        AppMethodBeat.o(137744);
    }

    public void setAutoPlay(boolean z) {
        AppMethodBeat.i(137745);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setAutoPlay %b", Boolean.valueOf(z));
        this.cEZ = z;
        AppMethodBeat.o(137745);
    }

    public void setVideoSource(int i2) {
        AppMethodBeat.i(137746);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoSource %d", Integer.valueOf(i2));
        this.mwp = i2;
        AppMethodBeat.o(137746);
    }

    public void setDuration(int i2) {
        AppMethodBeat.i(137747);
        if (i2 <= 0) {
            Log.i("MicroMsg.Video.AppBrandVideoView", "setDuration error duration=%d", Integer.valueOf(i2));
            AppMethodBeat.o(137747);
            return;
        }
        this.mvP.setText(xs(i2));
        this.atU = i2;
        AppMethodBeat.o(137747);
    }

    public int getDuration() {
        AppMethodBeat.i(137748);
        if (this.atU > 0) {
            int i2 = this.atU;
            AppMethodBeat.o(137748);
            return i2;
        }
        int videoDurationSec = this.mvJ.getVideoDurationSec();
        AppMethodBeat.o(137748);
        return videoDurationSec;
    }

    public void setLoop(boolean z) {
        AppMethodBeat.i(137749);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setLoop %b", Boolean.valueOf(z));
        this.mLoop = z;
        AppMethodBeat.o(137749);
    }

    public void setAutoPauseIfNavigate(boolean z) {
        this.cEK = z;
    }

    public void setAutoPauseIfOpenNative(boolean z) {
        this.cEL = z;
    }

    public final void start() {
        AppMethodBeat.i(137750);
        Log.i("MicroMsg.Video.AppBrandVideoView", "start");
        if (!this.mwv) {
            Log.i("MicroMsg.Video.AppBrandVideoView", "start, video not prepared");
            this.cJg = true;
        } else {
            Log.i("MicroMsg.Video.AppBrandVideoView", "start, video prepared, reset control flag");
            this.cJg = false;
        }
        if (this.mvJ.isPlaying()) {
            Log.i("MicroMsg.Video.AppBrandVideoView", "start, video is playing");
            AppMethodBeat.o(137750);
            return;
        }
        if (this.mwb) {
            this.mvM.bJz();
        }
        this.mvN.setVisibility(8);
        this.mvJ.start();
        if (this.mvL != null && this.mvM.bJt()) {
            this.mvL.show();
        }
        if (com.tencent.luggage.a.e.M(h.class) != null) {
            ((h) com.tencent.luggage.a.e.M(h.class)).report(this.mwq);
        }
        AppMethodBeat.o(137750);
    }

    public final void pause() {
        AppMethodBeat.i(137751);
        Log.i("MicroMsg.Video.AppBrandVideoView", "pause");
        if (!this.mwv) {
            Log.i("MicroMsg.Video.AppBrandVideoView", "pause, video not prepared");
            this.cJg = false;
            AppMethodBeat.o(137751);
        } else if (!this.mvJ.isPlaying()) {
            Log.i("MicroMsg.Video.AppBrandVideoView", "pause, video not playing");
            AppMethodBeat.o(137751);
        } else {
            this.mvJ.pause();
            if (this.mvL != null && this.mvM.bJt()) {
                this.mvL.pause();
            }
            AppMethodBeat.o(137751);
        }
    }

    public final void stop() {
        AppMethodBeat.i(137752);
        Log.i("MicroMsg.Video.AppBrandVideoView", "stop");
        if (!this.mwv) {
            Log.i("MicroMsg.Video.AppBrandVideoView", "stop, video not prepared");
            this.cJg = false;
            AppMethodBeat.o(137752);
        } else if (!this.mvJ.isPlaying()) {
            Log.i("MicroMsg.Video.AppBrandVideoView", "stop, video not playing");
            AppMethodBeat.o(137752);
        } else {
            this.mvJ.stop();
            this.mvM.bJA();
            if (this.mvL != null) {
                this.mvL.hide();
            }
            AppMethodBeat.o(137752);
        }
    }

    public final void onUIResume() {
        AppMethodBeat.i(137753);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onUIResume");
        if (this.mwt) {
            Log.i("MicroMsg.Video.AppBrandVideoView", "onUIResume, should skip ui resume");
            this.mwt = false;
            AppMethodBeat.o(137753);
            return;
        }
        this.mvJ.onUIResume();
        AppMethodBeat.o(137753);
    }

    public final void xr(int i2) {
        AppMethodBeat.i(137754);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onUIPause, type:%d", Integer.valueOf(i2));
        if ((i2 != 2 || this.cEL) && (i2 != 1 || this.cEK)) {
            this.mvJ.onUIPause();
            AppMethodBeat.o(137754);
            return;
        }
        Log.i("MicroMsg.Video.AppBrandVideoView", "onUIPause, should skip ui pause");
        this.mwt = true;
        AppMethodBeat.o(137754);
    }

    public final void onUIDestroy() {
        AppMethodBeat.i(137755);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onUIDestroy");
        clean();
        AppMethodBeat.o(137755);
    }

    public final void clean() {
        AppMethodBeat.i(137756);
        Log.i("MicroMsg.Video.AppBrandVideoView", "clean");
        stop();
        this.mvJ.onUIDestroy();
        if (this.mvL != null) {
            this.mvL.clear();
        }
        this.mvM.onDestroy();
        bJg();
        AppMethodBeat.o(137756);
    }

    public final void e(String str, boolean z, int i2) {
        String aaT;
        AppMethodBeat.i(137757);
        if (!(this.mwa == null || this.mwa.getFileSystem() == null || !this.mwa.getFileSystem().Vi(str))) {
            o VY = this.mwa.getFileSystem().VY(str);
            str = VY == null ? null : "file://" + aa.z(VY.her());
        }
        Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath path=%s isLive=%s", str, Boolean.valueOf(z));
        if (Util.isNullOrNil(str)) {
            Log.v("MicroMsg.Video.AppBrandVideoView", "setVideoPath videoPath empty");
            AppMethodBeat.o(137757);
            return;
        }
        stop();
        this.mwh = z;
        this.mwq = str;
        this.mvJ.setVideoSource(this.mwp);
        this.mvJ.c(z, str, i2);
        if (this.mwi > 0.0d) {
            this.mvJ.c(this.mwi, this.cEZ);
        }
        if (!(this.mwp != 1 || com.tencent.luggage.a.e.M(h.class) == null || (aaT = ((h) com.tencent.luggage.a.e.M(h.class)).aaT(this.mwq)) == null)) {
            Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath localVideoPath:%s", aaT);
            String str2 = this.mwq;
            Log.i("MicroMsg.Video.AppBrandVideoView", "leonlad setPreLoadVideoPath %s", aaT);
            if (!this.mvJ.isPlaying() && this.mwq.equalsIgnoreCase(str2)) {
                this.mwq = str2;
                this.mvJ.c(this.mwh, aaT, 0);
                if (this.cEZ) {
                    Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
                    start();
                } else {
                    Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
                    bIW();
                }
            }
            if (this.mwc != null) {
                b bVar = this.mwc;
                try {
                    JSONObject bKv = bVar.bKv();
                    bKv.put("timeStamp", System.currentTimeMillis());
                    bKv.put("url", str2);
                    bVar.a(new b.a((byte) 0), bKv);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.Video.JsApiVideoCallback", "onVideoCanPlay e=%s", e2);
                }
            }
        }
        if (this.cEZ) {
            Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
            start();
        } else {
            Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
            bIW();
        }
        setCover(str);
        AppMethodBeat.o(137757);
    }

    private void bIW() {
        AppMethodBeat.i(234598);
        if (this.mvJ != null) {
            this.mvJ.bIW();
        }
        AppMethodBeat.o(234598);
    }

    public final void bIX() {
        AppMethodBeat.i(234599);
        d(0.0d, false);
        AppMethodBeat.o(234599);
    }

    public final void d(double d2, boolean z) {
        AppMethodBeat.i(137758);
        int currPosSec = this.mvJ.getCurrPosSec();
        Log.i("MicroMsg.Video.AppBrandVideoView", "seek to position=%s current=%d isLive=%b", Double.valueOf(d2), Integer.valueOf(currPosSec), Boolean.valueOf(this.mwh));
        if (isLive()) {
            AppMethodBeat.o(137758);
            return;
        }
        this.mvN.setVisibility(8);
        if (z) {
            this.mvJ.c(d2, z);
        } else {
            this.mvJ.p(d2);
        }
        if (this.mvL != null && ((double) currPosSec) > d2) {
            this.mvL.xE((int) d2);
        }
        AppMethodBeat.o(137758);
    }

    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.i(137759);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setIsShowBasicControls %b", Boolean.valueOf(z));
        this.mwb = z;
        if (this.mvM != null) {
            if (this.mwb) {
                this.mvM.bJv();
                AppMethodBeat.o(137759);
                return;
            }
            this.mvM.hide();
        }
        AppMethodBeat.o(137759);
    }

    public void setIsEnableBottomProgressBar(boolean z) {
        this.mwu = z;
    }

    public final void setCover$16da05f7(String str) {
        AppMethodBeat.i(137760);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setCover:%s", str);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(137760);
            return;
        }
        this.mwj = str;
        com.tencent.mm.modelappbrand.a.b.aXY().a(this.mvU, str, (Drawable) null, (b.h) null);
        AppMethodBeat.o(137760);
    }

    private void setCover(final String str) {
        AppMethodBeat.i(137761);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(137761);
        } else if (!Util.isNullOrNil(this.mwj)) {
            Log.i("MicroMsg.Video.AppBrandVideoView", "setCover mCoverUrl not null");
            AppMethodBeat.o(137761);
        } else {
            m.bZn().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(234569);
                    final Bitmap createVideoThumbnail = BitmapUtil.createVideoThumbnail(str, 1);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(234568);
                            if (createVideoThumbnail != null && !createVideoThumbnail.isRecycled()) {
                                AppBrandVideoView.this.mvU.setImageBitmap(createVideoThumbnail);
                            }
                            AppMethodBeat.o(234568);
                        }
                    });
                    AppMethodBeat.o(234569);
                }
            });
            AppMethodBeat.o(137761);
        }
    }

    public void setShowProgress(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(137762);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setShowProgress %b", Boolean.valueOf(z));
        this.mwm = z;
        e.a aVar = this.mvM;
        if ((!z && !this.mwn) || isLive()) {
            z2 = false;
        }
        aVar.setShowProgress(z2);
        AppMethodBeat.o(137762);
    }

    public void setShowProgressBarInControlMode(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(234600);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setShowProgressInControlMode %b", Boolean.valueOf(z));
        this.mwn = z;
        e.a aVar = this.mvM;
        if ((!this.mwm && !z) || isLive()) {
            z2 = false;
        }
        aVar.setShowProgress(z2);
        AppMethodBeat.o(234600);
    }

    public void setShowFullScreenBtn(boolean z) {
        AppMethodBeat.i(137763);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setShowFullScreenBtn %b", Boolean.valueOf(z));
        this.mvM.setShowFullScreenBtn(z);
        AppMethodBeat.o(137763);
    }

    public void setShowPlayBtn(boolean z) {
        AppMethodBeat.i(137764);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setShowPlayBtn %b", Boolean.valueOf(z));
        this.mvM.setShowPlayBtn(z);
        AppMethodBeat.o(137764);
    }

    public final void hM(boolean z) {
        AppMethodBeat.i(137765);
        Log.i("MicroMsg.Video.AppBrandVideoView", "enableProgressGesture %b", Boolean.valueOf(z));
        this.mwl = z;
        AppMethodBeat.o(137765);
    }

    public void setShowCenterPlayBtn(boolean z) {
        int i2 = 0;
        AppMethodBeat.i(137766);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setShowCenterPlayBtn %b", Boolean.valueOf(z));
        this.mwo = z;
        this.mvN.setVisibility(z ? 0 : 8);
        View view = this.mvO;
        if (!z) {
            i2 = 8;
        }
        view.setVisibility(i2);
        if (this.mwo && this.mvM != null) {
            this.mvM.hide();
        }
        AppMethodBeat.o(137766);
    }

    public void setDanmakuEnable(boolean z) {
        AppMethodBeat.i(137767);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setDanmakuEnable %b", Boolean.valueOf(z));
        this.mvM.setDanmakuBtnOpen(z);
        AppMethodBeat.o(137767);
    }

    public void setShowDanmakuBtn(boolean z) {
        AppMethodBeat.i(137768);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setShowDanmakuBtn %b", Boolean.valueOf(z));
        if (z) {
            if (this.mvL == null) {
                bJc();
            }
            this.mvM.setDanmakuBtnOnClickListener(new e.g() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.AnonymousClass9 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.g
                public final void hO(boolean z) {
                    AppMethodBeat.i(234570);
                    if (!z) {
                        AppBrandVideoView.this.mvL.hide();
                    } else if (AppBrandVideoView.this.mvJ.isPlaying()) {
                        AppBrandVideoView.this.mvL.show();
                    } else {
                        AppBrandVideoView.this.mvL.pause();
                    }
                    if (AppBrandVideoView.this.mwc != null) {
                        com.tencent.mm.plugin.appbrand.jsapi.video.c.b bVar = AppBrandVideoView.this.mwc;
                        int i2 = AppBrandVideoView.this.mvZ;
                        try {
                            Log.i("MicroMsg.Video.JsApiVideoCallback", "onVideoClickDanmuBtn showDanmu=%b", Boolean.valueOf(z));
                            JSONObject bKv = bVar.bKv();
                            bKv.put("showDanmu", z);
                            bKv.put("videoPlayerId", i2);
                            bVar.a(new b.C0712b((byte) 0), bKv);
                            AppMethodBeat.o(234570);
                            return;
                        } catch (JSONException e2) {
                            Log.e("MicroMsg.Video.JsApiVideoCallback", "onVideoClickDanmuBtn e=%s", e2);
                        }
                    }
                    AppMethodBeat.o(234570);
                }
            });
        }
        this.mvM.setShowDanmakuBtn(z);
        AppMethodBeat.o(137768);
    }

    public void setObjectFit(String str) {
        AppMethodBeat.i(137769);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setObjectFit %s", str);
        if ("fill".equalsIgnoreCase(str)) {
            this.mvJ.setScaleType(e.h.FILL);
            this.mvU.setScaleType(ImageView.ScaleType.FIT_XY);
            AppMethodBeat.o(137769);
        } else if ("cover".equalsIgnoreCase(str)) {
            this.mvJ.setScaleType(e.h.COVER);
            this.mvU.setScaleType(ImageView.ScaleType.CENTER_CROP);
            AppMethodBeat.o(137769);
        } else {
            this.mvJ.setScaleType(e.h.CONTAIN);
            this.mvU.setScaleType(ImageView.ScaleType.FIT_CENTER);
            AppMethodBeat.o(137769);
        }
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(137770);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setMute %b", Boolean.valueOf(z));
        this.mIsMute = z;
        this.mvJ.setMute(z);
        this.mvM.setMuteBtnState(z);
        AppMethodBeat.o(137770);
    }

    public void setCookieData(String str) {
        this.mvY = str;
    }

    public String getCookieData() {
        return this.mvY;
    }

    public int getCurrPosSec() {
        AppMethodBeat.i(137771);
        int currPosSec = this.mvJ.getCurrPosSec();
        AppMethodBeat.o(137771);
        return currPosSec;
    }

    public int getCurrPosMs() {
        AppMethodBeat.i(137772);
        int currPosMs = this.mvJ.getCurrPosMs();
        AppMethodBeat.o(137772);
        return currPosMs;
    }

    public int getCacheTimeSec() {
        AppMethodBeat.i(137773);
        if (this.mvJ != null) {
            int cacheTimeSec = this.mvJ.getCacheTimeSec();
            AppMethodBeat.o(137773);
            return cacheTimeSec;
        }
        AppMethodBeat.o(137773);
        return 0;
    }

    public void setFullScreenDirection(int i2) {
        AppMethodBeat.i(137774);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setFullScreenDirection %d", Integer.valueOf(i2));
        this.add = i2;
        AppMethodBeat.o(137774);
    }

    public void setFullScreenState(boolean z) {
        AppMethodBeat.i(234601);
        if (z) {
            this.mvM.KD();
            AppMethodBeat.o(234601);
            return;
        }
        this.mvM.bGL();
        AppMethodBeat.o(234601);
    }

    public void setPageGesture(boolean z) {
        AppMethodBeat.i(137775);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setPageGesture %b", Boolean.valueOf(z));
        this.mwd = z;
        AppMethodBeat.o(137775);
    }

    public void setPageGestureInFullscreen(boolean z) {
        AppMethodBeat.i(137776);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setPageGestureInFullscreen %b", Boolean.valueOf(z));
        this.mwe = z;
        AppMethodBeat.o(137776);
    }

    public void setInitialTime(double d2) {
        AppMethodBeat.i(137777);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setInitialTime %s", Double.valueOf(d2));
        this.mwi = d2;
        AppMethodBeat.o(137777);
    }

    public void setCallback(com.tencent.mm.plugin.appbrand.jsapi.video.c.b bVar) {
        this.mwc = bVar;
    }

    public void setDanmakuItemList(JSONArray jSONArray) {
        com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a aVar;
        AppMethodBeat.i(137778);
        if (jSONArray == null) {
            AppMethodBeat.o(137778);
            return;
        }
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(jSONArray != null ? jSONArray.length() : 0);
        Log.i("MicroMsg.Video.AppBrandVideoView", "setDanmakuItemList length=%d", objArr);
        if (this.mvL == null) {
            Log.w("MicroMsg.Video.AppBrandVideoView", "setDanmakuItemList mDanmakuView null");
            bJc();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject == null) {
                aVar = null;
            } else {
                int optInt = optJSONObject.optInt("time", 0);
                String optString = optJSONObject.optString("text", "");
                int afD = g.afD(optJSONObject.optString("color", ""));
                if (afD == 0) {
                    afD = -1;
                }
                aVar = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(optString), afD, optInt);
            }
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        DanmuView danmuView = this.mvL;
        danmuView.bKp();
        danmuView.clearItems();
        danmuView.mAA.clear();
        danmuView.prepare();
        if (arrayList.isEmpty()) {
            danmuView.bKq();
            AppMethodBeat.o(137778);
            return;
        }
        h.RTc.ba(new Runnable(arrayList) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.AnonymousClass4 */
            final /* synthetic */ List hjk;

            {
                this.hjk = r2;
            }

            public final void run() {
                AppMethodBeat.i(137860);
                synchronized (DanmuView.this.mAz) {
                    try {
                        DanmuView.this.mAz.addAll(this.hjk);
                    } finally {
                        AppMethodBeat.o(137860);
                    }
                }
                synchronized (DanmuView.this.mAA) {
                    try {
                        DanmuView.this.mAA.addAll(this.hjk);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                DanmuView.this.postInvalidate();
                AppMethodBeat.o(137860);
            }
        });
        danmuView.bKq();
        AppMethodBeat.o(137778);
    }

    public final boolean dG(String str, String str2) {
        AppMethodBeat.i(137779);
        if (this.mvL == null) {
            Log.w("MicroMsg.Video.AppBrandVideoView", " addDanmaku mDanmakuView null");
            bJc();
        }
        int afD = g.afD(str2);
        if (afD == 0) {
            afD = -1;
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(str), afD, this.mvJ.getCurrPosSec());
        DanmuView danmuView = this.mvL;
        synchronized (danmuView.mAz) {
            try {
                danmuView.mAz.offerFirst(aVar);
                h.RTc.b(new Runnable(aVar) {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.AnonymousClass3 */
                    final /* synthetic */ d mAH;

                    {
                        this.mAH = r2;
                    }

                    public final void run() {
                        AppMethodBeat.i(137859);
                        synchronized (DanmuView.this.mAA) {
                            int i2 = 0;
                            while (true) {
                                try {
                                    if (i2 >= DanmuView.this.mAA.size()) {
                                        break;
                                    } else if (this.mAH.bKk() <= ((d) DanmuView.this.mAA.get(i2)).bKk()) {
                                        DanmuView.this.mAA.add(i2, this.mAH);
                                        break;
                                    } else {
                                        i2++;
                                    }
                                } finally {
                                    AppMethodBeat.o(137859);
                                }
                            }
                        }
                    }
                }, "DanmuView-addItemToWaitingHead");
            } catch (Throwable th) {
                AppMethodBeat.o(137779);
                throw th;
            }
        }
        AppMethodBeat.o(137779);
        return true;
    }

    public void setFullScreenDelegate(a aVar) {
        this.mwg = aVar;
    }

    public com.tencent.mm.plugin.appbrand.jsapi.video.c.b getCallback() {
        return this.mwc;
    }

    private void bIY() {
        AppMethodBeat.i(137780);
        this.mwf = new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a(getContext(), this, new a.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.AnonymousClass10 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
            public final void bJj() {
                AppMethodBeat.i(234571);
                Log.d("MicroMsg.Video.AppBrandVideoView", "onSingleTap");
                if (AppBrandVideoView.this.mwb && AppBrandVideoView.this.mvN.getVisibility() != 0) {
                    AppBrandVideoView.this.mvM.bJu();
                    if (AppBrandVideoView.this.mwr) {
                        AppBrandVideoView.j(AppBrandVideoView.this);
                    }
                }
                AppMethodBeat.o(234571);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
            public final void bJk() {
                AppMethodBeat.i(234572);
                Log.d("MicroMsg.Video.AppBrandVideoView", "onDoubleTap");
                if (AppBrandVideoView.this.mws) {
                    if (AppBrandVideoView.this.mvJ.isPlaying()) {
                        AppBrandVideoView.this.pause();
                        AppMethodBeat.o(234572);
                        return;
                    }
                    AppBrandVideoView.this.start();
                }
                AppMethodBeat.o(234572);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
            public final void bJl() {
                AppMethodBeat.i(234573);
                if (!AppBrandVideoView.l(AppBrandVideoView.this)) {
                    AppMethodBeat.o(234573);
                    return;
                }
                AppBrandVideoView.this.mvK.setVisibility(0);
                AppBrandVideoView.j(AppBrandVideoView.this);
                AppMethodBeat.o(234573);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
            public final int k(int i2, float f2) {
                AppMethodBeat.i(234574);
                if (!AppBrandVideoView.l(AppBrandVideoView.this)) {
                    AppMethodBeat.o(234574);
                    return 0;
                }
                Log.i("MicroMsg.Video.AppBrandVideoView", "onDragProgress:" + i2 + FilePathGenerator.ANDROID_DIR_SEP + f2);
                int videoDurationSec = AppBrandVideoView.this.mvJ.getVideoDurationSec();
                int c2 = com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a.c(f2, (float) AppBrandVideoView.this.getMeasuredWidth(), getCurrentPosition(), videoDurationSec);
                AppBrandVideoView.this.mvK.setText(l.AF(((long) c2) * 1000) + FilePathGenerator.ANDROID_DIR_SEP + l.AF(((long) videoDurationSec) * 1000));
                AppBrandVideoView.this.mvM.seek(c2);
                if (AppBrandVideoView.this.mvM.bJw()) {
                    AppBrandVideoView.this.mvM.bJB();
                }
                AppMethodBeat.o(234574);
                return c2;
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
            public final void l(int i2, float f2) {
                AppMethodBeat.i(234575);
                if (!AppBrandVideoView.l(AppBrandVideoView.this)) {
                    AppMethodBeat.o(234575);
                    return;
                }
                AppBrandVideoView.this.mvK.setVisibility(8);
                AppBrandVideoView.n(AppBrandVideoView.this);
                Log.i("MicroMsg.Video.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", Integer.valueOf(i2), Integer.valueOf(AppBrandVideoView.this.mvJ.getCurrPosSec()), Float.valueOf(f2));
                AppBrandVideoView.this.d((double) i2, false);
                AppMethodBeat.o(234575);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
            public final int getCurrentPosition() {
                AppMethodBeat.i(234576);
                int currPosSec = AppBrandVideoView.this.mvJ.getCurrPosSec();
                AppMethodBeat.o(234576);
                return currPosSec;
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
            public final boolean bJo() {
                AppMethodBeat.i(263549);
                boolean s = AppBrandVideoView.s(AppBrandVideoView.this);
                AppMethodBeat.o(263549);
                return s;
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
            public final boolean bJp() {
                AppMethodBeat.i(263550);
                boolean s = AppBrandVideoView.s(AppBrandVideoView.this);
                AppMethodBeat.o(263550);
                return s;
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
            public final boolean bJq() {
                AppMethodBeat.i(234583);
                boolean l = AppBrandVideoView.l(AppBrandVideoView.this);
                AppMethodBeat.o(234583);
                return l;
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
            public final void aM(float f2) {
                AppMethodBeat.i(234577);
                if (!AppBrandVideoView.s(AppBrandVideoView.this)) {
                    AppMethodBeat.o(234577);
                    return;
                }
                Log.d("MicroMsg.Video.AppBrandVideoView", "onAdjustVolume:".concat(String.valueOf(f2)));
                AppBrandVideoView.this.mvR.setPercent(f2);
                AppBrandVideoView.this.mvS.setText(R.string.et6);
                AppBrandVideoView.this.mvT.setImageResource(R.drawable.brp);
                AppBrandVideoView.this.mvQ.setVisibility(0);
                AppBrandVideoView.j(AppBrandVideoView.this);
                AppMethodBeat.o(234577);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
            public final void aN(float f2) {
                AppMethodBeat.i(234578);
                if (!AppBrandVideoView.s(AppBrandVideoView.this)) {
                    AppMethodBeat.o(234578);
                    return;
                }
                Log.d("MicroMsg.Video.AppBrandVideoView", "onAdjustBrightness:".concat(String.valueOf(f2)));
                AppBrandVideoView.this.mvR.setPercent(f2);
                AppBrandVideoView.this.mvS.setText(R.string.et5);
                AppBrandVideoView.this.mvT.setImageResource(R.drawable.brn);
                AppBrandVideoView.this.mvQ.setVisibility(0);
                AppBrandVideoView.j(AppBrandVideoView.this);
                AppMethodBeat.o(234578);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
            public final void bJm() {
                AppMethodBeat.i(234579);
                if (!AppBrandVideoView.s(AppBrandVideoView.this)) {
                    AppMethodBeat.o(234579);
                    return;
                }
                AppBrandVideoView.this.mvQ.setVisibility(8);
                AppBrandVideoView.n(AppBrandVideoView.this);
                AppMethodBeat.o(234579);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b
            public final void bJn() {
                AppMethodBeat.i(234580);
                if (!AppBrandVideoView.s(AppBrandVideoView.this)) {
                    AppMethodBeat.o(234580);
                    return;
                }
                AppBrandVideoView.this.mvQ.setVisibility(8);
                AppBrandVideoView.n(AppBrandVideoView.this);
                AppMethodBeat.o(234580);
            }
        });
        AppMethodBeat.o(137780);
    }

    private void bIZ() {
        AppMethodBeat.i(137781);
        this.mvM.bIZ();
        AppMethodBeat.o(137781);
    }

    private void bJa() {
        AppMethodBeat.i(137782);
        this.mvJ.setIMMVideoViewCallback(new e.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.AnonymousClass11 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
            public final void c(String str, String str2, String str3, int i2, int i3) {
                AppMethodBeat.i(234584);
                Log.i("MicroMsg.Video.AppBrandVideoView", "onError errorMsg=%s what=%d extra=%d", str3, Integer.valueOf(i2), Integer.valueOf(i3));
                if (AppBrandVideoView.this.mwc != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.video.c.b bVar = AppBrandVideoView.this.mwc;
                    bVar.clean();
                    try {
                        JSONObject bKv = bVar.bKv();
                        bKv.put("errMsg", str3);
                        bVar.a(new b.d((byte) 0), bKv);
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.Video.JsApiVideoCallback", "onError e=%s", e2);
                    }
                }
                if (AppBrandVideoView.this.mwz != null) {
                    AppBrandVideoView.this.mwz.c(str, str2, str3, i2, i3);
                }
                AppMethodBeat.o(234584);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
            public final void dH(String str, String str2) {
                AppMethodBeat.i(234585);
                Log.i("MicroMsg.Video.AppBrandVideoView", "onPrepared");
                AppBrandVideoView.this.mwx = 0;
                AppBrandVideoView.u(AppBrandVideoView.this);
                AppBrandVideoView.this.mwv = true;
                if (AppBrandVideoView.this.cJg) {
                    AppBrandVideoView.this.start();
                }
                AppBrandVideoView.this.mwf.bKZ();
                if (AppBrandVideoView.this.mwc != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.video.c.b unused = AppBrandVideoView.this.mwc;
                }
                if (AppBrandVideoView.this.mwz != null) {
                    AppBrandVideoView.this.mwz.dH(str, str2);
                }
                AppMethodBeat.o(234585);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
            public final void dI(String str, String str2) {
                AppMethodBeat.i(234586);
                Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoEnded");
                AppBrandVideoView.y(AppBrandVideoView.this);
                AppBrandVideoView.this.mvK.setVisibility(8);
                AppBrandVideoView.this.mvM.setIsPlay(false);
                if (AppBrandVideoView.this.mvM.bJw() && AppBrandVideoView.this.mvM.bJy()) {
                    AppBrandVideoView.this.mvM.hide();
                }
                if (AppBrandVideoView.this.mvX.getVisibility() == 0) {
                    AppBrandVideoView.this.mvX.setVisibility(8);
                }
                if (AppBrandVideoView.A(AppBrandVideoView.this) || !AppBrandVideoView.this.mwo) {
                    AppBrandVideoView.this.mvO.setVisibility(8);
                    AppBrandVideoView.this.mvN.setVisibility(8);
                } else {
                    if (AppBrandVideoView.this.atU <= 0) {
                        AppBrandVideoView.this.mvP.setText(AppBrandVideoView.xu(AppBrandVideoView.this.mvJ.getVideoDurationSec()));
                    }
                    AppBrandVideoView.this.mvO.setVisibility(0);
                    AppBrandVideoView.this.mvN.setVisibility(0);
                }
                if (AppBrandVideoView.this.mwc != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.video.c.b bVar = AppBrandVideoView.this.mwc;
                    try {
                        bVar.a(new b.c((byte) 0), bVar.bKv());
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoEnded e=%s", e2);
                    }
                    bVar.bKw();
                }
                if (AppBrandVideoView.this.mLoop) {
                    AppBrandVideoView.this.d(0.0d, true);
                }
                if (AppBrandVideoView.this.mwz != null) {
                    AppBrandVideoView.this.mwz.dI(str, str2);
                }
                AppMethodBeat.o(234586);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
            public final void d(String str, String str2, int i2, int i3) {
                AppMethodBeat.i(234587);
                Log.i("MicroMsg.Video.AppBrandVideoView", "onGetVideoSize width=%d height=%d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (AppBrandVideoView.this.add == -1) {
                    AppBrandVideoView.this.add = i2 < i3 ? 0 : 90;
                    Log.i("MicroMsg.Video.AppBrandVideoView", "onGetVideoSize adjust direction from AUTO to %s", Integer.valueOf(AppBrandVideoView.this.add));
                }
                if (AppBrandVideoView.this.mwc != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.video.c.b bVar = AppBrandVideoView.this.mwc;
                    int duration = AppBrandVideoView.this.getDuration();
                    try {
                        Log.i("MicroMsg.Video.JsApiVideoCallback", "onVideoLoadedMetaData, width:%d, height:%d, duration:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(duration));
                        JSONObject bKv = bVar.bKv();
                        bKv.put("width", i2);
                        bKv.put("height", i3);
                        bKv.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, (((double) duration) * 1.0d) / 1000.0d);
                        bVar.a(new b.f((byte) 0), bKv);
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.Video.JsApiVideoCallback", "onVideoLoadedMetaData e=%s", e2);
                    }
                }
                if (AppBrandVideoView.this.mwz != null) {
                    AppBrandVideoView.this.mwz.d(str, str2, i2, i3);
                }
                AppMethodBeat.o(234587);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
            public final void dJ(String str, String str2) {
                AppMethodBeat.i(234588);
                Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoPause");
                if (AppBrandVideoView.this.mwc != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.video.c.b bVar = AppBrandVideoView.this.mwc;
                    try {
                        bVar.a(new b.g((byte) 0), bVar.bKv());
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoPause e=%s", e2);
                    }
                    bVar.bKw();
                }
                if (AppBrandVideoView.this.mwz != null) {
                    AppBrandVideoView.this.mwz.dJ(str, str2);
                }
                AppMethodBeat.o(234588);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
            public final void dK(String str, String str2) {
                AppMethodBeat.i(234589);
                Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoPlay, isLive:%b", Boolean.valueOf(AppBrandVideoView.A(AppBrandVideoView.this)));
                if (AppBrandVideoView.this.atU <= 0 && !AppBrandVideoView.A(AppBrandVideoView.this)) {
                    AppBrandVideoView.this.mvP.setText(AppBrandVideoView.xu(AppBrandVideoView.this.mvJ.getVideoDurationSec()));
                }
                AppBrandVideoView.a(AppBrandVideoView.this, AppBrandVideoView.A(AppBrandVideoView.this));
                if (AppBrandVideoView.this.mwb) {
                    AppBrandVideoView.H(AppBrandVideoView.this);
                }
                if (AppBrandVideoView.this.mwc != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.video.c.b bVar = AppBrandVideoView.this.mwc;
                    try {
                        bVar.mAN = 0;
                        JSONObject bKv = bVar.bKv();
                        bKv.put("timeStamp", System.currentTimeMillis());
                        bVar.a(new b.h((byte) 0), bKv);
                        if (bVar.mAM == null) {
                            bVar.mAM = new MTimerHandler(new MTimerHandler.CallBack() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.video.c.b.AnonymousClass1 */

                                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                                public final boolean onTimerExpired() {
                                    AppMethodBeat.i(234906);
                                    try {
                                        int currPosMs = b.this.mAK.getCurrPosMs();
                                        if (Math.abs(currPosMs - b.this.mAN) < 250) {
                                            AppMethodBeat.o(234906);
                                            return true;
                                        }
                                        JSONObject bKv = b.this.bKv();
                                        b.this.mAN = currPosMs;
                                        bKv.put("position", new BigDecimal((((double) currPosMs) * 1.0d) / 1000.0d).setScale(3, 4).doubleValue());
                                        bKv.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, b.this.mAK.getDuration());
                                        b.this.a(new l((byte) 0), bKv);
                                        AppMethodBeat.o(234906);
                                        return true;
                                    } catch (JSONException e2) {
                                        Log.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", e2);
                                    }
                                }
                            }, true);
                        }
                        bVar.mAM.startTimer(250);
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoPlay e=%s", e2);
                    }
                }
                if (AppBrandVideoView.this.mwa != null && "wxfe02ecfe70800f46".equalsIgnoreCase(AppBrandVideoView.this.mwa.getAppId())) {
                    Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoPlay, send play event");
                    EventCenter.instance.publish(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
                }
                if (AppBrandVideoView.this.mwz != null) {
                    AppBrandVideoView.this.mwz.dK(str, str2);
                }
                AppMethodBeat.o(234589);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
            public final void dL(String str, String str2) {
                AppMethodBeat.i(234590);
                Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoWaiting");
                if (AppBrandVideoView.this.mwc != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.video.c.b bVar = AppBrandVideoView.this.mwc;
                    try {
                        JSONObject bKv = bVar.bKv();
                        bKv.put("timeStamp", System.currentTimeMillis());
                        bVar.a(new b.m((byte) 0), bKv);
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.Video.JsApiVideoCallback", "onVideoWaiting e=%s", e2);
                    }
                }
                AppBrandVideoView.this.mwr = true;
                AppBrandVideoView.j(AppBrandVideoView.this);
                if (AppBrandVideoView.this.mwz != null) {
                    AppBrandVideoView.this.mwz.dL(str, str2);
                }
                AppMethodBeat.o(234590);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
            public final void dM(String str, String str2) {
                AppMethodBeat.i(234591);
                AppBrandVideoView.this.mwr = false;
                AppBrandVideoView.n(AppBrandVideoView.this);
                if (AppBrandVideoView.this.mwz != null) {
                    AppBrandVideoView.this.mwz.dM(str, str2);
                }
                AppMethodBeat.o(234591);
            }
        });
        AppMethodBeat.o(137782);
    }

    public void setIMMVideoViewCallback(e.c cVar) {
        this.mwz = cVar;
    }

    public final void p(boolean z, int i2) {
        int i3;
        AppMethodBeat.i(137784);
        Log.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen toFullScreen:%b direction:%d", Boolean.valueOf(z), Integer.valueOf(i2));
        if (this.mwg == null) {
            Log.w("MicroMsg.Video.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
            AppMethodBeat.o(137784);
        } else if (z == bJb()) {
            Log.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen current same");
            AppMethodBeat.o(137784);
        } else {
            if (i2 == -1) {
                i3 = this.add == -1 ? 90 : this.add;
                Log.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen target direction:%d", Integer.valueOf(i3));
            } else {
                i3 = i2;
            }
            if (z) {
                this.lXF = i3;
                this.mwg.xd(i3);
                this.mvM.KD();
                hN(true);
                AppMethodBeat.o(137784);
                return;
            }
            this.mwg.bGL();
            this.mvM.bGL();
            AppMethodBeat.o(137784);
        }
    }

    public final boolean bJb() {
        AppMethodBeat.i(137785);
        if (this.mwg == null) {
            Log.w("MicroMsg.Video.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
            AppMethodBeat.o(137785);
            return false;
        }
        boolean isFullScreen = this.mwg.isFullScreen();
        AppMethodBeat.o(137785);
        return isFullScreen;
    }

    private void bJc() {
        AppMethodBeat.i(137786);
        this.mvL = (DanmuView) findViewById(R.id.bka);
        this.mvL.setDanmuViewCallBack(new c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.AnonymousClass12 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.danmu.c
            public final int baT() {
                AppMethodBeat.i(234592);
                int currPosSec = AppBrandVideoView.this.mvJ.getCurrPosSec();
                AppMethodBeat.o(234592);
                return currPosSec;
            }
        });
        this.mvL.bKt();
        this.mvL.setMaxRunningPerRow(5);
        this.mvL.setPickItemInterval(200);
        this.mvL.hide();
        if (this.mvJ != null && ((View) this.mvJ).getHeight() > 0) {
            float yOffset = this.mvL.getYOffset();
            this.mvL.setMaxRow((int) (((float) ((int) (((float) ((View) this.mvJ).getHeight()) * yOffset))) / com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b.dW(getContext())));
        }
        AppMethodBeat.o(137786);
    }

    public final void a(e.a aVar) {
        AppMethodBeat.i(137787);
        this.mvM = aVar;
        if ((this.mvM instanceof View) && this.mvM != null) {
            View view = (View) this.mvM;
            if (view.getId() != -1) {
                view.setId(R.id.rl);
            }
        }
        this.mvM.hide();
        this.mvM.setFullScreenBtnOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(234593);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                boolean z = !AppBrandVideoView.this.bJb();
                AppBrandVideoView appBrandVideoView = AppBrandVideoView.this;
                appBrandVideoView.p(z, appBrandVideoView.add);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(234593);
            }
        });
        this.mvM.setIplaySeekCallback(new e.d() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.AnonymousClass14 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.d
            public final void aJq() {
                AppMethodBeat.i(234594);
                Log.i("MicroMsg.Video.AppBrandVideoView", "onSeekPre");
                AppMethodBeat.o(234594);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.d
            public final void rk(int i2) {
                AppMethodBeat.i(234595);
                AppBrandVideoView.this.d((double) i2, false);
                AppMethodBeat.o(234595);
            }
        });
        this.mvM.setOnPlayButtonClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(234596);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (AppBrandVideoView.this.mvJ.isPlaying()) {
                    AppBrandVideoView.this.pause();
                } else {
                    AppBrandVideoView.this.start();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(234596);
            }
        });
        this.mvM.setStatePorter(new e.i() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.i
            public final int bJh() {
                AppMethodBeat.i(234562);
                int cacheTimeSec = AppBrandVideoView.this.mvJ.getCacheTimeSec();
                AppMethodBeat.o(234562);
                return cacheTimeSec;
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.i
            public final int bJi() {
                AppMethodBeat.i(234563);
                int videoDurationSec = AppBrandVideoView.this.mvJ.getVideoDurationSec();
                AppMethodBeat.o(234563);
                return videoDurationSec;
            }
        });
        this.mvM.setMuteBtnOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(234564);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AppBrandVideoView.this.setMute(!AppBrandVideoView.this.mIsMute);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(234564);
            }
        });
        this.mvM.setExitFullScreenBtnOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(137702);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AppBrandVideoView.this.p(false, AppBrandVideoView.this.add);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(137702);
            }
        });
        this.mvM.a(new e.f() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.f
            public final void onVisibilityChanged(boolean z) {
                AppMethodBeat.i(234565);
                AppBrandVideoView.H(AppBrandVideoView.this);
                AppMethodBeat.o(234565);
            }
        });
        this.mvM.setOnUpdateProgressLenListener(new e.AbstractC0717e() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.AbstractC0717e
            public final void onProgressChanged(int i2, int i3) {
                int i4;
                AppMethodBeat.i(234566);
                if (i3 <= 0) {
                    AppMethodBeat.o(234566);
                    return;
                }
                if (i2 < 0) {
                    i4 = 0;
                } else {
                    i4 = i2;
                }
                if (i4 > i3) {
                    i4 = i3;
                }
                int width = (i4 * AppBrandVideoView.this.mvW.getWidth()) / i3;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) AppBrandVideoView.this.mvV.getLayoutParams();
                layoutParams.width = width;
                AppBrandVideoView.this.mvV.setLayoutParams(layoutParams);
                AppBrandVideoView.this.mvV.requestLayout();
                AppMethodBeat.o(234566);
            }
        });
        AppMethodBeat.o(137787);
    }

    private static String xs(int i2) {
        AppMethodBeat.i(137788);
        String str = xt(i2 / 60) + ":" + xt(i2 % 60);
        AppMethodBeat.o(137788);
        return str;
    }

    private static String xt(int i2) {
        AppMethodBeat.i(137789);
        if (i2 < 10) {
            String concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i2));
            AppMethodBeat.o(137789);
            return concat;
        }
        String valueOf = String.valueOf(i2);
        AppMethodBeat.o(137789);
        return valueOf;
    }

    public final void hN(boolean z) {
        AppMethodBeat.i(137790);
        if (this.mwc == null) {
            AppMethodBeat.o(137790);
            return;
        }
        this.mwc.c(this.mvZ, z, this.lXF);
        AppMethodBeat.o(137790);
    }

    private boolean isLive() {
        AppMethodBeat.i(137791);
        if (this.mwh || this.mvJ.isLive()) {
            AppMethodBeat.o(137791);
            return true;
        }
        AppMethodBeat.o(137791);
        return false;
    }

    private boolean bJd() {
        AppMethodBeat.i(137792);
        if (!this.mwl || this.mvJ.isLive() || bJf()) {
            AppMethodBeat.o(137792);
            return false;
        }
        AppMethodBeat.o(137792);
        return true;
    }

    private boolean bJe() {
        AppMethodBeat.i(137793);
        if (bJf() || ((bJb() || !this.mwd) && (!bJb() || !this.mwe))) {
            AppMethodBeat.o(137793);
            return false;
        }
        AppMethodBeat.o(137793);
        return true;
    }

    private boolean bJf() {
        AppMethodBeat.i(137794);
        if (this.mvN.getVisibility() == 0) {
            AppMethodBeat.o(137794);
            return true;
        }
        AppMethodBeat.o(137794);
        return false;
    }

    private void bJg() {
        AppMethodBeat.i(234602);
        if (this.mww != null) {
            this.mww.stopTimer();
        }
        AppMethodBeat.o(234602);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bJd;
        AppMethodBeat.i(137783);
        if (this.mws) {
            bJd = true;
        } else {
            bJd = bJd();
            if (!bJe()) {
                bJd = false;
            }
        }
        if (bJd) {
            if (this.mwf != null) {
                this.mwf.A(motionEvent);
            }
            AppMethodBeat.o(137783);
            return true;
        }
        if (motionEvent.getAction() == 0 && this.mwb && this.mvN.getVisibility() != 0) {
            this.mvM.bJu();
            if (this.mwr) {
                bIZ();
            }
        }
        if (this.mwk) {
            AppMethodBeat.o(137783);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(137783);
        return onTouchEvent;
    }

    static /* synthetic */ void n(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.i(234605);
        appBrandVideoView.mvM.bJC();
        AppMethodBeat.o(234605);
    }

    static /* synthetic */ void u(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.i(234607);
        if (appBrandVideoView.mww == null) {
            appBrandVideoView.mww = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.AnonymousClass7 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    int i2;
                    AppMethodBeat.i(234567);
                    int cacheTimeSec = AppBrandVideoView.this.getCacheTimeSec();
                    int duration = AppBrandVideoView.this.getDuration();
                    if (!(duration == 0 || (i2 = (int) ((((float) cacheTimeSec) * 100.0f) / ((float) duration))) == AppBrandVideoView.this.mwx)) {
                        AppBrandVideoView.this.mwx = i2;
                        if (AppBrandVideoView.this.mwc != null) {
                            com.tencent.mm.plugin.appbrand.jsapi.video.c.b bVar = AppBrandVideoView.this.mwc;
                            try {
                                Log.i("MicroMsg.Video.JsApiVideoCallback", "onVideoCacheUpdate, percent:%d, duration:%s", Integer.valueOf(i2), Integer.valueOf(duration));
                                JSONObject bKv = bVar.bKv();
                                bKv.put("buffered", i2);
                                bKv.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, duration);
                                bVar.a(new b.i((byte) 0), bKv);
                            } catch (JSONException e2) {
                                Log.e("MicroMsg.Video.JsApiVideoCallback", "onVideoCacheUpdate e=%s", e2);
                            }
                        }
                    }
                    AppMethodBeat.o(234567);
                    return true;
                }
            }, true);
        }
        appBrandVideoView.mww.startTimer(500);
        AppMethodBeat.o(234607);
    }

    static /* synthetic */ void a(AppBrandVideoView appBrandVideoView, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(234611);
        Log.i("MicroMsg.Video.AppBrandVideoView", "updateLiveUI isLive:%b", Boolean.valueOf(z));
        e.a aVar = appBrandVideoView.mvM;
        if ((appBrandVideoView.mwm || appBrandVideoView.mwn) && !z) {
            z2 = true;
        }
        aVar.setShowProgress(z2);
        AppMethodBeat.o(234611);
    }

    static /* synthetic */ void H(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.i(234612);
        boolean bJD = appBrandVideoView.mvM.bJD();
        if (!appBrandVideoView.mwb || !appBrandVideoView.mwm || !appBrandVideoView.mwu || bJD || appBrandVideoView.isLive() || appBrandVideoView.bJf()) {
            appBrandVideoView.mvX.setVisibility(8);
            AppMethodBeat.o(234612);
            return;
        }
        appBrandVideoView.mvX.setVisibility(0);
        AppMethodBeat.o(234612);
    }
}
