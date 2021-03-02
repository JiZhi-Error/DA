package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class b implements View.OnClickListener {
    protected Context mContext;
    protected int sPt = 1301;
    protected int xGR;

    public b(Context context) {
        this.mContext = context;
        if (context == null) {
            throw new IllegalArgumentException("context is null.");
        }
    }

    protected static int a(Context context, o oVar) {
        if (oVar == null) {
            Log.e("MicroMsg.GameMessageOnClickListener", "game message is null.");
            return 0;
        } else if (!Util.isNullOrNil(oVar.field_appId)) {
            Bundle bundle = new Bundle();
            bundle.putCharSequence("game_app_id", oVar.field_appId);
            bundle.putInt("game_report_from_scene", 1301);
            return c.b(context, oVar.field_appId, null, bundle);
        } else {
            Log.e("MicroMsg.GameMessageOnClickListener", "message type : " + oVar.field_msgType + " ,message.field_appId is null.");
            return 0;
        }
    }
}
