package com.tencent.mm.videocomposition.b;

import android.graphics.Rect;
import android.opengl.GLES30;
import android.os.SystemClock;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.mm.videocomposition.j;
import com.tencent.mm.xeffect.VLogDirector;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0006J\b\u0010'\u001a\u00020#H\u0016J(\u0010(\u001a\u0004\u0018\u00010\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0016J\u0010\u00100\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u00010!J\u000e\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020\u0010J\u0010\u00104\u001a\u00020#2\b\u00105\u001a\u0004\u0018\u00010\u001dJ\u0018\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, hxF = {"Lcom/tencent/mm/videocomposition/render/VLogDirectorMultiVideoCompositionEffect;", "Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;", "()V", "TAG", "", "checkPerformance", "", "getCheckPerformance", "()Z", "setCheckPerformance", "(Z)V", "effectMgrChanged", "glBlendStateCache", "Lcom/tencent/mm/videocomposition/render/GLBlendStateCache;", "needRelease", "outputCrop", "Landroid/graphics/Rect;", "outputHeight", "", "outputSizeChanged", "outputTexture", "Lcom/tencent/tav/coremedia/TextureInfo;", "outputWidth", "<set-?>", "Lcom/tencent/mm/videocomposition/render/PerformanceTick;", "performance", "getPerformance", "()Lcom/tencent/mm/videocomposition/render/PerformanceTick;", "processCallback", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "vLogDirector", "Lcom/tencent/mm/xeffect/VLogDirector;", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "checkCreateOutputTexture", "", "checkInitVLogDirector", "enableRelease", "enable", "release", "renderTracks", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "pts", "", "trackList", "", "Lcom/tencent/mm/videocomposition/TrackRenderInfo;", "setEffectManager", "effectMgr", "setOutputCrop", "rect", "setProcessCallback", "callback", "updateAssetSize", "width", "height", "video_composition_release"})
public final class g extends a {
    private VLogDirector AsI;
    private volatile boolean AsJ;
    private EffectManager GAw;
    private final Rect Rhq = new Rect();
    public boolean Rhu = true;
    public volatile e Rib;
    private volatile boolean Ric;
    private TextureInfo Rid;
    public d Rie = new d("renderTracks");
    private c Rif;
    private final String TAG = "VLogDirectorMultiVideoCompositionEffect";
    private boolean needRelease = true;
    private int outputHeight;
    private int outputWidth;

    public g() {
        AppMethodBeat.i(216857);
        AppMethodBeat.o(216857);
    }

