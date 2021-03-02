package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public abstract class a {
    AbstractC0808a obo;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.a$a  reason: collision with other inner class name */
    interface AbstractC0808a {
        void a(a aVar, View view, boolean z);
    }

    public abstract void bSx();

    public abstract View bYp();

    public abstract void onDetached();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void zu(int i2);

    public abstract void zv(int i2);

    a() {
    }

    /* access modifiers changed from: protected */
    public void a(WeImageView weImageView) {
    }

    /* access modifiers changed from: protected */
    public final void setViewEnable(boolean z) {
        if (bYp() != null) {
            if (z) {
                if (bYp().getVisibility() != 0) {
                    bYp().setVisibility(0);
                }
            } else if (bYp().getVisibility() != 8) {
                bYp().setVisibility(8);
            }
            if (this.obo != null) {
                this.obo.a(this, bYp(), z);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean getViewEnable() {
        if (bYp() != null && bYp().getVisibility() == 0) {
            return true;
        }
        return false;
    }
}
