package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.m;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.ck;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class SendFeedBackUI extends MMActivity implements i {
    private TextView CZK = null;
    private ProgressDialog gtM = null;
    private EditText nBD;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a0m;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73987);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(73987);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(73988);
        g.azz().b(153, this);
        super.onDestroy();
        AppMethodBeat.o(73988);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(73989);
        setMMTitle(R.string.gox);
        this.nBD = (EditText) findViewById(R.id.be9);
        String stringExtra = getIntent().getStringExtra("intentKeyFrom");
        if (stringExtra != null && stringExtra.equals("fromEnjoyAppDialog")) {
            this.CZK = (TextView) findViewById(R.id.j7m);
            this.CZK.setVisibility(0);
            this.CZK.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(73982);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/setting/ui/setting/SendFeedBackUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", SendFeedBackUI.this.getString(R.string.j1o));
                    c.b(SendFeedBackUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SendFeedBackUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(73982);
                }
            });
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73983);
                SendFeedBackUI.this.hideVKB();
                SendFeedBackUI.this.finish();
                AppMethodBeat.o(73983);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.yq), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73985);
                String trim = SendFeedBackUI.this.nBD.getText().toString().trim();
                if (trim.length() > 0) {
                    if (trim.startsWith("//traceroute")) {
                        SendFeedBackUI.this.nBD.setText("");
                        c.V(SendFeedBackUI.this.getContext(), "traceroute", ".ui.NetworkDiagnoseIntroUI");
                        AppMethodBeat.o(73985);
                        return false;
                    }
                    final m mVar = new m(q.aoL(), trim + " key " + ck.getFingerprint() + " local key " + ck.gEv() + "NetType:" + NetStatusUtil.getNetTypeString(SendFeedBackUI.this.getApplicationContext()) + " hasNeon: " + n.aos() + " isArmv6: " + n.aou() + " isArmv7: " + n.aot());
                    g.azz().a(153, SendFeedBackUI.this);
                    g.azz().a(mVar, 0);
                    SendFeedBackUI.this.hideVKB();
                    SendFeedBackUI sendFeedBackUI = SendFeedBackUI.this;
                    SendFeedBackUI sendFeedBackUI2 = SendFeedBackUI.this;
                    SendFeedBackUI.this.getString(R.string.zb);
                    sendFeedBackUI.gtM = h.a((Context) sendFeedBackUI2, SendFeedBackUI.this.getString(R.string.ys), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI.AnonymousClass3.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(73984);
                            g.azz().a(mVar);
                            AppMethodBeat.o(73984);
                        }
                    });
                }
                AppMethodBeat.o(73985);
                return false;
            }
        });
        AppMethodBeat.o(73989);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(73990);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (i2 == 0 && i3 == 0) {
            h.d(this, getString(R.string.gow), getString(R.string.zb), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(73986);
                    SendFeedBackUI.this.finish();
                    AppMethodBeat.o(73986);
                }
            });
            AppMethodBeat.o(73990);
            return;
        }
        h.d(this, getString(R.string.gov), getString(R.string.zb), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(73990);
    }
}
