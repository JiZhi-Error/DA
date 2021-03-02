package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.gif.MMGIFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0010H\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/emoji/decode/MMGIFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "stream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "TAG", "", "currFrame", "", "currFrameTime", "framePicker", "Lcom/tencent/mm/emoji/decode/FramePicker;", "gifPointer", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "", "startPerformance", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "plugin-emojisdk_release"})
public final class f implements d {
    private final String TAG;
    private Bitmap gUK;
    private long gUL;
    private final int[] gUM;
    private int gUN;
    private int gUO;
    private final c gUP;
    private int gsi;

    public f(byte[] bArr) {
        p.h(bArr, "bytes");
        AppMethodBeat.i(105372);
        this.TAG = "MicroMsg.GIF.MMGIFDecoder";
        this.gUM = new int[6];
        this.gUN = -1;
        this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifEnable, WXHardCoderJNI.hcGifDelay, WXHardCoderJNI.hcGifCPU, WXHardCoderJNI.hcGifIO, WXHardCoderJNI.hcGifThr ? Process.myTid() : 0, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
        this.gUL = MMGIFJNI.openByByteArray(bArr, this.gUM);
        if (this.gUM[0] > 1024 || this.gUM[1] > 1024) {
            Log.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", Integer.valueOf(this.gUM[0]), Integer.valueOf(this.gUM[1]));
            h.INSTANCE.idkeyStat(401, 2, 1, false);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.gUM[0], this.gUM[1], Bitmap.Config.ARGB_8888);
        p.g(createBitmap, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
        this.gUK = createBitmap;
        this.gUP = new c(this.gUM[2]);
        AppMethodBeat.o(105372);
    }

    public f(InputStream inputStream) {
        p.h(inputStream, "stream");
        AppMethodBeat.i(105373);
        this.TAG = "MicroMsg.GIF.MMGIFDecoder";
        this.gUM = new int[6];
        this.gUN = -1;
        this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifEnable, WXHardCoderJNI.hcGifDelay, WXHardCoderJNI.hcGifCPU, WXHardCoderJNI.hcGifIO, WXHardCoderJNI.hcGifThr ? Process.myTid() : 0, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
        this.gUL = MMGIFJNI.openByInputStrem(inputStream, this.gUM);
        if (this.gUM[0] > 1024 || this.gUM[1] > 1024) {
            Log.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", Integer.valueOf(this.gUM[0]), Integer.valueOf(this.gUM[1]));
            h.INSTANCE.idkeyStat(401, 2, 1, false);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.gUM[0], this.gUM[1], Bitmap.Config.ARGB_8888);
        p.g(createBitmap, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
        this.gUK = createBitmap;
        this.gUP = new c(this.gUM[2]);
        AppMethodBeat.o(105373);
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final void auo() {
        AppMethodBeat.i(105370);
        MMGIFJNI.drawFrameBitmap(this.gUL, this.gUK, this.gUM);
        this.gUN = this.gUM[5];
        this.gUO = this.gUM[4];
        Log.d(this.TAG, "drawFrameBitmap: decode frame " + this.gUN + ", " + this.gUO);
        AppMethodBeat.o(105370);
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final void seekTo(long j2) {
        AppMethodBeat.i(199863);
        if (this.gUO <= 0) {
            auo();
        }
        int pe = this.gUP.pe((int) j2);
        int i2 = this.gUM[2];
        for (int i3 = 0; i3 < i2 && pe < 0; i3++) {
            auo();
            this.gUP.cz(this.gUN, this.gUO);
            pe = this.gUP.pe((int) j2);
        }
        int i4 = ((pe - this.gUN) + this.gUM[2]) % this.gUM[2];
        Log.d(this.TAG, "seekTo: " + j2 + ", " + this.gUN + ", " + i4 + ", " + auq() + ", " + this.gUM[2] + (char) 65292 + this.gUP.gUI);
        for (int i5 = 0; i5 < i4; i5++) {
            auo();
        }
        AppMethodBeat.o(199863);
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final Bitmap getFrame() {
        return this.gUK;
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final int aup() {
        return this.gUM[2];
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final int auq() {
        if (this.gUM[2] == 1) {
            return Integer.MAX_VALUE;
        }
        return this.gUM[4];
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final int aur() {
        return this.gUM[0];
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final int aus() {
        return this.gUM[1];
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final void destroy() {
        AppMethodBeat.i(105371);
        if (this.gsi != 0) {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcGifEnable || WXHardCoderJNI.hcGifFrameEnable, this.gsi);
            this.gsi = 0;
        }
        long j2 = this.gUL;
        this.gUL = 0;
        MMGIFJNI.recycle(j2);
        AppMethodBeat.o(105371);
    }
}
