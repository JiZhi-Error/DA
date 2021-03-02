package com.tencent.mm.plugin.festival.model;

import android.content.Context;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.festival.b.e;
import com.tencent.mm.plugin.festival.c.f;
import com.tencent.mm.plugin.festival.ui.FestivalWaitForHeartbeatLoadingProxyUIC;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tavkit.component.TAVExporter;
import java.util.HashSet;
import kotlin.g.a.r;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.l;
import kotlin.l.k;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001)B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J|\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2d\u0010\u001b\u001a`\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00150\u001cJ\u000e\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0004J\u0010\u0010&\u001a\u00020\u00152\b\u0010'\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010(\u001a\u00020\u00152\b\u0010'\u001a\u0004\u0018\u00010\u000bR\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00048F@BX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\u0011¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalWishConfigProvider;", "Lcom/tencent/mm/plugin/festival/model/IFestivalDataProviderContract;", "()V", "DEFAULT_WISH_CONFIG", "Lcom/tencent/mm/plugin/festival/proto/FestivalWishConfig;", "getDEFAULT_WISH_CONFIG", "()Lcom/tencent/mm/plugin/festival/proto/FestivalWishConfig;", "TAG", "", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/festival/model/FestivalWishConfigProvider$OnConfigUpdatedListener;", "Lkotlin/collections/HashSet;", "<set-?>", "wishConfig", "getWishConfig", "setWishConfig", "(Lcom/tencent/mm/plugin/festival/proto/FestivalWishConfig;)V", "wishConfig$delegate", "Lcom/tencent/mm/plugin/festival/model/FestivalMmkvProperty;", "debugClearCacheData", "", "enterFestivalLive", "context", "Landroid/content/Context;", "fromScene", "", "startLiveRoomDelegate", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "objectId", "liveId", "anchorUserName", "nonceId", "notifyUpdated", "config", "registerConfigUpdatedListener", "l", "unregisterConfigUpdatedListener", "OnConfigUpdatedListener", "plugin-festival_release"})
public final class z implements af {
    private static final p Uza = new p(hRB(), f.a.WishConfig);
    public static final z Uzb = new z();
    static final /* synthetic */ k[] cLI = {aa.a(new v(aa.bp(z.class), "wishConfig", "getWishConfig()Lcom/tencent/mm/plugin/festival/proto/FestivalWishConfig;"))};
    static final HashSet<a> listeners = new HashSet<>();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalWishConfigProvider$OnConfigUpdatedListener;", "", "onConfigUpdated", "", "config", "Lcom/tencent/mm/plugin/festival/proto/FestivalWishConfig;", "plugin-festival_release"})
    public interface a {
        void a(e eVar);
    }

    /* access modifiers changed from: package-private */
    public final void b(e eVar) {
        AppMethodBeat.i(263082);
        Uza.a(this, cLI[0], eVar);
        AppMethodBeat.o(263082);
    }

    public final e hRC() {
        AppMethodBeat.i(263081);
        e eVar = (e) Uza.a(this, cLI[0]);
        AppMethodBeat.o(263081);
        return eVar;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "config", "Lcom/tencent/mm/plugin/festival/proto/FestivalWishConfig;", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<e, x> {
        final /* synthetic */ r Uzf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(r rVar) {
            super(1);
            this.Uzf = rVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(e eVar) {
            AppMethodBeat.i(263078);
            e eVar2 = eVar;
            p.h(eVar2, "config");
            try {
                String str = eVar2.UAF;
                p.g(str, "config.objectid");
                if (str == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
                    AppMethodBeat.o(263078);
                    throw tVar;
                }
                long Ga = com.tencent.mm.ac.d.Ga(n.trim(str).toString());
                String str2 = eVar2.UAD;
                p.g(str2, "config.liveid");
                if (str2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type kotlin.CharSequence");
                    AppMethodBeat.o(263078);
                    throw tVar2;
                }
                this.Uzf.invoke(Long.valueOf(Ga), Long.valueOf(com.tencent.mm.ac.d.Ga(n.trim(str2).toString())), z.Uzb.hRC().UAE, z.Uzb.hRC().object_nonce_id);
                x xVar = x.SXb;
                AppMethodBeat.o(263078);
                return xVar;
            } catch (Exception e2) {
                Log.e("MicroMsg.FestivalWishConfigProvider", "enterFestivalLive::onGetLiveRoomInfo, parse live params failed, objectId:" + eVar2.UAF + ", liveId:" + eVar2.UAD + ", exception:" + e2);
                g.UxZ.gWK();
            }
        }
    }

    static {
        AppMethodBeat.i(263079);
        AppMethodBeat.o(263079);
    }

    private z() {
    }

    private static e hRB() {
        AppMethodBeat.i(263080);
        e eVar = new e();
        eVar.UAG = 60;
        eVar.UAC = 5;
        eVar.UAL = 60;
        eVar.UAP = 32;
        eVar.UAH = 5;
        eVar.height = TAVExporter.VIDEO_EXPORT_HEIGHT;
        eVar.width = TAVExporter.VIDEO_EXPORT_HEIGHT;
        AppMethodBeat.o(263080);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.festival.model.af
    public final void debugClearCacheData() {
        AppMethodBeat.i(263083);
        b(hRB());
        AppMethodBeat.o(263083);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(263084);
        synchronized (listeners) {
            try {
                listeners.add(aVar);
            } finally {
                AppMethodBeat.o(263084);
            }
        }
    }

    public static void b(a aVar) {
        AppMethodBeat.i(263085);
        synchronized (listeners) {
            try {
                listeners.remove(aVar);
            } finally {
                AppMethodBeat.o(263085);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/model/FestivalWishConfigProvider$enterFestivalLive$1$1", "Lcom/tencent/mm/plugin/festival/model/FestivalWishConfigProvider$OnConfigUpdatedListener;", "onConfigUpdated", "", "config", "Lcom/tencent/mm/plugin/festival/proto/FestivalWishConfig;", "plugin-festival_release"})
    public static final class b implements a {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ FestivalWaitForHeartbeatLoadingProxyUIC.b Uzc;
        final /* synthetic */ kotlin.g.a.b Uzd;
        final /* synthetic */ int Uze;

        b(FestivalWaitForHeartbeatLoadingProxyUIC.b bVar, Context context, kotlin.g.a.b bVar2, int i2) {
            this.Uzc = bVar;
            this.$context$inlined = context;
            this.Uzd = bVar2;
            this.Uze = i2;
        }

        @Override // com.tencent.mm.plugin.festival.model.z.a
        public final void a(e eVar) {
            AppMethodBeat.i(263076);
            p.h(eVar, "config");
            z zVar = z.Uzb;
            z.b(this);
            this.Uzc.finish();
            this.Uzd.invoke(eVar);
            AppMethodBeat.o(263076);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/festival/model/FestivalWishConfigProvider$enterFestivalLive$1$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/plugin/festival/model/FestivalLiveHeartbeatErrorResp;", "callback", "", "event", "plugin-festival_release"})
    public static final class c extends IListener<n> {
        final /* synthetic */ FestivalWaitForHeartbeatLoadingProxyUIC.b Uzc;

        c(FestivalWaitForHeartbeatLoadingProxyUIC.b bVar) {
            this.Uzc = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(n nVar) {
            AppMethodBeat.i(263077);
            n nVar2 = nVar;
            p.h(nVar2, "event");
            dead();
            if (kotlin.a.e.contains(new Integer[]{Integer.valueOf((int) TXLiteAVCode.ERR_SERVER_INFO_TOKEN_ERROR), Integer.valueOf((int) TXLiteAVCode.ERR_SERVER_INFO_ALLOCATE_ACCESS_FAILED)}, Integer.valueOf(nVar2.errCode))) {
                this.Uzc.finish();
            }
            AppMethodBeat.o(263077);
            return false;
        }
    }
}
