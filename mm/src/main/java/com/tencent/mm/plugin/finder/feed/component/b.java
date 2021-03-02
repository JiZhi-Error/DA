package com.tencent.mm.plugin.finder.feed.component;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u000fJ^\u0010.\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020326\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0015R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013RL\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/component/StickyFeedComponent;", "", "()V", "MMFinder_ModSticky_Err_Private_NotAllow_Sticky", "", "getMMFinder_ModSticky_Err_Private_NotAllow_Sticky", "()I", "MMFinder_ModSticky_Err_Sticky_Num_Limit", "getMMFinder_ModSticky_Err_Sticky_Num_Limit", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "requesting", "", "getRequesting", "()Z", "setRequesting", "(Z)V", "succCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "req", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "ret", "", "getSuccCallback", "()Lkotlin/jvm/functions/Function2;", "setSuccCallback", "(Lkotlin/jvm/functions/Function2;)V", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "addStickyMenuItem", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "context", "Landroid/content/Context;", "CANCEL_STICKY_ID", "STICKY_ID", "ifSticky", "makeFeedSticky", "feedId", "", "sticky", "nonceId", "", "plugin-finder_release"})
public final class b {
    final int tUm = -4051;
    final int tUn = -4053;
    private final ai<aze> tUo = new a(this);
    m<? super aze, ? super apg, x> tUp;
    boolean tUq;
    Dialog tipDialog;

    public b() {
        AppMethodBeat.i(244530);
        AppMethodBeat.o(244530);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/feed/component/StickyFeedComponent$callback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
    public static final class a implements ai<aze> {
        final /* synthetic */ b tUr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(b bVar) {
            this.tUr = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0045  */
        @Override // com.tencent.mm.plugin.i.a.ai
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void a(com.tencent.mm.protocal.protobuf.aze r5, com.tencent.mm.protocal.protobuf.apg r6) {
            /*
            // Method dump skipped, instructions count: 117
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.component.b.a.a(java.lang.Object, com.tencent.mm.protocal.protobuf.apg):void");
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.component.b$a$a  reason: collision with other inner class name */
        static final class C1143a implements u.b {
            public static final C1143a tUs = new C1143a();

            static {
                AppMethodBeat.i(244525);
                AppMethodBeat.o(244525);
            }

            C1143a() {
            }

            @Override // com.tencent.mm.ui.base.u.b
            public final void dU(View view) {
                TextView textView;
                AppMethodBeat.i(244524);
                if (view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null) {
                    AppMethodBeat.o(244524);
                    return;
                }
                textView.setTextSize(1, 14.0f);
                AppMethodBeat.o(244524);
            }
        }
    }

    public final void a(Context context, long j2, boolean z, String str, m<? super aze, ? super apg, x> mVar) {
        int i2 = 1;
        AppMethodBeat.i(244529);
        p.h(context, "context");
        p.h(str, "nonceId");
        p.h(mVar, "succCallback");
        this.tUp = mVar;
        this.tUq = true;
        d.a(500, new C1144b(this, context));
        s sVar = (s) g.af(s.class);
        if (z) {
            i2 = 0;
        }
        sVar.a(j2, i2, str, this.tUo);
        AppMethodBeat.o(244529);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.feed.component.b$b  reason: collision with other inner class name */
    public static final class C1144b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ b tUr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1144b(b bVar, Context context) {
            super(0);
            this.tUr = bVar;
            this.$context = context;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.component.b$b$a */
        static final class a implements DialogInterface.OnCancelListener {
            public static final a tUt = new a();

            static {
                AppMethodBeat.i(244527);
                AppMethodBeat.o(244527);
            }

            a() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(244528);
            if (this.tUr.tUq) {
                Dialog dialog = this.tUr.tipDialog;
                if (dialog != null) {
                    dialog.show();
                } else {
                    b bVar = this.tUr;
                    Context context = this.$context;
                    this.$context.getString(R.string.zb);
                    bVar.tipDialog = h.a(context, this.$context.getString(R.string.a06), false, (DialogInterface.OnCancelListener) a.tUt);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244528);
            return xVar;
        }
    }
}
