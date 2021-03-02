package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;

@e(c.class)
public interface l extends com.tencent.mm.kernel.c.a {

    public interface a {
        LocalUsageInfo bRO();
    }

    AppBrandRecentView a(Context context, b bVar, a aVar);

    void ccV();

    g ccW();

    public enum b {
        TYPE_MENU,
        TYPE_CONVERSATION;

        public static b valueOf(String str) {
            AppMethodBeat.i(194399);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(194399);
            return bVar;
        }

        static {
            AppMethodBeat.i(194400);
            AppMethodBeat.o(194400);
        }
    }
}
