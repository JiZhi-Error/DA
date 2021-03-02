package com.tencent.mm.plugin.appbrand.config.a;

import com.facebook.appevents.UserDataStore;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.r;
import com.tencent.mm.plugin.appbrand.ab.d;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "batchUpdatePrefetchTime", "", "usernameList", "", "", "contains", "", "key", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "delete", "get", "updatePrefetchTime", "KEY", "plugin-appbrand-integration_release"})
public final class b extends MAutoStorage<a> {
    private final ISQLiteDatabase db;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.iBg, "AppBrandPrefetchWxaAttrsMarkTable", r.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        AppMethodBeat.i(228184);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(228184);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "", "()V", "APPID", "USERNAME", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$APPID;", "plugin-appbrand-integration_release"})
    public static abstract class a {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.config.a.b$a$b  reason: collision with other inner class name */
        public static final class C0564b extends a {
            final String value;

            public final boolean equals(Object obj) {
                AppMethodBeat.i(228179);
                if (this == obj || ((obj instanceof C0564b) && p.j(this.value, ((C0564b) obj).value))) {
                    AppMethodBeat.o(228179);
                    return true;
                }
                AppMethodBeat.o(228179);
                return false;
            }

            public final int hashCode() {
                AppMethodBeat.i(228178);
                String str = this.value;
                if (str != null) {
                    int hashCode = str.hashCode();
                    AppMethodBeat.o(228178);
                    return hashCode;
                }
                AppMethodBeat.o(228178);
                return 0;
            }

            public final String toString() {
                AppMethodBeat.i(228177);
                String str = "USERNAME(value=" + this.value + ")";
                AppMethodBeat.o(228177);
                return str;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0564b(String str) {
                super((byte) 0);
                p.h(str, "value");
                AppMethodBeat.i(228176);
                this.value = str;
                AppMethodBeat.o(228176);
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$APPID;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.config.a.b$a$a  reason: collision with other inner class name */
        public static final class C0563a extends a {
            final String value;

            public final boolean equals(Object obj) {
                AppMethodBeat.i(228175);
                if (this == obj || ((obj instanceof C0563a) && p.j(this.value, ((C0563a) obj).value))) {
                    AppMethodBeat.o(228175);
                    return true;
                }
                AppMethodBeat.o(228175);
                return false;
            }

            public final int hashCode() {
                AppMethodBeat.i(228174);
                String str = this.value;
                if (str != null) {
                    int hashCode = str.hashCode();
                    AppMethodBeat.o(228174);
                    return hashCode;
                }
                AppMethodBeat.o(228174);
                return 0;
            }

            public final String toString() {
                AppMethodBeat.i(228173);
                String str = "APPID(value=" + this.value + ")";
                AppMethodBeat.o(228173);
                return str;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0563a(String str) {
                super((byte) 0);
                p.h(str, "value");
                AppMethodBeat.i(228172);
                this.value = str;
                AppMethodBeat.o(228172);
            }
        }
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(228181);
        p.h(aVar, "key");
        p.h(aVar, "key");
        a aVar2 = new a();
        aVar2.field_appId = ((a.C0563a) aVar).value;
        if (!super.get(aVar2, "appId")) {
            aVar2 = null;
        }
        if (aVar2 != null) {
            AppMethodBeat.o(228181);
            return true;
        }
        AppMethodBeat.o(228181);
        return false;
    }

    public final void br(List<String> list) {
        AppMethodBeat.i(228182);
        p.h(list, "usernameList");
        d dVar = d.nOm;
        d.a(this.db, new C0565b(this, list));
        AppMethodBeat.o(228182);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(228183);
        p.h(aVar, "key");
        long nowSecond = Util.nowSecond();
        a aVar2 = new a();
        aVar2.field_prefetchUpdateTime = nowSecond;
        aVar2.field_username = ((a.C0564b) aVar).value;
        aVar2.field_appId = y.Xw(aVar2.field_username);
        super.replace(aVar2);
        AppMethodBeat.o(228183);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.config.a.b$b  reason: collision with other inner class name */
    public static final class C0565b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ List kPr;
        final /* synthetic */ b lht;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0565b(b bVar, List list) {
            super(0);
            this.lht = bVar;
            this.kPr = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(228180);
            for (String str : this.kPr) {
                String str2 = str;
                if (!(str2 == null || str2.length() == 0)) {
                    this.lht.b(new a.C0564b(str));
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(228180);
            return xVar;
        }
    }
}
