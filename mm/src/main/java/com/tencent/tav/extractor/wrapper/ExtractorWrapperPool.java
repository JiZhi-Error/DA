package com.tencent.tav.extractor.wrapper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.extractor.AssetExtractor;
import java.util.HashMap;

public class ExtractorWrapperPool {
    private static final HashMap<String, ExtractorWrapper> extractorHashMap = new HashMap<>();

    static {
        AppMethodBeat.i(218527);
        AppMethodBeat.o(218527);
    }

    public static synchronized ExtractorWrapper get(String str) {
        ExtractorWrapper extractorWrapper;
        synchronized (ExtractorWrapperPool.class) {
            AppMethodBeat.i(218520);
            extractorWrapper = extractorHashMap.get(str);
            if (extractorWrapper == null) {
                extractorWrapper = new ExtractorWrapper(str);
            }
            extractorHashMap.put(str, extractorWrapper);
            AppMethodBeat.o(218520);
        }
        return extractorWrapper;
    }

    public static synchronized boolean contains(String str) {
        boolean containsKey;
        synchronized (ExtractorWrapperPool.class) {
            AppMethodBeat.i(218521);
            containsKey = extractorHashMap.containsKey(str);
            AppMethodBeat.o(218521);
        }
        return containsKey;
    }

    public static synchronized void put(ExtractorWrapper extractorWrapper) {
        synchronized (ExtractorWrapperPool.class) {
            AppMethodBeat.i(218522);
            extractorHashMap.put(extractorWrapper.getVideoPath(), extractorWrapper);
            AppMethodBeat.o(218522);
        }
    }

    public static synchronized void load(String str) {
        synchronized (ExtractorWrapperPool.class) {
            AppMethodBeat.i(218523);
            AssetExtractor assetExtractor = new AssetExtractor();
            assetExtractor.setDataSource(str);
            get(str).checkAndLoad(assetExtractor);
            AppMethodBeat.o(218523);
        }
    }

    public static synchronized void load(AssetExtractor assetExtractor) {
        synchronized (ExtractorWrapperPool.class) {
            AppMethodBeat.i(218524);
            get(assetExtractor.getSourcePath()).checkAndLoad(assetExtractor);
            AppMethodBeat.o(218524);
        }
    }

    public static synchronized void fillIn(String str, AssetExtractor assetExtractor) {
        synchronized (ExtractorWrapperPool.class) {
            AppMethodBeat.i(218525);
            ExtractorWrapper extractorWrapper = get(str);
            extractorWrapper.checkAndLoad(assetExtractor);
            assetExtractor.setSize(extractorWrapper.getVideoSize());
            assetExtractor.setDuration(extractorWrapper.getDuration());
            assetExtractor.setPreferRotation(extractorWrapper.getPreferRotation());
            AppMethodBeat.o(218525);
        }
    }

    public static synchronized void clear() {
        synchronized (ExtractorWrapperPool.class) {
            AppMethodBeat.i(218526);
            extractorHashMap.clear();
            AppMethodBeat.o(218526);
        }
    }
}
