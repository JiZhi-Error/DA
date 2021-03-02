package com.tencent.tmediacodec.g;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import com.tencent.tmediacodec.b.e;
import com.tencent.tmediacodec.b.f;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public final class d {
    public static final String[] Sna = {"csd-0", "csd-1", "csd-2"};
    private static boolean Snb;
    private static boolean Snc;

    public static boolean by(String str) {
        AppMethodBeat.i(190193);
        boolean contains = str.contains("video");
        AppMethodBeat.o(190193);
        return contains;
    }

    public static String a(MediaCodec mediaCodec) {
        AppMethodBeat.i(190194);
        if (Build.VERSION.SDK_INT >= 18) {
            String name = mediaCodec.getName();
            AppMethodBeat.o(190194);
            return name;
        }
        AppMethodBeat.o(190194);
        return "unknow-low-api-18";
    }

    public static String n(Surface surface) {
        AppMethodBeat.i(190195);
        try {
            Field k = c.k(Surface.class, "mName");
            k.setAccessible(true);
            String valueOf = String.valueOf(k.get(surface));
            AppMethodBeat.o(190195);
            return valueOf;
        } catch (Throwable th) {
            b.bqV("TUtils");
            AppMethodBeat.o(190195);
            return "";
        }
    }

    public static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        AppMethodBeat.i(190196);
        if (Build.VERSION.SDK_INT < 19 || !codecCapabilities.isFeatureSupported("adaptive-playback")) {
            AppMethodBeat.o(190196);
            return false;
        }
        AppMethodBeat.o(190196);
        return true;
    }

    public static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        AppMethodBeat.i(190197);
        if (Build.VERSION.SDK_INT < 21 || !codecCapabilities.isFeatureSupported("secure-playback")) {
            AppMethodBeat.o(190197);
            return false;
        }
        AppMethodBeat.o(190197);
        return true;
    }

    public static int b(f fVar, e eVar) {
        int d2;
        AppMethodBeat.i(190198);
        if (eVar.bdr != -1) {
            int i2 = 0;
            for (int i3 = 0; i3 < eVar.Slz.size(); i3++) {
                i2 += eVar.Slz.get(i3).length;
            }
            d2 = eVar.bdr + i2;
        } else {
            d2 = d(eVar.bdq, eVar.width, eVar.height, fVar.bsY);
        }
        AppMethodBeat.o(190198);
        return d2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static int d(String str, int i2, int i3, boolean z) {
        char c2;
        int i4;
        int i5 = 2;
        AppMethodBeat.i(190199);
        if (i2 == -1 || i3 == -1) {
            AppMethodBeat.o(190199);
            return -1;
        }
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1662541442:
                if (str.equals(TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127257:
                if (str.equals(TPDecoderType.TP_CODEC_MIMETYPE_VP9)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                i4 = i2 * i3;
                break;
            case 2:
                if (!"BRAVIA 4K 2015".equals(Build.MODEL) && (!"Amazon".equals(Build.MANUFACTURER) || (!"KFSOWI".equals(Build.MODEL) && (!"AFTS".equals(Build.MODEL) || !z)))) {
                    i4 = asx(i2) * asx(i3) * 16 * 16;
                    break;
                } else {
                    AppMethodBeat.o(190199);
                    return -1;
                }
            case 3:
                i4 = i2 * i3;
                break;
            case 4:
            case 5:
                i4 = i2 * i3;
                i5 = 4;
                break;
            default:
                AppMethodBeat.o(190199);
                return -1;
        }
        int i6 = (i4 * 3) / (i5 * 2);
        AppMethodBeat.o(190199);
        return i6;
    }

    private static int asx(int i2) {
        return ((i2 + 16) - 1) / 16;
    }

    public static ArrayList<byte[]> j(MediaFormat mediaFormat) {
        AppMethodBeat.i(190200);
        ArrayList<byte[]> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < Sna.length; i2++) {
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(Sna[i2]);
            if (byteBuffer != null) {
                arrayList.add(byteBuffer.array());
            }
        }
        AppMethodBeat.o(190200);
        return arrayList;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01c4, code lost:
        if (r5.equals("ELUGA_Note") != false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:411:0x06d4, code lost:
        if (r3.equals("AFTA") != false) goto L_0x0047;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0050 A[Catch:{ all -> 0x06c7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean hpH() {
        /*
        // Method dump skipped, instructions count: 2568
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmediacodec.g.d.hpH():boolean");
    }
}
