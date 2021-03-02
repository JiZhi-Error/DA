package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.TraeAudioCodecList;
import com.tencent.rtmp.sharp.jni.TraeAudioSession;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(16)
public class AudioDeviceInterface {
    private static final FileFilter CPU_FILTER = new FileFilter() {
        /* class com.tencent.rtmp.sharp.jni.AudioDeviceInterface.AnonymousClass4 */

        public final boolean accept(File file) {
            AppMethodBeat.i(13910);
            String name = file.getName();
            if (name.startsWith("cpu")) {
                for (int i2 = 3; i2 < name.length(); i2++) {
                    if (name.charAt(i2) < '0' || name.charAt(i2) > '9') {
                        AppMethodBeat.o(13910);
                        return false;
                    }
                }
                AppMethodBeat.o(13910);
                return true;
            }
            AppMethodBeat.o(13910);
            return false;
        }
    };
    public static final int OUTPUT_MODE_HEADSET = 0;
    public static final int OUTPUT_MODE_SPEAKER = 1;
    private static boolean _dumpEnable = false;
    private static boolean _logEnable = true;
    private static boolean isSupportVivoKTVHelper = false;
    private static String[] mDeviceList = null;
    private static VivoKTVHelper mVivoKTVHelper = null;
    private TraeAudioSession _as = null;
    private TraeAudioSession _asAudioManager = null;
    private AudioManager _audioManager = null;
    private AudioRecord _audioRecord = null;
    private boolean _audioRouteChanged = false;
    private int _audioSource = 0;
    private int _audioSourcePolicy = -1;
    private int _audioStreamTypePolicy = -1;
    private AudioTrack _audioTrack = null;
    private int _bufferedPlaySamples = 0;
    private int _bufferedRecSamples = 0;
    private int _channelOutType = 4;
    private String _connectedDev = TraeAudioManager.DEVICE_NONE;
    private Context _context = null;
    private ByteBuffer _decBuffer0;
    private ByteBuffer _decBuffer1;
    private ByteBuffer _decBuffer10;
    private ByteBuffer _decBuffer2;
    private ByteBuffer _decBuffer3;
    private ByteBuffer _decBuffer4;
    private ByteBuffer _decBuffer5;
    private ByteBuffer _decBuffer6;
    private ByteBuffer _decBuffer7;
    private ByteBuffer _decBuffer8;
    private ByteBuffer _decBuffer9;
    private int _deviceStat = 0;
    private boolean _doPlayInit = true;
    private boolean _doRecInit = true;
    private boolean _isPlaying = false;
    private boolean _isRecording = false;
    private int _modePolicy = -1;
    private ByteBuffer _playBuffer;
    private int _playPosition = 0;
    private int _playSamplerate = TXRecordCommon.AUDIO_SAMPLERATE_8000;
    private File _play_dump = null;
    private FileOutputStream _play_out = null;
    private boolean _preDone = false;
    private Condition _precon = this._prelock.newCondition();
    private ReentrantLock _prelock = new ReentrantLock();
    private ByteBuffer _recBuffer;
    private File _rec_dump = null;
    private FileOutputStream _rec_out = null;
    private int _sceneMode = 0;
    private int _sessionId = 0;
    private int _streamType = 0;
    private byte[] _tempBufPlay;
    private byte[] _tempBufRec;
    private TraeAudioCodecList _traeAudioCodecList = null;
    private int nPlayLengthMs = 0;
    private int nRecordLengthMs = 0;
    private int switchState = 0;
    private boolean usingJava = true;

    static /* synthetic */ void access$500(AudioDeviceInterface audioDeviceInterface, String str) {
        AppMethodBeat.i(13862);
        audioDeviceInterface.onOutputChanage(str);
        AppMethodBeat.o(13862);
    }

    static {
        AppMethodBeat.i(13863);
        AppMethodBeat.o(13863);
    }

