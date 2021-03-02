package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.Util;

public final class o extends b {
    public o(Context context, int i2) {
        super(context);
        this.xGR = i2;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(42277);
        if (!(view.getTag() instanceof com.tencent.mm.plugin.game.model.o)) {
            AppMethodBeat.o(42277);
            return;
        }
        com.tencent.mm.plugin.game.model.o oVar = (com.tencent.mm.plugin.game.model.o) view.getTag();
        switch (oVar.field_msgType) {
            case 6:
                if (!Util.isNullOrNil(oVar.xFd)) {
                    f.a(this.mContext, 13, 1301, 5, c.aQ(this.mContext, oVar.xFd), 0, oVar.field_appId, this.xGR, oVar.field_msgType, oVar.field_gameMsgId, oVar.xFW, f.a(null, null, oVar.xFX, null));
                    AppMethodBeat.o(42277);
                    return;
                }
                break;
            default:
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", oVar.field_appId);
                bundle.putInt("game_report_from_scene", 1301);
                f.a(this.mContext, 13, 1301, 5, c.b(this.mContext, oVar.field_appId, null, bundle), 0, oVar.field_appId, this.xGR, oVar.field_msgType, oVar.field_gameMsgId, oVar.xFW, f.a(null, null, oVar.xFX, null));
                break;
        }
        AppMethodBeat.o(42277);
    }
}
