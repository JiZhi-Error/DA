package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberCore;", "", "()V", "sPhoneNumberLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "getSPhoneNumberLogic", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "setSPhoneNumberLogic", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;)V", "logic", "luggage-wechat-full-sdk_release"})
public final class u {
    private static n nAd;
    public static final u nAe = new u();

    static {
        AppMethodBeat.i(148122);
        AppMethodBeat.o(148122);
    }

    private u() {
    }

    public static void a(n nVar) {
        nAd = nVar;
    }

    public static n bTz() {
        AppMethodBeat.i(148121);
        if (nAd == null) {
            i iVar = new i();
            AppMethodBeat.o(148121);
            return iVar;
        }
        n nVar = nAd;
        if (nVar == null) {
            p.hyc();
        }
        AppMethodBeat.o(148121);
        return nVar;
    }
}
