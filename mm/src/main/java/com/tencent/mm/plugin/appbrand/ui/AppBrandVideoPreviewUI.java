package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.z;
import com.tencent.mm.g.a.st;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tavkit.component.TAVExporter;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@com.tencent.mm.ui.base.a(32)
@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\"\u001a\u00020\u001dH\u0002J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010)\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010*\u001a\u00020\u0005H\u0014J\b\u0010+\u001a\u00020\u0005H\u0002J\b\u0010,\u001a\u00020$H\u0002J\b\u0010-\u001a\u00020\u001dH\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u00020\u001dH\u0016J\u0012\u00100\u001a\u00020$2\b\u00101\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u00102\u001a\u00020$H\u0014J\b\u00103\u001a\u00020$H\u0014J\b\u00104\u001a\u00020$H\u0014J\b\u00105\u001a\u00020\u001dH\u0016J\u0010\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020\u001dH\u0016J\u0010\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020\u0005H\u0002J\u0012\u0010:\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010;\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010<\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000¨\u0006="}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/message/MsgJobCallback;", "()V", "BASIC_PADDING", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "TOGGLE_PADDING", "appBrandVideoViewControlBar", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar;", "mAdditionButtonStr", "mAdditionMsgId", "", "Ljava/lang/Long;", "mAdditionSenderUsername", "mAdditionStartAppBrandId", "mAdditionTalkerUsername", "mAdditionText", "mChattingType", "Ljava/lang/Integer;", "mCoverUrl", "mExtData", "Landroid/os/Bundle;", "mLocalPath", "mScene", "mShouldAutoSave", "", "Ljava/lang/Boolean;", "mVideoUrl", "mVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "checkParams", "doInBackground", "", "job", "Lcom/tencent/mm/message/MsgJobCallback$Job;", "doOnlySelectRecordMsg", "bundle", "failDoJob", "getLayoutId", "getUIFlag", "initVideoView", "isFromMoreSelectRetransmit", "isJustTransAsNormalMsg", "isOnlySelectRecordMsg", "onCreate", "savedInstanceState", "onDestroy", "onPause", "onResume", "onSwipeBackFinish", "onWindowFocusChanged", "hasFocus", "reportWitrhType", "type", "requestExitSelectedMode", "resumeEditMode", "setWindowStyle", "plugin-appbrand-integration_release"})
public final class AppBrandVideoPreviewUI extends MMActivity implements z {
    final String TAG = "MicroMsg.AppBrandVideoPreviewUI";
    private HashMap _$_findViewCache;
    private Bundle lpM;
    private String mwj = "";
    private int nYA;
    private String nYm;
    private AppBrandVideoView nYn;
    private String nYo = "";
    private Boolean nYp = Boolean.FALSE;
    private Integer nYq = 0;
    private Integer nYr = 0;
    private String nYs = "";
    private String nYt = "";
    private String nYu = "";
    private Long nYv = -1L;
    private String nYw = "";
    private String nYx = "";
    private AppBrandVideoViewControlBar nYy;
    private int nYz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(229540);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(229540);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(229539);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(229539);
        return view;
    }

    public AppBrandVideoPreviewUI() {
        AppMethodBeat.i(51170);
        AppMethodBeat.o(51170);
    }

    public static final /* synthetic */ void a(AppBrandVideoPreviewUI appBrandVideoPreviewUI, int i2) {
        AppMethodBeat.i(51171);
        appBrandVideoPreviewUI.zp(i2);
        AppMethodBeat.o(51171);
    }

    public static final /* synthetic */ int bXI() {
        return TAVExporter.VIDEO_EXPORT_HEIGHT;
    }

    @Override // com.tencent.mm.ag.z
    public final void a(z.a aVar) {
        AppMethodBeat.i(51161);
        Log.i(this.TAG, "hy: fail do job: %s", aVar);
        AppMethodBeat.o(51161);
    }

    @Override // com.tencent.mm.ag.z
    public final void b(z.a aVar) {
        AppMethodBeat.i(51162);
        Log.i(this.TAG, "hy: doInBackground do job: %s", aVar);
        AppMethodBeat.o(51162);
    }

    @Override // com.tencent.mm.ag.z
    public final void c(z.a aVar) {
        AppMethodBeat.i(51163);
        Log.i(this.TAG, "hy: requestExitSelectedMode do job: %s", aVar);
        if (aVar == z.a.trans) {
            zp(4);
        }
        AppMethodBeat.o(51163);
    }

    @Override // com.tencent.mm.ag.z
    public final boolean aSC() {
        return true;
    }

    @Override // com.tencent.mm.ag.z
    public final boolean aSD() {
        return false;
    }

    @Override // com.tencent.mm.ag.z
    public final boolean aSE() {
        return false;
    }

    @Override // com.tencent.mm.ag.z
    public final void B(Bundle bundle) {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.g4;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        Long l;
        String str4;
        String str5;
        boolean z;
        Long l2;
        AppBrandVideoViewControlBar appBrandVideoViewControlBar;
        AppMethodBeat.i(51164);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        setSelfNavigationBarVisible(8);
        com.tencent.mm.plugin.mmsight.d.rb(true);
        Window window = getWindow();
        p.g(window, "window");
        window.setNavigationBarColor(WebView.NIGHT_MODE_COLOR);
        Window window2 = getWindow();
        p.g(window2, "window");
        window2.setStatusBarColor(0);
        Window window3 = getWindow();
        p.g(window3, "window");
        View decorView = window3.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        Window window4 = getWindow();
        p.g(window4, "window");
        window4.getDecorView().setOnSystemUiVisibilityChangeListener(new f(this));
        this.nYz = com.tencent.mm.cb.a.aH(this, R.dimen.hv);
        this.nYA = com.tencent.mm.cb.a.aH(this, R.dimen.sb) + this.nYz;
        this.nYm = getIntent().getStringExtra("key_video_url");
        this.mwj = getIntent().getStringExtra("key_cover_path");
        this.nYo = getIntent().getStringExtra("key_local_file_path");
        this.nYp = Boolean.valueOf(getIntent().getBooleanExtra("key_auto_save", false));
        this.nYq = Integer.valueOf(getIntent().getIntExtra("key_scene", 0));
        this.lpM = getIntent().getBundleExtra("key_ext_data");
        if (this.mwj != null) {
            String str6 = this.mwj;
            if (str6 == null) {
                p.hyc();
            }
            if (n.J(str6, FilePathGenerator.ANDROID_DIR_SEP, false)) {
                this.mwj = "file:/" + this.mwj;
            }
        }
        if (Util.isNullOrNil(this.nYm)) {
            z = false;
        } else {
            Integer num = this.nYq;
            if (num != null && num.intValue() == 1) {
                Bundle bundle2 = this.lpM;
                this.nYr = bundle2 != null ? Integer.valueOf(bundle2.getInt("key_chatting_type")) : null;
                Bundle bundle3 = this.lpM;
                if (bundle3 != null) {
                    str = bundle3.getString("key_chatting_wording");
                } else {
                    str = null;
                }
                this.nYs = str;
                Bundle bundle4 = this.lpM;
                if (bundle4 != null) {
                    str2 = bundle4.getString("key_chatting_text");
                } else {
                    str2 = null;
                }
                this.nYt = str2;
                Bundle bundle5 = this.lpM;
                if (bundle5 != null) {
                    str3 = bundle5.getString("key_chatting_appid");
                } else {
                    str3 = null;
                }
                this.nYu = str3;
                Bundle bundle6 = this.lpM;
                if (bundle6 != null) {
                    l = Long.valueOf(bundle6.getLong("key_msg_id", -1));
                } else {
                    l = null;
                }
                this.nYv = l;
                Bundle bundle7 = this.lpM;
                if (bundle7 != null) {
                    str4 = bundle7.getString("key_talker_username");
                } else {
                    str4 = null;
                }
                this.nYw = str4;
                Bundle bundle8 = this.lpM;
                if (bundle8 != null) {
                    str5 = bundle8.getString("key_sender_username");
                } else {
                    str5 = null;
                }
                this.nYx = str5;
                if (Util.isNullOrNil(this.nYu) || Util.isNullOrNil(this.nYw) || Util.isNullOrNil(this.nYx)) {
                    z = false;
                } else if (this.nYv == null || ((l2 = this.nYv) != null && l2.longValue() == -1)) {
                    z = false;
                } else {
                    com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                    i eiy = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy();
                    Long l3 = this.nYv;
                    if (l3 == null) {
                        p.hyc();
                    }
                    eiy.Hb(l3.longValue());
                }
            }
            z = true;
        }
        if (!z) {
            finish();
            AppMethodBeat.o(51164);
            return;
        }
        zp(2);
        Integer num2 = this.nYq;
        if (num2 != null && num2.intValue() == 1) {
            ((ImageView) findViewById(R.id.ggg)).setOnClickListener(new c(this));
            ((ImageView) findViewById(R.id.ggs)).setOnClickListener(new d(this));
        } else {
            setBackBtn(new e(this));
            setMMTitle("");
            hideActionbarLine();
            setActionbarColor(WebView.NIGHT_MODE_COLOR);
        }
        AppBrandVideoWrapper appBrandVideoWrapper = new AppBrandVideoWrapper(this);
        this.nYn = new AppBrandVideoView(this, appBrandVideoWrapper);
        this.nYy = new AppBrandVideoViewControlBar(this);
        AppBrandVideoViewControlBar appBrandVideoViewControlBar2 = this.nYy;
        if (appBrandVideoViewControlBar2 == null) {
            p.hyc();
        }
        appBrandVideoViewControlBar2.setId(R.id.rl);
        AppBrandVideoView appBrandVideoView = this.nYn;
        if (appBrandVideoView != null) {
            appBrandVideoView.a(this.nYy);
        }
        appBrandVideoWrapper.setVideoFooterView(this.nYy);
        Integer num3 = this.nYr;
        if (!(num3 == null || num3.intValue() != 48 || (appBrandVideoViewControlBar = this.nYy) == null)) {
            appBrandVideoViewControlBar.setAutoHide(false);
        }
        ((RelativeLayout) findViewById(R.id.be_)).addView(this.nYn, 0, new RelativeLayout.LayoutParams(-1, -1));
        AppBrandVideoView appBrandVideoView2 = this.nYn;
        if (appBrandVideoView2 != null) {
            appBrandVideoView2.setAutoPlay(true);
        }
        AppBrandVideoView appBrandVideoView3 = this.nYn;
        if (appBrandVideoView3 != null) {
            appBrandVideoView3.setLoop(true);
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
            appBrandVideoView6.setCover$16da05f7(this.mwj);
        }
        AppBrandVideoView appBrandVideoView7 = this.nYn;
        if (appBrandVideoView7 != null) {
            appBrandVideoView7.setObjectFit("contain");
        }
        AppBrandVideoView appBrandVideoView8 = this.nYn;
        if (appBrandVideoView8 != null) {
            appBrandVideoView8.setShowDanmakuBtn(false);
        }
        AppBrandVideoView appBrandVideoView9 = this.nYn;
        if (appBrandVideoView9 != null) {
            appBrandVideoView9.setShowMuteBtn(false);
        }
        AppBrandVideoView appBrandVideoView10 = this.nYn;
        if (appBrandVideoView10 != null) {
            appBrandVideoView10.setShowPlayBtn(true);
        }
        AppBrandVideoView appBrandVideoView11 = this.nYn;
        if (appBrandVideoView11 != null) {
            appBrandVideoView11.setShowProgress(true);
        }
        AppBrandVideoView appBrandVideoView12 = this.nYn;
        if (appBrandVideoView12 != null) {
            appBrandVideoView12.setShowFullScreenBtn(false);
        }
        AppBrandVideoView appBrandVideoView13 = this.nYn;
        if (appBrandVideoView13 != null) {
            appBrandVideoView13.setIsShowBasicControls(true);
        }
        AppBrandVideoView appBrandVideoView14 = this.nYn;
        if (appBrandVideoView14 != null) {
            appBrandVideoView14.setIsEnableBottomProgressBar(false);
        }
        AppBrandVideoView appBrandVideoView15 = this.nYn;
        if (appBrandVideoView15 != null) {
            appBrandVideoView15.setShowCenterPlayBtn(false);
        }
        AppBrandVideoView appBrandVideoView16 = this.nYn;
        if (appBrandVideoView16 != null) {
            appBrandVideoView16.setShowControlProgress(true);
        }
        AppBrandVideoView appBrandVideoView17 = this.nYn;
        if (appBrandVideoView17 != null) {
            appBrandVideoView17.setPageGesture(true);
        }
        AppBrandVideoView appBrandVideoView18 = this.nYn;
        if (appBrandVideoView18 != null) {
            appBrandVideoView18.hM(true);
        }
        AppBrandVideoView appBrandVideoView19 = this.nYn;
        if (appBrandVideoView19 != null) {
            appBrandVideoView19.e(this.nYm, false, 0);
        }
        Integer num4 = this.nYq;
        if (num4 == null) {
            AppMethodBeat.o(51164);
            return;
        }
        if (num4.intValue() == 1) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.g3, (ViewGroup) findViewById(R.id.be_), false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = this.nYA;
            ((RelativeLayout) findViewById(R.id.be_)).addView(inflate, layoutParams);
            View findViewById = inflate.findViewById(R.id.h0);
            p.g(findViewById, "additionView.findViewByI…View>(R.id.addition_text)");
            ((TextView) findViewById).setText(this.nYs);
            Button button = (Button) inflate.findViewById(R.id.gz);
            p.g(button, "startBtn");
            button.setText(this.nYt);
            button.setOnClickListener(new a(this));
            AppBrandVideoViewControlBar appBrandVideoViewControlBar3 = this.nYy;
            if (appBrandVideoViewControlBar3 != null) {
                appBrandVideoViewControlBar3.a(new b(this, inflate));
                AppMethodBeat.o(51164);
                return;
            }
        }
        AppMethodBeat.o(51164);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ AppBrandVideoPreviewUI nYB;

        c(AppBrandVideoPreviewUI appBrandVideoPreviewUI) {
            this.nYB = appBrandVideoPreviewUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(51157);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.nYB.onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51157);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ AppBrandVideoPreviewUI nYB;

        d(AppBrandVideoPreviewUI appBrandVideoPreviewUI) {
            this.nYB = appBrandVideoPreviewUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(51158);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i(this.nYB.TAG, "hy: on click menu");
            st stVar = new st();
            stVar.dZk.context = this.nYB;
            stVar.dZk.dZl = ab.Eq(this.nYB.nYw);
            ArrayList arrayList = new ArrayList();
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            i eiy = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy();
            Long l = this.nYB.nYv;
            if (l == null) {
                p.hyc();
            }
            arrayList.add(eiy.Hb(l.longValue()));
            stVar.dZk.dXK = arrayList;
            stVar.dZk.talker = this.nYB.nYw;
            stVar.dZk.dZm = this.nYB;
            EventCenter.instance.publish(stVar);
            AppBrandVideoPreviewUI.a(this.nYB, 3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51158);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class e implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ AppBrandVideoPreviewUI nYB;

        e(AppBrandVideoPreviewUI appBrandVideoPreviewUI) {
            this.nYB = appBrandVideoPreviewUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(51159);
            this.nYB.onBackPressed();
            AppMethodBeat.o(51159);
            return true;
        }
    }

    private final void zp(int i2) {
        int i3;
        AppMethodBeat.i(51165);
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[4];
        if (ab.Eq(this.nYw)) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = this.nYu;
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = 1;
        hVar.a(17608, objArr);
        AppMethodBeat.o(51165);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onSystemUiVisibilityChange"})
    static final class f implements View.OnSystemUiVisibilityChangeListener {
        final /* synthetic */ AppBrandVideoPreviewUI nYB;

        f(AppBrandVideoPreviewUI appBrandVideoPreviewUI) {
            this.nYB = appBrandVideoPreviewUI;
        }

        public final void onSystemUiVisibilityChange(int i2) {
            AppMethodBeat.i(51160);
            if ((i2 & 4) == 0) {
                Window window = this.nYB.getWindow();
                p.g(window, "window");
                View decorView = window.getDecorView();
                p.g(decorView, "window.decorView");
                decorView.setSystemUiVisibility(AppBrandVideoPreviewUI.bXI());
            }
            AppMethodBeat.o(51160);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(51166);
        AppMethodBeat.at(this, z);
        super.onWindowFocusChanged(z);
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        AppMethodBeat.o(51166);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ AppBrandVideoPreviewUI nYB;

        a(AppBrandVideoPreviewUI appBrandVideoPreviewUI) {
            this.nYB = appBrandVideoPreviewUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(51155);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$initVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i(this.nYB.TAG, "hy: request start to appid " + this.nYB.nYu);
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            i eiy = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy();
            Long l = this.nYB.nYv;
            if (l == null) {
                p.hyc();
            }
            ca Hb = eiy.Hb(l.longValue());
            Bundle bundle = new Bundle();
            bundle.putInt("stat_scene", 11);
            bundle.putString("stat_msg_id", "msg_" + Long.toString(Hb.ajM()));
            bundle.putString("stat_chat_talker_username", this.nYB.nYw);
            bundle.putString("stat_send_msg_user", this.nYB.nYx);
            String str = this.nYB.nYw;
            if (str == null) {
                p.hyc();
            }
            if (this.nYB.nYx == null) {
                p.hyc();
            }
            com.tencent.mm.modelappbrand.a.a(str, 1136, k.b.HD(Hb.getContent()), bundle);
            AppBrandVideoPreviewUI.a(this.nYB, 5);
            this.nYB.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$initVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51155);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onVisibilityChanged"})
    static final class b implements e.f {
        final /* synthetic */ AppBrandVideoPreviewUI nYB;
        final /* synthetic */ View nYC;

        b(AppBrandVideoPreviewUI appBrandVideoPreviewUI, View view) {
            this.nYB = appBrandVideoPreviewUI;
            this.nYC = view;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.f
        public final void onVisibilityChanged(boolean z) {
            AppMethodBeat.i(51156);
            if (!z) {
                View findViewById = this.nYB.findViewById(R.id.ggg);
                p.g(findViewById, "findViewById<ImageView>(R.id.preview_close)");
                ((ImageView) findViewById).setVisibility(8);
                View findViewById2 = this.nYB.findViewById(R.id.ggs);
                p.g(findViewById2, "findViewById<ImageView>(R.id.preview_share)");
                ((ImageView) findViewById2).setVisibility(8);
                View view = this.nYC;
                p.g(view, "additionView");
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(51156);
                    throw tVar;
                }
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = this.nYB.nYz;
                AppMethodBeat.o(51156);
                return;
            }
            View findViewById3 = this.nYB.findViewById(R.id.ggg);
            p.g(findViewById3, "findViewById<ImageView>(R.id.preview_close)");
            ((ImageView) findViewById3).setVisibility(0);
            View findViewById4 = this.nYB.findViewById(R.id.ggs);
            p.g(findViewById4, "findViewById<ImageView>(R.id.preview_share)");
            ((ImageView) findViewById4).setVisibility(0);
            View view2 = this.nYC;
            p.g(view2, "additionView");
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            if (layoutParams2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(51156);
                throw tVar2;
            }
            ((RelativeLayout.LayoutParams) layoutParams2).bottomMargin = this.nYB.nYA;
            AppMethodBeat.o(51156);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final boolean onSwipeBackFinish() {
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(51167);
        super.onResume();
        AppBrandVideoView appBrandVideoView = this.nYn;
        if (appBrandVideoView != null) {
            appBrandVideoView.onUIResume();
            AppMethodBeat.o(51167);
            return;
        }
        AppMethodBeat.o(51167);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(51168);
        super.onPause();
        AppBrandVideoView appBrandVideoView = this.nYn;
        if (appBrandVideoView != null) {
            appBrandVideoView.xr(3);
            AppMethodBeat.o(51168);
            return;
        }
        AppMethodBeat.o(51168);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(51169);
        super.onDestroy();
        AppBrandVideoView appBrandVideoView = this.nYn;
        if (appBrandVideoView != null) {
            appBrandVideoView.onUIDestroy();
            AppMethodBeat.o(51169);
            return;
        }
        AppMethodBeat.o(51169);
    }
}
