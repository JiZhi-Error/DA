package com.tencent.mm.plugin.kidswatch.ui.login;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.kidswatch.a;
import com.tencent.mm.plugin.kidswatch.model.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0014J\b\u0010\u0013\u001a\u00020\bH\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\"\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\u0012\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J,\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "deviceName", "kidsCount", "", "loginUrl", "okSessionList", "option", "radius", "doLoginOK", "", "loginScene", "finish", "", "getForceOrientation", "getLayoutId", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateCB", "plugin-kidswatch_release"})
public final class KidsWatchLoginFirstChooseSceneUI extends MMActivity implements i {
    private final String TAG = "MicroMsg.KidsWatchLoginFirstChooseSceneUI";
    private HashMap _$_findViewCache;
    private String dZW;
    private String deviceName;
    private int option;
    private final int radius = at.fromDPToPix(getContext(), 16);
    private String yBa;
    private int yBh;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(256284);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(256284);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(256283);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(256283);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public KidsWatchLoginFirstChooseSceneUI() {
        AppMethodBeat.i(256280);
        AppMethodBeat.o(256280);
    }

    public static final /* synthetic */ boolean a(KidsWatchLoginFirstChooseSceneUI kidsWatchLoginFirstChooseSceneUI, String str, String str2, int i2) {
        AppMethodBeat.i(256282);
        boolean ab = kidsWatchLoginFirstChooseSceneUI.ab(str, str2, i2);
        AppMethodBeat.o(256282);
        return ab;
    }

