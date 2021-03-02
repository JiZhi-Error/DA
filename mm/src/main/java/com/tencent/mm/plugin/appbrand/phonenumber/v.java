package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.permission.h;
import com.tencent.mm.plugin.appbrand.phonenumber.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u00062\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u00020\u000e2\u0006\u00103\u001a\u000204H\u0016J\b\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020\u000eH\u0016J\u0010\u0010>\u001a\u00020\u000e2\u0006\u00103\u001a\u000204H\u0016J\u0010\u0010?\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020<H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R&\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000e0#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(RD\u0010,\u001a\u0012\u0012\u0004\u0012\u00020$0*j\b\u0012\u0004\u0012\u00020$`+2\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020$0*j\b\u0012\u0004\u0012\u00020$`+@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "context", "Landroid/content/Context;", "appId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "value", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "dismiss", "getDialogHeight", "", "onBackPressedEvent", "", "onDismiss", "show", "showPrivacyExplainEntry", "luggage-wechat-full-sdk_release"})
public final class v extends a implements com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a {
    final String appId;
    ArrayList<PhoneItem> lJn = new ArrayList<>();
    kotlin.g.a.a<x> lJo = a.nAg;
    kotlin.g.a.a<x> lJq = c.nAi;
    kotlin.g.a.a<x> lJt = e.nAk;
    kotlin.g.a.a<x> lJu = b.nAh;
    kotlin.g.a.a<x> lJv = f.nAl;
    private q nch;
    kotlin.g.a.a<x> nci = d.nAj;
    kotlin.g.a.b<? super PhoneItem, x> ncj = g.nAm;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        public static final a nAg = new a();

