package com.tencent.mm.plugin.game;

import android.content.Context;
import android.database.Cursor;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.c;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.protobuf.bb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.net.URLEncoder;
import java.util.HashMap;

public final class d implements c {
    @Override // com.tencent.mm.plugin.game.api.c
    public final int NY(int i2) {
        int i3 = 2;
        AppMethodBeat.i(204088);
        if (i2 == 1) {
            i3 = 1;
        } else if (i2 != 2) {
            AppMethodBeat.o(204088);
            return 0;
        }
        int Op = ((f) g.af(f.class)).dSK().Op(i3);
        AppMethodBeat.o(204088);
        return Op;
    }

    @Override // com.tencent.mm.plugin.game.api.c
    public final String NZ(int i2) {
        String string;
        int i3;
        o oVar;
        o oVar2 = null;
        AppMethodBeat.i(204089);
        if (i2 == 1) {
            string = MMApplicationContext.getContext().getString(R.string.dpf);
            i3 = 1;
        } else if (i2 == 2) {
            string = MMApplicationContext.getContext().getString(R.string.drv);
            i3 = 2;
        } else {
            AppMethodBeat.o(204089);
            return "";
        }
        Cursor On = ((f) g.af(f.class)).dSK().On(i3);
        if (On != null) {
            if (On.moveToFirst()) {
                oVar = new o();
                oVar.convertFrom(On);
            } else {
                oVar = null;
            }
            On.close();
            oVar2 = oVar;
        }
        if (oVar2 != null) {
            oVar2.dVl();
            String str = oVar2.xFg.mText;
            if (Util.isNullOrNil(str)) {
                str = oVar2.xFi.mDesc;
            }
            if (Util.isNullOrNil(str)) {
                string = MMApplicationContext.getContext().getString(R.string.do1);
            } else {
                string = str;
            }
            int Op = ((f) g.af(f.class)).dSK().Op(i3);
            if (Op > 1) {
                string = MMApplicationContext.getContext().getString(R.string.dr6, Integer.valueOf(Op), string);
            }
        }
        AppMethodBeat.o(204089);
        return string;
    }

    @Override // com.tencent.mm.plugin.game.api.c
    public final void a(final c.a aVar) {
        AppMethodBeat.i(204090);
        if (((Boolean) g.aAh().azQ().get(ar.a.USERINFO_GAME_LIFE_HISTORY_DELETED_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            aVar.a(null);
            AppMethodBeat.o(204090);
            return;
        }
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.game.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(204086);
                bb dSY = a.dSY();
                if (dSY == null || dSY.xKY == null || Util.isNullOrNil(dSY.xKY.xMs)) {
                    if (aVar != null) {
                        aVar.a(null);
                    }
                    AppMethodBeat.o(204086);
                    return;
                }
                c.b dVB = ((f) g.af(f.class)).dSK().dVB();
                if (aVar != null) {
                    aVar.a(dVB);
                }
                AppMethodBeat.o(204086);
            }
        });
        AppMethodBeat.o(204090);
    }

    @Override // com.tencent.mm.plugin.game.api.c
    public final void fV(Context context) {
        AppMethodBeat.i(204091);
        bb dSY = a.dSY();
        if (!(dSY == null || dSY.xKY == null || Util.isNullOrNil(dSY.xKY.xMs))) {
            com.tencent.mm.plugin.game.e.c.aQ(context, dSY.xKY.xMs);
        }
        AppMethodBeat.o(204091);
    }

    @Override // com.tencent.mm.plugin.game.api.c
    public final void dSH() {
        AppMethodBeat.i(204092);
        g.aAh().azQ().set(ar.a.USERINFO_GAME_LIFE_HISTORY_DELETED_BOOLEAN, Boolean.TRUE);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.game.d.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(204087);
                Log.i("MicroMsg.GameMessageStorage", "deleteGameLifeChatMsg history ret:%s", Boolean.valueOf(((f) g.af(f.class)).dSK().execSQL("GameRawMessage", "delete from GameRawMessage where rawXML like \"%<chatmsg%\"")));
                AppMethodBeat.o(204087);
            }
        });
        AppMethodBeat.o(204092);
    }

    @Override // com.tencent.mm.plugin.game.api.c
    public final int C(Context context, String str, String str2) {
        String F;
        AppMethodBeat.i(204093);
        Log.i("MicroMsg.GameExternalService", "fromUsername:%s, toUsername:%s", str, str2);
        if (context == null || Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(204093);
            return -1;
        }
        bb dSY = a.dSY();
        if (dSY == null || dSY.xLb == null || dSY.xLb.xMh == null) {
            Log.i("MicroMsg.GameExternalService", "no Gift info");
            AppMethodBeat.o(204093);
            return -1;
        }
        Log.i("MicroMsg.GameExternalService", "GiftEntranceType:%d", Integer.valueOf(dSY.xLb.xMh.oUv));
        switch (dSY.xLb.xMh.oUv) {
            case 1:
                if (!Util.isNullOrNil(dSY.xLb.xMh.xIy)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("from_username", str);
                    hashMap.put("to_username", str2);
                    String F2 = com.tencent.mm.plugin.game.e.c.F(dSY.xLb.xMh.xIy, hashMap);
                    Log.i("MicroMsg.GameExternalService", "Gift jumpUrl:%s", F2);
                    com.tencent.mm.plugin.game.e.c.aQ(context, F2);
                    AppMethodBeat.o(204093);
                    return 40;
                }
                break;
            case 2:
                if (dSY.xLb.xMh.xJb != null && !Util.isNullOrNil(dSY.xLb.xMh.xJb.jfi)) {
                    String str3 = dSY.xLb.xMh.xJb.xut;
                    if (Util.isNullOrNil(str3)) {
                        F = "?from_username=" + URLEncoder.encode(str) + "&to_username=" + URLEncoder.encode(str2);
                    } else {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("from_username", str);
                        hashMap2.put("to_username", str2);
                        F = com.tencent.mm.plugin.game.e.c.F(str3, hashMap2);
                    }
                    Log.i("MicroMsg.GameExternalService", "Gift Weapp, AppId:%s, Path:%s", dSY.xLb.xMh.xJb.jfi, F);
                    com.tencent.mm.plugin.game.e.c.c(context, dSY.xLb.xMh.xJb.jfi, F, dSY.xLb.xMh.xJb.xMC);
                    AppMethodBeat.o(204093);
                    return 71;
                }
        }
        AppMethodBeat.o(204093);
        return -1;
    }
}
