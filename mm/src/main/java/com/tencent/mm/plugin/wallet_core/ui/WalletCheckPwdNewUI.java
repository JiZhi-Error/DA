package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@com.tencent.mm.ui.base.a(3)
public class WalletCheckPwdNewUI extends WalletBaseUI {
    private EditHintPasswdView HKf;
    private a Igd;
    TextView Ige;
    private TextView Igf;
    private LinearLayout Igg;
    private ImageView Igh;
    private TextView Igi;
    private LinearLayout Igj;
    private LinearLayout Igk;
    private TextView Igl;
    private ScrollView Igm;
    private ImageView avD;

    public interface a {
        void aVF(String str);

        void onCreate();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70887);
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("scene", -1);
        Log.i("MicroMsg.WalletCheckPwdNewUI", "scene: %s", Integer.valueOf(intExtra));
        if (intExtra == 3) {
            this.Igd = new h(this);
        } else {
            this.Igd = new c(this);
        }
        setActionbarColor(getResources().getColor(R.color.afz));
        hideTitleView();
        hideActionbarLine();
        initView();
        this.Igd.onCreate();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(70884);
                WalletCheckPwdNewUI.a(WalletCheckPwdNewUI.this);
                AppMethodBeat.o(70884);
                return false;
            }
        });
        AppMethodBeat.o(70887);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void setContentViewVisibility(int i2) {
        AppMethodBeat.i(70888);
        getContentView().setVisibility(i2);
        AppMethodBeat.o(70888);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(70889);
        this.avD = (ImageView) findViewById(R.id.b47);
        this.Ige = (TextView) findViewById(R.id.jhz);
        this.Igf = (TextView) findViewById(R.id.jhu);
        this.Igg = (LinearLayout) findViewById(R.id.jhx);
        this.HKf = (EditHintPasswdView) findViewById(R.id.dyp);
        this.Igh = (ImageView) findViewById(R.id.d4k);
        this.Igi = (TextView) findViewById(R.id.d4o);
        this.Igj = (LinearLayout) findViewById(R.id.d4l);
        this.Igk = (LinearLayout) findViewById(R.id.jjn);
        this.Igl = (TextView) findViewById(R.id.jjm);
        this.Igm = (ScrollView) findViewById(R.id.jjo);
        this.avD.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(70885);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletCheckPwdNewUI.a(WalletCheckPwdNewUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70885);
            }
        });
        com.tencent.mm.wallet_core.ui.formview.a.a(this.HKf);
        this.HKf.setOnInputValidListener(new EditHintPasswdView.a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI.AnonymousClass3 */

            @Override // com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a
            public final void onInputValidChange(boolean z) {
                AppMethodBeat.i(70886);
                Log.i("MicroMsg.WalletCheckPwdNewUI", "input isValid: %s", Boolean.valueOf(z));
                if (z) {
                    WalletCheckPwdNewUI.this.Igd.aVF(WalletCheckPwdNewUI.this.HKf.getText());
                }
                AppMethodBeat.o(70886);
            }
        });
        setEditFocusListener(this.HKf, 0, false);
        showTenpayKB();
        AppMethodBeat.o(70889);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(70890);
        super.onResume();
        AppMethodBeat.o(70890);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(70891);
        super.onPause();
        AppMethodBeat.o(70891);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(70892);
        super.onDestroy();
        AppMethodBeat.o(70892);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(70893);
        Log.i("MicroMsg.WalletCheckPwdNewUI", "controller ret: %s", Boolean.FALSE);
        AppMethodBeat.o(70893);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c8l;
    }

    static /* synthetic */ void a(WalletCheckPwdNewUI walletCheckPwdNewUI) {
        AppMethodBeat.i(70894);
        Log.i("MicroMsg.WalletCheckPwdNewUI", "close btn");
        walletCheckPwdNewUI.finish();
        AppMethodBeat.o(70894);
    }
}
