package com.tencent.mm.plugin.expt.hellhound.a.f.g.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.t;

public final class a {
    private static boolean sJa;
    private static boolean sJb;
    private static boolean sJc;
    private static final b sJd = new b();
    public static final C1020a sJe = new C1020a((byte) 0);

    /* renamed from: com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a$a */
    public static final class C1020a {
        private C1020a() {
        }

        public /* synthetic */ C1020a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(177420);
        AppMethodBeat.o(177420);
    }

    public static final class b implements c {
        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            Class<?> cls;
            AppMethodBeat.i(184285);
            if (objArr == null) {
                AppMethodBeat.o(184285);
            } else if (objArr.length < 2) {
                AppMethodBeat.o(184285);
            } else {
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEl = false;
                Object obj2 = objArr[1];
                if (obj2 == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.Preference");
                    AppMethodBeat.o(184285);
                    throw tVar;
                }
                Preference preference = (Preference) obj2;
                C1020a aVar = a.sJe;
                a.sJa = p.j("jd_market_entrance", preference.getKey());
                C1020a aVar2 = a.sJe;
                a.sJb = p.j("find_friends_by_qrcode", preference.getKey());
                C1020a aVar3 = a.sJe;
                a.sJc = p.j("find_friends_by_finder", preference.getKey());
                C1020a aVar4 = a.sJe;
                if (a.sJc) {
                    Log.i("HABBYGE-MALI.FindMoreFriendUIMonitor", "Finder, 19354, 1");
                    e.INSTANCE.a(19354, 1);
                }
                String key = preference.getKey();
                p.g(key, "pref.key");
                erd erd = new erd();
                erd.id = key;
                erd.timestamp = System.currentTimeMillis();
                erd.NoL = key;
                erd.dMl = com.tencent.mm.plugin.expt.hellhound.core.b.aoE((obj == null || (cls = obj.getClass()) == null) ? null : cls.getName());
                erd.NoN = obj != null ? obj.hashCode() : -1;
                erd.NoM = erd.dMl;
                erd.eventId = d.SINGLE_CLICK.value;
                erd.typeName = erd.dMl;
                erd.type = 0;
                com.tencent.mm.plugin.expt.hellhound.core.b.c.e eVar = com.tencent.mm.plugin.expt.hellhound.core.b.c.e.sAU;
                com.tencent.mm.plugin.expt.hellhound.core.b.c.e.a(erd);
                AppMethodBeat.o(184285);
            }
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    }

    public static final void startMonitor() {
        AppMethodBeat.i(177421);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create("onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z"));
        HashMap hashMap = new HashMap();
        hashMap.put("com/tencent/mm/ui/AbstractTabChildPreference", arrayList);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(hashMap, sJd);
        AppMethodBeat.o(177421);
    }
}
