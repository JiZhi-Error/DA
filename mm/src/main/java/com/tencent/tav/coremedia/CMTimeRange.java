package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CMTimeRange implements Cloneable {
    public static CMTimeRange CMTimeRangeInvalid;
    private CMTime duration;
    private CMTime end;
    private CMTime start;

    static {
        AppMethodBeat.i(199461);
        CMTime cMTime = CMTime.CMTimeZero;
        CMTimeRangeInvalid = new CMTimeRange(cMTime, cMTime);
        AppMethodBeat.o(199461);
    }

    public static CMTimeRange fromSeconds(float f2, float f3) {
        AppMethodBeat.i(199441);
        CMTimeRange cMTimeRange = new CMTimeRange(CMTime.fromSeconds(f2), CMTime.fromSeconds(f3));
        AppMethodBeat.o(199441);
        return cMTimeRange;
    }

    public static CMTimeRange fromMs(long j2, long j3) {
        AppMethodBeat.i(199442);
        CMTimeRange cMTimeRange = new CMTimeRange(CMTime.fromMs(j2), CMTime.fromMs(j3));
        AppMethodBeat.o(199442);
        return cMTimeRange;
    }

    public static CMTimeRange fromUs(long j2, long j3) {
        AppMethodBeat.i(199443);
        CMTimeRange cMTimeRange = new CMTimeRange(CMTime.fromUs(j2), CMTime.fromUs(j3));
        AppMethodBeat.o(199443);
        return cMTimeRange;
    }

    public CMTimeRange(CMTime cMTime, CMTime cMTime2) {
        AppMethodBeat.i(199444);
        this.start = cMTime;
        this.duration = cMTime2;
        this.end = cMTime.add(cMTime2);
        AppMethodBeat.o(199444);
    }

    public static CMTimeRange getIntersection(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        CMTimeRange cMTimeRange3;
        CMTimeRange cMTimeRange4;
        AppMethodBeat.i(199445);
        if (cMTimeRange == null || cMTimeRange2 == null) {
            CMTimeRange cMTimeRange5 = CMTimeRangeInvalid;
            AppMethodBeat.o(199445);
            return cMTimeRange5;
        }
        CMTimeRange clone = cMTimeRange.clone();
        CMTimeRange clone2 = cMTimeRange2.clone();
        if (clone.getStartUs() > clone2.getStartUs()) {
            cMTimeRange3 = clone;
            cMTimeRange4 = clone2;
        } else {
            cMTimeRange3 = clone2;
            cMTimeRange4 = clone;
        }
        if (cMTimeRange4.getEndUs() > cMTimeRange3.getStartUs() && cMTimeRange4.getEndUs() < cMTimeRange3.getEndUs()) {
            CMTimeRange cMTimeRange6 = new CMTimeRange(cMTimeRange3.getStart(), cMTimeRange4.getEnd().sub(cMTimeRange3.getStart()));
            AppMethodBeat.o(199445);
            return cMTimeRange6;
        } else if (cMTimeRange4.getEndUs() >= cMTimeRange3.getEndUs()) {
            AppMethodBeat.o(199445);
            return cMTimeRange3;
        } else if (cMTimeRange4.getEndUs() < cMTimeRange3.getStartUs()) {
            CMTimeRange cMTimeRange7 = CMTimeRangeInvalid;
            AppMethodBeat.o(199445);
            return cMTimeRange7;
        } else {
            CMTimeRange cMTimeRange8 = CMTimeRangeInvalid;
            AppMethodBeat.o(199445);
            return cMTimeRange8;
        }
    }

    public static CMTimeRange[] getUnions(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        CMTimeRange cMTimeRange3;
        CMTimeRange cMTimeRange4;
        AppMethodBeat.i(199446);
        CMTimeRange[] cMTimeRangeArr = new CMTimeRange[2];
        if (cMTimeRange == null) {
            cMTimeRangeArr[0] = cMTimeRange2;
        } else if (cMTimeRange2 == null) {
            cMTimeRangeArr[0] = cMTimeRange;
        } else {
            CMTimeRange clone = cMTimeRange.clone();
            CMTimeRange clone2 = cMTimeRange2.clone();
            if (clone.getStartUs() > clone2.getStartUs()) {
                cMTimeRange3 = clone;
                cMTimeRange4 = clone2;
            } else {
                cMTimeRange3 = clone2;
                cMTimeRange4 = clone;
            }
            cMTimeRangeArr[0] = cMTimeRange4;
            if (cMTimeRange4.getEndUs() >= cMTimeRange3.getStartUs() && cMTimeRange4.getEndUs() < cMTimeRange3.getEndUs()) {
                cMTimeRangeArr[1] = new CMTimeRange(cMTimeRange4.getEnd(), cMTimeRange3.getEnd().sub(cMTimeRange4.getEnd()));
            } else if (cMTimeRange4.getEndUs() >= cMTimeRange3.getEndUs()) {
                cMTimeRangeArr[1] = null;
            } else if (cMTimeRange4.getEndUs() < cMTimeRange3.getStartUs()) {
                cMTimeRangeArr[1] = cMTimeRange3;
            }
        }
        AppMethodBeat.o(199446);
        return cMTimeRangeArr;
    }

    public CMTime getStart() {
        return this.start;
    }

    public CMTime getDuration() {
        return this.duration;
    }

    public long getDurationUs() {
        AppMethodBeat.i(199447);
        long timeUs = this.duration.getTimeUs();
        AppMethodBeat.o(199447);
        return timeUs;
    }

    public long getStartUs() {
        AppMethodBeat.i(199448);
        long timeUs = this.start.getTimeUs();
        AppMethodBeat.o(199448);
        return timeUs;
    }

    public long getEndUs() {
        AppMethodBeat.i(199449);
        long startUs = getStartUs() + getDurationUs();
        AppMethodBeat.o(199449);
        return startUs;
    }

    public void setStart(CMTime cMTime) {
        AppMethodBeat.i(199450);
        this.start = cMTime;
        this.end = this.start.add(this.duration);
        AppMethodBeat.o(199450);
    }

    public void setDuration(CMTime cMTime) {
        AppMethodBeat.i(199451);
        this.duration = cMTime;
        this.end = this.start.add(this.duration);
        AppMethodBeat.o(199451);
    }

    public boolean containsTime(CMTime cMTime) {
        AppMethodBeat.i(199452);
        if (getStartUs() > cMTime.getTimeUs() || getEndUs() <= cMTime.getTimeUs()) {
            AppMethodBeat.o(199452);
            return false;
        }
        AppMethodBeat.o(199452);
        return true;
    }

    public boolean containsTimeRange(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(199453);
        if (getStartUs() > cMTimeRange.getStartUs() || getEndUs() < cMTimeRange.getEndUs()) {
            AppMethodBeat.o(199453);
            return false;
        }
        AppMethodBeat.o(199453);
        return true;
    }

    public CMTime getEnd() {
        return this.end;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(199454);
        if (!(obj instanceof CMTimeRange)) {
            AppMethodBeat.o(199454);
            return false;
        } else if (!this.start.equals(((CMTimeRange) obj).start) || !this.duration.equals(((CMTimeRange) obj).duration)) {
            AppMethodBeat.o(199454);
            return false;
        } else {
            AppMethodBeat.o(199454);
            return true;
        }
    }

    @Override // java.lang.Object
    public CMTimeRange clone() {
        AppMethodBeat.i(199455);
        CMTimeRange cMTimeRange = new CMTimeRange(this.start, this.duration);
        AppMethodBeat.o(199455);
        return cMTimeRange;
    }

    public CMTimeRange[] split(float f2) {
        AppMethodBeat.i(199456);
        if (f2 < 0.0f || f2 > 1.0f) {
            AppMethodBeat.o(199456);
            return null;
        }
        CMTimeRange cMTimeRange = new CMTimeRange(this.start, getDuration().multi(f2));
        CMTimeRange[] cMTimeRangeArr = {cMTimeRange, new CMTimeRange(cMTimeRange.getEnd(), getDuration().multi(1.0f - f2))};
        AppMethodBeat.o(199456);
        return cMTimeRangeArr;
    }

    public boolean isLegal() {
        AppMethodBeat.i(199457);
        if (getStartUs() < 0 || getDurationUs() <= 0) {
            AppMethodBeat.o(199457);
            return false;
        }
        AppMethodBeat.o(199457);
        return true;
    }

    public String toSimpleString() {
        AppMethodBeat.i(199458);
        String str = "CMTimeRange{startUs=" + this.start.getTimeUs() + ", durationUs=" + this.duration.getTimeUs() + '}';
        AppMethodBeat.o(199458);
        return str;
    }

    public String toString() {
        AppMethodBeat.i(199459);
        String str = "CMTimeRange{start=" + this.start + ", duration=" + this.duration + ", end=" + this.end + '}';
        AppMethodBeat.o(199459);
        return str;
    }
}
