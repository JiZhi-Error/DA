package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedList;

public final class a {
    MMHandler handler = new MMHandler(Looper.getMainLooper());
    public LinkedList<C0840a> oQt = new LinkedList<>();

    public a() {
        AppMethodBeat.i(22056);
        AppMethodBeat.o(22056);
    }

    public final boolean j(final int i2, final Object obj) {
        AppMethodBeat.i(22057);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.d.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(22054);
                a.this.oQt.add(new C0840a(i2, obj));
                AppMethodBeat.o(22054);
            }
        });
        AppMethodBeat.o(22057);
        return true;
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.a$a  reason: collision with other inner class name */
    public class C0840a {
        public Object obj;
        public int type;

        public C0840a(int i2, Object obj2) {
            this.type = i2;
            this.obj = obj2;
        }
    }
}
