package com.tencent.mm.plugin.finder.video.statistics;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/statistics/ConsumingStatistics;", "", "TAG", "", "(Ljava/lang/String;)V", "getTAG", "()Ljava/lang/String;", "setTAG", "count", "", "getCount", "()I", "setCount", "(I)V", "currentTimeConsuming", "", "getCurrentTimeConsuming", "()J", "setCurrentTimeConsuming", "(J)V", "totalTimeConsuming", "getTotalTimeConsuming", "setTotalTimeConsuming", TencentMapServiceProtocol.SERVICE_NAME_STATISTIC, "", "timeConsuming", "plugin-finder_release"})
public final class a {
    public String TAG;
    public int count;
    public long wiM;
    public long wiN;

    public a(String str) {
        p.h(str, "TAG");
        AppMethodBeat.i(254546);
        this.TAG = str;
        AppMethodBeat.o(254546);
    }
}
