package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.ao;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderFeedCardReporter;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderFeedCardReporter;", "()V", "ENTERSESSION_MULTI_CHAT", "", "ENTERSESSION_SINGLE_CHAT", "ENTERSESSION_SNS", "enterTimeMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "report22144", "", "entersession", "cardType", "sourceUsr", "", "feedIdStr", "updateSceneEnterTime", "plugin-finder_release"})
public final class am implements ao {
    private static final HashMap<Integer, Long> USX = new HashMap<>();
    public static final am USY = new am();

    static {
        AppMethodBeat.i(261317);
        AppMethodBeat.o(261317);
    }

    private am() {
    }

    @Override // com.tencent.mm.plugin.i.a.ao
    public final void awT(int i2) {
        AppMethodBeat.i(261315);
        USX.put(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() / 1000));
        AppMethodBeat.o(261315);
    }

    @Override // com.tencent.mm.plugin.i.a.ao
    public final void y(int i2, String str, String str2) {
        AppMethodBeat.i(261316);
        p.h(str, "sourceUsr");
        p.h(str2, "feedIdStr");
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder append = new StringBuilder().append(i2).append('-');
        long j2 = USX.get(Integer.valueOf(i2));
        if (j2 == null) {
            j2 = 0L;
        }
        String sb = append.append(j2.longValue()).toString();
        Log.i("FinderFeedCardReporter", "report22144 entersessionId=" + sb + ", entersession=" + i2 + ", eventTime=" + currentTimeMillis + ", cardType=1, sourceUsr=" + str + ", feedId=" + str2);
        h.INSTANCE.a(22144, sb, Integer.valueOf(i2), Long.valueOf(currentTimeMillis), 1, str, str2);
        AppMethodBeat.o(261316);
    }
}
