package com.tencent.mm.plugin.collect.model.voice;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public b qxv;

    /* synthetic */ d(byte b2) {
        this();
    }

    private d() {
        AppMethodBeat.i(63892);
        this.qxv = new b();
        AppMethodBeat.o(63892);
    }

    public final int start(String str) {
        AppMethodBeat.i(63893);
        int start = this.qxv.start(str);
        AppMethodBeat.o(63893);
        return start;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        static d qxw = new d((byte) 0);

        static {
            AppMethodBeat.i(63891);
            AppMethodBeat.o(63891);
        }
    }
}
