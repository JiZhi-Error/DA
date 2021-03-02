package com.tencent.mm.plugin.music.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import java.nio.ByteBuffer;

public final class c implements IDataSourceFactory {
    public ByteBuffer buffer;
    public e iJR;

    public c(e eVar) {
        this.iJR = eVar;
    }

    public c(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory
    public final IDataSource createDataSource() {
        AppMethodBeat.i(137426);
        if (this.buffer != null) {
            a aVar = new a(this.buffer);
            AppMethodBeat.o(137426);
            return aVar;
        }
        b bVar = new b(this.iJR);
        AppMethodBeat.o(137426);
        return bVar;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory
    public final INativeDataSource createNativeDataSource() {
        return null;
    }
}
