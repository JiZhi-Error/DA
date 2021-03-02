package c.t.m.sapp.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class o {
    public static boolean a(Handler handler) {
        AppMethodBeat.i(223014);
        boolean a2 = a(handler == null ? null : handler.getLooper());
        AppMethodBeat.o(223014);
        return a2;
    }

    public static boolean a(Looper looper) {
        AppMethodBeat.i(223015);
        if (looper == null || !looper.getThread().isAlive()) {
            AppMethodBeat.o(223015);
            return false;
        }
        AppMethodBeat.o(223015);
        return true;
    }

    public static boolean a(Handler handler, Message message) {
        AppMethodBeat.i(223016);
        boolean a2 = a(handler, message, 0);
        AppMethodBeat.o(223016);
        return a2;
    }

    public static boolean a(Handler handler, Message message, long j2) {
        AppMethodBeat.i(223017);
        if (message == null || !a(handler)) {
            AppMethodBeat.o(223017);
            return false;
        }
        boolean sendMessageDelayed = handler.sendMessageDelayed(message, j2);
        AppMethodBeat.o(223017);
        return sendMessageDelayed;
    }
}
