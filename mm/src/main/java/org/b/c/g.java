package org.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.b.b.b;
import org.b.d.i;
import org.b.g.c;
import org.b.g.d;

public final class g implements a, f {
    private static final Pattern Uih = Pattern.compile("oauth_token=([^&]+)");
    private static final Pattern Uii = Pattern.compile("oauth_token_secret=([^&]*)");

    static {
        AppMethodBeat.i(40507);
        AppMethodBeat.o(40507);
    }

    @Override // org.b.c.f, org.b.c.a
    public final i bvu(String str) {
        AppMethodBeat.i(40508);
        d.oM(str, "Response body is incorrect. Can't extract a token from an empty string");
        i iVar = new i(g(str, Uih), g(str, Uii), str);
        AppMethodBeat.o(40508);
        return iVar;
    }

    private static String g(String str, Pattern pattern) {
        AppMethodBeat.i(40509);
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find() || matcher.groupCount() <= 0) {
            b bVar = new b("Response body is incorrect. Can't extract token and secret from this: '" + str + "'", null);
            AppMethodBeat.o(40509);
            throw bVar;
        }
        String decode = c.decode(matcher.group(1));
        AppMethodBeat.o(40509);
        return decode;
    }
}
