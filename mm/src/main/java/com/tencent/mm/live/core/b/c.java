package com.tencent.mm.live.core.b;

import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.xlabeffect.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ&\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0016J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u001b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/live/core/render/LiveFilterProcessTex;", "", "()V", "inputTexture", "", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "textureHeight", "textureWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "clear", "", "filterProcess", "initial", "previewTexture", "beautyParam", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "filterParam", "Lcom/tencent/mm/live/core/render/FilterConfig;", "setInputTexture", "texture", "setInputTexture$plugin_core_release", "updateBeautyConfig", "beautyConfig", "updateFilterConfig", "updateOutputTexture", "updateTextureSize", "Companion", "plugin-core_release"})
public final class c {
    static final String TAG = TAG;
    public static final a hDp = new a((byte) 0);
    int hDl;
    d hDm;
    int hDn;
    int hDo;
    b hiH;

    public final void a(int i2, d dVar, a aVar, b bVar) {
        AppMethodBeat.i(196616);
        p.h(dVar, "outputTexture");
        p.h(aVar, "beautyParam");
        p.h(bVar, "filterParam");
        try {
            String str = TAG;
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            Log.i(str, "initial %s, %d, beauytParams:%s", this, Long.valueOf(currentThread.getId()), aVar);
            if (this.hiH != null) {
                Log.w(TAG, "initial xLabEffect: again");
                b bVar2 = this.hiH;
                if (bVar2 == null) {
                    p.hyc();
                }
                bVar2.destroy();
            }
            this.hiH = new b(0, 0, 1);
            b bVar3 = this.hiH;
            if (bVar3 == null) {
                p.hyc();
            }
            bVar3.zG(false);
            boolean aEr = aVar.aEr();
            boolean aEs = aVar.aEs();
            boolean aEv = bVar.aEv();
            boolean aEt = aVar.aEt();
            boolean aEu = aVar.aEu();
            Log.i(TAG, "initial, needSkin:" + aEr + ", needShape:" + aEs + ", needBright:" + aEt + ", needFilter:" + aEv + ", needRosy:" + aEu + " [" + aVar.aEl() + ", " + aVar.aEm() + ", " + aVar.aEn() + ", " + aVar.aEo() + ", " + aVar.aEp() + ", " + aVar.aEq() + ", " + bVar.hDj + ", " + bVar.hDk + ']');
            b bVar4 = this.hiH;
            if (bVar4 == null) {
                p.hyc();
            }
            bVar4.l(aVar.aEl(), aVar.aEm(), aVar.aEn(), aVar.aEo(), aVar.aEp());
            if (aEr) {
                b bVar5 = this.hiH;
                if (bVar5 == null) {
                    p.hyc();
                }
                bVar5.gli();
            }
            if (aEs) {
                b bVar6 = this.hiH;
                if (bVar6 == null) {
                    p.hyc();
                }
                bVar6.glk();
            }
            if (aEt) {
                b bVar7 = this.hiH;
                if (bVar7 == null) {
                    p.hyc();
                }
                b.a(bVar7);
            }
            if (aEv) {
                b bVar8 = this.hiH;
                if (bVar8 == null) {
                    p.hyc();
                }
                bVar8.m(bVar.hDj, ((float) bVar.hDk) / 100.0f);
            }
            if (aEu) {
                b bVar9 = this.hiH;
                if (bVar9 == null) {
                    p.hyc();
                }
                bVar9.ahu(aVar.aEq());
                b bVar10 = this.hiH;
                if (bVar10 == null) {
                    p.hyc();
                }
                bVar10.glm();
            }
            this.hDl = i2;
            this.hDm = dVar;
            Log.d(TAG, "initial end %s", this);
            AppMethodBeat.o(196616);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "initial error", new Object[0]);
            AppMethodBeat.o(196616);
        }
    }

    public final void aEw() {
        AppMethodBeat.i(196617);
        long currentTicks = Util.currentTicks();
        try {
            b bVar = this.hiH;
            if (bVar == null) {
                p.hyc();
            }
            b.a(bVar, this.hDl);
            d dVar = this.hDm;
            if (dVar == null) {
                p.hyc();
            }
            dVar.a(this.hDn, this.hDo, NativeBitmapStruct.GLFormat.GL_RGBA, null, 9729, 10497);
            b bVar2 = this.hiH;
            if (bVar2 == null) {
                p.hyc();
            }
            int i2 = this.hDl;
            d dVar2 = this.hDm;
            if (dVar2 == null) {
                p.hyc();
            }
            b.a(bVar2, i2, dVar2.igv, false, 40);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "filterProcess error", new Object[0]);
        }
        Log.d(TAG, "filterProcess: cost %s", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(196617);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/core/render/LiveFilterProcessTex$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(196618);
        AppMethodBeat.o(196618);
    }
}
