package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.pluginsdk.ui.span.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends a {
    private ImageView EbI;
    private ImageView EbJ;
    LinearLayout EbK;
    int clickCount;
    private TextView jCB;
    LinearLayout tmh;

    public c(Context context, d dVar, ViewGroup viewGroup) {
        super(context, dVar, viewGroup);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.bui;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96416);
        this.jCB.setText(((d) this.EcX).DXU.get(0));
        if (((d) this.EcX).DZm) {
            this.EbI.setImageDrawable(a.l(this.context, R.drawable.buz));
            this.EbJ.setImageDrawable(a.l(this.context, R.drawable.bt4));
            this.jCB.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.EbK.setBackgroundResource(R.drawable.bt);
        } else {
            this.EbI.setImageDrawable(a.l(this.context, R.drawable.buy));
            this.EbJ.setImageDrawable(a.l(this.context, R.drawable.bt3));
            this.jCB.setTextColor(-1);
            this.EbK.setBackgroundResource(R.drawable.bu);
        }
        this.EbK.setPadding((int) ((d) this.EcX).paddingLeft, 0, (int) ((d) this.EcX).paddingRight, 0);
        this.tmh.setPadding(0, (int) ((d) this.EcX).paddingTop, 0, (int) ((d) this.EcX).paddingBottom);
        a(this.EbK);
        this.EbK.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(96415);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingContactComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.this.clickCount++;
                if (e.a.KqE == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingContactComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(96415);
                    return;
                }
                if (c.a(c.this).DXU.size() > 1) {
                    e.a.KqE.a(c.this.context, c.a(c.this).DXU, new e.b() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.widget.a.e.b
                        public final void onDismiss() {
                            AppMethodBeat.i(96414);
                            ap.hb(c.this.context);
                            AppMethodBeat.o(96414);
                        }
                    });
                } else if (c.a(c.this).DXU.size() > 0) {
                    AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity) c.this.context, c.a(c.this).DXU.get(0));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingContactComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(96415);
            }
        });
        AppMethodBeat.o(96416);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean bp(JSONObject jSONObject) {
        AppMethodBeat.i(96418);
        if (!super.bp(jSONObject)) {
            AppMethodBeat.o(96418);
            return false;
        }
        try {
            jSONObject.put("clickCount", this.clickCount);
            AppMethodBeat.o(96418);
            return true;
        } catch (JSONException e2) {
            Log.printErrStackTrace("AdLandingBorderedComp", e2, "", new Object[0]);
            AppMethodBeat.o(96418);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(96417);
        if (((d) this.EcX).DXU.isEmpty()) {
            AppMethodBeat.o(96417);
            return;
        }
        View view = this.contentView;
        this.EbI = (ImageView) view.findViewById(R.id.ea_);
        this.EbJ = (ImageView) view.findViewById(R.id.h6o);
        this.jCB = (TextView) view.findViewById(R.id.bmr);
        this.tmh = (LinearLayout) view.findViewById(R.id.be3);
        this.EbK = (LinearLayout) view.findViewById(R.id.dyj);
        AppMethodBeat.o(96417);
    }

    static /* synthetic */ d a(c cVar) {
        return (d) cVar.EcX;
    }
}
