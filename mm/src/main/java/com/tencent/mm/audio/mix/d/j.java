package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class j implements Comparable<j>, Runnable {
    private static int dvQ = 1000;
    protected long addTime;
    protected String name = "";
    protected final int priority;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(j jVar) {
        AppMethodBeat.i(136831);
        j jVar2 = jVar;
        int abs = (int) (Math.abs(System.currentTimeMillis() - this.addTime) / ((long) dvQ));
        int i2 = this.priority;
        if (abs > 0) {
            i2 += abs;
        }
        int i3 = jVar2.priority - i2;
        AppMethodBeat.o(136831);
        return i3;
    }

    public j(String str) {
        AppMethodBeat.i(136829);
        this.name = str;
        this.addTime = System.currentTimeMillis();
        this.priority = 5;
        AppMethodBeat.o(136829);
    }

    public void run() {
        AppMethodBeat.i(136830);
        AppMethodBeat.o(136830);
    }

    public void reset() {
    }
}
