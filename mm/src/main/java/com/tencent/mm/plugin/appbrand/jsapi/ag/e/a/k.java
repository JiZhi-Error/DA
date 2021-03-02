package com.tencent.mm.plugin.appbrand.jsapi.ag.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.b;
import com.tencent.mm.plugin.appbrand.g.b.c;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.a.j;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002¨\u0006\u0005"}, hxF = {"isRecentDevice", "", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "saveDevice", "", "luggage-xweb-ext_release"})
public final class k {

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ MultiProcessMMKV gUu;
        final /* synthetic */ c mNf;
        final /* synthetic */ int mNg = 2;

        a(c cVar, MultiProcessMMKV multiProcessMMKV) {
            this.mNf = cVar;
            this.gUu = multiProcessMMKV;
        }

        public final void run() {
            final String str;
            String str2 = null;
            AppMethodBeat.i(139810);
            Set<String> stringSet = this.gUu.getStringSet("VideoCastDeviceManager.saveDevice", null);
            final List v = stringSet != null ? j.v((Collection) stringSet) : null;
            b bBo = this.mNf.bBo();
            if (bBo != null) {
                str = bBo.ljS;
            } else {
                str = null;
            }
            if (v == null) {
                android.support.v4.e.b bVar = new android.support.v4.e.b();
                bVar.add(str);
                this.gUu.putStringSet("VideoCastDeviceManager.saveDevice", bVar);
                this.gUu.putLong(str, System.currentTimeMillis());
                AppMethodBeat.o(139810);
            } else if (v.contains(str)) {
                this.gUu.putLong(str, System.currentTimeMillis());
                AppMethodBeat.o(139810);
            } else {
                if (v.size() >= this.mNg) {
                    new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.k.a.AnonymousClass1 */
                        final /* synthetic */ a mNh;

                        {
                            this.mNh = r2;
                        }

                        @Override // kotlin.g.a.a
                        public final void invoke() {
                            AppMethodBeat.i(139809);
                            List<String> list = v;
                            ArrayList arrayList = new ArrayList(j.a(list, 10));
                            for (String str : list) {
                                arrayList.add(Long.valueOf(this.mNh.gUu.getLong(str, 0)));
                            }
                            j.n(arrayList);
                            this.mNh.gUu.removeValueForKey((String) v.get(0));
                            v.set(0, str);
                            this.mNh.gUu.putLong(str, System.currentTimeMillis());
                            AppMethodBeat.o(139809);
                        }
                    }.invoke();
                }
                b bBo2 = this.mNf.bBo();
                if (bBo2 != null) {
                    str2 = bBo2.ljS;
                }
                v.add(str2);
                this.gUu.putStringSet("VideoCastDeviceManager.saveDevice", j.r((Iterable) v));
                this.gUu.putLong(str, System.currentTimeMillis());
                AppMethodBeat.o(139810);
            }
        }
    }
}
