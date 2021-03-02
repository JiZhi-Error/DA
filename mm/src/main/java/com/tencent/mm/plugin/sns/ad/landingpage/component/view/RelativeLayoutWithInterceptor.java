package com.tencent.mm.plugin.sns.ad.landingpage.component.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RelativeLayoutWithInterceptor extends RelativeLayout {
    private a DtW;

    public interface a {
        boolean eXh();
    }

    public RelativeLayoutWithInterceptor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RelativeLayoutWithInterceptor(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setEventInterceptor(a aVar) {
        this.DtW = aVar;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(202000);
        if (this.DtW != null) {
            boolean eXh = this.DtW.eXh();
            AppMethodBeat.o(202000);
            return eXh;
        }
        AppMethodBeat.o(202000);
        return true;
    }
}
