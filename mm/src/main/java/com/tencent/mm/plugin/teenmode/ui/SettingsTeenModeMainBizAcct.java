package com.tencent.mm.plugin.teenmode.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.protocal.protobuf.egy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.smtt.sdk.TbsListener;

public class SettingsTeenModeMainBizAcct extends MMActivity {
    private WeImageView FWJ;
    private WeImageView FWK;
    private WeImageView FWL;
    private LinearLayout FWM;
    private int FWN = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SettingsTeenModeMainBizAcct settingsTeenModeMainBizAcct) {
        AppMethodBeat.i(187425);
        settingsTeenModeMainBizAcct.updateStatus();
        AppMethodBeat.o(187425);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.brd;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(187420);
        super.onCreate(bundle);
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        this.FWJ = (WeImageView) findViewById(R.id.iiv);
        this.FWK = (WeImageView) findViewById(R.id.iix);
        this.FWL = (WeImageView) findViewById(R.id.iiw);
        this.FWM = (LinearLayout) findViewById(R.id.c43);
        this.FWN = ((b) g.af(b.class)).fvo();
        updateStatus();
        ((View) this.FWJ.getParent()).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainBizAcct.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(187415);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainBizAcct$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SettingsTeenModeMainBizAcct.this.FWN = 1;
                SettingsTeenModeMainBizAcct.a(SettingsTeenModeMainBizAcct.this);
                a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainBizAcct$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187415);
            }
        });
        ((View) this.FWK.getParent()).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainBizAcct.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(187416);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainBizAcct$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SettingsTeenModeMainBizAcct.this.FWN = 0;
                SettingsTeenModeMainBizAcct.a(SettingsTeenModeMainBizAcct.this);
                a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainBizAcct$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187416);
            }
        });
        ((View) this.FWL.getParent()).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainBizAcct.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(187417);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainBizAcct$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SettingsTeenModeMainBizAcct.this.FWN = 2;
                SettingsTeenModeMainBizAcct.a(SettingsTeenModeMainBizAcct.this);
                a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainBizAcct$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187417);
            }
        });
        this.FWM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainBizAcct.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(187418);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainBizAcct$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("intent_service_type", 251658241);
                c.b(view.getContext(), "brandservice", ".ui.BrandServiceIndexUI", intent);
                a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainBizAcct$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187418);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainBizAcct.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(187419);
                SettingsTeenModeMainBizAcct.this.onBackPressed();
                AppMethodBeat.o(187419);
                return true;
            }
        });
        AppMethodBeat.o(187420);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(187421);
        super.onPause();
        AppMethodBeat.o(187421);
    }

    private void updateStatus() {
        AppMethodBeat.i(187423);
        this.FWJ.setVisibility(8);
        this.FWK.setVisibility(8);
        this.FWL.setVisibility(8);
        this.FWM.setVisibility(4);
        switch (this.FWN) {
            case 0:
                this.FWK.setVisibility(0);
                this.FWM.setVisibility(0);
                break;
            case 1:
                this.FWJ.setVisibility(0);
                break;
            case 2:
                this.FWL.setVisibility(0);
                break;
        }
        fvu();
        AppMethodBeat.o(187423);
    }

    private void fvu() {
        AppMethodBeat.i(187424);
        Log.d("MicroMsg.SettingsTeenModeMainBizAcct", "doSaveConfig: %s", Integer.valueOf(this.FWN));
        g.aAh().azQ().set(ar.a.USERINFO_SETTING_TEEN_MODE_BIZ_ACCT_RANGE_INT_SYNC, Integer.valueOf(this.FWN));
        AppMethodBeat.o(187424);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(187422);
        Log.d("MicroMsg.SettingsTeenModeMainBizAcct", "doOplog: %s", Integer.valueOf(this.FWN));
        egy egy = new egy();
        egy.NgJ = this.FWN;
        ((l) g.af(l.class)).eis().b(new k.a(TbsListener.ErrorCode.EXCEED_INCR_UPDATE, egy));
        ((b) g.af(b.class)).fvq();
        super.onDestroy();
        AppMethodBeat.o(187422);
    }
}
