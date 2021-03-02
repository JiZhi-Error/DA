package com.tencent.tavkit.composition.builder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.video.TAVVideoCompositionInstruction;
import com.tencent.tavkit.composition.video.TAVVideoCompositionLayerInstruction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* access modifiers changed from: package-private */
public class VideoInstructionsBuilder {
    private final BuilderModel builderModel;
    private final List<TAVVideoCompositionInstruction> outputInstructions = new ArrayList();

    VideoInstructionsBuilder(BuilderModel builderModel2) {
        AppMethodBeat.i(197542);
        this.builderModel = builderModel2;
        AppMethodBeat.o(197542);
    }

    /* access modifiers changed from: package-private */
    public List<TAVVideoCompositionInstruction> build() {
        AppMethodBeat.i(197543);
        List<List<TAVVideoCompositionLayerInstruction>> buildMainLayerInstructions = buildMainLayerInstructions();
        List<TAVVideoCompositionLayerInstruction> buildOverlayLayerInstructions = buildOverlayLayerInstructions();
        buildInstructions(buildMainLayerInstructions, buildOverlayLayerInstructions, calculateSlicesForLayerInstructions(concatAndSortLayers(buildMainLayerInstructions, buildOverlayLayerInstructions)));
        List<TAVVideoCompositionInstruction> list = this.outputInstructions;
        AppMethodBeat.o(197543);
        return list;
    }

    /* access modifiers changed from: package-private */
    public List<List<TAVVideoCompositionLayerInstruction>> buildMainLayerInstructions() {
        AppMethodBeat.i(197544);
        ArrayList arrayList = new ArrayList();
        for (List<VideoInfo> list : this.builderModel.getMainVideoTrackInfo()) {
            ArrayList arrayList2 = new ArrayList();
            for (VideoInfo videoInfo : list) {
                arrayList2.add(new TAVVideoCompositionLayerInstruction(videoInfo.compositionTrack.getTrackID(), videoInfo.clip));
            }
            arrayList.add(arrayList2);
        }
        fixLastLayerDuration(arrayList);
        AppMethodBeat.o(197544);
        return arrayList;
    }

    private void fixLastLayerDuration(List<List<TAVVideoCompositionLayerInstruction>> list) {
        AppMethodBeat.i(197545);
        if (list == null || list.size() != 1) {
            AppMethodBeat.o(197545);
            return;
        }
        List<TAVVideoCompositionLayerInstruction> list2 = list.get(0);
        if (list2 == null || list2.isEmpty()) {
            AppMethodBeat.o(197545);
            return;
        }
        TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction = list2.get(list2.size() - 1);
        CMTime frameDuration = this.builderModel.getTavComposition().getFrameDuration();
        if (frameDuration == null) {
            frameDuration = new CMTime(1, 30);
        }
        tAVVideoCompositionLayerInstruction.setTimeRange(new CMTimeRange(tAVVideoCompositionLayerInstruction.getTimeRange().getStart(), tAVVideoCompositionLayerInstruction.getTimeRange().getDuration().add(frameDuration)));
        AppMethodBeat.o(197545);
    }

    /* access modifiers changed from: package-private */
    public List<TAVVideoCompositionLayerInstruction> buildOverlayLayerInstructions() {
        AppMethodBeat.i(197546);
        ArrayList arrayList = new ArrayList();
        for (VideoOverlayInfo videoOverlayInfo : this.builderModel.getOverlayTrackInfo()) {
            arrayList.add(videoOverlayInfo.convertToLayerInstruction());
        }
        AppMethodBeat.o(197546);
        return arrayList;
    }

