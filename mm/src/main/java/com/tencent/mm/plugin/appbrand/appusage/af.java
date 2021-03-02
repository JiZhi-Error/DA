package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bzl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic;", "", "()V", "Companion", "IFetchStartListCallback", "plugin-appbrand-integration_release"})
public final class af {
    public static final a kVR = new a((byte) 0);
    private static final long kVx = TimeUnit.DAYS.toSeconds(1);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "", "onCgiBack", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "onHitFrequencyLimit", "plugin-appbrand-integration_release"})
    public interface b {
        void b(c.a<bzl> aVar);

        void bxE();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$Companion;", "", "()V", "FETCH_FREQUENCY", "", "TAG", "", "fetchListFromServer", "", "reason", "", "prescene", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "plugin-appbrand-integration_release"})
    public static final class a {

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00012*\u0010\u0004\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "kotlin.jvm.PlatformType", "back", "call"})
        /* renamed from: com.tencent.mm.plugin.appbrand.appusage.af$a$a  reason: collision with other inner class name */
        public static final class C0556a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
            final /* synthetic */ b kVS;
            final /* synthetic */ int kVT;
            final /* synthetic */ long kVU;

            C0556a(b bVar, int i2, long j2) {
                this.kVS = bVar;
                this.kVT = i2;
                this.kVU = j2;
            }

            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(Object obj) {
                s sVar;
                AppMethodBeat.i(50292);
                c.a<bzl> aVar = (c.a) obj;
                b bVar = this.kVS;
                if (bVar != null) {
                    bVar.b(aVar);
                }
                if (aVar != null) {
                    int i2 = this.kVT;
                    int i3 = aVar.errType;
                    int i4 = aVar.errCode;
                    String str = aVar.errMsg;
                    q qVar = aVar.dGJ;
                    if (qVar != null) {
                        sVar = qVar.getReqResp();
                    } else {
                        sVar = null;
                    }
                    if (!(sVar instanceof d)) {
                        sVar = null;
                    }
                    v.a(i2, i3, i4, str, (d) sVar, Long.valueOf(this.kVU));
                    AppMethodBeat.o(50292);
                    return aVar;
                }
                AppMethodBeat.o(50292);
                return null;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static /* synthetic */ void a(int i2, int i3, b bVar, int i4) {
            AppMethodBeat.i(50294);
            if ((i4 & 1) != 0) {
                i2 = 5;
            }
            if ((i4 & 2) != 0) {
                i3 = 0;
            }
            if ((i4 & 4) != 0) {
                bVar = null;
            }
            a(i2, i3, bVar);
            AppMethodBeat.o(50294);
        }

        private static void a(int i2, int i3, b bVar) {
            long j2;
            AppMethodBeat.i(50293);
            if (i2 == 2 || i2 == 7 || i2 == 8) {
                try {
                    e aAh = g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    Object obj = aAh.azQ().get(ar.a.USERINFO_APP_BRAND_COLLECTION_LIST_FETCH_NEXT_TIME_SEC_LONG, (Object) 0L);
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Long");
                        AppMethodBeat.o(50293);
                        throw tVar;
                    }
                    j2 = ((Long) obj).longValue();
                    if (j2 > Util.nowSecond()) {
                        Log.d("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "daily fetch blocked by frequency");
                        if (bVar != null) {
                            bVar.bxE();
                            AppMethodBeat.o(50293);
                            return;
                        }
                        AppMethodBeat.o(50293);
                        return;
                    }
                    e aAh2 = g.aAh();
                    p.g(aAh2, "MMKernel.storage()");
                    aAh2.azQ().set(ar.a.USERINFO_APP_BRAND_COLLECTION_LIST_FETCH_NEXT_TIME_SEC_LONG, Long.valueOf(Util.nowSecond() + af.kVx));
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "fetchListFromServer checkFrequency by configStg fail, e=".concat(String.valueOf(e2)));
                    j2 = 0;
                }
            }
            Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "fetchList reason=" + i2 + ", prescene=" + i3);
            new z(i2, i3, 2, Integer.MAX_VALUE, 0).aYI().j(new C0556a(bVar, i2, Util.nowMilliSecond()));
            AppMethodBeat.o(50293);
        }
    }

    static {
        AppMethodBeat.i(50295);
        AppMethodBeat.o(50295);
    }
}
