package com.huawei.easygo.sdk;

import android.content.Context;
import android.os.Bundle;
import com.huawei.easygo.BuildConfig;
import com.huawei.easygo.callback.IEasyGoCallback;
import com.huawei.easygo.manager.EasyGoManager;
import com.huawei.easygo.sdk.module.EasyGoRet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public final class EasyGo {
    private static final String TAG = "EasyGo";
    private EasyGoManager mEasyGoManager = null;

    public EasyGo(Context context) {
        AppMethodBeat.i(190207);
        if (getRomSupStatus(context) == 0) {
            this.mEasyGoManager = new EasyGoManager(context);
        }
        AppMethodBeat.o(190207);
    }

    public final List<Integer> init(String[] strArr) {
        AppMethodBeat.i(190208);
        if (this.mEasyGoManager == null) {
            List<Integer> assembleInitFailRet = assembleInitFailRet(strArr);
            AppMethodBeat.o(190208);
            return assembleInitFailRet;
        }
        List<Integer> init = this.mEasyGoManager.init(strArr);
        AppMethodBeat.o(190208);
        return init;
    }

    public final EasyGoRet invokeSync(String str, String str2, JSONObject jSONObject, Bundle bundle) {
        AppMethodBeat.i(190209);
        if (this.mEasyGoManager == null) {
            EasyGoRet easyGoRet = new EasyGoRet(507, new Bundle());
            AppMethodBeat.o(190209);
            return easyGoRet;
        }
        EasyGoRet easyGoRet2 = new EasyGoRet(this.mEasyGoManager.invokeSync(str, str2, jSONObject, bundle));
        AppMethodBeat.o(190209);
        return easyGoRet2;
    }

    public final void invokeAsync(String str, String str2, JSONObject jSONObject, Bundle bundle, IEasyGoCallback iEasyGoCallback) {
        AppMethodBeat.i(190210);
        if (this.mEasyGoManager == null) {
            AppMethodBeat.o(190210);
            return;
        }
        this.mEasyGoManager.invokeAsync(str, str2, jSONObject, bundle, iEasyGoCallback);
        AppMethodBeat.o(190210);
    }

    public final void release() {
        AppMethodBeat.i(190211);
        if (this.mEasyGoManager == null) {
            AppMethodBeat.o(190211);
            return;
        }
        this.mEasyGoManager.release();
        AppMethodBeat.o(190211);
    }

    private int getRomSupStatus(Context context) {
        AppMethodBeat.i(190212);
        try {
            int romSupStatus = new EasyGoManager(context).getRomSupStatus(context, BuildConfig.VERSION_NAME);
            AppMethodBeat.o(190212);
            return romSupStatus;
        } catch (NoClassDefFoundError e2) {
            AppMethodBeat.o(190212);
            return 506;
        } catch (SecurityException e3) {
            AppMethodBeat.o(190212);
            return 508;
        } catch (Exception e4) {
            AppMethodBeat.o(190212);
            return 509;
        }
    }

    private List<Integer> assembleInitFailRet(String[] strArr) {
        AppMethodBeat.i(190213);
        if (strArr == null) {
            AppMethodBeat.o(190213);
            return null;
        }
        List<Integer> nCopies = Collections.nCopies(strArr.length, 507);
        AppMethodBeat.o(190213);
        return nCopies;
    }
}
