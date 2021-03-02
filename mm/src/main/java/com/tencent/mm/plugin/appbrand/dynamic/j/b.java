package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.content.ContentValues;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.e;
import com.tencent.mm.plugin.appbrand.widget.f;
import com.tencent.mm.sdk.platformtools.Util;

public final class b {
    public static e YE(String str) {
        AppMethodBeat.i(121476);
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        e a2 = a((ContentValues) h.a(MainProcessIPCService.dkO, bundle, a.class));
        AppMethodBeat.o(121476);
        return a2;
    }

    static e a(ContentValues contentValues) {
        AppMethodBeat.i(121477);
        if (contentValues != null) {
            e eVar = new e();
            eVar.field_id = contentValues.getAsString("id");
            eVar.field_appId = contentValues.getAsString("appId");
            eVar.field_cacheKey = contentValues.getAsString("cacheKey");
            eVar.field_updateTime = Util.nullAsNil(contentValues.getAsLong(ch.COL_UPDATETIME));
            eVar.field_interval = Util.nullAsNil(contentValues.getAsInteger("interval"));
            eVar.systemRowid = Util.nullAsNil(contentValues.getAsLong("rowid"));
            AppMethodBeat.o(121477);
            return eVar;
        }
        AppMethodBeat.o(121477);
        return null;
    }

    static class a implements k<Bundle, ContentValues> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ ContentValues invoke(Bundle bundle) {
            e eVar;
            AppMethodBeat.i(121474);
            String string = bundle.getString("id");
            f buM = ((com.tencent.mm.plugin.appbrand.widget.a.b) g.af(com.tencent.mm.plugin.appbrand.widget.a.b.class)).buM();
            if (Util.isNullOrNil(string)) {
                eVar = null;
            } else {
                eVar = new e();
                eVar.field_id = string;
                if (!buM.get(eVar, "id")) {
                    eVar = null;
                }
            }
            if (eVar == null) {
                AppMethodBeat.o(121474);
                return null;
            }
            ContentValues convertTo = eVar.convertTo();
            AppMethodBeat.o(121474);
            return convertTo;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j.b$b  reason: collision with other inner class name */
    public static class C0576b implements k<ContentValues, Bundle> {
        private C0576b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Bundle invoke(ContentValues contentValues) {
            boolean z;
            AppMethodBeat.i(121475);
            f buM = ((com.tencent.mm.plugin.appbrand.widget.a.b) g.af(com.tencent.mm.plugin.appbrand.widget.a.b.class)).buM();
            e a2 = b.a(contentValues);
            if (a2 == null || (a2.systemRowid > 0 && buM.replace(a2))) {
                z = false;
            } else {
                z = buM.insert(a2);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("result", z);
            AppMethodBeat.o(121475);
            return bundle;
        }
    }
}
