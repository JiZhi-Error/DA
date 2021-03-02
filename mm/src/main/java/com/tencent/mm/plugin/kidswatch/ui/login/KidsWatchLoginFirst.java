package com.tencent.mm.plugin.kidswatch.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.kidswatch.a;
import com.tencent.mm.plugin.kidswatch.model.c;
import com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegGetInfoUI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0014J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "deviceName", "", "isShowRegBtn", "", "kidsCount", "", "loginUrl", "okSessionList", "scene", "Lcom/tencent/mm/plugin/kidswatch/ConstantsKidsWatch$LoginFirstChooseScene;", "finish", "", "getForceOrientation", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onWindowFocusChanged", "hasFocus", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchLoginFirst extends MMActivity {
    public static final a yBo = new a((byte) 0);
    private HashMap _$_findViewCache;
    private String dZW;
    private String deviceName;
    private String yBa;
    private boolean yBg;
    private int yBh;
    private a.c yBn = a.c.SCENE_CHOOSE_LOGIN;

    static {
        AppMethodBeat.i(256255);
        AppMethodBeat.o(256255);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(256258);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(256258);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(256257);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(256257);
        return view;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$Companion;", "", "()V", "TAG", "", "plugin-kidswatch_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ String b(KidsWatchLoginFirst kidsWatchLoginFirst) {
        AppMethodBeat.i(256256);
        String str = kidsWatchLoginFirst.dZW;
        if (str == null) {
            p.btv("loginUrl");
        }
        AppMethodBeat.o(256256);
        return str;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(256251);
        super.onCreate(bundle);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            p.hyc();
        }
        supportActionBar.hide();
        initView();
        overridePendingTransition(R.anim.dq, R.anim.s);
        AppMethodBeat.o(256251);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(256252);
        AppMethodBeat.at(this, z);
        super.onWindowFocusChanged(z);
        if (z) {
            com.tencent.mm.plugin.kidswatch.b.a aVar = com.tencent.mm.plugin.kidswatch.b.a.yBL;
            com.tencent.mm.plugin.kidswatch.b.a.aq(this);
        }
        AppMethodBeat.o(256252);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(256253);
        Log.i("MicroMsg.KidsWatchLoginFirst", "initView");
        setMMTitle("");
        String stringExtra = getIntent().getStringExtra("intent.key.login.url");
        p.g(stringExtra, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
        this.dZW = stringExtra;
        this.yBh = getIntent().getIntExtra("intent.key.kids.cnt", 0);
        this.deviceName = getIntent().getStringExtra("intent.key.device.name");
        this.yBa = getIntent().getStringExtra("intent.key.ok.session.list");
        this.yBg = getIntent().getBooleanExtra("intent.key.ok.reg.btn", false);
        ((KidsWatchHeadComponent) _$_findCachedViewById(R.id.dnl)).setCloseBtnCallBack(new b(this));
        ((KidsWatchHeadComponent) _$_findCachedViewById(R.id.dnl)).ebW();
        Button button = (Button) _$_findCachedViewById(R.id.erc);
        if (button == null) {
            p.hyc();
        }
        button.setOnClickListener(new c(this));
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.gyr);
        if (linearLayout != null) {
            linearLayout.setVisibility(this.yBg ? 0 : 4);
        }
        Button button2 = (Button) _$_findCachedViewById(R.id.gyt);
        if (button2 == null) {
            p.hyc();
        }
        button2.setOnClickListener(new d(this));
        AppMethodBeat.o(256253);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ KidsWatchLoginFirst yBp;

        c(KidsWatchLoginFirst kidsWatchLoginFirst) {
            this.yBp = kidsWatchLoginFirst;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256249);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.KidsWatchLoginFirst", "login button clicked");
            this.yBp.yBn = a.c.SCENE_CHOOSE_LOGIN;
            Intent intent = new Intent();
            intent.putExtra("intent.key.login.url", KidsWatchLoginFirst.b(this.yBp));
            intent.putExtra("intent.key.device.name", this.yBp.deviceName);
            intent.putExtra("intent.key.ok.session.list", this.yBp.yBa);
            intent.putExtra("intent.key.kids.cnt", this.yBp.yBh);
            intent.setFlags(268435456);
            intent.setClass(this.yBp, KidsWatchLoginFirstChooseSceneUI.class);
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256249);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ KidsWatchLoginFirst yBp;

        d(KidsWatchLoginFirst kidsWatchLoginFirst) {
            this.yBp = kidsWatchLoginFirst;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256250);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.KidsWatchLoginFirst", "reg button clicked, isShowRegBtn:" + this.yBp.yBg);
            Intent intent = new Intent();
            intent.putExtra("intent.key.login.url", KidsWatchLoginFirst.b(this.yBp));
            intent.putExtra("intent.key.device.name", this.yBp.deviceName);
            intent.setFlags(268435456);
            intent.setClass(this.yBp, KidsWatchRegGetInfoUI.class);
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.yBp.yBn = a.c.SCENE_CHOOSE_REG;
            com.tencent.mm.plugin.kidswatch.model.c cVar = com.tencent.mm.plugin.kidswatch.model.c.yAF;
            com.tencent.mm.plugin.kidswatch.model.c.a(c.a.ACCOUNT_TYPE_NORMAL, KidsWatchLoginFirst.b(this.yBp), c.EnumC1454c.LOGIN_TYPE_DEFAULT, c.b.LOGIN_RESULT_TURN_TO_REG, this.yBp.yBh, 0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirst$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256250);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.axl;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(256254);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.f6do);
        AppMethodBeat.o(256254);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ KidsWatchLoginFirst yBp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(KidsWatchLoginFirst kidsWatchLoginFirst) {
            super(0);
            this.yBp = kidsWatchLoginFirst;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(256248);
            switch (a.$EnumSwitchMapping$0[this.yBp.yBn.ordinal()]) {
                case 1:
                    com.tencent.mm.plugin.kidswatch.model.c cVar = com.tencent.mm.plugin.kidswatch.model.c.yAF;
                    com.tencent.mm.plugin.kidswatch.model.c.a("", c.d.REG_RESULT_CANCEL, 0);
                    break;
                default:
                    com.tencent.mm.plugin.kidswatch.model.c cVar2 = com.tencent.mm.plugin.kidswatch.model.c.yAF;
                    com.tencent.mm.plugin.kidswatch.model.c.a(c.a.ACCOUNT_TYPE_NORMAL, KidsWatchLoginFirst.b(this.yBp), c.EnumC1454c.LOGIN_TYPE_DEFAULT, c.b.LOGIN_RESULT_CANCEL, this.yBp.yBh, 0);
                    break;
            }
            this.yBp.finish();
            x xVar = x.SXb;
            AppMethodBeat.o(256248);
            return xVar;
        }
    }
}
