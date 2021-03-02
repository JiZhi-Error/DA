package com.tencent.mm.xeffect.effect;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.p;
import kotlin.l;

@Keep
@l(hxD = {1, 1, 15}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/xeffect/effect/StickerDecoderWrapper;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "decoder", "(Lcom/tencent/mm/xeffect/effect/IStickerDecoder;)V", "getDecoder", "()Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "destroy", "", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "getFrame", "Landroid/graphics/Bitmap;", "seekTo", "time", "size", "Landroid/util/Size;", "sizeInArray", "", "renderlib_release"})
public final class StickerDecoderWrapper implements IStickerDecoder {
    private final IStickerDecoder decoder;

    public StickerDecoderWrapper(IStickerDecoder iStickerDecoder) {
        p.h(iStickerDecoder, "decoder");
        AppMethodBeat.i(237113);
        this.decoder = iStickerDecoder;
        AppMethodBeat.o(237113);
    }

    public final IStickerDecoder getDecoder() {
        return this.decoder;
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoder
    public final Size size() {
        AppMethodBeat.i(237107);
        Size size = this.decoder.size();
        AppMethodBeat.o(237107);
        return size;
    }

    public final int[] sizeInArray() {
        AppMethodBeat.i(237108);
        Size size = this.decoder.size();
        int[] iArr = {size.getWidth(), size.getHeight()};
        AppMethodBeat.o(237108);
        return iArr;
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoder
    public final long duration() {
        AppMethodBeat.i(237109);
        long duration = this.decoder.duration();
        AppMethodBeat.o(237109);
        return duration;
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoder
    public final void seekTo(long j2) {
        AppMethodBeat.i(237110);
        this.decoder.seekTo(j2);
        AppMethodBeat.o(237110);
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoder
    public final Bitmap getFrame() {
        AppMethodBeat.i(237111);
        Bitmap frame = this.decoder.getFrame();
        AppMethodBeat.o(237111);
        return frame;
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoder
    public final void destroy() {
        AppMethodBeat.i(237112);
        this.decoder.destroy();
        AppMethodBeat.o(237112);
    }
}
