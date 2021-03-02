package com.tencent.mm.plugin.sns.ad.timeline.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.b;

public final class a {
    public static c d(int i2, Context context) {
        AppMethodBeat.i(202069);
        if (i2 == 1) {
            try {
                com.tencent.mm.plugin.sns.ad.timeline.a.b.a aVar = new com.tencent.mm.plugin.sns.ad.timeline.a.b.a(context);
                AppMethodBeat.o(202069);
                return aVar;
            } catch (Throwable th) {
            }
        } else if (i2 == 3) {
            b bVar = new b(context);
            AppMethodBeat.o(202069);
            return bVar;
        } else if (i2 == 4) {
            com.tencent.mm.plugin.sns.ad.timeline.a.c.b bVar2 = new com.tencent.mm.plugin.sns.ad.timeline.a.c.b(context);
            AppMethodBeat.o(202069);
            return bVar2;
        } else {
            if (i2 == 5) {
                com.tencent.mm.plugin.sns.ad.timeline.a.d.b bVar3 = new com.tencent.mm.plugin.sns.ad.timeline.a.d.b(context);
                AppMethodBeat.o(202069);
                return bVar3;
            }
            AppMethodBeat.o(202069);
            return null;
        }
    }
}
