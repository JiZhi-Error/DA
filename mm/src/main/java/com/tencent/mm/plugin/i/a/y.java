package com.tencent.mm.plugin.i.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eaa;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\f\r\u000e\u000fJ*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService;", "Lcom/tencent/mm/kernel/service/IService;", "poiRedirectRequest", "", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "snsFeedId", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$PoiRedirectCallBack;", "FinderPoiFromType", "FinderPoiRedirectType", "LbsAgentPoiSourceFlag", "PoiRedirectCallBack", "finder-sdk_release"})
public interface y extends com.tencent.mm.kernel.c.a {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "", "(Ljava/lang/String;I)V", "FINDER_POI_FROM_TYPE_DEFAULT", "FINDER_POI_FROM_TYPE_SNS", "finder-sdk_release"})
    public enum a {
        FINDER_POI_FROM_TYPE_DEFAULT,
        FINDER_POI_FROM_TYPE_SNS;

        static {
            AppMethodBeat.i(208790);
            AppMethodBeat.o(208790);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(208792);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(208792);
            return aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiRedirectType;", "", "(Ljava/lang/String;I)V", "FINDER_POI_REDIRECT_TYPE_DEFAULT", "FINDER_POI_REDIRECT_TYPE_POI_PAGE", "FINDER_POI_REDIRECT_TYPE_MPH5", "FINDER_POI_REDIRECT_TYPE_USER_PAGE", "FINDER_POI_REDIRECT_TYPE_MAP", "finder-sdk_release"})
    public enum b {
        FINDER_POI_REDIRECT_TYPE_DEFAULT,
        FINDER_POI_REDIRECT_TYPE_POI_PAGE,
        FINDER_POI_REDIRECT_TYPE_MPH5,
        FINDER_POI_REDIRECT_TYPE_USER_PAGE,
        FINDER_POI_REDIRECT_TYPE_MAP;

        static {
            AppMethodBeat.i(208793);
            AppMethodBeat.o(208793);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(208795);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(208795);
            return bVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$PoiRedirectCallBack;", "", "onPoiRedirect", "", "type", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiRedirectType;", "finder-sdk_release"})
    public interface c {
        void a(b bVar);
    }

    void a(eaa eaa, a aVar, String str, c cVar);
}
