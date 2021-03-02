package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public class FavVideoView extends RelativeLayout implements View.OnClickListener, j.a {
    public boolean ZA;
    private String dLl;
    private String fullPath;
    private ProgressBar mEz;
    private MMHandler qaC;
    private j qbJ;
    private MTimerHandler qbP;
    private ImageView tiQ;
    private boolean tiT;
    public LinearLayout tjm;
    private TextView tmU;
    private View tmV;
    private ImageView tmW;
    private VideoPlayerSeekBar tmX;
    private RelativeLayout tmY;
    private boolean tmZ;
    private boolean tna;
    private int tnb;
    private int tnc;
    private boolean tnd;
    private MMPinProgressBtn tne;
    private int tnf;
    private b tng;
    MTimerHandler tnh;
    private com.tencent.mm.plugin.sight.decode.ui.b tni;
    private a tnj;

    public interface b {
        void finish();
    }

    public FavVideoView(Context context) {
        this(context, null);
    }

    public FavVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FavVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(107576);
        this.qaC = new MMHandler(Looper.getMainLooper());
        this.tmZ = false;
        this.tna = false;
        this.tnb = 0;
        this.tiT = false;
        this.tnc = 0;
        this.ZA = false;
        this.tnd = false;
        this.dLl = "";
        this.tnf = 0;
        this.qbP = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.fav.ui.widget.FavVideoView.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(107561);
                FavVideoView.this.tnc = FavVideoView.this.getPalyPosition();
                FavVideoView.this.tmX.seek(Math.max(0, FavVideoView.this.tnc / 1000));
                AppMethodBeat.o(107561);
                return true;
            }
        }, true);
        this.tnh = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.fav.ui.widget.FavVideoView.AnonymousClass3 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(107563);
                if (FavVideoView.this.tnd) {
                    FavVideoView.this.cWV();
                }
                AppMethodBeat.o(107563);
                return false;
            }
        }, false);
        this.tni = new com.tencent.mm.plugin.sight.decode.ui.b() {
            /* class com.tencent.mm.plugin.fav.ui.widget.FavVideoView.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void aJq() {
                AppMethodBeat.i(107564);
                FavVideoView.this.cXa();
                FavVideoView.this.tnh.stopTimer();
                AppMethodBeat.o(107564);
            }

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void rk(int i2) {
                AppMethodBeat.i(107565);
                if (!FavVideoView.this.isPlaying()) {
                    FavVideoView.this.qbP.startTimer(500);
                    FavVideoView.this.setVideoStateIv(false);
                }
                FavVideoView.this.seek(i2);
                FavVideoView.this.cXb();
                AppMethodBeat.o(107565);
            }
        };
        this.tnj = new a(this, (byte) 0);
        Log.i("MicroMsg.FavVideoView", "%d ui init view.", Integer.valueOf(hashCode()));
        LayoutInflater.from(context).inflate(R.layout.a87, this);
        this.tiQ = (ImageView) findViewById(R.id.j6m);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.dup);
        ((TextView) findViewById(R.id.j4l)).setVisibility(8);
        this.tne = (MMPinProgressBtn) findViewById(R.id.j62);
        this.mEz = (ProgressBar) findViewById(R.id.j59);
        this.tjm = (LinearLayout) findViewById(R.id.cbv);
        this.tmW = (ImageView) findViewById(R.id.j43);
        this.tmY = (RelativeLayout) findViewById(R.id.biu);
        this.tmV = findViewById(R.id.j4y);
        this.tmX = (VideoPlayerSeekBar) findViewById(R.id.j5y);
        this.tmU = (TextView) findViewById(R.id.j6r);
        if (e.bbm()) {
            this.tna = true;
            this.qbJ = new VideoPlayerTextureView(context);
        } else {
            this.tna = false;
            this.qbJ = new VideoTextureView(context);
        }
        this.qbJ.setVideoCallback(this);
        cWV();
        setVideoStateIv(true);
        this.tmX.setIplaySeekCallback(this.tni);
        this.tmX.setPlayBtnOnClickListener(this);
        this.tmW.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.widget.FavVideoView.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(107566);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (FavVideoView.this.tng != null) {
                    FavVideoView.this.tng.finish();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(107566);
            }
        });
        this.tmX.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        relativeLayout.addView((View) this.qbJ, layoutParams);
        ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.tnj);
        ((af) g.ah(af.class)).getFavCdnStorage().a(this.tnj);
        boolean aA = ao.aA(getContext());
        int aD = ao.aD(getContext());
        Log.i("MicroMsg.FavVideoView", "%d handleVerticalUI image gallery ui isNavBarVisibility %b navBarHeight %d", Integer.valueOf(hashCode()), Boolean.valueOf(aA), Integer.valueOf(aD));
        if (aA) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.tmV.getLayoutParams());
            layoutParams2.addRule(12);
            layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, aD);
            this.tmY.setLayoutParams(layoutParams2);
        }
        AppMethodBeat.o(107576);
    }

    public void setVideoData(String str) {
        this.fullPath = str;
    }

    public final void c(String str, boolean z, String str2) {
        AppMethodBeat.i(107577);
        this.fullPath = str;
        if (z) {
            showLoading();
            this.dLl = str2;
        }
        AppMethodBeat.o(107577);
    }

    public void setThumbView(String str) {
        AppMethodBeat.i(107578);
        this.tiQ.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(str, 1.0f));
        AppMethodBeat.o(107578);
    }

    public final void onResume() {
        AppMethodBeat.i(107579);
        Log.i("MicroMsg.FavVideoView", "VideoPlay:   onResume()");
        if (!this.tmZ) {
            cWZ();
        }
        AppMethodBeat.o(107579);
    }

    public final void onDestroy() {
        AppMethodBeat.i(107580);
        Log.i("MicroMsg.FavVideoView", "VideoPlay:   onDestroy()");
        this.qbP.stopTimer();
        this.tnh.stopTimer();
        this.tnh.stopTimer();
        try {
            ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.tnj);
            ((af) g.ah(af.class)).getFavCdnStorage().b(this.tnj);
            this.qbJ.stop();
            AppMethodBeat.o(107580);
        } catch (Throwable th) {
            Log.e("MicroMsg.FavVideoView", "onDestroy() %s %s", th.getClass().getSimpleName(), th.getMessage());
            AppMethodBeat.o(107580);
        }
    }

    public void onClick(View view) {
        AppMethodBeat.i(107581);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getId() == R.id.gcc) {
            Log.i("MicroMsg.FavVideoView", "toggle video");
            if (isPlaying()) {
                cWX();
            } else {
                cWY();
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107581);
    }

    public final void cWU() {
        AppMethodBeat.i(107582);
        if (!this.ZA) {
            Log.i("MicroMsg.FavVideoView", "handleSingleClck isPrepared:false");
            AppMethodBeat.o(107582);
        } else if (this.tnd) {
            cWV();
            AppMethodBeat.o(107582);
        } else {
            cWW();
            AppMethodBeat.o(107582);
        }
    }

    public final void cWV() {
        AppMethodBeat.i(107583);
        Log.i("MicroMsg.FavVideoView", "hide video tool bar");
        this.tmV.setVisibility(8);
        this.tmW.setVisibility(8);
        this.tnd = false;
        AppMethodBeat.o(107583);
    }

    public final void cWW() {
        AppMethodBeat.i(107584);
        Log.i("MicroMsg.FavVideoView", "show video tool bar");
        this.tmV.setVisibility(0);
        this.tmW.setVisibility(0);
        this.tnd = true;
        cXb();
        AppMethodBeat.o(107584);
    }

    public final void cWX() {
        AppMethodBeat.i(107585);
        cXa();
        this.qbP.stopTimer();
        setVideoStateIv(true);
        this.tnh.stopTimer();
        AppMethodBeat.o(107585);
    }

    public final void cWY() {
        AppMethodBeat.i(107586);
        seek(this.tmX.getmPosition());
        this.qbP.startTimer(500);
        setVideoStateIv(false);
        cXb();
        AppMethodBeat.o(107586);
    }

    private void mK(final boolean z) {
        AppMethodBeat.i(107587);
        this.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.widget.FavVideoView.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(107567);
                Log.i("MicroMsg.FavVideoView", "VideoPlay: switch video model isVideoPlay %b ", Boolean.valueOf(z));
                View view = (View) FavVideoView.this.qbJ;
                if (z) {
                    view.setAlpha(1.0f);
                    view.setVisibility(0);
                    FavVideoView.this.tiQ.setVisibility(8);
                    FavVideoView.this.tmX.setVideoTotalTime(FavVideoView.this.qbJ.getDuration() / 1000);
                    AppMethodBeat.o(107567);
                    return;
                }
                view.setVisibility(8);
                FavVideoView.this.tiQ.setVisibility(0);
                AppMethodBeat.o(107567);
            }
        });
        AppMethodBeat.o(107587);
    }

    private void cWZ() {
        AppMethodBeat.i(107588);
        if (Util.isNullOrNil(this.fullPath) || !s.YS(this.fullPath)) {
            Log.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is  null, show error, toggleVideo()");
            mK(false);
            AppMethodBeat.o(107588);
            return;
        }
        Log.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is not null,exist,  toggleVideo()");
        asy(this.fullPath);
        AppMethodBeat.o(107588);
    }

    public final void cXa() {
        AppMethodBeat.i(107589);
        if (this.qbJ.isPlaying()) {
            Log.i("MicroMsg.FavVideoView", "VideoPlay: pausePlay()");
            this.qbJ.pause();
        }
        AppMethodBeat.o(107589);
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(107590);
        if (this.qbJ == null) {
            AppMethodBeat.o(107590);
            return false;
        }
        boolean isPlaying = this.qbJ.isPlaying();
        AppMethodBeat.o(107590);
        return isPlaying;
    }

    public void setVideoStateIv(boolean z) {
        AppMethodBeat.i(107591);
        try {
            this.tmX.setIsPlay(!z);
            AppMethodBeat.o(107591);
        } catch (Exception e2) {
            Log.e("MicroMsg.FavVideoView", "set video state iv error : " + e2.toString());
            AppMethodBeat.o(107591);
        }
    }

    /* access modifiers changed from: protected */
    public final void cXb() {
        AppMethodBeat.i(107592);
        if (this.tnd) {
            this.tnh.startTimer(4000);
        }
        AppMethodBeat.o(107592);
    }

    private static boolean cXc() {
        AppMethodBeat.i(107593);
        boolean z = g.aAh().azQ().getBoolean(ar.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
        AppMethodBeat.o(107593);
        return z;
    }

    public final void asy(String str) {
        AppMethodBeat.i(107594);
        Log.i("MicroMsg.FavVideoView", "VideoPlay: prepareVideo");
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FavVideoView", "VideoPlay: %d prepare video but filepath is null.", Integer.valueOf(hashCode()));
            AppMethodBeat.o(107594);
            return;
        }
        if (this.qbJ != null) {
            if (this.qbJ instanceof VideoPlayerTextureView) {
                ((VideoPlayerTextureView) this.qbJ).setNeedResetExtractor(cXc());
            }
            ((View) this.qbJ).setVisibility(0);
            ((View) this.qbJ).setAlpha(0.0f);
            this.tiQ.setVisibility(0);
            this.qbJ.setVideoPath(str);
        }
        if (((Integer) g.aAh().azQ().get(ar.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, (Object) 0)).intValue() == 1) {
            this.tmU.setText(com.tencent.mm.plugin.sight.base.e.aFm(str));
            this.tmU.setVisibility(0);
        }
        AppMethodBeat.o(107594);
    }

    public final void seek(int i2) {
        AppMethodBeat.i(107595);
        Log.i("MicroMsg.FavVideoView", "VideoPlay: seek second is %d", Integer.valueOf(i2));
        this.qbJ.q((double) (i2 * 1000));
        AppMethodBeat.o(107595);
    }

    public int getPalyPosition() {
        AppMethodBeat.i(107596);
        int currentPosition = this.qbJ.getCurrentPosition();
        AppMethodBeat.o(107596);
        return currentPosition;
    }

    public void setCallback(b bVar) {
        this.tng = bVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final int fh(int i2, int i3) {
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void eo(int i2, int i3) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void tf() {
        AppMethodBeat.i(107597);
        this.tnb = 0;
        this.ZA = true;
        mK(true);
        this.tiT = this.qbJ.start();
        this.qbP.startTimer(500);
        setVideoStateIv(false);
        Log.i("MicroMsg.FavVideoView", "VideoPlay: startPlay(),duration is %d", Integer.valueOf(this.qbJ.getDuration() / 1000));
        AppMethodBeat.o(107597);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void onCompletion() {
        AppMethodBeat.i(107598);
        Log.i("MicroMsg.FavVideoView", "%d on completion", Integer.valueOf(hashCode()));
        if (d.oF(18) || !this.tna) {
            seek(0);
            AppMethodBeat.o(107598);
            return;
        }
        if (this.qbJ != null) {
            this.qbJ.stop();
        }
        AppMethodBeat.o(107598);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void onError(int i2, int i3) {
        AppMethodBeat.i(107599);
        Log.e("MicroMsg.FavVideoView", "VideoPlay: %d on play video error what %d extra %d. isMMVideoPlayer[%b]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.tna));
        if (this.tiT) {
            onCompletion();
            AppMethodBeat.o(107599);
            return;
        }
        this.tnb = i3;
        final String videoPath = this.qbJ.getVideoPath();
        this.qbJ.stop();
        this.tmZ = true;
        mK(false);
        if (this.tnb == -1) {
            this.tnf++;
            if (this.tnf <= 3) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.widget.FavVideoView.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(107568);
                        if (FavVideoView.this.qbJ != null) {
                            FavVideoView.this.asy(FavVideoView.this.fullPath);
                        }
                        AppMethodBeat.o(107568);
                    }
                });
                AppMethodBeat.o(107599);
                return;
            }
        }
        if (!Util.isNullOrNil(videoPath) && s.YS(videoPath)) {
            Log.e("MicroMsg.FavVideoView", "VideoPlay: start third player to play");
            this.qaC.post(new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.widget.FavVideoView.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(107569);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    FileProviderHelper.setIntentDataAndType(FavVideoView.this.getContext(), intent, new o(videoPath), "video/*", false);
                    try {
                        Context context = FavVideoView.this.getContext();
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$7", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$7", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(107569);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.FavVideoView", "startActivity fail, activity not found");
                        h.n(FavVideoView.this.getContext(), R.string.caa, R.string.cab);
                        AppMethodBeat.o(107569);
                    }
                }
            });
        }
        AppMethodBeat.o(107599);
    }

    private void showLoading() {
        AppMethodBeat.i(107600);
        this.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.widget.FavVideoView.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(107571);
                if (!(FavVideoView.this.mEz == null || FavVideoView.this.mEz.getVisibility() == 0)) {
                    FavVideoView.this.mEz.setVisibility(0);
                }
                if (!(FavVideoView.this.tne == null || FavVideoView.this.tne.getVisibility() == 8)) {
                    FavVideoView.this.tne.setVisibility(8);
                }
                AppMethodBeat.o(107571);
            }
        });
        AppMethodBeat.o(107600);
    }

    class a implements p, com.tencent.mm.plugin.record.a.d {
        private a() {
        }

        /* synthetic */ a(FavVideoView favVideoView, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fav.a.p
        public final void e(c cVar) {
            AppMethodBeat.i(107573);
            if (cVar == null) {
                AppMethodBeat.o(107573);
            } else if (Util.isNullOrNil(cVar.field_dataId) || !cVar.field_dataId.equals(FavVideoView.this.dLl)) {
                AppMethodBeat.o(107573);
            } else {
                a(cVar.field_status, cVar.field_path, cVar.field_offset, cVar.field_totalLen);
                AppMethodBeat.o(107573);
            }
        }

        @Override // com.tencent.mm.plugin.record.a.d
        public final void a(int i2, com.tencent.mm.plugin.record.a.j jVar) {
            AppMethodBeat.i(107574);
            if (jVar == null) {
                AppMethodBeat.o(107574);
            } else if (!jVar.field_dataId.equals(FavVideoView.this.dLl)) {
                AppMethodBeat.o(107574);
            } else {
                a(jVar.field_status, jVar.field_path, jVar.field_offset, jVar.field_totalLen);
                AppMethodBeat.o(107574);
            }
        }

        private void a(int i2, String str, int i3, int i4) {
            AppMethodBeat.i(107575);
            Log.d("MicroMsg.FavVideoView", "onCdnStatusChanged status:%s, offset:%s, totalLength:%s, path:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
            if ((i2 == 3 || i2 == 2) && s.YS(str)) {
                FavVideoView.this.qbJ.stop();
                FavVideoView.l(FavVideoView.this);
                FavVideoView.this.fullPath = str;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.widget.FavVideoView.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(107572);
                        if (FavVideoView.this.qbJ != null) {
                            FavVideoView.this.asy(FavVideoView.this.fullPath);
                        }
                        AppMethodBeat.o(107572);
                    }
                });
                AppMethodBeat.o(107575);
                return;
            }
            FavVideoView.a(FavVideoView.this, i3, i4);
            AppMethodBeat.o(107575);
        }
    }

    static /* synthetic */ void l(FavVideoView favVideoView) {
        AppMethodBeat.i(107601);
        favVideoView.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.widget.FavVideoView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(107562);
                if (!(FavVideoView.this.mEz == null || FavVideoView.this.mEz.getVisibility() == 8)) {
                    FavVideoView.this.mEz.setVisibility(8);
                }
                if (!(FavVideoView.this.tne == null || FavVideoView.this.tne.getVisibility() == 8)) {
                    FavVideoView.this.tne.setVisibility(8);
                }
                AppMethodBeat.o(107562);
            }
        });
        AppMethodBeat.o(107601);
    }

    static /* synthetic */ void a(FavVideoView favVideoView, final int i2, final int i3) {
        AppMethodBeat.i(107602);
        favVideoView.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.widget.FavVideoView.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(107570);
                if (!(FavVideoView.this.mEz == null || FavVideoView.this.mEz.getVisibility() == 8)) {
                    FavVideoView.this.mEz.setVisibility(8);
                }
                if (FavVideoView.this.tne != null) {
                    if (FavVideoView.this.tne.getVisibility() != 0) {
                        FavVideoView.this.tne.setVisibility(0);
                    }
                    Log.i("MicroMsg.FavVideoView", "download video update progress offset:%d  total: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (FavVideoView.this.tne.getMax() != i3 && i3 > 0) {
                        FavVideoView.this.tne.setMax(i3);
                    }
                    FavVideoView.this.tne.setProgress(i2);
                }
                AppMethodBeat.o(107570);
            }
        });
        AppMethodBeat.o(107602);
    }
}
