package com.tencent.mm.plugin.voip.video.camera.prev;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.video.ObservableSurfaceView;
import com.tencent.mm.plugin.voip.video.camera.a.c;

public class CaptureView extends ObservableSurfaceView {
    public CaptureView(Context context) {
        super(context);
        AppMethodBeat.i(235866);
        init();
        AppMethodBeat.o(235866);
    }

    public CaptureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(235867);
        init();
        AppMethodBeat.o(235867);
    }

    public CaptureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(235868);
        init();
        AppMethodBeat.o(235868);
    }

    private void init() {
        AppMethodBeat.i(235869);
        if (c.fLj()) {
            setNeedSetType(true);
        }
        AppMethodBeat.o(235869);
    }
}
