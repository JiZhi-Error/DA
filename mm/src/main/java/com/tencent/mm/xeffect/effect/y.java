package com.tencent.mm.xeffect.effect;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/xeffect/effect/StickerDecoder;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "path", "", "(Ljava/lang/String;)V", "bytes", "", "([B)V", "bitmap", "Landroid/graphics/Bitmap;", "height", "", "width", "destroy", "", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "getFrame", "seekTo", "time", "size", "Landroid/util/Size;", "renderlib_release"})
public final class y implements IStickerDecoder {
    private final Bitmap bitmap;
    private final int height = this.bitmap.getHeight();
    private final int width = this.bitmap.getWidth();

    public y(String str) {
        p.h(str, "path");
        AppMethodBeat.i(237102);
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        p.g(decodeFile, "BitmapFactory.decodeFile(path)");
        this.bitmap = decodeFile;
        AppMethodBeat.o(237102);
    }

    public y(byte[] bArr) {
        p.h(bArr, "bytes");
        AppMethodBeat.i(237103);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        p.g(decodeByteArray, "BitmapFactory.decodeByte…ray(bytes, 0, bytes.size)");
        this.bitmap = decodeByteArray;
        AppMethodBeat.o(237103);
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoder
    public final Size size() {
        AppMethodBeat.i(237101);
        Size size = new Size(this.width, this.height);
        AppMethodBeat.o(237101);
        return size;
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoder
    public final long duration() {
        return TPAudioFrame.TP_CH_STEREO_RIGHT;
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoder
    public final void seekTo(long j2) {
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoder
    public final Bitmap getFrame() {
        return this.bitmap;
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoder
    public final void destroy() {
    }
}
