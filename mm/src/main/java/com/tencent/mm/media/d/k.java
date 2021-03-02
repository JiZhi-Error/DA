package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\\\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/media/decoder/PassthroughDecodeStrategy;", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "()V", "TAG", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "startTime", "", "frames", "", "inFPS", "", "outFPS", "parents", "", "outPts", "", "plugin-mediaeditor_release"})
public final class k implements c {
    private final String TAG = "DecodeStrategy";

    @Override // com.tencent.mm.media.d.c
    public final void a(long j2, List<Long> list, int i2, int i3, Map<Long, Long> map, Map<Long, List<Long>> map2) {
        AppMethodBeat.i(93557);
        p.h(list, "frames");
        p.h(map, "parents");
        p.h(map2, "outPts");
        Log.i(this.TAG, "use passthrough decode strategy");
        long j3 = -1;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            j3 = it.next().longValue();
            if (j3 >= j2) {
                map.put(Long.valueOf(j3), Long.valueOf(j3));
                map2.put(Long.valueOf(j3), j.mutableListOf(Long.valueOf(j3)));
            } else {
                j3 = j3;
            }
        }
        AppMethodBeat.o(93557);
    }
}
