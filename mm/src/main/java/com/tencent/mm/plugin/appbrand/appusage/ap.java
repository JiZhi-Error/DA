package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.protocal.protobuf.bzb;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0004\u0012\u0013\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic;", "", "()V", "mReceiver", "", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "clear", "", "notifyReceiver", "entrances", "", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "registerEntranceInfoUpdateReceiverForId", "receiver", "requestEntranceInfo", "unregisterEntranceInfoUpdateReceiverForId", "Companion", "EntranceId", "EntranceInfoUpdateReceiver", "ShowCaseType", "plugin-appbrand-integration_release"})
public final class ap {
    public static final a kWn = new a((byte) 0);
    public final Map<b, List<c>> kWm = new LinkedHashMap();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "onEntranceInfoUpdate", "", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "plugin-appbrand-integration_release"})
    public interface c {
        void a(ajs ajs);

        b byw();
    }

    static {
        AppMethodBeat.i(180446);
        AppMethodBeat.o(180446);
    }

    public ap() {
        AppMethodBeat.i(180445);
        AppMethodBeat.o(180445);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$requestEntranceInfo$locationCallback$1", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "onGetLocation", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "plugin-appbrand-integration_release"})
    public static final class e implements b.a {
        final /* synthetic */ ap kWB;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public e(ap apVar) {
            this.kWB = apVar;
        }

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(180444);
            com.tencent.mm.modelgeo.d.bca().c(this);
            f.bs(this);
            d.a aVar = new d.a();
            aVar.sG(3752);
            aVar.MB("/cgi-bin/mmbiz-bin/wxaapp/getwxadesktopentrance");
            bzb bzb = new bzb();
            bzb.MeH = (double) f2;
            bzb.MeI = (double) f3;
            aVar.c(bzb);
            aVar.d(new bzc());
            aa.a(aVar.aXF(), new a(this), true);
            AppMethodBeat.o(180444);
            return false;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
        static final class a implements aa.a {
            final /* synthetic */ e kWC;

            a(e eVar) {
                this.kWC = eVar;
            }

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                AppMethodBeat.i(180443);
                p.g(dVar, "rr");
                com.tencent.mm.bw.a aYK = dVar.aYK();
                if (i2 != 0 || i3 != 0 || aYK == null || !(aYK instanceof bzc)) {
                    Log.e("WxaDesktopEntranceShowLogic", "refresh() cgi return errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                } else {
                    ap apVar = this.kWC.kWB;
                    LinkedList<ajs> linkedList = ((bzc) aYK).MeJ;
                    p.g(linkedList, "resp.entrance_info");
                    ap.a(apVar, linkedList);
                }
                AppMethodBeat.o(180443);
                return 0;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "", "(Ljava/lang/String;I)V", "ENTRANCE_ID_NONE", "ENTRANCE_ID_NEARBY", "ENTRANCE_ID_LIVE", "ENTRANCE_ID_FRIENDS_USING", "Companion", "plugin-appbrand-integration_release"})
    public enum b {
        ENTRANCE_ID_NONE,
        ENTRANCE_ID_NEARBY,
        ENTRANCE_ID_LIVE,
        ENTRANCE_ID_FRIENDS_USING;
        
        public static final a kWt = new a((byte) 0);

        static {
            AppMethodBeat.i(180436);
            AppMethodBeat.o(180436);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(180438);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(180438);
            return bVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId$Companion;", "", "()V", "getByOrdinal", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "id", "", "plugin-appbrand-integration_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType;", "", "(Ljava/lang/String;I)V", "TYPE_NULL", "TYPE_WORDING", "TYPE_ICON_WORDING", "TYPE_ICON_WORDING_ICON2", "TYPE_WORDING_ICON", "Companion", "plugin-appbrand-integration_release"})
    public enum d {
        TYPE_NULL,
        TYPE_WORDING,
        TYPE_ICON_WORDING,
        TYPE_ICON_WORDING_ICON2,
        TYPE_WORDING_ICON;
        
        public static final a kWA = new a((byte) 0);

        static {
            AppMethodBeat.i(180439);
            AppMethodBeat.o(180439);
        }

        public static d valueOf(String str) {
            AppMethodBeat.i(180441);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(180441);
            return dVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType$Companion;", "", "()V", "getByOrdinal", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType;", "id", "", "plugin-appbrand-integration_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        public static final d wb(int i2) {
            AppMethodBeat.i(180442);
            d[] values = values();
            for (d dVar : values) {
                if (i2 == dVar.ordinal()) {
                    AppMethodBeat.o(180442);
                    return dVar;
                }
            }
            AppMethodBeat.o(180442);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(ap apVar, List list) {
        b bVar;
        List<c> list2;
        AppMethodBeat.i(180447);
        synchronized (apVar.kWm) {
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ajs ajs = (ajs) it.next();
                    b.a aVar = b.kWt;
                    int i2 = ajs.Ltf;
                    b[] values = b.values();
                    int length = values.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            bVar = null;
                            break;
                        }
                        bVar = values[i3];
                        if (i2 == bVar.ordinal()) {
                            break;
                        }
                        i3++;
                    }
                    if (!(bVar == null || (list2 = apVar.kWm.get(bVar)) == null)) {
                        Iterator<T> it2 = list2.iterator();
                        while (it2.hasNext()) {
                            it2.next().a(ajs);
                        }
                    }
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(180447);
            }
        }
    }
}
