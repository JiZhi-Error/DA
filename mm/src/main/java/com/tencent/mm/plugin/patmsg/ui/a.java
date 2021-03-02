package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.hk;
import com.tencent.mm.g.b.a.hu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.audio.h;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.d;
import com.tencent.mm.plugin.patmsg.b.c;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;

public final class a {
    private static final int ARy = ((b) g.af(b.class)).a(b.a.clicfg_pat_double_click_avatar_delay_interval, ViewConfiguration.getDoubleTapTimeout());
    private c AQX;
    d ARA;
    View.OnClickListener ARB = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.patmsg.ui.a.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(206990);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/patmsg/ui/PatHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a.this.hAk.sendMessageAtFrontOfQueue(a.this.hAk.obtainMessage(com.tencent.mm.plugin.appbrand.jsapi.audio.g.CTRL_INDEX, view));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(206990);
        }
    };
    com.tencent.mm.plugin.patmsg.a.c ARz;
    private MMHandler hAk = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.patmsg.ui.a.AnonymousClass2 */
        private long lastClickTime = 0;

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            boolean z = false;
            AppMethodBeat.i(206991);
            Log.i("MicroMsg.PatHandler", "click msg %d", Integer.valueOf(message.what));
            switch (message.what) {
                case com.tencent.mm.plugin.appbrand.jsapi.audio.g.CTRL_INDEX:
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.lastClickTime <= 0 || currentTimeMillis - this.lastClickTime >= ((long) a.ARy)) {
                        sendMessageDelayed(a.this.hAk.obtainMessage(291, message.obj), (long) a.ARy);
                    } else {
                        Log.i("MicroMsg.PatHandler", "double click");
                        removeMessages(291);
                        sendMessage(a.this.hAk.obtainMessage(l.CTRL_INDEX, message.obj));
                    }
                    this.lastClickTime = currentTimeMillis;
                    AppMethodBeat.o(206991);
                    return;
                case 291:
                    if (!(a.this.ARz == null || a.this.ARz.getOnClickListener() == null)) {
                        Log.i("MicroMsg.PatHandler", "single click");
                        a.this.ARz.getOnClickListener().onClick((View) message.obj);
                    }
                    this.lastClickTime = 0;
                    AppMethodBeat.o(206991);
                    return;
                case l.CTRL_INDEX:
                    if (!(a.this.ARz == null || a.this.ARz.getDoubleClickListener() == null)) {
                        z = a.this.ARz.getDoubleClickListener().eF((View) message.obj);
                    }
                    if (!z && a.this.ARz != null) {
                        a.c(a.this);
                    }
                    this.lastClickTime = 0;
                    AppMethodBeat.o(206991);
                    return;
                case h.CTRL_INDEX:
                    a.this.ARA.eBp();
                    break;
            }
            AppMethodBeat.o(206991);
        }
    };

    public a() {
        AppMethodBeat.i(206997);
        AppMethodBeat.o(206997);
    }

    static {
        AppMethodBeat.i(207003);
        AppMethodBeat.o(207003);
    }

    public final void eBq() {
        AppMethodBeat.i(206998);
        Log.d("MicroMsg.PatHandler", "onDetachPatMsgView");
        this.hAk.removeMessages(l.CTRL_INDEX);
        this.AQX = null;
        AppMethodBeat.o(206998);
    }

    public final void eBr() {
        AppMethodBeat.i(206999);
        Log.d("MicroMsg.PatHandler", "onDetachPatTipView");
        this.hAk.removeMessages(h.CTRL_INDEX);
        AppMethodBeat.o(206999);
    }

    private boolean Un(int i2) {
        String string;
        AppMethodBeat.i(207000);
        if (((PluginPatMsg) g.ah(PluginPatMsg.class)).isRevokePatMsgEnable() && g.aAh().azQ().getBoolean(ar.a.USERINFO_PAT_AVATAR_REVOKE_TIP_BOOLEAN_SYNC, true)) {
            if (i2 != 5 || !g.aAh().azQ().getBoolean(ar.a.USERINFO_PAT_PROFILE_AVATAR_BOOLEAN_SYNC, true)) {
                string = MMApplicationContext.getResources().getString(R.string.g5t);
            } else {
                string = MMApplicationContext.getResources().getString(R.string.g5n);
            }
            jm(string, MMApplicationContext.getResources().getString(R.string.g5u, 2));
            g.aAh().azQ().set(ar.a.USERINFO_PAT_AVATAR_REVOKE_TIP_BOOLEAN_SYNC, Boolean.FALSE);
            if (i2 == 5) {
                g.aAh().azQ().set(ar.a.USERINFO_PAT_PROFILE_AVATAR_BOOLEAN_SYNC, Boolean.FALSE);
            }
            AppMethodBeat.o(207000);
            return true;
        } else if (i2 != 5 || !g.aAh().azQ().getBoolean(ar.a.USERINFO_PAT_PROFILE_AVATAR_BOOLEAN_SYNC, true)) {
            AppMethodBeat.o(207000);
            return false;
        } else {
            jm(MMApplicationContext.getResources().getString(R.string.fpt), MMApplicationContext.getResources().getString(R.string.fps));
            g.aAh().azQ().set(ar.a.USERINFO_PAT_PROFILE_AVATAR_BOOLEAN_SYNC, Boolean.FALSE);
            AppMethodBeat.o(207000);
            return true;
        }
    }

    private void jm(String str, String str2) {
        AppMethodBeat.i(207001);
        final k kVar = new k(((View) this.ARz).getContext());
        kVar.bmc(str).bmd(str2).g(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.patmsg.ui.a.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(206992);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/patmsg/ui/PatHandler$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kVar.bMo();
                c unused = a.this.AQX;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatHandler$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(206992);
            }
        });
        kVar.dGm();
        AppMethodBeat.o(207001);
    }

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(207002);
        String tagUsername = aVar.ARz.getTagUsername();
        String tagTalker = aVar.ARz.getTagTalker();
        int tagScene = aVar.ARz.getTagScene();
        Log.i("MicroMsg.PatHandler", "scene %d, sendPatMsg to %s, pattedUser %s", Integer.valueOf(tagScene), tagTalker, tagUsername);
        if (Util.isNullOrNil(tagUsername, tagTalker)) {
            Log.w("MicroMsg.PatHandler", "tagUsername or talker is null!");
            AppMethodBeat.o(207002);
        } else if (!((com.tencent.mm.plugin.patmsg.a.b) g.af(com.tencent.mm.plugin.patmsg.a.b.class)).J(tagScene, tagTalker, tagUsername)) {
            Log.w("MicroMsg.PatHandler", "cannot pat, scene %d, talker %s, user %s", Integer.valueOf(tagScene), tagTalker, tagUsername);
            AppMethodBeat.o(207002);
        } else if (aVar.AQX == null || aVar.AQX.ARo == null || !((com.tencent.mm.plugin.patmsg.a.b) g.af(com.tencent.mm.plugin.patmsg.a.b.class)).e(aVar.AQX.ARo)) {
            aVar.AQX = new c();
            aVar.AQX.scene = tagScene;
            aVar.AQX.talker = tagTalker;
            aVar.AQX.ARq = tagUsername;
            aVar.Un(tagScene);
            ((PluginPatMsg) g.ah(PluginPatMsg.class)).playPatAnimation((View) aVar.ARz);
            ((View) aVar.ARz).performHapticFeedback(0, 2);
            Pair<Long, Long> K = ((com.tencent.mm.plugin.patmsg.a.b) g.af(com.tencent.mm.plugin.patmsg.a.b.class)).K(tagScene, tagTalker, tagUsername);
            if (K != null) {
                aVar.AQX.ARo = K;
                if (aVar.ARA != null) {
                    aVar.ARA.aJN(((com.tencent.mm.plugin.patmsg.a.b) g.af(com.tencent.mm.plugin.patmsg.a.b.class)).aJK(tagUsername));
                    aVar.hAk.sendEmptyMessageDelayed(h.CTRL_INDEX, 3000);
                }
            }
            AppMethodBeat.o(207002);
        } else {
            ((PluginPatMsg) g.ah(PluginPatMsg.class)).playRevokePatAnimation((View) aVar.ARz, z.aTY().equals(tagUsername));
            ((View) aVar.ARz).performHapticFeedback(3, 2);
            final Context context = ((View) aVar.ARz).getContext();
            final Pair<Long, Long> pair = aVar.AQX.ARo;
            e eVar = new e(context, 1, true);
            eVar.j(MMApplicationContext.getResources().getString(R.string.g5o), 1, com.tencent.mm.cb.a.fromDPToPix(context, 14));
            eVar.HLX = new o.f() {
                /* class com.tencent.mm.plugin.patmsg.ui.a.AnonymousClass4 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(206993);
                    mVar.a(547, context.getResources().getColor(R.color.a5e), context.getString(R.string.yj));
                    AppMethodBeat.o(206993);
                }
            };
            eVar.QNH = new o.f() {
                /* class com.tencent.mm.plugin.patmsg.ui.a.AnonymousClass5 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(206994);
                    mVar.kV(548, R.string.sz);
                    AppMethodBeat.o(206994);
                }
            };
            eVar.HLY = new o.g() {
                /* class com.tencent.mm.plugin.patmsg.ui.a.AnonymousClass6 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(206995);
                    if (menuItem.getItemId() == 547) {
                        ((com.tencent.mm.plugin.patmsg.a.b) g.af(com.tencent.mm.plugin.patmsg.a.b.class)).a(pair, 2);
                    }
                    AppMethodBeat.o(206995);
                }
            };
            eVar.QNK = new o.g() {
                /* class com.tencent.mm.plugin.patmsg.ui.a.AnonymousClass7 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    czg boC;
                    czh a2;
                    int i3;
                    AppMethodBeat.i(206996);
                    if (menuItem.getItemId() == 548 && (a2 = ((com.tencent.mm.plugin.patmsg.a.b) g.af(com.tencent.mm.plugin.patmsg.a.b.class)).a((boC = com.tencent.mm.util.e.boC(((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(((Long) pair.first).longValue()).field_content)), ((Long) pair.second).longValue())) != null) {
                        if (a2.oNJ == 0) {
                            hu huVar = new hu();
                            if (ab.Ix(boC.gnh)) {
                                huVar.vz(boC.gnh);
                            }
                            huVar.eMu = ((Long) pair.second).longValue() - ((com.tencent.mm.plugin.patmsg.a.b) g.af(com.tencent.mm.plugin.patmsg.a.b.class)).b(boC.gnh, pair);
                            if (((Long) pair.second).longValue() <= ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEP(boC.gnh)) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            huVar.eMw = i3;
                            huVar.eMx = ((com.tencent.mm.plugin.patmsg.a.b) g.af(com.tencent.mm.plugin.patmsg.a.b.class)).b(boC, ((Long) pair.second).longValue()) + 1;
                            huVar.vx(z.aTY());
                            huVar.vy(boC.gnh);
                            huVar.eLQ = a2.createTime;
                            huVar.vA(com.tencent.mm.plugin.patmsg.c.aJL(a2.MEA));
                            huVar.eLX = 2;
                            huVar.eLV = 2;
                            huVar.bfK();
                            com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
                            com.tencent.mm.util.b.a(huVar);
                            AppMethodBeat.o(206996);
                            return;
                        }
                        hk hkVar = new hk();
                        hkVar.eLQ = a2.createTime;
                        hkVar.eLR = System.currentTimeMillis();
                        hkVar.ve(a2.dRL);
                        hkVar.vf(a2.MEA);
                        hkVar.vg(com.tencent.mm.plugin.patmsg.c.aJL(a2.MEA));
                        if (ab.Ix(boC.gnh)) {
                            hkVar.vh(boC.gnh);
                        }
                        hkVar.eLV = 2;
                        hkVar.eLX = 2;
                        hkVar.bfK();
                        com.tencent.mm.util.b bVar2 = com.tencent.mm.util.b.QYu;
                        com.tencent.mm.util.b.a(hkVar);
                    }
                    AppMethodBeat.o(206996);
                }
            };
            eVar.dGm();
            AppMethodBeat.o(207002);
        }
    }
}
