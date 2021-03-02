package com.tencent.mm.plugin.account.ui;

import com.google.android.search.verification.client.SearchActionVerificationClientActivity;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.model.VoiceActionService;
import com.tencent.mm.sdk.platformtools.Log;

public class VoiceActionActivity extends SearchActionVerificationClientActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.google.android.search.verification.client.SearchActionVerificationClientActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.google.android.search.verification.client.SearchActionVerificationClientActivity
    public final Class<? extends SearchActionVerificationClientService> xP() {
        AppMethodBeat.i(128793);
        Log.d("MicroMsg.VoiceActionActivity", "getServiceClass");
        AppMethodBeat.o(128793);
        return VoiceActionService.class;
    }
}
