package com.tencent.tbs.one.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;

public final class b<T> extends TBSOneCallback<T> {

    /* renamed from: a  reason: collision with root package name */
    T f2378a;

    /* renamed from: b  reason: collision with root package name */
    int f2379b = 0;

    /* renamed from: c  reason: collision with root package name */
    String f2380c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2381d;

    private synchronized void b() {
        AppMethodBeat.i(174155);
        this.f2381d = true;
        notify();
        AppMethodBeat.o(174155);
    }

    public final synchronized void a() {
        AppMethodBeat.i(174156);
        if (!this.f2381d) {
            try {
                wait();
                AppMethodBeat.o(174156);
            } catch (InterruptedException e2) {
                this.f2379b = 103;
                this.f2380c = "Failed to wait for loading result";
            }
        }
        AppMethodBeat.o(174156);
    }

    @Override // com.tencent.tbs.one.TBSOneCallback
    public final void onCompleted(T t) {
        AppMethodBeat.i(174153);
        this.f2378a = t;
        b();
        AppMethodBeat.o(174153);
    }

    @Override // com.tencent.tbs.one.TBSOneCallback
    public final void onError(int i2, String str) {
        AppMethodBeat.i(174154);
        this.f2379b = i2;
        this.f2380c = str;
        b();
        AppMethodBeat.o(174154);
    }

    @Override // com.tencent.tbs.one.TBSOneCallback
    public final void onProgressChanged(int i2, int i3) {
    }
}
