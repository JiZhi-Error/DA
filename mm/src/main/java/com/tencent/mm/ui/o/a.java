package com.tencent.mm.ui.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.h.a.f;
import com.tencent.mm.ui.o.b;
import java.util.ArrayList;
import org.b.a.a.c;
import org.b.d.i;
import org.b.d.j;
import org.b.d.k;
import org.b.g.d;

@SuppressLint({"HandlerLeak"})
public final class a implements b.a {
    MMHandler Eok = new MMHandler() {
        /* class com.tencent.mm.ui.o.a.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(152852);
            if (message.what == 1000) {
                String str = (String) message.obj;
                if (str != null) {
                    Context context = a.this.context;
                    a aVar = a.this;
                    if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
                        f.Y(context, "Error", "Application requires permission to access the Internet");
                    } else {
                        new b(context, str, aVar).show();
                    }
                } else {
                    a.this.c(c.QAR);
                }
            }
            if (message.what == 1010) {
                c cVar = (c) message.obj;
                a aVar2 = a.this;
                aVar2.QAK = false;
                if (cVar == c.QAR) {
                    aVar2.QAI = null;
                    a.a((i) null);
                }
                if (aVar2.QAM != null) {
                    aVar2.QAM.b(cVar);
                }
            }
            AppMethodBeat.o(152852);
        }
    };
    org.b.e.b QAG = null;
    public i QAH = null;
    i QAI = null;
    private boolean QAJ = false;
    boolean QAK = false;
    public b QAL = null;
    public AbstractC2123a QAM = null;
    Context context = null;

    /* renamed from: com.tencent.mm.ui.o.a$a  reason: collision with other inner class name */
    public interface AbstractC2123a {
        void b(c cVar);
    }

    public interface b {
        void a(c cVar);
    }

    public enum c {
        Finished,
        QAR,
        Canceled;

        public static c valueOf(String str) {
            AppMethodBeat.i(152860);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(152860);
            return cVar;
        }

        static {
            AppMethodBeat.i(152861);
            AppMethodBeat.o(152861);
        }
    }

    public a() {
        i iVar;
        AppMethodBeat.i(152862);
        org.b.a.a aVar = new org.b.a.a();
        aVar.Uie = org.b.a.a.bH(c.a.class);
        d.oM("XMr2y8FEVEqZBcZ1TU3gLA", "Invalid Api key");
        aVar.Uib = "XMr2y8FEVEqZBcZ1TU3gLA";
        d.oM("kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo", "Invalid Api secret");
        aVar.Uic = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
        d.j("wechatapp://sign-in-twitter.wechatapp.com/", "Callback can't be null");
        aVar.Uid = "wechatapp://sign-in-twitter.wechatapp.com/";
        d.j(aVar.Uie, "You must specify a valid api through the provider() method");
        d.oM(aVar.Uib, "You must provide an api key");
        d.oM(aVar.Uic, "You must provide an api secret");
        this.QAG = aVar.Uie.a(new org.b.d.a(aVar.Uib, aVar.Uic, aVar.Uid, aVar.Uif, aVar.scope, aVar.Uig));
        if (g.aAf().azp()) {
            String str = (String) g.aAh().azQ().get(69377, (Object) null);
            String str2 = (String) g.aAh().azQ().get(69378, (Object) null);
            if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
                iVar = null;
            } else {
                iVar = new i(str, str2);
            }
        } else {
            Log.e("Twitter", "acchas not ready for restoreTwitterAccessToken");
            iVar = null;
        }
        this.QAH = iVar;
        AppMethodBeat.o(152862);
    }

