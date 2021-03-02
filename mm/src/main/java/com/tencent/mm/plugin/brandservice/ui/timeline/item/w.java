package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.x;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.protocal.protobuf.egd;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 c2\u00020\u0001:\u0002cdB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020IH\u0002J\u0018\u0010J\u001a\u00020F2\u0006\u0010K\u001a\u00020I2\u0006\u0010L\u001a\u00020MH\u0002J(\u0010N\u001a\u00020F2\u0006\u0010L\u001a\u00020M2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u0012H\u0016J\u0010\u0010S\u001a\u00020F2\u0006\u0010R\u001a\u00020\u0012H&J\u000e\u0010T\u001a\u00020F2\u0006\u0010U\u001a\u00020\u0012J*\u0010V\u001a\u00020F2\u0006\u0010L\u001a\u00020M2\b\u0010W\u001a\u0004\u0018\u00010X2\b\u0010Q\u001a\u0004\u0018\u00010\u00122\u0006\u0010Y\u001a\u00020PJ \u0010Z\u001a\u00020F2\u0006\u0010[\u001a\u00020\u00122\u0006\u0010L\u001a\u00020M2\u0006\u0010O\u001a\u00020PH\u0002J\u0016\u0010\\\u001a\u00020F2\u0006\u0010L\u001a\u00020M2\u0006\u0010O\u001a\u00020PJ\u0012\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J\u0018\u0010a\u001a\u00020F2\u0006\u0010b\u001a\u00020I2\u0006\u0010L\u001a\u00020MH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\u001a\u00101\u001a\u000202X.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016R\u001a\u0010:\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R\u001a\u0010=\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001f\"\u0004\b?\u0010!R\u001f\u0010@\u001a\u0010\u0012\f\u0012\n B*\u0004\u0018\u00010\u00030\u00030A¢\u0006\b\n\u0000\u001a\u0004\bC\u0010D¨\u0006e"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "addContacListener", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$IListenerImpl;", "avatarIV", "Landroid/widget/ImageView;", "getAvatarIV", "()Landroid/widget/ImageView;", "setAvatarIV", "(Landroid/widget/ImageView;)V", "closeIv", "Landroid/view/View;", "getCloseIv", "()Landroid/view/View;", "setCloseIv", "(Landroid/view/View;)V", "closeLayout", "getCloseLayout", "setCloseLayout", "getContext", "()Landroid/content/Context;", "followAlready", "Landroid/widget/TextView;", "getFollowAlready", "()Landroid/widget/TextView;", "setFollowAlready", "(Landroid/widget/TextView;)V", "followArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getFollowArrow", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setFollowArrow", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "followType3", "Landroid/widget/Button;", "getFollowType3", "()Landroid/widget/Button;", "setFollowType3", "(Landroid/widget/Button;)V", "nickNameTV", "getNickNameTV", "setNickNameTV", "profileDescTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getProfileDescTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setProfileDescTv", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "profileLayout", "getProfileLayout", "setProfileLayout", "profileReasonTv", "getProfileReasonTv", "setProfileReasonTv", "recCardTitle", "getRecCardTitle", "setRecCardTitle", "weakContext", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getWeakContext", "()Ljava/lang/ref/WeakReference;", "attachRound", "", "iv", "brandURL", "", "btnFollow", ch.COL_USERNAME, "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "filling", "position", "", "convertView", "parent", "inflate", "inflateHeader", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "onAppMsgClick", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "order", "onUnLikeClick", "view", "refreshHeader", "shouldShowNegativeFeedback", "", "recCardUserInfo", "Lcom/tencent/mm/protocal/protobuf/TLRecCardUserInfo;", "viewContactProfile", "talker", "Companion", "IListenerImpl", "plugin-brandservice_release"})
public abstract class w extends ad {
    public static final a pvR = new a((byte) 0);
    final Context context;
    public ImageView gvv;
    final WeakReference<Context> ooi = new WeakReference<>(this.context);
    final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
    public TextView pvG;
    public TextView pvH;
    public View pvI;
    public View pvJ;
    public View pvK;
    public TextView pvL;
    public MMNeat7extView pvM;
    public Button pvN;
    public TextView pvO;
    public WeImageView pvP;
    private b pvQ = new b(this);

    public abstract void du(View view);

    public w(Context context2, com.tencent.mm.plugin.brandservice.ui.timeline.b bVar) {
        p.h(context2, "context");
        p.h(bVar, "adapter");
        this.context = context2;
        this.psQ = bVar;
    }

