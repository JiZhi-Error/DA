package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.smtt.sdk.TbsListener;

/* access modifiers changed from: package-private */
public final class a extends FrameLayout {
    public a(Context context, View view) {
        super(context);
        AppMethodBeat.i(131474);
        addView(view);
        AppMethodBeat.o(131474);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(131475);
        if ((getParent() instanceof View) && ((View) getParent()).getMeasuredHeight() > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(((View) getParent()).getMeasuredHeight() - com.tencent.mm.cb.a.fromDPToPix(getContext(), KeyBoardUtil.isPortOrientation(getContext()) ? TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3 : 24), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(131475);
    }
}
