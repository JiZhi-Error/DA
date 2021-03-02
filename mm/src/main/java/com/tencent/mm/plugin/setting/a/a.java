package com.tencent.mm.plugin.setting.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.al;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/setting/report/FindMoreSettingReport;", "", "()V", "TAG", "", "reportNearby3TabSwitch", "", "switch", "", "reportNearbyPersonSwitch", "reportNearbySwitch", "entranceId", "", "settingEvent", "plugin-setting_release"})
public final class a {
    public static final a CYr = new a();

    static {
        AppMethodBeat.i(256606);
        AppMethodBeat.o(256606);
    }

    private a() {
    }

    public static void ak(long j2, long j3) {
        AppMethodBeat.i(256605);
        al alVar = new al();
        alVar.cd(j2);
        alVar.ce(j3);
        alVar.acd();
        alVar.bfK();
        Log.d("FindMoreSettingReport", "reportNearbySwitch " + alVar.abW());
        AppMethodBeat.o(256605);
    }
}
