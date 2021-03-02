package com.tencent.mm.plugin.account;

import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ac;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.bh;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.ar;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.plugin.account.friend.a.f;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.LinkedList;

public class a implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private b jZh;
    private com.tencent.mm.plugin.account.friend.a.h jZi;
    private k jZj;
    private ar jZk;
    private at jZl;
    private q jZm;
    private o jZn;
    private ap jZo;
    private d jZp = new d();
    private LinkedList<cik> jZq = null;
    private c jZr = new c();
    private e jZs = new e();
    private f jZt = new f();
    private IListener jZu = new IListener<bh>() {
        /* class com.tencent.mm.plugin.account.a.AnonymousClass1 */

        {
            AppMethodBeat.i(161693);
            this.__eventId = bh.class.getName().hashCode();
            AppMethodBeat.o(161693);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bh bhVar) {
            AppMethodBeat.i(127779);
            bh bhVar2 = bhVar;
            if (bhVar2 instanceof bh) {
                bhVar2.dEw.result = l.boc();
            }
            AppMethodBeat.o(127779);
            return false;
        }
    };
    private IListener jZv = new IListener<jx>() {
        /* class com.tencent.mm.plugin.account.a.AnonymousClass7 */

        {
            AppMethodBeat.i(161695);
            this.__eventId = jx.class.getName().hashCode();
            AppMethodBeat.o(161695);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(jx jxVar) {
            AppMethodBeat.i(127782);
            jx jxVar2 = jxVar;
            if (jxVar2 instanceof jx) {
                int i2 = jxVar2.dOQ.scene;
                ad adVar = new ad();
                ((bqd) adVar.rr.iLK.iLR).Scene = i2;
                g.azz().a(adVar, 0);
            }
            AppMethodBeat.o(127782);
            return false;
        }
    };
    private IListener jZw = new IListener<jl>() {
        /* class com.tencent.mm.plugin.account.a.AnonymousClass8 */

        {
            AppMethodBeat.i(161696);
            this.__eventId = jl.class.getName().hashCode();
            AppMethodBeat.o(161696);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(jl jlVar) {
            AppMethodBeat.i(127783);
            jl jlVar2 = jlVar;
            if (jlVar2 instanceof jl) {
                String str = jlVar2.dOk.dOm;
                if (Util.isNullOrNil(str)) {
                    Log.e("MicroMsg.SubCoreFriend", "hy: mobile number is null");
                } else {
                    Cursor rawQuery = a.getAddrUploadStg().iFy.rawQuery("select addr_upload2.username from addr_upload2 where addr_upload2.moblie = ".concat(String.valueOf(str)), null, 2);
                    LinkedList linkedList = new LinkedList();
                    while (rawQuery.moveToNext()) {
                        linkedList.add(rawQuery.getString(0));
                    }
                    rawQuery.close();
                    String str2 = linkedList.size() == 0 ? "" : (String) linkedList.get(0);
                    Log.i("MicroMsg.SubCoreFriend", "hy: username: %s", str2);
                    jlVar2.dOl.userName = str2;
                }
            }
            AppMethodBeat.o(127783);
            return false;
        }
    };
    private IListener jZx = new IListener<uj>() {
        /* class com.tencent.mm.plugin.account.a.AnonymousClass4 */

        {
            AppMethodBeat.i(184134);
            this.__eventId = uj.class.getName().hashCode();
            AppMethodBeat.o(184134);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(uj ujVar) {
            AppMethodBeat.i(184135);
            uj ujVar2 = ujVar;
            Intent intent = ujVar2.eaI.intent;
            String str = ujVar2.eaI.username;
            if (intent == null || str == null || str.length() == 0) {
                Log.e("MicroMsg.AccountSyncUtil", "setLocalQQMobile fail, intent = " + intent + ", username = " + str);
            } else {
                as Tg = ((at) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).Tg(str);
                if (Tg != null) {
                    intent.putExtra("Contact_Uin", Tg.kfN);
                    intent.putExtra("Contact_QQNick", Tg.getDisplayName());
                }
                com.tencent.mm.plugin.account.friend.a.a SR = ((b) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).SR(str);
                if (SR != null) {
                    intent.putExtra("Contact_Mobile_MD5", SR.getMd5());
                }
            }
            AppMethodBeat.o(184135);
            return false;
        }
    };

    public a() {
        AppMethodBeat.i(127784);
        AppMethodBeat.o(127784);
    }

    private static synchronized a bnb() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(127785);
            aVar = (a) y.at(a.class);
            AppMethodBeat.o(127785);
        }
        return aVar;
    }

    public static b getAddrUploadStg() {
        AppMethodBeat.i(127786);
        g.aAf().azk();
        if (bnb().jZh == null) {
            bnb().jZh = new b(g.aAh().hqK);
        }
        b bVar = bnb().jZh;
        AppMethodBeat.o(127786);
        return bVar;
    }

    public static com.tencent.mm.plugin.account.friend.a.h getFacebookFrdStg() {
        AppMethodBeat.i(127787);
        g.aAf().azk();
        if (bnb().jZi == null) {
            bnb().jZi = new com.tencent.mm.plugin.account.friend.a.h(g.aAh().hqK);
        }
        com.tencent.mm.plugin.account.friend.a.h hVar = bnb().jZi;
        AppMethodBeat.o(127787);
        return hVar;
    }

    public static k getFrdExtStg() {
        AppMethodBeat.i(127788);
        g.aAf().azk();
        if (bnb().jZj == null) {
            bnb().jZj = new k(g.aAh().hqK);
        }
        k kVar = bnb().jZj;
        AppMethodBeat.o(127788);
        return kVar;
    }

    public static ar getQQGroupStg() {
        AppMethodBeat.i(127789);
        g.aAf().azk();
        if (bnb().jZk == null) {
            bnb().jZk = new ar(g.aAh().hqK);
        }
        ar arVar = bnb().jZk;
        AppMethodBeat.o(127789);
        return arVar;
    }

    public static q getInviteFriendOpenStg() {
        AppMethodBeat.i(127790);
        g.aAf().azk();
        if (bnb().jZm == null) {
            bnb().jZm = new q(g.aAh().hqK);
        }
        q qVar = bnb().jZm;
        AppMethodBeat.o(127790);
        return qVar;
    }

    public static at getQQListStg() {
        AppMethodBeat.i(127791);
        g.aAf().azk();
        if (bnb().jZl == null) {
            bnb().jZl = new at(g.aAh().hqK);
        }
        at atVar = bnb().jZl;
        AppMethodBeat.o(127791);
        return atVar;
    }

    public static void setFriendData(LinkedList<cik> linkedList) {
        AppMethodBeat.i(127792);
        g.aAf().azk();
        bnb().jZq = linkedList;
        AppMethodBeat.o(127792);
    }

    public static LinkedList<cik> getFriendData() {
        AppMethodBeat.i(127793);
        g.aAf().azk();
        LinkedList<cik> linkedList = bnb().jZq;
        AppMethodBeat.o(127793);
        return linkedList;
    }

    public static void clearFriendData() {
        AppMethodBeat.i(127794);
        g.aAf().azk();
        bnb().jZq = null;
        AppMethodBeat.o(127794);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(127795);
        EventCenter.instance.removeListener(this.jZx);
        EventCenter.instance.removeListener(this.jZw);
        EventCenter.instance.removeListener(this.jZr);
        EventCenter.instance.removeListener(this.jZs);
        EventCenter.instance.removeListener(this.jZt);
        EventCenter.instance.removeListener(this.jZu);
        EventCenter.instance.removeListener(this.jZv);
        h.d.b(42, this.jZp);
        h.d.b(66, this.jZp);
        this.jZq = null;
        AppMethodBeat.o(127795);
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    static {
        AppMethodBeat.i(127798);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("ADDR_UPLOAD_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.account.a.AnonymousClass9 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("FACE_BOOK_FIREND_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.account.a.AnonymousClass10 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.account.friend.a.h.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("FRIEND_EXT_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.account.a.AnonymousClass11 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return k.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("QQ_GROUP_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.account.a.AnonymousClass12 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return ar.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("QQ_LIST_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.account.a.AnonymousClass13 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return at.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("INVITEFRIENDOPEN_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.account.a.AnonymousClass14 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return q.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("GOOGLE_FRIEND_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.account.a.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return o.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("OLD_ACCOUNT_FRIEND_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.account.a.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return ap.SQL_CREATE;
            }
        });
        AppMethodBeat.o(127798);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(127796);
        h.d.a(42, this.jZp);
        h.d.a(66, this.jZp);
        EventCenter.instance.addListener(this.jZx);
        EventCenter.instance.addListener(this.jZw);
        EventCenter.instance.addListener(this.jZr);
        EventCenter.instance.addListener(this.jZs);
        EventCenter.instance.addListener(this.jZt);
        EventCenter.instance.addListener(this.jZu);
        EventCenter.instance.addListener(this.jZv);
        ((n) g.ah(n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a() {
            /* class com.tencent.mm.plugin.account.a.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.fts.a.a.a
            public final boolean execute() {
                AppMethodBeat.i(184136);
                com.tencent.mm.w.a aVar = new com.tencent.mm.w.a();
                ((n) g.ah(n.class)).registerIndexStorage(aVar);
                aVar.create();
                com.tencent.mm.w.b bVar = new com.tencent.mm.w.b();
                ((n) g.ah(n.class)).registerNativeLogic(9, bVar);
                bVar.create();
                ((n) g.ah(n.class)).registerFTSUILogic(new com.tencent.mm.w.a.a());
                AppMethodBeat.o(184136);
                return true;
            }

            @Override // com.tencent.mm.plugin.fts.a.a.a
            public final String getName() {
                return "InitFTSFriendPluginTask";
            }
        });
        ac.iNB = new ac.a() {
            /* class com.tencent.mm.plugin.account.a.AnonymousClass6 */

            @Override // com.tencent.mm.ak.ac.a
            public final boolean aZy() {
                AppMethodBeat.i(196845);
                if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_wtlogin_buf_expr, 0) == 0) {
                    AppMethodBeat.o(196845);
                    return true;
                }
                AppMethodBeat.o(196845);
                return false;
            }
        };
        AppMethodBeat.o(127796);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    public static o getGoogleFriendStorage() {
        AppMethodBeat.i(127797);
        g.aAf().azk();
        if (bnb().jZn == null) {
            bnb().jZn = new o(g.aAh().hqK);
        }
        o oVar = bnb().jZn;
        AppMethodBeat.o(127797);
        return oVar;
    }

    public static ap getOldAccountFriendStorage() {
        AppMethodBeat.i(184137);
        g.aAf().azk();
        if (bnb().jZo == null) {
            bnb().jZo = new ap(g.aAh().hqK);
        }
        ap apVar = bnb().jZo;
        AppMethodBeat.o(184137);
        return apVar;
    }
}
