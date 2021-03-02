package org.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.b.d.i;

public class c extends b {
    @Override // org.b.a.a.b
    public String hPZ() {
        return "http://api.twitter.com/oauth/access_token";
    }

    @Override // org.b.a.a.b
    public String hPY() {
        return "http://api.twitter.com/oauth/request_token";
    }

    @Override // org.b.a.a.b
    public final String b(i iVar) {
        AppMethodBeat.i(40503);
        String format = String.format("https://api.twitter.com/oauth/authorize?oauth_token=%s", iVar.token);
        AppMethodBeat.o(40503);
        return format;
    }

    public static class a extends c {
        @Override // org.b.a.a.c, org.b.a.a.b
        public final String hPZ() {
            return "https://api.twitter.com/oauth/access_token";
        }

        @Override // org.b.a.a.c, org.b.a.a.b
        public final String hPY() {
            return "https://api.twitter.com/oauth/request_token";
        }
    }
}
