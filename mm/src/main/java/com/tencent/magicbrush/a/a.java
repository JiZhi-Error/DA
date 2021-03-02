package com.tencent.magicbrush.a;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static AbstractC0192a cMC = new AbstractC0192a() {
        /* class com.tencent.magicbrush.a.a.AnonymousClass1 */

        @Override // com.tencent.magicbrush.a.a.AbstractC0192a
        public final int q(String str, int i2) {
            return 0;
        }

        @Override // com.tencent.magicbrush.a.a.AbstractC0192a
        public final Drawable r(String str, int i2) {
            return null;
        }
    };

    /* renamed from: com.tencent.magicbrush.a.a$a  reason: collision with other inner class name */
    public interface AbstractC0192a {
        int q(String str, int i2);

        Drawable r(String str, int i2);
    }

    static {
        AppMethodBeat.i(139954);
        AppMethodBeat.o(139954);
    }

    public static void a(AbstractC0192a aVar) {
        cMC = aVar;
    }

    public static AbstractC0192a Rt() {
        return cMC;
    }
}
