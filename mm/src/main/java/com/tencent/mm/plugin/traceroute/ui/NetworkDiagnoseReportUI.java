package com.tencent.mm.plugin.traceroute.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public class NetworkDiagnoseReportUI extends MMActivity {
    private static String Grg;
    private boolean GrV = false;
    private Button GrW;
    private Button GrX;
    private ImageView GrY;
    private TextView GrZ;
    private TextView Gsa;
    private TextView Gsb;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29703);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(29703);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(29704);
        setMMTitle("");
        this.GrY = (ImageView) findViewById(R.id.h3b);
        this.GrZ = (TextView) findViewById(R.id.h3e);
        this.Gsa = (TextView) findViewById(R.id.h3d);
        this.GrV = getIntent().getBooleanExtra("diagnose_result", false);
        if (this.GrV) {
            this.GrY.setImageResource(R.drawable.bjc);
            this.GrZ.setText(getString(R.string.htg));
            this.Gsa.setVisibility(0);
            addTextOptionMenu(0, getString(R.string.bm4), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(29699);
                    NetworkDiagnoseReportUI.this.finish();
                    AppMethodBeat.o(29699);
                    return false;
                }
            });
            AppMethodBeat.o(29704);
            return;
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29700);
                NetworkDiagnoseReportUI.this.finish();
                AppMethodBeat.o(29700);
                return true;
            }
        });
        Grg = getIntent().getStringExtra("diagnose_log_file_path");
        this.GrY.setImageResource(R.drawable.bjb);
        this.GrZ.setText(getString(R.string.htf));
        if (Grg == null || s.boW(Grg) <= 0) {
            AppMethodBeat.o(29704);
            return;
        }
        this.Gsb = (TextView) findViewById(R.id.h3c);
        this.Gsb.setText(getString(R.string.g4y, new Object[]{Grg.replace("mnt/", "")}));
        findViewById(R.id.h3c).setVisibility(0);
        findViewById(R.id.hkd).setVisibility(0);
        this.GrW = (Button) findViewById(R.id.hkh);
        this.GrW.setVisibility(0);
        this.GrW.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(29701);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent("android.intent.action.SEND");
                intent.addFlags(268435456);
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"WeChat_Log@qq.com"});
                intent.putExtra("android.intent.extra.SUBJECT", NetworkDiagnoseReportUI.a(NetworkDiagnoseReportUI.this));
                intent.putExtra("android.intent.extra.STREAM", FileProviderHelper.getUriForFile(NetworkDiagnoseReportUI.this.getContext(), new o(NetworkDiagnoseReportUI.Grg)));
                intent.setType("text/plain");
                NetworkDiagnoseReportUI networkDiagnoseReportUI = NetworkDiagnoseReportUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(networkDiagnoseReportUI, bl.axQ(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                networkDiagnoseReportUI.startActivity((Intent) bl.pG(0));
                a.a(networkDiagnoseReportUI, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29701);
            }
        });
        this.GrX = (Button) findViewById(R.id.j7h);
        this.GrX.setVisibility(0);
        this.GrX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(29702);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!Util.isNullOrNil(NetworkDiagnoseReportUI.Grg)) {
                    o oVar = new o(NetworkDiagnoseReportUI.Grg);
                    if (oVar.exists()) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        FileProviderHelper.setIntentDataAndType((Context) NetworkDiagnoseReportUI.this.getContext(), intent, oVar, "text/plain", false);
                        intent.addFlags(268435456);
                        NetworkDiagnoseReportUI networkDiagnoseReportUI = NetworkDiagnoseReportUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        a.a(networkDiagnoseReportUI, bl.axQ(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        networkDiagnoseReportUI.startActivity((Intent) bl.pG(0));
                        a.a(networkDiagnoseReportUI, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                }
                a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseReportUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29702);
            }
        });
        AppMethodBeat.o(29704);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bfq;
    }

    static /* synthetic */ String a(NetworkDiagnoseReportUI networkDiagnoseReportUI) {
        AppMethodBeat.i(29705);
        String string = networkDiagnoseReportUI.getString(R.string.g4x);
        o oVar = new o(Grg);
        if (!oVar.exists()) {
            AppMethodBeat.o(29705);
            return string;
        }
        String name = oVar.getName();
        if (Util.isNullOrNil(name)) {
            AppMethodBeat.o(29705);
            return string;
        }
        int indexOf = name.indexOf(".");
        StringBuilder append = new StringBuilder().append(string).append("_");
        if (indexOf <= 0) {
            indexOf = name.length();
        }
        String sb = append.append(name.substring(0, indexOf)).toString();
        AppMethodBeat.o(29705);
        return sb;
    }
}
