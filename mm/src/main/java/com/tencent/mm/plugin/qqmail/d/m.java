package com.tencent.mm.plugin.qqmail.d;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.qqmail.c.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class m {
    n BrA;
    private int BrB = 0;
    private int BrC = 1;
    int BrD = 2;
    private long Brz;
    List<a> callbacks;
    int status = this.BrB;

    public static abstract class a {
        public abstract void onComplete();
    }

    m(String str) {
        AppMethodBeat.i(122698);
        this.BrA = new n(str);
        this.callbacks = new ArrayList();
        AppMethodBeat.o(122698);
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(122699);
        this.callbacks.clear();
        AppMethodBeat.o(122699);
    }

    public final List<l> aKD(String str) {
        AppMethodBeat.i(122700);
        ArrayList<l> arrayList = new ArrayList();
        LinkedList blq = this.BrA.blq();
        if (blq != null) {
            arrayList.addAll(blq);
        }
        if (this.status == this.BrB) {
            eGn();
        }
        Collections.sort(arrayList, new Comparator<l>() {
            /* class com.tencent.mm.plugin.qqmail.d.m.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(l lVar, l lVar2) {
                AppMethodBeat.i(198596);
                l lVar3 = lVar;
                l lVar4 = lVar2;
                if (!Util.isAlpha(m.aKF(lVar3.pinyin)) || !Util.isAlpha(m.aKF(lVar4.pinyin))) {
                    if (Util.isAlpha(m.aKF(lVar3.pinyin))) {
                        AppMethodBeat.o(198596);
                        return -1;
                    } else if (Util.isAlpha(m.aKF(lVar4.pinyin))) {
                        AppMethodBeat.o(198596);
                        return 1;
                    }
                }
                int compareTo = lVar3.pinyin.compareTo(lVar4.pinyin);
                AppMethodBeat.o(198596);
                return compareTo;
            }
        });
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(122700);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (l lVar : arrayList) {
            if (lVar != null && ((lVar.name != null && lVar.name.contains(str)) || ((lVar.pinyin != null && lVar.pinyin.contains(str)) || (lVar.yFq != null && lVar.yFq.contains(str))))) {
                arrayList2.add(lVar);
            }
        }
        AppMethodBeat.o(122700);
        return arrayList2;
    }

    public final void eGn() {
        AppMethodBeat.i(122701);
        if (this.status == this.BrC) {
            AppMethodBeat.o(122701);
        } else if (Util.nowMilliSecond() - this.Brz <= 600000) {
            for (a aVar : this.callbacks) {
                aVar.onComplete();
            }
            AppMethodBeat.o(122701);
        } else {
            this.status = this.BrC;
            this.Brz = Util.nowMilliSecond();
            h.a(MMApplicationContext.getPackageName(), new IPCVoid(), j.class, new d<Bundle>() {
                /* class com.tencent.mm.plugin.qqmail.d.m.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    LinkedList linkedList;
                    AppMethodBeat.i(198598);
                    Bundle bundle2 = bundle;
                    LinkedList blq = m.this.BrA.blq();
                    if (blq == null) {
                        linkedList = new LinkedList();
                    } else {
                        linkedList = blq;
                    }
                    ArrayList<Bundle> parcelableArrayList = bundle2.getParcelableArrayList("sync_add_list");
                    if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                        for (Bundle bundle3 : parcelableArrayList) {
                            l lVar = new l();
                            lVar.name = bundle3.getString(FirebaseAnalytics.b.ITEM_NAME);
                            lVar.yFq = bundle3.getString("item_addr");
                            if (!Util.isNullOrNil(lVar.yFq)) {
                                lVar.bNi = lVar.yFq.hashCode();
                            }
                            lVar.pinyin = f.Sh(lVar.name);
                            as asVar = new as(lVar);
                            if (!linkedList.contains(asVar)) {
                                linkedList.add(asVar);
                                Log.i("MicroMsg.Plugin.MailAddrMgr", "add contact (%s,%s)", lVar.yFq, lVar.name);
                            }
                        }
                    }
                    ArrayList<Bundle> parcelableArrayList2 = bundle2.getParcelableArrayList("sync_update_list");
                    if (parcelableArrayList2 != null && !parcelableArrayList2.isEmpty()) {
                        for (Bundle bundle4 : parcelableArrayList2) {
                            l lVar2 = new l();
                            lVar2.name = bundle4.getString(FirebaseAnalytics.b.ITEM_NAME);
                            lVar2.yFq = bundle4.getString("item_addr");
                            if (!Util.isNullOrNil(lVar2.yFq)) {
                                lVar2.bNi = lVar2.yFq.hashCode();
                            }
                            lVar2.pinyin = f.Sh(lVar2.name);
                            as asVar2 = new as(lVar2);
                            int indexOf = linkedList.indexOf(asVar2);
                            if (indexOf != -1) {
                                linkedList.set(indexOf, asVar2);
                                Log.i("MicroMsg.Plugin.MailAddrMgr", "update contact (%s,%s)", lVar2.yFq, lVar2.name);
                            }
                        }
                    }
                    ArrayList<Bundle> parcelableArrayList3 = bundle2.getParcelableArrayList("sync_delete_list");
                    if (parcelableArrayList3 != null && !parcelableArrayList3.isEmpty()) {
                        for (Bundle bundle5 : parcelableArrayList3) {
                            l lVar3 = new l();
                            lVar3.name = bundle5.getString(FirebaseAnalytics.b.ITEM_NAME);
                            lVar3.yFq = bundle5.getString("item_addr");
                            if (!Util.isNullOrNil(lVar3.yFq)) {
                                lVar3.bNi = lVar3.yFq.hashCode();
                            }
                            lVar3.pinyin = f.Sh(lVar3.name);
                            linkedList.remove(new as(lVar3));
                            Log.i("MicroMsg.Plugin.MailAddrMgr", "delete contact (%s,%s)", lVar3.yFq, lVar3.name);
                        }
                    }
                    m.this.BrA.r(linkedList);
                    g.aAh().azQ().set(ar.a.USERINFO_XMAIL_SYNC_CONTACT_KEY_LONG_SYNC, Long.valueOf(bundle2.getLong("last_sync_key")));
                    m.this.status = m.this.BrD;
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.qqmail.d.m.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(198597);
                            for (a aVar : m.this.callbacks) {
                                aVar.onComplete();
                            }
                            AppMethodBeat.o(198597);
                        }
                    });
                    AppMethodBeat.o(198598);
                }
            });
            AppMethodBeat.o(122701);
        }
    }

    public final void a(a aVar) {
        AppMethodBeat.i(122702);
        for (a aVar2 : this.callbacks) {
            if (aVar2 == aVar) {
                AppMethodBeat.o(122702);
                return;
            }
        }
        this.callbacks.add(aVar);
        AppMethodBeat.o(122702);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(122703);
        for (a aVar2 : this.callbacks) {
            if (aVar2 == aVar) {
                this.callbacks.remove(aVar2);
                AppMethodBeat.o(122703);
                return;
            }
        }
        AppMethodBeat.o(122703);
    }

    public final void fU(List<l> list) {
        AppMethodBeat.i(122704);
        LinkedList blq = this.BrA.blq();
        for (l lVar : list) {
            int indexOf = blq.indexOf(new as(lVar));
            if (indexOf != -1) {
                ((as) blq.get(indexOf)).Bry++;
            }
        }
        this.BrA.r(blq);
        AppMethodBeat.o(122704);
    }

    public static l aKE(String str) {
        AppMethodBeat.i(122706);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(122706);
            return null;
        }
        String trim = str.trim();
        int lastIndexOf = trim.trim().lastIndexOf(" ");
        if (lastIndexOf == -1) {
            AppMethodBeat.o(122706);
            return null;
        }
        l lVar = new l();
        lVar.name = trim.substring(0, lastIndexOf);
        lVar.yFq = trim.substring(lastIndexOf + 1);
        AppMethodBeat.o(122706);
        return lVar;
    }

    static /* synthetic */ char aKF(String str) {
        AppMethodBeat.i(198599);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(198599);
            return '~';
        }
        char charAt = str.charAt(0);
        AppMethodBeat.o(198599);
        return charAt;
    }
}
