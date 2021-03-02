package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class PoiHeaderView extends RelativeLayout {
    private Context context;
    public TextView gyt;
    public String yHX = "";
    public String yHY = "";
    public SimpleImageView yHZ;

    public PoiHeaderView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(55854);
        this.context = context2;
        View inflate = View.inflate(this.context, R.layout.bic, this);
        this.gyt = (TextView) inflate.findViewById(R.id.dou);
        this.yHZ = (SimpleImageView) inflate.findViewById(R.id.doh);
        this.gyt.setVisibility(8);
        this.yHZ.setVisibility(8);
        setVisibility(8);
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.PoiHeaderView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(55853);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/location/ui/PoiHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                String str = Util.isNullOrNil(PoiHeaderView.this.yHY) ? PoiHeaderView.this.yHX : PoiHeaderView.this.yHY;
                Log.d("MicroMsg.PoiHeaderView", "click url %s", str);
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                c.f(PoiHeaderView.this.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                a.a(this, "com/tencent/mm/plugin/location/ui/PoiHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(55853);
            }
        });
        AppMethodBeat.o(55854);
    }

    public void setViewUrl(String str) {
        AppMethodBeat.i(55855);
        Log.d("MicroMsg.PoiHeaderView", "viewUrl ".concat(String.valueOf(str)));
        this.yHY = str;
        AppMethodBeat.o(55855);
    }
}
