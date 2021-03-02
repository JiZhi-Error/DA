package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/account/ui/AccountExpiredSettingUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-account_release"})
public final class AccountExpiredSettingUI extends MMActivity {
    final String TAG = "MicroMsg.AccountExpiredSettingUI";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(196834);
        super.onCreate(bundle);
        setMMTitle(R.string.cl);
        setBackBtn(new a(this));
        findViewById(R.id.g3k).setOnClickListener(new b(this));
        AppMethodBeat.o(196834);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ AccountExpiredSettingUI kjL;

        a(AccountExpiredSettingUI accountExpiredSettingUI) {
            this.kjL = accountExpiredSettingUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(196831);
            this.kjL.finish();
            AppMethodBeat.o(196831);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ AccountExpiredSettingUI kjL;

        b(AccountExpiredSettingUI accountExpiredSettingUI) {
            this.kjL = accountExpiredSettingUI;
        }

        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.i(196833);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/AccountExpiredSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            final z.f fVar = new z.f();
            View findViewById = this.kjL.findViewById(R.id.br);
            p.g(findViewById, "findViewById<MMEditText>…_expired_setting_errcode)");
            fVar.SYG = (T) ((MMEditText) findViewById).getText().toString();
            final z.f fVar2 = new z.f();
            View findViewById2 = this.kjL.findViewById(R.id.bs);
            p.g(findViewById2, "findViewById<MMEditText>…t_expired_setting_errmsg)");
            fVar2.SYG = (T) ((MMEditText) findViewById2).getText().toString();
            d.a(10000, new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.account.ui.AccountExpiredSettingUI.b.AnonymousClass1 */
                final /* synthetic */ b kjM;

                {
                    this.kjM = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(196832);
                    ae aeVar = ae.SYK;
                    String format = String.format("<e>\n<ShowType>1</ShowType>\n<Content><![CDATA[%s]]></Content>\n<Url><![CDATA[]]></Url>\n<DispSec>30</DispSec>\n<Title><![CDATA[]]></Title>\n<Action>1</Action>\n<DelayConnSec>0</DelayConnSec>\n<Countdown>0</Countdown>\n<Ok><![CDATA[]]></Ok>\n<Cancel><![CDATA[]]></Cancel>\n</e>", Arrays.copyOf(new Object[]{fVar2.SYG}, 1));
                    p.g(format, "java.lang.String.format(format, *args)");
                    com.tencent.mm.kernel.a.FL(format);
                    c cVar = new c();
                    cVar.dBO.errType = 4;
                    try {
                        cVar.dBO.errCode = Integer.parseInt(fVar.SYG);
                    } catch (Exception e2) {
                        Log.e(this.kjM.kjL.TAG, "parse errcode error");
                    }
                    cVar.dBO.errMsg = format;
                    EventCenter.instance.publish(cVar);
                    x xVar = x.SXb;
                    AppMethodBeat.o(196832);
                    return xVar;
                }
            });
            T t = fVar2.SYG;
            if (t == null || t.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                T t2 = fVar.SYG;
                if (!(t2 == null || t2.length() == 0)) {
                    Toast.makeText(this.kjL, (int) R.string.wo, 0).show();
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/AccountExpiredSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(196833);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.b9;
    }
}
