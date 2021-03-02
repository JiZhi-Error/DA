package com.tencent.mm.media.k;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/media/util/FPSComputer;", "", "()V", "REPORT_ID_SROTY_VIDEO", "", "REPORT_KEY_EXECUTE_TIME", "REPORT_KEY_FAIL_COUNT", "TAG", "", "computeMinMaxAvgFps", "", "path", "result", "", "threshold", "", "plugin-mediaeditor_release"})
public final class b {
    public static final b ill = new b();

    static {
        AppMethodBeat.i(93873);
        AppMethodBeat.o(93873);
    }

    private b() {
    }

    public static /* synthetic */ List a(String str, double[] dArr) {
        AppMethodBeat.i(93872);
        List<Long> a2 = a(str, dArr, Integer.MAX_VALUE);
        AppMethodBeat.o(93872);
        return a2;
    }

    public static final List<Long> a(String str, double[] dArr, int i2) {
        AppMethodBeat.i(93871);
        p.h(dArr, "result");
        if (str == null || !s.YS(str)) {
            v vVar = v.SXr;
            AppMethodBeat.o(93871);
            return vVar;
        }
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        c cVar = new c();
        try {
            cVar.setDataSource(str);
            int i5 = 0;
            int trackCount = cVar.getTrackCount();
            while (true) {
                if (i5 >= trackCount) {
                    break;
                }
                MediaFormat trackFormat = cVar.getTrackFormat(i5);
                p.g(trackFormat, "mediaExtractor.getTrackFormat(i)");
                String string = trackFormat.getString("mime");
                p.g(string, "format.getString(MediaFormat.KEY_MIME)");
                if (n.J(string, "video/", false)) {
                    z = true;
                    cVar.selectTrack(i5);
                    break;
                }
                i5++;
            }
            if (z) {
                int i6 = 1000000;
                int i7 = 0;
                ArrayList arrayList2 = new ArrayList();
                do {
                    long sampleTime = cVar.getSampleTime();
                    if (sampleTime == -1) {
                        break;
                    }
                    arrayList.add(Long.valueOf(sampleTime));
                    if (sampleTime > ((long) i6)) {
                        arrayList2.add(Integer.valueOf(i7));
                        i4 = Math.max(i4, i7);
                        i3 = Math.min(i3, i7);
                        if (i4 - i3 >= i2) {
                            break;
                        }
                        i7 = 0;
                        i6 += 1000000;
                    } else {
                        i7++;
                    }
                } while (cVar.advance());
                if (i6 <= 1000000) {
                    arrayList2.add(Integer.valueOf(i7));
                    i4 = Math.max(i4, i7);
                    i3 = Math.min(i3, i7);
                }
                dArr[0] = (double) i3;
                dArr[1] = (double) i4;
                dArr[2] = j.A(arrayList2);
            }
            cVar.release();
        } catch (Exception e2) {
            Log.e("FPSComputer", "compute fps error: " + e2.getLocalizedMessage());
            h.INSTANCE.F(986, 103);
            cVar.release();
        } catch (Throwable th) {
            cVar.release();
            AppMethodBeat.o(93871);
            throw th;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        Log.i("FPSComputer", "compute fps for file: " + str + ", threshold = " + i2 + " frames = " + arrayList.size() + ", execute time = " + (currentTimeMillis2 - currentTimeMillis) + "ms, min fps = " + dArr[0] + ", max fps = " + dArr[1] + ", avg fps = " + dArr[2]);
        h.INSTANCE.n(986, 102, currentTimeMillis2 - currentTimeMillis);
        AppMethodBeat.o(93871);
        return arrayList;
    }
}
