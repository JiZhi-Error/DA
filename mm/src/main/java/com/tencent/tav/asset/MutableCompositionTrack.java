package com.tencent.tav.asset;

import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.ImageDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MutableCompositionTrack extends CompositionTrack {
    private String extendedLanguageTag;
    private String languageCode;

    MutableCompositionTrack(int i2, int i3) {
        this.mediaType = i2;
        this.trackID = i3;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public void setLanguageCode(String str) {
        this.languageCode = str;
    }

    /* access modifiers changed from: package-private */
    public void setNaturalSize(CGSize cGSize) {
        this.naturalSize = cGSize;
    }

    public String getExtendedLanguageTag() {
        return this.extendedLanguageTag;
    }

    public void setExtendedLanguageTag(String str) {
        this.extendedLanguageTag = str;
    }

    public void setNaturalTimeScale(int i2) {
        this.naturalTimeScale = i2;
    }

    @Override // com.tencent.tav.asset.AssetTrack
    public void setPreferredTransform(Matrix matrix) {
        this.preferredTransform = matrix;
    }

    @Override // com.tencent.tav.asset.AssetTrack
    public void setPreferredVolume(float f2) {
        this.preferredVolume = f2;
    }

    public void setSegments(List<CompositionTrackSegment> list) {
        this.segments = list;
    }

    @Override // com.tencent.tav.asset.AssetTrack
    public CMTime getDuration() {
        AppMethodBeat.i(217671);
        CMTime cMTime = CMTime.CMTimeZero;
        for (int i2 = 0; i2 < this.segments.size(); i2++) {
            cMTime = cMTime.add(((CompositionTrackSegment) this.segments.get(i2)).getScaleDuration());
        }
        AppMethodBeat.o(217671);
        return cMTime;
    }

    public boolean insertTimeRange(CMTimeRange cMTimeRange, AssetTrack assetTrack, CMTime cMTime) {
        AppMethodBeat.i(217672);
        if (this.timeRange == null) {
            CMTime cMTime2 = CMTime.CMTimeZero;
            this.timeRange = new CMTimeRange(cMTime2, cMTime2);
        }
        if ((this.naturalSize == null || this.naturalSize.equals(CGSize.CGSizeZero)) && assetTrack != null) {
            this.naturalSize = assetTrack.naturalSize;
        }
        if (this.preferredRotation == 0 && assetTrack != null) {
            this.preferredRotation = assetTrack.preferredRotation;
        }
        if (cMTime == CMTime.CMTimeInvalid || cMTime.getValue() < 0) {
            insertTimeRange(cMTimeRange, new CMTimeRange(this.timeRange.getDuration(), cMTimeRange.getDuration()), assetTrack, -1);
            AppMethodBeat.o(217672);
            return true;
        } else if (cMTimeRange.getDuration().value <= 0) {
            AppMethodBeat.o(217672);
            return false;
        } else {
            CMTimeRange cMTimeRange2 = new CMTimeRange(cMTime, cMTimeRange.getDuration());
            if (this.segments.size() == 0) {
                if (cMTime.value > 0) {
                    this.segments.add(new CompositionTrackSegment(new CMTimeRange(CMTime.CMTimeZero, cMTime)));
                }
                insertTimeRange(cMTimeRange, cMTimeRange2, assetTrack, -1);
                AppMethodBeat.o(217672);
                return true;
            }
            int findSegmentIndexAt = findSegmentIndexAt(cMTime, false);
            if (findSegmentIndexAt != -1) {
                CMTime segmentStartCMTime = getSegmentStartCMTime(findSegmentIndexAt);
                if (cMTime.equalsTo(segmentStartCMTime)) {
                    insertTimeRange(cMTimeRange, cMTimeRange2, assetTrack, findSegmentIndexAt);
                } else {
                    CompositionTrackSegment[] split = split((CompositionTrackSegment) this.segments.remove(findSegmentIndexAt), cMTime.sub(segmentStartCMTime));
                    if (split[1].scaleDuration.getTimeUs() > 0) {
                        this.segments.add(findSegmentIndexAt, split[1]);
                    }
                    insertTimeRange(cMTimeRange, cMTimeRange, assetTrack, findSegmentIndexAt);
                    if (split[0].scaleDuration.getTimeUs() > 0) {
                        this.segments.add(findSegmentIndexAt, split[0]);
                    }
                }
            } else {
                CMTime segmentStartCMTime2 = getSegmentStartCMTime(this.segments.size());
                if (cMTime.bigThan(segmentStartCMTime2)) {
                    this.segments.add(new CompositionTrackSegment(new CMTimeRange(segmentStartCMTime2, cMTime.sub(segmentStartCMTime2))));
                }
                insertTimeRange(cMTimeRange, cMTimeRange2, assetTrack, -1);
            }
            updateTimeRange();
            AppMethodBeat.o(217672);
            return true;
        }
    }

    public void insertCompositionTrackSegment(CompositionTrackSegment compositionTrackSegment) {
        AppMethodBeat.i(217673);
        if ((this.naturalSize == null || this.naturalSize.equals(CGSize.CGSizeZero)) && compositionTrackSegment.getSourceType() == 3 && !TextUtils.isEmpty(compositionTrackSegment.getSourcePath())) {
            this.naturalSize = ImageDecoder.getDefaultOutputImageSize(compositionTrackSegment.getSourcePath());
        }
        CMTimeRange target = compositionTrackSegment.timeMapping.getTarget();
        CMTime start = target.getStart();
        if (this.segments.size() == 0) {
            if (target.getStart().value > 0) {
                this.segments.add(new CompositionTrackSegment(new CMTimeRange(CMTime.CMTimeZero, target.getStart())));
            }
            insertSegment(compositionTrackSegment, -1);
            AppMethodBeat.o(217673);
            return;
        }
        int findSegmentIndexAt = findSegmentIndexAt(start, false);
        if (findSegmentIndexAt != -1) {
            CMTime segmentStartCMTime = getSegmentStartCMTime(findSegmentIndexAt);
            if (start.equalsTo(segmentStartCMTime)) {
                insertSegment(compositionTrackSegment, findSegmentIndexAt);
            } else {
                CompositionTrackSegment[] split = split((CompositionTrackSegment) this.segments.remove(findSegmentIndexAt), start.sub(segmentStartCMTime));
                if (split[1].scaleDuration.getTimeUs() > 0) {
                    this.segments.add(findSegmentIndexAt, split[1]);
                }
                insertSegment(compositionTrackSegment, findSegmentIndexAt);
                if (split[0].scaleDuration.getTimeUs() > 0) {
                    this.segments.add(findSegmentIndexAt, split[0]);
                }
            }
        } else {
            CMTime segmentStartCMTime2 = getSegmentStartCMTime(this.segments.size());
            if (start.bigThan(segmentStartCMTime2)) {
                this.segments.add(new CompositionTrackSegment(new CMTimeRange(segmentStartCMTime2, start.sub(segmentStartCMTime2))));
            }
            insertSegment(compositionTrackSegment, -1);
        }
        CMTime cMTime = CMTime.CMTimeZero;
        for (CompositionTrackSegment compositionTrackSegment2 : this.segments) {
            compositionTrackSegment2.updateTargetTimeRange(new CMTimeRange(cMTime, compositionTrackSegment2.scaleDuration));
            cMTime = cMTime.add(compositionTrackSegment2.scaleDuration);
        }
        updateTimeRange();
        AppMethodBeat.o(217673);
    }

    public void insertEmptyTimeRange(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(217674);
        insertTimeRange(cMTimeRange, null, cMTimeRange.getStart());
        AppMethodBeat.o(217674);
    }

    public void removeTimeRange(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(217675);
        if (cMTimeRange == null || !cMTimeRange.isLegal()) {
            AppMethodBeat.o(217675);
            return;
        }
        insertEmptyTimeRange(new CMTimeRange(cMTimeRange.getStart(), CMTime.CMTimeOne));
        insertEmptyTimeRange(new CMTimeRange(cMTimeRange.getEnd().add(CMTime.CMTimeOne), CMTime.CMTimeOne));
        int findSegmentIndexAt = findSegmentIndexAt(cMTimeRange.getStart(), false);
        int findSegmentIndexAt2 = findSegmentIndexAt(cMTimeRange.getEnd().add(CMTime.CMTimeOne), false);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.segments.size(); i2++) {
            if (i2 < findSegmentIndexAt || i2 > findSegmentIndexAt2) {
                arrayList.add(this.segments.get(i2));
            }
        }
        this.segments = arrayList;
        updateTimeRange();
        updateSegmentsStartTimeAfterRemoved(cMTimeRange);
        AppMethodBeat.o(217675);
    }

    public void scaleTimeRange(CMTimeRange cMTimeRange, CMTime cMTime) {
        int i2;
        CMTime sub;
        AppMethodBeat.i(217676);
        CMTime start = cMTimeRange.getStart();
        CMTime end = cMTimeRange.getEnd();
        if (cMTimeRange.getDuration().getTimeUs() <= 0 || this.segments == null || this.segments.size() == 0) {
            AppMethodBeat.o(217676);
            return;
        }
        int findSegmentIndexAt = findSegmentIndexAt(cMTimeRange.getStart(), false);
        if (findSegmentIndexAt == -1) {
            AppMethodBeat.o(217676);
            return;
        }
        int findSegmentIndexAt2 = findSegmentIndexAt(cMTimeRange.getEnd(), false);
        if (findSegmentIndexAt2 == -1) {
            i2 = this.segments.size() - 1;
        } else if (getSegmentStartCMTime(findSegmentIndexAt2).equalsTo(cMTimeRange.getEnd())) {
            i2 = findSegmentIndexAt2 - 1;
        } else {
            i2 = findSegmentIndexAt2;
        }
        if (findSegmentIndexAt == i2) {
            CMTime segmentStartCMTime = getSegmentStartCMTime(findSegmentIndexAt);
            CompositionTrackSegment compositionTrackSegment = (CompositionTrackSegment) this.segments.remove(findSegmentIndexAt);
            if (end.smallThan(segmentStartCMTime.add(compositionTrackSegment.scaleDuration))) {
                CompositionTrackSegment[] split = split(compositionTrackSegment, start.sub(segmentStartCMTime));
                compositionTrackSegment = split[0];
                if (split[1].scaleDuration.getTimeUs() > 0) {
                    this.segments.add(findSegmentIndexAt, split[1]);
                }
            }
            if (start.bigThan(segmentStartCMTime)) {
                CompositionTrackSegment[] split2 = split(compositionTrackSegment, start.sub(segmentStartCMTime));
                split2[1].scaleDuration = cMTime;
                if (split2[1].scaleDuration.getTimeUs() > 0) {
                    this.segments.add(findSegmentIndexAt, split2[1]);
                }
                if (split2[0].scaleDuration.getTimeUs() > 0) {
                    this.segments.add(findSegmentIndexAt, split2[0]);
                }
            } else {
                compositionTrackSegment.scaleDuration = cMTime;
                this.segments.add(findSegmentIndexAt, compositionTrackSegment);
            }
        } else {
            CMTime segmentStartCMTime2 = getSegmentStartCMTime(findSegmentIndexAt);
            CMTime segmentStartCMTime3 = getSegmentStartCMTime(i2);
            if (start.bigThan(segmentStartCMTime2)) {
                CompositionTrackSegment[] split3 = split((CompositionTrackSegment) this.segments.remove(findSegmentIndexAt), start.sub(segmentStartCMTime2));
                split3[1].scaleDuration = cMTime.multi(split3[1].scaleDuration).divide(cMTimeRange.getDuration());
                sub = cMTime.sub(split3[1].scaleDuration);
                if (split3[1].scaleDuration.getTimeUs() > 0) {
                    this.segments.add(findSegmentIndexAt, split3[1]);
                }
                if (split3[0].scaleDuration.getTimeUs() > 0) {
                    this.segments.add(findSegmentIndexAt, split3[0]);
                }
            } else {
                CompositionTrackSegment compositionTrackSegment2 = (CompositionTrackSegment) this.segments.get(findSegmentIndexAt);
                compositionTrackSegment2.scaleDuration = cMTime.multi(compositionTrackSegment2.scaleDuration).divide(cMTimeRange.getDuration());
                sub = cMTime.sub(compositionTrackSegment2.scaleDuration);
            }
            CMTime cMTime2 = sub;
            for (int i3 = findSegmentIndexAt + 1; i3 < i2; i3++) {
                CompositionTrackSegment compositionTrackSegment3 = (CompositionTrackSegment) this.segments.get(i3);
                compositionTrackSegment3.scaleDuration = cMTime2.multi(compositionTrackSegment3.scaleDuration).divide(cMTimeRange.getDuration());
                cMTime2 = cMTime2.sub(compositionTrackSegment3.scaleDuration);
            }
            CompositionTrackSegment compositionTrackSegment4 = (CompositionTrackSegment) this.segments.get(i2);
            if (end.smallThan(segmentStartCMTime3.add(compositionTrackSegment4.scaleDuration))) {
                CompositionTrackSegment[] split4 = split((CompositionTrackSegment) this.segments.remove(i2), end.sub(segmentStartCMTime3));
                split4[0].scaleDuration = cMTime2;
                if (split4[1].scaleDuration.getTimeUs() > 0) {
                    this.segments.add(i2, split4[1]);
                }
                if (split4[0].scaleDuration.getTimeUs() > 0) {
                    this.segments.add(i2, split4[0]);
                }
            } else {
                compositionTrackSegment4.scaleDuration = cMTime2;
            }
        }
        CMTime cMTime3 = CMTime.CMTimeZero;
        for (CompositionTrackSegment compositionTrackSegment5 : this.segments) {
            compositionTrackSegment5.updateTargetTimeRange(new CMTimeRange(cMTime3, compositionTrackSegment5.scaleDuration));
            cMTime3 = cMTime3.add(compositionTrackSegment5.scaleDuration);
        }
        updateTimeRange();
        AppMethodBeat.o(217676);
    }

    public boolean validateTrackSegments(List<CompositionTrackSegment> list) {
        return false;
    }

    public void clipRangeAndRemoveOutRange(CMTimeRange cMTimeRange) {
        int i2;
        AppMethodBeat.i(217677);
        if (cMTimeRange == null || cMTimeRange.getDuration().getTimeUs() <= 0 || this.segments == null || this.segments.size() == 0) {
            AppMethodBeat.o(217677);
            return;
        }
        CMTime start = cMTimeRange.getStart();
        CMTime end = cMTimeRange.getEnd();
        int findSegmentIndexAt = findSegmentIndexAt(start, false);
        if (findSegmentIndexAt == -1) {
            AppMethodBeat.o(217677);
            return;
        }
        int findSegmentIndexAt2 = findSegmentIndexAt(end, false);
        if (findSegmentIndexAt2 == -1) {
            i2 = this.segments.size() - 1;
        } else if (getSegmentStartTime(findSegmentIndexAt2) == end.getTimeUs()) {
            i2 = findSegmentIndexAt2 - 1;
        } else {
            i2 = findSegmentIndexAt2;
        }
        long segmentStartTime = getSegmentStartTime(findSegmentIndexAt);
        long segmentStartTime2 = getSegmentStartTime(i2);
        CompositionTrackSegment compositionTrackSegment = (CompositionTrackSegment) this.segments.get(findSegmentIndexAt);
        CompositionTrackSegment compositionTrackSegment2 = (CompositionTrackSegment) this.segments.get(i2);
        long timeUs = cMTimeRange.getEnd().getTimeUs() - segmentStartTime2;
        compositionTrackSegment2.timeRange = new CMTimeRange(compositionTrackSegment2.timeRange.getStart(), TimeUtil.us2CMTime((long) (((float) (compositionTrackSegment2.scaleDuration.getTimeUs() / compositionTrackSegment2.timeRange.getDuration().getTimeUs())) * ((float) timeUs))));
        compositionTrackSegment2.scaleDuration = TimeUtil.us2CMTime(timeUs);
        float timeUs2 = (float) (compositionTrackSegment.scaleDuration.getTimeUs() / compositionTrackSegment.timeRange.getDuration().getTimeUs());
        long timeUs3 = cMTimeRange.getStart().getTimeUs() - segmentStartTime;
        long j2 = (long) (timeUs2 * ((float) timeUs3));
        compositionTrackSegment.timeRange = new CMTimeRange(TimeUtil.us2CMTime(compositionTrackSegment.timeRange.getStart().getTimeUs() + j2), TimeUtil.us2CMTime(compositionTrackSegment.timeRange.getDuration().getTimeUs() - j2));
        compositionTrackSegment.scaleDuration = TimeUtil.us2CMTime(compositionTrackSegment.scaleDuration.getTimeUs() - timeUs3);
        for (int size = this.segments.size() - 1; size >= 0; size--) {
            if (size > i2 || size < findSegmentIndexAt) {
                this.segments.remove(size);
            }
        }
        AppMethodBeat.o(217677);
    }

    private void updateTimeRange() {
        AppMethodBeat.i(217678);
        if (this.segments == null || this.segments.size() <= 0) {
            CMTime cMTime = CMTime.CMTimeZero;
            this.timeRange = new CMTimeRange(cMTime, cMTime);
            AppMethodBeat.o(217678);
            return;
        }
        this.timeRange = new CMTimeRange(((CompositionTrackSegment) this.segments.get(0)).timeRange.getStart(), getDuration());
        AppMethodBeat.o(217678);
    }

    private void insertTimeRange(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2, AssetTrack assetTrack, int i2) {
        CompositionTrackSegment compositionTrackSegment;
        AppMethodBeat.i(217679);
        if (assetTrack instanceof CompositionTrack) {
            insertTimeRange(cMTimeRange, cMTimeRange2, (CompositionTrack) assetTrack, i2);
            AppMethodBeat.o(217679);
            return;
        }
        if (assetTrack != null) {
            compositionTrackSegment = new CompositionTrackSegment(assetTrack.getSourcePath(), assetTrack.getTrackID(), cMTimeRange, cMTimeRange2, assetTrack.getMediaType());
        } else {
            compositionTrackSegment = new CompositionTrackSegment(cMTimeRange2);
        }
        if (i2 >= 0) {
            this.segments.add(i2, compositionTrackSegment);
        } else {
            this.segments.add(compositionTrackSegment);
        }
        updateTimeRange();
        AppMethodBeat.o(217679);
    }

    private void insertSegment(CompositionTrackSegment compositionTrackSegment, int i2) {
        AppMethodBeat.i(217680);
        if (i2 >= 0) {
            this.segments.add(i2, compositionTrackSegment);
        } else {
            this.segments.add(compositionTrackSegment);
        }
        updateTimeRange();
        AppMethodBeat.o(217680);
    }

    private void insertTimeRange(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2, CompositionTrack compositionTrack, int i2) {
        AppMethodBeat.i(217681);
        CMTime start = cMTimeRange.getStart();
        CMTime end = cMTimeRange.getEnd();
        CMTime start2 = cMTimeRange2.getStart();
        float durationUs = (((float) cMTimeRange2.getDurationUs()) * 1.0f) / ((float) cMTimeRange.getDurationUs());
        CMTime cMTime = start2;
        for (CompositionTrackSegment compositionTrackSegment : compositionTrack.getSegments()) {
            CMTimeRange target = compositionTrackSegment.getTimeMapping().getTarget();
            CMTime start3 = target.getStart();
            CMTime end2 = target.getEnd();
            CMTime clone = start3.clone();
            CMTime clone2 = end2.clone();
            if (start3.smallThan(start)) {
                clone = cMTimeRange.getStart();
            } else if (start3.bigThan(end)) {
                clone = CMTime.CMTimeInvalid;
            }
            if (end2.smallThan(start)) {
                clone2 = CMTime.CMTimeInvalid;
            } else if (end2.bigThan(end)) {
                clone2 = end;
            }
            if (!(clone.equalsTo(clone2) || clone == CMTime.CMTimeInvalid || clone2 == CMTime.CMTimeInvalid)) {
                CMTime sub = clone.sub(start3);
                CMTime sub2 = clone2.sub(clone);
                CMTime multi = sub2.multi(durationUs);
                CMTimeRange cMTimeRange3 = new CMTimeRange(compositionTrackSegment.timeMapping.getSource().getStart().add(sub.divide((((float) compositionTrackSegment.timeMapping.getTarget().getDurationUs()) * 1.0f) / ((float) compositionTrackSegment.timeMapping.getSource().getDurationUs()))), sub2);
                CMTimeRange cMTimeRange4 = new CMTimeRange(cMTime, multi);
                CMTime add = cMTime.add(multi);
                CompositionTrackSegment compositionTrackSegment2 = new CompositionTrackSegment(compositionTrackSegment.getSourcePath(), this.trackID, cMTimeRange3, cMTimeRange4, compositionTrackSegment.getSourceType());
                if (i2 >= 0) {
                    this.segments.add(i2, compositionTrackSegment2);
                    i2++;
                    cMTime = add;
                } else {
                    this.segments.add(compositionTrackSegment2);
                    cMTime = add;
                }
            }
        }
        updateTimeRange();
        AppMethodBeat.o(217681);
    }

    private void updateSegmentStartTimeAfterInserted(CMTime cMTime, CMTimeRange cMTimeRange) {
        AppMethodBeat.i(217682);
        int findSegmentIndexAt = findSegmentIndexAt(cMTime, false);
        if (findSegmentIndexAt >= 0 && findSegmentIndexAt < this.segments.size()) {
            for (int i2 = findSegmentIndexAt + 1; i2 < this.segments.size(); i2++) {
                CompositionTrackSegment compositionTrackSegment = (CompositionTrackSegment) this.segments.get(i2);
                CMTimeRange target = compositionTrackSegment.getTimeMapping().getTarget();
                compositionTrackSegment.updateTargetTimeRange(new CMTimeRange(target.getStart().add(cMTimeRange.getDuration()), target.getDuration().clone()));
            }
        }
        AppMethodBeat.o(217682);
    }

    private void updateSegmentsStartTimeAfterRemoved(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(217683);
        int findSegmentIndexAt = findSegmentIndexAt(cMTimeRange.getStart(), false);
        if (findSegmentIndexAt >= 0 && findSegmentIndexAt < this.segments.size()) {
            while (findSegmentIndexAt < this.segments.size()) {
                CompositionTrackSegment compositionTrackSegment = (CompositionTrackSegment) this.segments.get(findSegmentIndexAt);
                CMTimeRange target = compositionTrackSegment.getTimeMapping().getTarget();
                compositionTrackSegment.updateTargetTimeRange(new CMTimeRange(target.getStart().sub(cMTimeRange.getDuration().add(CMTime.CMTimeOne).add(CMTime.CMTimeOne)), target.getDuration().clone()));
                findSegmentIndexAt++;
            }
        }
        AppMethodBeat.o(217683);
    }

    private int findSegmentIndexAt(CMTime cMTime, boolean z) {
        int i2;
        boolean z2 = false;
        AppMethodBeat.i(217684);
        CMTime cMTime2 = CMTime.CMTimeZero;
        Iterator it = this.segments.iterator();
        int i3 = 0;
        CMTime cMTime3 = cMTime2;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CompositionTrackSegment compositionTrackSegment = (CompositionTrackSegment) it.next();
            if (compositionTrackSegment.timeRange.containsTime(cMTime)) {
                z2 = true;
                break;
            }
            cMTime3 = compositionTrackSegment.timeRange.getEnd();
            i3++;
        }
        if (z2 || !cMTime.equalsTo(cMTime3) || i3 <= 0 || !z) {
            i2 = i3;
        } else {
            z2 = true;
            i2 = i3 - 1;
        }
        if (z2) {
            AppMethodBeat.o(217684);
            return i2;
        }
        AppMethodBeat.o(217684);
        return -1;
    }

    private long getSegmentStartTime(int i2) {
        AppMethodBeat.i(217685);
        CMTime cMTime = CMTime.CMTimeZero;
        int i3 = 0;
        while (i3 < i2 && i3 < this.segments.size()) {
            cMTime = cMTime.add(((CompositionTrackSegment) this.segments.get(i3)).getScaleDuration());
            i3++;
        }
        long timeUs = cMTime.getTimeUs();
        AppMethodBeat.o(217685);
        return timeUs;
    }

    private CMTime getSegmentStartCMTime(int i2) {
        AppMethodBeat.i(217686);
        CMTime cMTime = CMTime.CMTimeZero;
        int i3 = 0;
        while (i3 < i2 && i3 < this.segments.size()) {
            cMTime = cMTime.add(((CompositionTrackSegment) this.segments.get(i3)).getScaleDuration());
            i3++;
        }
        AppMethodBeat.o(217686);
        return cMTime;
    }

    private CompositionTrackSegment[] split(CompositionTrackSegment compositionTrackSegment, CMTime cMTime) {
        AppMethodBeat.i(217687);
        if (compositionTrackSegment != null && !compositionTrackSegment.timeRange.getDuration().smallThan(cMTime)) {
            float timeUs = (((float) cMTime.getTimeUs()) * 1.0f) / ((float) compositionTrackSegment.timeRange.getDurationUs());
            CMTimeRange[] split = compositionTrackSegment.getTimeMapping().getTarget().split(timeUs);
            CMTimeRange[] split2 = compositionTrackSegment.getTimeMapping().getSource().split(timeUs);
            if (!(split == null || split2 == null)) {
                CompositionTrackSegment compositionTrackSegment2 = new CompositionTrackSegment(compositionTrackSegment.getSourcePath(), compositionTrackSegment.getSourceTrackID(), split2[0], split[0], compositionTrackSegment.getSourceType());
                CompositionTrackSegment compositionTrackSegment3 = new CompositionTrackSegment(compositionTrackSegment.getSourcePath(), compositionTrackSegment.getSourceTrackID(), split2[1], split[1], compositionTrackSegment.getSourceType());
                compositionTrackSegment2.scaleDuration = cMTime;
                compositionTrackSegment3.scaleDuration = compositionTrackSegment.scaleDuration.sub(cMTime);
                CompositionTrackSegment[] compositionTrackSegmentArr = {compositionTrackSegment2, compositionTrackSegment3};
                AppMethodBeat.o(217687);
                return compositionTrackSegmentArr;
            }
        }
        AppMethodBeat.o(217687);
        return null;
    }
}
