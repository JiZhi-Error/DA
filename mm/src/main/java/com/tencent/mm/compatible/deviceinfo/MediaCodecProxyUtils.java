package com.tencent.mm.compatible.deviceinfo;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveConstants;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class MediaCodecProxyUtils {
    private static volatile long gJP = 0;
    private static final Map<Integer, a> gJQ = new ConcurrentHashMap();
    private static final Map<Integer, a> gJR = new ConcurrentHashMap();
    private static final Map<Integer, a> gJS = new ConcurrentHashMap();
    private static final Map<Integer, a> gJT = new ConcurrentHashMap();
    private static u gJU;

    static {
        AppMethodBeat.i(155819);
        AppMethodBeat.o(155819);
    }

    public static final class b {
        public static void oA(int i2) {
            AppMethodBeat.i(155798);
            u uVar = MediaCodecProxyUtils.gJU;
            if (uVar != null) {
                uVar.yU((long) i2);
            }
            AppMethodBeat.o(155798);
        }

        public static void a(int i2, a aVar) {
            AppMethodBeat.i(155799);
            if (aVar == null) {
                aVar = new a();
            }
            String str = "";
            if (aVar.gJX != null) {
                str = aVar.gJX.replace(",", ";");
            }
            x(i2, String.format(Locale.US, "%d,%d,%d,%d,%d,%b,%s,%s,%s,%s", Integer.valueOf(i2), Integer.valueOf(MediaCodecProxyUtils.gJQ.size()), Integer.valueOf(MediaCodecProxyUtils.gJR.size()), Integer.valueOf(MediaCodecProxyUtils.gJS.size()), Integer.valueOf(MediaCodecProxyUtils.gJT.size()), Boolean.valueOf(aVar.gJV), aVar.mimeType, aVar.gJW, str, aVar.stack));
            AppMethodBeat.o(155799);
        }

        public static void w(int i2, String str) {
            AppMethodBeat.i(155800);
            x(i2, String.format(Locale.US, "%d,%d,%d,%d,%d,%b,%s,%s,%s,%s", Integer.valueOf(i2), Integer.valueOf(MediaCodecProxyUtils.gJQ.size()), Integer.valueOf(MediaCodecProxyUtils.gJR.size()), Integer.valueOf(MediaCodecProxyUtils.gJS.size()), Integer.valueOf(MediaCodecProxyUtils.gJT.size()), Boolean.FALSE, "", "", "", str));
            AppMethodBeat.o(155800);
        }

        private static void x(int i2, String str) {
            AppMethodBeat.i(155801);
            u uVar = MediaCodecProxyUtils.gJU;
            boolean z = uVar != null && uVar.aoV();
            Log.i("MicroMsg.MediaCodecProxyUtils", "reportKVImpl xSwitch:[%s], reportKey:[%d], kv:[%s]", Boolean.valueOf(z), Integer.valueOf(i2), str);
            if (!z) {
                AppMethodBeat.o(155801);
                return;
            }
            uVar.DX(str);
            AppMethodBeat.o(155801);
        }
    }

    public static class a {
        public long createTime = System.currentTimeMillis();
        public boolean gJV;
        public String gJW;
        public String gJX;
        public String mimeType;
        public String stack = Util.getStack().toString();

        public a() {
            AppMethodBeat.i(155797);
            AppMethodBeat.o(155797);
        }
    }

    public static a a(int i2, boolean z, String str) {
        AppMethodBeat.i(155810);
        a aVar = new a();
        aVar.mimeType = str;
        aVar.gJV = z;
        Log.i("MicroMsg.MediaCodecProxyUtils", "insertMapWithMimeType, isEncode:[%b],mimeType:[%s]", Boolean.valueOf(z), str);
        if (str.contains("video/")) {
            if (z) {
                gJS.put(Integer.valueOf(i2), aVar);
            } else {
                gJT.put(Integer.valueOf(i2), aVar);
            }
        } else if (!str.contains("audio/")) {
            b.oA(20);
            b.a(20, aVar);
        } else if (z) {
            gJQ.put(Integer.valueOf(i2), aVar);
        } else {
            gJR.put(Integer.valueOf(i2), aVar);
        }
        AppMethodBeat.o(155810);
        return aVar;
    }

    public static a v(int i2, String str) {
        AppMethodBeat.i(155811);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i3 = 0; i3 < codecCount; i3++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (TextUtils.equals(codecInfoAt.getName(), str)) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                if (supportedTypes.length > 0) {
                    Log.i("MicroMsg.MediaCodecProxyUtils", "insertMapWithCodecName success, codecName:[%s], mime:[%s]", str, supportedTypes[0]);
                    a a2 = a(i2, codecInfoAt.isEncoder(), supportedTypes[0]);
                    AppMethodBeat.o(155811);
                    return a2;
                }
            }
        }
        Log.e("MicroMsg.MediaCodecProxyUtils", "insertMapWithCodecName fail, codecName:[%s]", str);
        a aVar = new a();
        aVar.gJW = str;
        b.oA(21);
        b.a(21, aVar);
        a aVar2 = new a();
        AppMethodBeat.o(155811);
        return aVar2;
    }

    public static boolean oz(int i2) {
        AppMethodBeat.i(155812);
        if (gJQ.remove(Integer.valueOf(i2)) != null) {
            Log.d("MicroMsg.MediaCodecProxyUtils", "removeMap audioEncodeMap success");
            AppMethodBeat.o(155812);
            return true;
        } else if (gJR.remove(Integer.valueOf(i2)) != null) {
            Log.d("MicroMsg.MediaCodecProxyUtils", "removeMap audioDecodeMap success");
            AppMethodBeat.o(155812);
            return true;
        } else if (gJS.remove(Integer.valueOf(i2)) != null) {
            Log.d("MicroMsg.MediaCodecProxyUtils", "removeMap videoEncodeMap success");
            AppMethodBeat.o(155812);
            return true;
        } else if (gJT.remove(Integer.valueOf(i2)) != null) {
            Log.d("MicroMsg.MediaCodecProxyUtils", "removeMap videoDecodeMap success");
            AppMethodBeat.o(155812);
            return true;
        } else {
            Log.e("MicroMsg.MediaCodecProxyUtils", "removeMap fail");
            b.oA(22);
            b.a(22, new a());
            AppMethodBeat.o(155812);
            return false;
        }
    }

    public static void aoY() {
        AppMethodBeat.i(155813);
        Log.i("MicroMsg.MediaCodecProxyUtils", "codecCountCheck allsize:[%d], audioEncodeMap:[%d], audioDecodeMap:[%d], videoEncodeMap:[%d], videoDecodeMap:[%d]", Integer.valueOf(gJQ.size() + gJR.size() + gJS.size() + gJT.size()), Integer.valueOf(gJQ.size()), Integer.valueOf(gJR.size()), Integer.valueOf(gJS.size()), Integer.valueOf(gJT.size()));
        a(gJR, 12);
        a(gJQ, 13);
        a(gJT, 14);
        a(gJS, 15);
        AppMethodBeat.o(155813);
    }

    private static void a(Map<Integer, a> map, int i2) {
        AppMethodBeat.i(155814);
        if (map.size() >= 8) {
            Log.i("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl type:[%d], map.size:[%d], process:[%s]", Integer.valueOf(i2), Integer.valueOf(map.size()), MMApplicationContext.getProcessName());
            if (gJP + 30000 >= System.currentTimeMillis()) {
                if (gJP == 0) {
                    Log.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl first time");
                } else {
                    Log.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl report return, time diff is %s", Long.valueOf(System.currentTimeMillis() - gJP));
                    AppMethodBeat.o(155814);
                    return;
                }
            }
            gJP = System.currentTimeMillis();
            Log.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl start leak report, time:%s", Long.valueOf(gJP));
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            Set<Integer> keySet = map.keySet();
            long currentTimeMillis = System.currentTimeMillis();
            for (Integer num : keySet) {
                a aVar = map.get(num);
                if (aVar != null) {
                    String str = "";
                    if (aVar.gJX != null) {
                        str = aVar.gJX.replace(",", ";");
                    }
                    sb.append(aVar.gJV).append(";").append(aVar.mimeType).append(";").append(aVar.gJW).append(";").append(MMApplicationContext.getProcessName()).append(";").append(str).append(";").append(aVar.stack).append("|");
                    long j2 = currentTimeMillis - aVar.createTime;
                    if (j2 > 600000) {
                        Log.i("MicroMsg.MediaCodecProxyUtils", "codecCountCheckImpl diffTime:[%s] ", Long.valueOf(j2));
                        sb2.append(j2).append(";").append(aVar.gJV).append(";").append(aVar.mimeType).append(";").append(aVar.gJW).append(";").append(MMApplicationContext.getProcessName()).append(";").append(str).append(";").append(aVar.stack).append("|");
                    }
                }
            }
            if (i2 == 12) {
                b.oA(12);
                if (!TextUtils.isEmpty(sb2.toString())) {
                    b.oA(192);
                    if (MMApplicationContext.isMainProcess()) {
                        b.w(192, sb.toString());
                    }
                }
                if (MMApplicationContext.isMainProcess()) {
                    b.oA(TXLiveConstants.RENDER_ROTATION_180);
                    b.w(TXLiveConstants.RENDER_ROTATION_180, sb.toString());
                    AppMethodBeat.o(155814);
                    return;
                } else if (aoZ()) {
                    b.oA(184);
                    AppMethodBeat.o(155814);
                    return;
                } else {
                    b.oA(188);
                    AppMethodBeat.o(155814);
                    return;
                }
            } else if (i2 == 13) {
                b.oA(13);
                if (!TextUtils.isEmpty(sb2.toString())) {
                    b.oA(193);
                    if (MMApplicationContext.isMainProcess()) {
                        b.w(193, sb.toString());
                    }
                }
                if (MMApplicationContext.isMainProcess()) {
                    b.oA(181);
                    b.w(181, sb.toString());
                    AppMethodBeat.o(155814);
                    return;
                } else if (aoZ()) {
                    b.oA(185);
                    AppMethodBeat.o(155814);
                    return;
                } else {
                    b.oA(189);
                    AppMethodBeat.o(155814);
                    return;
                }
            } else if (i2 == 14) {
                b.oA(14);
                if (!TextUtils.isEmpty(sb2.toString())) {
                    b.oA(194);
                    if (MMApplicationContext.isMainProcess()) {
                        b.w(194, sb.toString());
                    }
                }
                if (MMApplicationContext.isMainProcess()) {
                    b.oA(182);
                    b.w(182, sb.toString());
                    AppMethodBeat.o(155814);
                    return;
                } else if (aoZ()) {
                    b.oA(186);
                    AppMethodBeat.o(155814);
                    return;
                } else {
                    b.oA(FacebookRequestErrorClassification.EC_INVALID_TOKEN);
                    AppMethodBeat.o(155814);
                    return;
                }
            } else if (i2 == 15) {
                b.oA(15);
                if (!TextUtils.isEmpty(sb2.toString())) {
                    b.oA(195);
                    if (MMApplicationContext.isMainProcess()) {
                        b.w(195, sb.toString());
                    }
                }
                if (MMApplicationContext.isMainProcess()) {
                    b.oA(183);
                    b.w(183, sb.toString());
                    AppMethodBeat.o(155814);
                    return;
                } else if (aoZ()) {
                    b.oA(187);
                    AppMethodBeat.o(155814);
                    return;
                } else {
                    b.oA(191);
                }
            }
        }
        AppMethodBeat.o(155814);
    }

    private static boolean aoZ() {
        AppMethodBeat.i(175887);
        boolean contains = MMApplicationContext.getProcessName().contains(":appbrand");
        AppMethodBeat.o(175887);
        return contains;
    }

    public static boolean a(String str, a aVar) {
        String[] supportedTypes;
        AppMethodBeat.i(155815);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            for (String str2 : codecInfoAt.getSupportedTypes()) {
                if (TextUtils.equals(str2, str)) {
                    aVar.gJW = codecInfoAt.getName();
                    AppMethodBeat.o(155815);
                    return true;
                }
            }
        }
        Log.e("MicroMsg.MediaCodecProxyUtils", "mimeTypeSupportCheck error, type unsupport:[%s]", str);
        b.oA(23);
        b.a(23, aVar);
        AppMethodBeat.o(155815);
        return false;
    }

    public static boolean b(String str, a aVar) {
        AppMethodBeat.i(155816);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            if (TextUtils.equals(str, MediaCodecList.getCodecInfoAt(i2).getName())) {
                aVar.gJW = str;
                AppMethodBeat.o(155816);
                return true;
            }
        }
        Log.e("MicroMsg.MediaCodecProxyUtils", "codecNameSupportCheck error, type unsupport:[%s]", str);
        b.oA(24);
        b.a(24, aVar);
        AppMethodBeat.o(155816);
        return false;
    }

    public static void a(boolean z, String str, a aVar) {
        AppMethodBeat.i(155817);
        Log.i("MicroMsg.MediaCodecProxyUtils", "isEncode:[%b], mimeType:[%s]", Boolean.valueOf(z), str);
        if (!str.contains("video/")) {
            if (str.contains("audio/")) {
                if (z) {
                    b.oA(4);
                    b.a(4, aVar);
                    AppMethodBeat.o(155817);
                    return;
                }
                b.oA(3);
                b.a(3, aVar);
            }
            AppMethodBeat.o(155817);
        } else if (z) {
            b.oA(6);
            b.a(6, aVar);
            AppMethodBeat.o(155817);
        } else {
            b.oA(5);
            b.a(5, aVar);
            AppMethodBeat.o(155817);
        }
    }

    public static void c(String str, a aVar) {
        AppMethodBeat.i(155818);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (TextUtils.equals(codecInfoAt.getName(), str)) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                if (supportedTypes.length > 0) {
                    a(codecInfoAt.isEncoder(), supportedTypes[0], aVar);
                }
            }
        }
        AppMethodBeat.o(155818);
    }

    public static class MediaCodecRetryInfo implements Parcelable {
        public static final Parcelable.Creator<MediaCodecRetryInfo> CREATOR = new Parcelable.Creator<MediaCodecRetryInfo>() {
            /* class com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils.MediaCodecRetryInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ MediaCodecRetryInfo[] newArray(int i2) {
                return new MediaCodecRetryInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ MediaCodecRetryInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(155802);
                MediaCodecRetryInfo mediaCodecRetryInfo = new MediaCodecRetryInfo(parcel);
                AppMethodBeat.o(155802);
                return mediaCodecRetryInfo;
            }
        };
        int gJY;

        protected MediaCodecRetryInfo(Parcel parcel) {
            AppMethodBeat.i(155803);
            this.gJY = parcel.readInt();
            AppMethodBeat.o(155803);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(155804);
            parcel.writeInt(this.gJY);
            AppMethodBeat.o(155804);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.i(155805);
            AppMethodBeat.o(155805);
        }
    }

    public static class MediaCodecRetryInfoWrapper implements Parcelable {
        public static final Parcelable.Creator<MediaCodecRetryInfoWrapper> CREATOR = new Parcelable.Creator<MediaCodecRetryInfoWrapper>() {
            /* class com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils.MediaCodecRetryInfoWrapper.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ MediaCodecRetryInfoWrapper[] newArray(int i2) {
                return new MediaCodecRetryInfoWrapper[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ MediaCodecRetryInfoWrapper createFromParcel(Parcel parcel) {
                AppMethodBeat.i(155806);
                MediaCodecRetryInfoWrapper mediaCodecRetryInfoWrapper = new MediaCodecRetryInfoWrapper(parcel);
                AppMethodBeat.o(155806);
                return mediaCodecRetryInfoWrapper;
            }
        };
        List<MediaCodecRetryInfo> gJZ;

        protected MediaCodecRetryInfoWrapper(Parcel parcel) {
            AppMethodBeat.i(155807);
            this.gJZ = parcel.createTypedArrayList(MediaCodecRetryInfo.CREATOR);
            AppMethodBeat.o(155807);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(155808);
            parcel.writeTypedList(this.gJZ);
            AppMethodBeat.o(155808);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.i(155809);
            AppMethodBeat.o(155809);
        }
    }

    public static void a(u uVar) {
        gJU = uVar;
    }
}
