package com.tencent.mm.plugin.finder.view;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.nio.ByteBuffer;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010M\u001a\u00020NJ\b\u0010O\u001a\u00020NH\u0002J\u000e\u0010P\u001a\u00020N2\u0006\u0010Q\u001a\u00020\u000fJE\u0010R\u001a\u00020N2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020N0T2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020N0T2!\u0010V\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(Z\u0012\u0004\u0012\u00020N0WR\u000e\u0010\u0007\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\rR\u001a\u0010/\u001a\u000200X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u0010\u0013R\u001a\u00108\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0011\"\u0004\b:\u0010\u0013R\u0011\u0010;\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@X.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010GR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u0010L¨\u0006["}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker;", "", "path", "", "textureView", "Landroid/view/TextureView;", "(Ljava/lang/String;Landroid/view/TextureView;)V", "TAG", "canPauseInput", "", "getCanPauseInput", "()Z", "setCanPauseInput", "(Z)V", "curInputTimeUs", "", "getCurInputTimeUs", "()J", "setCurInputTimeUs", "(J)V", "curOutputTimeUs", "getCurOutputTimeUs", "setCurOutputTimeUs", "decoder", "Landroid/media/MediaCodec;", "getDecoder", "()Landroid/media/MediaCodec;", "setDecoder", "(Landroid/media/MediaCodec;)V", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "getExtractor", "()Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "setExtractor", "(Lcom/tencent/mm/compatible/video/VFSMediaExtractor;)V", "frameFlagExtractor", "getFrameFlagExtractor", "setFrameFlagExtractor", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "hasStart", "getHasStart", "setHasStart", "ht", "Landroid/os/HandlerThread;", "getHt", "()Landroid/os/HandlerThread;", "setHt", "(Landroid/os/HandlerThread;)V", "lastSeekTimeMs", "getLastSeekTimeMs", "setLastSeekTimeMs", "lastSyncFrameTimeUs", "getLastSyncFrameTimeUs", "setLastSyncFrameTimeUs", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "mime", "getMime", "()Ljava/lang/String;", "setMime", "(Ljava/lang/String;)V", "getPath", "getTextureView", "()Landroid/view/TextureView;", "destroy", "", "releaseDecoder", "seekTo", "timeMs", "start", "onTextureReady", "Lkotlin/Function0;", "onTextureDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class m {
    public final String TAG = "Finder.FinderVideoFrameSeeker";
    public final TextureView bec;
    public MediaCodec decoder;
    public MMHandler handler;
    public boolean hki;
    public c jto;
    public final Object lock = new Object();
    public MediaFormat mediaFormat;
    public String mime;
    public final String path;
    public c wpL;
    public HandlerThread wpM;
    public long wpN = -1;
    public long wpO = -1;
    private long wpP = -1;
    public long wpQ = -1;
    boolean wpR;

    public m(String str, TextureView textureView) {
        p.h(str, "path");
        p.h(textureView, "textureView");
        AppMethodBeat.i(255011);
        this.path = str;
        this.bec = textureView;
        AppMethodBeat.o(255011);
    }

    public final c dHm() {
        AppMethodBeat.i(255009);
        c cVar = this.jto;
        if (cVar == null) {
            p.btv("extractor");
        }
        AppMethodBeat.o(255009);
        return cVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-finder_release"})
    public static final class a implements TextureView.SurfaceTextureListener {
        final /* synthetic */ b wbp;
        final /* synthetic */ m wpS;
        final /* synthetic */ kotlin.g.a.a wpT;
        final /* synthetic */ kotlin.g.a.a wpU;

        public a(m mVar, kotlin.g.a.a aVar, b bVar, kotlin.g.a.a aVar2) {
            this.wpS = mVar;
            this.wpT = aVar;
            this.wbp = bVar;
            this.wpU = aVar2;
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(255007);
            this.wpS.releaseDecoder();
            this.wpT.invoke();
            AppMethodBeat.o(255007);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.finder.view.m$a$a  reason: collision with other inner class name */
        static final class RunnableC1340a implements Runnable {
            final /* synthetic */ a wpV;
            final /* synthetic */ SurfaceTexture wpW;

            RunnableC1340a(a aVar, SurfaceTexture surfaceTexture) {
                this.wpV = aVar;
                this.wpW = surfaceTexture;
            }

            public final void run() {
                AppMethodBeat.i(255006);
                if (this.wpV.wpS.decoder != null) {
                    this.wpV.wpS.releaseDecoder();
                }
                m mVar = this.wpV.wpS;
                String str = this.wpV.wpS.mime;
                if (str == null) {
                    p.btv("mime");
                }
                mVar.decoder = MediaCodec.createDecoderByType(str);
                MediaCodec mediaCodec = this.wpV.wpS.decoder;
                if (mediaCodec != null) {
                    mediaCodec.setCallback(new C1341a(this));
                    MediaFormat mediaFormat = this.wpV.wpS.mediaFormat;
                    if (mediaFormat == null) {
                        p.btv("mediaFormat");
                    }
                    mediaCodec.configure(mediaFormat, new Surface(this.wpW), (MediaCrypto) null, 0);
                    this.wpV.wpS.bec.post(new b(this));
                    AppMethodBeat.o(255006);
                    return;
                }
                AppMethodBeat.o(255006);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1$onSurfaceTextureAvailable$1$1$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "decoder", "inputIndex", "", "onOutputBufferAvailable", "outputIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-finder_release"})
            /* renamed from: com.tencent.mm.plugin.finder.view.m$a$a$a  reason: collision with other inner class name */
            public static final class C1341a extends MediaCodec.Callback {
                final /* synthetic */ RunnableC1340a wpX;

                C1341a(RunnableC1340a aVar) {
                    this.wpX = aVar;
                }

                public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
                    AppMethodBeat.i(255001);
                    p.h(mediaCodec, "decoder");
                    p.h(bufferInfo, "bufferInfo");
                    Log.i(this.wpX.wpV.wpS.TAG, "lxl onOutputBufferAvailable");
                    switch (i2) {
                        case -3:
                        case -2:
                        case -1:
                            mediaCodec.releaseOutputBuffer(i2, false);
                            AppMethodBeat.o(255001);
                            return;
                        default:
                            if (i2 >= 0) {
                                try {
                                    if ((bufferInfo.flags & 4) == 0) {
                                        if (bufferInfo.presentationTimeUs >= this.wpX.wpV.wpS.wpN * 1000) {
                                            mediaCodec.releaseOutputBuffer(i2, true);
                                            this.wpX.wpV.wbp.invoke(Long.valueOf(bufferInfo.presentationTimeUs));
                                            Log.i(this.wpX.wpV.wpS.TAG, "lxl releaseOutputBuffer " + (bufferInfo.presentationTimeUs / 1000) + ", render!");
                                            synchronized (this.wpX.wpV.wpS.lock) {
                                                try {
                                                    this.wpX.wpV.wpS.wpR = true;
                                                    x xVar = x.SXb;
                                                } catch (Throwable th) {
                                                    AppMethodBeat.o(255001);
                                                    throw th;
                                                }
                                            }
                                        } else {
                                            Log.i(this.wpX.wpV.wpS.TAG, "lxl releaseOutputBuffer " + (bufferInfo.presentationTimeUs / 1000) + ", no");
                                            mediaCodec.releaseOutputBuffer(i2, false);
                                        }
                                        this.wpX.wpV.wpS.wpQ = bufferInfo.presentationTimeUs;
                                        AppMethodBeat.o(255001);
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    Log.printErrStackTrace(this.wpX.wpV.wpS.TAG, th2, "lxl onOutputBufferAvailable exception", new Object[0]);
                                    AppMethodBeat.o(255001);
                                    return;
                                }
                            }
                            Log.i(this.wpX.wpV.wpS.TAG, "lxl releaseOutputBuffer BUFFER_FLAG_END_OF_STREAM");
                            mediaCodec.releaseOutputBuffer(i2, false);
                            AppMethodBeat.o(255001);
                            return;
                    }
                }

                public final void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
                    AppMethodBeat.i(255002);
                    p.h(mediaCodec, "decoder");
                    Log.i(this.wpX.wpV.wpS.TAG, "lxl onInputBufferAvailable");
                    synchronized (this.wpX.wpV.wpS.lock) {
                        if (i2 >= 0) {
                            try {
                                ByteBuffer inputBuffer = mediaCodec.getInputBuffer(i2);
                                c dHm = this.wpX.wpV.wpS.dHm();
                                if (inputBuffer == null) {
                                    p.hyc();
                                }
                                int readSampleData = dHm.readSampleData(inputBuffer, 0);
                                if (readSampleData < 0) {
                                    Log.i(this.wpX.wpV.wpS.TAG, "lxl queueInputBuffer BUFFER_FLAG_END_OF_STREAM");
                                    mediaCodec.queueInputBuffer(i2, 0, 0, 0, 4);
                                } else {
                                    mediaCodec.queueInputBuffer(i2, 0, readSampleData, this.wpX.wpV.wpS.dHm().getSampleTime(), 0);
                                    this.wpX.wpV.wpS.dHm().advance();
                                    Log.i(this.wpX.wpV.wpS.TAG, "lxl queueInputBuffer " + (this.wpX.wpV.wpS.dHm().getSampleTime() / 1000));
                                }
                                if (this.wpX.wpV.wpS.wpR) {
                                    this.wpX.wpV.wpS.lock.wait();
                                    this.wpX.wpV.wpS.wpR = false;
                                }
                            } catch (Throwable th) {
                                Log.printErrStackTrace(this.wpX.wpV.wpS.TAG, th, "lxl onInputBufferAvailable exception", new Object[0]);
                            }
                        }
                        try {
                            x xVar = x.SXb;
                        } finally {
                            AppMethodBeat.o(255002);
                        }
                    }
                }

                public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
                    AppMethodBeat.i(255003);
                    p.h(mediaCodec, "codec");
                    p.h(mediaFormat, "format");
                    AppMethodBeat.o(255003);
                }

                public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
                    AppMethodBeat.i(255004);
                    p.h(mediaCodec, "codec");
                    p.h(codecException, "e");
                    AppMethodBeat.o(255004);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1$onSurfaceTextureAvailable$1$1$2"})
            /* renamed from: com.tencent.mm.plugin.finder.view.m$a$a$b */
            static final class b implements Runnable {
                final /* synthetic */ RunnableC1340a wpX;

                b(RunnableC1340a aVar) {
                    this.wpX = aVar;
                }

                public final void run() {
                    AppMethodBeat.i(255005);
                    this.wpX.wpV.wpU.invoke();
                    AppMethodBeat.o(255005);
                }
            }
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(255008);
            MMHandler mMHandler = this.wpS.handler;
            if (mMHandler == null) {
                p.btv("handler");
            }
            mMHandler.post(new RunnableC1340a(this, surfaceTexture));
            AppMethodBeat.o(255008);
        }
    }

    public final void releaseDecoder() {
        AppMethodBeat.i(255010);
        MediaCodec mediaCodec = this.decoder;
        if (mediaCodec != null) {
            mediaCodec.stop();
        }
        MediaCodec mediaCodec2 = this.decoder;
        if (mediaCodec2 != null) {
            mediaCodec2.release();
        }
        this.decoder = null;
        AppMethodBeat.o(255010);
    }
}
