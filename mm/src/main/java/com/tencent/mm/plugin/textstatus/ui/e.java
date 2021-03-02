package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.plugin.textstatus.d.c;
import com.tencent.mm.plugin.textstatus.d.d;
import com.tencent.mm.plugin.textstatus.f.k;
import com.tencent.mm.plugin.textstatus.g.y;
import com.tencent.mm.plugin.textstatus.j.b;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020pH\u0016J\b\u0010q\u001a\u00020\u000bH\u0016J\b\u0010r\u001a\u00020\u0017H\u0016J\b\u0010s\u001a\u00020nH\u0002J\b\u0010t\u001a\u00020nH\u0003J\b\u0010u\u001a\u00020nH\u0016J\u0010\u0010v\u001a\u00020n2\u0006\u0010e\u001a\u00020(H\u0003J\b\u0010w\u001a\u00020pH\u0002J\u0012\u0010x\u001a\u00020n2\b\u0010y\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010z\u001a\u00020n2\u0006\u0010{\u001a\u00020\u000bH\u0016J\u0010\u0010|\u001a\u00020n2\u0006\u0010{\u001a\u00020\u000bH\u0016J\u0010\u0010}\u001a\u00020n2\u0006\u0010{\u001a\u00020\u000bH\u0016J\b\u0010~\u001a\u00020nH\u0016J\b\u0010\u001a\u00020nH\u0016J\t\u0010\u0001\u001a\u00020nH\u0016J\u0012\u0010\u0001\u001a\u00020n2\u0007\u0010\u0001\u001a\u00020pH\u0016J\t\u0010\u0001\u001a\u00020nH\u0016J\t\u0010\u0001\u001a\u00020nH\u0016J2\u0010\u0001\u001a\u00020n2\u0007\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u000b2\t\u0010\u0001\u001a\u0004\u0018\u00010(2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020nH\u0016J\t\u0010\u0001\u001a\u00020nH\u0016J\t\u0010\u0001\u001a\u00020nH\u0016J\u0013\u0010\u0001\u001a\u00020n2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0014\u0010\u0001\u001a\u00020n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u001aH\u0016J\u0014\u0010\u0001\u001a\u00020n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0002H\u0016J\u0013\u0010\u0001\u001a\u00020n2\b\u0010e\u001a\u0004\u0018\u00010(H\u0016R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R6\u0010>\u001a\u001e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020A0?j\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020A`BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010N\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001c\u0010S\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010P\"\u0004\bU\u0010RR\u001a\u0010V\u001a\u00020@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010P\"\u0004\bX\u0010RR\u001a\u0010Y\u001a\u00020@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010P\"\u0004\b[\u0010RR\u001c\u0010\\\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010P\"\u0004\b^\u0010RR\u001c\u0010_\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010P\"\u0004\ba\u0010RR\u001c\u0010b\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010P\"\u0004\bd\u0010RR\u001c\u0010e\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001c\u0010j\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0010\"\u0004\bl\u0010\u0012¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/ProfileCardView;", "Lcom/tencent/mm/plugin/textstatus/api/IProfileCardView;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "rootLayout", "Landroid/widget/RelativeLayout;", "headerRoot", "Landroid/widget/LinearLayout;", "extraPadding", "", "(Landroid/content/Context;Landroid/widget/RelativeLayout;Landroid/widget/LinearLayout;I)V", "btnJoin", "Landroid/widget/ImageView;", "getBtnJoin", "()Landroid/widget/ImageView;", "setBtnJoin", "(Landroid/widget/ImageView;)V", "btnLike", "getBtnLike", "setBtnLike", "cardView", "Landroid/view/View;", "clickListener", "eventListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "iconAvatarNotify", "getIconAvatarNotify", "setIconAvatarNotify", "iconStatus", "getIconStatus", "setIconStatus", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "lastExposedSessionId", "", "layoutCardContent", "getLayoutCardContent", "()Landroid/widget/RelativeLayout;", "setLayoutCardContent", "(Landroid/widget/RelativeLayout;)V", "layoutNotify", "getLayoutNotify", "()Landroid/widget/LinearLayout;", "setLayoutNotify", "(Landroid/widget/LinearLayout;)V", "loadLogic", "Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "getLoadLogic", "()Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "setLoadLogic", "(Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "oriColorMap", "Ljava/util/HashMap;", "Landroid/widget/TextView;", "Landroid/content/res/ColorStateList;", "Lkotlin/collections/HashMap;", "getOriColorMap", "()Ljava/util/HashMap;", "setOriColorMap", "(Ljava/util/HashMap;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "sessionId", "tvChatCount", "getTvChatCount", "()Landroid/widget/TextView;", "setTvChatCount", "(Landroid/widget/TextView;)V", "tvDesc", "getTvDesc", "setTvDesc", "tvDescNotify", "getTvDescNotify", "setTvDescNotify", "tvLikeNum", "getTvLikeNum", "setTvLikeNum", "tvPoi", "getTvPoi", "setTvPoi", "tvSameFriendsTips", "getTvSameFriendsTips", "setTvSameFriendsTips", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", ch.COL_USERNAME, "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "vBack", "getVBack", "setVBack", "fixLayout", "", "hasStatus", "", "getLayoutId", "getView", "goDetail", "handleNotify", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initData", "isSelf", "onClick", "v", "onCoordinationViewClosing", "offset", "onCoordinationViewOpening", "onListInnerScroll", "onMuteIn", "onMuteOut", "onPostClose", "onPostOpen", "isMute", "onPreClose", "onPreOpen", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStatusShowDestroy", "onStatusShowPause", "onStatusShowResume", "onTransAnim", "persent", "", "setEventListener", "l", "setItemClickListener", "update", "Companion", "plugin-textstatus_release"})
public final class e implements View.OnClickListener, i, d {
    public static final a Gdh = new a((byte) 0);
    private static final String TAG = TAG;
    private f.a FXT;
    private TextView FYd;
    private TextView FYe;
    private TextView FYg;
    private ImageView FYh;
    private TextView FYj;
    private ImageView FYo;
    private ImageView FYp;
    private TextView FYq;
    private com.tencent.mm.plugin.textstatus.f.f.a FYx;
    private RelativeLayout GcI;
    private ImageView GcJ;
    private ImageView GcO;
    private TextView GcP;
    private LinearLayout GcQ;
    private c GcV;
    private HashMap<TextView, ColorStateList> GcW = new HashMap<>();
    private final LinearLayout GcZ;
    private final int Gda;
    private String VeN;
    private View.OnClickListener dec;
    private q gut;
    private final RelativeLayout hOX;
    private Context mContext;
    private String sessionId;
    private final View tlx;
    private String username;

    public e(Context context, RelativeLayout relativeLayout, LinearLayout linearLayout, int i2) {
        p.h(context, "context");
        p.h(relativeLayout, "rootLayout");
        p.h(linearLayout, "headerRoot");
        AppMethodBeat.i(216416);
        this.hOX = relativeLayout;
        this.GcZ = linearLayout;
        this.Gda = i2;
        View inflate = LayoutInflater.from(context).inflate(R.layout.c2t, (ViewGroup) null, false);
        p.g(inflate, "LayoutInflater.from(cont…tLayoutId(), null, false)");
        this.tlx = inflate;
        this.mContext = context;
        com.tencent.mm.plugin.textstatus.d.e eVar = com.tencent.mm.plugin.textstatus.d.e.FYH;
        n nVar = n.VcA;
        p.g(nVar, "StatusShowParam.sDefaultProfileShowParam");
        this.GcV = com.tencent.mm.plugin.textstatus.d.e.b(nVar);
        this.GcV.ba(this.tlx);
        this.FYd = (TextView) this.tlx.findViewById(R.id.iyr);
        this.FYg = (TextView) this.tlx.findViewById(R.id.iyd);
        this.FYe = (TextView) this.tlx.findViewById(R.id.ix3);
        this.FYj = (TextView) this.tlx.findViewById(R.id.iy7);
        this.GcJ = (ImageView) this.tlx.findViewById(R.id.aeu);
        View findViewById = this.tlx.findViewById(R.id.aew);
        p.g(findViewById, "cardView.findViewById(R.id.btn_like)");
        this.FYo = (ImageView) findViewById;
        this.FYp = (ImageView) this.tlx.findViewById(R.id.du8);
        View findViewById2 = this.tlx.findViewById(R.id.dtg);
        p.g(findViewById2, "cardView.findViewById(R.id.icon_avatar_notify)");
        this.GcO = (ImageView) findViewById2;
        View findViewById3 = this.tlx.findViewById(R.id.ix4);
        p.g(findViewById3, "cardView.findViewById(R.id.tv_desc_notify)");
        this.GcP = (TextView) findViewById3;
        View findViewById4 = this.tlx.findViewById(R.id.e_1);
        p.g(findViewById4, "cardView.findViewById(R.id.layout_notify)");
        this.GcQ = (LinearLayout) findViewById4;
        View findViewById5 = this.tlx.findViewById(R.id.ixv);
        p.g(findViewById5, "cardView.findViewById(R.id.tv_like_num)");
        this.FYq = (TextView) findViewById5;
        this.FYh = (ImageView) this.tlx.findViewById(R.id.j23);
        this.GcI = (RelativeLayout) this.tlx.findViewById(R.id.e9s);
        com.tencent.mm.plugin.textstatus.j.f fVar = com.tencent.mm.plugin.textstatus.j.f.Ggk;
        com.tencent.mm.plugin.textstatus.j.f.B(this.GcO, (float) com.tencent.mm.cb.a.fromDPToPix(context, 10.0f));
        String Nj = com.tencent.mm.plugin.fts.a.d.Nj(1);
        p.g(Nj, "FTSApiLogic.getUnsignedM…atus.SessionScene.NORMAL)");
        this.sessionId = Nj;
        this.VeN = "";
        AppMethodBeat.o(216416);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/ProfileCardView$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(216417);
        AppMethodBeat.o(216417);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.f
    public final View getView() {
        return this.tlx;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.j
    public final void DV(String str) {
        ViewGroup.LayoutParams layoutParams;
        AppMethodBeat.i(216401);
        String str2 = str;
        if (str2 == null || kotlin.n.n.aL(str2)) {
            AppMethodBeat.o(216401);
            return;
        }
        new k.e(str, this);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((SecDataUIC) com.tencent.mm.ui.component.a.ko(this.mContext).get(SecDataUIC.class)).a(new com.tencent.mm.plugin.secdata.c(y.class, 9, (byte) 0));
        SecDataUIC.a aVar2 = SecDataUIC.CWq;
        y yVar = (y) SecDataUIC.a.a(this.mContext, 9, y.class);
        if (yVar != null) {
            yVar.sessionId = this.sessionId;
            yVar.username = str;
            yVar.VdU = 4;
        }
        this.username = str;
        new k.e(str, this);
        com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        this.FYx = com.tencent.mm.plugin.textstatus.b.f.aTf(str);
        com.tencent.mm.plugin.textstatus.b.f fVar2 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        com.tencent.mm.plugin.textstatus.b.f.fvM().bys(str);
        this.GcV.a(new d.a(false));
        boolean aNc = this.GcV.aNc(str);
        if (!aNc) {
            LinearLayout linearLayout = this.GcZ;
            if (linearLayout != null) {
                linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), com.tencent.mm.cb.a.fromDPToPix(this.mContext, 32));
            }
            RelativeLayout relativeLayout = this.hOX;
            if (!(relativeLayout == null || (layoutParams = relativeLayout.getLayoutParams()) == null)) {
                layoutParams.height = -2;
            }
        } else {
            int i2 = ah.jS(this.mContext).width;
            LinearLayout linearLayout2 = this.GcZ;
            if (linearLayout2 != null) {
                linearLayout2.setPadding(linearLayout2.getPaddingLeft(), linearLayout2.getPaddingTop(), linearLayout2.getPaddingRight(), com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16));
            }
            this.hOX.getLayoutParams().height = i2;
        }
        if (!aNc) {
            this.tlx.setVisibility(8);
            com.tencent.mm.plugin.textstatus.j.f fVar3 = com.tencent.mm.plugin.textstatus.j.f.Ggk;
            com.tencent.mm.plugin.textstatus.j.f.aT(this.GcW);
            AppMethodBeat.o(216401);
            return;
        }
        this.tlx.setVisibility(0);
        com.tencent.mm.plugin.textstatus.j.f.Ggk.a(this.GcZ, -1, this.GcW);
        b bVar = b.GfZ;
        com.tencent.mm.plugin.textstatus.f.f.a aVar3 = this.FYx;
        String name = b.getName(aVar3 != null ? aVar3.field_IconID : null);
        TextView textView = this.FYd;
        if (textView != null) {
            textView.setText(this.mContext.getString(R.string.hnv) + name);
        }
        this.tlx.setOnClickListener(this);
        SecDataUIC.a aVar4 = SecDataUIC.CWq;
        y yVar2 = (y) SecDataUIC.a.a(this.mContext, 9, y.class);
        if (yVar2 == null || TextUtils.equals(yVar2.sessionId, this.VeN)) {
            AppMethodBeat.o(216401);
            return;
        }
        com.tencent.mm.plugin.textstatus.k.a aVar5 = com.tencent.mm.plugin.textstatus.k.a.VeA;
        com.tencent.mm.plugin.textstatus.k.a.a(1, yVar2);
        String str3 = yVar2.sessionId;
        p.g(str3, "it.sessionId");
        this.VeN = str3;
        com.tencent.mm.plugin.textstatus.k.a aVar6 = com.tencent.mm.plugin.textstatus.k.a.VeA;
        com.tencent.mm.plugin.textstatus.k.a.a(yVar2);
        AppMethodBeat.o(216401);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.h
    public final void fvv() {
        AppMethodBeat.i(216402);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
        AppMethodBeat.o(216402);
        throw nVar;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.h
    public final void fvw() {
        AppMethodBeat.i(216403);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
        AppMethodBeat.o(216403);
        throw nVar;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.h
    public final void fvx() {
        AppMethodBeat.i(216404);
        kotlin.n nVar = new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
        AppMethodBeat.o(216404);
        throw nVar;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.l
    public final void cd(float f2) {
    }

    @Override // com.tencent.mm.plugin.textstatus.a.f
    public final void f(View.OnClickListener onClickListener) {
        this.dec = onClickListener;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.f
    public final void a(f.a aVar) {
        this.FXT = aVar;
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void onPostOpen(boolean z) {
        AppMethodBeat.i(216405);
        this.GcV.onPostOpen(z);
        AppMethodBeat.o(216405);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void onPostClose() {
        AppMethodBeat.i(216406);
        this.GcV.onPostClose();
        AppMethodBeat.o(216406);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void eEk() {
        AppMethodBeat.i(216407);
        this.GcV.eEk();
        AppMethodBeat.o(216407);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void eEl() {
        AppMethodBeat.i(216408);
        this.GcV.eEl();
        AppMethodBeat.o(216408);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void eEm() {
        AppMethodBeat.i(216409);
        this.GcV.eEm();
        AppMethodBeat.o(216409);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void eEn() {
        AppMethodBeat.i(216410);
        this.GcV.eEn();
        AppMethodBeat.o(216410);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void UC(int i2) {
        AppMethodBeat.i(216411);
        this.GcV.UC(i2);
        AppMethodBeat.o(216411);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void UD(int i2) {
        AppMethodBeat.i(216412);
        this.GcV.UD(i2);
        AppMethodBeat.o(216412);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void UE(int i2) {
        AppMethodBeat.i(216413);
        this.GcV.UE(i2);
        AppMethodBeat.o(216413);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(216414);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/ProfileCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        View.OnClickListener onClickListener = this.dec;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/ProfileCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216414);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(216415);
        if (qVar instanceof com.tencent.mm.plugin.textstatus.f.b) {
            g.azz().b(((com.tencent.mm.plugin.textstatus.f.b) qVar).getType(), this);
            boolean z = false;
            if (i2 == 0 && i3 == 0) {
                z = true;
            } else {
                h.X(this.mContext, this.mContext.getString(R.string.hn7), "");
            }
            f.a aVar = this.FXT;
            if (aVar != null) {
                aVar.dV(Boolean.valueOf(z));
            }
        }
        q qVar2 = this.gut;
        if (qVar2 != null) {
            qVar2.dismiss();
            AppMethodBeat.o(216415);
            return;
        }
        AppMethodBeat.o(216415);
    }
}
