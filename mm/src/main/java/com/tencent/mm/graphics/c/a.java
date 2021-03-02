package com.tencent.mm.graphics.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public enum a {
    INSTANCE;

    /* renamed from: com.tencent.mm.graphics.c.a$a  reason: collision with other inner class name */
    public static class C0348a {
        public int aXk;
        public int fileSize;
        public String from;
        public int height;
        public int hku;
        public int hkv;
        public int hkw;
        public String imagePath;
        public int imageType;
        public int orientation;
        public int width;
    }

    public static a valueOf(String str) {
        AppMethodBeat.i(136213);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(136213);
        return aVar;
    }

    static {
        AppMethodBeat.i(136217);
        AppMethodBeat.o(136217);
    }

    public static void a(C0348a aVar, C0348a aVar2) {
        AppMethodBeat.i(136214);
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar != null) {
            a(currentTimeMillis, aVar);
        }
        if (aVar2 != null) {
            a(currentTimeMillis, aVar2);
        }
        AppMethodBeat.o(136214);
    }

    private static void a(long j2, C0348a aVar) {
        AppMethodBeat.i(136215);
        if (aVar == null) {
            AppMethodBeat.o(136215);
            return;
        }
        Log.i("MicroMsg.ImageReporter", "alvinluo reportImageDecodeInfo sessionId: %d, from: %s, imageType: %d, w: %d, h: %d, fileSize: %d, orientation: %d, decodeResult: %d, decodeTime: %d, fullSampleSzie: %d, onlyDecodeTime: %d", Long.valueOf(j2), aVar.from, Integer.valueOf(aVar.imageType), Integer.valueOf(aVar.width), Integer.valueOf(aVar.height), Integer.valueOf(aVar.fileSize), Integer.valueOf(aVar.orientation), Integer.valueOf(aVar.hku), Integer.valueOf(aVar.hkv), Integer.valueOf(aVar.aXk), Integer.valueOf(aVar.hkw));
        h.INSTANCE.a(15467, Long.valueOf(j2), aVar.from, Integer.valueOf(aVar.imageType), Integer.valueOf(aVar.width), Integer.valueOf(aVar.height), Integer.valueOf(aVar.fileSize), Integer.valueOf(aVar.orientation), Integer.valueOf(aVar.hku), Integer.valueOf(aVar.hkv), Integer.valueOf(aVar.aXk), Integer.valueOf(aVar.hkw));
        AppMethodBeat.o(136215);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(136216);
        long currentTimeMillis = System.currentTimeMillis();
        if (bVar != null) {
            Log.i("MicroMsg.ImageReporter", "alvinluo reportPerformance sessionId: %d, fps.maxFps: %f, fps.minFps: %f, fps.averageFps: %f, memory.memoryUsedWhenInit: %f, memory.currentMaxUsedMemory: %f, memory.currentMinUsedMemory: %f, memory.averUsed: %f, memory.currentVarianceSum: %f", Long.valueOf(currentTimeMillis), Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(bVar.hjZ), Double.valueOf(bVar.hka), Double.valueOf(bVar.hkb), Double.valueOf(bVar.hkd), Double.valueOf(bVar.hkc));
            h.INSTANCE.a(15471, Long.valueOf(currentTimeMillis), 0, 0, 0, Integer.valueOf((int) bVar.hjZ), Integer.valueOf((int) bVar.hka), Integer.valueOf((int) bVar.hkd), Integer.valueOf((int) bVar.hkc), 1);
        }
        AppMethodBeat.o(136216);
    }
}
