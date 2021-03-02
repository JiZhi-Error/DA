package com.tencent.mm.plugin.finder.utils.fake;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.fake.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftCmd;", "", "()V", "TAG", "", "sendGift", "", "intent", "Landroid/content/Intent;", "plugin-finder_release"})
public final class a {
    private static final String TAG = TAG;
    public static final a waF = new a();

    static {
        AppMethodBeat.i(253826);
        AppMethodBeat.o(253826);
    }

    private a() {
    }

    public static void as(Intent intent) {
        c.d dVar;
        e eVar;
        AppMethodBeat.i(253825);
        p.h(intent, "intent");
        String stringExtra = intent.getStringExtra("gift_id");
        int mZ = j.mZ(Util.safeParseInt(intent.getStringExtra("count")), 1);
        long safeParseLong = Util.safeParseLong(intent.getStringExtra("delay"));
        boolean z = Util.safeParseInt(intent.getStringExtra("isSelf")) == 1;
        String stringExtra2 = intent.getStringExtra("comboId");
        Log.i(TAG, "gift_id " + stringExtra + " count " + mZ + " delay: " + safeParseLong + " isSelf:" + z + " comboId:" + stringExtra2);
        e eVar2 = e.LOVE;
        c cVar = c.waP;
        e eVar3 = eVar2;
        for (Map.Entry<e, c.b> entry : c.dEJ().entrySet()) {
            if (p.j(entry.getValue().upZ, stringExtra)) {
                eVar = entry.getKey();
            } else {
                eVar = eVar3;
            }
            eVar3 = eVar;
        }
        LinkedList linkedList = new LinkedList();
        c cVar2 = c.waP;
        c.AbstractC1316c cVar3 = c.dEK().get(eVar3);
        if (cVar3 != null) {
            dVar = cVar3.Ma(mZ);
            dVar.waU = safeParseLong;
        } else {
            dVar = null;
        }
        if (z && dVar != null) {
            dVar.dEL();
        }
        if (!Util.isNullOrNil(stringExtra2) && dVar != null) {
            p.g(stringExtra2, "comboId");
            dVar.awF(stringExtra2);
        }
        linkedList.offerLast(dVar);
        c cVar4 = c.waP;
        c.eD(linkedList);
        AppMethodBeat.o(253825);
    }
}