    public static final /* synthetic */ void a(w wVar, View view, z zVar, int i2) {
        boolean z = false;
        ege gAD = zVar.gAD();
        if (gAD == null) {
            Log.w("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] onUnLikeClick wrapper is null");
            return;
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.f fVar = wVar.psQ.pqZ;
        efz gAC = zVar.gAC();
        if (gAC == null) {
            p.hyc();
        }
        fVar.a(gAC.NfT.UserName, 0L, 0, 16, 0, gAD.MOC, true, 0);
        if (gAD.NfY == null || gAD.NfY.NfU == null || gAD.NfY.NfU.NfX == null || Util.isNullOrNil(gAD.NfY.NfU.NfX.KWr)) {
            z = true;
        }
        if (!Util.isNullOrNil(gAD.NfZ) || !z) {
            Context context2 = view.getContext();
            p.g(context2, "view.context");
            ((b) new b(context2, zVar, wVar.psQ, i2).hw(view)).show();
            return;
        }
        Log.w("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] onUnLikeClick negativeFeedbackReason is null");
    }

    public static final /* synthetic */ void b(w wVar, String str, z zVar) {
        Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] btnFollow");
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(wVar.context, new c(wVar));
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(160);
        aVar.a(str, linkedList, "");
        ege gAD = zVar.gAD();
        if (gAD != null) {
            wVar.psQ.pqZ.a(zVar.field_talker, 0L, 0, 22, 0, gAD.MOC, true, 0);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final TextView cmX() {
        TextView textView = this.pvL;
        if (textView == null) {
            p.btv("profileReasonTv");
        }
        return textView;
    }

    public final Button cmY() {
        Button button = this.pvN;
        if (button == null) {
            p.btv("followType3");
        }
        return button;
    }

    public final TextView cmZ() {
        TextView textView = this.pvO;
        if (textView == null) {
            p.btv("followAlready");
        }
        return textView;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public void a(z zVar, int i2, View view, View view2) {
        boolean z;
        p.h(zVar, "info");
        p.h(view, "convertView");
        p.h(view2, "parent");
        h.INSTANCE.idkeyStat(1149, 2, 1, false);
        du(view2);
        efz gAC = zVar.gAC();
        if ((gAC != null ? gAC.NfT : null) == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        p.h(zVar, "info");
        efz gAC2 = zVar.gAC();
        TextView textView = this.pvH;
        if (textView == null) {
            p.btv("recCardTitle");
        }
        textView.setText(gAC2.Lug);
        TextView textView2 = this.pvG;
        if (textView2 == null) {
            p.btv("nickNameTV");
        }
        if (textView2 == null) {
            p.hyc();
        }
        TextPaint paint = textView2.getPaint();
        p.g(paint, "tp");
        paint.setFakeBoldText(true);
        ImageView imageView = this.gvv;
        if (imageView == null) {
            p.btv("avatarIV");
        }
        if (imageView == null) {
            p.hyc();
        }
        String str = gAC2.NfT.KQY;
        p.g(str, "recCard.BizInfo.BrandIconUrl");
        c.a aVar = new c.a();
        aVar.tz(R.drawable.bar);
        aVar.bdq();
        aVar.bdt();
        q.bcV().a(str, imageView, aVar.bdv());
        TextView textView3 = this.pvG;
        if (textView3 == null) {
            p.btv("nickNameTV");
        }
        if (textView3 == null) {
            p.hyc();
        }
        textView3.setText(gAC2.NfT.oUJ);
        TextView textView4 = this.pvL;
        if (textView4 == null) {
            p.btv("profileReasonTv");
        }
        textView4.setText(gAC2.NfT.NfV);
        String str2 = gAC2.NfT.UserName;
        View view3 = this.pvK;
        if (view3 == null) {
            p.btv("profileLayout");
        }
        view3.setOnClickListener(new d(this, str2, zVar));
        ege gAD = zVar.gAD();
        if (gAD != null) {
            egd egd = gAC2.NfU;
            if (egd == null) {
                Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo = null");
                z = false;
            } else if (egd.NfX == null) {
                Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo = null");
                z = false;
            } else if (egd.NfX.KWs != 1) {
                Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.ShowNegativeFeedbackReason != 1");
                z = false;
            } else if (Util.isNullOrNil(egd.NfX.KWr)) {
                Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.NegativeFeedbackReason null");
                z = false;
            } else {
                z = true;
            }
            if (z || !Util.isNullOrNil(gAD.NfZ)) {
                Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] showNegativeFeedback，BizNickName = " + gAC2.NfT.oUJ);
                View view4 = this.pvI;
                if (view4 == null) {
                    p.btv("closeLayout");
                }
                view4.setVisibility(0);
                View view5 = this.pvI;
                if (view5 == null) {
                    p.btv("closeLayout");
                }
                view5.setOnClickListener(new e(this, zVar, i2));
            } else {
                Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] hideNegativeFeedback，BizNickName = " + gAC2.NfT.oUJ);
                View view6 = this.pvI;
                if (view6 == null) {
                    p.btv("closeLayout");
                }
                view6.setVisibility(8);
            }
            f fVar = new f(this, zVar, str2);
            TextView textView5 = this.pvO;
            if (textView5 == null) {
                p.btv("followAlready");
            }
            textView5.setVisibility(8);
            Button button = this.pvN;
            if (button == null) {
                p.btv("followType3");
            }
            button.setVisibility(8);
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str2);
            if (Kn == null || Kn.arH() <= 0) {
                ay.a.aVo().a(str2, "", null);
                fVar.invoke();
            } else if (!Kn.arv()) {
                fVar.invoke();
            } else if (Kn.arv()) {
                TextView textView6 = this.pvO;
                if (textView6 == null) {
                    p.btv("followAlready");
                }
                textView6.setVisibility(0);
            }
        }
    }

    public final void dv(View view) {
        p.h(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        View findViewById = view.findViewById(R.id.x1);
        if (findViewById == null) {
            throw new t("null cannot be cast to non-null type android.widget.ImageView");
        }
        this.gvv = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.fz_);
        if (findViewById2 == null) {
            throw new t("null cannot be cast to non-null type android.widget.TextView");
        }
        this.pvG = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.a6x);
        p.g(findViewById3, "header.findViewById(R.id.biz_rec_card_title)");
        this.pvH = (TextView) findViewById3;
        com.tencent.mm.plugin.brandservice.ui.b.d dVar = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
        TextView textView = this.pvH;
        if (textView == null) {
            p.btv("recCardTitle");
        }
        com.tencent.mm.plugin.brandservice.ui.b.d.i(textView);
        View findViewById4 = view.findViewById(R.id.b4i);
        p.g(findViewById4, "header.findViewById(R.id.close_layout)");
        this.pvI = findViewById4;
        View findViewById5 = view.findViewById(R.id.b4h);
        p.g(findViewById5, "header.findViewById(R.id.close_iv)");
        this.pvJ = findViewById5;
        View findViewById6 = view.findViewById(R.id.a6v);
        p.g(findViewById6, "header.findViewById(R.id…_rec_card_profile_layout)");
        this.pvK = findViewById6;
        View findViewById7 = view.findViewById(R.id.a6w);
        p.g(findViewById7, "header.findViewById(R.id.biz_rec_card_reason_tv)");
        this.pvL = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.a6j);
        p.g(findViewById8, "header.findViewById(R.id.biz_rec_card_desc_tv)");
        this.pvM = (MMNeat7extView) findViewById8;
        View findViewById9 = view.findViewById(R.id.ftl);
        ((WeImageView) findViewById9).setVisibility(0);
        p.g(findViewById9, "header.findViewById<WeIm…sibility = View.VISIBLE }");
        this.pvP = (WeImageView) findViewById9;
        View findViewById10 = view.findViewById(R.id.a6s);
        p.g(findViewById10, "header.findViewById(R.id…_rec_card_follow_already)");
        this.pvO = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.a6t);
        p.g(findViewById11, "header.findViewById(R.id…iz_rec_card_follow_type3)");
        this.pvN = (Button) findViewById11;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ String hLl;
        final /* synthetic */ z prL;
        final /* synthetic */ w pvT;

        d(w wVar, String str, z zVar) {
            this.pvT = wVar;
            this.hLl = str;
            this.prL = zVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195397);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            w wVar = this.pvT;
            String str = this.hLl;
            p.g(str, ch.COL_USERNAME);
            w.a(wVar, str, this.prL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195397);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ z prL;
        final /* synthetic */ w pvT;

        e(w wVar, z zVar, int i2) {
            this.pvT = wVar;
            this.prL = zVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195398);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            w wVar = this.pvT;
            View view2 = this.pvT.pvJ;
            if (view2 == null) {
                p.btv("closeIv");
            }
            w.a(wVar, view2, this.prL, this.gUj);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195398);
        }
    }

    public final void a(z zVar, ega ega, View view, int i2) {
        long j2;
        p.h(zVar, "info");
        if (!(ega == null || zVar.gAC() == null)) {
            efz gAC = zVar.gAC();
            if (gAC == null) {
                p.hyc();
            }
            if (gAC.NfT != null) {
                efz gAC2 = zVar.gAC();
                if (gAC2 == null) {
                    p.hyc();
                }
                egb egb = gAC2.NfT;
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
                if (ega.iAb == 5) {
                    com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.brandservice.a.b.class);
                    p.g(af, "MMKernel.service(IBrandService::class.java)");
                    if (((com.tencent.mm.plugin.brandservice.a.b) af).cld()) {
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
                }
                if (!((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1) || !((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.context, d2, ega.iAb, 138, 10000, intent)) {
                    com.tencent.mm.br.c.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
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
                    this.psQ.pqZ.a(zVar.field_talker, j2, i3, 15, 0, gAD.MOC, true, i2);
                }
                this.psQ.b(zVar, i2);
                return;
            }
        }
        Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "ok", "", "hasSentVerify", "respUsername", "", "googleItemID", "canAddContact"})
    public static final class c implements a.AbstractC2025a {
        final /* synthetic */ w pvT;

        c(w wVar) {
            this.pvT = wVar;
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
        public final void a(boolean z, boolean z2, String str, String str2) {
            AppMethodBeat.i(195396);
            p.h(str, "respUsername");
            p.h(str2, "googleItemID");
            if (!(!z || this.pvT.ooi == null || this.pvT.ooi.get() == null)) {
                this.pvT.cmZ().setVisibility(0);
                this.pvT.cmY().setVisibility(8);
            }
            AppMethodBeat.o(195396);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$IListenerImpl;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ModNewContactEvent;", "ref", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;)V", "value", "", ch.COL_USERNAME, "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "weakRef", "Ljava/lang/ref/WeakReference;", "callback", "", "event", "plugin-brandservice_release"})
    static final class b extends IListener<mp> {
        private final WeakReference<w> pvS;
        private String username = "";

        public b(w wVar) {
            p.h(wVar, "ref");
            AppMethodBeat.i(195395);
            this.pvS = new WeakReference<>(wVar);
            AppMethodBeat.o(195395);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mp mpVar) {
            w wVar;
            AppMethodBeat.i(195394);
            mp mpVar2 = mpVar;
            if (!(this.pvS == null || this.pvS.get() == null || mpVar2 == null || !p.j(this.username, mpVar2.dSe.username) || (wVar = this.pvS.get()) == null)) {
                wVar.cmZ().setVisibility(0);
            }
            AppMethodBeat.o(195394);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<no name provided>", "", "invoke"})
    public static final class f extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ String hLl;
        final /* synthetic */ z prL;
        final /* synthetic */ w pvT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(w wVar, z zVar, String str) {
            super(0);
            this.pvT = wVar;
            this.prL = zVar;
            this.hLl = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            ViewGroup.LayoutParams layoutParams;
            AppMethodBeat.i(195400);
            switch (this.prL.NQn.style) {
                case 3:
                case 5:
                    if (l.cmL()) {
                        this.pvT.cmY().setVisibility(0);
                        this.pvT.cmY().setOnClickListener(new View.OnClickListener(this) {
                            /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.w.f.AnonymousClass1 */
                            final /* synthetic */ f pvU;

                            {
                                this.pvU = r1;
                            }

                            public final void onClick(View view) {
                                AppMethodBeat.i(195399);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$showFollow$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                w wVar = this.pvU.pvT;
                                String str = this.pvU.hLl;
                                p.g(str, ch.COL_USERNAME);
                                w.b(wVar, str, this.pvU.prL);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$showFollow$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(195399);
                            }
                        });
                        ViewGroup.LayoutParams layoutParams2 = this.pvT.cmX().getLayoutParams();
                        if (!(layoutParams2 instanceof LinearLayout.LayoutParams)) {
                            layoutParams = null;
                        } else {
                            layoutParams = layoutParams2;
                        }
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
                        if (layoutParams3 != null) {
                            layoutParams3.setMargins(com.tencent.mm.cb.a.fromDPToPix(this.pvT.context, 8), 0, com.tencent.mm.cb.a.fromDPToPix(this.pvT.context, 80), 0);
                        }
                        this.pvT.cmX().setLayoutParams(layoutParams2);
                        break;
                    }
                    break;
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195400);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(w wVar, String str, z zVar) {
        ege gAD = zVar.gAD();
        if (gAD == null) {
            Log.w("MicroMsg.BizTimeLineItem", "viewContactProfile wrapper is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        intent.putExtra("Contact_Scene", 160);
        intent.putExtra("KBizRecCardId", gAD.MOC);
        intent.putExtra("force_get_contact", true);
        intent.putExtra("key_use_new_contact_profile", true);
        com.tencent.mm.br.c.b(wVar.context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        h.INSTANCE.idkeyStat(1149, 3, 1, false);
        wVar.psQ.pqZ.a(str, 0L, 0, 13, 0, gAD.MOC, true, 0);
    }
}
