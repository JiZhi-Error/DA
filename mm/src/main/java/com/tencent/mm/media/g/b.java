package com.tencent.mm.media.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010!\u001a\u00020\u001cJ\u0006\u0010\"\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020\u001cJ\u000e\u0010$\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aXT¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/media/globject/GLLeakIDKeyReport;", "", "()V", "FBO_STEP", "", "ID", "", "KEY_ABSSURFACERENDERER", "KEY_FADEDRAWER", "KEY_GLTEXTURERENDERPROC", "KEY_GLTEXTURERENDERPROCBLEND", "KEY_GLTEXTURERENDERPROCYUVTORGB", "KEY_IMAGEDRAWER", "KEY_LIVE", "KEY_MULTITALK", "KEY_MULTI_VIDEO", "KEY_OTHER", "KEY_SCRIPTRENDER", "KEY_STICKERPREVIEWRENDER", "KEY_VLOGREMUXSURFACE", "KEY_VLogScriptTexCache", "KEY_VOIP", "KEY_XEFFECT_RENDERER", "KEY_XLABEFFECT", "NOT_DEFINED", "TAG", "", "markGLFBOCreated", "", "markGLFBOLeaked", "markGLFBOLeakedInErrorTid", "markGLFBOLeakedScene", "key", "markGLTextureCreated", "markGLTextureLeaked", "markGLTextureLeakedInErrorTid", "markGLTextureLeakedScene", "plugin-mediaeditor_release"})
public final class b {
    public static final b igr = new b();

    static {
        AppMethodBeat.i(93693);
        AppMethodBeat.o(93693);
    }

    private b() {
    }

    public static void aMu() {
        AppMethodBeat.i(93685);
        Log.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureCreated");
        h.INSTANCE.n(1184, 0, 1);
        AppMethodBeat.o(93685);
    }

    public static void aMv() {
        AppMethodBeat.i(93686);
        Log.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeaked");
        h.INSTANCE.n(1184, 1, 1);
        AppMethodBeat.o(93686);
    }

    public static void zG(long j2) {
        AppMethodBeat.i(93687);
        Log.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeakedScene key:".concat(String.valueOf(j2)));
        h.INSTANCE.n(1184, j2, 1);
        AppMethodBeat.o(93687);
    }

    public static void aMw() {
        AppMethodBeat.i(93688);
        Log.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOCreated");
        h.INSTANCE.n(1184, 100, 1);
        AppMethodBeat.o(93688);
    }

    public static void aMx() {
        AppMethodBeat.i(93689);
        Log.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeaked");
        h.INSTANCE.n(1184, 101, 1);
        AppMethodBeat.o(93689);
    }

    public static void zH(long j2) {
        AppMethodBeat.i(93690);
        Log.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeakedScene key:".concat(String.valueOf(j2)));
        h.INSTANCE.n(1184, 100 + j2, 1);
        AppMethodBeat.o(93690);
    }

    public static void aMy() {
        AppMethodBeat.i(93691);
        Log.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeakedInErrorTid");
        h.INSTANCE.n(1184, 200, 1);
        AppMethodBeat.o(93691);
    }

    public static void aMz() {
        AppMethodBeat.i(93692);
        Log.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeakedInErrorTid");
        h.INSTANCE.n(1184, 201, 1);
        AppMethodBeat.o(93692);
    }
}
