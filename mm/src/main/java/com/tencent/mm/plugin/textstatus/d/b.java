package com.tencent.mm.plugin.textstatus.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.plugin.textstatus.d.d;
import com.tencent.mm.plugin.textstatus.g.r;
import com.tencent.mm.plugin.textstatus.g.v;
import com.tencent.mm.plugin.textstatus.g.w;
import com.tencent.mm.plugin.textstatus.g.y;
import com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010z\u001a\u00020{2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010|\u001a\u00020{2\u0006\u0010t\u001a\u00020TH\u0002J\u0006\u0010}\u001a\u00020{J\u0010\u0010~\u001a\u00020{2\u0006\u0010\u001a\u00020\"H\u0016J4\u0010\u0001\u001a\u00020{2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010T2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020{2\u0007\u0010\u0001\u001a\u00020FH\u0016J\u0015\u0010\u0001\u001a\u00020{2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0012\u0010\u0001\u001a\u00030\u00012\u0006\u0010t\u001a\u00020TH\u0016J\u001d\u0010\u0001\u001a\u00030\u00012\u0006\u0010t\u001a\u00020T2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0016H\u0016J\t\u0010\u0001\u001a\u00020{H\u0003J\u0013\u0010\u0001\u001a\u00020{2\b\u0010\u0001\u001a\u00030\u0001H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u001c\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010$\"\u0004\b>\u0010&R\u001c\u0010?\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010$\"\u0004\bA\u0010&R\u001c\u0010B\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010$\"\u0004\bD\u0010&R\u001a\u0010E\u001a\u00020FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010Y\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001c\u0010_\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\\\"\u0004\ba\u0010^R\u001a\u0010b\u001a\u00020ZX.¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\\\"\u0004\bd\u0010^R\u001c\u0010e\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\\\"\u0004\bg\u0010^R\u001c\u0010h\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\\\"\u0004\bj\u0010^R\u001c\u0010k\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\\\"\u0004\bm\u0010^R\u001c\u0010n\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\\\"\u0004\bp\u0010^R\u001c\u0010q\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\\\"\u0004\bs\u0010^R\u001c\u0010t\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010V\"\u0004\bv\u0010XR\u001c\u0010w\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\t\"\u0004\by\u0010\u000b¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic;", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "(Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;)V", "btnLike", "Landroid/widget/ImageView;", "getBtnLike", "()Landroid/widget/ImageView;", "setBtnLike", "(Landroid/widget/ImageView;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "iconStatus", "getIconStatus", "setIconStatus", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "ivBrand", "getIvBrand", "setIvBrand", "ivNick", "getIvNick", "setIvNick", "ivSecurityClose", "Landroid/view/View;", "getIvSecurityClose", "()Landroid/view/View;", "setIvSecurityClose", "(Landroid/view/View;)V", "lastPopupLikeDismissTime", "", "getLastPopupLikeDismissTime", "()J", "setLastPopupLikeDismissTime", "(J)V", "layoutAvatarSameFriends", "Landroid/widget/LinearLayout;", "getLayoutAvatarSameFriends", "()Landroid/widget/LinearLayout;", "setLayoutAvatarSameFriends", "(Landroid/widget/LinearLayout;)V", "layoutBrand", "getLayoutBrand", "setLayoutBrand", "layoutBrandSpecialLayout", "Landroid/widget/FrameLayout;", "getLayoutBrandSpecialLayout", "()Landroid/widget/FrameLayout;", "setLayoutBrandSpecialLayout", "(Landroid/widget/FrameLayout;)V", "layoutCardContent", "getLayoutCardContent", "setLayoutCardContent", "layoutLike", "getLayoutLike", "setLayoutLike", "layoutSecurity", "getLayoutSecurity", "setLayoutSecurity", "loadParam", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$LoadLogicParam;", "getLoadParam", "()Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$LoadLogicParam;", "setLoadParam", "(Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$LoadLogicParam;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "getShowParam", "()Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "statusId", "", "getStatusId", "()Ljava/lang/String;", "setStatusId", "(Ljava/lang/String;)V", "tvBrand", "Landroid/widget/TextView;", "getTvBrand", "()Landroid/widget/TextView;", "setTvBrand", "(Landroid/widget/TextView;)V", "tvDesc", "getTvDesc", "setTvDesc", "tvLikeNum", "getTvLikeNum", "setTvLikeNum", "tvNick", "getTvNick", "setTvNick", "tvPoi", "getTvPoi", "setTvPoi", "tvSameFriendsTips", "getTvSameFriendsTips", "setTvSameFriendsTips", "tvSecurity", "getTvSecurity", "setTvSecurity", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", ch.COL_USERNAME, "getUsername", "setUsername", "vBack", "getVBack", "setVBack", "handleBrand", "", "handleLike", "handleSecurity", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "contentView", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setLoadLogicParam", "loadLogicParam", "setThumb", "bitmap", "Landroid/graphics/Bitmap;", "update", "", "item", "updateLikeNum", "updateOtherUserLocalState", "isLike", "Companion", "plugin-textstatus_release"})
public class b implements i, d {
    public static final a FYB = new a((byte) 0);
    final n FYA;
    private TextView FYd;
    private TextView FYe;
    private String FYf = "";
    TextView FYg;
    private ImageView FYh;
    private View FYi;
    private TextView FYj;
    private LinearLayout FYk;
    private LinearLayout FYl;
    private ImageView FYm;
    private TextView FYn;
    public ImageView FYo;
    private ImageView FYp;
    public TextView FYq;
    private ImageView FYr;
    private TextView FYs;
    FrameLayout FYt;
    private TextView FYu;
    View FYv;
    private View FYw;
    com.tencent.mm.plugin.textstatus.f.f.a FYx;
    long FYy;
    private d.a FYz = new d.a();
    private View Vdw;
    public Context context;
    private String username;

    static {
        AppMethodBeat.i(216152);
        AppMethodBeat.o(216152);
    }

    public b(n nVar) {
        p.h(nVar, "showParam");
        AppMethodBeat.i(216151);
        this.FYA = nVar;
        AppMethodBeat.o(216151);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final Context getContext() {
        AppMethodBeat.i(216141);
        Context context2 = this.context;
        if (context2 == null) {
            p.btv("context");
        }
        AppMethodBeat.o(216141);
        return context2;
    }

    @Override // com.tencent.mm.plugin.textstatus.d.d
    public void ba(View view) {
        AppMethodBeat.i(216142);
        p.h(view, "contentView");
        Context context2 = view.getContext();
        p.g(context2, "contentView.context");
        this.context = context2;
        this.FYd = (TextView) view.findViewById(R.id.iyr);
        this.FYg = (TextView) view.findViewById(R.id.iyd);
        this.FYe = (TextView) view.findViewById(R.id.ix3);
        this.FYj = (TextView) view.findViewById(R.id.iy7);
        View findViewById = view.findViewById(R.id.aew);
        p.g(findViewById, "contentView.findViewById(R.id.btn_like)");
        this.FYo = (ImageView) findViewById;
        this.Vdw = view.findViewById(R.id.k00);
        this.FYp = (ImageView) view.findViewById(R.id.du8);
        View findViewById2 = view.findViewById(R.id.ixv);
        p.g(findViewById2, "contentView.findViewById(R.id.tv_like_num)");
        this.FYq = (TextView) findViewById2;
        this.FYh = (ImageView) view.findViewById(R.id.j23);
        this.FYk = (LinearLayout) view.findViewById(R.id.e9m);
        this.FYi = view.findViewById(R.id.e9s);
        this.FYl = (LinearLayout) view.findViewById(R.id.e9q);
        this.FYm = (ImageView) view.findViewById(R.id.e4c);
        this.FYn = (TextView) view.findViewById(R.id.iwp);
        this.FYr = (ImageView) view.findViewById(R.id.e4u);
        this.FYs = (TextView) view.findViewById(R.id.iy4);
        this.FYt = (FrameLayout) view.findViewById(R.id.e9r);
        this.FYv = view.findViewById(R.id.e_5);
        this.FYw = view.findViewById(R.id.e50);
        this.FYu = (TextView) view.findViewById(R.id.iyf);
        LinearLayout linearLayout = this.FYl;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new f(this));
            AppMethodBeat.o(216142);
            return;
        }
        AppMethodBeat.o(216142);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ b FYC;

        f(b bVar) {
            this.FYC = bVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0078, code lost:
            continue;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r8) {
            /*
            // Method dump skipped, instructions count: 256
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.textstatus.d.b.f.onClick(android.view.View):void");
        }
    }

    @Override // com.tencent.mm.plugin.textstatus.d.d
    public final boolean aNc(String str) {
        AppMethodBeat.i(216143);
        p.h(str, ch.COL_USERNAME);
        com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        boolean b2 = b(str, com.tencent.mm.plugin.textstatus.b.f.aTf(str));
        AppMethodBeat.o(216143);
        return b2;
    }

    @Override // com.tencent.mm.plugin.textstatus.d.d
    public boolean b(String str, com.tencent.mm.plugin.textstatus.f.f.a aVar) {
        boolean z;
        boolean z2;
        boolean z3;
        ImageView imageView;
        AppMethodBeat.i(216144);
        p.h(str, ch.COL_USERNAME);
        this.username = str;
        this.FYx = aVar;
        Log.i("MicroMsg.TxtStatus.BaseStatusLoadLogic", "[update status]info:%s", this.FYx);
        if (aVar == null) {
            AppMethodBeat.o(216144);
            return false;
        }
        com.tencent.mm.plugin.textstatus.j.b bVar = com.tencent.mm.plugin.textstatus.j.b.GfZ;
        String a2 = com.tencent.mm.plugin.textstatus.j.b.a(aVar.fvU());
        String str2 = aVar.field_StatusID;
        p.g(str2, "info.field_StatusID");
        this.FYf = str2;
        String str3 = aVar.field_Description;
        String str4 = aVar.field_IconID;
        if (!TextUtils.isEmpty(str3)) {
            TextView textView = this.FYe;
            if (textView != null) {
                Context context2 = this.context;
                if (context2 == null) {
                    p.btv("context");
                }
                String str5 = str3;
                TextView textView2 = this.FYe;
                textView.setText(com.tencent.mm.ui.g.c.b.c(context2, str5, textView2 != null ? textView2.getTextSize() : 0.0f));
            }
            TextView textView3 = this.FYe;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
        } else {
            TextView textView4 = this.FYe;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
        }
        if (!this.FYA.abM(8) || str4 == null) {
            ImageView imageView2 = this.FYp;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        } else {
            ImageView imageView3 = this.FYp;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            ImageView imageView4 = this.FYp;
            if (imageView4 != null) {
                com.tencent.mm.plugin.textstatus.j.b bVar2 = com.tencent.mm.plugin.textstatus.j.b.GfZ;
                imageView4.setImageDrawable(com.tencent.mm.plugin.textstatus.j.b.a(str4, a.c.OUTLINED, a.EnumC1808a.WHITE));
            }
            ImageView imageView5 = this.FYp;
            if (imageView5 != null) {
                imageView5.setOnClickListener(new g(this, aVar));
            }
        }
        TextView textView5 = this.FYd;
        if (textView5 != null) {
            textView5.setText(a2);
        }
        com.tencent.mm.plugin.textstatus.f.f.a aVar2 = this.FYx;
        if (aVar2 != null) {
            fvQ();
            c cVar = new c(this, str, aVar2);
            View view = this.Vdw;
            if (view != null) {
                view.setOnClickListener(cVar);
            }
            ImageView imageView6 = this.FYo;
            if (imageView6 == null) {
                p.btv("btnLike");
            }
            if (imageView6 != null) {
                imageView6.setOnClickListener(cVar);
            }
            TextView textView6 = this.FYq;
            if (textView6 == null) {
                p.btv("tvLikeNum");
            }
            if (textView6 != null) {
                textView6.setOnClickListener(cVar);
            }
        }
        if (this.FYz.FYG && (imageView = this.FYh) != null) {
            if (this.FYA.FXv) {
                com.tencent.mm.plugin.textstatus.e.a aVar3 = com.tencent.mm.plugin.textstatus.e.a.FYI;
                Context context3 = this.context;
                if (context3 == null) {
                    p.btv("context");
                }
                com.tencent.mm.plugin.textstatus.e.a.a(context3, imageView, str, aVar);
            } else {
                com.tencent.mm.plugin.textstatus.e.a aVar4 = com.tencent.mm.plugin.textstatus.e.a.FYI;
                Context context4 = this.context;
                if (context4 == null) {
                    p.btv("context");
                }
                com.tencent.mm.plugin.textstatus.e.a.a(aVar4, context4, str, imageView);
            }
        }
        String str6 = aVar.field_PoiName;
        if (str6 == null || kotlin.n.n.aL(str6)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            TextView textView7 = this.FYj;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
        } else {
            TextView textView8 = this.FYj;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            TextView textView9 = this.FYj;
            if (textView9 != null) {
                textView9.setText(aVar.field_PoiName);
            }
        }
        LinearLayout linearLayout = this.FYk;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        if (this.FYA.abM(1)) {
            ImageView imageView7 = this.FYr;
            if (imageView7 != null) {
                imageView7.setVisibility(0);
            }
            a.b.c(this.FYr, str);
        } else {
            ImageView imageView8 = this.FYr;
            if (imageView8 != null) {
                imageView8.setVisibility(8);
            }
        }
        if (this.FYA.abM(2)) {
            TextView textView10 = this.FYs;
            if (textView10 != null) {
                textView10.setVisibility(0);
            }
            String displayName = aa.getDisplayName(str);
            TextView textView11 = this.FYs;
            if (textView11 != null) {
                textView11.setText(displayName);
            }
        } else {
            TextView textView12 = this.FYs;
            if (textView12 != null) {
                textView12.setVisibility(8);
            }
        }
        p.h(aVar, "info");
        w fvU = aVar.fvU();
        String str7 = fvU.Gao;
        if (!(str7 == null || kotlin.n.n.aL(str7))) {
            StringBuilder sb = new StringBuilder("[handleBrand] ");
            String str8 = fvU.Gam;
            if (str8 == null || kotlin.n.n.aL(str8)) {
                z2 = true;
            } else {
                z2 = false;
            }
            Log.i("MicroMsg.TxtStatus.BaseStatusLoadLogic", sb.append(z2).append(',').append(fvU.Gal).toString());
            LinearLayout linearLayout2 = this.FYl;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            TextView textView13 = this.FYn;
            if (textView13 != null) {
                textView13.setText(fvU.Gal);
            }
            String str9 = fvU.Gam;
            if (str9 == null || kotlin.n.n.aL(str9)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                ImageView imageView9 = this.FYm;
                if (imageView9 != null) {
                    imageView9.setVisibility(0);
                    q.bcV().loadImage(fvU.Gam, imageView9);
                }
            } else {
                ImageView imageView10 = this.FYm;
                if (imageView10 != null) {
                    imageView10.setVisibility(8);
                }
            }
            h.RTc.aX(new RunnableC1817b(this, fvU));
        } else {
            LinearLayout linearLayout3 = this.FYl;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
        }
        com.tencent.mm.plugin.textstatus.f.f.a aVar5 = this.FYx;
        if (aVar5 != null) {
            switch (aVar5.field_state) {
                case 5:
                    View view2 = this.FYv;
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                    Context context5 = this.context;
                    if (context5 == null) {
                        p.btv("context");
                    }
                    String string = context5.getResources().getString(R.string.hnz);
                    p.g(string, "context.resources.getStr….text_status_tips_resend)");
                    TextView textView14 = this.FYu;
                    if (textView14 != null) {
                        textView14.setText(string);
                    }
                    View view3 = this.FYw;
                    if (view3 != null) {
                        view3.setVisibility(8);
                    }
                    View view4 = this.FYv;
                    if (view4 != null) {
                        view4.setOnClickListener(new d(this));
                        break;
                    }
                    break;
                case 6:
                    View view5 = this.FYv;
                    if (view5 != null) {
                        view5.setVisibility(0);
                    }
                    View view6 = this.FYw;
                    if (view6 != null) {
                        view6.setVisibility(0);
                    }
                    com.tencent.mm.plugin.textstatus.f.h.c cVar2 = com.tencent.mm.plugin.textstatus.f.h.c.FZX;
                    String str10 = null;
                    v fwe = com.tencent.mm.plugin.textstatus.f.h.c.fwe();
                    if (fwe != null) {
                        str10 = fwe.errMsg;
                    }
                    TextView textView15 = this.FYu;
                    if (textView15 != null) {
                        textView15.setText(str10);
                    }
                    View view7 = this.FYv;
                    if (view7 != null) {
                        view7.setOnClickListener(new e(this));
                        break;
                    }
                    break;
                default:
                    View view8 = this.FYv;
                    if (view8 != null) {
                        view8.setVisibility(8);
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(216144);
        return true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class g implements View.OnClickListener {
        final /* synthetic */ b FYC;
        final /* synthetic */ com.tencent.mm.plugin.textstatus.f.f.a FYF;

        g(b bVar, com.tencent.mm.plugin.textstatus.f.f.a aVar) {
            this.FYC = bVar;
            this.FYF = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(258389);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$update$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (p.j(this.FYF.field_IconID, "2021")) {
                ((com.tencent.mm.plugin.festival.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.festival.a.a.class)).ba(this.FYC.getContext(), 12);
                SecDataUIC.a aVar = SecDataUIC.CWq;
                y yVar = (y) SecDataUIC.a.a(this.FYC.getContext(), 9, y.class);
                if (yVar != null) {
                    com.tencent.mm.plugin.textstatus.k.a aVar2 = com.tencent.mm.plugin.textstatus.k.a.VeA;
                    com.tencent.mm.plugin.textstatus.k.a.a(25, yVar);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$update$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(258389);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ b FYC;

        d(b bVar) {
            this.FYC = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216137);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleSecurity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.textstatus.f.h.c cVar = com.tencent.mm.plugin.textstatus.f.h.c.FZX;
            com.tencent.mm.plugin.textstatus.f.h.c.fwc();
            View view2 = this.FYC.FYv;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleSecurity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216137);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ b FYC;

        e(b bVar) {
            this.FYC = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216138);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleSecurity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View view2 = this.FYC.FYv;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleSecurity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216138);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.textstatus.d.b$b  reason: collision with other inner class name */
    public static final class RunnableC1817b implements Runnable {
        final /* synthetic */ b FYC;
        final /* synthetic */ w FYD;

        RunnableC1817b(b bVar, w wVar) {
            this.FYC = bVar;
            this.FYD = wVar;
        }

        public final void run() {
            AppMethodBeat.i(216135);
            final z.f fVar = new z.f();
            fVar.SYG = null;
            com.tencent.mm.plugin.textstatus.i.d dVar = com.tencent.mm.plugin.textstatus.i.d.Gcq;
            String str = this.FYD.Gao;
            p.g(str, "topicInfo.source_id");
            LinkedList<r> linkedList = this.FYD.Gbe;
            p.g(linkedList, "topicInfo.jump_infos");
            r first = linkedList.getFirst();
            p.g(first, "topicInfo.jump_infos.first");
            fVar.SYG = (T) com.tencent.mm.plugin.textstatus.i.d.a(str, first);
            h.RTc.aV(new Runnable(this) {
                /* class com.tencent.mm.plugin.textstatus.d.b.RunnableC1817b.AnonymousClass1 */
                final /* synthetic */ RunnableC1817b FYE;

                {
                    this.FYE = r1;
                }

                public final void run() {
                    AppMethodBeat.i(216134);
                    FrameLayout frameLayout = this.FYE.FYC.FYt;
                    if (frameLayout != null) {
                        frameLayout.removeAllViews();
                    }
                    if (fVar.SYG != null) {
                        FrameLayout frameLayout2 = this.FYE.FYC.FYt;
                        if (frameLayout2 != null) {
                            frameLayout2.setVisibility(0);
                        }
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.width = at.aH(this.FYE.FYC.getContext(), R.dimen.cb);
                        layoutParams.height = at.aH(this.FYE.FYC.getContext(), R.dimen.cb);
                        fVar.SYG.setLayoutParams(layoutParams);
                        FrameLayout frameLayout3 = this.FYE.FYC.FYt;
                        if (frameLayout3 != null) {
                            frameLayout3.addView(fVar.SYG);
                        }
                        fVar.SYG.invalidate();
                        AppMethodBeat.o(216134);
                        return;
                    }
                    FrameLayout frameLayout4 = this.FYE.FYC.FYt;
                    if (frameLayout4 != null) {
                        frameLayout4.setVisibility(8);
                        AppMethodBeat.o(216134);
                        return;
                    }
                    AppMethodBeat.o(216134);
                }
            });
            AppMethodBeat.o(216135);
        }
    }

    @Override // com.tencent.mm.plugin.textstatus.d.d
    public final void a(d.a aVar) {
        AppMethodBeat.i(216147);
        p.h(aVar, "loadLogicParam");
        this.FYz = aVar;
        AppMethodBeat.o(216147);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ b FYC;
        final /* synthetic */ com.tencent.mm.plugin.textstatus.f.f.a FYF;
        final /* synthetic */ String hLl;

        c(b bVar, String str, com.tencent.mm.plugin.textstatus.f.f.a aVar) {
            this.FYC = bVar;
            this.hLl = str;
            this.FYF = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(258388);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleLike$likeClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (p.j(com.tencent.mm.plugin.auth.a.a.ceA(), this.hLl)) {
                TextStatusLikeListActivity.b bVar2 = TextStatusLikeListActivity.Gfx;
                Context context = this.FYC.getContext();
                String str = this.FYF.field_StatusID;
                p.h(context, "context");
                Intent intent = new Intent(context, TextStatusLikeListActivity.class);
                intent.putExtra("status_id", str);
                intent.putExtra("scene", 0);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForHistory", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForHistory", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                SecDataUIC.a aVar = SecDataUIC.CWq;
                y yVar = (y) SecDataUIC.a.a(this.FYC.getContext(), 9, y.class);
                if (yVar != null) {
                    com.tencent.mm.plugin.textstatus.k.a aVar2 = com.tencent.mm.plugin.textstatus.k.a.VeA;
                    com.tencent.mm.plugin.textstatus.k.a.a(14, yVar);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleLike$likeClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(258388);
            } else if (Math.abs(System.currentTimeMillis() - this.FYC.FYy) < 500) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleLike$likeClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(258388);
            } else {
                com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
                com.tencent.mm.plugin.textstatus.f.f.c fvN = com.tencent.mm.plugin.textstatus.b.f.fvN();
                com.tencent.mm.plugin.textstatus.f.f.a aVar3 = this.FYF;
                boolean aTi = fvN.aTi(aVar3 != null ? aVar3.field_StatusID : null);
                ImageView imageView = this.FYC.FYo;
                if (imageView == null) {
                    p.btv("btnLike");
                }
                Object tag = imageView.getTag();
                if (!(tag instanceof Boolean)) {
                    tag = null;
                }
                Boolean bool = (Boolean) tag;
                Log.i("MicroMsg.TxtStatus.BaseStatusLoadLogic", "isLikeOther:" + aTi + " localIsLike:" + bool);
                if (p.j(bool, Boolean.TRUE)) {
                    String str2 = this.FYF.field_TopicId;
                    p.g(str2, "info.field_TopicId");
                    String str3 = this.FYF.field_StatusID;
                    p.g(str3, "info.field_StatusID");
                    com.tencent.mm.plugin.textstatus.f.i iVar = new com.tencent.mm.plugin.textstatus.f.i(str2, str3, this.hLl, 1, 1);
                    com.tencent.mm.kernel.g.azz().a(iVar.getType(), new f(this.FYC));
                    com.tencent.mm.kernel.g.azz().b(iVar);
                    b.a(this.FYC, false);
                    SecDataUIC.a aVar4 = SecDataUIC.CWq;
                    y yVar2 = (y) SecDataUIC.a.a(this.FYC.getContext(), 9, y.class);
                    if (yVar2 != null) {
                        com.tencent.mm.plugin.textstatus.k.a aVar5 = com.tencent.mm.plugin.textstatus.k.a.VeA;
                        com.tencent.mm.plugin.textstatus.k.a.a(12, yVar2);
                    }
                } else {
                    b.a(this.FYC, true);
                    String str4 = this.FYF.field_TopicId;
                    p.g(str4, "info.field_TopicId");
                    String str5 = this.FYF.field_StatusID;
                    p.g(str5, "info.field_StatusID");
                    com.tencent.mm.plugin.textstatus.f.i iVar2 = new com.tencent.mm.plugin.textstatus.f.i(str4, str5, this.hLl, 0, 1);
                    com.tencent.mm.kernel.g.azz().a(iVar2.getType(), new f(this.FYC));
                    com.tencent.mm.kernel.g.azz().b(iVar2);
                    SecDataUIC.a aVar6 = SecDataUIC.CWq;
                    y yVar3 = (y) SecDataUIC.a.a(this.FYC.getContext(), 9, y.class);
                    if (yVar3 != null) {
                        com.tencent.mm.plugin.textstatus.k.a aVar7 = com.tencent.mm.plugin.textstatus.k.a.VeA;
                        com.tencent.mm.plugin.textstatus.k.a.a(13, "1", yVar3);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleLike$likeClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(258388);
            }
        }
    }

    @SuppressLint({"ResourceType"})
    private final void fvQ() {
        AppMethodBeat.i(216149);
        com.tencent.mm.plugin.textstatus.f.f.a aVar = this.FYx;
        if (aVar == null) {
            AppMethodBeat.o(216149);
            return;
        }
        if (p.j(this.username, com.tencent.mm.plugin.auth.a.a.ceA())) {
            com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
            int aTj = com.tencent.mm.plugin.textstatus.b.f.fvN().aTj(aVar.field_StatusID);
            View view = this.Vdw;
            if (view != null) {
                view.setBackground(null);
            }
            if (aTj > 0) {
                TextView textView = this.FYq;
                if (textView == null) {
                    p.btv("tvLikeNum");
                }
                textView.setText(String.valueOf(aTj));
                TextView textView2 = this.FYq;
                if (textView2 == null) {
                    p.btv("tvLikeNum");
                }
                textView2.setVisibility(0);
                ImageView imageView = this.FYo;
                if (imageView == null) {
                    p.btv("btnLike");
                }
                imageView.setVisibility(0);
                View view2 = this.Vdw;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            } else {
                TextView textView3 = this.FYq;
                if (textView3 == null) {
                    p.btv("tvLikeNum");
                }
                textView3.setVisibility(8);
                ImageView imageView2 = this.FYo;
                if (imageView2 == null) {
                    p.btv("btnLike");
                }
                imageView2.setVisibility(8);
                View view3 = this.Vdw;
                if (view3 != null) {
                    view3.setVisibility(8);
                }
            }
            ImageView imageView3 = this.FYo;
            if (imageView3 == null) {
                p.btv("btnLike");
            }
            Context context2 = this.context;
            if (context2 == null) {
                p.btv("context");
            }
            Drawable drawable = context2.getResources().getDrawable(R.raw.finder_filled_like_private);
            Context context3 = this.context;
            if (context3 == null) {
                p.btv("context");
            }
            imageView3.setImageDrawable(ar.e(drawable, context3.getResources().getColor(R.color.am)));
        } else {
            View view4 = this.Vdw;
            if (view4 != null) {
                Context context4 = this.context;
                if (context4 == null) {
                    p.btv("context");
                }
                view4.setBackground(context4.getResources().getDrawable(R.drawable.cvj));
            }
            com.tencent.mm.plugin.textstatus.b.f fVar2 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
            boolean aTi = com.tencent.mm.plugin.textstatus.b.f.fvN().aTi(aVar.field_StatusID);
            ImageView imageView4 = this.FYo;
            if (imageView4 == null) {
                p.btv("btnLike");
            }
            imageView4.setTag(Boolean.valueOf(aTi));
            TextView textView4 = this.FYq;
            if (textView4 == null) {
                p.btv("tvLikeNum");
            }
            Context context5 = this.context;
            if (context5 == null) {
                p.btv("context");
            }
            textView4.setText(context5.getString(R.string.hng));
            TextView textView5 = this.FYq;
            if (textView5 == null) {
                p.btv("tvLikeNum");
            }
            textView5.setVisibility(0);
            if (aTi) {
                ImageView imageView5 = this.FYo;
                if (imageView5 == null) {
                    p.btv("btnLike");
                }
                Context context6 = this.context;
                if (context6 == null) {
                    p.btv("context");
                }
                Drawable drawable2 = context6.getResources().getDrawable(R.raw.icon_filled_awesome);
                Context context7 = this.context;
                if (context7 == null) {
                    p.btv("context");
                }
                imageView5.setImageDrawable(ar.e(drawable2, context7.getResources().getColor(R.color.Red_100)));
            } else {
                ImageView imageView6 = this.FYo;
                if (imageView6 == null) {
                    p.btv("btnLike");
                }
                Context context8 = this.context;
                if (context8 == null) {
                    p.btv("context");
                }
                Drawable drawable3 = context8.getResources().getDrawable(R.raw.icons_outlined_like);
                Context context9 = this.context;
                if (context9 == null) {
                    p.btv("context");
                }
                imageView6.setImageDrawable(ar.e(drawable3, context9.getResources().getColor(R.color.am)));
            }
        }
        SecDataUIC.a aVar2 = SecDataUIC.CWq;
        Context context10 = this.context;
        if (context10 == null) {
            p.btv("context");
        }
        y yVar = (y) SecDataUIC.a.a(context10, 9, y.class);
        if (yVar != null) {
            ImageView imageView7 = this.FYo;
            if (imageView7 == null) {
                p.btv("btnLike");
            }
            yVar.VdR = imageView7.getVisibility() == 0 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
            AppMethodBeat.o(216149);
            return;
        }
        AppMethodBeat.o(216149);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(216150);
        if (qVar instanceof com.tencent.mm.plugin.textstatus.f.i) {
            com.tencent.mm.kernel.g.azz().b(((com.tencent.mm.plugin.textstatus.f.i) qVar).getType(), this);
            fvQ();
        }
        AppMethodBeat.o(216150);
    }

    public static final /* synthetic */ void a(b bVar, boolean z) {
        AppMethodBeat.i(216153);
        ImageView imageView = bVar.FYo;
        if (imageView == null) {
            p.btv("btnLike");
        }
        imageView.setTag(Boolean.valueOf(z));
        if (z) {
            ImageView imageView2 = bVar.FYo;
            if (imageView2 == null) {
                p.btv("btnLike");
            }
            Context context2 = bVar.context;
            if (context2 == null) {
                p.btv("context");
            }
            Drawable drawable = context2.getResources().getDrawable(R.raw.icon_filled_awesome);
            Context context3 = bVar.context;
            if (context3 == null) {
                p.btv("context");
            }
            imageView2.setImageDrawable(ar.e(drawable, context3.getResources().getColor(R.color.Red_100)));
            AppMethodBeat.o(216153);
            return;
        }
        ImageView imageView3 = bVar.FYo;
        if (imageView3 == null) {
            p.btv("btnLike");
        }
        Context context4 = bVar.context;
        if (context4 == null) {
            p.btv("context");
        }
        Drawable drawable2 = context4.getResources().getDrawable(R.raw.icons_outlined_like);
        Context context5 = bVar.context;
        if (context5 == null) {
            p.btv("context");
        }
        imageView3.setImageDrawable(ar.e(drawable2, context5.getResources().getColor(R.color.am)));
        AppMethodBeat.o(216153);
    }
}
