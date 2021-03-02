package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MimeTypeMap extends z {

    /* renamed from: a  reason: collision with root package name */
    private static MimeTypeMap f1701a;

    private MimeTypeMap() {
    }

    public static String getFileExtensionFromUrl(String str) {
        AppMethodBeat.i(54575);
        if (isX5Core()) {
            String mimeTypeMapGetFileExtensionFromUrl = getCoreMessy().mimeTypeMapGetFileExtensionFromUrl(str);
            AppMethodBeat.o(54575);
            return mimeTypeMapGetFileExtensionFromUrl;
        }
        String fileExtensionFromUrl = android.webkit.MimeTypeMap.getFileExtensionFromUrl(str);
        AppMethodBeat.o(54575);
        return fileExtensionFromUrl;
    }

    public boolean hasMimeType(String str) {
        AppMethodBeat.i(54576);
        if (isX5Core()) {
            boolean mimeTypeMapHasMimeType = getCoreMessy().mimeTypeMapHasMimeType(str);
            AppMethodBeat.o(54576);
            return mimeTypeMapHasMimeType;
        }
        boolean hasMimeType = android.webkit.MimeTypeMap.getSingleton().hasMimeType(str);
        AppMethodBeat.o(54576);
        return hasMimeType;
    }

    public String getMimeTypeFromExtension(String str) {
        AppMethodBeat.i(54577);
        if (isX5Core()) {
            String mimeTypeMapGetMimeTypeFromExtension = getCoreMessy().mimeTypeMapGetMimeTypeFromExtension(str);
            AppMethodBeat.o(54577);
            return mimeTypeMapGetMimeTypeFromExtension;
        }
        String mimeTypeFromExtension = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        AppMethodBeat.o(54577);
        return mimeTypeFromExtension;
    }

    public boolean hasExtension(String str) {
        AppMethodBeat.i(54578);
        if (isX5Core()) {
            boolean mimeTypeMapHasExtension = getCoreMessy().mimeTypeMapHasExtension(str);
            AppMethodBeat.o(54578);
            return mimeTypeMapHasExtension;
        }
        boolean hasExtension = android.webkit.MimeTypeMap.getSingleton().hasExtension(str);
        AppMethodBeat.o(54578);
        return hasExtension;
    }

    public String getExtensionFromMimeType(String str) {
        AppMethodBeat.i(54579);
        if (isX5Core()) {
            String mimeTypeMapGetExtensionFromMimeType = getCoreMessy().mimeTypeMapGetExtensionFromMimeType(str);
            AppMethodBeat.o(54579);
            return mimeTypeMapGetExtensionFromMimeType;
        }
        String extensionFromMimeType = android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        AppMethodBeat.o(54579);
        return extensionFromMimeType;
    }

    public static synchronized MimeTypeMap getSingleton() {
        MimeTypeMap mimeTypeMap;
        synchronized (MimeTypeMap.class) {
            AppMethodBeat.i(54580);
            if (f1701a == null) {
                f1701a = new MimeTypeMap();
            }
            mimeTypeMap = f1701a;
            AppMethodBeat.o(54580);
        }
        return mimeTypeMap;
    }
}
