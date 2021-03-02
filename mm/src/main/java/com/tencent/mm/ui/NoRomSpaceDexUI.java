package com.tencent.mm.ui;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class NoRomSpaceDexUI extends HellActivity implements DialogInterface.OnClickListener {
    PendingIntent OKa;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public Resources getResources() {
        AppMethodBeat.i(232702);
        Resources resources = MMApplicationContext.getResources();
        AppMethodBeat.o(232702);
        return resources;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33678);
        super.onCreate(bundle);
        LocaleUtil.initLanguage(MMApplicationContext.getContext());
        setContentView(R.layout.bg4);
        Intent intent = getIntent();
        this.OKa = (PendingIntent) intent.getParcelableExtra(NativeProtocol.WEB_DIALOG_ACTION);
        p pVar = new p(this);
        if (intent.hasExtra("title")) {
            pVar.setTitle(intent.getStringExtra("title"));
        } else {
            pVar.setTitle(intent.getIntExtra("titleRes", R.string.b3h));
        }
        if (intent.hasExtra("message")) {
            pVar.setMessage(intent.getStringExtra("message"));
        } else {
            int intExtra = intent.getIntExtra("messageRes", R.string.b3g);
            pVar.NIK.setVisibility(0);
            pVar.NIC.setVisibility(0);
            pVar.NIC.setText(intExtra);
        }
        if (intent.hasExtra("button")) {
            pVar.setMessage(intent.getStringExtra("message"));
        } else {
            String string = getString(intent.getIntExtra("buttonRes", R.string.b3e));
            if (pVar.HRF != null) {
                pVar.HRF.setVisibility(0);
                pVar.HRF.setText(string);
                pVar.HRF.setOnClickListener(new View.OnClickListener(this) {
                    /* class com.tencent.mm.ui.p.AnonymousClass1 */
                    final /* synthetic */ DialogInterface.OnClickListener NJb;
                    final /* synthetic */ boolean NJc = true;

                    {
                        this.NJb = r3;
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.i(33391);
                        b bVar = new b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/ui/LiteDependDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (this.NJb != null) {
                            this.NJb.onClick(p.this, -1);
                        }
                        if (this.NJc) {
                            p.this.dismiss();
                        }
                        a.a(this, "com/tencent/mm/ui/LiteDependDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(33391);
                    }
                });
            }
        }
        pVar.setCancelable(false);
        pVar.gIC();
        pVar.show();
        AppMethodBeat.o(33678);
    }

    public void onClick(DialogInterface dialogInterface, int i2) {
        AppMethodBeat.i(33679);
        if (this.OKa != null) {
            try {
                this.OKa.send();
            } catch (PendingIntent.CanceledException e2) {
            }
        }
        finish();
        com.tencent.mm.hellhoundlib.b.a a2 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object obj = new Object();
        a.a(obj, a2.axQ(), "com/tencent/mm/ui/NoRomSpaceDexUI", "onClick", "(Landroid/content/DialogInterface;I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer) a2.pG(0)).intValue());
        a.a(obj, "com/tencent/mm/ui/NoRomSpaceDexUI", "onClick", "(Landroid/content/DialogInterface;I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(33679);
    }
}
