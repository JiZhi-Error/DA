package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public abstract class MMWizardActivity extends MMActivity {
    protected static final Map<String, Intent> OHY = new HashMap();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i("MicroMsg.MMWizardActivity", "onCreate()");
        if (IntentUtil.getBoolean(getIntent().getExtras(), "WizardRootKillSelf", false)) {
            super.finish();
            Log.i("MicroMsg.MMWizardActivity", "finish wizard, root=" + getComponentName().getClassName());
            exit(getIntent().getExtras().getInt("wizard_activity_result_code"));
        }
    }

    public static void ay(Context context, Intent intent) {
        Log.i("MicroMsg.MMWizardActivity", "startWizardActivity()");
        String stringExtra = intent.getStringExtra("WizardRootClass");
        String stringExtra2 = intent.getStringExtra("WizardTransactionId");
        Intent intent2 = context instanceof Activity ? ((Activity) context).getIntent() : null;
        if (Util.isNullOrNil(stringExtra) && intent2 != null) {
            stringExtra = intent2.getStringExtra("WizardRootClass");
            stringExtra2 = intent2.getStringExtra("WizardTransactionId");
            if (intent2.getComponent() != null) {
                Log.i("MicroMsg.MMWizardActivity", "start wizard, callerIntent class=%s", intent2.getComponent().getClassName());
            }
        }
        Log.i("MicroMsg.MMWizardActivity", "start wizard, root=%s", stringExtra);
        if (!Util.isNullOrNil(stringExtra)) {
            intent.putExtra("WizardRootClass", stringExtra);
        }
        if (stringExtra2 != null) {
            intent.putExtra("WizardTransactionId", stringExtra2);
        }
        if (intent.getExtras() == null) {
            intent.putExtras(new Bundle());
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/MMWizardActivity", "startWizardActivity", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/MMWizardActivity", "startWizardActivity", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }

    public static void b(Context context, Intent intent, Intent intent2) {
        try {
            String str = "trans." + Util.currentTicks() + "." + intent2.hashCode();
            OHY.put(str, intent2);
            intent.putExtra("WizardTransactionId", str);
            Intent intent3 = ((Activity) context).getIntent();
            if (intent3 != null) {
                intent3.putExtra("WizardTransactionId", str);
            }
            ay(context, intent);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMWizardActivity", "%s", Util.stackTraceToString(e2));
        }
    }

    public final void exit(int i2) {
        String stringExtra = getIntent().getStringExtra("WizardRootClass");
        String stringExtra2 = getIntent().getStringExtra("WizardTransactionId");
        Log.i("MicroMsg.MMWizardActivity", "exit resultCode:%d, rootClass:%s, transaction:%s", Integer.valueOf(i2), stringExtra, stringExtra2);
        Intent intent = OHY.get(stringExtra2);
        OHY.remove(stringExtra2);
        if (intent == null) {
            intent = new Intent();
        }
        if (Util.isNullOrNil(stringExtra) && intent.getComponent() != null) {
            stringExtra = intent.getComponent().getClassName();
            Log.i("MicroMsg.MMWizardActivity", "exit component rootClass %s", stringExtra);
        }
        if (!Util.isNullOrNil(stringExtra)) {
            try {
                intent.putExtra("wizard_activity_result_code", i2);
                intent.setClassName(this, stringExtra);
                intent.addFlags(67108864);
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/MMWizardActivity", "exit", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMWizardActivity", "exit", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } catch (Exception e2) {
            }
        }
        super.finish();
    }

    /* access modifiers changed from: protected */
    public final void cancel() {
        Log.i("MicroMsg.MMWizardActivity", "cancel()");
        String stringExtra = getIntent().getStringExtra("WizardTransactionId");
        Intent intent = OHY.get(stringExtra);
        OHY.remove(stringExtra);
        if (intent != null) {
            Log.d("MicroMsg.MMWizardActivity", "canceled exit for transaction=" + stringExtra + ", intent=" + intent);
        }
    }

    public final void ala(int i2) {
        Log.i("MicroMsg.MMWizardActivity", "finishWizard()");
        exit(i2);
    }
}
