package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

/* access modifiers changed from: package-private */
public abstract class CharsetRecognizer {
    /* access modifiers changed from: package-private */
    public abstract String getName();

    /* access modifiers changed from: package-private */
    public abstract CharsetMatch match(CharsetDetector charsetDetector);

    CharsetRecognizer() {
    }

    public String getLanguage() {
        return null;
    }
}
