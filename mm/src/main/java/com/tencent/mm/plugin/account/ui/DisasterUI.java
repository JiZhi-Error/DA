package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class DisasterUI extends MMActivity {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127908);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_disaster_content");
        final String stringExtra2 = getIntent().getStringExtra("key_disaster_url");
        Log.i("MicroMsg.DisasterUI", "summerdiz onCreate :%d, content[%s], url[%s]", Integer.valueOf(hashCode()), stringExtra, stringExtra2);
        ((TextView) findViewById(R.id.g2n)).setText(stringExtra);
        findViewById(R.id.g2k).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.DisasterUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(127906);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/ui/DisasterUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.DisasterUI", "summerdiz jump link");
                h.INSTANCE.a(13939, 1);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(stringExtra2));
                DisasterUI disasterUI = DisasterUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(disasterUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/DisasterUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                disasterUI.startActivity((Intent) bl.pG(0));
                a.a(disasterUI, "com/tencent/mm/plugin/account/ui/DisasterUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                a.a(this, "com/tencent/mm/plugin/account/ui/DisasterUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(127906);
            }
        });
        setMMTitle(getString(R.string.bn3));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.DisasterUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127907);
                h.INSTANCE.a(13939, 3);
                Log.i("MicroMsg.DisasterUI", "summerdiz back");
                DisasterUI.this.finish();
                AppMethodBeat.o(127907);
                return true;
            }
        });
        AppMethodBeat.o(127908);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.zy;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean needShowIdcError() {
        return false;
    }
}
