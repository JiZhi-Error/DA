package com.tencent.mm.modelvoice;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.app.o;
import com.tencent.mm.audio.b.i;
import com.tencent.mm.blink.b;
import com.tencent.mm.g.a.so;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cv;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import junit.framework.Assert;

public class o implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.modelvoice.o.AnonymousClass2 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(148435);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!com.tencent.mm.kernel.a.azj()) {
                    b.ake().arrange(new Runnable() {
                        /* class com.tencent.mm.modelvoice.o.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(148434);
                            o.bid().run();
                            AppMethodBeat.o(148434);
                        }
                    });
                }
            }
            AppMethodBeat.o(148435);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(148436);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                com.tencent.mm.kernel.a.azj();
            }
            AppMethodBeat.o(148436);
        }
    };
    private w jvm;
    private cv jvn;
    private i jvo;
    private t jvp = new t();
    private IListener jvq = new IListener<so>() {
        /* class com.tencent.mm.modelvoice.o.AnonymousClass1 */

        {
            AppMethodBeat.i(161586);
            this.__eventId = so.class.getName().hashCode();
            AppMethodBeat.o(161586);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(so soVar) {
            AppMethodBeat.i(148433);
            s.uj((int) soVar.dZf.dCM.field_msgId);
            AppMethodBeat.o(148433);
            return false;
        }
    };

    public o() {
        AppMethodBeat.i(148438);
        AppMethodBeat.o(148438);
    }

    private static o bia() {
        AppMethodBeat.i(148439);
        o oVar = (o) y.at(o.class);
        AppMethodBeat.o(148439);
        return oVar;
    }

    public static w bib() {
        AppMethodBeat.i(148440);
        g.aAf().azk();
        if (bia().jvm == null) {
            Assert.assertTrue("dataDB is null ", g.aAh().hqK != null);
            bia().jvm = new w(g.aAh().hqK);
        }
        w wVar = bia().jvm;
        AppMethodBeat.o(148440);
        return wVar;
    }

    public static cv bic() {
        AppMethodBeat.i(148441);
        g.aAf().azk();
        if (bia().jvn == null) {
            Assert.assertTrue("dataDB is null ", g.aAh().hqK != null);
            bia().jvn = new cv(g.aAh().hqK);
        }
        cv cvVar = bia().jvn;
        AppMethodBeat.o(148441);
        return cvVar;
    }

    public static i bid() {
        AppMethodBeat.i(148442);
        g.aAf().azk();
        if (bia().jvo == null) {
            bia().jvo = i.aaw();
        }
        Log.i("MicroMsg.SubCoreVoice", "getVoiceService %s", bia().jvo.toString());
        i iVar = bia().jvo;
        AppMethodBeat.o(148442);
        return iVar;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(148443);
        if (bia().jvo != null) {
            bia().jvo.dAF = 0;
        }
        this.appForegroundListener.dead();
        h.d.b(34, this.jvp);
        EventCenter.instance.removeListener(this.jvq);
        com.tencent.mm.pluginsdk.cmd.b.V("//voicetrymore");
        AppMethodBeat.o(148443);
    }

    static {
        AppMethodBeat.i(148445);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("VOICE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.modelvoice.o.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return w.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("VOICETRANSTEXT_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.modelvoice.o.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return cv.SQL_CREATE;
            }
        });
        AppMethodBeat.o(148445);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(148444);
        h.d.a(34, this.jvp);
        EventCenter.instance.addListener(this.jvq);
        this.appForegroundListener.alive();
        com.tencent.mm.pluginsdk.cmd.b.a(new a(), "//voicetrymore");
        AppMethodBeat.o(148444);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    static class a implements com.tencent.mm.pluginsdk.cmd.a {
        a() {
        }

        @Override // com.tencent.mm.pluginsdk.cmd.a
        public final boolean a(Context context, String[] strArr, String str) {
            boolean z;
            AppMethodBeat.i(148437);
            String str2 = strArr[0];
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1560895490:
                    if (str2.equals("//voicetrymore")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    if (strArr.length > 1 && strArr[1] != null) {
                        int i2 = Util.getInt(strArr[1], 1);
                        if (i2 == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        i.dAH = z;
                        Log.i("MicroMsg.SubCoreVoice", "summervoicetrymore enable[%d]", Integer.valueOf(i2));
                        AppMethodBeat.o(148437);
                        return true;
                    }
            }
            AppMethodBeat.o(148437);
            return false;
        }
    }
}
