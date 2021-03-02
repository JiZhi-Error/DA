package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ShareStoryFeature implements DialogFeature {
    SHARE_STORY_ASSET(NativeProtocol.PROTOCOL_VERSION_20170417);
    
    private int minVersion;

    public static ShareStoryFeature valueOf(String str) {
        AppMethodBeat.i(8333);
        ShareStoryFeature shareStoryFeature = (ShareStoryFeature) Enum.valueOf(ShareStoryFeature.class, str);
        AppMethodBeat.o(8333);
        return shareStoryFeature;
    }

    static {
        AppMethodBeat.i(8334);
        AppMethodBeat.o(8334);
    }

    private ShareStoryFeature(int i2) {
        this.minVersion = i2;
    }

    @Override // com.facebook.internal.DialogFeature
    public final String getAction() {
        return NativeProtocol.ACTION_SHARE_STORY;
    }

    @Override // com.facebook.internal.DialogFeature
    public final int getMinVersion() {
        return this.minVersion;
    }
}
