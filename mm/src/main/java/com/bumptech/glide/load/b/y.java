package com.bumptech.glide.load.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class y {
    private boolean aIe;
    private final Handler handler = new Handler(Looper.getMainLooper(), new a());

    y() {
        AppMethodBeat.i(77057);
        AppMethodBeat.o(77057);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void e(v<?> vVar) {
        AppMethodBeat.i(77058);
        if (this.aIe) {
            this.handler.obtainMessage(1, vVar).sendToTarget();
            AppMethodBeat.o(77058);
        } else {
            this.aIe = true;
            vVar.recycle();
            this.aIe = false;
            AppMethodBeat.o(77058);
        }
    }

    static final class a implements Handler.Callback {
        a() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(77056);
            if (message.what == 1) {
                ((v) message.obj).recycle();
                AppMethodBeat.o(77056);
                return true;
            }
            AppMethodBeat.o(77056);
            return false;
        }
    }
}
