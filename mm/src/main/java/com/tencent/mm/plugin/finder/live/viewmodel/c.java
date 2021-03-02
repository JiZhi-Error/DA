package com.tencent.mm.plugin.finder.live.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.awt;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B;\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0001H\u0016J\u0006\u0010!\u001a\u00020\tJ\b\u0010\"\u001a\u00020\tH\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u0004¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "liveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "(Lcom/tencent/mm/live/api/LiveConfig;)V", "objectId", "", "liveId", "anchorUserName", "", "nonceId", "coverUrl", "sessionBuffer", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "liveRoomData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveRoomData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setLiveRoomData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setNoticeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "staticConfig", "getStaticConfig", "()Lcom/tencent/mm/live/api/LiveConfig;", "setStaticConfig", "compare", "", "obj", "info", "toString", "plugin-finder_release"})
public final class c implements i {
    public LiveConfig uCr;
    public g uCs = new g();
    public awt ufj;

    public c(LiveConfig liveConfig) {
        p.h(liveConfig, "liveConfig");
        AppMethodBeat.i(247876);
        this.uCr = liveConfig;
        AppMethodBeat.o(247876);
    }

    public c(long j2, long j3, String str, String str2, String str3, String str4) {
        p.h(str, "anchorUserName");
        p.h(str2, "nonceId");
        p.h(str3, "coverUrl");
        AppMethodBeat.i(247877);
        LiveConfig aBR = new LiveConfig.a().qo(LiveConfig.hvU).zt(j3).Gd(str2).zu(j2).Gg(str).Gf(str3).Gl(str4).aBR();
        p.g(aBR, "builder.toWhere(LiveConf…fer)\n            .build()");
        this.uCr = aBR;
        AppMethodBeat.o(247877);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(247874);
        p.h(iVar, "obj");
        if (!(iVar instanceof c) || ((c) iVar).uCr.getLiveId() != this.uCr.getLiveId()) {
            AppMethodBeat.o(247874);
            return -1;
        }
        AppMethodBeat.o(247874);
        return 0;
    }

    public final String toString() {
        String exc;
        AppMethodBeat.i(247875);
        try {
            exc = hashCode() + "_config:" + this.uCr.info() + " FinderLiveRoomData: " + this.uCs.info();
        } catch (Exception e2) {
            exc = e2.toString();
        }
        AppMethodBeat.o(247875);
        return exc;
    }
}
