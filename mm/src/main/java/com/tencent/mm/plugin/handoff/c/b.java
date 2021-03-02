package com.tencent.mm.plugin.handoff.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0002\b\u0005\n\u0002\u0010\n\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005H\b\u001a\u001d\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\b\u001a\u001f\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0004\u001a\u0017\u0010\u000b\u001a\u00020\t*\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0004\u001a\"\u0010\u000b\u001a\u00020\t*\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\bH\u0004¢\u0006\u0002\u0010\u0011\u001a\"\u0010\u000b\u001a\u00020\t*\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\bH\u0004¢\u0006\u0002\u0010\u0013\u001a\"\u0010\u000b\u001a\u00020\t*\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\bH\u0004¢\u0006\u0002\u0010\u0014\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u0015H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u0016H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u0017H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u0018H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u0019H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u001aH\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u0012H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u001bH\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u001cH\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u001dH\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u001eH\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u001fH\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020 H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020!H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\"H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020#H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0004\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u001f\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0010H\u0002\u001a*\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\bH\u0002¢\u0006\u0002\u0010&\u001a*\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\bH\u0002¢\u0006\u0002\u0010'\u001a*\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\bH\u0002¢\u0006\u0002\u0010(\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0015H\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0016H\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0017H\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0018H\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0019H\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001aH\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0012H\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001bH\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001cH\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001dH\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001eH\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001fH\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020 H\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020!H\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\"H\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020)H\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020#H\u0002\u001a\u001d\u0010$\u001a\u00020\u0004*\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¨\u0006*"}, hxF = {"bundle", "Landroid/os/Bundle;", "initFun", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "bundleOf", "pairs", "", "Lcom/tencent/mm/plugin/handoff/service/BundlePair;", "([Lcom/tencent/mm/plugin/handoff/service/BundlePair;)Landroid/os/Bundle;", "bundleTo", "", "value", "Landroid/os/Parcelable;", "n", "Ljava/lang/Void;", "(Ljava/lang/String;[Landroid/os/Parcelable;)Lcom/tencent/mm/plugin/handoff/service/BundlePair;", "", "(Ljava/lang/String;[Ljava/lang/CharSequence;)Lcom/tencent/mm/plugin/handoff/service/BundlePair;", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/handoff/service/BundlePair;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "set", "key", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Parcelable;)V", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/CharSequence;)V", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/String;)V", "", "plugin-handoff_release"})
public final class b {
    public static final c ig(String str, String str2) {
        AppMethodBeat.i(199155);
        p.h(str, "$this$bundleTo");
        p.h(str2, "value");
        c cVar = new c(new c(str, str2));
        AppMethodBeat.o(199155);
        return cVar;
    }

    public static final void a(Bundle bundle, String str, String str2) {
        AppMethodBeat.i(199156);
        p.h(bundle, "$this$set");
        p.h(str, "key");
        p.h(str2, "value");
        bundle.putString(str, str2);
        AppMethodBeat.o(199156);
    }

    public static final Bundle a(c... cVarArr) {
        AppMethodBeat.i(199154);
        p.h(cVarArr, "pairs");
        Bundle bundle = new Bundle();
        for (c cVar : cVarArr) {
            p.h(bundle, "bundle");
            cVar.yhT.invoke(bundle);
        }
        AppMethodBeat.o(199154);
        return bundle;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Bundle;", "invoke"})
    static final class a extends q implements kotlin.g.a.b<Bundle, x> {
        final /* synthetic */ String yhQ;
        final /* synthetic */ int yhR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, int i2) {
            super(1);
            this.yhQ = str;
            this.yhR = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Bundle bundle) {
            AppMethodBeat.i(199151);
            Bundle bundle2 = bundle;
            p.h(bundle2, LocaleUtil.ITALIAN);
            String str = this.yhQ;
            int i2 = this.yhR;
            p.h(bundle2, "$this$set");
            p.h(str, "key");
            bundle2.putInt(str, i2);
            x xVar = x.SXb;
            AppMethodBeat.o(199151);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Bundle;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.handoff.c.b$b  reason: collision with other inner class name */
    static final class C1432b extends q implements kotlin.g.a.b<Bundle, x> {
        final /* synthetic */ String yhQ;
        final /* synthetic */ long yhS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1432b(String str, long j2) {
            super(1);
            this.yhQ = str;
            this.yhS = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Bundle bundle) {
            AppMethodBeat.i(199152);
            Bundle bundle2 = bundle;
            p.h(bundle2, LocaleUtil.ITALIAN);
            String str = this.yhQ;
            long j2 = this.yhS;
            p.h(bundle2, "$this$set");
            p.h(str, "key");
            bundle2.putLong(str, j2);
            x xVar = x.SXb;
            AppMethodBeat.o(199152);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Bundle;", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<Bundle, x> {
        final /* synthetic */ String gUd;
        final /* synthetic */ String yhQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, String str2) {
            super(1);
            this.yhQ = str;
            this.gUd = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Bundle bundle) {
            AppMethodBeat.i(199153);
            Bundle bundle2 = bundle;
            p.h(bundle2, LocaleUtil.ITALIAN);
            b.a(bundle2, this.yhQ, this.gUd);
            x xVar = x.SXb;
            AppMethodBeat.o(199153);
            return xVar;
        }
    }
}
