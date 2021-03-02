package com.tencent.mm.plugin.taskbar.api;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public abstract class b implements View.OnTouchListener, AbsListView.OnScrollListener {
    protected List<a> FSp = new LinkedList();
    private int FSq = 0;

    public interface a {
        void caB();

        void caC();

        void eG(int i2, int i3);

        void zT(int i2);
    }

    public abstract void abu(int i2);

    public abstract void abv(int i2);

    public abstract void ac(MotionEvent motionEvent);

    public abstract boolean esy();

    public abstract boolean fuw();

    public abstract void fux();

    public abstract void fuz();

    public abstract int getAnimationScrollOffset();

    public abstract void iE();

    public abstract void o(View view, View view2);

    public abstract void onDestroy();

    public abstract void setActionBar(View view);

    public abstract void setActionBarUpdateCallback(a aVar);

    public abstract void setStatusBarMaskView(View view);

    public abstract void setTabView(View view);

    public abstract void wk(boolean z);

    public void setIsCurrentMainUI(boolean z) {
    }

    public void fuy() {
    }

    public void onResume() {
    }

    public void i(long j2, int i2, boolean z) {
    }

    public final void a(a aVar) {
        if (!this.FSp.contains(aVar)) {
            this.FSp.add(aVar);
        }
    }

    public final void ax(boolean z, boolean z2) {
        a(z, z2, 0, 0);
    }

    public final void a(boolean z, boolean z2, int i2, int i3) {
        Log.i("MicroMsg.HeaderAnimController", "alvinluo notifyCallback isOpen: %b, isDrag: %b, reason: %d", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2));
        if (z) {
            wl(z2);
            if ((this.FSq & 2) == 0) {
                this.FSq |= 2;
                this.FSq &= -5;
            } else {
                return;
            }
        } else {
            wm(z2);
            if ((this.FSq & 4) == 0) {
                this.FSq |= 4;
                this.FSq &= -3;
            } else {
                return;
            }
        }
        for (a aVar : this.FSp) {
            if (z) {
                if (z2) {
                    aVar.caC();
                } else {
                    aVar.caB();
                }
            } else if (z2) {
                aVar.zT(i2);
            } else {
                aVar.eG(i2, i3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void wl(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void wm(boolean z) {
    }
}
