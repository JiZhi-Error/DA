package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.blink.b;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.y.a;

public final class ab implements MStorageEx.IOnStorageChange {
    IListener<ts> OAQ = new IListener<ts>() {
        /* class com.tencent.mm.ui.ab.AnonymousClass6 */

        {
            AppMethodBeat.i(161509);
            this.__eventId = ts.class.getName().hashCode();
            AppMethodBeat.o(161509);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ts tsVar) {
            AppMethodBeat.i(33497);
            ab.this.OIp = true;
            MMHandlerThread.removeRunnable(ab.this.OIq);
            MMHandlerThread.postToMainThread(ab.this.OIq);
            AppMethodBeat.o(33497);
            return false;
        }
    };
    IListener OAR = new IListener<lb>() {
        /* class com.tencent.mm.ui.ab.AnonymousClass5 */

        {
            AppMethodBeat.i(161508);
            this.__eventId = lb.class.getName().hashCode();
            AppMethodBeat.o(161508);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lb lbVar) {
            AppMethodBeat.i(33496);
            b.ake().arrange(new Runnable() {
                /* class com.tencent.mm.ui.ab.AnonymousClass5.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(33495);
                    ab.this.OIp = true;
                    MMHandlerThread.removeRunnable(ab.this.OIq);
                    MMHandlerThread.postToMainThread(ab.this.OIq);
                    AppMethodBeat.o(33495);
                }
            });
            AppMethodBeat.o(33496);
            return true;
        }
    };
    LauncherUI.c OIn;
    c OIo;
    private boolean OIp;
    private Runnable OIq = new Runnable() {
        /* class com.tencent.mm.ui.ab.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(33490);
            if (!g.aAf().azp()) {
                Log.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "Account not Ready!!!");
                AppMethodBeat.o(33490);
            } else if (ab.this.OIo == null) {
                Log.w("MicroMsg.LauncherUI.MainTabUnreadMgr", "set tag job, but tab view is null");
                AppMethodBeat.o(33490);
            } else {
                com.tencent.mm.vending.g.g.hdG().d(new com.tencent.mm.vending.c.a<Integer, Void>() {
                    /* class com.tencent.mm.ui.ab.AnonymousClass1.AnonymousClass2 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Integer call(Void r7) {
                        int i2;
                        int i3 = 0;
                        AppMethodBeat.i(33489);
                        if (!bg.aAc()) {
                            Log.w("MicroMsg.UnreadCountHelper", "getFindTabUnreadCount, but mmcore not ready");
                        } else {
                            int aUc = z.aUc();
                            if ((z.aUl() & 64) == 0 && (aUc & 32768) == 0) {
                                i2 = s.aTQ() + 0;
                            } else {
                                i2 = 0;
                            }
                            if ((z.aUl() & 256) == 0) {
                                cm bgP = d.bgP();
                                if (bgP != null) {
                                    i3 = bgP.ctM() + 0;
                                }
                                i3 += o.a.glW().eUf();
                            }
                            int i4 = i2 + i3;
                            if ((z.aUl() & 32768) != 0 || com.tencent.mm.plugin.sns.b.o.DCO == null) {
                                i3 = i4;
                            } else {
                                i3 = i4 + com.tencent.mm.plugin.sns.b.o.DCO.ctM();
                            }
                            e redDotMgr = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr();
                            if (com.tencent.mm.aw.b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
                                Log.i("MicroMsg.UnreadCountHelper", "checkLookVisibility EuropeanUnionCountry");
                            } else if (redDotMgr != null && redDotMgr.fxI() && redDotMgr.fxJ()) {
                                int fxu = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxu();
                                if (((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxy() && fxu > 0) {
                                    i3 += fxu;
                                }
                            }
                        }
                        Integer valueOf = Integer.valueOf(i3);
                        AppMethodBeat.o(33489);
                        return valueOf;
                    }
                }).f(new com.tencent.mm.vending.c.a<Void, Integer>() {
                    /* class com.tencent.mm.ui.ab.AnonymousClass1.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Void call(Integer num) {
                        AppMethodBeat.i(33488);
                        Void q = q(num);
                        AppMethodBeat.o(33488);
                        return q;
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0244, code lost:
                        if (((java.lang.Boolean) com.tencent.mm.model.c.azQ().get(com.tencent.mm.storage.ar.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, java.lang.Boolean.FALSE)).booleanValue() == true) goto L_0x0246;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    private java.lang.Void q(java.lang.Integer r13) {
                        /*
                        // Method dump skipped, instructions count: 849
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.ab.AnonymousClass1.AnonymousClass1.q(java.lang.Integer):java.lang.Void");
                    }
                }).b(ab.this.uLr);
                if (((com.tencent.mm.plugin.updater.a.a) g.ah(com.tencent.mm.plugin.updater.a.a.class)).hasBottomTabRedDot()) {
                    ab.this.OIo.AU(true);
                }
                AppMethodBeat.o(33490);
            }
        }

        public final String toString() {
            AppMethodBeat.i(33491);
            String str = super.toString() + "|setTagRunnable";
            AppMethodBeat.o(33491);
            return str;
        }
    };
    a OIr;
    a.AbstractC2176a OIs = new a.AbstractC2176a() {
        /* class com.tencent.mm.ui.ab.AnonymousClass11 */

        @Override // com.tencent.mm.y.a.AbstractC2176a
        public final void D(int i2, String str) {
            AppMethodBeat.i(33502);
            if (i2 == 262145 || i2 == 262156 || i2 == 262152 || i2 == 266260 || i2 == 266267) {
                ab.e(ab.this);
            }
            if (i2 == 262147 || i2 == 262149 || i2 == 352279 || i2 == 352280) {
                ab.e(ab.this);
            }
            AppMethodBeat.o(33502);
        }

        @Override // com.tencent.mm.y.a.AbstractC2176a
        public final void b(ar.a aVar) {
            AppMethodBeat.i(33503);
            if (aVar == ar.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC) {
                ab.e(ab.this);
            }
            AppMethodBeat.o(33503);
        }
    };
    MStorageEx.IOnStorageChange OIt = new MStorageEx.IOnStorageChange() {
        /* class com.tencent.mm.ui.ab.AnonymousClass12 */

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(33504);
            int nullAsInt = Util.nullAsInt(obj, 0);
            Log.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i2), Integer.valueOf(nullAsInt), mStorageEx);
            bg.aVF();
            if (mStorageEx != c.azQ() || nullAsInt <= 0) {
                Log.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(nullAsInt), mStorageEx);
                AppMethodBeat.o(33504);
                return;
            }
            ab.this.gJd();
            if (nullAsInt == 143618) {
                ab.d(ab.this);
                AppMethodBeat.o(33504);
                return;
            }
            if (nullAsInt == 204817 || nullAsInt == 204820) {
                ab.e(ab.this);
            }
            AppMethodBeat.o(33504);
        }
    };
    IListener OIu = new IListener<yi>() {
        /* class com.tencent.mm.ui.ab.AnonymousClass2 */

        {
            AppMethodBeat.i(161507);
            this.__eventId = yi.class.getName().hashCode();
            AppMethodBeat.o(161507);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yi yiVar) {
            AppMethodBeat.i(33492);
            Log.v("MicroMsg.LauncherUI.MainTabUnreadMgr", "appTagUnreadChangeListener, event:%s", yiVar.toString());
            ab.this.gJd();
            AppMethodBeat.o(33492);
            return false;
        }
    };
    MMFragmentActivity uLr;

    public ab() {
        AppMethodBeat.i(33506);
        AppMethodBeat.o(33506);
    }

    /* access modifiers changed from: protected */
    public final void gJg() {
        AppMethodBeat.i(33507);
        b.ake().arrange(new Runnable() {
            /* class com.tencent.mm.ui.ab.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(33499);
                ab.this.OIp = true;
                MMHandlerThread.removeRunnable(ab.this.OIq);
                MMHandlerThread.postToMainThread(ab.this.OIq);
                AppMethodBeat.o(33499);
            }
        });
        AppMethodBeat.o(33507);
    }

    /* access modifiers changed from: protected */
    public final void gJd() {
        AppMethodBeat.i(33508);
        b.ake().arrange(new Runnable() {
            /* class com.tencent.mm.ui.ab.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(33500);
                ab.this.OIp = true;
                MMHandlerThread.removeRunnable(ab.this.OIq);
                MMHandlerThread.postToMainThreadDelayed(ab.this.OIq, 300);
                AppMethodBeat.o(33500);
            }
        });
        AppMethodBeat.o(33508);
    }

    /* access modifiers changed from: protected */
    public final void gJb() {
        AppMethodBeat.i(33509);
        b.ake().arrange(new Runnable() {
            /* class com.tencent.mm.ui.ab.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(33501);
                if (ab.this.OIp) {
                    Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "remove setTagRunnable");
                    MMHandlerThread.removeRunnable(ab.this.OIq);
                }
                AppMethodBeat.o(33501);
            }
        });
        AppMethodBeat.o(33509);
    }

    /* access modifiers changed from: protected */
    public final void gJc() {
        AppMethodBeat.i(33510);
        if (this.OIp) {
            Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "start  setAppTagUnreadNow");
            gJg();
        }
        AppMethodBeat.o(33510);
    }

    /* access modifiers changed from: package-private */
    public static class a implements i.a {
        c OIo;

        public a(c cVar) {
            this.OIo = cVar;
        }

        @Override // com.tencent.mm.plugin.newtips.a.i.a
        public final void e(com.tencent.mm.plugin.newtips.b.a aVar) {
            AppMethodBeat.i(33505);
            if (aVar != null && aVar.field_tipId == com.tencent.mm.plugin.newtips.a.d.ADb) {
                com.tencent.mm.plugin.newtips.a.exo();
                if (com.tencent.mm.plugin.newtips.a.e.Ty(com.tencent.mm.plugin.newtips.a.d.ADb)) {
                    this.OIo.AU(true);
                }
            }
            AppMethodBeat.o(33505);
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(33512);
        if (obj == null || !(obj instanceof String)) {
            Log.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(33512);
            return;
        }
        bg.aVF();
        if (mStorageEx == c.aST()) {
            Log.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "Launcherui onNotifyChange event type %d, username %s", Integer.valueOf(i2), obj);
            if (as.IG((String) obj)) {
                gJd();
            }
            AppMethodBeat.o(33512);
            return;
        }
        AppMethodBeat.o(33512);
    }

    public final void alg(int i2) {
        AppMethodBeat.i(33513);
        if (this.OIo != null) {
            this.OIo.setTo(i2);
        }
        AppMethodBeat.o(33513);
    }

    public final int gJh() {
        AppMethodBeat.i(33514);
        int i2 = 0;
        if (this.OIo != null && this.OIo.getMainTabUnread() > 0) {
            i2 = this.OIo.getMainTabUnread();
        }
        AppMethodBeat.o(33514);
        return i2;
    }

    static /* synthetic */ void d(ab abVar) {
        AppMethodBeat.i(33515);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.ab.AnonymousClass4 */

            public final String toString() {
                AppMethodBeat.i(232650);
                String str = super.toString() + "|setAddressTagUnread";
                AppMethodBeat.o(232650);
                return str;
            }

            public final void run() {
                int nullAsNil;
                AppMethodBeat.i(232649);
                if (!bg.aAc()) {
                    Log.w("MicroMsg.UnreadCountHelper", "getAddrTabUnreadCount, but mmcore not ready");
                    nullAsNil = 0;
                } else {
                    bg.aVF();
                    nullAsNil = Util.nullAsNil((Integer) c.azQ().get(143618, (Object) null));
                }
                if (ab.this.OIo != null) {
                    ab.this.OIo.akI(nullAsNil);
                }
                AppMethodBeat.o(232649);
            }
        });
        AppMethodBeat.o(33515);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x03d9  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0327  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0395  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x03c7  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x03cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void e(com.tencent.mm.ui.ab r20) {
        /*
        // Method dump skipped, instructions count: 1001
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.ab.e(com.tencent.mm.ui.ab):void");
    }
}
