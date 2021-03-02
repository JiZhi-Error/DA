package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.bk;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.d;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.e;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.h;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.n;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.backgroundfetch.g;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.launching.ar;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.c;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class b {
    static final Map<a, String[]> kHX = new HashMap();
    private static final Map<Class, Object> kHY = new HashMap();

    public interface a<T> {
        T b(ISQLiteDatabase iSQLiteDatabase);
    }

    private static void a(a aVar, String[] strArr) {
        AppMethodBeat.i(44084);
        kHX.put(aVar, strArr);
        AppMethodBeat.o(44084);
    }

    static {
        AppMethodBeat.i(44088);
        a(new a<t>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ t b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44065);
                t tVar = new t(iSQLiteDatabase);
                AppMethodBeat.o(44065);
                return tVar;
            }
        }, t.iBh);
        a(new a<ai>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass12 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ ai b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44076);
                ai aiVar = new ai(iSQLiteDatabase);
                AppMethodBeat.o(44076);
                return aiVar;
            }
        }, ai.iBh);
        a(new a<n>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass18 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ n b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44077);
                n nVar = new n(iSQLiteDatabase);
                AppMethodBeat.o(44077);
                return nVar;
            }
        }, n.iBh);
        a(new a<e>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass19 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ e b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44078);
                e eVar = new e(iSQLiteDatabase);
                AppMethodBeat.o(44078);
                return eVar;
            }
        }, e.iBh);
        a(new a<ap>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass20 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ ap b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44079);
                ap apVar = new ap(iSQLiteDatabase);
                AppMethodBeat.o(44079);
                return apVar;
            }
        }, ap.iBh);
        a(new a<k>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass21 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ k b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44080);
                k kVar = new k(iSQLiteDatabase);
                AppMethodBeat.o(44080);
                return kVar;
            }
        }, k.iBh);
        a(new a<h>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass22 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ h b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44081);
                h hVar = new h(iSQLiteDatabase);
                AppMethodBeat.o(44081);
                return hVar;
            }
        }, h.iBh);
        a(new a<d>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass23 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ d b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44082);
                d dVar = new d(iSQLiteDatabase);
                AppMethodBeat.o(44082);
                return dVar;
            }
        }, d.iBh);
        a(new a<an>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass24 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ an b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44083);
                an anVar = new an(iSQLiteDatabase);
                AppMethodBeat.o(44083);
                return anVar;
            }
        }, an.iBh);
        a(new a<com.tencent.mm.plugin.appbrand.appcache.predownload.e.b>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ com.tencent.mm.plugin.appbrand.appcache.predownload.e.b b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44066);
                com.tencent.mm.plugin.appbrand.appcache.predownload.e.b bVar = new com.tencent.mm.plugin.appbrand.appcache.predownload.e.b(iSQLiteDatabase);
                AppMethodBeat.o(44066);
                return bVar;
            }
        }, com.tencent.mm.plugin.appbrand.appcache.predownload.e.b.iBh);
        a(new a<com.tencent.mm.plugin.appbrand.appusage.a.b>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ com.tencent.mm.plugin.appbrand.appusage.a.b b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44067);
                com.tencent.mm.plugin.appbrand.appusage.a.b bVar = new com.tencent.mm.plugin.appbrand.appusage.a.b(iSQLiteDatabase);
                AppMethodBeat.o(44067);
                return bVar;
            }
        }, com.tencent.mm.plugin.appbrand.appusage.a.b.iBh);
        a(new a<u>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ u b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44068);
                u uVar = new u((com.tencent.mm.storagebase.h) iSQLiteDatabase);
                AppMethodBeat.o(44068);
                return uVar;
            }
        }, u.iBh);
        a(new a<com.tencent.mm.plugin.appbrand.backgroundfetch.d>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass5 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ com.tencent.mm.plugin.appbrand.backgroundfetch.d b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44069);
                com.tencent.mm.plugin.appbrand.backgroundfetch.d dVar = new com.tencent.mm.plugin.appbrand.backgroundfetch.d(iSQLiteDatabase);
                AppMethodBeat.o(44069);
                return dVar;
            }
        }, com.tencent.mm.plugin.appbrand.backgroundfetch.d.iBh);
        a(new a<g>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass6 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ g b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44070);
                g gVar = new g(iSQLiteDatabase);
                AppMethodBeat.o(44070);
                return gVar;
            }
        }, g.iBh);
        a(new a<com.tencent.mm.plugin.appbrand.appcache.predownload.d.a>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass7 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ com.tencent.mm.plugin.appbrand.appcache.predownload.d.a b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44071);
                com.tencent.mm.plugin.appbrand.appcache.predownload.d.a aVar = new com.tencent.mm.plugin.appbrand.appcache.predownload.d.a(iSQLiteDatabase);
                AppMethodBeat.o(44071);
                return aVar;
            }
        }, com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.iBh);
        a(new a<aj>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass8 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ aj b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44072);
                aj ajVar = new aj(iSQLiteDatabase);
                AppMethodBeat.o(44072);
                return ajVar;
            }
        }, aj.iBh);
        a(new a<com.tencent.mm.plugin.appbrand.appstorage.b>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass9 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ com.tencent.mm.plugin.appbrand.appstorage.b b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44073);
                com.tencent.mm.plugin.appbrand.appstorage.b bVar = new com.tencent.mm.plugin.appbrand.appstorage.b(iSQLiteDatabase);
                AppMethodBeat.o(44073);
                return bVar;
            }
        }, com.tencent.mm.plugin.appbrand.appstorage.b.iBh);
        a(new a<ar>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass10 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ ar b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44074);
                ar arVar = new ar(iSQLiteDatabase);
                AppMethodBeat.o(44074);
                return arVar;
            }
        }, ar.iBh);
        a(new a<c>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass11 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ c b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(44075);
                c cVar = new c((ISQLiteDatabaseEx) iSQLiteDatabase);
                AppMethodBeat.o(44075);
                return cVar;
            }
        }, com.tencent.mm.plugin.appbrand.page.web_renderingcache.b.iBh);
        a(new a<bl>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass13 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ bl b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(180183);
                bl blVar = new bl((ISQLiteDatabaseEx) iSQLiteDatabase);
                AppMethodBeat.o(180183);
                return blVar;
            }
        }, bk.iBh);
        a(new a<com.tencent.mm.plugin.appbrand.appcache.b>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass14 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ com.tencent.mm.plugin.appbrand.appcache.b b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(180184);
                com.tencent.mm.plugin.appbrand.appcache.b bVar = new com.tencent.mm.plugin.appbrand.appcache.b(iSQLiteDatabase);
                AppMethodBeat.o(180184);
                return bVar;
            }
        }, com.tencent.mm.plugin.appbrand.appcache.a.iBh);
        a(new a<com.tencent.mm.plugin.appbrand.appcache.d>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass15 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ com.tencent.mm.plugin.appbrand.appcache.d b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(180185);
                com.tencent.mm.plugin.appbrand.appcache.d dVar = new com.tencent.mm.plugin.appbrand.appcache.d(iSQLiteDatabase);
                AppMethodBeat.o(180185);
                return dVar;
            }
        }, com.tencent.mm.plugin.appbrand.appcache.c.iBh);
        a(new a<com.tencent.mm.plugin.appbrand.config.a.b>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass16 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ com.tencent.mm.plugin.appbrand.config.a.b b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(226282);
                com.tencent.mm.plugin.appbrand.config.a.b bVar = new com.tencent.mm.plugin.appbrand.config.a.b(iSQLiteDatabase);
                AppMethodBeat.o(226282);
                return bVar;
            }
        }, com.tencent.mm.plugin.appbrand.config.a.a.iBh);
        a(new a<com.tencent.mm.plugin.appbrand.ui.c.a.b>() {
            /* class com.tencent.mm.plugin.appbrand.app.b.AnonymousClass17 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.app.b.a
            public final /* synthetic */ com.tencent.mm.plugin.appbrand.ui.c.a.b b(ISQLiteDatabase iSQLiteDatabase) {
                AppMethodBeat.i(226283);
                com.tencent.mm.plugin.appbrand.ui.c.a.b bVar = new com.tencent.mm.plugin.appbrand.ui.c.a.b(iSQLiteDatabase);
                AppMethodBeat.o(226283);
                return bVar;
            }
        }, com.tencent.mm.plugin.appbrand.ui.c.a.b.iBh);
        a(v.a.lfO, v.iBh);
        AppMethodBeat.o(44088);
    }

    static void a(ISQLiteDatabase iSQLiteDatabase) {
        AppMethodBeat.i(44085);
        synchronized (kHY) {
            try {
                kHY.clear();
                for (a aVar : kHX.keySet()) {
                    Object b2 = aVar.b(iSQLiteDatabase);
                    kHY.put(b2.getClass(), b2);
                }
            } finally {
                AppMethodBeat.o(44085);
            }
        }
    }

    static void buh() {
        AppMethodBeat.i(44086);
        synchronized (kHY) {
            try {
                kHY.clear();
            } finally {
                AppMethodBeat.o(44086);
            }
        }
    }

    static <T> T W(Class<T> cls) {
        T t;
        AppMethodBeat.i(44087);
        Assert.assertTrue("Cant pass Null class here", cls != null);
        synchronized (kHY) {
            try {
                t = (T) kHY.get(cls);
            } finally {
                AppMethodBeat.o(44087);
            }
        }
        return t;
    }
}
