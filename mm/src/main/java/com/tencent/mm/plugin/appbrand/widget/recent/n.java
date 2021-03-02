package com.tencent.mm.plugin.appbrand.widget.recent;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Arrays;
import kotlin.a.e;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0004J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001d\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;", "", "args", "", "([Ljava/lang/Object;)V", "getArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
public class n {
    final Object[] args;

    public n(Object... objArr) {
        p.h(objArr, "args");
        AppMethodBeat.i(229688);
        this.args = objArr;
        AppMethodBeat.o(229688);
    }

    public String toString() {
        AppMethodBeat.i(229685);
        String a2 = e.a(this.args, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, a.oDN, 31);
        AppMethodBeat.o(229685);
        return a2;
    }

    public int hashCode() {
        AppMethodBeat.i(229686);
        int hashCode = toString().hashCode();
        AppMethodBeat.o(229686);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(229687);
        if (this == obj) {
            AppMethodBeat.o(229687);
            return true;
        } else if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.widget.recent.QueryCacheConfig");
            AppMethodBeat.o(229687);
            throw tVar;
        } else if (!Arrays.equals(this.args, ((n) obj).args)) {
            AppMethodBeat.o(229687);
            return false;
        } else {
            AppMethodBeat.o(229687);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class a extends q implements b<Object, CharSequence> {
        public static final a oDN = new a();

        static {
            AppMethodBeat.i(229684);
            AppMethodBeat.o(229684);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.b
        public final /* synthetic */ CharSequence invoke(Object obj) {
            String obj2;
            AppMethodBeat.i(229683);
            if (obj == null || (obj2 = obj.toString()) == null) {
                AppMethodBeat.o(229683);
                return r0;
            }
            String str = obj2;
            AppMethodBeat.o(229683);
            return str;
        }
    }
}
