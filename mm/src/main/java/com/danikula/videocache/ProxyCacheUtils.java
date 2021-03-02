package com.danikula.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ProxyCacheUtils {
    static final int DEFAULT_BUFFER_SIZE = 8192;
    static final int MAX_ARRAY_PREVIEW = 16;

    static String getSupposablyMime(String str) {
        AppMethodBeat.i(223195);
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            AppMethodBeat.o(223195);
            return null;
        }
        String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
        AppMethodBeat.o(223195);
        return mimeTypeFromExtension;
    }

    static void assertBuffer(byte[] bArr, long j2, int i2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(223196);
        Preconditions.checkNotNull(bArr, "Buffer must be not null!");
        if (j2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Data offset must be positive!");
        if (i2 < 0 || i2 > bArr.length) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "Length must be in range [0..buffer.length]");
        AppMethodBeat.o(223196);
    }

    static String preview(byte[] bArr, int i2) {
        AppMethodBeat.i(223197);
        int min = Math.min(16, Math.max(i2, 0));
        String arrays = Arrays.toString(Arrays.copyOfRange(bArr, 0, min));
        if (min < i2) {
            arrays = arrays.substring(0, arrays.length() - 1) + ", ...]";
        }
        AppMethodBeat.o(223197);
        return arrays;
    }

    static String encode(String str) {
        AppMethodBeat.i(183613);
        try {
            String encode = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            AppMethodBeat.o(183613);
            return encode;
        } catch (UnsupportedEncodingException e2) {
            RuntimeException runtimeException = new RuntimeException("Error encoding url", e2);
            AppMethodBeat.o(183613);
            throw runtimeException;
        }
    }

    static String decode(String str) {
        AppMethodBeat.i(183614);
        try {
            String decode = URLDecoder.decode(str, ProtocolPackage.ServerEncoding);
            AppMethodBeat.o(183614);
            return decode;
        } catch (UnsupportedEncodingException e2) {
            RuntimeException runtimeException = new RuntimeException("Error decoding url", e2);
            AppMethodBeat.o(183614);
            throw runtimeException;
        }
    }

    static void close(Closeable closeable) {
        AppMethodBeat.i(183615);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(183615);
                return;
            } catch (IOException e2) {
                Logger.error("Error closing resource");
            }
        }
        AppMethodBeat.o(183615);
    }

    public static String computeMD5(String str) {
        AppMethodBeat.i(183616);
        try {
            String bytesToHexString = bytesToHexString(MessageDigest.getInstance("MD5").digest(str.getBytes()));
            AppMethodBeat.o(183616);
            return bytesToHexString;
        } catch (NoSuchAlgorithmException e2) {
            IllegalStateException illegalStateException = new IllegalStateException(e2);
            AppMethodBeat.o(183616);
            throw illegalStateException;
        }
    }

    private static String bytesToHexString(byte[] bArr) {
        AppMethodBeat.i(223198);
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i2])));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(223198);
        return stringBuffer2;
    }
}
