package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.q;

public interface aa {

    public enum b implements com.tencent.mm.plugin.appbrand.appstorage.a.a {
        INSTANCE;

        public static b valueOf(String str) {
            AppMethodBeat.i(44460);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(44460);
            return bVar;
        }

        static {
            AppMethodBeat.i(44462);
            AppMethodBeat.o(44462);
        }

        @Override // com.tencent.mm.plugin.appbrand.appstorage.a.a
        public final int Wp(String str) {
            AppMethodBeat.i(44461);
            g.aAf();
            int uin = com.tencent.mm.kernel.a.getUin();
            AppMethodBeat.o(44461);
            return uin;
        }
    }

    public enum a implements com.tencent.mm.plugin.appbrand.appstorage.a.a {
        INSTANCE;

        public static a valueOf(String str) {
            AppMethodBeat.i(44456);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(44456);
            return aVar;
        }

        static {
            AppMethodBeat.i(44458);
            AppMethodBeat.o(44458);
        }

        @Override // com.tencent.mm.plugin.appbrand.appstorage.a.a
        public final int Wp(String str) {
            AppMethodBeat.i(44457);
            q TQ = com.tencent.mm.plugin.appbrand.a.TQ(str);
            if (TQ == null || TQ.bsC() == null) {
                AppMethodBeat.o(44457);
                return 0;
            }
            int i2 = TQ.bsC().uin;
            AppMethodBeat.o(44457);
            return i2;
        }
    }
}
