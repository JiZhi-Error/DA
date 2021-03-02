package com.tencent.youtu.sdkkitframework.common;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public class CommonUtils {
    public static final int MAX_TIMEOUT_MS = 30000;
    public static final int MIN_TIMEOUT_MS = 0;
    private static final String TAG = "CommonUtils";
    private static ConcurrentHashMap<String, BenchMarkTime> benchMarkMaps = new ConcurrentHashMap<>();

    static {
        AppMethodBeat.i(192549);
        AppMethodBeat.o(192549);
    }

    public static void benchMarkBegin(String str) {
        AppMethodBeat.i(192542);
        if (!benchMarkMaps.containsKey(str)) {
            benchMarkMaps.put(str, new BenchMarkTime());
        }
        benchMarkMaps.get(str).begin();
        AppMethodBeat.o(192542);
    }

    public static long benchMarkEnd(String str) {
        AppMethodBeat.i(192543);
        if (!benchMarkMaps.containsKey(str)) {
            AppMethodBeat.o(192543);
            return 0;
        }
        BenchMarkTime benchMarkTime = benchMarkMaps.get(str);
        benchMarkTime.end();
        YtLogger.d(TAG, "benchMarkEnd -- " + str + " : " + benchMarkTime.cur + LocaleUtil.MALAY);
        long j2 = benchMarkTime.cur;
        AppMethodBeat.o(192543);
        return j2;
    }

    public static String getBenchMarkTime(String str) {
        AppMethodBeat.i(192544);
        if (!benchMarkMaps.containsKey(str)) {
            AppMethodBeat.o(192544);
            return "";
        }
        String str2 = "[" + str + "]" + benchMarkMaps.get(str).getTime();
        AppMethodBeat.o(192544);
        return str2;
    }

    public static String getYoutuOpenAppSign(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(192545);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String str5 = "a=" + str + "&k=" + str2 + "&e=" + (2592000 + currentTimeMillis) + "&t=" + currentTimeMillis + "&r=" + Math.abs(new Random().nextInt()) + "&u=" + str4 + "&f=";
        byte[] signature = getSignature(str5, str3);
        byte[] bArr = new byte[(signature.length + str5.getBytes().length)];
        System.arraycopy(signature, 0, bArr, 0, signature.length);
        System.arraycopy(str5.getBytes(), 0, bArr, signature.length, str5.getBytes().length);
        String str6 = new String(Base64.encode(bArr, 2));
        AppMethodBeat.o(192545);
        return str6;
    }

    public static String makeMessageJson(int i2, String str, String str2) {
        AppMethodBeat.i(192546);
        try {
            new JSONObject(str2);
        } catch (Exception e2) {
            str2 = "{ \"errorcode\":" + i2 + ",\"errormsg\": \"" + str + "\",\"extrainfo\":\"" + str2 + "\"}";
        }
        AppMethodBeat.o(192546);
        return str2;
    }

    private static byte[] getSignature(String str, String str2) {
        AppMethodBeat.i(192547);
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec(str2.getBytes(), instance.getAlgorithm()));
        byte[] doFinal = instance.doFinal(str.getBytes());
        AppMethodBeat.o(192547);
        return doFinal;
    }

    static class BenchMarkTime {
        long avg = 0;
        long begin;
        long cur = 0;
        long max = Long.MIN_VALUE;
        long min = MAlarmHandler.NEXT_FIRE_INTERVAL;
        long tick = 0;
        long total = 0;

        public BenchMarkTime() {
            AppMethodBeat.i(192537);
            AppMethodBeat.o(192537);
        }

        public void begin() {
            AppMethodBeat.i(192538);
            this.begin = System.currentTimeMillis();
            AppMethodBeat.o(192538);
        }

        public void end() {
            AppMethodBeat.i(192539);
            this.cur = System.currentTimeMillis() - this.begin;
            update(this.cur);
            AppMethodBeat.o(192539);
        }

        public String getTime() {
            AppMethodBeat.i(192540);
            String str = "avg: " + this.avg + "ms min: " + this.min + "ms max: " + this.max + "ms cur: " + this.cur + LocaleUtil.MALAY;
            AppMethodBeat.o(192540);
            return str;
        }

        private void update(long j2) {
            AppMethodBeat.i(192541);
            this.tick++;
            this.min = Math.min(j2, this.min);
            this.max = Math.max(j2, this.max);
            this.total += j2;
            this.avg = this.total / this.tick;
            AppMethodBeat.o(192541);
        }
    }

    public static void reportException(String str, final Exception exc) {
        AppMethodBeat.i(192548);
        YtSDKStats.getInstance().reportInfo(str + " cause exception: " + exc.getLocalizedMessage());
        YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
            /* class com.tencent.youtu.sdkkitframework.common.CommonUtils.AnonymousClass1 */

            {
                AppMethodBeat.i(192536);
                put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
                put("error_code", Integer.valueOf((int) ErrorCode.YT_SDK_PARAM_ERROR));
                put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_PARAM_ERROR, StringCode.RST_FAILED, exc.getLocalizedMessage()));
                AppMethodBeat.o(192536);
            }
        });
        AppMethodBeat.o(192548);
    }
}
