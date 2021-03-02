package com.tencent.rtmp.sharp.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;

public class TraeAudioSession extends BroadcastReceiver {
    static int s_nSessionIdAllocator = 0;
    final String TRAE_ACTION_PHONE_STATE = "android.intent.action.PHONE_STATE";
    private boolean _canSwtich2Earphone = true;
    private String _connectedDev = TraeAudioManager.DEVICE_NONE;
    private ITraeAudioCallback mCallback;
    private Context mContext;
    private boolean mIsHostside = false;
    private long mSessionId = Long.MIN_VALUE;

    public interface ITraeAudioCallback {
        void onAudioRouteSwitchEnd(String str, long j2);

        void onAudioRouteSwitchStart(String str, String str2);

        void onConnectDeviceRes(int i2, String str, boolean z);

        void onDeviceChangabledUpdate(boolean z);

        void onDeviceListUpdate(String[] strArr, String str, String str2, String str3);

        void onGetConnectedDeviceRes(int i2, String str);

        void onGetConnectingDeviceRes(int i2, String str);

        void onGetDeviceListRes(int i2, String[] strArr, String str, String str2, String str3);

        void onGetStreamTypeRes(int i2, int i3);

        void onIsDeviceChangabledRes(int i2, boolean z);

        void onRingCompletion(int i2, String str);

        void onServiceStateUpdate(boolean z);

        void onStreamTypeUpdate(int i2);

        void onVoicecallPreprocessRes(int i2);
    }

    public static long requestSessionId() {
        AppMethodBeat.i(13662);
        int i2 = s_nSessionIdAllocator + 1;
        s_nSessionIdAllocator = i2;
        long myPid = (((long) Process.myPid()) << 32) + ((long) i2);
        AppMethodBeat.o(13662);
        return myPid;
    }

