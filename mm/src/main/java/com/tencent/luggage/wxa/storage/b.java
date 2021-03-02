package com.tencent.luggage.wxa.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, hxF = {"Lcom/tencent/luggage/wxa/storage/CriticalAuthorityResolver;", "", "()V", "resolveAuthority", "", "data-storage_release"})
public final class b {
    public static final b cDF = new b();

    static {
        AppMethodBeat.i(146074);
        AppMethodBeat.o(146074);
    }

    private b() {
    }

    public static final String Pn() {
        AppMethodBeat.i(146073);
        StringBuilder sb = new StringBuilder();
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        String sb2 = sb.append(context.getPackageName()).append(".wxa_critical_content").toString();
        AppMethodBeat.o(146073);
        return sb2;
    }
}