    @Override // com.tencent.mm.videocomposition.b.a
    public final TextureInfo a(CIContext cIContext, long j2, List<j> list) {
        Integer num;
        TextureInfo textureInfo;
        Integer num2;
        VLogDirector vLogDirector;
        AppMethodBeat.i(216852);
        p.h(cIContext, "context");
        p.h(list, "trackList");
        if (this.outputWidth == 0 || this.outputHeight == 0) {
            this.outputWidth = cIContext.getRenderContext().width();
            this.outputHeight = cIContext.getRenderContext().height();
            b.i(this.TAG, "renderTracks renderSize " + this.outputWidth + ", " + this.outputHeight + ", assetSize: " + this.RhT + ", crop: " + this.Rhq, new Object[0]);
        }
        if (this.AsI == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.AsI = new VLogDirector();
            VLogDirector vLogDirector2 = this.AsI;
            if (vLogDirector2 != null) {
                vLogDirector2.init();
            }
            VLogDirector vLogDirector3 = this.AsI;
            if (vLogDirector3 != null) {
                vLogDirector3.setSize(this.RhT.getWidth(), this.RhT.getHeight());
            }
            if (!this.Rhq.isEmpty() && (vLogDirector = this.AsI) != null) {
                vLogDirector.V(this.Rhq.left, this.Rhq.top, this.Rhq.right, this.Rhq.bottom);
            }
            VLogDirector vLogDirector4 = this.AsI;
            if (vLogDirector4 != null) {
                vLogDirector4.setOutputSize(this.outputWidth, this.outputHeight);
            }
            b.i(this.TAG, "init vLogDirector:" + (SystemClock.elapsedRealtime() - elapsedRealtime), new Object[0]);
        }
        if (this.Ric) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            VLogDirector vLogDirector5 = this.AsI;
            if (vLogDirector5 != null) {
                vLogDirector5.b(this.GAw);
            }
            this.Ric = false;
            b.i(this.TAG, "setVLogEffectMgr:" + (SystemClock.elapsedRealtime() - elapsedRealtime2), new Object[0]);
        }
        if (this.Rid == null) {
            long elapsedRealtime3 = SystemClock.elapsedRealtime();
            TextureInfo newTextureInfo = CIContext.newTextureInfo(this.outputWidth, this.outputHeight);
            GLES30.glBindTexture(3553, newTextureInfo.textureID);
            GLES30.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, newTextureInfo.width, newTextureInfo.height, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLES30.glBindTexture(3553, 0);
            this.Rid = newTextureInfo;
            String str = this.TAG;
            StringBuilder sb = new StringBuilder("checkCreateOutputTexture texture.id:");
            TextureInfo textureInfo2 = this.Rid;
            if (textureInfo2 != null) {
                num2 = Integer.valueOf(textureInfo2.textureID);
            } else {
                num2 = null;
            }
            b.i(str, sb.append(num2).append(", cost:").append(SystemClock.elapsedRealtime() - elapsedRealtime3).toString(), new Object[0]);
            this.AsJ = false;
        } else if (this.AsJ) {
            long elapsedRealtime4 = SystemClock.elapsedRealtime();
            TextureInfo newTextureInfo2 = CIContext.newTextureInfo(this.outputWidth, this.outputHeight);
            GLES30.glBindTexture(3553, newTextureInfo2.textureID);
            GLES30.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, newTextureInfo2.width, newTextureInfo2.height, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLES30.glBindTexture(3553, 0);
            this.Rid = newTextureInfo2;
            String str2 = this.TAG;
            StringBuilder sb2 = new StringBuilder("ReCreateOutputTexture texture.id:");
            TextureInfo textureInfo3 = this.Rid;
            if (textureInfo3 != null) {
                num = Integer.valueOf(textureInfo3.textureID);
            } else {
                num = null;
            }
            b.i(str2, sb2.append(num).append(", cost:").append(SystemClock.elapsedRealtime() - elapsedRealtime4).toString(), new Object[0]);
            this.AsJ = false;
        }
        LinkedList linkedList = new LinkedList();
        for (T t : list) {
            com.tencent.mm.xeffect.b bVar = new com.tencent.mm.xeffect.b(t.texture.textureID, t.texture.width, t.texture.height, false, t.GzA.dYT);
            if (!t.GzA.Rha.isEmpty()) {
                bVar.RxI.set(t.GzA.Rha);
            }
            if (t.GzA.Rhb) {
                if (!t.GzA.iiw.isEmpty()) {
                    bVar.RxJ.set(t.GzA.iiw);
                } else {
                    bVar.RxJ.set(0, 0, t.GzA.Gzu, t.GzA.Gzv);
                    Rect rect = bVar.RxJ;
                    p.g(rect, "inputTexture.contentCrop");
                    com.tencent.mm.videocomposition.l.c(rect, new Rect(0, 0, this.RhT.getWidth(), this.RhT.getHeight()));
                }
            }
            linkedList.add(bVar);
        }
        this.Rie.RhZ = SystemClock.elapsedRealtime();
        if (linkedList.size() > 0 && (textureInfo = this.Rid) != null) {
            TextureInfo textureInfo4 = textureInfo.textureID > 0 ? textureInfo : null;
            if (textureInfo4 != null) {
                if (this.Rif == null) {
                    this.Rif = new c();
                }
                c cVar = this.Rif;
                if (cVar != null) {
                    cVar.cache();
                }
                e eVar = this.Rib;
                if (eVar != null) {
                    eVar.KM(j2);
                }
                VLogDirector vLogDirector6 = this.AsI;
                if (vLogDirector6 != null) {
                    vLogDirector6.a(linkedList, textureInfo4.textureID, j2);
                }
                c cVar2 = this.Rif;
                if (cVar2 != null) {
                    cVar2.restore();
                }
            }
        }
        d dVar = this.Rie;
        if (dVar.RhZ > 0) {
            dVar.dtZ += SystemClock.elapsedRealtime() - dVar.RhZ;
            dVar.tTn++;
        }
        dVar.RhZ = 0;
        if (this.Rhu) {
            GLES30.glFinish();
        }
        TextureInfo textureInfo5 = this.Rid;
        AppMethodBeat.o(216852);
        return textureInfo5;
    }

    public final void t(Rect rect) {
        AppMethodBeat.i(216853);
        p.h(rect, "rect");
        this.Rhq.set(rect);
        if (!this.Rhq.isEmpty()) {
            this.outputWidth = this.Rhq.width();
            this.outputHeight = this.Rhq.height();
        }
        AppMethodBeat.o(216853);
    }

    @Override // com.tencent.mm.videocomposition.b.a
    public final void lY(int i2, int i3) {
        AppMethodBeat.i(216854);
        super.lY(i2, i3);
        if (!(this.outputWidth == i2 && this.outputHeight == i3)) {
            this.outputWidth = i2;
            this.outputHeight = i3;
            VLogDirector vLogDirector = this.AsI;
            if (vLogDirector != null) {
                vLogDirector.setSize(this.outputWidth, this.outputHeight);
            }
            VLogDirector vLogDirector2 = this.AsI;
            if (vLogDirector2 != null) {
                vLogDirector2.setOutputSize(this.outputWidth, this.outputHeight);
            }
            this.AsJ = true;
        }
        AppMethodBeat.o(216854);
    }

    public final void b(EffectManager effectManager) {
        AppMethodBeat.i(216855);
        if (!p.j(effectManager, this.GAw)) {
            this.GAw = effectManager;
            this.Ric = true;
        }
        AppMethodBeat.o(216855);
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter, com.tencent.mm.videocomposition.b.a
    public final void release() {
        String str;
        AppMethodBeat.i(216856);
        super.release();
        if (!this.needRelease) {
            AppMethodBeat.o(216856);
            return;
        }
        VLogDirector vLogDirector = this.AsI;
        if (vLogDirector != null) {
            vLogDirector.destroy();
        }
        TextureInfo textureInfo = this.Rid;
        if (textureInfo != null) {
            textureInfo.release();
        }
        this.Rid = null;
        e eVar = this.Rib;
        if (eVar != null) {
            eVar.onRelease();
        }
        if (this.Rhu) {
            String str2 = this.TAG;
            d dVar = this.Rie;
            if (dVar.tTn <= 0 || dVar.dtZ <= 0) {
                str = "";
            } else {
                str = dVar.tag + " average cost:" + (dVar.dtZ / dVar.tTn);
            }
            b.i(str2, str, new Object[0]);
        }
        AppMethodBeat.o(216856);
    }
}
