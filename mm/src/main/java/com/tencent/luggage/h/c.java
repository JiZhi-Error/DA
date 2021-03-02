package com.tencent.luggage.h;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006\u001a\u001c\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006\u001a\u0016\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001f\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u000bH\u0007\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0000\u001a\u0004\b\u0003\u0010\u0000\u001a\u001f\u0010\f\u001a\u00020\n*\u0004\u0018\u00010\u000bH\u0007\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000e\u001a\u001c\u0010\u0011\u001a\u00020\n*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\n\u001a\u001c\u0010\u0014\u001a\u00020\n*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\n\u001a-\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u0002H\u00170\u0016j\b\u0012\u0004\u0012\u0002H\u0017`\u0018\"\u0004\b\u0000\u0010\u0017*\n\u0012\u0006\b\u0001\u0012\u0002H\u00170\u0019¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, hxF = {"removeUiRunnable", "", "task", "Ljava/lang/Runnable;", "uiThread", "block", "Lkotlin/Function0;", "delay", "", "isNotNull", "", "", "isNull", "optStringStrictly", "", "Lorg/json/JSONObject;", "name", "startsWithIgnoreCase", "prefix", "protocol", "startsWithIgnoreCaseAndBlank", "toArrayList", "Ljava/util/ArrayList;", "T", "Lkotlin/collections/ArrayList;", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "luggage-commons_release"})
public final class c {
    public static /* synthetic */ boolean A(String str, String str2) {
        AppMethodBeat.i(221358);
        boolean a2 = a(str, str2, true);
        AppMethodBeat.o(221358);
        return a2;
    }

    public static final boolean a(String str, String str2, boolean z) {
        AppMethodBeat.i(221357);
        p.h(str, "$this$startsWithIgnoreCase");
        p.h(str2, "prefix");
        if (n.aL(str2)) {
            AppMethodBeat.o(221357);
            return false;
        }
        if (!z) {
            if (URLUtil.isHttpUrl(str)) {
                str = str.substring(7);
                p.g(str, "(this as java.lang.String).substring(startIndex)");
            } else if (URLUtil.isHttpsUrl(str)) {
                str = str.substring(8);
                p.g(str, "(this as java.lang.String).substring(startIndex)");
            }
        }
        boolean C = l.C(str, str2);
        AppMethodBeat.o(221357);
        return C;
    }

    public static /* synthetic */ boolean B(String str, String str2) {
        AppMethodBeat.i(221359);
        p.h(str, "$this$startsWithIgnoreCaseAndBlank");
        p.h(str2, "prefix");
        boolean C = l.C(str, str2);
        AppMethodBeat.o(221359);
        return C;
    }
}
