package com.tencent.mm.plugin.expt.hellhound.a.h;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.d;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.e;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.t;

public final class a {
    private static final b sJA = new b();
    private static boolean sJB;
    public static final C1021a sJC = new C1021a((byte) 0);
    private static boolean sJz;

    /* renamed from: com.tencent.mm.plugin.expt.hellhound.a.h.a$a */
    public static final class C1021a {
        private C1021a() {
        }

        public /* synthetic */ C1021a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(169403);
        AppMethodBeat.o(169403);
    }

    public static final class b implements c {
        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            AppMethodBeat.i(184286);
            if (objArr == null) {
                AppMethodBeat.o(184286);
                return;
            }
            if (objArr.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(184286);
                return;
            }
            Object obj2 = objArr[0];
            if (obj2 == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(184286);
                throw tVar;
            }
            int intValue = ((Integer) obj2).intValue();
            C1021a aVar = a.sJC;
            if (10 == intValue) {
                z2 = true;
            } else {
                z2 = false;
            }
            a.sJz = z2;
            C1021a aVar2 = a.sJC;
            if (Integer.MAX_VALUE != intValue) {
                z3 = false;
            }
            a.sJB = z3;
            erd erd = new erd();
            erd.id = String.valueOf(intValue);
            erd.timestamp = System.currentTimeMillis();
            erd.NoL = erd.id;
            erd.typeName = "MMPopupWindow$PopupViewContainer";
            erd.NoM = "MMPopupWindow$PopupViewContainer";
            erd.eventId = d.SINGLE_CLICK.value;
            erd.type = 0;
            Log.i("HABBYGE-MALI.SubMenuMonitor", "SubMenuMonitor, viewCallback:\nid=" + erd.id + '\n' + "timestamp=" + erd.timestamp + '\n' + "eventId=" + erd.eventId);
            e eVar = e.sAU;
            e.a(erd);
            AppMethodBeat.o(184286);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    }

    public static final void startMonitor() {
        AppMethodBeat.i(169404);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create("processOnItemClick", "(II)V"));
        HashMap hashMap = new HashMap();
        hashMap.put("com/tencent/mm/ui/PlusSubMenuHelper", arrayList);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(hashMap, sJA);
        AppMethodBeat.o(169404);
    }
}
