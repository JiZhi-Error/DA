package com.tencent.mm.plugin.finder.activity;

import android.content.Intent;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/FinderActivityParamUtil;", "", "()V", "isActivityDraftValid", "", "activityId", "", "from", "", "(Ljava/lang/Long;I)Z", "setActivityParam", "", "originIntent", "Landroid/content/Intent;", "startIntent", "plugin-finder_release"})
public final class b {
    public static final b tqg = new b();

    static {
        AppMethodBeat.i(241999);
        AppMethodBeat.o(241999);
    }

    private b() {
    }

    public static boolean b(Long l, int i2) {
        AppMethodBeat.i(241998);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String obj = aAh.azQ().get(ar.a.USERINFO_FINDER_OPEN_UPLOAD_DRAFT_STRING_SYNC, "").toString();
        if (!Util.isNullOrNil(obj)) {
            try {
                byte[] bqe = com.tencent.e.f.e.bqe(obj);
                Parcel obtain = Parcel.obtain();
                p.g(obtain, "Parcel.obtain()");
                obtain.unmarshall(bqe, 0, bqe.length);
                obtain.setDataPosition(0);
                Intent intent = (Intent) Intent.CREATOR.createFromParcel(obtain);
                if (intent.hasExtra("key_topic_id")) {
                    if (i2 != 9) {
                        AppMethodBeat.o(241998);
                        return true;
                    }
                    long longExtra = intent.getLongExtra("key_topic_id", 0);
                    if (l != null && longExtra == l.longValue()) {
                        AppMethodBeat.o(241998);
                        return true;
                    }
                    e aAh2 = g.aAh();
                    p.g(aAh2, "MMKernel.storage()");
                    aAh2.azQ().set(ar.a.USERINFO_FINDER_OPEN_UPLOAD_DRAFT_STRING_SYNC, "");
                }
            } catch (Exception e2) {
                Log.e("Finder.ActivityRouter", "goDraft() ".concat(String.valueOf(e2)));
            }
        }
        AppMethodBeat.o(241998);
        return false;
    }
}
