package com.tencent.mm.plugin.textstatus.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.g;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.plugin.textstatus.d.d;
import com.tencent.mm.plugin.textstatus.d.e;
import com.tencent.mm.plugin.textstatus.f.k;
import com.tencent.mm.plugin.textstatus.g.y;
import com.tencent.mm.plugin.thumbplayer.e.b;
import com.tencent.mm.plugin.thumbplayer.view.MMTPRecyclerVideoLayout;
import com.tencent.mm.ui.base.q;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010g\u001a\u00020hJ\b\u0010i\u001a\u00020\u0014H\u0016J\u0006\u0010j\u001a\u00020hJ\u0010\u0010k\u001a\u00020h2\u0006\u0010[\u001a\u00020'H\u0003J\u0012\u0010l\u001a\u00020h2\b\u0010m\u001a\u0004\u0018\u00010\u0014H\u0016J,\u0010n\u001a\u00020h2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020p2\b\u0010r\u001a\u0004\u0018\u00010'2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\b\u0010u\u001a\u00020hH\u0016J\b\u0010v\u001a\u00020hH\u0016J\b\u0010w\u001a\u00020hH\u0016J\u0010\u0010x\u001a\u00020h2\u0006\u0010y\u001a\u00020zH\u0016J\u0006\u0010{\u001a\u00020hJ\u0006\u0010|\u001a\u00020hJ\u0012\u0010}\u001a\u00020h2\b\u0010~\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001a\u00020h2\b\u0010~\u001a\u0004\u0018\u00010\u0003H\u0016J\u001b\u0010\u0001\u001a\u00020h2\u0006\u0010[\u001a\u00020'2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0013\u0010\u0001\u001a\u00020h2\b\u0010[\u001a\u0004\u0018\u00010'H\u0016J\u0007\u0010\u0001\u001a\u00020hR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u000203X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0010\u0010C\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020JX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR\u001c\u0010R\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010L\"\u0004\bT\u0010NR\u001c\u0010U\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010L\"\u0004\bW\u0010NR\u001c\u0010X\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010L\"\u0004\bZ\u0010NR\u001c\u0010[\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010F\"\u0004\b]\u0010HR\u001c\u0010^\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\r\"\u0004\b`\u0010\u000fR\u001c\u0010a\u001a\u0004\u0018\u00010bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010f¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/StatusCardView;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusInfoUpdate;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;)V", "btnJoin", "Landroid/widget/ImageView;", "getBtnJoin", "()Landroid/widget/ImageView;", "setBtnJoin", "(Landroid/widget/ImageView;)V", "btnLike", "getBtnLike", "setBtnLike", "cardView", "Landroid/view/View;", "clickListener", "eventListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "iconStatus", "getIconStatus", "setIconStatus", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "ivMask", "getIvMask", "()Landroid/view/View;", "setIvMask", "(Landroid/view/View;)V", "lastExposedSessionId", "", "lastStatusId", "layoutCardContent", "getLayoutCardContent", "setLayoutCardContent", "layoutVideo", "Landroid/widget/FrameLayout;", "getLayoutVideo", "()Landroid/widget/FrameLayout;", "setLayoutVideo", "(Landroid/widget/FrameLayout;)V", "loadLogic", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "getLoadLogic", "()Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "setLoadLogic", "(Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "sessionId", "statusId", "getStatusId", "()Ljava/lang/String;", "setStatusId", "(Ljava/lang/String;)V", "tvDesc", "Landroid/widget/TextView;", "getTvDesc", "()Landroid/widget/TextView;", "setTvDesc", "(Landroid/widget/TextView;)V", "tvLikeNum", "getTvLikeNum", "setTvLikeNum", "tvPoi", "getTvPoi", "setTvPoi", "tvSameFriendsTips", "getTvSameFriendsTips", "setTvSameFriendsTips", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", ch.COL_USERNAME, "getUsername", "setUsername", "vBack", "getVBack", "setVBack", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;)V", "destoryVideo", "", "getView", "handleVideo", "initData", "onClick", "v", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStatusShowDestroy", "onStatusShowPause", "onStatusShowResume", "onTransAnim", "persent", "", "pauseVideo", "playVideo", "setEventListener", "l", "setItemClickListener", "update", "updateMask", "Companion", "plugin-textstatus_release"})
public final class f implements View.OnClickListener, i, com.tencent.mm.plugin.textstatus.a.f, g {
    public static final a Gdx = new a((byte) 0);
    private MMTPRecyclerVideoLayout AuG;
    private f.a FXT;
    private final n FYA;
    private TextView FYd;
    private TextView FYe;
    private String FYf;
    private TextView FYg;
    private ImageView FYh;
    private TextView FYj;
    private ImageView FYo;
    private ImageView FYp;
    private TextView FYq;
    private com.tencent.mm.plugin.textstatus.f.f.a FYx;
    private ImageView GcJ;
    private FrameLayout Gcu;
    private d Gdv;
    private View Gdw;
    private String VeN;
    private String VeO;
    View.OnClickListener dec;
    private q gut;
    private Context mContext;
    private String sessionId;
    public final View tlx;
    private String username;

