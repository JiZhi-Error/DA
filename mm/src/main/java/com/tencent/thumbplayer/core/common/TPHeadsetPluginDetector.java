package com.tencent.thumbplayer.core.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TPHeadsetPluginDetector {
    private static final int AUDIO_TYPE_BLUETOOTH_A2DP = 2;
    private static final int AUDIO_TYPE_BUILTIN_OTHERS = 99;
    private static final int AUDIO_TYPE_BUILTIN_SPEAKER = 0;
    private static final int AUDIO_TYPE_HEADPHONES = 1;
    private static final String TAG = "TPHeadsetPluginDetector";
    private static boolean hasRegisterReceiver = false;
    private static boolean isInitted = false;
    private static List<HeadsetPluginListener> listeners = new LinkedList();
    private static WeakReference<Context> mContextRef = null;
    private static Set<Integer> mCurOutputs = null;
    private static BroadcastReceiver mReceiver = null;

    /* access modifiers changed from: package-private */
    public interface HeadsetPluginListener {
        void onHeadsetPlugin(Set<Integer> set, Set<Integer> set2);
    }

    static /* synthetic */ Set access$100() {
        AppMethodBeat.i(189753);
        Set<Integer> audioOutputs = getAudioOutputs();
        AppMethodBeat.o(189753);
        return audioOutputs;
    }

    static /* synthetic */ void access$200(Set set, Set set2) {
        AppMethodBeat.i(189754);
        notifyAudioOutputStateChange(set, set2);
        AppMethodBeat.o(189754);
    }

    static {
        AppMethodBeat.i(189755);
        AppMethodBeat.o(189755);
    }

    public static void init(Context context) {
        AppMethodBeat.i(189739);
        synchronized (TPHeadsetPluginDetector.class) {
            try {
                if (!isInitted) {
                    mContextRef = new WeakReference<>(context.getApplicationContext());
                    isInitted = true;
                    initCurrentOutputs();
                    TPNativeLog.printLog(2, TAG, "HeadsetPluginDetector init succeed!");
                    AppMethodBeat.o(189739);
                }
            } finally {
                AppMethodBeat.o(189739);
            }
        }
    }

    public static void deinit() {
        AppMethodBeat.i(189740);
        synchronized (TPHeadsetPluginDetector.class) {
            try {
                if (isInitted && mContextRef != null) {
                    mContextRef.clear();
                    isInitted = false;
                    TPNativeLog.printLog(2, TAG, "HeadsetPluginDetector deinit succeed!");
                    AppMethodBeat.o(189740);
                }
            } finally {
                AppMethodBeat.o(189740);
            }
        }
    }

    @TPMethodCalledByNative
    public static boolean isHeadsetPlugin() {
        AppMethodBeat.i(189741);
        AudioManager audioManager = getAudioManager();
        if (audioManager == null) {
            AppMethodBeat.o(189741);
            return false;
        }
        boolean isWiredHeadsetOn = audioManager.isWiredHeadsetOn();
        AppMethodBeat.o(189741);
        return isWiredHeadsetOn;
    }

    @TPMethodCalledByNative
    public static boolean isBluetoothPlugin() {
        AppMethodBeat.i(189742);
        AudioManager audioManager = getAudioManager();
        if (audioManager == null) {
            AppMethodBeat.o(189742);
            return false;
        }
        boolean isBluetoothA2dpOn = audioManager.isBluetoothA2dpOn();
        AppMethodBeat.o(189742);
        return isBluetoothA2dpOn;
    }

    @TPMethodCalledByNative
    public static boolean isAudioRouteTypeOn(int i2) {
        AppMethodBeat.i(189743);
        if (mCurOutputs == null) {
            AppMethodBeat.o(189743);
            return false;
        }
        boolean contains = mCurOutputs.contains(Integer.valueOf(i2));
        AppMethodBeat.o(189743);
        return contains;
    }

    @TPMethodCalledByNative
    public static Set<Integer> getCurrentRoutes() {
        return mCurOutputs;
    }

    public static void addHeadsetPluginListener(HeadsetPluginListener headsetPluginListener) {
        AppMethodBeat.i(189744);
        synchronized (TPHeadsetPluginDetector.class) {
            try {
                if (listeners.add(headsetPluginListener) && !hasRegisterReceiver) {
                    registerReceiver();
                    hasRegisterReceiver = true;
                }
            } finally {
                AppMethodBeat.o(189744);
            }
        }
    }

    public static void removeHeadsetPluginListener(HeadsetPluginListener headsetPluginListener) {
        AppMethodBeat.i(189745);
        synchronized (TPHeadsetPluginDetector.class) {
            try {
                listeners.remove(headsetPluginListener);
                if (listeners.isEmpty() && hasRegisterReceiver) {
                    unregisterReceiver();
                    hasRegisterReceiver = false;
                }
            } finally {
                AppMethodBeat.o(189745);
            }
        }
    }

    private static void initCurrentOutputs() {
        AppMethodBeat.i(189746);
        mCurOutputs = getAudioOutputs();
        AppMethodBeat.o(189746);
    }

    private static Set<Integer> getAudioOutputs() {
        AppMethodBeat.i(189747);
        HashSet hashSet = new HashSet();
        AudioManager audioManager = getAudioManager();
        if (audioManager == null) {
            AppMethodBeat.o(189747);
        } else {
            if (Build.VERSION.SDK_INT >= 23) {
                AudioDeviceInfo[] devices = audioManager.getDevices(2);
                if (devices != null) {
                    for (AudioDeviceInfo audioDeviceInfo : devices) {
                        if (audioDeviceInfo.getType() == 2) {
                            hashSet.add(0);
                        } else if (audioDeviceInfo.getType() == 8) {
                            hashSet.add(2);
                        } else if (audioDeviceInfo.getType() == 3) {
                            hashSet.add(1);
                        }
                    }
                }
            } else {
                hashSet.add(0);
                if (isHeadsetPlugin()) {
                    hashSet.add(1);
                }
                if (isBluetoothPlugin()) {
                    hashSet.add(2);
                }
            }
            AppMethodBeat.o(189747);
        }
        return hashSet;
    }

    private static boolean registerDeviceCallback() {
        AppMethodBeat.i(189748);
        AudioManager audioManager = getAudioManager();
        if (audioManager == null) {
            AppMethodBeat.o(189748);
            return false;
        }
        audioManager.registerAudioDeviceCallback(new AudioDeviceCallback() {
            /* class com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector.AnonymousClass1 */

            public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
                AppMethodBeat.i(189736);
                TPNativeLog.printLog(2, TPHeadsetPluginDetector.TAG, "onAudioDevicesAdded!");
                TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.mCurOutputs, TPHeadsetPluginDetector.access$100());
                AppMethodBeat.o(189736);
            }

            public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
                AppMethodBeat.i(189737);
                TPNativeLog.printLog(2, TPHeadsetPluginDetector.TAG, "onAudioDevicesRemoved!");
                TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.mCurOutputs, TPHeadsetPluginDetector.access$100());
                AppMethodBeat.o(189737);
            }
        }, null);
        AppMethodBeat.o(189748);
        return true;
    }

    private static void registerReceiver() {
        AppMethodBeat.i(189749);
        if (Build.VERSION.SDK_INT < 23 || !registerDeviceCallback()) {
            if (mReceiver == null) {
                mReceiver = new HeadsetPluginReceiver();
            }
            if (!isInitted || mContextRef == null) {
                TPNativeLog.printLog(4, TAG, "registerReceiver failed, TPHeadsetPluginDetector is not init yet!");
                AppMethodBeat.o(189749);
                return;
            }
            Context context = mContextRef.get();
            if (context == null) {
                TPNativeLog.printLog(4, TAG, "registerReceiver failed, context is null, maybe is invalid!");
                AppMethodBeat.o(189749);
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
            intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
            context.registerReceiver(mReceiver, intentFilter);
            AppMethodBeat.o(189749);
            return;
        }
        AppMethodBeat.o(189749);
    }

    private static void unregisterReceiver() {
        AppMethodBeat.i(189750);
        if (!isInitted || mContextRef == null) {
            TPNativeLog.printLog(4, TAG, "registerReceiver failed, HeadsetPluginDetector is not init yet!");
            AppMethodBeat.o(189750);
            return;
        }
        Context context = mContextRef.get();
        if (context == null) {
            TPNativeLog.printLog(4, TAG, "registerReceiver failed, context is null, maybe is invalid!");
            AppMethodBeat.o(189750);
            return;
        }
        context.unregisterReceiver(mReceiver);
        AppMethodBeat.o(189750);
    }

    private static void notifyAudioOutputStateChange(Set<Integer> set, Set<Integer> set2) {
        AppMethodBeat.i(189751);
        boolean z = true;
        if (set != null && set2 != null && set.size() == set2.size() && set2.containsAll(set)) {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(189751);
            return;
        }
        mCurOutputs = set2;
        synchronized (TPHeadsetPluginDetector.class) {
            try {
                for (HeadsetPluginListener headsetPluginListener : listeners) {
                    headsetPluginListener.onHeadsetPlugin(set, set2);
                }
            } finally {
                AppMethodBeat.o(189751);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class HeadsetPluginReceiver extends BroadcastReceiver {
        private HeadsetPluginReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            int i2 = 0;
            AppMethodBeat.i(189738);
            TPNativeLog.printLog(2, TPHeadsetPluginDetector.TAG, "onReceive: " + intent.getAction());
            Set access$100 = TPHeadsetPluginDetector.access$100();
            if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                if (intent.hasExtra("state")) {
                    i2 = intent.getIntExtra("state", 0);
                }
                if (access$100 != null) {
                    if (i2 == 0) {
                        access$100.remove(1);
                    } else if (i2 == 1) {
                        access$100.add(1);
                    }
                }
                TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.mCurOutputs, access$100);
                AppMethodBeat.o(189738);
            } else if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                if (access$100 != null) {
                    access$100.remove(1);
                }
                TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.mCurOutputs, access$100);
                AppMethodBeat.o(189738);
            } else {
                if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                    if (access$100 != null) {
                        if (intExtra == 2) {
                            access$100.add(2);
                        } else if (intExtra == 0) {
                            access$100.remove(2);
                        }
                    }
                    TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.mCurOutputs, access$100);
                }
                AppMethodBeat.o(189738);
            }
        }
    }

    private static AudioManager getAudioManager() {
        AppMethodBeat.i(189752);
        if (!isInitted || mContextRef == null) {
            TPNativeLog.printLog(4, TAG, "getAudioManager failed, HeadsetPluginDetector is not init yet!");
            AppMethodBeat.o(189752);
            return null;
        }
        Context context = mContextRef.get();
        if (context == null) {
            TPNativeLog.printLog(4, TAG, "getAudioManager failed, context is null, maybe is invalid!");
            AppMethodBeat.o(189752);
            return null;
        }
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (audioManager == null) {
            TPNativeLog.printLog(4, TAG, "getAudioManager failed, audioMgr is null!");
            AppMethodBeat.o(189752);
            return null;
        }
        AppMethodBeat.o(189752);
        return audioManager;
    }
}
