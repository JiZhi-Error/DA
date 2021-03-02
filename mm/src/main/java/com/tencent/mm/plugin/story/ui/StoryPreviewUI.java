package com.tencent.mm.plugin.story.ui;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(hxD = {1, 1, 16}, hxE = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StoryPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "videoCallBack", "com/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1", "Lcom/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1;", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-story_release"})
public final class StoryPreviewUI extends MMActivity {
    private final b Fxg = new b(this);
    private final String TAG = "MicroMsg.StoryPreviewUI";
    private VideoPlayerTextureView zyd;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public StoryPreviewUI() {
        AppMethodBeat.i(119645);
        AppMethodBeat.o(119645);
    }

    public static final /* synthetic */ VideoPlayerTextureView a(StoryPreviewUI storyPreviewUI) {
        AppMethodBeat.i(119646);
        VideoPlayerTextureView videoPlayerTextureView = storyPreviewUI.zyd;
        if (videoPlayerTextureView == null) {
            p.btv("videoPlayView");
        }
        AppMethodBeat.o(119646);
        return videoPlayerTextureView;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
    public static final class b implements j.a {
        final /* synthetic */ StoryPreviewUI Fxh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(StoryPreviewUI storyPreviewUI) {
            this.Fxh = storyPreviewUI;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTextureUpdate"})
        static final class a implements j.e {
            final /* synthetic */ b Fxi;

            a(b bVar) {
                this.Fxi = bVar;
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.e
            public final void bLh() {
                AppMethodBeat.i(119640);
                StoryPreviewUI.a(this.Fxi.Fxh).setVisibility(0);
                StoryPreviewUI.a(this.Fxi.Fxh).setAlpha(1.0f);
                AppMethodBeat.o(119640);
            }
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void tf() {
            AppMethodBeat.i(119641);
            StoryPreviewUI.a(this.Fxh).setOneTimeVideoTextureUpdateCallback(new a(this));
            StoryPreviewUI.a(this.Fxh).start();
            AppMethodBeat.o(119641);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void onCompletion() {
            AppMethodBeat.i(119642);
            StoryPreviewUI.a(this.Fxh).d(0.0d, true);
            AppMethodBeat.o(119642);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final int fh(int i2, int i3) {
            return 0;
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void eo(int i2, int i3) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void onError(int i2, int i3) {
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(119643);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        setSelfNavigationBarVisible(8);
        getWindow().addFlags(2097280);
        if (d.oD(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(1024, 1024);
        }
        String stringExtra = getIntent().getStringExtra("video_path");
        View findViewById = findViewById(R.id.icc);
        p.g(findViewById, "findViewById(R.id.story_preview_play_view)");
        this.zyd = (VideoPlayerTextureView) findViewById;
        VideoPlayerTextureView videoPlayerTextureView = this.zyd;
        if (videoPlayerTextureView == null) {
            p.btv("videoPlayView");
        }
        videoPlayerTextureView.setVideoPath(stringExtra);
        VideoPlayerTextureView videoPlayerTextureView2 = this.zyd;
        if (videoPlayerTextureView2 == null) {
            p.btv("videoPlayView");
        }
        videoPlayerTextureView2.setVideoCallback(this.Fxg);
        VideoPlayerTextureView videoPlayerTextureView3 = this.zyd;
        if (videoPlayerTextureView3 == null) {
            p.btv("videoPlayView");
        }
        videoPlayerTextureView3.setAlpha(0.0f);
        findViewById(R.id.icb).setOnClickListener(new a(this));
        AppMethodBeat.o(119643);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ StoryPreviewUI Fxh;

        a(StoryPreviewUI storyPreviewUI) {
            this.Fxh = storyPreviewUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119639);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StoryPreviewUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Fxh.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StoryPreviewUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119639);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.c0s;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(119644);
        super.onDestroy();
        VideoPlayerTextureView videoPlayerTextureView = this.zyd;
        if (videoPlayerTextureView == null) {
            p.btv("videoPlayView");
        }
        videoPlayerTextureView.stop();
        AppMethodBeat.o(119644);
    }
}
