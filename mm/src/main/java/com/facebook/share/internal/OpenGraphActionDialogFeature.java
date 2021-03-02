package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum OpenGraphActionDialogFeature implements DialogFeature {
    OG_ACTION_DIALOG(NativeProtocol.PROTOCOL_VERSION_20130618);
    
    private int minVersion;

    public static OpenGraphActionDialogFeature valueOf(String str) {
        AppMethodBeat.i(8184);
        OpenGraphActionDialogFeature openGraphActionDialogFeature = (OpenGraphActionDialogFeature) Enum.valueOf(OpenGraphActionDialogFeature.class, str);
        AppMethodBeat.o(8184);
        return openGraphActionDialogFeature;
    }

    static {
        AppMethodBeat.i(8185);
        AppMethodBeat.o(8185);
    }

    private OpenGraphActionDialogFeature(int i2) {
        this.minVersion = i2;
    }

    @Override // com.facebook.internal.DialogFeature
    public final String getAction() {
        return NativeProtocol.ACTION_OGACTIONPUBLISH_DIALOG;
    }

    @Override // com.facebook.internal.DialogFeature
    public final int getMinVersion() {
        return this.minVersion;
    }
}
