package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.media.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.videocomposition.c.a;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TAVImageResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import java.io.FileInputStream;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 15}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010 \u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eJ\u0014\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0002R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f`\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0017`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/videocomposition/TrackCache;", "", "()V", "bitmapCache", "Ljava/util/HashMap;", "", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashMap;", "bitmapSizeLimit", "", "getBitmapSizeLimit", "()I", "setBitmapSizeLimit", "(I)V", "cache", "Lcom/tencent/tavkit/composition/resource/TAVResource;", "imageDuration", "", "getImageDuration", "()J", "setImageDuration", "(J)V", "videoInfoCache", "Lcom/tencent/mm/videocomposition/VideoClipInfo;", "clear", "", "createRescaleBitmap", "path", "getBitmap", FFmpegMetadataRetriever.METADATA_KEY_TRACK, "Lcom/tencent/mm/videocomposition/CompositionTrack;", "getResource", k.NAME, "remove", "resizeBitmap", "bitmap", "video_composition_release"})
public final class i {
    private static final HashMap<String, m> GyX = new HashMap<>();
    private static final HashMap<String, Bitmap> JeH = new HashMap<>();
    private static int Rhh = 1080;
    private static long Rhi = 10000;
    public static final i Rhj = new i();
    private static final HashMap<String, TAVResource> cache = new HashMap<>();

    static {
        AppMethodBeat.i(216757);
        AppMethodBeat.o(216757);
    }

    private i() {
    }

    public static void apL(int i2) {
        Rhh = i2;
    }

    public static int hfl() {
        return Rhh;
    }

    public static void hfm() {
        Rhi = 4000;
    }

    public final TAVResource c(d dVar) {
        TAVResource clone;
        Bitmap bitmap;
        int i2;
        Bitmap bitmap2;
        AppMethodBeat.i(216753);
        p.h(dVar, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
        synchronized (this) {
            try {
                TAVImageResource tAVImageResource = cache.get(dVar.path);
                if (tAVImageResource == null) {
                    switch (dVar.type) {
                        case 1:
                            String str = dVar.path;
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            b.i("CompositionTrack", "createRescaleBitmap:".concat(String.valueOf(str)), new Object[0]);
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeFile(str, options);
                            int i3 = options.outWidth;
                            int i4 = options.outHeight;
                            a aVar = a.Rig;
                            int i5 = Rhh;
                            options.inSampleSize = a.calculateInSampleSize(i3, i4, i5, i5);
                            options.inJustDecodeBounds = false;
                            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                            if (decodeFile == null || decodeFile.isRecycled()) {
                                bitmap = null;
                            } else {
                                if (decodeFile.getWidth() % 2 == 1) {
                                    bitmap2 = Bitmap.createBitmap(decodeFile.getWidth() + 1, decodeFile.getHeight(), Bitmap.Config.ARGB_8888);
                                    if (bitmap2 == null) {
                                        p.hyc();
                                    }
                                    Canvas canvas = new Canvas(bitmap2);
                                    canvas.drawARGB(0, 0, 0, 0);
                                    canvas.drawBitmap(decodeFile, 0.0f, 0.0f, (Paint) null);
                                } else {
                                    bitmap2 = decodeFile;
                                }
                                bitmap = bitmap2;
                            }
                            if (bitmap == null) {
                                p.hyc();
                            }
                            switch (new androidx.a.a.a(new FileInputStream(str)).getAttributeInt(android.support.e.a.TAG_ORIENTATION, 1)) {
                                case 3:
                                    b.i("CompositionTrack", "image rotate 180", new Object[0]);
                                    i2 = TXLiveConstants.RENDER_ROTATION_180;
                                    break;
                                case 4:
                                case 5:
                                case 7:
                                default:
                                    i2 = 0;
                                    break;
                                case 6:
                                    b.i("CompositionTrack", "image rotate 90", new Object[0]);
                                    i2 = 90;
                                    break;
                                case 8:
                                    b.i("CompositionTrack", "image rotate 270", new Object[0]);
                                    i2 = 270;
                                    break;
                            }
                            if (i2 > 0) {
                                a aVar2 = a.Rig;
                                Bitmap rotate = a.rotate(bitmap, (float) i2);
                                if (rotate != null) {
                                    bitmap = rotate;
                                }
                            }
                            b.i("CompositionTrack", "final rescale bitmap size:[" + bitmap.getWidth() + ", " + bitmap.getHeight() + "], origin size:[" + i3 + ", " + i4 + "], cost:" + (SystemClock.elapsedRealtime() - elapsedRealtime), new Object[0]);
                            JeH.put(dVar.path, bitmap);
                            tAVImageResource = new TAVImageResource(new CIImage(bitmap), new CMTime(Rhi, 1000), true);
                            break;
                        case 2:
                        case 3:
                            tAVImageResource = new TAVAssetTrackResource(new URLAsset(dVar.path));
                            break;
                        default:
                            tAVImageResource = new TAVEmptyResource(CMTime.CMTimeZero);
                            break;
                    }
                    cache.put(dVar.path, tAVImageResource);
                }
                clone = tAVImageResource.clone();
                p.g(clone, "resource.clone()");
            } finally {
                AppMethodBeat.o(216753);
            }
        }
        return clone;
    }

    public final Bitmap d(d dVar) {
        Bitmap bitmap;
        AppMethodBeat.i(216754);
        p.h(dVar, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
        synchronized (this) {
            try {
                bitmap = JeH.get(dVar.path);
            } finally {
                AppMethodBeat.o(216754);
            }
        }
        return bitmap;
    }

    public final void clear() {
        AppMethodBeat.i(216755);
        synchronized (this) {
            try {
                cache.clear();
                JeH.clear();
                GyX.clear();
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(216755);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0085, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0086, code lost:
        r7.release();
        com.tencent.matrix.trace.core.AppMethodBeat.o(216756);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0091, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0085 A[ExcHandler: all (r0v7 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:6:0x001e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.videocomposition.m bpj(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 150
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.videocomposition.i.bpj(java.lang.String):com.tencent.mm.videocomposition.m");
    }
}
