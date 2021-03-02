package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\\\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001b0\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/media/decoder/SimpleVfrDecodeStrategy;", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "()V", "TAG", "", "frameTimeInterval", "", "getFrameTimeInterval", "()J", "setFrameTimeInterval", "(J)V", "avgFrameInterval", "", "startPts", "endPts", "frameCount", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "startTime", "frames", "", "inFPS", "outFPS", "parents", "", "outPts", "", "plugin-mediaeditor_release"})
public final class m implements c {
    private final String TAG = "DecodeStrategy";
    private long zgl = 33;

    @Override // com.tencent.mm.media.d.c
    public final void a(long j2, List<Long> list, int i2, int i3, Map<Long, Long> map, Map<Long, List<Long>> map2) {
        float f2;
        AppMethodBeat.i(259084);
        p.h(list, "frames");
        p.h(map, "parents");
        p.h(map2, "outPts");
        Log.i(this.TAG, "use simple vfr decode strategy");
        long j3 = -1;
        long j4 = -1;
        if (i3 == 0) {
            i3 = i2;
        }
        this.zgl = TimeUtil.SECOND_TO_US / ((long) i3);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            j4 = it.next().longValue();
            if (j4 >= j2) {
                if (j3 == -1) {
                    j3 = j4;
                }
                int size = map.size() + 1;
                if (size == 0) {
                    f2 = 0.0f;
                } else {
                    f2 = ((float) (j4 - j3)) / ((float) size);
                }
                if (f2 <= ((float) this.zgl)) {
                    map.put(Long.valueOf(j4), Long.valueOf(j4));
                    map2.put(Long.valueOf(j4), j.mutableListOf(Long.valueOf(j4)));
                }
            }
            j4 = j4;
        }
        AppMethodBeat.o(259084);
    }
}
