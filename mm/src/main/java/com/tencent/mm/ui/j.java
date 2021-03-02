package com.tencent.mm.ui;

import android.view.View;
import android.widget.AbsListView;
import java.util.List;

public abstract class j implements View.OnTouchListener, AbsListView.OnScrollListener {
    protected List<a> FSp;

    public interface a {
    }

    public final void a(a aVar) {
        if (!this.FSp.contains(aVar)) {
            this.FSp.add(aVar);
        }
    }
}
