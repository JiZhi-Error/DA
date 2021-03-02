package com.tencent.mm.plugin.appbrand.page.capsulebar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i;

public interface a {
    i.a a(b bVar);

    int bSu();

    public enum b {
        NORMAL(-1, -1),
        LBS(R.string.et2, R.drawable.bxg),
        VOICE(R.string.et3, R.drawable.bxi),
        nuS(-1, R.drawable.bxh),
        LOADING(-1, -1);
        
        final int nuU;
        final int nuV;

        public static b valueOf(String str) {
            AppMethodBeat.i(219464);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(219464);
            return bVar;
        }

        static {
            AppMethodBeat.i(219465);
            AppMethodBeat.o(219465);
        }

        private b(int i2, int i3) {
            this.nuU = i2;
            this.nuV = i3;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.capsulebar.a$a  reason: collision with other inner class name */
    public static class C0775a {
        private static final a nuO = new a() {
            /* class com.tencent.mm.plugin.appbrand.page.capsulebar.a.C0775a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.a
            public final i.a a(b bVar) {
                return i.nvz;
            }

            @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.a
            public final int bSu() {
                return Integer.MIN_VALUE;
            }
        };

        public static a ah(AppBrandRuntime appBrandRuntime) {
            AppMethodBeat.i(219460);
            if (appBrandRuntime == null || appBrandRuntime.isDestroyed() || appBrandRuntime.SO) {
                a aVar = nuO;
                AppMethodBeat.o(219460);
                return aVar;
            }
            a aVar2 = appBrandRuntime.kAx.nvl;
            AppMethodBeat.o(219460);
            return aVar2;
        }

        static {
            AppMethodBeat.i(219462);
            AppMethodBeat.o(219462);
        }

        public static a a(AppBrandRuntime appBrandRuntime, i.a aVar) {
            AppMethodBeat.i(219461);
            b bVar = new b(appBrandRuntime, aVar);
            AppMethodBeat.o(219461);
            return bVar;
        }
    }
}
