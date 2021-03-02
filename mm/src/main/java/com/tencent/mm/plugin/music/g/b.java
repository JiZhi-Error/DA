package com.tencent.mm.plugin.music.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public final class b implements IDataSource {
    public e iJR;

    public b(e eVar) {
        this.iJR = eVar;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public final void open() {
        AppMethodBeat.i(137421);
        Logger.i("MicroMsg.Audio.InputStreamDataSource", WeChatBrands.Business.GROUP_OPEN);
        if (this.iJR != null) {
            this.iJR.open();
        }
        AppMethodBeat.o(137421);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public final int readAt(long j2, byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(137422);
        if (this.iJR == null) {
            Logger.e("MicroMsg.Audio.InputStreamDataSource", "[readAt]audioDataSource is null");
            AppMethodBeat.o(137422);
            return -1;
        }
        int readAt = this.iJR.readAt(j2, bArr, i2, i3);
        AppMethodBeat.o(137422);
        return readAt;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public final long getSize() {
        AppMethodBeat.i(137423);
        if (this.iJR != null) {
            long size = this.iJR.getSize();
            AppMethodBeat.o(137423);
            return size;
        }
        AppMethodBeat.o(137423);
        return 0;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public final AudioFormat.AudioType getAudioType() {
        AppMethodBeat.i(137424);
        if (this.iJR == null) {
            Logger.e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
            AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
            AppMethodBeat.o(137424);
            return audioType;
        }
        Logger.i("MicroMsg.Audio.InputStreamDataSource", "getAudioType:" + this.iJR.aYm());
        switch (this.iJR.aYm()) {
            case 0:
                AudioFormat.AudioType audioType2 = AudioFormat.AudioType.UNSUPPORT;
                AppMethodBeat.o(137424);
                return audioType2;
            case 1:
                AudioFormat.AudioType audioType3 = AudioFormat.AudioType.AAC;
                AppMethodBeat.o(137424);
                return audioType3;
            case 2:
                AudioFormat.AudioType audioType4 = AudioFormat.AudioType.MP3;
                AppMethodBeat.o(137424);
                return audioType4;
            case 3:
                AudioFormat.AudioType audioType5 = AudioFormat.AudioType.WAV;
                AppMethodBeat.o(137424);
                return audioType5;
            case 4:
                AudioFormat.AudioType audioType6 = AudioFormat.AudioType.OGG;
                AppMethodBeat.o(137424);
                return audioType6;
            default:
                Logger.e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
                AudioFormat.AudioType audioType7 = AudioFormat.AudioType.UNSUPPORT;
                AppMethodBeat.o(137424);
                return audioType7;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(137425);
        Logger.i("MicroMsg.Audio.InputStreamDataSource", "close");
        if (this.iJR != null) {
            this.iJR.close();
        }
        AppMethodBeat.o(137425);
    }
}
