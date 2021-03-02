package com.tencent.youtu.sdkkitframework.framework;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

public class YtFSM {
    private static final String TAG = YtFSM.class.getSimpleName();
    private static YtFSM instance;
    private YtFSMUpdateData currentData = new YtFSMUpdateData();
    private YtFSMBaseState currentState;
    private YtSDKKitFramework.YtSDKKitFrameworkWorkMode currentWorkMode = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
    private YtSDKKitFramework.IYtSDKKitFrameworkEventListener eventListener;
    private String firstStateName;
    private boolean isStarted = false;
    private boolean needEventHandler = false;
    private YtSDKKitFramework.YtSDKPlatformContext sdkPlatformContex;
    private Lock startStopLock = new ReentrantLock();
    private Lock stateLock = new ReentrantLock();
    private HashMap<String, YtFSMBaseState> stateMap = new HashMap<>();
    private Thread updateEventHandler;
    private ConcurrentLinkedQueue<YtFSMUpdateData> updateQueue = new ConcurrentLinkedQueue<>();

    static {
        AppMethodBeat.i(192651);
        AppMethodBeat.o(192651);
    }

    /* access modifiers changed from: package-private */
    public class YtFSMUpdateData {
        byte[] imageData;
        int imageHeight;
        int imageType;
        int imageWidth;
        long timeStamp;

        private YtFSMUpdateData() {
        }
    }

    private YtFSM() {
        AppMethodBeat.i(192633);
        AppMethodBeat.o(192633);
    }

    public static synchronized YtFSM getInstance() {
        YtFSM ytFSM;
        synchronized (YtFSM.class) {
            AppMethodBeat.i(192634);
            if (instance == null) {
                instance = new YtFSM();
            }
            ytFSM = instance;
            AppMethodBeat.o(192634);
        }
        return ytFSM;
    }

    public static synchronized void clearInstance() {
        synchronized (YtFSM.class) {
            if (instance != null) {
                instance = null;
            }
        }
    }

    public void start(String str, YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode, final int i2) {
        AppMethodBeat.i(192635);
        YtLogger.i(TAG, "FSM start use work mode ".concat(String.valueOf(ytSDKKitFrameworkWorkMode)));
        try {
            this.startStopLock.lock();
            if (!this.isStarted) {
                this.firstStateName = str;
                this.currentWorkMode = ytSDKKitFrameworkWorkMode;
                this.isStarted = true;
                this.needEventHandler = true;
                if (this.stateMap.containsKey(this.firstStateName)) {
                    YtLogger.d(TAG, "start set current state:".concat(String.valueOf(str)));
                    this.currentState = this.stateMap.get(this.firstStateName);
                    this.currentState.enter();
                } else {
                    YtLogger.e(TAG, "Start " + str + " failed which is not found");
                }
                this.updateQueue.clear();
                this.updateEventHandler = new Thread(new Runnable() {
                    /* class com.tencent.youtu.sdkkitframework.framework.YtFSM.AnonymousClass1 */

                    public void run() {
                        YtFSMUpdateData ytFSMUpdateData;
                        AppMethodBeat.i(192631);
                        Process.setThreadPriority(i2);
                        while (YtFSM.this.needEventHandler) {
                            try {
                                YtFSM.this.stateLock.lock();
                                if (YtFSM.this.isStarted && (ytFSMUpdateData = (YtFSMUpdateData) YtFSM.this.updateQueue.poll()) != null) {
                                    YtFSM.this.currentData = ytFSMUpdateData;
                                    if (YtFSM.this.currentState != null) {
                                        YtFSM.this.currentState.update(YtFSM.this.currentData.imageData, YtFSM.this.currentData.imageWidth, YtFSM.this.currentData.imageHeight, YtFSM.this.currentData.imageType, YtFSM.this.currentData.timeStamp);
                                    }
                                }
                                YtFSM.this.stateLock.unlock();
                                try {
                                    Thread.sleep(10);
                                } catch (InterruptedException e2) {
                                    YtLogger.e(YtFSM.TAG, "sleep failed");
                                }
                            } catch (Throwable th) {
                                YtFSM.this.stateLock.unlock();
                                AppMethodBeat.o(192631);
                                throw th;
                            }
                        }
                        AppMethodBeat.o(192631);
                    }
                });
                this.updateEventHandler.setName("YtEventUpdateThread");
                this.updateEventHandler.start();
            }
        } catch (Exception e2) {
            YtLogger.e(TAG, e2.getLocalizedMessage());
        } finally {
            this.startStopLock.unlock();
            AppMethodBeat.o(192635);
        }
    }

