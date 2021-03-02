package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.c;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.landingpage.component.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;

public final class a extends com.tencent.mm.plugin.sns.ad.timeline.a.a.a {
    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.a.a
    public final boolean a(View view, int i2, SnsInfo snsInfo, ADXml.AdCardActionBtnInfo adCardActionBtnInfo, d dVar) {
        AppMethodBeat.i(202094);
        if (adCardActionBtnInfo == null || snsInfo == null) {
            AppMethodBeat.o(202094);
            return false;
        }
        j.a((SnsAdClick) dVar.z("snsAdClick", null), 42);
        b bVar = new b(view.getContext(), snsInfo);
        if (bVar.oXS == null) {
            bVar.mContentView = LayoutInflater.from(bVar.mContext).inflate(R.layout.bvb, (ViewGroup) null);
            View findViewById = bVar.mContentView.findViewById(R.id.b3z);
            TextView textView = (TextView) bVar.mContentView.findViewById(R.id.idg);
            bVar.Dxx = (ImageView) bVar.mContentView.findViewById(R.id.jjz);
            bVar.Dxy = (TextView) bVar.mContentView.findViewById(R.id.jk0);
            bVar.Dxz = (TextView) bVar.mContentView.findViewById(R.id.idr);
            bVar.DxA = (TextView) bVar.mContentView.findViewById(R.id.idk);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.ad.timeline.a.a.a.a.b.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(202088);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/impl/AdCouponActionButtonClick$AdCouponHalfScreenPrompt$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        try {
                            if (b.this.oXS != null && b.this.oXS.isShowing()) {
                                b.this.oXS.bMo();
                            }
                        } catch (Throwable th) {
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/impl/AdCouponActionButtonClick$AdCouponHalfScreenPrompt$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(202088);
                    }
                });
            }
            if (textView != null) {
                textView.setText(R.string.h3h);
                textView.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.ad.timeline.a.a.a.a.b.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(202089);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/impl/AdCouponActionButtonClick$AdCouponHalfScreenPrompt$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        try {
                            b.this.sendRequest();
                        } catch (Throwable th) {
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/impl/AdCouponActionButtonClick$AdCouponHalfScreenPrompt$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(202089);
                    }
                });
            }
            bVar.oXS = new e(bVar.mContext, true, 0);
            bVar.oXS.V(bVar.mContentView, true);
            bVar.oXS.Dm(true);
        }
        if (adCardActionBtnInfo != null) {
            if (bVar.Dxy != null) {
                bVar.Dxy.setText(adCardActionBtnInfo.couponSenderName);
            }
            if (bVar.Dxz != null) {
                bVar.Dxz.setText(adCardActionBtnInfo.couponName);
            }
            if (bVar.DxA != null) {
                bVar.DxA.setText(adCardActionBtnInfo.couponDesc);
            }
            c.k(adCardActionBtnInfo.couponSenderPhoto, bVar.Dxx);
        }
        if (!bVar.oXS.isShowing()) {
            bVar.oXS.dGm();
        }
        AppMethodBeat.o(202094);
        return true;
    }

    /* renamed from: com.tencent.mm.plugin.sns.ad.timeline.a.a.a.a$a  reason: collision with other inner class name */
    public static class C1707a extends a.C1704a {
        public C1707a(SnsInfo snsInfo, int i2, String str) {
            super(i2, str);
            AppMethodBeat.i(202087);
            this.source = 1;
            if (snsInfo != null) {
                this.uxInfo = Util.nullAsNil(snsInfo.getUxinfo());
                this.dRS = r.v(snsInfo);
                if (snsInfo.getAdXml() != null) {
                    this.adExtInfo = Util.nullAsNil(snsInfo.getAdXml().adExtInfo);
                    ADXml.AdCardActionBtnInfo adCardActionBtnInfo = snsInfo.getAdXml().adCardActionBtnInfo;
                    if (adCardActionBtnInfo != null) {
                        this.appId = Util.nullAsNil(adCardActionBtnInfo.couponAppId);
                        this.gTp = Util.nullAsNil(adCardActionBtnInfo.couponStockId);
                    }
                }
            }
            AppMethodBeat.o(202087);
        }
    }

    public static class b implements i {
        private SnsInfo DqO;
        TextView DxA;
        q DxB = null;
        ImageView Dxx;
        TextView Dxy;
        TextView Dxz;
        View mContentView;
        Context mContext;
        e oXS;

        b(Context context, SnsInfo snsInfo) {
            this.mContext = context;
            this.DqO = snsInfo;
        }

        /* access modifiers changed from: package-private */
        public final void sendRequest() {
            ADXml.AdCardActionBtnInfo adCardActionBtnInfo;
            AppMethodBeat.i(202092);
            SnsInfo snsInfo = this.DqO;
            if (snsInfo == null || snsInfo.getAdXml() == null) {
                adCardActionBtnInfo = null;
            } else {
                adCardActionBtnInfo = snsInfo.getAdXml().adCardActionBtnInfo;
            }
            if (adCardActionBtnInfo != null) {
                com.tencent.mm.plugin.sns.ad.h.b bVar = new com.tencent.mm.plugin.sns.ad.h.b(adCardActionBtnInfo.couponAppId, adCardActionBtnInfo.couponStockId, snsInfo.getUxinfo(), "");
                g.azz().a(4743, this);
                g.azz().a(bVar, 0);
                if (this.DxB == null) {
                    this.DxB = h.a(this.mContext, this.mContext.getString(R.string.ek_), true, (DialogInterface.OnCancelListener) null);
                    AppMethodBeat.o(202092);
                    return;
                } else if (!this.DxB.isShowing()) {
                    this.DxB.show();
                }
            }
            AppMethodBeat.o(202092);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            final String str2;
            AppMethodBeat.i(202093);
            try {
                com.tencent.f.h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ad.timeline.a.a.a.a.b.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(202090);
                        try {
                            q qVar = b.this.DxB;
                            if (qVar != null && qVar.isShowing()) {
                                qVar.dismiss();
                            }
                            e eVar = b.this.oXS;
                            if (eVar != null && eVar.isShowing()) {
                                eVar.bMo();
                            }
                            AppMethodBeat.o(202090);
                        } catch (Throwable th) {
                            AppMethodBeat.o(202090);
                        }
                    }
                });
                g.azz().b(4743, this);
                final int i4 = -1;
                if (i2 == 0 && i3 == 0 && (qVar instanceof com.tencent.mm.plugin.sns.ad.h.b)) {
                    bvk bvk = (bvk) ((com.tencent.mm.plugin.sns.ad.h.b) qVar).eXx();
                    if (bvk != null) {
                        int i5 = bvk.ret;
                        str2 = Util.nullAsNil(bvk.msg);
                        i4 = i5;
                    }
                    str2 = "";
                } else {
                    Log.w("SnsAd.AdCoupon", "the coupon errType is " + i2 + ", errCode is " + i3);
                    str2 = "";
                }
                Log.d("SnsAd.AdCoupon", "the coupon result is ".concat(String.valueOf(i4)));
                com.tencent.f.h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ad.timeline.a.a.a.a.b.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(202091);
                        try {
                            if (i4 == 0) {
                                u.cG(b.this.mContext, TextUtils.isEmpty(str2) ? b.this.mContext.getString(R.string.h3j) : str2);
                                AppMethodBeat.o(202091);
                                return;
                            }
                            u.cH(b.this.mContext, TextUtils.isEmpty(str2) ? b.this.mContext.getString(R.string.h3i) : str2);
                            AppMethodBeat.o(202091);
                        } catch (Throwable th) {
                            AppMethodBeat.o(202091);
                        }
                    }
                });
                com.tencent.mm.plugin.sns.ad.i.i.a(new C1707a(this.DqO, i4, str2));
                AppMethodBeat.o(202093);
            } catch (Throwable th) {
                AppMethodBeat.o(202093);
            }
        }
    }
}
