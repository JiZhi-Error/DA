package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import java.util.HashMap;
import java.util.Map;

public class YtSDKKitCommon {

    public static class StateNameHelper {
        private static HashMap<StateClassName, String> _stateNameMap = new HashMap<StateClassName, String>() {
            /* class com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.AnonymousClass1 */

            {
                AppMethodBeat.i(192656);
                put(StateClassName.UNKNOWN_STATE, "com.tencent.youtu.sdkkitframework.liveness.Unknown");
                put(StateClassName.TIMEOUT_STATE, "com.tencent.youtu.sdkkitframework.framework.TimeoutState");
                put(StateClassName.IDLE_STATE, "com.tencent.youtu.sdkkitframework.framework.IdleState");
                put(StateClassName.SILENT_STATE, "com.tencent.youtu.sdkkitframework.liveness.SilentLivenessState");
                put(StateClassName.ACTION_STATE, "com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState");
                put(StateClassName.REFLECT_STATE, "com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState");
                put(StateClassName.OCR_AUTO_DETECT_STATE, "com.tencent.youtu.sdkkitframework.ocr.OcrCardAutoDetectState");
                put(StateClassName.OCR_MANUAL_DETECT_STATE, "com.tencent.youtu.sdkkitframework.ocr.OcrCardManualDetectState");
                put(StateClassName.NET_FETCH_STATE, "com.tencent.youtu.sdkkitframework.liveness.NetFetchState");
                put(StateClassName.NET_LIVENESS_REQ_RESULT_STATE, "com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState");
                put(StateClassName.NET_OCR_REQ_RESULT_STATE, "com.tencent.youtu.sdkkitframework.ocr.NetOcrReqResultState");
                put(StateClassName.LIPREAD_STATE, "com.tencent.youtu.sdkkitframework.liveness.LipReadLivenessState");
                put(StateClassName.DETECTONLY_STATE, "com.tencent.youtu.sdkkitframework.liveness.DetectOnlyState");
                put(StateClassName.OCR_VIID_STATE, "com.tencent.youtu.sdkkitframework.ocr.OcrVideoIdentState");
                AppMethodBeat.o(192656);
            }
        };

        static {
            AppMethodBeat.i(192662);
            AppMethodBeat.o(192662);
        }

        public enum StateClassName {
            UNKNOWN_STATE,
            TIMEOUT_STATE,
            IDLE_STATE,
            SILENT_STATE,
            ACTION_STATE,
            REFLECT_STATE,
            OCR_AUTO_DETECT_STATE,
            OCR_MANUAL_DETECT_STATE,
            NET_FETCH_STATE,
            NET_LIVENESS_REQ_RESULT_STATE,
            NET_OCR_REQ_RESULT_STATE,
            LIPREAD_STATE,
            DETECTONLY_STATE,
            OCR_VIID_STATE,
            STATE_COUNT;

            public static StateClassName valueOf(String str) {
                AppMethodBeat.i(192658);
                StateClassName stateClassName = (StateClassName) Enum.valueOf(StateClassName.class, str);
                AppMethodBeat.o(192658);
                return stateClassName;
            }

            static {
                AppMethodBeat.i(192659);
                AppMethodBeat.o(192659);
            }
        }

        public static String classNameOfState(StateClassName stateClassName) {
            AppMethodBeat.i(192660);
            String str = _stateNameMap.get(stateClassName);
            AppMethodBeat.o(192660);
            return str;
        }

        public static StateClassName typeOfClassName(String str) {
            AppMethodBeat.i(192661);
            for (Map.Entry<StateClassName, String> entry : _stateNameMap.entrySet()) {
                if (entry.getValue().equals(str)) {
                    StateClassName key = entry.getKey();
                    AppMethodBeat.o(192661);
                    return key;
                }
            }
            StateClassName stateClassName = StateClassName.UNKNOWN_STATE;
            AppMethodBeat.o(192661);
            return stateClassName;
        }
    }

    public static class ProcessHelper {
        private static float crossProduct(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f4 * f3);
        }

        public static float preCheckCloseEyeScore(float[] fArr) {
            AppMethodBeat.i(192652);
            float f2 = fArr[32] - fArr[40];
            float f3 = fArr[33] - fArr[41];
            float sqrt = (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
            float abs = (Math.abs(crossProduct(f2, f3, fArr[36] - fArr[40], fArr[37] - fArr[41])) + Math.abs(crossProduct(f2, f3, fArr[44] - fArr[40], fArr[45] - fArr[41]))) / (sqrt * sqrt);
            float f4 = fArr[56] - fArr[48];
            float f5 = fArr[57] - fArr[49];
            float sqrt2 = (float) Math.sqrt((double) ((f4 * f4) + (f5 * f5)));
            float abs2 = (Math.abs(crossProduct(f4, f5, fArr[52] - fArr[56], fArr[53] - fArr[57])) + Math.abs(crossProduct(f4, f5, fArr[60] - fArr[56], fArr[61] - fArr[57]))) / (sqrt2 * sqrt2);
            if (abs > abs2) {
                AppMethodBeat.o(192652);
                return abs2;
            }
            AppMethodBeat.o(192652);
            return abs;
        }

        public static float calcEyeScore(float[] fArr) {
            AppMethodBeat.i(192653);
            float f2 = fArr[32] - fArr[40];
            float f3 = fArr[33] - fArr[41];
            float sqrt = (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
            float abs = (Math.abs(crossProduct(f2, f3, fArr[36] - fArr[40], fArr[37] - fArr[41])) + Math.abs(crossProduct(f2, f3, fArr[44] - fArr[40], fArr[45] - fArr[41]))) / (sqrt * sqrt);
            float f4 = fArr[56] - fArr[48];
            float f5 = fArr[57] - fArr[49];
            float sqrt2 = (float) Math.sqrt((double) ((f4 * f4) + (f5 * f5)));
            float abs2 = abs + ((Math.abs(crossProduct(f4, f5, fArr[52] - fArr[56], fArr[53] - fArr[57])) + Math.abs(crossProduct(f4, f5, fArr[60] - fArr[56], fArr[61] - fArr[57]))) / (sqrt2 * sqrt2));
            AppMethodBeat.o(192653);
            return abs2;
        }

        public static float calcMouthScore(float[] fArr) {
            AppMethodBeat.i(192654);
            float abs = Math.abs(((fArr[129] + fArr[109]) / 2.0f) - ((fArr[119] + fArr[97]) / 2.0f)) / Math.abs(fArr[90] - fArr[102]);
            AppMethodBeat.o(192654);
            return abs;
        }

        public static float[] convert90PTo5P(float[] fArr) {
            AppMethodBeat.i(192655);
            YtLogger.d("ProcessHelper", "90 to 5 convert size:" + fArr.length);
            float[] fArr2 = {fArr[176], fArr[177], fArr[178], fArr[179], fArr[64], fArr[65], fArr[90], fArr[91], fArr[102], fArr[103]};
            AppMethodBeat.o(192655);
            return fArr2;
        }
    }
}
