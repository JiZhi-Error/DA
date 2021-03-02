package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.ui.GameDetailRankUI;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;

public class GameRankHeadView extends LinearLayout implements View.OnClickListener {
    private TextView hbb;
    private c xHm;
    k.a xQH;
    private l xQJ;
    private TextView xQh;
    private TextView xVA;
    private ImageView xVB;

    static /* synthetic */ void c(GameRankHeadView gameRankHeadView) {
        AppMethodBeat.i(42346);
        gameRankHeadView.dWo();
        AppMethodBeat.o(42346);
    }

    public GameRankHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42342);
        super.onFinishInflate();
        this.hbb = (TextView) findViewById(R.id.df1);
        this.xVA = (TextView) findViewById(R.id.dem);
        this.xQh = (TextView) findViewById(R.id.df0);
        this.xVB = (ImageView) findViewById(R.id.dhj);
        Log.i("MicroMsg.GameRankHeadView", "initView finished");
        AppMethodBeat.o(42342);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void dWo() {
        AppMethodBeat.i(42343);
        if (h.a(getContext(), this.xHm)) {
            if (this.xHm.versionCode > com.tencent.mm.plugin.game.e.c.aAH(this.xHm.field_packageName)) {
                this.xQh.setText(R.string.dod);
                AppMethodBeat.o(42343);
                return;
            }
            this.xQh.setText(R.string.dob);
            AppMethodBeat.o(42343);
            return;
        }
        switch (this.xHm.status) {
            case 0:
                if (this.xQJ == null) {
                    this.xQh.setVisibility(8);
                    this.xVB.setVisibility(8);
                    AppMethodBeat.o(42343);
                    return;
                }
                this.xQh.setVisibility(0);
                this.xVB.setVisibility(0);
                switch (this.xQJ.status) {
                    case 0:
                        this.xQh.setText(R.string.do9);
                        AppMethodBeat.o(42343);
                        return;
                    case 1:
                        this.xQh.setText(R.string.do_);
                        AppMethodBeat.o(42343);
                        return;
                    case 2:
                        this.xQh.setText(R.string.do8);
                        AppMethodBeat.o(42343);
                        return;
                    case 3:
                        this.xQh.setText(R.string.doa);
                        break;
                }
                AppMethodBeat.o(42343);
                return;
            default:
                this.xQh.setText(R.string.do9);
                AppMethodBeat.o(42343);
                return;
        }
    }

    public void setData(GameDetailRankUI.a aVar) {
        AppMethodBeat.i(42344);
        this.hbb.setText(aVar.xQA);
        this.xVA.setText(aVar.xQB);
        this.xHm = aVar.xQC;
        this.xHm.dYu = TXLiteAVCode.WARNING_MICROPHONE_NOT_AUTHORIZED;
        this.xHm.position = 2;
        if (this.xQJ == null) {
            this.xQJ = new l(this.xHm);
        }
        this.xQJ.gi(getContext());
        this.xQJ.cCq();
        dWo();
        if (this.xQH != null) {
            k.a(this.xQH);
        } else {
            this.xQH = new k.a() {
                /* class com.tencent.mm.plugin.game.ui.GameRankHeadView.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.game.model.k.a
                public final void e(int i2, String str, boolean z) {
                    AppMethodBeat.i(42341);
                    if (GameRankHeadView.this.xHm != null) {
                        GameRankHeadView.this.xQJ.gi(GameRankHeadView.this.getContext());
                        GameRankHeadView.this.xQJ.cCq();
                        if (z) {
                            GameRankHeadView.c(GameRankHeadView.this);
                        }
                    }
                    AppMethodBeat.o(42341);
                }
            };
            k.a(this.xQH);
        }
        this.xQh.setOnClickListener(this);
        AppMethodBeat.o(42344);
    }

    public void onClick(View view) {
        AppMethodBeat.i(42345);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/game/ui/GameRankHeadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        new d(getContext()).a(this.xHm, new l(this.xHm));
        a.a(this, "com/tencent/mm/plugin/game/ui/GameRankHeadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42345);
    }
}
