package com.tencent.mm.plugin.recordvideo.c;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.media.j.b.c;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.media.j.d;
import com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig;
import java.nio.IntBuffer;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u00020\fH\u0014J\n\u0010$\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010%\u001a\u00020\u000fH\u0016J\b\u0010&\u001a\u00020\u000fH\u0016J\b\u0010'\u001a\u0004\u0018\u00010\"J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0004H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\u000e\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020 J\u000e\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0004J\u0016\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ+\u00101\u001a\u00020\u00142!\u00102\u001a\u001d\u0012\u0013\u0012\u001104¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u001403H\u0016J\b\u00106\u001a\u00020\u0014H\u0016J\u0018\u00107\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000RL\u0010\r\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "()V", "beautyEnable", "", "currentFilter", "", "filterOutputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcess", "", "inputRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "onDrawViewSizeUpdate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "getOnDrawViewSizeUpdate", "()Lkotlin/jvm/functions/Function2;", "setOnDrawViewSizeUpdate", "(Lkotlin/jvm/functions/Function2;)V", "outputRenderProc", "useCpuCrop", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "xEffectConfig", "Lcom/tencent/mm/plugin/recordvideo/jumper/XEffectConfig;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "doInitRenderProc", "getOutputTexture", "getSnapHeight", "getSnapWidth", "getXEffect", "release", "shouldDestroySurfaceTexture", "render", "setBeautyConfig", "config", "setBeautyEnable", "enable", "setFilter", "filterPath", "setOnRGBDataAvailableListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Ljava/nio/IntBuffer;", "buffer", "takePhoto", "updateDrawViewSize", "plugin-recordvideo_release"})
public final class b extends d {
    private XEffectConfig BOJ = new XEffectConfig();
    private a BXr;
    private boolean BXs;
    public m<? super Integer, ? super Integer, x> BXt;
    private String BXu;
    private float BXv;
    public com.tencent.mm.plugin.xlabeffect.b hiH;
    private boolean ilO;
    private a rwM;
    public com.tencent.mm.media.g.d rwP;

    public b() {
        super(1);
        AppMethodBeat.i(182865);
        AppMethodBeat.o(182865);
    }

    public final void a(XEffectConfig xEffectConfig) {
        AppMethodBeat.i(237432);
        p.h(xEffectConfig, "config");
        this.BOJ = xEffectConfig;
        com.tencent.mm.plugin.xlabeffect.b bVar = this.hiH;
        if (bVar != null) {
            bVar.l(this.BOJ.hDb, this.BOJ.hDc, this.BOJ.hDd, this.BOJ.hDe, this.BOJ.hDf);
            AppMethodBeat.o(237432);
            return;
        }
        AppMethodBeat.o(237432);
    }

    public final void ti(boolean z) {
        AppMethodBeat.i(237433);
        this.BXs = z;
        com.tencent.mm.plugin.xlabeffect.b bVar = this.hiH;
        if (bVar != null) {
            bVar.ti(this.BXs);
            AppMethodBeat.o(237433);
            return;
        }
        AppMethodBeat.o(237433);
    }

    @Override // com.tencent.mm.media.j.a
    public final a aEC() {
        a cVar;
        AppMethodBeat.i(182860);
        if (this.ilO) {
            cVar = new f(this.hDn, this.hDo, this.hEp, this.hEq, 2, this.scaleType);
        } else {
            cVar = new c(this.hDn, this.hDo, this.hEp, this.hEq, 2, this.scaleType);
        }
        this.rwM = cVar;
        a aVar = this.rwM;
        if (aVar != null) {
            aVar.ijH = true;
        }
        a aVar2 = this.BXr;
        if (aVar2 != null) {
            aVar2.release();
        }
        this.BXr = new e(this.hEp, this.hEq, this.hEp, this.hEq, this.ijy, 1);
        com.tencent.mm.plugin.xlabeffect.b bVar = this.hiH;
        if (bVar != null) {
            bVar.destroy();
        }
        this.hiH = new com.tencent.mm.plugin.xlabeffect.b();
        com.tencent.mm.plugin.xlabeffect.b bVar2 = this.hiH;
        if (bVar2 != null) {
            bVar2.l(this.BOJ.hDb, this.BOJ.hDc, this.BOJ.hDd, this.BOJ.hDe, this.BOJ.hDf);
        }
        com.tencent.mm.plugin.xlabeffect.b bVar3 = this.hiH;
        if (bVar3 != null) {
            bVar3.ti(this.BXs);
        }
        com.tencent.mm.plugin.xlabeffect.b bVar4 = this.hiH;
        if (bVar4 != null) {
            bVar4.m(this.BXu, this.BXv);
        }
        com.tencent.mm.plugin.xlabeffect.b bVar5 = this.hiH;
        if (bVar5 != null) {
            bVar5.zG(false);
        }
        com.tencent.mm.plugin.xlabeffect.b bVar6 = this.hiH;
        if (bVar6 != null) {
            bVar6.setSize(this.hEp, this.hEq);
        }
        com.tencent.mm.media.g.d dVar = this.rwP;
        if (dVar != null) {
            dVar.close();
        }
        this.rwP = com.tencent.mm.media.g.c.a(true, 16);
        AppMethodBeat.o(182860);
        return cVar;
    }

