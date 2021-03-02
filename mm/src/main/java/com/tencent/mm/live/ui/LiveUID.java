package com.tencent.mm.live.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.x;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.tavkit.component.TAVExporter;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u0005H\u0014J\b\u0010(\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020&H\u0002J\u0010\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\f2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u00100\u001a\u00020\f2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u00101\u001a\u00020\f2\u0006\u0010-\u001a\u00020.H\u0002J\b\u00102\u001a\u00020&H\u0002J\b\u00103\u001a\u00020&H\u0016J\u0012\u00104\u001a\u00020&2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020&H\u0014J\b\u00108\u001a\u00020&H\u0014J,\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010\b2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020&H\u0002J\b\u0010@\u001a\u00020&H\u0002J\b\u0010A\u001a\u00020&H\u0002J\b\u0010B\u001a\u00020&H\u0002J\b\u0010C\u001a\u00020&H\u0002J\b\u0010D\u001a\u00020&H\u0002J\b\u0010E\u001a\u00020&H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, hxF = {"Lcom/tencent/mm/live/ui/LiveUID;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "RANGE_ROOM", "", "RANGE_SELF_ONLY", "TAG", "", "curRange", "fromSence", "hasBeenEnterReplay", "", "liveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "profileBackBtn", "Landroid/widget/ImageView;", "profileContentGroup", "Landroid/view/View;", "profileDescTv", "Landroid/widget/TextView;", "profileGeneratingTipTv", "profileGeneratingTv", "profileIconIv", "profileRangeBtn", "profileRangeClose", "profileRangeContentPanel", "profileRangeFinishBtn", "Landroid/widget/Button;", "profileRangePanel", "profileRangeRoomGroup", "profileRangeRoomSelect", "profileRangeSelfGroup", "profileRangeSelfSelect", "profileRangeTipTv", "profileReplayBtn", "profileTitleTv", "doReplaySwitch", "", "getLayoutId", "hideRangePanel", "initConfig", "initRangePanel", "initViews", "isAnchor", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "isReplayClosed", "isReplayDeprecated", "isReplayGenerated", "loadLiveInfo", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "replayClosed", "replayDeprecated", "replayGenerated", "replayGenerating", "setWindowStyle", "showRangePanel", "updateReplayRange", "plugin-logic_release"})
public final class LiveUID extends MMActivity implements com.tencent.mm.ak.i {
    private final String TAG = "MicroMsg.LiveUID";
    private int hTW;
    private int hUA = this.hUx;
    private boolean hUB;
    private ImageView hUf;
    private TextView hUg;
    private TextView hUh;
    private View hUi;
    private TextView hUj;
    private TextView hUk;
    private TextView hUl;
    private Button hUm;
    private View hUn;
    private ImageView hUo;
    private View hUp;
    private View hUq;
    private ImageView hUr;
    private View hUs;
    private ImageView hUt;
    private View hUu;
    private ImageView hUv;
    private Button hUw;
    private final int hUx;
    private final int hUy = 1;
    private LiveConfig hUz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LiveUID() {
        AppMethodBeat.i(208408);
        AppMethodBeat.o(208408);
    }

    public static final /* synthetic */ void i(LiveUID liveUID) {
        AppMethodBeat.i(208410);
        liveUID.aJa();
        AppMethodBeat.o(208410);
    }

