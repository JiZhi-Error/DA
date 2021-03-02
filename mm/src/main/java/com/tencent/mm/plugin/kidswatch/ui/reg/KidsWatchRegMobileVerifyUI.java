package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.pay.tool.APPluginConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.kidswatch.model.c;
import com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 22\u00020\u00012\u00020\u00022\u00020\u0003:\u000223B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0014J$\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0014J\u0012\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0015H\u0014J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0017H\u0016J\b\u0010%\u001a\u00020\u0015H\u0014J\b\u0010&\u001a\u00020\u0015H\u0014J,\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010\b2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u0015H\u0002J\b\u0010.\u001a\u00020\u0015H\u0002J\b\u0010/\u001a\u00020\u0015H\u0002J\b\u00100\u001a\u00020\u0015H\u0002J\b\u00101\u001a\u00020\u0015H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0018\u00010\u0013R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "()V", "hasSetAvatar", "", "headImgAesKey", "", "headImgFileID", "loginUrl", "mobile", "nickName", Scopes.OPEN_ID, "plusCountryCode", "proDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "regSessionId", "verifyTimer", "Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$VerifyTimer;", "finish", "", "getForceOrientation", "", "getLayoutId", "gotoRebindUI", "lastNickname", "lastHeadImgUrl", "gotoRegSuccessUI", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestSms", "startExtReg", "startSms", "startSmsListener", "stopSmsListener", "Companion", "VerifyTimer", "plugin-kidswatch_release"})
public final class KidsWatchRegMobileVerifyUI extends MMActivity implements i, b.a {
    public static final a yBD = new a((byte) 0);
    private HashMap _$_findViewCache;
    private String dSf;
    private String dZW;
    private q kdn;
    private String knu;
    private boolean kpI;
    private final String kpW = "+86";
    private String nickName;
    private String openid;
    private String yBA;
    private String yBB;
    private b yBC;

    static {
        AppMethodBeat.i(256355);
        AppMethodBeat.o(256355);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(256359);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(256359);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(256358);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(256358);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$Companion;", "", "()V", "INTERVAL_UPDATE_TIME", "", "MAX_WAIT_TIME", "TAG", "", "plugin-kidswatch_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(KidsWatchRegMobileVerifyUI kidsWatchRegMobileVerifyUI) {
        AppMethodBeat.i(256356);
        kidsWatchRegMobileVerifyUI.eca();
        AppMethodBeat.o(256356);
    }

    public static final /* synthetic */ String d(KidsWatchRegMobileVerifyUI kidsWatchRegMobileVerifyUI) {
        AppMethodBeat.i(256357);
        String str = kidsWatchRegMobileVerifyUI.dZW;
        if (str == null) {
            p.btv("loginUrl");
        }
        AppMethodBeat.o(256357);
        return str;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(256345);
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
        AppMethodBeat.o(256345);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(256346);
        super.onResume();
        ((InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk)).setExternalListener(this);
        AppMethodBeat.o(256346);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(256347);
        super.onPause();
        ((InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk)).setExternalListener(null);
        bTC();
        AppMethodBeat.o(256347);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(256348);
        super.onDestroy();
        bTC();
        AppMethodBeat.o(256348);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(256349);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.f6do);
        AppMethodBeat.o(256349);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.axq;
    }

