package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010?\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH&J\u0006\u0010E\u001a\u00020\u000bJ\u0018\u0010F\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010G\u001a\u00020HH\u0016J\u0006\u0010I\u001a\u00020\u000bJ\u0016\u0010J\u001a\u00020K2\u0006\u0010C\u001a\u00020D2\u0006\u0010L\u001a\u00020MJ*\u0010N\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020B2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010O\u001a\u0004\u0018\u00010\u00112\u0006\u0010P\u001a\u00020HJ\u001e\u0010Q\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010L\u001a\u00020MJ\u0016\u0010R\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020B2\u0006\u0010L\u001a\u00020MJ\u001e\u0010S\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010L\u001a\u00020MJ\u0016\u0010T\u001a\u00020K*\u00020B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010DR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u001c\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u0010\u0015R\u001c\u00109\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010*\"\u0004\b;\u0010,R\u001c\u0010<\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00103\"\u0004\b>\u00105¨\u0006U"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "clickCallback", "Lkotlin/Function0;", "", "getClickCallback", "()Lkotlin/jvm/functions/Function0;", "setClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "clickView", "Landroid/view/View;", "getClickView", "()Landroid/view/View;", "setClickView", "(Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "friendReadTv", "Landroid/widget/TextView;", "getFriendReadTv", "()Landroid/widget/TextView;", "setFriendReadTv", "(Landroid/widget/TextView;)V", "itemView", "getItemView", "setItemView", "pressMask", "Landroid/widget/ImageView;", "getPressMask", "()Landroid/widget/ImageView;", "setPressMask", "(Landroid/widget/ImageView;)V", "singleDigest", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getSingleDigest", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setSingleDigest", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "singleTitle", "getSingleTitle", "setSingleTitle", "singleTitleLayout", "Landroid/widget/LinearLayout;", "getSingleTitleLayout", "()Landroid/widget/LinearLayout;", "setSingleTitleLayout", "(Landroid/widget/LinearLayout;)V", "statLayout", "getStatLayout", "setStatLayout", "title", "getTitle", "setTitle", "titleLayout", "getTitleLayout", "setTitleLayout", "filling", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "inflate", "id", "", "inflateStatLayout", "needRoundBottom", "", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "onAppMsgClick", "convertView", "order", "refreshClickView", "refreshFriendInfo", "refreshTitle", "isSingleMsg", "plugin-brandservice_release"})
public abstract class f {
    View aus;
    final Context context;
    final b psQ;
    View ptQ;
    MMNeat7extView ptR;
    ImageView ptS;
    LinearLayout ptT;
    LinearLayout ptU;
    MMNeat7extView ptV;
    MMNeat7extView ptW;
    private View ptX;
    TextView ptY;
    kotlin.g.a.a<x> ptZ;

    public f(Context context2, b bVar) {
        p.h(context2, "context");
        p.h(bVar, "adapter");
        this.context = context2;
        this.psQ = bVar;
    }

    public void U(View view, int i2) {
        p.h(view, "parent");
        if (this.aus == null) {
            this.aus = ((ViewStub) view.findViewById(i2)).inflate();
        }
    }

    public final void cmH() {
        View view;
        TextView textView;
        if (this.aus != null) {
            View view2 = this.aus;
            if (view2 != null) {
                view = view2.findViewById(R.id.i4r);
            } else {
                view = null;
            }
            this.ptX = view;
            View view3 = this.aus;
            if (view3 != null) {
                textView = (TextView) view3.findViewById(R.id.daz);
            } else {
                textView = null;
            }
            this.ptY = textView;
        }
    }

