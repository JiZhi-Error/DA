package com.tencent.tavkit.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.MutableCompositionTrack;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.audio.TAVAudioTransition;
import com.tencent.tavkit.composition.model.TAVCompositionTimeRange;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TrackInfo;
import com.tencent.tavkit.composition.video.TAVVideoTransition;
import java.util.List;

public class CompositionUtils {
    private static final String TAG = "CompositionUtils";

    /* access modifiers changed from: package-private */
    public interface TransitionTimeCalculator {
        CMTime transition(int i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.tav.asset.MutableCompositionTrack mutableTrackCompatibleWithTimeRange(com.tencent.tav.asset.MutableComposition r5, com.tencent.tav.coremedia.CMTimeRange r6, int r7) {
        /*
            r4 = 197666(0x30422, float:2.76989E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.util.List r0 = r5.tracksWithMediaType(r7)
            java.util.Iterator r1 = r0.iterator()
        L_0x000e:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0035
            java.lang.Object r0 = r1.next()
            com.tencent.tav.asset.MutableCompositionTrack r0 = (com.tencent.tav.asset.MutableCompositionTrack) r0
            com.tencent.tav.coremedia.CMTimeRange r2 = r0.getTimeRange()
            com.tencent.tav.coremedia.CMTimeRange r2 = com.tencent.tavkit.utils.TAVTimeUtil.getIntersection(r2, r6)
            if (r2 == 0) goto L_0x0031
            com.tencent.tav.coremedia.CMTime r2 = r2.getDuration()
            float r2 = r2.getTimeSeconds()
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x000e
        L_0x0031:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0034:
            return r0
        L_0x0035:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tavkit.utils.CompositionUtils.mutableTrackCompatibleWithTimeRange(com.tencent.tav.asset.MutableComposition, com.tencent.tav.coremedia.CMTimeRange, int):com.tencent.tav.asset.MutableCompositionTrack");
    }

    public static void reloadVideoStartTimeWithTransitionableVideo(final List<? extends TAVTransitionableVideo> list) {
        AppMethodBeat.i(197667);
        reloadStartTimeWithTransitionable(list, new TransitionTimeCalculator() {
            /* class com.tencent.tavkit.utils.CompositionUtils.AnonymousClass1 */

            @Override // com.tencent.tavkit.utils.CompositionUtils.TransitionTimeCalculator
            public final CMTime transition(int i2) {
                AppMethodBeat.i(197664);
                TAVVideoTransition videoTransition = ((TAVTransitionableVideo) list.get(i2)).getVideoTransition();
                if (videoTransition != null) {
                    CMTime duration = videoTransition.getDuration();
                    AppMethodBeat.o(197664);
                    return duration;
                }
                CMTime cMTime = CMTime.CMTimeZero;
                AppMethodBeat.o(197664);
                return cMTime;
            }
        });
        AppMethodBeat.o(197667);
    }

    public static void reloadAudioStartTimeWithTransitionableAudio(final List<? extends TAVTransitionableAudio> list) {
        AppMethodBeat.i(197668);
        reloadStartTimeWithTransitionable(list, new TransitionTimeCalculator() {
            /* class com.tencent.tavkit.utils.CompositionUtils.AnonymousClass2 */

            @Override // com.tencent.tavkit.utils.CompositionUtils.TransitionTimeCalculator
            public final CMTime transition(int i2) {
                AppMethodBeat.i(197665);
                TAVAudioTransition audioTransition = ((TAVTransitionableAudio) list.get(i2)).getAudioTransition();
                if (audioTransition != null) {
                    CMTime duration = audioTransition.getDuration();
                    AppMethodBeat.o(197665);
                    return duration;
                }
                CMTime cMTime = CMTime.CMTimeZero;
                AppMethodBeat.o(197665);
                return cMTime;
            }
        });
        AppMethodBeat.o(197668);
    }

    private static void reloadStartTimeWithTransitionable(List<? extends TAVCompositionTimeRange> list, TransitionTimeCalculator transitionTimeCalculator) {
        CMTime cMTime;
        AppMethodBeat.i(197669);
        CMTime cMTime2 = CMTime.CMTimeZero;
        CMTime cMTime3 = CMTime.CMTimeZero;
        for (int i2 = 0; i2 < list.size(); i2++) {
            TAVCompositionTimeRange tAVCompositionTimeRange = (TAVCompositionTimeRange) list.get(i2);
            CMTime cMTime4 = CMTime.CMTimeZero;
            if (transitionTimeCalculator != null) {
                cMTime = transitionTimeCalculator.transition(i2);
            } else {
                cMTime = cMTime4;
            }
            CMTime duration = tAVCompositionTimeRange.getTimeRange().getDuration();
            if (duration.smallThan(cMTime) || i2 >= list.size() - 1) {
                cMTime3 = CMTime.CMTimeZero;
            } else {
                if (((TAVCompositionTimeRange) list.get(i2 + 1)).getTimeRange().getDuration().smallThan(cMTime)) {
                    cMTime = CMTime.CMTimeZero;
                }
                cMTime3 = cMTime;
            }
            CMTime sub = cMTime2.sub(cMTime3);
            tAVCompositionTimeRange.setStartTime(sub);
            cMTime2 = sub.add(duration);
        }
        AppMethodBeat.o(197669);
    }

    public static void insertTimeRangeToTrack(TrackInfo trackInfo, MutableCompositionTrack mutableCompositionTrack, CMTimeRange cMTimeRange) {
        AppMethodBeat.i(197670);
        try {
            CMTimeRange selectedTimeRange = trackInfo.getSelectedTimeRange();
            if (trackInfo.getTrack() != null) {
                mutableCompositionTrack.insertTimeRange(selectedTimeRange, trackInfo.getTrack(), cMTimeRange.getStart());
                checkScaleTimeRange(mutableCompositionTrack, cMTimeRange, selectedTimeRange);
                AppMethodBeat.o(197670);
            } else if (trackInfo.getCompositionTrackSegment(cMTimeRange) != null) {
                mutableCompositionTrack.insertCompositionTrackSegment(trackInfo.getCompositionTrackSegment(cMTimeRange));
                AppMethodBeat.o(197670);
            } else {
                Logger.e(TAG, "insertTimeRangeToTrack: TrackInfo track and segment are null !!!");
                AppMethodBeat.o(197670);
            }
        } catch (Exception e2) {
            AppMethodBeat.o(197670);
        }
    }

    private static void checkScaleTimeRange(MutableCompositionTrack mutableCompositionTrack, CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        AppMethodBeat.i(197671);
        if (!CMTime.CMTimeInvalid.equalsTo(cMTimeRange.getDuration()) && !cMTimeRange2.getDuration().equalsTo(cMTimeRange.getDuration())) {
            mutableCompositionTrack.scaleTimeRange(new CMTimeRange(cMTimeRange.getStart(), cMTimeRange2.getDuration()), cMTimeRange.getDuration());
        }
        AppMethodBeat.o(197671);
    }

    public static TAVEmptyResource createEmptyResource(CMTime cMTime) {
        AppMethodBeat.i(197672);
        TAVEmptyResource tAVEmptyResource = new TAVEmptyResource(cMTime);
        tAVEmptyResource.setDuration(cMTime);
        tAVEmptyResource.setScaledDuration(cMTime);
        AppMethodBeat.o(197672);
        return tAVEmptyResource;
    }
}
