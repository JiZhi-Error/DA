package com.tencent.i.a.c.c.a.a.a;

import android.view.MotionEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends b {
    private c Sti;
    private String activityName;

    public d(Window.Callback callback, c cVar, String str) {
        super(callback);
        this.Sti = cVar;
        this.activityName = str;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.i.a.c.c.a.a.a.b
    public final void aC(MotionEvent motionEvent) {
        AppMethodBeat.i(214809);
        this.Sti.b(this.activityName, motionEvent);
        AppMethodBeat.o(214809);
    }
}
