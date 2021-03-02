package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class ag extends m implements View.OnClickListener {
    private WeImageView EfX;
    private int EfY = 0;
    private TextView Ws;
    private Context mContext;

    public ag(Context context, af afVar, ViewGroup viewGroup) {
        super(context, afVar, viewGroup);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.bun;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWX() {
        AppMethodBeat.i(203018);
        ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins((int) this.EcX.paddingLeft, (int) this.EcX.paddingTop, (int) this.EcX.paddingRight, (int) this.EcX.paddingBottom);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.o(203018);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(203020);
        View view = this.contentView;
        this.Ws = (TextView) view.findViewById(R.id.izb);
        this.EfX = (WeImageView) view.findViewById(R.id.dt5);
        view.setOnClickListener(this);
        AppMethodBeat.o(203020);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(203021);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageShareComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        this.EfY++;
        if (this.mContext instanceof SnsAdNativeLandingPagesUI) {
            ((SnsAdNativeLandingPagesUI) this.mContext).fgY();
        }
        a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageShareComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203021);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean bp(JSONObject jSONObject) {
        AppMethodBeat.i(203022);
        if (!super.bp(jSONObject)) {
            AppMethodBeat.o(203022);
            return false;
        }
        try {
            jSONObject.put("clickCount", this.EfY);
            AppMethodBeat.o(203022);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.Sns.AdLandingPageShareComponent", "setComponentKVReportData exp=" + e2.toString());
            AppMethodBeat.o(203022);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(203019);
        af afVar = (af) this.EcX;
        this.Ws.setText(afVar.DZJ);
        if (!TextUtils.isEmpty(afVar.DYt)) {
            try {
                int parseColor = Color.parseColor(afVar.DYt);
                this.Ws.setTextColor(parseColor);
                this.EfX.setIconColor(parseColor);
                AppMethodBeat.o(203019);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.Sns.AdLandingPageShareComponent", "parseColor exp=" + e2.toString());
            }
        }
        AppMethodBeat.o(203019);
    }
}
