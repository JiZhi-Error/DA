package com.tencent.mm.plugin.extqlauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fs;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.extqlauncher.provider.ExtControlProviderQLauncher;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class b implements bd {
    private a sOM;
    private C1033b sON;
    boolean sOO = false;
    private MStorageEx.IOnStorageChange sOP = new MStorageEx.IOnStorageChange() {
        /* class com.tencent.mm.plugin.extqlauncher.b.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(24549);
            Log.d("MicroMsg.SubCoreExtQLauncher", "onNotifyChange");
            if (b.this.sOO) {
                AppMethodBeat.o(24549);
                return;
            }
            bg.aVF();
            if (mStorageEx != c.aST()) {
                AppMethodBeat.o(24549);
            } else if (mStorageEx == null || obj == null) {
                Log.e("MicroMsg.SubCoreExtQLauncher", "onConversationChange, wrong args");
                AppMethodBeat.o(24549);
            } else if (MMApplicationContext.getContext() == null || !bg.aAc()) {
                Log.w("MicroMsg.SubCoreExtQLauncher", "wrong account status");
                AppMethodBeat.o(24549);
            } else {
                b.this.cSJ();
                AppMethodBeat.o(24549);
            }
        }
    };
    boolean sOQ = false;
    long sOR = 0;
    private final long sOS = 300000;
    private final long sOT = 4000;
    private final String sOU = "fun1";
    int sOV = 0;
    private MMHandler sOW = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.extqlauncher.b.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
        public final void handleMessage(Message message) {
            AppMethodBeat.i(24552);
            if (MMApplicationContext.getContext() == null || !bg.aAc()) {
                Log.w("MicroMsg.SubCoreExtQLauncher", "wrong status");
                AppMethodBeat.o(24552);
                return;
            }
            if (b.a(b.this) && b.this.sOV > 0) {
                Log.d("MicroMsg.SubCoreExtQLauncher", "notify unread");
                Intent intent = new Intent("com.tencent.mm.ext.ACTION_EXT_NOTIFY");
                intent.putExtra("EXTRA_EXT_NOTIFY_TYPE", "NEW_UNREAD");
                MMApplicationContext.getContext().sendBroadcast(intent);
                b.this.sOV = 0;
            }
            AppMethodBeat.o(24552);
        }
    };

    public b() {
        AppMethodBeat.i(24556);
        AppMethodBeat.o(24556);
    }

    public static b cSI() {
        AppMethodBeat.i(24557);
        bg.aVz();
        b bVar = (b) cg.KG("plugin.extqlauncher");
        if (bVar == null) {
            bVar = new b();
            bg.aVz().a("plugin.extqlauncher", bVar);
        }
        AppMethodBeat.o(24557);
        return bVar;
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    public static class a extends IListener<fs> {
        public a() {
            AppMethodBeat.i(161364);
            this.__eventId = fs.class.getName().hashCode();
            AppMethodBeat.o(161364);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fs fsVar) {
            AppMethodBeat.i(24553);
            fs fsVar2 = fsVar;
            if (!(fsVar2 instanceof fs)) {
                Log.f("MicroMsg.SubCoreExtQLauncher", "mismatched event");
                AppMethodBeat.o(24553);
                return false;
            }
            ExtControlProviderQLauncher extControlProviderQLauncher = new ExtControlProviderQLauncher(fsVar2.dIR.dBX, fsVar2.dIR.dIT, fsVar2.dIR.context);
            fsVar2.dIS.dIU = extControlProviderQLauncher.query(fsVar2.dIR.uri, null, null, fsVar2.dIR.selectionArgs, null);
            AppMethodBeat.o(24553);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.extqlauncher.b$b  reason: collision with other inner class name */
    class C1033b extends IListener<qa> {
        private C1033b() {
            AppMethodBeat.i(161365);
            this.__eventId = qa.class.getName().hashCode();
            AppMethodBeat.o(161365);
        }

        /* synthetic */ C1033b(b bVar, byte b2) {
            this();
            AppMethodBeat.i(161366);
            this.__eventId = qa.class.getName().hashCode();
            AppMethodBeat.o(161366);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qa qaVar) {
            AppMethodBeat.i(24555);
            boolean a2 = a(qaVar);
            AppMethodBeat.o(24555);
            return a2;
        }

        private boolean a(qa qaVar) {
            AppMethodBeat.i(24554);
            if (!b.a(b.this)) {
                Log.e("MicroMsg.SubCoreExtQLauncher", "!isPluginInstall");
                AppMethodBeat.o(24554);
                return false;
            } else if (MMApplicationContext.getContext() == null) {
                Log.e("MicroMsg.SubCoreExtQLauncher", "MMApplicationContext null");
                AppMethodBeat.o(24554);
                return false;
            } else {
                Log.d("MicroMsg.SubCoreExtQLauncher", "GetScanCodeEvent callback flag = %s, url = %s", Integer.valueOf(qaVar.dWj.cSx), qaVar.dWj.scanResult);
                try {
                    switch (qaVar.dWj.cSx) {
                        case 1:
                            if (!Util.isNullOrNil(qaVar.dWj.scanResult) && qaVar.dWj.scanResult.startsWith("qlauncher://")) {
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.setComponent(new ComponentName("com.tencent.qlauncher", "com.tencent.qlauncher.thirdpartycoop.DispatchActivity"));
                                intent.setData(Uri.parse(qaVar.dWj.scanResult));
                                intent.setFlags(268435456);
                                Context context = MMApplicationContext.getContext();
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/extqlauncher/SubCoreExtQLauncher$GetScanCodeListener", "callback", "(Lcom/tencent/mm/autogen/events/PublishScanCodeResultEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/extqlauncher/SubCoreExtQLauncher$GetScanCodeListener", "callback", "(Lcom/tencent/mm/autogen/events/PublishScanCodeResultEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                qaVar.dWk.ret = 1;
                                AppMethodBeat.o(24554);
                                return true;
                            }
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.SubCoreExtQLauncher", "Exception in ScanCodeResultEvent, %s", e2.getMessage());
                }
                AppMethodBeat.o(24554);
                return false;
            }
        }
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(24558);
        bg.aVF();
        c.aST().add(this.sOP);
        if (this.sOM == null) {
            this.sOM = new a();
        }
        EventCenter.instance.addListener(this.sOM);
        if (this.sON == null) {
            this.sON = new C1033b(this, (byte) 0);
        }
        EventCenter.instance.addListener(this.sON);
        AppMethodBeat.o(24558);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(24559);
        if (this.sOM != null) {
            EventCenter.instance.removeListener(this.sOM);
        }
        if (this.sON != null) {
            EventCenter.instance.removeListener(this.sON);
        }
        bg.aVF();
        c.aST().remove(this.sOP);
        this.sOW.removeMessages(0);
        AppMethodBeat.o(24559);
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    public final void cSJ() {
        AppMethodBeat.i(24561);
        this.sOW.removeMessages(0);
        this.sOW.sendEmptyMessageDelayed(0, 4000);
        AppMethodBeat.o(24561);
    }

    static /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(24562);
        if (MMApplicationContext.getContext() == null) {
            Log.w("MicroMsg.SubCoreExtQLauncher", "isPluginInstall, ApplicationContext null");
            bVar.sOQ = false;
            AppMethodBeat.o(24562);
            return false;
        } else if (System.currentTimeMillis() - bVar.sOR < 300000) {
            boolean z = bVar.sOQ;
            AppMethodBeat.o(24562);
            return z;
        } else {
            com.tencent.f.h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.extqlauncher.b.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(24550);
                    try {
                        b.this.sOR = System.currentTimeMillis();
                        Log.e("MicroMsg.SubCoreExtQLauncher", "getInstalledApplications return null");
                        b.this.sOQ = false;
                        AppMethodBeat.o(24550);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.SubCoreExtQLauncher", "exception in getApplicationInfo, %s", e2.getMessage());
                        b.this.sOQ = false;
                        AppMethodBeat.o(24550);
                    }
                }

                public final String toString() {
                    AppMethodBeat.i(24551);
                    String str = super.toString() + "|isPluginInstall";
                    AppMethodBeat.o(24551);
                    return str;
                }
            }, "MicroMsg.SubCoreExtQLauncher");
            boolean z2 = bVar.sOQ;
            AppMethodBeat.o(24562);
            return z2;
        }
    }
}
