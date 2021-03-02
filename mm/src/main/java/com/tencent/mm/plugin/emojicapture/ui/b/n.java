package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.c;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.auth.j;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.g;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.ui.b.b;
import com.tencent.mm.plugin.xlabeffect.b;
import com.tencent.mm.sticker.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\fJ\b\u0010\u0018\u001a\u00020\nH\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0016J\u0016\u0010#\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "mode", "", "(I)V", "faceTrackHeight", "faceTrackWidth", "filterOutputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "inputRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "lastSticker", "Lcom/tencent/mm/sticker/StickerPack;", "outputRenderProc", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewOutputProc;", "previewHeight", "previewRect", "Landroid/graphics/Rect;", "previewWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "changeSticker", "", "stickerPack", "doInitRenderProc", "release", "shouldDestroySurfaceTexture", "", "render", "resizeContent", "resizePreview", "setInitPreviewRect", "updateDrawViewSize", "width", "height", "updateMode", "Companion", "plugin-emojicapture_release"})
public final class n extends com.tencent.mm.media.j.a {
    public static final a rwS = new a((byte) 0);
    public b hiH;
    private int mode;
    private int previewHeight;
    public final Rect previewRect;
    private int previewWidth;
    private com.tencent.mm.media.j.b.a rwM;
    private m rwN;
    public f rwO;
    private d rwP;
    private int rwQ;
    private int rwR;

    static {
        AppMethodBeat.i(g.CTRL_INDEX);
        AppMethodBeat.o(g.CTRL_INDEX);
    }

    private n() {
        super(0, 0, 1, 2, 15);
        AppMethodBeat.i(as.CTRL_INDEX);
        this.mode = 0;
        this.previewRect = new Rect();
        AppMethodBeat.o(as.CTRL_INDEX);
    }

    public /* synthetic */ n(byte b2) {
        this();
    }

    @Override // com.tencent.mm.media.j.a
    public final com.tencent.mm.media.j.b.a aEC() {
        AppMethodBeat.i(870);
        this.rwP = c.a(true, 8);
        com.tencent.mm.media.j.b.a aVar = this.rwM;
        if (aVar != null) {
            aVar.release();
        }
        com.tencent.mm.media.j.b.c cVar = new com.tencent.mm.media.j.b.c(this.hDn, this.hDo, this.previewWidth, this.previewHeight, 2, 2);
        this.rwM = cVar;
        com.tencent.mm.media.j.b.a aVar2 = this.rwM;
        if (aVar2 != null) {
            aVar2.ijH = true;
        }
        m mVar = this.rwN;
        if (mVar != null) {
            mVar.release();
        }
        this.rwN = new m(this.previewWidth, this.previewHeight, this.hEp, this.hEq, (byte) 0);
        m mVar2 = this.rwN;
        if (mVar2 != null) {
            d dVar = this.rwP;
            if (dVar == null) {
                p.hyc();
            }
            mVar2.hDl = dVar.igv;
        }
        b bVar = this.hiH;
        if (bVar != null) {
            bVar.destroy();
        }
        this.hiH = new b(0, 0, 0, false, false, 15);
        b bVar2 = this.hiH;
        if (bVar2 != null) {
            bVar2.ti(true);
        }
        b bVar3 = this.hiH;
        if (bVar3 != null) {
            bVar3.zG(false);
        }
        b bVar4 = this.hiH;
        if (bVar4 != null) {
            bVar4.a(this.rwO);
        }
        b bVar5 = this.hiH;
        if (bVar5 != null) {
            bVar5.setSize(this.previewWidth, this.previewHeight);
        }
        com.tencent.mm.media.j.b.c cVar2 = cVar;
        AppMethodBeat.o(870);
        return cVar2;
    }

    @Override // com.tencent.mm.media.j.a
    public final void aED() {
        int i2;
        d dVar;
        AppMethodBeat.i(871);
        super.aED();
        com.tencent.mm.media.j.b.a aVar = this.rwM;
        if (aVar == null || (dVar = aVar.ijD) == null) {
            i2 = -1;
        } else {
            i2 = dVar.igv;
        }
        b bVar = this.hiH;
        if (bVar != null) {
            b.a(bVar, i2);
        }
        b.a aVar2 = b.rvS;
        d dVar2 = this.rwP;
        if (dVar2 == null) {
            p.hyc();
        }
        b.a.ab(dVar2.igv, this.previewWidth, this.previewHeight);
        com.tencent.mm.plugin.xlabeffect.b bVar2 = this.hiH;
        if (bVar2 != null) {
            d dVar3 = this.rwP;
            if (dVar3 == null) {
                p.hyc();
            }
            com.tencent.mm.plugin.xlabeffect.b.a(bVar2, i2, dVar3.igv, false, 60);
        }
        m mVar = this.rwN;
        if (mVar != null) {
            mVar.aED();
            AppMethodBeat.o(871);
            return;
        }
        AppMethodBeat.o(871);
    }

