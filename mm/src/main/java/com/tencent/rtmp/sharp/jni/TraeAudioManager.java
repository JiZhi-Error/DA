package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.rtmp.sharp.jni.TraeMediaPlayer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.xwalk.core.XWalkEnvironment;

@SuppressLint({"NewApi"})
public class TraeAudioManager extends BroadcastReceiver {
    public static final String ACTION_TRAEAUDIOMANAGER_NOTIFY = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY";
    public static final String ACTION_TRAEAUDIOMANAGER_REQUEST = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST";
    public static final String ACTION_TRAEAUDIOMANAGER_RES = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES";
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP = 128;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES = 256;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER = 512;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO = 16;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO_CARKIT = 64;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO_HEADSET = 32;
    static final int AUDIO_DEVICE_OUT_EARPIECE = 1;
    static final int AUDIO_DEVICE_OUT_SPEAKER = 2;
    static final int AUDIO_DEVICE_OUT_WIRED_HEADPHONE = 8;
    static final int AUDIO_DEVICE_OUT_WIRED_HEADSET = 4;
    public static final int AUDIO_MANAGER_ACTIVE_NONE = 0;
    public static final int AUDIO_MANAGER_ACTIVE_RING = 2;
    public static final int AUDIO_MANAGER_ACTIVE_VOICECALL = 1;
    static final String AUDIO_PARAMETER_STREAM_ROUTING = "routing";
    public static final String CONNECTDEVICE_DEVICENAME = "CONNECTDEVICE_DEVICENAME";
    public static final String CONNECTDEVICE_RESULT_DEVICENAME = "CONNECTDEVICE_RESULT_DEVICENAME";
    public static final String DEVICE_BLUETOOTHHEADSET = "DEVICE_BLUETOOTHHEADSET";
    public static final String DEVICE_EARPHONE = "DEVICE_EARPHONE";
    public static final String DEVICE_NONE = "DEVICE_NONE";
    public static final String DEVICE_SPEAKERPHONE = "DEVICE_SPEAKERPHONE";
    public static final int DEVICE_STATUS_CONNECTED = 2;
    public static final int DEVICE_STATUS_CONNECTING = 1;
    public static final int DEVICE_STATUS_DISCONNECTED = 0;
    public static final int DEVICE_STATUS_DISCONNECTING = 3;
    public static final int DEVICE_STATUS_ERROR = -1;
    public static final int DEVICE_STATUS_UNCHANGEABLE = 4;
    public static final String DEVICE_WIREDHEADSET = "DEVICE_WIREDHEADSET";
    public static final int EARACTION_AWAY = 0;
    public static final int EARACTION_CLOSE = 1;
    public static final String EXTRA_DATA_AVAILABLEDEVICE_LIST = "EXTRA_DATA_AVAILABLEDEVICE_LIST";
    public static final String EXTRA_DATA_CONNECTEDDEVICE = "EXTRA_DATA_CONNECTEDDEVICE";
    public static final String EXTRA_DATA_DEVICECONFIG = "EXTRA_DATA_DEVICECONFIG";
    public static final String EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME = "EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME";
    public static final String EXTRA_DATA_PREV_CONNECTEDDEVICE = "EXTRA_DATA_PREV_CONNECTEDDEVICE";
    public static final String EXTRA_DATA_ROUTESWITCHEND_DEV = "EXTRA_DATA_ROUTESWITCHEND_DEV";
    public static final String EXTRA_DATA_ROUTESWITCHEND_TIME = "EXTRA_DATA_ROUTESWITCHEND_TIME";
    public static final String EXTRA_DATA_ROUTESWITCHSTART_FROM = "EXTRA_DATA_ROUTESWITCHSTART_FROM";
    public static final String EXTRA_DATA_ROUTESWITCHSTART_TO = "EXTRA_DATA_ROUTESWITCHSTART_TO";
    public static final String EXTRA_DATA_STREAMTYPE = "EXTRA_DATA_STREAMTYPE";
    public static final String EXTRA_EARACTION = "EXTRA_EARACTION";
    public static final int FORCE_ANALOG_DOCK = 8;
    public static final int FORCE_BT_A2DP = 4;
    public static final int FORCE_BT_CAR_DOCK = 6;
    public static final int FORCE_BT_DESK_DOCK = 7;
    public static final int FORCE_BT_SCO = 3;
    public static final int FORCE_DEFAULT = 0;
    public static final int FORCE_DIGITAL_DOCK = 9;
    public static final int FORCE_HEADPHONES = 2;
    public static final int FORCE_NONE = 0;
    public static final int FORCE_NO_BT_A2DP = 10;
    public static final int FORCE_SPEAKER = 1;
    public static final int FORCE_WIRED_ACCESSORY = 5;
    public static final int FOR_COMMUNICATION = 0;
    public static final int FOR_DOCK = 3;
    public static final int FOR_MEDIA = 1;
    public static final int FOR_RECORD = 2;
    public static final String GETCONNECTEDDEVICE_RESULT_LIST = "GETCONNECTEDDEVICE_REULT_LIST";
    public static final String GETCONNECTINGDEVICE_RESULT_LIST = "GETCONNECTINGDEVICE_REULT_LIST";
    public static final String ISDEVICECHANGABLED_RESULT_ISCHANGABLED = "ISDEVICECHANGABLED_REULT_ISCHANGABLED";
    public static boolean IsEarPhoneSupported = false;
    public static boolean IsMusicScene = false;
    public static boolean IsUpdateSceneFlag = false;
    public static final int MODE_MUSIC_PLAYBACK = 2;
    public static final int MODE_MUSIC_PLAY_RECORD = 1;
    public static final int MODE_MUSIC_PLAY_RECORD_HIGH_QUALITY = 3;
    public static final int MODE_MUSIC_PLAY_RECORD_LOW_QUALITY = 5;
    public static final int MODE_VOICE_CHAT = 0;
    public static final int MODE_VOICE_PLAYBACK = 4;
    public static final String MUSIC_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_WIREDHEADSET;DEVICE_BLUETOOTHHEADSET;";
    public static final String NOTIFY_DEVICECHANGABLE_UPDATE = "NOTIFY_DEVICECHANGABLE_UPDATE";
    public static final String NOTIFY_DEVICECHANGABLE_UPDATE_DATE = "NOTIFY_DEVICECHANGABLE_UPDATE_DATE";
    public static final String NOTIFY_DEVICELIST_UPDATE = "NOTIFY_DEVICELISTUPDATE";
    public static final String NOTIFY_RING_COMPLETION = "NOTIFY_RING_COMPLETION";
    public static final String NOTIFY_ROUTESWITCHEND = "NOTIFY_ROUTESWITCHEND";
    public static final String NOTIFY_ROUTESWITCHSTART = "NOTIFY_ROUTESWITCHSTART";
    public static final String NOTIFY_SERVICE_STATE = "NOTIFY_SERVICE_STATE";
    public static final String NOTIFY_SERVICE_STATE_DATE = "NOTIFY_SERVICE_STATE_DATE";
    public static final String NOTIFY_STREAMTYPE_UPDATE = "NOTIFY_STREAMTYPE_UPDATE";
    private static final int NUM_FORCE_CONFIG = 11;
    private static final int NUM_FORCE_USE = 4;
    public static final String OPERATION_CONNECTDEVICE = "OPERATION_CONNECTDEVICE";
    public static final String OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE = "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE";
    public static final String OPERATION_EARACTION = "OPERATION_EARACTION";
    public static final String OPERATION_GETCONNECTEDDEVICE = "OPERATION_GETCONNECTEDDEVICE";
    public static final String OPERATION_GETCONNECTINGDEVICE = "OPERATION_GETCONNECTINGDEVICE";
    public static final String OPERATION_GETDEVICELIST = "OPERATION_GETDEVICELIST";
    public static final String OPERATION_GETSTREAMTYPE = "OPERATION_GETSTREAMTYPE";
    public static final String OPERATION_ISDEVICECHANGABLED = "OPERATION_ISDEVICECHANGABLED";
    public static final String OPERATION_RECOVER_AUDIO_FOCUS = "OPERATION_RECOVER_AUDIO_FOCUS";
    public static final String OPERATION_REGISTERAUDIOSESSION = "OPERATION_REGISTERAUDIOSESSION";
    public static final String OPERATION_REQUEST_RELEASE_AUDIO_FOCUS = "OPERATION_REQUEST_RELEASE_AUDIO_FOCUS";
    public static final String OPERATION_STARTRING = "OPERATION_STARTRING";
    public static final String OPERATION_STARTSERVICE = "OPERATION_STARTSERVICE";
    public static final String OPERATION_STOPRING = "OPERATION_STOPRING";
    public static final String OPERATION_STOPSERVICE = "OPERATION_STOPSERVICE";
    public static final String OPERATION_VOICECALL_AUDIOPARAM_CHANGED = "OPERATION_VOICECALL_AUDIOPARAM_CHANGED";
    public static final String OPERATION_VOICECALL_POSTPROCESS = "OPERATION_VOICECALL_POSTROCESS";
    public static final String OPERATION_VOICECALL_PREPROCESS = "OPERATION_VOICECALL_PREPROCESS";
    public static final String PARAM_DEVICE = "PARAM_DEVICE";
    public static final String PARAM_ERROR = "PARAM_ERROR";
    public static final String PARAM_ISHOSTSIDE = "PARAM_ISHOSTSIDE";
    public static final String PARAM_MODEPOLICY = "PARAM_MODEPOLICY";
    public static final String PARAM_OPERATION = "PARAM_OPERATION";
    public static final String PARAM_RES_ERRCODE = "PARAM_RES_ERRCODE";
    public static final String PARAM_RING_DATASOURCE = "PARAM_RING_DATASOURCE";
    public static final String PARAM_RING_FILEPATH = "PARAM_RING_FILEPATH";
    public static final String PARAM_RING_LOOP = "PARAM_RING_LOOP";
    public static final String PARAM_RING_LOOPCOUNT = "PARAM_RING_LOOPCOUNT";
    public static final String PARAM_RING_MODE = "PARAM_RING_MODE";
    public static final String PARAM_RING_RSID = "PARAM_RING_RSID";
    public static final String PARAM_RING_URI = "PARAM_RING_URI";
    public static final String PARAM_RING_USERDATA_STRING = "PARAM_RING_USERDATA_STRING";
    public static final String PARAM_SESSIONID = "PARAM_SESSIONID";
    public static final String PARAM_STATUS = "PARAM_STATUS";
    public static final String PARAM_STREAMTYPE = "PARAM_STREAMTYPE";
    public static final String REGISTERAUDIOSESSION_ISREGISTER = "REGISTERAUDIOSESSION_ISREGISTER";
    public static final int RES_ERRCODE_DEVICE_BTCONNCECTED_TIMEOUT = 10;
    public static final int RES_ERRCODE_DEVICE_NOT_VISIABLE = 8;
    public static final int RES_ERRCODE_DEVICE_UNCHANGEABLE = 9;
    public static final int RES_ERRCODE_DEVICE_UNKOWN = 7;
    public static final int RES_ERRCODE_NONE = 0;
    public static final int RES_ERRCODE_RING_NOT_EXIST = 5;
    public static final int RES_ERRCODE_SERVICE_OFF = 1;
    public static final int RES_ERRCODE_STOPRING_INTERRUPT = 4;
    public static final int RES_ERRCODE_VOICECALLPOST_INTERRUPT = 6;
    public static final int RES_ERRCODE_VOICECALL_EXIST = 2;
    public static final int RES_ERRCODE_VOICECALL_NOT_EXIST = 3;
    public static final String VIDEO_CONFIG = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    public static final String VOICECALL_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    static int _gHostProcessId = -1;
    static TraeAudioManager _ginstance = null;
    static ReentrantLock _glock = new ReentrantLock();
    public static boolean enableDeviceSwitchFlag = true;
    static final String[] forceName = {"FORCE_NONE", "FORCE_SPEAKER", "FORCE_HEADPHONES", "FORCE_BT_SCO", "FORCE_BT_A2DP", "FORCE_WIRED_ACCESSORY", "FORCE_BT_CAR_DOCK", "FORCE_BT_DESK_DOCK", "FORCE_ANALOG_DOCK", "FORCE_NO_BT_A2DP", "FORCE_DIGITAL_DOCK"};
    boolean IsBluetoothA2dpExisted = true;
    int _activeMode = 0;
    AudioManager _am = null;
    TraeAudioSessionHost _audioSessionHost = new TraeAudioSessionHost();
    BluetoohHeadsetCheckInterface _bluetoothCheck = null;
    Context _context = null;
    DeviceConfigManager _deviceConfigManager = new DeviceConfigManager();
    ReentrantLock _lock = new ReentrantLock();
    int _modePolicy = -1;
    int _prevMode = 0;
    int _streamType = 0;
    switchThread _switchThread = null;
    TraeAudioManagerLooper mTraeAudioManagerLooper = null;
    String sessionConnectedDev = DEVICE_NONE;

    public class Parameters {
        public static final String BLUETOOTHPOLICY = "com.tencent.sharp.TraeAudioManager.Parameters.BLUETOOTHPOLICY";
        public static final String CONTEXT = "com.tencent.sharp.TraeAudioManager.Parameters.CONTEXT";
        public static final String DEVICECONFIG = "com.tencent.sharp.TraeAudioManager.Parameters.DEVICECONFIG";
        public static final String MODEPOLICY = "com.tencent.sharp.TraeAudioManager.Parameters.MODEPOLICY";

        public Parameters() {
        }
    }

    static {
        AppMethodBeat.i(13761);
        AppMethodBeat.o(13761);
    }

    public static boolean checkDevName(String str) {
        AppMethodBeat.i(13701);
        if (str == null) {
            AppMethodBeat.o(13701);
            return false;
        } else if (DEVICE_SPEAKERPHONE.equals(str) || DEVICE_EARPHONE.equals(str) || DEVICE_WIREDHEADSET.equals(str) || DEVICE_BLUETOOTHHEADSET.equals(str)) {
            AppMethodBeat.o(13701);
            return true;
        } else {
            AppMethodBeat.o(13701);
            return false;
        }
    }

