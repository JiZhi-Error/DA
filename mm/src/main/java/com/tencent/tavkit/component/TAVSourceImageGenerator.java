package com.tencent.tavkit.component;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.util.ArrayList;
import java.util.List;

public class TAVSourceImageGenerator {
    public static final String TAG = "TAVSourceImageGenerator";
    private AssetImageGenerator assetImageGenerator;

    public TAVSourceImageGenerator(TAVComposition tAVComposition, CGSize cGSize) {
        AppMethodBeat.i(197418);
        init(new TAVCompositionBuilder(tAVComposition).buildSource(), cGSize);
        AppMethodBeat.o(197418);
    }

    public TAVSourceImageGenerator(TAVSource tAVSource, CGSize cGSize) {
        AppMethodBeat.i(197419);
        init(tAVSource, cGSize);
        AppMethodBeat.o(197419);
    }

    private void init(TAVSource tAVSource, CGSize cGSize) {
        AppMethodBeat.i(197420);
        this.assetImageGenerator = new AssetImageGenerator(tAVSource.getAsset());
        this.assetImageGenerator.setMaximumSize(cGSize);
        this.assetImageGenerator.setAppliesPreferredTrackTransform(true);
        this.assetImageGenerator.setVideoComposition(tAVSource.getVideoComposition());
        AppMethodBeat.o(197420);
    }

    public AssetImageGenerator getAssetImageGenerator() {
        return this.assetImageGenerator;
    }

    public void generateThumbnailAtTime(CMTime cMTime, AssetImageGenerator.ImageGeneratorListener imageGeneratorListener) {
        AppMethodBeat.i(197421);
        ArrayList arrayList = new ArrayList();
        if (cMTime == null || cMTime.getTimeUs() < 0) {
            cMTime = CMTime.CMTimeZero;
        }
        arrayList.add(cMTime);
        generateThumbnailAtTimes(arrayList, imageGeneratorListener);
        AppMethodBeat.o(197421);
    }

    public synchronized void generateThumbnailAtTimes(List<CMTime> list, final AssetImageGenerator.ImageGeneratorListener imageGeneratorListener) {
        AppMethodBeat.i(197422);
        checkRequestedTimes(list);
        if (!list.isEmpty()) {
            if (this.assetImageGenerator == null) {
                AppMethodBeat.o(197422);
            } else {
                this.assetImageGenerator.generateCGImagesAsynchronouslyForTimes(list, new AssetImageGenerator.ImageGeneratorListener() {
                    /* class com.tencent.tavkit.component.TAVSourceImageGenerator.AnonymousClass1 */

                    @Override // com.tencent.tav.core.AssetImageGenerator.ImageGeneratorListener
                    public void onCompletion(CMTime cMTime, Bitmap bitmap, CMTime cMTime2, AssetImageGenerator.AssetImageGeneratorResult assetImageGeneratorResult) {
                        AppMethodBeat.i(197417);
                        imageGeneratorListener.onCompletion(cMTime, bitmap, cMTime2, assetImageGeneratorResult);
                        AppMethodBeat.o(197417);
                    }
                });
            }
        }
        AppMethodBeat.o(197422);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r6.getTimeUs() < 0) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap generateThumbnailAtTimeSync(com.tencent.tav.coremedia.CMTime r6) {
        /*
            r5 = this;
            r0 = 0
            r4 = 197423(0x3032f, float:2.76649E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.tencent.tav.core.AssetImageGenerator r1 = r5.assetImageGenerator
            if (r1 == 0) goto L_0x0020
            if (r6 == 0) goto L_0x0017
            long r0 = r6.getTimeUs()     // Catch:{ Exception -> 0x0024 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0019
        L_0x0017:
            com.tencent.tav.coremedia.CMTime r6 = com.tencent.tav.coremedia.CMTime.CMTimeZero     // Catch:{ Exception -> 0x0024 }
        L_0x0019:
            com.tencent.tav.core.AssetImageGenerator r0 = r5.assetImageGenerator     // Catch:{ Exception -> 0x0024 }
            r1 = 0
            android.graphics.Bitmap r0 = r0.copyCGImageAtTimeAndActualTime(r6, r1)     // Catch:{ Exception -> 0x0024 }
        L_0x0020:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r0
        L_0x0024:
            r0 = move-exception
            java.lang.Exception r1 = new java.lang.Exception
            r1.<init>(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tavkit.component.TAVSourceImageGenerator.generateThumbnailAtTimeSync(com.tencent.tav.coremedia.CMTime):android.graphics.Bitmap");
    }

    private void checkRequestedTimes(List<CMTime> list) {
        AppMethodBeat.i(197424);
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
        }
        if (arrayList.isEmpty()) {
            arrayList.add(CMTime.CMTimeZero);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            CMTime cMTime = arrayList.get(i2);
            if (cMTime == null || cMTime.getTimeUs() < 0) {
                arrayList.set(i2, CMTime.CMTimeZero);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (CMTime cMTime2 : arrayList) {
            if (!arrayList2.contains(cMTime2)) {
                arrayList2.add(cMTime2);
            }
        }
        arrayList.clear();
        arrayList.addAll(arrayList2);
        AppMethodBeat.o(197424);
    }
}
