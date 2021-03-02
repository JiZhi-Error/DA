package com.tencent.tav.decoder.muxer;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MediaMuxerFactory {
    private static DefaultMediaMuxerCreator defaultMuxerCreator = new DefaultMediaMuxerCreator();
    private static MediaMuxerCreator muxerCreator = null;

    public interface MediaMuxerCreator {
        IMediaMuxer createMediaMuxer(String str, int i2);
    }

    static class DefaultMediaMuxerCreator implements MediaMuxerCreator {
        private DefaultMediaMuxerCreator() {
        }

        @Override // com.tencent.tav.decoder.muxer.MediaMuxerFactory.MediaMuxerCreator
        public IMediaMuxer createMediaMuxer(String str, int i2) {
            AppMethodBeat.i(218465);
            DefaultMediaMuxer defaultMediaMuxer = new DefaultMediaMuxer(str, i2);
            AppMethodBeat.o(218465);
            return defaultMediaMuxer;
        }
    }

    static {
        AppMethodBeat.i(218467);
        AppMethodBeat.o(218467);
    }

    public static void setMuxerCreator(MediaMuxerCreator mediaMuxerCreator) {
        muxerCreator = mediaMuxerCreator;
    }

    public static IMediaMuxer createMediaMuxer(String str, int i2) {
        AppMethodBeat.i(218466);
        if (muxerCreator == null) {
            IMediaMuxer createMediaMuxer = defaultMuxerCreator.createMediaMuxer(str, i2);
            AppMethodBeat.o(218466);
            return createMediaMuxer;
        }
        IMediaMuxer createMediaMuxer2 = muxerCreator.createMediaMuxer(str, i2);
        AppMethodBeat.o(218466);
        return createMediaMuxer2;
    }
}
