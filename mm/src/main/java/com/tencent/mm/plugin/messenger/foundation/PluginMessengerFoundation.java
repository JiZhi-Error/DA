package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ba.j;
import com.tencent.mm.ba.o;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.as;
import com.tencent.mm.model.at;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.e;
import com.tencent.mm.model.y;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.z;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.co;
import com.tencent.mm.storage.ct;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public class PluginMessengerFoundation extends f implements a, c, d, at, s {
    private d UYP;
    private e UYQ;
    private cj UYR = new cj();
    private com.tencent.mm.plugin.chatroom.a UYS = new com.tencent.mm.plugin.chatroom.a();
    public int UYT = 0;
    private at UYU;
    private b UYV;
    private e iDE = new e();

    public PluginMessengerFoundation() {
        AppMethodBeat.i(116903);
        AppMethodBeat.o(116903);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(116904);
        alias(s.class);
        AppMethodBeat.o(116904);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(116905);
        dependsOn(PluginZero.class);
        AppMethodBeat.o(116905);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(116906);
        com.tencent.mm.plugin.zero.c.JSe = new com.tencent.mm.co.c<com.tencent.mm.plugin.zero.a.f>() {
            /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass1 */

            @Override // com.tencent.mm.co.c
            public com.tencent.mm.plugin.zero.a.f get() {
                AppMethodBeat.i(169107);
                f fVar = new f();
                AppMethodBeat.o(169107);
                return fVar;
            }
        };
        a aVar = new a();
        x.a.a(2, aVar);
        x.a.a(17, aVar);
        x.a.a(4, aVar);
        x.a.a(7, new b());
        c cVar = new c();
        x.a.a(5, cVar);
        x.a.a(8, cVar);
        x.a.a(9, cVar);
        x.a.a(1, new g());
        com.tencent.mm.kernel.g.aAd().a(w.class, new com.tencent.mm.kernel.c.e(new n()));
        com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.zero.a.d.class);
        if (gVar.aBb()) {
            new com.tencent.mm.plugin.zero.tasks.b().before(this);
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.foundation.a.e.class, new com.tencent.mm.plugin.messenger.foundation.a.e() {
                /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.messenger.foundation.a.e
                public void processModContact(cpl cpl, String str, byte[] bArr, boolean z, boolean z2, int i2) {
                    AppMethodBeat.i(187480);
                    a.processModContact(cpl, str, bArr, z, z2, i2);
                    AppMethodBeat.o(187480);
                }

                @Override // com.tencent.mm.plugin.messenger.foundation.a.e
                public com.tencent.mm.vending.b.b addContactAssembler(com.tencent.mm.plugin.messenger.foundation.a.d dVar) {
                    AppMethodBeat.i(116899);
                    com.tencent.mm.vending.b.b addContactAssembler = a.addContactAssembler(dVar);
                    AppMethodBeat.o(116899);
                    return addContactAssembler;
                }

                public void removeContactAssembler(com.tencent.mm.plugin.messenger.foundation.a.d dVar) {
                    AppMethodBeat.i(169109);
                    a.removeContactAssembler(dVar);
                    AppMethodBeat.o(169109);
                }
            });
            com.tencent.mm.kernel.g.b(k.class, new k() {
                /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.messenger.foundation.a.k
                public h.b processAddMsg(h.a aVar, aa aaVar) {
                    AppMethodBeat.i(116900);
                    h.b processAddMsg = c.processAddMsg(aVar, aaVar);
                    AppMethodBeat.o(116900);
                    return processAddMsg;
                }

                @Override // com.tencent.mm.plugin.messenger.foundation.a.k
                public void addSyncDoCmdCallback(z zVar) {
                    AppMethodBeat.i(116901);
                    f.addSyncDoCmdCallback(zVar);
                    AppMethodBeat.o(116901);
                }

                @Override // com.tencent.mm.plugin.messenger.foundation.a.k
                public void removeSyncDoCmdCallback(z zVar) {
                    AppMethodBeat.i(116902);
                    f.removeSyncDoCmdCallback(zVar);
                    AppMethodBeat.o(116902);
                }
            });
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.chatroom.a.c.class, this.UYS);
            CoreService.akv();
        }
        AppMethodBeat.o(116906);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(116907);
        if (gVar.aBb()) {
            this.UYP = new d();
            com.tencent.mm.kernel.g.a(l.class, new com.tencent.mm.kernel.c.e(this.UYP));
            this.UYQ = new e();
            com.tencent.mm.kernel.g.a(m.class, new com.tencent.mm.kernel.c.e(this.UYQ));
        }
        AppMethodBeat.o(116907);
    }

    @Override // com.tencent.mm.kernel.b.f
    public String toString() {
        return "plugin-messenger-foundation";
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(116908);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("MESSAGE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public String[] getSQLs() {
                return cb.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass5 */

            @Override // com.tencent.mm.storagebase.h.b
            public String[] getSQLs() {
                return ay.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("OPLOG_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass6 */

            @Override // com.tencent.mm.storagebase.h.b
            public String[] getSQLs() {
                return j.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("CONVERSATION_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass7 */

            @Override // com.tencent.mm.storagebase.h.b
            public String[] getSQLs() {
                return ba.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass8 */

            @Override // com.tencent.mm.storagebase.h.b
            public String[] getSQLs() {
                return com.tencent.mm.storage.cj.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass9 */

            @Override // com.tencent.mm.storagebase.h.b
            public String[] getSQLs() {
                return co.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("FRIEND_USER_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass10 */

            @Override // com.tencent.mm.storagebase.h.b
            public String[] getSQLs() {
                return br.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass11 */

            @Override // com.tencent.mm.storagebase.h.b
            public String[] getSQLs() {
                return bd.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass12 */

            @Override // com.tencent.mm.storagebase.h.b
            public String[] getSQLs() {
                return by.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass13 */

            @Override // com.tencent.mm.storagebase.h.b
            public String[] getSQLs() {
                return cm.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass14 */

            @Override // com.tencent.mm.storagebase.h.b
            public String[] getSQLs() {
                return ct.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass15 */

            @Override // com.tencent.mm.storagebase.h.b
            public String[] getSQLs() {
                return bo.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass16 */

            @Override // com.tencent.mm.storagebase.h.b
            public String[] getSQLs() {
                return bm.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("CHATROOM_MSGSEQ_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass17 */

            @Override // com.tencent.mm.storagebase.h.b
            public String[] getSQLs() {
                return ak.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.AnonymousClass18 */

            @Override // com.tencent.mm.storagebase.h.b
            public String[] getSQLs() {
                return bu.SQL_CREATE;
            }
        });
        AppMethodBeat.o(116908);
        return hashMap;
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(116909);
        h.d.a(10000, this.iDE);
        h.d.a(1, this.iDE);
        h.d.a(10001, this.UYR);
        h.d.a(10002, this.UYR);
        AppMethodBeat.o(116909);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(116910);
        h.d.b(10000, this.iDE);
        h.d.b(1, this.iDE);
        h.d.b(10001, this.UYR);
        h.d.b(10002, this.UYR);
        AppMethodBeat.o(116910);
    }

    @Override // com.tencent.mm.kernel.api.e
    public void onDataBaseOpened(com.tencent.mm.storagebase.h hVar, com.tencent.mm.storagebase.h hVar2) {
        AppMethodBeat.i(116911);
        y.aTW();
        d dVar = this.UYP;
        com.tencent.mm.storagebase.h hVar3 = com.tencent.mm.kernel.g.aAh().hqK;
        com.tencent.mm.kernel.g.aAh();
        dVar.zpB = new o(new j(hVar3));
        dVar.zpC = new com.tencent.mm.ba.a();
        dVar.zpw = new ay(hVar3);
        dVar.zpx = new co(hVar3);
        dVar.zpy = new br(hVar3);
        dVar.zpA = new ba(hVar3);
        dVar.zpz = new cb(hVar3, dVar.zpw, dVar.zpA);
        dVar.zpD = new com.tencent.mm.storage.cj(hVar3);
        dVar.zpE = new bd(hVar3);
        dVar.zpF = new bo(hVar3);
        dVar.zpG = new bm(hVar3);
        dVar.zpH = new by(hVar3);
        dVar.zpI = new cm(hVar3);
        dVar.zpJ = new ct(hVar3);
        dVar.zpK = new ak(hVar3);
        dVar.zpL = new bu(hVar3);
        AppMethodBeat.o(116911);
    }

    @Override // com.tencent.mm.kernel.api.e
    public void onDataBaseClosed(com.tencent.mm.storagebase.h hVar, com.tencent.mm.storagebase.h hVar2) {
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.s
    public cj getSysCmdMsgExtension() {
        return this.UYR;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.s
    public void setIDataTransferFactoryDelegate(at atVar) {
        this.UYU = atVar;
    }

    @Override // com.tencent.mm.model.at
    public List<as> getDataTransferList() {
        AppMethodBeat.i(116912);
        if (this.UYU != null) {
            List<as> dataTransferList = this.UYU.getDataTransferList();
            if (dataTransferList.size() > 8) {
                Assert.assertTrue("Do not add more IDataTransfer from mIDataTransferFactoryDelegate!!!!!!!!!!!", false);
            }
            AppMethodBeat.o(116912);
            return dataTransferList;
        }
        ArrayList arrayList = new ArrayList();
        AppMethodBeat.o(116912);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.s
    public void setBizTimeLineCallback(b bVar) {
        this.UYV = bVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.s
    public b getBizTimeLineCallback() {
        return this.UYV;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.s
    public void setEnSendMsgActionFlag(int i2) {
        AppMethodBeat.i(116913);
        Log.i("MicroMsg.TAG", "setEnSendMsgActionFlag %s", Integer.valueOf(i2));
        this.UYT = i2;
        AppMethodBeat.o(116913);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.s
    public boolean ifAddTicketByActionFlag(String str) {
        boolean z;
        AppMethodBeat.i(116914);
        if (this.UYT == 0) {
            z = false;
        } else {
            if (ab.Iu(str)) {
                if (Util.isEqual(this.UYT & 1, 1)) {
                    z = true;
                }
            } else if (ab.Eq(str) && Util.isEqual(this.UYT & 2, 2)) {
                z = true;
            }
            z = false;
        }
        Log.i("MicroMsg.TAG", "ifAddTicketByActionFlag %s %s", str, Boolean.valueOf(z));
        AppMethodBeat.o(116914);
        return z;
    }
}
