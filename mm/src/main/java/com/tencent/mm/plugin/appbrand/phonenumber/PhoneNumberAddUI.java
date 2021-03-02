package com.tencent.mm.plugin.appbrand.phonenumber;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.BaseLuggageActivity;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI;", "Lcom/tencent/mm/ui/base/BaseLuggageActivity;", "()V", "mPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "luggage-wechat-full-sdk_release"})
public final class PhoneNumberAddUI extends BaseLuggageActivity {
    public static final a nzW = new a((byte) 0);
    private l nzV;

    static {
        AppMethodBeat.i(148111);
        AppMethodBeat.o(148111);
    }

    @Override // com.tencent.mm.ui.BaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.base.BaseLuggageActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.BaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(148109);
        if (j.cDv.isDarkMode()) {
            setTheme(R.style.a1a);
        } else {
            setTheme(R.style.a1b);
        }
        super.onCreate(bundle);
        setNavigationbarColor(getResources().getColor(R.color.f3044b));
        setActionBarColor(getResources().getColor(R.color.f3045c));
        hideActionbarLine();
        String stringExtra = getIntent().getStringExtra("APPID");
        Log.i("MicroMsg.PhoneNumberAddUI", "onCreate() appId:".concat(String.valueOf(stringExtra)));
        setTitle(R.string.a2h);
        setBackBtn(new b(this));
        u uVar = u.nAe;
        p.g(stringExtra, "appId");
        this.nzV = u.bTz().a(this, stringExtra, new c(this));
        l lVar = this.nzV;
        if (lVar != null) {
            lVar.init();
        }
        l lVar2 = this.nzV;
        setContentView(lVar2 != null ? lVar2.getView() : null);
        AppMethodBeat.o(148109);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ PhoneNumberAddUI nzX;

        b(PhoneNumberAddUI phoneNumberAddUI) {
            this.nzX = phoneNumberAddUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(148107);
            this.nzX.finish();
            AppMethodBeat.o(148107);
            return true;
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(148110);
        super.onDestroy();
        l lVar = this.nzV;
        if (lVar != null) {
            lVar.uninit();
            AppMethodBeat.o(148110);
            return;
        }
        AppMethodBeat.o(148110);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI$Companion;", "", "()V", "APPID", "", "TAG", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ PhoneNumberAddUI nzX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(PhoneNumberAddUI phoneNumberAddUI) {
            super(0);
            this.nzX = phoneNumberAddUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(148108);
            this.nzX.finish();
            x xVar = x.SXb;
            AppMethodBeat.o(148108);
            return xVar;
        }
    }
}
