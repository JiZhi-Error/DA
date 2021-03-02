package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/PreRenderIDKeyReport;", "", "()V", "ID", "", "KEY_TASK_COMPLETE", "KEY_TASK_FAIL_ALREADY_ALIVE", "KEY_TASK_FAIL_BIND_REMOTE_SERVICE_FAIL", "KEY_TASK_FAIL_CREATE_RUNTIME_FAILED", "KEY_TASK_FAIL_GET_ATTRS_FAIL", "KEY_TASK_FAIL_INVALID_PARAMS", "KEY_TASK_FAIL_REMOTE_SERVICE_DIED", "KEY_TASK_FAIL_RESOURCE_PREPARE_FAIL", "KEY_TASK_FAIL_UNSUPPORTED", "KEY_TASK_START", "codeToKey", TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "plugin-appbrand-integration_release"})
public final class as {
    public static final as kFm = new as();

    static {
        AppMethodBeat.i(227934);
        AppMethodBeat.o(227934);
    }

    private as() {
    }

    public static int vD(int i2) {
        switch (i2) {
            case -8:
                return 9;
            case -7:
                return 8;
            case -6:
                return 7;
            case -5:
                return 6;
            case -4:
                return 5;
            case -3:
                return 4;
            case -2:
                return 3;
            case -1:
                return 2;
            case 0:
                return 1;
            default:
                return 10000;
        }
    }
}
