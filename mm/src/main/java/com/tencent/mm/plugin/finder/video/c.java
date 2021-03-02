package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.b;
import java.util.Arrays;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0014J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderGLTextureRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "videoHeight", "videoWidth", "initDrawCoordBuffer", "", "setVideoSize", "width", "height", "plugin-finder_release"})
public final class c extends b {
    int videoHeight;
    int videoWidth;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"valid", "", "size", "invoke"})
    static final class a extends q implements kotlin.g.a.b<Float, Float> {
        public static final a wct = new a();

        static {
            AppMethodBeat.i(254013);
            AppMethodBeat.o(254013);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Float invoke(Float f2) {
            AppMethodBeat.i(254012);
            Float valueOf = Float.valueOf(au(f2.floatValue()));
            AppMethodBeat.o(254012);
            return valueOf;
        }

        public static float au(float f2) {
            if (f2 > 1.0f) {
                return 1.0f;
            }
            if (f2 < 0.0f) {
                return 0.0f;
            }
            return f2;
        }
    }

    public c(int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i2, i3, i4, i5, i6, i7);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void aMS() {
        int i2;
        int i3;
        AppMethodBeat.i(254014);
        if (this.scaleType == 4) {
            RectF aMR = aMR();
            float f2 = aMR.left;
            float f3 = aMR.top;
            float f4 = aMR.right;
            float f5 = aMR.bottom;
            Rect rect = this.ijA;
            if (rect != null) {
                float[] fArr = com.tencent.mm.media.k.c.iln;
                float[] copyOf = Arrays.copyOf(fArr, fArr.length);
                a aVar = a.wct;
                if (this.videoWidth > 0) {
                    i2 = this.videoWidth;
                } else {
                    i2 = this.hDn;
                }
                if (this.videoHeight > 0) {
                    i3 = this.videoHeight;
                } else {
                    i3 = this.hDo;
                }
                float au = a.au(((float) rect.left) / ((float) i2));
                float au2 = a.au(((float) rect.right) / ((float) i2));
                float au3 = a.au(((float) rect.bottom) / ((float) i3));
                float au4 = a.au(((float) rect.top) / ((float) i3));
                float abs = Math.abs(f4 - f2);
                float abs2 = Math.abs(f5 - f3);
                float f6 = (au * abs) + f2;
                float f7 = (au2 * abs) + f2;
                float min = Math.min(f3, f5) + (abs2 * au3);
                float min2 = (au4 * abs2) + Math.min(f3, f5);
                copyOf[0] = f6;
                copyOf[1] = min2;
                copyOf[2] = f7;
                copyOf[3] = min2;
                copyOf[4] = f6;
                copyOf[5] = min;
                copyOf[6] = f7;
                copyOf[7] = min;
                this.hDT.put(com.tencent.mm.media.k.c.iln);
                this.hDT.position(0);
                this.hDT.put(copyOf);
                this.hDT.position(0);
                this.hDU.position(0);
            }
            this.hDU.position(0);
            this.hDU.put(com.tencent.mm.media.k.c.ilm);
            this.hDU.position(0);
            AppMethodBeat.o(254014);
            return;
        }
        super.aMS();
        AppMethodBeat.o(254014);
    }
}
