package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\f\u001a\u00020\bH\u0014J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegSuccessUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "loginUrl", "", "nickname", "openId", "finish", "", "getForceOrientation", "", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchRegSuccessUI extends MMActivity {
    public static final a yBJ = new a((byte) 0);
    private HashMap _$_findViewCache;
    private String dZW;
    private String nickname;
    private String openId;

    static {
        AppMethodBeat.i(256378);
        AppMethodBeat.o(256378);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(256382);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(256382);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(256381);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(256381);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegSuccessUI$Companion;", "", "()V", "TAG", "", "plugin-kidswatch_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ String a(KidsWatchRegSuccessUI kidsWatchRegSuccessUI) {
        AppMethodBeat.i(256379);
        String str = kidsWatchRegSuccessUI.dZW;
        if (str == null) {
            p.btv("loginUrl");
        }
        AppMethodBeat.o(256379);
        return str;
    }

    public static final /* synthetic */ String b(KidsWatchRegSuccessUI kidsWatchRegSuccessUI) {
        AppMethodBeat.i(256380);
        String str = kidsWatchRegSuccessUI.openId;
        if (str == null) {
            p.btv("openId");
        }
        AppMethodBeat.o(256380);
        return str;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(256375);
        super.onCreate(bundle);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            p.hyc();
        }
        supportActionBar.hide();
        setSelfNavigationBarVisible(8);
        AppCompatActivity context = getContext();
        p.g(context, "context");
        setActionbarColor(context.getResources().getColor(R.color.YellowK));
        AppCompatActivity context2 = getContext();
        p.g(context2, "context");
        setNavigationbarColor(context2.getResources().getColor(R.color.YellowK));
        initView();
        overridePendingTransition(R.anim.dq, R.anim.s);
        AppMethodBeat.o(256375);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.axs;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(256376);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.f6do);
        AppMethodBeat.o(256376);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(256377);
        setMMTitle("");
        String string = getString(R.string.eaa);
        p.g(string, "getString(R.string.kids_…ogin_enter_loading_title)");
        ((KidsWatchHeadComponent) _$_findCachedViewById(R.id.dnl)).setTitle(string);
        ((KidsWatchHeadComponent) _$_findCachedViewById(R.id.dnl)).setCloseBtnCallBack(new b(this));
        String stringExtra = getIntent().getStringExtra("intent.key.login.url");
        p.g(stringExtra, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
        this.dZW = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("intent.key.reg.nickname");
        p.g(stringExtra2, "intent.getStringExtra(Co….INTENT_KEY_REG_NICKNAME)");
        this.nickname = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra("intent.key.reg.openid");
        p.g(stringExtra3, "intent.getStringExtra(Co…h.INTENT_KEY_REG_OPEN_ID)");
        this.openId = stringExtra3;
        Object[] objArr = new Object[1];
        String str = this.nickname;
        if (str == null) {
            p.btv("nickname");
        }
        objArr[0] = str;
        String string2 = getString(R.string.ebb, objArr);
        p.g(string2, "getString(R.string.kids_…t_content_desc, nickname)");
        TextView textView = (TextView) _$_findCachedViewById(R.id.bms);
        p.g(textView, "descTV");
        textView.setText(string2);
        ((Button) _$_findCachedViewById(R.id.dkd)).setOnClickListener(new c(this));
        com.tencent.mm.plugin.kidswatch.b.a aVar = com.tencent.mm.plugin.kidswatch.b.a.yBL;
        AppCompatActivity context = getContext();
        p.g(context, "context");
        com.tencent.mm.plugin.kidswatch.b.a.a(context, (LinearLayout) _$_findCachedViewById(R.id.f66), (LinearLayout) _$_findCachedViewById(R.id.a_z));
        AppMethodBeat.o(256377);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ KidsWatchRegSuccessUI yBK;

        c(KidsWatchRegSuccessUI kidsWatchRegSuccessUI) {
            this.yBK = kidsWatchRegSuccessUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256374);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegSuccessUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ae aeVar = ae.SYK;
            String format = String.format("/pages/home/home.html?scene=register&openid=%s", Arrays.copyOf(new Object[]{KidsWatchRegSuccessUI.b(this.yBK)}, 1));
            p.g(format, "java.lang.String.format(format, *args)");
            Log.i("MicroMsg.KidsWatchRegSuccessUI", "goWebUIBtn, path:".concat(String.valueOf(format)));
            com.tencent.mm.plugin.kidswatch.b.a aVar = com.tencent.mm.plugin.kidswatch.b.a.yBL;
            AppCompatActivity context = this.yBK.getContext();
            p.g(context, "context");
            com.tencent.mm.plugin.kidswatch.b.a.h(context, "", true);
            com.tencent.mm.plugin.kidswatch.b.a aVar2 = com.tencent.mm.plugin.kidswatch.b.a.yBL;
            AppCompatActivity context2 = this.yBK.getContext();
            p.g(context2, "context");
            com.tencent.mm.plugin.kidswatch.b.a.f(context2, "wxaaff6b96fc2cd3c6", format, "2");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegSuccessUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256374);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ KidsWatchRegSuccessUI yBK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(KidsWatchRegSuccessUI kidsWatchRegSuccessUI) {
            super(0);
            this.yBK = kidsWatchRegSuccessUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(256373);
            com.tencent.mm.plugin.kidswatch.b.a aVar = com.tencent.mm.plugin.kidswatch.b.a.yBL;
            AppCompatActivity context = this.yBK.getContext();
            p.g(context, "context");
            com.tencent.mm.plugin.kidswatch.b.a.h(context, KidsWatchRegSuccessUI.a(this.yBK), false);
            x xVar = x.SXb;
            AppMethodBeat.o(256373);
            return xVar;
        }
    }
}
