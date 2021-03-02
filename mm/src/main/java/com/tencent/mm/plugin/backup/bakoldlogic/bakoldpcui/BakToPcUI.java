package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMWizardActivity;

public class BakToPcUI extends MMWizardActivity implements e.a {
    private int EX = -1;
    private Button hPX;
    private Button hSq;
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private TextView oSM;
    private TextView oSN;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BakToPcUI() {
        AppMethodBeat.i(22028);
        AppMethodBeat.o(22028);
    }

    static /* synthetic */ void d(BakToPcUI bakToPcUI) {
        AppMethodBeat.i(22038);
        bakToPcUI.chu();
        AppMethodBeat.o(22038);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22029);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false)) {
            AppMethodBeat.o(22029);
            return;
        }
        initView();
        this.EX = a.cgZ().cha().oRP;
        Log.i("MicroMsg.BakToPcUI", "BakToPcUI auth onCreate nowCmd:%d", Integer.valueOf(this.EX));
        a.cgZ().cha().oRJ = this;
        chu();
        AppMethodBeat.o(22029);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(22030);
        setMMTitle(R.string.a_n);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22023);
                a.cgZ().cha().Bu(1);
                BakToPcUI.a(BakToPcUI.this);
                AppMethodBeat.o(22023);
                return true;
            }
        });
        this.hPX = (Button) findViewById(R.id.zc);
        this.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(22024);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (BakToPcUI.this.EX == 0) {
                    a.cgZ().chb().iDM = 1;
                    a.cgZ().cha().Bu(0);
                    MMWizardActivity.ay(BakToPcUI.this, new Intent(BakToPcUI.this, BakWaitingUI.class));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22024);
            }
        });
        this.hSq = (Button) findViewById(R.id.za);
        this.hSq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(22025);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (BakToPcUI.this.EX == 0) {
                    a.cgZ().chb().iDM = 2;
                    a.cgZ().chb().aWm();
                    a.cgZ().cha().Bu(1);
                    BakToPcUI.c(BakToPcUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22025);
            }
        });
        this.oSM = (TextView) findViewById(R.id.zh);
        this.oSM.setText(a.cgZ().cha().oRQ);
        this.oSN = (TextView) findViewById(R.id.zi);
        this.oSN.setText(a.cgZ().cha().oRR);
        AppMethodBeat.o(22030);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.hx;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(22031);
        super.onDestroy();
        Log.i("MicroMsg.BakToPcUI", "BakToPcUI auth onDestroy nowCmd:%d", Integer.valueOf(this.EX));
        a.cgZ().cha().oRJ = null;
        AppMethodBeat.o(22031);
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.a
    public final void chm() {
        AppMethodBeat.i(22032);
        this.EX = 0;
        this.hPX.setVisibility(0);
        this.hSq.setVisibility(0);
        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(22026);
                BakToPcUI.d(BakToPcUI.this);
                AppMethodBeat.o(22026);
            }
        });
        AppMethodBeat.o(22032);
    }

    private void chu() {
        AppMethodBeat.i(22033);
        if (this.EX == 0) {
            this.hPX.setEnabled(true);
            this.hSq.setEnabled(true);
            AppMethodBeat.o(22033);
            return;
        }
        this.hPX.setEnabled(false);
        this.hSq.setEnabled(false);
        AppMethodBeat.o(22033);
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.b
    public final void onError(final int i2) {
        AppMethodBeat.i(22034);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(22027);
                Log.d("MicroMsg.BakToPcUI", "BakToPcUI onCloseSocket errType: %d", Integer.valueOf(i2));
                if (i2 == -1) {
                    Log.d("MicroMsg.BakToPcUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", BakToPcUI.this.getString(R.string.a8c));
                    intent.putExtra("rawUrl", BakToPcUI.this.getString(R.string.a79, new Object[]{LocaleUtil.getApplicationLanguage()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    c.b(BakToPcUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(22027);
                    return;
                }
                BakToPcUI.e(BakToPcUI.this);
                AppMethodBeat.o(22027);
            }
        });
        AppMethodBeat.o(22034);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(22035);
        if (i2 == 4) {
            a.cgZ().chb().iDM = 3;
            a.cgZ().chb().aWm();
            a.cgZ().cha().Bu(1);
            ala(1);
            AppMethodBeat.o(22035);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(22035);
        return onKeyDown;
    }

    static /* synthetic */ void a(BakToPcUI bakToPcUI) {
        AppMethodBeat.i(22036);
        bakToPcUI.ala(1);
        AppMethodBeat.o(22036);
    }

    static /* synthetic */ void c(BakToPcUI bakToPcUI) {
        AppMethodBeat.i(22037);
        bakToPcUI.ala(1);
        AppMethodBeat.o(22037);
    }

    static /* synthetic */ void e(BakToPcUI bakToPcUI) {
        AppMethodBeat.i(22039);
        bakToPcUI.ala(1);
        AppMethodBeat.o(22039);
    }
}