    public static void ExConnectDevice(Context context, String str) {
        AppMethodBeat.i(13663);
        if (context == null || str == null || str.length() <= 0) {
            AppMethodBeat.o(13663);
            return;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, Long.MIN_VALUE);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_CONNECTDEVICE);
        intent.putExtra(TraeAudioManager.CONNECTDEVICE_DEVICENAME, str);
        context.sendBroadcast(intent);
        AppMethodBeat.o(13663);
    }

    public TraeAudioSession(Context context, ITraeAudioCallback iTraeAudioCallback) {
        String str;
        boolean z = false;
        AppMethodBeat.i(13664);
        this.mIsHostside = Process.myPid() == TraeAudioManager._gHostProcessId ? true : z;
        this.mSessionId = requestSessionId();
        this.mCallback = iTraeAudioCallback;
        this.mContext = context;
        if (context == null && QLog.isColorLevel()) {
            StringBuilder append = new StringBuilder("AudioSession | Invalid parameters: ctx = ").append(context == null ? BuildConfig.COMMAND : "{object}").append("; cb = ");
            if (iTraeAudioCallback == null) {
                str = BuildConfig.COMMAND;
            } else {
                str = "{object}";
            }
            QLog.w("TRAE", 2, append.append(str).toString());
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_RES);
        intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
        if (context != null) {
            try {
                context.registerReceiver(this, intentFilter);
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "registerReceiver Exception: " + e2.getMessage());
                }
            }
        }
        registerAudioSession(this, true);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "TraeAudioSession create, mSessionId: " + this.mSessionId);
        }
        AppMethodBeat.o(13664);
    }

    public void release() {
        AppMethodBeat.i(13665);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "TraeAudioSession release, mSessionId: " + this.mSessionId);
        }
        if (this.mContext != null) {
            try {
                this.mContext.unregisterReceiver(this);
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "unregisterReceiver failed." + e2.getMessage());
                }
            }
        }
        registerAudioSession(this, false);
        this.mContext = null;
        this.mCallback = null;
        AppMethodBeat.o(13665);
    }

    public void setCallback(ITraeAudioCallback iTraeAudioCallback) {
        this.mCallback = iTraeAudioCallback;
    }

    private int registerAudioSession(TraeAudioSession traeAudioSession, boolean z) {
        AppMethodBeat.i(13666);
        if (this.mContext == null) {
            AppMethodBeat.o(13666);
            return -1;
        }
        int registerAudioSession = TraeAudioManager.registerAudioSession(traeAudioSession, z, this.mSessionId, this.mContext);
        AppMethodBeat.o(13666);
        return registerAudioSession;
    }

    public int startService(String str) {
        AppMethodBeat.i(13667);
        if (str == null || str.length() <= 0) {
            str = "internal_disable_dev_switch";
        }
        if (this.mIsHostside) {
            int startService = TraeAudioManager.startService(TraeAudioManager.OPERATION_STARTSERVICE, this.mSessionId, this.mIsHostside, str);
            AppMethodBeat.o(13667);
            return startService;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13667);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STARTSERVICE);
            intent.putExtra(TraeAudioManager.EXTRA_DATA_DEVICECONFIG, str);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13667);
            return 0;
        }
    }

    public int disableDeviceSwitch() {
        AppMethodBeat.i(13668);
        int disableDeviceSwitch = TraeAudioManager.disableDeviceSwitch();
        AppMethodBeat.o(13668);
        return disableDeviceSwitch;
    }

    public int stopService() {
        AppMethodBeat.i(13669);
        if (this.mIsHostside) {
            int stopService = TraeAudioManager.stopService(TraeAudioManager.OPERATION_STOPSERVICE, this.mSessionId, this.mIsHostside);
            AppMethodBeat.o(13669);
            return stopService;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13669);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STOPSERVICE);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13669);
            return 0;
        }
    }

    public int getDeviceList() {
        AppMethodBeat.i(13670);
        if (this.mIsHostside) {
            int deviceList = TraeAudioManager.getDeviceList(TraeAudioManager.OPERATION_GETDEVICELIST, this.mSessionId, this.mIsHostside);
            AppMethodBeat.o(13670);
            return deviceList;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13670);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_GETDEVICELIST);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13670);
            return 0;
        }
    }

    public int getStreamType() {
        AppMethodBeat.i(13671);
        if (this.mIsHostside) {
            int streamType = TraeAudioManager.getStreamType(TraeAudioManager.OPERATION_GETSTREAMTYPE, this.mSessionId, this.mIsHostside);
            AppMethodBeat.o(13671);
            return streamType;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13671);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_GETSTREAMTYPE);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13671);
            return 0;
        }
    }

    public int connectDevice(String str) {
        AppMethodBeat.i(13672);
        if (this.mIsHostside) {
            int connectDevice = TraeAudioManager.connectDevice(TraeAudioManager.OPERATION_CONNECTDEVICE, this.mSessionId, this.mIsHostside, str);
            AppMethodBeat.o(13672);
            return connectDevice;
        } else if (this.mContext == null || str == null || str.length() <= 0) {
            AppMethodBeat.o(13672);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_CONNECTDEVICE);
            intent.putExtra(TraeAudioManager.CONNECTDEVICE_DEVICENAME, str);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13672);
            return 0;
        }
    }

    public int connectHighestPriorityDevice() {
        AppMethodBeat.i(13673);
        if (this.mIsHostside) {
            int connectHighestPriorityDevice = TraeAudioManager.connectHighestPriorityDevice(TraeAudioManager.OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE, this.mSessionId, this.mIsHostside);
            AppMethodBeat.o(13673);
            return connectHighestPriorityDevice;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13673);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13673);
            return 0;
        }
    }

    public int EarAction(int i2) {
        AppMethodBeat.i(13674);
        if (this.mIsHostside) {
            int earAction = TraeAudioManager.earAction(TraeAudioManager.OPERATION_EARACTION, this.mSessionId, this.mIsHostside, i2);
            AppMethodBeat.o(13674);
            return earAction;
        } else if (this.mContext == null || !(i2 == 0 || i2 == 1)) {
            AppMethodBeat.o(13674);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_EARACTION);
            intent.putExtra(TraeAudioManager.EXTRA_EARACTION, i2);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13674);
            return 0;
        }
    }

    public int isDeviceChangabled() {
        AppMethodBeat.i(13675);
        if (this.mIsHostside) {
            int isDeviceChangabled = TraeAudioManager.isDeviceChangabled(TraeAudioManager.OPERATION_ISDEVICECHANGABLED, this.mSessionId, this.mIsHostside);
            AppMethodBeat.o(13675);
            return isDeviceChangabled;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13675);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_ISDEVICECHANGABLED);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13675);
            return 0;
        }
    }

    public int getConnectedDevice() {
        AppMethodBeat.i(13676);
        if (this.mIsHostside) {
            int connectedDevice = TraeAudioManager.getConnectedDevice(TraeAudioManager.OPERATION_GETCONNECTEDDEVICE, this.mSessionId, this.mIsHostside);
            AppMethodBeat.o(13676);
            return connectedDevice;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13676);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_GETCONNECTEDDEVICE);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13676);
            return 0;
        }
    }

    public int getConnectingDevice() {
        AppMethodBeat.i(13677);
        if (this.mIsHostside) {
            int connectingDevice = TraeAudioManager.getConnectingDevice(TraeAudioManager.OPERATION_GETCONNECTINGDEVICE, this.mSessionId, this.mIsHostside);
            AppMethodBeat.o(13677);
            return connectingDevice;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13677);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_GETCONNECTINGDEVICE);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13677);
            return 0;
        }
    }

    public int voiceCallPreprocess(int i2, int i3) {
        AppMethodBeat.i(13678);
        if (this.mIsHostside) {
            int voicecallPreprocess = TraeAudioManager.voicecallPreprocess(TraeAudioManager.OPERATION_VOICECALL_PREPROCESS, this.mSessionId, this.mIsHostside, i2, i3);
            AppMethodBeat.o(13678);
            return voicecallPreprocess;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13678);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_MODEPOLICY, i2);
            intent.putExtra(TraeAudioManager.PARAM_STREAMTYPE, i3);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_VOICECALL_PREPROCESS);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13678);
            return 0;
        }
    }

    public int voiceCallPostprocess() {
        AppMethodBeat.i(13679);
        if (this.mIsHostside) {
            int voicecallPostprocess = TraeAudioManager.voicecallPostprocess(TraeAudioManager.OPERATION_VOICECALL_POSTPROCESS, this.mSessionId, this.mIsHostside);
            AppMethodBeat.o(13679);
            return voicecallPostprocess;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13679);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_VOICECALL_POSTPROCESS);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13679);
            return 0;
        }
    }

    public int voiceCallAudioParamChanged(int i2, int i3) {
        AppMethodBeat.i(13680);
        if (this.mIsHostside) {
            int voiceCallAudioParamChanged = TraeAudioManager.voiceCallAudioParamChanged(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST, this.mSessionId, this.mIsHostside, i2, i3);
            AppMethodBeat.o(13680);
            return voiceCallAudioParamChanged;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13680);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_MODEPOLICY, i2);
            intent.putExtra(TraeAudioManager.PARAM_STREAMTYPE, i3);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_VOICECALL_AUDIOPARAM_CHANGED);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13680);
            return 0;
        }
    }

    public int startRing(int i2, int i3, Uri uri, String str, boolean z) {
        AppMethodBeat.i(13681);
        if (this.mIsHostside) {
            int startRing = TraeAudioManager.startRing(TraeAudioManager.OPERATION_STARTRING, this.mSessionId, this.mIsHostside, i2, i3, uri, str, z, 1, "normal-ring", false);
            AppMethodBeat.o(13681);
            return startRing;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13681);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_RING_DATASOURCE, i2);
            intent.putExtra(TraeAudioManager.PARAM_RING_RSID, i3);
            intent.putExtra(TraeAudioManager.PARAM_RING_URI, uri);
            intent.putExtra(TraeAudioManager.PARAM_RING_FILEPATH, str);
            intent.putExtra(TraeAudioManager.PARAM_RING_LOOP, z);
            intent.putExtra(TraeAudioManager.PARAM_RING_MODE, false);
            intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, "normal-ring");
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STARTRING);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13681);
            return 0;
        }
    }

    public int startRing(int i2, int i3, Uri uri, String str, boolean z, int i4, String str2) {
        AppMethodBeat.i(13682);
        if (this.mIsHostside) {
            int startRing = TraeAudioManager.startRing(TraeAudioManager.OPERATION_STARTRING, this.mSessionId, this.mIsHostside, i2, i3, uri, str, z, i4, str2, false);
            AppMethodBeat.o(13682);
            return startRing;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13682);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_RING_DATASOURCE, i2);
            intent.putExtra(TraeAudioManager.PARAM_RING_RSID, i3);
            intent.putExtra(TraeAudioManager.PARAM_RING_URI, uri);
            intent.putExtra(TraeAudioManager.PARAM_RING_FILEPATH, str);
            intent.putExtra(TraeAudioManager.PARAM_RING_LOOP, z);
            intent.putExtra(TraeAudioManager.PARAM_RING_LOOPCOUNT, i4);
            intent.putExtra(TraeAudioManager.PARAM_RING_MODE, false);
            intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, str2);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STARTRING);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13682);
            return 0;
        }
    }

    public int startRing(int i2, int i3, Uri uri, String str, boolean z, int i4, String str2, boolean z2) {
        AppMethodBeat.i(13683);
        if (this.mIsHostside) {
            int startRing = TraeAudioManager.startRing(TraeAudioManager.OPERATION_STARTRING, this.mSessionId, this.mIsHostside, i2, i3, uri, str, z, i4, str2, z2);
            AppMethodBeat.o(13683);
            return startRing;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13683);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_RING_DATASOURCE, i2);
            intent.putExtra(TraeAudioManager.PARAM_RING_RSID, i3);
            intent.putExtra(TraeAudioManager.PARAM_RING_URI, uri);
            intent.putExtra(TraeAudioManager.PARAM_RING_FILEPATH, str);
            intent.putExtra(TraeAudioManager.PARAM_RING_LOOP, z);
            intent.putExtra(TraeAudioManager.PARAM_RING_LOOPCOUNT, i4);
            intent.putExtra(TraeAudioManager.PARAM_RING_MODE, z2);
            intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, str2);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STARTRING);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13683);
            return 0;
        }
    }

    public int stopRing() {
        AppMethodBeat.i(13684);
        if (this.mIsHostside) {
            int stopRing = TraeAudioManager.stopRing(TraeAudioManager.OPERATION_STOPRING, this.mSessionId, this.mIsHostside);
            AppMethodBeat.o(13684);
            return stopRing;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13684);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STOPRING);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13684);
            return 0;
        }
    }

    public int requestReleaseAudioFocus() {
        AppMethodBeat.i(13685);
        if (this.mIsHostside) {
            int requestReleaseAudioFocus = TraeAudioManager.requestReleaseAudioFocus(TraeAudioManager.OPERATION_REQUEST_RELEASE_AUDIO_FOCUS, this.mSessionId, this.mIsHostside);
            AppMethodBeat.o(13685);
            return requestReleaseAudioFocus;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13685);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_REQUEST_RELEASE_AUDIO_FOCUS);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13685);
            return 0;
        }
    }

    public int recoverAudioFocus() {
        AppMethodBeat.i(13686);
        if (this.mIsHostside) {
            int recoverAudioFocus = TraeAudioManager.recoverAudioFocus(TraeAudioManager.OPERATION_RECOVER_AUDIO_FOCUS, this.mSessionId, this.mIsHostside);
            AppMethodBeat.o(13686);
            return recoverAudioFocus;
        } else if (this.mContext == null) {
            AppMethodBeat.o(13686);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_RECOVER_AUDIO_FOCUS);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(13686);
            return 0;
        }
    }

    public void onReceiveCallback(Intent intent) {
        AppMethodBeat.i(13687);
        if (intent == null) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "[ERROR] intent = null!!");
                }
                AppMethodBeat.o(13687);
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "AudioSession| nSessinId = " + this.mSessionId + " onReceive::intent:" + intent.toString() + " intent.getAction():" + intent.getAction() + " Exception:" + e2.getMessage());
                }
                AppMethodBeat.o(13687);
            }
        } else {
            long longExtra = intent.getLongExtra(TraeAudioManager.PARAM_SESSIONID, Long.MIN_VALUE);
            String stringExtra = intent.getStringExtra(TraeAudioManager.PARAM_OPERATION);
            int intExtra = intent.getIntExtra(TraeAudioManager.PARAM_RES_ERRCODE, 0);
            if (TraeAudioManager.ACTION_TRAEAUDIOMANAGER_RES.equals(intent.getAction())) {
                if (this.mSessionId != longExtra) {
                    AppMethodBeat.o(13687);
                    return;
                } else if (TraeAudioManager.OPERATION_VOICECALL_PREPROCESS.equals(stringExtra)) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onReceiveCallback onVoicecallPreprocess] err:".concat(String.valueOf(intExtra)));
                    }
                    if (this.mCallback != null) {
                        this.mCallback.onVoicecallPreprocessRes(intExtra);
                    }
                }
            }
            AppMethodBeat.o(13687);
        }
    }

    public void onReceive(Context context, Intent intent) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(13688);
        if (intent == null) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "[ERROR] intent = null!!");
                }
                AppMethodBeat.o(13688);
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "AudioSession| nSessinId = " + this.mSessionId + " onReceive::intent:" + intent.toString() + " intent.getAction():" + intent.getAction() + " Exception:" + e2.getMessage());
                }
                AppMethodBeat.o(13688);
            }
        } else {
            long longExtra = intent.getLongExtra(TraeAudioManager.PARAM_SESSIONID, Long.MIN_VALUE);
            String stringExtra = intent.getStringExtra(TraeAudioManager.PARAM_OPERATION);
            int intExtra = intent.getIntExtra(TraeAudioManager.PARAM_RES_ERRCODE, 0);
            if (TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY.equals(intent.getAction())) {
                if (TraeAudioManager.NOTIFY_SERVICE_STATE.equals(stringExtra)) {
                    boolean booleanExtra = intent.getBooleanExtra(TraeAudioManager.NOTIFY_SERVICE_STATE_DATE, false);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onServiceStateUpdate]" + (booleanExtra ? "on" : "off"));
                    }
                    if (this.mCallback != null) {
                        this.mCallback.onServiceStateUpdate(booleanExtra);
                    }
                    AppMethodBeat.o(13688);
                    return;
                } else if (TraeAudioManager.NOTIFY_DEVICELIST_UPDATE.equals(stringExtra)) {
                    String[] stringArrayExtra = intent.getStringArrayExtra(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST);
                    String stringExtra2 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE);
                    String stringExtra3 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE);
                    String stringExtra4 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME);
                    String str = "\n";
                    for (int i2 = 0; i2 < stringArrayExtra.length; i2++) {
                        str = str + "AudioSession|    " + i2 + " " + stringArrayExtra[i2] + "\n";
                        if (stringArrayExtra[i2].equals(TraeAudioManager.DEVICE_WIREDHEADSET) || stringArrayExtra[i2].equals(TraeAudioManager.DEVICE_BLUETOOTHHEADSET)) {
                            z = false;
                        }
                    }
                    String str2 = str + "\n";
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onDeviceListUpdate]  connected:" + stringExtra2 + " prevConnected:" + stringExtra3 + " bt:" + stringExtra4 + " Num:" + stringArrayExtra.length + str2);
                    }
                    this._canSwtich2Earphone = z;
                    this._connectedDev = stringExtra2;
                    if (this.mCallback != null) {
                        this.mCallback.onDeviceListUpdate(stringArrayExtra, stringExtra2, stringExtra3, stringExtra4);
                    }
                    AppMethodBeat.o(13688);
                    return;
                } else if (TraeAudioManager.NOTIFY_DEVICECHANGABLE_UPDATE.equals(stringExtra)) {
                    boolean booleanExtra2 = intent.getBooleanExtra(TraeAudioManager.NOTIFY_DEVICECHANGABLE_UPDATE_DATE, true);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onDeviceChangabledUpdate]".concat(String.valueOf(booleanExtra2)));
                    }
                    if (this.mCallback != null) {
                        this.mCallback.onDeviceChangabledUpdate(booleanExtra2);
                    }
                    AppMethodBeat.o(13688);
                    return;
                } else if (TraeAudioManager.NOTIFY_STREAMTYPE_UPDATE.equals(stringExtra)) {
                    int intExtra2 = intent.getIntExtra(TraeAudioManager.EXTRA_DATA_STREAMTYPE, -1);
                    if (intExtra != 0 && QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onStreamTypeUpdate] err:" + intExtra + " st:" + intExtra2);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.onStreamTypeUpdate(intExtra2);
                    }
                    AppMethodBeat.o(13688);
                    return;
                } else if (TraeAudioManager.NOTIFY_ROUTESWITCHSTART.equals(stringExtra)) {
                    String stringExtra5 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_ROUTESWITCHSTART_FROM);
                    String stringExtra6 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_ROUTESWITCHSTART_TO);
                    if (!(this.mCallback == null || stringExtra5 == null || stringExtra6 == null)) {
                        this.mCallback.onAudioRouteSwitchStart(stringExtra5, stringExtra6);
                    }
                    AppMethodBeat.o(13688);
                    return;
                } else if (TraeAudioManager.NOTIFY_ROUTESWITCHEND.equals(stringExtra)) {
                    String stringExtra7 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_ROUTESWITCHEND_DEV);
                    long longExtra2 = intent.getLongExtra(TraeAudioManager.EXTRA_DATA_ROUTESWITCHEND_TIME, -1);
                    if (!(this.mCallback == null || stringExtra7 == null || longExtra2 == -1)) {
                        this.mCallback.onAudioRouteSwitchEnd(stringExtra7, longExtra2);
                    }
                    AppMethodBeat.o(13688);
                    return;
                }
            } else if (TraeAudioManager.ACTION_TRAEAUDIOMANAGER_RES.equals(intent.getAction())) {
                if (this.mSessionId != longExtra) {
                    AppMethodBeat.o(13688);
                    return;
                } else if (TraeAudioManager.OPERATION_GETDEVICELIST.equals(stringExtra)) {
                    String[] stringArrayExtra2 = intent.getStringArrayExtra(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST);
                    String stringExtra8 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE);
                    String stringExtra9 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE);
                    String stringExtra10 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME);
                    String str3 = "\n";
                    for (int i3 = 0; i3 < stringArrayExtra2.length; i3++) {
                        str3 = str3 + "AudioSession|    " + i3 + " " + stringArrayExtra2[i3] + "\n";
                        if (stringArrayExtra2[i3].equals(TraeAudioManager.DEVICE_WIREDHEADSET) || stringArrayExtra2[i3].equals(TraeAudioManager.DEVICE_BLUETOOTHHEADSET)) {
                            z = false;
                        }
                    }
                    String str4 = str3 + "\n";
                    this._canSwtich2Earphone = z;
                    this._connectedDev = stringExtra8;
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onGetDeviceListRes] err:" + intExtra + " connected:" + stringExtra8 + " prevConnected:" + stringExtra9 + " bt:" + stringExtra10 + " Num:" + stringArrayExtra2.length + str4);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.onGetDeviceListRes(intExtra, stringArrayExtra2, stringExtra8, stringExtra9, stringExtra10);
                    }
                    AppMethodBeat.o(13688);
                    return;
                } else if (TraeAudioManager.OPERATION_CONNECTDEVICE.equals(stringExtra)) {
                    String stringExtra11 = intent.getStringExtra(TraeAudioManager.CONNECTDEVICE_RESULT_DEVICENAME);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onConnectDeviceRes] err:" + intExtra + " dev:" + stringExtra11);
                    }
                    if (this.mCallback != null) {
                        ITraeAudioCallback iTraeAudioCallback = this.mCallback;
                        if (intExtra == 0) {
                            z2 = true;
                        }
                        iTraeAudioCallback.onConnectDeviceRes(intExtra, stringExtra11, z2);
                    }
                    AppMethodBeat.o(13688);
                    return;
                } else if (TraeAudioManager.OPERATION_EARACTION.equals(stringExtra)) {
                    int intExtra3 = intent.getIntExtra(TraeAudioManager.EXTRA_EARACTION, -1);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onConnectDeviceRes] err:" + intExtra + " earAction:" + intExtra3);
                    }
                    AppMethodBeat.o(13688);
                    return;
                } else if (TraeAudioManager.OPERATION_ISDEVICECHANGABLED.equals(stringExtra)) {
                    boolean booleanExtra3 = intent.getBooleanExtra(TraeAudioManager.ISDEVICECHANGABLED_RESULT_ISCHANGABLED, false);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onIsDeviceChangabledRes] err:" + intExtra + " Changabled:" + (booleanExtra3 ? "Y" : "N"));
                    }
                    if (this.mCallback != null) {
                        this.mCallback.onIsDeviceChangabledRes(intExtra, booleanExtra3);
                    }
                    AppMethodBeat.o(13688);
                    return;
                } else if (TraeAudioManager.OPERATION_GETCONNECTEDDEVICE.equals(stringExtra)) {
                    String stringExtra12 = intent.getStringExtra(TraeAudioManager.GETCONNECTEDDEVICE_RESULT_LIST);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onGetConnectedDeviceRes] err:" + intExtra + " dev:" + stringExtra12);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.onGetConnectedDeviceRes(intExtra, stringExtra12);
                    }
                    AppMethodBeat.o(13688);
                    return;
                } else if (TraeAudioManager.OPERATION_GETCONNECTINGDEVICE.equals(stringExtra)) {
                    String stringExtra13 = intent.getStringExtra(TraeAudioManager.GETCONNECTINGDEVICE_RESULT_LIST);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onGetConnectingDeviceRes] err:" + intExtra + " dev:" + stringExtra13);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.onGetConnectingDeviceRes(intExtra, stringExtra13);
                    }
                    AppMethodBeat.o(13688);
                    return;
                } else if (TraeAudioManager.OPERATION_GETSTREAMTYPE.equals(stringExtra)) {
                    int intExtra4 = intent.getIntExtra(TraeAudioManager.EXTRA_DATA_STREAMTYPE, -1);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onGetStreamTypeRes] err:" + intExtra + " st:" + intExtra4);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.onGetStreamTypeRes(intExtra, intExtra4);
                    }
                    AppMethodBeat.o(13688);
                    return;
                } else if (TraeAudioManager.NOTIFY_RING_COMPLETION.equals(stringExtra)) {
                    String stringExtra14 = intent.getStringExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onRingCompletion] err:" + intExtra + " userData:" + stringExtra14);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.onRingCompletion(intExtra, stringExtra14);
                    }
                    AppMethodBeat.o(13688);
                    return;
                } else if (TraeAudioManager.OPERATION_VOICECALL_PREPROCESS.equals(stringExtra)) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onVoicecallPreprocess] err:".concat(String.valueOf(intExtra)));
                    }
                    if (this.mCallback != null) {
                        this.mCallback.onVoicecallPreprocessRes(intExtra);
                    }
                }
            }
            AppMethodBeat.o(13688);
        }
    }
}
