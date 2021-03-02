package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.secdata.c;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.plugin.textstatus.g.y;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.q;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0014J,\u00107\u001a\u0002052\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\b\u0010;\u001a\u0004\u0018\u00010\u00062\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u000205H\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u0010\u0010\"\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusCardDialog;", "Lcom/tencent/mm/plugin/textstatus/ui/MMCardDialog;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "mContext", "Landroid/content/Context;", ch.COL_USERNAME, "", "(Landroid/content/Context;Ljava/lang/String;)V", "mBtnChat", "Landroid/widget/Button;", "getMBtnChat", "()Landroid/widget/Button;", "setMBtnChat", "(Landroid/widget/Button;)V", "getMContext", "()Landroid/content/Context;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getMProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setMProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "mTvDesc", "Landroid/widget/TextView;", "getMTvDesc", "()Landroid/widget/TextView;", "setMTvDesc", "(Landroid/widget/TextView;)V", "mTvSetSame", "getMTvSetSame", "setMTvSetSame", "mTvTextStatus", "getMTvTextStatus", "setMTvTextStatus", "mTvTextStatusEdt", "mTvTips", "getMTvTips", "setMTvTips", "statusCardView", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "getStatusCardView", "()Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "setStatusCardView", "(Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;)V", "getUsername", "()Ljava/lang/String;", "vPic", "Landroid/view/View;", "getVPic", "()Landroid/view/View;", "setVPic", "(Landroid/view/View;)V", "dismiss", "", "initUI", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "Companion", "plugin-textstatus_release"})
public final class g extends b implements i {
    public static final a Gdz = new a((byte) 0);
    private f Gdy;
    private q gxX;
    private final Context mContext;
    private final String username;

    static {
        AppMethodBeat.i(216466);
        AppMethodBeat.o(216466);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context, String str) {
        super(context);
        p.h(context, "mContext");
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(216465);
        this.mContext = context;
        this.username = str;
        AppMethodBeat.o(216465);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusCardDialog$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.textstatus.ui.b
    public final void onStart() {
        AppMethodBeat.i(216461);
        super.onStart();
        AppMethodBeat.o(216461);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.textstatus.ui.b
    public final void initUI() {
        AppMethodBeat.i(216462);
        super.initUI();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((SecDataUIC) com.tencent.mm.ui.component.a.ko(this.mContext).get(SecDataUIC.class)).a(new c(y.class, 9, (byte) 0));
        SecDataUIC.a aVar2 = SecDataUIC.CWq;
        y yVar = (y) SecDataUIC.a.a(this.mContext, 9, y.class);
        if (yVar != null) {
            yVar.sessionId = d.Nj(1);
        }
        Context context = this.mContext;
        n nVar = n.FXt;
        p.g(nVar, "StatusShowParam.sDefStatusCardDialogParam");
        f fVar = new f(context, nVar);
        View view = fVar.tlx;
        p.h(view, "customView");
        LinearLayout linearLayout = this.GcD;
        if (linearLayout != null) {
            linearLayout.addView(view, -1, -2);
        }
        fVar.DV(this.username);
        fVar.dec = new b(this);
        this.Gdy = fVar;
        LinearLayout linearLayout2 = this.GcD;
        if (linearLayout2 != null) {
            ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
            if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
                layoutParams = null;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (layoutParams2 != null) {
                layoutParams2.topMargin += au.eu(getContext());
                AppMethodBeat.o(216462);
                return;
            }
            AppMethodBeat.o(216462);
            return;
        }
        AppMethodBeat.o(216462);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ g VeT;

        b(g gVar) {
            this.VeT = gVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(258451);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusCardDialog$initUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            p.g(view, LocaleUtil.ITALIAN);
            if (view.getId() == R.id.iko) {
                this.VeT.dismiss();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusCardDialog$initUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(258451);
        }
    }

    public final void dismiss() {
        AppMethodBeat.i(216463);
        super.dismiss();
        f fVar = this.Gdy;
        if (fVar != null) {
            fVar.fvv();
            AppMethodBeat.o(216463);
            return;
        }
        AppMethodBeat.o(216463);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(216464);
        q qVar2 = this.gxX;
        if (qVar2 != null) {
            qVar2.dismiss();
            AppMethodBeat.o(216464);
            return;
        }
        AppMethodBeat.o(216464);
    }
}
