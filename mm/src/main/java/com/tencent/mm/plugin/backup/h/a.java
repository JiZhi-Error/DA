package com.tencent.mm.plugin.backup.h;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedList;

public final class a {
    public MMHandler handler = new MMHandler(Looper.getMainLooper());
    LinkedList<C0849a> oQt = new LinkedList<>();

    public a() {
        AppMethodBeat.i(21743);
        AppMethodBeat.o(21743);
    }

    public final void i(int i2, Object obj) {
        AppMethodBeat.i(21744);
        this.oQt.add(new C0849a(i2, obj));
        AppMethodBeat.o(21744);
    }

    /* renamed from: com.tencent.mm.plugin.backup.h.a$a  reason: collision with other inner class name */
    class C0849a {
        public Object obj;
        public int type;

        public C0849a(int i2, Object obj2) {
            this.type = i2;
            this.obj = obj2;
        }
    }
}
