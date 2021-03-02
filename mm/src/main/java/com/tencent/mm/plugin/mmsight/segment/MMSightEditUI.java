package com.tencent.mm.plugin.mmsight.segment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.a.a;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.ui.VideoSeekBarEditorView;
import com.tencent.mm.plugin.mmsight.ui.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.a;

@a(3)
public class MMSightEditUI extends MMActivity {
    private d gVN = new d(MMApplicationContext.getContext());
    private ViewGroup hwr;
    private String rpE;
    private String thumbPath;
    private String videoPath;
    private VideoTransPara zua;
    private VideoPlayerTextureView zyd;
    private VideoSeekBarEditorView zye;
    private String zyf;
    private b zyg;
    private boolean zyh = false;
    private boolean zyi = true;
    private boolean zyj = false;
    private j.a zyk = new j.a() {
        /* class com.tencent.mm.plugin.mmsight.segment.MMSightEditUI.AnonymousClass3 */

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void onError(int i2, int i3) {
            AppMethodBeat.i(94396);
            Log.e("MicroMsg.MMSightEditUI", "%d on error what %d extra %d", Integer.valueOf(MMSightEditUI.this.hashCode()), Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(94396);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void tf() {
            AppMethodBeat.i(94397);
            if (MMSightEditUI.this.zyd != null) {
                MMSightEditUI.this.zyd.start();
                MMSightEditUI.this.zyd.setLoop(true);
                MMSightEditUI.this.zyd.setAlpha(1.0f);
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.mmsight.segment.MMSightEditUI.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(94395);
                        MMSightEditUI.k(MMSightEditUI.this);
                        AppMethodBeat.o(94395);
                    }
                }, 300);
            }
            AppMethodBeat.o(94397);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void onCompletion() {
            AppMethodBeat.i(94398);
            MMSightEditUI.this.zyd.d(0.0d, true);
            AppMethodBeat.o(94398);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final int fh(int i2, int i3) {
            return 0;
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void eo(int i2, int i3) {
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MMSightEditUI() {
        AppMethodBeat.i(94399);
        AppMethodBeat.o(94399);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(94400);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().addFlags(2097280);
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            getWindow().setFlags(201327616, 201327616);
            com.tencent.mm.plugin.mmsight.d.rb(true);
        } else {
            getWindow().setFlags(1024, 1024);
            com.tencent.mm.plugin.mmsight.d.rb(false);
        }
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.gVN));
        final long currentTicks = Util.currentTicks();
        this.gVN.connect(new Runnable() {
            /* class com.tencent.mm.plugin.mmsight.segment.MMSightEditUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(94390);
                Log.i("MicroMsg.MMSightEditUI", "connect cost %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
                if (CaptureMMProxy.getInstance() != null) {
                    ae.DV(CaptureMMProxy.getInstance().getDeviceInfoConfig());
                }
                MMSightEditUI.a(MMSightEditUI.this);
                AppMethodBeat.o(94390);
            }
        });
        AppMethodBeat.o(94400);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bau;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(94401);
        if (this.zyg == null || !this.zyg.onBackPressed()) {
            super.onBackPressed();
            AppMethodBeat.o(94401);
            return;
        }
        AppMethodBeat.o(94401);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(94402);
        super.onPause();
        if (this.zyd != null) {
            this.zyd.pause();
        }
        AppMethodBeat.o(94402);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(94403);
        super.onResume();
        if (this.zyd != null) {
            this.zyd.start();
        }
        AppMethodBeat.o(94403);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(94404);
        super.onDestroy();
        if (this.zyd != null) {
            this.zyd.stop();
        }
        if (this.zyg != null) {
            if (this.zyj) {
                com.tencent.mm.plugin.mmsight.a.a.a(new a.C1478a(this.zyg.scene));
            }
            this.zyg.release();
        }
        AppMethodBeat.o(94404);
    }

    static /* synthetic */ void a(MMSightEditUI mMSightEditUI) {
        AppMethodBeat.i(94405);
        if (au.aA(mMSightEditUI)) {
            mMSightEditUI.setSelfNavigationBarColor(-637534208);
            mMSightEditUI.setSelfNavigationBarVisible(0);
        }
        mMSightEditUI.hwr = (ViewGroup) mMSightEditUI.findViewById(R.id.h8v);
        mMSightEditUI.zyd = (VideoPlayerTextureView) mMSightEditUI.findViewById(R.id.j5s);
        mMSightEditUI.zye = (VideoSeekBarEditorView) mMSightEditUI.findViewById(R.id.j6g);
        mMSightEditUI.zyf = mMSightEditUI.getIntent().getStringExtra("key_text_color");
        mMSightEditUI.zye.setTextColor(mMSightEditUI.zyf);
        mMSightEditUI.videoPath = mMSightEditUI.getIntent().getStringExtra("key_video_path");
        mMSightEditUI.zua = (VideoTransPara) mMSightEditUI.getIntent().getParcelableExtra("key_video_para");
        mMSightEditUI.zyh = mMSightEditUI.getIntent().getBooleanExtra("key_need_clip_video_first", false);
        mMSightEditUI.zyi = mMSightEditUI.getIntent().getBooleanExtra("key_need_remux_video", true);
        int intExtra = mMSightEditUI.getIntent().getIntExtra("key_max_duration_seconds", 0);
        Log.i("MicroMsg.MMSightEditUI", "maxDurationSeconds: %s", Integer.valueOf(intExtra));
        if (!mMSightEditUI.zyi) {
            mMSightEditUI.zyh = true;
        }
        if (Util.isNullOrNil(mMSightEditUI.videoPath)) {
            Log.e("MicroMsg.MMSightEditUI", "error!, videoPath is null!!");
            AppMethodBeat.o(94405);
            return;
        }
        if (mMSightEditUI.zua == null) {
            Log.e("MicroMsg.MMSightEditUI", "videoTransPara is null!, use SnsAlbumVideoTransPara");
            mMSightEditUI.zua = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
        }
        if (mMSightEditUI.zua == null) {
            Log.e("MicroMsg.MMSightEditUI", "videoTransPara still null!!!");
            mMSightEditUI.zua = new VideoTransPara();
        }
        if (intExtra > 0) {
            mMSightEditUI.zua.duration = intExtra;
        }
        Log.i("MicroMsg.MMSightEditUI", "videoTransPara: %s", mMSightEditUI.zua);
        mMSightEditUI.zyd.setAlpha(0.0f);
        mMSightEditUI.zyd.setVideoPath(mMSightEditUI.videoPath);
        mMSightEditUI.zyd.setLoop(true);
        mMSightEditUI.zyd.setForceScaleFullScreen(true);
        mMSightEditUI.zyd.setVideoCallback(mMSightEditUI.zyk);
        mMSightEditUI.rpE = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
        mMSightEditUI.thumbPath = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg";
        if (au.aA(mMSightEditUI)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) mMSightEditUI.zye.getLayoutParams();
            marginLayoutParams.bottomMargin += au.aD(mMSightEditUI);
            mMSightEditUI.zye.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(94405);
    }

    static /* synthetic */ void k(MMSightEditUI mMSightEditUI) {
        AppMethodBeat.i(94406);
        mMSightEditUI.zyg = new b();
        mMSightEditUI.zyg.zCs = true;
        mMSightEditUI.zyg.zCv = 2;
        mMSightEditUI.zyg.zCy = mMSightEditUI.zyi;
        mMSightEditUI.zyg.zCq = new b.a() {
            /* class com.tencent.mm.plugin.mmsight.segment.MMSightEditUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.mmsight.ui.b.a
            public final void eks() {
                AppMethodBeat.i(94392);
                Log.i("MicroMsg.MMSightEditUI", "onEditFinish");
                try {
                    MMSightEditUI.this.zyj = true;
                    long j2 = (long) MMSightEditUI.this.zyg.zCh;
                    long j3 = (long) MMSightEditUI.this.zyg.zCi;
                    if (MMSightEditUI.this.zyg != null) {
                        MMSightEditUI.this.zyg.rm(false);
                        MMSightEditUI.this.zyg.release();
                        MMSightEditUI.this.zyg = null;
                    }
                    if (!MMSightEditUI.this.zyi) {
                        Intent intent = new Intent();
                        intent.putExtra("K_SEGMENTVIDEOPATH", MMSightEditUI.this.videoPath);
                        intent.putExtra("key_seek_look_start_time", j2);
                        intent.putExtra("key_seek_end_time", j3);
                        MMSightEditUI.this.setResult(-1, intent);
                        MMSightEditUI.this.finish();
                        AppMethodBeat.o(94392);
                        return;
                    }
                    Bitmap PF = com.tencent.mm.plugin.mmsight.d.PF(MMSightEditUI.this.rpE);
                    if (PF != null) {
                        PInt pInt = new PInt();
                        PInt pInt2 = new PInt();
                        if (com.tencent.mm.plugin.mmsight.d.a(PF.getWidth(), PF.getHeight(), MMSightEditUI.this.zua.iTf, pInt, pInt2)) {
                            PF = Bitmap.createScaledBitmap(PF, pInt.value, pInt2.value, true);
                        }
                        Log.i("MicroMsg.MMSightEditUI", "getBitmap size = [%d, %d]", Integer.valueOf(PF.getWidth()), Integer.valueOf(PF.getHeight()));
                        BitmapUtil.saveBitmapToImage(PF, 80, Bitmap.CompressFormat.JPEG, MMSightEditUI.this.thumbPath, true);
                        Intent intent2 = new Intent();
                        intent2.putExtra("K_SEGMENTVIDEOPATH", MMSightEditUI.this.rpE);
                        intent2.putExtra("KSEGMENTVIDEOTHUMBPATH", MMSightEditUI.this.thumbPath);
                        MMSightEditUI.this.setResult(-1, intent2);
                        MMSightEditUI.this.finish();
                        AppMethodBeat.o(94392);
                        return;
                    }
                    Log.e("MicroMsg.MMSightEditUI", "getVideoThumb failed!");
                    AppMethodBeat.o(94392);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.MMSightEditUI", e2, "save video thumb error", new Object[0]);
                    Toast.makeText(MMSightEditUI.this, (int) R.string.f12, 1).show();
                    MMSightEditUI.this.finish();
                    AppMethodBeat.o(94392);
                }
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.b.a
            public final void ekt() {
                AppMethodBeat.i(94393);
                Log.i("MicroMsg.MMSightEditUI", "onExitEdit");
                if (MMSightEditUI.this.zyg != null) {
                    MMSightEditUI.this.zyg.rm(true);
                    MMSightEditUI.this.zyg.release();
                    MMSightEditUI.this.zyg = null;
                }
                MMSightEditUI.this.finish();
                AppMethodBeat.o(94393);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.b.a
            public final void onError() {
                AppMethodBeat.i(94394);
                if (MMSightEditUI.this.zyg != null) {
                    MMSightEditUI.this.zyg.release();
                    MMSightEditUI.this.zyg = null;
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.mmsight.segment.MMSightEditUI.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(94391);
                        Toast.makeText(MMSightEditUI.this, (int) R.string.f12, 1).show();
                        AppMethodBeat.o(94391);
                    }
                });
                AppMethodBeat.o(94394);
            }
        };
        mMSightEditUI.zyg.videoOutputPath = mMSightEditUI.rpE;
        mMSightEditUI.zyg.zCx = true;
        mMSightEditUI.zyg.a(mMSightEditUI, 512, mMSightEditUI.videoPath, mMSightEditUI.zye, mMSightEditUI.zyd, mMSightEditUI.hwr, mMSightEditUI.zua, mMSightEditUI.zyh);
        AppMethodBeat.o(94406);
    }
}
