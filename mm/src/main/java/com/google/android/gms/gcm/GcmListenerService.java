package com.google.android.gms.gcm;

import android.os.Bundle;
import com.google.android.gms.iid.zze;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@Deprecated
public class GcmListenerService extends zze {
    static void zzd(Bundle bundle) {
        AppMethodBeat.i(3610);
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && next.startsWith("google.c.")) {
                it.remove();
            }
        }
        AppMethodBeat.o(3610);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0109  */
    @Override // com.google.android.gms.iid.zze
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleIntent(android.content.Intent r9) {
        /*
        // Method dump skipped, instructions count: 494
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.GcmListenerService.handleIntent(android.content.Intent):void");
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(String str, Bundle bundle) {
    }

    public void onMessageSent(String str) {
    }

    public void onSendError(String str, String str2) {
    }
}
