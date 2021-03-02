package com.tencent.map.tools.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q {
    private static boolean a(Handler handler) {
        Looper looper;
        AppMethodBeat.i(193529);
        if (handler == null) {
            looper = null;
        } else {
            looper = handler.getLooper();
        }
        if (looper == null || !looper.getThread().isAlive()) {
            AppMethodBeat.o(193529);
            return false;
        }
        AppMethodBeat.o(193529);
        return true;
    }

    public static boolean a(Handler handler, int i2, long j2) {
        AppMethodBeat.i(193530);
        boolean a2 = a(handler, handler == null ? null : handler.obtainMessage(i2), j2);
        AppMethodBeat.o(193530);
        return a2;
    }

    private static boolean a(Handler handler, Message message, long j2) {
        AppMethodBeat.i(193531);
        if (message == null || !a(handler)) {
            AppMethodBeat.o(193531);
            return false;
        }
        boolean sendMessageDelayed = handler.sendMessageDelayed(message, j2);
        AppMethodBeat.o(193531);
        return sendMessageDelayed;
    }

    public static boolean a(Handler handler, int i2, Object obj) {
        AppMethodBeat.i(193532);
        if (handler == null) {
            AppMethodBeat.o(193532);
            return false;
        }
        boolean a2 = a(handler, b(handler, i2, obj), 0);
        AppMethodBeat.o(193532);
        return a2;
    }

    private static Message b(Handler handler, int i2, Object obj) {
        AppMethodBeat.i(193533);
        Message message = handler == null ? new Message() : handler.obtainMessage(i2);
        message.what = i2;
        message.arg1 = 0;
        message.arg2 = 0;
        message.obj = obj;
        AppMethodBeat.o(193533);
        return message;
    }
}
