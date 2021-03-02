package com.tencent.mm.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.TimeLogger;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public static final HashSet<b> jMm = new HashSet<>();
    private static final b jMn = new b() {
        /* class com.tencent.mm.platformtools.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.account.a.a.b
        public final void fG(boolean z) {
            AppMethodBeat.i(127662);
            Log.i("MicroMsg.AddrBookSyncHelper", "syncAddrBookAndUpload onSyncEnd suc:%b", Boolean.valueOf(z));
            if (!z) {
                AppMethodBeat.o(127662);
                return;
            }
            System.currentTimeMillis();
            l.boe();
            g.azz().a(new ao(l.boi(), l.boh()), 0);
            AppMethodBeat.o(127662);
        }
    };
    private static Thread thread = null;

    static {
        AppMethodBeat.i(127672);
        AppMethodBeat.o(127672);
    }

    public static boolean blm() {
        AppMethodBeat.i(127670);
        boolean syncAddrBook = syncAddrBook(jMn);
        AppMethodBeat.o(127670);
        return syncAddrBook;
    }

    public static boolean syncAddrBook(final b bVar) {
        AppMethodBeat.i(127671);
        final long id = Thread.currentThread().getId();
        boolean boc = l.boc();
        if (!boc) {
            Log.e("MicroMsg.AddrBookSyncHelper", "canSync:%b, skip", Boolean.valueOf(boc));
            AppMethodBeat.o(127671);
            return false;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.platformtools.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(127663);
                boolean z = a.thread != null && a.thread.isAlive();
                Log.i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", Boolean.valueOf(z), Integer.valueOf(a.jMm.size()), Long.valueOf(id), bVar);
                a.jMm.add(bVar);
                if (z) {
                    AppMethodBeat.o(127663);
                    return;
                }
                l.gl(true);
                h.RTc.ba(new C0506a((byte) 0));
                AppMethodBeat.o(127663);
            }
        });
        AppMethodBeat.o(127671);
        return true;
    }

    public static boolean bln() {
        return C0506a.iUD;
    }

    /* renamed from: com.tencent.mm.platformtools.a$a  reason: collision with other inner class name */
    static class C0506a implements com.tencent.f.i.h {
        public static boolean iUD = false;
        private static final MMHandler jMv = new MMHandler(Looper.getMainLooper()) {
            /* class com.tencent.mm.platformtools.a.C0506a.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(127664);
                if (!g.aAc()) {
                    AppMethodBeat.o(127664);
                    return;
                }
                f.a aVar = new f.a();
                int size = a.jMm.size();
                boolean parseBoolean = Boolean.parseBoolean(message.obj.toString());
                Iterator<b> it = a.jMm.iterator();
                while (it.hasNext()) {
                    it.next().fG(parseBoolean);
                }
                a.jMm.clear();
                Log.i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", Integer.valueOf(size), Long.valueOf(aVar.apr()));
                AppMethodBeat.o(127664);
            }
        };
        private static byte[] lock = new byte[0];
        private List<String[]> jMq;
        private List<String[]> jMr;
        private List<com.tencent.mm.plugin.account.friend.a.a> jMs;
        private List<com.tencent.mm.plugin.account.friend.a.a> jMt;
        private TimeLogger jMu;

        private C0506a() {
        }

        /* synthetic */ C0506a(byte b2) {
            this();
        }

        static {
            AppMethodBeat.i(127669);
            AppMethodBeat.o(127669);
        }

        private static List<com.tencent.mm.plugin.account.friend.a.a> c(List<com.tencent.mm.plugin.account.friend.a.a> list, int i2, int i3) {
            AppMethodBeat.i(127665);
            LinkedList linkedList = new LinkedList();
            while (i2 < i3) {
                linkedList.add(list.get(i2));
                i2++;
            }
            AppMethodBeat.o(127665);
            return linkedList;
        }

        public final void run() {
            List<com.tencent.mm.plugin.account.friend.a.a> c2;
            List<com.tencent.mm.plugin.account.friend.a.a> c3;
            AppMethodBeat.i(127666);
            synchronized (lock) {
                try {
                    this.jMu = new TimeLogger("MicroMsg.AddrBookSyncHelper", "sync addrBook");
                    this.jMu.addSplit("sync begin");
                    Log.d("MicroMsg.AddrBookSyncHelper", "reading email info");
                    this.jMq = com.tencent.mm.pluginsdk.b.ij(MMApplicationContext.getContext());
                    if (this.jMq != null) {
                        Log.i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.jMq.size());
                    }
                    this.jMt = d(1, this.jMq);
                    Log.d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
                    this.jMr = com.tencent.mm.pluginsdk.b.ii(MMApplicationContext.getContext());
                    if (this.jMr != null) {
                        Log.i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.jMr.size());
                    }
                    this.jMs = d(0, this.jMr);
                    Log.d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
                    if (this.jMq != null && this.jMt.size() > 0) {
                        for (int i2 = 0; i2 < this.jMt.size(); i2 += 100) {
                            Log.i("MicroMsg.AddrBookSyncHelper", "sync email index: ".concat(String.valueOf(i2)));
                            if (i2 + 100 < this.jMt.size()) {
                                c3 = c(this.jMt, i2, i2 + 100);
                            } else {
                                List<com.tencent.mm.plugin.account.friend.a.a> list = this.jMt;
                                c3 = c(list, i2, list.size());
                            }
                            Log.i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + c3.size());
                            l.aW(c3);
                        }
                    }
                    if (this.jMs == null || this.jMs.size() == 0) {
                        Log.i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
                        Message obtainMessage = jMv.obtainMessage();
                        obtainMessage.obj = Boolean.FALSE;
                        jMv.sendMessage(obtainMessage);
                        return;
                    }
                    for (int i3 = 0; i3 < this.jMs.size(); i3 += 100) {
                        Log.i("MicroMsg.AddrBookSyncHelper", "sync mobile index: ".concat(String.valueOf(i3)));
                        if (!g.aAc()) {
                            Log.i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
                            Message obtainMessage2 = jMv.obtainMessage();
                            obtainMessage2.obj = Boolean.FALSE;
                            jMv.sendMessage(obtainMessage2);
                            AppMethodBeat.o(127666);
                            return;
                        }
                        if (i3 + 100 < this.jMs.size()) {
                            c2 = c(this.jMs, i3, i3 + 100);
                        } else {
                            List<com.tencent.mm.plugin.account.friend.a.a> list2 = this.jMs;
                            c2 = c(list2, i3, list2.size());
                        }
                        Log.i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + c2.size());
                        l.aW(c2);
                    }
                    Log.i("MicroMsg.AddrBookSyncHelper", "sync ok");
                    if (!g.aAc()) {
                        Log.i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
                        Message obtainMessage3 = jMv.obtainMessage();
                        obtainMessage3.obj = Boolean.FALSE;
                        jMv.sendMessage(obtainMessage3);
                        AppMethodBeat.o(127666);
                        return;
                    }
                    blp();
                    System.currentTimeMillis();
                    l.boe();
                    this.jMu.addSplit("sync ok");
                    this.jMu.dumpToLog();
                    Message obtainMessage4 = jMv.obtainMessage();
                    obtainMessage4.obj = Boolean.TRUE;
                    jMv.sendMessage(obtainMessage4);
                    AppMethodBeat.o(127666);
                } finally {
                    AppMethodBeat.o(127666);
                }
            }
        }

        private static void blp() {
            AppMethodBeat.i(127667);
            TimeLogger timeLogger = new TimeLogger("MicroMsg.AddrBookSyncHelper", "delete");
            ArrayList arrayList = new ArrayList();
            List<String> ik = com.tencent.mm.pluginsdk.b.ik(MMApplicationContext.getContext());
            for (String[] strArr : ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).bnS()) {
                String nullAsNil = Util.nullAsNil(strArr[0]);
                String nullAsNil2 = Util.nullAsNil(strArr[1]);
                if (!nullAsNil.equals("") && !ik.contains(nullAsNil)) {
                    arrayList.add(nullAsNil2);
                }
            }
            if (arrayList.size() > 0) {
                ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aT(arrayList);
                l.aV(arrayList);
            }
            timeLogger.addSplit("end");
            timeLogger.dumpToLog();
            AppMethodBeat.o(127667);
        }

        private static List<com.tencent.mm.plugin.account.friend.a.a> d(int i2, List<String[]> list) {
            AppMethodBeat.i(127668);
            if (list == null) {
                Log.e("MicroMsg.AddrBookSyncHelper", "sync address book failed, null info list");
                LinkedList linkedList = new LinkedList();
                AppMethodBeat.o(127668);
                return linkedList;
            }
            ArrayList arrayList = new ArrayList();
            for (String[] strArr : list) {
                if (strArr != null) {
                    String str = strArr[0];
                    String str2 = strArr[1];
                    String str3 = strArr[2];
                    String str4 = strArr[3];
                    long safeParseLong = Util.safeParseLong(strArr[4]);
                    if (str3 != null && !str3.equals("")) {
                        String str5 = "";
                        if (i2 == 1) {
                            str5 = com.tencent.mm.b.g.getMessageDigest(str3.getBytes());
                        }
                        if (i2 == 0) {
                            String Ts = com.tencent.mm.pluginsdk.b.Ts(str3);
                            if (Util.isNullOrNil(Ts)) {
                                Log.d("MicroMsg.AddrBookSyncHelper", "formatted mobile null, continue");
                            } else {
                                str5 = com.tencent.mm.b.g.getMessageDigest(Ts.getBytes());
                            }
                        }
                        com.tencent.mm.plugin.account.friend.a.a aVar = new com.tencent.mm.plugin.account.friend.a.a();
                        aVar.realName = str2;
                        aVar.kdP = f.Si(str2);
                        aVar.kdQ = f.Sh(str2);
                        aVar.kdN = str;
                        aVar.iKR = str4;
                        aVar.setMd5(str5);
                        aVar.keq = safeParseLong;
                        aVar.kdW = aVar.aqN();
                        if (i2 == 1) {
                            aVar.fuD = str3;
                        }
                        if (i2 == 0) {
                            aVar.kdT = str3;
                        }
                        aVar.type = i2;
                        aVar.cSx = 1095798;
                        arrayList.add(aVar);
                    }
                }
            }
            AppMethodBeat.o(127668);
            return arrayList;
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "AddrBookSyncHelper_addrBookRead";
        }
    }
}
