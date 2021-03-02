package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.h;

public class FreeWifiTestActivity extends HellActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25170);
        super.onCreate(bundle);
        setContentView(R.layout.amr);
        findViewById(R.id.da5).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiTestActivity.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(25168);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiTestActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Toast.makeText(MMApplicationContext.getContext(), "test message", 0).show();
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiTestActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25168);
            }
        });
        findViewById(R.id.da6).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiTestActivity.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(25169);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiTestActivity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.a(FreeWifiTestActivity.this, "t12345", "t54331", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiTestActivity.AnonymousClass2.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                }, (DialogInterface.OnClickListener) null);
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiTestActivity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25169);
            }
        });
        AppMethodBeat.o(25170);
    }
}
