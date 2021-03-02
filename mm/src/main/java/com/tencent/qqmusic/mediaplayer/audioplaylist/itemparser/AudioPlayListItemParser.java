package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetDetector;
import java.util.Iterator;

public abstract class AudioPlayListItemParser {
    public static final String TAG = "AudioListItemParser";
    protected CharsetDetector charsetDetector = new CharsetDetector();
    protected String mUri;

    public abstract boolean isParseSuccess();

    public abstract Iterator<TrackInfo> iterator();

    public abstract void parse();

    protected static String delSeprator(String str) {
        return str.substring(str.indexOf("\"") + 1, str.lastIndexOf("\""));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005b A[SYNTHETIC, Splitter:B:18:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006e A[SYNTHETIC, Splitter:B:25:0x006e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String guessCharsetEncoding(java.io.InputStream r7) {
        /*
        // Method dump skipped, instructions count: 129
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.AudioPlayListItemParser.guessCharsetEncoding(java.io.InputStream):java.lang.String");
    }
}
