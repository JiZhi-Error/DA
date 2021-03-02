package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;

@a(19)
public class WalletLqtSaveFetchFinishUI extends WalletBaseUI {
    private TextView HAB;
    private WalletTextView HAC;
    private TextView HAD;
    private TextView HAE;
    private caf HAF;
    private CdnImageView HAG;
    private TextView HAH;
    private TextView HAI;
    private LinearLayout HAJ;
    private ViewGroup HAK;
    private int gYH;
    private ViewGroup qyr;
    private Button zDY;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68965);
        fixStatusbar(true);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.afz));
        hideTitleView();
        enableBackMenu(false);
        this.qyr = (ViewGroup) findViewById(R.id.f6c);
        this.HAB = (TextView) findViewById(R.id.idv);
        this.HAC = (WalletTextView) findViewById(R.id.f3094me);
        this.zDY = (Button) findViewById(R.id.d50);
        this.HAD = (TextView) findViewById(R.id.gl1);
        this.HAE = (TextView) findViewById(R.id.j0q);
        this.HAG = (CdnImageView) findViewById(R.id.aaf);
        this.HAH = (TextView) findViewById(R.id.aag);
        this.HAI = (TextView) findViewById(R.id.aae);
        this.HAJ = (LinearLayout) findViewById(R.id.aaq);
        this.HAK = (ViewGroup) findViewById(R.id.d4z);
        this.gYH = getIntent().getIntExtra("entrance_type", 0);
        int intExtra = getIntent().getIntExtra("key_mode", 1);
        double doubleExtra = getIntent().getDoubleExtra("key_amount", 0.0d);
        String stringExtra = getIntent().getStringExtra("profile_date_wording");
        String stringExtra2 = getIntent().getStringExtra("profile_upgrade_wording");
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_guide_cell");
        if (byteArrayExtra != null) {
            try {
                this.HAF = (caf) new caf().parseFrom(byteArrayExtra);
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishUI", e2, "", new Object[0]);
            }
        }
        if (intExtra == 1) {
            this.HAB.setText(getString(R.string.iif));
            setMMTitle(getString(R.string.iif));
        } else if (intExtra == 2) {
            this.HAB.setText(getString(R.string.igx));
            setMMTitle(getString(R.string.igx));
        }
        this.HAC.setText(f.formatMoney2f(doubleExtra));
        this.zDY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(68961);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WalletLqtSaveFetchFinishUI.this.gYH == 8) {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    c.b(WalletLqtSaveFetchFinishUI.this.getContext(), "mall", ".ui.MallWalletUI", intent);
                } else {
                    WalletLqtSaveFetchFinishUI.this.finish();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68961);
            }
        });
        if (!Util.isNullOrNil(stringExtra)) {
            this.HAD.setText(stringExtra);
            this.HAD.setVisibility(0);
        }
        if (!Util.isNullOrNil(stringExtra2)) {
            this.HAE.setText(l.g(this, stringExtra2, (int) this.HAE.getTextSize()));
            this.HAE.setClickable(true);
            this.HAE.setOnTouchListener(new o());
            this.HAE.setVisibility(0);
        }
        if (this.HAF != null) {
            if (!Util.isNullOrNil(this.HAF.icon)) {
                this.HAG.setUrl(this.HAF.icon);
            }
            this.HAH.setText(this.HAF.title);
            this.HAI.setText(this.HAF.desc);
            this.HAJ.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(68962);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if ("wxpay://lqt/planindex".equals(WalletLqtSaveFetchFinishUI.this.HAF.url)) {
                        Intent intent = new Intent(WalletLqtSaveFetchFinishUI.this.getContext(), WalletLqtPlanBeforeHomeUI.class);
                        WalletLqtSaveFetchFinishUI walletLqtSaveFetchFinishUI = WalletLqtSaveFetchFinishUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(walletLqtSaveFetchFinishUI, bl.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        walletLqtSaveFetchFinishUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(walletLqtSaveFetchFinishUI, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    } else if ("wxpay://lqt/preaddplan".equals(WalletLqtSaveFetchFinishUI.this.HAF.url)) {
                        Intent intent2 = new Intent(WalletLqtSaveFetchFinishUI.this.getContext(), WalletLqtPlanAddUI.class);
                        intent2.putExtra("key_mode", 3);
                        WalletLqtSaveFetchFinishUI walletLqtSaveFetchFinishUI2 = WalletLqtSaveFetchFinishUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                        com.tencent.mm.hellhoundlib.a.a.a(walletLqtSaveFetchFinishUI2, bl2.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        walletLqtSaveFetchFinishUI2.startActivity((Intent) bl2.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(walletLqtSaveFetchFinishUI2, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    } else {
                        Log.w("MicroMsg.WalletLqtSaveFetchFinishUI", "unknown url: %s", WalletLqtSaveFetchFinishUI.this.HAF.url);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(68962);
                }
            });
            this.HAJ.setVisibility(0);
            getWindow().getDecorView().post(new Runnable() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishUI.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(68963);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) WalletLqtSaveFetchFinishUI.this.HAK.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    }
                    layoutParams.removeRule(12);
                    WalletLqtSaveFetchFinishUI.this.HAK.setLayoutParams(layoutParams);
                    AppMethodBeat.o(68963);
                }
            });
            AppMethodBeat.o(68965);
            return;
        }
        this.HAJ.setVisibility(8);
        getWindow().getDecorView().post(new Runnable() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(68964);
                if (WalletLqtSaveFetchFinishUI.this.HAK == null) {
                    AppMethodBeat.o(68964);
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) WalletLqtSaveFetchFinishUI.this.HAK.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                }
                layoutParams.addRule(12);
                WalletLqtSaveFetchFinishUI.this.HAK.setLayoutParams(layoutParams);
                AppMethodBeat.o(68964);
            }
        });
        AppMethodBeat.o(68965);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c9n;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void setContentViewVisibility(int i2) {
        AppMethodBeat.i(68966);
        getContentView().setVisibility(i2);
        AppMethodBeat.o(68966);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
    }
}
