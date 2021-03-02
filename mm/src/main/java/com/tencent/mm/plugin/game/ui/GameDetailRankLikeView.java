package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.protobuf.eh;
import com.tencent.mm.plugin.game.protobuf.ei;
import com.tencent.mm.sdk.platformtools.Log;

public class GameDetailRankLikeView extends LinearLayout implements View.OnClickListener {
    String mAppId;
    private int xGR;
    aa xQk;
    aa.a xQl;
    private Drawable xQm;
    private Drawable xQn;
    private Animation xQo;
    private ImageView xQp;
    private TextView xQq;

    public GameDetailRankLikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(41987);
        super.onFinishInflate();
        this.xQm = getContext().getResources().getDrawable(R.drawable.bfk);
        this.xQn = getContext().getResources().getDrawable(R.drawable.bfj);
        this.xQo = AnimationUtils.loadAnimation(getContext(), R.anim.e6);
        inflate(getContext(), R.layout.apv, this);
        setOnClickListener(this);
        this.xQp = (ImageView) findViewById(R.id.eb6);
        this.xQq = (TextView) findViewById(R.id.eb_);
        AppMethodBeat.o(41987);
    }

    /* access modifiers changed from: package-private */
    public final void rb() {
        AppMethodBeat.i(41988);
        if (this.xQl != null) {
            pW(this.xQl.xHd);
            setCount(this.xQl.xHc);
            AppMethodBeat.o(41988);
            return;
        }
        setVisibility(8);
        AppMethodBeat.o(41988);
    }

    private void pW(boolean z) {
        AppMethodBeat.i(41989);
        if (z) {
            this.xQp.setImageDrawable(this.xQm);
            AppMethodBeat.o(41989);
            return;
        }
        this.xQp.setImageDrawable(this.xQn);
        AppMethodBeat.o(41989);
    }

    private void setCount(int i2) {
        AppMethodBeat.i(41990);
        if (i2 > 99) {
            this.xQq.setText("99+");
            AppMethodBeat.o(41990);
        } else if (i2 == 0) {
            this.xQq.setText("");
            AppMethodBeat.o(41990);
        } else {
            this.xQq.setText(String.valueOf(i2));
            AppMethodBeat.o(41990);
        }
    }

    public void onClick(View view) {
        AppMethodBeat.i(41991);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (z.aTY().equals(this.xQl.dWq)) {
            if (this.xQl.xHc > 0) {
                Intent intent = new Intent(getContext(), GameDetailRankLikedUI.class);
                intent.putExtra("extra_appdi", this.mAppId);
                Context context = getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(context, bl.axQ(), "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                a.a(context, "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
        } else if (!this.xQl.xHd) {
            this.xQl.xHd = true;
            this.xQl.xHc++;
            this.xQk.dVM();
            String str = this.mAppId;
            String str2 = this.xQl.dWq;
            d.a aVar = new d.a();
            aVar.iLN = new eh();
            aVar.iLO = new ei();
            aVar.uri = "/cgi-bin/mmgame-bin/upfriend";
            aVar.funcId = 1330;
            d aXF = aVar.aXF();
            eh ehVar = (eh) aXF.iLK.iLR;
            ehVar.hik = str;
            ehVar.xNG = str2;
            com.tencent.mm.ak.aa.a(aXF, new aa.a() {
                /* class com.tencent.mm.plugin.game.ui.GameDetailRankLikeView.AnonymousClass1 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, d dVar, q qVar) {
                    AppMethodBeat.i(41986);
                    if (i2 == 0 && i3 == 0) {
                        AppMethodBeat.o(41986);
                    } else {
                        Log.e("MicroMsg.GameDetailRankLikeView", "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        AppMethodBeat.o(41986);
                    }
                    return 0;
                }
            });
            f.a(getContext(), 12, TXLiteAVCode.WARNING_MICROPHONE_NOT_AUTHORIZED, 1, 2, this.mAppId, this.xGR, null);
            rb();
            this.xQp.startAnimation(this.xQo);
        }
        a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(41991);
    }

    public void setSourceScene(int i2) {
        this.xGR = i2;
    }
}
