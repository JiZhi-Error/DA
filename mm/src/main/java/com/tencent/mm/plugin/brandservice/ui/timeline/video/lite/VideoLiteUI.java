package com.tencent.mm.plugin.brandservice.ui.timeline.video.lite;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteControBar;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(32)
@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0014J\b\u0010\u001a\u001a\u00020\u0012H\u0014J\b\u0010\u001b\u001a\u00020\u0012H\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u0012H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "btnCenterPlayer", "Landroid/widget/ImageView;", "mVideoUrl", "mVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "videoLiteControlBar", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteControBar;", "getLayoutId", "", "getUIFlag", "initVideoView", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSwipeBackFinish", "", "onWindowFocusChanged", "hasFocus", "setWindowStyle", "plugin-brandservice_release"})
public final class VideoLiteUI extends MMActivity {
    private final String TAG = "MicroMsg.VideoLiteUI";
    private HashMap _$_findViewCache;
    private String nYm;
    private AppBrandVideoView nYn;
    private VideoLiteControBar pKb;
    private ImageView pKc;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(195971);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(195971);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(195970);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(195970);
        return view;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.c5g;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(195964);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        setSelfNavigationBarVisible(8);
        d.rb(true);
        Window window = getWindow();
        p.g(window, "window");
        window.setNavigationBarColor(WebView.NIGHT_MODE_COLOR);
        Window window2 = getWindow();
        p.g(window2, "window");
        View decorView = window2.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(1284);
        this.nYm = getIntent().getStringExtra("rawUrl");
        this.pKc = (ImageView) findViewById(R.id.aqa);
        ImageView imageView = this.pKc;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        AppBrandVideoWrapper appBrandVideoWrapper = new AppBrandVideoWrapper(this);
        appBrandVideoWrapper.setMyVideoViewFactory(f.mFb);
        this.nYn = new AppBrandVideoView(this, appBrandVideoWrapper);
        this.pKb = new VideoLiteControBar(this);
        VideoLiteControBar videoLiteControBar = this.pKb;
        if (videoLiteControBar == null) {
            p.hyc();
        }
        videoLiteControBar.setBtnCloseListener(new a(this));
        VideoLiteControBar videoLiteControBar2 = this.pKb;
        if (videoLiteControBar2 == null) {
            p.hyc();
        }
        videoLiteControBar2.setOnPlayStatusChangeListener(new b(this));
        AppBrandVideoView appBrandVideoView = this.nYn;
        if (appBrandVideoView != null) {
            appBrandVideoView.a(this.pKb);
        }
        appBrandVideoWrapper.setVideoFooterView(this.pKb);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.be_);
        if (frameLayout != null) {
            frameLayout.addView(this.nYn, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        ImageView imageView2 = this.pKc;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new c(this));
        }
        AppBrandVideoView appBrandVideoView2 = this.nYn;
        if (appBrandVideoView2 != null) {
            appBrandVideoView2.setAutoPlay(true);
        }
        AppBrandVideoView appBrandVideoView3 = this.nYn;
        if (appBrandVideoView3 != null) {
            appBrandVideoView3.setLoop(false);
        }
        AppBrandVideoView appBrandVideoView4 = this.nYn;
        if (appBrandVideoView4 != null) {
            appBrandVideoView4.setMute(false);
        }
        AppBrandVideoView appBrandVideoView5 = this.nYn;
        if (appBrandVideoView5 != null) {
            appBrandVideoView5.setCookieData(null);
        }
        AppBrandVideoView appBrandVideoView6 = this.nYn;
        if (appBrandVideoView6 != null) {
            appBrandVideoView6.setObjectFit("contain");
        }
        AppBrandVideoView appBrandVideoView7 = this.nYn;
        if (appBrandVideoView7 != null) {
            appBrandVideoView7.setShowDanmakuBtn(false);
        }
        AppBrandVideoView appBrandVideoView8 = this.nYn;
        if (appBrandVideoView8 != null) {
            appBrandVideoView8.setShowMuteBtn(false);
        }
        AppBrandVideoView appBrandVideoView9 = this.nYn;
        if (appBrandVideoView9 != null) {
            appBrandVideoView9.setShowPlayBtn(true);
        }
        AppBrandVideoView appBrandVideoView10 = this.nYn;
        if (appBrandVideoView10 != null) {
            appBrandVideoView10.setShowProgress(true);
        }
        AppBrandVideoView appBrandVideoView11 = this.nYn;
        if (appBrandVideoView11 != null) {
            appBrandVideoView11.setShowFullScreenBtn(false);
        }
        AppBrandVideoView appBrandVideoView12 = this.nYn;
        if (appBrandVideoView12 != null) {
            appBrandVideoView12.setIsShowBasicControls(true);
        }
        AppBrandVideoView appBrandVideoView13 = this.nYn;
        if (appBrandVideoView13 != null) {
            appBrandVideoView13.setIsEnableBottomProgressBar(false);
        }
        AppBrandVideoView appBrandVideoView14 = this.nYn;
        if (appBrandVideoView14 != null) {
            appBrandVideoView14.setShowCenterPlayBtn(false);
        }
        AppBrandVideoView appBrandVideoView15 = this.nYn;
        if (appBrandVideoView15 != null) {
            appBrandVideoView15.setShowControlProgress(true);
        }
        AppBrandVideoView appBrandVideoView16 = this.nYn;
        if (appBrandVideoView16 != null) {
            appBrandVideoView16.setPageGesture(true);
        }
        AppBrandVideoView appBrandVideoView17 = this.nYn;
        if (appBrandVideoView17 != null) {
            appBrandVideoView17.hM(true);
        }
        AppBrandVideoView appBrandVideoView18 = this.nYn;
        if (appBrandVideoView18 != null) {
            appBrandVideoView18.e(this.nYm, false, 0);
            AppMethodBeat.o(195964);
            return;
        }
        AppMethodBeat.o(195964);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ VideoLiteUI pKd;

        a(VideoLiteUI videoLiteUI) {
            this.pKd = videoLiteUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195961);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.pKd.onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195961);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "isPlay", "", "onPlayStatusChange"})
    static final class b implements VideoLiteControBar.a {
        final /* synthetic */ VideoLiteUI pKd;

        b(VideoLiteUI videoLiteUI) {
            this.pKd = videoLiteUI;
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteControBar.a
        public final void kr(boolean z) {
            AppMethodBeat.i(195962);
            ImageView imageView = this.pKd.pKc;
            if (imageView != null) {
                imageView.setVisibility(z ? 8 : 0);
                AppMethodBeat.o(195962);
                return;
            }
            AppMethodBeat.o(195962);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ VideoLiteUI pKd;

        c(VideoLiteUI videoLiteUI) {
            this.pKd = videoLiteUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195963);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            AppBrandVideoView appBrandVideoView = this.pKd.nYn;
            if (appBrandVideoView != null) {
                appBrandVideoView.start();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195963);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(195965);
        AppMethodBeat.at(this, z);
        super.onWindowFocusChanged(z);
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(1284);
        AppMethodBeat.o(195965);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(195966);
        p.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        VideoLiteControBar videoLiteControBar = this.pKb;
        if (videoLiteControBar != null) {
            videoLiteControBar.e(configuration);
            AppMethodBeat.o(195966);
            return;
        }
        AppMethodBeat.o(195966);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final boolean onSwipeBackFinish() {
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(195967);
        super.onResume();
        AppBrandVideoView appBrandVideoView = this.nYn;
        if (appBrandVideoView != null) {
            appBrandVideoView.onUIResume();
            AppMethodBeat.o(195967);
            return;
        }
        AppMethodBeat.o(195967);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(195968);
        super.onPause();
        AppBrandVideoView appBrandVideoView = this.nYn;
        if (appBrandVideoView != null) {
            appBrandVideoView.xr(3);
            AppMethodBeat.o(195968);
            return;
        }
        AppMethodBeat.o(195968);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(195969);
        super.onDestroy();
        AppBrandVideoView appBrandVideoView = this.nYn;
        if (appBrandVideoView != null) {
            appBrandVideoView.onUIDestroy();
            AppMethodBeat.o(195969);
            return;
        }
        AppMethodBeat.o(195969);
    }
}
