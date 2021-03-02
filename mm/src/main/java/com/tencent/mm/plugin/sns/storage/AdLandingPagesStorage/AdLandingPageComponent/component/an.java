package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public final class an extends m {
    private static final int Ehc = Color.parseColor("#26eae9e2");
    private RadarChart Ehd;
    private Bitmap Ehe;
    private Bitmap Ehf;
    private CountDownLatch rDn = new CountDownLatch(2);

    static {
        AppMethodBeat.i(96818);
        AppMethodBeat.o(96818);
    }

    public an(Context context, ao aoVar, ViewGroup viewGroup) {
        super(context, aoVar, viewGroup);
        AppMethodBeat.i(96811);
        AppMethodBeat.o(96811);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(96812);
        this.Ehd = (RadarChart) this.contentView.findViewById(R.id.ar6);
        AppMethodBeat.o(96812);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWX() {
        AppMethodBeat.i(96813);
        ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins((int) this.EcX.paddingLeft, (int) this.EcX.paddingTop, (int) this.EcX.paddingRight, (int) this.EcX.paddingBottom);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.o(96813);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96814);
        h.RTc.aX(new com.tencent.f.i.h() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an.AnonymousClass1 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "AdlandingRadarComp";
            }

            public final void run() {
                AppMethodBeat.i(96806);
                try {
                    an.this.rDn.await();
                } catch (InterruptedException e2) {
                }
                if (!(an.this.Ehe == null || an.this.Ehf == null)) {
                    an.this.contentView.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(96805);
                            an.a(an.this, an.this.Ehe, an.this.Ehf);
                            AppMethodBeat.o(96805);
                        }
                    });
                }
                AppMethodBeat.o(96806);
            }
        });
        ao aoVar = (ao) fdr();
        if (aoVar != null) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(aoVar.Eah, aoVar.DZj, new f.a() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWN() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWO() {
                    AppMethodBeat.i(96807);
                    an.this.Ehe = null;
                    an.this.rDn.countDown();
                    AppMethodBeat.o(96807);
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void aNH(String str) {
                    AppMethodBeat.i(96808);
                    try {
                        an.this.Ehe = BitmapUtil.decodeFile(str);
                        an.this.rDn.countDown();
                        AppMethodBeat.o(96808);
                    } catch (Exception e2) {
                        Log.e("AdlandingRadarChartComp", "%s" + Util.stackTraceToString(e2));
                        AppMethodBeat.o(96808);
                    }
                }
            });
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(aoVar.Ean, aoVar.DZj, new f.a() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWN() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWO() {
                    AppMethodBeat.i(96809);
                    an.this.Ehf = null;
                    an.this.rDn.countDown();
                    AppMethodBeat.o(96809);
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void aNH(String str) {
                    AppMethodBeat.i(96810);
                    try {
                        an.this.Ehf = BitmapUtil.decodeFile(str);
                        an.this.rDn.countDown();
                        AppMethodBeat.o(96810);
                    } catch (Exception e2) {
                        Log.e("AdlandingRadarChartComp", "%s" + Util.stackTraceToString(e2));
                        AppMethodBeat.o(96810);
                    }
                }
            });
            eWX();
            AppMethodBeat.o(96814);
            return;
        }
        android.util.Log.wtf("AdlandingRadarChartComp", "null info");
        AppMethodBeat.o(96814);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.bu7;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(96815);
        super.eXd();
        this.rDn.countDown();
        this.rDn.countDown();
        AppMethodBeat.o(96815);
    }

    private static void a(Spannable spannable, int i2, int i3, Object... objArr) {
        AppMethodBeat.i(96816);
        for (int i4 = 0; i4 < 2; i4++) {
            spannable.setSpan(objArr[i4], i2, i3, 18);
        }
        AppMethodBeat.o(96816);
    }

    static /* synthetic */ void a(an anVar, Bitmap bitmap, Bitmap bitmap2) {
        AppMethodBeat.i(96817);
        ao aoVar = (ao) anVar.fdr();
        RadarChart radarChart = anVar.Ehd;
        radarChart.Ebe = 0;
        radarChart.Ebg = null;
        radarChart.EaX = null;
        radarChart.EaV = null;
        anVar.Ehd.setLatitudeNum(5);
        c cVar = new c();
        cVar.EaA = 0;
        int parseColor = Color.parseColor(aoVar.Eai);
        cVar.backgroundColor = 1442840575 & parseColor;
        cVar.EaF = Ehc;
        cVar.EaJ = 1.0f;
        cVar.EaU = bitmap2;
        cVar.EaG = Ehc;
        cVar.EaH = Ehc;
        cVar.EaI = (float) a.fromDPToPix(anVar.context, 1);
        cVar.EaK = -1;
        cVar.EaM = 30.0f;
        cVar.EaL = 40.0f;
        cVar.EaQ = bitmap;
        cVar.EaR = aoVar.borderWidth;
        cVar.EaS = Color.parseColor("#7feae9e2");
        cVar.EaT = a.fromDPToPix(anVar.context, 1);
        anVar.Ehd.setGridStyle(cVar);
        b bVar = new b();
        bVar.Eau = Ehc;
        bVar.Eav = 1.0f;
        bVar.Eaw = parseColor & Integer.MAX_VALUE;
        bVar.Eax = TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
        bVar.Eay = Color.parseColor("#00fcff");
        bVar.Eaz = a.fromDPToPix(anVar.context, 2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aoVar.Eaj);
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(aoVar.Eal);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(aoVar.Eak);
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(aoVar.Eam);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a(bVar);
        StringBuilder sb = new StringBuilder();
        for (ao.a aVar2 : aoVar.jzm) {
            if (aVar2 != null) {
                sb.delete(0, sb.length());
                sb.append(aVar2.label).append(":").append(aVar2.Eao);
                SpannableString spannableString = new SpannableString(sb.toString());
                a(spannableString, 0, aVar2.label.length() + 1, foregroundColorSpan, absoluteSizeSpan);
                a(spannableString, aVar2.label.length() + 1, sb.length(), foregroundColorSpan2, absoluteSizeSpan2);
                aVar.put(spannableString, Float.valueOf(aVar2.value));
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        try {
            anVar.Ehd.setData((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a[]) arrayList.toArray(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a[arrayList.size()]));
        } catch (Exception e2) {
            android.util.Log.getStackTraceString(e2);
        }
        anVar.Ehd.Ebd = 2;
        AppMethodBeat.o(96817);
    }
}
