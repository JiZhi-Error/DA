package com.tencent.tavkit.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TAVTimeUtil {
    public static float factorForTime(CMTime cMTime, CMTimeRange cMTimeRange) {
        AppMethodBeat.i(197686);
        if (cMTimeRange == null) {
            AppMethodBeat.o(197686);
            return 0.0f;
        }
        float timeSeconds = cMTime.sub(cMTimeRange.getStart()).getTimeSeconds() / cMTimeRange.getDuration().getTimeSeconds();
        AppMethodBeat.o(197686);
        return timeSeconds;
    }

    public static CMTimeRange getIntersection(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        CMTimeRange cMTimeRange3;
        CMTimeRange cMTimeRange4;
        CMTime start;
        CMTime end;
        AppMethodBeat.i(197687);
        if (cMTimeRange == null || cMTimeRange2 == null) {
            AppMethodBeat.o(197687);
            return null;
        }
        if (cMTimeRange.getStart().bigThan(cMTimeRange2.getStart())) {
            cMTimeRange3 = cMTimeRange;
            cMTimeRange4 = cMTimeRange2;
        } else {
            cMTimeRange3 = cMTimeRange2;
            cMTimeRange4 = cMTimeRange;
        }
        if (cMTimeRange4.getEnd().smallThan(cMTimeRange3.getStart())) {
            AppMethodBeat.o(197687);
            return null;
        }
        if (cMTimeRange4.getStart().bigThan(cMTimeRange3.getStart())) {
            start = cMTimeRange4.getStart();
        } else {
            start = cMTimeRange3.getStart();
        }
        if (cMTimeRange4.getEnd().smallThan(cMTimeRange3.getEnd())) {
            end = cMTimeRange4.getEnd();
        } else {
            end = cMTimeRange3.getEnd();
        }
        CMTimeRange cMTimeRange5 = new CMTimeRange(start, end.sub(start));
        AppMethodBeat.o(197687);
        return cMTimeRange5;
    }

    public static List<CMTimeRange> sliceTimeRangesForTimeRange1(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        List<CMTimeRange> arrayList;
        AppMethodBeat.i(197688);
        CMTimeRange intersection = getIntersection(cMTimeRange, cMTimeRange2);
        if (intersection.getDuration().getTimeSeconds() <= 0.0f) {
            arrayList = new ArrayList<>();
            arrayList.add(cMTimeRange);
            arrayList.add(cMTimeRange2);
        } else if (cMTimeRange2.containsTimeRange(cMTimeRange) || (cMTimeRange.getStart().getTimeSeconds() < cMTimeRange2.getStart().getTimeSeconds() && cMTimeRange.getEnd().getTimeSeconds() < cMTimeRange2.getEnd().getTimeSeconds())) {
            arrayList = mixTimeRangesWithMinTimeRange(cMTimeRange, intersection, cMTimeRange2);
        } else {
            arrayList = mixTimeRangesWithMinTimeRange(cMTimeRange2, intersection, cMTimeRange);
        }
        Collections.sort(arrayList, new Comparator<CMTimeRange>() {
            /* class com.tencent.tavkit.utils.TAVTimeUtil.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
                AppMethodBeat.i(197685);
                int compare = compare(cMTimeRange, cMTimeRange2);
                AppMethodBeat.o(197685);
                return compare;
            }

            public final int compare(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
                AppMethodBeat.i(197684);
                CMTime start = cMTimeRange.getStart();
                CMTime start2 = cMTimeRange2.getStart();
                if (start.equalsTo(start2)) {
                    AppMethodBeat.o(197684);
                    return 0;
                } else if (start.smallThan(start2)) {
                    AppMethodBeat.o(197684);
                    return -1;
                } else {
                    AppMethodBeat.o(197684);
                    return 1;
                }
            }
        });
        AppMethodBeat.o(197688);
        return arrayList;
    }

    public static List<CMTimeRange> mixTimeRangesWithMinTimeRange(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2, CMTimeRange cMTimeRange3) {
        AppMethodBeat.i(197689);
        if (cMTimeRange3.containsTimeRange(cMTimeRange)) {
            ArrayList arrayList = new ArrayList();
            CMTime sub = cMTimeRange2.getStart().sub(cMTimeRange3.getStart());
            if (sub.getTimeSeconds() > 0.0f) {
                arrayList.add(new CMTimeRange(cMTimeRange3.getStart(), sub));
            }
            arrayList.add(cMTimeRange2);
            CMTime sub2 = cMTimeRange3.getEnd().sub(cMTimeRange2.getEnd());
            if (sub2.getTimeSeconds() > 0.0f) {
                arrayList.add(new CMTimeRange(cMTimeRange2.getEnd(), sub2));
            }
            AppMethodBeat.o(197689);
            return arrayList;
        } else if (cMTimeRange.equals(cMTimeRange3)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(cMTimeRange2);
            AppMethodBeat.o(197689);
            return arrayList2;
        } else {
            ArrayList arrayList3 = new ArrayList();
            CMTimeRange cMTimeRange4 = new CMTimeRange(cMTimeRange.getStart(), cMTimeRange.getDuration().sub(cMTimeRange2.getDuration()));
            if (cMTimeRange4.getDuration().getTimeSeconds() > 0.0f) {
                arrayList3.add(cMTimeRange4);
            }
            arrayList3.add(cMTimeRange2);
            CMTimeRange cMTimeRange5 = new CMTimeRange(cMTimeRange2.getEnd(), cMTimeRange3.getEnd().sub(cMTimeRange2.getEnd()));
            if (cMTimeRange5.getDuration().getTimeSeconds() > 0.0f) {
                arrayList3.add(cMTimeRange5);
            }
            AppMethodBeat.o(197689);
            return arrayList3;
        }
    }

    public static List<CMTimeRange> timeRange(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        AppMethodBeat.i(197690);
        CMTimeRange intersection = getIntersection(cMTimeRange, cMTimeRange2);
        if (intersection == null || intersection.getDuration().getTimeSeconds() <= 0.0f) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(cMTimeRange);
            AppMethodBeat.o(197690);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        CMTimeRange cMTimeRange3 = new CMTimeRange(cMTimeRange.getStart(), intersection.getStart().sub(cMTimeRange.getStart()));
        if (cMTimeRange3.getDuration().getTimeSeconds() > 0.0f) {
            arrayList2.add(cMTimeRange3);
        }
        CMTimeRange cMTimeRange4 = new CMTimeRange(intersection.getEnd(), cMTimeRange.getEnd().sub(intersection.getEnd()));
        if (cMTimeRange4.getDuration().getTimeSeconds() > 0.0f) {
            arrayList2.add(cMTimeRange4);
        }
        AppMethodBeat.o(197690);
        return arrayList2;
    }
}