    public final void a(b bVar, Context context2) {
        AppMethodBeat.i(152863);
        if (this.QAJ) {
            AppMethodBeat.o(152863);
            return;
        }
        h.INSTANCE.idkeyStat(583, 0, 1, false);
        this.QAL = bVar;
        this.context = context2;
        this.QAJ = true;
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.ui.o.a.AnonymousClass2 */

            public final void run() {
                String str = null;
                AppMethodBeat.i(152853);
                try {
                    a.this.QAI = a.this.QAG.hQl();
                    str = a.this.QAG.b(a.this.QAI);
                } catch (org.b.b.a | org.b.b.b e2) {
                }
                a.this.Eok.sendMessage(a.this.Eok.obtainMessage(1000, str));
                AppMethodBeat.o(152853);
            }
        }, "Twitter_doOAuth");
        AppMethodBeat.o(152863);
    }

    public final boolean gYx() {
        return this.QAH != null;
    }

    public final void a(AbstractC2123a aVar) {
        AppMethodBeat.i(152864);
        if (this.QAK) {
            AppMethodBeat.o(152864);
            return;
        }
        this.QAM = aVar;
        this.QAK = true;
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.ui.o.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(152854);
                c cVar = c.Finished;
                if (a.this.QAH == null) {
                    cVar = c.QAR;
                } else {
                    org.b.d.c cVar2 = new org.b.d.c(j.GET, "https://api.twitter.com/1.1/account/verify_credentials.json");
                    a.this.QAG.a(a.this.QAH, cVar2);
                    try {
                        if (cVar2.hQf().code != 200) {
                            cVar = c.QAR;
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.Twitter", e2, "request error.", new Object[0]);
                        cVar = c.QAR;
                    }
                }
                a.this.Eok.sendMessage(a.this.Eok.obtainMessage(1010, cVar));
                AppMethodBeat.o(152854);
            }
        }, "Twitter_validationAccessToken");
        AppMethodBeat.o(152864);
    }

    static void a(i iVar) {
        AppMethodBeat.i(152865);
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
        if (iVar == null) {
            g.aAh().azQ().set(69377, "");
            g.aAh().azQ().set(69378, "");
            AppMethodBeat.o(152865);
            return;
        }
        g.aAh().azQ().set(69377, iVar.token);
        g.aAh().azQ().set(69378, iVar.Mte);
        AppMethodBeat.o(152865);
    }

    /* access modifiers changed from: package-private */
    public final void c(c cVar) {
        AppMethodBeat.i(152866);
        this.QAJ = false;
        this.QAI = null;
        if (this.QAL != null) {
            this.QAL.a(cVar);
        }
        AppMethodBeat.o(152866);
    }

    @Override // com.tencent.mm.ui.o.b.a
    public final void E(final Bundle bundle) {
        AppMethodBeat.i(152867);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.ui.o.a.AnonymousClass4 */

            public final void run() {
                i iVar = null;
                AppMethodBeat.i(152857);
                if (a.this.QAI == null) {
                    AppMethodBeat.o(152857);
                    return;
                }
                a.CP(true);
                String string = bundle.getString("oauth_verifier");
                if (string != null) {
                    try {
                        iVar = a.this.QAG.a(a.this.QAI, new k(string));
                    } catch (org.b.b.a e2) {
                    }
                }
                if (iVar != null) {
                    a.this.QAH = iVar;
                    a.a(a.this.QAH);
                    new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.tencent.mm.ui.o.a.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(152855);
                            a.this.c(c.Finished);
                            h.INSTANCE.idkeyStat(583, 1, 1, false);
                            AppMethodBeat.o(152855);
                        }
                    });
                    AppMethodBeat.o(152857);
                    return;
                }
                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.mm.ui.o.a.AnonymousClass4.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(152856);
                        a.this.c(c.QAR);
                        h.INSTANCE.idkeyStat(583, 4, 1, false);
                        AppMethodBeat.o(152856);
                    }
                });
                AppMethodBeat.o(152857);
            }

            public final String toString() {
                AppMethodBeat.i(152858);
                String str = super.toString() + "|onComplete";
                AppMethodBeat.o(152858);
                return str;
            }
        });
        AppMethodBeat.o(152867);
    }

    @Override // com.tencent.mm.ui.o.b.a
    public final void gYy() {
        AppMethodBeat.i(152868);
        CP(false);
        c(c.QAR);
        h.INSTANCE.idkeyStat(583, 2, 1, false);
        AppMethodBeat.o(152868);
    }

    @Override // com.tencent.mm.ui.o.b.a
    public final void onCancel() {
        AppMethodBeat.i(152869);
        CP(false);
        c(c.Canceled);
        h.INSTANCE.idkeyStat(583, 3, 1, false);
        AppMethodBeat.o(152869);
    }

    static void CP(boolean z) {
        AppMethodBeat.i(152870);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i.a(10251, z ? "1" : "2"));
        ((l) g.af(l.class)).aSM().d(new com.tencent.mm.ba.i(arrayList));
        AppMethodBeat.o(152870);
    }
}
