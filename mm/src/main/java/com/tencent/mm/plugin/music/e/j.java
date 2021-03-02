package com.tencent.mm.plugin.music.e;

import android.media.AudioTrack;
import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class j implements b {
    @Override // com.tencent.mm.plugin.music.e.b
    public MediaPlayer etV() {
        AppMethodBeat.i(137282);
        MediaPlayer mediaPlayer = new MediaPlayer();
        AppMethodBeat.o(137282);
        return mediaPlayer;
    }

    @Override // com.tencent.mm.plugin.music.e.b
    public AudioTrack as(int i2, int i3, int i4) {
        AppMethodBeat.i(137283);
        AudioTrack audioTrack = new AudioTrack(3, i2, i3, 2, i4, 1);
        AppMethodBeat.o(137283);
        return audioTrack;
    }
}
