package com.tencent.mm.plugin.webwx.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;

public class WebWeiXinIntroductionUI extends MMActivity {
    private Button JFL;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cbc;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30246);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(30246);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(30247);
        setMMTitle("");
        this.JFL = (Button) findViewById(R.id.jla);
        this.JFL.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webwx.ui.WebWeiXinIntroductionUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(30244);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/webwx/ui/WebWeiXinIntroductionUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
                intent.putExtra("from_album", false);
                intent.putExtra("show_intro", false);
                intent.setFlags(65536);
                c.b(WebWeiXinIntroductionUI.this, "scanner", ".ui.BaseScanUI", intent);
                a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWeiXinIntroductionUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30244);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.webwx.ui.WebWeiXinIntroductionUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(30245);
                WebWeiXinIntroductionUI.this.finish();
                AppMethodBeat.o(30245);
                return true;
            }
        });
        AppMethodBeat.o(30247);
    }
}
