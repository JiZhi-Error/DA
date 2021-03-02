package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.o;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\\\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00130\u0011H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/media/decoder/VfrDecodeStrategy;", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "startTime", "", "frames", "", "inFPS", "", "outFPS", "parents", "", "outPts", "", "plugin-mediaeditor_release"})
public final class l implements c {
    private final String TAG = "DecodeStrategy";

    @Override // com.tencent.mm.media.d.c
    public final void a(long j2, List<Long> list, int i2, int i3, Map<Long, Long> map, Map<Long, List<Long>> map2) {
        AppMethodBeat.i(93558);
        p.h(list, "frames");
        p.h(map, "parents");
        p.h(map2, "outPts");
        Log.i(this.TAG, "use vfr decode strategy");
        int i4 = 0;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().longValue() >= j2) {
                int size = list.size() - i4;
                int i5 = (size * i3) / i2;
                List N = j.N(list, size);
                v vVar = v.SXr;
                long currentTimeMillis = System.currentTimeMillis();
                d dVar = d.ieb;
                p.h(N, "frames");
                int size2 = N.size();
                ArrayList arrayList = new ArrayList(size2);
                for (int i6 = 0; i6 < size2; i6++) {
                    arrayList.add(Boolean.FALSE);
                }
                ArrayList arrayList2 = arrayList;
                int i7 = i5 + 1;
                ArrayList arrayList3 = new ArrayList(i7);
                for (int i8 = 0; i8 < i7; i8++) {
                    ArrayList arrayList4 = new ArrayList(size2);
                    for (int i9 = 0; i9 < size2; i9++) {
                        arrayList4.add(2305843009213693952L);
                    }
                    arrayList3.add(arrayList4);
                }
                ArrayList arrayList5 = arrayList3;
                int i10 = i5 + 1;
                ArrayList arrayList6 = new ArrayList(i10);
                for (int i11 = 0; i11 < i10; i11++) {
                    ArrayList arrayList7 = new ArrayList(size2);
                    for (int i12 = 0; i12 < size2; i12++) {
                        arrayList7.add(-1);
                    }
                    arrayList6.add(arrayList7);
                }
                ArrayList arrayList8 = arrayList6;
                ((List) arrayList5.get(1)).set(0, 0L);
                ((List) arrayList8.get(1)).set(0, 0);
                ArrayList arrayList9 = new ArrayList();
                int i13 = 2;
                if (2 <= i5) {
                    while (true) {
                        arrayList9.clear();
                        arrayList9.add(Integer.valueOf(i13 - 2));
                        for (int i14 = i13 - 1; i14 < size2; i14++) {
                            while (arrayList9.size() > 1) {
                                if (d.a(((Number) arrayList9.get(1)).intValue(), ((Number) arrayList9.get(0)).intValue(), (List) arrayList5.get(i13 - 1), N) >= d.a(((Number) arrayList9.get(1)).intValue(), ((Number) arrayList9.get(0)).intValue(), N) * ((Number) N.get(i14)).doubleValue()) {
                                    break;
                                }
                                arrayList9.remove(0);
                            }
                            int intValue = ((Number) j.ks(arrayList9)).intValue();
                            ((List) arrayList5.get(i13)).set(i14, Long.valueOf(((Number) ((List) arrayList5.get(i13 - 1)).get(intValue)).longValue() + ((((Number) N.get(i14)).longValue() - ((Number) N.get(intValue)).longValue()) * (((Number) N.get(i14)).longValue() - ((Number) N.get(intValue)).longValue()))));
                            ((List) arrayList8.get(i13)).set(i14, Integer.valueOf(intValue));
                            while (arrayList9.size() > 1) {
                                if (d.a(i14, ((Number) arrayList9.get(j.kq(arrayList9))).intValue(), (List) arrayList5.get(i13 - 1), N) * d.a(((Number) arrayList9.get(j.kq(arrayList9))).intValue(), ((Number) arrayList9.get(j.kq(arrayList9) - 1)).intValue(), N) >= d.a(i14, ((Number) arrayList9.get(j.kq(arrayList9))).intValue(), N) * d.a(((Number) arrayList9.get(j.kq(arrayList9))).intValue(), ((Number) arrayList9.get(j.kq(arrayList9) - 1)).intValue(), (List) arrayList5.get(i13 - 1), N)) {
                                    break;
                                }
                                arrayList9.remove(j.kq(arrayList9));
                            }
                            arrayList9.add(Integer.valueOf(i14));
                        }
                        if (i13 == i5) {
                            break;
                        }
                        i13++;
                    }
                }
                int i15 = size2 - 1;
                int i16 = i5;
                while (i16 > 0) {
                    arrayList2.set(i15, Boolean.TRUE);
                    i16--;
                    i15 = ((Number) ((List) arrayList8.get(i16)).get(i15)).intValue();
                }
                Log.i(this.TAG, "DropFrame, total frames = " + N.size() + ", remain frames = " + i5 + ", cost " + (System.currentTimeMillis() - currentTimeMillis) + LocaleUtil.MALAY);
                long j3 = -1;
                for (o oVar : j.c((Iterable) arrayList2, (Iterable) N)) {
                    boolean booleanValue = oVar.first.booleanValue();
                    long longValue = oVar.second.longValue();
                    if (booleanValue) {
                        map.put(Long.valueOf(longValue), Long.valueOf(j3));
                        map2.put(Long.valueOf(longValue), j.mutableListOf(Long.valueOf(longValue)));
                    } else {
                        longValue = j3;
                    }
                    j3 = longValue;
                }
                AppMethodBeat.o(93558);
                return;
            }
            i4++;
        }
        AppMethodBeat.o(93558);
    }
}
