package com.tencent.thumbplayer.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.g;
import java.util.HashMap;

public final class b {
    private static String TAG = "TPPlaybackInfo";
    public String RVh;
    String RVi;
    public int RVj;
    public int RVk;
    public long RVl;
    String RVm;
    int RVn;
    long RVo;
    public int RVp;
    long RVq;
    public long RVr;
    int RVs;
    int channels;
    String definition;
    public long durationMs;
    public long height;
    long sampleRate;
    public long width;

    public static b bqw(String str) {
        AppMethodBeat.i(188602);
        if (TextUtils.isEmpty(str)) {
            b bVar = new b();
            AppMethodBeat.o(188602);
            return bVar;
        }
        String[] split = str.split("\n");
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < split.length; i2++) {
            if (!split[i2].startsWith("#") && split[i2].contains("=")) {
                String[] split2 = split[i2].split("=");
                if (split2 == null || split2.length < 2) {
                    g.i(TAG, "parseInfo, " + ((split2 == null || split2.length <= 0) ? "param null, " : split2[0]) + "is empty");
                } else {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        b bVar2 = new b();
        if (hashMap.containsKey("ContainerFormat")) {
            bVar2.RVh = (String) hashMap.get("ContainerFormat");
        }
        if (hashMap.containsKey("VideoCodec")) {
            bVar2.RVi = (String) hashMap.get("VideoCodec");
        }
        if (hashMap.containsKey("AudioCodec")) {
            bVar2.RVm = (String) hashMap.get("AudioCodec");
        }
        if (hashMap.containsKey("Width")) {
            bVar2.width = Long.valueOf((String) hashMap.get("Width")).longValue();
        }
        if (hashMap.containsKey("Height")) {
            bVar2.height = Long.valueOf((String) hashMap.get("Height")).longValue();
        }
        if (hashMap.containsKey("VideoBitRate")) {
            bVar2.RVl = Long.valueOf((String) hashMap.get("VideoBitRate")).longValue();
        }
        if (hashMap.containsKey("AudioBitRate")) {
            bVar2.RVo = Long.valueOf((String) hashMap.get("AudioBitRate")).longValue();
        }
        if (hashMap.containsKey("SampleRate")) {
            bVar2.sampleRate = Long.valueOf((String) hashMap.get("SampleRate")).longValue();
        }
        if (hashMap.containsKey("Channels")) {
            bVar2.channels = Integer.valueOf((String) hashMap.get("Channels")).intValue();
        }
        if (hashMap.containsKey("Definition")) {
            bVar2.definition = (String) hashMap.get("Definition");
        }
        AppMethodBeat.o(188602);
        return bVar2;
    }
}
