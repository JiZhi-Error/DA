package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class GameMessageBubbleView extends LinearLayout implements View.OnClickListener {
    private Context mContext;
    private boolean mHasInit = false;
    View xUR;
    private TextView xUS;
    private ImageView xUT;
    private o xUU;
    private final long xUV = 500;
    private long xUW = 0;

    public GameMessageBubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42278);
        super.onFinishInflate();
        if (!this.mHasInit) {
            this.xUT = (ImageView) findViewById(R.id.dhm);
            this.xUS = (TextView) findViewById(R.id.dhl);
            this.xUR = findViewById(R.id.dhn);
            setVisibility(8);
            this.mHasInit = true;
        }
        AppMethodBeat.o(42278);
    }

    public final void dWx() {
        AppMethodBeat.i(42279);
        ((e) g.af(e.class)).dSJ();
        this.xUU = r.dVs();
        if (this.xUU == null) {
            this.xUR.setOnClickListener(null);
            setVisibility(8);
            AppMethodBeat.o(42279);
            return;
        }
        this.xUU.dVl();
        if (this.xUU.field_msgType != 100 || (!Util.isNullOrNil(this.xUU.xFi.mDesc) && !Util.isNullOrNil(this.xUU.xFi.xGg) && !Util.isNullOrNil(this.xUU.xFi.xGh) && this.xUU.xFj.containsKey(this.xUU.xFi.xGh))) {
            this.xUS.setText(this.xUU.xFi.mDesc);
            q.bcV().loadImage(this.xUU.xFi.xGg, this.xUT);
            this.xUR.setOnClickListener(this);
            setVisibility(0);
            AppMethodBeat.o(42279);
            return;
        }
        Log.w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
        this.xUR.setOnClickListener(null);
        setVisibility(8);
        AppMethodBeat.o(42279);
    }

    public void onClick(View view) {
        o.g gVar;
        AppMethodBeat.i(42280);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (System.currentTimeMillis() - this.xUW <= 500) {
            a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42280);
        } else if (this.xUU == null) {
            a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42280);
        } else {
            ((e) g.af(e.class)).dSJ();
            r.dVt();
            if (this.xUU.field_msgType == 100) {
                if (!Util.isNullOrNil(this.xUU.xFi.xGh) && (gVar = this.xUU.xFj.get(this.xUU.xFi.xGh)) != null) {
                    int a2 = p.a(this.mContext, this.xUU, gVar, this.xUU.field_appId, 1007);
                    if (a2 != 0) {
                        f.a(this.mContext, 10, 1007, 1, a2, 0, this.xUU.field_appId, 0, this.xUU.xFV, this.xUU.field_gameMsgId, this.xUU.xFW, f.a(null, null, this.xUU.xFX, null));
                    }
                    if (gVar.mJumpType != 4) {
                        this.xUU.field_isRead = true;
                        ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().update(this.xUU, new String[0]);
                    }
                }
                this.xUW = System.currentTimeMillis();
                a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(42280);
                return;
            }
            if (!(this.xUU == null || this.xUU.xFl == 3)) {
                this.xUU.field_isRead = true;
                ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().update(this.xUU, new String[0]);
            }
            int i2 = 0;
            switch (this.xUU.xFl) {
                case 1:
                    String str = this.xUU.xEX;
                    if (!Util.isNullOrNil(str)) {
                        i2 = c.D(this.mContext, str, "game_center_bubble");
                        break;
                    }
                    break;
                case 2:
                    if (Util.isNullOrNil(this.xUU.field_appId)) {
                        Log.e("MicroMsg.GameMessageHeaderView", "message type : " + this.xUU.field_msgType + " ,message.field_appId is null.");
                        break;
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", this.xUU.field_appId);
                        bundle.putInt("game_report_from_scene", 1007);
                        i2 = c.b(this.mContext, this.xUU.field_appId, null, bundle);
                        break;
                    }
                case 3:
                    Intent intent = new Intent();
                    if (((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_game_open_message_center_v2, 0) == 1) {
                        intent.setClass(this.mContext, GameMsgCenterUI.class);
                    } else {
                        intent.setClass(this.mContext, GameMessageUI.class);
                    }
                    intent.putExtra("game_report_from_scene", 1007);
                    Context context = this.mContext;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    a.a(context, bl.axQ(), "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    a.a(context, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    i2 = 6;
                    break;
                default:
                    Log.e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.xUU.xFl);
                    a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(42280);
                    return;
            }
            f.a(this.mContext, 10, 1007, 1, i2, 0, this.xUU.field_appId, 0, this.xUU.field_msgType, this.xUU.field_gameMsgId, this.xUU.xFW, f.a(null, null, this.xUU.xFX, null));
            this.xUW = System.currentTimeMillis();
            a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42280);
        }
    }
}