    @Override // com.tencent.mm.media.j.a
    public final void release(boolean z) {
        AppMethodBeat.i(872);
        super.release(z);
        m mVar = this.rwN;
        if (mVar != null) {
            mVar.release();
        }
        com.tencent.mm.plugin.xlabeffect.b bVar = this.hiH;
        if (bVar != null) {
            bVar.destroy();
        }
        this.hiH = null;
        d dVar = this.rwP;
        if (dVar != null) {
            dVar.close();
            AppMethodBeat.o(872);
            return;
        }
        AppMethodBeat.o(872);
    }

    @Override // com.tencent.mm.media.j.a
    public final void cY(int i2, int i3) {
        AppMethodBeat.i(873);
        super.cY(i2, i3);
        cJZ();
        com.tencent.mm.media.j.b.a aVar = this.rwM;
        if (aVar != null) {
            aVar.cY(this.previewWidth, this.previewHeight);
        }
        m mVar = this.rwN;
        if (mVar != null) {
            mVar.cZ(this.previewWidth, this.previewHeight);
        }
        m mVar2 = this.rwN;
        if (mVar2 != null) {
            mVar2.cY(this.hEp, this.hEq);
        }
        cKa();
        AppMethodBeat.o(873);
    }

    public final void b(int i2, Rect rect) {
        AppMethodBeat.i(j.CTRL_INDEX);
        p.h(rect, "previewRect");
        if (this.mode == i2) {
            AppMethodBeat.o(j.CTRL_INDEX);
            return;
        }
        this.mode = i2;
        this.previewRect.set(rect);
        com.tencent.mm.media.j.b.a aVar = this.rwM;
        if (aVar != null) {
            aVar.release();
        }
        m mVar = this.rwN;
        if (mVar != null) {
            mVar.release();
        }
        d dVar = this.rwP;
        if (dVar != null) {
            dVar.close();
        }
        cJZ();
        this.ijo = aEC();
        com.tencent.mm.media.j.b.a aVar2 = this.rwM;
        if (aVar2 != null) {
            aVar2.cZ(this.hDn, this.hDo);
        }
        com.tencent.mm.media.j.b.a aVar3 = this.rwM;
        if (aVar3 != null) {
            aVar3.cY(this.previewWidth, this.previewHeight);
        }
        com.tencent.mm.media.j.b.a aVar4 = this.rwM;
        if (aVar4 != null) {
            aVar4.qx(this.ijt);
        }
        com.tencent.mm.media.j.b.a aVar5 = this.rwM;
        if (aVar5 != null) {
            aVar5.iju = this.iju;
        }
        m mVar2 = this.rwN;
        if (mVar2 != null) {
            mVar2.cZ(this.previewWidth, this.previewHeight);
        }
        m mVar3 = this.rwN;
        if (mVar3 != null) {
            mVar3.cY(this.hEp, this.hEq);
        }
        cKa();
        AppMethodBeat.o(j.CTRL_INDEX);
    }

    private final void cJZ() {
        switch (this.mode) {
            case 0:
                this.previewWidth = 640;
                this.previewHeight = 640;
                break;
            case 1:
                this.previewWidth = 640;
                this.previewHeight = 1137;
                break;
            case 2:
                if (this.hEp <= 640) {
                    this.previewWidth = this.hEp;
                    this.previewHeight = this.hEq;
                    break;
                } else {
                    this.previewWidth = 640;
                    this.previewHeight = (this.hEq * 640) / this.hEp;
                    break;
                }
        }
        this.rwQ = 160;
        this.rwR = (this.previewHeight * this.rwQ) / this.previewWidth;
    }

    private final void cKa() {
        AppMethodBeat.i(ar.CTRL_INDEX);
        switch (this.mode) {
            case 0:
                m mVar = this.rwN;
                if (mVar != null) {
                    d.a aVar = com.tencent.mm.plugin.emojicapture.model.d.roA;
                    mVar.a(true, ((float) this.previewWidth) * 0.06666667f);
                    break;
                }
                break;
            case 2:
                m mVar2 = this.rwN;
                if (mVar2 != null) {
                    m.a(mVar2);
                    break;
                }
                break;
        }
        if (this.previewRect.isEmpty()) {
            m mVar3 = this.rwN;
            if (mVar3 != null) {
                mVar3.C(0, 0, this.hEp, this.hEq);
                AppMethodBeat.o(ar.CTRL_INDEX);
                return;
            }
            AppMethodBeat.o(ar.CTRL_INDEX);
            return;
        }
        m mVar4 = this.rwN;
        if (mVar4 != null) {
            mVar4.C(this.previewRect.left, this.previewRect.top, this.previewRect.right, this.previewRect.bottom);
            AppMethodBeat.o(ar.CTRL_INDEX);
            return;
        }
        AppMethodBeat.o(ar.CTRL_INDEX);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender$Companion;", "", "()V", "MAX_FACE_TRACK_WIDTH", "", "MAX_PREVIEW_WIDTH", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