    public AudioDeviceInterface() {
        AppMethodBeat.i(13814);
        try {
            this._playBuffer = ByteBuffer.allocateDirect(1920);
            this._recBuffer = ByteBuffer.allocateDirect(1920);
            this._decBuffer0 = ByteBuffer.allocateDirect(3840);
            this._decBuffer1 = ByteBuffer.allocateDirect(3840);
            this._decBuffer2 = ByteBuffer.allocateDirect(3840);
            this._decBuffer3 = ByteBuffer.allocateDirect(3840);
            this._decBuffer4 = ByteBuffer.allocateDirect(3840);
            this._decBuffer5 = ByteBuffer.allocateDirect(3840);
            this._decBuffer6 = ByteBuffer.allocateDirect(3840);
            this._decBuffer7 = ByteBuffer.allocateDirect(3840);
            this._decBuffer8 = ByteBuffer.allocateDirect(3840);
            this._decBuffer9 = ByteBuffer.allocateDirect(3840);
            this._decBuffer10 = ByteBuffer.allocateDirect(3840);
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, e2.getMessage());
            }
        }
        this._tempBufPlay = new byte[1920];
        this._tempBufRec = new byte[1920];
        this._traeAudioCodecList = new TraeAudioCodecList();
        int i2 = Build.VERSION.SDK_INT;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "AudioDeviceInterface apiLevel:".concat(String.valueOf(i2)));
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " SDK_INT:" + Build.VERSION.SDK_INT);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
        }
        AppMethodBeat.o(13814);
    }

    public void setContext(Context context) {
        this._context = context;
    }

    private int getLowlatencySamplerate() {
        AppMethodBeat.i(13815);
        if (this._context == null || Build.VERSION.SDK_INT < 9) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
            }
            AppMethodBeat.o(13815);
        } else {
            boolean hasSystemFeature = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "LOW_LATENCY:" + (hasSystemFeature ? "Y" : "N"));
            }
            if (Build.VERSION.SDK_INT < 17) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
                }
                AppMethodBeat.o(13815);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "getLowlatencySamplerate not support right now!");
                }
                AppMethodBeat.o(13815);
            }
        }
        return 0;
    }

    private int getLowlatencyFramesPerBuffer() {
        AppMethodBeat.i(13816);
        if (this._context == null || Build.VERSION.SDK_INT < 9) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
            }
            AppMethodBeat.o(13816);
        } else {
            boolean hasSystemFeature = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "LOW_LATENCY:" + (hasSystemFeature ? "Y" : "N"));
            }
            if (Build.VERSION.SDK_INT < 17) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
                }
                AppMethodBeat.o(13816);
            } else {
                AppMethodBeat.o(13816);
            }
        }
        return 0;
    }

    @TargetApi(16)
    private int getAudioSessionId(AudioRecord audioRecord) {
        return 0;
    }

    private int InitSetting(int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(13817);
        this._audioSourcePolicy = i2;
        this._audioStreamTypePolicy = i3;
        this._modePolicy = i4;
        this._deviceStat = i5;
        this._sceneMode = i6;
        if (this._deviceStat == 1 || this._deviceStat == 5 || this._deviceStat == 2 || this._deviceStat == 3) {
            TraeAudioManager.IsMusicScene = true;
        } else {
            TraeAudioManager.IsMusicScene = false;
        }
        if (this._sceneMode == 0 || this._sceneMode == 4) {
            TraeAudioManager.IsEarPhoneSupported = true;
        } else {
            TraeAudioManager.IsEarPhoneSupported = false;
        }
        TraeAudioManager.IsUpdateSceneFlag = true;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitSetting: _audioSourcePolicy:" + this._audioSourcePolicy + " _audioStreamTypePolicy:" + this._audioStreamTypePolicy + " _modePolicy:" + this._modePolicy + " DeviceStat:" + i5 + " isSupportVivoKTVHelper:" + isSupportVivoKTVHelper);
        }
        AppMethodBeat.o(13817);
        return 0;
    }

    private int InitRecording(int i2, int i3) {
        AppMethodBeat.i(13818);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitRecording entry:".concat(String.valueOf(i2)));
        }
        if (this._isRecording || this._audioRecord != null || i3 > 2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "InitRecording _isRecording:" + this._isRecording);
            }
            AppMethodBeat.o(13818);
            return -1;
        }
        int i4 = 16;
        if (i3 == 2) {
            i4 = 12;
        }
        int minBufferSize = AudioRecord.getMinBufferSize(i2, i4, 2);
        int i5 = (((i2 * 20) * i3) * 2) / 1000;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitRecording: min rec buf size is " + minBufferSize + " sr:" + getLowlatencySamplerate() + " fp" + getLowlatencyFramesPerBuffer() + " 20msFZ:" + i5);
        }
        this._bufferedRecSamples = (i2 * 5) / 200;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "  rough rec delay set to " + this._bufferedRecSamples);
        }
        if (this._audioRecord != null) {
            this._audioRecord.release();
            this._audioRecord = null;
        }
        int[] iArr = {0, 1, 5, 0};
        iArr[0] = TraeAudioManager.getAudioSource(this._audioSourcePolicy);
        int i6 = minBufferSize;
        for (int i7 = 0; i7 < 4 && this._audioRecord == null; i7++) {
            this._audioSource = iArr[i7];
            for (int i8 = 1; i8 <= 2; i8++) {
                i6 = minBufferSize * i8;
                if (i6 >= i5 * 4 || i8 >= 2) {
                    try {
                        this.nRecordLengthMs = (i6 * 500) / (i2 * i3);
                        this._audioRecord = new AudioRecord(this._audioSource, i2, i4, 2, i6);
                        if (this._audioRecord.getState() == 1) {
                            break;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "InitRecording:  rec not initialized,try agine,  minbufsize:" + i6 + " sr:" + i2 + " as:" + this._audioSource);
                        }
                        this._audioRecord.release();
                        this._audioRecord = null;
                    } catch (Exception e2) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, e2.getMessage() + " _audioRecord:" + this._audioRecord);
                        }
                        if (this._audioRecord != null) {
                            this._audioRecord.release();
                        }
                        this._audioRecord = null;
                    }
                }
            }
        }
        if (this._audioRecord == null) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "InitRecording fail!!!");
            }
            AppMethodBeat.o(13818);
            return -1;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " [Config] InitRecording: audioSession:" + this._sessionId + " audioSource:" + this._audioSource + " rec sample rate set to " + i2 + " recBufSize:" + i6 + " nRecordLengthMs:" + this.nRecordLengthMs);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitRecording exit");
        }
        int i9 = this._bufferedRecSamples;
        AppMethodBeat.o(13818);
        return i9;
    }

    private int InitPlayback(int i2, int i3) {
        int i4;
        int streamType;
        AppMethodBeat.i(13819);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback entry: sampleRate ".concat(String.valueOf(i2)));
        }
        if (this._isPlaying || this._audioTrack != null || i3 > 2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "InitPlayback _isPlaying:" + this._isPlaying);
            }
            AppMethodBeat.o(13819);
            return -1;
        }
        if (this._audioManager == null) {
            try {
                this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, e2.getMessage());
                }
                AppMethodBeat.o(13819);
                return -1;
            }
        }
        if (i3 == 2) {
            this._channelOutType = 12;
        } else {
            this._channelOutType = 4;
        }
        this._playSamplerate = i2;
        int minBufferSize = AudioTrack.getMinBufferSize(i2, this._channelOutType, 2);
        if (this._channelOutType == 12) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "InitPlayback, _channelOutType stero");
            } else if (this._channelOutType == 4 && QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "InitPlayback, _channelOutType Mono");
            }
        }
        int i5 = (((i2 * 20) * 1) * 2) / 1000;
        if (this._channelOutType == 12) {
            i4 = i5 * 2;
        } else {
            i4 = i5;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback: minPlayBufSize:" + minBufferSize + " 20msFz:" + i4);
        }
        this._bufferedPlaySamples = 0;
        if (this._audioTrack != null) {
            this._audioTrack.release();
            this._audioTrack = null;
        }
        int[] iArr = {0, 0, 3, 1};
        this._streamType = TraeAudioManager.getAudioStreamType(this._audioStreamTypePolicy);
        if (this._audioRouteChanged) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "_audioRouteChanged:" + this._audioRouteChanged + " _streamType:" + this._streamType);
            }
            if (this._audioManager.getMode() != 0 || !this._connectedDev.equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
                this._streamType = 0;
            } else {
                this._streamType = 3;
            }
            this._audioRouteChanged = false;
        }
        iArr[0] = this._streamType;
        int i6 = minBufferSize;
        for (int i7 = 0; i7 < 4 && this._audioTrack == null; i7++) {
            this._streamType = iArr[i7];
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "InitPlayback: min play buf size is " + minBufferSize + " hw_sr:" + AudioTrack.getNativeOutputSampleRate(this._streamType));
            }
            for (int i8 = 1; i8 <= 2; i8++) {
                i6 = minBufferSize * i8;
                if (i6 >= i4 * 4 || i8 >= 2) {
                    try {
                        this.nPlayLengthMs = (i6 * 500) / (i2 * i3);
                        this._audioTrack = new AudioTrack(this._streamType, this._playSamplerate, this._channelOutType, 2, i6, 1);
                        if (this._audioTrack.getState() == 1) {
                            break;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "InitPlayback: play not initialized playBufSize:" + i6 + " sr:" + this._playSamplerate);
                        }
                        this._audioTrack.release();
                        this._audioTrack = null;
                    } catch (Exception e3) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, e3.getMessage() + " _audioTrack:" + this._audioTrack);
                        }
                        if (this._audioTrack != null) {
                            this._audioTrack.release();
                        }
                        this._audioTrack = null;
                    }
                }
            }
        }
        if (this._audioTrack == null) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "InitPlayback fail!!!");
            }
            AppMethodBeat.o(13819);
            return -1;
        }
        if (!(this._as == null || this._audioManager == null)) {
            this._as.voiceCallAudioParamChanged(this._audioManager.getMode(), this._streamType);
        }
        this._playPosition = this._audioTrack.getPlaybackHeadPosition();
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback exit: streamType:" + this._streamType + " samplerate:" + this._playSamplerate + " _playPosition:" + this._playPosition + " playBufSize:" + i6 + " nPlayLengthMs:" + this.nPlayLengthMs);
        }
        AudioManager audioManager = this._audioManager;
        if (this._connectedDev.equals(TraeAudioManager.DEVICE_BLUETOOTHHEADSET)) {
            streamType = 6;
        } else {
            streamType = this._audioTrack.getStreamType();
        }
        TraeAudioManager.forceVolumeControlStream(audioManager, streamType);
        AppMethodBeat.o(13819);
        return 0;
    }

    private int getPlayRecordSysBufferMs() {
        return (this.nRecordLengthMs + this.nPlayLengthMs) * 2;
    }

    private String getDumpFilePath(String str, int i2) {
        AppMethodBeat.i(13820);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
        }
        if (this._context == null) {
            AppMethodBeat.o(13820);
            return null;
        }
        File externalFilesDir = this._context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            AppMethodBeat.o(13820);
            return null;
        }
        String str2 = externalFilesDir.getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + Build.MODEL + "-as-" + TraeAudioManager.getAudioSource(this._audioSourcePolicy) + "-st-" + this._streamType + "-m-" + i2 + "-" + str;
        File file = new File(str2);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "dump:".concat(String.valueOf(str2)));
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "dump replace:" + str2.replace(" ", "_"));
        }
        String replace = str2.replace(" ", "_");
        AppMethodBeat.o(13820);
        return replace;
    }

    private int StartRecording() {
        int i2 = -1;
        AppMethodBeat.i(13821);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StartRecording entry");
        }
        if (this._isRecording) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "StartRecording _isRecording:" + this._isRecording);
            }
            AppMethodBeat.o(13821);
            return -1;
        } else if (this._audioRecord == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "StartRecording _audioRecord:" + this._audioRecord);
            }
            AppMethodBeat.o(13821);
            return -1;
        } else {
            try {
                this._audioRecord.startRecording();
                if (_dumpEnable) {
                    if (this._audioManager != null) {
                        i2 = this._audioManager.getMode();
                    }
                    this._rec_dump = new File(getDumpFilePath("jnirecord.pcm", i2));
                    try {
                        this._rec_out = new FileOutputStream(this._rec_dump);
                    } catch (FileNotFoundException e2) {
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "open rec dump file failed.");
                        }
                    }
                }
                this._isRecording = true;
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "StartRecording ok");
                }
                AppMethodBeat.o(13821);
                return 0;
            } catch (IllegalStateException e3) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "StartRecording fail");
                }
                AppMethodBeat.o(13821);
                return -1;
            }
        }
    }

    private int StartPlayback() {
        int i2 = -1;
        AppMethodBeat.i(13822);
        if (this._isPlaying) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "StartPlayback _isPlaying");
            }
            AppMethodBeat.o(13822);
            return -1;
        } else if (this._audioTrack == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "StartPlayback _audioTrack:" + this._audioTrack);
            }
            AppMethodBeat.o(13822);
            return -1;
        } else {
            try {
                this._audioTrack.play();
                if (_dumpEnable) {
                    if (this._audioManager != null) {
                        i2 = this._audioManager.getMode();
                    }
                    this._play_dump = new File(getDumpFilePath("jniplay.pcm", i2));
                    try {
                        this._play_out = new FileOutputStream(this._play_dump);
                    } catch (FileNotFoundException e2) {
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "open play dump file failed.");
                        }
                    }
                }
                this._isPlaying = true;
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "StartPlayback ok");
                }
                AppMethodBeat.o(13822);
                return 0;
            } catch (IllegalStateException e3) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "StartPlayback fail");
                }
                AppMethodBeat.o(13822);
                return -1;
            }
        }
    }

    private int StopRecording() {
        AppMethodBeat.i(13823);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopRecording entry");
        }
        if (this._audioRecord == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "UnintRecord:" + this._audioRecord);
            }
            AppMethodBeat.o(13823);
            return -1;
        }
        if (this._audioRecord.getRecordingState() == 3) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "StopRecording stop... state:" + this._audioRecord.getRecordingState());
                }
                this._audioRecord.stop();
            } catch (IllegalStateException e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "StopRecording  err");
                }
                AppMethodBeat.o(13823);
                return -1;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopRecording releaseing... state:" + this._audioRecord.getRecordingState());
        }
        this._audioRecord.release();
        this._audioRecord = null;
        this._isRecording = false;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopRecording exit ok");
        }
        AppMethodBeat.o(13823);
        return 0;
    }

    private int StopPlayback() {
        AppMethodBeat.i(13824);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopPlayback entry _isPlaying:" + this._isPlaying);
        }
        if (this._audioTrack == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "StopPlayback _isPlaying:" + this._isPlaying + " " + this._audioTrack);
            }
            AppMethodBeat.o(13824);
            return -1;
        }
        if (this._audioTrack.getPlayState() == 3) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "StopPlayback stoping...");
                }
                this._audioTrack.stop();
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "StopPlayback flushing... state:" + this._audioTrack.getPlayState());
                }
                this._audioTrack.flush();
            } catch (IllegalStateException e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "StopPlayback err");
                }
                AppMethodBeat.o(13824);
                return -1;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopPlayback releaseing... state:" + this._audioTrack.getPlayState());
        }
        this._audioTrack.release();
        this._audioTrack = null;
        this._isPlaying = false;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopPlayback exit ok");
        }
        AppMethodBeat.o(13824);
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:92:0x023f A[Catch:{ all -> 0x0274 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int PlayAudio(int r15) {
        /*
        // Method dump skipped, instructions count: 1070
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.AudioDeviceInterface.PlayAudio(int):int");
    }

    private int OpenslesNeedResetAudioTrack(boolean z) {
        AppMethodBeat.i(13826);
        try {
            if (!TraeAudioManager.isCloseSystemAPM(this._modePolicy)) {
                AppMethodBeat.o(13826);
                return -1;
            }
            if (this._audioRouteChanged || z) {
                if (this._audioManager == null && this._context != null) {
                    this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                }
                if (this._audioManager == null) {
                    AppMethodBeat.o(13826);
                    return 0;
                }
                if (this._audioManager.getMode() != 0 || !this._connectedDev.equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
                    this._audioStreamTypePolicy = 0;
                } else {
                    this._audioStreamTypePolicy = 3;
                }
                this._audioRouteChanged = false;
            }
            int i2 = this._audioStreamTypePolicy;
            AppMethodBeat.o(13826);
            return i2;
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "PlayAudio Exception: " + e2.getMessage());
            }
        } catch (Throwable th) {
            AppMethodBeat.o(13826);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00be A[Catch:{ all -> 0x0142 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int RecordAudio(int r9) {
        /*
        // Method dump skipped, instructions count: 327
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.AudioDeviceInterface.RecordAudio(int):int");
    }

    private int SetPlayoutVolume(int i2) {
        AppMethodBeat.i(13828);
        if (this._audioManager == null && this._context != null) {
            this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        int i3 = -1;
        if (this._audioManager != null) {
            this._audioManager.setStreamVolume(0, i2, 0);
            i3 = 0;
        }
        AppMethodBeat.o(13828);
        return i3;
    }

    public int GetPlayoutVolume() {
        int i2;
        AppMethodBeat.i(13829);
        try {
            if (this._audioManager == null && this._context != null) {
                this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            }
            if (this._audioManager != null) {
                i2 = this._audioManager.getStreamVolume(this._streamType);
            } else {
                i2 = -1;
            }
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE GetPlayoutVolume", 2, e2.getMessage());
            }
            i2 = -1;
        }
        AppMethodBeat.o(13829);
        return i2;
    }

    public static String getTraceInfo() {
        AppMethodBeat.i(13830);
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        stringBuffer.append(stackTrace[2].getClassName()).append(".").append(stackTrace[2].getMethodName()).append(": ").append(stackTrace[2].getLineNumber());
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(13830);
        return stringBuffer2;
    }

    public static final void LogTraceEntry(String str) {
        AppMethodBeat.i(13831);
        if (!_logEnable) {
            AppMethodBeat.o(13831);
            return;
        }
        String str2 = getTraceInfo() + " entry:" + str;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, str2);
        }
        AppMethodBeat.o(13831);
    }

    public static final void LogTraceExit() {
        AppMethodBeat.i(13832);
        if (!_logEnable) {
            AppMethodBeat.o(13832);
            return;
        }
        String str = getTraceInfo() + " exit";
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, str);
        }
        AppMethodBeat.o(13832);
    }

    private void onOutputChanage(String str) {
        String str2;
        String str3;
        String str4;
        AppMethodBeat.i(13833);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " onOutputChanage:".concat(String.valueOf(str)));
        }
        setAudioRouteSwitchState(str);
        if (!TraeAudioManager.isCloseSystemAPM(this._modePolicy)) {
            AppMethodBeat.o(13833);
        } else if (this._deviceStat == 1 || this._deviceStat == 5 || this._deviceStat == 2 || this._deviceStat == 3) {
            AppMethodBeat.o(13833);
        } else {
            this._connectedDev = str;
            if (QLog.isColorLevel()) {
                StringBuilder append = new StringBuilder(" onOutputChanage:").append(str);
                if (this._audioManager == null) {
                    str3 = " am==null";
                } else {
                    str3 = " mode:" + this._audioManager.getMode();
                }
                StringBuilder append2 = append.append(str3).append(" st:").append(this._streamType);
                if (this._audioTrack == null) {
                    str4 = "_audioTrack==null";
                } else {
                    str4 = " at.st:" + this._audioTrack.getStreamType();
                }
                QLog.w("TRAE", 2, append2.append(str4).toString());
            }
            try {
                if (this._audioManager == null) {
                    this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                }
                if (QLog.isColorLevel()) {
                    StringBuilder append3 = new StringBuilder(" curr mode:").append(str);
                    if (this._audioManager == null) {
                        str2 = "am==null";
                    } else {
                        str2 = " mode:" + this._audioManager.getMode();
                    }
                    QLog.w("TRAE", 2, append3.append(str2).toString());
                }
                if (this._audioManager != null && this._connectedDev.equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
                    this._audioManager.setMode(0);
                }
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, e2.getMessage());
                }
            }
            this._audioRouteChanged = true;
            AppMethodBeat.o(13833);
        }
    }

    public int getMode() {
        int i2;
        AppMethodBeat.i(222660);
        int i3 = -1;
        try {
            if (this._audioManager == null && this._context != null) {
                this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            }
            if (this._audioManager != null) {
                i2 = this._audioManager.getMode();
            } else {
                i2 = -1;
            }
            i3 = i2;
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE getMode", 2, e2.getMessage());
            }
        }
        AppMethodBeat.o(222660);
        return i3;
    }

    public int isBackground() {
        boolean z;
        AppMethodBeat.i(222661);
        if (this._context == null) {
            AppMethodBeat.o(222661);
            return 0;
        }
        try {
            ActivityManager activityManager = (ActivityManager) this._context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            if (activityManager.getRunningTasks(1) == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "running task is null, ams is abnormal!!!");
                }
                AppMethodBeat.o(222661);
                return 0;
            }
            ActivityManager.RunningTaskInfo runningTaskInfo = activityManager.getRunningTasks(1).get(0);
            if (runningTaskInfo == null || runningTaskInfo.topActivity == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "failed to get RunningTaskInfo");
                }
                AppMethodBeat.o(222661);
                return 0;
            }
            if (!runningTaskInfo.topActivity.getPackageName().equals(this._context.getPackageName())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(222661);
                return 1;
            }
            AppMethodBeat.o(222661);
            return 0;
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE isBackground", 2, e2.getMessage());
            }
            AppMethodBeat.o(222661);
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0109, code lost:
        r8._prelock.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0110, code lost:
        r8._prelock.unlock();
        com.tencent.matrix.trace.core.AppMethodBeat.o(13834);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0118, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010f A[ExcHandler: all (r0v6 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:6:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int call_preprocess() {
        /*
        // Method dump skipped, instructions count: 285
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.AudioDeviceInterface.call_preprocess():int");
    }

    public int call_postprocess() {
        AppMethodBeat.i(13835);
        LogTraceEntry("");
        this.switchState = 0;
        if (this._as != null) {
            this._as.voiceCallPostprocess();
            this._as.release();
            this._as = null;
        }
        TraeAudioManager.IsUpdateSceneFlag = false;
        LogTraceExit();
        AppMethodBeat.o(13835);
        return 0;
    }

    public int call_preprocess_media() {
        AppMethodBeat.i(13836);
        LogTraceEntry("");
        this.switchState = 0;
        if (mVivoKTVHelper != null && isSupportVivoKTVHelper) {
            mVivoKTVHelper.openKTVDevice();
            mVivoKTVHelper.setPreModeParam(1);
            mVivoKTVHelper.setPlayFeedbackParam(1);
            mVivoKTVHelper.setPlayFeedbackParam(0);
        }
        if (this._as == null) {
            this._as = new TraeAudioSession(this._context, new TraeAudioSession.ITraeAudioCallback() {
                /* class com.tencent.rtmp.sharp.jni.AudioDeviceInterface.AnonymousClass2 */

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public void onServiceStateUpdate(boolean z) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public void onDeviceListUpdate(String[] strArr, String str, String str2, String str3) {
                    AppMethodBeat.i(13635);
                    String[] unused = AudioDeviceInterface.mDeviceList = strArr;
                    if (AudioDeviceInterface.this.usingJava) {
                        AudioDeviceInterface.access$500(AudioDeviceInterface.this, str);
                    }
                    AppMethodBeat.o(13635);
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public void onDeviceChangabledUpdate(boolean z) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public void onGetDeviceListRes(int i2, String[] strArr, String str, String str2, String str3) {
                    AppMethodBeat.i(13636);
                    String[] unused = AudioDeviceInterface.mDeviceList = strArr;
                    AppMethodBeat.o(13636);
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public void onConnectDeviceRes(int i2, String str, boolean z) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public void onIsDeviceChangabledRes(int i2, boolean z) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public void onGetConnectedDeviceRes(int i2, String str) {
                    AppMethodBeat.i(13637);
                    if (i2 == 0) {
                        AudioDeviceInterface.access$500(AudioDeviceInterface.this, str);
                    }
                    AppMethodBeat.o(13637);
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public void onGetConnectingDeviceRes(int i2, String str) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public void onRingCompletion(int i2, String str) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public void onStreamTypeUpdate(int i2) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public void onGetStreamTypeRes(int i2, int i3) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public void onVoicecallPreprocessRes(int i2) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public void onAudioRouteSwitchStart(String str, String str2) {
                }

                @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                public void onAudioRouteSwitchEnd(String str, long j2) {
                }
            });
        }
        if (this._as != null) {
            try {
                if (this._audioManager == null) {
                    this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                }
                if (this._audioManager != null) {
                    if (this._audioManager.getMode() == 2) {
                        int i2 = 5;
                        while (true) {
                            int i3 = i2 - 1;
                            if (i2 <= 0 || this._audioManager.getMode() != 2) {
                                break;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.e("TRAE", 2, "media call_preprocess_media waiting...  mode:" + this._audioManager.getMode());
                            }
                            Thread.sleep(500);
                            i2 = i3;
                        }
                    }
                    if (this._audioManager.getMode() != 0) {
                        this._audioManager.setMode(0);
                    }
                    if (this._audioManager.isMicrophoneMute()) {
                        this._audioManager.setMicrophoneMute(false);
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "media call_preprocess_media setMicrophoneMute false");
                        }
                    }
                }
                this._as.connectHighestPriorityDevice();
                this._as.getConnectedDevice();
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "call_preprocess_media done!");
                }
            } catch (InterruptedException e2) {
            }
        }
        LogTraceExit();
        AppMethodBeat.o(13836);
        return 0;
    }

    public int call_postprocess_media() {
        AppMethodBeat.i(13837);
        LogTraceEntry("");
        this.switchState = 0;
        if (this._as != null) {
            this._as.release();
            this._as = null;
        }
        TraeAudioManager.IsUpdateSceneFlag = false;
        if (mVivoKTVHelper != null && isSupportVivoKTVHelper) {
            mVivoKTVHelper.closeKTVDevice();
        }
        LogTraceExit();
        AppMethodBeat.o(13837);
        return 0;
    }

    public void setJavaInterface(int i2) {
        AppMethodBeat.i(13838);
        if (i2 == 0) {
            this.usingJava = false;
        } else {
            this.usingJava = true;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "setJavaInterface flg:".concat(String.valueOf(i2)));
        }
        AppMethodBeat.o(13838);
    }

    private void setAudioRouteSwitchState(String str) {
        AppMethodBeat.i(13839);
        if (str.equals(TraeAudioManager.DEVICE_EARPHONE)) {
            this.switchState = 1;
            AppMethodBeat.o(13839);
        } else if (str.equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
            this.switchState = 2;
            AppMethodBeat.o(13839);
        } else if (str.equals(TraeAudioManager.DEVICE_WIREDHEADSET)) {
            this.switchState = 3;
            AppMethodBeat.o(13839);
        } else if (str.equals(TraeAudioManager.DEVICE_BLUETOOTHHEADSET)) {
            this.switchState = 4;
            AppMethodBeat.o(13839);
        } else {
            this.switchState = 0;
            AppMethodBeat.o(13839);
        }
    }

    public int getAudioRouteSwitchState() {
        return this.switchState;
    }

    private void initTRAEAudioManager() {
        AppMethodBeat.i(13840);
        if (this._context != null) {
            TraeAudioManager.init(this._context);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "initTRAEAudioManager , TraeAudioSession create");
            }
            if (this._asAudioManager == null) {
                this._asAudioManager = new TraeAudioSession(this._context, new TraeAudioSession.ITraeAudioCallback() {
                    /* class com.tencent.rtmp.sharp.jni.AudioDeviceInterface.AnonymousClass3 */

                    @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                    public void onServiceStateUpdate(boolean z) {
                    }

                    @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                    public void onDeviceListUpdate(String[] strArr, String str, String str2, String str3) {
                        AppMethodBeat.i(13889);
                        String[] unused = AudioDeviceInterface.mDeviceList = strArr;
                        if (AudioDeviceInterface.this.usingJava) {
                            AudioDeviceInterface.access$500(AudioDeviceInterface.this, str);
                        }
                        AppMethodBeat.o(13889);
                    }

                    @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                    public void onDeviceChangabledUpdate(boolean z) {
                    }

                    @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                    public void onGetDeviceListRes(int i2, String[] strArr, String str, String str2, String str3) {
                        AppMethodBeat.i(13890);
                        String[] unused = AudioDeviceInterface.mDeviceList = strArr;
                        AppMethodBeat.o(13890);
                    }

                    @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                    public void onConnectDeviceRes(int i2, String str, boolean z) {
                    }

                    @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                    public void onIsDeviceChangabledRes(int i2, boolean z) {
                    }

                    @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                    public void onGetConnectedDeviceRes(int i2, String str) {
                        AppMethodBeat.i(13891);
                        if (i2 == 0) {
                            AudioDeviceInterface.access$500(AudioDeviceInterface.this, str);
                        }
                        AppMethodBeat.o(13891);
                    }

                    @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                    public void onGetConnectingDeviceRes(int i2, String str) {
                    }

                    @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                    public void onRingCompletion(int i2, String str) {
                    }

                    @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                    public void onStreamTypeUpdate(int i2) {
                    }

                    @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                    public void onGetStreamTypeRes(int i2, int i3) {
                    }

                    @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                    public void onVoicecallPreprocessRes(int i2) {
                    }

                    @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                    public void onAudioRouteSwitchStart(String str, String str2) {
                    }

                    @Override // com.tencent.rtmp.sharp.jni.TraeAudioSession.ITraeAudioCallback
                    public void onAudioRouteSwitchEnd(String str, long j2) {
                    }
                });
            }
            this._asAudioManager.startService(TraeAudioManager.VIDEO_CONFIG);
        }
        AppMethodBeat.o(13840);
    }

    private int startService(String str) {
        AppMethodBeat.i(13841);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "initTRAEAudioManager , TraeAudioSession startService: " + this._asAudioManager + " deviceConfig:" + str);
        }
        if (this._asAudioManager != null) {
            int startService = this._asAudioManager.startService(str);
            AppMethodBeat.o(13841);
            return startService;
        }
        AppMethodBeat.o(13841);
        return -1;
    }

    private int stopService() {
        AppMethodBeat.i(13842);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "initTRAEAudioManager , TraeAudioSession stopService: " + this._asAudioManager);
        }
        if (this._asAudioManager != null) {
            int stopService = this._asAudioManager.stopService();
            AppMethodBeat.o(13842);
            return stopService;
        }
        AppMethodBeat.o(13842);
        return -1;
    }

    private int SetAudioOutputMode(int i2) {
        AppMethodBeat.i(13843);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "TraeAudioSession SetAudioOutputMode: ".concat(String.valueOf(i2)));
        }
        if (i2 == 0) {
            if (mDeviceList == null || this._asAudioManager == null) {
                AppMethodBeat.o(13843);
                return -1;
            }
            boolean z = false;
            do {
                int i3 = 0;
                while (true) {
                    if (i3 >= mDeviceList.length || z) {
                        break;
                    } else if (TraeAudioManager.DEVICE_WIREDHEADSET.equals(mDeviceList[i3])) {
                        this._asAudioManager.connectDevice(TraeAudioManager.DEVICE_WIREDHEADSET);
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                int i4 = 0;
                while (true) {
                    if (i4 >= mDeviceList.length || z) {
                        break;
                    } else if (TraeAudioManager.DEVICE_BLUETOOTHHEADSET.equals(mDeviceList[i4])) {
                        this._asAudioManager.connectDevice(TraeAudioManager.DEVICE_BLUETOOTHHEADSET);
                        z = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= mDeviceList.length || z) {
                        break;
                    } else if (TraeAudioManager.DEVICE_EARPHONE.equals(mDeviceList[i5])) {
                        this._asAudioManager.connectDevice(TraeAudioManager.DEVICE_EARPHONE);
                        z = true;
                        continue;
                        break;
                    } else {
                        i5++;
                    }
                }
            } while (!z);
            AppMethodBeat.o(13843);
            return 0;
        } else if (1 != i2) {
            AppMethodBeat.o(13843);
            return -1;
        } else if (this._asAudioManager == null) {
            AppMethodBeat.o(13843);
            return -1;
        } else {
            this._asAudioManager.connectDevice(TraeAudioManager.DEVICE_SPEAKERPHONE);
            AppMethodBeat.o(13843);
            return 0;
        }
    }

    private int getAndroidSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    public int hasLightSensorManager() {
        AppMethodBeat.i(13844);
        if (this._context == null) {
            AppMethodBeat.o(13844);
            return 1;
        }
        try {
            if (((SensorManager) this._context.getSystemService("sensor")).getDefaultSensor(5) == null) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "not hasLightSensorManager null == sensor8");
                }
                AppMethodBeat.o(13844);
                return 0;
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "hasLightSensorManager");
            }
            AppMethodBeat.o(13844);
            return 1;
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, e2.getMessage());
            }
            AppMethodBeat.o(13844);
            return 1;
        }
    }

    static boolean isHardcodeOpenSles() {
        AppMethodBeat.i(13845);
        if (Build.MANUFACTURER.equals("Xiaomi")) {
            if (Build.MODEL.equals("MI 5")) {
                AppMethodBeat.o(13845);
                return true;
            } else if (Build.MODEL.equals("MI 5s")) {
                AppMethodBeat.o(13845);
                return true;
            } else if (Build.MODEL.equals("MI 5s Plus")) {
                AppMethodBeat.o(13845);
                return true;
            }
        } else if (Build.MANUFACTURER.equals("samsung") && Build.MODEL.equals("SM-G9350")) {
            AppMethodBeat.o(13845);
            return true;
        }
        AppMethodBeat.o(13845);
        return false;
    }

    public int getNumberOfCPUCores() {
        int i2 = -1;
        AppMethodBeat.i(13846);
        if (Build.VERSION.SDK_INT <= 10) {
            AppMethodBeat.o(13846);
            return 1;
        }
        try {
            i2 = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        } catch (NullPointerException | SecurityException e2) {
        }
        AppMethodBeat.o(13846);
        return i2;
    }

    private int isSupportLowLatency() {
        AppMethodBeat.i(13847);
        if (isHardcodeOpenSles()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "hardcode FEATURE_AUDIO_LOW_LATENCY: " + Build.MANUFACTURER + "_" + Build.MODEL);
            }
            AppMethodBeat.o(13847);
            return 1;
        }
        AppMethodBeat.o(13847);
        return 0;
    }

    private int isSupportVivoKTVHelper() {
        AppMethodBeat.i(13848);
        if (this._context != null) {
            VivoKTVHelper instance = VivoKTVHelper.getInstance(this._context);
            mVivoKTVHelper = instance;
            if (instance != null) {
                isSupportVivoKTVHelper = mVivoKTVHelper.isDeviceSupportKaraoke();
            }
        }
        if (isSupportVivoKTVHelper) {
            AppMethodBeat.o(13848);
            return 1;
        }
        AppMethodBeat.o(13848);
        return 0;
    }

    private int EnableVivoKTVLoopback(int i2) {
        AppMethodBeat.i(13849);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "EnableVivoKTVLoopback: " + i2 + " isSupportVivoKTVHelper:" + isSupportVivoKTVHelper + " mVivoKTVHelper:" + mVivoKTVHelper);
        }
        if (mVivoKTVHelper == null || !isSupportVivoKTVHelper) {
            AppMethodBeat.o(13849);
            return -1;
        }
        mVivoKTVHelper.setPlayFeedbackParam(i2);
        AppMethodBeat.o(13849);
        return 0;
    }

    private int isVivoKTVLoopback() {
        AppMethodBeat.i(13850);
        if (mVivoKTVHelper == null || !isSupportVivoKTVHelper) {
            AppMethodBeat.o(13850);
            return 0;
        }
        int playFeedbackParam = mVivoKTVHelper.getPlayFeedbackParam();
        AppMethodBeat.o(13850);
        return playFeedbackParam;
    }

    private void uninitTRAEAudioManager() {
        AppMethodBeat.i(13851);
        if (this._context != null) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "uninitTRAEAudioManager , stopService");
            }
            if (this._asAudioManager != null) {
                this._asAudioManager.stopService();
                this._asAudioManager.release();
                this._asAudioManager = null;
                AppMethodBeat.o(13851);
                return;
            }
        } else if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "uninitTRAEAudioManager , context null");
        }
        AppMethodBeat.o(13851);
    }

    private int OpenMp3File(String str, int i2, int i3) {
        AppMethodBeat.i(13852);
        if (this._traeAudioCodecList.find((long) i2) == null) {
            TraeAudioCodecList.CodecInfo add = this._traeAudioCodecList.add((long) i2);
            add.audioDecoder.setIOPath(str);
            add.audioDecoder.setIndex(i2);
            int prepare = add.audioDecoder.prepare(i3);
            if (prepare != 0) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "openFile mp3 Failed!!!");
                }
                add.audioDecoder.release();
                add.audioDecoder = null;
                this._traeAudioCodecList.remove((long) i2);
                AppMethodBeat.o(13852);
                return prepare;
            }
            AppMethodBeat.o(13852);
            return 0;
        }
        AppMethodBeat.o(13852);
        return -1;
    }

    private ByteBuffer getDecBuffer(int i2) {
        AppMethodBeat.i(13853);
        switch (i2) {
            case 0:
                ByteBuffer byteBuffer = this._decBuffer0;
                AppMethodBeat.o(13853);
                return byteBuffer;
            case 1:
                ByteBuffer byteBuffer2 = this._decBuffer1;
                AppMethodBeat.o(13853);
                return byteBuffer2;
            case 2:
                ByteBuffer byteBuffer3 = this._decBuffer2;
                AppMethodBeat.o(13853);
                return byteBuffer3;
            case 3:
                ByteBuffer byteBuffer4 = this._decBuffer3;
                AppMethodBeat.o(13853);
                return byteBuffer4;
            case 4:
                ByteBuffer byteBuffer5 = this._decBuffer4;
                AppMethodBeat.o(13853);
                return byteBuffer5;
            case 5:
                ByteBuffer byteBuffer6 = this._decBuffer5;
                AppMethodBeat.o(13853);
                return byteBuffer6;
            case 6:
                ByteBuffer byteBuffer7 = this._decBuffer6;
                AppMethodBeat.o(13853);
                return byteBuffer7;
            case 7:
                ByteBuffer byteBuffer8 = this._decBuffer7;
                AppMethodBeat.o(13853);
                return byteBuffer8;
            case 8:
                ByteBuffer byteBuffer9 = this._decBuffer8;
                AppMethodBeat.o(13853);
                return byteBuffer9;
            case 9:
                ByteBuffer byteBuffer10 = this._decBuffer9;
                AppMethodBeat.o(13853);
                return byteBuffer10;
            case 10:
                ByteBuffer byteBuffer11 = this._decBuffer10;
                AppMethodBeat.o(13853);
                return byteBuffer11;
            default:
                QLog.w("TRAE", 2, "getDecBuffer failed!! index:".concat(String.valueOf(i2)));
                AppMethodBeat.o(13853);
                return null;
        }
    }

    private int ReadMp3File(int i2) {
        AppMethodBeat.i(13854);
        TraeAudioCodecList.CodecInfo find = this._traeAudioCodecList.find((long) i2);
        if (find != null) {
            ByteBuffer decBuffer = getDecBuffer(i2);
            if (decBuffer == null) {
                AppMethodBeat.o(13854);
                return -1;
            }
            decBuffer.rewind();
            int frameSize = find.audioDecoder.getFrameSize();
            int ReadOneFrame = find.audioDecoder.ReadOneFrame(find._tempBufdec, frameSize);
            decBuffer.put(find._tempBufdec, 0, frameSize);
            AppMethodBeat.o(13854);
            return ReadOneFrame;
        }
        AppMethodBeat.o(13854);
        return -1;
    }

    private int CloseMp3File(int i2) {
        AppMethodBeat.i(13855);
        TraeAudioCodecList.CodecInfo find = this._traeAudioCodecList.find((long) i2);
        if (find != null) {
            find.audioDecoder.release();
            find.audioDecoder = null;
            this._traeAudioCodecList.remove((long) i2);
            AppMethodBeat.o(13855);
            return 0;
        }
        AppMethodBeat.o(13855);
        return -1;
    }

    private int SeekMp3To(int i2, int i3) {
        AppMethodBeat.i(13856);
        TraeAudioCodecList.CodecInfo find = this._traeAudioCodecList.find((long) i2);
        if (find != null) {
            int SeekTo = find.audioDecoder.SeekTo(i3);
            AppMethodBeat.o(13856);
            return SeekTo;
        }
        AppMethodBeat.o(13856);
        return 0;
    }

    private int getMp3SampleRate(int i2) {
        AppMethodBeat.i(13857);
        TraeAudioCodecList.CodecInfo find = this._traeAudioCodecList.find((long) i2);
        if (find != null) {
            int sampleRate = find.audioDecoder.getSampleRate();
            AppMethodBeat.o(13857);
            return sampleRate;
        }
        AppMethodBeat.o(13857);
        return -1;
    }

    private int getMp3Channels(int i2) {
        AppMethodBeat.i(13858);
        TraeAudioCodecList.CodecInfo find = this._traeAudioCodecList.find((long) i2);
        if (find != null) {
            int channels = find.audioDecoder.getChannels();
            AppMethodBeat.o(13858);
            return channels;
        }
        AppMethodBeat.o(13858);
        return -1;
    }

    private long getMp3FileTotalMs(int i2) {
        AppMethodBeat.i(13859);
        TraeAudioCodecList.CodecInfo find = this._traeAudioCodecList.find((long) i2);
        if (find != null) {
            long fileTotalMs = find.audioDecoder.getFileTotalMs();
            AppMethodBeat.o(13859);
            return fileTotalMs;
        }
        AppMethodBeat.o(13859);
        return -1;
    }

    public int checkAACSupported() {
        AppMethodBeat.i(13860);
        int checkAACMediaCodecSupported = checkAACMediaCodecSupported(false);
        int checkAACMediaCodecSupported2 = checkAACMediaCodecSupported(true);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "checkAACSupported isSupportEncoder: " + checkAACMediaCodecSupported + ", isSupportDecoder:" + checkAACMediaCodecSupported2);
        }
        if (checkAACMediaCodecSupported == 1 && checkAACMediaCodecSupported2 == 1) {
            AppMethodBeat.o(13860);
            return 1;
        }
        AppMethodBeat.o(13860);
        return 0;
    }

    @SuppressLint({"NewApi"})
    public int checkAACMediaCodecSupported(boolean z) {
        String[] supportedTypes;
        String[] supportedTypes2;
        AppMethodBeat.i(13861);
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
                for (MediaCodecInfo mediaCodecInfo : codecInfos) {
                    if (mediaCodecInfo.isEncoder() != z) {
                        if (mediaCodecInfo.getName().toLowerCase().contains("nvidia")) {
                            AppMethodBeat.o(13861);
                            return 0;
                        }
                        for (String str : mediaCodecInfo.getSupportedTypes()) {
                            if (str.equalsIgnoreCase(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE)) {
                                if (QLog.isColorLevel()) {
                                    QLog.w("TRAE", 2, "checkAACSupported support!, " + mediaCodecInfo.getName());
                                }
                                AppMethodBeat.o(13861);
                                return 1;
                            }
                        }
                        continue;
                    }
                }
            } else {
                int codecCount = MediaCodecList.getCodecCount();
                for (int i2 = 0; i2 < codecCount; i2++) {
                    MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
                    if (codecInfoAt.isEncoder() != z) {
                        if (codecInfoAt.getName().toLowerCase().contains("nvidia")) {
                            AppMethodBeat.o(13861);
                            return 0;
                        }
                        for (String str2 : codecInfoAt.getSupportedTypes()) {
                            if (str2.equalsIgnoreCase(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE)) {
                                if (QLog.isColorLevel()) {
                                    QLog.w("TRAE", 2, "checkAACSupported support!, " + codecInfoAt.getName());
                                }
                                AppMethodBeat.o(13861);
                                return 1;
                            }
                        }
                        continue;
                    }
                }
            }
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "check if support aac codec failed.");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "Error when checking aac codec availability");
        }
        AppMethodBeat.o(13861);
        return 0;
    }
}
