package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/QueryCall;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "Landroid/os/Parcel;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
public final class al implements k<QueryParams, Parcel> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.ipcinvoker.k
    public final /* synthetic */ Parcel invoke(QueryParams queryParams) {
        AppMethodBeat.i(50299);
        Parcel a2 = a(queryParams);
        AppMethodBeat.o(50299);
        return a2;
    }

    private static Parcel a(QueryParams queryParams) {
        AppMethodBeat.i(50298);
        Parcel obtain = Parcel.obtain();
        if (g.aAc() && queryParams != null) {
            try {
                obtain.writeTypedList(((ag) g.af(ag.class)).a(queryParams.count, queryParams.kWk, queryParams.iOo));
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrandCollectionStorageIPC", "QueryCall, writeTypedList e = ".concat(String.valueOf(e2)));
            }
        }
        p.g(obtain, "Parcel.obtain().apply {\n…}\n            }\n        }");
        AppMethodBeat.o(50298);
        return obtain;
    }
}
