package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.StringTokenizer;

public class VivoKTVHelper {
    private static final String KEY_EXT_SPKR = "vivo_ktv_ext_speaker";
    private static final String KEY_KTV_MODE = "vivo_ktv_mode";
    private static final String KEY_MIC_SRC = "vivo_ktv_rec_source";
    private static final String KEY_MIC_TYPE = "vivo_ktv_mic_type";
    private static final String KEY_PLAY_SRC = "vivo_ktv_play_source";
    private static final String KEY_PRESET = "vivo_ktv_preset_effect";
    private static final String KEY_VOL_MIC = "vivo_ktv_volume_mic";
    private static final String TAG = "VivoKTVHelper";
    private static VivoKTVHelper mVivoKTVHelper;
    private AudioManager mAudioManager;
    private Context mContext;
    private final Object mParamLock = new Object();

    public VivoKTVHelper(Context context) {
        AppMethodBeat.i(13762);
        this.mContext = context;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        AppMethodBeat.o(13762);
    }

    public static VivoKTVHelper getInstance(Context context) {
        AppMethodBeat.i(13763);
        if (mVivoKTVHelper == null) {
            mVivoKTVHelper = new VivoKTVHelper(context);
        }
        VivoKTVHelper vivoKTVHelper = mVivoKTVHelper;
        AppMethodBeat.o(13763);
        return vivoKTVHelper;
    }

    public boolean isDeviceSupportKaraoke() {
        int parseInt;
        AppMethodBeat.i(13764);
        if (Build.MODEL.trim().contains("vivo")) {
            StringTokenizer stringTokenizer = new StringTokenizer(this.mAudioManager.getParameters(KEY_MIC_TYPE), "=");
            if (stringTokenizer.countTokens() != 2) {
                AppMethodBeat.o(13764);
                return false;
            } else if (stringTokenizer.nextToken().equals(KEY_MIC_TYPE) && ((parseInt = Integer.parseInt(stringTokenizer.nextToken())) == 1 || parseInt == 0)) {
                AppMethodBeat.o(13764);
                return true;
            }
        }
        AppMethodBeat.o(13764);
        return false;
    }

    public void openKTVDevice() {
        AppMethodBeat.i(13765);
        this.mAudioManager.setParameters("vivo_ktv_mode=1");
        isDeviceSupportKaraoke();
        AppMethodBeat.o(13765);
    }

    public void closeKTVDevice() {
        AppMethodBeat.i(13766);
        this.mAudioManager.setParameters("vivo_ktv_mode=0");
        AppMethodBeat.o(13766);
    }

    public void setMicVolParam(int i2) {
        AppMethodBeat.i(13767);
        synchronized (this.mParamLock) {
            try {
                if (this.mAudioManager != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("vivo_ktv_volume_mic=").append(i2);
                    this.mAudioManager.setParameters(sb.toString());
                }
            } finally {
                AppMethodBeat.o(13767);
            }
        }
    }

    public void setVoiceOutParam(int i2) {
        AppMethodBeat.i(13768);
        synchronized (this.mParamLock) {
            try {
                if (this.mAudioManager != null) {
                    this.mAudioManager.setParameters("vivo_ktv_rec_source=".concat(String.valueOf(i2)));
                }
            } finally {
                AppMethodBeat.o(13768);
            }
        }
    }

    public void setPreModeParam(int i2) {
        AppMethodBeat.i(13769);
        synchronized (this.mParamLock) {
            try {
                if (this.mAudioManager != null) {
                    this.mAudioManager.setParameters("vivo_ktv_preset_effect=".concat(String.valueOf(i2)));
                }
            } finally {
                AppMethodBeat.o(13769);
            }
        }
    }

    public void setPlayFeedbackParam(int i2) {
        AppMethodBeat.i(13770);
        synchronized (this.mParamLock) {
            try {
                if (this.mAudioManager != null) {
                    this.mAudioManager.setParameters("vivo_ktv_play_source=".concat(String.valueOf(i2)));
                }
            } finally {
                AppMethodBeat.o(13770);
            }
        }
    }

    public void setExtSpeakerParam(int i2) {
        AppMethodBeat.i(13771);
        synchronized (this.mParamLock) {
            try {
                if (this.mAudioManager != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("vivo_ktv_ext_speaker=").append(i2);
                    this.mAudioManager.setParameters(sb.toString());
                }
            } finally {
                AppMethodBeat.o(13771);
            }
        }
    }

    public int getExtSpeakerParam() {
        AppMethodBeat.i(13772);
        int kTVParam = getKTVParam(KEY_EXT_SPKR);
        AppMethodBeat.o(13772);
        return kTVParam;
    }

    public int getPlayFeedbackParam() {
        AppMethodBeat.i(13773);
        int kTVParam = getKTVParam(KEY_PLAY_SRC);
        AppMethodBeat.o(13773);
        return kTVParam;
    }

    public int getPreModeParam() {
        AppMethodBeat.i(13774);
        int kTVParam = getKTVParam(KEY_PRESET);
        AppMethodBeat.o(13774);
        return kTVParam;
    }

    public int getMicTypeParam() {
        AppMethodBeat.i(13775);
        int kTVParam = getKTVParam(KEY_MIC_TYPE);
        AppMethodBeat.o(13775);
        return kTVParam;
    }

    public int getVoiceOutParam() {
        AppMethodBeat.i(13776);
        int kTVParam = getKTVParam(KEY_MIC_SRC);
        AppMethodBeat.o(13776);
        return kTVParam;
    }

    public int getMicVolParam() {
        AppMethodBeat.i(13777);
        int kTVParam = getKTVParam(KEY_VOL_MIC);
        AppMethodBeat.o(13777);
        return kTVParam;
    }

    private int getKTVParam(String str) {
        AppMethodBeat.i(13778);
        if (Build.MODEL.trim().contains("vivo")) {
            StringTokenizer stringTokenizer = new StringTokenizer(this.mAudioManager.getParameters(str), "=");
            if (stringTokenizer.countTokens() == 2 && str.equals(stringTokenizer.nextToken())) {
                int parseInt = Integer.parseInt(stringTokenizer.nextToken().trim());
                AppMethodBeat.o(13778);
                return parseInt;
            }
        }
        AppMethodBeat.o(13778);
        return 0;
    }
}
