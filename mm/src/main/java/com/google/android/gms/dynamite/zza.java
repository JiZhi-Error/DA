package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zza implements DynamiteModule.VersionPolicy.IVersions {
    zza() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions
    public final int getLocalVersion(Context context, String str) {
        AppMethodBeat.i(5470);
        int localVersion = DynamiteModule.getLocalVersion(context, str);
        AppMethodBeat.o(5470);
        return localVersion;
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions
    public final int getRemoteVersion(Context context, String str, boolean z) {
        AppMethodBeat.i(5469);
        int remoteVersion = DynamiteModule.getRemoteVersion(context, str, z);
        AppMethodBeat.o(5469);
        return remoteVersion;
    }
}