    public static boolean isHandfree(String str) {
        AppMethodBeat.i(13702);
        if (!checkDevName(str)) {
            AppMethodBeat.o(13702);
            return false;
        } else if (DEVICE_SPEAKERPHONE.equals(str)) {
            AppMethodBeat.o(13702);
            return true;
        } else {
            AppMethodBeat.o(13702);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class DeviceConfigManager {
        String _bluetoothDevName = "unknow";
        String connectedDevice = TraeAudioManager.DEVICE_NONE;
        String connectingDevice = TraeAudioManager.DEVICE_NONE;
        HashMap<String, DeviceConfig> deviceConfigs = new HashMap<>();
        ReentrantLock mLock = new ReentrantLock();
        String prevConnectedDevice = TraeAudioManager.DEVICE_NONE;
        boolean visiableUpdate = false;

        public class DeviceConfig {
            String deviceName = TraeAudioManager.DEVICE_NONE;
            int priority = 0;
            boolean visible = false;

            public DeviceConfig() {
            }

            public boolean init(String str, int i2) {
                AppMethodBeat.i(13656);
                if (str == null || str.length() <= 0) {
                    AppMethodBeat.o(13656);
                    return false;
                } else if (!TraeAudioManager.checkDevName(str)) {
                    AppMethodBeat.o(13656);
                    return false;
                } else {
                    this.deviceName = str;
                    this.priority = i2;
                    AppMethodBeat.o(13656);
                    return true;
                }
            }

            public String getDeviceName() {
                return this.deviceName;
            }

            public boolean getVisible() {
                return this.visible;
            }

            public int getPriority() {
                return this.priority;
            }

            public void setVisible(boolean z) {
                this.visible = z;
            }
        }

        public DeviceConfigManager() {
            AppMethodBeat.i(13864);
            AppMethodBeat.o(13864);
        }

        public boolean init(String str) {
            AppMethodBeat.i(13865);
            AudioDeviceInterface.LogTraceEntry(" strConfigs:".concat(String.valueOf(str)));
            if (str == null || str.length() <= 0) {
                AppMethodBeat.o(13865);
                return false;
            }
            String replace = str.replace("\n", "").replace("\r", "");
            if (replace == null || replace.length() <= 0) {
                AppMethodBeat.o(13865);
                return false;
            }
            if (replace.indexOf(";") < 0) {
                replace = replace + ";";
            }
            String[] split = replace.split(";");
            if (split == null || 1 > split.length) {
                AppMethodBeat.o(13865);
                return false;
            }
            this.mLock.lock();
            for (int i2 = 0; i2 < split.length; i2++) {
                _addConfig(split[i2], i2);
            }
            this.mLock.unlock();
            TraeAudioManager.this.printDevices();
            AppMethodBeat.o(13865);
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean _addConfig(String str, int i2) {
            AppMethodBeat.i(13866);
            AudioDeviceInterface.LogTraceEntry(" devName:" + str + " priority:" + i2);
            DeviceConfig deviceConfig = new DeviceConfig();
            if (!deviceConfig.init(str, i2)) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " err dev init!");
                }
                AppMethodBeat.o(13866);
                return false;
            } else if (this.deviceConfigs.containsKey(str)) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "err dev exist!");
                }
                AppMethodBeat.o(13866);
                return false;
            } else {
                this.deviceConfigs.put(str, deviceConfig);
                this.visiableUpdate = true;
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " n" + getDeviceNumber() + " 0:" + getDeviceName(0));
                }
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(13866);
                return true;
            }
        }

        public void clearConfig() {
            AppMethodBeat.i(13867);
            this.mLock.lock();
            this.deviceConfigs.clear();
            this.prevConnectedDevice = TraeAudioManager.DEVICE_NONE;
            this.connectedDevice = TraeAudioManager.DEVICE_NONE;
            this.connectingDevice = TraeAudioManager.DEVICE_NONE;
            this.mLock.unlock();
            AppMethodBeat.o(13867);
        }

        public boolean getVisiableUpdateFlag() {
            AppMethodBeat.i(13868);
            this.mLock.lock();
            boolean z = this.visiableUpdate;
            this.mLock.unlock();
            AppMethodBeat.o(13868);
            return z;
        }

        public void resetVisiableUpdateFlag() {
            AppMethodBeat.i(13869);
            this.mLock.lock();
            this.visiableUpdate = false;
            this.mLock.unlock();
            AppMethodBeat.o(13869);
        }

        public boolean setVisible(String str, boolean z) {
            boolean z2;
            AppMethodBeat.i(13870);
            this.mLock.lock();
            DeviceConfig deviceConfig = this.deviceConfigs.get(str);
            if (deviceConfig == null || deviceConfig.getVisible() == z) {
                z2 = false;
            } else {
                deviceConfig.setVisible(z);
                this.visiableUpdate = true;
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " ++setVisible:" + str + (z ? " Y" : " N"));
                }
                z2 = true;
            }
            this.mLock.unlock();
            AppMethodBeat.o(13870);
            return z2;
        }

        public void setBluetoothName(String str) {
            AppMethodBeat.i(13871);
            if (str == null) {
                this._bluetoothDevName = "unknow";
                AppMethodBeat.o(13871);
            } else if (str.isEmpty()) {
                this._bluetoothDevName = "unknow";
                AppMethodBeat.o(13871);
            } else {
                this._bluetoothDevName = str;
                AppMethodBeat.o(13871);
            }
        }

        public String getBluetoothName() {
            return this._bluetoothDevName;
        }

        public boolean getVisible(String str) {
            boolean z;
            AppMethodBeat.i(13872);
            this.mLock.lock();
            DeviceConfig deviceConfig = this.deviceConfigs.get(str);
            if (deviceConfig != null) {
                z = deviceConfig.getVisible();
            } else {
                z = false;
            }
            this.mLock.unlock();
            AppMethodBeat.o(13872);
            return z;
        }

        public int getPriority(String str) {
            int i2;
            AppMethodBeat.i(13873);
            this.mLock.lock();
            DeviceConfig deviceConfig = this.deviceConfigs.get(str);
            if (deviceConfig != null) {
                i2 = deviceConfig.getPriority();
            } else {
                i2 = -1;
            }
            this.mLock.unlock();
            AppMethodBeat.o(13873);
            return i2;
        }

        public int getDeviceNumber() {
            AppMethodBeat.i(13874);
            this.mLock.lock();
            int size = this.deviceConfigs.size();
            this.mLock.unlock();
            AppMethodBeat.o(13874);
            return size;
        }

        public String getDeviceName(int i2) {
            DeviceConfig deviceConfig;
            AppMethodBeat.i(13875);
            int i3 = 0;
            this.mLock.lock();
            Iterator<Map.Entry<String, DeviceConfig>> it = this.deviceConfigs.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    deviceConfig = null;
                    break;
                }
                Map.Entry<String, DeviceConfig> next = it.next();
                if (i3 == i2) {
                    deviceConfig = next.getValue();
                    break;
                }
                i3++;
            }
            String deviceName = deviceConfig != null ? deviceConfig.getDeviceName() : TraeAudioManager.DEVICE_NONE;
            this.mLock.unlock();
            AppMethodBeat.o(13875);
            return deviceName;
        }

        public String getAvailabledHighestPriorityDevice(String str) {
            AppMethodBeat.i(13876);
            this.mLock.lock();
            DeviceConfig deviceConfig = null;
            for (Map.Entry<String, DeviceConfig> entry : this.deviceConfigs.entrySet()) {
                entry.getKey();
                entry.getValue();
                DeviceConfig value = entry.getValue();
                if (value != null && value.getVisible() && !value.getDeviceName().equals(str)) {
                    if (deviceConfig == null) {
                        deviceConfig = value;
                    } else {
                        if (value.getPriority() < deviceConfig.getPriority()) {
                            value = deviceConfig;
                        }
                        deviceConfig = value;
                    }
                }
            }
            this.mLock.unlock();
            if (deviceConfig != null) {
                String deviceName = deviceConfig.getDeviceName();
                AppMethodBeat.o(13876);
                return deviceName;
            }
            AppMethodBeat.o(13876);
            return TraeAudioManager.DEVICE_SPEAKERPHONE;
        }

        public String getAvailabledHighestPriorityDevice() {
            AppMethodBeat.i(13877);
            this.mLock.lock();
            DeviceConfig deviceConfig = null;
            for (Map.Entry<String, DeviceConfig> entry : this.deviceConfigs.entrySet()) {
                entry.getKey();
                entry.getValue();
                DeviceConfig value = entry.getValue();
                if (value != null && value.getVisible()) {
                    if (deviceConfig == null) {
                        deviceConfig = value;
                    } else {
                        if (value.getPriority() < deviceConfig.getPriority()) {
                            value = deviceConfig;
                        }
                        deviceConfig = value;
                    }
                }
            }
            this.mLock.unlock();
            if (deviceConfig != null) {
                String deviceName = deviceConfig.getDeviceName();
                AppMethodBeat.o(13877);
                return deviceName;
            }
            AppMethodBeat.o(13877);
            return TraeAudioManager.DEVICE_SPEAKERPHONE;
        }

        public String getConnectingDevice() {
            String str;
            AppMethodBeat.i(13878);
            this.mLock.lock();
            DeviceConfig deviceConfig = this.deviceConfigs.get(this.connectingDevice);
            if (deviceConfig == null || !deviceConfig.getVisible()) {
                str = null;
            } else {
                str = this.connectingDevice;
            }
            this.mLock.unlock();
            AppMethodBeat.o(13878);
            return str;
        }

        public String getConnectedDevice() {
            AppMethodBeat.i(13879);
            this.mLock.lock();
            String _getConnectedDevice = _getConnectedDevice();
            this.mLock.unlock();
            AppMethodBeat.o(13879);
            return _getConnectedDevice;
        }

        public String getPrevConnectedDevice() {
            AppMethodBeat.i(13880);
            this.mLock.lock();
            String _getPrevConnectedDevice = _getPrevConnectedDevice();
            this.mLock.unlock();
            AppMethodBeat.o(13880);
            return _getPrevConnectedDevice;
        }

        public boolean setConnecting(String str) {
            boolean z;
            AppMethodBeat.i(13881);
            this.mLock.lock();
            DeviceConfig deviceConfig = this.deviceConfigs.get(str);
            if (deviceConfig == null || !deviceConfig.getVisible()) {
                z = false;
            } else {
                this.connectingDevice = str;
                z = true;
            }
            this.mLock.unlock();
            AppMethodBeat.o(13881);
            return z;
        }

        public boolean setConnected(String str) {
            boolean z;
            AppMethodBeat.i(13882);
            this.mLock.lock();
            DeviceConfig deviceConfig = this.deviceConfigs.get(str);
            if (deviceConfig == null || !deviceConfig.getVisible()) {
                z = false;
            } else {
                if (this.connectedDevice != null && !this.connectedDevice.equals(str)) {
                    this.prevConnectedDevice = this.connectedDevice;
                }
                this.connectedDevice = str;
                this.connectingDevice = "";
                z = true;
            }
            this.mLock.unlock();
            AppMethodBeat.o(13882);
            return z;
        }

        public boolean isConnected(String str) {
            boolean z;
            AppMethodBeat.i(13883);
            this.mLock.lock();
            DeviceConfig deviceConfig = this.deviceConfigs.get(str);
            if (deviceConfig == null || !deviceConfig.getVisible()) {
                z = false;
            } else {
                z = this.connectedDevice.equals(str);
            }
            this.mLock.unlock();
            AppMethodBeat.o(13883);
            return z;
        }

        public HashMap<String, Object> getSnapParams() {
            AppMethodBeat.i(13884);
            HashMap<String, Object> hashMap = new HashMap<>();
            this.mLock.lock();
            hashMap.put(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST, _getAvailableDeviceList());
            hashMap.put(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE, _getConnectedDevice());
            hashMap.put(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE, _getPrevConnectedDevice());
            this.mLock.unlock();
            AppMethodBeat.o(13884);
            return hashMap;
        }

        public ArrayList<String> getAvailableDeviceList() {
            AppMethodBeat.i(13885);
            new ArrayList();
            this.mLock.lock();
            ArrayList<String> _getAvailableDeviceList = _getAvailableDeviceList();
            this.mLock.unlock();
            AppMethodBeat.o(13885);
            return _getAvailableDeviceList;
        }

        /* access modifiers changed from: package-private */
        public ArrayList<String> _getAvailableDeviceList() {
            AppMethodBeat.i(13886);
            ArrayList<String> arrayList = new ArrayList<>();
            for (Map.Entry<String, DeviceConfig> entry : this.deviceConfigs.entrySet()) {
                DeviceConfig value = entry.getValue();
                if (value != null && value.getVisible()) {
                    arrayList.add(value.getDeviceName());
                }
            }
            AppMethodBeat.o(13886);
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public String _getConnectedDevice() {
            AppMethodBeat.i(13887);
            DeviceConfig deviceConfig = this.deviceConfigs.get(this.connectedDevice);
            String str = (deviceConfig == null || !deviceConfig.getVisible()) ? TraeAudioManager.DEVICE_NONE : this.connectedDevice;
            AppMethodBeat.o(13887);
            return str;
        }

        /* access modifiers changed from: package-private */
        public String _getPrevConnectedDevice() {
            AppMethodBeat.i(13888);
            DeviceConfig deviceConfig = this.deviceConfigs.get(this.prevConnectedDevice);
            String str = (deviceConfig == null || !deviceConfig.getVisible()) ? TraeAudioManager.DEVICE_NONE : this.prevConnectedDevice;
            AppMethodBeat.o(13888);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public void printDevices() {
        AppMethodBeat.i(13703);
        AudioDeviceInterface.LogTraceEntry("");
        if (this._deviceConfigManager == null) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "_deviceConfigManager is null");
            }
            AppMethodBeat.o(13703);
            return;
        }
        int deviceNumber = this._deviceConfigManager.getDeviceNumber();
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   ConnectedDevice:" + this._deviceConfigManager.getConnectedDevice());
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   ConnectingDevice:" + this._deviceConfigManager.getConnectingDevice());
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   prevConnectedDevice:" + this._deviceConfigManager.getPrevConnectedDevice());
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   AHPDevice:" + this._deviceConfigManager.getAvailabledHighestPriorityDevice());
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   deviceNamber:".concat(String.valueOf(deviceNumber)));
        }
        for (int i2 = 0; i2 < deviceNumber; i2++) {
            String deviceName = this._deviceConfigManager.getDeviceName(i2);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "      " + i2 + " devName:" + deviceName + " Visible:" + this._deviceConfigManager.getVisible(deviceName) + " Priority:" + this._deviceConfigManager.getPriority(deviceName));
            }
        }
        String[] strArr = (String[]) this._deviceConfigManager.getAvailableDeviceList().toArray(new String[0]);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   AvailableNamber:" + strArr.length);
        }
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String str = strArr[i3];
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "      " + i3 + " devName:" + str + " Visible:" + this._deviceConfigManager.getVisible(str) + " Priority:" + this._deviceConfigManager.getPriority(str));
            }
        }
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13703);
    }

    static boolean isCloseSystemAPM(int i2) {
        AppMethodBeat.i(13704);
        if (i2 != -1) {
            AppMethodBeat.o(13704);
            return false;
        }
        if (Build.MANUFACTURER.equals("Xiaomi")) {
            if (Build.MODEL.equals("MI 2")) {
                AppMethodBeat.o(13704);
                return true;
            } else if (Build.MODEL.equals("MI 2A")) {
                AppMethodBeat.o(13704);
                return true;
            } else if (Build.MODEL.equals("MI 2S")) {
                AppMethodBeat.o(13704);
                return true;
            } else if (Build.MODEL.equals("MI 2SC")) {
                AppMethodBeat.o(13704);
                return true;
            }
        } else if (Build.MANUFACTURER.equals("samsung") && Build.MODEL.equals("SCH-I959")) {
            AppMethodBeat.o(13704);
            return true;
        }
        AppMethodBeat.o(13704);
        return false;
    }

    public static boolean IsEabiLowVersionByAbi(String str) {
        AppMethodBeat.i(13705);
        if (str == null) {
            AppMethodBeat.o(13705);
            return true;
        } else if (str.contains("x86")) {
            AppMethodBeat.o(13705);
            return false;
        } else if (str.contains("mips")) {
            AppMethodBeat.o(13705);
            return false;
        } else if (str.equalsIgnoreCase("armeabi")) {
            AppMethodBeat.o(13705);
            return true;
        } else if (str.equalsIgnoreCase(XWalkEnvironment.RUNTIME_ABI_ARM32_STR)) {
            AppMethodBeat.o(13705);
            return false;
        } else if (str.equalsIgnoreCase(XWalkEnvironment.RUNTIME_ABI_ARM64_STR)) {
            AppMethodBeat.o(13705);
            return false;
        } else {
            AppMethodBeat.o(13705);
            return true;
        }
    }

    static boolean IsEabiLowVersion() {
        AppMethodBeat.i(13706);
        String str = Build.CPU_ABI;
        String str2 = "unknown";
        if (Build.VERSION.SDK_INT >= 8) {
            try {
                str2 = (String) Build.class.getDeclaredField("CPU_ABI2").get(null);
            } catch (Exception e2) {
                if (IsEabiLowVersionByAbi(str)) {
                    AppMethodBeat.o(13706);
                    return true;
                }
                AppMethodBeat.o(13706);
                return false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "IsEabiVersion CPU_ABI:" + str + " CPU_ABI2:" + str2);
        }
        if (!IsEabiLowVersionByAbi(str) || !IsEabiLowVersionByAbi(str2)) {
            AppMethodBeat.o(13706);
            return false;
        }
        AppMethodBeat.o(13706);
        return true;
    }

    static int getAudioSource(int i2) {
        int i3 = 0;
        AppMethodBeat.i(13707);
        if (IsMusicScene) {
            AppMethodBeat.o(13707);
            return 0;
        } else if (IsEabiLowVersion()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] armeabi low Version, getAudioSource _audioSourcePolicy:" + i2 + " source:0");
            }
            AppMethodBeat.o(13707);
            return 0;
        } else {
            int i4 = Build.VERSION.SDK_INT;
            if (i2 >= 0) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "[Config] getAudioSource _audioSourcePolicy:" + i2 + " source:" + i2);
                }
                AppMethodBeat.o(13707);
                return i2;
            }
            if (i4 >= 11) {
                i3 = 7;
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] getAudioSource _audioSourcePolicy:" + i2 + " source:" + i3);
            }
            AppMethodBeat.o(13707);
            return i3;
        }
    }

    static int getAudioStreamType(int i2) {
        int i3 = 3;
        AppMethodBeat.i(13708);
        if (IsMusicScene) {
            AppMethodBeat.o(13708);
        } else if (IsEabiLowVersion()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] armeabi low Version, getAudioStreamType audioStreamTypePolicy:" + i2 + " streamType:3");
            }
            AppMethodBeat.o(13708);
        } else {
            int i4 = Build.VERSION.SDK_INT;
            if (i2 >= 0) {
                i3 = i2;
            } else if (i4 >= 9) {
                i3 = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] getAudioStreamType audioStreamTypePolicy:" + i2 + " streamType:" + i3);
            }
            AppMethodBeat.o(13708);
        }
        return i3;
    }

    static int getCallAudioMode(int i2) {
        int i3 = 0;
        AppMethodBeat.i(13709);
        if (IsMusicScene) {
            AppMethodBeat.o(13709);
            return 0;
        } else if (IsEabiLowVersion()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] armeabi low Version, getCallAudioMode modePolicy:" + i2 + " mode:0");
            }
            AppMethodBeat.o(13709);
            return 0;
        } else {
            int i4 = Build.VERSION.SDK_INT;
            if (i2 >= 0) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "[Config] getCallAudioMode modePolicy:" + i2 + " mode:" + i2);
                }
                AppMethodBeat.o(13709);
                return i2;
            }
            if (i4 >= 11) {
                i3 = 3;
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] getCallAudioMode _modePolicy:" + i2 + " mode:" + i3 + "facturer:" + Build.MANUFACTURER + " model:" + Build.MODEL);
            }
            AppMethodBeat.o(13709);
            return i3;
        }
    }

    /* access modifiers changed from: package-private */
    public void updateDeviceStatus() {
        boolean z;
        AppMethodBeat.i(13710);
        if (this._deviceConfigManager == null) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "_deviceConfigManager is null");
            }
            AppMethodBeat.o(13710);
            return;
        }
        int deviceNumber = this._deviceConfigManager.getDeviceNumber();
        for (int i2 = 0; i2 < deviceNumber; i2++) {
            String deviceName = this._deviceConfigManager.getDeviceName(i2);
            if (deviceName != null) {
                if (deviceName.equals(DEVICE_BLUETOOTHHEADSET)) {
                    if (this._bluetoothCheck == null) {
                        z = this._deviceConfigManager.setVisible(deviceName, false);
                    } else {
                        z = this._deviceConfigManager.setVisible(deviceName, this._bluetoothCheck.isConnected());
                    }
                } else if (deviceName.equals(DEVICE_WIREDHEADSET)) {
                    z = this._deviceConfigManager.setVisible(deviceName, this._am.isWiredHeadsetOn());
                } else if (deviceName.equals(DEVICE_SPEAKERPHONE)) {
                    this._deviceConfigManager.setVisible(deviceName, true);
                }
                if (z && QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "pollUpdateDevice dev:" + deviceName + " Visible:" + this._deviceConfigManager.getVisible(deviceName));
                }
            }
            z = false;
            QLog.w("TRAE", 2, "pollUpdateDevice dev:" + deviceName + " Visible:" + this._deviceConfigManager.getVisible(deviceName));
        }
        checkAutoDeviceListUpdate();
        AppMethodBeat.o(13710);
    }

    /* access modifiers changed from: package-private */
    public void _updateEarphoneVisable() {
        AppMethodBeat.i(13711);
        if (this._deviceConfigManager == null) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "_deviceConfigManager is null");
            }
            AppMethodBeat.o(13711);
        } else if (this._deviceConfigManager.getVisible(DEVICE_WIREDHEADSET)) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " detected headset plugin,so disable earphone");
            }
            this._deviceConfigManager.setVisible(DEVICE_EARPHONE, false);
            AppMethodBeat.o(13711);
        } else {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " detected headset plugout,so enable earphone");
            }
            this._deviceConfigManager.setVisible(DEVICE_EARPHONE, true);
            AppMethodBeat.o(13711);
        }
    }

    /* access modifiers changed from: package-private */
    public void checkAutoDeviceListUpdate() {
        AppMethodBeat.i(13712);
        if (this._deviceConfigManager == null) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "_deviceConfigManager is null");
            }
            AppMethodBeat.o(13712);
            return;
        }
        if (this._deviceConfigManager.getVisiableUpdateFlag()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "checkAutoDeviceListUpdate got update!");
            }
            _updateEarphoneVisable();
            this._deviceConfigManager.resetVisiableUpdateFlag();
            internalSendMessage(TraeAudioManagerLooper.MESSAGE_AUTO_DEVICELIST_UPDATE, new HashMap<>());
        }
        AppMethodBeat.o(13712);
    }

    /* access modifiers changed from: package-private */
    public void checkDevicePlug(String str, boolean z) {
        AppMethodBeat.i(13713);
        if (this._deviceConfigManager == null) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "_deviceConfigManager is null");
            }
            AppMethodBeat.o(13713);
            return;
        }
        if (this._deviceConfigManager.getVisiableUpdateFlag()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "checkDevicePlug got update dev:" + str + (z ? " piugin" : " plugout") + " connectedDev:" + this._deviceConfigManager.getConnectedDevice());
            }
            _updateEarphoneVisable();
            this._deviceConfigManager.resetVisiableUpdateFlag();
            if (z) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put(PARAM_DEVICE, str);
                internalSendMessage(TraeAudioManagerLooper.MESSAGE_AUTO_DEVICELIST_PLUGIN_UPDATE, hashMap);
                AppMethodBeat.o(13713);
                return;
            }
            String connectedDevice = this._deviceConfigManager.getConnectedDevice();
            if (connectedDevice.equals(str) || connectedDevice.equals(DEVICE_NONE)) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put(PARAM_DEVICE, str);
                internalSendMessage(TraeAudioManagerLooper.MESSAGE_AUTO_DEVICELIST_PLUGOUT_UPDATE, hashMap2);
                AppMethodBeat.o(13713);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " ---No switch,plugout:" + str + " connectedDev:" + connectedDevice);
            }
            internalSendMessage(TraeAudioManagerLooper.MESSAGE_AUTO_DEVICELIST_UPDATE, new HashMap<>());
        }
        AppMethodBeat.o(13713);
    }

    /* access modifiers changed from: package-private */
    public class TraeAudioManagerLooper extends Thread {
        public static final int MESSAGE_AUTO_DEVICELIST_PLUGIN_UPDATE = 32786;
        public static final int MESSAGE_AUTO_DEVICELIST_PLUGOUT_UPDATE = 32787;
        public static final int MESSAGE_AUTO_DEVICELIST_UPDATE = 32785;
        public static final int MESSAGE_BEGIN = 32768;
        public static final int MESSAGE_CONNECTDEVICE = 32775;
        public static final int MESSAGE_CONNECT_HIGHEST_PRIORITY_DEVICE = 32789;
        public static final int MESSAGE_DISABLE = 32773;
        public static final int MESSAGE_EARACTION = 32776;
        public static final int MESSAGE_ENABLE = 32772;
        public static final int MESSAGE_GETCONNECTEDDEVICE = 32778;
        public static final int MESSAGE_GETCONNECTINGDEVICE = 32779;
        public static final int MESSAGE_GETDEVICELIST = 32774;
        public static final int MESSAGE_GETSTREAMTYPE = 32784;
        public static final int MESSAGE_ISDEVICECHANGABLED = 32777;
        public static final int MESSAGE_RECOVER_AUDIO_FOCUS = 32791;
        public static final int MESSAGE_REQUEST_RELEASE_AUDIO_FOCUS = 32790;
        public static final int MESSAGE_STARTRING = 32782;
        public static final int MESSAGE_STOPRING = 32783;
        public static final int MESSAGE_VOICECALLPOSTPROCESS = 32781;
        public static final int MESSAGE_VOICECALLPREPROCESS = 32780;
        public static final int MESSAGE_VOICECALL_AUIDOPARAM_CHANGED = 32788;
        boolean _enabled = false;
        int _focusSteamType = 0;
        String _lastCfg = "";
        TraeAudioManager _parent = null;
        int _preRingMode = 0;
        int _preServiceMode = 0;
        String _ringOperation = "";
        TraeMediaPlayer _ringPlayer = null;
        long _ringSessionID = -1;
        String _ringUserdata = "";
        final boolean[] _started = {false};
        String _voiceCallOperation = "";
        long _voiceCallSessionID = -1;
        AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = null;
        Handler mMsgHandler = null;

        public TraeAudioManagerLooper(TraeAudioManager traeAudioManager) {
            AppMethodBeat.i(13911);
            this._parent = traeAudioManager;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "TraeAudioManagerLooper start...");
            }
            start();
            synchronized (this._started) {
                try {
                    if (!this._started[0]) {
                        try {
                            this._started.wait(3000);
                        } catch (InterruptedException e2) {
                        }
                    }
                } finally {
                    AppMethodBeat.o(13911);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "  start used:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + LocaleUtil.MALAY);
            }
        }

        public void quit() {
            AppMethodBeat.i(13912);
            AudioDeviceInterface.LogTraceEntry("");
            if (this.mMsgHandler == null) {
                AppMethodBeat.o(13912);
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mMsgHandler.getLooper().quit();
            synchronized (this._started) {
                try {
                    if (this._started[0]) {
                        try {
                            this._started.wait(10000);
                        } catch (InterruptedException e2) {
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(13912);
                    throw th;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "  quit used:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + LocaleUtil.MALAY);
            }
            this.mMsgHandler = null;
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(13912);
        }

        public int sendMessage(int i2, HashMap<String, Object> hashMap) {
            AppMethodBeat.i(13913);
            if (this.mMsgHandler == null) {
                AudioDeviceInterface.LogTraceEntry(" fail mMsgHandler==null _enabled:" + (this._enabled ? "Y" : "N") + " activeMode:" + TraeAudioManager.this._activeMode + " msg:" + i2);
                AppMethodBeat.o(13913);
                return -1;
            }
            if (this.mMsgHandler.sendMessage(Message.obtain(this.mMsgHandler, i2, hashMap))) {
                AppMethodBeat.o(13913);
                return 0;
            }
            AppMethodBeat.o(13913);
            return -1;
        }

        /* access modifiers changed from: package-private */
        public void startService(HashMap<String, Object> hashMap) {
            AppMethodBeat.i(13914);
            String str = (String) hashMap.get(TraeAudioManager.EXTRA_DATA_DEVICECONFIG);
            AudioDeviceInterface.LogTraceEntry(" _enabled:" + (this._enabled ? "Y" : "N") + " activeMode:" + TraeAudioManager.this._activeMode + " cfg:" + str);
            if (TraeAudioManager.this._context == null) {
                AppMethodBeat.o(13914);
                return;
            }
            QLog.w("TRAE", 2, "   startService:".concat(String.valueOf(str)));
            if ((!this._enabled || !this._lastCfg.equals(str)) && TraeAudioManager.this._activeMode == 0) {
                if (this._enabled) {
                    stopService();
                }
                _prev_startService();
                TraeAudioManager.this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                if (TraeAudioManager.this._deviceConfigManager != null) {
                    TraeAudioManager.this._deviceConfigManager.clearConfig();
                    TraeAudioManager.this._deviceConfigManager.init(str);
                }
                this._lastCfg = str;
                if (TraeAudioManager.this._am != null) {
                    this._preServiceMode = TraeAudioManager.this._am.getMode();
                }
                this._enabled = true;
                if (this._ringPlayer == null) {
                    this._ringPlayer = new TraeMediaPlayer(TraeAudioManager.this._context, new TraeMediaPlayer.OnCompletionListener() {
                        /* class com.tencent.rtmp.sharp.jni.TraeAudioManager.TraeAudioManagerLooper.AnonymousClass1 */

                        @Override // com.tencent.rtmp.sharp.jni.TraeMediaPlayer.OnCompletionListener
                        public void onCompletion() {
                            AppMethodBeat.i(13892);
                            if (QLog.isColorLevel()) {
                                QLog.w("TRAE", 2, "_ringPlayer onCompletion _activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + TraeAudioManagerLooper.this._preRingMode);
                            }
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put(TraeAudioManager.PARAM_ISHOSTSIDE, Boolean.TRUE);
                            TraeAudioManagerLooper.this.sendMessage(TraeAudioManagerLooper.MESSAGE_STOPRING, hashMap);
                            TraeAudioManagerLooper.this.notifyRingCompletion();
                            AppMethodBeat.o(13892);
                        }
                    });
                }
                notifyServiceState(this._enabled);
                TraeAudioManager.this.updateDeviceStatus();
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(13914);
                return;
            }
            AppMethodBeat.o(13914);
        }

        /* access modifiers changed from: package-private */
        public boolean isNeedForceVolumeType() {
            AppMethodBeat.i(13915);
            if (Build.MANUFACTURER.equals("Xiaomi")) {
                if (Build.MODEL.equals("MI 5")) {
                    AppMethodBeat.o(13915);
                    return true;
                } else if (Build.MODEL.equals("MI 5s")) {
                    AppMethodBeat.o(13915);
                    return true;
                } else if (Build.MODEL.equals("MI 5s Plus")) {
                    AppMethodBeat.o(13915);
                    return true;
                }
            }
            AppMethodBeat.o(13915);
            return false;
        }

        /* access modifiers changed from: package-private */
        public void stopService() {
            AppMethodBeat.i(13916);
            AudioDeviceInterface.LogTraceEntry(" _enabled:" + (this._enabled ? "Y" : "N") + " activeMode:" + TraeAudioManager.this._activeMode);
            if (!this._enabled) {
                AppMethodBeat.o(13916);
                return;
            }
            if (TraeAudioManager.this._activeMode == 1) {
                interruptVoicecallPostprocess();
            } else if (TraeAudioManager.this._activeMode == 2) {
                interruptRing();
            }
            if (TraeAudioManager.this._switchThread != null) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "_switchThread:" + TraeAudioManager.this._switchThread.getDeviceName());
                }
                TraeAudioManager.this._switchThread.quit();
                TraeAudioManager.this._switchThread = null;
            }
            if (this._ringPlayer != null) {
                this._ringPlayer.stopRing();
            }
            this._ringPlayer = null;
            this._enabled = false;
            notifyServiceState(this._enabled);
            if (!(TraeAudioManager.this._am == null || TraeAudioManager.this._context == null)) {
                try {
                    TraeAudioManager.this.InternalSetMode(0);
                    if (isNeedForceVolumeType()) {
                        QLog.w("TRAE", 2, "NeedForceVolumeType: AudioManager.STREAM_MUSIC");
                        TraeAudioManager.forceVolumeControlStream(TraeAudioManager.this._am, 3);
                    }
                } catch (Exception e2) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, "set mode failed." + e2.getMessage());
                    }
                }
            }
            _post_stopService();
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(13916);
        }

        /* access modifiers changed from: package-private */
        public int notifyServiceState(boolean z) {
            AppMethodBeat.i(13917);
            if (TraeAudioManager.this._context == null) {
                AppMethodBeat.o(13917);
                return -1;
            }
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_SERVICE_STATE);
            intent.putExtra(TraeAudioManager.NOTIFY_SERVICE_STATE_DATE, z);
            if (TraeAudioManager.this._context != null) {
                TraeAudioManager.this._context.sendBroadcast(intent);
            }
            AppMethodBeat.o(13917);
            return 0;
        }

        public void run() {
            AppMethodBeat.i(13918);
            AudioDeviceInterface.LogTraceEntry("");
            Looper.prepare();
            this.mMsgHandler = new Handler() {
                /* class com.tencent.rtmp.sharp.jni.TraeAudioManager.TraeAudioManagerLooper.AnonymousClass2 */

                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.tencent.rtmp.sharp.jni.TraeAudioManager */
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.tencent.rtmp.sharp.jni.TraeAudioManager */
                /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.tencent.rtmp.sharp.jni.TraeAudioManager$TraeAudioManagerLooper */
                /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.tencent.rtmp.sharp.jni.TraeAudioManager$TraeAudioManagerLooper */
                /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.tencent.rtmp.sharp.jni.TraeAudioManager$TraeAudioManagerLooper */
                /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: com.tencent.rtmp.sharp.jni.TraeAudioManager$TraeAudioManagerLooper */
                /* JADX DEBUG: Multi-variable search result rejected for r1v14, resolved type: com.tencent.rtmp.sharp.jni.TraeAudioManager$TraeAudioManagerLooper */
                /* JADX DEBUG: Multi-variable search result rejected for r1v16, resolved type: com.tencent.rtmp.sharp.jni.TraeAudioManager */
                /* JADX DEBUG: Multi-variable search result rejected for r1v18, resolved type: com.tencent.rtmp.sharp.jni.TraeAudioManager */
                /* JADX DEBUG: Multi-variable search result rejected for r1v20, resolved type: com.tencent.rtmp.sharp.jni.TraeAudioManager */
                /* JADX DEBUG: Multi-variable search result rejected for r1v21, resolved type: com.tencent.rtmp.sharp.jni.TraeAudioManager$TraeAudioManagerLooper */
                /* JADX DEBUG: Multi-variable search result rejected for r2v44, resolved type: com.tencent.rtmp.sharp.jni.TraeAudioManager */
                /* JADX DEBUG: Multi-variable search result rejected for r1v25, resolved type: com.tencent.rtmp.sharp.jni.TraeAudioManager$TraeAudioManagerLooper */
                /* JADX WARN: Multi-variable type inference failed */
                public void handleMessage(Message message) {
                    HashMap hashMap;
                    AppMethodBeat.i(13790);
                    try {
                        hashMap = (HashMap) message.obj;
                    } catch (Exception e2) {
                        hashMap = null;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "TraeAudioManagerLooper msg:" + message.what + " _enabled:" + (TraeAudioManagerLooper.this._enabled ? "Y" : "N"));
                    }
                    if (message.what == 32772) {
                        TraeAudioManagerLooper.this.startService(hashMap);
                        AppMethodBeat.o(13790);
                    } else if (!TraeAudioManagerLooper.this._enabled) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "******* disabled ,skip msg******");
                        }
                        TraeAudioManager.this.sendResBroadcast(new Intent(), hashMap, 1);
                        AppMethodBeat.o(13790);
                    } else {
                        switch (message.what) {
                            case TraeAudioManagerLooper.MESSAGE_DISABLE /*{ENCODED_INT: 32773}*/:
                                TraeAudioManagerLooper.this.stopService();
                                AppMethodBeat.o(13790);
                                return;
                            case TraeAudioManagerLooper.MESSAGE_GETDEVICELIST /*{ENCODED_INT: 32774}*/:
                                TraeAudioManagerLooper.this.InternalSessionGetDeviceList(hashMap);
                                AppMethodBeat.o(13790);
                                return;
                            case TraeAudioManagerLooper.MESSAGE_CONNECTDEVICE /*{ENCODED_INT: 32775}*/:
                                TraeAudioManager.this.InternalSessionConnectDevice(hashMap);
                                AppMethodBeat.o(13790);
                                return;
                            case TraeAudioManagerLooper.MESSAGE_EARACTION /*{ENCODED_INT: 32776}*/:
                                TraeAudioManager.this.InternalSessionEarAction(hashMap);
                                AppMethodBeat.o(13790);
                                return;
                            case TraeAudioManagerLooper.MESSAGE_ISDEVICECHANGABLED /*{ENCODED_INT: 32777}*/:
                                TraeAudioManager.this.InternalSessionIsDeviceChangabled(hashMap);
                                AppMethodBeat.o(13790);
                                return;
                            case TraeAudioManagerLooper.MESSAGE_GETCONNECTEDDEVICE /*{ENCODED_INT: 32778}*/:
                                TraeAudioManager.this.InternalSessionGetConnectedDevice(hashMap);
                                AppMethodBeat.o(13790);
                                return;
                            case TraeAudioManagerLooper.MESSAGE_GETCONNECTINGDEVICE /*{ENCODED_INT: 32779}*/:
                                TraeAudioManager.this.InternalSessionGetConnectingDevice(hashMap);
                                AppMethodBeat.o(13790);
                                return;
                            case TraeAudioManagerLooper.MESSAGE_VOICECALLPREPROCESS /*{ENCODED_INT: 32780}*/:
                                TraeAudioManagerLooper.this.InternalVoicecallPreprocess(hashMap);
                                AppMethodBeat.o(13790);
                                return;
                            case TraeAudioManagerLooper.MESSAGE_VOICECALLPOSTPROCESS /*{ENCODED_INT: 32781}*/:
                                TraeAudioManagerLooper.this.InternalVoicecallPostprocess(hashMap);
                                AppMethodBeat.o(13790);
                                return;
                            case TraeAudioManagerLooper.MESSAGE_STARTRING /*{ENCODED_INT: 32782}*/:
                                TraeAudioManagerLooper.this.InternalStartRing(hashMap);
                                AppMethodBeat.o(13790);
                                return;
                            case TraeAudioManagerLooper.MESSAGE_STOPRING /*{ENCODED_INT: 32783}*/:
                                TraeAudioManagerLooper.this.InternalStopRing(hashMap);
                                AppMethodBeat.o(13790);
                                return;
                            case TraeAudioManagerLooper.MESSAGE_GETSTREAMTYPE /*{ENCODED_INT: 32784}*/:
                                TraeAudioManagerLooper.this.InternalGetStreamType(hashMap);
                                AppMethodBeat.o(13790);
                                return;
                            case TraeAudioManagerLooper.MESSAGE_AUTO_DEVICELIST_UPDATE /*{ENCODED_INT: 32785}*/:
                            case TraeAudioManagerLooper.MESSAGE_CONNECT_HIGHEST_PRIORITY_DEVICE /*{ENCODED_INT: 32789}*/:
                                String availabledHighestPriorityDevice = TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice();
                                String connectedDevice = TraeAudioManager.this._deviceConfigManager.getConnectedDevice();
                                if (QLog.isColorLevel()) {
                                    QLog.w("TRAE", 2, "MESSAGE_AUTO_DEVICELIST_UPDATE  connectedDev:" + connectedDevice + " highestDev" + availabledHighestPriorityDevice);
                                }
                                if (TraeAudioManager.IsUpdateSceneFlag) {
                                    if (!TraeAudioManager.IsMusicScene || TraeAudioManager.this.IsBluetoothA2dpExisted) {
                                        TraeAudioManager.this.InternalConnectDevice(availabledHighestPriorityDevice, null, true);
                                        AppMethodBeat.o(13790);
                                        return;
                                    }
                                    TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice(TraeAudioManager.DEVICE_BLUETOOTHHEADSET), null, true);
                                    AppMethodBeat.o(13790);
                                    return;
                                } else if (!availabledHighestPriorityDevice.equals(connectedDevice)) {
                                    TraeAudioManager.this.InternalConnectDevice(availabledHighestPriorityDevice, null, false);
                                    AppMethodBeat.o(13790);
                                    return;
                                } else {
                                    TraeAudioManager.this.InternalNotifyDeviceListUpdate();
                                    AppMethodBeat.o(13790);
                                    return;
                                }
                            case TraeAudioManagerLooper.MESSAGE_AUTO_DEVICELIST_PLUGIN_UPDATE /*{ENCODED_INT: 32786}*/:
                                String str = (String) hashMap.get(TraeAudioManager.PARAM_DEVICE);
                                if (TraeAudioManager.this.InternalConnectDevice(str, null, false) != 0) {
                                    if (QLog.isColorLevel()) {
                                        QLog.w("TRAE", 2, " plugin dev:" + str + " sessionConnectedDev:" + TraeAudioManager.this.sessionConnectedDev + " connected fail,auto switch!");
                                    }
                                    TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice(), null, false);
                                    AppMethodBeat.o(13790);
                                    return;
                                }
                                break;
                            case TraeAudioManagerLooper.MESSAGE_AUTO_DEVICELIST_PLUGOUT_UPDATE /*{ENCODED_INT: 32787}*/:
                                if (TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this.sessionConnectedDev, null, false) != 0) {
                                    String str2 = (String) hashMap.get(TraeAudioManager.PARAM_DEVICE);
                                    if (QLog.isColorLevel()) {
                                        QLog.w("TRAE", 2, " plugout dev:" + str2 + " sessionConnectedDev:" + TraeAudioManager.this.sessionConnectedDev + " connected fail,auto switch!");
                                    }
                                    TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice(), null, false);
                                    break;
                                }
                                break;
                            case TraeAudioManagerLooper.MESSAGE_VOICECALL_AUIDOPARAM_CHANGED /*{ENCODED_INT: 32788}*/:
                                Integer num = (Integer) hashMap.get(TraeAudioManager.PARAM_STREAMTYPE);
                                if (num != null) {
                                    TraeAudioManager.this._streamType = num.intValue();
                                    TraeAudioManagerLooper.this.InternalNotifyStreamTypeUpdate(num.intValue());
                                    AppMethodBeat.o(13790);
                                    return;
                                } else if (QLog.isColorLevel()) {
                                    QLog.e("TRAE", 2, " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!");
                                    AppMethodBeat.o(13790);
                                    return;
                                }
                                break;
                            case TraeAudioManagerLooper.MESSAGE_REQUEST_RELEASE_AUDIO_FOCUS /*{ENCODED_INT: 32790}*/:
                                TraeAudioManagerLooper.this.abandonAudioFocus();
                                AppMethodBeat.o(13790);
                                return;
                            case TraeAudioManagerLooper.MESSAGE_RECOVER_AUDIO_FOCUS /*{ENCODED_INT: 32791}*/:
                                AppMethodBeat.o(13790);
                                return;
                        }
                        AppMethodBeat.o(13790);
                    }
                }
            };
            _init();
            synchronized (this._started) {
                try {
                    this._started[0] = true;
                    this._started.notifyAll();
                } finally {
                    AppMethodBeat.o(13918);
                }
            }
            Looper.loop();
            _uninit();
            synchronized (this._started) {
                try {
                    this._started[0] = false;
                    this._started.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(13918);
        }

        /* access modifiers changed from: package-private */
        public void _init() {
            AppMethodBeat.i(13919);
            AudioDeviceInterface.LogTraceEntry("");
            if (TraeAudioManager.this._deviceConfigManager == null) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "_deviceConfigManager is null");
                }
                AppMethodBeat.o(13919);
                return;
            }
            try {
                TraeAudioManager._gHostProcessId = Process.myPid();
                TraeAudioManager.this._am = (AudioManager) TraeAudioManager.this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                TraeAudioManager.this._bluetoothCheck = TraeAudioManager.this.CreateBluetoothCheck(TraeAudioManager.this._context, TraeAudioManager.this._deviceConfigManager);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
                TraeAudioManager.this._bluetoothCheck.addAction(intentFilter);
                intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
                TraeAudioManager.this._context.registerReceiver(this._parent, intentFilter);
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "======7");
                }
            }
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(13919);
        }

        /* access modifiers changed from: package-private */
        public void _prev_startService() {
            AppMethodBeat.i(13920);
            if (TraeAudioManager.this._deviceConfigManager == null) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "_deviceConfigManager is null");
                }
                AppMethodBeat.o(13920);
                return;
            }
            try {
                TraeAudioManager.this._am = (AudioManager) TraeAudioManager.this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                if (TraeAudioManager.this._bluetoothCheck == null) {
                    TraeAudioManager.this._bluetoothCheck = TraeAudioManager.this.CreateBluetoothCheck(TraeAudioManager.this._context, TraeAudioManager.this._deviceConfigManager);
                }
                TraeAudioManager.this._context.unregisterReceiver(this._parent);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
                TraeAudioManager.this._bluetoothCheck.addAction(intentFilter);
                intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
                TraeAudioManager.this._context.registerReceiver(this._parent, intentFilter);
                AppMethodBeat.o(13920);
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "======7");
                }
                AppMethodBeat.o(13920);
            }
        }

        /* access modifiers changed from: package-private */
        public void _post_stopService() {
            AppMethodBeat.i(13921);
            if (TraeAudioManager.this._deviceConfigManager == null) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "_deviceConfigManager is null");
                }
                AppMethodBeat.o(13921);
                return;
            }
            try {
                if (TraeAudioManager.this._bluetoothCheck != null) {
                    TraeAudioManager.this._bluetoothCheck.release();
                }
                TraeAudioManager.this._bluetoothCheck = null;
                if (TraeAudioManager.this._context != null) {
                    TraeAudioManager.this._context.unregisterReceiver(this._parent);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
                    TraeAudioManager.this._context.registerReceiver(this._parent, intentFilter);
                }
                AppMethodBeat.o(13921);
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "stop service failed." + e2.getMessage());
                }
                AppMethodBeat.o(13921);
            }
        }

        /* access modifiers changed from: package-private */
        public void _uninit() {
            AppMethodBeat.i(13922);
            AudioDeviceInterface.LogTraceEntry("");
            try {
                stopService();
                if (TraeAudioManager.this._bluetoothCheck != null) {
                    TraeAudioManager.this._bluetoothCheck.release();
                }
                TraeAudioManager.this._bluetoothCheck = null;
                if (TraeAudioManager.this._context != null) {
                    TraeAudioManager.this._context.unregisterReceiver(this._parent);
                    TraeAudioManager.this._context = null;
                }
                if (TraeAudioManager.this._deviceConfigManager != null) {
                    TraeAudioManager.this._deviceConfigManager.clearConfig();
                }
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "uninit failed." + e2.getMessage());
                }
            }
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(13922);
        }

        /* access modifiers changed from: package-private */
        public int InternalSessionGetDeviceList(HashMap<String, Object> hashMap) {
            AppMethodBeat.i(13923);
            Intent intent = new Intent();
            HashMap<String, Object> snapParams = TraeAudioManager.this._deviceConfigManager.getSnapParams();
            intent.putExtra(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST, (String[]) ((ArrayList) snapParams.get(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST)).toArray(new String[0]));
            intent.putExtra(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE, (String) snapParams.get(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE));
            intent.putExtra(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE, (String) snapParams.get(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE));
            intent.putExtra(TraeAudioManager.EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME, TraeAudioManager.this._deviceConfigManager.getBluetoothName());
            TraeAudioManager.this.sendResBroadcast(intent, hashMap, 0);
            AppMethodBeat.o(13923);
            return 0;
        }

        /* access modifiers changed from: package-private */
        @TargetApi(8)
        public void abandonAudioFocus() {
            AppMethodBeat.i(13925);
            AppMethodBeat.o(13925);
        }

        /* access modifiers changed from: package-private */
        public int InternalVoicecallPreprocess(HashMap<String, Object> hashMap) {
            AppMethodBeat.i(13926);
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
            if (hashMap == null) {
                AppMethodBeat.o(13926);
                return -1;
            } else if (TraeAudioManager.this._deviceConfigManager == null) {
                AppMethodBeat.o(13926);
                return -1;
            } else if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " InternalVoicecallPreprocess am==null!!");
                }
                AppMethodBeat.o(13926);
                return -1;
            } else if (TraeAudioManager.this._activeMode == 1) {
                TraeAudioManager.this.sendResBroadcast(new Intent(), hashMap, 2);
                AppMethodBeat.o(13926);
                return -1;
            } else {
                this._voiceCallSessionID = ((Long) hashMap.get(TraeAudioManager.PARAM_SESSIONID)).longValue();
                this._voiceCallOperation = (String) hashMap.get(TraeAudioManager.PARAM_OPERATION);
                TraeAudioManager.this._activeMode = 1;
                TraeAudioManager.this._prevMode = TraeAudioManager.this._am.getMode();
                Integer.valueOf(-1);
                Integer.valueOf(0);
                Integer num = (Integer) hashMap.get(TraeAudioManager.PARAM_MODEPOLICY);
                if (num == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, " params.get(PARAM_MODEPOLICY)==null!!");
                    }
                    TraeAudioManager.this._modePolicy = -1;
                } else {
                    TraeAudioManager.this._modePolicy = num.intValue();
                }
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "  _modePolicy:" + TraeAudioManager.this._modePolicy);
                }
                Integer num2 = (Integer) hashMap.get(TraeAudioManager.PARAM_STREAMTYPE);
                if (num2 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, " params.get(PARAM_STREAMTYPE)==null!!");
                    }
                    TraeAudioManager.this._streamType = 0;
                } else {
                    TraeAudioManager.this._streamType = num2.intValue();
                }
                if (!TraeAudioManager.isCloseSystemAPM(TraeAudioManager.this._modePolicy) || TraeAudioManager.this._activeMode == 2 || TraeAudioManager.this._deviceConfigManager == null) {
                    TraeAudioManager.this.InternalSetMode(TraeAudioManager.getCallAudioMode(TraeAudioManager.this._modePolicy));
                } else if (TraeAudioManager.this._deviceConfigManager.getConnectedDevice().equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
                    TraeAudioManager.this.InternalSetMode(0);
                } else {
                    TraeAudioManager.this.InternalSetMode(3);
                }
                TraeAudioManager.this.sendResBroadcast(new Intent(), hashMap, 0);
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(13926);
                return 0;
            }
        }

        /* access modifiers changed from: package-private */
        public int InternalVoicecallPostprocess(HashMap<String, Object> hashMap) {
            AppMethodBeat.i(13927);
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
            if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " InternalVoicecallPostprocess am==null!!");
                }
                AppMethodBeat.o(13927);
                return -1;
            } else if (TraeAudioManager.this._activeMode != 1) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " not ACTIVE_VOICECALL!!");
                }
                TraeAudioManager.this.sendResBroadcast(new Intent(), hashMap, 3);
                AppMethodBeat.o(13927);
                return -1;
            } else {
                TraeAudioManager.this._activeMode = 0;
                abandonAudioFocus();
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(13927);
                return 0;
            }
        }

        /* access modifiers changed from: package-private */
        public int interruptVoicecallPostprocess() {
            AppMethodBeat.i(13928);
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
            if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " am==null!!");
                }
                AppMethodBeat.o(13928);
                return -1;
            } else if (TraeAudioManager.this._activeMode != 1) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " not ACTIVE_RING!!");
                }
                AppMethodBeat.o(13928);
                return -1;
            } else {
                TraeAudioManager.this._activeMode = 0;
                if (TraeAudioManager.this._prevMode != -1) {
                    TraeAudioManager.this.InternalSetMode(TraeAudioManager.this._prevMode);
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put(TraeAudioManager.PARAM_SESSIONID, Long.valueOf(this._voiceCallSessionID));
                hashMap.put(TraeAudioManager.PARAM_OPERATION, this._voiceCallOperation);
                TraeAudioManager.this.sendResBroadcast(new Intent(), hashMap, 6);
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(13928);
                return 0;
            }
        }

        /* access modifiers changed from: package-private */
        public int InternalStartRing(HashMap<String, Object> hashMap) {
            boolean z = true;
            AppMethodBeat.i(13929);
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
            if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " InternalStartRing am==null!!");
                }
                AppMethodBeat.o(13929);
                return -1;
            }
            if (TraeAudioManager.this._activeMode == 2) {
                interruptRing();
            }
            try {
                this._ringSessionID = ((Long) hashMap.get(TraeAudioManager.PARAM_SESSIONID)).longValue();
                this._ringOperation = (String) hashMap.get(TraeAudioManager.PARAM_OPERATION);
                this._ringUserdata = (String) hashMap.get(TraeAudioManager.PARAM_RING_USERDATA_STRING);
                int intValue = ((Integer) hashMap.get(TraeAudioManager.PARAM_RING_DATASOURCE)).intValue();
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "  dataSource:".concat(String.valueOf(intValue)));
                }
                int intValue2 = ((Integer) hashMap.get(TraeAudioManager.PARAM_RING_RSID)).intValue();
                Uri uri = (Uri) hashMap.get(TraeAudioManager.PARAM_RING_URI);
                String str = (String) hashMap.get(TraeAudioManager.PARAM_RING_FILEPATH);
                boolean booleanValue = ((Boolean) hashMap.get(TraeAudioManager.PARAM_RING_LOOP)).booleanValue();
                int intValue3 = ((Integer) hashMap.get(TraeAudioManager.PARAM_RING_LOOPCOUNT)).intValue();
                boolean booleanValue2 = ((Boolean) hashMap.get(TraeAudioManager.PARAM_RING_MODE)).booleanValue();
                if (TraeAudioManager.this._activeMode != 1) {
                    TraeAudioManager.this._activeMode = 2;
                }
                Intent intent = new Intent();
                intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, this._ringUserdata);
                TraeAudioManager.this.sendResBroadcast(intent, hashMap, 0);
                this._preRingMode = TraeAudioManager.this._am.getMode();
                TraeMediaPlayer traeMediaPlayer = this._ringPlayer;
                if (TraeAudioManager.this._activeMode != 1) {
                    z = false;
                }
                traeMediaPlayer.playRing(intValue, intValue2, uri, str, booleanValue, intValue3, booleanValue2, z, TraeAudioManager.this._streamType);
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " _ringUserdata:" + this._ringUserdata + " DurationMS:" + this._ringPlayer.getDuration());
                }
                InternalNotifyStreamTypeUpdate(this._ringPlayer.getStreamType());
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(13929);
                return 0;
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " startRing err params");
                }
                AppMethodBeat.o(13929);
                return -1;
            }
        }

        /* access modifiers changed from: package-private */
        public int InternalStopRing(HashMap<String, Object> hashMap) {
            AppMethodBeat.i(13930);
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this._preRingMode);
            if (TraeAudioManager.this._am == null || this._ringPlayer == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " InternalStopRing am==null!!");
                }
                AppMethodBeat.o(13930);
                return -1;
            }
            this._ringPlayer.stopRing();
            if (!this._ringPlayer.hasCall() && TraeAudioManager.this._activeMode == 2) {
                abandonAudioFocus();
                TraeAudioManager.this._activeMode = 0;
            }
            Intent intent = new Intent();
            intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, this._ringUserdata);
            TraeAudioManager.this.sendResBroadcast(intent, hashMap, 0);
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(13930);
            return 0;
        }

        /* access modifiers changed from: package-private */
        public int InternalGetStreamType(HashMap<String, Object> hashMap) {
            int i2;
            AppMethodBeat.i(13931);
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this._preRingMode);
            if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " InternalStopRing am==null!!");
                }
                AppMethodBeat.o(13931);
                return -1;
            }
            if (TraeAudioManager.this._activeMode == 2) {
                i2 = this._ringPlayer.getStreamType();
            } else {
                i2 = TraeAudioManager.this._streamType;
            }
            Intent intent = new Intent();
            intent.putExtra(TraeAudioManager.EXTRA_DATA_STREAMTYPE, i2);
            TraeAudioManager.this.sendResBroadcast(intent, hashMap, 0);
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(13931);
            return 0;
        }

        /* access modifiers changed from: package-private */
        public int InternalNotifyStreamTypeUpdate(final int i2) {
            AppMethodBeat.i(13932);
            if (TraeAudioManager.this._context == null) {
                AppMethodBeat.o(13932);
                return -1;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.rtmp.sharp.jni.TraeAudioManager.TraeAudioManagerLooper.AnonymousClass3 */

                public void run() {
                    AppMethodBeat.i(222659);
                    Intent intent = new Intent();
                    intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
                    intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_STREAMTYPE_UPDATE);
                    intent.putExtra(TraeAudioManager.EXTRA_DATA_STREAMTYPE, i2);
                    if (TraeAudioManager.this._context != null) {
                        TraeAudioManager.this._context.sendBroadcast(intent);
                    }
                    AppMethodBeat.o(222659);
                }
            });
            AppMethodBeat.o(13932);
            return 0;
        }

        /* access modifiers changed from: package-private */
        public int interruptRing() {
            AppMethodBeat.i(13933);
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this._preRingMode);
            if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " interruptRing am==null!!");
                }
                AppMethodBeat.o(13933);
                return -1;
            } else if (TraeAudioManager.this._activeMode != 2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " not ACTIVE_RING!!");
                }
                AppMethodBeat.o(13933);
                return -1;
            } else {
                this._ringPlayer.stopRing();
                abandonAudioFocus();
                TraeAudioManager.this._activeMode = 0;
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put(TraeAudioManager.PARAM_SESSIONID, Long.valueOf(this._ringSessionID));
                hashMap.put(TraeAudioManager.PARAM_OPERATION, this._ringOperation);
                Intent intent = new Intent();
                intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, this._ringUserdata);
                TraeAudioManager.this.sendResBroadcast(intent, hashMap, 4);
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(13933);
                return 0;
            }
        }

        /* access modifiers changed from: package-private */
        public void notifyRingCompletion() {
            AppMethodBeat.i(13934);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(TraeAudioManager.PARAM_SESSIONID, Long.valueOf(this._ringSessionID));
            hashMap.put(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_RING_COMPLETION);
            Intent intent = new Intent();
            intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, this._ringUserdata);
            TraeAudioManager.this.sendResBroadcast(intent, hashMap, 0);
            AppMethodBeat.o(13934);
        }
    }

    public static int SetSpeakerForTest(Context context, boolean z) {
        AppMethodBeat.i(13714);
        int i2 = -1;
        _glock.lock();
        if (_ginstance != null) {
            i2 = _ginstance.InternalSetSpeaker(context, z);
        } else if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "TraeAudioManager|static SetSpeakerForTest|null == _ginstance");
        }
        _glock.unlock();
        AppMethodBeat.o(13714);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public int InternalSetSpeaker(Context context, boolean z) {
        String str;
        AppMethodBeat.i(13715);
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "Could not InternalSetSpeaker - no context");
            }
            AppMethodBeat.o(13715);
            return -1;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (audioManager == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "Could not InternalSetSpeaker - no audio manager");
            }
            AppMethodBeat.o(13715);
            return -1;
        }
        if (QLog.isColorLevel()) {
            StringBuilder append = new StringBuilder("InternalSetSpeaker entry:speaker:").append(audioManager.isSpeakerphoneOn() ? "Y" : "N").append("-->:");
            if (z) {
                str = "Y";
            } else {
                str = "N";
            }
            QLog.w("TRAE", 2, append.append(str).toString());
        }
        if (!isCloseSystemAPM(this._modePolicy) || this._activeMode == 2) {
            if (audioManager.isSpeakerphoneOn() != z) {
                audioManager.setSpeakerphoneOn(z);
            }
            int i2 = audioManager.isSpeakerphoneOn() == z ? 0 : -1;
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "InternalSetSpeaker exit:" + z + " res:" + i2 + " mode:" + audioManager.getMode());
            }
            AppMethodBeat.o(13715);
            return i2;
        }
        int InternalSetSpeakerSpe = InternalSetSpeakerSpe(audioManager, z);
        AppMethodBeat.o(13715);
        return InternalSetSpeakerSpe;
    }

    /* access modifiers changed from: package-private */
    public int InternalSetSpeakerSpe(AudioManager audioManager, boolean z) {
        int i2 = 0;
        AppMethodBeat.i(13716);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InternalSetSpeakerSpe fac:" + Build.MANUFACTURER + " model:" + Build.MODEL + " st:" + this._streamType + " media_force_use:" + getForceUse(1));
        }
        if (z) {
            InternalSetMode(0);
            audioManager.setSpeakerphoneOn(true);
            setForceUse(1, 1);
        } else {
            InternalSetMode(3);
            audioManager.setSpeakerphoneOn(false);
            setForceUse(1, 0);
        }
        if (audioManager.isSpeakerphoneOn() != z) {
            i2 = -1;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InternalSetSpeakerSpe exit:" + z + " res:" + i2 + " mode:" + audioManager.getMode());
        }
        AppMethodBeat.o(13716);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void InternalSetMode(int i2) {
        AppMethodBeat.i(13717);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "SetMode entry:".concat(String.valueOf(i2)));
        }
        if (this._am == null) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "setMode:" + i2 + " fail am=null");
            }
            AppMethodBeat.o(13717);
            return;
        }
        this._am.setMode(i2);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "setMode:" + i2 + (this._am.getMode() != i2 ? "fail" : "success"));
        }
        AppMethodBeat.o(13717);
    }

    public static int registerAudioSession(TraeAudioSession traeAudioSession, boolean z, long j2, Context context) {
        AppMethodBeat.i(13718);
        int i2 = -1;
        _glock.lock();
        if (_ginstance != null) {
            if (z) {
                if (_ginstance._audioSessionHost != null) {
                    _ginstance._audioSessionHost.add(traeAudioSession, j2, context);
                    if (QLog.isColorLevel()) {
                        QLog.d("TRAE", 2, "[register] add AudioSession: ".concat(String.valueOf(j2)));
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("TRAE", 2, "_ginstance._audioSessionHost is null");
                }
            } else if (_ginstance._audioSessionHost != null) {
                _ginstance._audioSessionHost.remove(j2);
                if (QLog.isColorLevel()) {
                    QLog.d("TRAE", 2, "[register] remove AudioSession: ".concat(String.valueOf(j2)));
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("TRAE", 2, "_ginstance._audioSessionHost is null");
            }
            i2 = 0;
        }
        _glock.unlock();
        AppMethodBeat.o(13718);
        return i2;
    }

    public static int sendMessage(int i2, HashMap<String, Object> hashMap) {
        AppMethodBeat.i(13719);
        int i3 = -1;
        _glock.lock();
        if (_ginstance != null) {
            i3 = _ginstance.internalSendMessage(i2, hashMap);
        }
        _glock.unlock();
        AppMethodBeat.o(13719);
        return i3;
    }

    public static int init(Context context) {
        AppMethodBeat.i(13720);
        new StringBuilder("TraeAudioManager init _ginstance:").append(_ginstance);
        AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
        _glock.lock();
        if (_ginstance == null) {
            _ginstance = new TraeAudioManager(context);
        }
        _glock.unlock();
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13720);
        return 0;
    }

    public static void uninit() {
        AppMethodBeat.i(13721);
        new StringBuilder("TraeAudioManager uninit _ginstance:").append(_ginstance);
        AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
        _glock.lock();
        if (_ginstance != null) {
            _ginstance.release();
            _ginstance = null;
        }
        _glock.unlock();
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13721);
    }

    TraeAudioManager(Context context) {
        AppMethodBeat.i(13722);
        AudioDeviceInterface.LogTraceEntry(" context:".concat(String.valueOf(context)));
        if (context == null) {
            AppMethodBeat.o(13722);
            return;
        }
        this._context = context;
        this.mTraeAudioManagerLooper = new TraeAudioManagerLooper(this);
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13722);
    }

    public void release() {
        AppMethodBeat.i(13723);
        AudioDeviceInterface.LogTraceEntry("");
        if (this.mTraeAudioManagerLooper != null) {
            this.mTraeAudioManagerLooper.quit();
            this.mTraeAudioManagerLooper = null;
        }
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13723);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(13724);
        if (intent == null || context == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TRAE", 2, "onReceive intent or context is null!");
            }
            AppMethodBeat.o(13724);
            return;
        }
        try {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra(PARAM_OPERATION);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "TraeAudioManager|onReceive::Action:" + intent.getAction());
            }
            if (this._deviceConfigManager == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TRAE", 2, "_deviceConfigManager null!");
                }
                AppMethodBeat.o(13724);
                return;
            }
            boolean visible = this._deviceConfigManager.getVisible(DEVICE_WIREDHEADSET);
            boolean visible2 = this._deviceConfigManager.getVisible(DEVICE_BLUETOOTHHEADSET);
            if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                onHeadsetPlug(context, intent);
                if (!visible && this._deviceConfigManager.getVisible(DEVICE_WIREDHEADSET)) {
                    checkDevicePlug(DEVICE_WIREDHEADSET, true);
                }
                if (visible && !this._deviceConfigManager.getVisible(DEVICE_WIREDHEADSET)) {
                    checkDevicePlug(DEVICE_WIREDHEADSET, false);
                    AppMethodBeat.o(13724);
                    return;
                }
            } else if (!"android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                if (ACTION_TRAEAUDIOMANAGER_REQUEST.equals(action)) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "   OPERATION:".concat(String.valueOf(stringExtra)));
                    }
                    if (OPERATION_STARTSERVICE.equals(stringExtra)) {
                        startService(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent.getStringExtra(EXTRA_DATA_DEVICECONFIG));
                        AppMethodBeat.o(13724);
                        return;
                    } else if (OPERATION_STOPSERVICE.equals(stringExtra)) {
                        stopService(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(13724);
                        return;
                    } else if (OPERATION_GETDEVICELIST.equals(stringExtra)) {
                        getDeviceList(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(13724);
                        return;
                    } else if (OPERATION_GETSTREAMTYPE.equals(stringExtra)) {
                        getStreamType(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(13724);
                        return;
                    } else if (OPERATION_CONNECTDEVICE.equals(stringExtra)) {
                        connectDevice(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent.getStringExtra(CONNECTDEVICE_DEVICENAME));
                        AppMethodBeat.o(13724);
                        return;
                    } else if (OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE.equals(stringExtra)) {
                        connectHighestPriorityDevice(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(13724);
                        return;
                    } else if (OPERATION_EARACTION.equals(stringExtra)) {
                        earAction(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent.getIntExtra(EXTRA_EARACTION, -1));
                        AppMethodBeat.o(13724);
                        return;
                    } else if (OPERATION_ISDEVICECHANGABLED.equals(stringExtra)) {
                        isDeviceChangabled(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(13724);
                        return;
                    } else if (OPERATION_GETCONNECTEDDEVICE.equals(stringExtra)) {
                        getConnectedDevice(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(13724);
                        return;
                    } else if (OPERATION_GETCONNECTINGDEVICE.equals(stringExtra)) {
                        getConnectingDevice(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(13724);
                        return;
                    } else if (OPERATION_VOICECALL_PREPROCESS.equals(stringExtra)) {
                        voicecallPreprocess(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent.getIntExtra(PARAM_MODEPOLICY, -1), intent.getIntExtra(PARAM_STREAMTYPE, -1));
                        AppMethodBeat.o(13724);
                        return;
                    } else if (OPERATION_VOICECALL_POSTPROCESS.equals(stringExtra)) {
                        voicecallPostprocess(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(13724);
                        return;
                    } else if (OPERATION_VOICECALL_AUDIOPARAM_CHANGED.equals(stringExtra)) {
                        voiceCallAudioParamChanged(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent.getIntExtra(PARAM_MODEPOLICY, -1), intent.getIntExtra(PARAM_STREAMTYPE, -1));
                        AppMethodBeat.o(13724);
                        return;
                    } else if (OPERATION_STARTRING.equals(stringExtra)) {
                        String stringExtra2 = intent.getStringExtra(PARAM_RING_FILEPATH);
                        boolean booleanExtra = intent.getBooleanExtra(PARAM_RING_LOOP, false);
                        String stringExtra3 = intent.getStringExtra(PARAM_RING_USERDATA_STRING);
                        int intExtra = intent.getIntExtra(PARAM_RING_LOOPCOUNT, 1);
                        boolean booleanExtra2 = intent.getBooleanExtra(PARAM_RING_MODE, false);
                        startRing(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent.getIntExtra(PARAM_RING_DATASOURCE, -1), intent.getIntExtra(PARAM_RING_RSID, -1), (Uri) intent.getParcelableExtra(PARAM_RING_URI), stringExtra2, booleanExtra, intExtra, stringExtra3, booleanExtra2);
                        AppMethodBeat.o(13724);
                        return;
                    } else if (OPERATION_STOPRING.equals(stringExtra)) {
                        stopRing(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(13724);
                        return;
                    }
                } else if (this._deviceConfigManager != null) {
                    if (this._bluetoothCheck != null) {
                        this._bluetoothCheck.onReceive(context, intent, this._deviceConfigManager);
                    }
                    if (!visible2 && this._deviceConfigManager.getVisible(DEVICE_BLUETOOTHHEADSET)) {
                        checkDevicePlug(DEVICE_BLUETOOTHHEADSET, true);
                    }
                    if (visible2 && !this._deviceConfigManager.getVisible(DEVICE_BLUETOOTHHEADSET)) {
                        checkDevicePlug(DEVICE_BLUETOOTHHEADSET, false);
                    }
                }
            }
            AppMethodBeat.o(13724);
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "deal with receiver failed." + e2.getMessage());
            }
            AppMethodBeat.o(13724);
        }
    }

    /* access modifiers changed from: package-private */
    public void onHeadsetPlug(Context context, Intent intent) {
        AppMethodBeat.i(13725);
        String stringExtra = intent.getStringExtra("name");
        if (stringExtra == null) {
            stringExtra = "unkonw";
        }
        String str = "" + " [" + stringExtra + "] ";
        int intExtra = intent.getIntExtra("state", -1);
        if (intExtra != -1) {
            str = str + (intExtra == 0 ? "unplugged" : "plugged");
        }
        String str2 = str + " mic:";
        int intExtra2 = intent.getIntExtra("microphone", -1);
        if (intExtra2 != -1) {
            str2 = str2 + (intExtra2 == 1 ? "Y" : "unkown");
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "onHeadsetPlug:: ".concat(String.valueOf(str2)));
        }
        if (this._deviceConfigManager != null) {
            this._deviceConfigManager.setVisible(DEVICE_WIREDHEADSET, 1 == intExtra);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "onHeadsetPlug exit");
        }
        AppMethodBeat.o(13725);
    }

    /* access modifiers changed from: package-private */
    public int internalSendMessage(int i2, HashMap<String, Object> hashMap) {
        AppMethodBeat.i(13726);
        int i3 = -1;
        if (this.mTraeAudioManagerLooper != null) {
            i3 = this.mTraeAudioManagerLooper.sendMessage(i2, hashMap);
        }
        AppMethodBeat.o(13726);
        return i3;
    }

    static int getDeviceList(String str, long j2, boolean z) {
        AppMethodBeat.i(13727);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_GETDEVICELIST, hashMap);
        AppMethodBeat.o(13727);
        return sendMessage;
    }

    static int getStreamType(String str, long j2, boolean z) {
        AppMethodBeat.i(13728);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_GETSTREAMTYPE, hashMap);
        AppMethodBeat.o(13728);
        return sendMessage;
    }

    static int startService(String str, long j2, boolean z, String str2) {
        AppMethodBeat.i(13729);
        if (str2.length() <= 0) {
            AppMethodBeat.o(13729);
            return -1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(EXTRA_DATA_DEVICECONFIG, str2);
        int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_ENABLE, hashMap);
        AppMethodBeat.o(13729);
        return sendMessage;
    }

    static int stopService(String str, long j2, boolean z) {
        AppMethodBeat.i(13730);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_DISABLE, hashMap);
        AppMethodBeat.o(13730);
        return sendMessage;
    }

    static int disableDeviceSwitch() {
        enableDeviceSwitchFlag = false;
        return 0;
    }

    static int connectDevice(String str, long j2, boolean z, String str2) {
        AppMethodBeat.i(13731);
        if (str2 == null) {
            AppMethodBeat.o(13731);
            return -1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(CONNECTDEVICE_DEVICENAME, str2);
        hashMap.put(PARAM_DEVICE, str2);
        int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_CONNECTDEVICE, hashMap);
        AppMethodBeat.o(13731);
        return sendMessage;
    }

    static int connectHighestPriorityDevice(String str, long j2, boolean z) {
        AppMethodBeat.i(13732);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_CONNECT_HIGHEST_PRIORITY_DEVICE, hashMap);
        AppMethodBeat.o(13732);
        return sendMessage;
    }

    static int earAction(String str, long j2, boolean z, int i2) {
        AppMethodBeat.i(13733);
        if (i2 == 0 || i2 == 1) {
            HashMap hashMap = new HashMap();
            hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
            hashMap.put(PARAM_OPERATION, str);
            hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
            hashMap.put(EXTRA_EARACTION, Integer.valueOf(i2));
            int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_EARACTION, hashMap);
            AppMethodBeat.o(13733);
            return sendMessage;
        }
        AppMethodBeat.o(13733);
        return -1;
    }

    static int isDeviceChangabled(String str, long j2, boolean z) {
        AppMethodBeat.i(13734);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_ISDEVICECHANGABLED, hashMap);
        AppMethodBeat.o(13734);
        return sendMessage;
    }

    static int getConnectedDevice(String str, long j2, boolean z) {
        AppMethodBeat.i(13735);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_GETCONNECTEDDEVICE, hashMap);
        AppMethodBeat.o(13735);
        return sendMessage;
    }

    static int getConnectingDevice(String str, long j2, boolean z) {
        AppMethodBeat.i(13736);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_GETCONNECTINGDEVICE, hashMap);
        AppMethodBeat.o(13736);
        return sendMessage;
    }

    static int voicecallPreprocess(String str, long j2, boolean z, int i2, int i3) {
        AppMethodBeat.i(13737);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(PARAM_MODEPOLICY, Integer.valueOf(i2));
        hashMap.put(PARAM_STREAMTYPE, Integer.valueOf(i3));
        int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_VOICECALLPREPROCESS, hashMap);
        AppMethodBeat.o(13737);
        return sendMessage;
    }

    static int voicecallPostprocess(String str, long j2, boolean z) {
        AppMethodBeat.i(13738);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_VOICECALLPOSTPROCESS, hashMap);
        AppMethodBeat.o(13738);
        return sendMessage;
    }

    static int voiceCallAudioParamChanged(String str, long j2, boolean z, int i2, int i3) {
        AppMethodBeat.i(13739);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(PARAM_MODEPOLICY, Integer.valueOf(i2));
        hashMap.put(PARAM_STREAMTYPE, Integer.valueOf(i3));
        int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_VOICECALL_AUIDOPARAM_CHANGED, hashMap);
        AppMethodBeat.o(13739);
        return sendMessage;
    }

    static int startRing(String str, long j2, boolean z, int i2, int i3, Uri uri, String str2, boolean z2, int i4, String str3, boolean z3) {
        AppMethodBeat.i(13740);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(PARAM_RING_DATASOURCE, Integer.valueOf(i2));
        hashMap.put(PARAM_RING_RSID, Integer.valueOf(i3));
        hashMap.put(PARAM_RING_URI, uri);
        hashMap.put(PARAM_RING_FILEPATH, str2);
        hashMap.put(PARAM_RING_LOOP, Boolean.valueOf(z2));
        hashMap.put(PARAM_RING_LOOPCOUNT, Integer.valueOf(i4));
        hashMap.put(PARAM_RING_MODE, Boolean.valueOf(z3));
        hashMap.put(PARAM_RING_USERDATA_STRING, str3);
        int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_STARTRING, hashMap);
        AppMethodBeat.o(13740);
        return sendMessage;
    }

    static int stopRing(String str, long j2, boolean z) {
        AppMethodBeat.i(13741);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_STOPRING, hashMap);
        AppMethodBeat.o(13741);
        return sendMessage;
    }

    static int requestReleaseAudioFocus(String str, long j2, boolean z) {
        AppMethodBeat.i(13742);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_REQUEST_RELEASE_AUDIO_FOCUS, hashMap);
        AppMethodBeat.o(13742);
        return sendMessage;
    }

    static int recoverAudioFocus(String str, long j2, boolean z) {
        AppMethodBeat.i(13743);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(TraeAudioManagerLooper.MESSAGE_RECOVER_AUDIO_FOCUS, hashMap);
        AppMethodBeat.o(13743);
        return sendMessage;
    }

    /* access modifiers changed from: package-private */
    public int InternalSessionConnectDevice(HashMap<String, Object> hashMap) {
        int i2;
        AppMethodBeat.i(13744);
        AudioDeviceInterface.LogTraceEntry("");
        if (hashMap == null || this._context == null) {
            AppMethodBeat.o(13744);
            return -1;
        } else if (IsMusicScene) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "MusicScene: InternalSessionConnectDevice failed");
            }
            AppMethodBeat.o(13744);
            return -1;
        } else {
            String str = (String) hashMap.get(PARAM_DEVICE);
            if (IsEarPhoneSupported || !str.equals(DEVICE_EARPHONE)) {
                boolean InternalIsDeviceChangeable = InternalIsDeviceChangeable();
                if (!checkDevName(str)) {
                    i2 = 7;
                } else if (!this._deviceConfigManager.getVisible(str)) {
                    i2 = 8;
                } else if (!InternalIsDeviceChangeable) {
                    i2 = 9;
                } else {
                    i2 = 0;
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "sessonID:" + ((Long) hashMap.get(PARAM_SESSIONID)) + " devName:" + str + " bChangabled:" + (InternalIsDeviceChangeable ? "Y" : "N") + " err:" + i2);
                }
                if (i2 != 0) {
                    Intent intent = new Intent();
                    intent.putExtra(CONNECTDEVICE_RESULT_DEVICENAME, (String) hashMap.get(PARAM_DEVICE));
                    sendResBroadcast(intent, hashMap, i2);
                    AppMethodBeat.o(13744);
                    return -1;
                } else if (str.equals(this._deviceConfigManager.getConnectedDevice())) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, " --has connected!");
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra(CONNECTDEVICE_RESULT_DEVICENAME, (String) hashMap.get(PARAM_DEVICE));
                    sendResBroadcast(intent2, hashMap, i2);
                    AppMethodBeat.o(13744);
                    return 0;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, " --connecting...");
                    }
                    InternalConnectDevice(str, hashMap, false);
                    AudioDeviceInterface.LogTraceExit();
                    AppMethodBeat.o(13744);
                    return 0;
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "InternalSessionConnectDevice IsEarPhoneSupported = false, Connect device:" + str + " failed");
                }
                AppMethodBeat.o(13744);
                return -1;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int InternalSessionEarAction(HashMap<String, Object> hashMap) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int InternalConnectDevice(String str, HashMap<String, Object> hashMap, boolean z) {
        AppMethodBeat.i(13745);
        AudioDeviceInterface.LogTraceEntry(" devName:".concat(String.valueOf(str)));
        if (str == null) {
            AppMethodBeat.o(13745);
            return -1;
        } else if (IsMusicScene && str.equals(DEVICE_EARPHONE)) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "MusicScene, Connect device:" + str + " failed");
            }
            AppMethodBeat.o(13745);
            return -1;
        } else if (!IsEarPhoneSupported && str.equals(DEVICE_EARPHONE)) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "IsEarPhoneSupported = false, Connect device:" + str + " failed");
            }
            AppMethodBeat.o(13745);
            return -1;
        } else if (!z && !this._deviceConfigManager.getConnectedDevice().equals(DEVICE_NONE) && str.equals(this._deviceConfigManager.getConnectedDevice())) {
            AppMethodBeat.o(13745);
            return 0;
        } else if (!checkDevName(str) || !this._deviceConfigManager.getVisible(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, " checkDevName fail");
            }
            AppMethodBeat.o(13745);
            return -1;
        } else if (!InternalIsDeviceChangeable()) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, " InternalIsDeviceChangeable fail");
            }
            AppMethodBeat.o(13745);
            return -1;
        } else {
            if (this._switchThread != null) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "_switchThread:" + this._switchThread.getDeviceName());
                }
                this._switchThread.quit();
                this._switchThread = null;
            }
            if (str.equals(DEVICE_EARPHONE)) {
                this._switchThread = new earphoneSwitchThread();
            } else if (str.equals(DEVICE_SPEAKERPHONE)) {
                this._switchThread = new speakerSwitchThread();
            } else if (str.equals(DEVICE_WIREDHEADSET)) {
                this._switchThread = new headsetSwitchThread();
            } else if (str.equals(DEVICE_BLUETOOTHHEADSET)) {
                this._switchThread = new bluetoothHeadsetSwitchThread();
            }
            if (this._switchThread != null) {
                this._switchThread.setDeviceConnectParam(hashMap);
                this._switchThread.start();
            }
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(13745);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract class switchThread extends Thread {
        boolean[] _exited = {false};
        HashMap<String, Object> _params = null;
        boolean _running = true;
        long _usingtime = 0;

        public abstract void _quit();

        public abstract void _run();

        public abstract String getDeviceName();

        switchThread() {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " ++switchThread:" + getDeviceName());
            }
        }

        public void setDeviceConnectParam(HashMap<String, Object> hashMap) {
            this._params = hashMap;
        }

        /* access modifiers changed from: package-private */
        public void updateStatus() {
            TraeAudioManager.this._deviceConfigManager.setConnected(getDeviceName());
            processDeviceConnectRes(0);
        }

        /* access modifiers changed from: package-private */
        public void processDeviceConnectRes(int i2) {
            TraeAudioManager.this.InternalNotifyDeviceChangableUpdate();
            AudioDeviceInterface.LogTraceEntry(getDeviceName() + " err:" + i2);
            if (this._params == null) {
                TraeAudioManager.this.InternalNotifyDeviceListUpdate();
                return;
            }
            TraeAudioManager.this.sessionConnectedDev = TraeAudioManager.this._deviceConfigManager.getConnectedDevice();
            Long l = (Long) this._params.get(TraeAudioManager.PARAM_SESSIONID);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " sessonID:".concat(String.valueOf(l)));
            }
            if (l == null || l.longValue() == Long.MIN_VALUE) {
                TraeAudioManager.this.InternalNotifyDeviceListUpdate();
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "processDeviceConnectRes sid null,don't send res");
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(TraeAudioManager.CONNECTDEVICE_RESULT_DEVICENAME, (String) this._params.get(TraeAudioManager.PARAM_DEVICE));
            if (TraeAudioManager.this.sendResBroadcast(intent, this._params, i2) == 0) {
                TraeAudioManager.this.InternalNotifyDeviceListUpdate();
            }
            AudioDeviceInterface.LogTraceExit();
        }

        public void run() {
            AudioDeviceInterface.LogTraceEntry(getDeviceName());
            TraeAudioManager.this._deviceConfigManager.setConnecting(getDeviceName());
            TraeAudioManager.this.InternalNotifyDeviceChangableUpdate();
            _run();
            synchronized (this._exited) {
                this._exited[0] = true;
                this._exited.notifyAll();
            }
            AudioDeviceInterface.LogTraceExit();
        }

        public void quit() {
            AudioDeviceInterface.LogTraceEntry(getDeviceName());
            this._running = false;
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " quit:" + getDeviceName() + " _running:" + this._running);
            }
            interrupt();
            _quit();
            synchronized (this._exited) {
                if (!this._exited[0]) {
                    try {
                        this._exited.wait(10000);
                    } catch (InterruptedException e2) {
                    }
                }
            }
            AudioDeviceInterface.LogTraceExit();
        }
    }

    /* access modifiers changed from: package-private */
    public class earphoneSwitchThread extends switchThread {
        earphoneSwitchThread() {
            super();
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.switchThread
        public void _run() {
            AppMethodBeat.i(13634);
            if (TraeAudioManager.IsUpdateSceneFlag && TraeAudioManager.enableDeviceSwitchFlag) {
                TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, false);
            }
            updateStatus();
            if (!TraeAudioManager.IsUpdateSceneFlag) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "connect earphone: do nothing");
                }
                AppMethodBeat.o(13634);
            } else if (!TraeAudioManager.enableDeviceSwitchFlag) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "connect earphone: disableDeviceSwitchFlag");
                }
                AppMethodBeat.o(13634);
            } else {
                int i2 = 0;
                while (this._running) {
                    if (TraeAudioManager.this._am.isSpeakerphoneOn()) {
                        TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, false);
                    }
                    try {
                        Thread.sleep(i2 < 5 ? 1000 : 4000);
                    } catch (InterruptedException e2) {
                    }
                    i2++;
                }
                AppMethodBeat.o(13634);
            }
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.switchThread
        public String getDeviceName() {
            return TraeAudioManager.DEVICE_EARPHONE;
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.switchThread
        public void _quit() {
        }
    }

    /* access modifiers changed from: package-private */
    public class speakerSwitchThread extends switchThread {
        speakerSwitchThread() {
            super();
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.switchThread
        public void _run() {
            AppMethodBeat.i(13649);
            int i2 = 0;
            if (!TraeAudioManager.IsMusicScene && TraeAudioManager.IsUpdateSceneFlag && TraeAudioManager.enableDeviceSwitchFlag) {
                TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, true);
            }
            updateStatus();
            if (TraeAudioManager.IsMusicScene || !TraeAudioManager.IsUpdateSceneFlag) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "connect speakerPhone: do nothing");
                }
                AppMethodBeat.o(13649);
            } else if (!TraeAudioManager.enableDeviceSwitchFlag) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "connect speakerPhone: disableDeviceSwitchFlag");
                }
                AppMethodBeat.o(13649);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " _run:" + getDeviceName() + " _running:" + this._running);
                }
                while (this._running) {
                    if (!TraeAudioManager.this._am.isSpeakerphoneOn()) {
                        TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, true);
                    }
                    try {
                        Thread.sleep(i2 < 5 ? 1000 : 4000);
                    } catch (InterruptedException e2) {
                    }
                    i2++;
                }
                AppMethodBeat.o(13649);
            }
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.switchThread
        public String getDeviceName() {
            return TraeAudioManager.DEVICE_SPEAKERPHONE;
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.switchThread
        public void _quit() {
        }
    }

    /* access modifiers changed from: package-private */
    public class headsetSwitchThread extends switchThread {
        headsetSwitchThread() {
            super();
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.switchThread
        public void _run() {
            AppMethodBeat.i(13903);
            if (!TraeAudioManager.IsMusicScene && TraeAudioManager.IsUpdateSceneFlag && TraeAudioManager.enableDeviceSwitchFlag) {
                TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, false);
                TraeAudioManager.this._am.setWiredHeadsetOn(true);
            }
            updateStatus();
            if (TraeAudioManager.IsMusicScene || !TraeAudioManager.IsUpdateSceneFlag) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "connect headset: do nothing");
                }
                AppMethodBeat.o(13903);
            } else if (!TraeAudioManager.enableDeviceSwitchFlag) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "connect headset: disableDeviceSwitchFlag");
                }
                AppMethodBeat.o(13903);
            } else {
                int i2 = 0;
                while (this._running) {
                    if (TraeAudioManager.this._am.isSpeakerphoneOn()) {
                        TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, false);
                    }
                    try {
                        Thread.sleep(i2 < 5 ? 1000 : 4000);
                    } catch (InterruptedException e2) {
                    }
                    i2++;
                }
                AppMethodBeat.o(13903);
            }
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.switchThread
        public String getDeviceName() {
            return TraeAudioManager.DEVICE_WIREDHEADSET;
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.switchThread
        public void _quit() {
        }
    }

    /* access modifiers changed from: package-private */
    public class bluetoothHeadsetSwitchThread extends switchThread {
        bluetoothHeadsetSwitchThread() {
            super();
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.switchThread
        public void _run() {
            AppMethodBeat.i(13689);
            if (TraeAudioManager.IsMusicScene || !TraeAudioManager.IsUpdateSceneFlag) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "connect bluetoothHeadset: do nothing, IsMusicScene:" + TraeAudioManager.IsMusicScene + " ,IsUpdateSceneFlag:" + TraeAudioManager.IsUpdateSceneFlag);
                }
                updateStatus();
                AppMethodBeat.o(13689);
            } else if (!TraeAudioManager.enableDeviceSwitchFlag) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "connect bluetoothHeadset: disableDeviceSwitchFlag");
                }
                AppMethodBeat.o(13689);
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e2) {
                }
                _startBluetoothSco();
                int i2 = 0;
                while (true) {
                    if (!this._running) {
                        break;
                    }
                    int i3 = i2 + 1;
                    if (i2 >= 10) {
                        break;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread i:" + i3 + " sco:" + (TraeAudioManager.this._am.isBluetoothScoOn() ? "Y" : "N") + " :" + TraeAudioManager.this._deviceConfigManager.getBluetoothName());
                    }
                    if (TraeAudioManager.this._am.isBluetoothScoOn()) {
                        updateStatus();
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                        i2 = i3;
                    } catch (InterruptedException e3) {
                        i2 = i3;
                    }
                }
                if (!TraeAudioManager.this._am.isBluetoothScoOn()) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, "bluetoothHeadsetSwitchThread sco fail,remove btheadset");
                    }
                    TraeAudioManager.this._deviceConfigManager.setVisible(getDeviceName(), false);
                    processDeviceConnectRes(10);
                    TraeAudioManager.this.checkAutoDeviceListUpdate();
                }
                AppMethodBeat.o(13689);
            }
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.switchThread
        public String getDeviceName() {
            return TraeAudioManager.DEVICE_BLUETOOTHHEADSET;
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.switchThread
        @TargetApi(8)
        public void _quit() {
            AppMethodBeat.i(13690);
            if (TraeAudioManager.this._am == null) {
                AppMethodBeat.o(13690);
                return;
            }
            _stopBluetoothSco();
            AppMethodBeat.o(13690);
        }

        /* access modifiers changed from: package-private */
        @TargetApi(8)
        public void _startBluetoothSco() {
            AppMethodBeat.i(13691);
            TraeAudioManager.this._am.setBluetoothScoOn(true);
            if (Build.VERSION.SDK_INT > 8) {
                TraeAudioManager.this._am.startBluetoothSco();
            }
            AppMethodBeat.o(13691);
        }

        /* access modifiers changed from: package-private */
        @TargetApi(8)
        public void _stopBluetoothSco() {
            AppMethodBeat.i(13692);
            if (Build.VERSION.SDK_INT > 8) {
                TraeAudioManager.this._am.stopBluetoothSco();
            }
            TraeAudioManager.this._am.setBluetoothScoOn(false);
            AppMethodBeat.o(13692);
        }
    }

    /* access modifiers changed from: package-private */
    public int InternalSessionIsDeviceChangabled(HashMap<String, Object> hashMap) {
        AppMethodBeat.i(13746);
        Intent intent = new Intent();
        intent.putExtra(ISDEVICECHANGABLED_RESULT_ISCHANGABLED, InternalIsDeviceChangeable());
        sendResBroadcast(intent, hashMap, 0);
        AppMethodBeat.o(13746);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean InternalIsDeviceChangeable() {
        AppMethodBeat.i(13747);
        String connectingDevice = this._deviceConfigManager.getConnectingDevice();
        if (connectingDevice == null || connectingDevice.equals(DEVICE_NONE) || connectingDevice.equals("")) {
            AppMethodBeat.o(13747);
            return true;
        }
        AppMethodBeat.o(13747);
        return false;
    }

    /* access modifiers changed from: package-private */
    public int InternalSessionGetConnectedDevice(HashMap<String, Object> hashMap) {
        AppMethodBeat.i(13748);
        Intent intent = new Intent();
        intent.putExtra(GETCONNECTEDDEVICE_RESULT_LIST, this._deviceConfigManager.getConnectedDevice());
        sendResBroadcast(intent, hashMap, 0);
        AppMethodBeat.o(13748);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int InternalSessionGetConnectingDevice(HashMap<String, Object> hashMap) {
        AppMethodBeat.i(13749);
        Intent intent = new Intent();
        intent.putExtra(GETCONNECTINGDEVICE_RESULT_LIST, this._deviceConfigManager.getConnectingDevice());
        sendResBroadcast(intent, hashMap, 0);
        AppMethodBeat.o(13749);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int sendResBroadcast(final Intent intent, HashMap<String, Object> hashMap, final int i2) {
        AppMethodBeat.i(13750);
        if (this._context == null) {
            AppMethodBeat.o(13750);
            return -1;
        }
        Long l = (Long) hashMap.get(PARAM_SESSIONID);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " sessonID:" + l + " " + ((String) hashMap.get(PARAM_OPERATION)));
        }
        if (l == null || l.longValue() == Long.MIN_VALUE) {
            InternalNotifyDeviceListUpdate();
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "sendResBroadcast sid null,don't send res");
            }
            AppMethodBeat.o(13750);
            return -1;
        }
        final Long l2 = (Long) hashMap.get(PARAM_SESSIONID);
        final String str = (String) hashMap.get(PARAM_OPERATION);
        if (OPERATION_VOICECALL_PREPROCESS.equals(str)) {
            intent.setAction(ACTION_TRAEAUDIOMANAGER_RES);
            intent.putExtra(PARAM_SESSIONID, l2);
            intent.putExtra(PARAM_OPERATION, str);
            intent.putExtra(PARAM_RES_ERRCODE, i2);
            if (this._audioSessionHost != null) {
                this._audioSessionHost.sendToAudioSessionMessage(intent);
            }
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.rtmp.sharp.jni.TraeAudioManager.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(13779);
                    intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_RES);
                    intent.putExtra(TraeAudioManager.PARAM_SESSIONID, l2);
                    intent.putExtra(TraeAudioManager.PARAM_OPERATION, str);
                    intent.putExtra(TraeAudioManager.PARAM_RES_ERRCODE, i2);
                    if (TraeAudioManager.this._context != null) {
                        TraeAudioManager.this._context.sendBroadcast(intent);
                    }
                    AppMethodBeat.o(13779);
                }
            });
        }
        AppMethodBeat.o(13750);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int InternalNotifyDeviceListUpdate() {
        AppMethodBeat.i(13751);
        AudioDeviceInterface.LogTraceEntry("");
        if (this._context == null) {
            AppMethodBeat.o(13751);
            return -1;
        }
        HashMap<String, Object> snapParams = this._deviceConfigManager.getSnapParams();
        final ArrayList arrayList = (ArrayList) snapParams.get(EXTRA_DATA_AVAILABLEDEVICE_LIST);
        final String str = (String) snapParams.get(EXTRA_DATA_CONNECTEDDEVICE);
        final String str2 = (String) snapParams.get(EXTRA_DATA_PREV_CONNECTEDDEVICE);
        final String bluetoothName = this._deviceConfigManager.getBluetoothName();
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.rtmp.sharp.jni.TraeAudioManager.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(13935);
                Intent intent = new Intent();
                intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
                intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_DEVICELIST_UPDATE);
                intent.putExtra(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST, (String[]) arrayList.toArray(new String[0]));
                intent.putExtra(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE, str);
                intent.putExtra(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE, str2);
                intent.putExtra(TraeAudioManager.EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME, bluetoothName);
                if (TraeAudioManager.this._context != null) {
                    TraeAudioManager.this._context.sendBroadcast(intent);
                }
                AppMethodBeat.o(13935);
            }
        });
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13751);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int InternalNotifyDeviceChangableUpdate() {
        AppMethodBeat.i(13752);
        if (this._context == null) {
            AppMethodBeat.o(13752);
            return -1;
        }
        final boolean InternalIsDeviceChangeable = InternalIsDeviceChangeable();
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.rtmp.sharp.jni.TraeAudioManager.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(13655);
                Intent intent = new Intent();
                intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
                intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_DEVICECHANGABLE_UPDATE);
                intent.putExtra(TraeAudioManager.NOTIFY_DEVICECHANGABLE_UPDATE_DATE, InternalIsDeviceChangeable);
                if (TraeAudioManager.this._context != null) {
                    TraeAudioManager.this._context.sendBroadcast(intent);
                }
                AppMethodBeat.o(13655);
            }
        });
        AppMethodBeat.o(13752);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public abstract class BluetoohHeadsetCheckInterface {
        /* access modifiers changed from: package-private */
        public abstract void _addAction(IntentFilter intentFilter);

        /* access modifiers changed from: package-private */
        public abstract void _onReceive(Context context, Intent intent);

        public abstract boolean init(Context context, DeviceConfigManager deviceConfigManager);

        public abstract String interfaceDesc();

        public abstract boolean isConnected();

        public abstract void release();

        BluetoohHeadsetCheckInterface() {
        }

        public void addAction(IntentFilter intentFilter) {
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            _addAction(intentFilter);
        }

        public void onReceive(Context context, Intent intent, DeviceConfigManager deviceConfigManager) {
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BT ACTION_STATE_CHANGED|   EXTRA_STATE " + getBTActionStateChangedExtraString(intExtra));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BT ACTION_STATE_CHANGED|   EXTRA_PREVIOUS_STATE " + getBTActionStateChangedExtraString(intExtra2));
                }
                if (intExtra == 10) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "    BT off");
                    }
                    deviceConfigManager.setVisible(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                } else if (intExtra == 12 && QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BT OFF-->ON,Visiable it...");
                }
            } else if ("android.bluetooth.device.action.ACL_CONNECTED".equals(intent.getAction()) && Build.VERSION.SDK_INT < 11) {
            } else {
                if (!"android.bluetooth.device.action.ACL_DISCONNECTED".equals(intent.getAction()) || Build.VERSION.SDK_INT >= 11) {
                    _onReceive(context, intent);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public String getBTActionStateChangedExtraString(int i2) {
            String str;
            switch (i2) {
                case 10:
                    str = "STATE_OFF";
                    break;
                case 11:
                    str = "STATE_TURNING_ON";
                    break;
                case 12:
                    str = "STATE_ON";
                    break;
                case 13:
                    str = "STATE_TURNING_OFF";
                    break;
                default:
                    str = "unknow";
                    break;
            }
            return str + ":" + i2;
        }

        /* access modifiers changed from: package-private */
        public String getSCOAudioStateExtraString(int i2) {
            String str;
            switch (i2) {
                case -1:
                    str = "SCO_AUDIO_STATE_ERROR";
                    break;
                case 0:
                    str = "SCO_AUDIO_STATE_DISCONNECTED";
                    break;
                case 1:
                    str = "SCO_AUDIO_STATE_CONNECTED";
                    break;
                case 2:
                    str = "SCO_AUDIO_STATE_CONNECTING";
                    break;
                default:
                    str = "unknow";
                    break;
            }
            return str + ":" + i2;
        }

        /* access modifiers changed from: package-private */
        public String getBTAdapterConnectionState(int i2) {
            String str;
            switch (i2) {
                case 0:
                    str = "STATE_DISCONNECTED";
                    break;
                case 1:
                    str = "STATE_CONNECTING";
                    break;
                case 2:
                    str = "STATE_CONNECTED";
                    break;
                case 3:
                    str = "STATE_DISCONNECTING";
                    break;
                default:
                    str = "unknow";
                    break;
            }
            return str + ":" + i2;
        }

        /* access modifiers changed from: package-private */
        public String getBTHeadsetConnectionState(int i2) {
            String str;
            switch (i2) {
                case 0:
                    str = "STATE_DISCONNECTED";
                    break;
                case 1:
                    str = "STATE_CONNECTING";
                    break;
                case 2:
                    str = "STATE_CONNECTED";
                    break;
                case 3:
                    str = "STATE_DISCONNECTING";
                    break;
                default:
                    str = "unknow";
                    break;
            }
            return str + ":" + i2;
        }

        /* access modifiers changed from: package-private */
        public String getBTHeadsetAudioState(int i2) {
            String str;
            switch (i2) {
                case 10:
                    str = "STATE_AUDIO_DISCONNECTED";
                    break;
                case 11:
                default:
                    str = "unknow:".concat(String.valueOf(i2));
                    break;
                case 12:
                    str = "STATE_AUDIO_CONNECTED";
                    break;
            }
            return str + ":" + i2;
        }
    }

    /* access modifiers changed from: package-private */
    public class BluetoohHeadsetCheckFake extends BluetoohHeadsetCheckInterface {
        BluetoohHeadsetCheckFake() {
            super();
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public boolean init(Context context, DeviceConfigManager deviceConfigManager) {
            return true;
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public void release() {
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public boolean isConnected() {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public void _addAction(IntentFilter intentFilter) {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public void _onReceive(Context context, Intent intent) {
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public String interfaceDesc() {
            return "BluetoohHeadsetCheckFake";
        }
    }

    public BluetoohHeadsetCheckInterface CreateBluetoothCheck(Context context, DeviceConfigManager deviceConfigManager) {
        BluetoohHeadsetCheckInterface bluetoohHeadsetCheckFake;
        AppMethodBeat.i(13753);
        if (Build.VERSION.SDK_INT >= 11) {
            bluetoohHeadsetCheckFake = new BluetoohHeadsetCheck();
        } else if (Build.VERSION.SDK_INT != 18) {
            bluetoohHeadsetCheckFake = new BluetoohHeadsetCheckFor2x();
        } else {
            bluetoohHeadsetCheckFake = new BluetoohHeadsetCheckFake();
        }
        if (!bluetoohHeadsetCheckFake.init(context, deviceConfigManager)) {
            bluetoohHeadsetCheckFake = new BluetoohHeadsetCheckFake();
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "CreateBluetoothCheck:" + bluetoohHeadsetCheckFake.interfaceDesc() + " skip android4.3:" + (Build.VERSION.SDK_INT == 18 ? "Y" : "N"));
        }
        AppMethodBeat.o(13753);
        return bluetoohHeadsetCheckFake;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(11)
    public class BluetoohHeadsetCheck extends BluetoohHeadsetCheckInterface implements BluetoothProfile.ServiceListener {
        BluetoothAdapter _adapter = null;
        Context _ctx = null;
        DeviceConfigManager _devCfg = null;
        BluetoothProfile _profile = null;
        private final ReentrantLock _profileLock = new ReentrantLock();

        BluetoohHeadsetCheck() {
            super();
            AppMethodBeat.i(13806);
            AppMethodBeat.o(13806);
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        @TargetApi(11)
        public boolean init(Context context, DeviceConfigManager deviceConfigManager) {
            AppMethodBeat.i(13807);
            AudioDeviceInterface.LogTraceEntry("");
            if (context == null || deviceConfigManager == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " err ctx==null||_devCfg==null");
                }
                AppMethodBeat.o(13807);
                return false;
            }
            this._ctx = context;
            this._devCfg = deviceConfigManager;
            this._adapter = BluetoothAdapter.getDefaultAdapter();
            if (this._adapter == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " err getDefaultAdapter fail!");
                }
                AppMethodBeat.o(13807);
                return false;
            }
            this._profileLock.lock();
            try {
                if (!this._adapter.isEnabled() || this._profile != null || this._adapter.getProfileProxy(this._ctx, this, 1)) {
                    this._profileLock.unlock();
                    AudioDeviceInterface.LogTraceExit();
                    AppMethodBeat.o(13807);
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
                }
                return false;
            } finally {
                this._profileLock.unlock();
                AppMethodBeat.o(13807);
            }
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public void release() {
            AppMethodBeat.i(13808);
            AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile);
            this._profileLock.lock();
            try {
                if (this._adapter != null) {
                    if (this._profile != null) {
                        this._adapter.closeProfileProxy(1, this._profile);
                    }
                    this._profile = null;
                }
                this._profileLock.unlock();
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " closeProfileProxy:e:" + e2.getMessage());
                }
                this._profileLock.unlock();
            } catch (Throwable th) {
                this._profileLock.unlock();
                AppMethodBeat.o(13808);
                throw th;
            }
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(13808);
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public boolean isConnected() {
            boolean z = false;
            AppMethodBeat.i(13809);
            this._profileLock.lock();
            try {
                if (this._profile != null) {
                    List<BluetoothDevice> connectedDevices = this._profile.getConnectedDevices();
                    if (connectedDevices == null) {
                        return z;
                    }
                    if (connectedDevices.size() > 0) {
                        z = true;
                    }
                }
                this._profileLock.unlock();
                AppMethodBeat.o(13809);
                return z;
            } finally {
                this._profileLock.unlock();
                AppMethodBeat.o(13809);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00e1  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0112 A[SYNTHETIC] */
        @android.annotation.TargetApi(11)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onServiceConnected(int r14, android.bluetooth.BluetoothProfile r15) {
            /*
            // Method dump skipped, instructions count: 405
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheck.onServiceConnected(int, android.bluetooth.BluetoothProfile):void");
        }

        @TargetApi(11)
        public void onServiceDisconnected(int i2) {
            AppMethodBeat.i(13811);
            AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile + " profile:" + i2);
            if (i2 == 1) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Disconnected");
                }
                if (isConnected()) {
                    TraeAudioManager.this.checkDevicePlug(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                }
                this._profileLock.lock();
                try {
                    if (this._profile != null) {
                        this._adapter.closeProfileProxy(1, this._profile);
                        this._profile = null;
                    }
                    this._profileLock.unlock();
                } catch (Throwable th) {
                    this._profileLock.unlock();
                    AppMethodBeat.o(13811);
                    throw th;
                }
            }
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(13811);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public void _addAction(IntentFilter intentFilter) {
            AppMethodBeat.i(13812);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " " + interfaceDesc() + " _addAction");
            }
            intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
            intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
            AppMethodBeat.o(13812);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* access modifiers changed from: package-private */
        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public void _onReceive(Context context, Intent intent) {
            String str;
            AppMethodBeat.i(13813);
            if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE " + getBTAdapterConnectionState(intExtra));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "    EXTRA_PREVIOUS_CONNECTION_STATE " + getBTAdapterConnectionState(intExtra2));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "    EXTRA_DEVICE " + bluetoothDevice + " " + (bluetoothDevice != null ? bluetoothDevice.getName() : " "));
                }
                if (intExtra == 2) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "   dev:" + bluetoothDevice.getName() + " connected,start sco...");
                    }
                    this._devCfg.setVisible(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                    DeviceConfigManager deviceConfigManager = this._devCfg;
                    if (bluetoothDevice != null) {
                        str = bluetoothDevice.getName();
                    } else {
                        str = "unkown";
                    }
                    deviceConfigManager.setBluetoothName(str);
                    AppMethodBeat.o(13813);
                    return;
                } else if (intExtra == 0) {
                    this._devCfg.setVisible(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                    AppMethodBeat.o(13813);
                    return;
                }
            } else if ("android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(intent.getAction())) {
                int intExtra3 = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
                int intExtra4 = intent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BT ACTION_SCO_AUDIO_STATE_UPDATED|   EXTRA_CONNECTION_STATE  dev:".concat(String.valueOf(bluetoothDevice2)));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_STATE " + getSCOAudioStateExtraString(intExtra3));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_PREVIOUS_STATE " + getSCOAudioStateExtraString(intExtra4));
                    AppMethodBeat.o(13813);
                    return;
                }
            } else if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                switch (defaultAdapter.getProfileConnectionState(2)) {
                    case 0:
                        QLog.w("TRAE", 2, "BluetoothA2dp STATE_DISCONNECTED");
                        TraeAudioManager.this.IsBluetoothA2dpExisted = false;
                        AppMethodBeat.o(13813);
                        return;
                    case 1:
                    default:
                        QLog.w("TRAE", 2, "BluetoothA2dp" + defaultAdapter.getProfileConnectionState(2));
                        break;
                    case 2:
                        QLog.w("TRAE", 2, "BluetoothA2dp STATE_CONNECTED");
                        TraeAudioManager.this.IsBluetoothA2dpExisted = true;
                        AppMethodBeat.o(13813);
                        return;
                }
            }
            AppMethodBeat.o(13813);
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public String interfaceDesc() {
            return "BluetoohHeadsetCheck";
        }
    }

    /* access modifiers changed from: package-private */
    public class BluetoohHeadsetCheckFor2x extends BluetoohHeadsetCheckInterface {
        public static final String ACTION_BLUETOOTHHEADSET_AUDIO_STATE_CHANGED = "android.bluetooth.headset.action.AUDIO_STATE_CHANGED";
        public static final String ACTION_BLUETOOTHHEADSET_STATE_CHANGED = "android.bluetooth.headset.action.STATE_CHANGED";
        public static final int AUDIO_STATE_CONNECTED = 1;
        public static final int AUDIO_STATE_DISCONNECTED = 0;
        static final int STATE_CONNECTED = 2;
        static final int STATE_DISCONNECTED = 0;
        Class<?> BluetoothHeadsetClass = null;
        Object BluetoothHeadsetObj = null;
        Class<?> ListenerClass = null;
        Context _ctx = null;
        DeviceConfigManager _devCfg = null;
        Method getCurrentHeadsetMethod = null;

        BluetoohHeadsetCheckFor2x() {
            super();
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public boolean init(Context context, DeviceConfigManager deviceConfigManager) {
            AppMethodBeat.i(13791);
            AudioDeviceInterface.LogTraceEntry("");
            this._ctx = context;
            this._devCfg = deviceConfigManager;
            if (this._ctx == null || this._devCfg == null) {
                AppMethodBeat.o(13791);
                return false;
            }
            try {
                this.BluetoothHeadsetClass = Class.forName("android.bluetooth.BluetoothHeadset");
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset class not found");
                }
            }
            if (this.BluetoothHeadsetClass == null) {
                AppMethodBeat.o(13791);
                return false;
            }
            try {
                this.ListenerClass = Class.forName("android.bluetooth.BluetoothHeadset$ServiceListener");
            } catch (Exception e3) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset.ServiceListener class not found:".concat(String.valueOf(e3)));
                }
            }
            try {
                this.getCurrentHeadsetMethod = this.BluetoothHeadsetClass.getDeclaredMethod("getCurrentHeadset", new Class[0]);
            } catch (NoSuchMethodException e4) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset NoSuchMethodException");
                }
            }
            if (this.getCurrentHeadsetMethod == null) {
                AppMethodBeat.o(13791);
                return false;
            }
            try {
                this.BluetoothHeadsetObj = this.BluetoothHeadsetClass.getConstructor(Context.class, this.ListenerClass).newInstance(context, null);
            } catch (IllegalArgumentException e5) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalArgumentException");
                }
            } catch (InstantiationException e6) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor InstantiationException");
                }
            } catch (IllegalAccessException e7) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalAccessException");
                }
            } catch (InvocationTargetException e8) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor InvocationTargetException");
                }
            } catch (NoSuchMethodException e9) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor NoSuchMethodException");
                }
            }
            if (this.BluetoothHeadsetObj == null) {
                AppMethodBeat.o(13791);
                return false;
            }
            this._devCfg.setVisible(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, isConnected());
            if (isConnected()) {
                this._devCfg.setVisible(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                TraeAudioManager.this.checkDevicePlug(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
            } else {
                this._devCfg.setVisible(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
            }
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(13791);
            return true;
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public void release() {
            Method method;
            AppMethodBeat.i(13792);
            AudioDeviceInterface.LogTraceEntry("");
            if (this.BluetoothHeadsetObj == null) {
                AppMethodBeat.o(13792);
                return;
            }
            try {
                method = this.BluetoothHeadsetClass.getDeclaredMethod("close", new Class[0]);
            } catch (NoSuchMethodException e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread _uninitHeadsetfor2x method close NoSuchMethodException");
                }
                method = null;
            }
            if (method == null) {
                AppMethodBeat.o(13792);
                return;
            }
            try {
                method.invoke(this.BluetoothHeadsetObj, new Object[0]);
            } catch (Exception e3) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "close bluetooth headset failed." + e3.getMessage());
                }
            }
            this.BluetoothHeadsetClass = null;
            this.ListenerClass = null;
            this.BluetoothHeadsetObj = null;
            this.getCurrentHeadsetMethod = null;
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(13792);
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public boolean isConnected() {
            AppMethodBeat.i(13793);
            Object obj = null;
            if (this.getCurrentHeadsetMethod == null || this.getCurrentHeadsetMethod == null) {
                AppMethodBeat.o(13793);
                return false;
            }
            try {
                obj = this.getCurrentHeadsetMethod.invoke(this.BluetoothHeadsetObj, new Object[0]);
            } catch (IllegalArgumentException e2) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalArgumentException");
                }
            } catch (IllegalAccessException e3) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalAccessException");
                }
            } catch (InvocationTargetException e4) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset InvocationTargetException");
                }
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset res:" + (obj != null ? " Y" : "N"));
            }
            if (obj != null) {
                AppMethodBeat.o(13793);
                return true;
            }
            AppMethodBeat.o(13793);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public void _addAction(IntentFilter intentFilter) {
            AppMethodBeat.i(13794);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " " + interfaceDesc() + " _addAction");
            }
            intentFilter.addAction(ACTION_BLUETOOTHHEADSET_AUDIO_STATE_CHANGED);
            intentFilter.addAction(ACTION_BLUETOOTHHEADSET_STATE_CHANGED);
            AppMethodBeat.o(13794);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public void _onReceive(Context context, Intent intent) {
            AppMethodBeat.i(13795);
            if (ACTION_BLUETOOTHHEADSET_AUDIO_STATE_CHANGED.equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
                int intExtra2 = intent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
                int intExtra3 = intent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "++ AUDIO_STATE_CHANGED|  STATE ".concat(String.valueOf(intExtra)));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "       PREVIOUS_STATE ".concat(String.valueOf(intExtra2)));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "       AUDIO_STATE ".concat(String.valueOf(intExtra3)));
                }
                if (intExtra3 == 2) {
                    this._devCfg.setVisible(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                    AppMethodBeat.o(13795);
                    return;
                } else if (intExtra3 == 0) {
                    this._devCfg.setVisible(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                    AppMethodBeat.o(13795);
                    return;
                }
            } else if (ACTION_BLUETOOTHHEADSET_STATE_CHANGED.equals(intent.getAction())) {
                int intExtra4 = intent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
                int intExtra5 = intent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
                int intExtra6 = intent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "++ STATE_CHANGED|  STATE ".concat(String.valueOf(intExtra4)));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "       PREVIOUS_STATE ".concat(String.valueOf(intExtra5)));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "       AUDIO_STATE ".concat(String.valueOf(intExtra6)));
                }
                if (intExtra6 == 2) {
                    this._devCfg.setVisible(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                    AppMethodBeat.o(13795);
                    return;
                } else if (intExtra6 == 0) {
                    this._devCfg.setVisible(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                }
            }
            AppMethodBeat.o(13795);
        }

        @Override // com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
        public String interfaceDesc() {
            return "BluetoohHeadsetCheckFor2x";
        }
    }

    static String getForceConfigName(int i2) {
        if (i2 < 0 || i2 >= forceName.length) {
            return "unknow";
        }
        return forceName[i2];
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class[] clsArr) {
        AppMethodBeat.i(13754);
        Object obj2 = null;
        try {
            obj2 = obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "invokeMethod Exception:" + e2.getMessage());
            }
        }
        AppMethodBeat.o(13754);
        return obj2;
    }

    public static Object invokeStaticMethod(String str, String str2, Object[] objArr, Class[] clsArr) {
        Object obj = null;
        AppMethodBeat.i(13755);
        try {
            obj = Class.forName(str).getMethod(str2, clsArr).invoke(null, objArr);
        } catch (ClassNotFoundException e2) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "ClassNotFound:".concat(String.valueOf(str)));
            }
        } catch (NoSuchMethodException e3) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "NoSuchMethod:".concat(String.valueOf(str2)));
            }
        } catch (IllegalArgumentException e4) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "IllegalArgument:".concat(String.valueOf(str2)));
            }
        } catch (IllegalAccessException e5) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "IllegalAccess:".concat(String.valueOf(str2)));
            }
        } catch (InvocationTargetException e6) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "InvocationTarget:".concat(String.valueOf(str2)));
            }
        } catch (Exception e7) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "invokeStaticMethod Exception:" + e7.getMessage());
            }
        }
        AppMethodBeat.o(13755);
        return obj;
    }

    static void setParameters(String str) {
        AppMethodBeat.i(13756);
        Object[] objArr = {str};
        Class[] clsArr = {String.class};
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "setParameters  :".concat(String.valueOf(str)));
        }
        invokeStaticMethod("android.media.AudioSystem", "setParameters", objArr, clsArr);
        AppMethodBeat.o(13756);
    }

    static void setPhoneState(int i2) {
        AppMethodBeat.i(13757);
        invokeStaticMethod("android.media.AudioSystem", "setPhoneState", new Object[]{Integer.valueOf(i2)}, new Class[]{Integer.TYPE});
        AppMethodBeat.o(13757);
    }

    static void setForceUse(int i2, int i3) {
        AppMethodBeat.i(13758);
        Object invokeStaticMethod = invokeStaticMethod("android.media.AudioSystem", "setForceUse", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}, new Class[]{Integer.TYPE, Integer.TYPE});
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "setForceUse  usage:" + i2 + " config:" + i3 + " ->" + getForceConfigName(i3) + " res:" + invokeStaticMethod);
        }
        AppMethodBeat.o(13758);
    }

    static int getForceUse(int i2) {
        Integer num;
        AppMethodBeat.i(13759);
        Object invokeStaticMethod = invokeStaticMethod("android.media.AudioSystem", "getForceUse", new Object[]{Integer.valueOf(i2)}, new Class[]{Integer.TYPE});
        if (invokeStaticMethod != null) {
            num = (Integer) invokeStaticMethod;
        } else {
            num = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "getForceUse  usage:" + i2 + " config:" + num + " ->" + getForceConfigName(num.intValue()));
        }
        int intValue = num.intValue();
        AppMethodBeat.o(13759);
        return intValue;
    }

    static void forceVolumeControlStream(AudioManager audioManager, int i2) {
        AppMethodBeat.i(13760);
        if (Build.MANUFACTURER.equals("Google")) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "forceVolumeControlStream, Google phone nothing to do");
            }
            AppMethodBeat.o(13760);
            return;
        }
        Object invokeMethod = invokeMethod(audioManager, "forceVolumeControlStream", new Object[]{Integer.valueOf(i2)}, new Class[]{Integer.TYPE});
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "forceVolumeControlStream  streamType:" + i2 + " res:" + invokeMethod);
        }
        AppMethodBeat.o(13760);
    }
}
