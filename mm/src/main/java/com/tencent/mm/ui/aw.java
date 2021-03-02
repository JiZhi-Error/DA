package com.tencent.mm.ui;

import android.content.Context;
import com.huawei.easygo.sdk.EasyGo;
import com.huawei.easygo.sdk.module.EasyGoRet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class aw {
    private static EasyGo easyGoManager = null;
    private static List<Integer> qQz;

    public static void kA(Context context) {
        AppMethodBeat.i(205307);
        if (easyGoManager == null) {
            easyGoManager = new EasyGo(context);
        }
        qQz = easyGoManager.init(new String[]{"magicwindow"});
        AppMethodBeat.o(205307);
    }

    public static boolean gWx() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(205308);
        if (qQz != null && qQz.size() > 0) {
            Log.d("huaweiUtil", "dancy test retList get(0):%s", qQz.get(0));
            if (qQz.get(0).intValue() == 0) {
                z = true;
            } else {
                z = false;
            }
            z2 = z;
        }
        AppMethodBeat.o(205308);
        return z2;
    }

    public static EasyGo gWy() {
        return easyGoManager;
    }

    public static int a(EasyGo easyGo, int i2) {
        AppMethodBeat.i(205309);
        if (easyGo == null) {
            AppMethodBeat.o(205309);
            return -1;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("@int:taskId", i2);
            EasyGoRet invokeSync = easyGo.invokeSync("magicwindow", "getTaskPosition", jSONObject, null);
            Log.i("EasyGo", new StringBuilder().append(invokeSync.code).toString());
            int i3 = invokeSync.result.getInt("int");
            Log.e("EasyGo", "getTaskPosition".concat(String.valueOf(i3)));
            AppMethodBeat.o(205309);
            return i3;
        } catch (JSONException e2) {
            Log.e("EasyGo", e2.getMessage());
            AppMethodBeat.o(205309);
            return -1;
        }
    }

    public static void a(EasyGo easyGo, int i2, int i3) {
        AppMethodBeat.i(205310);
        if (easyGo == null) {
            AppMethodBeat.o(205310);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("@int:taskId", i2);
            jSONObject.put("@int:targetPosition", i3);
        } catch (JSONException e2) {
            Log.e("EasyGo", e2.getMessage());
        }
        Log.i("EasyGo", new StringBuilder().append(easyGo.invokeSync("magicwindow", "setTaskPosition", jSONObject, null).code).toString());
        AppMethodBeat.o(205310);
    }

    public static void aoh(int i2) {
        AppMethodBeat.i(205311);
        if (easyGoManager == null) {
            AppMethodBeat.o(205311);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("@int:loginStatus", i2);
            Log.i("EasyGo", " setLoginStatus ret " + easyGoManager.invokeSync("magicwindow", "setLoginStatus", jSONObject, null).code);
            AppMethodBeat.o(205311);
        } catch (JSONException e2) {
            Log.e("EasyGo", e2.getMessage());
            AppMethodBeat.o(205311);
        }
    }

    public static boolean b(EasyGo easyGo, int i2) {
        AppMethodBeat.i(205312);
        if (a(easyGo, i2) == -1) {
            AppMethodBeat.o(205312);
            return false;
        }
        AppMethodBeat.o(205312);
        return true;
    }

    public static boolean kB(Context context) {
        AppMethodBeat.i(205313);
        String configuration = context.getResources().getConfiguration().toString();
        if (configuration.contains("hwMultiwindow-magic") || configuration.contains("hw-magic-windows")) {
            AppMethodBeat.o(205313);
            return true;
        }
        AppMethodBeat.o(205313);
        return false;
    }
}
