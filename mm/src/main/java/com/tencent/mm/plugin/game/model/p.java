package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class p implements View.OnClickListener {
    private Context mContext;
    public int xGR;

    public static class a {
        public int dYu = 1301;
        public int position;
        public o xGS;
        public String xGs;

        public a(o oVar, String str, int i2) {
            this.xGS = oVar;
            this.xGs = str;
            this.position = i2;
        }
    }

    public p(Context context) {
        this.mContext = context;
    }

    public p(Context context, int i2) {
        this.mContext = context;
        this.xGR = i2;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(41455);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            Log.e("MicroMsg.GameMessageClickListener", "v.getTag is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41455);
            return;
        }
        a aVar = (a) view.getTag();
        if (aVar.xGS == null) {
            Log.e("MicroMsg.GameMessageClickListener", "message is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41455);
        } else if (aVar.xGs == null) {
            Log.e("MicroMsg.GameMessageClickListener", "jumpId is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41455);
        } else {
            o.g gVar = aVar.xGS.xFj.get(aVar.xGs);
            if (gVar == null) {
                Log.e("MicroMsg.GameMessageClickListener", "jumpInfo is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(41455);
                return;
            }
            int a2 = a(this.mContext, aVar.xGS, gVar, aVar.xGS.field_appId, aVar.dYu);
            if (a2 != 0) {
                f.a(this.mContext, 13, aVar.dYu, aVar.position, a2, 0, aVar.xGS.field_appId, this.xGR, aVar.xGS.xFV, aVar.xGS.field_gameMsgId, aVar.xGS.xFW, f.a(null, null, aVar.xGS.xFX, null));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41455);
        }
    }

    public static int a(Context context, o oVar, o.g gVar, String str, int i2) {
        AppMethodBeat.i(41456);
        int i3 = 0;
        switch (gVar.mJumpType) {
            case 1:
                i3 = i(context, str, i2);
                break;
            case 2:
                i3 = aN(context, str);
                break;
            case 3:
                i3 = j(context, str, i2);
                break;
            case 4:
                i3 = a(context, oVar, i2);
                break;
            case 5:
                i3 = aO(context, gVar.rHJ);
                break;
            case 6:
            default:
                Log.i("MicroMsg.GameMessageClickListener", "unknown msg jump type = " + gVar.mJumpType);
                break;
            case 7:
                gj(context);
                break;
        }
        AppMethodBeat.o(41456);
        return i3;
    }

    private static int aN(Context context, String str) {
        AppMethodBeat.i(41457);
        if (h.s(context, str)) {
            e.at(context, str);
            AppMethodBeat.o(41457);
            return 3;
        }
        AppMethodBeat.o(41457);
        return 0;
    }

    private static int i(Context context, String str, int i2) {
        AppMethodBeat.i(41458);
        if (h.s(context, str)) {
            e.at(context, str);
            AppMethodBeat.o(41458);
            return 3;
        }
        int j2 = j(context, str, i2);
        AppMethodBeat.o(41458);
        return j2;
    }

    private static int j(Context context, String str, int i2) {
        AppMethodBeat.i(41459);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(41459);
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence("game_app_id", str);
        bundle.putInt("game_report_from_scene", i2);
        int b2 = c.b(context, str, null, bundle);
        AppMethodBeat.o(41459);
        return b2;
    }

    private static int a(Context context, o oVar, int i2) {
        AppMethodBeat.i(41460);
        if (oVar != null) {
            oVar.field_isRead = true;
            ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().update(oVar, new String[0]);
        }
        Intent intent = new Intent();
        if (((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_game_open_message_center_v2, 0) == 1) {
            intent.setClassName(context, "com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI");
        } else {
            intent.setClassName(context, "com.tencent.mm.plugin.game.ui.GameMessageUI");
        }
        intent.putExtra("game_report_from_scene", i2);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/game/model/GameMessageClickListener", "dealMsgJumpMsgCenter", "(Landroid/content/Context;Lcom/tencent/mm/plugin/game/model/GameMessage;I)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "dealMsgJumpMsgCenter", "(Landroid/content/Context;Lcom/tencent/mm/plugin/game/model/GameMessage;I)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(41460);
        return 6;
    }

    private static int aO(Context context, String str) {
        AppMethodBeat.i(41461);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(41461);
            return 0;
        }
        int aQ = c.aQ(context, str);
        AppMethodBeat.o(41461);
        return aQ;
    }

    private static int gj(Context context) {
        AppMethodBeat.i(204163);
        Intent intent = new Intent();
        intent.putExtra("key_can_select_video_and_pic", true);
        intent.putExtra("key_send_raw_image", false);
        intent.putExtra("max_select_count", 9);
        intent.putExtra("query_source_type", 15);
        intent.putExtra("query_media_type", 2);
        intent.putExtra("show_header_view", false);
        intent.addFlags(67108864);
        intent.putExtra("game_haowan_ignore_video_preview", true);
        intent.putExtra("game_haowan_force_select", true);
        intent.putExtra("game_straight_to_publish", true);
        intent.putExtra("game_media_default_type", 1);
        com.tencent.mm.br.c.b(context, "game", ".media.GamePublishGalleryUI", intent);
        AppMethodBeat.o(204163);
        return 6;
    }
}
