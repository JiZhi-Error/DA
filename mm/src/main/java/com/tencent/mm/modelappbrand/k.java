package com.tencent.mm.modelappbrand;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;

public interface k extends com.tencent.mm.kernel.c.a {

    public interface b {
        void sD(int i2);
    }

    public interface c {
        void aXL();

        void ft(boolean z);
    }

    View a(Context context, Bundle bundle, boolean z, c cVar);

    b.f a(int i2, int i3, a aVar);

    void a(String str, View view);

    boolean a(String str, View view, Bundle bundle);

    boolean a(String str, View view, Bundle bundle, b bVar);

    b.h aXK();

    /* renamed from: do  reason: not valid java name */
    b.f m10do(int i2, int i3);

    void g(int i2, Bundle bundle);

    public enum a {
        DECODE_TYPE_DEFAULT,
        DECODE_TYPE_ORIGIN;

        public static a valueOf(String str) {
            AppMethodBeat.i(2624);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(2624);
            return aVar;
        }

        static {
            AppMethodBeat.i(2625);
            AppMethodBeat.o(2625);
        }
    }
}
