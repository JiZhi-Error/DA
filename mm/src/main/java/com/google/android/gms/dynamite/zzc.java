package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzc implements DynamiteModule.VersionPolicy {
    zzc() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) {
        AppMethodBeat.i(5472);
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        selectionResult.localVersion = iVersions.getLocalVersion(context, str);
        if (selectionResult.localVersion != 0) {
            selectionResult.selection = -1;
        } else {
            selectionResult.remoteVersion = iVersions.getRemoteVersion(context, str, true);
            if (selectionResult.remoteVersion != 0) {
                selectionResult.selection = 1;
            }
        }
        AppMethodBeat.o(5472);
        return selectionResult;
    }
}
