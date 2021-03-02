package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.TraeAudioSession;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AudioSessionDuplicate {
    private static final String TAG = "AudioSessionDuplicate";
    private static TraeAudioSession _as = null;
    private static boolean _preDone = false;
    private static Condition _precon;
    private static ReentrantLock _prelock;
    private static String[] mDeviceList = null;
    private static int playoutDeviceType = 0;
    private static boolean usingJava = true;

    static /* synthetic */ void access$500(String str) {
        AppMethodBeat.i(13660);
        onOutputChanage(str);
        AppMethodBeat.o(13660);
    }

    static {
        AppMethodBeat.i(13661);
        ReentrantLock reentrantLock = new ReentrantLock();
        _prelock = reentrantLock;
        _precon = reentrantLock.newCondition();
        AppMethodBeat.o(13661);
    }

    public static void DeleteAudioSessionDuplicate() {
        AppMethodBeat.i(13657);
        TXCLog.i(TAG, " DeleteAudioSessionDuplicate...");
        if (_as != null) {
            _as.voiceCallPostprocess();
            _as.release();
            _as = null;
        }
        AppMethodBeat.o(13657);
    }

    private static void onOutputChanage(String str) {
        AppMethodBeat.i(13658);
        TXCLog.i(TAG, "device: ".concat(String.valueOf(str)));
        if (str.equals(TraeAudioManager.DEVICE_EARPHONE)) {
            playoutDeviceType = 1;
        } else if (str.equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
            playoutDeviceType = 2;
        } else if (str.equals(TraeAudioManager.DEVICE_WIREDHEADSET)) {
            playoutDeviceType = 3;
        } else if (str.equals(TraeAudioManager.DEVICE_BLUETOOTHHEADSET)) {
            playoutDeviceType = 4;
        } else {
            playoutDeviceType = 0;
        }
        TXCAudioEngineJNI.nativeSetPlayoutDevice(playoutDeviceType);
        AppMethodBeat.o(13658);
    }

    public static void NewAudioSessionDuplicate(Context context) {
        AppMethodBeat.i(13659);
        TXCLog.i(TAG, " NewAudioSessionDuplicate...");
        if (_as == null) {
            _as = new TraeAudioSession(context, new TraeAudioSession.ITraeAudioCallback() {
                /* class com.tencent.rtmp.sharp.jni.AudioSessionDuplicate.AnonymousClass1 */

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public final void onServiceStateUpdate(boolean z) {
                    AppMethodBeat.i(13796);
                    if (!z) {
                        try {
                            AudioSessionDuplicate._prelock.lock();
                            boolean unused = AudioSessionDuplicate._preDone = true;
                            if (QLog.isColorLevel()) {
                                QLog.e("TRAE", 2, "onServiceStateUpdate signalAll");
                            }
                            AudioSessionDuplicate._precon.signalAll();
                            AudioSessionDuplicate._prelock.unlock();
                            AppMethodBeat.o(13796);
                            return;
                        } catch (Exception e2) {
                        }
                    }
                    AppMethodBeat.o(13796);
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public final void onDeviceListUpdate(String[] strArr, String str, String str2, String str3) {
                    AppMethodBeat.i(13797);
                    String[] unused = AudioSessionDuplicate.mDeviceList = strArr;
                    if (AudioSessionDuplicate.usingJava) {
                        AudioSessionDuplicate.access$500(str);
                    }
                    AppMethodBeat.o(13797);
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public final void onDeviceChangabledUpdate(boolean z) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public final void onGetDeviceListRes(int i2, String[] strArr, String str, String str2, String str3) {
                    AppMethodBeat.i(13798);
                    String[] unused = AudioSessionDuplicate.mDeviceList = strArr;
                    AppMethodBeat.o(13798);
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public final void onConnectDeviceRes(int i2, String str, boolean z) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public final void onIsDeviceChangabledRes(int i2, boolean z) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public final void onGetConnectedDeviceRes(int i2, String str) {
                    AppMethodBeat.i(13799);
                    if (i2 == 0) {
                        AudioSessionDuplicate.access$500(str);
                    }
                    AppMethodBeat.o(13799);
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public final void onGetConnectingDeviceRes(int i2, String str) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public final void onRingCompletion(int i2, String str) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public final void onStreamTypeUpdate(int i2) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public final void onGetStreamTypeRes(int i2, int i3) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public final void onVoicecallPreprocessRes(int i2) {
                    AppMethodBeat.i(13800);
                    try {
                        AudioSessionDuplicate._prelock.lock();
                        boolean unused = AudioSessionDuplicate._preDone = true;
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "onVoicecallPreprocessRes signalAll");
                        }
                        AudioSessionDuplicate._precon.signalAll();
                        AudioSessionDuplicate._prelock.unlock();
                        AppMethodBeat.o(13800);
                    } catch (Exception e2) {
                        AppMethodBeat.o(13800);
                    }
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public final void onAudioRouteSwitchStart(String str, String str2) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public final void onAudioRouteSwitchEnd(String str, long j2) {
                }
            });
        }
        AppMethodBeat.o(13659);
    }
}
