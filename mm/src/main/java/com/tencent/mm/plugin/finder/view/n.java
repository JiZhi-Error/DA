package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.utils.aa;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.ah;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.aso;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.eoy;
import com.tencent.mm.protocal.protobuf.eoz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q;
import java.util.LinkedList;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderWxProfileHelper;", "", "()V", "Companion", "plugin-finder_release"})
public final class n {
    private static final String TAG = TAG;
    public static final a wpY = new a((byte) 0);

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\nH\u0002J0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017J*\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J4\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017H\u0002J\u001a\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion;", "", "()V", "TAG", "", "contactToBundle", "", "contact", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "extra", "Landroid/os/Bundle;", "contactToIntent", "intent", "Landroid/content/Intent;", "intentToContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "saveMsgStrangerContact", "msgUsername", "showWxProfileDialog", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "context", "Landroid/content/Context;", "addBlackListener", "Lkotlin/Function1;", "updateDialog", "reqUsername", "dialog", "contactType", "", "updateWxProfile", "contentView", "Landroid/view/View;", "updateWxProfileFinderEntry", "plugin-finder_release"})
    public static final class a {

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, hxF = {"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
        public static final class i<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
            final /* synthetic */ Intent $intent;
            final /* synthetic */ d wpZ;
            final /* synthetic */ Bundle wqa;

            i(Intent intent, Bundle bundle, d dVar) {
                this.$intent = intent;
                this.wqa = bundle;
                this.wpZ = dVar;
            }

            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(261549);
                c.a aVar = (c.a) obj;
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    LinkedList<FinderContact> linkedList = ((aru) aVar.iLC).LCI;
                    p.g(linkedList, "back.resp.contactList");
                    if (!linkedList.isEmpty()) {
                        LinkedList<FinderContact> linkedList2 = ((aru) aVar.iLC).LCI;
                        p.g(linkedList2, "back.resp.contactList");
                        FinderContact finderContact = (FinderContact) kotlin.a.j.kt(linkedList2);
                        if (finderContact != null) {
                            this.$intent.putExtra("V5UserName", finderContact.wx_username_v5);
                            this.wqa.putString("V5UserName", finderContact.wx_username_v5);
                            a aVar2 = n.wpY;
                            a.a(finderContact.wx_username_v5, this.wqa, this.wpZ, 2);
                            x xVar = x.SXb;
                            AppMethodBeat.o(261549);
                            return xVar;
                        }
                        AppMethodBeat.o(261549);
                        return null;
                    }
                }
                Log.i(n.TAG, "acquire v5 failed.");
                x xVar2 = x.SXb;
                AppMethodBeat.o(261549);
                return xVar2;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfile$1$1"})
        public static final class e implements View.OnClickListener {
            final /* synthetic */ bbn $contextObj;
            final /* synthetic */ String $sessionId;
            final /* synthetic */ ConstraintLayout UVA;
            final /* synthetic */ String hLl;
            final /* synthetic */ long txv;
            final /* synthetic */ String vvZ;
            final /* synthetic */ long vwa;
            final /* synthetic */ Bundle wqh;
            final /* synthetic */ ImageView wqi;
            final /* synthetic */ TextView wqj;
            final /* synthetic */ View wqk;
            final /* synthetic */ TextView wql;
            final /* synthetic */ TextView wqm;
            final /* synthetic */ TextView wqn;
            final /* synthetic */ TextView wqo;
            final /* synthetic */ TextView wqp;
            final /* synthetic */ kotlin.g.a.b wqq;

            e(String str, String str2, String str3, long j2, long j3, bbn bbn, Bundle bundle, ImageView imageView, TextView textView, View view, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, kotlin.g.a.b bVar, ConstraintLayout constraintLayout) {
                this.vvZ = str;
                this.$sessionId = str2;
                this.hLl = str3;
                this.txv = j2;
                this.vwa = j3;
                this.$contextObj = bbn;
                this.wqh = bundle;
                this.wqi = imageView;
                this.wqj = textView;
                this.wqk = view;
                this.wql = textView2;
                this.wqm = textView3;
                this.wqn = textView4;
                this.wqo = textView5;
                this.wqp = textView6;
                this.wqq = bVar;
                this.UVA = constraintLayout;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(255033);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfile$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String str = this.vvZ;
                if (str == null || str.length() == 0) {
                    com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                    Context context = this.wqk.getContext();
                    p.g(context, "contentView.context");
                    String str2 = this.$sessionId;
                    p.g(str2, "sessionId");
                    String str3 = this.hLl;
                    p.g(str3, ch.COL_USERNAME);
                    com.tencent.mm.plugin.finder.utils.a.a(context, str2, str3, this.txv, this.vwa, this.$contextObj);
                } else {
                    com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    Context context2 = this.wqk.getContext();
                    p.g(context2, "contentView.context");
                    String str4 = this.$sessionId;
                    p.g(str4, "sessionId");
                    com.tencent.mm.plugin.finder.utils.a.a(context2, str4, this.vvZ, this.$contextObj);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfile$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(255033);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfile$1$2"})
        public static final class f implements View.OnClickListener {
            final /* synthetic */ ConstraintLayout UVA;
            final /* synthetic */ String tpD;
            final /* synthetic */ long txv;
            final /* synthetic */ String vvZ;
            final /* synthetic */ long vwa;
            final /* synthetic */ Bundle wqh;
            final /* synthetic */ ImageView wqi;
            final /* synthetic */ TextView wqj;
            final /* synthetic */ View wqk;
            final /* synthetic */ TextView wql;
            final /* synthetic */ TextView wqm;
            final /* synthetic */ TextView wqn;
            final /* synthetic */ TextView wqo;
            final /* synthetic */ TextView wqp;
            final /* synthetic */ kotlin.g.a.b wqq;

            f(String str, long j2, long j3, String str2, Bundle bundle, ImageView imageView, TextView textView, View view, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, kotlin.g.a.b bVar, ConstraintLayout constraintLayout) {
                this.vvZ = str;
                this.vwa = j2;
                this.txv = j3;
                this.tpD = str2;
                this.wqh = bundle;
                this.wqi = imageView;
                this.wqj = textView;
                this.wqk = view;
                this.wql = textView2;
                this.wqm = textView3;
                this.wqn = textView4;
                this.wqo = textView5;
                this.wqp = textView6;
                this.wqq = bVar;
                this.UVA = constraintLayout;
            }

            public final void onClick(View view) {
                ai<ayt> aiVar = null;
                AppMethodBeat.i(255034);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfile$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.b bVar2 = this.wqq;
                if (bVar2 != null) {
                    bVar2.invoke(this.vvZ);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfile$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(255034);
                    return;
                }
                if (this.wqk.getContext() instanceof ai) {
                    try {
                        Context context = this.wqk.getContext();
                        if (context == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.findersdk.api.IModifyUserResult<com.tencent.mm.protocal.protobuf.FinderModBlackList>");
                            AppMethodBeat.o(255034);
                            throw tVar;
                        }
                        aiVar = (ai) context;
                    } catch (ClassCastException e2) {
                    }
                }
                if (!Util.isNullOrNil(this.vvZ)) {
                    String nullAsNil = Util.nullAsNil(this.vvZ);
                    p.g(nullAsNil, "Util.nullAsNil(fansId)");
                    ((com.tencent.mm.plugin.i.a.t) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.t.class)).b(nullAsNil, true, aiVar);
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    Context context2 = this.wqk.getContext();
                    p.g(context2, "contentView.context");
                    com.tencent.mm.plugin.finder.report.k.b(context2, 8, 4);
                } else {
                    long j2 = this.vwa;
                    long j3 = this.txv;
                    String str = this.tpD;
                    p.g(str, "nonceId");
                    ((com.tencent.mm.plugin.i.a.t) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.t.class)).a(j2, j3, str, aiVar);
                    com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                    Context context3 = this.wqk.getContext();
                    p.g(context3, "contentView.context");
                    com.tencent.mm.plugin.finder.report.k.b(context3, 11, 4);
                }
                TextView textView = this.wqp;
                p.g(textView, "addBlackList");
                textView.setVisibility(4);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfile$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(255034);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfile$1$3"})
        public static final class g implements View.OnClickListener {
            final /* synthetic */ ConstraintLayout UVA;
            final /* synthetic */ long txv;
            final /* synthetic */ long vwa;
            final /* synthetic */ Bundle wqh;
            final /* synthetic */ ImageView wqi;
            final /* synthetic */ TextView wqj;
            final /* synthetic */ View wqk;
            final /* synthetic */ TextView wql;
            final /* synthetic */ TextView wqm;
            final /* synthetic */ TextView wqn;
            final /* synthetic */ TextView wqo;
            final /* synthetic */ TextView wqp;
            final /* synthetic */ kotlin.g.a.b wqq;

            g(long j2, long j3, Bundle bundle, ImageView imageView, TextView textView, View view, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, kotlin.g.a.b bVar, ConstraintLayout constraintLayout) {
                this.txv = j2;
                this.vwa = j3;
                this.wqh = bundle;
                this.wqi = imageView;
                this.wqj = textView;
                this.wqk = view;
                this.wql = textView2;
                this.wqm = textView3;
                this.wqn = textView4;
                this.wqo = textView5;
                this.wqp = textView6;
                this.wqq = bVar;
                this.UVA = constraintLayout;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(255035);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfile$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.finder.feed.logic.a aVar = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                Context context = this.wqk.getContext();
                p.g(context, "contentView.context");
                com.tencent.mm.plugin.finder.feed.logic.a.a(context, this.txv, this.vwa, 0, 8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfile$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(255035);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class h implements View.OnClickListener {
            public static final h wqr = new h();

            static {
                AppMethodBeat.i(255037);
                AppMethodBeat.o(255037);
            }

            h() {
            }

            public final void onClick(View view) {
                AppMethodBeat.i(255036);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfile$1$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfile$1$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(255036);
            }
        }

        static void a(View view, Bundle bundle) {
            String str;
            String str2;
            String str3;
            T t;
            v vVar;
            LinkedList<FinderObject> linkedList;
            AppMethodBeat.i(261554);
            View findViewById = view.findViewById(R.id.jtw);
            View findViewById2 = view.findViewById(R.id.k0x);
            FinderHalfContactItem finderHalfContactItem = (FinderHalfContactItem) view.findViewById(R.id.jtx);
            FinderHalfContactItem finderHalfContactItem2 = (FinderHalfContactItem) view.findViewById(R.id.jty);
            Context context = view.getContext();
            String string = context.getString(R.string.da9);
            p.g(string, "context.getString(R.string.finder_title)");
            finderHalfContactItem.setTitle(string);
            String string2 = context.getString(R.string.jcy);
            p.g(string2, "context.getString(R.stri…finder_recent_like_entry)");
            finderHalfContactItem2.setTitle(string2);
            p.g(findViewById, "entryContainer");
            findViewById.setVisibility(8);
            if (bundle == null || (str = bundle.getString("UserPreviewInfo", "")) == null) {
                str = "";
            }
            if (bundle == null || (str2 = bundle.getString("V5UserName", "")) == null) {
                str2 = "";
            }
            if (bundle == null || (str3 = bundle.getString("Nickname", "")) == null) {
                str3 = "";
            }
            String str4 = str;
            if (!(str4 == null || str4.length() == 0)) {
                eoy eoy = new eoy();
                try {
                    eoy.parseFrom(com.tencent.e.f.e.bqe(str));
                } catch (Exception e2) {
                    Log.printDebugStack("safeParser", "", e2);
                    eoy = null;
                }
                eoy eoy2 = eoy;
                if (eoy2 != null) {
                    findViewById.setVisibility(0);
                    z.f fVar = new z.f();
                    fVar.SYG = "";
                    if (eoy2.contact == null) {
                        p.g(finderHalfContactItem, "finderEntry");
                        finderHalfContactItem.setVisibility(8);
                    } else {
                        p.g(finderHalfContactItem, "finderEntry");
                        finderHalfContactItem.setVisibility(0);
                        if (eoy2.LNG == 0) {
                            eoz eoz = new eoz();
                            eoz.LCW.addAll(eoy2.LCW);
                            finderHalfContactItem.a(eoz);
                        } else {
                            finderHalfContactItem.a(null);
                        }
                        FinderContact finderContact = eoy2.contact;
                        if (finderContact == null || (t = (T) finderContact.username) == null) {
                            t = (T) "";
                        }
                        fVar.SYG = t;
                    }
                    if (eoy2.LNI == 1) {
                        p.g(finderHalfContactItem2, "recentLikeEntry");
                        finderHalfContactItem2.setVisibility(0);
                        if (finderHalfContactItem.getVisibility() == 0) {
                            finderHalfContactItem2.a(null);
                        } else {
                            eoz eoz2 = new eoz();
                            LinkedList<FinderObject> linkedList2 = eoz2.LCW;
                            aso aso = eoy2.LNJ;
                            if (aso == null || (linkedList = aso.LDv) == null) {
                                vVar = v.SXr;
                            } else {
                                vVar = linkedList;
                            }
                            linkedList2.addAll(vVar);
                            finderHalfContactItem2.a(eoz2);
                        }
                    } else {
                        p.g(finderHalfContactItem2, "recentLikeEntry");
                        finderHalfContactItem2.setVisibility(8);
                    }
                    finderHalfContactItem.setOnClickListener(new k(fVar, findViewById, finderHalfContactItem, finderHalfContactItem2, context, str2, str3, findViewById2));
                    finderHalfContactItem2.setOnClickListener(new l(findViewById, finderHalfContactItem, finderHalfContactItem2, context, str2, str3, findViewById2));
                    if (finderHalfContactItem.getVisibility() == 0 && finderHalfContactItem2.getVisibility() == 0) {
                        p.g(findViewById2, "middleLine");
                        findViewById2.setVisibility(0);
                        AppMethodBeat.o(261554);
                        return;
                    }
                    p.g(findViewById2, "middleLine");
                    findViewById2.setVisibility(8);
                    if (finderHalfContactItem.getVisibility() == 8 && finderHalfContactItem2.getVisibility() == 8) {
                        findViewById.setVisibility(8);
                    }
                    AppMethodBeat.o(261554);
                    return;
                }
            }
            AppMethodBeat.o(261554);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfileFinderEntry$1$3"})
        public static final class k implements View.OnClickListener {
            final /* synthetic */ Context $context$inlined;
            final /* synthetic */ z.f UVB;
            final /* synthetic */ View UVC;
            final /* synthetic */ FinderHalfContactItem UVD;
            final /* synthetic */ FinderHalfContactItem UVE;
            final /* synthetic */ String UVF;
            final /* synthetic */ View UVG;
            final /* synthetic */ String uhS;

            k(z.f fVar, View view, FinderHalfContactItem finderHalfContactItem, FinderHalfContactItem finderHalfContactItem2, Context context, String str, String str2, View view2) {
                this.UVB = fVar;
                this.UVC = view;
                this.UVD = finderHalfContactItem;
                this.UVE = finderHalfContactItem2;
                this.$context$inlined = context;
                this.uhS = str;
                this.UVF = str2;
                this.UVG = view2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(261552);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfileFinderEntry$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!Util.isNullOrNil((String) this.UVB.SYG)) {
                    Intent intent = new Intent();
                    intent.putExtra("finder_username", (String) this.UVB.SYG);
                    intent.putExtra("key_enter_profile_type", 14);
                    boolean j2 = p.j(this.UVB.SYG, com.tencent.mm.model.z.aUg());
                    ((aj) com.tencent.mm.kernel.g.ah(aj.class)).fillContextIdToIntent(14, 2, j2 ? 33 : 32, intent);
                    intent.putExtra("KEY_FINDER_SELF_FLAG", j2);
                    ((aj) com.tencent.mm.kernel.g.ah(aj.class)).enterFinderProfileUI(this.$context$inlined, intent);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfileFinderEntry$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(261552);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfileFinderEntry$1$4"})
        public static final class l implements View.OnClickListener {
            final /* synthetic */ Context $context$inlined;
            final /* synthetic */ View UVC;
            final /* synthetic */ FinderHalfContactItem UVD;
            final /* synthetic */ FinderHalfContactItem UVE;
            final /* synthetic */ String UVF;
            final /* synthetic */ View UVG;
            final /* synthetic */ String uhS;

            l(View view, FinderHalfContactItem finderHalfContactItem, FinderHalfContactItem finderHalfContactItem2, Context context, String str, String str2, View view2) {
                this.UVC = view;
                this.UVD = finderHalfContactItem;
                this.UVE = finderHalfContactItem2;
                this.$context$inlined = context;
                this.uhS = str;
                this.UVF = str2;
                this.UVG = view2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(261553);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfileFinderEntry$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!Util.isNullOrNil(this.uhS)) {
                    com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(aj.class);
                    p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
                    ((aj) ah).getFinderUtilApi().b(this.$context$inlined, this.uhS, this.UVF, 98);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfileFinderEntry$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(261553);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:31:0x013e, code lost:
            if ((r2 == null || r2.length() == 0) == false) goto L_0x0140;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.tencent.mm.plugin.finder.view.d a(android.content.Context r20, android.content.Intent r21, kotlin.g.a.b<? super java.lang.String, kotlin.x> r22) {
            /*
            // Method dump skipped, instructions count: 507
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.view.n.a.a(android.content.Context, android.content.Intent, kotlin.g.a.b):com.tencent.mm.plugin.finder.view.d");
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.finder.view.n$a$a  reason: collision with other inner class name */
        public static final class View$OnClickListenerC1346a implements View.OnClickListener {
            final /* synthetic */ d wpZ;

            View$OnClickListenerC1346a(d dVar) {
                this.wpZ = dVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(255026);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$showWxProfileDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.wpZ.bMo();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$showWxProfileDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(255026);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        public static final class d implements Runnable {
            final /* synthetic */ Context $context;
            final /* synthetic */ z.f wqe;

            d(z.f fVar, Context context) {
                this.wqe = fVar;
                this.$context = context;
            }

            public final void run() {
                AppMethodBeat.i(255032);
                this.wqe.SYG = (T) q.a(this.$context, this.$context.getResources().getString(R.string.a06), true, 0, AnonymousClass1.wqg);
                AppMethodBeat.o(255032);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "newContact", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "onDone"})
        public static final class c implements m.a {
            final /* synthetic */ z.f UVy;
            final /* synthetic */ d wpZ;
            final /* synthetic */ Bundle wqa;
            final /* synthetic */ kotlin.g.a.b wqb;
            final /* synthetic */ aps wqc;
            final /* synthetic */ com.tencent.f.i.d wqd;
            final /* synthetic */ z.f wqe;

            c(z.f fVar, Bundle bundle, aps aps, com.tencent.f.i.d dVar, z.f fVar2, d dVar2, kotlin.g.a.b bVar) {
                this.UVy = fVar;
                this.wqa = bundle;
                this.wqc = aps;
                this.wqd = dVar;
                this.wqe = fVar2;
                this.wpZ = dVar2;
                this.wqb = bVar;
            }

            @Override // com.tencent.mm.plugin.i.a.m.a
            public final void c(ah ahVar) {
                AppMethodBeat.i(255030);
                p.g(ahVar, "newContact");
                if (p.j(this.UVy.SYG, ahVar.getUsername())) {
                    Log.i(n.TAG, "get contact success %s", this.UVy.SYG);
                    a aVar = n.wpY;
                    Bundle bundle = this.wqa;
                    p.h(ahVar, "contact");
                    p.h(bundle, "extra");
                    bundle.putString("Avatar", ahVar.cXH());
                    bundle.putString("Nickname", ahVar.arJ());
                    bundle.putInt("Sex", ahVar.ajE());
                    bundle.putLong("contactId", ahVar.cXJ());
                    bundle.putString("Province", ahVar.getProvince());
                    bundle.putString("City", ahVar.getCity());
                    bundle.putString("Country", ahVar.getCountry());
                    bundle.putString("Signature", ahVar.getSignature());
                    a aVar2 = n.wpY;
                    a.o(this.wqc.LBC, this.wqa);
                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.finder.view.n.a.c.AnonymousClass1 */
                        final /* synthetic */ c wqf;

                        {
                            this.wqf = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(255028);
                            this.wqf.wqd.cancel(false);
                            T t = this.wqf.wqe.SYG;
                            if (t != null) {
                                t.dismiss();
                            }
                            a aVar = n.wpY;
                            View view = this.wqf.wpZ.lJI;
                            p.g(view, "dialog.rootView");
                            a.a(view, this.wqf.wqa, this.wqf.wqb);
                            x xVar = x.SXb;
                            AppMethodBeat.o(255028);
                            return xVar;
                        }
                    });
                    AppMethodBeat.o(255030);
                    return;
                }
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.view.n.a.c.AnonymousClass2 */
                    final /* synthetic */ c wqf;

                    {
                        this.wqf = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(255029);
                        this.wqf.wqd.cancel(false);
                        T t = this.wqf.wqe.SYG;
                        if (t != null) {
                            t.dismiss();
                        }
                        a aVar = n.wpY;
                        View view = this.wqf.wpZ.lJI;
                        p.g(view, "dialog.rootView");
                        a.a(view, this.wqf.wqa, this.wqf.wqb);
                        x xVar = x.SXb;
                        AppMethodBeat.o(255029);
                        return xVar;
                    }
                });
                AppMethodBeat.o(255030);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateDialog$1", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "", "onCallback", "", "ret", "plugin-finder_release"})
        public static final class j implements af.a<Object> {
            final /* synthetic */ d wpZ;
            final /* synthetic */ Bundle wqa;

            j(Bundle bundle, d dVar) {
                this.wqa = bundle;
                this.wpZ = dVar;
            }

            @Override // com.tencent.mm.plugin.i.a.af.a
            public final void bn(Object obj) {
                AppMethodBeat.i(261551);
                p.h(obj, "ret");
                if (obj instanceof eoy) {
                    this.wqa.putString("UserPreviewInfo", com.tencent.e.f.e.bytesToHexString(((eoy) obj).toByteArray()));
                    com.tencent.mm.ac.d.h(new C1347a(this));
                }
                AppMethodBeat.o(261551);
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.finder.view.n$a$j$a  reason: collision with other inner class name */
            static final class C1347a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
                final /* synthetic */ j UVz;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C1347a(j jVar) {
                    super(0);
                    this.UVz = jVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(261550);
                    a aVar = n.wpY;
                    View view = this.UVz.wpZ.lJI;
                    p.g(view, "dialog.rootView");
                    a.a(view, this.UVz.wqa);
                    x xVar = x.SXb;
                    AppMethodBeat.o(261550);
                    return xVar;
                }
            }
        }

        static void a(String str, Bundle bundle, d dVar, int i2) {
            AppMethodBeat.i(261555);
            aa aaVar = aa.vYi;
            aa.a(str, null, new j(bundle, dVar), null, true, i2);
            AppMethodBeat.o(261555);
        }

        static void o(String str, Bundle bundle) {
            boolean z;
            AppMethodBeat.i(255039);
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                Log.e(n.TAG, "[saveMsgStrangerContact] msgUsername is null");
                AppMethodBeat.o(255039);
                return;
            }
            com.tencent.mm.plugin.finder.api.g aj = aj(bundle);
            aj.setUsername(str);
            boolean z2 = aj.cXH().length() == 0;
            if (z2) {
                Log.w(n.TAG, "nickname=" + aj.getNickname() + " avatarUrl is null. username=" + aj.getUsername());
            }
            ab msgStrangerContactStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMsgStrangerContactStorage();
            if (!z2) {
                z = true;
            } else {
                z = false;
            }
            msgStrangerContactStorage.a(aj, z);
            AppMethodBeat.o(255039);
        }

        public static void a(ah ahVar, Intent intent) {
            AppMethodBeat.i(255040);
            p.h(ahVar, "contact");
            p.h(intent, "intent");
            intent.putExtra("Username", ahVar.getUsername());
            intent.putExtra("Avatar", ahVar.cXH());
            intent.putExtra("Nickname", ahVar.arJ());
            intent.putExtra("Sex", ahVar.ajE());
            intent.putExtra("contactId", ahVar.cXJ());
            intent.putExtra("Province", ahVar.getProvince());
            intent.putExtra("City", ahVar.getCity());
            intent.putExtra("Signature", ahVar.getSignature());
            AppMethodBeat.o(255040);
        }

        private static com.tencent.mm.plugin.finder.api.g aj(Bundle bundle) {
            AppMethodBeat.i(255041);
            com.tencent.mm.plugin.finder.api.g gVar = new com.tencent.mm.plugin.finder.api.g();
            String string = bundle.getString("Username", "");
            p.g(string, "extra.getString(Constant…erWxProfile.Username, \"\")");
            gVar.setUsername(string);
            String string2 = bundle.getString("Nickname", "");
            p.g(string2, "extra.getString(Constant…erWxProfile.Nickname, \"\")");
            gVar.setNickname(string2);
            gVar.nj(bundle.getInt("Sex", 0));
            String string3 = bundle.getString("Signature", "");
            p.g(string3, "extra.getString(Constant…rWxProfile.Signature, \"\")");
            gVar.BV(string3);
            String string4 = bundle.getString("Province", "");
            p.g(string4, "extra.getString(Constant…erWxProfile.Province, \"\")");
            gVar.BW(string4);
            String string5 = bundle.getString("City", "");
            p.g(string5, "extra.getString(Constant…FinderWxProfile.City, \"\")");
            gVar.BX(string5);
            String string6 = bundle.getString("Avatar", "");
            p.g(string6, "extra.getString(Constant…nderWxProfile.Avatar, \"\")");
            gVar.asL(string6);
            AppMethodBeat.o(255041);
            return gVar;
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ d wpZ;
            final /* synthetic */ Bundle wqa;
            final /* synthetic */ kotlin.g.a.b wqb;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(d dVar, Bundle bundle, kotlin.g.a.b bVar) {
                super(0);
                this.wpZ = dVar;
                this.wqa = bundle;
                this.wqb = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(255027);
                a aVar = n.wpY;
                View view = this.wpZ.lJI;
                p.g(view, "dialog.rootView");
                a.a(view, this.wqa, this.wqb);
                x xVar = x.SXb;
                AppMethodBeat.o(255027);
                return xVar;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:61:0x03b2, code lost:
            if (r4 == false) goto L_0x03b4;
         */
        /* JADX WARNING: Removed duplicated region for block: B:101:0x04d4  */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x04f7  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x04fb  */
        /* JADX WARNING: Removed duplicated region for block: B:119:0x0568  */
        /* JADX WARNING: Removed duplicated region for block: B:120:0x05b2  */
        /* JADX WARNING: Removed duplicated region for block: B:121:0x05d7  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0352  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0358  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x03e0  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x03fa  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0403  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x040b  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x041b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final /* synthetic */ void a(android.view.View r43, android.os.Bundle r44, kotlin.g.a.b r45) {
            /*
            // Method dump skipped, instructions count: 1550
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.view.n.a.a(android.view.View, android.os.Bundle, kotlin.g.a.b):void");
        }
    }

    static {
        AppMethodBeat.i(255043);
        AppMethodBeat.o(255043);
    }
}
