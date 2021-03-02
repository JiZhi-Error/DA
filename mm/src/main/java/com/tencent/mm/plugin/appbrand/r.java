package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import java.util.HashSet;
import java.util.Set;

public interface r {
    q b(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandRuntimeContainerWC appBrandRuntimeContainerWC);

    public static class a {
        private static final Set<r> kDY = new HashSet();

        static {
            AppMethodBeat.i(43958);
            AppMethodBeat.o(43958);
        }

        public static void a(r rVar) {
            AppMethodBeat.i(43956);
            if (rVar != null) {
                synchronized (kDY) {
                    try {
                        kDY.add(rVar);
                    } finally {
                        AppMethodBeat.o(43956);
                    }
                }
                return;
            }
            AppMethodBeat.o(43956);
        }

        static Set<r> bsU() {
            HashSet hashSet;
            AppMethodBeat.i(43957);
            synchronized (kDY) {
                try {
                    hashSet = new HashSet(kDY);
                } finally {
                    AppMethodBeat.o(43957);
                }
            }
            return hashSet;
        }
    }
}
