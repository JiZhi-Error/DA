package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.a;
import com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI;
import com.tencent.mm.sdk.platformtools.Log;

public class GameInfoViewForeign extends RelativeLayout {
    private int dOS = 0;
    private Context mContext;
    private int xGR = 0;
    private TextView xTf;
    private int xTg = 2;
    private View.OnClickListener xTh = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.game.ui.GameInfoViewForeign.AnonymousClass1 */

        public final void onClick(View view) {
            int i2;
            AppMethodBeat.i(42178);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                a.C1403a dUN = com.tencent.mm.plugin.game.model.a.dUN();
                if (dUN.cSx == 2) {
                    i2 = c.D(GameInfoViewForeign.this.mContext, dUN.url, "game_center_msgcenter");
                } else {
                    Intent intent = new Intent();
                    if (((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_game_open_message_center_v2, 0) == 1) {
                        intent.setClass(GameInfoViewForeign.this.mContext, GameMsgCenterUI.class);
                    } else {
                        intent.setClass(GameInfoViewForeign.this.mContext, GameMessageUI.class);
                    }
                    intent.putExtra("game_report_from_scene", 1001);
                    Context context = GameInfoViewForeign.this.mContext;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    i2 = 6;
                }
            } else {
                i2 = c.D(GameInfoViewForeign.this.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            f.a(GameInfoViewForeign.this.mContext, 10, 1001, GameInfoViewForeign.this.xTg, i2, 0, null, GameInfoViewForeign.this.xGR, 0, null, null, f.ap("resource", "5"));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42178);
        }
    };

    public GameInfoViewForeign(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42179);
        this.mContext = context;
        AppMethodBeat.o(42179);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42180);
        super.onFinishInflate();
        setOnClickListener(this.xTh);
        this.xTf = (TextView) findViewById(R.id.dht);
        dWq();
        Log.i("MicroMsg.GameInfoViewForeign", "initView finished");
        AppMethodBeat.o(42180);
    }

    public final void dWq() {
        AppMethodBeat.i(42181);
        this.dOS = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().dVz();
        if (this.dOS > 0 && this.dOS <= 99) {
            this.xTf.setVisibility(0);
            this.xTf.setText(new StringBuilder().append(this.dOS).toString());
            AppMethodBeat.o(42181);
        } else if (this.dOS > 99) {
            this.xTf.setVisibility(0);
            this.xTf.setText("99+");
            this.xTf.setTextSize(1, 9.0f);
            AppMethodBeat.o(42181);
        } else {
            this.xTf.setVisibility(4);
            AppMethodBeat.o(42181);
        }
    }

    public void setSourceScene(int i2) {
        this.xGR = i2;
    }
}