    private static List<Slice> calculateSlicesForLayerInstructions(List<TAVVideoCompositionLayerInstruction> list) {
        AppMethodBeat.i(197547);
        TreeSet treeSet = new TreeSet(new Comparator<CMTime>() {
            /* class com.tencent.tavkit.composition.builder.VideoInstructionsBuilder.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(CMTime cMTime, CMTime cMTime2) {
                AppMethodBeat.i(197539);
                int compare = compare(cMTime, cMTime2);
                AppMethodBeat.o(197539);
                return compare;
            }

            public final int compare(CMTime cMTime, CMTime cMTime2) {
                AppMethodBeat.i(197538);
                int value = (int) cMTime.sub(cMTime2).getValue();
                AppMethodBeat.o(197538);
                return value;
            }
        });
        for (TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction : list) {
            treeSet.add(tAVVideoCompositionLayerInstruction.getTimeRange().getStart());
            treeSet.add(tAVVideoCompositionLayerInstruction.getTimeRange().getEnd());
        }
        ArrayList arrayList = new ArrayList();
        CMTime cMTime = (CMTime) treeSet.pollFirst();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            cMTime = (CMTime) it.next();
            CMTimeRange cMTimeRange = new CMTimeRange(cMTime, cMTime.sub(cMTime));
            ArrayList arrayList2 = new ArrayList();
            for (TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction2 : list) {
                if (tAVVideoCompositionLayerInstruction2.getTimeRange().getEnd().getTimeUs() >= cMTime.getTimeUs() && tAVVideoCompositionLayerInstruction2.getTimeRange().getStart().getTimeUs() <= cMTime.getTimeUs()) {
                    arrayList2.add(tAVVideoCompositionLayerInstruction2);
                }
            }
            arrayList.add(new Slice(cMTimeRange, arrayList2));
        }
        AppMethodBeat.o(197547);
        return arrayList;
    }

    private List<TAVVideoCompositionLayerInstruction> concatAndSortLayers(List<List<TAVVideoCompositionLayerInstruction>> list, List<TAVVideoCompositionLayerInstruction> list2) {
        AppMethodBeat.i(197548);
        ArrayList arrayList = new ArrayList();
        for (List<TAVVideoCompositionLayerInstruction> list3 : list) {
            arrayList.addAll(list3);
        }
        arrayList.addAll(list2);
        Collections.sort(arrayList, new Comparator<TAVVideoCompositionLayerInstruction>() {
            /* class com.tencent.tavkit.composition.builder.VideoInstructionsBuilder.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction, TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction2) {
                AppMethodBeat.i(197541);
                int compare = compare(tAVVideoCompositionLayerInstruction, tAVVideoCompositionLayerInstruction2);
                AppMethodBeat.o(197541);
                return compare;
            }

            public int compare(TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction, TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction2) {
                AppMethodBeat.i(197540);
                CMTime start = tAVVideoCompositionLayerInstruction.getTimeRange().getStart();
                CMTime start2 = tAVVideoCompositionLayerInstruction2.getTimeRange().getStart();
                if (start.equalsTo(start2)) {
                    AppMethodBeat.o(197540);
                    return 0;
                } else if (start.smallThan(start2)) {
                    AppMethodBeat.o(197540);
                    return -1;
                } else {
                    AppMethodBeat.o(197540);
                    return 1;
                }
            }
        });
        AppMethodBeat.o(197548);
        return arrayList;
    }

    private void buildInstructions(List<List<TAVVideoCompositionLayerInstruction>> list, List<TAVVideoCompositionLayerInstruction> list2, List<Slice> list3) {
        AppMethodBeat.i(197549);
        for (Slice slice : list3) {
            this.outputInstructions.add(buildInstruction(slice, list2, list));
        }
        AppMethodBeat.o(197549);
    }

    private TAVVideoCompositionInstruction buildInstruction(Slice slice, List<TAVVideoCompositionLayerInstruction> list, List<List<TAVVideoCompositionLayerInstruction>> list2) {
        AppMethodBeat.i(197550);
        TAVVideoCompositionInstruction tAVVideoCompositionInstruction = new TAVVideoCompositionInstruction(trackIDsByLayers(slice.layerInstructions), slice.timeRange);
        tAVVideoCompositionInstruction.setChannelLayers(selectChannels(list2, slice.layerInstructions));
        tAVVideoCompositionInstruction.setOverlayLayers(selectLayers(list, slice.layerInstructions));
        tAVVideoCompositionInstruction.setBackgroundColor(this.builderModel.getBackgroundColor());
        tAVVideoCompositionInstruction.setGlobalVideoEffect(this.builderModel.getTavComposition().getGlobalVideoEffect());
        tAVVideoCompositionInstruction.setVideoMixEffect(this.builderModel.getTavComposition().getVideoMixEffect());
        tAVVideoCompositionInstruction.setSourceVideoEffect(this.builderModel.getTavComposition().getSourceVideoEffect());
        AppMethodBeat.o(197550);
        return tAVVideoCompositionInstruction;
    }

    private List<Integer> trackIDsByLayers(List<TAVVideoCompositionLayerInstruction> list) {
        AppMethodBeat.i(197551);
        ArrayList arrayList = new ArrayList();
        for (TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction : list) {
            arrayList.add(Integer.valueOf(tAVVideoCompositionLayerInstruction.getTrackID()));
        }
        AppMethodBeat.o(197551);
        return arrayList;
    }

    private List<List<TAVVideoCompositionLayerInstruction>> selectChannels(List<List<TAVVideoCompositionLayerInstruction>> list, List<TAVVideoCompositionLayerInstruction> list2) {
        AppMethodBeat.i(197552);
        ArrayList arrayList = new ArrayList();
        for (List<TAVVideoCompositionLayerInstruction> list3 : list) {
            List<TAVVideoCompositionLayerInstruction> selectLayers = selectLayers(list2, list3);
            if (selectLayers.size() > 0) {
                arrayList.add(selectLayers);
            }
        }
        AppMethodBeat.o(197552);
        return arrayList;
    }

    private List<TAVVideoCompositionLayerInstruction> selectLayers(List<TAVVideoCompositionLayerInstruction> list, List<TAVVideoCompositionLayerInstruction> list2) {
        AppMethodBeat.i(197553);
        ArrayList arrayList = new ArrayList();
        for (TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction : list) {
            if (list2.contains(tAVVideoCompositionLayerInstruction)) {
                arrayList.add(tAVVideoCompositionLayerInstruction);
            }
        }
        AppMethodBeat.o(197553);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public static class Slice {
        private List<TAVVideoCompositionLayerInstruction> layerInstructions;
        private CMTimeRange timeRange;

        Slice(CMTimeRange cMTimeRange, List<TAVVideoCompositionLayerInstruction> list) {
            this.timeRange = cMTimeRange;
            this.layerInstructions = list;
        }
    }
}
