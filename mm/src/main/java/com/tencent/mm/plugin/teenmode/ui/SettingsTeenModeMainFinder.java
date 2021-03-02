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
import com.tencent.mm.protocal.protobuf.egz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.smtt.sdk.TbsListener;

public class SettingsTeenModeMainFinder extends MMActivity {
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

    static /* synthetic */ void a(SettingsTeenModeMainFinder settingsTeenModeMainFinder) {
        AppMethodBeat.i(187437);
        settingsTeenModeMainFinder.updateStatus();
        AppMethodBeat.o(187437);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bre;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(187431);
        super.onCreate(bundle);
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        this.FWJ = (WeImageView) findViewById(R.id.iiv);
        this.FWK = (WeImageView) findViewById(R.id.iix);
        this.FWL = (WeImageView) findViewById(R.id.iiw);
        this.FWM = (LinearLayout) findViewById(R.id.c43);
        this.FWN = ((b) g.af(b.class)).dxW();
        updateStatus();
        ((View) this.FWJ.getParent()).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainFinder.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(187426);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainFinder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SettingsTeenModeMainFinder.this.FWN = 1;
                SettingsTeenModeMainFinder.a(SettingsTeenModeMainFinder.this);
                a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainFinder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187426);
            }
        });
        ((View) this.FWK.getParent()).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainFinder.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(187427);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainFinder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SettingsTeenModeMainFinder.this.FWN = 0;
                SettingsTeenModeMainFinder.a(SettingsTeenModeMainFinder.this);
                a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainFinder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187427);
            }
        });
        ((View) this.FWL.getParent()).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainFinder.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(187428);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainFinder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SettingsTeenModeMainFinder.this.FWN = 2;
                SettingsTeenModeMainFinder.a(SettingsTeenModeMainFinder.this);
                a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainFinder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187428);
            }
        });
        this.FWM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainFinder.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(187429);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainFinder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("from_teen_mode_setting_page", true);
                c.b(SettingsTeenModeMainFinder.this, "finder", ".ui.FinderFollowListUI", intent);
                a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainFinder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187429);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainFinder.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(187430);
                SettingsTeenModeMainFinder.this.onBackPressed();
                AppMethodBeat.o(187430);
                return true;
            }
        });
        AppMethodBeat.o(187431);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(187432);
        super.onPause();
        AppMethodBeat.o(187432);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(187434);
        super.onBackPressed();
        AppMethodBeat.o(187434);
    }

    private void updateStatus() {
        AppMethodBeat.i(187435);
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
        AppMethodBeat.o(187435);
    }

    private void fvu() {
        AppMethodBeat.i(187436);
        Log.d("MicroMsg.SettingsTeenModeMainFinder", "doSaveConfig: %s", Integer.valueOf(this.FWN));
        g.aAh().azQ().set(ar.a.USERINFO_SETTING_TEEN_MODE_FINDER_RANGE_INT_SYNC, Integer.valueOf(this.FWN));
        AppMethodBeat.o(187436);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(187433);
        Log.d("MicroMsg.SettingsTeenModeMainFinder", "doLog: %s", Integer.valueOf(this.FWN));
        egz egz = new egz();
        egz.NgJ = this.FWN;
        ((l) g.af(l.class)).eis().b(new k.a(TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, egz));
        ((b) g.af(b.class)).fvq();
        super.onDestroy();
        AppMethodBeat.o(187433);
    }
}
