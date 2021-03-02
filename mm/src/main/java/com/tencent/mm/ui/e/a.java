package com.tencent.mm.ui.e;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    static android.arch.a.c.a<Context, Resources> PRK = new android.arch.a.c.a<Context, Resources>() {
        /* class com.tencent.mm.ui.e.a.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.a.c.a
        public final /* synthetic */ Resources apply(Context context) {
            AppMethodBeat.i(198211);
            Resources resources = context.getResources();
            AppMethodBeat.o(198211);
            return resources;
        }
    };
    static android.arch.a.c.a<String, String> PRL = new android.arch.a.c.a<String, String>() {
        /* class com.tencent.mm.ui.e.a.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.a.c.a
        public final /* bridge */ /* synthetic */ String apply(String str) {
            return str;
        }
    };

    static {
        AppMethodBeat.i(198213);
        AppMethodBeat.o(198213);
    }

    public static void b(android.arch.a.c.a<Context, Resources> aVar) {
        PRK = aVar;
    }

    public static Resources kn(Context context) {
        AppMethodBeat.i(198212);
        Resources apply = PRK.apply(context);
        AppMethodBeat.o(198212);
        return apply;
    }

    public static void c(android.arch.a.c.a<String, String> aVar) {
        PRL = aVar;
    }
}
