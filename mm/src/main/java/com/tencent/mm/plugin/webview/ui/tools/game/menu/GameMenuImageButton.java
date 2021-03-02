package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;

public class GameMenuImageButton extends LinearLayout {
    private ImageView dKU;
    public boolean pKn;

    public interface a {
        void dlk();
    }

    public GameMenuImageButton(Context context) {
        super(context);
        AppMethodBeat.i(80958);
        bh(context);
        AppMethodBeat.o(80958);
    }

    public GameMenuImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(80959);
        bh(context);
        AppMethodBeat.o(80959);
    }

    public GameMenuImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(80960);
        bh(context);
        AppMethodBeat.o(80960);
    }

    private void bh(Context context) {
        AppMethodBeat.i(80961);
        this.dKU = new ImageView(context);
        this.dKU.setLayoutParams(new ViewGroup.LayoutParams(com.tencent.mm.cb.a.aH(context, R.dimen.a8n), com.tencent.mm.cb.a.aH(context, R.dimen.a8n)));
        this.dKU.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.dKU.setImageResource(R.drawable.c_a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, com.tencent.mm.cb.a.aH(context, R.dimen.a8m), com.tencent.mm.cb.a.aH(context, R.dimen.a8m), 0);
        addView(this.dKU, layoutParams);
        AppMethodBeat.o(80961);
    }

    public final void a(FrameLayout frameLayout, final a aVar) {
        AppMethodBeat.i(80962);
        if (getParent() == null && frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            frameLayout.addView(this, layoutParams);
        }
        if (this.dKU != null) {
            this.dKU.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(80957);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/game/menu/GameMenuImageButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (aVar != null) {
                        aVar.dlk();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/game/menu/GameMenuImageButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(80957);
                }
            });
        }
        this.pKn = true;
        AppMethodBeat.o(80962);
    }
}
