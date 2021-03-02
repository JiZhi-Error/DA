package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\\\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00142\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00160\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/media/decoder/CfrDecodeStrategy;", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "()V", "TAG", "", "frameTimeInterval", "", "getFrameTimeInterval", "()J", "setFrameTimeInterval", "(J)V", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "startTime", "frames", "", "inFPS", "", "outFPS", "parents", "", "outPts", "", "plugin-mediaeditor_release"})
public final class a implements c {
    private final String TAG = "DecodeStrategy";
    long zgl = 33;

    @Override // com.tencent.mm.media.d.c
    public final void a(long j2, List<Long> list, int i2, int i3, Map<Long, Long> map, Map<Long, List<Long>> map2) {
        long j3;
        AppMethodBeat.i(93522);
        p.h(list, "frames");
        p.h(map, "parents");
        p.h(map2, "outPts");
        Log.i(this.TAG, "use cfr decode strategy");
        long j4 = 0;
        long j5 = -1;
        long j6 = -1;
        if (i3 == 0) {
            i3 = i2;
        }
        this.zgl = TimeUtil.SECOND_TO_US / ((long) i3);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            if (longValue >= j2) {
                if (j5 == -1) {
                    j5 = longValue;
                    j4 = longValue;
                }
                if (longValue >= j4) {
                    map.put(Long.valueOf(longValue), Long.valueOf(j6));
                    long j7 = j4;
                    while (longValue >= j7) {
                        Long valueOf = Long.valueOf(longValue);
                        ArrayList arrayList = map2.get(valueOf);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            map2.put(valueOf, arrayList);
                        }
                        arrayList.add(Long.valueOf(j7));
                        j7 += this.zgl;
                    }
                    j3 = longValue;
                    j4 = j7;
                    j6 = j3;
                }
            }
            j3 = j6;
            j6 = j3;
        }
        AppMethodBeat.o(93522);
    }
}
