package com.tencent.mm.plugin.teenmode.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.teenmode.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.u;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class b implements com.tencent.mm.plugin.teenmode.a.b {
    private Set<c> FWj;

    /* synthetic */ b(byte b2) {
        this();
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final boolean Vt() {
        AppMethodBeat.i(187361);
        boolean nullAsFalse = Util.nullAsFalse(Boolean.valueOf(g.aAh().azQ().getBoolean(ar.a.USERINFO_SETTING_TEEN_MODE_STATE_BOOLEAN_SYNC, false)));
        Log.d("MicroMsg.TeenModeService", "isTeenMode:%s", Boolean.valueOf(nullAsFalse));
        AppMethodBeat.o(187361);
        return nullAsFalse;
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final int dxW() {
        AppMethodBeat.i(187362);
        int i2 = g.aAh().azQ().getInt(ar.a.USERINFO_SETTING_TEEN_MODE_FINDER_RANGE_INT_SYNC, 0);
        Log.d("MicroMsg.TeenModeService", "getFinderOption, option:%s", Integer.valueOf(i2));
        AppMethodBeat.o(187362);
        return i2;
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final int fvo() {
        AppMethodBeat.i(187363);
        int i2 = g.aAh().azQ().getInt(ar.a.USERINFO_SETTING_TEEN_MODE_BIZ_ACCT_RANGE_INT_SYNC, 0);
        Log.d("MicroMsg.TeenModeService", "getBizAcctOption, option:%s", Integer.valueOf(i2));
        AppMethodBeat.o(187363);
        return i2;
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final int fvp() {
        AppMethodBeat.i(187364);
        int i2 = g.aAh().azQ().getInt(ar.a.USERINFO_SETTING_TEEN_MODE_MINI_PROGRAM_RANGE_INT_SYNC, 0);
        Log.d("MicroMsg.TeenModeService", "getMiniProgramOption, option:%s", Integer.valueOf(i2));
        AppMethodBeat.o(187364);
        return i2;
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final void hr(Context context) {
        AppMethodBeat.i(187365);
        u.u(context, context.getString(R.string.hme), R.raw.teen_mode);
        AppMethodBeat.o(187365);
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final void pl(int i2) {
        AppMethodBeat.i(187366);
        h.INSTANCE.a(20917, Integer.valueOf(i2));
        AppMethodBeat.o(187366);
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final boolean fvr() {
        boolean z;
        AppMethodBeat.i(187367);
        String str = (String) g.aAh().azQ().get(274436, (Object) null);
        if (Util.isNullOrNil(str) || !str.toUpperCase().equals(WeChatBrands.AppInfo.LANG_CN)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            Log.i("MicroMsg.TeenModeService", "isHideTeenModeEntrance, not in china, hide entrance.");
            AppMethodBeat.o(187367);
            return true;
        }
        String value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("ShowTeenagerMode");
        if (Util.isNullOrNil(value)) {
            Log.i("MicroMsg.TeenModeService", "isHideTeenModeEntrance, ShowTeenagerMode is null");
            AppMethodBeat.o(187367);
            return false;
        }
        int parseInt = Integer.parseInt(value);
        Log.i("MicroMsg.TeenModeService", "isHideTeenModeEntrance, val is %s", Integer.valueOf(parseInt));
        if (value == null || 1 != parseInt) {
            AppMethodBeat.o(187367);
            return false;
        }
        AppMethodBeat.o(187367);
        return true;
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final void a(c cVar) {
        AppMethodBeat.i(187368);
        if (cVar != null) {
            this.FWj.add(cVar);
        }
        AppMethodBeat.o(187368);
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final void b(c cVar) {
        AppMethodBeat.i(187369);
        if (cVar != null) {
            this.FWj.remove(cVar);
        }
        AppMethodBeat.o(187369);
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final void fvq() {
        AppMethodBeat.i(187370);
        Log.d("MicroMsg.TeenModeService", "notifyTeenModeDataChanged %d", Integer.valueOf(this.FWj.size()));
        for (c cVar : this.FWj) {
            cVar.onDataChanged();
        }
        AppMethodBeat.o(187370);
    }

    static class a {
        public static b FWk = new b((byte) 0);

        static {
            AppMethodBeat.i(187360);
            AppMethodBeat.o(187360);
        }
    }

    public static b fvs() {
        return a.FWk;
    }

    private b() {
        AppMethodBeat.i(187371);
        this.FWj = new CopyOnWriteArraySet();
        AppMethodBeat.o(187371);
    }
}