    public static final /* synthetic */ void k(LiveUID liveUID) {
        AppMethodBeat.i(208412);
        liveUID.aIZ();
        AppMethodBeat.o(208412);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.b1e;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        ViewGroup.LayoutParams layoutParams;
        String str;
        String str2;
        AppMethodBeat.i(208400);
        setTheme(R.style.a2);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        this.hTW = getIntent().getIntExtra("FROM_SENCE", 2);
        switch (this.hTW) {
            case 1:
                x xVar = x.hJf;
                if (!p.j(x.aGt(), z.aTY())) {
                    com.tencent.mm.live.d.d.aIG();
                    break;
                } else {
                    com.tencent.mm.live.d.d.aIE();
                    break;
                }
            case 2:
                x xVar2 = x.hJf;
                if (!p.j(x.aGt(), z.aTY())) {
                    com.tencent.mm.live.d.d.aIH();
                    break;
                } else {
                    com.tencent.mm.live.d.d.aIF();
                    break;
                }
        }
        setSelfNavigationBarVisible(8);
        getWindow().addFlags(2097280);
        getWindow().addFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(67108864);
            Window window = getWindow();
            p.g(window, "window");
            View decorView = window.getDecorView();
            p.g(decorView, "window.decorView");
            decorView.setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
            getWindow().addFlags(Integer.MIN_VALUE);
            Window window2 = getWindow();
            p.g(window2, "window");
            window2.setStatusBarColor(0);
        }
        getWindow().setFormat(-3);
        getWindow().setSoftInputMode(3);
        this.hUz = (LiveConfig) getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
        if (this.hUz != null) {
            x xVar3 = x.hJf;
            x.a(new civ());
            x xVar4 = x.hJf;
            civ aGr = x.aGr();
            LiveConfig liveConfig = this.hUz;
            aGr.hyH = liveConfig != null ? liveConfig.getLiveId() : 0;
            x xVar5 = x.hJf;
            LiveConfig liveConfig2 = this.hUz;
            if (liveConfig2 == null || (str = liveConfig2.aBD()) == null) {
                str = "";
            }
            x.GQ(str);
            x xVar6 = x.hJf;
            LiveConfig liveConfig3 = this.hUz;
            if (liveConfig3 == null || (str2 = liveConfig3.aBG()) == null) {
                str2 = "";
            }
            x.GS(str2);
        }
        String str3 = this.TAG;
        StringBuilder sb = new StringBuilder("initConfig liveId:");
        x xVar7 = x.hJf;
        StringBuilder append = sb.append(x.aGr().hyH).append(" wechatRoomId:");
        x xVar8 = x.hJf;
        Log.i(str3, append.append(x.aGm()).toString());
        this.hUf = (ImageView) findViewById(R.id.ekw);
        this.hUg = (TextView) findViewById(R.id.ekx);
        this.hUh = (TextView) findViewById(R.id.ekh);
        this.hUi = findViewById(R.id.ekn);
        this.hUj = (TextView) findViewById(R.id.ekv);
        this.hUk = (TextView) findViewById(R.id.ekf);
        this.hUl = (TextView) findViewById(R.id.eki);
        this.hUm = (Button) findViewById(R.id.ekd);
        this.hUn = findViewById(R.id.ekg);
        this.hUo = (ImageView) findViewById(R.id.ekc);
        View view = this.hUn;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(208400);
            throw tVar;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = au.getStatusBarHeight(getContext()) + au.eu(getContext());
        ImageView imageView = this.hUf;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.hUg;
        ViewGroup.LayoutParams layoutParams2 = textView != null ? textView.getLayoutParams() : null;
        if (layoutParams2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(208400);
            throw tVar2;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = at.fromDPToPix(getContext(), 72);
        TextView textView2 = this.hUg;
        if (textView2 != null) {
            textView2.requestLayout();
        }
        View view2 = this.hUi;
        if (view2 != null) {
            view2.setOnClickListener(new g(this));
        }
        ImageView imageView2 = this.hUo;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new h(this));
        }
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        x xVar9 = x.hJf;
        if (Util.isEqual((String) aAh.azQ().get(2), x.aGt())) {
            View view3 = this.hUi;
            if (view3 != null) {
                view3.setVisibility(0);
            }
        } else {
            View view4 = this.hUi;
            if (view4 != null) {
                view4.setVisibility(8);
            }
        }
        aIZ();
        this.hUp = findViewById(R.id.ekp);
        this.hUq = findViewById(R.id.ekm);
        this.hUr = (ImageView) findViewById(R.id.ekl);
        this.hUs = findViewById(R.id.eku);
        this.hUt = (ImageView) findViewById(R.id.ekt);
        this.hUu = findViewById(R.id.eks);
        this.hUv = (ImageView) findViewById(R.id.ekr);
        this.hUw = (Button) findViewById(R.id.ekk);
        View view5 = this.hUp;
        if (view5 != null) {
            view5.setVisibility(8);
        }
        View view6 = this.hUq;
        if (view6 != null) {
            view6.setTranslationY((float) au.az(getContext()).y);
        }
        View view7 = this.hUs;
        if (view7 != null) {
            view7.setOnClickListener(new b(this));
        }
        View view8 = this.hUu;
        if (view8 != null) {
            view8.setOnClickListener(new c(this));
        }
        View view9 = this.hUp;
        if (view9 != null) {
            view9.setOnClickListener(new d(this));
        }
        Button button = this.hUw;
        if (button != null) {
            button.setOnClickListener(new e(this));
        }
        ImageView imageView3 = this.hUr;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new f(this));
        }
        r rVar = r.hIg;
        r.aGb();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3806, this);
        com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().a(3712, this);
        AppMethodBeat.o(208400);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(208401);
        super.onResume();
        AppMethodBeat.o(208401);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(208402);
        super.onDestroy();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3806, this);
        com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().b(3712, this);
        if (this.hUz != null) {
            x xVar = x.hJf;
            x.and();
        }
        AppMethodBeat.o(208402);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(208403);
        View view = this.hUp;
        if (view == null || !view.isShown()) {
            super.onBackPressed();
            AppMethodBeat.o(208403);
            return;
        }
        aJa();
        AppMethodBeat.o(208403);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ LiveUID hUC;

        g(LiveUID liveUID) {
            this.hUC = liveUID;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208395);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            LiveUID.a(this.hUC);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208395);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h implements View.OnClickListener {
        final /* synthetic */ LiveUID hUC;

        h(LiveUID liveUID) {
            this.hUC = liveUID;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208396);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.hUC.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208396);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ LiveUID hUC;

        b(LiveUID liveUID) {
            this.hUC = liveUID;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208390);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!this.hUC.hUB) {
                com.tencent.mm.live.d.d.aIx();
            } else if (this.hUC.hUA != this.hUC.hUx) {
                com.tencent.mm.live.d.d.aIB();
            }
            this.hUC.hUA = this.hUC.hUx;
            ImageView imageView = this.hUC.hUt;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.hUC.hUv;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208390);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ LiveUID hUC;

        c(LiveUID liveUID) {
            this.hUC = liveUID;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208391);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!this.hUC.hUB) {
                com.tencent.mm.live.d.d.aIy();
            } else if (this.hUC.hUA != this.hUC.hUy) {
                com.tencent.mm.live.d.d.aIC();
            }
            this.hUC.hUA = this.hUC.hUy;
            ImageView imageView = this.hUC.hUt;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.hUC.hUv;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208391);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ LiveUID hUC;

        d(LiveUID liveUID) {
            this.hUC = liveUID;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208392);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            LiveUID.i(this.hUC);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208392);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ LiveUID hUC;

        e(LiveUID liveUID) {
            this.hUC = liveUID;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208393);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            LiveUID.j(this.hUC);
            LiveUID.k(this.hUC);
            LiveUID.i(this.hUC);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208393);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ LiveUID hUC;

        f(LiveUID liveUID) {
            this.hUC = liveUID;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208394);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            LiveUID.i(this.hUC);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208394);
        }
    }

    private final void aIZ() {
        TextView textView;
        AppMethodBeat.i(208404);
        int i2 = this.hUA;
        if (i2 == this.hUx) {
            TextView textView2 = this.hUj;
            if (textView2 != null) {
                AppCompatActivity context = getContext();
                p.g(context, "context");
                textView2.setText(context.getResources().getString(R.string.eia));
                AppMethodBeat.o(208404);
                return;
            }
            AppMethodBeat.o(208404);
        } else if (i2 != this.hUy || (textView = this.hUj) == null) {
            AppMethodBeat.o(208404);
        } else {
            AppCompatActivity context2 = getContext();
            p.g(context2, "context");
            textView.setText(context2.getResources().getString(R.string.eib));
            AppMethodBeat.o(208404);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/live/ui/LiveUID$hideRangePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ LiveUID hUC;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(LiveUID liveUID) {
            this.hUC = liveUID;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(208389);
            View view = this.hUC.hUp;
            if (view != null) {
                view.setVisibility(8);
                AppMethodBeat.o(208389);
                return;
            }
            AppMethodBeat.o(208389);
        }
    }

    private final void aJa() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator translationY;
        AppMethodBeat.i(208405);
        View view = this.hUq;
        ViewPropertyAnimator duration = (view == null || (animate = view.animate()) == null || (translationY = animate.translationY((float) au.az(getContext()).y)) == null) ? null : translationY.setDuration(200);
        if (duration != null) {
            duration.setListener(new a(this));
        }
        if (duration != null) {
            duration.start();
            AppMethodBeat.o(208405);
            return;
        }
        AppMethodBeat.o(208405);
    }

    private final void aJb() {
        AppMethodBeat.i(208406);
        Button button = this.hUm;
        if (button != null) {
            button.setVisibility(8);
        }
        TextView textView = this.hUl;
        if (textView != null) {
            textView.setVisibility(0);
        }
        ImageView imageView = this.hUf;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView2 = this.hUg;
        ViewGroup.LayoutParams layoutParams = textView2 != null ? textView2.getLayoutParams() : null;
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(208406);
            throw tVar;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = at.fromDPToPix(getContext(), 72);
        TextView textView3 = this.hUg;
        if (textView3 != null) {
            textView3.requestLayout();
            AppMethodBeat.o(208406);
            return;
        }
        AppMethodBeat.o(208406);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class k implements View.OnClickListener {
        final /* synthetic */ LiveUID hUC;

        k(LiveUID liveUID) {
            this.hUC = liveUID;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208399);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent(this.hUC.getContext(), LiveUIB.class);
            intent.putExtra("FROM_SENCE", this.hUC.hTW);
            AppCompatActivity context = this.hUC.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            x xVar = x.hJf;
            if (p.j(x.aGt(), z.aTY())) {
                com.tencent.mm.live.d.d.aIz();
            } else {
                com.tencent.mm.live.d.d.aII();
            }
            this.hUC.hUB = true;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208399);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class j implements View.OnClickListener {
        final /* synthetic */ LiveUID hUC;

        j(LiveUID liveUID) {
            this.hUC = liveUID;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208398);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$replayDeprecated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.hUC.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$replayDeprecated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208398);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ LiveUID hUC;

        i(LiveUID liveUID) {
            this.hUC = liveUID;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208397);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$replayClosed$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.hUC.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$replayClosed$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208397);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup.LayoutParams layoutParams3;
        boolean z4;
        AppMethodBeat.i(208407);
        Log.i(this.TAG, "errType:" + i2 + ", errCode:" + i3);
        if (qVar instanceof com.tencent.mm.live.b.a.b) {
            x xVar = x.hJf;
            if (x.aGr().MnK) {
                i4 = this.hUy;
            } else {
                i4 = this.hUx;
            }
            this.hUA = i4;
            aIZ();
            if (i2 == 0 && i3 == 0) {
                x xVar2 = x.hJf;
                civ aGr = x.aGr();
                if (p.j(aGr.MnL, aGr.MnM)) {
                    String str2 = aGr.MnI;
                    if (str2 == null || str2.length() == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    z = !z4;
                } else {
                    if (aGr.MnK) {
                        String str3 = aGr.MnI;
                        if (!(str3 == null || str3.length() == 0)) {
                            z = true;
                        }
                    }
                    z = false;
                }
                if (z) {
                    TextView textView = this.hUl;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                    TextView textView2 = this.hUk;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                    Button button = this.hUm;
                    if (button != null) {
                        button.setVisibility(0);
                    }
                    Button button2 = this.hUm;
                    if (button2 != null) {
                        AppCompatActivity context = getContext();
                        p.g(context, "context");
                        button2.setText(context.getResources().getString(R.string.ef0));
                    }
                    Button button3 = this.hUm;
                    if (button3 != null) {
                        button3.setOnClickListener(new k(this));
                    }
                    ImageView imageView = this.hUf;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    TextView textView3 = this.hUg;
                    if (textView3 != null) {
                        layoutParams3 = textView3.getLayoutParams();
                    } else {
                        layoutParams3 = null;
                    }
                    if (layoutParams3 == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(208407);
                        throw tVar;
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = at.fromDPToPix(getContext(), 72);
                    TextView textView4 = this.hUg;
                    if (textView4 != null) {
                        textView4.requestLayout();
                        AppMethodBeat.o(208407);
                        return;
                    }
                    AppMethodBeat.o(208407);
                    return;
                }
                x xVar3 = x.hJf;
                int i5 = x.aGr().status;
                o.e eVar = o.e.hGR;
                if (i5 == o.e.aFB()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    TextView textView5 = this.hUg;
                    if (textView5 != null) {
                        AppCompatActivity context2 = getContext();
                        p.g(context2, "context");
                        textView5.setText(context2.getResources().getString(R.string.ei9));
                    }
                    TextView textView6 = this.hUh;
                    if (textView6 != null) {
                        AppCompatActivity context3 = getContext();
                        p.g(context3, "context");
                        textView6.setText(context3.getResources().getString(R.string.ei4));
                    }
                    TextView textView7 = this.hUl;
                    if (textView7 != null) {
                        textView7.setVisibility(8);
                    }
                    TextView textView8 = this.hUk;
                    if (textView8 != null) {
                        textView8.setVisibility(8);
                    }
                    Button button4 = this.hUm;
                    if (button4 != null) {
                        button4.setVisibility(0);
                    }
                    Button button5 = this.hUm;
                    if (button5 != null) {
                        AppCompatActivity context4 = getContext();
                        p.g(context4, "context");
                        button5.setText(context4.getResources().getString(R.string.w0));
                    }
                    Button button6 = this.hUm;
                    if (button6 != null) {
                        button6.setOnClickListener(new j(this));
                    }
                    ImageView imageView2 = this.hUf;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                    ImageView imageView3 = this.hUf;
                    if (imageView3 != null) {
                        AppCompatActivity context5 = getContext();
                        p.g(context5, "context");
                        imageView3.setImageDrawable(context5.getResources().getDrawable(R.raw.icons_dark_help));
                    }
                    TextView textView9 = this.hUg;
                    if (textView9 != null) {
                        layoutParams2 = textView9.getLayoutParams();
                    } else {
                        layoutParams2 = null;
                    }
                    if (layoutParams2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(208407);
                        throw tVar2;
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = at.fromDPToPix(getContext(), 40);
                    TextView textView10 = this.hUg;
                    if (textView10 != null) {
                        textView10.requestLayout();
                        AppMethodBeat.o(208407);
                        return;
                    }
                    AppMethodBeat.o(208407);
                    return;
                }
                x xVar4 = x.hJf;
                civ aGr2 = x.aGr();
                int i6 = aGr2.status;
                o.e eVar2 = o.e.hGR;
                if (i6 != o.e.aFA() || aGr2.MnK) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    TextView textView11 = this.hUg;
                    if (textView11 != null) {
                        AppCompatActivity context6 = getContext();
                        p.g(context6, "context");
                        textView11.setText(context6.getResources().getString(R.string.ei7));
                    }
                    TextView textView12 = this.hUh;
                    if (textView12 != null) {
                        AppCompatActivity context7 = getContext();
                        p.g(context7, "context");
                        textView12.setText(context7.getResources().getString(R.string.ei3));
                    }
                    TextView textView13 = this.hUl;
                    if (textView13 != null) {
                        textView13.setVisibility(8);
                    }
                    TextView textView14 = this.hUk;
                    if (textView14 != null) {
                        textView14.setVisibility(8);
                    }
                    Button button7 = this.hUm;
                    if (button7 != null) {
                        button7.setVisibility(0);
                    }
                    Button button8 = this.hUm;
                    if (button8 != null) {
                        AppCompatActivity context8 = getContext();
                        p.g(context8, "context");
                        button8.setText(context8.getResources().getString(R.string.w0));
                    }
                    Button button9 = this.hUm;
                    if (button9 != null) {
                        button9.setOnClickListener(new i(this));
                    }
                    ImageView imageView4 = this.hUf;
                    if (imageView4 != null) {
                        imageView4.setVisibility(0);
                    }
                    ImageView imageView5 = this.hUf;
                    if (imageView5 != null) {
                        AppCompatActivity context9 = getContext();
                        p.g(context9, "context");
                        imageView5.setImageDrawable(context9.getResources().getDrawable(R.raw.icons_dark_help));
                    }
                    TextView textView15 = this.hUg;
                    if (textView15 != null) {
                        layoutParams = textView15.getLayoutParams();
                    } else {
                        layoutParams = null;
                    }
                    if (layoutParams == null) {
                        t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(208407);
                        throw tVar3;
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = at.fromDPToPix(getContext(), 40);
                    TextView textView16 = this.hUg;
                    if (textView16 != null) {
                        textView16.requestLayout();
                        AppMethodBeat.o(208407);
                        return;
                    }
                    AppMethodBeat.o(208407);
                    return;
                }
                aJb();
                AppMethodBeat.o(208407);
                return;
            }
            aJb();
        }
        AppMethodBeat.o(208407);
    }

    public static final /* synthetic */ void a(LiveUID liveUID) {
        ViewPropertyAnimator viewPropertyAnimator;
        ViewPropertyAnimator animate;
        ViewPropertyAnimator translationY;
        AppMethodBeat.i(208409);
        int i2 = liveUID.hUA;
        if (i2 == liveUID.hUx) {
            ImageView imageView = liveUID.hUt;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = liveUID.hUv;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        } else if (i2 == liveUID.hUy) {
            ImageView imageView3 = liveUID.hUt;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
            ImageView imageView4 = liveUID.hUv;
            if (imageView4 != null) {
                imageView4.setVisibility(0);
            }
        }
        View view = liveUID.hUp;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = liveUID.hUq;
        if (view2 == null || (animate = view2.animate()) == null || (translationY = animate.translationY(0.0f)) == null) {
            viewPropertyAnimator = null;
        } else {
            viewPropertyAnimator = translationY.setDuration(200);
        }
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setListener(null);
        }
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.start();
            AppMethodBeat.o(208409);
            return;
        }
        AppMethodBeat.o(208409);
    }

    public static final /* synthetic */ void j(LiveUID liveUID) {
        AppMethodBeat.i(208411);
        int i2 = liveUID.hUA;
        if (i2 == liveUID.hUx) {
            r rVar = r.hIg;
            r.eG(false);
            AppMethodBeat.o(208411);
            return;
        }
        if (i2 == liveUID.hUy) {
            r rVar2 = r.hIg;
            r.eG(true);
        }
        AppMethodBeat.o(208411);
    }
}
