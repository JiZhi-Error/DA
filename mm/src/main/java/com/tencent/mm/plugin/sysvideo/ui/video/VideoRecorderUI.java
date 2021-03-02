package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.i.e;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.l.b;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.pluginsdk.l.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.t;

public class VideoRecorderUI extends MMActivity {
    private static VideoRecorderUI FOJ;
    private ImageView FOA;
    private ImageButton FOB = null;
    private ImageView FOC;
    private TextView FOD;
    private TextView FOE;
    private TextView FOF;
    private int FOG = 0;
    private boolean FOH;
    private ImageButton FOI;
    private boolean FOK = false;
    private boolean FOL = true;
    private String FOM = null;
    private View FON;
    private View FOO;
    SurfaceHolder.Callback FOP = new SurfaceHolder.Callback() {
        /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.AnonymousClass3 */

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            AppMethodBeat.i(29333);
            Log.d("MicroMsg.VideoRecorderUI", "surfaceCreated");
            if (VideoRecorderUI.this.FOu.d(VideoRecorderUI.this, VideoRecorderUI.this.FOK) != 0) {
                VideoRecorderUI.s(VideoRecorderUI.this);
            }
            AppMethodBeat.o(29333);
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            AppMethodBeat.i(29334);
            Log.d("MicroMsg.VideoRecorderUI", "surfaceDestroyed");
            VideoRecorderUI.this.FOL = true;
            VideoRecorderUI.this.FOu.goi();
            AppMethodBeat.o(29334);
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            AppMethodBeat.i(29335);
            Log.d("MicroMsg.VideoRecorderUI", "surfaceChanged for:" + i2 + " w:" + i3 + " h:" + i4);
            if (VideoRecorderUI.this.FOu.b(surfaceHolder) != 0) {
                VideoRecorderUI.s(VideoRecorderUI.this);
            }
            VideoRecorderUI.this.FOK = false;
            VideoRecorderUI.this.FOL = false;
            VideoRecorderUI.x(VideoRecorderUI.this);
            AppMethodBeat.o(29335);
        }
    };
    private String FOq = null;
    private b FOu;
    private ImageButton FOv;
    private boolean FOw = false;
    private boolean FOx = false;
    private TextView FOy;
    private LinearLayout FOz;
    private SurfaceHolder gQc = null;
    private ProgressDialog gtM = null;
    private SurfaceView mSurfaceView = null;
    private String mss = null;
    private long qPn = -1;
    private MTimerHandler qPy = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(29331);
            if (VideoRecorderUI.this.qPn == -1) {
                VideoRecorderUI.this.qPn = SystemClock.elapsedRealtime();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - VideoRecorderUI.this.qPn;
            VideoRecorderUI.this.FOD.setText(f.formatSecToMin((int) (elapsedRealtime / 1000)));
            if (elapsedRealtime > 30000 || elapsedRealtime < 20000) {
                VideoRecorderUI.this.FOy.setVisibility(8);
            } else {
                long j2 = (30000 - elapsedRealtime) / 1000;
                VideoRecorderUI.this.FOy.setVisibility(0);
                VideoRecorderUI.this.FOy.setText(VideoRecorderUI.this.getResources().getQuantityString(R.plurals.a_, (int) j2, Long.valueOf(j2)));
            }
            if (elapsedRealtime >= 30000) {
                Log.v("MicroMsg.VideoRecorderUI", "record stop on countdown");
                VideoRecorderUI.d(VideoRecorderUI.this);
                VideoRecorderUI.this.qPn = -1;
                AppMethodBeat.o(29331);
                return false;
            }
            VideoRecorderUI.this.FOG %= 2;
            if (VideoRecorderUI.this.FOG == 0) {
                VideoRecorderUI.this.FOC.setVisibility(4);
            } else {
                VideoRecorderUI.this.FOC.setVisibility(0);
            }
            VideoRecorderUI.g(VideoRecorderUI.this);
            AppMethodBeat.o(29331);
            return true;
        }
    }, true);
    private String talker = null;
    private String videoPath = null;
    private MMHandler zPV = new MMHandler() {
        /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.AnonymousClass9 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(29342);
            super.handleMessage(message);
            VideoRecorderUI.this.FOI.setEnabled(true);
            AppMethodBeat.o(29342);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VideoRecorderUI() {
        AppMethodBeat.i(29345);
        AppMethodBeat.o(29345);
    }

    static /* synthetic */ int g(VideoRecorderUI videoRecorderUI) {
        int i2 = videoRecorderUI.FOG;
        videoRecorderUI.FOG = i2 + 1;
        return i2;
    }

    static /* synthetic */ void j(VideoRecorderUI videoRecorderUI) {
        AppMethodBeat.i(29361);
        videoRecorderUI.ftB();
        AppMethodBeat.o(29361);
    }

    static /* synthetic */ void s(VideoRecorderUI videoRecorderUI) {
        AppMethodBeat.i(29363);
        videoRecorderUI.ftC();
        AppMethodBeat.o(29363);
    }

    static /* synthetic */ void u(VideoRecorderUI videoRecorderUI) {
        AppMethodBeat.i(29364);
        videoRecorderUI.resetStatus();
        AppMethodBeat.o(29364);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29346);
        super.onCreate(bundle);
        MMActivity.initLanguage(this);
        FOJ = this;
        getWindow().setFlags(1024, 1024);
        getSupportActionBar().hide();
        setMMTitle(R.string.hxn);
        addTextOptionMenu(0, getString(R.string.yq), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29337);
                Intent intent = new Intent();
                intent.putExtra("VideoRecorder_FileName", VideoRecorderUI.this.FOu.filename);
                intent.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.this.FOu.Dqi.iFw);
                intent.putExtra("VideoRecorder_ToUser", VideoRecorderUI.this.talker);
                VideoRecorderUI.this.setResult(-1, intent);
                VideoRecorderUI.this.finish();
                AppMethodBeat.o(29337);
                return true;
            }
        }, null, t.b.GREEN);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29338);
                VideoRecorderUI.j(VideoRecorderUI.this);
                AppMethodBeat.o(29338);
                return true;
            }
        });
        this.talker = getIntent().getStringExtra("VideoRecorder_ToUser");
        this.videoPath = getIntent().getStringExtra("VideoRecorder_VideoPath");
        this.FOq = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
        this.mss = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
        this.FOM = getIntent().getStringExtra("VideoRecorder_FileName");
        Log.d("MicroMsg.VideoRecorderUI", "talker :" + this.talker);
        Log.d("MicroMsg.VideoRecorderUI", "videoPath :" + this.videoPath + " videoFullPath " + this.FOq + " videoThumbPath " + this.mss + " KFileName " + this.FOM);
        initView();
        resetStatus();
        bg.Xi().akr();
        AppMethodBeat.o(29346);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(29347);
        super.onStart();
        if (this.FOH) {
            setRequestedOrientation(0);
            AppMethodBeat.o(29347);
            return;
        }
        setRequestedOrientation(1);
        AppMethodBeat.o(29347);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(29348);
        FOJ = null;
        Log.v("MicroMsg.VideoRecorderUI", "on destroy");
        bg.Xi().akq();
        super.onDestroy();
        AppMethodBeat.o(29348);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        int i2 = 1;
        AppMethodBeat.i(29349);
        this.mSurfaceView = (SurfaceView) findViewById(R.id.iep);
        this.FOz = (LinearLayout) findViewById(R.id.j67);
        this.gQc = this.mSurfaceView.getHolder();
        this.gQc.addCallback(this.FOP);
        this.gQc.setType(3);
        this.FOC = (ImageView) findViewById(R.id.j6_);
        this.FOI = (ImageButton) findViewById(R.id.j74);
        this.FOD = (TextView) findViewById(R.id.j68);
        this.FON = findViewById(R.id.j69);
        this.FOO = findViewById(R.id.j63);
        this.FOD.setText(f.formatSecToMin(0));
        this.FOu = new b();
        this.FOy = (TextView) findViewById(R.id.j79);
        this.FOE = (TextView) findViewById(R.id.j6a);
        this.FOF = (TextView) findViewById(R.id.j64);
        this.FOv = (ImageButton) findViewById(R.id.j76);
        this.FOv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(29340);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                bg.aVF();
                if (!c.isSDCardAvailable()) {
                    u.g(VideoRecorderUI.this, null);
                    a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(29340);
                    return;
                }
                if (VideoRecorderUI.this.FOx) {
                    VideoRecorderUI.d(VideoRecorderUI.this);
                } else if (VideoRecorderUI.this.FOw) {
                    h.a(VideoRecorderUI.this, VideoRecorderUI.this.getString(R.string.hxm), VideoRecorderUI.this.getString(R.string.zb), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.AnonymousClass7.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(29339);
                            VideoRecorderUI.this.FOv.setImageResource(R.drawable.bpu);
                            VideoRecorderUI.n(VideoRecorderUI.this);
                            AppMethodBeat.o(29339);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.AnonymousClass7.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                } else {
                    VideoRecorderUI.this.FOv.setImageResource(R.drawable.bpu);
                    VideoRecorderUI.n(VideoRecorderUI.this);
                }
                a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29340);
            }
        });
        if (d.getNumberOfCameras() > 1) {
            this.FOI.setVisibility(0);
        } else {
            this.FOI.setVisibility(4);
        }
        this.FOI.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(29341);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                VideoRecorderUI.this.FOI.setEnabled(false);
                VideoRecorderUI.this.zPV.sendEmptyMessageDelayed(0, 3000);
                VideoRecorderUI.this.FOK = true;
                VideoRecorderUI.this.FOu.goi();
                if (!(VideoRecorderUI.this.FOu.d(VideoRecorderUI.this, VideoRecorderUI.this.FOK) == 0 && VideoRecorderUI.this.FOu.b(VideoRecorderUI.this.gQc) == 0)) {
                    VideoRecorderUI.s(VideoRecorderUI.this);
                }
                a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29341);
            }
        });
        this.FOB = (ImageButton) findViewById(R.id.j5n);
        this.FOA = (ImageView) findViewById(R.id.j66);
        this.FOB.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(29343);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(VideoRecorderUI.this, VideoRecorderPreviewUI.class);
                intent.putExtra("VideoRecorder_FileName", VideoRecorderUI.this.FOu.filename);
                intent.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.this.FOu.Dqi.iFw);
                intent.putExtra("VideoRecorder_VideoSize", VideoRecorderUI.this.FOu.fileSize);
                intent.putExtra("VideoRecorder_ToUser", VideoRecorderUI.this.talker);
                intent.putExtra("VideoRecorder_VideoFullPath", VideoRecorderUI.this.FOq);
                VideoRecorderUI.this.startActivityForResult(intent, 0);
                BackwardSupportUtil.AnimationHelper.overridePendingTransition(VideoRecorderUI.this, 0, 0);
                a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29343);
            }
        });
        b bVar = this.FOu;
        if (!this.FOH) {
            z = true;
        } else {
            z = false;
        }
        String str = this.videoPath;
        String str2 = this.FOq;
        String str3 = this.mss;
        String str4 = this.FOM;
        bVar.jqs = 0;
        if (1 == bVar.jqs) {
            bVar.Dqi = com.tencent.mm.pluginsdk.l.a.goh();
        } else {
            bVar.Dqi = com.tencent.mm.pluginsdk.l.a.gog();
        }
        if (ae.gKv.gKa) {
            bVar.Dqi.ifO = ae.gKv.mVideoHeight;
            bVar.Dqi.ifN = ae.gKv.mVideoWidth;
            bVar.Dqi.zuR = ae.gKv.gKc;
        }
        bVar.filename = str4;
        bVar.Dqi.zuY = str2;
        bVar.Dqi.zuW = str3;
        bVar.Dqi.zuV = str + "temp.pcm";
        bVar.Dqi.zuU = str + "temp.yuv";
        bVar.Dqi.zuX = str + "temp.vid";
        bVar.Dqi.zva = d.getNumberOfCameras();
        com.tencent.mm.pluginsdk.l.a aVar = bVar.Dqi;
        if (!z) {
            i2 = 0;
        }
        aVar.dYT = i2;
        bVar.Dqi.iFw = 0;
        bVar.KaF = new g();
        AppMethodBeat.o(29349);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void dealContentView(View view) {
        AppMethodBeat.i(29350);
        ao.p(ao.a(getWindow(), (View) null), getBodyView());
        ((ViewGroup) getBodyView().getParent()).removeView(getBodyView());
        ((ViewGroup) getWindow().getDecorView()).addView(getBodyView(), 0);
        AppMethodBeat.o(29350);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(29351);
        if (i2 == 4) {
            Log.d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
            if (this.FOx) {
                AppMethodBeat.o(29351);
                return true;
            }
            ftB();
            AppMethodBeat.o(29351);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(29351);
        return onKeyDown;
    }

    private void ftB() {
        AppMethodBeat.i(29352);
        if (this.FOw) {
            h.a(this, getString(R.string.hxl), getString(R.string.zb), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(29344);
                    VideoRecorderUI.this.finish();
                    AppMethodBeat.o(29344);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.AnonymousClass12 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(29352);
            return;
        }
        finish();
        AppMethodBeat.o(29352);
    }

    private void resetStatus() {
        AppMethodBeat.i(29353);
        getSupportActionBar().hide();
        this.FOD.setText(f.formatSecToMin(0));
        this.FON.setVisibility(8);
        this.FOO.setVisibility(8);
        this.FOC.setVisibility(0);
        this.FOw = false;
        this.FOz.setVisibility(0);
        this.mSurfaceView.setVisibility(0);
        this.FOy.setVisibility(8);
        this.FOB.setVisibility(8);
        this.FOD.setText(f.formatSecToMin(0));
        this.FOA.setVisibility(8);
        this.FOv.setEnabled(true);
        this.FOI.setVisibility(0);
        AppMethodBeat.o(29353);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(29354);
        if (!this.FOL && !(this.FOu.d(this, false) == 0 && this.FOu.b(this.gQc) == 0)) {
            ftC();
        }
        this.FOL = false;
        Log.v("MicroMsg.VideoRecorderUI", "onResume");
        super.onResume();
        AppMethodBeat.o(29354);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(29355);
        if (this.FOx) {
            b bVar = this.FOu;
            if (bVar.zwf != null) {
                bVar.zwf.stop();
                bVar.zwf.release();
                bVar.zwf = null;
            }
            resetStatus();
            this.FOx = false;
            releaseWakeLock();
            this.FOv.setImageResource(R.drawable.bpt);
            this.qPy.stopTimer();
            this.FOy.setVisibility(8);
            this.FOz.setVisibility(0);
            this.mSurfaceView.setVisibility(0);
        }
        this.FOu.goi();
        Log.v("MicroMsg.VideoRecorderUI", "onPause");
        super.onPause();
        AppMethodBeat.o(29355);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(29356);
        if (i3 != -1) {
            AppMethodBeat.o(29356);
            return;
        }
        if (i2 == 0) {
            setResult(-1, intent);
            finish();
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(29356);
    }

    private void ftC() {
        AppMethodBeat.i(29357);
        h.a(this, (int) R.string.hw7, (int) R.string.zb, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(29336);
                VideoRecorderUI.this.FOu.goi();
                VideoRecorderUI.this.finish();
                AppMethodBeat.o(29336);
            }
        });
        AppMethodBeat.o(29357);
    }

    private void releaseWakeLock() {
        AppMethodBeat.i(29358);
        this.mSurfaceView.setKeepScreenOn(false);
        AppMethodBeat.o(29358);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(29359);
        if (ae.gKt.gFQ == 1) {
            z = true;
        } else if (Build.VERSION.SDK_INT != 10 || !Build.MODEL.equals("GT-S5360")) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            z2 = false;
        }
        this.FOH = z2;
        if (!this.FOH) {
            AppMethodBeat.o(29359);
            return R.layout.c5n;
        }
        getWindow().setFlags(1024, 1024);
        setRequestedOrientation(0);
        AppMethodBeat.o(29359);
        return R.layout.c5o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01f0 A[SYNTHETIC, Splitter:B:58:0x01f0] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0207 A[SYNTHETIC, Splitter:B:65:0x0207] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x025c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void d(com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI r13) {
        /*
        // Method dump skipped, instructions count: 681
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.d(com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI):void");
    }

    static /* synthetic */ void n(VideoRecorderUI videoRecorderUI) {
        AppMethodBeat.i(29362);
        videoRecorderUI.hideTitleView();
        videoRecorderUI.FOz.setVisibility(0);
        videoRecorderUI.mSurfaceView.setVisibility(0);
        videoRecorderUI.FOI.setVisibility(8);
        videoRecorderUI.FOO.setVisibility(8);
        videoRecorderUI.FOx = true;
        videoRecorderUI.FOA.setVisibility(8);
        videoRecorderUI.FOB.setVisibility(8);
        videoRecorderUI.FON.setVisibility(0);
        videoRecorderUI.FOy.setVisibility(0);
        videoRecorderUI.qPn = -1;
        videoRecorderUI.qPy.startTimer(300);
        videoRecorderUI.mSurfaceView.setKeepScreenOn(true);
        b bVar = videoRecorderUI.FOu;
        SurfaceHolder surfaceHolder = videoRecorderUI.gQc;
        if (surfaceHolder == null) {
            Log.e("MicroMsg.SceneVideo", "start fail, holder is null");
            AppMethodBeat.o(29362);
            return;
        }
        Surface surface = surfaceHolder.getSurface();
        bVar.KaG = 0;
        int i2 = bVar.Dqi.fps;
        int i3 = 0;
        while (bVar.KaF != null) {
            Camera camera = bVar.KaF.gGr.gII;
            if (surface == null || camera == null) {
                Log.e("MicroMsg.SceneVideo", "holder or cam is null ");
                AppMethodBeat.o(29362);
                return;
            }
            int i4 = ae.gKE.gGQ == -1 ? i2 : ae.gKE.gGQ;
            int cameraId = g.getCameraId();
            try {
                camera.unlock();
            } catch (Exception e2) {
                Log.w("MicroMsg.SceneVideo", "exception in cam.unlock() [%s]", e2.getMessage());
            }
            bVar.zwf = new e();
            bVar.zwf.setCamera(camera);
            bVar.zwf.setAudioSource(5);
            bVar.zwf.setVideoSource(1);
            bVar.zwf.setOutputFormat(2);
            bVar.zwf.setVideoSize(bVar.Dqi.sUz, bVar.Dqi.sUA);
            bVar.zwf.setVideoEncoder(2);
            bVar.zwf.setAudioEncoder(3);
            if (Build.VERSION.SDK_INT > 7) {
                bVar.zwf.setVideoEncodingBitRate(bVar.Dqi.zuR);
            }
            try {
                if (ae.gKv.gKa) {
                    bVar.zwf.setVideoFrameRate(ae.gKv.gKb);
                } else {
                    bVar.zwf.setVideoFrameRate(i4);
                }
            } catch (Exception e3) {
                Log.d("MicroMsg.SceneVideo", "try set fps failed: ".concat(String.valueOf(i4)));
            }
            bVar.zwf.setOutputFile(bVar.Dqi.zuY);
            bVar.zwf.setPreviewDisplay(surface);
            Log.d("MicroMsg.SceneVideo", "doStart camid[%s] params:\n%s", Integer.valueOf(cameraId), bVar.Dqi.toString());
            if (cameraId == 0) {
                bVar.setOrientationHint(ae.gKE.gGK == -1 ? 90 : ae.gKE.gGK);
            } else {
                bVar.setOrientationHint(ae.gKE.gGL == -1 ? 270 : ae.gKE.gGL);
            }
            try {
                bVar.zwf.prepare();
                bVar.zwf.start();
                AppMethodBeat.o(29362);
                return;
            } catch (Exception e4) {
                Log.w("MicroMsg.SceneVideo", "exception in mediaRecorder[%s] doStartCount[%s]", e4.getMessage(), Integer.valueOf(bVar.KaG));
                Log.printErrStackTrace("MicroMsg.SceneVideo", e4, "", new Object[0]);
                bVar.KaG++;
                if (bVar.KaG < 5) {
                    g gVar = bVar.KaF;
                    if (i3 < 0 || i3 >= gVar.KaO.size()) {
                        Log.d("MicroMsg.YuvReocrder", "ret fr ".concat(String.valueOf(i2)));
                    } else {
                        Log.d("MicroMsg.YuvReocrder", "ret fr " + gVar.KaO.get(i3));
                        i2 = gVar.KaO.get(i3).intValue();
                    }
                    i3++;
                } else {
                    AppMethodBeat.o(29362);
                    return;
                }
            }
        }
        Log.e("MicroMsg.SceneVideo", "yuvRecoder is null");
        AppMethodBeat.o(29362);
    }

    static /* synthetic */ void x(VideoRecorderUI videoRecorderUI) {
        int previewWidth;
        int previewHeight;
        int i2;
        int i3;
        AppMethodBeat.i(29365);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) videoRecorderUI.mSurfaceView.getLayoutParams();
        DisplayMetrics displayMetrics = videoRecorderUI.getResources().getDisplayMetrics();
        if (!videoRecorderUI.FOH) {
            previewWidth = videoRecorderUI.FOu.getPreviewHeight();
            previewHeight = videoRecorderUI.FOu.getPreviewWidth();
        } else {
            previewWidth = videoRecorderUI.FOu.getPreviewWidth();
            previewHeight = videoRecorderUI.FOu.getPreviewHeight();
        }
        Log.i("MicroMsg.VideoRecorderUI", "resizeLayout priveview[%d, %d], dm[%d, %d]", Integer.valueOf(previewWidth), Integer.valueOf(previewHeight), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        if (((float) previewWidth) / ((float) previewHeight) > ((float) displayMetrics.widthPixels) / ((float) displayMetrics.heightPixels)) {
            Log.i("MicroMsg.VideoRecorderUI", "resizeLayout wider");
            int i4 = displayMetrics.widthPixels;
            i3 = (int) (((float) previewHeight) * (((float) displayMetrics.widthPixels) / ((float) previewWidth)));
            i2 = i4;
        } else {
            Log.i("MicroMsg.VideoRecorderUI", "resizeLayout higher");
            int i5 = displayMetrics.heightPixels;
            i2 = (int) ((((float) displayMetrics.heightPixels) / ((float) previewHeight)) * ((float) previewWidth));
            i3 = i5;
        }
        Log.i("MicroMsg.VideoRecorderUI", "resizeLayout width:%d, height:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        layoutParams.width = i2;
        layoutParams.height = i3;
        videoRecorderUI.mSurfaceView.setLayoutParams(layoutParams);
        AppMethodBeat.o(29365);
    }
}
