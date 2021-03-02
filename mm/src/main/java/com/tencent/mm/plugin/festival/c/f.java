package com.tencent.mm.plugin.festival.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000e\u0010\f¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/festival/util/FestivalProcessSharedMMKV;", "", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "SP_NAME", "", "UIN", "", "getUIN", "()I", "UIN_BY_SP", "getUIN_BY_SP", "UIN_BY_SP$delegate", "Lkotlin/Lazy;", "Key", "plugin-festival_release"})
public final class f {
    public static final f UGm = new f();
    public static final kotlin.f kIr = g.ah(b.UGF);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0013\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/festival/util/FestivalProcessSharedMMKV$Key;", "", "(Ljava/lang/String;I)V", "HasVisitedFestivalLive", "CGIHeartbeatContext", "WishConfig", "LastPostWishTime", "PostQuotaLeft", "CanvasDataLatestCacheFileName", "CanvasDataLatestCacheFileLastModified", "CanvasDataLastCdnUrl", "LatestReadLikeRowId", "LastEnterTime", "LastMultiTaskBytes", "FirstEnterShowEducation", "HadEverShowSetStatusPanel", "StatusVerifyBuf", "StatusSourceName", "StatusSourceAcitivityId", "GetFuBagTime", "plugin-festival_release"})
    public enum a {
        HasVisitedFestivalLive,
        CGIHeartbeatContext,
        WishConfig,
        LastPostWishTime,
        PostQuotaLeft,
        CanvasDataLatestCacheFileName,
        CanvasDataLatestCacheFileLastModified,
        CanvasDataLastCdnUrl,
        LatestReadLikeRowId,
        LastEnterTime,
        LastMultiTaskBytes,
        FirstEnterShowEducation,
        HadEverShowSetStatusPanel,
        StatusVerifyBuf,
        StatusSourceName,
        StatusSourceAcitivityId,
        GetFuBagTime;

        static {
            AppMethodBeat.i(263489);
            AppMethodBeat.o(263489);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(263491);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(263491);
            return aVar;
        }
    }

    static {
        AppMethodBeat.i(263494);
        AppMethodBeat.o(263494);
    }

    private f() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Integer> {
        public static final b UGF = new b();

        static {
            AppMethodBeat.i(263493);
            AppMethodBeat.o(263493);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(263492);
            Integer valueOf = Integer.valueOf(com.tencent.mm.kernel.a.azs());
            AppMethodBeat.o(263492);
            return valueOf;
        }
    }
}
