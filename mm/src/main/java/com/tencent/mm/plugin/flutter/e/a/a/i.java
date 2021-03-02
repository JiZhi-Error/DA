package com.tencent.mm.plugin.flutter.e.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.plugin.flutter.e.a.a.o;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.bj;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class i implements com.tencent.mm.ak.i {
    private static volatile i wKc = null;
    HashMap<c, q> wKd = new HashMap<>();
    private final MStorage.IOnStorageChange wKe = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.flutter.e.a.a.i.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(240954);
            if (!TextUtils.isEmpty(str) && str.equals("event_update_group")) {
                Log.d("MMVideoEditorEmojiPaneiOperate", "modify emoji group .");
                i.dLY();
            }
            AppMethodBeat.o(240954);
        }
    };
    private final MStorage.IOnStorageChange wKf = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.flutter.e.a.a.i.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(240955);
            Log.i("MMVideoEditorEmojiPaneiOperate", "emoji storage notify %s", str);
            if (str == null) {
                AppMethodBeat.o(240955);
                return;
            }
            i.dLY();
            AppMethodBeat.o(240955);
        }
    };
    private final IListener wKg = new IListener<rj>() {
        /* class com.tencent.mm.plugin.flutter.e.a.a.i.AnonymousClass3 */

        {
            AppMethodBeat.i(240956);
            this.__eventId = rj.class.getName().hashCode();
            AppMethodBeat.o(240956);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(rj rjVar) {
            AppMethodBeat.i(240957);
            Log.i("MMVideoEditorEmojiPaneiOperate", "REFRESH_PANEL_EVENT");
            i.dLY();
            AppMethodBeat.o(240957);
            return false;
        }
    };

    private i() {
        AppMethodBeat.i(240958);
        if (MMApplicationContext.isMainProcess()) {
            g.aAg().hqi.a(698, this);
        }
        ((d) g.ah(d.class)).getProvider().k(this.wKe);
        ((d) g.ah(d.class)).getProvider().i(this.wKf);
        EventCenter.instance.addListener(this.wKg);
        AppMethodBeat.o(240958);
    }

    public static i dLX() {
        AppMethodBeat.i(240959);
        if (wKc == null) {
            synchronized (i.class) {
                try {
                    if (wKc == null) {
                        wKc = new i();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(240959);
                    throw th;
                }
            }
        }
        i iVar = wKc;
        AppMethodBeat.o(240959);
        return iVar;
    }

    public final void br(int i2, String str) {
        AppMethodBeat.i(240960);
        if (i2 == 0 || i2 == 1) {
            c cVar = new c(i2, 2, Collections.singletonList(str));
            this.wKd.put(cVar, new q(str, i2));
            g.aAg().hqi.a(cVar, 0);
        }
        AppMethodBeat.o(240960);
    }

    public final void bs(int i2, String str) {
        AppMethodBeat.i(240961);
        if (i2 == 0 || i2 == 1) {
            c cVar = new c(i2, 3, Collections.singletonList(str));
            this.wKd.put(cVar, new q(str, i2));
            g.aAg().hqi.a(cVar, 0);
        }
        AppMethodBeat.o(240961);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(240962);
        if (!this.wKd.containsKey(qVar)) {
            AppMethodBeat.o(240962);
            return;
        }
        q qVar2 = this.wKd.get(qVar);
        String str2 = qVar2.md5;
        int i4 = qVar2.gYc;
        List<String> singletonList = Collections.singletonList(str2);
        Log.i("MMVideoEditorEmojiPaneiOperate", "onSceneEnd: %s, %s, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(i4));
        if (qVar != null) {
            if (((c) qVar).kfa == 3) {
                if (i2 == 0 && i3 == 0) {
                    if (i4 == 0) {
                        j.auL().dW(true);
                        j.auL().dV(true);
                    } else {
                        j.auL().dY(true);
                    }
                    bj.gCJ().OpN.x(i4, singletonList);
                    AppMethodBeat.o(240962);
                    return;
                }
            } else if (((c) qVar).kfa == 2 && i2 == 0 && i3 == 0) {
                if (i4 == 0) {
                    j.auL().dW(true);
                    j.auL().dV(true);
                } else {
                    j.auL().dY(true);
                }
                bj.gCJ().OpN.I(singletonList, i4);
            }
        }
        AppMethodBeat.o(240962);
    }

    static /* synthetic */ void dLY() {
        AppMethodBeat.i(240963);
        o.a aVar = o.wKI;
        o.a.dMh().t("onEmojiPanelUpdate", 1);
        AppMethodBeat.o(240963);
    }
}
