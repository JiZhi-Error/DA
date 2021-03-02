package com.tencent.liteav.beauty.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f522a = false;

    public synchronized void a() {
        AppMethodBeat.i(15022);
        this.f522a = true;
        notify();
        AppMethodBeat.o(15022);
    }

    public synchronized void b() {
        AppMethodBeat.i(15023);
        while (!this.f522a) {
            wait();
        }
        this.f522a = false;
        AppMethodBeat.o(15023);
    }
}
