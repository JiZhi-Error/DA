package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.widget.AbsListView;
import com.tencent.mm.ui.s;

public abstract class a<T> extends s<T> implements AbsListView.OnScrollListener {
    private static final String TAG = ("MicroMsg." + a.class.getName());
    protected boolean hho;

    public abstract boolean cwg();

    public abstract int cwh();

    public abstract int getShowCount();

    public a(Context context, T t) {
        super(context, t);
        Bh(true);
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        this.hho = false;
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }
}
