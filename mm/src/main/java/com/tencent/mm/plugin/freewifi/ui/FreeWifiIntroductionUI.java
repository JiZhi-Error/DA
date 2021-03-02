package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiIntroductionUI extends MMActivity {
    private int source;
    private Button wQN;
    private Button wRX;
    private Button wRY;
    private CheckBox wRZ;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25062);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(25062);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(25063);
        this.wRX = (Button) findViewById(R.id.bfk);
        this.wRZ = (CheckBox) findViewById(R.id.ic);
        this.wQN = (Button) findViewById(R.id.dp6);
        this.wRY = (Button) findViewById(R.id.j1_);
        this.source = getIntent().getIntExtra("free_wifi_source", 1);
        if (this.source == 3) {
            setMMTitle(R.string.f0h);
            ((TextView) findViewById(R.id.d_i)).setText(R.string.f0f);
            ((TextView) findViewById(R.id.d_d)).setText(R.string.f0e);
            this.wQN.setVisibility(8);
        } else {
            setMMTitle(R.string.dip);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25057);
                FreeWifiIntroductionUI.this.finish();
                AppMethodBeat.o(25057);
                return false;
            }
        });
        this.wRX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(25058);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                bg.aVF();
                c.azQ().set(303104, (Object) 1);
                Intent intent = FreeWifiIntroductionUI.this.getIntent();
                intent.setClass(FreeWifiIntroductionUI.this, FreeWifiEntryUI.class);
                FreeWifiIntroductionUI freeWifiIntroductionUI = FreeWifiIntroductionUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(freeWifiIntroductionUI, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                freeWifiIntroductionUI.startActivity((Intent) bl.pG(0));
                a.a(freeWifiIntroductionUI, "com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                FreeWifiIntroductionUI.this.finish();
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25058);
            }
        });
        this.wRZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI.AnonymousClass3 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(25059);
                if (z) {
                    FreeWifiIntroductionUI.this.wRX.setEnabled(true);
                    AppMethodBeat.o(25059);
                    return;
                }
                FreeWifiIntroductionUI.this.wRX.setEnabled(false);
                AppMethodBeat.o(25059);
            }
        });
        this.wRY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI.AnonymousClass4 */

            public final void onClick(View view) {
                String string;
                AppMethodBeat.i(25060);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (FreeWifiIntroductionUI.this.source == 3) {
                    string = FreeWifiIntroductionUI.this.getString(R.string.f0g);
                } else {
                    string = FreeWifiIntroductionUI.this.getString(R.string.dim);
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.br.c.b(FreeWifiIntroductionUI.this, "webview", ".ui.tools.WebViewUI", intent);
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25060);
            }
        });
        this.wQN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(25061);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String string = FreeWifiIntroductionUI.this.getString(R.string.di3);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.br.c.b(FreeWifiIntroductionUI.this, "webview", ".ui.tools.WebViewUI", intent);
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25061);
            }
        });
        AppMethodBeat.o(25063);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.amj;
    }
}
