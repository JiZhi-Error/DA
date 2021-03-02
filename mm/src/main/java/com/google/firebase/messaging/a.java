package com.google.firebase.messaging;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public class a {
    private static final Pattern bMQ = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    private static a bMR;
    public final FirebaseInstanceId bLY;

    static {
        AppMethodBeat.i(116779);
        AppMethodBeat.o(116779);
    }

    private a(FirebaseInstanceId firebaseInstanceId) {
        this.bLY = firebaseInstanceId;
    }

    public static synchronized a yz() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(116778);
            if (bMR == null) {
                bMR = new a(FirebaseInstanceId.yc());
            }
            aVar = bMR;
            AppMethodBeat.o(116778);
        }
        return aVar;
    }
}
