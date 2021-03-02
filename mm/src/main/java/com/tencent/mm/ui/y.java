package com.tencent.mm.ui;

import android.view.MenuItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.coremedia.TimeUtil;

public abstract class y implements MenuItem.OnMenuItemClickListener {
    private long Dqp = -1;

    public abstract void ane();

    public boolean onMenuItemClick(MenuItem menuItem) {
        Log.i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
        if (this.Dqp != -1) {
            long nanoTime = (System.nanoTime() - this.Dqp) / TimeUtil.SECOND_TO_US;
            if (nanoTime < 500) {
                Log.i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", Long.valueOf(nanoTime), 500L);
                return false;
            }
        }
        this.Dqp = System.nanoTime();
        ane();
        return false;
    }
}
