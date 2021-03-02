package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;

public class SnsNotifyBanner extends RelativeLayout {
    private TextView EHf;
    private ImageView EHg;
    int EHh = 0;
    private a EHi;
    private View mContentView;
    private LayoutInflater mInflater;

    public interface a {
    }

    public SnsNotifyBanner(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(98933);
        init();
        AppMethodBeat.o(98933);
    }

    public SnsNotifyBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(98934);
        init();
        AppMethodBeat.o(98934);
    }

    private void init() {
        AppMethodBeat.i(98935);
        this.mInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.mContentView = this.mInflater.inflate(R.layout.bwo, (ViewGroup) this, true);
        this.EHf = (TextView) this.mContentView.findViewById(R.id.hwt);
        this.EHg = (ImageView) this.mContentView.findViewById(R.id.hws);
        this.EHg.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsNotifyBanner.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(98931);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsNotifyBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SnsNotifyBanner.this.setVisibility(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsNotifyBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98931);
            }
        });
        AppMethodBeat.o(98935);
    }

    public void setOnClickNotify(a aVar) {
        AppMethodBeat.i(98936);
        this.EHi = aVar;
        this.EHf.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsNotifyBanner.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(98932);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsNotifyBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (SnsNotifyBanner.this.EHi == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsNotifyBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(98932);
                    return;
                }
                if (SnsNotifyBanner.this.EHh > 0) {
                    SnsNotifyBanner.this.EHh = 0;
                    a unused = SnsNotifyBanner.this.EHi;
                } else {
                    a unused2 = SnsNotifyBanner.this.EHi;
                }
                SnsNotifyBanner.this.setVisibility(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsNotifyBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98932);
            }
        });
        AppMethodBeat.o(98936);
    }
}
