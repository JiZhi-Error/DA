package com.tencent.mm.plugin.appbrand.config;

import android.content.Context;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/MiniProgramUserAgentUtils;", "", "()V", "make", "", "context", "Landroid/content/Context;", "originalUserAgent", "luggage-wechat-full-sdk_release"})
public final class s {
    public static final s lfH = new s();

    static {
        AppMethodBeat.i(230056);
        AppMethodBeat.o(230056);
    }

    private s() {
    }

    public static final String aa(Context context, String str) {
        AppMethodBeat.i(230055);
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        if (str == null) {
            str = "";
        }
        String a2 = p.a(context, str, (p.a) e.M(p.a.class));
        kotlin.g.b.p.g(a2, "ua");
        if (!n.a((CharSequence) a2, (CharSequence) "MiniProgramEnv/android", false)) {
            a2 = a2 + " MiniProgramEnv/android";
        }
        kotlin.g.b.p.g(a2, "ua");
        AppMethodBeat.o(230055);
        return a2;
    }
}
