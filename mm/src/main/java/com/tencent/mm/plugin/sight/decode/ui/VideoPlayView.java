package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pluginsdk.ui.tools.v;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class VideoPlayView extends RelativeLayout implements d.a, j {
    private int DnP = 320;
    private int DnQ = 240;
    private boolean DnR = true;
    private a DnS;
    private ViewGroup DnT;
    public a DnU;
    private double DnV = 0.0d;
    public TextView DnW;
    public String DnX = "";
    public ImageView DnY;
    public boolean DnZ = true;
    private int Doa = 0;
    private int Dob = 0;
    private boolean Doc = false;
    private boolean Dod = false;
    private long Doe = 0;
    private Animation Dof = new AlphaAnimation(1.0f, 0.0f);
    private Animation Dog = new AlphaAnimation(0.0f, 1.0f);
    private Runnable Doh = new Runnable() {
        /* class com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.AnonymousClass4 */

        public final void run() {
            AppMethodBeat.i(116165);
            VideoPlayView.this.eVP();
            AppMethodBeat.o(116165);
        }
    };
    public int Doi = 0;
    private int duration = 0;
    private String fullPath;
    private boolean guh = false;
    private MMHandler hAk = new MMHandler();
    private View hRd;
    private ProgressBar krF;
    public View maskView;
    public j qbJ = null;

    public interface a {
        void XH(int i2);

        void eVQ();

        void eVR();

        void eVS();

        void uG(boolean z);
    }

    static /* synthetic */ void a(VideoPlayView videoPlayView, int i2) {
        AppMethodBeat.i(116201);
        videoPlayView.XG(i2);
        AppMethodBeat.o(116201);
    }

    static /* synthetic */ void a(VideoPlayView videoPlayView, boolean z) {
        AppMethodBeat.i(116200);
        videoPlayView.uF(z);
        AppMethodBeat.o(116200);
    }

    static /* synthetic */ void d(VideoPlayView videoPlayView) {
        AppMethodBeat.i(116202);
        videoPlayView.eVO();
        AppMethodBeat.o(116202);
    }

    static /* synthetic */ void e(VideoPlayView videoPlayView, int i2) {
        AppMethodBeat.i(116203);
        videoPlayView.update(i2);
        AppMethodBeat.o(116203);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setVideoPath(String str) {
        AppMethodBeat.i(116171);
        this.fullPath = str;
        Log.i("MicroMsg.VideoPlayView", "videoPath  %s", this.fullPath);
        this.qbJ.setVideoPath(this.fullPath);
        AppMethodBeat.o(116171);
    }

    public void setVideoPlayViewEvent(a aVar) {
        this.DnS = aVar;
    }

    public VideoPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(116172);
        init();
        AppMethodBeat.o(116172);
    }

    public VideoPlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(116173);
        init();
        AppMethodBeat.o(116173);
    }

    private void init() {
        AppMethodBeat.i(116174);
        this.Dof.setDuration(200);
        this.Dog.setDuration(200);
        View.inflate(getContext(), R.layout.c5h, this);
        this.hRd = findViewById(R.id.gcd);
        this.DnY = (ImageView) findViewById(R.id.fcv);
        this.DnY.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        this.krF = (ProgressBar) findViewById(R.id.glr);
        this.DnT = (ViewGroup) findViewById(R.id.j44);
        this.qbJ = v.iE(getContext());
        this.qbJ.setLoop(false);
        this.DnT.addView((View) this.qbJ, 0, new RelativeLayout.LayoutParams(-1, -1));
        this.DnW = (TextView) findViewById(R.id.hqu);
        this.maskView = this.DnW;
        this.qbJ.setVideoCallback(new j.a() {
            /* class com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void tf() {
                AppMethodBeat.i(116158);
                Log.d("MicroMsg.VideoPlayView", f.app() + " onPrepared");
                VideoPlayView.a(VideoPlayView.this, true);
                AppMethodBeat.o(116158);
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void onError(int i2, int i3) {
                AppMethodBeat.i(116159);
                Log.e("MicroMsg.VideoPlayView", "on play video error, what %d extra %d", Integer.valueOf(i2), Integer.valueOf(i3));
                VideoPlayView.this.qbJ.stop();
                AppMethodBeat.o(116159);
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void onCompletion() {
                AppMethodBeat.i(116160);
                Log.d("MicroMsg.VideoPlayView", "on completion " + Util.getStack().toString());
                if (!VideoPlayView.this.Doc) {
                    VideoPlayView.this.DnV = 0.0d;
                    VideoPlayView.this.q(0.0d);
                    VideoPlayView.this.DnU.setIsPlay(false);
                    VideoPlayView.a(VideoPlayView.this, 0);
                    VideoPlayView.d(VideoPlayView.this);
                    if (System.currentTimeMillis() - VideoPlayView.this.Doe < 2000) {
                        Log.i("MicroMsg.VideoPlayView", "Too short onCompletion");
                        AppMethodBeat.o(116160);
                        return;
                    }
                    VideoPlayView.this.Doe = System.currentTimeMillis();
                    if (VideoPlayView.this.DnS != null) {
                        VideoPlayView.this.DnS.eVR();
                        AppMethodBeat.o(116160);
                        return;
                    }
                } else {
                    VideoPlayView.this.DnU.setIsPlay(false);
                    VideoPlayView.a(VideoPlayView.this, (int) VideoPlayView.this.DnV);
                    VideoPlayView.d(VideoPlayView.this);
                    if (VideoPlayView.this.DnS != null) {
                        VideoPlayView.this.DnS.eVS();
                    }
                }
                AppMethodBeat.o(116160);
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final int fh(final int i2, final int i3) {
                AppMethodBeat.i(116161);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(116156);
                        Log.i("MicroMsg.VideoPlayView", "play time " + i2 + " video time " + i3);
                        if (i3 > 0) {
                            VideoPlayView.this.duration = i3;
                            if (VideoPlayView.this.DnU != null && VideoPlayView.this.DnR) {
                                VideoPlayView.this.DnR = false;
                            }
                            VideoPlayView.this.DnS.XH(i3);
                        }
                        if (VideoPlayView.this.DnU != null) {
                            if (VideoPlayView.this.DnU.getVideoTotalTime() != i3) {
                                VideoPlayView.this.DnU.setVideoTotalTime(i3);
                            }
                            VideoPlayView.this.DnU.seek(i2);
                            VideoPlayView.this.DnU.setIsPlay(true);
                        }
                        if (VideoPlayView.this.krF.getVisibility() == 0) {
                            VideoPlayView.this.krF.setVisibility(8);
                        }
                        VideoPlayView.this.DnV = (double) i2;
                        AppMethodBeat.o(116156);
                    }
                });
                AppMethodBeat.o(116161);
                return 0;
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void eo(int i2, int i3) {
                AppMethodBeat.i(116162);
                VideoPlayView.this.DnP = i2;
                VideoPlayView.this.DnQ = i3;
                if (VideoPlayView.this.Dod) {
                    VideoPlayView.this.hAk.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(116157);
                            VideoPlayView.e(VideoPlayView.this, VideoPlayView.this.Doi);
                            AppMethodBeat.o(116157);
                        }
                    });
                }
                AppMethodBeat.o(116162);
            }
        });
        if (this.qbJ instanceof VideoSightView) {
            ((VideoSightView) this.qbJ).setEnableConfigChanged(false);
        }
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(116163);
                if (motionEvent.getAction() == 1) {
                    VideoPlayView.m(VideoPlayView.this);
                } else {
                    motionEvent.getAction();
                }
                AppMethodBeat.o(116163);
                return true;
            }
        });
        eVP();
        ((View) this.qbJ).post(new Runnable() {
            /* class com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(116164);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (VideoPlayView.this.getContext() instanceof MMActivity) {
                    ((MMActivity) VideoPlayView.this.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    if (VideoPlayView.this.qbJ instanceof VideoSightView) {
                        ((VideoSightView) VideoPlayView.this.qbJ).setDrawableWidth(displayMetrics.widthPixels);
                    }
                }
                ((View) VideoPlayView.this.qbJ).requestLayout();
                ((View) VideoPlayView.this.qbJ).postInvalidate();
                AppMethodBeat.o(116164);
            }
        });
        AppMethodBeat.o(116174);
    }

    public void setVideoTotalTime(int i2) {
        AppMethodBeat.i(116175);
        if (this.DnU.getVideoTotalTime() != i2) {
            this.DnU.setVideoTotalTime(i2);
        }
        AppMethodBeat.o(116175);
    }

    public void setIsDownloading(boolean z) {
        AppMethodBeat.i(116176);
        this.Doc = z;
        if (this.qbJ != null && (this.qbJ instanceof VideoSightView)) {
            VideoSightView videoSightView = (VideoSightView) this.qbJ;
            if (videoSightView.getController() != null) {
                videoSightView.getController().DmL = !z;
            }
        }
        AppMethodBeat.o(116176);
    }

    public final void eVN() {
        AppMethodBeat.i(116177);
        this.krF.setVisibility(0);
        AppMethodBeat.o(116177);
    }

    private void eVO() {
        boolean z;
        AppMethodBeat.i(116178);
        ((View) this.DnU).setVisibility(0);
        this.hRd.setVisibility(0);
        if (this.DnZ) {
            this.DnY.setVisibility(0);
        }
        if (this.Doi == 2) {
            z = false;
        } else if (Util.isNullOrNil(this.DnX)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.maskView.setVisibility(0);
        }
        this.hAk.removeCallbacks(this.Doh);
        this.hAk.postDelayed(this.Doh, 3000);
        AppMethodBeat.o(116178);
    }

    public final void eVP() {
        AppMethodBeat.i(116179);
        if (this.DnU != null) {
            ((View) this.DnU).setVisibility(4);
        }
        this.hRd.setVisibility(8);
        this.DnY.setVisibility(8);
        this.maskView.setVisibility(8);
        AppMethodBeat.o(116179);
    }

    public void setLeftButtonOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(116180);
        this.hRd.setOnClickListener(onClickListener);
        AppMethodBeat.o(116180);
    }

    public void setRightButtonOnCliclListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(116181);
        this.DnY.setOnClickListener(onClickListener);
        AppMethodBeat.o(116181);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean start() {
        AppMethodBeat.i(116182);
        uF(true);
        AppMethodBeat.o(116182);
        return true;
    }

    private void uF(boolean z) {
        AppMethodBeat.i(116184);
        this.qbJ.q(this.DnV);
        this.qbJ.start();
        Log.i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.DnV);
        if (this.DnS != null) {
            this.DnS.uG(z);
        }
        AppMethodBeat.o(116184);
    }

    private void XG(int i2) {
        AppMethodBeat.i(116185);
        this.DnV = i2 >= 0 ? (double) i2 : this.qbJ.getLastProgresstime();
        Log.i("MicroMsg.VideoPlayView", "pause play " + this.DnV + " lastTime: " + i2 + " last " + this.qbJ.getLastProgresstime());
        this.qbJ.pause();
        this.hAk.post(new Runnable() {
            /* class com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(116169);
                if (VideoPlayView.this.DnU != null) {
                    VideoPlayView.this.DnU.setIsPlay(false);
                }
                AppMethodBeat.o(116169);
            }
        });
        if (this.DnS != null) {
            this.DnS.eVQ();
        }
        AppMethodBeat.o(116185);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean isPlaying() {
        AppMethodBeat.i(116186);
        boolean isPlaying = this.qbJ.isPlaying();
        AppMethodBeat.o(116186);
        return isPlaying;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public String getVideoPath() {
        return this.fullPath;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean E(Context context, boolean z) {
        AppMethodBeat.i(116187);
        boolean E = this.qbJ.E(context, z);
        AppMethodBeat.o(116187);
        return E;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void stop() {
        AppMethodBeat.i(116188);
        this.qbJ.stop();
        AppMethodBeat.o(116188);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void onDetach() {
        AppMethodBeat.i(116189);
        this.qbJ.onDetach();
        AppMethodBeat.o(116189);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setLoop(boolean z) {
        AppMethodBeat.i(116190);
        this.qbJ.setLoop(z);
        AppMethodBeat.o(116190);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public double getLastProgresstime() {
        AppMethodBeat.i(116191);
        double max = Math.max(this.DnV, this.qbJ.getLastProgresstime());
        AppMethodBeat.o(116191);
        return max;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setVideoCallback(j.a aVar) {
        AppMethodBeat.i(116192);
        this.qbJ.setVideoCallback(aVar);
        AppMethodBeat.o(116192);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public int getCurrentPosition() {
        AppMethodBeat.i(116193);
        int currentPosition = this.qbJ.getCurrentPosition();
        AppMethodBeat.o(116193);
        return currentPosition;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public int getDuration() {
        AppMethodBeat.i(116194);
        if (this.duration == 0) {
            int duration2 = this.qbJ.getDuration();
            AppMethodBeat.o(116194);
            return duration2;
        }
        int i2 = this.duration;
        AppMethodBeat.o(116194);
        return i2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setThumb(Bitmap bitmap) {
        AppMethodBeat.i(116195);
        this.qbJ.setThumb(bitmap);
        AppMethodBeat.o(116195);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void q(double d2) {
        AppMethodBeat.i(116196);
        this.qbJ.q(d2);
        this.DnU.seek((int) d2);
        AppMethodBeat.o(116196);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setPlayProgressCallback(boolean z) {
        AppMethodBeat.i(116197);
        this.qbJ.setPlayProgressCallback(z);
        AppMethodBeat.o(116197);
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTw() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTx() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTy() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTz() {
    }

    public final void update(int i2) {
        RelativeLayout.LayoutParams layoutParams;
        AppMethodBeat.i(116198);
        this.Dod = true;
        if (this.Dob == 0 || this.Doa == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.Dob = displayMetrics.heightPixels;
            this.Doa = displayMetrics.widthPixels;
            if (this.Dob < this.Doa) {
                this.Dob = displayMetrics.widthPixels;
                this.Doa = displayMetrics.heightPixels;
            }
            Log.i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.Dob + " screen_width:" + this.Doa);
        }
        ViewGroup.LayoutParams layoutParams2 = this.DnT.getLayoutParams();
        if (this.DnU == null) {
            layoutParams = null;
        } else {
            layoutParams = (RelativeLayout.LayoutParams) ((View) this.DnU).getLayoutParams();
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        if (i2 == 1) {
            layoutParams3.width = this.Doa;
            layoutParams3.height = (int) (((((double) this.Doa) * 1.0d) * ((double) this.DnQ)) / ((double) this.DnP));
            if (this.DnU != null) {
                layoutParams.bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 0.0f);
            }
        } else {
            layoutParams3.height = this.Doa;
            layoutParams3.width = (int) (((((double) this.Doa) * 1.0d) * ((double) this.DnP)) / ((double) this.DnQ));
            if (this.DnU != null) {
                layoutParams.bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 0.0f);
            }
        }
        if (this.DnU != null) {
            this.DnU.eVJ();
            ((View) this.DnU).setLayoutParams(layoutParams);
            if (this.DnU instanceof AdVideoPlayerLoadingBar) {
                this.hAk.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(116170);
                        if (!VideoPlayView.this.qbJ.isPlaying()) {
                            ((AdVideoPlayerLoadingBar) VideoPlayView.this.DnU).bKO();
                        }
                        AppMethodBeat.o(116170);
                    }
                }, 500);
            }
        }
        Log.i("MicroMsg.VideoPlayView", "orientation " + i2 + " " + layoutParams3.width + " " + layoutParams3.height);
        ((View) this.qbJ).setLayoutParams(layoutParams3);
        if (this.qbJ instanceof com.tencent.mm.plugin.sight.decode.a.a) {
            ((com.tencent.mm.plugin.sight.decode.a.a) this.qbJ).im(layoutParams3.width, layoutParams3.height);
        }
        layoutParams2.height = layoutParams3.height;
        layoutParams2.width = layoutParams3.width;
        this.DnT.setLayoutParams(layoutParams2);
        ((View) this.qbJ).requestLayout();
        AppMethodBeat.o(116198);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public long getLastSurfaceUpdateTime() {
        return 0;
    }

    public void setForceScaleFullScreen(boolean z) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setMute(boolean z) {
        this.guh = z;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void d(double d2, boolean z) {
        AppMethodBeat.i(116199);
        q(d2);
        AppMethodBeat.o(116199);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOneTimeVideoTextureUpdateCallback(j.e eVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOnSeekCompleteCallback(j.c cVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOnInfoCallback(j.b bVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOnSurfaceCallback(j.d dVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void pause() {
        AppMethodBeat.i(116183);
        XG(-1);
        AppMethodBeat.o(116183);
    }

    static /* synthetic */ void m(VideoPlayView videoPlayView) {
        AppMethodBeat.i(116204);
        if (videoPlayView.hRd.getVisibility() == 0) {
            videoPlayView.eVP();
            AppMethodBeat.o(116204);
            return;
        }
        videoPlayView.eVO();
        AppMethodBeat.o(116204);
    }

    static /* synthetic */ void o(VideoPlayView videoPlayView) {
        AppMethodBeat.i(116205);
        videoPlayView.XG(-1);
        AppMethodBeat.o(116205);
    }
}
