package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon;
import java.util.HashMap;

public class TimeoutState extends YtFSMBaseState {
    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enter() {
        AppMethodBeat.i(192630);
        super.enter();
        YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
            /* class com.tencent.youtu.sdkkitframework.framework.TimeoutState.AnonymousClass1 */

            {
                AppMethodBeat.i(192629);
                put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
                put("error_code", Integer.valueOf((int) ErrorCode.YT_SDK_VERIFY_TIMEOUT));
                put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_VERIFY_TIMEOUT, StringCode.MSG_TIMEOUT_ERROR, "Timeout"));
                AppMethodBeat.o(192629);
            }
        });
        YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
        AppMethodBeat.o(192630);
    }
}
