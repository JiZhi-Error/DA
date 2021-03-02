package com.tencent.liteav.trtc.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloudDef;
import java.util.ArrayList;
import java.util.Iterator;

public class TRTCTranscodingConfigInner extends TRTCCloudDef.TRTCTranscodingConfig {
    public String backgroundURL = "";
    public String mixExtraInfo = "";

    public TRTCTranscodingConfigInner() {
    }

    public TRTCTranscodingConfigInner(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
        AppMethodBeat.i(222390);
        this.appId = tRTCTranscodingConfig.appId;
        this.bizId = tRTCTranscodingConfig.bizId;
        this.mode = tRTCTranscodingConfig.mode;
        this.videoWidth = tRTCTranscodingConfig.videoWidth;
        this.videoHeight = tRTCTranscodingConfig.videoHeight;
        this.videoBitrate = tRTCTranscodingConfig.videoBitrate;
        this.videoFramerate = tRTCTranscodingConfig.videoFramerate;
        this.videoGOP = tRTCTranscodingConfig.videoGOP;
        this.backgroundColor = tRTCTranscodingConfig.backgroundColor;
        this.backgroundImage = tRTCTranscodingConfig.backgroundImage;
        this.audioSampleRate = tRTCTranscodingConfig.audioSampleRate;
        this.audioBitrate = tRTCTranscodingConfig.audioBitrate;
        this.audioChannels = tRTCTranscodingConfig.audioChannels;
        this.streamId = tRTCTranscodingConfig.streamId;
        this.mixUsers = new ArrayList();
        if (tRTCTranscodingConfig.mixUsers != null) {
            Iterator<TRTCCloudDef.TRTCMixUser> it = tRTCTranscodingConfig.mixUsers.iterator();
            while (it.hasNext()) {
                TRTCCloudDef.TRTCMixUser next = it.next();
                if (next != null) {
                    this.mixUsers.add(new TRTCMixUserInner(next));
                }
            }
        }
        AppMethodBeat.o(222390);
    }

    @Override // com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig
    public String toString() {
        AppMethodBeat.i(222391);
        String str = "backgroundURL=" + this.backgroundURL + ", mixExtraInfo=" + this.mixExtraInfo + ", " + super.toString();
        AppMethodBeat.o(222391);
        return str;
    }

    public static class TRTCMixUserInner extends TRTCCloudDef.TRTCMixUser {
        public String streamId = "";

        public TRTCMixUserInner() {
        }

        public TRTCMixUserInner(String str, int i2, int i3, int i4, int i5, int i6) {
            super(str, i2, i3, i4, i5, i6);
        }

        public TRTCMixUserInner(TRTCCloudDef.TRTCMixUser tRTCMixUser) {
            super(tRTCMixUser);
        }

        @Override // com.tencent.trtc.TRTCCloudDef.TRTCMixUser
        public String toString() {
            AppMethodBeat.i(222397);
            String str = super.toString() + ", streamId=" + this.streamId;
            AppMethodBeat.o(222397);
            return str;
        }
    }
}
