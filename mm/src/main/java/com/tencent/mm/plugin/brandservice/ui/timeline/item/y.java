package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001AB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J(\u0010*\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0012H\u0016J\n\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\fH\u0016J\n\u00101\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u00102\u001a\u00020%J\u0010\u00103\u001a\u00020%2\u0006\u0010-\u001a\u00020\u0012H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u00104\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u00105\u001a\u00020\fH\u0002J\u0018\u00106\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\u0018\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020<2\u0006\u0010&\u001a\u00020'H\u0002J\u0018\u0010=\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010>\u001a\u00020\u0001H\u0016J\u0010\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0018R\u00020\u00000\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010 \u001a\f\u0012\b\u0012\u00060\u0018R\u00020\u00000!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "firstIndex", "", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVideoCard", "", "item", "Landroid/view/View;", "jumpLinkClick", "Landroid/widget/LinearLayout;", "slotContainer", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "txtJumpLink", "Landroid/widget/TextView;", "txtTitle", "viewArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "viewClose", "viewHead", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "viewVideo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "clickCard", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "position", "convertView", "parent", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "inflate", "refreshClose", "showPos", "refreshCommonSlot", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "refreshHead", "refreshJumpLink", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "registerCard", "cardTmpl", "setVideoStatus", "status", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class y extends ad {
    final Context context;
    final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
    private TextView puA;
    private View puO;
    private LinearLayout puP;
    private LinkedList<a> puQ = new LinkedList<>();
    private final i<a> puR = new i<>(new h(this));
    private View pvb;
    private View pve;
    private WeImageView pvf;
    private g pvg = new g(this.context, this.psQ);
    private d pvh = new d(this.context, this.psQ);
    private boolean pvi;
    private TextView pwh;
    private int pwi = -1;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<no name provided>", "", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<pj, x> {
        final /* synthetic */ z prL;
        final /* synthetic */ y pwj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(y yVar, z zVar) {
            super(1);
            this.pwj = yVar;
            this.prL = zVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(pj pjVar) {
            AppMethodBeat.i(195430);
            pj pjVar2 = pjVar;
            p.h(pjVar2, "bizInfo");
            switch (pjVar2.KWy.get(0).iAb) {
                case 5:
                    g gVar = this.pwj.pvg;
                    View view = this.pwj.puO;
                    if (view == null) {
                        p.hyc();
                    }
                    gVar.a(view, this.prL, pjVar2);
                    this.pwj.pvh.hide();
                    this.pwj.pvi = true;
                    this.pwj.a(this.prL, this.pwj);
                    MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
                    MPVideoPreviewMgr.q(this.prL);
                    this.pwj.pvg.ptZ = new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.y.b.AnonymousClass1 */
                        final /* synthetic */ b pwn;

                        {
                            this.pwn = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(195429);
                            this.pwn.pwj.a(this.pwn.prL, "");
                            x xVar = x.SXb;
                            AppMethodBeat.o(195429);
                            return xVar;
                        }
                    };
                    break;
                default:
                    d dVar = this.pwj.pvh;
                    View view2 = this.pwj.puO;
                    if (view2 == null) {
                        p.hyc();
                    }
                    dVar.a(view2, this.prL, pjVar2);
                    this.pwj.pvg.hide();
                    break;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(195430);
            return xVar;
        }
    }

    public y(com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, Context context2) {
        p.h(bVar, "adapter");
        p.h(context2, "context");
        AppMethodBeat.i(195441);
        this.psQ = bVar;
        this.context = context2;
        AppMethodBeat.o(195441);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void a(z zVar, int i2, View view, View view2) {
        int i3;
        AppMethodBeat.i(195437);
        p.h(zVar, "info");
        p.h(view, "convertView");
        p.h(view2, "parent");
        p.h(view2, "parent");
        if (this.puO == null) {
            View inflate = ((ViewStub) view2.findViewById(R.id.j82)).inflate();
            this.pve = inflate.findViewById(R.id.b4i);
            this.pvf = (WeImageView) inflate.findViewById(R.id.b4h);
            this.puP = (LinearLayout) inflate.findViewById(R.id.a6i);
            this.pvb = inflate.findViewById(R.id.a54);
            this.pwh = (TextView) inflate.findViewById(R.id.fz_);
            this.puA = (TextView) inflate.findViewById(R.id.e5p);
            this.puO = inflate;
        }
        this.pwi = -1;
        LinkedList<pj> linkedList = zVar.gAD().Nga.KUf;
        p.g(linkedList, "info.tlRecCardWrapper.extraInfo.BizInfo");
        int i4 = 0;
        int i5 = 0;
        for (Object obj : j.b(linkedList, 2)) {
            int i6 = i4 + 1;
            if (i4 < 0) {
                j.hxH();
            }
            if (((pj) obj).KHa == 0) {
                i3 = i5 + 1;
                if (this.pwi != -1) {
                    i4 = this.pwi;
                }
                this.pwi = i4;
            } else {
                i3 = i5;
            }
            i4 = i6;
            i5 = i3;
        }
        if (i5 <= 0 || this.pwi == -1) {
            AppMethodBeat.o(195437);
            return;
        }
        view.setVisibility(0);
        View view3 = this.puO;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this.pvi = false;
        b bVar = new b(this, zVar);
        switch (i5) {
            case 1:
                pj pjVar = zVar.gAD().Nga.KUf.get(this.pwi);
                p.g(pjVar, "info.tlRecCardWrapper.ex…aInfo.BizInfo[firstIndex]");
                bVar.invoke(pjVar);
                for (T t : this.puQ) {
                    LinearLayout linearLayout = this.puP;
                    if (linearLayout != null) {
                        linearLayout.removeView(t.puS);
                    }
                    this.puR.da(t);
                }
                this.puQ.clear();
                break;
            case 2:
                pj pjVar2 = zVar.gAD().Nga.KUf.get(0);
                p.g(pjVar2, "info.tlRecCardWrapper.extraInfo.BizInfo[0]");
                bVar.invoke(pjVar2);
                pj pjVar3 = zVar.gAD().Nga.KUf.get(1);
                p.g(pjVar3, "info.tlRecCardWrapper.extraInfo.BizInfo[1]");
                pj pjVar4 = pjVar3;
                for (T t2 : this.puQ) {
                    LinearLayout linearLayout2 = this.puP;
                    if (linearLayout2 != null) {
                        linearLayout2.removeView(t2.puS);
                    }
                    this.puR.da(t2);
                }
                this.puQ.clear();
                a aVar = this.puR.get();
                LinearLayout linearLayout3 = this.puP;
                if (linearLayout3 != null) {
                    linearLayout3.addView(aVar.puS);
                }
                this.puQ.add(aVar);
                pi piVar = pjVar4.KWy.get(0);
                p.g(piVar, "bizInfo.AppMsg[0]");
                pi piVar2 = piVar;
                p.h(zVar, "info");
                p.h(pjVar4, "bizInfo");
                p.h(piVar2, "appMsg");
                String str = piVar2.Title;
                String str2 = piVar2.KSj;
                int i7 = piVar2.iAb;
                String str3 = piVar2.KSl;
                String str4 = piVar2.KSm;
                aVar.pxp.aw(str);
                com.tencent.mm.plugin.brandservice.ui.b.d dVar = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
                if (com.tencent.mm.plugin.brandservice.ui.b.d.crj()) {
                    com.tencent.mm.plugin.brandservice.ui.b.d dVar2 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
                    com.tencent.mm.plugin.brandservice.ui.b.d.c(aVar.pxp);
                }
                aVar.puS.setBackgroundResource(R.drawable.i1);
                aVar.puS.setOnClickListener(new a.View$OnClickListenerC0882a(aVar, zVar, pjVar4, piVar2));
                if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1) && !Util.isNullOrNil(str2)) {
                    ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(str2, i7, 90, new Object[0]);
                }
                aVar.ptH.type = i7;
                aVar.ptH.iAo = str3;
                aVar.ptH.iAD = str4;
                aVar.ptH.url = str2;
                View view4 = aVar.ptX;
                p.g(view4, "statLayout");
                view4.setVisibility(0);
                TextView textView = aVar.ptY;
                p.g(textView, "friendReadTv");
                textView.setText(!Util.isNullOrNil(piVar2.xLi) ? String.valueOf(piVar2.xLi) : "");
                ImageView imageView = aVar.pxu;
                p.g(imageView, "playIcon");
                imageView.setVisibility(8);
                aVar.pxu.setImageResource(R.drawable.ic);
                View view5 = aVar.pxs;
                p.g(view5, "voicePlayIconContainer");
                view5.setVisibility(8);
                if (aVar.ptH.type == 7) {
                    aVar.ptE.setVisibility(8);
                    p.h(zVar, "info");
                    p.h(pjVar4, "appMsgBizInfo");
                    p.h(piVar2, "appMsg");
                    ImageView imageView2 = aVar.pxu;
                    p.g(imageView2, "playIcon");
                    imageView2.setVisibility(8);
                    View view6 = aVar.pxs;
                    p.g(view6, "voicePlayIconContainer");
                    view6.setVisibility(0);
                    ImageView imageView3 = aVar.pxt;
                    p.g(imageView3, "voicePlayIcon");
                    Drawable drawable = imageView3.getDrawable();
                    if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                        ((AnimationDrawable) drawable).stop();
                    }
                    if (p.j(String.valueOf(zVar.field_msgId) + "_1", com.tencent.mm.plugin.brandservice.ui.b.c.crh())) {
                        aVar.pxt.setImageResource(R.drawable.ie);
                        ImageView imageView4 = aVar.pxt;
                        p.g(imageView4, "voicePlayIcon");
                        if (imageView4.getDrawable() instanceof AnimationDrawable) {
                            ImageView imageView5 = aVar.pxt;
                            p.g(imageView5, "voicePlayIcon");
                            Drawable drawable2 = imageView5.getDrawable();
                            if (drawable2 == null) {
                                t tVar = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                                AppMethodBeat.o(195437);
                                throw tVar;
                            }
                            ((AnimationDrawable) drawable2).start();
                        }
                    } else {
                        aVar.pxt.setImageResource(R.drawable.id);
                    }
                    String str5 = piVar2.KWt;
                    if (Util.isNullOrNil(str5)) {
                        Log.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
                    } else {
                        ((com.tencent.mm.plugin.brandservice.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.a.class)).a(aVar.pxt, String.valueOf(zVar.field_msgId) + "_1", piVar2.Title, str5, "", piVar2.KSl);
                        aVar.pxt.setOnClickListener(new a.e(aVar, zVar, piVar2));
                    }
                } else if (!Util.isNullOrNil(aVar.ptH.iAo)) {
                    aVar.ptE.setVisibility(0);
                    com.tencent.mm.plugin.brandservice.ui.timeline.preload.d dVar3 = aVar.pxE.prc;
                    long j2 = zVar.field_msgId;
                    v vVar = aVar.ptH;
                    String a2 = m.a(aVar.ptH);
                    ImageView imageView6 = aVar.ptE;
                    int i8 = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
                    dVar3.a(j2, 1, vVar, a2, imageView6, i8, i8, false, (m.a) new a.b(aVar, zVar), zVar.pxD + 1, 2.0f);
                    if (aVar.ptH.type == 5) {
                        ImageView imageView7 = aVar.pxu;
                        p.g(imageView7, "playIcon");
                        imageView7.setVisibility(0);
                    }
                } else if (aVar.ptH.type == 5 || aVar.ptH.type == 6) {
                    ImageView imageView8 = aVar.pxu;
                    p.g(imageView8, "playIcon");
                    imageView8.setVisibility(0);
                    aVar.ptE.setVisibility(0);
                    com.tencent.mm.plugin.brandservice.ui.timeline.preload.d dVar4 = aVar.pxE.prc;
                    ImageView imageView9 = aVar.ptE;
                    int i9 = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
                    dVar4.a("2131231740", imageView9, i9, i9, zVar.pxD + 1);
                } else {
                    aVar.pxr.setVisibility(8);
                }
                a.c cVar = a.c.pwl;
                View view7 = aVar.pxo;
                p.g(view7, "content");
                a.d.pwm.a(view7, 0, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.pry), 0, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prv));
                View view8 = aVar.jBI;
                p.g(view8, "topLine");
                cVar.invoke(view8, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prz));
                break;
        }
        TextView textView2 = this.pwh;
        if (textView2 != null) {
            textView2.setText(zVar.NQn.Nga.Lug);
        }
        com.tencent.mm.plugin.brandservice.ui.b.d dVar5 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
        com.tencent.mm.plugin.brandservice.ui.b.d.i(this.pwh);
        View view9 = this.pvb;
        if (view9 != null) {
            view9.setOnLongClickListener(new d(this, zVar));
        }
        if (Util.isNullOrNil(zVar.gAD().Nga.KWr) || zVar.gAD().Nga.KWs != 1) {
            View view10 = this.pve;
            if (view10 != null) {
                view10.setVisibility(8);
            }
        } else {
            View view11 = this.pve;
            if (view11 != null) {
                view11.setVisibility(0);
            }
            View view12 = this.pve;
            if (view12 != null) {
                view12.setOnClickListener(new c(this, zVar, i2));
            }
        }
        ege gAD = zVar.gAD();
        p.g(gAD, "info.tlRecCardWrapper");
        ale ale = gAD.Nga;
        if (Util.isNullOrNil(ale.Luk)) {
            TextView textView3 = this.puA;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            View view13 = this.pvb;
            if (view13 != null) {
                view13.setOnClickListener(null);
                AppMethodBeat.o(195437);
                return;
            }
            AppMethodBeat.o(195437);
            return;
        }
        TextView textView4 = this.puA;
        if (textView4 != null) {
            textView4.setVisibility(0);
        }
        TextView textView5 = this.puA;
        if (textView5 != null) {
            textView5.setText(ale.Luk);
        }
        com.tencent.mm.plugin.brandservice.ui.b.d dVar6 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
        com.tencent.mm.plugin.brandservice.ui.b.d.i(this.puA);
        if (Util.isNullOrNil(ale.Luj)) {
            View view14 = this.pvb;
            if (view14 != null) {
                view14.setClickable(false);
                AppMethodBeat.o(195437);
                return;
            }
            AppMethodBeat.o(195437);
            return;
        }
        TextView textView6 = this.puA;
        if (textView6 != null) {
            textView6.post(new e(this, gAD));
        }
        g gVar = new g(this, ale, gAD, zVar);
        View view15 = this.pvb;
        if (view15 != null) {
            view15.setOnClickListener(new f(gVar));
            AppMethodBeat.o(195437);
            return;
        }
        AppMethodBeat.o(195437);
    }

    public final void hide() {
        AppMethodBeat.i(195438);
        View view = this.puO;
        if (view != null) {
            view.setVisibility(8);
            AppMethodBeat.o(195438);
            return;
        }
        AppMethodBeat.o(195438);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    public static final class d implements View.OnLongClickListener {
        final /* synthetic */ z prL;
        final /* synthetic */ y pwj;

        d(y yVar, z zVar) {
            this.pwj = yVar;
            this.prL = zVar;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(195432);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            this.pwj.psQ.pqY = this.prL;
            this.pwj.psQ.cmn();
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(195432);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ z prL;
        final /* synthetic */ int pvq;
        final /* synthetic */ y pwj;

        c(y yVar, z zVar, int i2) {
            this.pwj = yVar;
            this.prL = zVar;
            this.pvq = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195431);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ege gAD = this.prL.gAD();
            if (this.pwj.pwi == -1) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(195431);
                return;
            }
            pj pjVar = this.prL.gAD().Nga.KUf.get(this.pwj.pwi);
            pi piVar = pjVar.KWy.get(0);
            String str = piVar.KSj;
            int i2 = 0;
            long j2 = 0;
            if (!Util.isNullOrNil(str)) {
                try {
                    Uri parse = Uri.parse(str);
                    i2 = Util.getInt(parse.getQueryParameter("idx"), 0);
                    j2 = Util.getLong(parse.getQueryParameter("mid"), 0);
                } catch (Exception e2) {
                }
            }
            this.pwj.psQ.pqZ.a(pjVar.UserName, j2, i2, 16, gAD.MOC, "", 0, gAD.Nga.KUo, gAD.event, gAD.Nga.KUk, piVar.KWv, gAD.style, piVar.KWw);
            ((e) new e(this.pwj.context, this.prL, this.pwj.psQ, pjVar, this.pvq).hw(this.pwj.pvf)).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195431);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ y pwj;
        final /* synthetic */ ege pwo;

        e(y yVar, ege ege) {
            this.pwj = yVar;
            this.pwo = ege;
        }

        public final void run() {
            Layout layout;
            AppMethodBeat.i(195433);
            TextView textView = this.pwj.puA;
            if (textView == null || (layout = textView.getLayout()) == null) {
                AppMethodBeat.o(195433);
                return;
            }
            TextView textView2 = this.pwj.pwh;
            if (textView2 != null) {
                textView2.setText((layout.getLineCount() <= 0 || layout.getEllipsisCount(layout.getLineCount() + -1) <= 0) ? this.pwo.Nga.Lug : this.pwj.context.getString(R.string.aj6));
                AppMethodBeat.o(195433);
                return;
            }
            AppMethodBeat.o(195433);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class f implements View.OnClickListener {
        final /* synthetic */ kotlin.g.a.a pwp;

        f(kotlin.g.a.a aVar) {
            this.pwp = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195434);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshJumpLink$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.pwp.invoke();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshJumpLink$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195434);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J2\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001d\u001a\u00020\u001eJ.\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eJ\u0016\u0010#\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eJ&\u0010$\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
    public final class a extends ah {
        final Context context;
        final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
        final v ptH = new v();
        final View puS = View.inflate(this.context, R.layout.k_, null);
        final /* synthetic */ y pwj;

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<no name provided>", "", "view", "Landroid/view/View;", "margin", "", "invoke"})
        public static final class c extends q implements kotlin.g.a.m<View, Integer, x> {
            public static final c pwl = new c();

            static {
                AppMethodBeat.i(195424);
                AppMethodBeat.o(195424);
            }

            c() {
                super(2);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(View view, Integer num) {
                AppMethodBeat.i(195423);
                View view2 = view;
                int intValue = num.intValue();
                p.h(view2, "view");
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    AppMethodBeat.o(195423);
                    throw tVar;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.rightMargin = intValue;
                view2.setLayoutParams(layoutParams2);
                x xVar = x.SXb;
                AppMethodBeat.o(195423);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\n¢\u0006\u0002\b\t"}, hxF = {"<no name provided>", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "invoke"})
        public static final class d extends q implements s<View, Integer, Integer, Integer, Integer, x> {
            public static final d pwm = new d();

            static {
                AppMethodBeat.i(195426);
                AppMethodBeat.o(195426);
            }

            d() {
                super(5);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.s
            public final /* synthetic */ x a(View view, Integer num, Integer num2, Integer num3, Integer num4) {
                AppMethodBeat.i(195425);
                View view2 = view;
                int intValue = num.intValue();
                int intValue2 = num2.intValue();
                int intValue3 = num3.intValue();
                int intValue4 = num4.intValue();
                p.h(view2, "view");
                view2.setPadding(intValue, intValue2, intValue3, intValue4);
                x xVar = x.SXb;
                AppMethodBeat.o(195425);
                return xVar;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(y yVar, com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, Context context2) {
            super(bVar, context2);
            p.h(bVar, "adapter");
            p.h(context2, "context");
            this.pwj = yVar;
            AppMethodBeat.i(195428);
            this.psQ = bVar;
            this.context = context2;
            this.jBI = this.puS.findViewById(R.id.it2);
            this.pxo = this.puS.findViewById(R.id.bf0);
            View findViewById = this.puS.findViewById(R.id.iqr);
            if (findViewById == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
                AppMethodBeat.o(195428);
                throw tVar;
            }
            this.pxp = (MMNeat7extView) findViewById;
            this.pxq = (TextView) this.puS.findViewById(R.id.ied);
            this.pxr = this.puS.findViewById(R.id.bgx);
            this.ptE = (ImageView) this.puS.findViewById(R.id.bh7);
            this.pxs = this.puS.findViewById(R.id.a7p);
            this.pxt = (ImageView) this.puS.findViewById(R.id.a97);
            this.pxu = (ImageView) this.puS.findViewById(R.id.gcf);
            this.ptX = this.puS.findViewById(R.id.i4r);
            View findViewById2 = this.puS.findViewById(R.id.daz);
            if (findViewById2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(195428);
                throw tVar2;
            }
            this.ptY = (TextView) findViewById2;
            this.pxv = this.puS.findViewById(R.id.gbl);
            this.pxw = this.puS.findViewById(R.id.gbk);
            this.puD = (TextView) this.puS.findViewById(R.id.gbt);
            AppMethodBeat.o(195428);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.item.y$a$a  reason: collision with other inner class name */
        public static final class View$OnClickListenerC0882a implements View.OnClickListener {
            final /* synthetic */ z prL;
            final /* synthetic */ int prP = 1;
            final /* synthetic */ pi ptK;
            final /* synthetic */ pj pvl;
            final /* synthetic */ a pwk;

            View$OnClickListenerC0882a(a aVar, z zVar, pj pjVar, pi piVar) {
                this.pwk = aVar;
                this.prL = zVar;
                this.pvl = pjVar;
                this.ptK = piVar;
            }

            public final void onClick(View view) {
                long j2;
                AppMethodBeat.i(195421);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a aVar = this.pwk;
                z zVar = this.prL;
                pj pjVar = this.pvl;
                pi piVar = this.ptK;
                int i2 = this.prP;
                p.h(zVar, "info");
                p.h(pjVar, "appMsgBizInfo");
                if (!(piVar == null || zVar.gAC() == null)) {
                    efz gAC = zVar.gAC();
                    if (gAC == null) {
                        p.hyc();
                    }
                    if (gAC.NfT != null) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1149, 4, 1, false);
                        Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", piVar.KSj);
                        Intent intent = new Intent();
                        String d2 = com.tencent.mm.ag.m.d(piVar.KSj, 169, 10000, 0);
                        intent.putExtra("rawUrl", d2);
                        intent.putExtra("geta8key_scene", 56);
                        intent.putExtra("geta8key_username", pjVar.UserName);
                        intent.putExtra("srcUsername", pjVar.UserName);
                        intent.putExtra("srcDisplayname", pjVar.oUJ);
                        intent.putExtra("prePublishId", "rec_card");
                        intent.putExtra("KPublisherId", "rec_card");
                        if (piVar.iAb == 5) {
                            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
                            p.g(af, "MMKernel.service(IBrandService::class.java)");
                            if (((com.tencent.mm.plugin.brandservice.a.b) af).cld()) {
                                intent.putExtra(e.b.OyQ, 169);
                                intent.putExtra(e.b.OyR, 10000);
                                intent.putExtra("biz_video_session_id", ab.getSessionId());
                                com.tencent.mm.ag.x xVar = new com.tencent.mm.ag.x();
                                xVar.iAh = intent.getStringExtra("KPublisherId");
                                xVar.dHc = pjVar.UserName;
                                xVar.iAg = pjVar.oUJ;
                                xVar.iAi.url = d2;
                                xVar.iAi.title = piVar.Title;
                                xVar.iAi.iAq = piVar.KSh;
                                xVar.iAi.iAo = piVar.KSl;
                                xVar.iAi.type = piVar.iAb;
                                xVar.iAi.time = (long) piVar.CreateTime;
                                xVar.iAi.iAs = piVar.KSx;
                                xVar.iAi.videoWidth = piVar.KSv;
                                xVar.iAi.videoHeight = piVar.KSw;
                                xVar.iAi.vid = piVar.KSu;
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
                        }
                        aVar.pwj.a(zVar, "PAUSE_FOR_RESUME");
                        if (!((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1) || !((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(aVar.context, d2, piVar.iAb, 169, 10000, intent)) {
                            com.tencent.mm.br.c.b(aVar.context, "webview", ".ui.tools.WebViewUI", intent);
                        } else {
                            Log.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
                        }
                        ege gAD = zVar.gAD();
                        if (gAD != null) {
                            int i3 = 0;
                            try {
                                Uri parse = Uri.parse(d2);
                                i3 = Util.getInt(parse.getQueryParameter("idx"), 0);
                                j2 = Util.getLong(parse.getQueryParameter("mid"), 0);
                            } catch (Exception e2) {
                                j2 = 0;
                            }
                            aVar.psQ.pqZ.a(pjVar.UserName, j2, i3, 15, gAD.MOC, "", i2, gAD.Nga.KUo, gAD.event, gAD.Nga.KUk, piVar.KWv, gAD.style, piVar.KWw);
                        }
                        aVar.psQ.b(zVar, i2);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(195421);
                    }
                }
                Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(195421);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
        public static final class b implements m.a {
            final /* synthetic */ z prL;
            final /* synthetic */ int puX = 1;
            final /* synthetic */ a pwk;

            /* JADX WARN: Incorrect types in method signature: (Lcom/tencent/mm/storage/z;I)V */
            b(a aVar, z zVar) {
                this.pwk = aVar;
                this.prL = zVar;
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onFinish() {
                AppMethodBeat.i(195422);
                this.pwk.a(this.pwk.ptH, true);
                this.pwk.pxE.prc.m(this.prL.field_msgId, this.puX);
                AppMethodBeat.o(195422);
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onStart() {
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class e implements View.OnClickListener {
            final /* synthetic */ z prL;
            final /* synthetic */ pi ptK;
            final /* synthetic */ a pwk;

            e(a aVar, z zVar, pi piVar) {
                this.pwk = aVar;
                this.prL = zVar;
                this.ptK = piVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(195427);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ((com.tencent.mm.plugin.brandservice.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.a.class)).dq(this.pwk.pxt);
                if (this.prL.gAD() != null) {
                    try {
                        Uri parse = Uri.parse(this.ptK.KSj);
                        Util.getInt(parse.getQueryParameter("idx"), 0);
                        Util.getLong(parse.getQueryParameter("mid"), 0);
                    } catch (Exception e2) {
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(195427);
            }
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void a(z zVar, ad adVar) {
        AppMethodBeat.i(195439);
        p.h(zVar, "info");
        p.h(adVar, "cardTmpl");
        MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
        MPVideoPreviewMgr.a(zVar, adVar);
        AppMethodBeat.o(195439);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final boolean cmS() {
        return this.pvi;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final View getVideoView() {
        return this.pvg.puc;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void setVideoStatus(int i2) {
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void a(z zVar, String str) {
        AppMethodBeat.i(195440);
        p.h(zVar, "info");
        p.h(str, "extra");
        MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
        MPVideoPreviewMgr.a(zVar, str);
        AppMethodBeat.o(195440);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "invoke"})
    static final class h extends q implements kotlin.g.a.a<a> {
        final /* synthetic */ y pwj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(y yVar) {
            super(0);
            this.pwj = yVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ a invoke() {
            AppMethodBeat.i(195436);
            a aVar = new a(this.pwj, this.pwj.psQ, this.pwj.context);
            AppMethodBeat.o(195436);
            return aVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<no name provided>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ z prL;
        final /* synthetic */ y pwj;
        final /* synthetic */ ege pwo;
        final /* synthetic */ ale pwq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(y yVar, ale ale, ege ege, z zVar) {
            super(0);
            this.pwj = yVar;
            this.pwq = ale;
            this.pwo = ege;
            this.prL = zVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(195435);
            if (!Util.isNullOrNil(this.pwq.Luj)) {
                String str = this.pwq.Luj;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", com.tencent.mm.ag.m.d(str, 169, 10000, 0));
                intent.putExtra("geta8key_scene", 56);
                com.tencent.mm.br.c.b(this.pwj.context, "webview", ".ui.tools.WebViewUI", intent);
                pj pjVar = this.pwq.KUf.get(this.pwj.pwi);
                String str2 = pjVar.KWy.get(0).KSj;
                p.g(str2, "bizInfo.AppMsg[0].ContentUrl");
                String[] bjc = af.bjc(str2);
                this.pwj.psQ.pqZ.a(pjVar.UserName, Util.getLong(bjc[0], 0), Util.getInt(bjc[1], 0), 24, this.pwo.MOC, "", this.pwo.Nga.KUo, this.pwo.event, this.pwo.Nga.KUk, this.pwo.style, "", this.pwo.Nga.Luk, this.pwo.Nga.Luj);
                this.pwj.psQ.pqZ.b(this.prL, 0, 24);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(195435);
            return xVar;
        }
    }
}
