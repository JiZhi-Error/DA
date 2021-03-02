package org.xwalk.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkLibraryLoader;

public class XWalkInitializer {
    private static final String TAG = "XWalkLib";
    private Context mContext;
    private XWalkInitListener mInitListener;
    private boolean mIsXWalkReady;

    public interface XWalkInitListener {
        void onXWalkInitCancelled();

        void onXWalkInitCompleted();

        void onXWalkInitFailed();

        void onXWalkInitStarted();
    }

    public XWalkInitializer(XWalkInitListener xWalkInitListener, Context context) {
        AppMethodBeat.i(154753);
        this.mInitListener = xWalkInitListener;
        this.mContext = context;
        XWalkLibraryLoader.prepareToInit(this.mContext);
        AppMethodBeat.o(154753);
    }

    public boolean initAsync_remove() {
        AppMethodBeat.i(154754);
        if (this.mIsXWalkReady) {
            AppMethodBeat.o(154754);
            return false;
        } else if (XWalkLibraryLoader.isInitializing() || XWalkLibraryLoader.isDownloading()) {
            Log.i(TAG, "Other initialization or download is proceeding");
            AppMethodBeat.o(154754);
            return false;
        } else {
            Log.i(TAG, "Initialized by XWalkInitializer");
            this.mInitListener.onXWalkInitStarted();
            AppMethodBeat.o(154754);
            return true;
        }
    }

    public static void addXWalkInitializeLog(String str, String str2) {
        AppMethodBeat.i(154755);
        XWalkEnvironment.addXWalkInitializeLog(str, str2);
        AppMethodBeat.o(154755);
    }

    public static void addXWalkInitializeLog(String str) {
        AppMethodBeat.i(154756);
        XWalkEnvironment.addXWalkInitializeLog(str);
        AppMethodBeat.o(154756);
    }

    public static String getXWalkInitializeLog() {
        AppMethodBeat.i(154757);
        SharedPreferences sharedPreferencesForLog = XWalkEnvironment.getSharedPreferencesForLog();
        if (sharedPreferencesForLog == null) {
            AppMethodBeat.o(154757);
            return "";
        }
        String string = sharedPreferencesForLog.getString("log", "");
        AppMethodBeat.o(154757);
        return string;
    }

    public boolean tryInitSync() {
        AppMethodBeat.i(154758);
        if (!XWalkEnvironment.hasAvailableVersion()) {
            if (XWalkEnvironment.getAvailableVersion() == -1) {
                addXWalkInitializeLog("no available version ,need download");
            } else {
                addXWalkInitializeLog("sdk not support this apk, need update new");
            }
            AppMethodBeat.o(154758);
            return false;
        }
        if (XWalkCoreWrapper.attachXWalkCore(XWalkEnvironment.getAvailableVersion()) == 1) {
            XWalkCoreWrapper.dockXWalkCore();
            XWalkCoreWrapper.getInstance().initNotifyChannnel();
            RuntimeToSdkChannel.initRuntimeToSdkChannel();
            this.mIsXWalkReady = true;
            XWalkLibraryLoader.finishInit(this.mContext);
            this.mInitListener.onXWalkInitCompleted();
            AppMethodBeat.o(154758);
            return true;
        }
        AppMethodBeat.o(154758);
        return false;
    }

    public boolean isXWalkReady() {
        return this.mIsXWalkReady;
    }

    public boolean isSharedMode() {
        AppMethodBeat.i(154759);
        if (!this.mIsXWalkReady || !XWalkLibraryLoader.isSharedLibrary()) {
            AppMethodBeat.o(154759);
            return false;
        }
        AppMethodBeat.o(154759);
        return true;
    }

    public boolean isDownloadMode() {
        AppMethodBeat.i(154760);
        if (!this.mIsXWalkReady || !XWalkEnvironment.isDownloadMode()) {
            AppMethodBeat.o(154760);
            return false;
        }
        AppMethodBeat.o(154760);
        return true;
    }

    class XWalkLibraryListener implements XWalkLibraryLoader.ActivateListener, XWalkLibraryLoader.DecompressListener {
        private XWalkLibraryListener() {
        }

        @Override // org.xwalk.core.XWalkLibraryLoader.DecompressListener
        public void onDecompressStarted() {
        }

        @Override // org.xwalk.core.XWalkLibraryLoader.DecompressListener
        public void onDecompressCancelled() {
            AppMethodBeat.i(154750);
            XWalkInitializer.this.mInitListener.onXWalkInitCancelled();
            AppMethodBeat.o(154750);
        }

        @Override // org.xwalk.core.XWalkLibraryLoader.DecompressListener
        public void onDecompressCompleted() {
        }

        @Override // org.xwalk.core.XWalkLibraryLoader.ActivateListener
        public void onActivateStarted() {
        }

        @Override // org.xwalk.core.XWalkLibraryLoader.ActivateListener
        public void onActivateFailed() {
            AppMethodBeat.i(154751);
            XWalkInitializer.this.mInitListener.onXWalkInitFailed();
            AppMethodBeat.o(154751);
        }

        @Override // org.xwalk.core.XWalkLibraryLoader.ActivateListener
        public void onActivateCompleted() {
            AppMethodBeat.i(154752);
            XWalkInitializer.this.mIsXWalkReady = true;
            XWalkLibraryLoader.finishInit(XWalkInitializer.this.mContext);
            XWalkInitializer.this.mInitListener.onXWalkInitCompleted();
            AppMethodBeat.o(154752);
        }
    }
}
