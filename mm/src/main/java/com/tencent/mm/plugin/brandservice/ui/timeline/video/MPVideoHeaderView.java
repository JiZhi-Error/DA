package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.v;
import com.tencent.mm.ag.x;
import com.tencent.mm.aj.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.protocal.protobuf.fp;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010+\u001a\u00020,H\u0002J\u0016\u0010-\u001a\u00020,2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010.\u001a\u00020,J\u0006\u0010/\u001a\u00020,J\b\u00100\u001a\u00020,H\u0002J\u000e\u00101\u001a\u00020,2\u0006\u00102\u001a\u000203J\u000e\u00104\u001a\u00020,2\u0006\u00102\u001a\u000205J\u000e\u00106\u001a\u00020,2\u0006\u0010\t\u001a\u00020\nJ\u000e\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020*J\b\u00109\u001a\u00020,H\u0002J\u000e\u0010:\u001a\u00020,2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X.¢\u0006\u0002\n\u0000¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "appMsgStat", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgStat;", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/widget/LinearLayout;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "dataLayout", "Landroid/view/View;", "descLayout", "descMoreLayout", "descTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "haoKanTv", "Landroid/widget/TextView;", "haokanCountTv", "haokanTipsIcon", "haokanTipsLayout", "haokanTipsShareTv", "maliciousTipsTv", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "needShowHaokanView", "", "nicknameTv", "readCountTv", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "talker", "timeTv", "titleTv", "writeCommentLayout", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "initAvatarNickName", "", "initData", "initView", "onAppMsgLike", "setDesc", "setMaliciousInfo", "info", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setOriginInfo", "Lcom/tencent/mm/protocal/protobuf/AppMsgExtBaseAppMsgInfo;", "setWow", "setWriteCommentLayout", "layout", "showHaoKanView", "update", "plugin-brandservice_release"})
public final class MPVideoHeaderView extends RelativeLayout {
    private final String TAG = "MicroMsg.MPVideoHeaderView";
    private ImageView gyr;
    private x pHv;
    private boolean pIK;
    private b pIL;
    private LinearLayout pIM;
    private TextView pIN;
    private MMNeat7extView pIO;
    private MMNeat7extView pIP;
    private View pIQ;
    private View pIR;
    private TextView pIS;
    private TextView pIT;
    private TextView pIU;
    private TextView pIV;
    private View pIW;
    private TextView pIX;
    private ImageView pIY;
    private View pIZ;
    private n pJa;
    private v ptH;
    private String talker = "";
    private TextView timeTv;

