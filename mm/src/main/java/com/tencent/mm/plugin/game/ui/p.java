package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class p extends b {
    public p(Context context, int i2) {
        super(context);
        this.xGR = i2;
    }

    public final void onClick(View view) {
        o oVar;
        AppMethodBeat.i(42282);
        Object tag = view.getTag();
        if (tag == null) {
            Log.e("MicroMsg.GameMessageOnClickListener", "Tag is null.");
            oVar = null;
        } else if (!(tag instanceof Long)) {
            Log.e("MicroMsg.GameMessageOnClickListener", "The tag of action listener is not instance of Long");
            oVar = null;
        } else {
            o GJ = ((f) g.af(f.class)).dSK().GJ(((Long) tag).longValue());
            if (GJ != null) {
                GJ.dVl();
            }
            oVar = GJ;
        }
        if (oVar == null) {
            Log.e("MicroMsg.GameMessageContentClickListener", "The game message is null.");
            AppMethodBeat.o(42282);
            return;
        }
        String a2 = com.tencent.mm.game.report.f.a(null, null, oVar.xFX, null);
        switch (oVar.field_msgType) {
            case 5:
                if (!Util.isNullOrNil(oVar.xFC)) {
                    com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, c.aQ(this.mContext, oVar.xFC), 0, oVar.field_appId, this.xGR, oVar.field_msgType, oVar.field_gameMsgId, oVar.xFW, a2);
                    AppMethodBeat.o(42282);
                    return;
                }
                break;
            case 6:
                if (!Util.isNullOrNil(oVar.xFz)) {
                    com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, c.aQ(this.mContext, oVar.xFz), 0, oVar.field_appId, this.xGR, oVar.field_msgType, oVar.field_gameMsgId, oVar.xFW, a2);
                    AppMethodBeat.o(42282);
                    return;
                }
                break;
            case 7:
            case 8:
            case 9:
            default:
                com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, a(this.mContext, oVar), 0, oVar.field_appId, this.xGR, oVar.field_msgType, oVar.field_gameMsgId, oVar.xFW, a2);
                break;
            case 10:
            case 11:
                if (!Util.isNullOrNil(oVar.xEW)) {
                    com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, c.aQ(this.mContext, oVar.xEW), 0, oVar.field_appId, this.xGR, oVar.field_msgType, oVar.field_gameMsgId, oVar.xFW, a2);
                    AppMethodBeat.o(42282);
                    return;
                }
                com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, a(this.mContext, oVar), 0, oVar.field_appId, this.xGR, oVar.field_msgType, oVar.field_gameMsgId, oVar.xFW, a2);
                AppMethodBeat.o(42282);
                return;
        }
        AppMethodBeat.o(42282);
    }
}
