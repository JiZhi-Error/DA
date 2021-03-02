package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public final class i extends a {
    private ImageView EbJ;
    private LinearLayout EbK;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i EcB;
    private View EcC;
    private ImageView EcD;
    int clickCount;
    private TextView jCB;
    private LinearLayout tmh;

    public i(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i iVar, ViewGroup viewGroup) {
        super(context, iVar, viewGroup);
        this.EcB = iVar;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(96458);
        View view = this.contentView;
        this.EcD = (ImageView) view.findViewById(R.id.ea_);
        this.EbJ = (ImageView) view.findViewById(R.id.h6o);
        this.jCB = (TextView) view.findViewById(R.id.bmr);
        this.EbK = (LinearLayout) view.findViewById(R.id.dyj);
        this.tmh = (LinearLayout) view.findViewById(R.id.be3);
        this.EcC = this.EbK;
        AppMethodBeat.o(96458);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96459);
        this.jCB.setText(this.EcB.DYc.yFx);
        if (this.EcB.DZm) {
            this.EcD.setImageDrawable(a.l(this.context, R.drawable.bst));
            this.EbJ.setImageDrawable(a.l(this.context, R.drawable.bt4));
            this.jCB.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.EbK.setBackgroundResource(R.drawable.bt);
        } else {
            this.EcD.setImageDrawable(a.l(this.context, R.drawable.bss));
            this.EbJ.setImageDrawable(a.l(this.context, R.drawable.bt3));
            this.jCB.setTextColor(-1);
            this.EbK.setBackgroundResource(R.drawable.bu);
        }
        this.EbK.setPadding((int) this.EcB.paddingLeft, 0, (int) this.EcB.paddingRight, 0);
        this.tmh.setPadding(0, (int) this.EcB.paddingTop, 0, (int) this.EcB.paddingBottom);
        a(this.EbK);
        AnonymousClass1 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(96457);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingLbsComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                i.this.clickCount++;
                Intent intent = new Intent();
                intent.putExtra("map_view_type", 1);
                intent.putExtra("kwebmap_slat", i.this.EcB.DYc.yFu);
                intent.putExtra("kwebmap_lng", i.this.EcB.DYc.yFv);
                intent.putExtra("kwebmap_scale", i.this.EcB.DYc.dRt);
                intent.putExtra("kPoiName", i.this.EcB.DYc.dWi);
                intent.putExtra("Kwebmap_locaion", i.this.EcB.DYc.yFx);
                Log.i("AdLandingBorderedComp", "locatint to slat " + i.this.EcB.DYc.yFu + ", slong " + i.this.EcB.DYc.yFv + ", " + i.this.EcB.DYc.dWi);
                c.b(i.this.context, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent, 2002);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingLbsComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(96457);
            }
        };
        if (this.EcC != null) {
            this.EcC.setOnClickListener(r0);
        }
        AppMethodBeat.o(96459);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.bui;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean bp(JSONObject jSONObject) {
        AppMethodBeat.i(96460);
        if (!super.bp(jSONObject)) {
            AppMethodBeat.o(96460);
            return false;
        }
        try {
            jSONObject.put("clickCount", this.clickCount);
            AppMethodBeat.o(96460);
            return true;
        } catch (JSONException e2) {
            Log.printErrStackTrace("AdLandingBorderedComp", e2, "", new Object[0]);
            AppMethodBeat.o(96460);
            return false;
        }
    }
}