    public static final /* synthetic */ b e(MPVideoHeaderView mPVideoHeaderView) {
        AppMethodBeat.i(7264);
        b bVar = mPVideoHeaderView.pIL;
        if (bVar == null) {
            p.btv("controller");
        }
        AppMethodBeat.o(7264);
        return bVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MPVideoHeaderView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(7263);
        View.inflate(context, R.layout.bbu, this);
        View findViewById = findViewById(R.id.a9b);
        p.g(findViewById, "findViewById(R.id.biz_video_avatar_layout)");
        this.pIM = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.a9a);
        p.g(findViewById2, "findViewById(R.id.biz_video_avatar_iv)");
        this.gyr = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.a9w);
        p.g(findViewById3, "findViewById(R.id.biz_video_nick_name_tv)");
        this.pIN = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.a_5);
        p.g(findViewById4, "findViewById(R.id.biz_video_title_tv)");
        this.pIO = (MMNeat7extView) findViewById4;
        View findViewById5 = findViewById(R.id.a9o);
        p.g(findViewById5, "findViewById(R.id.biz_video_desc_tv)");
        this.pIP = (MMNeat7extView) findViewById5;
        View findViewById6 = findViewById(R.id.a9n);
        p.g(findViewById6, "findViewById(R.id.biz_video_desc_show_more_layout)");
        this.pIQ = findViewById6;
        View findViewById7 = findViewById(R.id.a9m);
        p.g(findViewById7, "findViewById(R.id.biz_video_desc_layout)");
        this.pIR = findViewById7;
        View findViewById8 = findViewById(R.id.a_3);
        p.g(findViewById8, "findViewById(R.id.biz_video_time_tv)");
        this.timeTv = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.a_0);
        p.g(findViewById9, "findViewById(R.id.biz_video_read_count_tv)");
        this.pIS = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.a9r);
        p.g(findViewById10, "findViewById(R.id.biz_video_haokan_tv)");
        this.pIT = (TextView) findViewById10;
        View findViewById11 = findViewById(R.id.a9q);
        p.g(findViewById11, "findViewById(R.id.biz_video_haokan_count_tv)");
        this.pIU = (TextView) findViewById11;
        View findViewById12 = findViewById(R.id.a9t);
        p.g(findViewById12, "findViewById(R.id.biz_video_malicious_tips)");
        this.pIV = (TextView) findViewById12;
        View findViewById13 = findViewById(R.id.a_9);
        p.g(findViewById13, "findViewById(R.id.biz_video_write_wow_tips_layout)");
        this.pIW = findViewById13;
        View findViewById14 = findViewById(R.id.a__);
        p.g(findViewById14, "findViewById(R.id.biz_vi…_write_wow_tips_share_tv)");
        this.pIX = (TextView) findViewById14;
        View findViewById15 = findViewById(R.id.a_8);
        p.g(findViewById15, "findViewById(R.id.biz_video_write_wow_tips_icon)");
        this.pIY = (ImageView) findViewById15;
        View findViewById16 = findViewById(R.id.a9s);
        p.g(findViewById16, "findViewById(R.id.biz_video_header_data_layout)");
        this.pIZ = findViewById16;
        TextPaint paint = this.pIO.getPaint();
        p.g(paint, "tp");
        paint.setFakeBoldText(true);
        this.pIM.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView.AnonymousClass1 */
            final /* synthetic */ MPVideoHeaderView pJb;

            {
                this.pJb = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(7254);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if ((MPVideoHeaderView.e(this.pJb).iwg & 1) != 0) {
                    Log.w(this.pJb.TAG, "not allow jump to profile " + MPVideoHeaderView.e(this.pJb).iwg);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(7254);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", this.pJb.talker);
                intent.putExtra("Contact_Scene", 152);
                com.tencent.mm.br.c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(7254);
            }
        });
        AppMethodBeat.o(7263);
    }

    public final void setMaliciousInfo(cmb cmb) {
        AppMethodBeat.i(7259);
        p.h(cmb, "info");
        this.pIV.setVisibility(0);
        this.pIV.setText(cmb.Mrt);
        AppMethodBeat.o(7259);
    }

    public final void setOriginInfo(fp fpVar) {
        int i2;
        String str;
        String str2;
        String str3;
        String str4 = null;
        AppMethodBeat.i(7260);
        p.h(fpVar, "info");
        v vVar = this.ptH;
        if (vVar == null) {
            p.btv("readerItem");
        }
        vVar.title = fpVar.title;
        v vVar2 = this.ptH;
        if (vVar2 == null) {
            p.btv("readerItem");
        }
        vVar2.iAq = fpVar.iAq;
        a.b.d(this.gyr, this.talker);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(this.talker);
        if (Kn == null || Kn.arH() <= 0) {
            x xVar = this.pHv;
            if (xVar == null) {
                p.btv("msgInfo");
            }
            String str5 = xVar != null ? xVar.iAg : null;
            ImageView imageView = this.gyr;
            x xVar2 = this.pHv;
            if (xVar2 == null) {
                p.btv("msgInfo");
            }
            if (xVar2 != null) {
                str = xVar2.ajO();
            } else {
                str = null;
            }
            imageView.setTag(str);
            WeakReference weakReference = new WeakReference(this.gyr);
            ay.b aVo = ay.a.aVo();
            x xVar3 = this.pHv;
            if (xVar3 == null) {
                p.btv("msgInfo");
            }
            if (xVar3 != null) {
                str4 = xVar3.ajO();
            }
            aVo.a(str4, "", new a(weakReference));
            str4 = str5;
        } else {
            if (!Kn.arv()) {
                MMHandlerThread.postToMainThreadDelayed(new b(this, Kn), 200);
            }
            x xVar4 = this.pHv;
            if (xVar4 == null) {
                p.btv("msgInfo");
            }
            if (xVar4 != null) {
                str2 = xVar4.ajO();
            } else {
                str2 = null;
            }
            String displayName = aa.getDisplayName(str2);
            if (Util.isEqual(displayName, this.talker)) {
                x xVar5 = this.pHv;
                if (xVar5 == null) {
                    p.btv("msgInfo");
                }
                if (xVar5 != null) {
                    str3 = xVar5.iAg;
                } else {
                    str3 = null;
                }
                if (!Util.isNullOrNil(str3)) {
                    x xVar6 = this.pHv;
                    if (xVar6 == null) {
                        p.btv("msgInfo");
                    }
                    if (xVar6 != null) {
                        str4 = xVar6.iAg;
                    }
                }
            }
            str4 = displayName;
        }
        SpannableString b2 = com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), str4 + "  ", this.pIN.getTextSize());
        Context context = getContext();
        p.g(context, "context");
        Drawable drawable = context.getResources().getDrawable(R.drawable.c0b);
        int textSize = (int) this.pIN.getTextSize();
        drawable.setBounds(0, 0, textSize / 2, textSize);
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
        SpannableString spannableString = new SpannableString("@");
        spannableString.setSpan(aVar, 0, 1, 33);
        this.pIN.setText(TextUtils.concat(b2, spannableString));
        TextView textView = this.timeTv;
        Context context2 = getContext();
        x xVar7 = this.pHv;
        if (xVar7 == null) {
            p.btv("msgInfo");
        }
        textView.setText(com.tencent.mm.plugin.brandservice.ui.b.b.f(context2, xVar7.iAi.time * 1000));
        v vVar3 = this.ptH;
        if (vVar3 == null) {
            p.btv("readerItem");
        }
        if (Util.isNullOrNil(vVar3.iAq)) {
            this.pIR.setVisibility(8);
        } else {
            this.pIR.setVisibility(0);
            MMNeat7extView mMNeat7extView = this.pIP;
            v vVar4 = this.ptH;
            if (vVar4 == null) {
                p.btv("readerItem");
            }
            if (vVar4 == null) {
                p.hyc();
            }
            mMNeat7extView.aw(vVar4.iAq);
            com.tencent.neattextview.textview.layout.a mq = this.pIP.mq(com.tencent.mm.cb.a.jn(getContext()) - com.tencent.mm.cb.a.fromDPToPix(getContext(), 32), Integer.MAX_VALUE);
            if (mq != null) {
                i2 = mq.hiG();
            } else {
                i2 = 0;
            }
            if (i2 > 4) {
                float textSize2 = this.pIP.getTextSize();
                this.pIP.a(TextUtils.TruncateAt.END, textSize2);
                this.pIQ.setMinimumHeight((int) textSize2);
                this.pIQ.setVisibility(0);
                this.pIP.setMaxLines(4);
                this.pIR.setOnClickListener(new c(this));
            }
        }
        MMNeat7extView mMNeat7extView2 = this.pIO;
        x xVar8 = this.pHv;
        if (xVar8 == null) {
            p.btv("msgInfo");
        }
        mMNeat7extView2.aw(xVar8.iAi.title);
        AppMethodBeat.o(7260);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ MPVideoHeaderView pJb;

        c(MPVideoHeaderView mPVideoHeaderView) {
            this.pJb = mPVideoHeaderView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(7257);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$setDesc$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.pJb.pIQ.setVisibility(8);
            this.pJb.pIP.setMaxLines(Integer.MAX_VALUE);
            this.pJb.pIP.requestLayout();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$setDesc$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(7257);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", ch.COL_USERNAME, "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
    static final class a implements ay.b.a {
        final /* synthetic */ WeakReference pJc;

        a(WeakReference weakReference) {
            this.pJc = weakReference;
        }

        @Override // com.tencent.mm.model.ay.b.a
        public final void p(String str, boolean z) {
            AppMethodBeat.i(7255);
            ImageView imageView = (ImageView) this.pJc.get();
            if (imageView == null) {
                AppMethodBeat.o(7255);
                return;
            }
            p.g(imageView, "weakReference.get() ?: return@GetContactCallBack");
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
            if (Kn == null || Kn.arH() <= 0) {
                AppMethodBeat.o(7255);
                return;
            }
            if (imageView.getTag() instanceof String) {
                com.tencent.mm.aj.p.aYD().Mg(str);
                Object tag = imageView.getTag();
                if (tag == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(7255);
                    throw tVar;
                } else if (Util.isEqual((String) tag, str)) {
                    i Mx = com.tencent.mm.aj.p.aYB().Mx(str);
                    if (Mx == null || Util.isNullOrNil(Mx.aYu())) {
                        a.b.d(imageView, str);
                    } else {
                        com.tencent.mm.plugin.brandservice.b.d.a(imageView, Kn, Mx.aYu(), true);
                        AppMethodBeat.o(7255);
                        return;
                    }
                }
            }
            AppMethodBeat.o(7255);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ MPVideoHeaderView pJb;
        final /* synthetic */ as pJd;

        b(MPVideoHeaderView mPVideoHeaderView, as asVar) {
            this.pJb = mPVideoHeaderView;
            this.pJd = asVar;
        }

        public final void run() {
            i Mx;
            AppMethodBeat.i(7256);
            if (com.tencent.mm.aj.c.Mc(this.pJb.talker) == null && (Mx = com.tencent.mm.aj.p.aYB().Mx(this.pJb.talker)) != null && !Util.isNullOrNil(Mx.aYu())) {
                com.tencent.mm.plugin.brandservice.b.d.a(this.pJb.gyr, this.pJd, Mx.aYu(), true);
            }
            AppMethodBeat.o(7256);
        }
    }

    public final void setWow(nl nlVar) {
        int i2;
        AppMethodBeat.i(7261);
        p.h(nlVar, "appMsgStat");
        if (nlVar.KST != 1) {
            this.pIT.setVisibility(8);
            this.pIU.setVisibility(8);
            AppMethodBeat.o(7261);
            return;
        }
        this.pIT.setVisibility(0);
        this.pIU.setVisibility(0);
        if (nlVar.KSS == 1) {
            this.pIT.setTextColor(getResources().getColor(R.color.fj));
            this.pIU.setTextColor(getResources().getColor(R.color.fj));
            i2 = R.drawable.c0o;
        } else {
            this.pIT.setTextColor(getResources().getColor(R.color.fl));
            this.pIU.setTextColor(getResources().getColor(R.color.fl));
            i2 = R.drawable.c0n;
        }
        String string = getContext().getString(R.string.ajd);
        p.g(string, "context.getString(R.string.biz_video_haokan)");
        if (nlVar.KSR > 0) {
            this.pIU.setVisibility(0);
            TextView textView = this.pIU;
            Context context = getContext();
            p.g(context, "context");
            textView.setText(String.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.T(context, nlVar.KSR)));
        } else {
            this.pIU.setText("");
            this.pIU.setVisibility(4);
        }
        Context context2 = getContext();
        p.g(context2, "context");
        Drawable drawable = context2.getResources().getDrawable(i2);
        int textSize = (int) (((double) this.pIN.getTextSize()) * 1.3d);
        drawable.setBounds(0, 0, textSize, textSize);
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
        SpannableString spannableString = new SpannableString("@");
        spannableString.setSpan(aVar, 0, 1, 33);
        this.pIT.setText(TextUtils.concat(spannableString, " ", string));
        this.pIT.setOnClickListener(new d(this, nlVar));
        AppMethodBeat.o(7261);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ MPVideoHeaderView pJb;
        final /* synthetic */ nl pJe;

        d(MPVideoHeaderView mPVideoHeaderView, nl nlVar) {
            this.pJb = mPVideoHeaderView;
            this.pJe = nlVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(7258);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$setWow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.pJe.KSS == 1) {
                MPVideoHeaderView.e(this.pJb).aJ(2, "");
            } else {
                MPVideoHeaderView.e(this.pJb).aJ(1, "");
                this.pJb.pIK = true;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$setWow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(7258);
        }
    }

    public final void setWriteCommentLayout(n nVar) {
        AppMethodBeat.i(7262);
        p.h(nVar, "layout");
        this.pJa = nVar;
        AppMethodBeat.o(7262);
    }
}
