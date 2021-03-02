package org.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.b.a.a.b;
import org.b.c.e;
import org.b.d.c;
import org.b.d.g;
import org.b.d.h;
import org.b.d.i;
import org.b.d.j;
import org.b.d.k;
import org.b.f.d;

public final class a implements b {
    private static /* synthetic */ int[] UiI;
    private org.b.d.a UiG;
    private b UiH;

    private static /* synthetic */ int[] hQm() {
        AppMethodBeat.i(40568);
        int[] iArr = UiI;
        if (iArr != null) {
            AppMethodBeat.o(40568);
        } else {
            iArr = new int[h.values().length];
            try {
                iArr[h.Header.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[h.QueryString.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            UiI = iArr;
            AppMethodBeat.o(40568);
        }
        return iArr;
    }

    public a(b bVar, org.b.d.a aVar) {
        this.UiH = bVar;
        this.UiG = aVar;
    }

    @Override // org.b.e.b
    public final i hQl() {
        AppMethodBeat.i(40561);
        this.UiG.log("obtaining request token from " + this.UiH.hPY());
        c cVar = new c(j.POST, this.UiH.hPY());
        this.UiG.log("setting oauth_callback to " + this.UiG.Uid);
        cVar.oK("oauth_callback", this.UiG.Uid);
        a(cVar, org.b.d.b.Uij);
        b(cVar);
        this.UiG.log("sending request...");
        g hQf = cVar.hQf();
        String body = hQf.getBody();
        this.UiG.log("response status code: " + hQf.code);
        this.UiG.log("response body: ".concat(String.valueOf(body)));
        i bvu = new org.b.c.g().bvu(body);
        AppMethodBeat.o(40561);
        return bvu;
    }

    private void a(c cVar, i iVar) {
        AppMethodBeat.i(40562);
        cVar.oK("oauth_timestamp", new d().hQo());
        cVar.oK("oauth_nonce", new d().getNonce());
        cVar.oK("oauth_consumer_key", this.UiG.Uib);
        cVar.oK("oauth_signature_method", new org.b.f.a().hQn());
        cVar.oK("oauth_version", "1.0");
        if (this.UiG.hQa()) {
            cVar.oK("scope", this.UiG.scope);
        }
        cVar.oK("oauth_signature", b(cVar, iVar));
        this.UiG.log("appended additional OAuth parameters: " + org.b.g.b.M(cVar.Uik));
        AppMethodBeat.o(40562);
    }

    @Override // org.b.e.b
    public final i a(i iVar, k kVar) {
        AppMethodBeat.i(40563);
        this.UiG.log("obtaining access token from " + this.UiH.hPZ());
        c cVar = new c(j.POST, this.UiH.hPZ());
        cVar.oK("oauth_token", iVar.token);
        cVar.oK("oauth_verifier", kVar.value);
        this.UiG.log("setting token to: " + iVar + " and verifier to: " + kVar);
        a(cVar, iVar);
        b(cVar);
        i bvu = new org.b.c.g().bvu(cVar.hQf().getBody());
        AppMethodBeat.o(40563);
        return bvu;
    }

    @Override // org.b.e.b
    public final void a(i iVar, c cVar) {
        boolean z;
        AppMethodBeat.i(40564);
        this.UiG.log("signing request: " + cVar.hQd());
        if (!"".equals(iVar.token) || !"".equals(iVar.Mte)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            cVar.oK("oauth_token", iVar.token);
        }
        this.UiG.log("setting token to: ".concat(String.valueOf(iVar)));
        a(cVar, iVar);
        b(cVar);
        AppMethodBeat.o(40564);
    }

    @Override // org.b.e.b
    public final String b(i iVar) {
        AppMethodBeat.i(40565);
        String b2 = this.UiH.b(iVar);
        AppMethodBeat.o(40565);
        return b2;
    }

    private String b(c cVar, i iVar) {
        AppMethodBeat.i(40566);
        this.UiG.log("generating signature...");
        String a2 = new org.b.c.c().a(cVar);
        String bD = new org.b.f.a().bD(a2, this.UiG.Uic, iVar.Mte);
        this.UiG.log("base string is: ".concat(String.valueOf(a2)));
        this.UiG.log("signature is: ".concat(String.valueOf(bD)));
        AppMethodBeat.o(40566);
        return bD;
    }

    private void b(c cVar) {
        AppMethodBeat.i(40567);
        switch (hQm()[this.UiG.Uif.ordinal()]) {
            case 1:
                this.UiG.log("using Http Header signature");
                cVar.addHeader("Authorization", new e().a(cVar));
                AppMethodBeat.o(40567);
                return;
            case 2:
                this.UiG.log("using Querystring signature");
                for (Map.Entry<String, String> entry : cVar.Uik.entrySet()) {
                    cVar.oL(entry.getKey(), entry.getValue());
                }
                break;
        }
        AppMethodBeat.o(40567);
    }
}
