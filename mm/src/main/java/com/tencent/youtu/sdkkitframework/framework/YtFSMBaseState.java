package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.util.HashMap;
import org.json.JSONObject;

public abstract class YtFSMBaseState {
    private static final String TAG = YtFSMBaseState.class.getSimpleName();
    protected boolean isFirstEnter = true;
    public HashMap<String, Object> stateData;
    protected String stateName;
    protected String stateSimpleName;

    public abstract void enterFirst();

    public void loadStateWith(String str, JSONObject jSONObject) {
        this.stateName = str;
        try {
            this.stateSimpleName = Class.forName(str).getSimpleName();
        } catch (Exception e2) {
            String[] split = str.split("\\.");
            this.stateSimpleName = split[split.length - 1];
        }
        YtLogger.i(TAG, "load " + this.stateSimpleName);
        this.stateData = new HashMap<>();
        YtSDKStats.getInstance().registerStateName(this.stateSimpleName);
    }

    public void unload() {
        YtLogger.i(TAG, "unload " + this.stateSimpleName);
        this.stateData.clear();
    }

    public void reset() {
        this.isFirstEnter = true;
        this.stateData.clear();
        YtLogger.i(TAG, this.stateName + " reset");
    }

    public void enter() {
        YtSDKStats.getInstance().enterState(this.stateSimpleName);
        if (this.isFirstEnter) {
            this.isFirstEnter = false;
            enterFirst();
        }
        YtLogger.d(TAG, this.stateName + " enter");
    }

    public void exit() {
        YtLogger.d(TAG, this.stateName + " exit");
    }

    public void moveToNextState() {
        YtLogger.d(TAG, this.stateName + " move to next");
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void update(byte[] bArr, int i2, int i3, int i4, long j2) {
        YtSDKStats.getInstance().updateState(this.stateName);
        YtLogger.d(TAG, this.stateName + " update image : " + i2 + "x" + i3 + " type " + i4);
    }

    public void updateSDKSetting(JSONObject jSONObject) {
    }

    public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType ytFrameworkFireEventType, Object obj) {
    }

    public String getStateName() {
        return this.stateName;
    }

    public String getStateSimpleName() {
        return this.stateSimpleName;
    }

    public Object getStateDataBy(String str) {
        return this.stateData.get(str);
    }

    public void handleStateAction(String str, Object obj) {
    }
}
