package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public enum LikeDialogFeature implements DialogFeature {
    LIKE_DIALOG(NativeProtocol.PROTOCOL_VERSION_20140701);
    
    private int minVersion;

    public static LikeDialogFeature valueOf(String str) {
        AppMethodBeat.i(8144);
        LikeDialogFeature likeDialogFeature = (LikeDialogFeature) Enum.valueOf(LikeDialogFeature.class, str);
        AppMethodBeat.o(8144);
        return likeDialogFeature;
    }

    static {
        AppMethodBeat.i(8145);
        AppMethodBeat.o(8145);
    }

    private LikeDialogFeature(int i2) {
        this.minVersion = i2;
    }

    @Override // com.facebook.internal.DialogFeature
    public final String getAction() {
        return NativeProtocol.ACTION_LIKE_DIALOG;
    }

    @Override // com.facebook.internal.DialogFeature
    public final int getMinVersion() {
        return this.minVersion;
    }
}
