package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/emoji/decode/MMBitmapDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "lastValidFrame", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "frameCount", "", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "", "plugin-emojisdk_release"})
public final class e implements d {
    private Bitmap gUK;

    public e(Bitmap bitmap) {
        AppMethodBeat.i(105368);
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            p.g(bitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        }
        this.gUK = bitmap;
        this.gUK.setDensity(320);
        AppMethodBeat.o(105368);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public e(byte[] bArr) {
        this(BitmapUtil.decodeByteArray(bArr));
        p.h(bArr, "bytes");
        AppMethodBeat.i(105369);
        AppMethodBeat.o(105369);
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final void auo() {
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final void seekTo(long j2) {
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final int aup() {
        return 1;
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final Bitmap getFrame() {
        return this.gUK;
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final int auq() {
        return Integer.MAX_VALUE;
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final int aur() {
        AppMethodBeat.i(105366);
        int width = this.gUK.getWidth();
        AppMethodBeat.o(105366);
        return width;
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final int aus() {
        AppMethodBeat.i(105367);
        int height = this.gUK.getHeight();
        AppMethodBeat.o(105367);
        return height;
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final void destroy() {
    }
}
