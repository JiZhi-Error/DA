package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsCommentShowAbLayout extends AbsoluteLayout {
    public SnsCommentShowAbLayout(Context context) {
        super(context);
    }

    public SnsCommentShowAbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsCommentShowAbLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void buildDrawingCache(boolean z) {
        AppMethodBeat.i(98674);
        super.buildDrawingCache(z);
        AppMethodBeat.o(98674);
    }

    public void destroyDrawingCache() {
        AppMethodBeat.i(98675);
        super.destroyDrawingCache();
        AppMethodBeat.o(98675);
    }
}
