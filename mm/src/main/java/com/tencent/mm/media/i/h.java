package com.tencent.mm.media.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.d;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JW\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002Jg\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerFactory;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer$Factory;", "()V", "get", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "filePath", "", "outputFilePath", "outputWidth", "", "outputHeight", "outputBitrate", "outputFps", "minQP", "maxQP", "callback", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer$FinishCallback;", "startTimeMs", "", "endTimeMs", "plugin-mediaeditor_release"})
public final class h implements d.a {
    public static final h ijh = new h();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "path", "", "invoke"})
    static final class a extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ d.b iji;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d.b bVar) {
            super(1);
            this.iji = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(93821);
            String str2 = str;
            d.b bVar = this.iji;
            if (bVar != null) {
                bVar.Hn(str2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(93821);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "path", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ d.b iji;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d.b bVar) {
            super(1);
            this.iji = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(93822);
            String str2 = str;
            d.b bVar = this.iji;
            if (bVar != null) {
                bVar.Hn(str2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(93822);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(93825);
        AppMethodBeat.o(93825);
    }

    private h() {
    }

    @Override // com.tencent.mm.media.i.d.a
    public final d a(String str, String str2, int i2, int i3, int i4, int i5, int i6, int i7, d.b bVar) {
        AppMethodBeat.i(93823);
        f fVar = new f(null, str == null ? "" : str, 1, str2 == null ? "" : str2, 0, 0, i2, i3, i4, 48000, 44100, 1, i5, 0, 0, false, false, i6, i7, false, 0, new a(bVar), 7340032);
        AppMethodBeat.o(93823);
        return fVar;
    }

    @Override // com.tencent.mm.media.i.d.a
    public final d a(String str, String str2, int i2, int i3, int i4, int i5, long j2, long j3, int i6, int i7, d.b bVar) {
        AppMethodBeat.i(93824);
        f fVar = new f(null, str == null ? "" : str, 1, str2 == null ? "" : str2, 0, 0, i2, i3, i4, 48000, 44100, 1, i5, j2, j3, false, false, i6, i7, false, 0, new b(bVar), 7340032);
        AppMethodBeat.o(93824);
        return fVar;
    }
}
