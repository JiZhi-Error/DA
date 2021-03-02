package com.tencent.mm.pluginsdk.i;

import android.database.Cursor;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.db;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a implements MStorageEx.IOnStorageChange {
    public static a JYc = new a();
    private static Set<String> JYd = new HashSet();
    private static Set<String> JYe = new HashSet();
    private static boolean JYg;
    private volatile boolean JYf;
    private IListener<db> JYh = new IListener<db>() {
        /* class com.tencent.mm.pluginsdk.i.a.AnonymousClass1 */

        {
            AppMethodBeat.i(223808);
            this.__eventId = db.class.getName().hashCode();
            AppMethodBeat.o(223808);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(db dbVar) {
            AppMethodBeat.i(223809);
            db dbVar2 = dbVar;
            if (dbVar2.dGl.action == 1) {
                Log.i("MicroMsg.ContactBlackListHelper", "do init start");
                a.this.JYf = true;
            } else if (dbVar2.dGl.action == 2) {
                Log.i("MicroMsg.ContactBlackListHelper", "do init end");
                a.this.JYf = false;
            }
            AppMethodBeat.o(223809);
            return false;
        }
    };

    static /* synthetic */ void bdT(String str) {
        AppMethodBeat.i(223816);
        bdS(str);
        AppMethodBeat.o(223816);
    }

    static {
        AppMethodBeat.i(223817);
        AppMethodBeat.o(223817);
    }

    private a() {
        boolean z;
        AppMethodBeat.i(223811);
        if (((b) g.af(b.class)).a(b.a.clicfg_contact_blacklist_helper_notify_async, 0) == 1 || d.KyR || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
            z = true;
        } else {
            z = false;
        }
        JYg = z;
        Log.i("MicroMsg.ContactBlackListHelper", "asyncNotifyChange = %b", Boolean.valueOf(JYg));
        this.JYh.alive();
        AppMethodBeat.o(223811);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(223812);
        if (!(obj instanceof String)) {
            Log.d("MicroMsg.ContactBlackListHelper", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(223812);
            return;
        }
        final String str = (String) obj;
        Log.i("MicroMsg.ContactBlackListHelper", "onNotifyChange %s", str);
        if (mStorageEx instanceof bv) {
            if (this.JYf) {
                AppMethodBeat.o(223812);
                return;
            } else if (!Util.isNullOrNil(str)) {
                if (JYg) {
                    h.RTc.b(new Runnable() {
                        /* class com.tencent.mm.pluginsdk.i.a.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(223810);
                            a.bdT(str);
                            AppMethodBeat.o(223810);
                        }
                    }, "Thread-ContactBlackListHelper-onNotifyChange");
                    AppMethodBeat.o(223812);
                    return;
                }
                bdS(str);
            }
        }
        AppMethodBeat.o(223812);
    }

    private static void bdS(String str) {
        AppMethodBeat.i(223813);
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null || ((int) Kn.gMZ) <= 0) {
            AppMethodBeat.o(223813);
            return;
        }
        Log.i("MicroMsg.ContactBlackListHelper", "onContactStorageNotifyChange isBLackListContact: %s, isSnsBlack: %s,", Boolean.valueOf(Kn.ary()), Boolean.valueOf(Kn.arB()));
        synchronized (JYd) {
            try {
                if (Kn.ary()) {
                    JYd.add(str);
                } else {
                    JYd.remove(str);
                }
            } finally {
                AppMethodBeat.o(223813);
            }
        }
        synchronized (JYe) {
            try {
                if (Kn.arB()) {
                    JYe.add(str);
                } else {
                    JYe.remove(str);
                }
            } finally {
                AppMethodBeat.o(223813);
            }
        }
    }

    public static List<String> gnp() {
        ArrayList arrayList;
        AppMethodBeat.i(223814);
        synchronized (JYd) {
            try {
                if (JYd.isEmpty()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Cursor cursor = null;
                    try {
                        g.aAi();
                        Cursor mR = ((l) g.af(l.class)).aSN().mR("@black.android", "");
                        mR.moveToFirst();
                        while (!mR.isAfterLast()) {
                            JYd.add(mR.getString(0));
                            mR.moveToNext();
                        }
                        if (mR != null) {
                            mR.close();
                        }
                        Log.i("MicroMsg.ContactBlackListHelper", "[select black list] cost:%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    } catch (Throwable th) {
                        if (0 != 0) {
                            cursor.close();
                        }
                        Log.i("MicroMsg.ContactBlackListHelper", "[select black list] cost:%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(223814);
                        throw th;
                    }
                }
                Log.i("MicroMsg.ContactBlackListHelper", "[get black list] %s", JYd);
                arrayList = new ArrayList(JYd);
            } finally {
                AppMethodBeat.o(223814);
            }
        }
        return arrayList;
    }

    public static List<String> gnq() {
        ArrayList arrayList;
        AppMethodBeat.i(223815);
        synchronized (JYe) {
            try {
                if (JYe.isEmpty()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JYe.addAll(ab.aVa());
                    Log.i("MicroMsg.ContactBlackListHelper", "[select sns black list] cost:%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                Log.i("MicroMsg.ContactBlackListHelper", "[get black list] %s", JYe);
                arrayList = new ArrayList(JYe);
            } finally {
                AppMethodBeat.o(223815);
            }
        }
        return arrayList;
    }
}
