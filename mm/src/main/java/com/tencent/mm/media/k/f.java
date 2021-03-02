package com.tencent.mm.media.k;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/media/util/VideoConfigUtil;", "", "()V", "Companion", "plugin-mediaeditor_release"})
public final class f {
    private static final int ilD = 1;
    private static int ilE = 2;
    private static int ilF = 3;
    public static final a ilG = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\nR\u000e\u0010\u0010\u001a\u00020\u0011XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/media/util/VideoConfigUtil$Companion;", "", "()V", "BASE_LEVEL_BITRATE", "", "getBASE_LEVEL_BITRATE", "()I", "HIGH_LEVEL_BITRATE", "getHIGH_LEVEL_BITRATE", "setHIGH_LEVEL_BITRATE", "(I)V", "LOW_LEVEL_BITRATE", "getLOW_LEVEL_BITRATE", "SUPER_HIGH_LEVEL_BITRATE", "getSUPER_HIGH_LEVEL_BITRATE", "setSUPER_HIGH_LEVEL_BITRATE", "TAG", "", "getCommandBitrate", "width", "mode", "getCommandHeight", "standardVideoParamWithWidth", "", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static int ro(int i2) {
            AppMethodBeat.i(94002);
            Point az = ao.az(MMApplicationContext.getContext());
            int i3 = (az.y * i2) / az.x;
            AppMethodBeat.o(94002);
            return i3;
        }
    }

    static {
        AppMethodBeat.i(94003);
        AppMethodBeat.o(94003);
    }
}
