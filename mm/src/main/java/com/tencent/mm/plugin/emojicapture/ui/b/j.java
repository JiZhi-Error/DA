package com.tencent.mm.plugin.emojicapture.ui.b;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.mm.media.g.c;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.emojicapture.ui.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0001H&J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\b\u0010\"\u001a\u00020\u001cH\u0014J\b\u0010#\u001a\u00020\u001cH\u0016J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u000fH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0018\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiPreviewRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCaptureRender;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCapturePreviewRender;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "emojiFilterProcessTex", "Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess;", "enableEffect", "", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "outputHeight", "getOutputHeight", "()I", "outputProc", "outputWidth", "getOutputWidth", "removeBg", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "changeSticker", "", "checkInitEffect", "getInputRenderProc", "getRecordTexture", "pauseRender", "release", "renderImpl", "resumeRender", "setRemoveBg", "remove", "plugin-emojicapture_release"})
public abstract class j extends a implements k, l {
    private d hEv;
    final int outputHeight;
    final int outputWidth = com.tencent.mm.plugin.emojicapture.model.d.rov;
    private boolean rnN;
    private f rpM;
    private com.tencent.mm.plugin.emojicapture.d.a rwH;
    private boolean rwI;
    private a rwJ;

    public abstract a cJT();

    public j(int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i2, i3, i4, i5, i6, i7);
        d.a aVar = com.tencent.mm.plugin.emojicapture.model.d.roA;
        d.a aVar2 = com.tencent.mm.plugin.emojicapture.model.d.roA;
        this.outputHeight = com.tencent.mm.plugin.emojicapture.model.d.rov;
        this.rwI = true;
        b.a aVar3 = b.rvS;
        this.hEv = c.eV(true);
        this.rwJ = new i(this.outputWidth, this.outputHeight, i4, i5);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void aMV() {
        int i2;
        int i3 = 0;
        a cJT = cJT();
        if (cJT != null) {
            cJT.cZ(this.hDn, this.hDo);
        }
        a cJT2 = cJT();
        if (cJT2 != null) {
            cJT2.qx(this.ijt);
        }
        a cJT3 = cJT();
        if (cJT3 != null) {
            cJT3.iju = this.iju;
        }
        a cJT4 = cJT();
        if (cJT4 != null) {
            cJT4.aED();
            com.tencent.mm.media.g.d dVar = cJT4.ijD;
            if (dVar != null) {
                i2 = dVar.igv;
            } else {
                i2 = -1;
            }
        } else {
            i2 = 0;
        }
        cJY();
        com.tencent.mm.plugin.emojicapture.d.a aVar = this.rwH;
        if (aVar != null) {
            int i4 = this.outputWidth;
            int i5 = this.outputHeight;
            aVar.hDn = i4;
            aVar.hDo = i5;
            com.tencent.mm.plugin.xlabeffect.b bVar = aVar.hiH;
            if (bVar != null) {
                bVar.setSize(i4, i5);
            }
            aVar.hDl = i2;
            long currentTicks = Util.currentTicks();
            try {
                if (!aVar.rof) {
                    GLES20.glBindFramebuffer(36160, aVar.roe);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, aVar.hDl, 0);
                    b.a aVar2 = b.rvS;
                    b.a.ab(aVar.rod, aVar.hDn, aVar.hDo);
                    GLES20.glBindTexture(3553, aVar.rod);
                    GLES20.glCopyTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, 0, 0, aVar.hDn, aVar.hDo, 0);
                    GLES20.glBindFramebuffer(36160, 0);
                    GLES20.glBindTexture(3553, 0);
                } else {
                    com.tencent.mm.plugin.xlabeffect.b bVar2 = aVar.hiH;
                    if (bVar2 != null) {
                        com.tencent.mm.plugin.xlabeffect.b.a(bVar2, aVar.hDl);
                    }
                    b.a aVar3 = b.rvS;
                    b.a.ab(aVar.rod, aVar.hDn, aVar.hDo);
                    com.tencent.mm.plugin.xlabeffect.b bVar3 = aVar.hiH;
                    if (bVar3 != null) {
                        com.tencent.mm.plugin.xlabeffect.b.a(bVar3, aVar.hDl, aVar.rod, false, 60);
                    }
                    GLES20.glBindFramebuffer(36160, 0);
                    GLES20.glBindTexture(3553, 0);
                    Log.d(com.tencent.mm.plugin.emojicapture.d.a.TAG, "filterProcess: cost %s", Long.valueOf(Util.ticksToNow(currentTicks)));
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(com.tencent.mm.plugin.emojicapture.d.a.TAG, e2, "filterProcess error", new Object[0]);
                e eVar = e.roB;
                e.cIW();
            }
        }
        com.tencent.mm.media.g.d dVar2 = this.hEv;
        if (dVar2 != null) {
            i3 = dVar2.igv;
        }
        a aVar4 = this.rwJ;
        if (aVar4 != null) {
            aVar4.rl(i3);
        }
        a aVar5 = this.rwJ;
        if (aVar5 != null) {
            aVar5.aED();
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.b.l
    public final void a(f fVar) {
        this.rpM = fVar;
        cJY();
        com.tencent.mm.plugin.emojicapture.d.a aVar = this.rwH;
        if (aVar != null) {
            aVar.a(fVar);
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.b.l
    public final void lF(boolean z) {
        this.rnN = z;
        cJY();
        com.tencent.mm.plugin.emojicapture.d.a aVar = this.rwH;
        if (aVar != null) {
            aVar.lF(z);
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.b.k
    public final com.tencent.mm.media.g.d cJX() {
        a cJT = cJT();
        if (cJT != null) {
            return cJT.ijD;
        }
        return null;
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.b.l
    public final void aEa() {
        this.rwI = false;
        com.tencent.mm.plugin.emojicapture.d.a aVar = this.rwH;
        if (aVar != null) {
            aVar.clear();
        }
        this.rwH = null;
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.b.l
    public final void aEb() {
        this.rwI = true;
    }

    private final void cJY() {
        int i2;
        int i3 = 0;
        a cJT = cJT();
        if (cJT != null) {
            com.tencent.mm.media.g.d dVar = cJT.ijD;
            i2 = dVar != null ? dVar.igv : -1;
        } else {
            i2 = 0;
        }
        if (this.rwH == null && this.rwI) {
            this.rwH = new com.tencent.mm.plugin.emojicapture.d.a();
            com.tencent.mm.plugin.emojicapture.d.a aVar = this.rwH;
            if (aVar != null) {
                com.tencent.mm.media.g.d dVar2 = this.hEv;
                if (dVar2 != null) {
                    i3 = dVar2.igv;
                }
                aVar.fG(i2, i3);
            }
            com.tencent.mm.plugin.emojicapture.d.a aVar2 = this.rwH;
            if (aVar2 != null) {
                aVar2.lF(this.rnN);
            }
            com.tencent.mm.plugin.emojicapture.d.a aVar3 = this.rwH;
            if (aVar3 != null) {
                aVar3.a(this.rpM);
            }
        }
    }

    @Override // com.tencent.mm.media.j.b.a
    public void release() {
        super.release();
        com.tencent.mm.media.g.d dVar = this.hEv;
        if (dVar != null) {
            dVar.close();
        }
        a aVar = this.rwJ;
        if (aVar != null) {
            aVar.release();
        }
        com.tencent.mm.plugin.emojicapture.d.a aVar2 = this.rwH;
        if (aVar2 != null) {
            aVar2.clear();
        }
        this.rwH = null;
    }
}
