package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class MMSuperAlert extends HellActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(115306);
        super.onCreate(bundle);
        setContentView(R.layout.baf);
        final int intExtra = getIntent().getIntExtra("MMSuperAlert_msg", 0);
        final int intExtra2 = getIntent().getIntExtra("MMSuperAlert_title", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("MMSuperAlert_cancelable", true);
        new MMHandler().postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.voip.ui.MMSuperAlert.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(115305);
                h.a(MMSuperAlert.this, intExtra == 0 ? "" : MMSuperAlert.this.getString(intExtra), intExtra2 == 0 ? "" : MMSuperAlert.this.getString(intExtra2), booleanExtra, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.voip.ui.MMSuperAlert.AnonymousClass1.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(115303);
                        MMSuperAlert.this.finish();
                        AppMethodBeat.o(115303);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.voip.ui.MMSuperAlert.AnonymousClass1.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(115304);
                        MMSuperAlert.this.finish();
                        AppMethodBeat.o(115304);
                    }
                });
                AppMethodBeat.o(115305);
            }
        }, 50);
        AppMethodBeat.o(115306);
    }

    public static void at(Context context, int i2) {
        AppMethodBeat.i(115307);
        Intent intent = new Intent(context, MMSuperAlert.class);
        intent.putExtra("MMSuperAlert_title", R.string.zb);
        intent.putExtra("MMSuperAlert_msg", i2);
        intent.putExtra("MMSuperAlert_cancelable", false);
        intent.setFlags(268435456);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/voip/ui/MMSuperAlert", "show", "(Landroid/content/Context;IIZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/voip/ui/MMSuperAlert", "show", "(Landroid/content/Context;IIZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(115307);
    }

    public Resources getResources() {
        AppMethodBeat.i(115308);
        if (getAssets() == null || MMApplicationContext.getResources() == null) {
            Resources resources = super.getResources();
            AppMethodBeat.o(115308);
            return resources;
        }
        Resources resources2 = MMApplicationContext.getResources();
        AppMethodBeat.o(115308);
        return resources2;
    }
}