    public final void hide() {
        View view = this.aus;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void a(z zVar, pj pjVar, pi piVar) {
        p.h(zVar, "info");
        p.h(pjVar, "bizInfo");
        p.h(piVar, "appMsg");
        MMNeat7extView mMNeat7extView = this.ptR;
        if (mMNeat7extView != null) {
            mMNeat7extView.setTextColor(this.context.getResources().getColor(R.color.wu));
        }
        LinearLayout linearLayout = this.ptT;
        if (linearLayout != null) {
            linearLayout.setBackgroundResource(R.drawable.aij);
        }
        TextView textView = this.ptY;
        if (textView != null) {
            textView.setTextColor(this.context.getResources().getColor(R.color.wu));
        }
        if (a(zVar, pjVar)) {
            LinearLayout linearLayout2 = this.ptU;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            MMNeat7extView mMNeat7extView2 = this.ptR;
            if (mMNeat7extView2 != null) {
                mMNeat7extView2.setVisibility(8);
            }
            MMNeat7extView mMNeat7extView3 = this.ptV;
            if (mMNeat7extView3 != null) {
                mMNeat7extView3.setMaxLines(2);
                mMNeat7extView3.aw(piVar.Title);
                d dVar = d.pMy;
                if (d.crj()) {
                    d dVar2 = d.pMy;
                    d.c(mMNeat7extView3);
                    return;
                }
                return;
            }
            return;
        }
        LinearLayout linearLayout3 = this.ptU;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        MMNeat7extView mMNeat7extView4 = this.ptR;
        if (mMNeat7extView4 != null) {
            mMNeat7extView4.setVisibility(0);
        }
        MMNeat7extView mMNeat7extView5 = this.ptR;
        if (mMNeat7extView5 != null) {
            mMNeat7extView5.aw(piVar.Title);
        }
        d dVar3 = d.pMy;
        d.c(this.ptR);
    }

    public final void a(z zVar, pi piVar) {
        p.h(zVar, "info");
        p.h(piVar, "appMsg");
        MMNeat7extView mMNeat7extView = this.ptW;
        if (mMNeat7extView != null) {
            mMNeat7extView.setVisibility(8);
        }
        View view = this.ptX;
        if (view != null) {
            view.setVisibility(8);
        }
        if (a(zVar, (pj) null)) {
            if (!Util.isNullOrNil(piVar.xLi)) {
                MMNeat7extView mMNeat7extView2 = this.ptW;
                if (mMNeat7extView2 != null) {
                    mMNeat7extView2.setVisibility(0);
                }
                MMNeat7extView mMNeat7extView3 = this.ptW;
                if (mMNeat7extView3 != null) {
                    mMNeat7extView3.aw(piVar.xLi);
                }
            }
        } else if (!Util.isNullOrNil(piVar.xLi)) {
            View view2 = this.ptX;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            LinearLayout linearLayout = this.ptT;
            if (linearLayout != null) {
                linearLayout.setBackgroundResource(R.drawable.in);
            }
            TextView textView = this.ptY;
            if (textView != null) {
                textView.setText(piVar.xLi);
            }
        }
    }

    public final void b(z zVar, pj pjVar, pi piVar) {
        ImageView imageView;
        p.h(zVar, "info");
        p.h(pjVar, "bizInfo");
        p.h(piVar, "appMsg");
        if (a(zVar, pjVar)) {
            View view = this.ptQ;
            if (view != null) {
                view.setBackgroundResource(R.drawable.i1);
            }
            View view2 = this.ptQ;
            if (view2 != null) {
                View view3 = this.ptQ;
                int paddingLeft = view3 != null ? view3.getPaddingLeft() : 0;
                View view4 = this.ptQ;
                view2.setPadding(paddingLeft, 0, view4 != null ? view4.getPaddingRight() : 0, b.pry);
            }
        } else {
            View view5 = this.ptQ;
            if (view5 != null) {
                view5.setBackgroundResource(R.drawable.i7);
            }
            View view6 = this.ptQ;
            if (view6 != null) {
                View view7 = this.ptQ;
                int paddingLeft2 = view7 != null ? view7.getPaddingLeft() : 0;
                View view8 = this.ptQ;
                view6.setPadding(paddingLeft2, 0, view8 != null ? view8.getPaddingRight() : 0, 0);
            }
        }
        ImageView imageView2 = this.ptS;
        if (imageView2 != null) {
            imageView2.setBackgroundResource(R.drawable.hz);
        }
        View view9 = this.ptQ;
        if (view9 != null) {
            view9.setOnClickListener(new a(this, zVar, piVar));
        }
        if (a(pjVar, piVar) && (imageView = this.ptS) != null) {
            imageView.setBackgroundResource(R.drawable.hx);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ z prL;
        final /* synthetic */ pi ptK;
        final /* synthetic */ f pua;

        a(f fVar, z zVar, pi piVar) {
            this.pua = fVar;
            this.prL = zVar;
            this.ptK = piVar;
        }

        public final void onClick(View view) {
            long j2;
            AppMethodBeat.i(195271);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView$refreshClickView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a<x> aVar = this.pua.ptZ;
            if (aVar != null) {
                aVar.invoke();
            }
            f fVar = this.pua;
            z zVar = this.prL;
            pi piVar = this.ptK;
            p.h(zVar, "info");
            if (!(piVar == null || zVar.gAC() == null)) {
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
                    Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", piVar.KSj);
                    Intent intent = new Intent();
                    String d2 = m.d(piVar.KSj, 169, 10000, 0);
                    intent.putExtra("rawUrl", d2);
                    intent.putExtra("geta8key_scene", 56);
                    intent.putExtra("geta8key_username", egb.UserName);
                    intent.putExtra("srcUsername", egb.UserName);
                    intent.putExtra("srcDisplayname", egb.oUJ);
                    intent.putExtra("prePublishId", "rec_card");
                    intent.putExtra("KPublisherId", "rec_card");
                    if (piVar.iAb == 5) {
                        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.brandservice.a.b.class);
                        p.g(af, "MMKernel.service(IBrandService::class.java)");
                        if (((com.tencent.mm.plugin.brandservice.a.b) af).cld()) {
                            intent.putExtra(e.b.OyQ, 169);
                            intent.putExtra(e.b.OyR, 10000);
                            intent.putExtra("biz_video_session_id", ab.getSessionId());
                            com.tencent.mm.ag.x xVar = new com.tencent.mm.ag.x();
                            xVar.iAh = intent.getStringExtra("KPublisherId");
                            xVar.dHc = egb.UserName;
                            xVar.iAg = egb.oUJ;
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
                    if (!((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1) || !((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(fVar.context, d2, piVar.iAb, 169, 10000, intent)) {
                        c.b(fVar.context, "webview", ".ui.tools.WebViewUI", intent);
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
                        com.tencent.mm.plugin.brandservice.ui.timeline.f.a(gAD);
                        fVar.psQ.pqZ.a(zVar.field_talker, j2, i2, 15, gAD.MOC, "", 0, gAD.Nga.KUo, gAD.event, gAD.Nga.KUk, piVar.KWv, gAD.style, piVar.KWw);
                    }
                    fVar.psQ.b(zVar, 0);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView$refreshClickView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(195271);
                }
            }
            Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView$refreshClickView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195271);
        }
    }

    private static boolean a(pj pjVar, pi piVar) {
        p.h(pjVar, "bizInfo");
        p.h(piVar, "appMsg");
        int size = pjVar.KWy.size();
        return size <= 1 && size == 1 && !Util.isNullOrNil(piVar.KSh);
    }

    private static boolean a(z zVar, pj pjVar) {
        int i2;
        pj pjVar2;
        boolean z = true;
        p.h(zVar, "$this$isSingleMsg");
        switch (zVar.gAD().style) {
            case 101:
                if (pjVar == null) {
                    pjVar2 = zVar.gAD().Nga.KUf.get(0);
                } else {
                    pjVar2 = pjVar;
                }
                return pjVar2.KWy.size() <= 1;
            case 102:
                LinkedList<pj> linkedList = zVar.gAD().Nga.KUf;
                p.g(linkedList, "tlRecCardWrapper.extraInfo.BizInfo");
                int i3 = 0;
                int i4 = 0;
                for (Object obj : j.b(linkedList, 2)) {
                    int i5 = i3 + 1;
                    if (i3 < 0) {
                        j.hxH();
                    }
                    if (((pj) obj).KHa == 0) {
                        i2 = i4 + 1;
                    } else {
                        i2 = i4;
                    }
                    i3 = i5;
                    i4 = i2;
                }
                if (i4 >= 2) {
                    z = false;
                }
                return z;
            default:
                return false;
        }
    }
}
