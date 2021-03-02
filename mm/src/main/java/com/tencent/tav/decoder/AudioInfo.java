package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class AudioInfo implements Cloneable {
    public int channelCount = 1;
    public int pcmEncoding = 2;
    public int sampleRate = 44100;

    public AudioInfo() {
    }

    public AudioInfo(int i2, int i3, int i4) {
        this.sampleRate = i2;
        this.channelCount = i3;
        this.pcmEncoding = i4;
    }

    @Override // java.lang.Object
    public AudioInfo clone() {
        AppMethodBeat.i(218119);
        AudioInfo audioInfo = new AudioInfo(this.sampleRate, this.channelCount, this.pcmEncoding);
        AppMethodBeat.o(218119);
        return audioInfo;
    }

    public String toString() {
        AppMethodBeat.i(218120);
        String str = "AudioInfo{sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + ", pcmEncoding=" + this.pcmEncoding + '}';
        AppMethodBeat.o(218120);
        return str;
    }
}
