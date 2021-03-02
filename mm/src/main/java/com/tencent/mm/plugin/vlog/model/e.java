package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.VLogEffectJNI;
import com.tencent.mm.xeffect.effect.a;
import com.tencent.mm.xeffect.effect.ac;
import com.tencent.mm.xeffect.effect.ad;
import com.tencent.mm.xeffect.effect.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0005H\u0002R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/BlendRenderProcessWrapper;", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "(Lkotlin/jvm/functions/Function1;Lcom/tencent/mm/xeffect/effect/EffectManager;)V", "getBlendBitmapProvider", "()Lkotlin/jvm/functions/Function1;", "blendEffect", "Lcom/tencent/mm/xeffect/effect/BlendEffect;", "getBlendEffect", "()Lcom/tencent/mm/xeffect/effect/BlendEffect;", "getEffectMgr", "()Lcom/tencent/mm/xeffect/effect/EffectManager;", "height", "", "texture", "width", "blendTexture", "Lcom/tencent/mm/xeffect/InputTexture;", "pts", "ensureTexture", "", "onFrameStart", "onRelease", "uploadBitmap", "bitmap", "plugin-vlog_release"})
public final class e implements com.tencent.mm.videocomposition.b.e {
    private final a Gxh;
    private int Gxi;
    private int height;
    private final b<Long, Bitmap> ihf;
    private final EffectManager wbk;
    private int width;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.g.a.b<? super java.lang.Long, android.graphics.Bitmap> */
    /* JADX WARN: Multi-variable type inference failed */
    public e(b<? super Long, Bitmap> bVar, EffectManager effectManager) {
        p.h(bVar, "blendBitmapProvider");
        AppMethodBeat.i(190490);
        this.ihf = bVar;
        this.wbk = effectManager;
        EffectManager effectManager2 = this.wbk;
        ad a2 = effectManager2 != null ? effectManager2.a(j.BlendEffect) : null;
        this.Gxh = (a) (!(a2 instanceof a) ? null : a2);
        AppMethodBeat.o(190490);
    }

    @Override // com.tencent.mm.videocomposition.b.e
    public final void onRelease() {
        AppMethodBeat.i(190489);
        if (this.Gxi != 0) {
            GLES20.glDeleteTextures(1, new int[]{this.Gxi}, 0);
            this.Gxi = 0;
        }
        AppMethodBeat.o(190489);
    }

    @Override // com.tencent.mm.videocomposition.b.e
    public final void KM(long j2) {
        com.tencent.mm.xeffect.b bVar;
        EffectManager effectManager;
        AppMethodBeat.i(190488);
        Bitmap invoke = this.ihf.invoke(Long.valueOf(j2));
        if (invoke != null) {
            this.width = invoke.getWidth();
            this.height = invoke.getHeight();
            if (this.Gxi == 0) {
                int[] iArr = new int[1];
                GLES20.glGenTextures(1, iArr, 0);
                GLES20.glBindTexture(3553, iArr[0]);
                GLES20.glBindTexture(3553, 0);
                this.Gxi = iArr[0];
            }
            GLES20.glBindTexture(3553, this.Gxi);
            GLUtils.texImage2D(3553, 0, invoke, 0);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 10497.0f);
            GLES20.glTexParameterf(3553, 10243, 10497.0f);
            GLES20.glBindTexture(3553, 0);
            bVar = new com.tencent.mm.xeffect.b(this.Gxi, this.width, this.height);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            a aVar = this.Gxh;
            if (!(aVar == null || aVar.id != 0 || (effectManager = this.wbk) == null)) {
                effectManager.a(this.Gxh);
            }
            a aVar2 = this.Gxh;
            if (aVar2 != null) {
                int i2 = bVar.textureId;
                int i3 = bVar.width;
                int i4 = bVar.height;
                ac.a aVar3 = aVar2.RxR;
                aVar3.textureId = i2;
                aVar3.width = i3;
                aVar3.height = i4;
                VLogEffectJNI.INSTANCE.setEffectTexture$renderlib_release(aVar3.GAn.ptr, i2, i3, i4);
                AppMethodBeat.o(190488);
                return;
            }
        }
        AppMethodBeat.o(190488);
    }
}
