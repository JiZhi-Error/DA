package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.d;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.regex.Matcher;

public final class b {
    public static ArrayList<u> cn(Context context, String str) {
        AppMethodBeat.i(152259);
        ArrayList<u> arrayList = new ArrayList<>();
        Matcher matcher = k.a.KqO.matcher(str);
        while (matcher.find()) {
            u a2 = a(context, matcher.group(), matcher.start(), matcher.end());
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        AppMethodBeat.o(152259);
        return arrayList;
    }

    public static u a(Context context, String str, int i2, int i3) {
        AppMethodBeat.i(152260);
        u a2 = a(context, str, i2, i3, 0, 0);
        AppMethodBeat.o(152260);
        return a2;
    }

    public static u a(Context context, String str, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(152261);
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        u w = d.a.KqD.w(context, str);
        if (w != null) {
            w.start = i2;
            w.end = i3;
            w.linkColor = i4;
            w.backgroundColor = i5;
        }
        AppMethodBeat.o(152261);
        return w;
    }
}
