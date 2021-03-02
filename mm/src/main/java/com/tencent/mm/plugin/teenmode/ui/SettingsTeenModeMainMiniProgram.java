package com.tencent.mm.plugin.teenmode.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.smtt.sdk.TbsListener;

public class SettingsTeenModeMainMiniProgram extends MMActivity {
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

    static /* synthetic */ void a(SettingsTeenModeMainMiniProgram settingsTeenModeMainMiniProgram) {
        AppMethodBeat.i(187448);
        settingsTeenModeMainMiniProgram.updateStatus();
        AppMethodBeat.o(187448);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.brf;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(187443);
        super.onCreate(bundle);
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        this.FWJ = (WeImageView) findViewById(R.id.iiv);
        this.FWK = (WeImageView) findViewById(R.id.iix);
        this.FWL = (WeImageView) findViewById(R.id.iiw);
        this.FWM = (LinearLayout) findViewById(R.id.c43);
        this.FWN = ((b) g.af(b.class)).fvp();
        updateStatus();
        ((View) this.FWJ.getParent()).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainMiniProgram.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(187438);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SettingsTeenModeMainMiniProgram.this.FWN = 1;
                SettingsTeenModeMainMiniProgram.a(SettingsTeenModeMainMiniProgram.this);
                a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187438);
            }
        });
        ((View) this.FWK.getParent()).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainMiniProgram.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(187439);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SettingsTeenModeMainMiniProgram.this.FWN = 0;
                SettingsTeenModeMainMiniProgram.a(SettingsTeenModeMainMiniProgram.this);
                a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187439);
            }
        });
        ((View) this.FWL.getParent()).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainMiniProgram.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(187440);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SettingsTeenModeMainMiniProgram.this.FWN = 2;
                SettingsTeenModeMainMiniProgram.a(SettingsTeenModeMainMiniProgram.this);
                a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187440);
            }
        });
        this.FWM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainMiniProgram.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(187441);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ((t) g.af(t.class)).O(SettingsTeenModeMainMiniProgram.this.getContext(), 5);
                a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187441);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainMiniProgram.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(187442);
                SettingsTeenModeMainMiniProgram.this.onBackPressed();
                AppMethodBeat.o(187442);
                return true;
            }
        });
        AppMethodBeat.o(187443);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(187444);
        super.onPause();
        AppMethodBeat.o(187444);
    }

    private void updateStatus() {
        AppMethodBeat.i(187446);
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
        AppMethodBeat.o(187446);
    }

    private void fvu() {
        AppMethodBeat.i(187447);
        Log.d("MicroMsg.SettingsTeenModeMainMiniProgram", "doSaveConfig: %s", Integer.valueOf(this.FWN));
        g.aAh().azQ().set(ar.a.USERINFO_SETTING_TEEN_MODE_MINI_PROGRAM_RANGE_INT_SYNC, Integer.valueOf(this.FWN));
        AppMethodBeat.o(187447);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(187445);
        Log.d("MicroMsg.SettingsTeenModeMainMiniProgram", "doOPLog: %s", Integer.valueOf(this.FWN));
        egx egx = new egx();
        egx.NgJ = this.FWN;
        ((l) g.af(l.class)).eis().b(new k.a(TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, egx));
        ((b) g.af(b.class)).fvq();
        super.onDestroy();
        AppMethodBeat.o(187445);
    }
}
