package com.tencent.mm.plugin.emojicapture.d;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.emojicapture.ui.b.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.xlabeffect.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sticker.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0017\u001a\u00020\u0014J\u0006\u0010\u0018\u001a\u00020\u0014J\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0004J\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess;", "", "()V", "effectEnable", "", "getEffectEnable", "()Z", "setEffectEnable", "(Z)V", "faceTrackFbo", "", "inputTexture", "lensId", "", "outputTexture", "textureHeight", "textureWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "clear", "filterProcess", "initial", "previewRgbTexture", "setInputTexture", "texture", "setRemoveBg", "remove", "updateTextureSize", "Companion", "plugin-emojicapture_release"})
public final class a {
    public static final String TAG = TAG;
    public static final C0969a rog = new C0969a((byte) 0);
    public int hDl;
    public int hDn;
    public int hDo;
    public b hiH;
    private String rnS;
    public int rod;
    public int roe;
    public boolean rof = MultiProcessMMKV.getMMKV("xlab_effect_config").getBoolean("effect", true);

    public a() {
        AppMethodBeat.i(137);
        AppMethodBeat.o(137);
    }

    public final void fG(int i2, int i3) {
        AppMethodBeat.i(c.CTRL_INDEX);
        this.hDl = i2;
        this.rod = i3;
        try {
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            Log.i(TAG, "initial %s, %d, " + this.rof, this, Long.valueOf(currentThread.getId()));
            this.hiH = new b(0, 0, 0, false, false, 15);
            int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_skin_smooth_weight, -1);
            int a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_skin_bright_weight, -1);
            int a4 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_eye_bigger_weight, -1);
            int a5 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_eye_bright_weight, -1);
            int a6 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_face_thin_weight, -1);
            Log.i(TAG, "Face beauty config: skinSmooth: %d, skinBright: %d, eyeMorph: %d, eyeBright: %d, faceMorph: %d", Integer.valueOf(a2), Integer.valueOf(a3), Integer.valueOf(a4), Integer.valueOf(a5), Integer.valueOf(a6));
            com.tencent.mm.plugin.xlabeffect.b bVar = this.hiH;
            if (bVar != null) {
                bVar.l(a2, a4, a6, a3, a5);
            }
            com.tencent.mm.plugin.xlabeffect.b bVar2 = this.hiH;
            if (bVar2 != null) {
                bVar2.ti(true);
            }
            com.tencent.mm.plugin.xlabeffect.b bVar3 = this.hiH;
            if (bVar3 != null) {
                bVar3.zG(false);
            }
            b.a aVar = com.tencent.mm.plugin.emojicapture.ui.b.b.rvS;
            this.roe = b.a.cJU();
            Log.d(TAG, "initial end %s", this);
            AppMethodBeat.o(c.CTRL_INDEX);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "initial error", new Object[0]);
            e eVar = e.roB;
            e.cIV();
            AppMethodBeat.o(c.CTRL_INDEX);
        }
    }

    public final void clear() {
        AppMethodBeat.i(r.CTRL_INDEX);
        String str = TAG;
        Thread currentThread = Thread.currentThread();
        p.g(currentThread, "Thread.currentThread()");
        Log.i(str, "clear %s %d", this, Long.valueOf(currentThread.getId()));
        try {
            GLES20.glDeleteFramebuffers(1, new int[]{this.roe}, 0);
            com.tencent.mm.plugin.xlabeffect.b bVar = this.hiH;
            if (bVar != null) {
                bVar.destroy();
            }
            this.hiH = null;
            AppMethodBeat.o(r.CTRL_INDEX);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "clear error: %s", e2.getMessage());
            e eVar = e.roB;
            e.cIX();
            AppMethodBeat.o(r.CTRL_INDEX);
        }
    }

    public final void a(f fVar) {
        String str;
        String str2;
        String str3 = null;
        AppMethodBeat.i(256428);
        String str4 = TAG;
        StringBuilder append = new StringBuilder("changeSticker: ").append(this.rnS).append(", ");
        if (fVar != null) {
            str = fVar.rnS;
        } else {
            str = null;
        }
        Log.i(str4, append.append(str).toString());
        String str5 = this.rnS;
        if (fVar != null) {
            str2 = fVar.rnS;
        } else {
            str2 = null;
        }
        if (!p.j(str5, str2)) {
            if (fVar != null) {
                str3 = fVar.rnS;
            }
            this.rnS = str3;
            com.tencent.mm.plugin.xlabeffect.b bVar = this.hiH;
            if (bVar != null) {
                bVar.a(fVar);
                AppMethodBeat.o(256428);
                return;
            }
        }
        AppMethodBeat.o(256428);
    }

    public final void lF(boolean z) {
        AppMethodBeat.i(256429);
        Log.i(TAG, "setRemoveBg: ".concat(String.valueOf(z)));
        com.tencent.mm.plugin.xlabeffect.b bVar = this.hiH;
        if (bVar != null) {
            bVar.zG(z);
            AppMethodBeat.o(256429);
            return;
        }
        AppMethodBeat.o(256429);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.d.a$a  reason: collision with other inner class name */
    public static final class C0969a {
        private C0969a() {
        }

        public /* synthetic */ C0969a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(138);
        AppMethodBeat.o(138);
    }
}
