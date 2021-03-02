package com.tencent.scanlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.QbarNative;
import com.tencent.scanlib.model.DetectCode;
import com.tencent.stubs.logger.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.a.c;

public final class a {
    public static boolean isNullOrNil(String str) {
        AppMethodBeat.i(3505);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(3505);
            return true;
        }
        AppMethodBeat.o(3505);
        return false;
    }

    private static void d(InputStream inputStream, String str) {
        AppMethodBeat.i(3506);
        File file = new File(str);
        if (!file.exists() || file.exists()) {
            try {
                file.delete();
                c.c(inputStream, file);
                AppMethodBeat.o(3506);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(3506);
    }

    public static int cL(String str) {
        int i2 = 0;
        AppMethodBeat.i(3507);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i2 = Integer.decode(str).intValue();
                    AppMethodBeat.o(3507);
                    return i2;
                }
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(3507);
            }
        }
        AppMethodBeat.o(3507);
        return i2;
    }

    public static ArrayList<DetectCode> G(List<QbarNative.QBarCodeDetectInfo> list, List<QbarNative.QBarPoint> list2) {
        AppMethodBeat.i(3508);
        ArrayList<DetectCode> arrayList = new ArrayList<>();
        if (!list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                QbarNative.QBarCodeDetectInfo qBarCodeDetectInfo = list.get(i2);
                QbarNative.QBarPoint qBarPoint = list2.get(i2);
                ArrayList arrayList2 = new ArrayList(qBarPoint.point_cnt);
                if (qBarPoint.point_cnt > 0) {
                    arrayList2.add(new Point((int) qBarPoint.x0, (int) qBarPoint.y0));
                }
                if (qBarPoint.point_cnt > 1) {
                    arrayList2.add(new Point((int) qBarPoint.x1, (int) qBarPoint.y1));
                }
                if (qBarPoint.point_cnt > 2) {
                    arrayList2.add(new Point((int) qBarPoint.x2, (int) qBarPoint.y2));
                }
                if (qBarPoint.point_cnt > 3) {
                    arrayList2.add(new Point((int) qBarPoint.x3, (int) qBarPoint.y3));
                }
                arrayList.add(new DetectCode(qBarCodeDetectInfo.readerId, arrayList2, qBarCodeDetectInfo.prob));
            }
        }
        AppMethodBeat.o(3508);
        return arrayList;
    }

    public static QbarNative.QbarAiModelParam lb(Context context) {
        AppMethodBeat.i(3509);
        try {
            String str = context.getFilesDir().getAbsolutePath() + "/qbar";
            String str2 = str + "/detect_model.bin";
            String str3 = str + "/detect_model.param";
            String str4 = str + "/srnet.bin";
            String str5 = str + "/srnet.param";
            SharedPreferences sharedPreferences = context.getSharedPreferences("qbar_ai_preference_file", 0);
            int i2 = sharedPreferences.getInt("qbar_ai_model_version", 0);
            int i3 = sharedPreferences.getInt("qbar_ai_model_copy_version", 0);
            Log.i("ScanUtil", String.format("version %d, copyVersion %d", Integer.valueOf(i2), Integer.valueOf(i3)));
            if (!(i2 == 103 && i2 == i3)) {
                d(context.getResources().getAssets().open("qbar/detect_model.bin"), str2);
                d(context.getResources().getAssets().open("qbar/detect_model.param"), str3);
                d(context.getResources().getAssets().open("qbar/srnet.bin"), str4);
                d(context.getResources().getAssets().open("qbar/srnet.param"), str5);
                sharedPreferences.edit().putInt("qbar_ai_model_version", 103).apply();
                sharedPreferences.edit().putInt("qbar_ai_model_copy_version", 103).commit();
            }
            QbarNative.QbarAiModelParam qbarAiModelParam = new QbarNative.QbarAiModelParam();
            qbarAiModelParam.detect_model_bin_path_ = str2;
            qbarAiModelParam.detect_model_param_path_ = str3;
            qbarAiModelParam.superresolution_model_bin_path_ = str4;
            qbarAiModelParam.superresolution_model_param_path_ = str5;
            AppMethodBeat.o(3509);
            return qbarAiModelParam;
        } catch (Exception e2) {
            Log.e("ScanUtil", "copy qbar ai model file error! " + e2.getMessage());
            AppMethodBeat.o(3509);
            return null;
        }
    }
}
