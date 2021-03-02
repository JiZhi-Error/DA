package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.xlabeffect.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import kotlin.x;

public final class a {
    public static boolean Hkk = true;
    public static boolean Hkl = true;
    public static float Hkm = 180.0f;
    com.tencent.mm.media.j.b.a BXr;
    private int Hkn = -1;
    d Hko;
    byte[] Hkp;
    ByteBuffer Hkq = null;
    int Hkr = 0;
    volatile boolean bfY = false;
    d hDm;
    int hDn;
    int hDo;
    b hiH;
    private boolean isInit = false;

    public final void a(d dVar, d dVar2, int i2) {
        AppMethodBeat.i(115704);
        try {
            Log.i("MicroMsg.FilterProcessTex", "initial %s, %d, beauytParams:%s", this, Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(i2));
            if (this.hiH != null) {
                Log.w("MicroMsg.FilterProcessTex", "initial xLabEffect: again");
                this.hiH.destroy();
            }
            this.hiH = new b(0, 0, 1);
            this.hiH.zG(false);
            int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_lut_color_weight, 0);
            int a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_skin_smooth_weight, -1);
            int a4 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_skin_bright_weight, -1);
            int a5 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_eye_bigger_weight, -1);
            int a6 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_eye_bright_weight, -1);
            int a7 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_face_thin_weight, -1);
            Log.i("MicroMsg.FilterProcessTex", "Face beauty config: lutWeight: %d, skinSmooth: %d, skinBright: %d, eyeMorph: %d, eyeBright: %d, faceMorph: %d", Integer.valueOf(a2), Integer.valueOf(a3), Integer.valueOf(a4), Integer.valueOf(a5), Integer.valueOf(a6), Integer.valueOf(a7));
            this.hiH.l(a3, a5, a7, a4, a6);
            boolean z = (i2 & 1) != 0;
            boolean z2 = (i2 & 2) != 0;
            boolean z3 = (i2 & 4) != 0;
            Log.i("MicroMsg.FilterProcessTex", "initial, needSkin:%s, needShape:%s, needFilter:%s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
            if (z) {
                this.hiH.glh();
            }
            if (z2) {
                this.hiH.glj();
            }
            if (z3) {
                this.hiH.gll();
                this.hiH.aa(true, a2);
            }
            this.Hko = dVar;
            this.hDm = dVar2;
            this.BXr = new e(this.hDn, this.hDo, this.hDn, this.hDo, 2, 1);
            this.BXr.ijJ = new kotlin.g.a.b<IntBuffer, x>() {
                /* class com.tencent.mm.plugin.voip.video.a.a.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(IntBuffer intBuffer) {
                    AppMethodBeat.i(115703);
                    a.this.Hkq = a.this.BXr.ijR;
                    if (a.this.Hkq != null) {
                        a.this.bfY = true;
                    }
                    AppMethodBeat.o(115703);
                    return null;
                }
            };
            Log.d("MicroMsg.FilterProcessTex", "initial end %s", this);
            AppMethodBeat.o(115704);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FilterProcessTex", e2, "initial error", new Object[0]);
            AppMethodBeat.o(115704);
        }
    }

    public final ByteBuffer fLy() {
        AppMethodBeat.i(235892);
        if (!this.bfY) {
            Log.i("MicroMsg.FilterProcessTex", "still not have data");
            AppMethodBeat.o(235892);
            return null;
        }
        ByteBuffer byteBuffer = this.Hkq;
        AppMethodBeat.o(235892);
        return byteBuffer;
    }
}
