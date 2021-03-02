package com.tencent.mm.plugin.kidswatch.ui.login;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.kidswatch.a;
import com.tencent.mm.plugin.kidswatch.model.KidsWatchAcctInfo;
import com.tencent.mm.plugin.kidswatch.model.c;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0014J\b\u0010\u0014\u001a\u00020\u000bH\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0014J\"\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\u0012\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J,\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "curKidsAcctInfo", "Lcom/tencent/mm/protocal/protobuf/KidsAcctInfo;", "deviceName", "", "isShowRegBtn", "", "kidsCount", "", "loginUrl", "okSessionList", "convertTo", "kidsWatchAcctInfo", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo;", "finish", "", "getForceOrientation", "getLayoutId", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reLogin", "acctInfo", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchLoginCardChooseUI extends MMActivity implements i {
    public static final a yBj = new a((byte) 0);
    private HashMap _$_findViewCache;
    private String dZW;
    private String deviceName;
    private String yBa;
    private boolean yBg;
    private int yBh;
    private cgm yBi;

    static {
        AppMethodBeat.i(256241);
        AppMethodBeat.o(256241);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(256246);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(256246);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(256245);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(256245);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$Companion;", "", "()V", "REQUEST_SAFE_VERIFY", "", "TAG", "", "plugin-kidswatch_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ String a(KidsWatchLoginCardChooseUI kidsWatchLoginCardChooseUI) {
        AppMethodBeat.i(256242);
        String str = kidsWatchLoginCardChooseUI.dZW;
        if (str == null) {
            p.btv("loginUrl");
        }
        AppMethodBeat.o(256242);
        return str;
    }

    public static final /* synthetic */ void b(KidsWatchLoginCardChooseUI kidsWatchLoginCardChooseUI, cgm cgm) {
        AppMethodBeat.i(256244);
        kidsWatchLoginCardChooseUI.a(cgm);
        AppMethodBeat.o(256244);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(256234);
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
        AppMethodBeat.o(256234);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(256235);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.f6do);
        AppMethodBeat.o(256235);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(256236);
        finish();
        super.onBackPressed();
        AppMethodBeat.o(256236);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(256237);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 30846) {
            Log.i("KidsWatchLoginCardChooseUI", "onActivityResult, " + i2 + ", " + i3);
            if (i3 == -1) {
                if (this.yBi == null) {
                    AppMethodBeat.o(256237);
                    return;
                }
                cgm cgm = this.yBi;
                if (cgm == null) {
                    p.hyc();
                }
                a(cgm);
            }
        }
        AppMethodBeat.o(256237);
    }

    private final void a(cgm cgm) {
        AppMethodBeat.i(256238);
        Log.i("KidsWatchLoginCardChooseUI", "reLogin:" + cgm + ", userName:" + cgm.UserName);
        g.azz().a(972, this);
        String str = this.dZW;
        if (str == null) {
            p.btv("loginUrl");
        }
        g.azz().b(new com.tencent.mm.plugin.kidswatch.model.g(str, this.yBa, 2, cgm));
        AppMethodBeat.o(256238);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(256239);
        Log.i("KidsWatchLoginCardChooseUI", "initView");
        String string = getString(R.string.ea9);
        p.g(string, "getString(R.string.kids_…_login_card_choose_title)");
        ((KidsWatchHeadComponent) _$_findCachedViewById(R.id.dnl)).setTitle(string);
        ((KidsWatchHeadComponent) _$_findCachedViewById(R.id.dnl)).setCloseBtnCallBack(new b(this));
        String stringExtra = getIntent().getStringExtra("intent.key.login.url");
        p.g(stringExtra, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
        this.dZW = stringExtra;
        this.deviceName = getIntent().getStringExtra("intent.key.device.name");
        this.yBg = getIntent().getBooleanExtra("intent.key.ok.reg.btn", false);
        this.yBa = getIntent().getStringExtra("intent.key.ok.session.list");
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("intent.key.kids.list");
        this.yBh = parcelableArrayListExtra.size();
        StringBuilder sb = new StringBuilder("intent:<");
        String str = this.dZW;
        if (str == null) {
            p.btv("loginUrl");
        }
        Log.i("KidsWatchLoginCardChooseUI", sb.append(str).append(", ").append(this.deviceName).append(", ").append(this.yBg).append(", ").append(this.yBa).append(", ").append(this.yBh).append('>').toString());
        int i2 = this.yBh;
        for (int i3 = 0; i3 < i2; i3++) {
            AppCompatActivity context = getContext();
            p.g(context, "context");
            KidsWatchCardLayout kidsWatchCardLayout = new KidsWatchCardLayout(context);
            kidsWatchCardLayout.setId(i3);
            Object obj = parcelableArrayListExtra.get(i3);
            p.g(obj, "kidsList[i]");
            kidsWatchCardLayout.setData((KidsWatchAcctInfo) obj);
            if (i3 == this.yBh - 1) {
                LinearLayout linearLayout = (LinearLayout) kidsWatchCardLayout._$_findCachedViewById(R.id.ajm);
                p.g(linearLayout, "cardLL");
                ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    AppMethodBeat.o(256239);
                    throw tVar;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                int E = at.E(kidsWatchCardLayout.getContext(), com.tencent.h.c.c.getScreenWidth(kidsWatchCardLayout.getContext()));
                int fromDPToPix = at.fromDPToPix(kidsWatchCardLayout.getContext(), 8);
                if (E >= 375) {
                    fromDPToPix = at.fromDPToPix(kidsWatchCardLayout.getContext(), 24);
                }
                layoutParams2.setMargins(fromDPToPix, 0, fromDPToPix, 0);
                LinearLayout linearLayout2 = (LinearLayout) kidsWatchCardLayout._$_findCachedViewById(R.id.ajm);
                p.g(linearLayout2, "cardLL");
                linearLayout2.setLayoutParams(layoutParams2);
            }
            kidsWatchCardLayout.setOnClickListener(new c(this, parcelableArrayListExtra, i3));
            ((LinearLayout) _$_findCachedViewById(R.id.ajo)).addView(kidsWatchCardLayout);
        }
        ((TextView) _$_findCachedViewById(R.id.iex)).setOnClickListener(new d(this));
        ((ScrollView) _$_findCachedViewById(R.id.hcl)).post(new e(this));
        AppMethodBeat.o(256239);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ int hAM;
        final /* synthetic */ KidsWatchLoginCardChooseUI yBk;
        final /* synthetic */ ArrayList yBl;

        c(KidsWatchLoginCardChooseUI kidsWatchLoginCardChooseUI, ArrayList arrayList, int i2) {
            this.yBk = kidsWatchLoginCardChooseUI;
            this.yBl = arrayList;
            this.hAM = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256231);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            KidsWatchLoginCardChooseUI kidsWatchLoginCardChooseUI = this.yBk;
            Object obj = this.yBl.get(this.hAM);
            p.g(obj, "kidsList[i]");
            kidsWatchLoginCardChooseUI.yBi = KidsWatchLoginCardChooseUI.a((KidsWatchAcctInfo) obj);
            if (view == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchCardLayout");
                AppMethodBeat.o(256231);
                throw tVar;
            }
            if (((KidsWatchCardLayout) view).sPq) {
                h.c(this.yBk.getContext(), this.yBk.getString(R.string.ea6), "", this.yBk.getString(R.string.ea5), this.yBk.getString(R.string.ea4), new DialogInterface.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginCardChooseUI.c.AnonymousClass1 */
                    final /* synthetic */ c yBm;

                    {
                        this.yBm = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(256230);
                        KidsWatchLoginCardChooseUI kidsWatchLoginCardChooseUI = this.yBm.yBk;
                        cgm cgm = this.yBm.yBk.yBi;
                        if (cgm == null) {
                            p.hyc();
                        }
                        KidsWatchLoginCardChooseUI.b(kidsWatchLoginCardChooseUI, cgm);
                        AppMethodBeat.o(256230);
                    }
                }, null);
            } else {
                KidsWatchLoginCardChooseUI kidsWatchLoginCardChooseUI2 = this.yBk;
                cgm cgm = this.yBk.yBi;
                if (cgm == null) {
                    p.hyc();
                }
                KidsWatchLoginCardChooseUI.b(kidsWatchLoginCardChooseUI2, cgm);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256231);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ KidsWatchLoginCardChooseUI yBk;

        d(KidsWatchLoginCardChooseUI kidsWatchLoginCardChooseUI) {
            this.yBk = kidsWatchLoginCardChooseUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256232);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("KidsWatchLoginCardChooseUI", "click switch count button");
            Intent intent = new Intent();
            intent.putExtra("intent.key.login.url", KidsWatchLoginCardChooseUI.a(this.yBk));
            intent.putExtra("intent.key.device.name", this.yBk.deviceName);
            intent.putExtra("intent.key.ok.session.list", this.yBk.yBa);
            intent.putExtra("intent.key.ok.reg.btn", this.yBk.yBg);
            intent.putExtra("intent.key.kids.cnt", this.yBk.yBh);
            intent.putExtra("intent.key.enter.login.first", 2);
            intent.setFlags(268435456);
            intent.setClass(MMApplicationContext.getContext(), KidsWatchLoginFirst.class);
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256232);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ KidsWatchLoginCardChooseUI yBk;

        e(KidsWatchLoginCardChooseUI kidsWatchLoginCardChooseUI) {
            this.yBk = kidsWatchLoginCardChooseUI;
        }

        public final void run() {
            AppMethodBeat.i(256233);
            ((ScrollView) this.yBk._$_findCachedViewById(R.id.hcl)).fullScroll(130);
            AppMethodBeat.o(256233);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.axj;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(256240);
        Log.i("KidsWatchLoginCardChooseUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (qVar instanceof com.tencent.mm.plugin.kidswatch.model.g) {
            g.azz().b(972, this);
            if (i2 == 0 && i3 == a.b.ExtDeviceLoginRet_Ok.value) {
                u.cG(getContext(), getContext().getString(R.string.eap));
                com.tencent.mm.plugin.kidswatch.model.c cVar = com.tencent.mm.plugin.kidswatch.model.c.yAF;
                c.a aVar = c.a.ACCOUNT_TYPE_KIDS;
                String str2 = this.dZW;
                if (str2 == null) {
                    p.btv("loginUrl");
                }
                com.tencent.mm.plugin.kidswatch.model.c.a(aVar, str2, c.EnumC1454c.LOGIN_TYPE_DEFAULT, c.b.LOGIN_RESULT_SUCCESS, this.yBh, i3);
                com.tencent.mm.plugin.kidswatch.b.a aVar2 = com.tencent.mm.plugin.kidswatch.b.a.yBL;
                AppCompatActivity context = getContext();
                p.g(context, "context");
                com.tencent.mm.plugin.kidswatch.b.a.h(context, "", true);
                AppMethodBeat.o(256240);
                return;
            } else if (i2 == 4 && i3 == a.b.ExtDeviceLoginRet_Sapm.value) {
                Log.i("KidsWatchLoginCardChooseUI", i2 + ", " + i3 + ", showBlockBySpam");
                y.g(this, str, 30846);
                AppMethodBeat.o(256240);
                return;
            } else {
                com.tencent.mm.plugin.kidswatch.model.c cVar2 = com.tencent.mm.plugin.kidswatch.model.c.yAF;
                c.a aVar3 = c.a.ACCOUNT_TYPE_KIDS;
                String str3 = this.dZW;
                if (str3 == null) {
                    p.btv("loginUrl");
                }
                com.tencent.mm.plugin.kidswatch.model.c.a(aVar3, str3, c.EnumC1454c.LOGIN_TYPE_DEFAULT, c.b.LOGIN_RESULT_FAIL, this.yBh, i3);
                Log.i("KidsWatchLoginCardChooseUI", i2 + ", " + i3 + ", showAlertWhenError");
                com.tencent.mm.plugin.kidswatch.b.a aVar4 = com.tencent.mm.plugin.kidswatch.b.a.yBL;
                AppCompatActivity context2 = getContext();
                p.g(context2, "context");
                com.tencent.mm.plugin.kidswatch.b.a.c(context2, i3, str);
            }
        }
        AppMethodBeat.o(256240);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ KidsWatchLoginCardChooseUI yBk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(KidsWatchLoginCardChooseUI kidsWatchLoginCardChooseUI) {
            super(0);
            this.yBk = kidsWatchLoginCardChooseUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(256229);
            this.yBk.finish();
            com.tencent.mm.plugin.kidswatch.model.c cVar = com.tencent.mm.plugin.kidswatch.model.c.yAF;
            com.tencent.mm.plugin.kidswatch.model.c.a(c.a.ACCOUNT_TYPE_KIDS, KidsWatchLoginCardChooseUI.a(this.yBk), c.EnumC1454c.LOGIN_TYPE_DEFAULT, c.b.LOGIN_RESULT_CANCEL, this.yBk.yBh, 0);
            x xVar = x.SXb;
            AppMethodBeat.o(256229);
            return xVar;
        }
    }

    public static final /* synthetic */ cgm a(KidsWatchAcctInfo kidsWatchAcctInfo) {
        AppMethodBeat.i(256243);
        cgm cgm = new cgm();
        cgm.UserName = kidsWatchAcctInfo.userName;
        cgm.oUJ = kidsWatchAcctInfo.nickName;
        cgm.xJE = kidsWatchAcctInfo.iAR;
        cgm.oTI = kidsWatchAcctInfo.deviceName;
        cgm.MlV = kidsWatchAcctInfo.yAy;
        AppMethodBeat.o(256243);
        return cgm;
    }
}
