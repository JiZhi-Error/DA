package com.tencent.mm.plugin.ext.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.d;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static Map<String, a> iGj = null;
    final i callback = new i() {
        /* class com.tencent.mm.plugin.ext.b.c.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(24371);
            bg.azz().b(106, this);
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
                drt eiq = ((f) qVar).eiq();
                Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", Integer.valueOf(eiq.LUB));
                if (eiq.LUB > 0) {
                    if (eiq.LUC.isEmpty()) {
                        Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
                        c.a(c.this, eiq);
                    }
                    if (eiq.LUC.size() > 1) {
                        try {
                            Intent intent = new Intent();
                            intent.putExtra("add_more_friend_search_scene", 3);
                            intent.putExtra("result", eiq.toByteArray());
                            Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
                            com.tencent.mm.plugin.ext.a.jRt.s(intent, c.this.mContext);
                            AppMethodBeat.o(24371);
                        } catch (IOException e2) {
                            Log.printErrStackTrace("MicroMsg.RedirectToChattingByPhoneHelper", e2, "", new Object[0]);
                            AppMethodBeat.o(24371);
                        }
                    } else {
                        c.a(c.this, eiq.LUC.getFirst());
                        AppMethodBeat.o(24371);
                    }
                } else {
                    Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: only one result is retrieved. start to chatting directly");
                    c.b(c.this, eiq);
                    AppMethodBeat.o(24371);
                }
            } else {
                Log.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: err net.errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                c.a(c.this, (drt) null);
                AppMethodBeat.o(24371);
            }
        }
    };
    private Context mContext = null;
    private boolean sMA = false;
    private String sMz = "";

    static /* synthetic */ void a(c cVar, drr drr) {
        AppMethodBeat.i(24380);
        cVar.a(drr);
        AppMethodBeat.o(24380);
    }

    static /* synthetic */ void b(c cVar, drt drt) {
        AppMethodBeat.i(24381);
        cVar.a(drt);
        AppMethodBeat.o(24381);
    }

    public c(Context context, String str) {
        AppMethodBeat.i(24372);
        this.mContext = context;
        this.sMz = str;
        this.sMA = true;
        AppMethodBeat.o(24372);
    }

    public final int cSp() {
        a aVar;
        AppMethodBeat.i(24373);
        if (this.mContext == null) {
            Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
            AppMethodBeat.o(24373);
            return -1;
        } else if (Util.isNullOrNil(this.sMz)) {
            Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
            AppMethodBeat.o(24373);
            return -1;
        } else {
            String pureNumber = PhoneFormater.pureNumber(this.sMz);
            if (Util.isNullOrNil(pureNumber)) {
                Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
                AppMethodBeat.o(24373);
                return -1;
            }
            String str = this.sMz;
            if (Util.isNullOrNil(str)) {
                Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
                aVar = null;
            } else {
                if (iGj == null) {
                    iGj = new HashMap();
                }
                aVar = iGj.get(str);
            }
            if (aVar != null) {
                Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
                int a2 = a(aVar.userName, aVar.sMC, aVar.sMD);
                AppMethodBeat.o(24373);
                return a2;
            }
            jl jlVar = new jl();
            jlVar.dOk.dOm = pureNumber;
            EventCenter.instance.publish(jlVar);
            String str2 = jlVar.dOl.userName;
            if (!Util.isNullOrNil(str2)) {
                Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", str2);
                int a3 = a(str2, null, null);
                AppMethodBeat.o(24373);
                return a3;
            }
            Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
            bg.azz().a(106, this.callback);
            bg.azz().a(new f(pureNumber, 3), 0);
            Intent intent = new Intent();
            intent.setClassName(this.mContext, "com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI");
            intent.setFlags(268435456);
            Context context = this.mContext;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/ext/model/RedirectToChattingByPhoneHelper", "startDialogUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/ext/model/RedirectToChattingByPhoneHelper", "startDialogUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(24373);
            return 2;
        }
    }

    private static void a(String str, a aVar) {
        AppMethodBeat.i(24374);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when put to cache");
            AppMethodBeat.o(24374);
            return;
        }
        if (iGj == null) {
            iGj = new HashMap();
        }
        iGj.put(str, aVar);
        AppMethodBeat.o(24374);
    }

    private int a(String str, drt drt, drr drr) {
        AppMethodBeat.i(24375);
        if (this.mContext == null) {
            Log.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: error param. start redirect param error: context is null");
            AppMethodBeat.o(24375);
            return -1;
        }
        if (!Util.isNullOrNil(str)) {
            bg.aVF();
            if (com.tencent.mm.model.c.aSN().bjG(str)) {
                Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
                arp(str);
                AppMethodBeat.o(24375);
                return 0;
            }
        }
        if (drt != null) {
            Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
            a(drt);
            AppMethodBeat.o(24375);
            return 1;
        } else if (drr != null) {
            Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
            a(drr);
            AppMethodBeat.o(24375);
            return 1;
        } else {
            Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
            AppMethodBeat.o(24375);
            return -1;
        }
    }

    private void arp(String str) {
        AppMethodBeat.i(24376);
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", false);
        com.tencent.mm.br.c.f(this.mContext, ".ui.chatting.ChattingUI", intent);
        AppMethodBeat.o(24376);
    }

    private void a(drt drt) {
        AppMethodBeat.i(24377);
        if (drt == null) {
            Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
            AppMethodBeat.o(24377);
            return;
        }
        String a2 = z.a(drt.Lqk);
        if (!Util.isNullOrNil(a2)) {
            a(this.sMz, new a(z.a(drt.Lqk), drt, null));
            bg.aVF();
            if (com.tencent.mm.model.c.aSN().bjG(a2)) {
                Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
                arp(a2);
                AppMethodBeat.o(24377);
                return;
            }
            Intent intent = new Intent();
            d.a(intent, drt, 15);
            intent.putExtra("add_more_friend_search_scene", 2);
            com.tencent.mm.plugin.ext.a.jRt.c(intent, this.mContext);
            AppMethodBeat.o(24377);
            return;
        }
        Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
        AppMethodBeat.o(24377);
    }

    private void a(drr drr) {
        AppMethodBeat.i(24378);
        if (drr == null) {
            Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
            AppMethodBeat.o(24378);
            return;
        }
        String a2 = z.a(drr.Lqk);
        if (!Util.isNullOrNil(a2)) {
            a(this.sMz, new a(z.a(drr.Lqk), null, drr));
            bg.aVF();
            if (com.tencent.mm.model.c.aSN().bjG(a2)) {
                Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
                arp(a2);
                AppMethodBeat.o(24378);
                return;
            }
            Intent intent = new Intent();
            d.a(intent, drr);
            intent.putExtra("add_more_friend_search_scene", 2);
            com.tencent.mm.plugin.ext.a.jRt.c(intent, this.mContext);
            AppMethodBeat.o(24378);
            return;
        }
        Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
        AppMethodBeat.o(24378);
    }

    /* access modifiers changed from: package-private */
    public class a {
        drt sMC = null;
        drr sMD = null;
        String userName = "";

        public a(String str, drt drt, drr drr) {
            this.userName = str;
            this.sMC = drt;
            this.sMD = drr;
        }
    }

    static /* synthetic */ void a(c cVar, drt drt) {
        AppMethodBeat.i(24379);
        Intent intent = new Intent();
        intent.putExtra("add_more_friend_search_scene", 3);
        if (drt != null) {
            try {
                intent.putExtra("result", drt.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: IOException: %s", e2.toString());
            }
        }
        Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
        com.tencent.mm.plugin.ext.a.jRt.s(intent, cVar.mContext);
        AppMethodBeat.o(24379);
    }
}
