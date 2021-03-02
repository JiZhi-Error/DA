package com.tencent.tavkit.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.utils.TAVTimeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TAVTimeEffectBuilder {
    private TAVClip clip;
    private TAVTimeEffect[] timeEffects;

    public TAVTimeEffectBuilder() {
    }

    public TAVTimeEffectBuilder(TAVClip tAVClip, List<TAVTimeEffect> list) {
        AppMethodBeat.i(197428);
        this.clip = tAVClip;
        this.timeEffects = (TAVTimeEffect[]) list.toArray();
        AppMethodBeat.o(197428);
    }

    public TAVTimeEffectBuilder(TAVClip tAVClip, TAVTimeEffect... tAVTimeEffectArr) {
        this.clip = tAVClip;
        this.timeEffects = tAVTimeEffectArr;
    }

    public List<TAVClip> build() {
        AppMethodBeat.i(197429);
        ArrayList arrayList = new ArrayList();
        CMTimeRange sourceTimeRange = this.clip.getResource().getSourceTimeRange();
        if (sourceTimeRange == null || sourceTimeRange.getDuration().value == 0) {
            AppMethodBeat.o(197429);
            return null;
        }
        initChannelWithClip(this.clip, arrayList);
        AppMethodBeat.o(197429);
        return arrayList;
    }

    public void setClip(TAVClip tAVClip) {
        this.clip = tAVClip;
    }

    public void setTimeEffects(TAVTimeEffect[] tAVTimeEffectArr) {
        this.timeEffects = tAVTimeEffectArr;
    }

    private void initChannelWithClip(TAVClip tAVClip, List<TAVClip> list) {
        AppMethodBeat.i(197430);
        for (TAVClipSegment tAVClipSegment : segmentsWithClip(tAVClip)) {
            if (tAVClipSegment.timeEffect == null) {
                addSegmentToChannel(tAVClip, tAVClipSegment, list);
            } else {
                addSegmentToChannelWithTimeEffect(tAVClip, tAVClipSegment, list);
            }
        }
        AppMethodBeat.o(197430);
    }

    private void addSegmentToChannel(TAVClip tAVClip, TAVClipSegment tAVClipSegment, List<TAVClip> list) {
        AppMethodBeat.i(197431);
        TAVClip clone = tAVClip.clone();
        clone.getResource().setSourceTimeRange(tAVClipSegment.timeRange);
        clone.getResource().setScaledDuration(tAVClipSegment.timeRange.getDuration());
        list.add(clone);
        AppMethodBeat.o(197431);
    }

    private void addSegmentToChannelWithTimeEffect(TAVClip tAVClip, TAVClipSegment tAVClipSegment, List<TAVClip> list) {
        TAVResource clone;
        AppMethodBeat.i(197432);
        for (int i2 = 0; i2 < tAVClipSegment.timeEffect.getLoopCount(); i2++) {
            if (tAVClip.getResource() instanceof TAVAssetTrackResource) {
                Asset asset = ((TAVAssetTrackResource) tAVClip.getResource()).getAsset();
                if (tAVClipSegment.timeEffect.isFreeze()) {
                    clone = new TAVAssetTrackResource(asset);
                    CMTime cMTime = new CMTime(1, 30);
                    if (tAVClipSegment.timeEffect.isReverse()) {
                        clone.setSourceTimeRange(new CMTimeRange(tAVClipSegment.timeRange.getEnd().sub(cMTime), cMTime));
                    } else {
                        clone.setSourceTimeRange(new CMTimeRange(tAVClipSegment.timeRange.getStart(), cMTime));
                    }
                } else {
                    if (tAVClipSegment.timeEffect.isReverse()) {
                        clone = new TAVAssetTrackResource(asset);
                    } else {
                        clone = new TAVAssetTrackResource(asset);
                    }
                    clone.setSourceTimeRange(new CMTimeRange(tAVClipSegment.timeRange.getStart(), tAVClipSegment.timeEffect.getTimeRange().getDuration().divide((float) tAVClipSegment.timeEffect.getLoopCount())));
                }
            } else {
                clone = tAVClip.getResource().clone();
            }
            if (tAVClipSegment.timeEffect.getLoopCount() == 0) {
                clone.setScaledDuration(tAVClipSegment.timeRange.getDuration());
            } else {
                clone.setScaledDuration(tAVClipSegment.timeRange.getDuration().divide((float) tAVClipSegment.timeEffect.getLoopCount()));
            }
            if (tAVClipSegment.timeEffect.getScaledDuration().value > 0) {
                if (tAVClipSegment.timeEffect.getLoopCount() == 0) {
                    clone.setScaledDuration(tAVClipSegment.timeEffect.getScaledDuration());
                } else {
                    clone.setScaledDuration(tAVClipSegment.timeEffect.getScaledDuration().divide((float) tAVClipSegment.timeEffect.getLoopCount()));
                }
            }
            TAVClip clone2 = tAVClip.clone();
            clone2.setResource(clone);
            list.add(clone2);
        }
        AppMethodBeat.o(197432);
    }

    private List<TAVClipSegment> segmentsWithClip(TAVClip tAVClip) {
        AppMethodBeat.i(197433);
        TAVResource resource = tAVClip.getResource();
        CMTime start = resource.getSourceTimeRange().getStart();
        ArrayList arrayList = new ArrayList();
        CMTime traverseTimeEffect = traverseTimeEffect(tAVClip, resource, arrayList, start);
        CMTime sub = resource.getSourceTimeRange().getEnd().sub(traverseTimeEffect);
        if (sub.value > 0) {
            TAVClipSegment tAVClipSegment = new TAVClipSegment();
            tAVClipSegment.timeRange = new CMTimeRange(traverseTimeEffect, sub);
            arrayList.add(tAVClipSegment);
        }
        AppMethodBeat.o(197433);
        return arrayList;
    }

    private CMTime traverseTimeEffect(TAVClip tAVClip, TAVResource tAVResource, List<TAVClipSegment> list, CMTime cMTime) {
        AppMethodBeat.i(197434);
        List<TAVTimeEffect> availableTimeEffectsFromClip = availableTimeEffectsFromClip(tAVClip);
        if (availableTimeEffectsFromClip == null) {
            AppMethodBeat.o(197434);
        } else {
            for (TAVTimeEffect tAVTimeEffect : availableTimeEffectsFromClip) {
                CMTime sub = tAVTimeEffect.getTimeRange().getStart().sub(cMTime);
                if (sub.value > 0) {
                    TAVClipSegment tAVClipSegment = new TAVClipSegment();
                    tAVClipSegment.timeRange = new CMTimeRange(cMTime, sub);
                    list.add(tAVClipSegment);
                }
                TAVClipSegment tAVClipSegment2 = new TAVClipSegment();
                tAVClipSegment2.timeRange = new CMTimeRange(tAVTimeEffect.getTimeRange().getStart().add(tAVResource.getSourceTimeRange().getStart()), tAVTimeEffect.getTimeRange().getDuration());
                tAVClipSegment2.timeEffect = tAVTimeEffect;
                list.add(tAVClipSegment2);
                cMTime = tAVClipSegment2.timeRange.getEnd();
            }
            AppMethodBeat.o(197434);
        }
        return cMTime;
    }

    private List<TAVTimeEffect> availableTimeEffectsFromClip(TAVClip tAVClip) {
        boolean z;
        AppMethodBeat.i(197435);
        if (this.timeEffects == null) {
            AppMethodBeat.o(197435);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        TAVResource resource = tAVClip.getResource();
        TAVTimeEffect[] tAVTimeEffectArr = this.timeEffects;
        for (TAVTimeEffect tAVTimeEffect : tAVTimeEffectArr) {
            CMTimeRange intersection = TAVTimeUtil.getIntersection(resource.getSourceTimeRange(), tAVTimeEffect.getTimeRange());
            if (intersection != null && intersection.getDuration().value > 0) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    CMTimeRange intersection2 = TAVTimeUtil.getIntersection(((TAVTimeEffect) it.next()).getTimeRange(), intersection);
                    if (intersection2 != null && intersection2.getDuration().value > 0) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    arrayList.add(tAVTimeEffect);
                }
            }
        }
        Collections.sort(arrayList, new Comparator<TAVTimeEffect>() {
            /* class com.tencent.tavkit.component.TAVTimeEffectBuilder.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(TAVTimeEffect tAVTimeEffect, TAVTimeEffect tAVTimeEffect2) {
                AppMethodBeat.i(197427);
                int compare = compare(tAVTimeEffect, tAVTimeEffect2);
                AppMethodBeat.o(197427);
                return compare;
            }

            public int compare(TAVTimeEffect tAVTimeEffect, TAVTimeEffect tAVTimeEffect2) {
                AppMethodBeat.i(197426);
                CMTime start = tAVTimeEffect.getTimeRange().getStart();
                CMTime start2 = tAVTimeEffect2.getTimeRange().getStart();
                if (start.equalsTo(start2)) {
                    AppMethodBeat.o(197426);
                    return 0;
                } else if (start.bigThan(start2)) {
                    AppMethodBeat.o(197426);
                    return 1;
                } else {
                    AppMethodBeat.o(197426);
                    return -1;
                }
            }
        });
        AppMethodBeat.o(197435);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public static class TAVClipSegment {
        private TAVTimeEffect timeEffect;
        private CMTimeRange timeRange;

        private TAVClipSegment() {
        }
    }
}
