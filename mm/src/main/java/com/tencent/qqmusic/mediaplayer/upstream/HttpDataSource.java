package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import java.net.URL;
import java.util.Map;

public class HttpDataSource implements IDataSource {
    private final Map<String, String> headers;
    private IMediaHTTPConnection mediaHTTPConnection;
    private final IMediaHTTPService service;
    private final Uri uri;

    public HttpDataSource(Uri uri2, Map<String, String> map, IMediaHTTPService iMediaHTTPService) {
        this.uri = uri2;
        this.headers = map;
        this.service = iMediaHTTPService;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public void open() {
        AppMethodBeat.i(76540);
        this.mediaHTTPConnection = this.service.makeHTTPConnection();
        this.mediaHTTPConnection.connect(new URL(this.uri.toString()), this.headers);
        AppMethodBeat.o(76540);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public int readAt(long j2, byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(76541);
        int i4 = 0;
        do {
            int i5 = i2 + i4;
            int readAt = this.mediaHTTPConnection.readAt(((long) i4) + j2, bArr, i5, i3 - i5);
            if (readAt >= 0) {
                if (readAt == 0) {
                    break;
                }
                i4 += readAt;
            } else {
                AppMethodBeat.o(76541);
                return readAt;
            }
        } while (i4 < i3);
        AppMethodBeat.o(76541);
        return i4;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public long getSize() {
        AppMethodBeat.i(76542);
        long size = this.mediaHTTPConnection.getSize();
        AppMethodBeat.o(76542);
        return size;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public AudioFormat.AudioType getAudioType() {
        AppMethodBeat.i(76543);
        AudioFormat.AudioType audioFormat = FormatDetector.getAudioFormat((IDataSource) this, false);
        AppMethodBeat.o(76543);
        return audioFormat;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(76544);
        if (this.mediaHTTPConnection != null) {
            this.mediaHTTPConnection.disconnect();
        }
        AppMethodBeat.o(76544);
    }
}
