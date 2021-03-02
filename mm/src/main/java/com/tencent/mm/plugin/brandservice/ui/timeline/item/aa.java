package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.x;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.protocal.protobuf.egd;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class aa extends ag {
    public View jBI;
    public TextView pvH;
    public View pvI;
    public View pvJ;
    public View pvK;
    public TextView pvL;
    public MMNeat7extView pvM;
    public View pwD;
    public TextView pwE;
    public MMNeat7extView pwF;

    public aa(Context context, b bVar) {
        AppMethodBeat.i(194967);
        super.a(context, bVar);
        AppMethodBeat.o(194967);
    }

    public final View b(final z zVar, final int i2, View view, View view2) {
        boolean z;
        AppMethodBeat.i(194968);
        h.INSTANCE.idkeyStat(1149, 2, 1, false);
        Context context = this.mContext;
        if (this.puO == null) {
            this.puO = ((ViewStub) view2.findViewById(R.id.j84)).inflate();
            cne();
            this.pvH = (TextView) this.puO.findViewById(R.id.a6x);
            this.pvI = this.puO.findViewById(R.id.b4i);
            this.pvJ = this.puO.findViewById(R.id.b4h);
            this.pvK = this.puO.findViewById(R.id.a6v);
            this.pvL = (TextView) this.puO.findViewById(R.id.a6w);
            this.pvM = (MMNeat7extView) this.puO.findViewById(R.id.a6j);
            this.jBI = this.puO.findViewById(R.id.a6u);
            this.pwD = this.puO.findViewById(R.id.a6f);
            this.pwE = (TextView) this.puO.findViewById(R.id.a6g);
            this.pwF = (MMNeat7extView) this.puO.findViewById(R.id.a6h);
            ((WeImageView) this.puO.findViewById(R.id.ftl)).setIconColor(context.getResources().getColor(R.color.BW_0_Alpha_0_9));
        }
        this.puO.setVisibility(0);
        efz gAC = zVar.gAC();
        if (gAC == null || gAC.NfT == null) {
            view.setVisibility(8);
            AppMethodBeat.o(194968);
        } else {
            view.setVisibility(0);
            this.pvH.setText(gAC.Lug);
            this.pvG.getPaint().setFakeBoldText(true);
            ImageView imageView = this.gvv;
            String str = gAC.NfT.KQY;
            c.a aVar = new c.a();
            aVar.jbt = R.drawable.bar;
            aVar.jbe = true;
            aVar.iaT = true;
            q.bcV().a(str, imageView, aVar.bdv());
            this.pvG.setText(gAC.NfT.oUJ);
            this.pvL.setText(gAC.NfT.NfV);
            this.pvM.aw(gAC.NfT.keb);
            final String str2 = gAC.NfT.UserName;
            as Kn = ((l) g.af(l.class)).aSN().Kn(str2);
            if (Kn == null || ((int) Kn.gMZ) <= 0) {
                ay.a.iDq.a(str2, "", null);
            }
            this.pvK.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(194964);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    aa aaVar = aa.this;
                    String str = str2;
                    ege gAD = zVar.gAD();
                    if (gAD == null) {
                        Log.w("MicroMsg.BizTimeLineItem", "viewContactProfile wrapper is null");
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        intent.putExtra("Contact_Scene", 160);
                        intent.putExtra("KBizRecCardId", gAD.MOC);
                        intent.putExtra("force_get_contact", true);
                        intent.putExtra("key_use_new_contact_profile", true);
                        com.tencent.mm.br.c.b(aaVar.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        h.INSTANCE.idkeyStat(1149, 3, 1, false);
                        aaVar.pxE.pqZ.a(str, 0L, 0, 13, 0, gAD.MOC, true, 0);
                    }
                    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(194964);
                }
            });
            if (gAC.KWy == null || gAC.KWy.get(0) == null || (gAC.KWy.get(0).KHa & 1) != 0) {
                h.INSTANCE.idkeyStat(1149, 6, 1, false);
                this.jBI.setVisibility(8);
                this.pwD.setVisibility(8);
                this.pvK.setBackgroundResource(R.drawable.i1);
            } else {
                final ega ega = gAC.KWy.get(0);
                this.pwD.setVisibility(0);
                this.jBI.setVisibility(0);
                this.pwE.setText(gAC.KWx);
                this.pwF.aw(ega.Title);
                this.pwD.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.AnonymousClass2 */

                    public final void onClick(View view) {
                        long j2;
                        AppMethodBeat.i(194965);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        aa aaVar = aa.this;
                        z zVar = zVar;
                        ega ega = ega;
                        if (ega == null || zVar.gAC() == null || zVar.gAC().NfT == null) {
                            Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
                        } else {
                            egb egb = zVar.gAC().NfT;
                            h.INSTANCE.idkeyStat(1149, 4, 1, false);
                            Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", ega.KSj);
                            Intent intent = new Intent();
                            String d2 = m.d(ega.KSj, 138, 10000, 0);
                            intent.putExtra("rawUrl", d2);
                            intent.putExtra("geta8key_scene", 56);
                            intent.putExtra("geta8key_username", egb.UserName);
                            intent.putExtra("srcUsername", egb.UserName);
                            intent.putExtra("srcDisplayname", egb.oUJ);
                            intent.putExtra("prePublishId", "rec_card");
                            intent.putExtra("KPublisherId", "rec_card");
                            if (ega.iAb == 5 && ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld()) {
                                intent.putExtra(e.b.OyQ, 138);
                                intent.putExtra(e.b.OyR, 10000);
                                intent.putExtra("biz_video_session_id", ab.getSessionId());
                                x xVar = new x();
                                xVar.iAh = intent.getStringExtra("KPublisherId");
                                xVar.dHc = egb.UserName;
                                xVar.iAg = egb.oUJ;
                                xVar.iAi.url = d2;
                                xVar.iAi.title = ega.Title;
                                xVar.iAi.iAq = ega.KSh;
                                xVar.iAi.iAo = ega.KSl;
                                xVar.iAi.type = ega.iAb;
                                xVar.iAi.time = (long) ega.CreateTime;
                                xVar.iAi.iAs = ega.KSx;
                                xVar.iAi.videoWidth = ega.KSv;
                                xVar.iAi.videoHeight = ega.KSw;
                                xVar.iAi.vid = ega.KSu;
                                xVar.t(intent);
                                Log.i("MicroMsg.BizTimeLineItem", "jump to native video");
                                int[] iArr = new int[2];
                                if (view != null) {
                                    int width = view.getWidth();
                                    int height = view.getHeight();
                                    view.getLocationInWindow(iArr);
                                    intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                                }
                                intent.addFlags(268435456);
                            }
                            if (!((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1) || !((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(aaVar.mContext, d2, ega.iAb, 138, 10000, intent)) {
                                com.tencent.mm.br.c.b(aaVar.mContext, "webview", ".ui.tools.WebViewUI", intent);
                            } else {
                                Log.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
                            }
                            ege gAD = zVar.gAD();
                            if (gAD != null) {
                                int i2 = 0;
                                try {
                                    Uri parse = Uri.parse(d2);
                                    i2 = Util.getInt(parse.getQueryParameter("idx"), 0);
                                    j2 = Util.getLong(parse.getQueryParameter("mid"), 0);
                                } catch (Exception e2) {
                                    j2 = 0;
                                }
                                aaVar.pxE.pqZ.a(zVar.field_talker, j2, i2, 15, 0, gAD.MOC, true, 0);
                            }
                            aaVar.pxE.b(zVar, 0);
                        }
                        a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(194965);
                    }
                });
                this.pvK.setBackgroundResource(R.drawable.i7);
                if (((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1) && !Util.isNullOrNil(ega.KSj)) {
                    Log.d("MicroMsg.BizTimeLineItem", "preload %s", ega.KSj);
                    ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(ega.KSj, ega.iAb, 90, new Object[0]);
                }
            }
            com.tencent.mm.plugin.brandservice.ui.b.c.x(zVar);
            ege gAD = zVar.gAD();
            if (gAD == null) {
                AppMethodBeat.o(194968);
            } else {
                egd egd = gAC.NfU;
                if (egd == null) {
                    Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo = null");
                    z = false;
                } else if (egd.NfX == null) {
                    Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo = null");
                    z = false;
                } else if (egd.NfX.KWs != 1) {
                    Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.ShowNegativeFeedbackReason != 1");
                    z = false;
                } else if (Util.isNullOrNil(egd.NfX.KWr)) {
                    Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.NegativeFeedbackReason null");
                    z = false;
                } else {
                    z = true;
                }
                if (z || !Util.isNullOrNil(gAD.NfZ)) {
                    Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] showNegativeFeedback，BizNickName = %s", gAC.NfT.oUJ);
                    this.pvI.setVisibility(0);
                    this.pvI.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.AnonymousClass3 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(194966);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            aa aaVar = aa.this;
                            View view2 = aa.this.pvJ;
                            z zVar = zVar;
                            int i2 = i2;
                            ege gAD = zVar.gAD();
                            if (gAD == null) {
                                Log.w("MicroMsg.BizTimeLineItem", "onUnLikeClick wrapper is null");
                            } else {
                                aaVar.pxE.pqZ.a(zVar.gAC().NfT.UserName, 0L, 0, 16, 0, gAD.MOC, true, 0);
                                boolean z = false;
                                if (gAD.NfY == null || gAD.NfY.NfU == null || gAD.NfY.NfU.NfX == null || Util.isNullOrNil(gAD.NfY.NfU.NfX.KWr)) {
                                    z = true;
                                }
                                if (!Util.isNullOrNil(gAD.NfZ) || !z) {
                                    ((b) new b(view2.getContext(), zVar, aaVar.pxE, i2).hw(view2)).show();
                                } else {
                                    Log.w("MicroMsg.BizTimeLineItem", "onUnLikeClick negativeFeedbackReason is null");
                                }
                            }
                            a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(194966);
                        }
                    });
                } else {
                    Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] hideNegativeFeedback，BizNickName = %s", gAC.NfT.oUJ);
                    this.pvI.setVisibility(8);
                }
                AppMethodBeat.o(194968);
            }
        }
        return view;
    }

    public final void hide() {
        AppMethodBeat.i(194969);
        if (this.puO != null) {
            this.puO.setVisibility(8);
        }
        AppMethodBeat.o(194969);
    }
}
