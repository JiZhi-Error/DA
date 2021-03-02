package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/emoji/decode/EmptyDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "()V", "TAG", "", "emptyFrame", "Landroid/graphics/Bitmap;", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "", "plugin-emojisdk_release"})
public final class b implements d {
    private final String TAG = "MicroMsg.EmptyDecoder";
    private Bitmap gUG;

    public b() {
        AppMethodBeat.i(105365);
        Log.w(this.TAG, "init: should not call this, something error");
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        p.g(createBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        this.gUG = createBitmap;
        AppMethodBeat.o(105365);
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final void auo() {
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final void seekTo(long j2) {
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final Bitmap getFrame() {
        return this.gUG;
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final int aup() {
        return 1;
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final int auq() {
        return Integer.MAX_VALUE;
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final int aur() {
        AppMethodBeat.i(105363);
        int width = this.gUG.getWidth();
        AppMethodBeat.o(105363);
        return width;
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final int aus() {
        AppMethodBeat.i(105364);
        int height = this.gUG.getHeight();
        AppMethodBeat.o(105364);
        return height;
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final void destroy() {
    }
}
