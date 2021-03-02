package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.aa;

public class SnsFinderGuideView extends RelativeLayout {
    private a EDv = null;
    private Button hPX = null;

    /* access modifiers changed from: package-private */
    public interface a {
    }

    public SnsFinderGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(203572);
        init();
        AppMethodBeat.o(203572);
    }

    public SnsFinderGuideView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(203573);
        init();
        AppMethodBeat.o(203573);
    }

    private void init() {
        AppMethodBeat.i(203574);
        aa.jQ(getContext()).inflate(R.layout.bvr, this);
        this.hPX = (Button) findViewById(R.id.hxw);
        this.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsFinderGuideView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(203571);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsFinderGuideView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (SnsFinderGuideView.this.EDv != null) {
                    a unused = SnsFinderGuideView.this.EDv;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsFinderGuideView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203571);
            }
        });
        AppMethodBeat.o(203574);
    }

    public void setOnFinishDialogViewCallback(a aVar) {
        this.EDv = aVar;
    }
}
