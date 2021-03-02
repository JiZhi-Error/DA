package com.tencent.mm.plugin.webwx.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.crashfix.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMBaseActivity;

public class WebWXPopupUnlockUI extends MMBaseActivity {
    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30243);
        super.onCreate(bundle);
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("deviceName");
            if (stringExtra != null) {
                final a aVar = new a(this);
                aVar.requestWindowFeature(1);
                View inflate = View.inflate(this, R.layout.a5f, null);
                ((TextView) inflate.findViewById(R.id.j07)).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(30241);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/WebWXPopupUnlockUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        bg.azz().a(new com.tencent.mm.plugin.webwx.a.b(2), 0);
                        Log.d("MicroMsg.WebWxPopUnlockUI", "doScene netSceneExtDeviceControl : UNLOCK");
                        com.tencent.mm.plugin.webwx.a.jRu.iO(1);
                        Log.d("MicroMsg.WebWxPopUnlockUI", "trigger netSceneSync notify");
                        aVar.dismiss();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXPopupUnlockUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(30241);
                    }
                });
                aVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    /* class com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI.AnonymousClass2 */

                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(30242);
                        WebWXPopupUnlockUI.this.finish();
                        AppMethodBeat.o(30242);
                    }
                });
                ((TextView) inflate.findViewById(R.id.boy)).setText(stringExtra);
                aVar.setContentView(inflate);
                aVar.show();
                AppMethodBeat.o(30243);
                return;
            }
            Log.w("MicroMsg.WebWxPopUnlockUI", "Mac WeChat request to unlock,the deviceName is null");
        }
        AppMethodBeat.o(30243);
    }
}
