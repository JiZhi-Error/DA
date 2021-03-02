package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Gallery;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMGallery extends Gallery {
    public MMGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141958);
        setStaticTransformationsEnabled(true);
        AppMethodBeat.o(141958);
    }

    public MMGallery(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(141959);
        setStaticTransformationsEnabled(true);
        AppMethodBeat.o(141959);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(141960);
        if (f2 > 0.0f) {
            onKeyDown(21, null);
        } else {
            onKeyDown(22, null);
        }
        AppMethodBeat.o(141960);
        return true;
    }
}
