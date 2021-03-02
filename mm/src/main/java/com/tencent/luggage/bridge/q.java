package com.tencent.luggage.bridge;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* access modifiers changed from: package-private */
public final class q implements p {
    private static final Pattern csP = Pattern.compile("^<<//([a-z]{0,10})//>>");
    private o csD;

    static {
        AppMethodBeat.i(140345);
        AppMethodBeat.o(140345);
    }

    q(o oVar) {
        this.csD = oVar;
    }

    @Override // com.tencent.luggage.bridge.p
    public final void onReady() {
        AppMethodBeat.i(140343);
        this.csD.La();
        AppMethodBeat.o(140343);
    }

    @Override // com.tencent.luggage.bridge.p
    public final String cO(String str) {
        String str2;
        AppMethodBeat.i(140344);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(140344);
            return null;
        }
        Matcher matcher = csP.matcher(str);
        if (matcher.find()) {
            str2 = matcher.group(1);
        } else {
            str2 = null;
        }
        if (str2 == null) {
            AppMethodBeat.o(140344);
            return null;
        }
        String i2 = this.csD.csI.i(str.replaceFirst("^<<//([a-z]{0,10})//>>", ""), str2.equals("sync"));
        AppMethodBeat.o(140344);
        return i2;
    }
}
