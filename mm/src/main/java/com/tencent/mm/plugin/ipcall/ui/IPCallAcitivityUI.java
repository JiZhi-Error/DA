package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class IPCallAcitivityUI extends MMActivity {
    private com.tencent.mm.plugin.ipcall.model.h.a ytA;
    private FrameLayout ytu;
    private TextView ytv;
    private TextView ytw;
    private Button ytx;
    private CdnImageView yty;
    private boolean ytz = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.awr;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25606);
        super.onCreate(bundle);
        getWindow().addFlags(131072);
        getWindow().setFlags(1024, 1024);
        hideTitleView();
        initView();
        AppMethodBeat.o(25606);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25607);
        super.onDestroy();
        AppMethodBeat.o(25607);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(25608);
        this.ytu = (FrameLayout) findViewById(R.id.e1c);
        this.ytv = (TextView) findViewById(R.id.e1i);
        this.ytw = (TextView) findViewById(R.id.e1e);
        this.ytx = (Button) findViewById(R.id.e1f);
        this.yty = (CdnImageView) findViewById(R.id.e1g);
        bg.aVF();
        String str = (String) c.azQ().get(ar.a.USERFINO_IPCALL_ACTIVITY_STRING, "");
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.IPCallAcitivityUI", "xml is empty");
            finish();
        } else {
            this.ytA = com.tencent.mm.plugin.ipcall.model.h.a.aBT(str);
            if (this.ytA == null) {
                Log.e("MicroMsg.IPCallAcitivityUI", "mMsgInfo is null");
                finish();
            } else {
                this.ytv.setText(this.ytA.Title);
                this.ytw.setText(this.ytA.Desc);
                this.ytx.setText(this.ytA.ysC);
                this.yty.setUrl(this.ytA.ImgUrl);
            }
        }
        this.ytu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallAcitivityUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(25603);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                IPCallAcitivityUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25603);
            }
        });
        this.ytx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallAcitivityUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(25604);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (IPCallAcitivityUI.this.ytA.oUv == 1) {
                    Log.i("MicroMsg.IPCallAcitivityUI", "click activity, go to IPCallPackageUI");
                    Intent intent = new Intent();
                    intent.setClass(IPCallAcitivityUI.this.getContext(), IPCallShareCouponUI.class);
                    IPCallAcitivityUI iPCallAcitivityUI = IPCallAcitivityUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(iPCallAcitivityUI, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    iPCallAcitivityUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(iPCallAcitivityUI, "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    Intent intent2 = new Intent();
                    intent2.setClass(IPCallAcitivityUI.this.getContext(), IPCallPackageUI.class);
                    IPCallAcitivityUI iPCallAcitivityUI2 = IPCallAcitivityUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(iPCallAcitivityUI2, bl2.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    iPCallAcitivityUI2.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(iPCallAcitivityUI2, "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                IPCallAcitivityUI.this.ytz = true;
                IPCallAcitivityUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25604);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallAcitivityUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25605);
                IPCallAcitivityUI.this.finish();
                AppMethodBeat.o(25605);
                return true;
            }
        });
        AppMethodBeat.o(25608);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(25609);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.di);
        if (this.ytz) {
            com.tencent.mm.plugin.ipcall.model.f.c.Pe(1);
            AppMethodBeat.o(25609);
            return;
        }
        com.tencent.mm.plugin.ipcall.model.f.c.Pe(0);
        AppMethodBeat.o(25609);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(25610);
        super.onBackPressed();
        AppMethodBeat.o(25610);
    }
}
