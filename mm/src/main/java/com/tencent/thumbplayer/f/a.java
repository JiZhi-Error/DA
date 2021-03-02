package com.tencent.thumbplayer.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.g;

public final class a {
    public b RVM;
    private String mTag = this.RVM.tag;

    public a(b bVar) {
        AppMethodBeat.i(189267);
        this.RVM = bVar;
        AppMethodBeat.o(189267);
    }

    public a(b bVar, String str) {
        AppMethodBeat.i(189268);
        this.RVM = new b(bVar, str);
        AppMethodBeat.o(189268);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(189269);
        if (bVar == null) {
            this.RVM = new b(this.mTag);
            AppMethodBeat.o(189269);
            return;
        }
        this.RVM = bVar;
        AppMethodBeat.o(189269);
    }

    public final void r(Exception exc) {
        AppMethodBeat.i(189270);
        g.e(this.RVM.tag, exc);
        AppMethodBeat.o(189270);
    }

    public final void debug(String str) {
        AppMethodBeat.i(189271);
        g.d(this.RVM.tag, str);
        AppMethodBeat.o(189271);
    }

    public final void info(String str) {
        AppMethodBeat.i(189272);
        g.i(this.RVM.tag, str);
        AppMethodBeat.o(189272);
    }

    public final void warn(String str) {
        AppMethodBeat.i(189273);
        g.w(this.RVM.tag, str);
        AppMethodBeat.o(189273);
    }

    public final void error(String str) {
        AppMethodBeat.i(189274);
        g.e(this.RVM.tag, str);
        AppMethodBeat.o(189274);
    }
}
