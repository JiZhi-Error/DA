package com.tencent.youtu.sdkkitframework.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import java.util.HashMap;

public class YtSDKStats extends YtFSMBaseState {
    private static YtSDKStats ytSDKStats = null;
    private String currentAction;
    private long currentEnterTimeStampMS;
    private String currentState;
    private String preInfo;
    private String preUpdateState;
    private HashMap<String, Object> stateNameMap = new HashMap<>();

    public YtSDKStats() {
        AppMethodBeat.i(192588);
        AppMethodBeat.o(192588);
    }

    public static synchronized YtSDKStats getInstance() {
        YtSDKStats ytSDKStats2;
        synchronized (YtSDKStats.class) {
            AppMethodBeat.i(192589);
            if (ytSDKStats == null) {
                ytSDKStats2 = new YtSDKStats();
                ytSDKStats = ytSDKStats2;
                AppMethodBeat.o(192589);
            } else {
                ytSDKStats2 = ytSDKStats;
                AppMethodBeat.o(192589);
            }
        }
        return ytSDKStats2;
    }

    public static synchronized void clearInstance() {
        synchronized (YtSDKStats.class) {
            if (ytSDKStats != null) {
                ytSDKStats = null;
            }
        }
    }

    public void registerStateName(String str) {
        AppMethodBeat.i(192590);
        this.stateNameMap.put(str, 0);
        AppMethodBeat.o(192590);
    }

    public void enterState(String str) {
        AppMethodBeat.i(192591);
        Object obj = this.stateNameMap.get(str);
        if (obj == null) {
            AppMethodBeat.o(192591);
            return;
        }
        this.currentAction = "enter";
        int intValue = ((Integer) obj).intValue();
        if (intValue == 0) {
            exitState();
            if (this.currentAction != null) {
                this.currentEnterTimeStampMS = System.currentTimeMillis();
                this.currentState = str;
                makeReport(this.currentState, this.currentAction, null, null, null);
            }
        }
        this.stateNameMap.put(str, Integer.valueOf(intValue + 1));
        AppMethodBeat.o(192591);
    }

    public void updateState(String str) {
        AppMethodBeat.i(192592);
        this.currentAction = "update";
        if (this.preUpdateState == null || !this.preUpdateState.equals(this.currentState)) {
            this.preUpdateState = this.currentState;
            makeReport(this.currentState, this.currentAction, null, null, null);
        }
        AppMethodBeat.o(192592);
    }

    public void exitState() {
        AppMethodBeat.i(192593);
        if (this.currentState != null) {
            makeReport(this.currentState, "exit", null, Long.toString(System.currentTimeMillis() - this.currentEnterTimeStampMS), null);
        }
        AppMethodBeat.o(192593);
    }

    public void reportError(int i2, String str) {
        AppMethodBeat.i(192594);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("error_code", Integer.valueOf(i2));
        hashMap.put("error_msg", str);
        makeReport(this.currentState, this.currentAction, hashMap, null, null);
        AppMethodBeat.o(192594);
    }

    public void reportInfo(String str) {
        AppMethodBeat.i(192595);
        if (this.preInfo == null || !this.preInfo.equals(str)) {
            this.preInfo = str;
        }
        makeReport(this.currentState, this.currentAction, null, null, str);
        AppMethodBeat.o(192595);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void reset() {
        AppMethodBeat.i(192596);
        for (String str : this.stateNameMap.keySet()) {
            this.stateNameMap.put(str, 0);
        }
        this.currentState = null;
        this.preUpdateState = null;
        this.preInfo = null;
        AppMethodBeat.o(192596);
    }

    private void makeReport(String str, String str2, HashMap<String, Object> hashMap, String str3, String str4) {
        AppMethodBeat.i(192597);
        HashMap<String, Object> hashMap2 = new HashMap<>();
        HashMap hashMap3 = new HashMap();
        hashMap3.put("state_id", str);
        hashMap3.put("state_action", str2);
        if (hashMap != null) {
            hashMap3.put("state_error", hashMap);
        }
        if (str3 != null) {
            hashMap3.put("state_cost", str3);
        }
        if (str4 != null) {
            hashMap3.put("state_info", str4);
        }
        hashMap2.put(StateEvent.Name.STATE_STATS, hashMap3);
        sendStateEvent(hashMap2);
        AppMethodBeat.o(192597);
    }

    private void sendStateEvent(HashMap<String, Object> hashMap) {
        AppMethodBeat.i(192598);
        if (hashMap != null) {
            YtFSM.getInstance().sendFSMEvent(hashMap);
        }
        AppMethodBeat.o(192598);
    }

    public static String getNowTimeStamp() {
        AppMethodBeat.i(192599);
        String valueOf = String.valueOf(System.currentTimeMillis());
        AppMethodBeat.o(192599);
        return valueOf;
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
    }
}
