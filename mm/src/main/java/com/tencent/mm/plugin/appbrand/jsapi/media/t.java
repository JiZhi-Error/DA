package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.i.d;
import com.tencent.mm.media.i.h;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiResumeDownloadTaskForNative;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tavkit.component.TAVPlayer;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public final class t {
    public static final int meG = c.Dmd;

    static {
        AppMethodBeat.i(46609);
        j.bur();
        AppMethodBeat.o(46609);
    }

    public static String aaf(String str) {
        AppMethodBeat.i(46603);
        if (str == null) {
            Log.e("MicroMsg.RemuxHelper", "remuxIfNeed, filePath is null");
            AppMethodBeat.o(46603);
            return null;
        }
        String a2 = a(new a(str, TAVExporter.VIDEO_EXPORT_WIDTH, TAVPlayer.VIDEO_PLAYER_WIDTH, 0, 0, c.Dmd, c.Dme));
        AppMethodBeat.o(46603);
        return a2;
    }

    public static String a(a aVar) {
        AppMethodBeat.i(46604);
        if (aVar == null) {
            Log.e("MicroMsg.RemuxHelper", "remuxIfNeed, compress request is null");
            AppMethodBeat.o(46604);
            return null;
        }
        String a2 = a(aVar, ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_hard_remux_video, 0) == 1);
        AppMethodBeat.o(46604);
        return a2;
    }

    private static String a(a aVar, boolean z) {
        int i2;
        int i3;
        int remuxingVFS;
        AppMethodBeat.i(46605);
        String str = aVar.filePath;
        if (aan(str) != -50006) {
            d.pl(15);
            AppMethodBeat.o(46605);
            return str;
        }
        Log.i("MicroMsg.RemuxHelper", "compress info: filePath: %s, suggestWidth: %d, suggestHeight: %d, outputWidth: %d, outputHeight: %d, remuxBitRate %d", str, Integer.valueOf(aVar.meH), Integer.valueOf(aVar.meI), Integer.valueOf(aVar.outputWidth), Integer.valueOf(aVar.outputHeight), Integer.valueOf(aVar.meJ));
        if (aVar.outputWidth == 0 || aVar.outputHeight == 0) {
            int i4 = aVar.meH > 0 ? aVar.meH : TAVExporter.VIDEO_EXPORT_WIDTH;
            int i5 = aVar.meI > 0 ? aVar.meI : TAVPlayer.VIDEO_PLAYER_WIDTH;
            b aao = aao(str);
            Log.i("MicroMsg.RemuxHelper", "sourceWidth: %d, sourceHeight: %d", Integer.valueOf(aao == null ? 0 : aao.width), Integer.valueOf(aao == null ? 0 : aao.height));
            int[] iArr = new int[2];
            m.b(str, iArr, i4, i5);
            int i6 = iArr[0];
            i2 = iArr[1];
            i3 = i6;
        } else {
            int i7 = aVar.outputWidth;
            i2 = aVar.outputHeight;
            if (i7 % 2 != 0) {
                i7++;
            }
            if (i2 % 2 != 0) {
                i2++;
                i3 = i7;
            } else {
                i3 = i7;
            }
        }
        Log.i("MicroMsg.RemuxHelper", "outputWidth: %d, outputHeight: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        int i8 = aVar.meJ > 0 ? aVar.meJ : c.Dmd;
        float f2 = aVar.cKu > 0.0f ? aVar.cKu : c.Dme;
        if (!s.YS(com.tencent.mm.loader.j.b.aKH())) {
            s.boN(com.tencent.mm.loader.j.b.aKH());
        }
        String str2 = com.tencent.mm.loader.j.b.aKH() + "microMsg." + System.currentTimeMillis() + ".mp4";
        d.pl(0);
        if (z) {
            Log.i("MicroMsg.RemuxHelper", "hard remux mode.");
            d.pl(1);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            remuxingVFS = h.ijh.a(str, str2, i3, i2, i8, (int) f2, 0, 51, new d.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.t.AnonymousClass1 */

                @Override // com.tencent.mm.media.i.d.b
                public final void Hn(String str) {
                    AppMethodBeat.i(46602);
                    Log.d("MicroMsg.RemuxHelper", "remux onFinish.");
                    countDownLatch.countDown();
                    AppMethodBeat.o(46602);
                }
            }).aMG();
            try {
                Log.d("MicroMsg.RemuxHelper", "latch await ");
                countDownLatch.await();
            } catch (InterruptedException e2) {
                Log.e("MicroMsg.RemuxHelper", "latch await exception, %s.", e2.getMessage());
            }
            d.pl(10);
        } else {
            Log.i("MicroMsg.RemuxHelper", "soft remux mode.");
            d.pl(2);
            remuxingVFS = SightVideoJNI.remuxingVFS(str, str2, i3, i2, i8, c.Dmc, 8, 2, 25.0f, f2, null, 0, false, 0, 51);
            if (remuxingVFS < 0) {
                d.pl(14);
            } else {
                d.pl(11);
            }
        }
        Log.i("MicroMsg.RemuxHelper", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", str, str2, Integer.valueOf(remuxingVFS), Integer.valueOf(i3), Integer.valueOf(i2));
        AppMethodBeat.o(46605);
        return str2;
    }

    public static int aan(String str) {
        int i2;
        int i3;
        AppMethodBeat.i(46606);
        boolean Sx = com.tencent.mm.plugin.a.c.Sx(str);
        Log.i("MicroMsg.RemuxHelper", "checkRemux, isMp4 = %b", Boolean.valueOf(Sx));
        if (Sx) {
            i2 = SightVideoJNI.shouldRemuxingVFS(str, JsApiResumeDownloadTaskForNative.CTRL_INDEX, 500, 26214400, 1200000.0d, 1000000);
            Log.i("MicroMsg.RemuxHelper", "checkRemux, ret = %d", Integer.valueOf(i2));
        } else {
            Log.i("MicroMsg.RemuxHelper", "fileLength = %d", Integer.valueOf((int) s.boW(str)));
            i2 = 1;
        }
        switch (i2) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                i3 = -50002;
                break;
            case 0:
                i3 = -50006;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                i3 = 1;
                break;
            default:
                Log.e("MicroMsg.RemuxHelper", "unknown check type");
                i3 = -50001;
                break;
        }
        AppMethodBeat.o(46606);
        return i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.plugin.appbrand.jsapi.media.t.b aao(java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 246
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.media.t.aao(java.lang.String):com.tencent.mm.plugin.appbrand.jsapi.media.t$b");
    }

    private static float aap(String str) {
        int i2;
        AppMethodBeat.i(46608);
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            int trackCount = mediaExtractor.getTrackCount();
            int i3 = 0;
            while (true) {
                if (i3 >= trackCount) {
                    i2 = 0;
                    break;
                }
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
                if (trackFormat.getString("mime").startsWith("video/") && trackFormat.containsKey("frame-rate")) {
                    i2 = trackFormat.getInteger("frame-rate");
                    break;
                }
                i3++;
            }
            mediaExtractor.release();
        } catch (IOException e2) {
            mediaExtractor.release();
            i2 = 0;
        } catch (Throwable th) {
            mediaExtractor.release();
            AppMethodBeat.o(46608);
            throw th;
        }
        Log.i("MicroMsg.RemuxHelper", "getVideoFrameRate fps: %d", Integer.valueOf(i2));
        float f2 = ((float) i2) * 1.0f;
        AppMethodBeat.o(46608);
        return f2;
    }

    public static final class a {
        public float cKu;
        public String filePath;
        public int meH;
        public int meI;
        public int meJ;
        public int outputHeight;
        public int outputWidth;

        public a(String str, int i2, int i3, int i4, int i5, int i6, float f2) {
            this.filePath = str;
            this.meH = i2;
            this.meI = i3;
            this.outputWidth = i4;
            this.outputHeight = i5;
            this.meJ = i6;
            this.cKu = f2;
        }
    }

    public static final class b {
        public int bitrate;
        public float cKu;
        public int duration;
        public String filePath;
        public int height;
        public int rotation;
        public long size;
        public String type;
        public int width;

        public b(String str, int i2, String str2, int i3, long j2, int i4, int i5, int i6, float f2) {
            this.filePath = str;
            this.rotation = i2;
            this.type = str2;
            this.duration = i3;
            this.size = j2;
            this.width = i4;
            this.height = i5;
            this.bitrate = i6;
            this.cKu = f2;
        }
    }
}
