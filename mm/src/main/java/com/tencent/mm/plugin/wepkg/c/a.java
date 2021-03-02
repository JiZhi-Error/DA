package com.tencent.mm.plugin.wepkg.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private Map<String, b> JNZ;

    /* synthetic */ a(byte b2) {
        this();
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.c.a$a  reason: collision with other inner class name */
    public static class C2009a {
        private static a JOa = new a((byte) 0);

        static {
            AppMethodBeat.i(110764);
            AppMethodBeat.o(110764);
        }
    }

    private a() {
        AppMethodBeat.i(110765);
        this.JNZ = new ConcurrentHashMap();
        AppMethodBeat.o(110765);
    }

    public class b {
        int JOb;
        long jqG;

        public b() {
        }
    }

    public final void x(Set<String> set) {
        AppMethodBeat.i(110766);
        if (set.isEmpty()) {
            h.INSTANCE.idkeyStat(859, 20, 1, false);
            AppMethodBeat.o(110766);
            return;
        }
        h.INSTANCE.idkeyStat(859, 21, 1, false);
        b bVar = new b();
        bVar.JOb = set.size();
        bVar.jqG = 0;
        for (String str : set) {
            this.JNZ.put(str, bVar);
        }
        AppMethodBeat.o(110766);
    }

    public final void q(String str, String str2, long j2) {
        AppMethodBeat.i(110767);
        b remove = this.JNZ.remove(MD5Util.getMD5String(str + str2));
        if (remove != null) {
            remove.JOb--;
            remove.jqG += j2;
            if (remove.JOb == 0) {
                Log.i("MicroMsg.Wepkg.BatchUpdateReporter", "batch update size: %s", Long.valueOf(remove.jqG));
                com.tencent.mm.game.report.api.a.hhr.a(1, "", String.valueOf(remove.jqG), 0);
            }
        }
        AppMethodBeat.o(110767);
    }
}
