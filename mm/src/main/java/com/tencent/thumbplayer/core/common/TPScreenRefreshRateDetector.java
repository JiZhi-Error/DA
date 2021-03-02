package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class TPScreenRefreshRateDetector {
    public static final int DISPLAY_CHANGE = 10001;
    private static String TAG = "TPScreenRefreshRateDetector";
    private static boolean isInitted = false;
    private static List<ScreenRefreshRateChangedListener> listeners = new LinkedList();
    private static WeakReference<Context> mContext = null;
    private static float mCurScreenRefreshRate = 60.0f;
    private static DisplayManager.DisplayListener mDisplayListener = new DisplayManager.DisplayListener() {
        /* class com.tencent.thumbplayer.core.common.TPScreenRefreshRateDetector.AnonymousClass2 */

        public final void onDisplayAdded(int i2) {
        }

        public final void onDisplayRemoved(int i2) {
        }

        public final void onDisplayChanged(int i2) {
            AppMethodBeat.i(189797);
            if (i2 == 0) {
                TPScreenRefreshRateDetector.mHandler.sendEmptyMessage(10001);
            }
            TPNativeLog.printLog(2, TPScreenRefreshRateDetector.TAG, "onDisplayChanged displayId:".concat(String.valueOf(i2)));
            AppMethodBeat.o(189797);
        }
    };
    private static DisplayManager mDisplayManager = null;
    private static Handler mHandler;
    private static WindowManager mWindowManager = null;

    /* access modifiers changed from: package-private */
    public interface ScreenRefreshRateChangedListener {
        void onScreenRefreshRateChanged(float f2);
    }

    static /* synthetic */ void access$200(float f2) {
        AppMethodBeat.i(189806);
        notifyScreenRefreshRateChange(f2);
        AppMethodBeat.o(189806);
    }

    static {
        AppMethodBeat.i(189807);
        AppMethodBeat.o(189807);
    }

    private static Looper getLooper() {
        AppMethodBeat.i(189798);
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            AppMethodBeat.o(189798);
            return myLooper;
        }
        Looper mainLooper = Looper.getMainLooper();
        AppMethodBeat.o(189798);
        return mainLooper;
    }

    private static void notifyScreenRefreshRateChange(float f2) {
        AppMethodBeat.i(189799);
        boolean z = false;
        if (Math.abs(f2 - mCurScreenRefreshRate) >= 1.0f) {
            TPNativeLog.printLog(2, TAG, "notifyScreenRefreshRateChange Change From " + mCurScreenRefreshRate + " to " + f2);
            z = true;
        }
        if (!z) {
            AppMethodBeat.o(189799);
            return;
        }
        mCurScreenRefreshRate = f2;
        synchronized (TPScreenRefreshRateDetector.class) {
            try {
                for (ScreenRefreshRateChangedListener screenRefreshRateChangedListener : listeners) {
                    screenRefreshRateChangedListener.onScreenRefreshRateChanged(f2);
                }
            } finally {
                AppMethodBeat.o(189799);
            }
        }
    }

    public static void initHandleMsg() {
        AppMethodBeat.i(189800);
        mHandler = new Handler(getLooper()) {
            /* class com.tencent.thumbplayer.core.common.TPScreenRefreshRateDetector.AnonymousClass1 */

            public final void handleMessage(Message message) {
                AppMethodBeat.i(189796);
                switch (message.what) {
                    case 10001:
                        if (TPScreenRefreshRateDetector.mDisplayManager != null) {
                            Display display = TPScreenRefreshRateDetector.mDisplayManager.getDisplay(0);
                            TPNativeLog.printLog(2, TPScreenRefreshRateDetector.TAG, "handleMessage DISPLAY_CHANGE, mode:" + display.getMode().toString().toString());
                            TPScreenRefreshRateDetector.access$200(display.getMode().getRefreshRate());
                            break;
                        }
                        break;
                }
                super.handleMessage(message);
                AppMethodBeat.o(189796);
            }
        };
        AppMethodBeat.o(189800);
    }

    public static void init(Context context) {
        AppMethodBeat.i(189801);
        synchronized (TPScreenRefreshRateDetector.class) {
            try {
                TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector init enter!");
                if (!isInitted) {
                    mContext = new WeakReference<>(context.getApplicationContext());
                    isInitted = true;
                    initHandleMsg();
                    TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector init succeed!");
                    AppMethodBeat.o(189801);
                }
            } finally {
                AppMethodBeat.o(189801);
            }
        }
    }

    public static void deinit() {
        AppMethodBeat.i(189802);
        synchronized (TPScreenRefreshRateDetector.class) {
            try {
                if (isInitted && mContext != null) {
                    mContext.clear();
                    isInitted = false;
                    TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector deinit succeed!");
                    AppMethodBeat.o(189802);
                }
            } finally {
                AppMethodBeat.o(189802);
            }
        }
    }

    public static void addListener(ScreenRefreshRateChangedListener screenRefreshRateChangedListener) {
        AppMethodBeat.i(189803);
        synchronized (TPScreenRefreshRateDetector.class) {
            try {
                listeners.add(screenRefreshRateChangedListener);
            } finally {
                AppMethodBeat.o(189803);
            }
        }
    }

    public static void removeListener(ScreenRefreshRateChangedListener screenRefreshRateChangedListener) {
        AppMethodBeat.i(189804);
        synchronized (TPScreenRefreshRateDetector.class) {
            try {
                listeners.remove(screenRefreshRateChangedListener);
            } finally {
                AppMethodBeat.o(189804);
            }
        }
    }

    public static float getScreenRefreshRate() {
        AppMethodBeat.i(189805);
        if (Build.VERSION.SDK_INT < 23) {
            TPNativeLog.printLog(4, TAG, "Current version can not get screen refresh rate, set default.");
            float f2 = mCurScreenRefreshRate;
            AppMethodBeat.o(189805);
            return f2;
        } else if (mContext == null) {
            TPNativeLog.printLog(4, TAG, "Current mContext is null, set default.");
            float f3 = mCurScreenRefreshRate;
            AppMethodBeat.o(189805);
            return f3;
        } else {
            Context context = mContext.get();
            if (context != null) {
                if (mWindowManager == null) {
                    mWindowManager = (WindowManager) context.getSystemService("window");
                }
                if (mDisplayManager == null) {
                    DisplayManager displayManager = (DisplayManager) context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
                    mDisplayManager = displayManager;
                    displayManager.registerDisplayListener(mDisplayListener, mHandler);
                }
                if (mWindowManager != null) {
                    Display defaultDisplay = mWindowManager.getDefaultDisplay();
                    Display.Mode[] supportedModes = defaultDisplay.getSupportedModes();
                    Display.Mode mode = defaultDisplay.getMode();
                    TPNativeLog.printLog(2, TAG, "getMode width:" + mode.getPhysicalWidth() + " height:" + mode.getPhysicalHeight() + " refreshRate:" + mode.getRefreshRate() + " ModeId:" + mode.getModeId());
                    TPNativeLog.printLog(2, TAG, "getSupportedModes length:" + supportedModes.length);
                    for (int i2 = 0; i2 < supportedModes.length; i2++) {
                        TPNativeLog.printLog(2, TAG, "getSupportedModes width:" + supportedModes[i2].getPhysicalWidth() + " height:" + supportedModes[i2].getPhysicalHeight() + " refreshRate:" + supportedModes[i2].getRefreshRate() + " ModeId:" + supportedModes[i2].getModeId());
                    }
                    mCurScreenRefreshRate = mode.getRefreshRate();
                }
            }
            float f4 = mCurScreenRefreshRate;
            AppMethodBeat.o(189805);
            return f4;
        }
    }
}
