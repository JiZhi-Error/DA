package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.View;

public abstract class a {
    protected c JBa;
    Context owO;
    int owQ = 0;

    public abstract View Ap(int i2);

    public abstract int ccf();

    public abstract int ccg();

    public abstract int cch();

    public abstract int getPageCount();

    public abstract int getRowCount();

    public abstract int getRowSpacing();

    public final void setPanelManager(c cVar) {
        this.JBa = cVar;
    }
}
