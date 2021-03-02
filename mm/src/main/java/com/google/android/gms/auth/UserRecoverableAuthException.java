package com.google.android.gms.auth;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class UserRecoverableAuthException extends GoogleAuthException {
    private final Intent mIntent;

    public UserRecoverableAuthException(String str, Intent intent) {
        super(str);
        this.mIntent = intent;
    }

    public Intent getIntent() {
        AppMethodBeat.i(10620);
        if (this.mIntent == null) {
            AppMethodBeat.o(10620);
            return null;
        }
        Intent intent = new Intent(this.mIntent);
        AppMethodBeat.o(10620);
        return intent;
    }
}
