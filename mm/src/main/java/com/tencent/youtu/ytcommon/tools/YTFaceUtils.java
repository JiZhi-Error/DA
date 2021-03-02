package com.tencent.youtu.ytcommon.tools;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;

public class YTFaceUtils {
    private static final String TAG = "FaceUtils";

    public interface ShelterJudge {
        public static final int SHELTER_CHIN = 2;
        public static final int SHELTER_LEFTEYE = 7;
        public static final int SHELTER_LEFTFACE = 1;
        public static final int SHELTER_MOUTH = 3;
        public static final int SHELTER_NOSE = 5;
        public static final int SHELTER_PARAM_ERROR = -2;
        public static final int SHELTER_PARAM_NULL = -1;
        public static final int SHELTER_PASS = 0;
        public static final int SHELTER_RIGHTEYE = 6;
        public static final int SHELTER_RIGHTFACE = 4;
    }

    public static Rect getFaceScreen(YTFaceTrack.FaceStatus faceStatus) {
        int i2 = 0;
        AppMethodBeat.i(73375);
        float f2 = faceStatus.xys[0];
        float f3 = faceStatus.xys[0];
        float f4 = faceStatus.xys[1];
        float f5 = faceStatus.xys[1];
        while (i2 < 180) {
            if (f2 >= faceStatus.xys[i2]) {
                f2 = faceStatus.xys[i2];
            }
            if (f3 <= faceStatus.xys[i2]) {
                f3 = faceStatus.xys[i2];
            }
            int i3 = i2 + 1;
            if (f4 >= faceStatus.xys[i3]) {
                f4 = faceStatus.xys[i3];
            }
            if (f5 <= faceStatus.xys[i3]) {
                f5 = faceStatus.xys[i3];
            }
            i2 = i3 + 1;
        }
        Rect rect = new Rect((int) f2, (int) f4, (int) f3, (int) f5);
        AppMethodBeat.o(73375);
        return rect;
    }

    public static int shelterJudge(float[] fArr) {
        AppMethodBeat.i(73376);
        if (fArr == null) {
            YTLogger.i(TAG, "[YTFaceTraceInterface.blockJudge] input pointsVis is null.");
            AppMethodBeat.o(73376);
            return -1;
        } else if (fArr.length != 90) {
            YTLogger.i(TAG, "[YTFaceTraceInterface.blockJudge] input pointsVis.length != 90. current pointsVis.length: " + fArr.length);
            AppMethodBeat.o(73376);
            return -2;
        } else {
            int i2 = 0;
            for (int i3 = 33; i3 <= 45; i3++) {
                if (fArr[i3 - 1] < 0.7f) {
                    i2++;
                }
            }
            if (i2 >= 4) {
                AppMethodBeat.o(73376);
                return 5;
            }
            int i4 = 0;
            for (int i5 = 46; i5 <= 67; i5++) {
                if (fArr[i5 - 1] < 0.7f) {
                    i4++;
                }
            }
            if (i4 >= 4) {
                AppMethodBeat.o(73376);
                return 3;
            }
            int i6 = 0;
            for (int i7 = 9; i7 <= 16; i7++) {
                if (fArr[i7 - 1] < 0.7f) {
                    i6++;
                }
            }
            for (int i8 = 25; i8 <= 32; i8++) {
                if (fArr[i8 - 1] < 0.7f) {
                    i6++;
                }
            }
            if (fArr[89] < 0.7f) {
                i6++;
            }
            if (i6 >= 4) {
                AppMethodBeat.o(73376);
                return 6;
            }
            int i9 = 0;
            for (int i10 = 1; i10 <= 8; i10++) {
                if (fArr[i10 - 1] < 0.7f) {
                    i9++;
                }
            }
            for (int i11 = 17; i11 <= 24; i11++) {
                if (fArr[i11 - 1] < 0.7f) {
                    i9++;
                }
            }
            if (fArr[88] < 0.7f) {
                i9++;
            }
            if (i9 >= 4) {
                AppMethodBeat.o(73376);
                return 7;
            }
            int i12 = 0;
            for (int i13 = 68; i13 < 74; i13++) {
                if (fArr[i13 - 1] < 0.7f) {
                    i12++;
                }
            }
            if (i12 >= 3) {
                AppMethodBeat.o(73376);
                return 1;
            }
            int i14 = 0;
            for (int i15 = 82; i15 <= 88; i15++) {
                if (fArr[i15 - 1] < 0.7f) {
                    i14++;
                }
            }
            if (i14 >= 3) {
                AppMethodBeat.o(73376);
                return 4;
            }
            int i16 = 0;
            for (int i17 = 75; i17 <= 81; i17++) {
                if (fArr[i17 - 1] < 0.7f) {
                    i16++;
                }
            }
            if (i16 >= 3) {
                AppMethodBeat.o(73376);
                return 2;
            }
            AppMethodBeat.o(73376);
            return 0;
        }
    }
}
