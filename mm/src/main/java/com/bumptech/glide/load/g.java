package com.bumptech.glide.load;

import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public interface g {
    public static final Charset aEV = Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET);

    void a(MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
