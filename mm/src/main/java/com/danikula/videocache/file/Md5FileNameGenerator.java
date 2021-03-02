package com.danikula.videocache.file;

import android.text.TextUtils;
import com.danikula.videocache.ProxyCacheUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Md5FileNameGenerator implements FileNameGenerator {
    private static final int MAX_EXTENSION_LENGTH = 4;

    @Override // com.danikula.videocache.file.FileNameGenerator
    public String generate(String str) {
        AppMethodBeat.i(183627);
        String extension = getExtension(str);
        String computeMD5 = ProxyCacheUtils.computeMD5(str);
        if (TextUtils.isEmpty(extension)) {
            AppMethodBeat.o(183627);
            return computeMD5;
        }
        String str2 = computeMD5 + "." + extension;
        AppMethodBeat.o(183627);
        return str2;
    }

    private String getExtension(String str) {
        AppMethodBeat.i(223213);
        int lastIndexOf = str.lastIndexOf(46);
        int lastIndexOf2 = str.lastIndexOf(47);
        if (lastIndexOf == -1 || lastIndexOf <= lastIndexOf2 || lastIndexOf + 2 + 4 <= str.length()) {
            AppMethodBeat.o(223213);
            return "";
        }
        String substring = str.substring(lastIndexOf + 1, str.length());
        AppMethodBeat.o(223213);
        return substring;
    }
}
