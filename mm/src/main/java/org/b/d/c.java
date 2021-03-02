package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class c extends f {
    public Map<String, String> Uik = new HashMap();

    @Override // org.b.d.f
    public final /* bridge */ /* synthetic */ void addHeader(String str, String str2) {
        AppMethodBeat.i(40555);
        super.addHeader(str, str2);
        AppMethodBeat.o(40555);
    }

    @Override // org.b.d.f
    public final /* bridge */ /* synthetic */ String getUrl() {
        AppMethodBeat.i(260046);
        String url = super.getUrl();
        AppMethodBeat.o(260046);
        return url;
    }

    @Override // org.b.d.f
    public final /* bridge */ /* synthetic */ e hQb() {
        AppMethodBeat.i(40552);
        e hQb = super.hQb();
        AppMethodBeat.o(40552);
        return hQb;
    }

    @Override // org.b.d.f
    public final /* bridge */ /* synthetic */ j hQc() {
        AppMethodBeat.i(260047);
        j hQc = super.hQc();
        AppMethodBeat.o(260047);
        return hQc;
    }

    @Override // org.b.d.f
    public final /* bridge */ /* synthetic */ String hQd() {
        AppMethodBeat.i(40556);
        String hQd = super.hQd();
        AppMethodBeat.o(40556);
        return hQd;
    }

    @Override // org.b.d.f
    public final /* bridge */ /* synthetic */ String hQe() {
        AppMethodBeat.i(40557);
        String hQe = super.hQe();
        AppMethodBeat.o(40557);
        return hQe;
    }

    @Override // org.b.d.f
    public final /* bridge */ /* synthetic */ g hQf() {
        AppMethodBeat.i(40558);
        g hQf = super.hQf();
        AppMethodBeat.o(40558);
        return hQf;
    }

    @Override // org.b.d.f
    public final /* bridge */ /* synthetic */ e hQg() {
        AppMethodBeat.i(40559);
        e hQg = super.hQg();
        AppMethodBeat.o(40559);
        return hQg;
    }

    @Override // org.b.d.f
    public final /* bridge */ /* synthetic */ String hQh() {
        AppMethodBeat.i(40560);
        String hQh = super.hQh();
        AppMethodBeat.o(40560);
        return hQh;
    }

    @Override // org.b.d.f
    public final /* bridge */ /* synthetic */ void oL(String str, String str2) {
        AppMethodBeat.i(40554);
        super.oL(str, str2);
        AppMethodBeat.o(40554);
    }

    public c(j jVar, String str) {
        super(jVar, str);
        AppMethodBeat.i(40548);
        AppMethodBeat.o(40548);
    }

    public final void oK(String str, String str2) {
        AppMethodBeat.i(40549);
        Map<String, String> map = this.Uik;
        if (str.startsWith("oauth_") || str.equals("scope")) {
            map.put(str, str2);
            AppMethodBeat.o(40549);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("OAuth parameters must either be '%s' or start with '%s'", "scope", "oauth_"));
        AppMethodBeat.o(40549);
        throw illegalArgumentException;
    }

    @Override // org.b.d.f
    public final String toString() {
        AppMethodBeat.i(40550);
        String format = String.format("@OAuthRequest(%s, %s)", super.hQc(), super.getUrl());
        AppMethodBeat.o(40550);
        return format;
    }
}
