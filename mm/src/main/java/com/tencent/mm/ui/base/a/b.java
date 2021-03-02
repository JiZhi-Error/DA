package com.tencent.mm.ui.base.a;

import android.view.View;
import com.tencent.mm.view.recyclerview.h;

public final class b extends h {
    private final View view;

    public b(View view2) {
        super(view2);
        this.view = view2;
    }

    public final <V extends View> V getView() {
        return (V) this.view;
    }
}
