package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.g;
import com.tencent.mm.sdk.platformtools.Log;

public class FixAspectRatioRelativeLayout extends RelativeLayout {
    private float tEJ;

    public FixAspectRatioRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(40896);
        c(context, attributeSet, 0);
        AppMethodBeat.o(40896);
    }

    public FixAspectRatioRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(40897);
        c(context, attributeSet, i2);
        AppMethodBeat.o(40897);
    }

    private void c(Context context, AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(40898);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.FixAspectRatioImageView, i2, 0);
        this.tEJ = obtainStyledAttributes.getFloat(0, 0.0f);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(40898);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(40899);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i4 = (int) (this.tEJ * ((float) size));
        Log.i("MicroMsg.FixAspectRatioRelativeLayout", "width = %d, height = %d, ratioHeight = %d", Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(i4));
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
        AppMethodBeat.o(40899);
    }
}
