package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.report.service.h;
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
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001*B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000eH\u0016J\u0006\u0010#\u001a\u00020\u001dJ\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000eH\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0016R\u00020\u00000\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0016R\u00020\u00000\u001bX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "firstIndex", "", "item", "Landroid/view/View;", "jumpMore", "Landroid/widget/RelativeLayout;", "longClick", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot;", "time", "Landroid/widget/TextView;", "txtJumpLink", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "inflate", "refreshCommonSlot", "refreshHead", "refreshJumpLink", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class ac extends ad {
    final Context context;
    final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
    private TextView puA;
    private View puO;
    private LinearLayout puP;
    private LinkedList<a> puQ = new LinkedList<>();
    private final i<a> puR = new i<>(new g(this));
    private RelativeLayout pwM;
    private RelativeLayout pwN;
    private TextView pwO;
    private int pwi;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<no name provided>", "", "opType", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ z prL;
        final /* synthetic */ ac pwP;
        final /* synthetic */ ege pwo;
        final /* synthetic */ ale pwq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(ac acVar, ale ale, ege ege, z zVar) {
            super(1);
            this.pwP = acVar;
            this.pwq = ale;
            this.pwo = ege;
            this.prL = zVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(195465);
            int intValue = num.intValue();
            if (!Util.isNullOrNil(this.pwq.Luj)) {
                String str = this.pwq.Luj;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", m.d(str, 169, 10000, 0));
                intent.putExtra("geta8key_scene", 56);
                com.tencent.mm.br.c.b(this.pwP.context, "webview", ".ui.tools.WebViewUI", intent);
                pj pjVar = this.pwq.KUf.get(this.pwP.pwi);
                String str2 = pjVar.KWy.get(0).KSj;
                p.g(str2, "bizInfo.AppMsg[0].ContentUrl");
                String[] bjc = af.bjc(str2);
                this.pwP.psQ.pqZ.a(pjVar.UserName, Util.getLong(bjc[0], 0), Util.getInt(bjc[1], 0), intValue, this.pwo.MOC, "", this.pwo.Nga.KUo, this.pwo.event, this.pwo.Nga.KUk, this.pwo.style, "", this.pwo.Nga.Luk, this.pwo.Nga.Luj);
                this.pwP.psQ.pqZ.b(this.prL, 0, intValue);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(195465);
            return xVar;
        }
    }

    public ac(com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, Context context2) {
        p.h(bVar, "adapter");
        p.h(context2, "context");
        AppMethodBeat.i(195469);
        this.psQ = bVar;
        this.context = context2;
        AppMethodBeat.o(195469);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void a(z zVar, int i2, View view, View view2) {
        AppMethodBeat.i(195467);
        p.h(zVar, "info");
        p.h(view, "convertView");
        p.h(view2, "parent");
        p.h(view2, "parent");
        if (this.puO == null) {
            View inflate = ((ViewStub) view2.findViewById(R.id.j87)).inflate();
            this.puP = (LinearLayout) inflate.findViewById(R.id.a6i);
            this.puA = (TextView) inflate.findViewById(R.id.e5p);
            this.pwM = (RelativeLayout) inflate.findViewById(R.id.esr);
            this.pwN = (RelativeLayout) inflate.findViewById(R.id.fjn);
            this.pwO = (TextView) inflate.findViewById(R.id.imo);
            this.puO = inflate;
        }
        view.setVisibility(0);
        View view3 = this.puO;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        RelativeLayout relativeLayout = this.pwM;
        if (relativeLayout != null) {
            relativeLayout.setOnLongClickListener(new b(this, zVar));
        }
        TextView textView = this.pwO;
        if (textView != null) {
            textView.setText(com.tencent.mm.plugin.brandservice.ui.b.b.f(this.context, zVar.field_createTime));
        }
        ege gAD = zVar.gAD();
        p.g(gAD, "info.tlRecCardWrapper");
        ale ale = gAD.Nga;
        if (Util.isNullOrNil(ale.Luk)) {
            TextView textView2 = this.puA;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else {
            TextView textView3 = this.puA;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            TextView textView4 = this.puA;
            if (textView4 != null) {
                textView4.setText(ale.Luk);
            }
            com.tencent.mm.plugin.brandservice.ui.b.d dVar = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
            com.tencent.mm.plugin.brandservice.ui.b.d.i(this.puA);
            if (Util.isNullOrNil(ale.Luj)) {
                TextView textView5 = this.puA;
                if (textView5 != null) {
                    textView5.setOnClickListener(null);
                }
                RelativeLayout relativeLayout2 = this.pwN;
                if (relativeLayout2 != null) {
                    relativeLayout2.setOnClickListener(null);
                }
            } else {
                f fVar = new f(this, ale, gAD, zVar);
                RelativeLayout relativeLayout3 = this.pwM;
                if (relativeLayout3 != null) {
                    relativeLayout3.setOnClickListener(new c(fVar));
                }
                RelativeLayout relativeLayout4 = this.pwN;
                if (relativeLayout4 != null) {
                    relativeLayout4.setOnClickListener(new d(fVar));
                }
                TextView textView6 = this.puA;
                if (textView6 != null) {
                    textView6.setOnClickListener(new e(fVar));
                }
            }
        }
        for (T t : this.puQ) {
            LinearLayout linearLayout = this.puP;
            if (linearLayout != null) {
                linearLayout.removeView(t.puS);
            }
            this.puR.da(t);
        }
        this.puQ.clear();
        LinkedList<pj> linkedList = zVar.gAD().Nga.KUf;
        p.g(linkedList, "info.tlRecCardWrapper.extraInfo.BizInfo");
        int i3 = 0;
        for (T t2 : linkedList) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                j.hxH();
            }
            T t3 = t2;
            a aVar = this.puR.get();
            LinearLayout linearLayout2 = this.puP;
            if (linearLayout2 != null) {
                linearLayout2.addView(aVar.puS);
            }
            this.puQ.add(aVar);
            p.g(t3, "bizInfo");
            pi piVar = t3.KWy.get(0);
            p.g(piVar, "bizInfo.AppMsg[0]");
            pi piVar2 = piVar;
            p.h(zVar, "info");
            p.h(t3, "bizInfo");
            p.h(piVar2, "appMsg");
            String str = piVar2.Title;
            String str2 = piVar2.KSj;
            int i5 = piVar2.iAb;
            String str3 = piVar2.KSl;
            String str4 = piVar2.KSm;
            aVar.pxp.aw(str);
            com.tencent.mm.plugin.brandservice.ui.b.d dVar2 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
            if (com.tencent.mm.plugin.brandservice.ui.b.d.crj()) {
                com.tencent.mm.plugin.brandservice.ui.b.d dVar3 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
                com.tencent.mm.plugin.brandservice.ui.b.d.c(aVar.pxp);
            }
            aVar.puS.setBackgroundResource((i3 != 0 || i3 > 0) ? R.drawable.i1 : R.drawable.i7);
            aVar.puS.setOnClickListener(new a.View$OnClickListenerC0874a(aVar, zVar, t3, piVar2, i3));
            if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1) && !Util.isNullOrNil(str2)) {
                ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(str2, i5, 90, new Object[0]);
            }
            aVar.ptH.type = i5;
            aVar.ptH.iAo = str3;
            aVar.ptH.iAD = str4;
            aVar.ptH.url = str2;
            View view4 = aVar.ptX;
            p.g(view4, "statLayout");
            view4.setVisibility(0);
            TextView textView7 = aVar.ptY;
            p.g(textView7, "friendReadTv");
            textView7.setText(!Util.isNullOrNil(piVar2.xLi) ? String.valueOf(piVar2.xLi) : "");
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
                p.h(t3, "appMsgBizInfo");
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
                if (p.j(String.valueOf(zVar.field_msgId) + "_" + i3, com.tencent.mm.plugin.brandservice.ui.b.c.crh())) {
                    aVar.pxt.setImageResource(R.drawable.ie);
                    ImageView imageView4 = aVar.pxt;
                    p.g(imageView4, "voicePlayIcon");
                    if (imageView4.getDrawable() instanceof AnimationDrawable) {
                        ImageView imageView5 = aVar.pxt;
                        p.g(imageView5, "voicePlayIcon");
                        Drawable drawable2 = imageView5.getDrawable();
                        if (drawable2 == null) {
                            t tVar = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                            AppMethodBeat.o(195467);
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
                    ((com.tencent.mm.plugin.brandservice.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.a.class)).a(aVar.pxt, String.valueOf(zVar.field_msgId) + "_" + i3, piVar2.Title, str5, "", piVar2.KSl);
                    aVar.pxt.setOnClickListener(new a.e(aVar, zVar, piVar2));
                }
            } else if (!Util.isNullOrNil(aVar.ptH.iAo)) {
                aVar.ptE.setVisibility(0);
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.d dVar4 = aVar.pxE.prc;
                long j2 = zVar.field_msgId;
                v vVar = aVar.ptH;
                String a2 = m.a(aVar.ptH);
                ImageView imageView6 = aVar.ptE;
                int i6 = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
                dVar4.a(j2, i3, vVar, a2, imageView6, i6, i6, false, (m.a) new a.b(aVar, zVar, i3), zVar.pxD + 1, 2.0f);
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
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.d dVar5 = aVar.pxE.prc;
                ImageView imageView9 = aVar.ptE;
                int i7 = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
                dVar5.a("2131231740", imageView9, i7, i7, zVar.pxD + 1);
            } else {
                aVar.pxr.setVisibility(8);
            }
            a.c cVar = a.c.pwR;
            a.d dVar6 = a.d.pwS;
            switch (i3) {
                case 0:
                    if (i3 > 0) {
                        View view7 = aVar.pxo;
                        p.g(view7, "content");
                        dVar6.a(view7, 0, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prC), 0, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prv));
                    } else {
                        View view8 = aVar.pxo;
                        p.g(view8, "content");
                        dVar6.a(view8, 0, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prC), 0, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.pry));
                    }
                    View view9 = aVar.jBI;
                    p.g(view9, "topLine");
                    view9.setVisibility(8);
                    break;
                case 1:
                    View view10 = aVar.pxo;
                    p.g(view10, "content");
                    dVar6.a(view10, 0, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.pry), 0, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.pry));
                    View view11 = aVar.jBI;
                    p.g(view11, "topLine");
                    cVar.invoke(view11, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prz));
                    break;
            }
            if (aVar.ptH.type == 5) {
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.e eVar = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.pAN;
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.F(aVar.ptH.url, aVar.ptH.type, "");
            }
            i3 = i4;
        }
        AppMethodBeat.o(195467);
    }

    public final void hide() {
        AppMethodBeat.i(195468);
        View view = this.puO;
        if (view != null) {
            view.setVisibility(8);
            AppMethodBeat.o(195468);
            return;
        }
        AppMethodBeat.o(195468);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    public static final class b implements View.OnLongClickListener {
        final /* synthetic */ z prL;
        final /* synthetic */ ac pwP;

        b(ac acVar, z zVar) {
            this.pwP = acVar;
            this.prL = zVar;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(195461);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            this.pwP.psQ.pqY = this.prL;
            this.pwP.psQ.cmn();
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(195461);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ kotlin.g.a.b pwT;

        c(kotlin.g.a.b bVar) {
            this.pwT = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195462);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$refreshJumpLink$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.pwT.invoke(24);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$refreshJumpLink$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195462);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ kotlin.g.a.b pwT;

        d(kotlin.g.a.b bVar) {
            this.pwT = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195463);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$refreshJumpLink$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.pwT.invoke(25);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$refreshJumpLink$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195463);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ kotlin.g.a.b pwT;

        e(kotlin.g.a.b bVar) {
            this.pwT = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195464);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$refreshJumpLink$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.pwT.invoke(24);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$refreshJumpLink$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195464);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J2\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001d\u001a\u00020\u001eJ.\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eJ\u0016\u0010#\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eJ&\u0010$\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
    public final class a extends ah {
        final Context context;
        final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
        final v ptH = new v();
        final View puS = View.inflate(this.context, R.layout.k_, null);
        final /* synthetic */ ac pwP;

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<no name provided>", "", "view", "Landroid/view/View;", "margin", "", "invoke"})
        public static final class c extends q implements kotlin.g.a.m<View, Integer, x> {
            public static final c pwR = new c();

            static {
                AppMethodBeat.i(195456);
                AppMethodBeat.o(195456);
            }

            c() {
                super(2);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(View view, Integer num) {
                AppMethodBeat.i(195455);
                View view2 = view;
                int intValue = num.intValue();
                p.h(view2, "view");
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    AppMethodBeat.o(195455);
                    throw tVar;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.rightMargin = intValue;
                view2.setLayoutParams(layoutParams2);
                x xVar = x.SXb;
                AppMethodBeat.o(195455);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\n¢\u0006\u0002\b\t"}, hxF = {"<no name provided>", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "invoke"})
        public static final class d extends q implements s<View, Integer, Integer, Integer, Integer, x> {
            public static final d pwS = new d();

            static {
                AppMethodBeat.i(195458);
                AppMethodBeat.o(195458);
            }

            d() {
                super(5);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.s
            public final /* synthetic */ x a(View view, Integer num, Integer num2, Integer num3, Integer num4) {
                AppMethodBeat.i(195457);
                View view2 = view;
                int intValue = num.intValue();
                int intValue2 = num2.intValue();
                int intValue3 = num3.intValue();
                int intValue4 = num4.intValue();
                p.h(view2, "view");
                view2.setPadding(intValue, intValue2, intValue3, intValue4);
                x xVar = x.SXb;
                AppMethodBeat.o(195457);
                return xVar;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ac acVar, com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, Context context2) {
            super(bVar, context2);
            p.h(bVar, "adapter");
            p.h(context2, "context");
            this.pwP = acVar;
            AppMethodBeat.i(195460);
            this.psQ = bVar;
            this.context = context2;
            this.jBI = this.puS.findViewById(R.id.it2);
            this.pxo = this.puS.findViewById(R.id.bf0);
            View findViewById = this.puS.findViewById(R.id.iqr);
            if (findViewById == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
                AppMethodBeat.o(195460);
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
                AppMethodBeat.o(195460);
                throw tVar2;
            }
            this.ptY = (TextView) findViewById2;
            this.pxv = this.puS.findViewById(R.id.gbl);
            this.pxw = this.puS.findViewById(R.id.gbk);
            this.puD = (TextView) this.puS.findViewById(R.id.gbt);
            AppMethodBeat.o(195460);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.item.ac$a$a  reason: collision with other inner class name */
        public static final class View$OnClickListenerC0874a implements View.OnClickListener {
            final /* synthetic */ z prL;
            final /* synthetic */ int prP;
            final /* synthetic */ pi ptK;
            final /* synthetic */ pj pvl;
            final /* synthetic */ a pwQ;

            View$OnClickListenerC0874a(a aVar, z zVar, pj pjVar, pi piVar, int i2) {
                this.pwQ = aVar;
                this.prL = zVar;
                this.pvl = pjVar;
                this.ptK = piVar;
                this.prP = i2;
            }

            public final void onClick(View view) {
                long j2;
                AppMethodBeat.i(195453);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a aVar = this.pwQ;
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
                        h.INSTANCE.idkeyStat(1149, 4, 1, false);
                        Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", piVar.KSj);
                        Intent intent = new Intent();
                        String d2 = com.tencent.mm.ag.m.d(piVar.KSj, 183, 10000, 0);
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
                                intent.putExtra(e.b.OyQ, 183);
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
                        if (!((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1) || !((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(aVar.context, d2, piVar.iAb, 183, 10000, intent)) {
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
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(195453);
                    }
                }
                Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(195453);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
        public static final class b implements m.a {
            final /* synthetic */ z prL;
            final /* synthetic */ int puX;
            final /* synthetic */ a pwQ;

            b(a aVar, z zVar, int i2) {
                this.pwQ = aVar;
                this.prL = zVar;
                this.puX = i2;
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onFinish() {
                AppMethodBeat.i(195454);
                this.pwQ.a(this.pwQ.ptH, true);
                this.pwQ.pxE.prc.m(this.prL.field_msgId, this.puX);
                AppMethodBeat.o(195454);
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
            final /* synthetic */ a pwQ;

            e(a aVar, z zVar, pi piVar) {
                this.pwQ = aVar;
                this.prL = zVar;
                this.ptK = piVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(195459);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ((com.tencent.mm.plugin.brandservice.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.a.class)).dq(this.pwQ.pxt);
                if (this.prL.gAD() != null) {
                    try {
                        Uri parse = Uri.parse(this.ptK.KSj);
                        Util.getInt(parse.getQueryParameter("idx"), 0);
                        Util.getLong(parse.getQueryParameter("mid"), 0);
                    } catch (Exception e2) {
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(195459);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;", "invoke"})
    static final class g extends q implements kotlin.g.a.a<a> {
        final /* synthetic */ ac pwP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(ac acVar) {
            super(0);
            this.pwP = acVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ a invoke() {
            AppMethodBeat.i(195466);
            a aVar = new a(this.pwP, this.pwP.psQ, this.pwP.context);
            AppMethodBeat.o(195466);
            return aVar;
        }
    }
}
