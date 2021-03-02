package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.plugin.appbrand.dynamic.widget.b;
import com.tencent.mm.plugin.appbrand.utils.html.c;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.plugin.appbrand.widget.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WxaWidgetDebugUI extends MMActivity {
    String appId;
    int dMe;
    String id;
    MMSwitchBtn lpB;
    m lpC;
    int pkgVersion;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(121497);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(121491);
                WxaWidgetDebugUI.this.finish();
                AppMethodBeat.o(121491);
                return false;
            }
        });
        Object[] objArr = new Object[1];
        if (((g) com.tencent.mm.kernel.g.af(g.class)).aXI().aXP()) {
            str = String.format("(%s)", b.bCv());
        } else {
            str = "";
        }
        objArr[0] = str;
        setMMTitle(getString(R.string.j62, objArr));
        Intent intent = getIntent();
        this.id = intent.getStringExtra("id");
        this.appId = intent.getStringExtra("app_id");
        this.dMe = intent.getIntExtra("pkg_type", 0);
        this.pkgVersion = intent.getIntExtra("pkg_version", 0);
        setMMSubTitle(String.format("(%s)", this.id));
        this.lpB = (MMSwitchBtn) findViewById(R.id.g4a);
        this.lpC = ((com.tencent.mm.plugin.appbrand.widget.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.widget.a.b.class)).buH().afV(this.appId);
        if (this.lpC == null) {
            this.lpC = new m();
            this.lpC.field_appId = this.appId;
        }
        this.lpB.setCheck(this.lpC.field_openDebug);
        this.lpB.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(121492);
                WxaWidgetDebugUI.this.lpC.field_openDebug = z;
                n buH = ((com.tencent.mm.plugin.appbrand.widget.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.widget.a.b.class)).buH();
                m mVar = WxaWidgetDebugUI.this.lpC;
                if (mVar != null && !Util.isNullOrNil(mVar.field_appId)) {
                    mVar.field_appIdHash = mVar.field_appId.hashCode();
                    buH.replace(mVar);
                }
                AppMethodBeat.o(121492);
            }
        });
        TextView textView = (TextView) findViewById(R.id.dz2);
        textView.setText(c.a(getString(R.string.j68), true, (c.a) new c.a() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.utils.html.c.a
            public final void YF(String str) {
                AppMethodBeat.i(121493);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                com.tencent.mm.br.c.b(WxaWidgetDebugUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                Log.d("WxaWidgetDebugUI", "on custom url(%s) span clicked.", str);
                AppMethodBeat.o(121493);
            }
        }));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        findViewById(R.id.h5i).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(121495);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ((g) com.tencent.mm.kernel.g.af(g.class)).aXH().restart();
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(121494);
                        Toast.makeText(WxaWidgetDebugUI.this.getContext(), (int) R.string.j6a, 1).show();
                        AppMethodBeat.o(121494);
                    }
                }, 1000);
                a.a(this, "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121495);
            }
        });
        View findViewById = findViewById(R.id.jo0);
        if (((g) com.tencent.mm.kernel.g.af(g.class)).aXI().aXP()) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(121496);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent(WxaWidgetDebugUI.this.getContext(), WxaWidgetSettingsUI.class);
                    intent.putExtra("app_id", WxaWidgetDebugUI.this.appId);
                    intent.putExtra("pkg_type", WxaWidgetDebugUI.this.dMe);
                    intent.putExtra("pkg_version", WxaWidgetDebugUI.this.pkgVersion);
                    WxaWidgetDebugUI wxaWidgetDebugUI = WxaWidgetDebugUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    a.a(wxaWidgetDebugUI, bl.axQ(), "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    wxaWidgetDebugUI.startActivity((Intent) bl.pG(0));
                    a.a(wxaWidgetDebugUI, "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    a.a(this, "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(121496);
                }
            });
            AppMethodBeat.o(121497);
            return;
        }
        findViewById.setVisibility(8);
        AppMethodBeat.o(121497);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cd2;
    }
}