    public void stop() {
        AppMethodBeat.i(192636);
        YtLogger.i(TAG, "FSM stop work mode " + this.currentWorkMode);
        try {
            this.startStopLock.lock();
            this.needEventHandler = false;
            if (this.updateEventHandler != null && this.updateEventHandler.isAlive()) {
                this.updateEventHandler.join();
            }
            if (this.isStarted) {
                this.isStarted = false;
                for (YtFSMBaseState ytFSMBaseState : this.stateMap.values()) {
                    ytFSMBaseState.unload();
                }
                this.stateMap.clear();
                this.updateQueue.clear();
            }
        } catch (InterruptedException e2) {
            YtLogger.e(TAG, e2.getLocalizedMessage());
        } finally {
            this.startStopLock.unlock();
            AppMethodBeat.o(192636);
        }
    }

    public void reset() {
        AppMethodBeat.i(192637);
        YtLogger.i(TAG, "FSM reset work mode " + this.currentWorkMode);
        try {
            this.stateLock.lock();
            if (this.isStarted) {
                for (YtFSMBaseState ytFSMBaseState : this.stateMap.values()) {
                    ytFSMBaseState.reset();
                }
                if (this.stateMap.containsKey(this.firstStateName)) {
                    YtLogger.d(TAG, "reset set current state:" + this.firstStateName);
                    this.currentState = this.stateMap.get(this.firstStateName);
                    this.currentState.enter();
                } else {
                    YtLogger.e(TAG, "reset failed: " + this.firstStateName + " state is not found");
                }
                this.updateQueue.clear();
            }
        } finally {
            this.stateLock.unlock();
            AppMethodBeat.o(192637);
        }
    }

