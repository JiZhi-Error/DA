package com.tencent.mm.plugin.mmsight.segment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.segment.a.a;
import com.tencent.mm.plugin.mmsight.segment.a.c;
import com.tencent.mm.plugin.mmsight.segment.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@com.tencent.mm.ui.base.a(3)
public class VideoSegmentUI extends MMActivity {
    private CountDownLatch cZC = new CountDownLatch(2);
    private com.tencent.mm.remoteservice.d gVN = new com.tencent.mm.remoteservice.d(this);
    private ProgressDialog gtM = null;
    private int jkS;
    private Surface mSurface;
    private String rpE = "";
    private String thumbPath;
    private RelativeLayout tjk;
    private VideoTransPara zua;
    private String zzN = null;
    private f zzO;
    private com.tencent.mm.plugin.mmsight.segment.a.c zzP;
    private boolean zzQ = false;
    private c zzR;
    private int zzS = 10000;
    private boolean zzT = false;
    private boolean zzU = false;
    private boolean zzV = false;
    private c.b zzW = new c.b() {
        /* class com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.mmsight.segment.c.b
        public final void W(float f2, float f3) {
            AppMethodBeat.i(94463);
            if (VideoSegmentUI.this.zzP == null) {
                AppMethodBeat.o(94463);
                return;
            }
            int i2 = VideoSegmentUI.this.jkS;
            VideoSegmentUI.this.zzP.setLoop((int) (((float) i2) * f2), (int) (((float) i2) * f3));
            VideoSegmentUI.this.zzP.seekTo((int) (((float) i2) * f2));
            AppMethodBeat.o(94463);
        }

        @Override // com.tencent.mm.plugin.mmsight.segment.c.b
        public final void X(float f2, float f3) {
            AppMethodBeat.i(94464);
            if (VideoSegmentUI.this.zzP == null) {
                AppMethodBeat.o(94464);
                return;
            }
            VideoSegmentUI.this.zzP.pause();
            AppMethodBeat.o(94464);
        }

        @Override // com.tencent.mm.plugin.mmsight.segment.c.b
        public final void Y(float f2, float f3) {
            AppMethodBeat.i(94465);
            if (VideoSegmentUI.this.zzP == null) {
                AppMethodBeat.o(94465);
                return;
            }
            int i2 = (int) (((float) VideoSegmentUI.this.jkS) * f2);
            VideoSegmentUI.this.zzP.setLoop(i2, (int) (((float) VideoSegmentUI.this.jkS) * f3));
            VideoSegmentUI.this.zzP.seekTo(i2);
            AppMethodBeat.o(94465);
        }

        @Override // com.tencent.mm.plugin.mmsight.segment.c.b
        public final void Z(float f2, float f3) {
            AppMethodBeat.i(94466);
            if ((f3 - f2) * ((float) VideoSegmentUI.this.jkS) <= ((float) VideoSegmentUI.this.zzS)) {
                VideoSegmentUI.this.enableOptionMenu(true);
                AppMethodBeat.o(94466);
                return;
            }
            VideoSegmentUI.this.enableOptionMenu(false);
            AppMethodBeat.o(94466);
        }
    };
    private c.a zzX = new c.a() {
        /* class com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.AnonymousClass3 */
        private Runnable zAa;

        @Override // com.tencent.mm.plugin.mmsight.segment.a.c.a
        public final void QR(int i2) {
            AppMethodBeat.i(94467);
            if (VideoSegmentUI.this.zzR == null) {
                AppMethodBeat.o(94467);
                return;
            }
            if (this.zAa != null) {
                ((View) VideoSegmentUI.this.zzR).removeCallbacks(this.zAa);
            }
            this.zAa = new c(VideoSegmentUI.this.zzR, i2, VideoSegmentUI.this.jkS);
            ((View) VideoSegmentUI.this.zzR).post(this.zAa);
            AppMethodBeat.o(94467);
        }
    };
    private a.d zzY = new a.d() {
        /* class com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.mmsight.segment.a.a.d
        public final void ap(int i2, int i3, int i4) {
            AppMethodBeat.i(94468);
            if (i2 <= 0 || i3 <= 0) {
                Log.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged wrong size (%d, %d) invoked = %b", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(VideoSegmentUI.this.zzV));
                AppMethodBeat.o(94468);
            } else if (VideoSegmentUI.this.zzV) {
                Log.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged surface has invoked");
                AppMethodBeat.o(94468);
            } else {
                Log.i("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged (%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
                VideoSegmentUI.this.zzV = true;
                if (i3 <= 0 || i2 <= 0) {
                    Log.e("MicroMsg.VideoSegmentUI", "This video has wrong size (%dx%d)", Integer.valueOf(i2), Integer.valueOf(i3));
                    VideoSegmentUI.this.zzU = true;
                    VideoSegmentUI.this.finish();
                    VideoSegmentUI.b(VideoSegmentUI.this);
                    AppMethodBeat.o(94468);
                    return;
                }
                a aVar = new a(VideoSegmentUI.this, VideoSegmentUI.this.tjk, i3, i2, i4, new b(VideoSegmentUI.this, (byte) 0), (byte) 0);
                if (VideoSegmentUI.this.tjk.getWidth() <= 0 || VideoSegmentUI.this.tjk.getHeight() <= 0) {
                    Log.i("MicroMsg.VideoSegmentUI", "post init surface task after root measured.");
                    VideoSegmentUI.this.tjk.post(aVar);
                    AppMethodBeat.o(94468);
                    return;
                }
                aVar.run();
                AppMethodBeat.o(94468);
            }
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VideoSegmentUI() {
        AppMethodBeat.i(94488);
        AppMethodBeat.o(94488);
    }

    static /* synthetic */ void a(VideoSegmentUI videoSegmentUI, Surface surface) {
        AppMethodBeat.i(94499);
        videoSegmentUI.a(false, surface);
        AppMethodBeat.o(94499);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(94489);
        super.onCreate(bundle);
        getWindow().addFlags(128);
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.gVN));
        this.gVN.connect(new Runnable() {
            /* class com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(94462);
                Log.i("MicroMsg.VideoSegmentUI", "has connect");
                if (CaptureMMProxy.getInstance() != null) {
                    ae.DV(CaptureMMProxy.getInstance().getDeviceInfoConfig());
                }
                VideoSegmentUI.a(VideoSegmentUI.this);
                AppMethodBeat.o(94462);
            }
        });
        AppMethodBeat.o(94489);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(94490);
        this.zzR = (c) findViewById(R.id.hgx);
        this.tjk = (RelativeLayout) findViewById(R.id.h8v);
        AppMethodBeat.o(94490);
    }

    private void a(boolean z, Surface surface) {
        AppMethodBeat.i(94491);
        if (this.zzP != null) {
            Log.e("MicroMsg.VideoSegmentUI", "initSegmentPlayer not null, you can not init segmentPlayer");
            AppMethodBeat.o(94491);
            return;
        }
        this.zzP = new com.tencent.mm.plugin.mmsight.segment.a.c();
        this.zzQ = false;
        this.zzP.setDataSource(this.zzN);
        this.zzP.a(new a.AbstractC1482a() {
            /* class com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.mmsight.segment.a.a.AbstractC1482a
            public final boolean hc(int i2, int i3) {
                AppMethodBeat.i(94475);
                Log.e("MicroMsg.VideoSegmentUI", "MediaPlayer on error what = %d extra = %d", Integer.valueOf(i2), Integer.valueOf(i3));
                VideoSegmentUI.this.zzU = true;
                VideoSegmentUI.this.finish();
                VideoSegmentUI.b(VideoSegmentUI.this);
                AppMethodBeat.o(94475);
                return true;
            }
        });
        if (z) {
            this.zzP.a(this.zzY);
        }
        this.zzP.setAudioStreamType(3);
        this.zzP.setLooping(true);
        if (surface != null) {
            this.zzP.setSurface(surface);
        }
        this.zzP.zzX = this.zzX;
        this.zzP.a(new a.b() {
            /* class com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.AnonymousClass10 */

            @Override // com.tencent.mm.plugin.mmsight.segment.a.a.b
            public final void dD(Object obj) {
                AppMethodBeat.i(94476);
                Log.i("MicroMsg.VideoSegmentUI", "MediaPlayer.onPrepared start %s", obj);
                try {
                    if (VideoSegmentUI.this.zzP != null) {
                        VideoSegmentUI.this.zzQ = true;
                        VideoSegmentUI.this.zzP.start();
                    }
                    AppMethodBeat.o(94476);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.VideoSegmentUI", e2, "hy: exception when onPrepared waiting for starting", new Object[0]);
                    AppMethodBeat.o(94476);
                }
            }
        });
        this.zzP.prepareAsync();
        this.zzP.a(new a.c() {
            /* class com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.AnonymousClass11 */

            @Override // com.tencent.mm.plugin.mmsight.segment.a.a.c
            public final void dE(Object obj) {
                AppMethodBeat.i(94477);
                try {
                    if (VideoSegmentUI.this.zzP != null) {
                        VideoSegmentUI.this.zzP.start();
                    }
                    AppMethodBeat.o(94477);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.VideoSegmentUI", e2, "hy: exception when onSeekComplete waiting for starting", new Object[0]);
                    AppMethodBeat.o(94477);
                }
            }
        });
        AppMethodBeat.o(94491);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(94492);
        if (this.zzP != null && this.zzQ) {
            Log.i("MicroMsg.VideoSegmentUI", "onResume start player");
            this.zzP.start();
        }
        super.onResume();
        AppMethodBeat.o(94492);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(94493);
        if (this.zzP != null) {
            Log.i("MicroMsg.VideoSegmentUI", "onPause pause player");
            this.zzP.pause();
        }
        super.onPause();
        AppMethodBeat.o(94493);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(94494);
        Log.i("MicroMsg.VideoSegmentUI", "onDestroy");
        super.onDestroy();
        getWindow().clearFlags(128);
        this.gVN.release();
        if (this.zzR != null) {
            this.zzR.release();
        }
        if (this.zzP != null) {
            this.zzP.release();
        }
        if (this.mSurface != null) {
            this.mSurface.release();
        }
        if (this.zzO != null) {
            this.zzO.release();
        }
        k.zwi.aRR();
        AppMethodBeat.o(94494);
    }

    static class c implements Runnable {
        private int jkS;
        private WeakReference<c> oi;
        private int zAk;

        public c(c cVar, int i2, int i3) {
            AppMethodBeat.i(94484);
            this.oi = new WeakReference<>(cVar);
            this.zAk = i2;
            this.jkS = i3;
            AppMethodBeat.o(94484);
        }

        public final void run() {
            AppMethodBeat.i(94485);
            c cVar = this.oi.get();
            if (cVar == null) {
                AppMethodBeat.o(94485);
                return;
            }
            cVar.setCurrentCursorPosition(((float) this.zAk) / ((float) this.jkS));
            AppMethodBeat.o(94485);
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements Runnable {
        private d() {
        }

        /* synthetic */ d(VideoSegmentUI videoSegmentUI, byte b2) {
            this();
        }

        public final void run() {
            boolean z;
            AppMethodBeat.i(94487);
            try {
                z = VideoSegmentUI.this.cZC.await(5, TimeUnit.SECONDS);
            } catch (InterruptedException e2) {
                Log.e("MicroMsg.VideoSegmentUI", "count down latch error %s", e2);
                z = false;
            }
            if (z) {
                try {
                    if (!VideoSegmentUI.this.zzU && !VideoSegmentUI.this.isFinishing() && VideoSegmentUI.this.mSurface != null && VideoSegmentUI.this.mSurface.isValid()) {
                        if (VideoSegmentUI.this.zzP != null) {
                            VideoSegmentUI.this.zzP.a((a.AbstractC1482a) null);
                            VideoSegmentUI.this.zzP.a((a.d) null);
                            VideoSegmentUI.this.zzP.release();
                            VideoSegmentUI.this.zzP = null;
                        }
                        try {
                            VideoSegmentUI.a(VideoSegmentUI.this, VideoSegmentUI.this.mSurface);
                            VideoSegmentUI.this.zzP.setSurface(VideoSegmentUI.this.mSurface);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.d.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(94486);
                                    if (VideoSegmentUI.this.zzU || VideoSegmentUI.this.isFinishing() || VideoSegmentUI.this.zzR == null || VideoSegmentUI.this.zzP == null) {
                                        Log.i("MicroMsg.VideoSegmentUI", "waiting end, main thread, activity not valid.");
                                        AppMethodBeat.o(94486);
                                        return;
                                    }
                                    ((View) VideoSegmentUI.this.zzR).setAlpha(0.0f);
                                    ((View) VideoSegmentUI.this.zzR).setVisibility(0);
                                    ((View) VideoSegmentUI.this.zzR).animate().setDuration(300).setStartDelay(200).alpha(1.0f);
                                    float eko = VideoSegmentUI.this.zzR.eko();
                                    float ekp = VideoSegmentUI.this.zzR.ekp();
                                    if ((ekp - eko) * ((float) VideoSegmentUI.this.jkS) <= ((float) VideoSegmentUI.this.zzS)) {
                                        VideoSegmentUI.this.enableOptionMenu(true);
                                    }
                                    VideoSegmentUI.this.zzP.setLoop((int) (eko * ((float) VideoSegmentUI.this.jkS)), (int) (ekp * ((float) VideoSegmentUI.this.jkS)));
                                    AppMethodBeat.o(94486);
                                }
                            });
                            AppMethodBeat.o(94487);
                            return;
                        } catch (IOException e3) {
                            Log.printErrStackTrace("MicroMsg.VideoSegmentUI", e3, "init segmentPlayer second time %s", e3.getMessage());
                            VideoSegmentUI.this.finish();
                            AppMethodBeat.o(94487);
                            return;
                        }
                    }
                } catch (Exception e4) {
                    Log.printErrStackTrace("MicroMsg.VideoSegmentUI", e4, "Finished when init", new Object[0]);
                    VideoSegmentUI.this.finish();
                    AppMethodBeat.o(94487);
                    return;
                }
            }
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Boolean.valueOf(VideoSegmentUI.this.zzU);
            objArr[2] = Boolean.valueOf(VideoSegmentUI.this.isFinishing());
            objArr[3] = Boolean.valueOf(VideoSegmentUI.this.mSurface == null);
            Log.w("MicroMsg.VideoSegmentUI", "Waiting Prepared error result[%b] needFinish[%b] isFinishing[%b] mSurface is null[%b]", objArr);
            VideoSegmentUI.this.finish();
            AppMethodBeat.o(94487);
        }
    }

    class a implements Runnable {
        private Context context;
        private ViewGroup hwr;
        private int zAf;
        private int zAg;
        private int zAh;
        private b zAi;

        /* synthetic */ a(VideoSegmentUI videoSegmentUI, ViewGroup viewGroup, int i2, int i3, int i4, b bVar, byte b2) {
            this(viewGroup, i2, i3, i4, bVar);
        }

        private a(ViewGroup viewGroup, int i2, int i3, int i4, b bVar) {
            AppMethodBeat.i(94480);
            this.zAf = i2;
            this.zAg = i3;
            this.zAh = i4;
            this.context = viewGroup.getContext();
            this.hwr = viewGroup;
            this.zAi = bVar;
            AppMethodBeat.o(94480);
        }

        public final void run() {
            float f2;
            AppMethodBeat.i(94481);
            if (VideoSegmentUI.this.isFinishing()) {
                AppMethodBeat.o(94481);
                return;
            }
            AnonymousClass1 r1 = new MMTextureView(this.context) {
                /* class com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.a.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public final void onMeasure(int i2, int i3) {
                    AppMethodBeat.i(94479);
                    Log.d("MicroMsg.VideoSegmentUI", "onMeasure video size[%d, %d, %d] spec[%d, %d]", Integer.valueOf(a.this.zAg), Integer.valueOf(a.this.zAf), Integer.valueOf(a.this.zAh), Integer.valueOf(View.getDefaultSize(1, i2)), Integer.valueOf(View.getDefaultSize(1, i3)));
                    if (a.this.zAh == 90 || a.this.zAh == 270) {
                        Matrix matrix = new Matrix();
                        matrix.set(getMatrix());
                        int defaultSize = View.getDefaultSize(1, i2);
                        int defaultSize2 = View.getDefaultSize(1, i3);
                        float f2 = ((float) defaultSize) / 2.0f;
                        float f3 = ((float) defaultSize2) / 2.0f;
                        float f4 = ((float) defaultSize2) / ((float) defaultSize);
                        matrix.postRotate((float) a.this.zAh, f2, f3);
                        matrix.postScale(1.0f / f4, f4, f2, f3);
                        setTransform(matrix);
                        Log.i("MicroMsg.VideoSegmentUI", "rotate transform mDegrees[%d] screenSize[%d, %d]", Integer.valueOf(a.this.zAh), Integer.valueOf(defaultSize), Integer.valueOf(defaultSize2));
                    }
                    super.onMeasure(i2, i3);
                    AppMethodBeat.o(94479);
                }
            };
            int width = this.hwr.getWidth();
            int aG = com.tencent.mm.cb.a.aG(this.context, R.dimen.anm);
            int top = ((View) VideoSegmentUI.this.zzR).getTop() - (aG * 2);
            int i2 = this.zAg;
            int i3 = this.zAf;
            Point point = new Point();
            if (((float) i3) / ((float) i2) > ((float) top) / ((float) width)) {
                f2 = ((float) top) / ((float) i3);
            } else {
                f2 = ((float) width) / ((float) i2);
            }
            point.x = (int) (((float) i2) * f2);
            point.y = (int) (f2 * ((float) i3));
            Log.i("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d  rawDegress %d padding %d validWidth %d validHeight %d scaled %s", Integer.valueOf(this.zAg), Integer.valueOf(this.zAf), Integer.valueOf(this.zAh), Integer.valueOf(aG), Integer.valueOf(width), Integer.valueOf(top), point.toString());
            if (point.x <= 0 || point.y <= 0) {
                Log.e("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d padding %d validWidth %d validHeight %d scaled %s", Integer.valueOf(this.zAg), Integer.valueOf(this.zAf), Integer.valueOf(aG), Integer.valueOf(width), Integer.valueOf(top), point.toString());
                if (this.zAi != null) {
                    b bVar = this.zAi;
                    Log.e("MicroMsg.VideoSegmentUI", "TextureViewCallback error");
                    VideoSegmentUI.this.zzU = true;
                    VideoSegmentUI.this.finish();
                    VideoSegmentUI.b(VideoSegmentUI.this);
                }
                AppMethodBeat.o(94481);
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(point.x, point.y);
            int i4 = aG + ((int) (((float) (top - point.y)) / 2.0f));
            layoutParams.topMargin = i4;
            layoutParams.bottomMargin = i4;
            int i5 = (int) (((float) (width - point.x)) / 2.0f);
            layoutParams.leftMargin = i5;
            layoutParams.rightMargin = i5;
            r1.setSurfaceTextureListener(this.zAi);
            this.hwr.addView(r1, 0, layoutParams);
            AppMethodBeat.o(94481);
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements TextureView.SurfaceTextureListener {
        private b() {
        }

        /* synthetic */ b(VideoSegmentUI videoSegmentUI, byte b2) {
            this();
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(94482);
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(VideoSegmentUI.this.zzT);
            objArr[1] = Boolean.valueOf(VideoSegmentUI.this.zzP == null);
            Log.i("MicroMsg.VideoSegmentUI", "TextureViewCallback create needResume[%b] segmentPlayer is null[%b]", objArr);
            VideoSegmentUI.this.mSurface = new Surface(surfaceTexture);
            if (VideoSegmentUI.this.zzP == null && VideoSegmentUI.this.zzT) {
                Log.i("MicroMsg.VideoSegmentUI", "MediaPlayer resume");
                try {
                    VideoSegmentUI.a(VideoSegmentUI.this, VideoSegmentUI.this.mSurface);
                    if (!(VideoSegmentUI.this.zzR == null || VideoSegmentUI.this.zzP == null)) {
                        VideoSegmentUI.this.zzP.setLoop((int) (((float) VideoSegmentUI.this.jkS) * VideoSegmentUI.this.zzR.eko()), (int) (((float) VideoSegmentUI.this.jkS) * VideoSegmentUI.this.zzR.ekp()));
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.VideoSegmentUI", e2, "ResumeMediaPlayer error %s", e2.getMessage());
                }
                VideoSegmentUI.this.zzT = false;
            }
            VideoSegmentUI.this.cZC.countDown();
            AppMethodBeat.o(94482);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(94483);
            Log.i("MicroMsg.VideoSegmentUI", "TextureViewCallback.surfaceDestroyed %s", Util.getStack());
            try {
                if (VideoSegmentUI.this.zzP != null) {
                    Log.i("MicroMsg.VideoSegmentUI", "TextureViewCallback MediaPlayer pause");
                    VideoSegmentUI.this.zzP.release();
                    VideoSegmentUI.this.zzP = null;
                    VideoSegmentUI.this.zzT = true;
                }
                VideoSegmentUI.this.mSurface = null;
            } catch (Exception e2) {
            }
            AppMethodBeat.o(94483);
            return false;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c5s;
    }

    static /* synthetic */ void a(VideoSegmentUI videoSegmentUI) {
        boolean z = false;
        AppMethodBeat.i(94495);
        videoSegmentUI.setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(94469);
                VideoSegmentUI.this.finish();
                VideoSegmentUI.b(VideoSegmentUI.this);
                AppMethodBeat.o(94469);
                return true;
            }
        });
        videoSegmentUI.setMMTitle(R.string.bqa);
        videoSegmentUI.addTextOptionMenu(0, com.tencent.mm.cb.a.aI(videoSegmentUI.getContext(), R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(94470);
                VideoSegmentUI.c(VideoSegmentUI.this);
                AppMethodBeat.o(94470);
                return true;
            }
        }, null, t.b.GREEN);
        videoSegmentUI.enableOptionMenu(false);
        Intent intent = videoSegmentUI.getIntent();
        if (intent == null || Util.isNullOrNil(intent.getStringExtra("key_video_path"))) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(intent == null);
            if (intent == null || intent.getStringExtra("key_video_path") == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            Log.e("MicroMsg.VideoSegmentUI", "is Intent null ? %b, is path null ? %b", objArr);
            videoSegmentUI.finish();
            AppMethodBeat.o(94495);
            return;
        }
        videoSegmentUI.zzN = intent.getStringExtra("key_video_path");
        Log.i("MicroMsg.VideoSegmentUI", "selectVideoPath: %s", videoSegmentUI.zzN);
        if (videoSegmentUI.zzN == null || videoSegmentUI.zzN.length() == 0) {
            Log.e("MicroMsg.VideoSegmentUI", "Please pick a video first");
            AppMethodBeat.o(94495);
            return;
        }
        videoSegmentUI.initView();
        try {
            videoSegmentUI.a(true, (Surface) null);
            videoSegmentUI.zzR.setOnPreparedListener(new c.a() {
                /* class com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.AnonymousClass12 */

                @Override // com.tencent.mm.plugin.mmsight.segment.c.a
                public final void ri(boolean z) {
                    AppMethodBeat.i(94478);
                    if (z) {
                        Toast.makeText(VideoSegmentUI.this, (int) R.string.f12, 1).show();
                        Log.e("MicroMsg.VideoSegmentUI", "Not Supported init SegmentSeekBar failed.");
                        VideoSegmentUI.this.zzU = true;
                        VideoSegmentUI.this.finish();
                        VideoSegmentUI.b(VideoSegmentUI.this);
                        AppMethodBeat.o(94478);
                        return;
                    }
                    if (!VideoSegmentUI.this.isFinishing() && VideoSegmentUI.this.zzR != null) {
                        VideoSegmentUI.this.jkS = VideoSegmentUI.this.zzR.getDurationMs();
                        Log.i("MicroMsg.VideoSegmentUI", "SeekBar.onPrepared success %d", Integer.valueOf(VideoSegmentUI.this.jkS));
                        try {
                            if (VideoSegmentUI.this.zzP != null) {
                                VideoSegmentUI.this.zzP.setLoop((int) (((float) VideoSegmentUI.this.jkS) * VideoSegmentUI.this.zzR.eko()), (int) (((float) VideoSegmentUI.this.jkS) * VideoSegmentUI.this.zzR.ekp()));
                            }
                        } catch (Exception e2) {
                        }
                    }
                    VideoSegmentUI.this.cZC.countDown();
                    AppMethodBeat.o(94478);
                }
            });
            videoSegmentUI.zzR.setThumbBarSeekListener(videoSegmentUI.zzW);
            videoSegmentUI.zzR.aFp(videoSegmentUI.zzN);
            videoSegmentUI.zzO = new p();
            ThreadPool.postAtFront(new d(videoSegmentUI, (byte) 0), "waiting_for_component_prepared.");
            AppMethodBeat.o(94495);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VideoSegmentUI", e2, "MediaPlayer set data source error : [%s]", e2.getMessage());
            videoSegmentUI.finish();
            AppMethodBeat.o(94495);
        }
    }

    static /* synthetic */ void b(VideoSegmentUI videoSegmentUI) {
        AppMethodBeat.i(94496);
        int i2 = 0;
        while (true) {
            try {
                if (((long) i2) < videoSegmentUI.cZC.getCount()) {
                    videoSegmentUI.cZC.countDown();
                    i2++;
                } else {
                    AppMethodBeat.o(94496);
                    return;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.VideoSegmentUI", "ensureNotWaiting e : %s", e2);
                AppMethodBeat.o(94496);
                return;
            }
        }
    }

    static /* synthetic */ void c(VideoSegmentUI videoSegmentUI) {
        AppMethodBeat.i(94497);
        String accVideoPath = CaptureMMProxy.getInstance().getAccVideoPath();
        long currentTimeMillis = System.currentTimeMillis();
        final String str = "vsg_output_" + currentTimeMillis + ".mp4";
        final String str2 = "vsg_thumb_" + currentTimeMillis + ".jpg";
        videoSegmentUI.rpE = accVideoPath + str;
        videoSegmentUI.thumbPath = accVideoPath + str2;
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(94474);
                Iterable<e> dC = s.dC(CaptureMMProxy.getInstance().getAccVideoPath(), false);
                if (dC == null) {
                    AppMethodBeat.o(94474);
                    return;
                }
                for (e eVar : dC) {
                    if (!eVar.RbJ && eVar.name != null) {
                        if ((eVar.name.startsWith("vsg_output_") && !eVar.name.equals(str)) || (eVar.name.startsWith("vsg_thumb_") && !eVar.name.equals(str2))) {
                            eVar.hdW();
                        }
                    }
                }
                AppMethodBeat.o(94474);
            }
        }, "delete_old_temp_video_file");
        if (Util.isNullOrNil(videoSegmentUI.rpE) || Util.isNullOrNil(videoSegmentUI.thumbPath)) {
            Log.e("MicroMsg.VideoSegmentUI", "Create output file failed.");
            AppMethodBeat.o(94497);
            return;
        }
        videoSegmentUI.zua = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
        if (videoSegmentUI.zua == null) {
            Log.e("MicroMsg.VideoSegmentUI", "VideoTransPara not provided.");
            AppMethodBeat.o(94497);
        } else if (videoSegmentUI.zzN == null) {
            Log.e("MicroMsg.VideoSegmentUI", "Please pick a video first");
            AppMethodBeat.o(94497);
        } else if (videoSegmentUI.cZC.getCount() != 0) {
            Log.e("MicroMsg.VideoSegmentUI", "Not prepared right now, please try again.");
            AppMethodBeat.o(94497);
        } else {
            Log.i("MicroMsg.VideoSegmentUI", "Start to process video");
            videoSegmentUI.getString(R.string.zb);
            videoSegmentUI.gtM = h.a((Context) videoSegmentUI, videoSegmentUI.getString(R.string.a06), false, (DialogInterface.OnCancelListener) null);
            videoSegmentUI.zzR.rh(true);
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.AnonymousClass7 */

                public final void run() {
                    final boolean z = true;
                    AppMethodBeat.i(94473);
                    final String str = null;
                    try {
                        VideoSegmentUI.this.zzP.stop();
                        int i2 = VideoSegmentUI.this.jkS;
                        long currentTicks = Util.currentTicks();
                        VideoSegmentUI.this.zzO.b(VideoSegmentUI.this.zzN, VideoSegmentUI.this.rpE, VideoSegmentUI.this.zua);
                        int ab = VideoSegmentUI.this.zzO.ab((long) (VideoSegmentUI.this.zzR.eko() * ((float) i2)), (long) (((float) i2) * VideoSegmentUI.this.zzR.ekp()));
                        if (ab < 0) {
                            Log.i("MicroMsg.VideoSegmentUI", "clip failed! %s", Integer.valueOf(ab));
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.AnonymousClass7.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(94471);
                                    if (VideoSegmentUI.this.gtM != null) {
                                        VideoSegmentUI.this.gtM.dismiss();
                                    }
                                    if (VideoSegmentUI.this.zzR != null) {
                                        VideoSegmentUI.this.zzR.rh(false);
                                    }
                                    Toast.makeText(VideoSegmentUI.this, (int) R.string.f12, 1).show();
                                    AppMethodBeat.o(94471);
                                }
                            });
                            AppMethodBeat.o(94473);
                            return;
                        }
                        Bitmap PF = com.tencent.mm.plugin.mmsight.d.PF(VideoSegmentUI.this.rpE);
                        if (PF != null) {
                            PInt pInt = new PInt();
                            PInt pInt2 = new PInt();
                            if (com.tencent.mm.plugin.mmsight.d.a(PF.getWidth(), PF.getHeight(), VideoSegmentUI.this.zua.iTf, pInt, pInt2)) {
                                PF = Bitmap.createScaledBitmap(PF, pInt.value, pInt2.value, true);
                            }
                            Log.i("MicroMsg.VideoSegmentUI", "getBitmap size = [%d, %d]", Integer.valueOf(PF.getWidth()), Integer.valueOf(PF.getHeight()));
                            BitmapUtil.saveBitmapToImage(PF, 80, Bitmap.CompressFormat.JPEG, VideoSegmentUI.this.thumbPath, true);
                            Log.i("MicroMsg.VideoSegmentUI", "create video thumb. use %dms", Long.valueOf(Util.ticksToNow(currentTicks)));
                        } else {
                            Log.e("MicroMsg.VideoSegmentUI", "getVideoThumb failed!");
                        }
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.AnonymousClass7.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(94472);
                                if (VideoSegmentUI.this.gtM != null) {
                                    VideoSegmentUI.this.gtM.dismiss();
                                }
                                if (VideoSegmentUI.this.zzR != null) {
                                    VideoSegmentUI.this.zzR.rh(false);
                                }
                                VideoSegmentUI.a(VideoSegmentUI.this, z, str);
                                AppMethodBeat.o(94472);
                            }
                        });
                        AppMethodBeat.o(94473);
                    } catch (Exception e2) {
                        str = e2.getMessage();
                        Log.printErrStackTrace("MicroMsg.VideoSegmentUI", e2, "UnexpectedException when clip : [%s]", e2.getMessage());
                        z = false;
                    }
                }
            }, "clip_video");
            AppMethodBeat.o(94497);
        }
    }

    static /* synthetic */ void a(VideoSegmentUI videoSegmentUI, boolean z, String str) {
        AppMethodBeat.i(94498);
        if (!z) {
            Log.e("MicroMsg.VideoSegmentUI", "Clip not success. %s", str);
            AppMethodBeat.o(94498);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("K_SEGMENTVIDEOPATH", videoSegmentUI.rpE);
        intent.putExtra("KSEGMENTVIDEOTHUMBPATH", videoSegmentUI.thumbPath);
        videoSegmentUI.setResult(-1, intent);
        videoSegmentUI.finish();
        AppMethodBeat.o(94498);
    }
}
