package com.tencent.mm.plugin.profile.ui.tab;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class TestCoordinatorLayout extends CoordinatorLayout {
    public TestCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TestCoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(232007);
        super.setPadding(i2, i3, i4, i5);
        Log.i("TestCoordinatorLayout", "TestCoordinatorLayout:%d, %d, %d, %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        AppMethodBeat.o(232007);
    }
}
