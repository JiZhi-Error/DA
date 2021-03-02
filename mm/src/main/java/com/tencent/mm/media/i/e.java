package com.tencent.mm.media.i;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.d.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.nio.ByteBuffer;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010#\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010$\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010&\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000bJD\u0010'\u001a\u00020\u00102<\b\u0002\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nJ\b\u0010(\u001a\u00020\u0010H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000RB\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R.\u0010\u001a\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u001bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100 X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect;", "", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "calbackInMainThread", "", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Z)V", "TAG", "", "callback", "Lkotlin/Function2;", "Landroid/media/MediaFormat;", "Lkotlin/ParameterName;", "name", "mediaFormat", "checker", "", "decodeThread", "Landroid/os/HandlerThread;", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invokeCallback", "lock", "Ljava/lang/Object;", "onDecode", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "Landroid/media/MediaCodec$BufferInfo;", "onFormatChanged", "Lkotlin/Function1;", "getCropBottom", "", "getCropLeft", "getCropRight", "getCropTop", "hasCropRect", "startCheck", "stopDecoder", "plugin-mediaeditor_release"})
public final class e {
    public final String TAG;
    public m<? super MediaFormat, ? super e, x> gWp;
    final MMHandler handler;
    final kotlin.g.a.b<MediaFormat, x> ieq;
    public f ihG;
    boolean ihH;
    public HandlerThread ihI;
    final r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, x> ihJ;
    public final com.tencent.mm.media.f.a ihK;
    final Object lock;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
    static final class a extends q implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, x> {
        final /* synthetic */ e ihL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e eVar) {
            super(4);
            this.ihL = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(ByteBuffer byteBuffer, Long l, MediaCodec.BufferInfo bufferInfo, Boolean bool) {
            MediaFormat mediaFormat;
            MediaFormat mediaFormat2 = null;
            AppMethodBeat.i(184139);
            long longValue = l.longValue();
            bool.booleanValue();
            p.h(bufferInfo, "<anonymous parameter 2>");
            String str = this.ihL.TAG;
            StringBuilder sb = new StringBuilder("onDecode, format:");
            f fVar = this.ihL.ihG;
            if (fVar != null) {
                mediaFormat = fVar.mediaFormat;
            } else {
                mediaFormat = null;
            }
            Log.i(str, sb.append(mediaFormat).append(", pts:").append(longValue).toString());
            synchronized (this.ihL.lock) {
                try {
                    f fVar2 = this.ihL.ihG;
                    if (fVar2 != null) {
                        mediaFormat2 = fVar2.mediaFormat;
                    }
                    if (!this.ihL.ihH) {
                        e.a(this.ihL);
                        this.ihL.handler.post(new RunnableC0418a(mediaFormat2, this));
                        this.ihL.ihH = true;
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(184139);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(184139);
            return xVar2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect$onDecode$1$1$1"})
        /* renamed from: com.tencent.mm.media.i.e$a$a  reason: collision with other inner class name */
        static final class RunnableC0418a implements Runnable {
            final /* synthetic */ MediaFormat ihM;
            final /* synthetic */ a ihN;

            RunnableC0418a(MediaFormat mediaFormat, a aVar) {
                this.ihM = mediaFormat;
                this.ihN = aVar;
            }

            public final void run() {
                AppMethodBeat.i(93763);
                m<? super MediaFormat, ? super e, x> mVar = this.ihN.ihL.gWp;
                if (mVar != null) {
                    mVar.invoke(this.ihM, this.ihN.ihL);
                    AppMethodBeat.o(93763);
                    return;
                }
                AppMethodBeat.o(93763);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "mediaFormat", "Landroid/media/MediaFormat;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<MediaFormat, x> {
        final /* synthetic */ e ihL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar) {
            super(1);
            this.ihL = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(MediaFormat mediaFormat) {
            AppMethodBeat.i(93766);
            MediaFormat mediaFormat2 = mediaFormat;
            p.h(mediaFormat2, "mediaFormat");
            Log.i(this.ihL.TAG, "onFormatChanged, format:".concat(String.valueOf(mediaFormat2)));
            synchronized (this.ihL.lock) {
                try {
                    if (!this.ihL.ihH) {
                        e.a(this.ihL);
                        this.ihL.handler.post(new a(this, mediaFormat2));
                        this.ihL.ihH = true;
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(93766);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(93766);
            return xVar2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect$onFormatChanged$1$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ b ihO;
            final /* synthetic */ MediaFormat ihP;

            a(b bVar, MediaFormat mediaFormat) {
                this.ihO = bVar;
                this.ihP = mediaFormat;
            }

            public final void run() {
                AppMethodBeat.i(93765);
                m<? super MediaFormat, ? super e, x> mVar = this.ihO.ihL.gWp;
                if (mVar != null) {
                    mVar.invoke(this.ihP, this.ihO.ihL);
                    AppMethodBeat.o(93765);
                    return;
                }
                AppMethodBeat.o(93765);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<f, x> {
        final /* synthetic */ e ihL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(e eVar) {
            super(1);
            this.ihL = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(f fVar) {
            AppMethodBeat.i(93767);
            f fVar2 = fVar;
            p.h(fVar2, "$receiver");
            fVar2.ieo = this.ihL.ihJ;
            fVar2.ieq = this.ihL.ieq;
            x xVar = x.SXb;
            AppMethodBeat.o(93767);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<f, x> {
        final /* synthetic */ e ihL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(e eVar) {
            super(1);
            this.ihL = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(f fVar) {
            AppMethodBeat.i(93768);
            f fVar2 = fVar;
            p.h(fVar2, "$receiver");
            fVar2.ieo = this.ihL.ihJ;
            fVar2.ieq = this.ihL.ieq;
            x xVar = x.SXb;
            AppMethodBeat.o(93768);
            return xVar;
        }
    }

    private e(com.tencent.mm.media.f.a aVar) {
        p.h(aVar, "mediaExtractor");
        AppMethodBeat.i(93776);
        this.ihK = aVar;
        this.lock = new Object();
        this.TAG = "MicroMsg.MediaCodecCheckVideoCropRect";
        Looper myLooper = Looper.myLooper();
        this.handler = new MMHandler(myLooper == null ? Looper.getMainLooper() : myLooper);
        Log.i(this.TAG, "create MediaCodecCheckVideoCropRect");
        this.ihK.aMq();
        this.ihJ = new a(this);
        this.ieq = new b(this);
        AppMethodBeat.o(93776);
    }

    public /* synthetic */ e(com.tencent.mm.media.f.a aVar, byte b2) {
        this(aVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, hxF = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
    /* renamed from: com.tencent.mm.media.i.e$e  reason: collision with other inner class name */
    public static final class C0419e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e ihL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0419e(e eVar) {
            super(0);
            this.ihL = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(93769);
            f fVar = this.ihL.ihG;
            if (fVar != null) {
                fVar.startDecode();
                x xVar = x.SXb;
                AppMethodBeat.o(93769);
                return xVar;
            }
            AppMethodBeat.o(93769);
            return null;
        }
    }

    public static final /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(93777);
        Log.i(eVar.TAG, "stopDecoder");
        f fVar = eVar.ihG;
        if (fVar != null) {
            fVar.releaseDecoder();
        }
        HandlerThread handlerThread = eVar.ihI;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            AppMethodBeat.o(93777);
            return;
        }
        AppMethodBeat.o(93777);
    }
}
