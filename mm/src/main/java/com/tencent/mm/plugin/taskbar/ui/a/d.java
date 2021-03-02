package com.tencent.mm.plugin.taskbar.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBgLogImpl;", "Lcom/tencent/mm/dynamicbackground/util/DynamicBgLog$LogImp;", "()V", "d", "", "tag", "", "log", "e", "i", "v", "w", "plugin-taskbar_release"})
public final class d implements c.a {
    public static final d FVe = new d();

    static {
        AppMethodBeat.i(238477);
        AppMethodBeat.o(238477);
    }

    private d() {
    }

    @Override // com.tencent.mm.dynamicbackground.a.c.a
    public final void i(String str, String str2) {
        AppMethodBeat.i(238472);
        Log.i(str, str2);
        AppMethodBeat.o(238472);
    }

    @Override // com.tencent.mm.dynamicbackground.a.c.a
    public final void w(String str, String str2) {
        AppMethodBeat.i(238473);
        Log.w(str, str2);
        AppMethodBeat.o(238473);
    }

    @Override // com.tencent.mm.dynamicbackground.a.c.a
    public final void v(String str, String str2) {
        AppMethodBeat.i(238474);
        Log.v(str, str2);
        AppMethodBeat.o(238474);
    }

    @Override // com.tencent.mm.dynamicbackground.a.c.a
    public final void e(String str, String str2) {
        AppMethodBeat.i(238475);
        Log.e(str, str2);
        AppMethodBeat.o(238475);
    }

    @Override // com.tencent.mm.dynamicbackground.a.c.a
    public final void d(String str, String str2) {
        AppMethodBeat.i(238476);
        Log.d(str, str2);
        AppMethodBeat.o(238476);
    }
}
