package com.tencent.mm.ui;

import android.view.View;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.coremedia.TimeUtil;

public abstract class x implements View.OnClickListener {
    private long Dqp = -1;

    public abstract void czW();

    public void onClick(View view) {
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/ui/MMCustomClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Log.i("MicroMsg.MMCustomClickListener", "button onclick");
        if (this.Dqp != -1) {
            long nanoTime = (System.nanoTime() - this.Dqp) / TimeUtil.SECOND_TO_US;
            if (nanoTime < 3000) {
                Log.i("MicroMsg.MMCustomClickListener", "click time limited limitetime:%d, delaytime:%d", Long.valueOf(nanoTime), 3000L);
                a.a(this, "com/tencent/mm/ui/MMCustomClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                return;
            }
        }
        this.Dqp = System.nanoTime();
        czW();
        a.a(this, "com/tencent/mm/ui/MMCustomClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    }
}
