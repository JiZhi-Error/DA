package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.ToneGenerator;
import android.provider.Settings;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;

public final class c {
    private static final HashMap<String, Integer> Hhu;
    public static Context mContext;
    public Object Hhv = new Object();
    public ToneGenerator Hhw;
    private final int Hhx = 250;

    static {
        AppMethodBeat.i(115579);
        HashMap<String, Integer> hashMap = new HashMap<>();
        Hhu = hashMap;
        hashMap.put("1", 1);
        Hhu.put("2", 2);
        Hhu.put(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, 3);
        Hhu.put("4", 4);
        Hhu.put("5", 5);
        Hhu.put("6", 6);
        Hhu.put("7", 7);
        Hhu.put("8", 8);
        Hhu.put("9", 9);
        Hhu.put(AppEventsConstants.EVENT_PARAM_VALUE_NO, 0);
        Hhu.put("#", 11);
        Hhu.put("*", 10);
        AppMethodBeat.o(115579);
    }

    public c(Context context) {
        AppMethodBeat.i(115575);
        mContext = context;
        if (context != null) {
            try {
                synchronized (this.Hhv) {
                    try {
                        if (fKK() && this.Hhw == null) {
                            this.Hhw = new ToneGenerator(3, 66);
                        }
                    } finally {
                        AppMethodBeat.o(115575);
                    }
                }
                return;
            } catch (Exception e2) {
                Log.d("MicroMsg.DTMFToneGenerator", "获取音频发生器单例失败！！！");
                Log.d("MicroMsg.DTMFToneGenerator", e2.getMessage());
                this.Hhw = null;
            }
        }
        AppMethodBeat.o(115575);
    }

    private c() {
        AppMethodBeat.i(115576);
        AppMethodBeat.o(115576);
    }

    public static boolean fKK() {
        AppMethodBeat.i(115577);
        if (Settings.System.getInt(mContext.getContentResolver(), "dtmf_tone", 1) == 1) {
            AppMethodBeat.o(115577);
            return true;
        }
        AppMethodBeat.o(115577);
        return false;
    }

    public static int aUD(String str) {
        AppMethodBeat.i(115578);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(115578);
            return -1;
        } else if (Hhu.containsKey(str)) {
            int intValue = Hhu.get(str).intValue();
            AppMethodBeat.o(115578);
            return intValue;
        } else {
            AppMethodBeat.o(115578);
            return -1;
        }
    }
}
