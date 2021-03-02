package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class NoiseDetectMaskView extends RelativeLayout {
    TextView GRM;
    private b GRN;
    private a GRO;
    ProgressBar krF = null;
    private Context mContext = null;
    TextView xfB;

    public interface a {
        void fEN();
    }

    public interface b {
        void fEO();
    }

    public NoiseDetectMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(29824);
        this.mContext = context;
        this.mContext.getSystemService("layout_inflater");
        LayoutInflater.from(this.mContext).inflate(R.layout.bg6, this);
        this.krF = (ProgressBar) findViewById(R.id.g0a);
        this.xfB = (TextView) findViewById(R.id.g0_);
        this.GRM = (TextView) findViewById(R.id.g0b);
        this.GRM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(29822);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voiceprint/ui/NoiseDetectMaskView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (NoiseDetectMaskView.this.GRN != null) {
                    NoiseDetectMaskView.this.GRN.fEO();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/NoiseDetectMaskView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29822);
            }
        });
        findViewById(R.id.ea8).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(29823);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voiceprint/ui/NoiseDetectMaskView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (NoiseDetectMaskView.this.GRO != null) {
                    NoiseDetectMaskView.this.GRO.fEN();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/NoiseDetectMaskView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29823);
            }
        });
        AppMethodBeat.o(29824);
    }

    public void setOnClickRetryCallback(b bVar) {
        this.GRN = bVar;
    }

    public void setOnCancelDetectCallback(a aVar) {
        this.GRO = aVar;
    }

    public final void reset() {
        AppMethodBeat.i(29825);
        if (this.krF != null) {
            this.krF.setVisibility(0);
        }
        this.xfB.setText(R.string.hzm);
        this.GRM.setVisibility(8);
        AppMethodBeat.o(29825);
    }
}