    static {
        AppMethodBeat.i(216459);
        AppMethodBeat.o(216459);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ f(android.content.Context r4) {
        /*
            r3 = this;
            r2 = 216458(0x34d8a, float:3.03322E-40)
            com.tencent.mm.plugin.textstatus.a.n r0 = com.tencent.mm.plugin.textstatus.a.n.FXs
            java.lang.String r1 = "StatusShowParam.sDefaultShowParam"
            kotlin.g.b.p.g(r0, r1)
            r3.<init>(r4, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.textstatus.ui.f.<init>(android.content.Context):void");
    }

    public f(Context context, n nVar) {
        p.h(context, "context");
        p.h(nVar, "showParam");
        AppMethodBeat.i(216457);
        this.FYA = nVar;
        View inflate = LayoutInflater.from(context).inflate(R.layout.c2_, (ViewGroup) null, false);
        p.g(inflate, "LayoutInflater.from(cont…tus_card_ui, null, false)");
        this.tlx = inflate;
        this.mContext = context;
        this.FYf = "";
        e eVar = e.FYH;
        this.Gdv = e.a(this.FYA);
        this.Gdv.ba(this.tlx);
        this.FYd = (TextView) this.tlx.findViewById(R.id.iyr);
        this.FYg = (TextView) this.tlx.findViewById(R.id.iyd);
        this.FYe = (TextView) this.tlx.findViewById(R.id.ix3);
        this.FYj = (TextView) this.tlx.findViewById(R.id.iy7);
        this.GcJ = (ImageView) this.tlx.findViewById(R.id.aeu);
        View findViewById = this.tlx.findViewById(R.id.aew);
        p.g(findViewById, "cardView.findViewById(R.id.btn_like)");
        this.FYo = (ImageView) findViewById;
        this.FYp = (ImageView) this.tlx.findViewById(R.id.du8);
        View findViewById2 = this.tlx.findViewById(R.id.ixv);
        p.g(findViewById2, "cardView.findViewById(R.id.tv_like_num)");
        this.FYq = (TextView) findViewById2;
        this.FYh = (ImageView) this.tlx.findViewById(R.id.j23);
        this.Gdw = this.tlx.findViewById(R.id.e4t);
        this.Gcu = (FrameLayout) this.tlx.findViewById(R.id.e_a);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12.0f);
        com.tencent.mm.plugin.textstatus.j.f fVar = com.tencent.mm.plugin.textstatus.j.f.Ggk;
        com.tencent.mm.plugin.textstatus.j.f.B(this.tlx, (float) fromDPToPix);
        this.sessionId = "";
        this.VeN = "";
        this.VeO = "";
        AppMethodBeat.o(216457);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/StatusCardView$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @SuppressLint({"ResourceType"})
    private final void aDj(String str) {
        AppMethodBeat.i(216445);
        this.username = str;
        com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        this.FYx = com.tencent.mm.plugin.textstatus.b.f.aTf(str);
        com.tencent.mm.plugin.textstatus.f.f.a aVar = this.FYx;
        com.tencent.mm.plugin.textstatus.b.f fVar2 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        com.tencent.mm.plugin.textstatus.b.f.fvM().bys(str);
        a(str, aVar);
        AppMethodBeat.o(216445);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.g
    public final void a(String str, com.tencent.mm.plugin.textstatus.f.f.a aVar) {
        int i2;
        String str2;
        String str3;
        AppMethodBeat.i(216446);
        p.h(str, ch.COL_USERNAME);
        SecDataUIC.a aVar2 = SecDataUIC.CWq;
        y yVar = (y) SecDataUIC.a.a(this.mContext, 9, y.class);
        if (yVar != null) {
            String str4 = yVar.sessionId;
            if (str4 == null) {
                str4 = "";
            }
            this.sessionId = str4;
            yVar.username = str;
            yVar.VdU = this.FYA.scene;
        }
        if (!this.Gdv.b(str, aVar)) {
            this.tlx.setVisibility(8);
            AppMethodBeat.o(216446);
            return;
        }
        this.tlx.setVisibility(0);
        try {
            fwm();
        } catch (Throwable th) {
        }
        fwi();
        this.tlx.setOnClickListener(this);
        SecDataUIC.a aVar3 = SecDataUIC.CWq;
        y yVar2 = (y) SecDataUIC.a.a(this.mContext, 9, y.class);
        if (yVar2 != null) {
            if (TextUtils.equals(yVar2.sessionId, this.VeN)) {
                String str5 = this.VeO;
                if (aVar != null) {
                    str3 = aVar.field_StatusID;
                } else {
                    str3 = null;
                }
                if (TextUtils.equals(str5, str3)) {
                    AppMethodBeat.o(216446);
                    return;
                }
            }
            Object tag = this.tlx.getTag(R.id.ih4);
            if (!(tag instanceof Integer)) {
                tag = null;
            }
            Integer num = (Integer) tag;
            if (num != null) {
                i2 = num.intValue();
            } else {
                i2 = 0;
            }
            yVar2.VdW = i2;
            com.tencent.mm.plugin.textstatus.k.a aVar4 = com.tencent.mm.plugin.textstatus.k.a.VeA;
            com.tencent.mm.plugin.textstatus.k.a.a(1, yVar2);
            this.VeN = yVar2.sessionId;
            if (aVar == null || (str2 = aVar.field_StatusID) == null) {
                str2 = "";
            }
            this.VeO = str2;
            AppMethodBeat.o(216446);
            return;
        }
        AppMethodBeat.o(216446);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.f
    public final View getView() {
        return this.tlx;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.j
    public final void DV(String str) {
        AppMethodBeat.i(216447);
        String str2 = str;
        if (str2 == null || kotlin.n.n.aL(str2)) {
            AppMethodBeat.o(216447);
            return;
        }
        new k.e(str, this);
        aDj(str);
        AppMethodBeat.o(216447);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.h
    public final void fvv() {
        AppMethodBeat.i(216448);
        h.hkS();
        fwn();
        AppMethodBeat.o(216448);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.h
    public final void fvw() {
        AppMethodBeat.i(216449);
        h.hkS();
        PF();
        AppMethodBeat.o(216449);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.h
    public final void fvx() {
        b player;
        AppMethodBeat.i(216450);
        h.hkS();
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout = this.AuG;
        if (mMTPRecyclerVideoLayout == null || (player = mMTPRecyclerVideoLayout.getPlayer()) == null) {
            AppMethodBeat.o(216450);
            return;
        }
        player.pause();
        AppMethodBeat.o(216450);
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

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
        if (r1 == null) goto L_0x0081;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fwm() {
        /*
        // Method dump skipped, instructions count: 249
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.textstatus.ui.f.fwm():void");
    }

    private void PF() {
        b player;
        AppMethodBeat.i(216452);
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout = this.AuG;
        if (mMTPRecyclerVideoLayout == null || (player = mMTPRecyclerVideoLayout.getPlayer()) == null) {
            AppMethodBeat.o(216452);
            return;
        }
        player.fwU();
        AppMethodBeat.o(216452);
    }

    private void fwn() {
        b player;
        b player2;
        AppMethodBeat.i(216453);
        FrameLayout frameLayout = this.Gcu;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        FrameLayout frameLayout2 = this.Gcu;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout = this.AuG;
        if (!(mMTPRecyclerVideoLayout == null || (player2 = mMTPRecyclerVideoLayout.getPlayer()) == null)) {
            player2.stopAsync();
        }
        MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout2 = this.AuG;
        if (mMTPRecyclerVideoLayout2 == null || (player = mMTPRecyclerVideoLayout2.getPlayer()) == null) {
            AppMethodBeat.o(216453);
            return;
        }
        player.recycle();
        AppMethodBeat.o(216453);
    }

    private void fwi() {
        com.tencent.mm.plugin.textstatus.f.f.a aVar;
        AppMethodBeat.i(216454);
        com.tencent.mm.plugin.textstatus.f.f.a aVar2 = this.FYx;
        String str = aVar2 != null ? aVar2.field_MediaThumbUrl : null;
        if ((str == null || kotlin.n.n.aL(str)) || ((aVar = this.FYx) != null && aVar.fvV())) {
            View view = this.Gdw;
            if (view != null) {
                view.setVisibility(8);
                AppMethodBeat.o(216454);
                return;
            }
            AppMethodBeat.o(216454);
            return;
        }
        View view2 = this.Gdw;
        if (view2 != null) {
            view2.setVisibility(0);
            AppMethodBeat.o(216454);
            return;
        }
        AppMethodBeat.o(216454);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(216455);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/StatusCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        View.OnClickListener onClickListener = this.dec;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.iko) {
            if (this.FYA.scene == 6) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(216455);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", this.username);
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 2);
            c.b(this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent, 213);
            SecDataUIC.a aVar = SecDataUIC.CWq;
            y yVar = (y) SecDataUIC.a.a(this.mContext, 9, y.class);
            if (yVar != null) {
                com.tencent.mm.plugin.textstatus.k.a aVar2 = com.tencent.mm.plugin.textstatus.k.a.VeA;
                com.tencent.mm.plugin.textstatus.k.a.a(22, yVar);
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216455);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(216456);
        if (qVar instanceof com.tencent.mm.plugin.textstatus.f.b) {
            com.tencent.mm.kernel.g.azz().b(((com.tencent.mm.plugin.textstatus.f.b) qVar).getType(), this);
            boolean z = false;
            if (i2 == 0 && i3 == 0) {
                z = true;
            } else {
                com.tencent.mm.ui.base.h.X(this.mContext, this.mContext.getString(R.string.hn7), "");
            }
            f.a aVar = this.FXT;
            if (aVar != null) {
                aVar.dV(Boolean.valueOf(z));
            }
        }
        q qVar2 = this.gut;
        if (qVar2 != null) {
            qVar2.dismiss();
            AppMethodBeat.o(216456);
            return;
        }
        AppMethodBeat.o(216456);
    }
}
