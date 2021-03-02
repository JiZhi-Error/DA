package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMWizardActivity;

public class BakConnErrorUI extends MMWizardActivity {
    private int oSz;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.hy;
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21972);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false)) {
            AppMethodBeat.o(21972);
            return;
        }
        this.oSz = getIntent().getIntExtra("cmd", -1);
        Log.i("MicroMsg.BakFinishUI", "BakConnErrorUI onCreate nowCmd:%d", Integer.valueOf(this.oSz));
        initView();
        a.cgZ().cha().oRS = -1;
        AppMethodBeat.o(21972);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(21973);
        setMMTitle(R.string.a_n);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21971);
                BakConnErrorUI.a(BakConnErrorUI.this);
                AppMethodBeat.o(21971);
                return true;
            }
        });
        AppMethodBeat.o(21973);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(21974);
        super.onDestroy();
        a.cgZ().cha().oRK = null;
        Log.i("MicroMsg.BakFinishUI", "BakConnErrorUI onDestroy nowCmd:%d", Integer.valueOf(this.oSz));
        AppMethodBeat.o(21974);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(21975);
        if (i2 == 4) {
            ala(1);
            AppMethodBeat.o(21975);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(21975);
        return onKeyDown;
    }

    static /* synthetic */ void a(BakConnErrorUI bakConnErrorUI) {
        AppMethodBeat.i(21976);
        bakConnErrorUI.ala(1);
        AppMethodBeat.o(21976);
    }
}
