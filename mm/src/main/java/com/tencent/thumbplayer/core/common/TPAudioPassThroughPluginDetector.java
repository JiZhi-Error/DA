package com.tencent.thumbplayer.core.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class TPAudioPassThroughPluginDetector {
    private static final int DEFAULT_MAX_CHANNEL_COUNT = 8;
    private static final String TAG = "TPAudioPassThroughPluginDetector";
    private static boolean hasRegisterReceiver = false;
    private static boolean isInitted = false;
    private static List<AudioPassThroughPluginListener> listeners = new LinkedList();
    private static TPAudioPassThroughCapabilities mAudioPassThroughCapabilities = null;
    private static WeakReference<Context> mContextRef = null;
    private static Handler mHandler;
    private static boolean mIsAudioPassThroughPlugin = false;
    private static BroadcastReceiver mReceiver = null;

    /* access modifiers changed from: package-private */
    public interface AudioPassThroughPluginListener {
        void onAudioPassThroughPlugin(boolean z);
    }

    static /* synthetic */ void access$100(TPAudioPassThroughCapabilities tPAudioPassThroughCapabilities) {
        AppMethodBeat.i(189691);
        onUpdateAudioCapabilities(tPAudioPassThroughCapabilities);
        AppMethodBeat.o(189691);
    }

    static /* synthetic */ void access$200(boolean z) {
        AppMethodBeat.i(189692);
        notifyAudioPassThroughStateChange(z);
        AppMethodBeat.o(189692);
    }

    static {
        AppMethodBeat.i(189693);
        AppMethodBeat.o(189693);
    }

    private static Looper getLooper() {
        AppMethodBeat.i(189681);
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            AppMethodBeat.o(189681);
            return myLooper;
        }
        Looper mainLooper = Looper.getMainLooper();
        AppMethodBeat.o(189681);
        return mainLooper;
    }

    public static void init(Context context) {
        AppMethodBeat.i(189682);
        synchronized (TPAudioPassThroughPluginDetector.class) {
            try {
                TPNativeLog.printLog(2, TAG, "TPAudioPassThroughPluginDetector init enter!");
                if (!isInitted) {
                    mContextRef = new WeakReference<>(context.getApplicationContext());
                    isInitted = true;
                    mHandler = new Handler(getLooper());
                    registerReceiver();
                    hasRegisterReceiver = true;
                    TPNativeLog.printLog(2, TAG, "TPAudioPassThroughPluginDetector init succeed!");
                    AppMethodBeat.o(189682);
                }
            } finally {
                AppMethodBeat.o(189682);
            }
        }
    }

    public static void deinit() {
        AppMethodBeat.i(189683);
        synchronized (TPAudioPassThroughPluginDetector.class) {
            try {
                if (isInitted && mContextRef != null) {
                    mContextRef.clear();
                    isInitted = false;
                    TPNativeLog.printLog(2, TAG, "TPAudioPassThroughPluginDetector deinit succeed!");
                    AppMethodBeat.o(189683);
                }
            } finally {
                AppMethodBeat.o(189683);
            }
        }
    }

    public static boolean isAudioPassThroughPlugin() {
        boolean z;
        synchronized (TPAudioPassThroughPluginDetector.class) {
            z = mIsAudioPassThroughPlugin;
        }
        return z;
    }

    public static void addListener(AudioPassThroughPluginListener audioPassThroughPluginListener) {
        AppMethodBeat.i(189684);
        synchronized (TPAudioPassThroughPluginDetector.class) {
            try {
                if (listeners.add(audioPassThroughPluginListener) && !hasRegisterReceiver) {
                    registerReceiver();
                    hasRegisterReceiver = true;
                }
            } finally {
                AppMethodBeat.o(189684);
            }
        }
    }

    public static void removeListener(AudioPassThroughPluginListener audioPassThroughPluginListener) {
        AppMethodBeat.i(189685);
        synchronized (TPAudioPassThroughPluginDetector.class) {
            try {
                listeners.remove(audioPassThroughPluginListener);
                if (listeners.isEmpty() && hasRegisterReceiver) {
                    unregisterReceiver();
                    hasRegisterReceiver = false;
                }
            } finally {
                AppMethodBeat.o(189685);
            }
        }
    }

    public static boolean isAudioPassThroughSupport(int i2, int i3) {
        AppMethodBeat.i(189686);
        if (mAudioPassThroughCapabilities == null) {
            TPNativeLog.printLog(4, TAG, "isAudioPassThroughSupport failed, mAudioPassThroughCapabilities is not init yet!");
            AppMethodBeat.o(189686);
            return false;
        } else if (!mAudioPassThroughCapabilities.supportsEncoding(i2) || i3 > mAudioPassThroughCapabilities.getMaxChannelCount()) {
            AppMethodBeat.o(189686);
            return false;
        } else {
            AppMethodBeat.o(189686);
            return true;
        }
    }

    private static void registerReceiver() {
        Intent intent = null;
        AppMethodBeat.i(189687);
        TPNativeLog.printLog(2, TAG, "registerReceiver enter");
        if (Build.VERSION.SDK_INT < 24) {
            AppMethodBeat.o(189687);
        } else if (!isInitted || mContextRef == null) {
            TPNativeLog.printLog(4, TAG, "registerReceiver failed, TPAudioPassThroughPluginDetector is not init yet!");
            AppMethodBeat.o(189687);
        } else {
            if (mReceiver == null) {
                mReceiver = new HdmiAudioPlugBroadcastReceiver();
            }
            Context context = mContextRef.get();
            if (context == null) {
                TPNativeLog.printLog(4, TAG, "registerReceiver failed, context is null, maybe is invalid!");
                AppMethodBeat.o(189687);
                return;
            }
            if (mReceiver != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.media.action.HDMI_AUDIO_PLUG");
                intent = context.registerReceiver(mReceiver, intentFilter, null, mHandler);
            }
            mAudioPassThroughCapabilities = TPAudioPassThroughCapabilities.getCapabilities(context, intent);
            TPNativeLog.printLog(2, TAG, "registerReceiver leave");
            AppMethodBeat.o(189687);
        }
    }

    private static void unregisterReceiver() {
        AppMethodBeat.i(189688);
        if (!isInitted || mContextRef == null) {
            TPNativeLog.printLog(4, TAG, "registerReceiver failed, TPAudioPassThroughPluginDetector is not init yet!");
            AppMethodBeat.o(189688);
            return;
        }
        Context context = mContextRef.get();
        if (context == null) {
            TPNativeLog.printLog(4, TAG, "registerReceiver failed, context is null, maybe is invalid!");
            AppMethodBeat.o(189688);
            return;
        }
        context.unregisterReceiver(mReceiver);
        AppMethodBeat.o(189688);
    }

    private static void onUpdateAudioCapabilities(TPAudioPassThroughCapabilities tPAudioPassThroughCapabilities) {
        AppMethodBeat.i(189689);
        if (!tPAudioPassThroughCapabilities.equals(mAudioPassThroughCapabilities)) {
            mAudioPassThroughCapabilities = tPAudioPassThroughCapabilities;
            TPNativeLog.printLog(2, TAG, "onUpdateAudioCapabilities AudioCapabilities:" + mAudioPassThroughCapabilities.toString());
        }
        AppMethodBeat.o(189689);
    }

    private static void notifyAudioPassThroughStateChange(boolean z) {
        AppMethodBeat.i(189690);
        boolean z2 = true;
        if (mIsAudioPassThroughPlugin == z) {
            z2 = false;
        }
        if (!z2) {
            AppMethodBeat.o(189690);
            return;
        }
        mIsAudioPassThroughPlugin = z;
        synchronized (TPAudioPassThroughPluginDetector.class) {
            try {
                for (AudioPassThroughPluginListener audioPassThroughPluginListener : listeners) {
                    audioPassThroughPluginListener.onAudioPassThroughPlugin(z);
                }
            } finally {
                AppMethodBeat.o(189690);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class HdmiAudioPlugBroadcastReceiver extends BroadcastReceiver {
        private HdmiAudioPlugBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            AppMethodBeat.i(189680);
            TPNativeLog.printLog(2, TPAudioPassThroughPluginDetector.TAG, "HdmiAudioPlugBroadcastReceiver onReceive: " + intent.getAction());
            if (intent != null) {
                int intExtra = intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0);
                if (intExtra != 0 && intExtra == 1) {
                    z = true;
                }
                TPNativeLog.printLog(2, TPAudioPassThroughPluginDetector.TAG, "HdmiAudioPlugBroadcastReceiver audioPassThroughState:" + intExtra + " bPlugin:" + z);
                TPAudioPassThroughPluginDetector.access$100(new TPAudioPassThroughCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8)));
                TPAudioPassThroughPluginDetector.access$200(z);
            }
            AppMethodBeat.o(189680);
        }
    }
}
