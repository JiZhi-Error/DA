package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;

public class NetworkDiagnoseIntroUI extends MMActivity {
    private Button GrS;
    private TextView GrT;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29697);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(29697);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(29698);
        this.GrS = (Button) findViewById(R.id.i4h);
        this.GrS.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseIntroUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(29694);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                bg.aVF();
                if (!c.isSDCardAvailable()) {
                    u.g(NetworkDiagnoseIntroUI.this, null);
                    a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(29694);
                } else if (bg.azz().aYS() == 0) {
                    Toast.makeText(NetworkDiagnoseIntroUI.this, NetworkDiagnoseIntroUI.this.getString(R.string.dep), 0).show();
                    a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(29694);
                } else {
                    Intent intent = new Intent(NetworkDiagnoseIntroUI.this, NetworkDiagnoseUI.class);
                    NetworkDiagnoseIntroUI networkDiagnoseIntroUI = NetworkDiagnoseIntroUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    a.a(networkDiagnoseIntroUI, bl.axQ(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    networkDiagnoseIntroUI.startActivity((Intent) bl.pG(0));
                    a.a(networkDiagnoseIntroUI, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    NetworkDiagnoseIntroUI.this.finish();
                    a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(29694);
                }
            }
        });
        this.GrT = (TextView) findViewById(R.id.fuu);
        this.GrT.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseIntroUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(29695);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("title", NetworkDiagnoseIntroUI.this.getString(R.string.fp_));
                intent.putExtra("rawUrl", NetworkDiagnoseIntroUI.this.getString(R.string.htp, new Object[]{LocaleUtil.getApplicationLanguage(), LocaleUtil.getCurrentCountryCode()}));
                intent.putExtra("showShare", false);
                com.tencent.mm.plugin.traceroute.a.a.jRt.i(intent, NetworkDiagnoseIntroUI.this.getContext());
                a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29695);
            }
        });
        setMMTitle("");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseIntroUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29696);
                NetworkDiagnoseIntroUI.this.finish();
                AppMethodBeat.o(29696);
                return true;
            }
        });
        AppMethodBeat.o(29698);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bfp;
    }
}