    public static final /* synthetic */ void b(KidsWatchLoginFirstChooseSceneUI kidsWatchLoginFirstChooseSceneUI) {
        AppMethodBeat.i(256281);
        kidsWatchLoginFirstChooseSceneUI.ebX();
        AppMethodBeat.o(256281);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(256272);
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
        setMMTitle("");
        initView();
        overridePendingTransition(R.anim.dq, R.anim.s);
        AppMethodBeat.o(256272);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(256273);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.f6do);
        AppMethodBeat.o(256273);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(256274);
        super.onBackPressed();
        finish();
        AppMethodBeat.o(256274);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        Bitmap bitmap;
        AppMethodBeat.i(256275);
        this.dZW = getIntent().getStringExtra("intent.key.login.url");
        this.yBh = getIntent().getIntExtra("intent.key.kids.cnt", 0);
        this.deviceName = getIntent().getStringExtra("intent.key.device.name");
        this.yBa = getIntent().getStringExtra("intent.key.ok.session.list");
        ((KidsWatchHeadComponent) _$_findCachedViewById(R.id.dnl)).setCloseIconResId(R.drawable.bw7);
        ((KidsWatchHeadComponent) _$_findCachedViewById(R.id.dnl)).setCloseBtnCallBack(new a(this));
        String aTY = z.aTY();
        ((RoundCornerImageView) _$_findCachedViewById(R.id.wn)).ly(this.radius, this.radius);
        Bitmap Mc = com.tencent.mm.aj.c.Mc(aTY);
        if (Mc == null) {
            com.tencent.mm.aj.p.aYn();
            bitmap = com.tencent.mm.aj.e.Mn(aTY);
        } else {
            bitmap = Mc;
        }
        if (bitmap != null) {
            ((RoundCornerImageView) _$_findCachedViewById(R.id.wn)).setImageBitmap(bitmap);
        }
        WeImageView weImageView = (WeImageView) _$_findCachedViewById(R.id.erb);
        ViewParent parent = weImageView != null ? weImageView.getParent() : null;
        if (parent == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(256275);
            throw tVar;
        }
        ((View) parent).setOnClickListener(new b(this));
        WeImageView weImageView2 = (WeImageView) _$_findCachedViewById(R.id.erf);
        ViewParent parent2 = weImageView2 != null ? weImageView2.getParent() : null;
        if (parent2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(256275);
            throw tVar2;
        }
        ((View) parent2).setOnClickListener(new c(this));
        ebX();
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.br9);
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new d(this));
        }
        ((Button) _$_findCachedViewById(R.id.erc)).setOnClickListener(new e(this));
        com.tencent.mm.plugin.kidswatch.b.a aVar = com.tencent.mm.plugin.kidswatch.b.a.yBL;
        AppCompatActivity context = getContext();
        p.g(context, "context");
        com.tencent.mm.plugin.kidswatch.b.a.a(context, (LinearLayout) _$_findCachedViewById(R.id.ajo), (LinearLayout) _$_findCachedViewById(R.id.a_z));
        AppMethodBeat.o(256275);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ KidsWatchLoginFirstChooseSceneUI yBs;

        b(KidsWatchLoginFirstChooseSceneUI kidsWatchLoginFirstChooseSceneUI) {
            this.yBs = kidsWatchLoginFirstChooseSceneUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256268);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.yBs.option = 0;
            KidsWatchLoginFirstChooseSceneUI.b(this.yBs);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256268);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ KidsWatchLoginFirstChooseSceneUI yBs;

        c(KidsWatchLoginFirstChooseSceneUI kidsWatchLoginFirstChooseSceneUI) {
            this.yBs = kidsWatchLoginFirstChooseSceneUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256269);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.yBs.option = 1;
            KidsWatchLoginFirstChooseSceneUI.b(this.yBs);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256269);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ KidsWatchLoginFirstChooseSceneUI yBs;

        d(KidsWatchLoginFirstChooseSceneUI kidsWatchLoginFirstChooseSceneUI) {
            this.yBs = kidsWatchLoginFirstChooseSceneUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256270);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent(this.yBs, KidsWatchLoginFirstChooseHelpUI.class);
            KidsWatchLoginFirstChooseSceneUI kidsWatchLoginFirstChooseSceneUI = this.yBs;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(kidsWatchLoginFirstChooseSceneUI, bl.axQ(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            kidsWatchLoginFirstChooseSceneUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(kidsWatchLoginFirstChooseSceneUI, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256270);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ KidsWatchLoginFirstChooseSceneUI yBs;

        e(KidsWatchLoginFirstChooseSceneUI kidsWatchLoginFirstChooseSceneUI) {
            this.yBs = kidsWatchLoginFirstChooseSceneUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256271);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            KidsWatchLoginFirstChooseSceneUI kidsWatchLoginFirstChooseSceneUI = this.yBs;
            String str = this.yBs.dZW;
            if (str == null) {
                p.hyc();
            }
            KidsWatchLoginFirstChooseSceneUI.a(kidsWatchLoginFirstChooseSceneUI, str, this.yBs.yBa, this.yBs.option);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256271);
        }
    }

    private final void ebX() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(256276);
        WeImageView weImageView = (WeImageView) _$_findCachedViewById(R.id.erb);
        if (weImageView != null) {
            if (this.option == 0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            weImageView.setVisibility(i2);
        }
        WeImageView weImageView2 = (WeImageView) _$_findCachedViewById(R.id.erf);
        if (weImageView2 != null) {
            if (this.option != 1) {
                i3 = 8;
            }
            weImageView2.setVisibility(i3);
            AppMethodBeat.o(256276);
            return;
        }
        AppMethodBeat.o(256276);
    }

    private final boolean ab(String str, String str2, int i2) {
        AppMethodBeat.i(256277);
        Log.i(this.TAG, "doLoginOK, login:" + str + ", okSession:" + str2 + ", scene:" + i2);
        g.azz().a(972, this);
        g.azz().b(new com.tencent.mm.plugin.kidswatch.model.g(str, str2, i2, null));
        AppMethodBeat.o(256277);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.axn;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(256278);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 30846) {
            Log.i(this.TAG, "onActivityResult, " + i2 + ", " + i3);
            if (i3 == -1) {
                String str = this.dZW;
                if (str == null) {
                    p.hyc();
                }
                ab(str, this.yBa, this.option);
            }
        }
        AppMethodBeat.o(256278);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4;
        AppMethodBeat.i(256279);
        Log.i(this.TAG, "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (qVar instanceof com.tencent.mm.plugin.kidswatch.model.g) {
            Log.i(this.TAG, "onSceneEnd type[%d]", Integer.valueOf(((com.tencent.mm.plugin.kidswatch.model.g) qVar).getType()));
            g.azz().b(972, this);
            if (i2 == 0 && i3 == 0) {
                if (this.option == 0) {
                    Log.i(this.TAG, "top");
                    com.tencent.mm.plugin.kidswatch.model.c cVar = com.tencent.mm.plugin.kidswatch.model.c.yAF;
                    c.a aVar = c.a.ACCOUNT_TYPE_NORMAL;
                    String str2 = this.dZW;
                    if (str2 == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.kidswatch.model.c.a(aVar, str2, c.EnumC1454c.LOGIN_TYPE_BOTH, c.b.LOGIN_RESULT_SUCCESS, this.yBh, i3);
                    i4 = R.string.eao;
                } else {
                    com.tencent.mm.plugin.kidswatch.model.c cVar2 = com.tencent.mm.plugin.kidswatch.model.c.yAF;
                    c.a aVar2 = c.a.ACCOUNT_TYPE_NORMAL;
                    String str3 = this.dZW;
                    if (str3 == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.kidswatch.model.c.a(aVar2, str3, c.EnumC1454c.LOGIN_TYPE_WATCH_ONLY, c.b.LOGIN_RESULT_SUCCESS, this.yBh, i3);
                    i4 = R.string.eap;
                }
                String string = getContext().getString(i4);
                p.g(string, "context.getString(toastTip)");
                Log.i(this.TAG, "Tips: ".concat(String.valueOf(string)));
                u.cG(getContext(), string);
                com.tencent.mm.plugin.kidswatch.b.a aVar3 = com.tencent.mm.plugin.kidswatch.b.a.yBL;
                AppCompatActivity context = getContext();
                p.g(context, "context");
                com.tencent.mm.plugin.kidswatch.b.a.h(context, "", true);
                AppMethodBeat.o(256279);
                return;
            } else if (i2 == 4 && i3 == a.b.ExtDeviceLoginRet_Sapm.value) {
                Log.i(this.TAG, "showBlockBySpam");
                y.g(this, str, 30846);
                AppMethodBeat.o(256279);
                return;
            } else {
                com.tencent.mm.plugin.kidswatch.model.c cVar3 = com.tencent.mm.plugin.kidswatch.model.c.yAF;
                c.a aVar4 = c.a.ACCOUNT_TYPE_NORMAL;
                String str4 = this.dZW;
                if (str4 == null) {
                    p.hyc();
                }
                com.tencent.mm.plugin.kidswatch.model.c.a(aVar4, str4, this.option == 0 ? c.EnumC1454c.LOGIN_TYPE_BOTH : c.EnumC1454c.LOGIN_TYPE_WATCH_ONLY, c.b.LOGIN_RESULT_FAIL, this.yBh, i3);
                com.tencent.mm.plugin.kidswatch.b.a aVar5 = com.tencent.mm.plugin.kidswatch.b.a.yBL;
                AppCompatActivity context2 = getContext();
                p.g(context2, "context");
                com.tencent.mm.plugin.kidswatch.b.a.c(context2, i3, str);
            }
        }
        AppMethodBeat.o(256279);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ KidsWatchLoginFirstChooseSceneUI yBs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(KidsWatchLoginFirstChooseSceneUI kidsWatchLoginFirstChooseSceneUI) {
            super(0);
            this.yBs = kidsWatchLoginFirstChooseSceneUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(256267);
            this.yBs.finish();
            x xVar = x.SXb;
            AppMethodBeat.o(256267);
            return xVar;
        }
    }
}
