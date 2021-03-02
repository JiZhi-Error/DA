package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.app.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class c extends com.tencent.mm.vending.app.a {
    static /* synthetic */ a a(c cVar) {
        AppMethodBeat.i(63442);
        a bmo = cVar.bmo();
        AppMethodBeat.o(63442);
        return bmo;
    }

    @Override // com.tencent.mm.vending.app.a
    public final void onCreate() {
        AppMethodBeat.i(63440);
        super.onCreate();
        a(a.class, new a.AbstractC2149a<a>() {
            /* class com.tencent.mm.plugin.aa.model.b.c.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.vending.app.a.AbstractC2149a
            public final /* synthetic */ a bmp() {
                AppMethodBeat.i(63438);
                a a2 = c.a(c.this);
                AppMethodBeat.o(63438);
                return a2;
            }
        });
        AppMethodBeat.o(63440);
    }

    public class a {
        public List<String> gMT;
        public HashMap<String, Double> jTW = new HashMap<>();

        public a() {
            AppMethodBeat.i(63439);
            AppMethodBeat.o(63439);
        }
    }

    private a bmo() {
        AppMethodBeat.i(63441);
        int intExtra = this.QYU.getIntExtra("enter_scene", 1);
        ArrayList<String> stringArrayListExtra = this.QYU.getStringArrayListExtra("oldAmountData");
        Log.i("MicroMsg.LaunchAAByPersonAmountSelectInteractor", "getSelectMembers scene:%s oldDataList: %s", Integer.valueOf(intExtra), stringArrayListExtra);
        a aVar = new a();
        if (stringArrayListExtra != null) {
            try {
                if (stringArrayListExtra.size() > 0) {
                    Iterator<String> it = stringArrayListExtra.iterator();
                    while (it.hasNext()) {
                        String[] split = it.next().split(",");
                        if (split != null && split.length == 2) {
                            aVar.jTW.put(split[0], Double.valueOf(Util.getDouble(split[1], 0.0d)));
                        }
                    }
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.LaunchAAByPersonAmountSelectInteractor", "getSelectMembers parse old data error: %s", e2.getMessage());
            }
        }
        if (intExtra == 6) {
            ArrayList<String> stringArrayListExtra2 = this.QYU.getStringArrayListExtra("third_party_usernamelist");
            if (stringArrayListExtra2 != null && stringArrayListExtra2.size() > 0) {
                aVar.gMT = new ArrayList();
                Iterator<String> it2 = stringArrayListExtra2.iterator();
                while (it2.hasNext()) {
                    aVar.gMT.add(it2.next());
                }
            }
        } else {
            String stringExtra = this.QYU.getStringExtra("chatroom");
            if (!Util.isNullOrNil(stringExtra)) {
                aVar.gMT = i.SA(stringExtra);
                if (aVar.gMT != null && aVar.gMT.size() > 0) {
                    aVar.gMT.remove(z.aTY());
                }
            }
        }
        AppMethodBeat.o(63441);
        return aVar;
    }
}
