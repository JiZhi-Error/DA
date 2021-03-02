package com.tencent.mm.media.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/media/remuxer/RemuxConfig;", "", "()V", "Companion", "plugin-mediaeditor_release"})
public final class j {
    public static final a ijn = new a((byte) 0);

    static {
        AppMethodBeat.i(93836);
        AppMethodBeat.o(93836);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/media/remuxer/RemuxConfig$Companion;", "", "()V", "getAudioCpFile", "", "filePath", "getCpVideoFile", "file", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String Ho(String str) {
            AppMethodBeat.i(93834);
            p.h(str, "filePath");
            String str2 = str + "_audio.aac";
            AppMethodBeat.o(93834);
            return str2;
        }

        public static String Hp(String str) {
            AppMethodBeat.i(93835);
            p.h(str, "file");
            if (MMApplicationContext.isMainProcess()) {
                StringBuilder sb = new StringBuilder();
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                String sb2 = sb.append(aAh.azM()).append("videoMix/").toString();
                s.boN(sb2);
                String str2 = sb2 + s.bhK(str) + "_cp_video.temp";
                AppMethodBeat.o(93835);
                return str2;
            }
            String str3 = ar.NSe + "tmp";
            if (!s.YS(str3)) {
                s.boN(str3);
            }
            String str4 = str3 + FilePathGenerator.ANDROID_DIR_SEP + s.bhK(str) + "_cp_video.temp";
            AppMethodBeat.o(93835);
            return str4;
        }
    }
}
