package com.tencent.mm.plugin.account.friend.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.re;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.cut;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.sortview.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class av extends IListener<re> implements i {
    public Activity activity;
    private q gut;
    public RecoverFriendSortView kga;
    public String kgb;
    private ArrayList<d> kgc = new ArrayList<>();
    private int kgd = 65;
    private boolean kge;
    private AtomicInteger kgf = new AtomicInteger();
    public String sessionId;

    static /* synthetic */ void a(av avVar) {
        AppMethodBeat.i(206401);
        avVar.boE();
        AppMethodBeat.o(206401);
    }

    static /* synthetic */ void f(av avVar) {
        AppMethodBeat.i(206402);
        avVar.boD();
        AppMethodBeat.o(206402);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(re reVar) {
        AppMethodBeat.i(184445);
        re reVar2 = reVar;
        Log.i("MicroMsg.RecoverFriendPresenter", "received RecoverAccountFriendEvent type %d, username %s", Integer.valueOf(reVar2.dXU.type), reVar2.dXU.username);
        switch (reVar2.dXU.type) {
            case 1:
                if (!Util.isNullOrNil(reVar2.dXU.username)) {
                    Iterator<d> it = this.kgc.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else {
                            d next = it.next();
                            if (reVar2.dXU.username.equals(((au.a) next.data).kfY.field_encryptUsername)) {
                                ((au.a) next.data).kfY = au.ca(this.kgb, reVar2.dXU.username);
                                this.kga.refresh();
                                break;
                            }
                        }
                    }
                }
                break;
        }
        AppMethodBeat.o(184445);
        return true;
    }

    public av(Activity activity2) {
        AppMethodBeat.i(184440);
        this.activity = activity2;
        this.__eventId = re.class.getName().hashCode();
        AppMethodBeat.o(184440);
    }

    public final void vk(int i2) {
        AppMethodBeat.i(184441);
        Log.i("MicroMsg.RecoverFriendPresenter", "do next scene, oldWx %s,seq %d", this.kgb, Integer.valueOf(i2));
        g.azz().a(new ae(this.kgb, i2, this.sessionId), 0);
        if (this.gut == null) {
            this.gut = h.a((Context) this.activity, this.activity.getString(R.string.wd), false, (DialogInterface.OnCancelListener) null);
        }
        AppMethodBeat.o(184441);
    }

    private void boD() {
        AppMethodBeat.i(184442);
        int Th = au.Th(this.kgb);
        Log.i("MicroMsg.RecoverFriendPresenter", "totalCount %d", Integer.valueOf(Th));
        if (this.kgd != 65 || Th >= 20) {
            do {
                boE();
                if (this.kgc.size() >= 20) {
                    break;
                }
            } while (this.kgd <= 91);
            AppMethodBeat.o(184442);
            return;
        }
        List<au.a> aH = au.aH(this.kgb, -1);
        if (!aH.isEmpty()) {
            for (au.a aVar : aH) {
                d dVar = new d();
                dVar.data = aVar;
                int i2 = aVar.kfY.field_showHead;
                if (i2 < 65 || i2 > 90) {
                    dVar.Pae = "#";
                } else {
                    dVar.Pae = new StringBuilder().append((char) i2).toString();
                }
                this.kgc.add(dVar);
            }
            this.kga.hy(this.kgc);
        }
        this.kgd = 92;
        AppMethodBeat.o(184442);
    }

    private void boE() {
        AppMethodBeat.i(184443);
        while (this.kgd <= 91) {
            List<au.a> aH = au.aH(this.kgb, this.kgd);
            this.kgd++;
            if (!aH.isEmpty()) {
                for (au.a aVar : aH) {
                    d dVar = new d();
                    dVar.data = aVar;
                    int i2 = aVar.kfY.field_showHead;
                    if (i2 < 65 || i2 > 90) {
                        dVar.Pae = "#";
                    } else {
                        dVar.Pae = new StringBuilder().append((char) i2).toString();
                    }
                    this.kgc.add(dVar);
                }
                this.kga.hy(this.kgc);
                AppMethodBeat.o(184443);
                return;
            }
        }
        AppMethodBeat.o(184443);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(184444);
        Log.i("MicroMsg.RecoverFriendPresenter", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.kge = ((brf) ((ae) qVar).hJu.iLL.iLR).LYI;
            final List<cut> boo = ((ae) qVar).boo();
            final String str2 = ((bre) ((ae) qVar).hJu.iLK.iLR).UserName;
            Log.i("MicroMsg.RecoverFriendPresenter", "hasContinue %s, oldAccount friend %d", Boolean.valueOf(this.kge), Integer.valueOf(boo.size()));
            if (!this.kgb.equals(str2)) {
                Log.w("MicroMsg.RecoverFriendPresenter", "(%s,%s), not my old username, ignore", this.kgb, str2);
                AppMethodBeat.o(184444);
                return;
            }
            this.kgf.getAndIncrement();
            com.tencent.f.h.RTc.b(new com.tencent.f.i.i() {
                /* class com.tencent.mm.plugin.account.friend.a.av.AnonymousClass3 */

                @Override // com.tencent.f.i.i
                public final void boF() {
                    boolean z;
                    r rVar;
                    char c2;
                    AppMethodBeat.i(184437);
                    String str = str2;
                    List<cut> list = boo;
                    int i2 = 0;
                    for (cut cut : list) {
                        if (!Util.isNullOrNil(cut.dRe)) {
                            r ca = au.ca(str, cut.dRe);
                            if (ca == null) {
                                rVar = new r();
                            } else {
                                rVar = ca;
                            }
                            rVar.field_encryptUsername = cut.dRe;
                            rVar.field_nickname = cut.oUJ;
                            rVar.field_pinyinName = Util.nullAsNil(f.Sh(cut.oUJ)).toUpperCase();
                            String str2 = rVar.field_pinyinName;
                            if (Util.isNullOrNil(str2) || (c2 = str2.charAt(0)) < 'A' || c2 > 'Z') {
                                c2 = '[';
                            }
                            rVar.field_showHead = c2;
                            rVar.field_ticket = cut.Bri;
                            rVar.field_username = cut.UserName;
                            rVar.field_oldUsername = str;
                            rVar.field_seq = cut.KXP;
                            if (rVar.systemRowid == -1) {
                                boolean insert = ((ap) ((a) g.ah(a.class)).getOldAccountFriendStorage()).insert(rVar);
                                Log.i("MicroMsg.RecoverFriendLogic", "insert local old friend (%s,%s), success %s", cut.dRe, cut.oUJ, Boolean.valueOf(insert));
                                z = insert;
                            } else {
                                boolean replace = ((ap) ((a) g.ah(a.class)).getOldAccountFriendStorage()).replace(rVar);
                                Log.i("MicroMsg.RecoverFriendLogic", "replace local old friend (%s,%s), success %s", cut.dRe, cut.oUJ, Boolean.valueOf(replace));
                                z = replace;
                            }
                        } else {
                            z = false;
                        }
                        if (z) {
                            i2++;
                        } else {
                            i2 = i2;
                        }
                    }
                    Log.i("MicroMsg.RecoverFriendLogic", "insert local old %d, success %d", Integer.valueOf(list.size()), Integer.valueOf(i2));
                    Log.i("MicroMsg.RecoverFriendPresenter", "insert old account friend %d, success %d", Integer.valueOf(boo.size()), Integer.valueOf(i2));
                    AppMethodBeat.o(184437);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.f.i.f
                public final /* synthetic */ void cp(Runnable runnable) {
                    AppMethodBeat.i(184438);
                    Log.i("MicroMsg.RecoverFriendPresenter", "after running insert task");
                    if (av.this.kgf.decrementAndGet() == 0 && !av.this.kge) {
                        Log.i("MicroMsg.RecoverFriendPresenter", "all insert tasks are finished!");
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.account.friend.a.av.AnonymousClass3.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(184436);
                                av.f(av.this);
                                if (av.this.gut != null) {
                                    av.this.gut.dismiss();
                                }
                                AppMethodBeat.o(184436);
                            }
                        });
                    }
                    AppMethodBeat.o(184438);
                }

                @Override // com.tencent.f.i.f
                public final /* synthetic */ void boG() {
                    AppMethodBeat.i(184439);
                    Log.i("MicroMsg.RecoverFriendPresenter", "before running insert task");
                    AppMethodBeat.o(184439);
                }
            }, "Insert_Old_Account_Friend");
            if (this.kge) {
                vk(((ae) qVar).kfo);
                AppMethodBeat.o(184444);
                return;
            }
            if (this.kgf.get() == 0) {
                Log.i("MicroMsg.RecoverFriendPresenter", "all insert tasks are finished!");
                if (this.gut != null) {
                    this.gut.dismiss();
                }
                boD();
            }
            AppMethodBeat.o(184444);
            return;
        }
        boD();
        if (this.gut != null) {
            this.gut.dismiss();
        }
        if (Util.isNullOrNil(str)) {
            str = this.activity.getString(R.string.u5);
        }
        h.cD(this.activity, str);
        AppMethodBeat.o(184444);
    }
}
