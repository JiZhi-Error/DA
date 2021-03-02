package com.google.android.exoplayer2.e;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class d {
    private static final a btO = new a("OMX.google.raw.decoder", null, null, false, false);
    private static final Pattern btP = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<a, List<a>> btQ = new HashMap<>();
    private static final SparseIntArray btR;
    private static final SparseIntArray btS;
    private static final Map<String, Integer> btT;
    private static int btU = -1;

    /* access modifiers changed from: package-private */
    public interface c {
        boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i2);

        boolean vh();
    }

    public static class b extends Exception {
        /* synthetic */ b(Throwable th, byte b2) {
            this(th);
        }

        private b(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    static {
        AppMethodBeat.i(92378);
        SparseIntArray sparseIntArray = new SparseIntArray();
        btR = sparseIntArray;
        sparseIntArray.put(66, 1);
        btR.put(77, 2);
        btR.put(88, 4);
        btR.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        btS = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        btS.put(11, 4);
        btS.put(12, 8);
        btS.put(13, 16);
        btS.put(20, 32);
        btS.put(21, 64);
        btS.put(22, 128);
        btS.put(30, 256);
        btS.put(31, 512);
        btS.put(32, 1024);
        btS.put(40, 2048);
        btS.put(41, 4096);
        btS.put(42, 8192);
        btS.put(50, 16384);
        btS.put(51, 32768);
        btS.put(52, 65536);
        HashMap hashMap = new HashMap();
        btT = hashMap;
        hashMap.put("L30", 1);
        btT.put("L60", 4);
        btT.put("L63", 16);
        btT.put("L90", 64);
        btT.put("L93", 256);
        btT.put("L120", 1024);
        btT.put("L123", 4096);
        btT.put("L150", 16384);
        btT.put("L153", 65536);
        btT.put("L156", Integer.valueOf((int) TPMediaCodecProfileLevel.HEVCMainTierLevel52));
        btT.put("L180", 1048576);
        btT.put("L183", 4194304);
        btT.put("L186", Integer.valueOf((int) TPMediaCodecProfileLevel.HEVCMainTierLevel62));
        btT.put("H30", 2);
        btT.put("H60", 8);
        btT.put("H63", 32);
        btT.put("H90", 128);
        btT.put("H93", 512);
        btT.put("H120", 2048);
        btT.put("H123", 8192);
        btT.put("H150", 32768);
        btT.put("H153", 131072);
        btT.put("H156", 524288);
        btT.put("H180", Integer.valueOf((int) TPMediaCodecProfileLevel.HEVCHighTierLevel6));
        btT.put("H183", Integer.valueOf((int) TPMediaCodecProfileLevel.HEVCHighTierLevel61));
        btT.put("H186", Integer.valueOf((int) TPMediaCodecProfileLevel.HEVCHighTierLevel62));
        AppMethodBeat.o(92378);
    }

    public static a vf() {
        return btO;
    }

    public static a d(String str, boolean z) {
        AppMethodBeat.i(92371);
        List<a> e2 = e(str, z);
        if (e2.isEmpty()) {
            AppMethodBeat.o(92371);
            return null;
        }
        a aVar = e2.get(0);
        AppMethodBeat.o(92371);
        return aVar;
    }

    private static synchronized List<a> e(String str, boolean z) {
        List<a> list;
        synchronized (d.class) {
            AppMethodBeat.i(92372);
            a aVar = new a(str, z);
            list = btQ.get(aVar);
            if (list != null) {
                AppMethodBeat.o(92372);
            } else {
                List<a> a2 = a(aVar, x.SDK_INT >= 21 ? new e(z) : new C0106d((byte) 0));
                if (z && a2.isEmpty() && 21 <= x.SDK_INT && x.SDK_INT <= 23) {
                    List<a> a3 = a(aVar, new C0106d((byte) 0));
                    if (!a3.isEmpty()) {
                        new StringBuilder("MediaCodecList API didn't list secure decoder for: ").append(str).append(". Assuming: ").append(a3.get(0).name);
                    }
                    a2 = a3;
                }
                u(a2);
                list = Collections.unmodifiableList(a2);
                btQ.put(aVar, list);
                AppMethodBeat.o(92372);
            }
        }
        return list;
    }

    public static int vg() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(92373);
        if (btU == -1) {
            a d2 = d("video/avc", false);
            if (d2 != null) {
                MediaCodecInfo.CodecProfileLevel[] uZ = d2.uZ();
                int i4 = 0;
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : uZ) {
                    switch (codecProfileLevel.level) {
                        case 1:
                            i2 = 25344;
                            break;
                        case 2:
                            i2 = 25344;
                            break;
                        case 8:
                            i2 = 101376;
                            break;
                        case 16:
                            i2 = 101376;
                            break;
                        case 32:
                            i2 = 101376;
                            break;
                        case 64:
                            i2 = 202752;
                            break;
                        case 128:
                            i2 = 414720;
                            break;
                        case 256:
                            i2 = 414720;
                            break;
                        case 512:
                            i2 = Downloads.SPLIT_RANGE_SIZE_NET;
                            break;
                        case 1024:
                            i2 = 1310720;
                            break;
                        case 2048:
                            i2 = TPMediaCodecProfileLevel.HEVCHighTierLevel6;
                            break;
                        case 4096:
                            i2 = TPMediaCodecProfileLevel.HEVCHighTierLevel6;
                            break;
                        case 8192:
                            i2 = 2228224;
                            break;
                        case 16384:
                            i2 = 5652480;
                            break;
                        case 32768:
                            i2 = 9437184;
                            break;
                        case 65536:
                            i2 = 9437184;
                            break;
                        default:
                            i2 = -1;
                            break;
                    }
                    i4 = Math.max(i2, i4);
                }
                i3 = Math.max(i4, x.SDK_INT >= 21 ? 345600 : 172800);
            }
            btU = i3;
        }
        int i5 = btU;
        AppMethodBeat.o(92373);
        return i5;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        if (r6.equals("hev1") != false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> bi(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 234
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.d.bi(java.lang.String):android.util.Pair");
    }

    private static List<a> a(a aVar, c cVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(92375);
        try {
            ArrayList arrayList = new ArrayList();
            String str = aVar.mimeType;
            int codecCount = cVar.getCodecCount();
            boolean vh = cVar.vh();
            int i2 = 0;
            loop0:
            while (true) {
                if (i2 >= codecCount) {
                    AppMethodBeat.o(92375);
                    break;
                }
                MediaCodecInfo codecInfoAt = cVar.getCodecInfoAt(i2);
                String name = codecInfoAt.getName();
                if (codecInfoAt.isEncoder() || (!vh && name.endsWith(".secure"))) {
                    z = false;
                } else if (x.SDK_INT < 21 && ("CIPAACDecoder".equals(name) || "CIPMP3Decoder".equals(name) || "CIPVorbisDecoder".equals(name) || "CIPAMRNBDecoder".equals(name) || "AACDecoder".equals(name) || "MP3Decoder".equals(name))) {
                    z = false;
                } else if (x.SDK_INT < 18 && "OMX.SEC.MP3.Decoder".equals(name)) {
                    z = false;
                } else if (x.SDK_INT < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(name) && ("a70".equals(x.DEVICE) || ("Xiaomi".equals(x.MANUFACTURER) && x.DEVICE.startsWith("HM")))) {
                    z = false;
                } else if (x.SDK_INT == 16 && "OMX.qcom.audio.decoder.mp3".equals(name) && ("dlxu".equals(x.DEVICE) || "protou".equals(x.DEVICE) || "ville".equals(x.DEVICE) || "villeplus".equals(x.DEVICE) || "villec2".equals(x.DEVICE) || x.DEVICE.startsWith("gee") || "C6602".equals(x.DEVICE) || "C6603".equals(x.DEVICE) || "C6606".equals(x.DEVICE) || "C6616".equals(x.DEVICE) || "L36h".equals(x.DEVICE) || "SO-02E".equals(x.DEVICE))) {
                    z = false;
                } else if (x.SDK_INT == 16 && "OMX.qcom.audio.decoder.aac".equals(name) && ("C1504".equals(x.DEVICE) || "C1505".equals(x.DEVICE) || "C1604".equals(x.DEVICE) || "C1605".equals(x.DEVICE))) {
                    z = false;
                } else if (x.SDK_INT < 24 && (("OMX.SEC.aac.dec".equals(name) || "OMX.Exynos.AAC.Decoder".equals(name)) && x.MANUFACTURER.equals("samsung") && (x.DEVICE.startsWith("zeroflte") || x.DEVICE.startsWith("zerolte") || x.DEVICE.startsWith("zenlte") || x.DEVICE.equals("SC-05G") || x.DEVICE.equals("marinelteatt") || x.DEVICE.equals("404SC") || x.DEVICE.equals("SC-04G") || x.DEVICE.equals("SCV31")))) {
                    z = false;
                } else if (x.SDK_INT <= 19 && "OMX.SEC.vp8.dec".equals(name) && "samsung".equals(x.MANUFACTURER) && (x.DEVICE.startsWith("d2") || x.DEVICE.startsWith("serrano") || x.DEVICE.startsWith("jflte") || x.DEVICE.startsWith("santos") || x.DEVICE.startsWith("t0"))) {
                    z = false;
                } else if (x.SDK_INT > 19 || !x.DEVICE.startsWith("jflte") || !"OMX.qcom.video.decoder.vp8".equals(name)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    String[] supportedTypes = codecInfoAt.getSupportedTypes();
                    for (String str2 : supportedTypes) {
                        if (str2.equalsIgnoreCase(str)) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str2);
                                boolean a2 = cVar.a(str, capabilitiesForType);
                                if (x.SDK_INT > 22 || ((!x.MODEL.equals("ODROID-XU3") && !x.MODEL.equals("Nexus 10")) || (!"OMX.Exynos.AVC.Decoder".equals(name) && !"OMX.Exynos.AVC.Decoder.secure".equals(name)))) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if ((!vh || aVar.bsY != a2) && (vh || aVar.bsY)) {
                                    if (!vh && a2) {
                                        arrayList.add(a.a(name + ".secure", str, capabilitiesForType, z2, true));
                                        AppMethodBeat.o(92375);
                                        break loop0;
                                    }
                                } else {
                                    arrayList.add(a.a(name, str, capabilitiesForType, z2, false));
                                }
                            } catch (Exception e2) {
                                if (x.SDK_INT > 23 || arrayList.isEmpty()) {
                                    new StringBuilder("Failed to query codec ").append(name).append(" (").append(str2).append(")");
                                    AppMethodBeat.o(92375);
                                    throw e2;
                                }
                                new StringBuilder("Skipping codec ").append(name).append(" (failed to query capabilities)");
                            }
                        }
                    }
                    continue;
                }
                i2++;
            }
            return arrayList;
        } catch (Exception e3) {
            b bVar = new b(e3, (byte) 0);
            AppMethodBeat.o(92375);
            throw bVar;
        }
    }

    private static void u(List<a> list) {
        AppMethodBeat.i(92376);
        if (x.SDK_INT < 26 && list.size() > 1 && "OMX.MTK.AUDIO.DECODER.RAW".equals(list.get(0).name)) {
            for (int i2 = 1; i2 < list.size(); i2++) {
                a aVar = list.get(i2);
                if ("OMX.google.raw.decoder".equals(aVar.name)) {
                    list.remove(i2);
                    list.add(0, aVar);
                    AppMethodBeat.o(92376);
                    return;
                }
            }
        }
        AppMethodBeat.o(92376);
    }

    private static Pair<Integer, Integer> e(String[] strArr) {
        Integer valueOf;
        Integer valueOf2;
        AppMethodBeat.i(92377);
        if (strArr.length < 2) {
            AppMethodBeat.o(92377);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[2]));
            } else {
                AppMethodBeat.o(92377);
                return null;
            }
            Integer valueOf3 = Integer.valueOf(btR.get(valueOf.intValue()));
            if (valueOf3 == null) {
                new StringBuilder("Unknown AVC profile: ").append(valueOf);
                AppMethodBeat.o(92377);
                return null;
            }
            Integer valueOf4 = Integer.valueOf(btS.get(valueOf2.intValue()));
            if (valueOf4 == null) {
                new StringBuilder("Unknown AVC level: ").append(valueOf2);
                AppMethodBeat.o(92377);
                return null;
            }
            Pair<Integer, Integer> pair = new Pair<>(valueOf3, valueOf4);
            AppMethodBeat.o(92377);
            return pair;
        } catch (NumberFormatException e2) {
            AppMethodBeat.o(92377);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(21)
    public static final class e implements c {
        private final int btV;
        private MediaCodecInfo[] btW;

        public e(boolean z) {
            AppMethodBeat.i(92366);
            this.btV = z ? 1 : 0;
            AppMethodBeat.o(92366);
        }

        @Override // com.google.android.exoplayer2.e.d.c
        public final int getCodecCount() {
            AppMethodBeat.i(92367);
            vi();
            int length = this.btW.length;
            AppMethodBeat.o(92367);
            return length;
        }

        @Override // com.google.android.exoplayer2.e.d.c
        public final MediaCodecInfo getCodecInfoAt(int i2) {
            AppMethodBeat.i(92368);
            vi();
            MediaCodecInfo mediaCodecInfo = this.btW[i2];
            AppMethodBeat.o(92368);
            return mediaCodecInfo;
        }

        @Override // com.google.android.exoplayer2.e.d.c
        public final boolean vh() {
            return true;
        }

        @Override // com.google.android.exoplayer2.e.d.c
        public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            AppMethodBeat.i(92369);
            boolean isFeatureSupported = codecCapabilities.isFeatureSupported("secure-playback");
            AppMethodBeat.o(92369);
            return isFeatureSupported;
        }

        private void vi() {
            AppMethodBeat.i(92370);
            if (this.btW == null) {
                this.btW = new MediaCodecList(this.btV).getCodecInfos();
            }
            AppMethodBeat.o(92370);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.android.exoplayer2.e.d$d  reason: collision with other inner class name */
    public static final class C0106d implements c {
        private C0106d() {
        }

        /* synthetic */ C0106d(byte b2) {
            this();
        }

        @Override // com.google.android.exoplayer2.e.d.c
        public final int getCodecCount() {
            AppMethodBeat.i(92363);
            int codecCount = MediaCodecList.getCodecCount();
            AppMethodBeat.o(92363);
            return codecCount;
        }

        @Override // com.google.android.exoplayer2.e.d.c
        public final MediaCodecInfo getCodecInfoAt(int i2) {
            AppMethodBeat.i(92364);
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            AppMethodBeat.o(92364);
            return codecInfoAt;
        }

        @Override // com.google.android.exoplayer2.e.d.c
        public final boolean vh() {
            return false;
        }

        @Override // com.google.android.exoplayer2.e.d.c
        public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            AppMethodBeat.i(92365);
            boolean equals = "video/avc".equals(str);
            AppMethodBeat.o(92365);
            return equals;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        public final boolean bsY;
        public final String mimeType;

        public a(String str, boolean z) {
            this.mimeType = str;
            this.bsY = z;
        }

        public final int hashCode() {
            AppMethodBeat.i(92361);
            int hashCode = (this.bsY ? 1231 : 1237) + (((this.mimeType == null ? 0 : this.mimeType.hashCode()) + 31) * 31);
            AppMethodBeat.o(92361);
            return hashCode;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(92362);
            if (this == obj) {
                AppMethodBeat.o(92362);
                return true;
            } else if (obj == null || obj.getClass() != a.class) {
                AppMethodBeat.o(92362);
                return false;
            } else {
                a aVar = (a) obj;
                if (!TextUtils.equals(this.mimeType, aVar.mimeType) || this.bsY != aVar.bsY) {
                    AppMethodBeat.o(92362);
                    return false;
                }
                AppMethodBeat.o(92362);
                return true;
            }
        }
    }
}
