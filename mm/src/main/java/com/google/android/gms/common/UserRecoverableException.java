package com.google.android.gms.common;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class UserRecoverableException extends Exception {
    private final Intent mIntent;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.mIntent = intent;
    }

    public Intent getIntent() {
        AppMethodBeat.i(4462);
        Intent intent = new Intent(this.mIntent);
        AppMethodBeat.o(4462);
        return intent;
    }
}
