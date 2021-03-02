package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.aa;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.e;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0014J*\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000e2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u0012H\u0002J*\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000e2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\u0013H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/sns/ui/Festival2021Widget;", "Lcom/tencent/mm/plugin/sns/ui/FinderLiveWidget;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "snsType", "", "getSnsType", "()I", "onPrepareCommitPack", "", "packHelper", "Lcom/tencent/mm/plugin/sns/model/UploadPackHelper;", "safeGet", "", "Landroid/content/Intent;", "key", "block", "Lkotlin/Function1;", "Lkotlin/reflect/KFunction1;", "plugin-sns_release"})
public final class bx extends t {
    private final int FdB = 43;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "imgUrl", "", "invoke", "com/tencent/mm/plugin/sns/ui/Festival2021Widget$onPrepareCommitPack$1$3"})
    static final class a extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ bx VaM;
        final /* synthetic */ bf VaN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(bx bxVar, bf bfVar) {
            super(1);
            this.VaM = bxVar;
            this.VaN = bfVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(259395);
            String str2 = str;
            p.h(str2, "imgUrl");
            this.VaN.i(str2, "", "", -1, -1);
            x xVar = x.SXb;
            AppMethodBeat.o(259395);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012,\u0010\u0003\u001a( \u0002*\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00070\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/sns/model/UploadPackHelper;", "kotlin.jvm.PlatformType", "p1", "", "Lkotlin/ParameterName;", "name", "title", "invoke"})
    static final /* synthetic */ class b extends n implements kotlin.g.a.b<String, bf> {
        b(bf bfVar) {
            super(1, bfVar);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(259397);
            kotlin.l.b bp = aa.bp(bf.class);
            AppMethodBeat.o(259397);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "setObjTitle";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "setObjTitle(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/model/UploadPackHelper;";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ bf invoke(String str) {
            AppMethodBeat.i(259396);
            bf aPB = ((bf) this.SYl).aPB(str);
            AppMethodBeat.o(259396);
            return aPB;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012,\u0010\u0003\u001a( \u0002*\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00070\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/sns/model/UploadPackHelper;", "kotlin.jvm.PlatformType", "p1", "", "Lkotlin/ParameterName;", "name", "url", "invoke"})
    static final /* synthetic */ class c extends n implements kotlin.g.a.b<String, bf> {
        c(bf bfVar) {
            super(1, bfVar);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(259399);
            kotlin.l.b bp = aa.bp(bf.class);
            AppMethodBeat.o(259399);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "setObjUrl";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "setObjUrl(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/model/UploadPackHelper;";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ bf invoke(String str) {
            AppMethodBeat.i(259398);
            bf aPA = ((bf) this.SYl).aPA(str);
            AppMethodBeat.o(259398);
            return aPA;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ e VaO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(e eVar) {
            super(1);
            this.VaO = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(259400);
            String str2 = str;
            p.h(str2, LocaleUtil.ITALIAN);
            ((kotlin.g.a.b) this.VaO).invoke(str2);
            x xVar = x.SXb;
            AppMethodBeat.o(259400);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bx(MMActivity mMActivity) {
        super(mMActivity);
        p.h(mMActivity, "context");
        AppMethodBeat.i(259404);
        AppMethodBeat.o(259404);
    }

    private static String a(Intent intent, String str, kotlin.g.a.b<? super String, x> bVar) {
        AppMethodBeat.i(259401);
        String stringExtra = intent.getStringExtra(str);
        if (stringExtra != null) {
            String str2 = !kotlin.n.n.aL(stringExtra) ? stringExtra : null;
            if (str2 != null) {
                bVar.invoke(str2);
                AppMethodBeat.o(259401);
                return str2;
            }
        }
        AppMethodBeat.o(259401);
        return null;
    }

    private static String a(Intent intent, String str, e<? extends bf> eVar) {
        AppMethodBeat.i(259402);
        String a2 = a(intent, str, new d(eVar));
        AppMethodBeat.o(259402);
        return a2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.t
    public final int hWM() {
        return this.FdB;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.t
    public final void a(MMActivity mMActivity, bf bfVar) {
        AppMethodBeat.i(259403);
        p.h(mMActivity, "context");
        p.h(bfVar, "packHelper");
        Intent intent = mMActivity.getIntent();
        a(intent, "Ksnsupload_title", (e<? extends bf>) new b(bfVar));
        a(intent, "Ksnsupload_link", (e<? extends bf>) new c(bfVar));
        a(intent, "Ksnsupload_imgurl", new a(this, bfVar));
        super.a(mMActivity, bfVar);
        AppMethodBeat.o(259403);
    }
}
