package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

public class BannerActView extends LinearLayout {
    private List<a> zjK;
    private y zjL;
    private TextView zjM = ((TextView) LayoutInflater.from(getContext()).inflate(R.layout.ir, (ViewGroup) this, true).findViewById(R.id.f6w));

    public BannerActView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(66024);
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.mall.ui.BannerActView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(66023);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/BannerActView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BannerActView.this.setVisibility(8);
                com.tencent.mm.plugin.wallet_core.model.mall.b.ia(BannerActView.this.zjK);
                if (BannerActView.this.zjK != null && BannerActView.this.zjK.size() > 0) {
                    f.bn(BannerActView.this.getContext(), ((a) BannerActView.this.zjK.get(0)).Icc);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/BannerActView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(66023);
            }
        });
        AppMethodBeat.o(66024);
    }

    public void setData(y yVar) {
        AppMethodBeat.i(66025);
        this.zjL = yVar;
        if (this.zjL != null) {
            this.zjM.setText(this.zjL.field_bulletin_content);
            setVisibility(0);
            AppMethodBeat.o(66025);
            return;
        }
        setVisibility(8);
        AppMethodBeat.o(66025);
    }

    public void setActivityList(List<a> list) {
        AppMethodBeat.i(66026);
        this.zjK = list;
        if (this.zjK == null || this.zjK.size() <= 0) {
            Log.i("MicroMsg.BannerActivityView", "func[setActivityList] actList null");
        } else if (com.tencent.mm.plugin.wallet_core.model.mall.b.hZ(this.zjK)) {
            this.zjM.setText(this.zjK.get(0).Icb);
            setVisibility(0);
            AppMethodBeat.o(66026);
            return;
        }
        setVisibility(8);
        AppMethodBeat.o(66026);
    }
}
