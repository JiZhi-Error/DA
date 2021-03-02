package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.kidswatch.model.b;
import com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dmd;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.b;
import java.io.IOException;
import java.util.HashMap;
import java.util.TimeZone;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@com.tencent.mm.ui.base.a(35)
@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 C2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001CB\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\rH\u0014J\b\u0010\u001f\u001a\u00020\rH\u0014J\b\u0010 \u001a\u00020\u0019H\u0002J\u0018\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020\u0019H\u0014J\"\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0012\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\"\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\rH\u0016J\b\u00104\u001a\u00020\u0019H\u0002J\b\u00105\u001a\u00020\u0019H\u0014J-\u00106\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\r2\u000e\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u0007082\u0006\u00109\u001a\u00020:H\u0016¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020\u0019H\u0014J,\u0010=\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010\u00072\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0018\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0016J\b\u0010B\u001a\u00020\u0019H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchHeadImageUploader$IImgUploadCallback;", "()V", "adjustedMobile", "", "avatarBitmap", "Landroid/graphics/Bitmap;", "hasSetAvatar", "", "inputMobileRetrys", "", "lastInputMobile", "loginUrl", "mMobile", "needShowAgreements", "permissionCheckHelper", "Lcom/tencent/mm/platformtools/PermissionCheckHelper;", "plusCountryCode", "proDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "regSessionId", "changeAvatar", "", "checkMobileState", "mNumber", "checkMobileStateFun", "finish", "getForceOrientation", "getLayoutId", "gotoLawLink", "gotoMobileVerifyCodePage", "fileId", "aesKey", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "errType", "errCode", "errMsg", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onKeyBoardHidden", "onPause", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSuccess", "fileID", "uploadHeadImg", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchRegGetInfoUI extends MMActivity implements com.tencent.mm.ak.i, b.AbstractC1453b, b.a {
    public static final a yBt = new a((byte) 0);
    private HashMap _$_findViewCache;
    private String dZW;
    private q kdn;
    private final x kmF = new x();
    private String knP;
    private String knm;
    private String knn;
    private int kno;
    private String knu;
    private boolean kpI;
    private final String kpW = "+86";
    private Bitmap kqc;
    private boolean kqi = true;

    static {
        AppMethodBeat.i(256319);
        AppMethodBeat.o(256319);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(256325);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(256325);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(256324);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(256324);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$Companion;", "", "()V", "TAG", "", "plugin-kidswatch_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public KidsWatchRegGetInfoUI() {
        AppMethodBeat.i(256318);
        AppMethodBeat.o(256318);
    }

    public static final /* synthetic */ void c(KidsWatchRegGetInfoUI kidsWatchRegGetInfoUI, String str) {
        AppMethodBeat.i(256323);
        kidsWatchRegGetInfoUI.Tv(str);
        AppMethodBeat.o(256323);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(256303);
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
        AppMethodBeat.o(256303);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.axo;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(256304);
        super.onResume();
        ((InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk)).setExternalListener(this);
        ebZ();
        AppMethodBeat.o(256304);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(256305);
        super.onPause();
        ((InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk)).setExternalListener(null);
        AppMethodBeat.o(256305);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(256306);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.f6do);
        AppMethodBeat.o(256306);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        boolean z = true;
        AppMethodBeat.i(256307);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        if (i2 == 34) {
            if (iArr.length == 0) {
                z = false;
            }
            if (z && iArr[0] == 0) {
                Log.i("MicroMsg.KidsWatchRegGetInfoUI", "PERMISSION_GRANTED");
                com.tencent.mm.plugin.account.a.a.jRu.s(this);
                AppMethodBeat.o(256307);
                return;
            }
        } else {
            this.kmF.a(this, i2, strArr, iArr);
        }
        AppMethodBeat.o(256307);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ KidsWatchRegGetInfoUI yBu;
        final /* synthetic */ String yBv;

        b(KidsWatchRegGetInfoUI kidsWatchRegGetInfoUI, String str) {
            this.yBu = kidsWatchRegGetInfoUI;
            this.yBv = str;
        }

        public final void run() {
            AppMethodBeat.i(256285);
            KidsWatchRegGetInfoUI.a(this.yBu, this.yBv);
            AppMethodBeat.o(256285);
        }
    }

    private final void Tv(String str) {
        AppMethodBeat.i(256308);
        this.kmF.b(this, new b(this, str));
        AppMethodBeat.o(256308);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(256309);
        setMMTitle("");
        hideActionbarLine();
        String string = getString(R.string.eaa);
        p.g(string, "getString(R.string.kids_…ogin_enter_loading_title)");
        ((KidsWatchHeadComponent) _$_findCachedViewById(R.id.dnl)).setTitle(string);
        ((KidsWatchHeadComponent) _$_findCachedViewById(R.id.dnl)).ebW();
        ((KidsWatchHeadComponent) _$_findCachedViewById(R.id.dnl)).setCloseBtnCallBack(new c(this));
        ((InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk)).setExternalListener(this);
        ((RelativeLayout) _$_findCachedViewById(R.id.b0z)).setOnClickListener(new d(this));
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.gf);
        p.g(imageView, "addAvatarIV");
        imageView.setVisibility(0);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) _$_findCachedViewById(R.id.wn);
        p.g(roundCornerImageView, "avatarIV");
        roundCornerImageView.setVisibility(8);
        ((RoundCornerImageView) _$_findCachedViewById(R.id.wn)).ly(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 22), com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 22));
        ((MMClearEditText) _$_findCachedViewById(R.id.fz5)).addTextChangedListener(new e(this));
        ((MMClearEditText) _$_findCachedViewById(R.id.fgj)).addTextChangedListener(new f(this));
        com.tencent.mm.kernel.g.aAk().postAtFrontOfWorker(new g(this));
        Util.expandViewTouchArea((CheckBox) _$_findCachedViewById(R.id.e8z), 250, 250, 250, 250);
        Button button = (Button) _$_findCachedViewById(R.id.gys);
        p.g(button, "regBtn");
        button.setEnabled(false);
        ((CheckBox) _$_findCachedViewById(R.id.e8z)).setOnCheckedChangeListener(new h(this));
        String string2 = getString(R.string.eav);
        p.g(string2, "getString(R.string.kids_…eg_intro_get_info_cb_tip)");
        String string3 = getString(R.string.eaw);
        p.g(string3, "getString(R.string.kids_…tro_get_info_cb_tip_link)");
        int g2 = n.g(string2, string3);
        if (g2 < 0) {
            AppMethodBeat.o(256309);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string2);
        spannableStringBuilder.setSpan(new i(this), g2, string3.length() + g2, 18);
        ((TextView) _$_findCachedViewById(R.id.e90)).setOnTouchListener(new o(this));
        TextView textView = (TextView) _$_findCachedViewById(R.id.e90);
        p.g(textView, "lawDetailTV");
        textView.setClickable(true);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.e90);
        p.g(textView2, "lawDetailTV");
        textView2.setText(spannableStringBuilder);
        String stringExtra = getIntent().getStringExtra("intent.key.login.url");
        p.g(stringExtra, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
        this.dZW = stringExtra;
        ((Button) _$_findCachedViewById(R.id.gys)).setOnClickListener(new j(this));
        com.tencent.mm.plugin.kidswatch.b.a aVar = com.tencent.mm.plugin.kidswatch.b.a.yBL;
        AppCompatActivity context = getContext();
        p.g(context, "context");
        com.tencent.mm.plugin.kidswatch.b.a.a(context, (LinearLayout) _$_findCachedViewById(R.id.ajo), (LinearLayout) _$_findCachedViewById(R.id.a_z));
        AppMethodBeat.o(256309);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ KidsWatchRegGetInfoUI yBu;

        d(KidsWatchRegGetInfoUI kidsWatchRegGetInfoUI) {
            this.yBu = kidsWatchRegGetInfoUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256287);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            KidsWatchRegGetInfoUI.a(this.yBu);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256287);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-kidswatch_release"})
    public static final class e implements TextWatcher {
        final /* synthetic */ KidsWatchRegGetInfoUI yBu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(KidsWatchRegGetInfoUI kidsWatchRegGetInfoUI) {
            this.yBu = kidsWatchRegGetInfoUI;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(256288);
            p.h(charSequence, "s");
            AppMethodBeat.o(256288);
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(256289);
            p.h(charSequence, "s");
            AppMethodBeat.o(256289);
        }

        public final void afterTextChanged(Editable editable) {
            boolean z;
            AppMethodBeat.i(256290);
            p.h(editable, "s");
            Button button = (Button) this.yBu._$_findCachedViewById(R.id.gys);
            p.g(button, "regBtn");
            if (!Util.isNullOrNil(editable.toString())) {
                MMClearEditText mMClearEditText = (MMClearEditText) this.yBu._$_findCachedViewById(R.id.fgj);
                p.g(mMClearEditText, "mobileFIV");
                if (!Util.isNullOrNil(mMClearEditText.getText())) {
                    CheckBox checkBox = (CheckBox) this.yBu._$_findCachedViewById(R.id.e8z);
                    p.g(checkBox, "lawDetailCB");
                    if (checkBox.isChecked()) {
                        z = true;
                        button.setEnabled(z);
                        AppMethodBeat.o(256290);
                    }
                }
            }
            z = false;
            button.setEnabled(z);
            AppMethodBeat.o(256290);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$4", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-kidswatch_release"})
    public static final class f implements TextWatcher {
        final /* synthetic */ KidsWatchRegGetInfoUI yBu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(KidsWatchRegGetInfoUI kidsWatchRegGetInfoUI) {
            this.yBu = kidsWatchRegGetInfoUI;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(256291);
            p.h(charSequence, "s");
            AppMethodBeat.o(256291);
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(256292);
            p.h(charSequence, "s");
            AppMethodBeat.o(256292);
        }

        public final void afterTextChanged(Editable editable) {
            boolean z;
            AppMethodBeat.i(256293);
            p.h(editable, "s");
            Button button = (Button) this.yBu._$_findCachedViewById(R.id.gys);
            p.g(button, "regBtn");
            if (!Util.isNullOrNil(editable.toString())) {
                MMClearEditText mMClearEditText = (MMClearEditText) this.yBu._$_findCachedViewById(R.id.fz5);
                p.g(mMClearEditText, "nickFIV");
                if (!Util.isNullOrNil(mMClearEditText.getText())) {
                    CheckBox checkBox = (CheckBox) this.yBu._$_findCachedViewById(R.id.e8z);
                    p.g(checkBox, "lawDetailCB");
                    if (checkBox.isChecked()) {
                        z = true;
                        button.setEnabled(z);
                        AppMethodBeat.o(256293);
                    }
                }
            }
            z = false;
            button.setEnabled(z);
            AppMethodBeat.o(256293);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$5", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$IWaitWorkThread;", "nickname", "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "doInBackground", "", "onPostExecute", "toString", "plugin-kidswatch_release"})
    public static final class g implements MMHandlerThread.IWaitWorkThread {
        private String nickname;
        final /* synthetic */ KidsWatchRegGetInfoUI yBu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(KidsWatchRegGetInfoUI kidsWatchRegGetInfoUI) {
            this.yBu = kidsWatchRegGetInfoUI;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
        public final boolean onPostExecute() {
            boolean z;
            AppMethodBeat.i(256294);
            if (!Util.isNullOrNil(this.nickname)) {
                StringBuilder sb = new StringBuilder();
                MMClearEditText mMClearEditText = (MMClearEditText) this.yBu._$_findCachedViewById(R.id.fz5);
                p.g(mMClearEditText, "nickFIV");
                String sb2 = sb.append((Object) mMClearEditText.getText()).toString();
                int length = sb2.length() - 1;
                boolean z2 = false;
                int i2 = 0;
                while (i2 <= length) {
                    if (sb2.charAt(!z2 ? i2 : length) <= ' ') {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z2) {
                        if (!z) {
                            break;
                        }
                        length--;
                    } else if (!z) {
                        z2 = true;
                    } else {
                        i2++;
                    }
                }
                if (Util.isNullOrNil(sb2.subSequence(i2, length + 1).toString())) {
                    ((MMClearEditText) this.yBu._$_findCachedViewById(R.id.fz5)).setText(this.nickname);
                }
            }
            if (!com.tencent.mm.compatible.util.e.apn()) {
                Log.e("MicroMsg.KidsWatchRegGetInfoUI", "SDcard is not available");
                AppMethodBeat.o(256294);
                return false;
            }
            if (this.yBu.kqc != null) {
                Bitmap bitmap = this.yBu.kqc;
                if (bitmap == null) {
                    p.hyc();
                }
                if (!bitmap.isRecycled() && !this.yBu.kpI) {
                    ((RoundCornerImageView) this.yBu._$_findCachedViewById(R.id.wn)).setImageBitmap(this.yBu.kqc);
                    RoundCornerImageView roundCornerImageView = (RoundCornerImageView) this.yBu._$_findCachedViewById(R.id.wn);
                    p.g(roundCornerImageView, "avatarIV");
                    roundCornerImageView.setVisibility(0);
                    ImageView imageView = (ImageView) this.yBu._$_findCachedViewById(R.id.gf);
                    p.g(imageView, "addAvatarIV");
                    imageView.setVisibility(8);
                    this.yBu.kpI = true;
                }
            }
            AppMethodBeat.o(256294);
            return true;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
        public final boolean doInBackground() {
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(256295);
            String str = super.toString() + "|initView2";
            AppMethodBeat.o(256295);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
    public static final class h implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ KidsWatchRegGetInfoUI yBu;

        h(KidsWatchRegGetInfoUI kidsWatchRegGetInfoUI) {
            this.yBu = kidsWatchRegGetInfoUI;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.i(256296);
            MMClearEditText mMClearEditText = (MMClearEditText) this.yBu._$_findCachedViewById(R.id.fz5);
            p.g(mMClearEditText, "nickFIV");
            if (!Util.isNullOrNil(mMClearEditText.getText().toString())) {
                MMClearEditText mMClearEditText2 = (MMClearEditText) this.yBu._$_findCachedViewById(R.id.fgj);
                p.g(mMClearEditText2, "mobileFIV");
                if (!Util.isNullOrNil(mMClearEditText2.getText().toString()) && z) {
                    Button button = (Button) this.yBu._$_findCachedViewById(R.id.gys);
                    p.g(button, "regBtn");
                    button.setEnabled(z);
                }
            }
            if (!z) {
                Button button2 = (Button) this.yBu._$_findCachedViewById(R.id.gys);
                p.g(button2, "regBtn");
                button2.setEnabled(z);
            }
            AppMethodBeat.o(256296);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$7", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-kidswatch_release"})
    public static final class i extends com.tencent.mm.plugin.kidswatch.model.a {
        final /* synthetic */ KidsWatchRegGetInfoUI yBu;

        /* JADX WARN: Incorrect types in method signature: (I)V */
        i(KidsWatchRegGetInfoUI kidsWatchRegGetInfoUI) {
            this.yBu = kidsWatchRegGetInfoUI;
        }

        @Override // com.tencent.mm.plugin.kidswatch.model.a
        public final void ebS() {
            AppMethodBeat.i(256297);
            KidsWatchRegGetInfoUI.e(this.yBu);
            AppMethodBeat.o(256297);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class j implements View.OnClickListener {
        final /* synthetic */ KidsWatchRegGetInfoUI yBu;

        j(KidsWatchRegGetInfoUI kidsWatchRegGetInfoUI) {
            this.yBu = kidsWatchRegGetInfoUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256301);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.KidsWatchRegGetInfoUI", "click reg button");
            KidsWatchRegGetInfoUI kidsWatchRegGetInfoUI = this.yBu;
            this.yBu.getString(R.string.zb);
            kidsWatchRegGetInfoUI.kdn = com.tencent.mm.ui.base.h.a((Context) this.yBu, this.yBu.getString(R.string.a06), true, (DialogInterface.OnCancelListener) null);
            com.tencent.mm.ui.tools.b.c.f((MMClearEditText) this.yBu._$_findCachedViewById(R.id.fz5)).lv(1, 32).CN(true).a(new c.a(this) {
                /* class com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegGetInfoUI.j.AnonymousClass1 */
                final /* synthetic */ j yBw;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.yBw = r1;
                }

                @Override // com.tencent.mm.ui.tools.b.c.a
                public final void Tw(String str) {
                    AppMethodBeat.i(256298);
                    p.h(str, "text");
                    KidsWatchRegGetInfoUI kidsWatchRegGetInfoUI = this.yBw.yBu;
                    MMClearEditText mMClearEditText = (MMClearEditText) this.yBw.yBu._$_findCachedViewById(R.id.fgj);
                    p.g(mMClearEditText, "mobileFIV");
                    kidsWatchRegGetInfoUI.knP = PhoneFormater.pureNumber(mMClearEditText.getText().toString());
                    String str2 = this.yBw.yBu.kpW + this.yBw.yBu.knP;
                    this.yBw.yBu.hideVKB();
                    if (this.yBw.yBu.kqi) {
                        q qVar = this.yBw.yBu.kdn;
                        if (qVar != null) {
                            qVar.dismiss();
                        }
                        String string = this.yBw.yBu.getString(R.string.ee8, new Object[]{LocaleUtil.getApplicationLanguage(), WeChatBrands.AppInfo.LANG_CN, "kidswatchreg", 1, 0});
                        p.g(string, "getString(R.string.licen…N\", \"kidswatchreg\", 1, 0)");
                        com.tencent.mm.plugin.account.a.b.a.b(this.yBw.yBu.getContext(), string, 30847, false);
                        AppMethodBeat.o(256298);
                        return;
                    }
                    KidsWatchRegGetInfoUI.c(this.yBw.yBu, str2);
                    AppMethodBeat.o(256298);
                }

                @Override // com.tencent.mm.ui.tools.b.c.a
                public final void Tx(String str) {
                    AppMethodBeat.i(256299);
                    p.h(str, "text");
                    q qVar = this.yBw.yBu.kdn;
                    if (qVar != null) {
                        qVar.dismiss();
                    }
                    com.tencent.mm.ui.base.h.n(this.yBw.yBu.getContext(), R.string.gqv, R.string.gqy);
                    AppMethodBeat.o(256299);
                }

                @Override // com.tencent.mm.ui.tools.b.c.a
                public final void dv(String str) {
                    AppMethodBeat.i(256300);
                    p.h(str, "text");
                    q qVar = this.yBw.yBu.kdn;
                    if (qVar != null) {
                        qVar.dismiss();
                    }
                    com.tencent.mm.ui.base.h.n(this.yBw.yBu.getContext(), R.string.gqw, R.string.gqy);
                    AppMethodBeat.o(256300);
                }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256301);
        }
    }

    private final void ebY() {
        AppMethodBeat.i(256310);
        if (!this.kpI) {
            Log.i("MicroMsg.KidsWatchRegGetInfoUI", "uploadHeadImg, gotoMobileVerifyCodePage, " + this.kpI);
            ir("", "");
            AppMethodBeat.o(256310);
            return;
        }
        com.tencent.mm.plugin.kidswatch.model.b bVar = new com.tencent.mm.plugin.kidswatch.model.b(com.tencent.mm.loader.j.b.aKR() + "temp.avatar", this);
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        gVar.taskName = "task_KidsWatchHeadImageUpload";
        gVar.gqy = bVar.iZc;
        gVar.field_mediaId = bVar.mediaId;
        gVar.field_fullpath = bVar.dRr;
        gVar.field_thumbpath = "";
        gVar.field_fileType = com.tencent.mm.plugin.kidswatch.model.b.jSm;
        gVar.field_talker = "";
        gVar.field_priority = com.tencent.mm.i.a.gpM;
        gVar.field_needStorage = false;
        gVar.field_isStreamMedia = false;
        gVar.field_appType = 1;
        gVar.field_bzScene = 0;
        gVar.fuQ = 5;
        gVar.field_trysafecdn = true;
        gVar.field_enable_hitcheck = false;
        if (!com.tencent.mm.an.f.baQ().f(gVar)) {
            Log.e("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra addSendTask failed. mediaId:%s", bVar.mediaId);
        }
        AppMethodBeat.o(256310);
    }

    private final void ir(String str, String str2) {
        AppMethodBeat.i(256311);
        Intent intent = new Intent(this, KidsWatchRegMobileVerifyUI.class);
        String str3 = this.dZW;
        if (str3 == null) {
            p.btv("loginUrl");
        }
        intent.putExtra("intent.key.login.url", str3);
        MMClearEditText mMClearEditText = (MMClearEditText) _$_findCachedViewById(R.id.fz5);
        p.g(mMClearEditText, "nickFIV");
        intent.putExtra("intent.key.reg.nickname", mMClearEditText.getText().toString());
        MMClearEditText mMClearEditText2 = (MMClearEditText) _$_findCachedViewById(R.id.fgj);
        p.g(mMClearEditText2, "mobileFIV");
        intent.putExtra("intent.key.reg.mobile", mMClearEditText2.getText().toString());
        intent.putExtra("intent.key.reg.session.id", this.knu);
        intent.putExtra("intent.key.hasSetAvatar", this.kpI);
        intent.putExtra("intent.key.reg.head_img.file.id", str);
        intent.putExtra("intent.key.reg.head_img.aes.key", str2);
        Log.i("MicroMsg.KidsWatchRegGetInfoUI", "get info page:(fileId:" + str + ") , (aesKey:" + str2 + ')');
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI", "gotoMobileVerifyCodePage", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegGetInfoUI", "gotoMobileVerifyCodePage", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(256311);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        Bundle bundle = null;
        AppMethodBeat.i(256312);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.KidsWatchRegGetInfoUI", "onActivityResult, requestCode:" + i2 + ", resultCode: " + i3);
        if (i2 == 30846) {
            if (i3 == -1) {
                if (intent != null) {
                    bundle = intent.getBundleExtra("result_data");
                }
                if (bundle != null && p.j(bundle.getString("go_next", ""), "get_reg_verify_code")) {
                    ebY();
                    AppMethodBeat.o(256312);
                    return;
                }
            }
        } else if (i2 == 30847) {
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (bundle != null && p.j(bundle.getString("go_next", ""), "agree_privacy")) {
                this.kqi = false;
                Tv(this.kpW + this.knP);
                AppMethodBeat.o(256312);
                return;
            }
        } else {
            this.kqc = com.tencent.mm.plugin.account.a.a.jRu.b(this, i2, i3, intent);
            if (this.kqc != null) {
                ((RoundCornerImageView) _$_findCachedViewById(R.id.wn)).setImageBitmap(this.kqc);
                this.kpI = true;
                RoundCornerImageView roundCornerImageView = (RoundCornerImageView) _$_findCachedViewById(R.id.wn);
                p.g(roundCornerImageView, "avatarIV");
                roundCornerImageView.setVisibility(0);
                ImageView imageView = (ImageView) _$_findCachedViewById(R.id.gf);
                p.g(imageView, "addAvatarIV");
                imageView.setVisibility(8);
            }
        }
        AppMethodBeat.o(256312);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z;
        AppMethodBeat.i(256313);
        q qVar2 = this.kdn;
        if (qVar2 != null) {
            qVar2.dismiss();
        }
        if (i3 == -75) {
            com.tencent.mm.ui.base.h.n(this, R.string.h0, R.string.fxq);
            AppMethodBeat.o(256313);
            return;
        }
        if (qVar instanceof com.tencent.mm.modelfriend.a) {
            Log.i("MicroMsg.KidsWatchRegGetInfoUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
            com.tencent.mm.kernel.g.azz().b(145, this);
            int Vj = ((com.tencent.mm.modelfriend.a) qVar).Vj();
            this.knu = ((com.tencent.mm.modelfriend.a) qVar).bbU();
            if (Vj == 22) {
                if (i2 == 0 && i3 == 0) {
                    ebY();
                    AppMethodBeat.o(256313);
                    return;
                } else if (i3 == -41 || i3 == -59) {
                    com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                    if (Dk != null) {
                        Dk.a(this, null, null);
                        AppMethodBeat.o(256313);
                        return;
                    }
                    com.tencent.mm.ui.base.h.n(this, R.string.fz6, R.string.fz7);
                    AppMethodBeat.o(256313);
                    return;
                } else {
                    this.knP = PhoneFormater.pureNumber(this.knP);
                    this.knn = this.kpW + this.knP;
                    this.knu = ((com.tencent.mm.modelfriend.a) qVar).bbU();
                    if (i3 == -36 || i3 == -35 || i3 == -3) {
                        String bbI = ((com.tencent.mm.modelfriend.a) qVar).bbI();
                        if (!Util.isNullOrNil(bbI)) {
                            p.g(bbI, "pureMobile");
                            String str2 = bbI;
                            int length = str2.length() - 1;
                            boolean z2 = false;
                            int i4 = 0;
                            while (i4 <= length) {
                                if (str2.charAt(!z2 ? i4 : length) <= ' ') {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z2) {
                                    if (!z) {
                                        break;
                                    }
                                    length--;
                                } else if (!z) {
                                    z2 = true;
                                } else {
                                    i4++;
                                }
                            }
                            this.knP = str2.subSequence(i4, length + 1).toString();
                        }
                        if (i3 == -36) {
                            ebY();
                            AppMethodBeat.o(256313);
                            return;
                        }
                        com.tencent.mm.h.a Dk2 = com.tencent.mm.h.a.Dk(str);
                        if (Dk2 != null) {
                            Dk2.a(getContext(), null, null);
                            AppMethodBeat.o(256313);
                            return;
                        }
                        com.tencent.mm.ui.base.h.X(this, getString(R.string.af2, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), "");
                        AppMethodBeat.o(256313);
                        return;
                    } else if (i3 == -355) {
                        Log.i("MicroMsg.KidsWatchRegGetInfoUI", "showBlockBySpam");
                        y.g(this, str, 30846);
                        AppMethodBeat.o(256313);
                        return;
                    } else if (i3 == -34) {
                        com.tencent.mm.ui.base.h.X(this, getString(R.string.adu), "");
                        AppMethodBeat.o(256313);
                        return;
                    } else if (com.tencent.mm.plugin.account.a.a.jRu.a(this, i2, i3, str)) {
                        AppMethodBeat.o(256313);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(256313);
    }

    @Override // com.tencent.mm.ui.widget.b.a
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(256314);
        Log.i("MicroMsg.KidsWatchRegGetInfoUI", "keyboard show %s, keyboardHeight %d", Boolean.valueOf(z), Integer.valueOf(i2));
        if (z) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.dx6);
            p.g(linearLayout, "imgLL");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.a_z);
            p.g(linearLayout2, "bottomLL");
            ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(256314);
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
            ScrollView scrollView = (ScrollView) _$_findCachedViewById(R.id.hcl);
            p.g(scrollView, "scrollView");
            int height = scrollView.getHeight();
            ((InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk)).requestLayout();
            ((InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk)).post(new k(this, height));
            AppMethodBeat.o(256314);
            return;
        }
        ebZ();
        AppMethodBeat.o(256314);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class k implements Runnable {
        final /* synthetic */ KidsWatchRegGetInfoUI yBu;
        final /* synthetic */ int yBx;

        k(KidsWatchRegGetInfoUI kidsWatchRegGetInfoUI, int i2) {
            this.yBu = kidsWatchRegGetInfoUI;
            this.yBx = i2;
        }

        public final void run() {
            AppMethodBeat.i(256302);
            InputPanelLinearLayout inputPanelLinearLayout = (InputPanelLinearLayout) this.yBu._$_findCachedViewById(R.id.dyk);
            p.g(inputPanelLinearLayout, "inputContainer");
            Log.i("MicroMsg.KidsWatchRegGetInfoUI", "inputContainer.height: %d, screenHeight: %d", Integer.valueOf(inputPanelLinearLayout.getHeight()), Integer.valueOf(this.yBx));
            InputPanelLinearLayout inputPanelLinearLayout2 = (InputPanelLinearLayout) this.yBu._$_findCachedViewById(R.id.dyk);
            p.g(inputPanelLinearLayout2, "inputContainer");
            if (inputPanelLinearLayout2.getHeight() > this.yBx) {
                InputPanelLinearLayout inputPanelLinearLayout3 = (InputPanelLinearLayout) this.yBu._$_findCachedViewById(R.id.dyk);
                p.g(inputPanelLinearLayout3, "inputContainer");
                ((ScrollView) this.yBu._$_findCachedViewById(R.id.hcl)).scrollBy(0, inputPanelLinearLayout3.getHeight() - this.yBx);
            }
            AppMethodBeat.o(256302);
        }
    }

    private final void ebZ() {
        AppMethodBeat.i(256315);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.dx6);
        p.g(linearLayout, "imgLL");
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.a_z);
        p.g(linearLayout2, "bottomLL");
        ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(256315);
            throw tVar;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.bx);
        marginLayoutParams.topMargin = 0;
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
        ((InputPanelLinearLayout) _$_findCachedViewById(R.id.dyk)).setPadding(paddingLeft, paddingTop, inputPanelLinearLayout3.getPaddingRight(), 0);
        ((ScrollView) _$_findCachedViewById(R.id.hcl)).scrollBy(0, 0);
        AppMethodBeat.o(256315);
    }

    @Override // com.tencent.mm.plugin.kidswatch.model.b.AbstractC1453b
    public final void ds(String str, String str2) {
        AppMethodBeat.i(256316);
        p.h(str, "fileID");
        p.h(str2, "aesKey");
        Log.i("MicroMsg.KidsWatchRegGetInfoUI", "IImgUploadCallback, ok, fileId:" + str + ", aesKey:" + str2);
        ir(str, str2);
        AppMethodBeat.o(256316);
    }

    @Override // com.tencent.mm.plugin.kidswatch.model.b.AbstractC1453b
    public final void aCF(String str) {
        AppMethodBeat.i(256317);
        Log.e("MicroMsg.KidsWatchRegGetInfoUI", "upload head fail, errType:%s, errCode:%s, errMsg:%s", 3, -1, str);
        ir("", "");
        AppMethodBeat.o(256317);
    }

    public static final /* synthetic */ void a(KidsWatchRegGetInfoUI kidsWatchRegGetInfoUI, String str) {
        int i2;
        boolean z;
        boolean z2;
        AppMethodBeat.i(256320);
        com.tencent.mm.kernel.g.azz().a(145, kidsWatchRegGetInfoUI);
        MMClearEditText mMClearEditText = (MMClearEditText) kidsWatchRegGetInfoUI._$_findCachedViewById(R.id.fgj);
        p.g(mMClearEditText, "mobileFIV");
        String obj = mMClearEditText.getText().toString();
        int length = obj.length() - 1;
        boolean z3 = false;
        int i3 = 0;
        while (i3 <= length) {
            if (obj.charAt(!z3 ? i3 : length) <= ' ') {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z3) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (!z2) {
                z3 = true;
            } else {
                i3++;
            }
        }
        String pureNumber = PhoneFormater.pureNumber(obj.subSequence(i3, length + 1).toString());
        if (kidsWatchRegGetInfoUI.knm != null && kidsWatchRegGetInfoUI.knn != null && (!p.j(pureNumber, kidsWatchRegGetInfoUI.knm)) && p.j(pureNumber, kidsWatchRegGetInfoUI.knn)) {
            i2 = 1;
        } else if (kidsWatchRegGetInfoUI.knm == null || kidsWatchRegGetInfoUI.knn == null || !(!p.j(kidsWatchRegGetInfoUI.knn, kidsWatchRegGetInfoUI.knm)) || !(!p.j(pureNumber, kidsWatchRegGetInfoUI.knn))) {
            i2 = 0;
        } else {
            i2 = 2;
        }
        Log.i("MicroMsg.KidsWatchRegGetInfoUI", "checkMobileStateFun, adJust:" + i2 + ", opCode:22, " + kidsWatchRegGetInfoUI.kno);
        com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(str, 22, "", 0, "");
        aVar.sZ(kidsWatchRegGetInfoUI.kno);
        aVar.ta(i2);
        if (com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIO("ie_reg")) {
            com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIN("ie_reg");
        }
        dmd dmd = new dmd();
        MMClearEditText mMClearEditText2 = (MMClearEditText) kidsWatchRegGetInfoUI._$_findCachedViewById(R.id.fz5);
        p.g(mMClearEditText2, "nickFIV");
        dmd.oUJ = mMClearEditText2.getText().toString();
        if (kidsWatchRegGetInfoUI.kpI && kidsWatchRegGetInfoUI.kqc != null) {
            Bitmap bitmap = kidsWatchRegGetInfoUI.kqc;
            if (bitmap == null) {
                p.hyc();
            }
            if (!bitmap.isRecycled()) {
                dmd.Mvm = MD5Util.getMD5String(BitmapUtil.Bitmap2Bytes(kidsWatchRegGetInfoUI.kqc));
            }
        }
        dmd.MPI = str;
        dmd.rBH = Util.getTimeZoneOffset();
        TimeZone timeZone = TimeZone.getDefault();
        p.g(timeZone, "TimeZone.getDefault()");
        dmd.MPJ = timeZone.getID();
        Log.i("MicroMsg.KidsWatchRegGetInfoUI", "%s,%s", dmd.rBH, dmd.MPJ);
        ewf ewf = new ewf();
        ewf.NtO = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIP("ie_reg"));
        ewf.NtP = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIS("ce_reg"));
        ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.TJ(30));
        ewf.NtU = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.exM());
        try {
            ewf.NtR = new SKBuiltinBuffer_t().setBuffer(dmd.toByteArray());
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.KidsWatchRegGetInfoUI", e2, "convert to byte error ! %s", e2.getMessage());
        }
        aVar.a(ewf);
        String str2 = kidsWatchRegGetInfoUI.dZW;
        if (str2 == null) {
            p.btv("loginUrl");
        }
        aVar.Oj(str2);
        com.tencent.mm.kernel.g.azz().b(aVar);
        MMClearEditText mMClearEditText3 = (MMClearEditText) kidsWatchRegGetInfoUI._$_findCachedViewById(R.id.fgj);
        p.g(mMClearEditText3, "mobileFIV");
        String obj2 = mMClearEditText3.getText().toString();
        int length2 = obj2.length() - 1;
        int i4 = 0;
        boolean z4 = false;
        while (i4 <= length2) {
            if (obj2.charAt(!z4 ? i4 : length2) <= ' ') {
                z = true;
            } else {
                z = false;
            }
            if (z4) {
                if (!z) {
                    break;
                }
                length2--;
            } else if (!z) {
                z4 = true;
            } else {
                i4++;
            }
        }
        kidsWatchRegGetInfoUI.knm = PhoneFormater.pureNumber(obj2.subSequence(i4, length2 + 1).toString());
        kidsWatchRegGetInfoUI.kno++;
        AppMethodBeat.o(256320);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ KidsWatchRegGetInfoUI yBu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(KidsWatchRegGetInfoUI kidsWatchRegGetInfoUI) {
            super(0);
            this.yBu = kidsWatchRegGetInfoUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(256286);
            this.yBu.finish();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(256286);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(KidsWatchRegGetInfoUI kidsWatchRegGetInfoUI) {
        AppMethodBeat.i(256321);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(kidsWatchRegGetInfoUI, "android.permission.WRITE_EXTERNAL_STORAGE", 34, "", "");
        Log.i("MicroMsg.KidsWatchRegGetInfoUI", "changeAvatar, checkStorage:".concat(String.valueOf(a2)));
        if (a2) {
            com.tencent.mm.plugin.account.a.a.jRu.s(kidsWatchRegGetInfoUI);
        }
        AppMethodBeat.o(256321);
    }

    public static final /* synthetic */ void e(KidsWatchRegGetInfoUI kidsWatchRegGetInfoUI) {
        AppMethodBeat.i(256322);
        Log.i("MicroMsg.KidsWatchRegGetInfoUI", "click law link");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", kidsWatchRegGetInfoUI.getString(R.string.ee5, new Object[]{LocaleUtil.getApplicationLanguage()}));
        com.tencent.mm.br.c.b(kidsWatchRegGetInfoUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(256322);
    }
}
