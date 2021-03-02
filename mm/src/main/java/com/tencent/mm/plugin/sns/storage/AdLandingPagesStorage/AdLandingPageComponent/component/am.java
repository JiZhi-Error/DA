package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ce.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class am extends m {
    private b EgU;
    volatile boolean EgV = false;
    TextView vr;

    public am(Context context, ag agVar, ViewGroup viewGroup) {
        super(context, agVar, viewGroup);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.buq;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(96799);
        super.eXd();
        if (this.EgU != null) {
            this.EgU.cancel();
        }
        this.EgV = true;
        AppMethodBeat.o(96799);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWX() {
        AppMethodBeat.i(96800);
        ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins((int) this.EcX.paddingLeft, (int) this.EcX.paddingTop, (int) this.EcX.paddingRight, (int) this.EcX.paddingBottom);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.o(96800);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    @TargetApi(17)
    public final void eXe() {
        AppMethodBeat.i(96802);
        View view = this.contentView;
        view.setBackgroundColor(this.backgroundColor);
        view.findViewById(R.id.hvj).setBackgroundColor(this.backgroundColor);
        view.findViewById(R.id.hvk).setBackgroundColor(this.backgroundColor);
        this.vr = (TextView) view.findViewById(R.id.hvk);
        AppMethodBeat.o(96802);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(96803);
        super.eWZ();
        AppMethodBeat.o(96803);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXa() {
        AppMethodBeat.i(96804);
        super.eXa();
        AppMethodBeat.o(96804);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96801);
        if (((ag) this.EcX).textSize > 0.0f) {
            this.vr.setTextSize(0, ((ag) this.EcX).textSize);
        }
        if (((ag) this.EcX).subType == 1) {
            if (!Util.isNullOrNil(((ag) this.EcX).DZP)) {
                final String replace = ((ag) this.EcX).DZP.trim().replace("<icon", "<img");
                if (this.EgU != null) {
                    this.EgU.cancel();
                }
                this.EgU = new b() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.AnonymousClass1 */

                    @Override // com.tencent.f.i.h, com.tencent.f.i.g
                    public final String getKey() {
                        return "MicroMsg.Sns.AdLandingPageTextComponent";
                    }

                    public final void run() {
                        AppMethodBeat.i(96798);
                        if (am.this.EgV) {
                            AppMethodBeat.o(96798);
                            return;
                        }
                        final Spanned fromHtml = Html.fromHtml(replace, new Html.ImageGetter() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.AnonymousClass1.AnonymousClass1 */

                            public final Drawable getDrawable(String str) {
                                int intrinsicWidth;
                                int intrinsicHeight;
                                AppMethodBeat.i(96796);
                                Drawable drawable = null;
                                String kz = h.kz("adId", str);
                                if (Util.isNullOrNil(kz) || !s.YS(kz)) {
                                    h.a("adId", str, false, 0, new f.a() {
                                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                                        public final void eWN() {
                                        }

                                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                                        public final void eWO() {
                                        }

                                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                                        public final void aNH(String str) {
                                            AppMethodBeat.i(96795);
                                            try {
                                                final Spanned fromHtml = Html.fromHtml(replace, new Html.ImageGetter() {
                                                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                    public final Drawable getDrawable(String str) {
                                                        AppMethodBeat.i(96793);
                                                        Drawable drawable = null;
                                                        String kz = h.kz("adId", str);
                                                        if (!Util.isNullOrNil(kz) && s.YS(kz)) {
                                                            Drawable a2 = com.tencent.mm.plugin.sns.ad.i.b.a(am.this.vr.getResources(), kz);
                                                            if (a2 != null) {
                                                                a2.setBounds(0, 0, a2.getIntrinsicHeight() != 0 ? (a2.getIntrinsicWidth() * ((int) am.a(am.this).textSize)) / a2.getIntrinsicHeight() : a2.getIntrinsicWidth(), a2.getIntrinsicHeight() != 0 ? (int) am.a(am.this).textSize : a2.getIntrinsicHeight());
                                                            }
                                                            drawable = a2;
                                                        }
                                                        AppMethodBeat.o(96793);
                                                        return drawable;
                                                    }
                                                }, null);
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                                                    public final void run() {
                                                        AppMethodBeat.i(96794);
                                                        am.this.vr.setText(fromHtml);
                                                        AppMethodBeat.o(96794);
                                                    }
                                                });
                                                AppMethodBeat.o(96795);
                                            } catch (Exception e2) {
                                                Log.e("MicroMsg.Sns.AdLandingPageTextComponent", "the backgroundCoverUrl is set error ,because " + e2.toString());
                                                AppMethodBeat.o(96795);
                                            }
                                        }
                                    });
                                } else {
                                    Drawable a2 = com.tencent.mm.plugin.sns.ad.i.b.a(am.this.vr.getResources(), kz);
                                    if (a2 != null) {
                                        if (a2.getIntrinsicHeight() != 0) {
                                            intrinsicWidth = (a2.getIntrinsicWidth() * ((int) am.a(am.this).textSize)) / a2.getIntrinsicHeight();
                                        } else {
                                            intrinsicWidth = a2.getIntrinsicWidth();
                                        }
                                        if (a2.getIntrinsicHeight() != 0) {
                                            intrinsicHeight = (int) am.a(am.this).textSize;
                                        } else {
                                            intrinsicHeight = a2.getIntrinsicHeight();
                                        }
                                        a2.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                                        drawable = a2;
                                    } else {
                                        drawable = a2;
                                    }
                                }
                                AppMethodBeat.o(96796);
                                return drawable;
                            }
                        }, null);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.AnonymousClass1.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(96797);
                                am.this.vr.setText(g.gxZ().a(am.this.context, fromHtml, am.this.vr.getTextSize()));
                                AppMethodBeat.o(96797);
                            }
                        });
                        AppMethodBeat.o(96798);
                    }
                };
                com.tencent.f.h.RTc.aX(this.EgU);
            }
        } else if (!Util.isNullOrNil(((ag) this.EcX).DZP)) {
            this.vr.setText(g.gxZ().a(this.context, ((ag) this.EcX).DZP.trim(), this.vr.getTextSize()));
        }
        if (((ag) this.EcX).textAlignment == 0) {
            this.vr.setGravity(3);
        } else if (((ag) this.EcX).textAlignment == 1) {
            this.vr.setGravity(17);
        } else if (((ag) this.EcX).textAlignment == 2) {
            this.vr.setGravity(5);
        }
        if (((ag) this.EcX).zyf == null || ((ag) this.EcX).zyf.length() <= 0) {
            this.vr.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            try {
                this.vr.setTextColor(Color.parseColor(((ag) this.EcX).zyf));
            } catch (Exception e2) {
                Log.e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((ag) this.EcX).zyf);
            }
        }
        if (((ag) this.EcX).DZT > 0.0f) {
            this.vr.setLineSpacing(0.0f, ((ag) this.EcX).DZT + 1.0f);
        }
        TextPaint paint = this.vr.getPaint();
        if (((ag) this.EcX).DZQ) {
            paint.setFakeBoldText(true);
        }
        if (((ag) this.EcX).DZR) {
            paint.setTextSkewX(-0.25f);
        }
        if (((ag) this.EcX).DZS) {
            paint.setUnderlineText(true);
        }
        if (((ag) this.EcX).maxLines > 0) {
            this.vr.setMaxLines(((ag) this.EcX).maxLines);
        }
        if (((ag) this.EcX).DYv == ag.DZO) {
            this.vr.setTypeface(ap.hc(this.context));
        }
        AppMethodBeat.o(96801);
    }

    static /* synthetic */ ag a(am amVar) {
        return (ag) amVar.EcX;
    }
}
