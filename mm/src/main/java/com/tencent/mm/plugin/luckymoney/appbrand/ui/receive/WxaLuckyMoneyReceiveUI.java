package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.x;

@a(3)
public class WxaLuckyMoneyReceiveUI extends WxaLuckyMoneyBaseUI implements b {
    static final /* synthetic */ boolean $assertionsDisabled = (!WxaLuckyMoneyReceiveUI.class.desiredAssertionStatus());
    private TextView nAB;
    private int rxv = -1;
    private q tipDialog = null;
    private ImageView yQt;
    private int yRi = -1;
    private a yRj;
    private TextView yRk;
    private Button yRl;
    private View yRm;
    private ImageView yRn;
    private TextView yRo;
    private View yRp;
    private TextView yln;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(65011);
        AppMethodBeat.o(65011);
    }

    static /* synthetic */ void d(WxaLuckyMoneyReceiveUI wxaLuckyMoneyReceiveUI) {
        AppMethodBeat.i(65008);
        wxaLuckyMoneyReceiveUI.gR(4, -1);
        AppMethodBeat.o(65008);
    }

    static /* synthetic */ View e(WxaLuckyMoneyReceiveUI wxaLuckyMoneyReceiveUI) {
        AppMethodBeat.i(65009);
        View contentView = wxaLuckyMoneyReceiveUI.getContentView();
        AppMethodBeat.o(65009);
        return contentView;
    }

    static /* synthetic */ View f(WxaLuckyMoneyReceiveUI wxaLuckyMoneyReceiveUI) {
        AppMethodBeat.i(65010);
        View contentView = wxaLuckyMoneyReceiveUI.getContentView();
        AppMethodBeat.o(65010);
        return contentView;
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.b
    public final MMActivity eeF() {
        return this;
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.b
    public final void eeG() {
        AppMethodBeat.i(64991);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(64991);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.b
    public final void error(String str) {
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.b
    public final void a(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        AppMethodBeat.i(64992);
        eeG();
        iz(str, str2);
        iA(str3, str4);
        this.yRl.setOnClickListener(new x() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.x
            public final void czW() {
                AppMethodBeat.i(64986);
                WxaLuckyMoneyReceiveUI.a(WxaLuckyMoneyReceiveUI.this);
                if (WxaLuckyMoneyReceiveUI.this.yRj != null) {
                    WxaLuckyMoneyReceiveUI.this.yRj.eeJ();
                }
                AppMethodBeat.o(64986);
            }
        });
        this.yRl.setVisibility(0);
        X(z, z2);
        eeM();
        AppMethodBeat.o(64992);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.b
    public final void a(String str, String str2, int i2, String str3, boolean z, boolean z2) {
        AppMethodBeat.i(64993);
        this.rxv = i2;
        this.yRi = 1;
        eeG();
        iz(str, str2);
        iA(null, str3);
        this.yRl.setOnClickListener(null);
        this.yRl.setVisibility(8);
        X(z, z2);
        eeM();
        AppMethodBeat.o(64993);
    }

    private void eeM() {
        AppMethodBeat.i(64994);
        af.a(this.yRp, null);
        getContentView().setVisibility(0);
        AppMethodBeat.o(64994);
    }

    private void iz(String str, String str2) {
        AppMethodBeat.i(64995);
        af.a(this.yQt, str2, (String) null);
        af.a(getContext(), this.yRk, str);
        AppMethodBeat.o(64995);
    }

    private void iA(String str, String str2) {
        AppMethodBeat.i(64996);
        if (!Util.isNullOrNil(str)) {
            this.nAB.setText(str);
            this.nAB.setVisibility(0);
        } else {
            this.nAB.setVisibility(8);
        }
        if (!Util.isNullOrNil(str2)) {
            af.a(getContext(), this.yln, str2);
            this.yln.setVisibility(0);
        }
        AppMethodBeat.o(64996);
    }

    private void X(boolean z, boolean z2) {
        AppMethodBeat.i(64997);
        if (z) {
            this.yRm.setVisibility(0);
            if (z2) {
                this.yRo.setText(R.string.eoi);
            } else {
                this.yRo.setText(R.string.eoa);
            }
            this.yRn.setVisibility(8);
            this.yRm.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(64987);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    WxaLuckyMoneyReceiveUI.c(WxaLuckyMoneyReceiveUI.this);
                    m.vli.a(s.bh.SEE_DETAIL, s.bg.UNKNOWN, true);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(64987);
                }
            });
            AppMethodBeat.o(64997);
            return;
        }
        this.yRm.setVisibility(8);
        this.yRn.setVisibility(0);
        AppMethodBeat.o(64997);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64998);
        super.onCreate(bundle);
        Log.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onCreate ");
        initView();
        getIntent();
        this.yRj = new c();
        this.yRj.d(this, getIntent());
        AppMethodBeat.o(64998);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(64999);
        super.onResume();
        af.d(this.yRl);
        this.yRl.setBackgroundResource(R.drawable.c97);
        eeN();
        AppMethodBeat.o(64999);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(65000);
        super.onDestroy();
        Log.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onDestroy ");
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (this.yRj != null) {
            this.yRj.onDestroy();
            this.yRj = null;
        }
        AppMethodBeat.o(65000);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(65001);
        gR(this.yRi, this.rxv);
        finish();
        AppMethodBeat.o(65001);
    }

    private void gR(int i2, int i3) {
        AppMethodBeat.i(65002);
        Log.i("MicroMsg.WxaLuckyMoneyReceiveUI", "setBackResult cgiType:[%d],errCode:[%d]", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 1) {
            setResult(0, new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:no permission to receive the red packet"));
            AppMethodBeat.o(65002);
            return;
        }
        if (i2 == 4) {
            setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
        }
        AppMethodBeat.o(65002);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(65003);
        this.yRp = findViewById(R.id.f41);
        this.yQt = (ImageView) findViewById(R.id.f45);
        this.yRk = (TextView) findViewById(R.id.f46);
        this.nAB = (TextView) findViewById(R.id.f48);
        this.yln = (TextView) findViewById(R.id.f4b);
        this.yRl = (Button) findViewById(R.id.f4f);
        this.yRo = (TextView) findViewById(R.id.f4c);
        this.yRm = findViewById(R.id.f4d);
        this.yRn = (ImageView) findViewById(R.id.ey1);
        ImageView imageView = (ImageView) findViewById(R.id.f4e);
        if ($assertionsDisabled || imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(64988);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    WxaLuckyMoneyReceiveUI.d(WxaLuckyMoneyReceiveUI.this);
                    WxaLuckyMoneyReceiveUI.this.finish();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/receive/WxaLuckyMoneyReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(64988);
                }
            });
            m(this.yRk, R.dimen.ab1);
            m(this.nAB, R.dimen.ab2);
            m(this.yln, R.dimen.ab3);
            getContentView().setVisibility(8);
            this.tipDialog = h.a((Context) getContext(), getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(64989);
                    WxaLuckyMoneyReceiveUI.this.eeG();
                    if (WxaLuckyMoneyReceiveUI.e(WxaLuckyMoneyReceiveUI.this).getVisibility() == 8 || WxaLuckyMoneyReceiveUI.f(WxaLuckyMoneyReceiveUI.this).getVisibility() == 4) {
                        Log.i("MicroMsg.WxaLuckyMoneyReceiveUI", "user cancel & finish");
                        WxaLuckyMoneyReceiveUI.d(WxaLuckyMoneyReceiveUI.this);
                        WxaLuckyMoneyReceiveUI.this.finish();
                    }
                    AppMethodBeat.o(64989);
                }
            });
            this.tipDialog.show();
            eeN();
            AppMethodBeat.o(65003);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(65003);
        throw assertionError;
    }

    private void m(TextView textView, int i2) {
        AppMethodBeat.i(65004);
        int aH = (int) (((float) com.tencent.mm.cb.a.aH(getContext(), i2)) * com.tencent.mm.cb.a.iY(getContext()));
        int aG = com.tencent.mm.cb.a.aG(getContext(), i2);
        if (aG <= aH) {
            aH = aG;
        }
        textView.setTextSize(0, (float) aH);
        AppMethodBeat.o(65004);
    }

    private void eeN() {
        AppMethodBeat.i(65005);
        if (this.yRl == null) {
            AppMethodBeat.o(65005);
            return;
        }
        String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
        if (loadApplicationLanguage == null || loadApplicationLanguage.length() <= 0 || (!loadApplicationLanguage.equals(LocaleUtil.CHINA) && !loadApplicationLanguage.equals(LocaleUtil.TAIWAN) && !loadApplicationLanguage.equals(LocaleUtil.HONGKONG))) {
            this.yRl.setBackgroundResource(R.drawable.afv);
            this.yRl.setText(R.string.er0);
            AppMethodBeat.o(65005);
            return;
        }
        AppMethodBeat.o(65005);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ccx;
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.b
    public final void eeL() {
        AppMethodBeat.i(64990);
        af.d(this.yRl);
        AppMethodBeat.o(64990);
    }

    static /* synthetic */ void a(WxaLuckyMoneyReceiveUI wxaLuckyMoneyReceiveUI) {
        AppMethodBeat.i(65006);
        af.b(wxaLuckyMoneyReceiveUI.yRl);
        AppMethodBeat.o(65006);
    }

    static /* synthetic */ void c(WxaLuckyMoneyReceiveUI wxaLuckyMoneyReceiveUI) {
        AppMethodBeat.i(65007);
        if (wxaLuckyMoneyReceiveUI.yRj != null) {
            wxaLuckyMoneyReceiveUI.yRj.eeK();
        }
        AppMethodBeat.o(65007);
    }
}
