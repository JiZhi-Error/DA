package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.sdk.platformtools.Log;

@Deprecated
public interface o {

    public interface b {
        int eUf();

        void eUg();

        boolean eUh();

        void eUi();

        void eUj();

        boolean eUk();
    }

    public interface c {

        public interface a {
            String fVT();

            void fVU();

            boolean fVV();
        }
    }

    public static class e {
        public static c.a JSY;
    }

    public static class a {
        public static b JSX;

        public static b glW() {
            AppMethodBeat.i(30930);
            if (JSX == null) {
                Log.w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
                JSX = new com.tencent.mm.pluginsdk.a.c();
            }
            b bVar = JSX;
            AppMethodBeat.o(30930);
            return bVar;
        }

        public static com.tencent.mm.plugin.messenger.a.d eir() {
            AppMethodBeat.i(258863);
            com.tencent.mm.plugin.messenger.a.d eir = g.eir();
            AppMethodBeat.o(258863);
            return eir;
        }
    }

    public static class d {
        public static h glX() {
            return com.tencent.mm.plugin.sns.b.o.DCS;
        }
    }
}
