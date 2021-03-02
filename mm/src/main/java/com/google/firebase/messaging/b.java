package com.google.firebase.messaging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class b extends Exception {
    private final int errorCode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    b(String str) {
        super(str);
        int i2 = 1;
        AppMethodBeat.i(116788);
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.US);
            char c2 = 65535;
            switch (lowerCase.hashCode()) {
                case -1743242157:
                    if (lowerCase.equals("service_not_available")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1290953729:
                    if (lowerCase.equals("toomanymessages")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -920906446:
                    if (lowerCase.equals("invalid_parameters")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -617027085:
                    if (lowerCase.equals("messagetoobig")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -95047692:
                    if (lowerCase.equals("missing_to")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 2:
                    i2 = 2;
                    break;
                case 3:
                    i2 = 3;
                    break;
                case 4:
                    i2 = 4;
                    break;
            }
            this.errorCode = i2;
            AppMethodBeat.o(116788);
        }
        i2 = 0;
        this.errorCode = i2;
        AppMethodBeat.o(116788);
    }
}