        static {
            AppMethodBeat.i(148126);
            AppMethodBeat.o(148126);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        public static final b nAh = new b();

        static {
            AppMethodBeat.i(148127);
            AppMethodBeat.o(148127);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        public static final c nAi = new c();

        static {
            AppMethodBeat.i(148128);
            AppMethodBeat.o(148128);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        public static final d nAj = new d();

        static {
            AppMethodBeat.i(148129);
            AppMethodBeat.o(148129);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        public static final e nAk = new e();

        static {
            AppMethodBeat.i(148130);
            AppMethodBeat.o(148130);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        public static final f nAl = new f();

        static {
            AppMethodBeat.i(148131);
            AppMethodBeat.o(148131);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "invoke"})
    static final class g extends q implements kotlin.g.a.b<PhoneItem, x> {
        public static final g nAm = new g();

        static {
            AppMethodBeat.i(230149);
            AppMethodBeat.o(230149);
        }

        g() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(PhoneItem phoneItem) {
            AppMethodBeat.i(230148);
            p.h(phoneItem, LocaleUtil.ITALIAN);
            x xVar = x.SXb;
            AppMethodBeat.o(230148);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(Context context, String str) {
        super(context);
        p.h(context, "context");
        p.h(str, "appId");
        AppMethodBeat.i(148135);
        this.appId = str;
        this.nyF = new a.b(this) {
            /* class com.tencent.mm.plugin.appbrand.phonenumber.v.AnonymousClass1 */
            final /* synthetic */ v nAf;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.nAf = r1;
            }

            @Override // com.tencent.mm.plugin.appbrand.phonenumber.a.b
            public final void yU(int i2) {
                ArrayList<PhoneItem> arrayList;
                AppMethodBeat.i(148123);
                switch (i2) {
                    case 1:
                        this.nAf.lJo.invoke();
                        q qVar = this.nAf.nch;
                        if (qVar != null) {
                            arrayList = qVar.lJn;
                        } else {
                            arrayList = null;
                        }
                        if (arrayList == null) {
                            p.hyc();
                        }
                        Iterator<PhoneItem> it = arrayList.iterator();
                        while (it.hasNext()) {
                            PhoneItem next = it.next();
                            if (next.nzz) {
                                kotlin.g.a.b<? super PhoneItem, x> bVar = this.nAf.ncj;
                                p.g(next, "phoneItem");
                                bVar.invoke(next);
                                AppMethodBeat.o(148123);
                                return;
                            }
                        }
                        break;
                    case 2:
                        this.nAf.nci.invoke();
                        AppMethodBeat.o(148123);
                        return;
                    case 3:
                        this.nAf.lJq.invoke();
                        break;
                }
                AppMethodBeat.o(148123);
            }
        };
        a(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.appbrand.phonenumber.v.AnonymousClass2 */
            final /* synthetic */ v nAf;

            {
                this.nAf = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(148124);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.nAf.lJt.invoke();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(148124);
            }
        });
        this.ncg.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.appbrand.phonenumber.v.AnonymousClass3 */
            final /* synthetic */ v nAf;

            {
                this.nAf = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(148125);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                switch (this.nAf.lJn.size()) {
                    case 1:
                        this.nAf.lJu.invoke();
                        break;
                    default:
                        this.nAf.lJv.invoke();
                        break;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(148125);
            }
        });
        this.ncf.setVisibility(0);
        AppMethodBeat.o(148135);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class h implements Runnable {
        final /* synthetic */ v nAf;

        h(v vVar) {
            this.nAf = vVar;
        }

        public final void run() {
            AppMethodBeat.i(148132);
            v vVar = this.nAf;
            String str = this.nAf.appId;
            Context context = this.nAf.getContext();
            p.g(context, "context");
            vVar.nch = new q(str, context, this.nAf.lJn);
            this.nAf.mRecyclerView.setAdapter(this.nAf.nch);
            if (this.nAf.lJn.size() == 0) {
                this.nAf.gAy.setVisibility(0);
                this.nAf.mRecyclerView.setVisibility(8);
                this.nAf.ncg.setVisibility(8);
                AppMethodBeat.o(148132);
            } else if (this.nAf.lJn.size() == 1) {
                this.nAf.gAy.setVisibility(8);
                this.nAf.mRecyclerView.setVisibility(0);
                RecyclerView.a adapter = this.nAf.mRecyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
                this.nAf.ncg.setVisibility(0);
                this.nAf.ncg.setText(this.nAf.getContext().getString(R.string.a2z));
                u uVar = u.nAe;
                u.bTz();
                AppMethodBeat.o(148132);
            } else {
                this.nAf.gAy.setVisibility(8);
                this.nAf.mRecyclerView.setVisibility(0);
                this.nAf.ncg.setVisibility(0);
                RecyclerView.a adapter2 = this.nAf.mRecyclerView.getAdapter();
                if (adapter2 != null) {
                    adapter2.notifyDataSetChanged();
                }
                this.nAf.ncg.setText(this.nAf.getContext().getString(R.string.a2x));
                u uVar2 = u.nAe;
                u.bTz();
                AppMethodBeat.o(148132);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.a
    public final void onDismiss() {
        AppMethodBeat.i(148134);
        onCancel();
        AppMethodBeat.o(148134);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k, com.tencent.mm.plugin.appbrand.phonenumber.a
    public final boolean bjb() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void setOnDeny(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(230151);
        p.h(aVar, "<set-?>");
        this.nci = aVar;
        AppMethodBeat.o(230151);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void setOnCancel(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(230152);
        p.h(aVar, "<set-?>");
        this.lJq = aVar;
        AppMethodBeat.o(230152);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void setOnExplain(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(230153);
        p.h(aVar, "<set-?>");
        this.lJt = aVar;
        AppMethodBeat.o(230153);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void setOnAddPhoneNumber(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(230154);
        p.h(aVar, "<set-?>");
        this.lJu = aVar;
        AppMethodBeat.o(230154);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void setOnManagePhoneNumber(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(230155);
        p.h(aVar, "<set-?>");
        this.lJv = aVar;
        AppMethodBeat.o(230155);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void setOnPhoneItemSelect(kotlin.g.a.b<? super PhoneItem, x> bVar) {
        AppMethodBeat.i(230156);
        p.h(bVar, "<set-?>");
        this.ncj = bVar;
        AppMethodBeat.o(230156);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ v nAf;

        i(v vVar) {
            this.nAf = vVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230150);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$showPrivacyExplainEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.nAf.lJt.invoke();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$showPrivacyExplainEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230150);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.h
    public final com.tencent.mm.plugin.appbrand.permission.g a(com.tencent.mm.plugin.appbrand.d dVar, String str, ag agVar) {
        AppMethodBeat.i(230159);
        p.h(dVar, "component");
        Context context = getContext();
        p.g(context, "this.context");
        k kVar = new k(agVar, str, context, this.jBN.getMeasuredHeight());
        com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid = dVar.getWindowAndroid();
        p.g(windowAndroid, "component.windowAndroid");
        if (windowAndroid.bsj()) {
            kVar.setPosition(1);
        }
        k kVar2 = kVar;
        AppMethodBeat.o(230159);
        return kVar2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void setPhoneItems(ArrayList<PhoneItem> arrayList) {
        AppMethodBeat.i(148133);
        p.h(arrayList, "value");
        this.lJn.clear();
        this.lJn.addAll(arrayList);
        m.runOnUiThread(new h(this));
        AppMethodBeat.o(148133);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void hm(boolean z) {
        int i2;
        AppMethodBeat.i(230157);
        ImageView imageView = this.nyD;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        if (z) {
            Drawable l = android.support.v4.content.b.l(getContext(), R.drawable.bxy);
            this.nyG = l;
            this.nyD.setVisibility(8);
            if (l != null) {
                this.nyD.setImageDrawable(this.nyG);
                this.nyD.setVisibility(0);
            }
            super.a(new i(this));
            AppMethodBeat.o(230157);
            return;
        }
        super.a((View.OnClickListener) null);
        AppMethodBeat.o(230157);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.f
    public final void h(com.tencent.mm.plugin.appbrand.d dVar) {
        AppMethodBeat.i(230158);
        p.h(dVar, "component");
        super.setPosition(this.jCs);
        p.h(dVar, "$this$findPromptViewContainer");
        p.h(dVar, "$this$findPromptViewContainer");
        h.a.k(dVar).b(this);
        AppMethodBeat.o(230158);
    }
}
