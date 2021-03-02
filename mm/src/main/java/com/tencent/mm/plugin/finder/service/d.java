package com.tencent.mm.plugin.finder.service;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.y;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/service/FinderPoiService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService;", "()V", "poiRedirectRequest", "", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "snsFeedId", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$PoiRedirectCallBack;", "Companion", "plugin-finder_release"})
public final class d implements y {
    public static final a vvV = new a((byte) 0);

    static {
        AppMethodBeat.i(251463);
        AppMethodBeat.o(251463);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/service/FinderPoiService$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.i.a.y
    public final void a(eaa eaa, y.a aVar, String str, y.c cVar) {
        AppMethodBeat.i(251462);
        p.h(eaa, FirebaseAnalytics.b.LOCATION);
        p.h(aVar, "fromType");
        p.h(cVar, "callback");
        Log.i("Finder.FinderPoiService", "poiRedirectRequest: poiClassifyId = " + eaa.LIb + ", Longitude = " + eaa.LbC + ", Latitude = " + eaa.LbD + ", fromType = " + aVar);
        c cVar2 = c.vCb;
        boolean booleanValue = c.dxd().value().booleanValue();
        Log.i("Finder.FinderPoiService", "isGoToNewPage = ".concat(String.valueOf(booleanValue)));
        if (booleanValue) {
            Intent intent = new Intent();
            intent.putExtra("key_location", eaa.toByteArray());
            intent.putExtra("key_from_type", aVar);
            intent.putExtra("key_sns_feed_id", str);
            ((aj) g.ah(aj.class)).fillContextIdToIntent(4, 11, 81, intent);
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            com.tencent.mm.plugin.finder.utils.a.aj(context, intent);
            AppMethodBeat.o(251462);
            return;
        }
        cVar.a(y.b.FINDER_POI_REDIRECT_TYPE_DEFAULT);
        AppMethodBeat.o(251462);
    }
}
