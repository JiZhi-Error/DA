package com.tencent.mm.plugin.finder.newxml;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.Map;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/newxml/FinderReInitSysMsgConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "", "values", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-finder_release"})
public final class a implements p {
    public static final C1251a uTN = new C1251a((byte) 0);

    static {
        AppMethodBeat.i(249499);
        AppMethodBeat.o(249499);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/newxml/FinderReInitSysMsgConsumer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.newxml.a$a  reason: collision with other inner class name */
    public static final class C1251a {
        private C1251a() {
        }

        public /* synthetic */ C1251a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        boolean z;
        AppMethodBeat.i(249498);
        kotlin.g.b.p.h(map, "values");
        kotlin.g.b.p.h(aVar, "p2");
        if (kotlin.g.b.p.j(str, "finderuserreinit")) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1279, 25, 1);
            e aAh = g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_VERSION_INT_SYNC, 0);
            int safeParseInt = Util.safeParseInt(map.get(".sysmsg.userver"));
            String str2 = map.get(".sysmsg.username");
            int safeParseInt2 = Util.safeParseInt(map.get(".sysmsg.usertype"));
            if (safeParseInt2 == 1) {
                if (kotlin.g.b.p.j(z.aUg(), str2)) {
                    z = true;
                }
                z = false;
            } else {
                if (safeParseInt2 == 2 && kotlin.g.b.p.j(z.aTY(), str2)) {
                    z = true;
                }
                z = false;
            }
            Log.i("Finder.ReInitSysMsgConsumer", "[consumeNewXml] subType=" + str + " userVersion=" + safeParseInt + " curUserVersion=" + i2 + " username=" + str2 + " userType=" + safeParseInt2 + " isValid=" + z);
            if (z) {
                if (safeParseInt2 == 1) {
                    e aAh2 = g.aAh();
                    kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
                    aAh2.azQ().set(ar.a.USERINFO_MY_FINDER_REINIT_USERNAME_STRING_SYNC, "");
                    e aAh3 = g.aAh();
                    kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
                    aAh3.azQ().set(ar.a.USERINFO_FINDER_REINIT_USER_VERSION_INT_SYNC, (Object) 0);
                } else {
                    e aAh4 = g.aAh();
                    kotlin.g.b.p.g(aAh4, "MMKernel.storage()");
                    aAh4.azQ().set(ar.a.USERINFO_MY_FINDER_REINIT_USERNAME_STRING_SYNC, str2);
                    e aAh5 = g.aAh();
                    kotlin.g.b.p.g(aAh5, "MMKernel.storage()");
                    aAh5.azQ().set(ar.a.USERINFO_FINDER_REINIT_USER_VERSION_INT_SYNC, Integer.valueOf(safeParseInt));
                }
                e aAh6 = g.aAh();
                kotlin.g.b.p.g(aAh6, "MMKernel.storage()");
                aAh6.azQ().set(ar.a.USERINFO_FINDER_USER_HARD_REINIT_INT_SYNC, (Object) 1);
            }
        }
        AppMethodBeat.o(249498);
        return null;
    }
}
