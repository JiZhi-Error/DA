package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum CameraEffectFeature implements DialogFeature {
    SHARE_CAMERA_EFFECT(NativeProtocol.PROTOCOL_VERSION_20170417);
    
    private int minVersion;

    public static CameraEffectFeature valueOf(String str) {
        AppMethodBeat.i(7966);
        CameraEffectFeature cameraEffectFeature = (CameraEffectFeature) Enum.valueOf(CameraEffectFeature.class, str);
        AppMethodBeat.o(7966);
        return cameraEffectFeature;
    }

    static {
        AppMethodBeat.i(7967);
        AppMethodBeat.o(7967);
    }

    private CameraEffectFeature(int i2) {
        this.minVersion = i2;
    }

    @Override // com.facebook.internal.DialogFeature
    public final String getAction() {
        return NativeProtocol.ACTION_CAMERA_EFFECT;
    }

    @Override // com.facebook.internal.DialogFeature
    public final int getMinVersion() {
        return this.minVersion;
    }
}
