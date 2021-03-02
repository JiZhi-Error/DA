package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.xeffect.XEffectLog;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/xlabeffect/XLabEffectUtil;", "", "()V", "setupXLog", "", "plugin-xlabeffect_release"})
public final class d {
    public static final d JRC = new d();

    static {
        AppMethodBeat.i(215243);
        AppMethodBeat.o(215243);
    }

    private d() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ9\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ9\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ9\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ9\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/xlabeffect/XLabEffectUtil$setupXLog$1", "Lcom/tencent/mm/xeffect/XEffectLog$ILog;", "d", "", "TAG", "", "format", "args", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "v", "w", "plugin-xlabeffect_release"})
    public static final class a implements XEffectLog.b {
        a() {
        }

        @Override // com.tencent.mm.xeffect.XEffectLog.b
        public final void d(String str, String str2, Object... objArr) {
            AppMethodBeat.i(215239);
            p.h(objArr, "args");
            Log.d(str, str2, Arrays.copyOf(objArr, objArr.length));
            AppMethodBeat.o(215239);
        }

        @Override // com.tencent.mm.xeffect.XEffectLog.b
        public final void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(215240);
            p.h(objArr, "args");
            Log.i(str, str2, Arrays.copyOf(objArr, objArr.length));
            AppMethodBeat.o(215240);
        }

        @Override // com.tencent.mm.xeffect.XEffectLog.b
        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(215241);
            p.h(objArr, "args");
            Log.e(str, str2, Arrays.copyOf(objArr, objArr.length));
            AppMethodBeat.o(215241);
        }
    }

    public static final void gls() {
        AppMethodBeat.i(215242);
        XEffectLog.a(new a());
        AppMethodBeat.o(215242);
    }
}
