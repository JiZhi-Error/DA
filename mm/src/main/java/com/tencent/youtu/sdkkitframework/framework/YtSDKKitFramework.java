package com.tencent.youtu.sdkkitframework.framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.net.YtSDKKitNetHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class YtSDKKitFramework {
    private static final String TAG = YtSDKKitFramework.class.getSimpleName();
    private static YtSDKKitFramework instance = null;
    private static final String version = "1.0.8.67-wx";
    private Rect detectRect = new Rect(10, 110, 470, 530);
    private IYtSDKKitFrameworkEventListener eventListener;
    private int networkRequestTimeoutMS = 60000;
    private Rect previewRect = new Rect(0, 0, 480, 640);

    public interface IYTBaseFunctionListener {
        String base64Encode(byte[] bArr, int i2);

        byte[] getVoiceData();
    }

    public interface IYTReflectListener {
        float onGetAppBrightness();

        void onReflectEvent(ColorMatrixColorFilter colorMatrixColorFilter, float f2);

        void onReflectStart(long j2);
    }

    public interface IYtSDKKitFrameworkEventListener {
        void onFrameworkEvent(HashMap<String, Object> hashMap);

        void onNetworkRequestEvent(String str, String str2, HashMap<String, String> hashMap, IYtSDKKitNetResponseParser iYtSDKKitNetResponseParser);
    }

    public interface IYtSDKKitNetResponseParser {
        void onNetworkResponseEvent(HashMap<String, String> hashMap, Exception exc);
    }

    public static class YtSDKPlatformContext {
        public IYTBaseFunctionListener baseFunctionListener;
        public Context currentAppContext;
        public Camera currentCamera;
        public int currentCameraId;
        public int currentRotateState;
        public int imageToComapreType = 0;
        public Bitmap imageToCompare;
        public RelativeLayout reflectLayout;
        public IYTReflectListener reflectListener;
    }

    static {
        AppMethodBeat.i(192700);
        AppMethodBeat.o(192700);
    }

    public enum YtFrameworkFireEventType {
        YT_EVENT_TRIGGER_BEGIN_LIVENESS,
        YT_EVENT_TRIGGER_CANCEL_LIVENESS;

        public static YtFrameworkFireEventType valueOf(String str) {
            AppMethodBeat.i(192682);
            YtFrameworkFireEventType ytFrameworkFireEventType = (YtFrameworkFireEventType) Enum.valueOf(YtFrameworkFireEventType.class, str);
            AppMethodBeat.o(192682);
            return ytFrameworkFireEventType;
        }

        static {
            AppMethodBeat.i(192683);
            AppMethodBeat.o(192683);
        }
    }

    public enum YtSDKKitFrameworkWorkMode {
        YT_FW_UNKNOWN(0),
        YT_FW_OCR_TYPE(1),
        YT_FW_SILENT_TYPE(2),
        YT_FW_ACTION_TYPE(3),
        YT_FW_REFLECT_TYPE(4),
        YT_FW_ACTREFLECT_TYPE(5),
        YT_FW_LIPREAD_TYPE(6),
        YT_FW_DETECTONLY_TYPE(7),
        YT_FW_OCR_VIID_TYPE(8);
        
        private static HashMap<Integer, YtSDKKitFrameworkWorkMode> map = new HashMap<>();
        private int value;

        public static YtSDKKitFrameworkWorkMode valueOf(String str) {
            AppMethodBeat.i(192685);
            YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode = (YtSDKKitFrameworkWorkMode) Enum.valueOf(YtSDKKitFrameworkWorkMode.class, str);
            AppMethodBeat.o(192685);
            return ytSDKKitFrameworkWorkMode;
        }

        static {
            AppMethodBeat.i(192687);
            YtSDKKitFrameworkWorkMode[] values = values();
            for (YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode : values) {
                map.put(Integer.valueOf(ytSDKKitFrameworkWorkMode.value), ytSDKKitFrameworkWorkMode);
            }
            AppMethodBeat.o(192687);
        }

        private YtSDKKitFrameworkWorkMode(int i2) {
            this.value = i2;
        }

        public static YtSDKKitFrameworkWorkMode valueOf(int i2) {
            AppMethodBeat.i(192686);
            if (map.get(Integer.valueOf(i2)) == null) {
                YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode = YT_FW_UNKNOWN;
                AppMethodBeat.o(192686);
                return ytSDKKitFrameworkWorkMode;
            }
            YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode2 = map.get(Integer.valueOf(i2));
            AppMethodBeat.o(192686);
            return ytSDKKitFrameworkWorkMode2;
        }

        public final int getValue() {
            return this.value;
        }
    }

    private YtSDKKitFramework() {
        AppMethodBeat.i(192688);
        AppMethodBeat.o(192688);
    }

    private YtFSMBaseState parseStateFrom(String str, JSONObject jSONObject) {
        Throwable th;
        YtFSMBaseState ytFSMBaseState;
        AppMethodBeat.i(192689);
        try {
            ytFSMBaseState = (YtFSMBaseState) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            try {
                ytFSMBaseState.loadStateWith(str, jSONObject);
            } catch (Throwable th2) {
                th = th2;
                YtLogger.e(TAG, "Parse state " + str + "failed:" + th.getMessage());
                AppMethodBeat.o(192689);
                return ytFSMBaseState;
            }
        } catch (Throwable th3) {
            th = th3;
            ytFSMBaseState = null;
            YtLogger.e(TAG, "Parse state " + str + "failed:" + th.getMessage());
            AppMethodBeat.o(192689);
            return ytFSMBaseState;
        }
        AppMethodBeat.o(192689);
        return ytFSMBaseState;
    }

    public static synchronized YtSDKKitFramework getInstance() {
        YtSDKKitFramework ytSDKKitFramework;
        synchronized (YtSDKKitFramework.class) {
            AppMethodBeat.i(192690);
            if (instance == null) {
                instance = new YtSDKKitFramework();
            }
            ytSDKKitFramework = instance;
            AppMethodBeat.o(192690);
        }
        return ytSDKKitFramework;
    }

    public static synchronized void clearInstance() {
        synchronized (YtSDKKitFramework.class) {
            instance = null;
        }
    }

    public String version() {
        return version;
    }

    public int init(YtSDKPlatformContext ytSDKPlatformContext, JSONObject jSONObject, YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode, ArrayList<String> arrayList, IYtSDKKitFrameworkEventListener iYtSDKKitFrameworkEventListener) {
        int i2;
        AppMethodBeat.i(192691);
        YtLogger.i(TAG, "sdkkit framework 1.0.8.67-wx init");
        if (ytSDKPlatformContext == null) {
            YtLogger.e(TAG, "Context cannot be null");
            AppMethodBeat.o(192691);
            return -1;
        } else if (arrayList.isEmpty()) {
            YtLogger.e(TAG, "Pipeline state name cannot be empty");
            AppMethodBeat.o(192691);
            return -1;
        } else if (iYtSDKKitFrameworkEventListener == null) {
            YtLogger.e(TAG, "Event listener cannot be null");
            AppMethodBeat.o(192691);
            return -1;
        } else {
            YtFSM.getInstance().stop();
            YtFSM.getInstance().setEventListener(iYtSDKKitFrameworkEventListener);
            YtFSM.getInstance().setContext(ytSDKPlatformContext);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                YtFSM.getInstance().registerState(parseStateFrom(it.next(), jSONObject));
            }
            if (jSONObject.has("thread_priority")) {
                try {
                    i2 = jSONObject.getInt("thread_priority");
                } catch (JSONException e2) {
                    YtLogger.e(TAG, "failed to get priority " + e2.getLocalizedMessage());
                }
                YtFSM.getInstance().start(arrayList.get(0), ytSDKKitFrameworkWorkMode, i2);
                AppMethodBeat.o(192691);
                return 0;
            }
            i2 = -8;
            YtFSM.getInstance().start(arrayList.get(0), ytSDKKitFrameworkWorkMode, i2);
            AppMethodBeat.o(192691);
            return 0;
        }
    }

    public int deInit() {
        AppMethodBeat.i(192692);
        YtLogger.i(TAG, "sdkkit framework 1.0.8.67-wx deinit");
        YtSDKKitNetHelper.clearInstance();
        YtFSM.getInstance().stop();
        YtFSM.clearInstance();
        YtSDKStats.getInstance().exitState();
        YtSDKStats.clearInstance();
        AppMethodBeat.o(192692);
        return 0;
    }

    public void reset() {
        AppMethodBeat.i(192693);
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(192680);
                YtSDKStats.getInstance().reset();
                YtFSM.getInstance().reset();
                AppMethodBeat.o(192680);
            }
        });
        AppMethodBeat.o(192693);
    }

    public void fireEvent(YtFrameworkFireEventType ytFrameworkFireEventType, Object obj) {
        AppMethodBeat.i(192694);
        YtFSM.getInstance().handleEvent(ytFrameworkFireEventType, obj);
        AppMethodBeat.o(192694);
    }

    public int updateWithFrameData(byte[] bArr, int i2, int i3, int i4) {
        AppMethodBeat.i(192695);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis <= 946684800000L) {
            AppMethodBeat.o(192695);
            return ErrorCode.YT_SDK_TIMETICK_ERROR;
        }
        YtFSM.getInstance().update(bArr, i2, i3, i4, currentTimeMillis);
        AppMethodBeat.o(192695);
        return 0;
    }

    public void updateSDKSetting(JSONObject jSONObject) {
        AppMethodBeat.i(192696);
        YtFSM.getInstance().updateSDKSetting(jSONObject);
        AppMethodBeat.o(192696);
    }

    public void doPause() {
        AppMethodBeat.i(192697);
        YtFSM.getInstance().handlePauseEvent();
        AppMethodBeat.o(192697);
    }

    public void doResume() {
        AppMethodBeat.i(192698);
        YtFSM.getInstance().handleResumeEvent();
        AppMethodBeat.o(192698);
    }

    public YtSDKPlatformContext getPlatformContext() {
        AppMethodBeat.i(192699);
        YtSDKPlatformContext context = YtFSM.getInstance().getContext();
        AppMethodBeat.o(192699);
        return context;
    }

    public void setPreviewRect(Rect rect) {
        this.previewRect = rect;
    }

    public Rect getPreviewRect() {
        return this.previewRect;
    }

    public void setDetectRect(Rect rect) {
        this.detectRect = rect;
    }

    public Rect getDetectRect() {
        return this.detectRect;
    }

    public void setNetworkRequestTimeoutMS(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.networkRequestTimeoutMS = i2;
    }

    public int getNetworkRequestTimeoutMS() {
        return this.networkRequestTimeoutMS;
    }
}
