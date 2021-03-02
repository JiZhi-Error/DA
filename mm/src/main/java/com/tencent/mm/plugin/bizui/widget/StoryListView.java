package com.tencent.mm.plugin.bizui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class StoryListView extends ListView {
    private boolean pfJ;

    public StoryListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setBlockLayoutChildren(boolean z) {
        this.pfJ = z;
    }

    /* access modifiers changed from: protected */
    public void layoutChildren() {
        AppMethodBeat.i(123723);
        if (!this.pfJ) {
            super.layoutChildren();
        }
        AppMethodBeat.o(123723);
    }
}
