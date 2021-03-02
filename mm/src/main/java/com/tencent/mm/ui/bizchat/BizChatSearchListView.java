package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BizChatSearchListView extends ListView {
    private a PaY;

    public interface a {
        boolean clY();
    }

    public BizChatSearchListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BizChatSearchListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(33987);
        if (this.PaY != null) {
            this.PaY.clY();
        }
        if (super.onInterceptTouchEvent(motionEvent)) {
            AppMethodBeat.o(33987);
            return true;
        }
        AppMethodBeat.o(33987);
        return false;
    }

    public void setOnTouchListener(a aVar) {
        this.PaY = aVar;
    }
}
