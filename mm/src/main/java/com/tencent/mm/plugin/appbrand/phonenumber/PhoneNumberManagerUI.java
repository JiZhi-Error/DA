package com.tencent.mm.plugin.appbrand.phonenumber;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.mm.ui.base.BaseLuggageActivity;
import junit.framework.Assert;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0014J\b\u0010\u0011\u001a\u00020\bH\u0014J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerUI;", "Lcom/tencent/mm/ui/base/BaseLuggageActivity;", "()V", "mPhoneNumberManagerLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "showDelete", "", "enableEditPhoneNumber", "", "enable", "getLayoutId", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "updateView", "Companion", "luggage-wechat-full-sdk_release"})
public final class PhoneNumberManagerUI extends BaseLuggageActivity {
    public static final a nAu = new a((byte) 0);
    private o nAt;
    private boolean nze;

    static {
        AppMethodBeat.i(148158);
        AppMethodBeat.o(148158);
    }

    @Override // com.tencent.mm.ui.BaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.base.BaseLuggageActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static final /* synthetic */ void a(PhoneNumberManagerUI phoneNumberManagerUI, boolean z) {
        AppMethodBeat.i(148159);
        phoneNumberManagerUI.iu(z);
        AppMethodBeat.o(148159);
    }

    public static final /* synthetic */ void b(PhoneNumberManagerUI phoneNumberManagerUI) {
        AppMethodBeat.i(148160);
        phoneNumberManagerUI.updateView();
        AppMethodBeat.o(148160);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.BaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(148152);
        setTheme(R.style.a1_);
        super.onCreate(bundle);
        setActionBarColor(getResources().getColor(R.color.f3045c));
        setNavigationbarColor(getResources().getColor(R.color.f3044b));
        hideActionbarLine();
        setTitle(R.string.a2x);
        String stringExtra = getIntent().getStringExtra("APPID");
        Util.isNullOrNil(stringExtra);
        Assert.assertFalse(false);
        Log.i("MicroMsg.PhoneNumberManagerUI", "onCreate() appId:".concat(String.valueOf(stringExtra)));
        String stringExtra2 = getIntent().getStringExtra("PAGEPATH");
        u uVar = u.nAe;
        p.g(stringExtra, "appId");
        p.g(stringExtra2, "pagePath");
        this.nAt = u.bTz().s(this, stringExtra, stringExtra2);
        o oVar = this.nAt;
        if (oVar != null) {
            oVar.init();
        }
        o oVar2 = this.nAt;
        setContentView(oVar2 != null ? oVar2.getView() : null);
        AppMethodBeat.o(148152);
    }

    @Override // com.tencent.mm.ui.BaseActivity, com.tencent.mm.ui.base.BaseLuggageActivity
    public final int getLayoutId() {
        return R.layout.dp;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(148153);
        super.onResume();
        updateView();
        AppMethodBeat.o(148153);
    }

    private final void updateView() {
        AppMethodBeat.i(148154);
        removeAllOptionMenu();
        o oVar = this.nAt;
        if (oVar != null) {
            oVar.is(this.nze);
        }
        if (this.nze) {
            a(getString(R.string.a2p), BaseActivity.c.TEXT, new b(this));
            a(new c(this));
            AppMethodBeat.o(148154);
            return;
        }
        a(getString(R.string.a2w), BaseActivity.c.TEXT, new d(this));
        setBackBtn(new e(this));
        AppMethodBeat.o(148154);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ PhoneNumberManagerUI nAv;

        b(PhoneNumberManagerUI phoneNumberManagerUI) {
            this.nAv = phoneNumberManagerUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(148148);
            o oVar = this.nAv.nAt;
            if (oVar != null) {
                oVar.bTx();
            }
            PhoneNumberManagerUI.a(this.nAv, false);
            PhoneNumberManagerUI.b(this.nAv);
            AppMethodBeat.o(148148);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ PhoneNumberManagerUI nAv;

        c(PhoneNumberManagerUI phoneNumberManagerUI) {
            this.nAv = phoneNumberManagerUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(148149);
            PhoneNumberManagerUI.a(this.nAv, false);
            PhoneNumberManagerUI.b(this.nAv);
            AppMethodBeat.o(148149);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class d implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ PhoneNumberManagerUI nAv;

        d(PhoneNumberManagerUI phoneNumberManagerUI) {
            this.nAv = phoneNumberManagerUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(148150);
            PhoneNumberManagerUI.a(this.nAv, true);
            PhoneNumberManagerUI.b(this.nAv);
            AppMethodBeat.o(148150);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class e implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ PhoneNumberManagerUI nAv;

        e(PhoneNumberManagerUI phoneNumberManagerUI) {
            this.nAv = phoneNumberManagerUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(148151);
            this.nAv.finish();
            AppMethodBeat.o(148151);
            return true;
        }
    }

    @Override // android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(148155);
        if (this.nze) {
            iu(false);
            updateView();
            AppMethodBeat.o(148155);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.o(148155);
    }

    private final void iu(boolean z) {
        AppMethodBeat.i(148156);
        this.nze = z;
        o oVar = this.nAt;
        if (oVar != null) {
            oVar.it(z);
            AppMethodBeat.o(148156);
            return;
        }
        AppMethodBeat.o(148156);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(148157);
        super.onDestroy();
        o oVar = this.nAt;
        if (oVar != null) {
            oVar.uninit();
            AppMethodBeat.o(148157);
            return;
        }
        AppMethodBeat.o(148157);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerUI$Companion;", "", "()V", "APPID", "", "PAGE_PATH", "TAG", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
