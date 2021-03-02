package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class b {
    private static b nee = new b() {
        /* class com.tencent.mm.plugin.appbrand.media.record.a.b.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.media.record.a.b
        public final d acK(String str) {
            AppMethodBeat.i(146341);
            Log.i("MicroMsg.Record.AudioEncodeFactory", "createEncodeByType:%s", str);
            if (!h.acH(str)) {
                AppMethodBeat.o(146341);
                return null;
            } else if ("aac".equalsIgnoreCase(str)) {
                a aVar = new a();
                AppMethodBeat.o(146341);
                return aVar;
            } else if ("mp3".equalsIgnoreCase(str)) {
                e eVar = new e();
                AppMethodBeat.o(146341);
                return eVar;
            } else if ("wav".equalsIgnoreCase(str)) {
                g gVar = new g();
                AppMethodBeat.o(146341);
                return gVar;
            } else if ("pcm".equalsIgnoreCase(str)) {
                f fVar = new f();
                AppMethodBeat.o(146341);
                return fVar;
            } else {
                AppMethodBeat.o(146341);
                return null;
            }
        }
    };

    public abstract d acK(String str);

    public static d acL(String str) {
        return nee.acK(str);
    }
}
