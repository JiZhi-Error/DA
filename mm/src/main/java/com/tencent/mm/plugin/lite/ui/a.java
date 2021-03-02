package com.tencent.mm.plugin.lite.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a extends FrameLayout {
    a(Context context) {
        super(context);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(198936);
        getParent().requestDisallowInterceptTouchEvent(true);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(motionEvent.getAction());
        objArr[1] = onInterceptTouchEvent ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        com.tencent.wxa.c.a.i("MicroMsg.LiteApp.WxaLiteAppBaseView", "onInterceptTouchEvent action=%d r=%s", objArr);
        AppMethodBeat.o(198936);
        return onInterceptTouchEvent;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(198937);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(motionEvent.getAction());
        objArr[1] = onTouchEvent ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        com.tencent.wxa.c.a.i("MicroMsg.LiteApp.WxaLiteAppBaseView", "onTouchEvent action=%d r=%s", objArr);
        AppMethodBeat.o(198937);
        return onTouchEvent;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(198938);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(motionEvent.getAction());
        objArr[1] = dispatchTouchEvent ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        com.tencent.wxa.c.a.i("MicroMsg.LiteApp.WxaLiteAppBaseView", "dispatchTouchEvent action=%d r=%s", objArr);
        AppMethodBeat.o(198938);
        return dispatchTouchEvent;
    }
}
