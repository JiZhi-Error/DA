package com.tencent.mm.contact.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.a.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import junit.framework.Assert;

public final class a {
    public static aq h(as asVar) {
        AppMethodBeat.i(257873);
        Assert.assertTrue(asVar != null);
        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        if (Kn == null || Util.isNullOrNil(Kn.field_username)) {
            Kn = asVar;
        }
        Kn.aqS();
        if (as.bjp(asVar.field_username)) {
            aq EA = ((r) g.af(r.class)).EA(asVar.field_username);
            AppMethodBeat.o(257873);
            return EA;
        }
        aq j2 = j(Kn);
        AppMethodBeat.o(257873);
        return j2;
    }

    public static aq i(final as asVar) {
        aq j2;
        AppMethodBeat.i(257874);
        Assert.assertTrue(asVar != null);
        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        if (Kn == null || Util.isNullOrNil(Kn.field_username)) {
            Kn = asVar;
        }
        Kn.aqT();
        if (as.bjp(asVar.field_username)) {
            j2 = ((r) g.af(r.class)).EB(asVar.field_username);
        } else {
            j2 = j(Kn);
        }
        if (j2 != null) {
            j2.a(new b() {
                /* class com.tencent.mm.contact.a.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.String, com.tencent.mm.model.t] */
                @Override // com.tencent.mm.model.t
                public final /* synthetic */ void a(int i2, String str, b bVar) {
                    AppMethodBeat.i(257872);
                    az bjY = ((l) g.af(l.class)).aST().bjY(asVar.field_username);
                    if (bjY != null && "@blacklist".equals(bjY.field_parentRef)) {
                        ((l) g.af(l.class)).aST().c(new String[]{bjY.field_username}, "");
                    }
                    AppMethodBeat.o(257872);
                }
            });
        }
        AppMethodBeat.o(257874);
        return j2;
    }

    private static aq j(as asVar) {
        boolean z;
        AppMethodBeat.i(257875);
        if (asVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (!as.bjp(asVar.field_username)) {
            aq k = k(asVar);
            AppMethodBeat.o(257875);
            return k;
        }
        AppMethodBeat.o(257875);
        return null;
    }

    private static aq k(as asVar) {
        AppMethodBeat.i(257876);
        b arN = com.tencent.mm.contact.a.a.a.arN();
        arN.a(new k.a(2, ab.H(asVar)));
        AppMethodBeat.o(257876);
        return arN;
    }

    public static void l(as asVar) {
        AppMethodBeat.i(257877);
        Assert.assertTrue(asVar != null);
        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        if (Kn != null && !Util.isNullOrNil(Kn.field_username)) {
            asVar = Kn;
        }
        asVar.aqS();
        n(asVar);
        AppMethodBeat.o(257877);
    }

    public static void m(as asVar) {
        AppMethodBeat.i(257878);
        Assert.assertTrue(asVar != null);
        as Kn = ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        if (Kn != null && !Util.isNullOrNil(Kn.field_username)) {
            asVar = Kn;
        }
        asVar.aqT();
        n(asVar);
        AppMethodBeat.o(257878);
    }

    private static void n(as asVar) {
        boolean z;
        AppMethodBeat.i(257879);
        if (asVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (((int) asVar.gMZ) == 0) {
            ((l) g.af(l.class)).aSN().aq(asVar);
            ((l) g.af(l.class)).aSN().Kn(asVar.field_username);
        }
        ((l) g.af(l.class)).aSN().c(asVar.field_username, asVar);
        AppMethodBeat.o(257879);
    }
}
