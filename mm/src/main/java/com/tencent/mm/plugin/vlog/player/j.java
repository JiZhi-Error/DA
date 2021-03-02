package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.c;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache;", "", "()V", "externalTexIndex", "", "externalTexsPool", "", "Lcom/tencent/mm/media/globject/GLTextureObject;", "[Lcom/tencent/mm/media/globject/GLTextureObject;", "normalTexIndex", "normalTexsPool", "clearCache", "", "initCache", "releaseExternalTex", "tex", "releaseNormalTex", "requestExternalTex", "requestNormalTex", "Companion", "plugin-vlog_release"})
public final class j {
    public static final a GCf = new a((byte) 0);
    final d[] GCb = new d[2];
    final d[] GCc = new d[2];
    int GCd;
    int GCe;

    static {
        AppMethodBeat.i(190886);
        AppMethodBeat.o(190886);
    }

    public j() {
        AppMethodBeat.i(190885);
        AppMethodBeat.o(190885);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache$Companion;", "", "()V", "TAG", "", "cacheTexsNum", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void fCp() {
        AppMethodBeat.i(190884);
        Log.i("MicroMsg.VLogScriptTexCache", "init cache, cacheTexsNum:2");
        for (int i2 = 0; i2 < 2; i2++) {
            this.GCb[i2] = c.a(false, 11);
            this.GCc[i2] = c.a(true, 11);
        }
        AppMethodBeat.o(190884);
    }
}
