package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.aa;

public class EmojiStoreV2HotBarView extends LinearLayout {
    private View jBN;
    private TextView rkD;
    private View rkE;
    private TextView rkF;
    private View rkG;
    private TextView rkH;
    private View.OnClickListener rkI = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2HotBarView.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(109191);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2RankUI.class);
            Context context = EmojiStoreV2HotBarView.this.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            a.a(context, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            a.a(context, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109191);
        }
    };

    public EmojiStoreV2HotBarView(Context context) {
        super(context);
        AppMethodBeat.i(109193);
        init();
        AppMethodBeat.o(109193);
    }

    public EmojiStoreV2HotBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(109194);
        init();
        AppMethodBeat.o(109194);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(109195);
        super.onAttachedToWindow();
        Log.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
        AppMethodBeat.o(109195);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(109196);
        super.onDetachedFromWindow();
        Log.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
        AppMethodBeat.o(109196);
    }

    @TargetApi(11)
    public EmojiStoreV2HotBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(109197);
        init();
        AppMethodBeat.o(109197);
    }

    private void init() {
        AppMethodBeat.i(109198);
        this.jBN = ((ViewGroup) aa.jQ(getContext()).inflate(R.layout.a31, this)).findViewById(R.id.h8v);
        this.rkD = (TextView) this.jBN.findViewById(R.id.c04);
        this.rkE = this.jBN.findViewById(R.id.bzs);
        this.rkF = (TextView) this.jBN.findViewById(R.id.c0i);
        this.rkF.setText(((Object) getResources().getText(R.string.buq)) + " ");
        this.rkG = this.jBN.findViewById(R.id.bnm);
        this.rkG.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2HotBarView.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(109192);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2SingleProductUI.class);
                Context context = EmojiStoreV2HotBarView.this.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(context, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                a.a(context, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109192);
            }
        });
        this.rkH = (TextView) this.jBN.findViewById(R.id.fxj);
        cIc();
        setMoreOnClickListener(this.rkI);
        updateTitle();
        AppMethodBeat.o(109198);
    }

    public final void cIc() {
        AppMethodBeat.i(109199);
        boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_EMOJI_STORE_NEW_DESIGNER_EMOJI_BOOLEAN, Boolean.FALSE)).booleanValue();
        if (this.rkH != null) {
            this.rkH.setVisibility(booleanValue ? 0 : 8);
        }
        AppMethodBeat.o(109199);
    }

    public final void updateTitle() {
        AppMethodBeat.i(109200);
        if (e.cFX().rbm) {
            this.rkD.setText(R.string.bsj);
            AppMethodBeat.o(109200);
            return;
        }
        this.rkD.setText(R.string.bsi);
        AppMethodBeat.o(109200);
    }

    public void setMoreOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(109201);
        if (this.rkF != null) {
            this.rkF.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(109201);
    }

    public View getRootView() {
        return this.jBN;
    }

    public void setDesignerEmojiViewVisibility(int i2) {
        AppMethodBeat.i(109202);
        if (this.rkG != null) {
            this.rkG.setVisibility(i2);
        }
        AppMethodBeat.o(109202);
    }

    public void setDesignerCatalogViewPadding(boolean z) {
        AppMethodBeat.i(109203);
        if (this.rkE != null && !z) {
            int aG = com.tencent.mm.cb.a.aG(getContext(), R.dimen.i1);
            int aG2 = com.tencent.mm.cb.a.aG(getContext(), R.dimen.ib);
            int aG3 = com.tencent.mm.cb.a.aG(getContext(), R.dimen.ir);
            this.rkE.setPadding(aG3, aG, aG3, aG2);
        }
        AppMethodBeat.o(109203);
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(109204);
        if (this.jBN != null) {
            this.jBN.setVisibility(i2);
            AppMethodBeat.o(109204);
            return;
        }
        super.setVisibility(i2);
        AppMethodBeat.o(109204);
    }
}
