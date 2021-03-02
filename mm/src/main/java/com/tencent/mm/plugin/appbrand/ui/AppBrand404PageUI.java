package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(19)
public final class AppBrand404PageUI extends MMActivity {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    private static void a(String str, ActivityStarterIpcDelegate activityStarterIpcDelegate) {
        AppMethodBeat.i(48513);
        final Intent putExtra = new Intent(MMApplicationContext.getContext(), AppBrand404PageUI.class).putExtra("key_wording", str).putExtra("key_icon_url", (String) null);
        if (activityStarterIpcDelegate != null) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(putExtra);
            com.tencent.mm.hellhoundlib.a.a.a(activityStarterIpcDelegate, bl.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrand404PageUI", "show", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activityStarterIpcDelegate.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activityStarterIpcDelegate, "com/tencent/mm/plugin/appbrand/ui/AppBrand404PageUI", "show", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(48513);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(48511);
                putExtra.addFlags(268435456);
                Context context = MMApplicationContext.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(putExtra);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrand404PageUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/ui/AppBrand404PageUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(48511);
            }
        });
        AppMethodBeat.o(48513);
    }

    public static void show(int i2) {
        AppMethodBeat.i(48514);
        a(MMApplicationContext.getContext().getString(i2), null);
        AppMethodBeat.o(48514);
    }

    public static void a(ActivityStarterIpcDelegate activityStarterIpcDelegate) {
        AppMethodBeat.i(48515);
        a(MMApplicationContext.getContext().getString(R.string.ne), activityStarterIpcDelegate);
        AppMethodBeat.o(48515);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.cw;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(48516);
        super.onCreate(bundle);
        setMMTitle(R.string.kp);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(48512);
                AppBrand404PageUI.this.finish();
                AppMethodBeat.o(48512);
                return true;
            }
        });
        TextView textView = (TextView) findViewById(R.id.nx);
        String stringExtra = getIntent().getStringExtra("key_wording");
        Util.isNullOrNil(stringExtra);
        if (textView != null) {
            textView.setText(stringExtra);
        }
        AppMethodBeat.o(48516);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(48517);
        super.finish();
        AppMethodBeat.o(48517);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(48518);
        super.onDestroy();
        AppMethodBeat.o(48518);
    }
}
