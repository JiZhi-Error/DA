package com.tencent.tav.extractor.wrapper;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.extractor.AssetExtractor;

public class ExtractorLoader {
    private static Handler loadHandler;
    private static HandlerThread loadThread;

    static {
        AppMethodBeat.i(218515);
        HandlerThread handlerThread = new HandlerThread("ExtractorLoader");
        loadThread = handlerThread;
        handlerThread.start();
        AppMethodBeat.o(218515);
    }

    private static void checkAndStart() {
        AppMethodBeat.i(218512);
        if (loadHandler == null && loadThread.getLooper() != null) {
            loadHandler = new Handler(loadThread.getLooper());
        }
        AppMethodBeat.o(218512);
    }

    public static void cacheExtractor(String str) {
        AppMethodBeat.i(218513);
        checkAndStart();
        loadHandler.post(new VideoPathLoaderRunnable(str));
        AppMethodBeat.o(218513);
    }

    public static void cacheExtractor(AssetExtractor assetExtractor) {
        AppMethodBeat.i(218514);
        checkAndStart();
        loadHandler.post(new ExtractorLoaderRunnable(assetExtractor));
        AppMethodBeat.o(218514);
    }

    /* access modifiers changed from: package-private */
    public static class VideoPathLoaderRunnable implements Runnable {
        private String videoPath;

        VideoPathLoaderRunnable(String str) {
            this.videoPath = str;
        }

        public void run() {
            AppMethodBeat.i(218511);
            if (!ExtractorWrapperPool.contains(this.videoPath)) {
                AssetExtractor assetExtractor = new AssetExtractor();
                assetExtractor.setDataSource(this.videoPath);
                ExtractorWrapper extractorWrapper = new ExtractorWrapper(this.videoPath);
                extractorWrapper.checkAndLoad(assetExtractor);
                ExtractorWrapperPool.put(extractorWrapper);
            }
            AppMethodBeat.o(218511);
        }
    }

    static class ExtractorLoaderRunnable implements Runnable {
        private AssetExtractor extractor;

        ExtractorLoaderRunnable(AssetExtractor assetExtractor) {
            this.extractor = assetExtractor;
        }

        public void run() {
            AppMethodBeat.i(218510);
            if (!ExtractorWrapperPool.contains(this.extractor.getSourcePath())) {
                ExtractorWrapper extractorWrapper = new ExtractorWrapper(this.extractor.getSourcePath());
                extractorWrapper.checkAndLoad(this.extractor);
                ExtractorWrapperPool.put(extractorWrapper);
                this.extractor = null;
            }
            AppMethodBeat.o(218510);
        }
    }
}
