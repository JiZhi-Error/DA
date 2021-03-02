package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.app.Activity;
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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.c.b;
import com.tencent.mm.plugin.sns.ad.e.h;
import com.tencent.mm.plugin.sns.ad.i.i;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.ad.widget.b.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.e;

public final class b extends com.tencent.mm.plugin.sns.ad.timeline.a.a.a {
    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.a.a
    public final boolean a(View view, int i2, SnsInfo snsInfo, ADXml.AdCardActionBtnInfo adCardActionBtnInfo, d dVar) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        AppMethodBeat.i(202097);
        Log.d("SnsAd.AdFinderLiveNotice", "the AdFinderLiveSubscriptionClick button is clicked");
        if (view == null || view.getContext() == null || adCardActionBtnInfo == null) {
            AppMethodBeat.o(202097);
            return false;
        }
        j.a((SnsAdClick) dVar.z("snsAdClick", null), 43);
        c cVar = new c(view.getContext(), snsInfo, new a(view.getContext(), adCardActionBtnInfo));
        if (cVar.DBG == null) {
            Log.w("SnsAd.SemiDialogManager", "the adapter is null , can't show dialog!!!");
        } else {
            try {
                if (cVar.oXS == null) {
                    cVar.mContentView = LayoutInflater.from(cVar.mContext).inflate(R.layout.bvb, (ViewGroup) null);
                    if (cVar.DBG != null && !TextUtils.isEmpty(cVar.DBG.eXB())) {
                        com.tencent.mm.plugin.sns.a.c.k(cVar.DBG.eXB(), (ImageView) cVar.mContentView.findViewById(R.id.jjz));
                    }
                    if (!(cVar.DBG == null || TextUtils.isEmpty(cVar.DBG.eXC()) || (textView4 = (TextView) cVar.mContentView.findViewById(R.id.jk0)) == null)) {
                        textView4.setText(cVar.DBG.eXC());
                    }
                    if (!(cVar.DBG == null || TextUtils.isEmpty(cVar.DBG.eXD()) || (textView3 = (TextView) cVar.mContentView.findViewById(R.id.idr)) == null)) {
                        textView3.setText(cVar.DBG.eXD());
                    }
                    if (!(cVar.DBG == null || TextUtils.isEmpty(cVar.DBG.eXE()) || (textView2 = (TextView) cVar.mContentView.findViewById(R.id.idk)) == null)) {
                        textView2.setText(cVar.DBG.eXE());
                    }
                    if (!(cVar.DBG == null || TextUtils.isEmpty(cVar.DBG.eXF()) || (textView = (TextView) cVar.mContentView.findViewById(R.id.idg)) == null)) {
                        textView.setText(cVar.DBG.eXF());
                        textView.setOnClickListener(new View.OnClickListener(cVar.DBG.eXG()) {
                            /* class com.tencent.mm.plugin.sns.ad.widget.b.c.AnonymousClass2 */
                            final /* synthetic */ a DBI;

                            {
                                this.DBI = r2;
                            }

                            public final void onClick(View view) {
                                AppMethodBeat.i(202491);
                                b bVar = new b();
                                bVar.bm(view);
                                a.b("com/tencent/mm/plugin/sns/ad/widget/semidialog/SemiDialogManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                try {
                                    if (this.DBI != null) {
                                        this.DBI.a(c.this, view, c.this.DqO);
                                    }
                                } catch (Throwable th) {
                                }
                                a.a(this, "com/tencent/mm/plugin/sns/ad/widget/semidialog/SemiDialogManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(202491);
                            }
                        });
                    }
                    View findViewById = cVar.mContentView.findViewById(R.id.b3z);
                    if (findViewById != null) {
                        findViewById.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.sns.ad.widget.b.c.AnonymousClass1 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(202490);
                                b bVar = new b();
                                bVar.bm(view);
                                a.b("com/tencent/mm/plugin/sns/ad/widget/semidialog/SemiDialogManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                c.this.dismiss();
                                a.a(this, "com/tencent/mm/plugin/sns/ad/widget/semidialog/SemiDialogManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(202490);
                            }
                        });
                    }
                    cVar.oXS = new e(cVar.mContext, true, 0);
                    cVar.oXS.V(cVar.mContentView, true);
                    cVar.oXS.Dm(true);
                }
                if (cVar.oXS != null && !cVar.oXS.isShowing()) {
                    cVar.oXS.dGm();
                }
            } catch (Throwable th) {
            }
        }
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.gr(h.aB(snsInfo.getUxinfo(), r.v(snsInfo), 0), adCardActionBtnInfo.finderUsername);
        AppMethodBeat.o(202097);
        return true;
    }

    static class a implements com.tencent.mm.plugin.sns.ad.widget.b.a, com.tencent.mm.plugin.sns.ad.widget.b.b {
        ADXml.AdCardActionBtnInfo DxE;
        Context context;

        a(Context context2, ADXml.AdCardActionBtnInfo adCardActionBtnInfo) {
            this.context = context2;
            this.DxE = adCardActionBtnInfo;
        }

        @Override // com.tencent.mm.plugin.sns.ad.widget.b.b
        public final String eXB() {
            if (this.DxE != null) {
                return this.DxE.finderAvatar;
            }
            return "";
        }

        @Override // com.tencent.mm.plugin.sns.ad.widget.b.b
        public final String eXC() {
            if (this.DxE != null) {
                return this.DxE.finderNickName;
            }
            return "";
        }

        @Override // com.tencent.mm.plugin.sns.ad.widget.b.b
        public final String eXD() {
            if (this.DxE != null) {
                return this.DxE.finderLiveTitle;
            }
            return null;
        }

        @Override // com.tencent.mm.plugin.sns.ad.widget.b.b
        public final String eXE() {
            return "预约成功后，在活动开始前以服务通知的形式，提醒您准时参与";
        }

        @Override // com.tencent.mm.plugin.sns.ad.widget.b.b
        public final String eXF() {
            return "预约直播";
        }

        @Override // com.tencent.mm.plugin.sns.ad.widget.b.b
        public final com.tencent.mm.plugin.sns.ad.widget.b.a eXG() {
            return this;
        }

        @Override // com.tencent.mm.plugin.sns.ad.widget.b.a
        public final boolean a(final c cVar, View view, final SnsInfo snsInfo) {
            final q qVar = null;
            AppMethodBeat.i(202096);
            if (cVar == null || view == null || snsInfo == null || this.DxE == null) {
                AppMethodBeat.o(202096);
                return false;
            }
            final Context context2 = view.getContext();
            if (context2 == null) {
                AppMethodBeat.o(202096);
                return false;
            }
            if (context2 instanceof Activity) {
                qVar = com.tencent.mm.ui.base.h.a(context2, context2.getString(R.string.ek_), true, (DialogInterface.OnCancelListener) null);
            }
            final String v = r.v(snsInfo);
            final String str = this.DxE.finderUsername;
            final String str2 = this.DxE.finderLiveNoticeId;
            com.tencent.mm.plugin.sns.ad.c.b.b(v, str, str2, new b.a() {
                /* class com.tencent.mm.plugin.sns.ad.timeline.a.a.a.b.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.sns.ad.c.b.a
                public final void b(String str, int i2, Object obj) {
                    AppMethodBeat.i(202095);
                    Log.i("SnsAd.AdFinderLiveNotice", "AdFinderLiveNoticeClick:: the out snsid is " + v + ", inner snsid = " + str);
                    if (qVar != null && qVar.isShowing()) {
                        qVar.dismiss();
                    }
                    if (i2 == 0) {
                        com.tencent.mm.plugin.sns.ad.widget.living.b.fv(str, 513);
                    }
                    c cVar = cVar;
                    switch (i2) {
                        case -200045:
                        case -200023:
                        case 0:
                            if (cVar != null) {
                                cVar.dismiss();
                                break;
                            }
                            break;
                    }
                    com.tencent.mm.plugin.sns.ad.c.b.ao(context2, i2);
                    SnsInfo snsInfo = snsInfo;
                    String str2 = str;
                    String str3 = str2;
                    String str4 = "";
                    String str5 = "";
                    if (!(snsInfo == null || snsInfo.getAdXml() == null)) {
                        str4 = snsInfo.getAdXml().adExtInfo;
                        str5 = snsInfo.getUxinfo();
                    }
                    com.tencent.mm.plugin.sns.ad.c.a aVar = new com.tencent.mm.plugin.sns.ad.c.a();
                    aVar.c(str, str5, str4, str2, str3, i2, 1);
                    i.a(aVar);
                    AppMethodBeat.o(202095);
                }
            });
            AppMethodBeat.o(202096);
            return true;
        }
    }
}
