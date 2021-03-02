package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMWizardActivity;

public class BakWaitingUI extends MMWizardActivity implements e.c {
    private int EX;
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private boolean oSP;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BakWaitingUI() {
        AppMethodBeat.i(22044);
        AppMethodBeat.o(22044);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22045);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false)) {
            AppMethodBeat.o(22045);
            return;
        }
        a.cgZ().cha().oRI = this;
        this.EX = a.cgZ().cha().oRP;
        this.oSP = getIntent().getBooleanExtra("from_back_finish", false);
        Log.i("MicroMsg.BakWaitingUI", "BakWaitingUI onCreate nowCmd:%d isFromFinish:%b", Integer.valueOf(this.EX), Boolean.valueOf(this.oSP));
        initView();
        chv();
        AppMethodBeat.o(22045);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(22046);
        setMMTitle(R.string.a_n);
        if (this.oSP) {
            findViewById(R.id.zf).setVisibility(8);
        } else {
            findViewById(R.id.zf).setVisibility(0);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakWaitingUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22040);
                BakWaitingUI.a(BakWaitingUI.this);
                AppMethodBeat.o(22040);
                return true;
            }
        });
        AppMethodBeat.o(22046);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.i1;
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.c
    public final void onEvent(int i2) {
        AppMethodBeat.i(22047);
        this.EX = i2;
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakWaitingUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(22041);
                BakWaitingUI.this.chv();
                AppMethodBeat.o(22041);
            }
        });
        AppMethodBeat.o(22047);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(22048);
        super.onDestroy();
        a.cgZ().cha().oRI = null;
        Log.i("MicroMsg.BakWaitingUI", "BakWaitingUI onDestroy nowCmd:%d isFromFinish:%b", Integer.valueOf(this.EX), Boolean.valueOf(this.oSP));
        AppMethodBeat.o(22048);
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.c
    public final void Bx(final int i2) {
        AppMethodBeat.i(22049);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakWaitingUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(22042);
                Log.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", Integer.valueOf(i2));
                if (i2 == -1) {
                    Log.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", BakWaitingUI.this.getString(R.string.a8c));
                    intent.putExtra("rawUrl", BakWaitingUI.this.getString(R.string.a79, new Object[]{LocaleUtil.getApplicationLanguage()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    c.b(BakWaitingUI.this, "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(22042);
            }
        });
        AppMethodBeat.o(22049);
    }

    /* access modifiers changed from: package-private */
    public final void chv() {
        AppMethodBeat.i(22050);
        if (6 == this.EX || 1 == this.EX) {
            Intent intent = new Intent(this, BakOperatingUI.class);
            intent.putExtra("cmd", this.EX);
            MMWizardActivity.ay(this, intent);
        }
        AppMethodBeat.o(22050);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(22051);
        if (i2 == 4) {
            ala(1);
            AppMethodBeat.o(22051);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(22051);
        return onKeyDown;
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.b
    public final void onError(final int i2) {
        AppMethodBeat.i(22052);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakWaitingUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(22043);
                Log.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", Integer.valueOf(i2));
                if (i2 == -1) {
                    Log.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", BakWaitingUI.this.getString(R.string.a8c));
                    intent.putExtra("rawUrl", BakWaitingUI.this.getString(R.string.a79, new Object[]{LocaleUtil.getApplicationLanguage()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    c.b(BakWaitingUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(22043);
                    return;
                }
                MMWizardActivity.ay(BakWaitingUI.this, new Intent(BakWaitingUI.this, BakConnErrorUI.class));
                AppMethodBeat.o(22043);
            }
        });
        AppMethodBeat.o(22052);
    }

    static /* synthetic */ void a(BakWaitingUI bakWaitingUI) {
        AppMethodBeat.i(22053);
        bakWaitingUI.ala(1);
        AppMethodBeat.o(22053);
    }
}
