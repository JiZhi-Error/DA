package com.google.android.search.verification.client;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public abstract class SearchActionVerificationClientActivity extends HellActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public abstract Class<? extends SearchActionVerificationClientService> xP();

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, xP());
        intent.putExtra("SearchActionVerificationClientExtraIntent", getIntent());
        startService(intent);
        finish();
    }
}
