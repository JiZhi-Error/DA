package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class LoadMoreScrollView extends ScrollView {
    private a zbs;

    public interface a {
    }

    public LoadMoreScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public LoadMoreScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(65415);
        Log.v("MicroMsg.LoadMoreScrollView", i2 + ", " + i3 + ", " + z + ", " + z2 + ", " + getScrollY());
        super.onOverScrolled(i2, i3, z, z2);
        AppMethodBeat.o(65415);
    }

    public void setOnLoadMoreListener(a aVar) {
        this.zbs = aVar;
    }
}
