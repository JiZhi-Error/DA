package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Timer;

final class n {
    final MultiContextV8 doQ;
    final IJSRuntime dqn;
    Timer dqo;
    final Runnable dqp = new Runnable() {
        /* class com.tencent.mm.appbrand.v8.n.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(144070);
            n.this.doQ.debuggerMessageLoop();
            AppMethodBeat.o(144070);
        }
    };

    public n(MultiContextV8 multiContextV8, IJSRuntime iJSRuntime) {
        AppMethodBeat.i(144072);
        this.doQ = multiContextV8;
        this.dqn = iJSRuntime;
        AppMethodBeat.o(144072);
    }
}