    private final void bTC() {
        b bVar;
        AppMethodBeat.i(256350);
        Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "stopSmsListener");
        if (this.yBC == null || (bVar = this.yBC) == null) {
            AppMethodBeat.o(256350);
            return;
        }
        bVar.cancel();
        AppMethodBeat.o(256350);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$VerifyTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "plugin-kidswatch_release"})
    public final class b extends CountDownTimer {
        /* JADX WARN: Incorrect types in method signature: (J)V */
        public b() {
            super(Util.MILLSECONDS_OF_MINUTE, 1000);
        }

        public final void onTick(long j2) {
            AppMethodBeat.i(256335);
            Button button = (Button) KidsWatchRegMobileVerifyUI.this._$_findCachedViewById(R.id.h3y);
            p.g(button, "resendVerifyCodeBtn");
            button.setText(KidsWatchRegMobileVerifyUI.this.getString(R.string.eb3, new Object[]{new StringBuilder().append(j2 / 1000).toString()}));
            AppMethodBeat.o(256335);
        }

        public final void onFinish() {
            AppMethodBeat.i(256336);
            Button button = (Button) KidsWatchRegMobileVerifyUI.this._$_findCachedViewById(R.id.h3y);
            p.g(button, "resendVerifyCodeBtn");
            button.setEnabled(true);
            Button button2 = (Button) KidsWatchRegMobileVerifyUI.this._$_findCachedViewById(R.id.h3y);
            p.g(button2, "resendVerifyCodeBtn");
            button2.setText(KidsWatchRegMobileVerifyUI.this.getString(R.string.eb4));
            AppCompatActivity context = KidsWatchRegMobileVerifyUI.this.getContext();
            p.g(context, "context");
            ((Button) KidsWatchRegMobileVerifyUI.this._$_findCachedViewById(R.id.h3y)).setTextColor(context.getResources().getColor(R.color.hd));
            AppMethodBeat.o(256336);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    public static final class g implements DialogInterface.OnCancelListener {
        public static final g yBF = new g();

        static {
            AppMethodBeat.i(256343);
            AppMethodBeat.o(256343);
        }

        g() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class h implements DialogInterface.OnCancelListener {
        final /* synthetic */ KidsWatchRegMobileVerifyUI yBE;
        final /* synthetic */ com.tencent.mm.plugin.kidswatch.model.d yBG;

        h(KidsWatchRegMobileVerifyUI kidsWatchRegMobileVerifyUI, com.tencent.mm.plugin.kidswatch.model.d dVar) {
            this.yBE = kidsWatchRegMobileVerifyUI;
            this.yBG = dVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(256344);
            com.tencent.mm.kernel.g.azz().a(this.yBG);
            com.tencent.mm.kernel.g.azz().b(5888, this.yBE);
            AppMethodBeat.o(256344);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(256352);
        setMMTitle("");
        String string = getString(R.string.eaa);
        p.g(string, "getString(R.string.kids_…ogin_enter_loading_title)");
        ((KidsWatchHeadComponent) _$_findCachedViewById(R.id.dnl)).setTitle(string);
        ((KidsWatchHeadComponent) _$_findCachedViewById(R.id.dnl)).setCloseBtnCallBack(new c(this));
        ((InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk)).setExternalListener(this);
        String stringExtra = getIntent().getStringExtra("intent.key.login.url");
        p.g(stringExtra, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
        this.dZW = stringExtra;
        this.dSf = getIntent().getStringExtra("intent.key.reg.mobile");
        String stringExtra2 = getIntent().getStringExtra("intent.key.reg.nickname");
        p.g(stringExtra2, "intent.getStringExtra(Co….INTENT_KEY_REG_NICKNAME)");
        this.nickName = stringExtra2;
        this.knu = getIntent().getStringExtra("intent.key.reg.session.id");
        this.kpI = getIntent().getBooleanExtra("intent.key.hasSetAvatar", false);
        String stringExtra3 = getIntent().getStringExtra("intent.key.reg.head_img.file.id");
        p.g(stringExtra3, "intent.getStringExtra(Co…KEY_REG_HEAD_IMG_FILE_ID)");
        this.yBA = stringExtra3;
        String stringExtra4 = getIntent().getStringExtra("intent.key.reg.head_img.aes.key");
        p.g(stringExtra4, "intent.getStringExtra(Co…KEY_REG_HEAD_IMG_AES_KEY)");
        this.yBB = stringExtra4;
        eca();
        ((Button) _$_findCachedViewById(R.id.h3y)).setOnClickListener(new d(this));
        ((MMClearEditText) _$_findCachedViewById(R.id.dyl)).addTextChangedListener(new e(this));
        Button button = (Button) _$_findCachedViewById(R.id.d4x);
        p.g(button, "finishBtn");
        button.setEnabled(false);
        ((Button) _$_findCachedViewById(R.id.d4x)).setOnClickListener(new f(this));
        TextView textView = (TextView) _$_findCachedViewById(R.id.fgk);
        p.g(textView, "mobileTV");
        textView.setText(this.dSf);
        com.tencent.mm.plugin.kidswatch.b.a aVar = com.tencent.mm.plugin.kidswatch.b.a.yBL;
        AppCompatActivity context = getContext();
        p.g(context, "context");
        com.tencent.mm.plugin.kidswatch.b.a.a(context, (LinearLayout) _$_findCachedViewById(R.id.f66), (LinearLayout) _$_findCachedViewById(R.id.a_z));
        AppMethodBeat.o(256352);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ KidsWatchRegMobileVerifyUI yBE;

        d(KidsWatchRegMobileVerifyUI kidsWatchRegMobileVerifyUI) {
            this.yBE = kidsWatchRegMobileVerifyUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256338);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            KidsWatchRegMobileVerifyUI.a(this.yBE);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256338);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$initView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-kidswatch_release"})
    public static final class e implements TextWatcher {
        final /* synthetic */ KidsWatchRegMobileVerifyUI yBE;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(KidsWatchRegMobileVerifyUI kidsWatchRegMobileVerifyUI) {
            this.yBE = kidsWatchRegMobileVerifyUI;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(256339);
            p.h(charSequence, "s");
            AppMethodBeat.o(256339);
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(256340);
            p.h(charSequence, "s");
            AppMethodBeat.o(256340);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(256341);
            p.h(editable, "s");
            Button button = (Button) this.yBE._$_findCachedViewById(R.id.d4x);
            p.g(button, "finishBtn");
            button.setEnabled(!Util.isNullOrNil(editable.toString()));
            AppMethodBeat.o(256341);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class f implements View.OnClickListener {
        final /* synthetic */ KidsWatchRegMobileVerifyUI yBE;

        f(KidsWatchRegMobileVerifyUI kidsWatchRegMobileVerifyUI) {
            this.yBE = kidsWatchRegMobileVerifyUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256342);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "click finish button, code:24");
            this.yBE.hideVKB();
            KidsWatchRegMobileVerifyUI kidsWatchRegMobileVerifyUI = this.yBE;
            this.yBE.getString(R.string.zb);
            kidsWatchRegMobileVerifyUI.kdn = com.tencent.mm.ui.base.h.a((Context) this.yBE, this.yBE.getString(R.string.a06), true, (DialogInterface.OnCancelListener) null);
            MMClearEditText mMClearEditText = (MMClearEditText) this.yBE._$_findCachedViewById(R.id.dyl);
            p.g(mMClearEditText, "inputVerifyCodeET");
            String obj = mMClearEditText.getText().toString();
            com.tencent.mm.kernel.g.azz().a(145, this.yBE);
            com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(this.yBE.dSf, 24, obj, 0, "");
            aVar.Ok(this.yBE.knu);
            aVar.Oj(KidsWatchRegMobileVerifyUI.d(this.yBE));
            com.tencent.mm.kernel.g.azz().b(aVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256342);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(256353);
        Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        q qVar2 = this.kdn;
        if (qVar2 != null) {
            qVar2.dismiss();
        }
        if (qVar instanceof com.tencent.mm.modelfriend.a) {
            com.tencent.mm.kernel.g.azz().b(145, this);
            int Vj = ((com.tencent.mm.modelfriend.a) qVar).Vj();
            Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "NetSceneBindMobileForReg, opCode:".concat(String.valueOf(Vj)));
            if (Vj != 23) {
                if (Vj == 24) {
                    switch (i3) {
                        case -212:
                            String bbT = ((com.tencent.mm.modelfriend.a) qVar).bbT();
                            String bbS = ((com.tencent.mm.modelfriend.a) qVar).bbS();
                            if (Util.isNullOrNil(bbT)) {
                                Log.e("MicroMsg.KidsWatchRegMobileVerifyUI", "rebind but last nickname is empty");
                            }
                            String str2 = this.knu;
                            if (str2 == null) {
                                p.hyc();
                            }
                            Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "gotoRebindUI, regSessionId:" + str2 + ", lastNickName:" + bbT + ", lastHeadImgUrl:" + bbS);
                            finish();
                            Intent intent = new Intent(this, KidsWatchRegRebindUI.class);
                            String str3 = this.dZW;
                            if (str3 == null) {
                                p.btv("loginUrl");
                            }
                            intent.putExtra("intent.key.login.url", str3);
                            String str4 = this.nickName;
                            if (str4 == null) {
                                p.btv("nickName");
                            }
                            intent.putExtra("intent.key.reg.nickname", str4);
                            intent.putExtra("intent.key.reg.last.nickname", bbT);
                            intent.putExtra("intent.key.reg.last.head.img.url", bbS);
                            intent.putExtra("intent.key.reg.mobile", this.dSf);
                            intent.putExtra("intent.key.reg.session.id", str2);
                            intent.putExtra("intent.key.hasSetAvatar", this.kpI);
                            String str5 = this.yBA;
                            if (str5 == null) {
                                p.btv("headImgFileID");
                            }
                            intent.putExtra("intent.key.reg.head_img.file.id", str5);
                            String str6 = this.yBB;
                            if (str6 == null) {
                                p.btv("headImgAesKey");
                            }
                            intent.putExtra("intent.key.reg.head_img.aes.key", str6);
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "gotoRebindUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "gotoRebindUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(256353);
                            return;
                        case APPluginConstants.ERROR_IO_ObjectStreamException_NotActiveException:
                            AppMethodBeat.o(256353);
                            return;
                        case 0:
                            StringBuilder sb = new StringBuilder("startExtReg, ");
                            String str7 = this.nickName;
                            if (str7 == null) {
                                p.btv("nickName");
                            }
                            Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", sb.append(str7).append(", ").append(this.kpI).append(", ").append(this.knu).append(", 4").toString());
                            com.tencent.mm.kernel.g.azz().a(5888, this);
                            String str8 = this.nickName;
                            if (str8 == null) {
                                p.btv("nickName");
                            }
                            String str9 = this.kpW + this.dSf;
                            boolean z = this.kpI;
                            String str10 = this.dZW;
                            if (str10 == null) {
                                p.btv("loginUrl");
                            }
                            String str11 = this.yBA;
                            if (str11 == null) {
                                p.btv("headImgFileID");
                            }
                            String str12 = this.yBB;
                            if (str12 == null) {
                                p.btv("headImgAesKey");
                            }
                            com.tencent.mm.plugin.kidswatch.model.d dVar = new com.tencent.mm.plugin.kidswatch.model.d(str8, str9, z, str10, str11, str12);
                            dVar.PB(this.knu);
                            com.tencent.mm.kernel.g.azz().b(dVar);
                            getString(R.string.zb);
                            this.kdn = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.eb7), true, (DialogInterface.OnCancelListener) new h(this, dVar));
                            AppMethodBeat.o(256353);
                            return;
                        default:
                            if (!new com.tencent.mm.platformtools.b().a(this, new ae(i2, i3, str))) {
                                String string = getString(R.string.eaq, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                                p.g(string, "getString(R.string.kids_…or_tip, errType, errCode)");
                                com.tencent.mm.ui.base.h.X(getContext(), string, "");
                                break;
                            } else {
                                AppMethodBeat.o(256353);
                                return;
                            }
                    }
                }
                AppMethodBeat.o(256353);
                return;
            } else if (i3 != 0) {
                if (i3 == -41) {
                    com.tencent.mm.ui.base.h.n(this, R.string.fz6, R.string.fz7);
                    AppMethodBeat.o(256353);
                    return;
                } else if (i3 == -34) {
                    com.tencent.mm.ui.base.h.X(this, getString(R.string.adu), "");
                    AppMethodBeat.o(256353);
                    return;
                } else {
                    if (new com.tencent.mm.platformtools.b().a(this, new ae(i2, i3, str))) {
                        AppMethodBeat.o(256353);
                        return;
                    } else if (com.tencent.mm.plugin.account.a.a.jRu.a(this, i2, i3, str)) {
                        AppMethodBeat.o(256353);
                        return;
                    } else {
                        AppMethodBeat.o(256353);
                        return;
                    }
                }
            }
        } else if (qVar instanceof com.tencent.mm.plugin.kidswatch.model.d) {
            Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "NetSceneExtReg");
            com.tencent.mm.kernel.g.azz().b(5888, this);
            if (i2 == 0 && i3 == 0) {
                String username = ((com.tencent.mm.plugin.kidswatch.model.d) qVar).getUsername();
                this.openid = ((com.tencent.mm.plugin.kidswatch.model.d) qVar).getOpenId();
                com.tencent.mm.plugin.kidswatch.model.c cVar = com.tencent.mm.plugin.kidswatch.model.c.yAF;
                if (username == null) {
                    username = "";
                }
                com.tencent.mm.plugin.kidswatch.model.c.a(username, c.d.REG_RESULT_SUCCESS, 0);
                StringBuilder sb2 = new StringBuilder("gotoRegSuccessUI, nickName:");
                String str13 = this.nickName;
                if (str13 == null) {
                    p.btv("nickName");
                }
                Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", sb2.append(str13).append(", openId:").append(this.openid).toString());
                finish();
                Intent intent2 = new Intent(this, KidsWatchRegSuccessUI.class);
                String str14 = this.dZW;
                if (str14 == null) {
                    p.btv("loginUrl");
                }
                intent2.putExtra("intent.key.login.url", str14);
                String str15 = this.nickName;
                if (str15 == null) {
                    p.btv("nickName");
                }
                intent2.putExtra("intent.key.reg.nickname", str15);
                intent2.putExtra("intent.key.reg.openid", this.openid);
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "gotoRegSuccessUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegMobileVerifyUI", "gotoRegSuccessUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(256353);
                return;
            }
            com.tencent.mm.plugin.kidswatch.model.c cVar2 = com.tencent.mm.plugin.kidswatch.model.c.yAF;
            com.tencent.mm.plugin.kidswatch.model.c.a("", c.d.REG_RESULT_FAIL, i3);
            if (new com.tencent.mm.platformtools.b().a(this, new ae(i2, i3, str))) {
                AppMethodBeat.o(256353);
                return;
            }
            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
            if (Dk != null) {
                Dk.a(this, null, null);
                AppMethodBeat.o(256353);
                return;
            }
            kotlin.g.b.ae aeVar = kotlin.g.b.ae.SYK;
            String format = String.format("注册失败，错误码(%s, %s)", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}, 2));
            p.g(format, "java.lang.String.format(format, *args)");
            com.tencent.mm.ui.base.h.X(getContext(), format, "");
        }
        AppMethodBeat.o(256353);
    }

    @Override // com.tencent.mm.ui.widget.b.a
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(256354);
        Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "keyboard show %s, keyboardHeight %d", Boolean.valueOf(z), Integer.valueOf(i2));
        if (z) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.dx6);
            p.g(linearLayout, "imgLL");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.a_z);
            p.g(linearLayout2, "bottomLL");
            ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(256354);
                throw tVar;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.ce);
            marginLayoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ci);
            LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(R.id.a_z);
            p.g(linearLayout3, "bottomLL");
            linearLayout3.setLayoutParams(marginLayoutParams);
            InputPanelLinearLayout inputPanelLinearLayout = (InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk);
            p.g(inputPanelLinearLayout, "inputContainer");
            int paddingLeft = inputPanelLinearLayout.getPaddingLeft();
            InputPanelLinearLayout inputPanelLinearLayout2 = (InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk);
            p.g(inputPanelLinearLayout2, "inputContainer");
            int paddingTop = inputPanelLinearLayout2.getPaddingTop();
            InputPanelLinearLayout inputPanelLinearLayout3 = (InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk);
            p.g(inputPanelLinearLayout3, "inputContainer");
            ((InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk)).setPadding(paddingLeft, paddingTop, inputPanelLinearLayout3.getPaddingRight(), i2);
            ((InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk)).requestLayout();
            AppMethodBeat.o(256354);
            return;
        }
        LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(R.id.dx6);
        p.g(linearLayout4, "imgLL");
        linearLayout4.setVisibility(0);
        LinearLayout linearLayout5 = (LinearLayout) _$_findCachedViewById(R.id.a_z);
        p.g(linearLayout5, "bottomLL");
        ViewGroup.LayoutParams layoutParams2 = linearLayout5.getLayoutParams();
        if (layoutParams2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(256354);
            throw tVar2;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.bx);
        marginLayoutParams2.topMargin = 0;
        LinearLayout linearLayout6 = (LinearLayout) _$_findCachedViewById(R.id.a_z);
        p.g(linearLayout6, "bottomLL");
        linearLayout6.setLayoutParams(marginLayoutParams2);
        InputPanelLinearLayout inputPanelLinearLayout4 = (InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk);
        p.g(inputPanelLinearLayout4, "inputContainer");
        int paddingLeft2 = inputPanelLinearLayout4.getPaddingLeft();
        InputPanelLinearLayout inputPanelLinearLayout5 = (InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk);
        p.g(inputPanelLinearLayout5, "inputContainer");
        int paddingTop2 = inputPanelLinearLayout5.getPaddingTop();
        InputPanelLinearLayout inputPanelLinearLayout6 = (InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk);
        p.g(inputPanelLinearLayout6, "inputContainer");
        ((InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk)).setPadding(paddingLeft2, paddingTop2, inputPanelLinearLayout6.getPaddingRight(), 0);
        AppMethodBeat.o(256354);
    }

    private final void eca() {
        AppMethodBeat.i(256351);
        Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "startSmsListener");
        if (this.yBC != null) {
            b bVar = this.yBC;
            if (bVar != null) {
                bVar.cancel();
            }
        } else {
            this.yBC = new b();
        }
        Button button = (Button) _$_findCachedViewById(R.id.h3y);
        p.g(button, "resendVerifyCodeBtn");
        button.setEnabled(false);
        AppCompatActivity context = getContext();
        p.g(context, "context");
        ((Button) _$_findCachedViewById(R.id.h3y)).setTextColor(context.getResources().getColor(R.color.BW_0_Alpha_0_3_k));
        b bVar2 = this.yBC;
        if (bVar2 != null) {
            bVar2.start();
        }
        Log.i("MicroMsg.KidsWatchRegMobileVerifyUI", "requestSms, opCode:23");
        com.tencent.mm.kernel.g.azz().a(145, this);
        getString(R.string.zb);
        this.kdn = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fyo), true, (DialogInterface.OnCancelListener) g.yBF);
        com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(this.kpW + this.dSf, 23, "", 0, "", 0);
        aVar.Ok(this.knu);
        String str = this.dZW;
        if (str == null) {
            p.btv("loginUrl");
        }
        aVar.Oj(str);
        com.tencent.mm.kernel.g.azz().b(aVar);
        AppMethodBeat.o(256351);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ KidsWatchRegMobileVerifyUI yBE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(KidsWatchRegMobileVerifyUI kidsWatchRegMobileVerifyUI) {
            super(0);
            this.yBE = kidsWatchRegMobileVerifyUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(256337);
            this.yBE.finish();
            x xVar = x.SXb;
            AppMethodBeat.o(256337);
            return xVar;
        }
    }
}
