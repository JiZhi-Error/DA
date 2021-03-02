package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/emoji/decode/MMWXGFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "TAG", "", "currFrame", "", "currFrameTime", "frameMetadata", "", "framePicker", "Lcom/tencent/mm/emoji/decode/FramePicker;", "gifHandle", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "plugin-emojisdk_release"})
public final class g implements d {
    private final String TAG = "MicroMsg.GIF.MMWXGFDecoder";
    private Bitmap gUK;
    private final int[] gUM = new int[4];
    private int gUN = -1;
    private int gUO;
    private final c gUP;
    private long gUQ = MMWXGFJNI.nativeInitWxAMDecoder();
    private final int[] gUR = new int[4];

    public g(byte[] bArr) {
        p.h(bArr, "bytes");
        AppMethodBeat.i(105378);
        if (this.gUQ == 0 || this.gUQ == -901) {
            Log.w(this.TAG, "Cpan init wxam decoder failed. gifHandle:%d", Long.valueOf(this.gUQ));
            if (this.gUQ == -901) {
                h.INSTANCE.idkeyStat(711, 5, 1, false);
            }
            h.INSTANCE.idkeyStat(711, 4, 1, false);
            MMGIFException mMGIFException = new MMGIFException(201);
            AppMethodBeat.o(105378);
            throw mMGIFException;
        }
        int nativeDecodeBufferHeader = MMWXGFJNI.nativeDecodeBufferHeader(this.gUQ, bArr, bArr.length);
        if (nativeDecodeBufferHeader != 0) {
            Log.w(this.TAG, "Cpan WXGF decode buffer header failed. result:%d", Integer.valueOf(nativeDecodeBufferHeader));
            if (nativeDecodeBufferHeader == -904) {
                h.INSTANCE.idkeyStat(711, 8, 1, false);
            } else {
                h.INSTANCE.idkeyStat(711, 3, 1, false);
            }
            MMGIFException mMGIFException2 = new MMGIFException(nativeDecodeBufferHeader);
            AppMethodBeat.o(105378);
            throw mMGIFException2;
        }
        int nativeGetOption = MMWXGFJNI.nativeGetOption(this.gUQ, bArr, bArr.length, this.gUM);
        if (nativeGetOption != 0) {
            Log.w(this.TAG, "Cpan WXGF get option failed. result:%d", Integer.valueOf(nativeGetOption));
            if (nativeGetOption == -903) {
                h.INSTANCE.idkeyStat(711, 7, 1, false);
            } else {
                h.INSTANCE.idkeyStat(711, 3, 1, false);
            }
            MMGIFException mMGIFException3 = new MMGIFException(nativeGetOption);
            AppMethodBeat.o(105378);
            throw mMGIFException3;
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.gUM[1], this.gUM[2], Bitmap.Config.ARGB_8888);
        p.g(createBitmap, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
        this.gUK = createBitmap;
        this.gUP = new c(this.gUM[0]);
        AppMethodBeat.o(105378);
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final void auo() {
        AppMethodBeat.i(105376);
        int nativeDecodeBufferFrame = MMWXGFJNI.nativeDecodeBufferFrame(this.gUQ, null, 0, this.gUK, this.gUR);
        if (nativeDecodeBufferFrame == -904) {
            Log.i(this.TAG, "nativeDecodeBufferFrame failed. func is null.");
            h.INSTANCE.idkeyStat(401, 8, 1, false);
        } else if (nativeDecodeBufferFrame == -909) {
            Log.i(this.TAG, "nativeDecodeBufferFrame failed. frame is null.");
            h.INSTANCE.idkeyStat(401, 11, 1, false);
        } else if (nativeDecodeBufferFrame == -1) {
            Log.i(this.TAG, "nativeDecodeBufferFrame failed.");
        }
        this.gUN++;
        if ((this.gUN >= this.gUM[0] - 1 || nativeDecodeBufferFrame == 1) && MMWXGFJNI.nativeRewindBuffer(this.gUQ) == -905) {
            h.INSTANCE.idkeyStat(711, 9, 1, false);
            Log.w(this.TAG, "Cpan Rewind buffer failed.");
        }
        this.gUN %= this.gUM[0];
        this.gUO = this.gUR[0] > 0 ? this.gUR[0] : 100;
        Log.d(this.TAG, "drawFrameBitmap: decode frame " + this.gUN + ", " + this.gUO);
        AppMethodBeat.o(105376);
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final void seekTo(long j2) {
        AppMethodBeat.i(199867);
        if (this.gUO <= 0) {
            auo();
        }
        int pe = this.gUP.pe((int) j2);
        int i2 = this.gUM[0];
        for (int i3 = 0; i3 < i2 && pe < 0; i3++) {
            auo();
            this.gUP.cz(this.gUN, this.gUO);
            pe = this.gUP.pe((int) j2);
        }
        int i4 = ((pe - this.gUN) + this.gUM[0]) % this.gUM[0];
        Log.d(this.TAG, "seekTo: " + j2 + ", " + this.gUN + ", " + i4 + ", " + auq() + ", " + this.gUM[0] + (char) 65292 + this.gUP.gUI);
        for (int i5 = 0; i5 < i4; i5++) {
            auo();
        }
        AppMethodBeat.o(199867);
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final Bitmap getFrame() {
        return this.gUK;
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final int aup() {
        return this.gUM[0];
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final int auq() {
        if (this.gUM[0] == 1) {
            return Integer.MAX_VALUE;
        }
        return this.gUO;
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final int aur() {
        return this.gUM[1];
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final int aus() {
        return this.gUM[2];
    }

    @Override // com.tencent.mm.emoji.decode.d
    public final void destroy() {
        AppMethodBeat.i(105377);
        long j2 = this.gUQ;
        this.gUQ = 0;
        int nativeUninit = MMWXGFJNI.nativeUninit(j2);
        if (nativeUninit == -906) {
            h.INSTANCE.idkeyStat(401, 10, 1, false);
        }
        Log.d(this.TAG, "nativeUninit result:%d gifHandle:%s", Integer.valueOf(nativeUninit), Long.valueOf(j2));
        AppMethodBeat.o(105377);
    }
}
