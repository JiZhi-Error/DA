package com.tencent.mm.plugin.appbrand.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "ErrCode", "api-protocol_release"})
public interface f {
    void onError(int i2, String str);

    void onSuccess();

    @l(hxD = {1, 1, 16})
    public static final class a {
        public static /* synthetic */ void a(f fVar, int i2) {
            AppMethodBeat.i(194313);
            fVar.onError(i2, null);
            AppMethodBeat.o(194313);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback$ErrCode;", "", "()V", "ERR_INVALID_PARAMS", "", "ERR_TASK_ALREADY_ALIVE", "ERR_TASK_BIND_REMOTE_SERVICE_FAIL", "ERR_TASK_CREATE_RUNTIME_FAILED", "ERR_TASK_GET_ATTRS_FAIL", "ERR_TASK_REMOTE_SERVICE_DIED", "ERR_TASK_RESOURCE_PREPARE_FAIL", "ERR_TASK_UNSUPPORTED", "OK", "codeToString", "", TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "api-protocol_release"})
    public static final class b {
        public static final b kHv = new b();

        static {
            AppMethodBeat.i(194314);
            AppMethodBeat.o(194314);
        }

        private b() {
        }

        public static String vM(int i2) {
            switch (i2) {
                case -8:
                    return "ERR_TASK_UNSUPPORTED";
                case -7:
                    return "ERR_TASK_RESOURCE_PREPARE_FAIL";
                case -6:
                    return "ERR_TASK_CREATE_RUNTIME_FAILED";
                case -5:
                    return "ERR_TASK_REMOTE_SERVICE_DIED";
                case -4:
                    return "ERR_TASK_BIND_REMOTE_SERVICE_FAIL";
                case -3:
                    return "ERR_TASK_GET_ATTRS_FAIL";
                case -2:
                    return "ERR_TASK_ALREADY_ALIVE";
                case -1:
                    return "ERR_INVALID_PARAMS";
                case 0:
                    return "OK";
                default:
                    return "UNKNOWN";
            }
        }
    }
}
