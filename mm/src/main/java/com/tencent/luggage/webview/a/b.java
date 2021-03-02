package com.tencent.luggage.webview.a;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

public final class b {
    private final LinkedList<Pair<c, Pattern>> cDB = new LinkedList<>();

    public b() {
        AppMethodBeat.i(140557);
        AppMethodBeat.o(140557);
    }

    public final void a(c cVar) {
        Pattern compile;
        AppMethodBeat.i(140558);
        String Pl = cVar.Pl();
        if (TextUtils.isEmpty(Pl)) {
            compile = null;
        } else {
            compile = Pattern.compile(Pl);
        }
        this.cDB.add(new Pair<>(cVar, compile));
        AppMethodBeat.o(140558);
    }

    public final WebResourceResponse dO(String str) {
        WebResourceResponse cX;
        AppMethodBeat.i(140559);
        Iterator<Pair<c, Pattern>> it = this.cDB.iterator();
        while (it.hasNext()) {
            Pair<c, Pattern> next = it.next();
            c cVar = (c) next.first;
            Pattern pattern = (Pattern) next.second;
            if (pattern != null && pattern.matcher(str).matches() && (cX = cVar.cX(str)) != null) {
                AppMethodBeat.o(140559);
                return cX;
            }
        }
        AppMethodBeat.o(140559);
        return null;
    }
}
