package com.google.android.gms.common.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ApiException extends Exception {
    protected final Status mStatus;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ApiException(com.google.android.gms.common.api.Status r6) {
        /*
            r5 = this;
            r4 = 4463(0x116f, float:6.254E-42)
            int r1 = r6.getStatusCode()
            java.lang.String r0 = r6.getStatusMessage()
            if (r0 == 0) goto L_0x003e
            java.lang.String r0 = r6.getStatusMessage()
        L_0x0010:
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r2 = r2 + 13
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r2 = ": "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            r5.mStatus = r6
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return
        L_0x003e:
            java.lang.String r0 = ""
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.ApiException.<init>(com.google.android.gms.common.api.Status):void");
    }

    public int getStatusCode() {
        AppMethodBeat.i(4464);
        int statusCode = this.mStatus.getStatusCode();
        AppMethodBeat.o(4464);
        return statusCode;
    }

    @Deprecated
    public String getStatusMessage() {
        AppMethodBeat.i(4465);
        String statusMessage = this.mStatus.getStatusMessage();
        AppMethodBeat.o(4465);
        return statusMessage;
    }
}
