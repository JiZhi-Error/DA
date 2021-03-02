package com.tencent.mm.plugin.sysvideo.ui.video;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.video.VideoView;

public class VideoRecorderPreviewUI extends MMActivity {
    private VideoView FOp;
    private String FOq = null;
    private final int FOr = 3000;
    private MMHandler FOs = new MMHandler() {
        /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(29320);
            VideoRecorderPreviewUI.this.getWindow().setFlags(1024, 1024);
            VideoRecorderPreviewUI.this.hideTitleView();
            AppMethodBeat.o(29320);
        }
    };
    private long duration = -1;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VideoRecorderPreviewUI() {
        AppMethodBeat.i(29325);
        AppMethodBeat.o(29325);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29326);
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        hideTitleView();
        this.FOq = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
        setMMTitle(R.string.hxh);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29319);
                VideoRecorderPreviewUI.this.finish();
                BackwardSupportUtil.AnimationHelper.overridePendingTransition(VideoRecorderPreviewUI.this, 0, 0);
                AppMethodBeat.o(29319);
                return true;
            }
        });
        initView();
        AppMethodBeat.o(29326);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(29327);
        super.onStart();
        AppMethodBeat.o(29327);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(29329);
        super.onPause();
        if (this.FOp.isPlaying()) {
            VideoView videoView = this.FOp;
            if (videoView.mBq != null && videoView.mDW && videoView.mBq.isPlaying()) {
                videoView.mBq.pause();
            }
            videoView.cJi = false;
        }
        finish();
        BackwardSupportUtil.AnimationHelper.overridePendingTransition(this, 0, 0);
        this.FOs.removeMessages(0);
        AppMethodBeat.o(29329);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void dealContentView(View view) {
        AppMethodBeat.i(29330);
        ao.p(ao.a(getWindow(), (View) null), getBodyView());
        ((ViewGroup) getBodyView().getParent()).removeView(getBodyView());
        ((ViewGroup) getWindow().getDecorView()).addView(getBodyView(), 0);
        AppMethodBeat.o(29330);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c5p;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(29328);
        this.FOp = (VideoView) findViewById(R.id.j66);
        this.FOp.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI.AnonymousClass3 */

            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(29321);
                VideoRecorderPreviewUI.this.FOp.stopPlayback();
                h.n(VideoRecorderPreviewUI.this, R.string.hxg, R.string.hxe);
                AppMethodBeat.o(29321);
                return false;
            }
        });
        this.FOp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI.AnonymousClass4 */

            public final void onPrepared(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(29322);
                Log.d("MicroMsg.VideoRecorderPreviewUI", f.app() + " onPrepared");
                Log.d("MicroMsg.VideoRecorderPreviewUI", f.app() + " onPrepared");
                VideoView videoView = VideoRecorderPreviewUI.this.FOp;
                if (videoView.mBq == null || !videoView.mDW) {
                    videoView.cJi = true;
                } else {
                    videoView.mBq.start();
                    videoView.cJi = false;
                }
                VideoRecorderPreviewUI.this.FOs.sendEmptyMessageDelayed(0, 3000);
                AppMethodBeat.o(29322);
            }
        });
        findViewById(R.id.j65).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(29323);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                VideoRecorderPreviewUI.this.FOs.removeMessages(0);
                if (VideoRecorderPreviewUI.this.isTitleShowing()) {
                    VideoRecorderPreviewUI.this.getWindow().setFlags(1024, 1024);
                    VideoRecorderPreviewUI.this.hideTitleView();
                } else {
                    VideoRecorderPreviewUI.this.getWindow().clearFlags(1024);
                    VideoRecorderPreviewUI.this.showTitleView();
                    VideoRecorderPreviewUI.this.FOs.removeMessages(0);
                    VideoRecorderPreviewUI.this.FOs.sendEmptyMessageDelayed(0, 3000);
                }
                a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29323);
            }
        });
        this.FOp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            /* class com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI.AnonymousClass6 */

            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(29324);
                VideoRecorderPreviewUI.this.finish();
                BackwardSupportUtil.AnimationHelper.overridePendingTransition(VideoRecorderPreviewUI.this, 0, 0);
                AppMethodBeat.o(29324);
            }
        });
        if (this.FOq != null) {
            this.FOp.stopPlayback();
            this.FOp.setVideoURI(this.FOq);
        }
        AppMethodBeat.o(29328);
    }
}