    @Override // com.tencent.mm.media.j.a
    public final void aML() {
        a aVar = this.BXr;
        if (aVar != null) {
            aVar.ijM = true;
        }
    }

    @Override // com.tencent.mm.media.j.a
    public final int aMM() {
        a aVar = this.BXr;
        if (aVar != null) {
            return aVar.ijO;
        }
        return 0;
    }

    @Override // com.tencent.mm.media.j.a
    public final int aMN() {
        a aVar = this.BXr;
        if (aVar != null) {
            return aVar.ijP;
        }
        return 0;
    }

    @Override // com.tencent.mm.media.j.a
    public final void m(kotlin.g.a.b<? super IntBuffer, x> bVar) {
        AppMethodBeat.i(182861);
        p.h(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        a aVar = this.BXr;
        if (aVar != null) {
            aVar.ijJ = bVar;
            AppMethodBeat.o(182861);
            return;
        }
        AppMethodBeat.o(182861);
    }

    @Override // com.tencent.mm.media.j.a
    public final void cY(int i2, int i3) {
        AppMethodBeat.i(182862);
        super.cY(i2, i3);
        a aVar = this.BXr;
        if (aVar != null) {
            aVar.cZ(this.hEp, this.hEq);
        }
        a aVar2 = this.BXr;
        if (aVar2 != null) {
            aVar2.cY(this.hEp, this.hEq);
        }
        com.tencent.mm.plugin.xlabeffect.b bVar = this.hiH;
        if (bVar != null) {
            bVar.setSize(this.hEp, this.hEq);
        }
        m<? super Integer, ? super Integer, x> mVar = this.BXt;
        if (mVar != null) {
            mVar.invoke(Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(182862);
            return;
        }
        AppMethodBeat.o(182862);
    }

    @Override // com.tencent.mm.media.j.a
    public final void aED() {
        com.tencent.mm.media.g.d dVar;
        Integer num = null;
        AppMethodBeat.i(182863);
        super.aED();
        a aVar = this.rwM;
        if (aVar == null || (dVar = aVar.ijD) == null) {
            AppMethodBeat.o(182863);
            return;
        }
        com.tencent.mm.plugin.xlabeffect.b bVar = this.hiH;
        if (bVar != null) {
            com.tencent.mm.plugin.xlabeffect.b.a(bVar, dVar);
        }
        com.tencent.mm.media.g.d dVar2 = this.rwP;
        if (dVar2 != null) {
            com.tencent.mm.media.g.d.a(dVar2, this.hEp, this.hEq, 0, null, 0, 0, 60);
        }
        com.tencent.mm.media.g.d dVar3 = this.rwP;
        if (dVar3 != null) {
            com.tencent.mm.plugin.xlabeffect.b bVar2 = this.hiH;
            if (bVar2 != null) {
                num = Integer.valueOf(com.tencent.mm.plugin.xlabeffect.b.a(bVar2, dVar, dVar3, false, 60));
            }
            if (num != null) {
                if (num.intValue() != 0) {
                    dVar3 = dVar;
                }
                dVar = dVar3;
            }
        }
        a aVar2 = this.BXr;
        if (aVar2 != null) {
            aVar2.rl(dVar.igv);
        }
        a aVar3 = this.BXr;
        if (aVar3 != null) {
            aVar3.aED();
            AppMethodBeat.o(182863);
            return;
        }
        AppMethodBeat.o(182863);
    }

    @Override // com.tencent.mm.media.j.a
    public final void release(boolean z) {
        AppMethodBeat.i(182864);
        super.release(z);
        a aVar = this.BXr;
        if (aVar != null) {
            aVar.release();
        }
        this.BXr = null;
        com.tencent.mm.plugin.xlabeffect.b bVar = this.hiH;
        if (bVar != null) {
            bVar.destroy();
        }
        this.hiH = null;
        com.tencent.mm.media.g.d dVar = this.rwP;
        if (dVar != null) {
            dVar.close();
        }
        this.rwP = null;
        AppMethodBeat.o(182864);
    }

    @Override // com.tencent.mm.media.j.a
    public final com.tencent.mm.media.g.d aEE() {
        return this.rwP;
    }
}
