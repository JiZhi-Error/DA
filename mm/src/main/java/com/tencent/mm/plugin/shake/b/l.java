package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.c.a.e;
import com.tencent.mm.plugin.shake.c.a.g;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.plugin.shake.d.a.j;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.List;

public final class l {
    protected static long DgT = 16000;
    protected static int DgU = 54158;
    public int DgV;
    public b DgW;

    public interface a {
        void a(int i2, e eVar, long j2);

        void f(List<d> list, long j2);
    }

    public final b a(Context context, int i2, a aVar) {
        AppMethodBeat.i(28148);
        if (i2 == this.DgV) {
            b bVar = this.DgW;
            AppMethodBeat.o(28148);
            return bVar;
        }
        if (this.DgW != null) {
            this.DgW.eTQ();
        }
        switch (i2) {
            case 1:
                this.DgW = new c(context, aVar);
                break;
            case 3:
                this.DgW = j.a(aVar);
                break;
            case 4:
                this.DgW = new com.tencent.mm.plugin.shake.d.a.l(context, aVar);
                break;
            case 5:
                this.DgW = new h(aVar);
                break;
            case 6:
                this.DgW = new g(aVar);
                break;
        }
        this.DgV = i2;
        this.DgW.init();
        b bVar2 = this.DgW;
        AppMethodBeat.o(28148);
        return bVar2;
    }

    public static abstract class b {
        public a DgX;
        protected boolean DgY = false;
        protected long DgZ = l.DgT;
        private MMHandler Dha = new MMHandler(new MMHandler.Callback() {
            /* class com.tencent.mm.plugin.shake.b.l.b.AnonymousClass1 */

            public final boolean handleMessage(Message message) {
                AppMethodBeat.i(28147);
                if (message.what == l.DgU && !b.this.DgY && b.this.DgX != null) {
                    b.this.DgX.f(null, 5);
                }
                AppMethodBeat.o(28147);
                return false;
            }
        });

        public abstract void init();

        public abstract void pause();

        public abstract void reset();

        public abstract void resume();

        public abstract void start();

        public b(a aVar) {
            this.DgX = aVar;
        }

        public void eTQ() {
            reset();
            this.DgX = null;
        }
    }
}
