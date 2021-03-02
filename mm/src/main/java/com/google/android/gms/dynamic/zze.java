package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;

final class zze implements View.OnClickListener {
    private byte _hellAccFlag_;
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ Intent zzabl;

    zze(Context context, Intent intent) {
        this.val$context = context;
        this.zzabl = intent;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(12131);
        try {
            Context context = this.val$context;
            a bl = new a().bl(this.zzabl);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/google/android/gms/dynamic/zze", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/google/android/gms/dynamic/zze", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(12131);
        } catch (ActivityNotFoundException e2) {
            AppMethodBeat.o(12131);
        }
    }
}
