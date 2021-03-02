package com.tencent.mm.wallet_core.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class d implements View.OnClickListener {
    private View.OnClickListener ko;
    private long nJh = 0;

    public void onClick(View view) {
        AppMethodBeat.i(72961);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/wallet_core/ui/SafeOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.nJh >= 500) {
            this.ko.onClick(view);
            this.nJh = currentTimeMillis;
        }
        a.a(this, "com/tencent/mm/wallet_core/ui/SafeOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72961);
    }
}
