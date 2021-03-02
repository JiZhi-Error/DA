package com.tencent.mm.pluginsdk.ui.b;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;

public abstract class b implements a {
    public WeakReference<Context> Kgr = null;
    public boolean ifo = false;
    public boolean isFirst = false;
    public View view = null;

    public abstract void destroy();

    public abstract int getLayoutId();

    public b(Context context) {
        this.Kgr = new WeakReference<>(context);
        if (getLayoutId() > 0) {
            this.view = View.inflate(context, getLayoutId(), null);
        }
    }

    public void setVisibility(int i2) {
        if (getView() != null) {
            getView().setVisibility(i2);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.a
    public View getView() {
        return this.view;
    }

    public boolean bYa() {
        return this.view != null && this.view.getVisibility() == 0;
    }

    public void release() {
    }

    public int getOrder() {
        return 0;
    }
}
