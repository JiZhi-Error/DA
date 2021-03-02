package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class AudioPlayListItemParserFactory {
    public static AudioPlayListItemParser createParser(String str) {
        AppMethodBeat.i(76606);
        if (str.startsWith("http") || !str.endsWith(".cue")) {
            AppMethodBeat.o(76606);
            return null;
        }
        CueItemParser cueItemParser = new CueItemParser(str);
        AppMethodBeat.o(76606);
        return cueItemParser;
    }
}
