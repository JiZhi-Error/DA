package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.core.biometric.FaceManager;

public final class bg extends bi {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.bi
    public final void a(Context context, Intent intent, boolean z) {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.bi
    public final int z(Intent intent) {
        AppMethodBeat.i(44001);
        int intExtra = intent.getIntExtra("SCENE", -1);
        if (intExtra == 2) {
            AppMethodBeat.o(44001);
            return FaceManager.FACE_ACQUIRED_RIGHT;
        } else if (intExtra == 1) {
            AppMethodBeat.o(44001);
            return FaceManager.FACE_ACQUIRED_LEFT;
        } else {
            AppMethodBeat.o(44001);
            return -1;
        }
    }

    @Override // com.tencent.mm.plugin.x.a, com.tencent.mm.plugin.x.b
    public final int getType() {
        return 3;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.bi
    public final boolean b(Intent intent, boolean z) {
        boolean z2;
        AppMethodBeat.i(44002);
        boolean b2 = super.b(intent, z);
        if (z(intent) == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            Log.i("MiroMsg.WxaManufacturerShortcutEntry", "invalid scene ");
        }
        if (z2 || !b2) {
            AppMethodBeat.o(44002);
            return false;
        }
        AppMethodBeat.o(44002);
        return true;
    }
}
