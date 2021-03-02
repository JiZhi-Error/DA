package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ad extends m {
    private RelativeLayout EfF;
    ImageView EfG;
    TextView vr;

    public ad(Context context, ae aeVar, ViewGroup viewGroup) {
        super(context, aeVar, viewGroup);
        this.EcX = aeVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.bul;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(96678);
        super.eXd();
        AppMethodBeat.o(96678);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96679);
        this.vr.setText(((ae) this.EcX).label);
        this.vr.setTextSize(0, ((ae) this.EcX).fontSize);
        if (((ae) this.EcX).lco != null && ((ae) this.EcX).lco.length() > 0) {
            this.EfF.setBackgroundColor(Color.parseColor(((ae) this.EcX).lco));
        }
        h.a(((ae) this.EcX).DZI, ((ae) this.EcX).DZj, new f.a() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void eWN() {
            }

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void eWO() {
            }

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void aNH(String str) {
                AppMethodBeat.i(96677);
                try {
                    ad.this.EfG.setImageBitmap(BitmapUtil.decodeFile(str));
                    TextView textView = ad.this.vr;
                    Paint paint = new Paint();
                    String charSequence = textView.getText().toString();
                    paint.setTextSize(textView.getTextSize());
                    float measureText = (ad.this.EcX.DZk - paint.measureText(charSequence, 0, charSequence.length())) - TypedValue.applyDimension(1, 3.0f, ad.this.context.getResources().getDisplayMetrics());
                    int i2 = (int) (measureText - (ad.a(ad.this).value * measureText));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ad.this.EfG.getLayoutParams();
                    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, i2, layoutParams.leftMargin);
                    ad.this.EfG.setLayoutParams(layoutParams);
                    AppMethodBeat.o(96677);
                } catch (Exception e2) {
                    Log.e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + Util.stackTraceToString(e2));
                    AppMethodBeat.o(96677);
                }
            }
        });
        AppMethodBeat.o(96679);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(96680);
        View view = this.contentView;
        view.setBackgroundColor(this.backgroundColor);
        this.vr = (TextView) view.findViewById(R.id.hvi);
        this.EfF = (RelativeLayout) view.findViewById(R.id.hvg);
        this.EfG = (ImageView) view.findViewById(R.id.hvh);
        AppMethodBeat.o(96680);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(96681);
        super.eWZ();
        AppMethodBeat.o(96681);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXa() {
        AppMethodBeat.i(96682);
        super.eXa();
        AppMethodBeat.o(96682);
    }

    static /* synthetic */ ae a(ad adVar) {
        return (ae) adVar.EcX;
    }
}