    public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType ytFrameworkFireEventType, Object obj) {
        AppMethodBeat.i(192638);
        try {
            this.stateLock.lock();
            if (this.isStarted) {
                YtLogger.d(TAG, "handleevent " + ytFrameworkFireEventType + " for all states");
                for (YtFSMBaseState ytFSMBaseState : this.stateMap.values()) {
                    ytFSMBaseState.handleEvent(ytFrameworkFireEventType, obj);
                }
            }
        } finally {
            this.stateLock.unlock();
            AppMethodBeat.o(192638);
        }
    }

    public void update(byte[] bArr, int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(192639);
        if (this.isStarted) {
            YtFSMUpdateData ytFSMUpdateData = new YtFSMUpdateData();
            ytFSMUpdateData.imageData = bArr;
            ytFSMUpdateData.imageWidth = i2;
            ytFSMUpdateData.imageHeight = i3;
            ytFSMUpdateData.imageType = i4;
            ytFSMUpdateData.timeStamp = j2;
            if (this.updateQueue.size() >= 10) {
                this.updateQueue.poll();
                YtLogger.w(TAG, "drop frame");
            }
            this.updateQueue.add(ytFSMUpdateData);
        }
        AppMethodBeat.o(192639);
    }

    public void updateSDKSetting(JSONObject jSONObject) {
        AppMethodBeat.i(192640);
        for (YtFSMBaseState ytFSMBaseState : this.stateMap.values()) {
            ytFSMBaseState.updateSDKSetting(jSONObject);
        }
        AppMethodBeat.o(192640);
    }

    public void handlePauseEvent() {
        AppMethodBeat.i(192641);
        for (YtFSMBaseState ytFSMBaseState : this.stateMap.values()) {
            ytFSMBaseState.onPause();
        }
        AppMethodBeat.o(192641);
    }

    public void handleResumeEvent() {
        AppMethodBeat.i(192642);
        for (YtFSMBaseState ytFSMBaseState : this.stateMap.values()) {
            ytFSMBaseState.onResume();
        }
        AppMethodBeat.o(192642);
    }

    public int registerState(YtFSMBaseState ytFSMBaseState) {
        AppMethodBeat.i(192643);
        YtSDKStats.getInstance().registerStateName(ytFSMBaseState.getStateSimpleName());
        this.stateMap.put(ytFSMBaseState.getStateName(), ytFSMBaseState);
        AppMethodBeat.o(192643);
        return 0;
    }

    public int transitNow(String str) {
        int i2;
        AppMethodBeat.i(192644);
        if (this.stateMap.containsKey(str)) {
            this.currentState.exit();
            YtLogger.d(TAG, "transitnow set current state:".concat(String.valueOf(str)));
            this.currentState = this.stateMap.get(str);
            this.currentState.enter();
            if (this.currentData != null) {
                this.currentState.update(this.currentData.imageData, this.currentData.imageWidth, this.currentData.imageHeight, this.currentData.imageType, this.currentData.timeStamp);
                i2 = 0;
            } else {
                i2 = 0;
            }
        } else {
            i2 = -1;
            YtLogger.e(TAG, "transitnow failed:" + str + " state is not found");
        }
        AppMethodBeat.o(192644);
        return i2;
    }

    public int transitNextRound(String str) {
        int i2;
        AppMethodBeat.i(192645);
        if (this.stateMap.containsKey(str)) {
            this.currentState.exit();
            YtLogger.d(TAG, "transitnextround set current state:".concat(String.valueOf(str)));
            this.currentState = this.stateMap.get(str);
            this.currentState.enter();
            i2 = 0;
        } else {
            i2 = -1;
            YtLogger.e(TAG, "transitnextround faild:" + str + " state is not found");
        }
        AppMethodBeat.o(192645);
        return i2;
    }

    public YtFSMBaseState getStateByName(String str) {
        AppMethodBeat.i(192646);
        if (this.stateMap.containsKey(str)) {
            YtFSMBaseState ytFSMBaseState = this.stateMap.get(str);
            AppMethodBeat.o(192646);
            return ytFSMBaseState;
        }
        AppMethodBeat.o(192646);
        return null;
    }

    public void sendFSMEvent(HashMap<String, Object> hashMap) {
        AppMethodBeat.i(192647);
        if (this.eventListener != null) {
            if (hashMap.containsKey(StateEvent.Name.PROCESS_RESULT)) {
                YtLogger.d(TAG, "send framework event result: " + hashMap.get(StateEvent.Name.PROCESS_RESULT) + " errorcode:" + hashMap.get("error_code"));
            }
            this.eventListener.onFrameworkEvent(hashMap);
            AppMethodBeat.o(192647);
            return;
        }
        YtLogger.e(TAG, "Event listener not init");
        AppMethodBeat.o(192647);
    }

    public void sendNetworkRequest(final String str, String str2, String str3, HashMap<String, String> hashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser iYtSDKKitNetResponseParser) {
        AppMethodBeat.i(192648);
        if (this.eventListener != null) {
            sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.framework.YtFSM.AnonymousClass2 */

                {
                    AppMethodBeat.i(192632);
                    put(StateEvent.Name.UI_TIPS, str);
                    AppMethodBeat.o(192632);
                }
            });
            this.eventListener.onNetworkRequestEvent(str2, str3, hashMap, iYtSDKKitNetResponseParser);
            AppMethodBeat.o(192648);
            return;
        }
        YtLogger.e(TAG, "Event listener not init");
        AppMethodBeat.o(192648);
    }

    public YtSDKKitFramework.YtSDKKitFrameworkWorkMode getWorkMode() {
        return this.currentWorkMode;
    }

    public void setContext(YtSDKKitFramework.YtSDKPlatformContext ytSDKPlatformContext) {
        this.sdkPlatformContex = ytSDKPlatformContext;
    }

    public void setEventListener(YtSDKKitFramework.IYtSDKKitFrameworkEventListener iYtSDKKitFrameworkEventListener) {
        this.eventListener = iYtSDKKitFrameworkEventListener;
    }

    public YtSDKKitFramework.YtSDKPlatformContext getContext() {
        AppMethodBeat.i(192649);
        if (this.sdkPlatformContex == null) {
            this.sdkPlatformContex = new YtSDKKitFramework.YtSDKPlatformContext();
        }
        YtSDKKitFramework.YtSDKPlatformContext ytSDKPlatformContext = this.sdkPlatformContex;
        AppMethodBeat.o(192649);
        return ytSDKPlatformContext;
    }

    public void cleanUpQueue() {
        AppMethodBeat.i(192650);
        this.updateQueue.clear();
        AppMethodBeat.o(192650);
    }
}
