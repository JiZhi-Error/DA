package com.google.android.gms.internal.auth;

import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;

public abstract class zzbs extends FastSafeParcelableJsonResponse {
    private static String zzhq = "AUTH";

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public byte[] toByteArray() {
        try {
            return toString().getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            return null;
        }
    }
}
