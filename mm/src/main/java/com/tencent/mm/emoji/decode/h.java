package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.xeffect.effect.IStickerDecoder;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/emoji/decode/WXGifBitmapDecoder;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "bytes", "", "([B)V", "path", "", "(Ljava/lang/String;)V", "decoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "destroy", "", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "getFrame", "Landroid/graphics/Bitmap;", "seekTo", "time", "size", "Landroid/util/Size;", "plugin-xlabeffect_release"})
public final class h implements IStickerDecoder {
    private final d gUS;

    public h(byte[] bArr) {
        p.h(bArr, "bytes");
        AppMethodBeat.i(215211);
        this.gUS = MMGIFJNIFactory.Companion.getDecoder(bArr);
        AppMethodBeat.o(215211);
    }

    public h(String str) {
        p.h(str, "path");
        AppMethodBeat.i(215212);
        this.gUS = MMGIFJNIFactory.Companion.getDecoder(str);
        AppMethodBeat.o(215212);
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoder
    public final void destroy() {
        AppMethodBeat.i(215206);
        this.gUS.destroy();
        AppMethodBeat.o(215206);
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoder
    public final long duration() {
        AppMethodBeat.i(215207);
        long aup = (long) (this.gUS.aup() * this.gUS.auq());
        AppMethodBeat.o(215207);
        return aup;
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoder
    public final Bitmap getFrame() {
        AppMethodBeat.i(215208);
        Bitmap frame = this.gUS.getFrame();
        AppMethodBeat.o(215208);
        return frame;
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoder
    public final void seekTo(long j2) {
        AppMethodBeat.i(215209);
        this.gUS.seekTo(j2);
        AppMethodBeat.o(215209);
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoder
    public final Size size() {
        AppMethodBeat.i(215210);
        Size size = new Size(this.gUS.aur(), this.gUS.aus());
        AppMethodBeat.o(215210);
        return size;
    }
}
