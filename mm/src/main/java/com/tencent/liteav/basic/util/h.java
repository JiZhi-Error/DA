package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class h extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private int f482a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f483b = false;

    /* renamed from: c  reason: collision with root package name */
    private a f484c;

    public interface a {
        void a();
    }

    public h(Looper looper, a aVar) {
        super(looper);
        this.f484c = aVar;
    }

    public void handleMessage(Message message) {
        AppMethodBeat.i(222116);
        if (this.f484c != null) {
            this.f484c.a();
        }
        if (this.f483b) {
            sendEmptyMessageDelayed(0, (long) this.f482a);
        }
        AppMethodBeat.o(222116);
    }

    public void a(int i2, int i3) {
        AppMethodBeat.i(222117);
        a();
        this.f482a = i3;
        this.f483b = true;
        sendEmptyMessageDelayed(0, (long) i2);
        AppMethodBeat.o(222117);
    }

    public void a() {
        AppMethodBeat.i(222118);
        while (hasMessages(0)) {
            removeMessages(0);
        }
        this.f483b = false;
        AppMethodBeat.o(222118);
    }
}
