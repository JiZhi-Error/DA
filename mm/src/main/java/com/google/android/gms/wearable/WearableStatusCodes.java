package com.google.android.gms.wearable;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class WearableStatusCodes extends CommonStatusCodes {
    public static final int ASSET_UNAVAILABLE = 4005;
    public static final int DATA_ITEM_TOO_LARGE = 4003;
    public static final int DUPLICATE_CAPABILITY = 4006;
    public static final int DUPLICATE_LISTENER = 4001;
    public static final int INVALID_TARGET_NODE = 4004;
    public static final int TARGET_NODE_NOT_CONNECTED = 4000;
    public static final int UNKNOWN_CAPABILITY = 4007;
    public static final int UNKNOWN_LISTENER = 4002;
    public static final int WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED = 4008;

    private WearableStatusCodes() {
    }

    public static String getStatusCodeString(int i2) {
        AppMethodBeat.i(100921);
        switch (i2) {
            case 4000:
                AppMethodBeat.o(100921);
                return "TARGET_NODE_NOT_CONNECTED";
            case 4001:
                AppMethodBeat.o(100921);
                return "DUPLICATE_LISTENER";
            case 4002:
                AppMethodBeat.o(100921);
                return "UNKNOWN_LISTENER";
            case DATA_ITEM_TOO_LARGE /*{ENCODED_INT: 4003}*/:
                AppMethodBeat.o(100921);
                return "DATA_ITEM_TOO_LARGE";
            case INVALID_TARGET_NODE /*{ENCODED_INT: 4004}*/:
                AppMethodBeat.o(100921);
                return "INVALID_TARGET_NODE";
            case ASSET_UNAVAILABLE /*{ENCODED_INT: 4005}*/:
                AppMethodBeat.o(100921);
                return "ASSET_UNAVAILABLE";
            default:
                String statusCodeString = CommonStatusCodes.getStatusCodeString(i2);
                AppMethodBeat.o(100921);
                return statusCodeString;
        }
    }
}
