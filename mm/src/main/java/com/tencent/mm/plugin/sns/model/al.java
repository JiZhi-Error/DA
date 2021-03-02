package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class al implements e {
    HashMap<String, l> cache = new HashMap<>();

    public al() {
        AppMethodBeat.i(95848);
        AppMethodBeat.o(95848);
    }

    @Override // com.tencent.mm.plugin.sns.storage.e
    public final l aPj(String str) {
        AppMethodBeat.i(95849);
        l lVar = this.cache.get(str);
        AppMethodBeat.o(95849);
        return lVar;
    }

    @Override // com.tencent.mm.plugin.sns.storage.e
    public final boolean fbm() {
        AppMethodBeat.i(95850);
        aj.eJP().post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.al.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(95845);
                if (al.this.cache.size() > 50) {
                    al.a(al.this, 10);
                }
                AppMethodBeat.o(95845);
            }
        });
        AppMethodBeat.o(95850);
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.storage.e
    public final boolean fbn() {
        AppMethodBeat.i(95851);
        aj.eJP().post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.al.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(95846);
                al.a(al.this, al.this.cache.size());
                AppMethodBeat.o(95846);
            }
        });
        AppMethodBeat.o(95851);
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.storage.e
    public final boolean a(final l lVar) {
        AppMethodBeat.i(95852);
        if (lVar == null || Util.isNullOrNil(lVar.field_userName)) {
            AppMethodBeat.o(95852);
            return false;
        }
        aj.eJP().post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.al.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(95847);
                al.this.cache.put(lVar.field_userName, lVar);
                AppMethodBeat.o(95847);
            }
        });
        AppMethodBeat.o(95852);
        return true;
    }

    static /* synthetic */ void a(al alVar, int i2) {
        long j2;
        AppMethodBeat.i(95853);
        if (alVar.cache == null || alVar.cache.size() == 0) {
            Log.i("MicroMsg.SnsExtCache", "nothing need to pushto snsext");
            AppMethodBeat.o(95853);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        if (aj.getDataDB() != null) {
            z = true;
            j2 = aj.getDataDB().beginTransaction(Thread.currentThread().getId());
        } else {
            j2 = 0;
        }
        Log.d("MicroMsg.SnsExtCache", "writeNums " + i2 + " " + j2);
        LinkedList linkedList = new LinkedList();
        for (String str : alVar.cache.keySet()) {
            linkedList.add(str);
            if (linkedList.size() >= i2) {
                break;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (alVar.cache.containsKey(str2) && !aj.isInValid()) {
                aj.faS().b(alVar.cache.get(str2));
                alVar.cache.remove(str2);
            }
        }
        if (z) {
            aj.getDataDB().endTransaction(j2);
        }
        Log.d("MicroMsg.SnsExtCache", "wirtes times : " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(95853);
    }
}
