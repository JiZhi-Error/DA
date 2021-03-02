package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMWizardActivity;

public class BakFinishUI extends MMWizardActivity implements e.AbstractC0839e {
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private TextView hbm;
    private int oSz;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BakFinishUI() {
        AppMethodBeat.i(21980);
        AppMethodBeat.o(21980);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.hz;
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21981);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false)) {
            AppMethodBeat.o(21981);
            return;
        }
        this.oSz = getIntent().getIntExtra("cmd", -1);
        Log.i("MicroMsg.BakFinishUI", "BakFinishUI onCreate nowCmd:%d", Integer.valueOf(this.oSz));
        initView();
        a.cgZ().cha().oRK = this;
        AppMethodBeat.o(21981);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(21982);
        setMMTitle(R.string.a_n);
        this.hbm = (TextView) findViewById(R.id.zb);
        if (6 == this.oSz) {
            this.hbm.setText(getString(R.string.a_j));
        } else if (1 == this.oSz) {
            this.hbm.setText(getString(R.string.a_a));
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakFinishUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21977);
                a.cgZ().cha().oRS = -1;
                BakFinishUI.a(BakFinishUI.this);
                AppMethodBeat.o(21977);
                return true;
            }
        });
        AppMethodBeat.o(21982);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(21983);
        super.onDestroy();
        a.cgZ().cha().oRK = null;
        Log.i("MicroMsg.BakFinishUI", "BakFinishUI onDestroy nowCmd:%d", Integer.valueOf(this.oSz));
        AppMethodBeat.o(21983);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(21984);
        if (i2 == 4) {
            a.cgZ().cha().oRS = -1;
            ala(1);
            AppMethodBeat.o(21984);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(21984);
        return onKeyDown;
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.AbstractC0839e
    public final void chp() {
        AppMethodBeat.i(21985);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakFinishUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(21978);
                a.cgZ().cha().oRS = -1;
                BakFinishUI.b(BakFinishUI.this);
                AppMethodBeat.o(21978);
            }
        });
        AppMethodBeat.o(21985);
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.b
    public final void onError(int i2) {
        AppMethodBeat.i(21986);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakFinishUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(21979);
                Log.d("MicroMsg.BakFinishUI", "BakFinishUI onCloseSocket");
                MMWizardActivity.ay(BakFinishUI.this, new Intent(BakFinishUI.this, BakConnErrorUI.class));
                AppMethodBeat.o(21979);
            }
        });
        AppMethodBeat.o(21986);
    }

    static /* synthetic */ void a(BakFinishUI bakFinishUI) {
        AppMethodBeat.i(21987);
        bakFinishUI.ala(1);
        AppMethodBeat.o(21987);
    }

    static /* synthetic */ void b(BakFinishUI bakFinishUI) {
        AppMethodBeat.i(21988);
        bakFinishUI.ala(1);
        AppMethodBeat.o(21988);
    }
}
