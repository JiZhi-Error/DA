package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.ui.DelChatroomMemberUI;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.xz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.roomsdk.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@a(gRF = f.class)
public class e extends a implements i, MStorageEx.IOnStorageChange, f {
    private static int Pnl = -1;
    private boolean OFo = false;
    protected boolean Pnd = false;
    protected Map<String, String> Pne = new HashMap();
    private ProgressDialog Pnf = null;
    private IListener Png = new IListener<bc>() {
        /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass1 */

        {
            AppMethodBeat.i(161525);
            this.__eventId = bc.class.getName().hashCode();
            AppMethodBeat.o(161525);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bc bcVar) {
            AppMethodBeat.i(35134);
            bc bcVar2 = bcVar;
            if ((bcVar2 instanceof bc) && e.this.dom.getTalkerUserName() != null && !Util.isNullOrNil(bcVar2.dEl.username) && bcVar2.dEl.username.equals(e.this.dom.getTalkerUserName())) {
                e.a(e.this);
            }
            AppMethodBeat.o(35134);
            return false;
        }
    };
    private final MStorage.IOnStorageChange Pnh = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass12 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(35141);
            Log.v("MicroMsg.ChattingUI.ChatroomComponent", "roommember watcher notify ".concat(String.valueOf(str)));
            if (((d) e.this.dom.bh(d.class)).gOQ()) {
                e.this.OFo = com.tencent.mm.al.a.e.c(((d) e.this.dom.bh(d.class)).gON());
            } else {
                e.this.OFo = v.HW(e.this.dom.getTalkerUserName());
            }
            if (e.this.Pnd) {
                v.g(e.this.dom.getTalkerUserName(), e.this.Pne);
            } else {
                e.this.Pne.clear();
            }
            if (!Util.isNullOrNil(str)) {
                e.this.dom.cmy();
            }
            AppMethodBeat.o(35141);
        }
    };
    private IListener Pni = new IListener<xz>() {
        /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass19 */

        {
            AppMethodBeat.i(161526);
            this.__eventId = xz.class.getName().hashCode();
            AppMethodBeat.o(161526);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xz xzVar) {
            AppMethodBeat.i(35142);
            xz xzVar2 = xzVar;
            if ((!(xzVar2 instanceof xz) || e.this.dom.getTalkerUserName().equals(xzVar2.eeo.userName)) && ab.Eq(e.this.dom.getTalkerUserName())) {
                h.c(e.this.dom.Pwc.getContext(), e.this.dom.Pwc.getMMResources().getString(R.string.hr_), null, true);
            }
            AppMethodBeat.o(35142);
            return false;
        }
    };
    private Integer Pnj = 0;
    com.tencent.mm.roomsdk.a.c.e Pnk;
    private boolean Pnm = false;
    private com.tencent.mm.roomsdk.a.c.a gvh = null;
    private ProgressDialog gvi = null;

    public e() {
        AppMethodBeat.i(35148);
        AppMethodBeat.o(35148);
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(35165);
        eVar.gPl();
        AppMethodBeat.o(35165);
    }

    static /* synthetic */ void a(e eVar, ca caVar, int i2, LinkedList linkedList, int i3, int i4, int i5, String str) {
        AppMethodBeat.i(233030);
        eVar.a(caVar, i2, linkedList, i3, i4, i5, str);
        AppMethodBeat.o(233030);
    }

    static /* synthetic */ void a(e eVar, ca caVar, LinkedList linkedList, LinkedList linkedList2, int i2, int i3) {
        AppMethodBeat.i(233028);
        eVar.a(caVar, (LinkedList<String>) linkedList, (LinkedList<String>) linkedList2, i2, i3, true);
        AppMethodBeat.o(233028);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.f
    public final CharSequence bmF(String str) {
        AppMethodBeat.i(35149);
        d dVar = (d) this.dom.bh(d.class);
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        String Is = aa.Is(str);
        if (dVar.gOP() || Util.isNullOrNil(Is)) {
            if (this.Pne.containsKey(str)) {
                String str2 = this.Pne.get(str);
                if (!Util.isNullOrNil(str2)) {
                    if (as.bjp(str)) {
                        CharSequence a2 = com.tencent.mm.openim.room.a.a.a(Kn, str2);
                        AppMethodBeat.o(35149);
                        return a2;
                    }
                    AppMethodBeat.o(35149);
                    return str2;
                }
            }
            if (dVar.gOP()) {
                String displayName = dVar.gON().getDisplayName(str);
                AppMethodBeat.o(35149);
                return displayName;
            }
            CharSequence a3 = com.tencent.mm.openim.room.a.a.a(Kn, aa.getDisplayName(str));
            AppMethodBeat.o(35149);
            return a3;
        }
        CharSequence a4 = com.tencent.mm.openim.room.a.a.a(Kn, Is);
        AppMethodBeat.o(35149);
        return a4;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.f
    public final boolean gPh() {
        return this.Pnd;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.f
    public final boolean gPi() {
        AppMethodBeat.i(35150);
        if (this.OFo || ((d) this.dom.bh(d.class)).gOV()) {
            AppMethodBeat.o(35150);
            return true;
        }
        AppMethodBeat.o(35150);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.f
    public final boolean gPj() {
        ah Kd;
        AppMethodBeat.i(179851);
        if (!ab.Ix(this.dom.getTalkerUserName()) || !v.aTU() || (Kd = ((c) g.af(c.class)).aSX().Kd(this.dom.getTalkerUserName())) == null || (((long) Kd.field_chatroomStatus) & 131072) == 131072 || (((long) Kd.field_chatroomStatus) & 65536) != 65536) {
            AppMethodBeat.o(179851);
            return false;
        }
        AppMethodBeat.o(179851);
        return true;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.f
    public final boolean gPk() {
        ah Kd;
        AppMethodBeat.i(179852);
        if (!ab.Ix(this.dom.getTalkerUserName()) || (Kd = ((c) g.af(c.class)).aSX().Kd(this.dom.getTalkerUserName())) == null || (((long) Kd.field_chatroomStatus) & 131072) != 131072) {
            AppMethodBeat.o(179852);
            return false;
        }
        AppMethodBeat.o(179852);
        return true;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.f
    public final boolean amD() {
        AppMethodBeat.i(179853);
        ah Kd = ((c) g.af(c.class)).aSX().Kd(this.dom.getTalkerUserName());
        if (Kd == null || !Kd.amD()) {
            AppMethodBeat.o(179853);
            return false;
        }
        AppMethodBeat.o(179853);
        return true;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.f
    public final void b(long j2, final LinkedList<String> linkedList, final int i2) {
        AppMethodBeat.i(233022);
        bg.aVF();
        ah Kd = com.tencent.mm.model.c.aSX().Kd(this.dom.getTalkerUserName());
        if (Kd == null) {
            h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.g74), (String) null, this.dom.Pwc.getMMResources().getString(R.string.g6y), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass20 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(233022);
            return;
        }
        this.dom.getTalkerUserName();
        final LinkedList<String> linkedList2 = new LinkedList<>();
        List<String> bax = Kd.bax();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (bax != null && bax.contains(next)) {
                linkedList2.add(next);
            }
        }
        if (linkedList2.size() == 0) {
            if (linkedList.size() == 1) {
                h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.g6x), (String) null, this.dom.Pwc.getMMResources().getString(R.string.g6y), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass21 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            } else {
                h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.g6s), (String) null, this.dom.Pwc.getMMResources().getString(R.string.g6y), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass22 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            }
            if (i2 == 1) {
                a(((l) g.af(l.class)).eiy().Hb(j2), 5, linkedList, 0, 0, 1, "");
            }
            AppMethodBeat.o(233022);
            return;
        }
        final ca caVar = null;
        if (i2 == 1) {
            this.Pnj = 1;
        }
        if (j2 != -1) {
            caVar = ((l) g.af(l.class)).eiy().Hb(j2);
            if (!Util.isNullOrNil(caVar.field_historyId) && !caVar.gDS()) {
                if (cl.aWy() - caVar.field_createTime <= 120000) {
                    com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.dom.Pwc.getContext(), 1, false);
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass23 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(233017);
                            mVar.d(0, e.this.dom.Pwc.getContext().getString(R.string.g5l));
                            mVar.d(1, e.this.dom.Pwc.getContext().getString(R.string.g5m));
                            AppMethodBeat.o(233017);
                        }
                    };
                    eVar.HLY = new o.g() {
                        /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass24 */
                        final /* synthetic */ int gsA = 1;

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(233020);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    e.this.Pnj = 3;
                                    e.a(e.this, caVar, linkedList, linkedList2, this.gsA, i2);
                                    AppMethodBeat.o(233020);
                                    return;
                                case 1:
                                    e.a(e.this, DelChatroomMemberUI.a(e.this.dom.getTalkerUserName(), caVar, 1, null, new com.tencent.mm.roomsdk.a.b.e() {
                                        /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass24.AnonymousClass1 */

                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.roomsdk.a.b.a] */
                                        @Override // com.tencent.mm.roomsdk.a.b.a
                                        public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.e eVar) {
                                            String str2;
                                            AppMethodBeat.i(233019);
                                            com.tencent.mm.roomsdk.a.b.e eVar2 = eVar;
                                            Object[] objArr = new Object[4];
                                            objArr[0] = Integer.valueOf(i2);
                                            objArr[1] = Integer.valueOf(i3);
                                            objArr[2] = Util.nullAs(str, "");
                                            objArr[3] = eVar2 != null ? Integer.valueOf(eVar2.ret) : BuildConfig.COMMAND;
                                            Log.i("MicroMsg.ChattingUI.ChatroomComponent", "revokeRecord errType:%s errCode:%s errMsg:%s ret:%s", objArr);
                                            e.b(e.this);
                                            String listToString = Util.listToString(linkedList2, ";");
                                            if (this.ret != 0) {
                                                String str3 = "";
                                                if (Util.isNullOrNil(str)) {
                                                    str2 = e.this.dom.Pwc.getContext().getString(R.string.gip);
                                                } else {
                                                    str2 = str;
                                                }
                                                if (eVar2 != null) {
                                                    str3 = Util.nullAs(eVar2.title, "");
                                                    str2 = Util.nullAs(eVar2.content, e.this.dom.Pwc.getContext().getString(R.string.gip));
                                                }
                                                h.a(e.this.dom.Pwc.getContext(), str2, str3, e.this.dom.Pwc.getContext().getString(R.string.j34), new DialogInterface.OnClickListener() {
                                                    /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass24.AnonymousClass1.AnonymousClass1 */

                                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                                        AppMethodBeat.i(233018);
                                                        Log.i("MicroMsg.ChattingUI.ChatroomComponent", "click i know");
                                                        AppMethodBeat.o(233018);
                                                    }
                                                });
                                                e.a(e.this, caVar, 4, linkedList, linkedList2.size(), linkedList2.size(), 3, listToString);
                                                AppMethodBeat.o(233019);
                                                return;
                                            }
                                            e.a(e.this, caVar, 4, linkedList, linkedList2.size(), linkedList2.size(), 2, listToString);
                                            AppMethodBeat.o(233019);
                                        }
                                    }));
                                    break;
                            }
                            AppMethodBeat.o(233020);
                        }
                    };
                    eVar.PGl = new e.b() {
                        /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass25 */

                        @Override // com.tencent.mm.ui.widget.a.e.b
                        public final void onDismiss() {
                            AppMethodBeat.i(233021);
                            e.a(e.this, caVar, 2, linkedList, linkedList2.size(), 0, 1, "");
                            AppMethodBeat.o(233021);
                        }
                    };
                    eVar.dGm();
                    AppMethodBeat.o(233022);
                    return;
                }
                Log.d("MicroMsg.ChattingUI.ChatroomComponent", "dealDelChatroomMember 2 minute excede");
                this.Pnj = 6;
            }
        }
        a(caVar, linkedList, linkedList2, 1, i2, false);
        AppMethodBeat.o(233022);
    }

    private void a(final ca caVar, final LinkedList<String> linkedList, final LinkedList<String> linkedList2, final int i2, final int i3, final boolean z) {
        String string;
        String string2;
        AppMethodBeat.i(233023);
        if (linkedList.size() == 1) {
            if (z) {
                string = this.dom.Pwc.getMMResources().getString(R.string.g6r, bmG(linkedList.get(0)));
            } else {
                string = this.dom.Pwc.getMMResources().getString(R.string.g6q, bmG(linkedList.get(0)));
            }
            if (z) {
                string2 = this.dom.Pwc.getMMResources().getString(R.string.g70);
            } else {
                string2 = this.dom.Pwc.getMMResources().getString(R.string.g6z);
            }
            h.a((Context) this.dom.Pwc.getContext(), string, (String) null, string2, this.dom.Pwc.getMMResources().getString(R.string.sz), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(233001);
                    if (z) {
                        e.this.gvh = null;
                        e.b(e.this, DelChatroomMemberUI.a(e.this.dom.getTalkerUserName(), caVar, 2, (String) linkedList.get(0), new com.tencent.mm.roomsdk.a.b.e() {
                            /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass3.AnonymousClass1 */

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.roomsdk.a.b.a] */
                            @Override // com.tencent.mm.roomsdk.a.b.a
                            public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.e eVar) {
                                AppMethodBeat.i(233000);
                                com.tencent.mm.roomsdk.a.b.e eVar2 = eVar;
                                Object[] objArr = new Object[4];
                                objArr[0] = Integer.valueOf(i2);
                                objArr[1] = Integer.valueOf(i3);
                                objArr[2] = Util.nullAs(str, "");
                                objArr[3] = eVar2 != null ? Integer.valueOf(eVar2.ret) : BuildConfig.COMMAND;
                                Log.i("MicroMsg.ChattingUI.ChatroomComponent", "dealDelChatroomMemberImp errType:%s errCode:%s errMsg:%s ret:%s", objArr);
                                if (this.ret != 0) {
                                    e.c(e.this);
                                    h.a(e.this.dom.Pwc.getContext(), e.this.dom.Pwc.getContext().getString(R.string.gim), "", e.this.dom.Pwc.getContext().getString(R.string.x_), new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(232999);
                                            Log.i("MicroMsg.ChattingUI.ChatroomComponent", "dealDelChatroomMemberImp click i know");
                                            AppMethodBeat.o(232999);
                                        }
                                    });
                                    if (i3 == 1) {
                                        e.a(e.this, caVar, e.this.Pnj.intValue(), linkedList, linkedList2.size(), 1, 3, (String) linkedList.get(0));
                                        AppMethodBeat.o(233000);
                                        return;
                                    }
                                } else {
                                    e.this.gvh = e.a(e.this, caVar, linkedList, linkedList2, i2, i3, true);
                                }
                                AppMethodBeat.o(233000);
                            }
                        }));
                        AppMethodBeat.o(233001);
                        return;
                    }
                    e.a(e.this, caVar, linkedList, linkedList2, i2, i3, false);
                    AppMethodBeat.o(233001);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(233002);
                    if (i3 == 1) {
                        e.a(e.this, caVar, e.this.Pnj.intValue(), linkedList, 1, 1, 1, (String) linkedList.get(0));
                    }
                    AppMethodBeat.o(233002);
                }
            });
            AppMethodBeat.o(233023);
            return;
        }
        Intent intent = new Intent(this.dom.Pwc.getContext(), DelChatroomMemberUI.class);
        intent.putExtra("members", Util.listToString(linkedList2, ","));
        intent.putExtra("origin_members", Util.listToString(linkedList, ","));
        intent.putExtra("select_record_report_opt", this.Pnj);
        intent.putExtra("RoomInfo_Id", this.dom.getTalkerUserName());
        intent.putExtra("scene", 1);
        intent.putExtra("local_scene", i3);
        intent.putExtra("revoke_record", z);
        if (caVar != null) {
            intent.putExtra("msg_id", caVar.field_msgId);
        }
        com.tencent.mm.ui.chatting.e.a aVar = this.dom;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/component/ChatroomComponent", "dealDelChatroomMemberImp", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/util/LinkedList;Ljava/util/LinkedList;IIZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        aVar.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/component/ChatroomComponent", "dealDelChatroomMemberImp", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/util/LinkedList;Ljava/util/LinkedList;IIZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(233023);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.f
    public final void a(List<String> list, String str, ca caVar) {
        AppMethodBeat.i(35152);
        final com.tencent.mm.roomsdk.a.c.a a2 = b.bhF(this.dom.getTalkerUserName()).a(this.dom.gRL() ? this.dom.getTalkerUserName() : "", list, str, caVar);
        a2.b(new com.tencent.mm.roomsdk.a.b.d() {
            /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass10 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.roomsdk.a.b.a] */
            @Override // com.tencent.mm.roomsdk.a.b.a
            public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.d dVar) {
                AppMethodBeat.i(233008);
                com.tencent.mm.roomsdk.a.b.d dVar2 = dVar;
                if (Util.isTopActivity(e.this.dom.Pwc.getContext()) && !e.b(e.this.dom.Pwc.getContext(), i2, i3, str)) {
                    ca caVar = dVar2.NDK;
                    if (caVar == null) {
                        AppMethodBeat.o(233008);
                        return;
                    }
                    caVar.gDM();
                    bg.aVF();
                    com.tencent.mm.model.c.aSQ().b(caVar.field_msgSvrId, caVar);
                    Toast.makeText(e.this.dom.Pwc.getContext(), e.this.dom.Pwc.getMMResources().getString(R.string.e4g), 0).show();
                    if (a2.gvP()) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 24, (long) dVar2.gsq, true);
                    }
                }
                AppMethodBeat.o(233008);
            }
        }).c(new com.tencent.mm.roomsdk.a.b.b() {
            /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass9 */

            @Override // com.tencent.mm.roomsdk.a.b.a
            public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(233007);
                if (Util.isTopActivity(e.this.dom.Pwc.getContext()) && !e.b(e.this.dom.Pwc.getContext(), i2, i3, str)) {
                    Log.d("MicroMsg.ActionCallbackFunc", "scene type:%s errCode:%s, errType:%s, errMsg:%s", 610, Integer.valueOf(i3), Integer.valueOf(i2), Util.nullAsNil(str));
                    h.c(e.this.dom.Pwc.getContext(), e.this.dom.Pwc.getMMResources().getString(R.string.e4e), e.this.dom.Pwc.getMMResources().getString(R.string.zb), true);
                }
                AppMethodBeat.o(233007);
            }
        });
        a2.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.zb), this.dom.Pwc.getMMResources().getString(R.string.g7h), true, true, new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass11 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(233009);
                a2.cancel();
                AppMethodBeat.o(233009);
            }
        });
        AppMethodBeat.o(35152);
    }

    private void doResume() {
        AppMethodBeat.i(35153);
        d dVar = (d) this.dom.bh(d.class);
        if (ab.Eq(this.dom.getTalkerUserName())) {
            this.Pnd = v.HT(this.dom.getTalkerUserName());
            if (this.Pnd) {
                v.g(this.dom.getTalkerUserName(), this.Pne);
            } else {
                this.Pne.clear();
            }
            Log.d("MicroMsg.ChattingUI.ChatroomComponent", "chatroom display  " + (this.Pnd ? "show " : "not show"));
            AppMethodBeat.o(35153);
        } else if (dVar.gOQ()) {
            this.Pnd = true;
            AppMethodBeat.o(35153);
        } else {
            this.Pnd = false;
            this.Pne.clear();
            AppMethodBeat.o(35153);
        }
    }

    private void gOL() {
        AppMethodBeat.i(35154);
        bg.azz().b(610, this);
        bg.aVF();
        com.tencent.mm.model.c.aSN().remove(this);
        bg.azz().b(551, this);
        if (this.Pnk != null) {
            this.Pnk.dead();
        }
        if (bg.aAc()) {
            bg.aVF();
            com.tencent.mm.model.c.aSX().remove(this.Pnh);
            EventCenter.instance.removeListener(this.Png);
            EventCenter.instance.removeListener(this.Pni);
        }
        AppMethodBeat.o(35154);
    }

    private void gPl() {
        AppMethodBeat.i(35155);
        if (this.dom.GUe == null) {
            Log.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomMemberDetail() talker == null");
            AppMethodBeat.o(35155);
            return;
        }
        if (ab.Iw(this.dom.getTalkerUserName())) {
            Log.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[changeTalker]");
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass15 */

                public final void run() {
                    AppMethodBeat.i(233013);
                    if (e.this.dom == null) {
                        Log.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomMemberDetail] mChattingContext is null!");
                        AppMethodBeat.o(233013);
                        return;
                    }
                    bg.aVF();
                    ah Kd = com.tencent.mm.model.c.aSX().Kd(e.this.dom.getTalkerUserName());
                    if (Kd != null && Kd.gBu()) {
                        Log.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[doScene NetSceneGetChatroomMemberDetail]");
                        com.tencent.mm.roomsdk.a.c.a H = b.bhF(e.this.dom.getTalkerUserName()).H(e.this.dom.getTalkerUserName(), Kd.gBt());
                        H.b(new com.tencent.mm.roomsdk.a.b.b() {
                            /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass15.AnonymousClass1 */

                            @Override // com.tencent.mm.roomsdk.a.b.a
                            public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                                AppMethodBeat.i(233012);
                                if (Util.isTopActivity(e.this.dom.Pwc.getContext())) {
                                    Log.i("MicroMsg.ActionCallbackFunc", "cpan[refresh top btn]");
                                    e.this.OFo = v.HW(e.this.dom.getTalkerUserName());
                                    ((com.tencent.mm.ui.chatting.d.b.aa) e.this.dom.bh(com.tencent.mm.ui.chatting.d.b.aa.class)).gQp();
                                }
                                AppMethodBeat.o(233012);
                            }
                        });
                        H.aJu();
                    }
                    AppMethodBeat.o(233013);
                }
            }, 1000);
        }
        AppMethodBeat.o(35155);
    }

    private static int gPm() {
        AppMethodBeat.i(233024);
        if (Pnl == -1) {
            Pnl = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_check_update_chat_room_info_detail, 0);
        }
        int i2 = Pnl;
        AppMethodBeat.o(233024);
        return i2;
    }

    private String bmG(String str) {
        String displayName;
        AppMethodBeat.i(233025);
        if (((d) this.dom.bh(d.class)).gOQ() || this.dom.gRL()) {
            bg.aVF();
            as Kn = com.tencent.mm.model.c.aSN().Kn(str);
            if (Kn == null || ((int) Kn.gMZ) == 0) {
                AppMethodBeat.o(233025);
                return str;
            }
            if (!Util.isNullOrNil(Kn.field_conRemark)) {
                displayName = Kn.field_conRemark;
            } else {
                bg.aVF();
                ah Kd = com.tencent.mm.model.c.aSX().Kd(this.dom.getTalkerUserName());
                if (Kd == null) {
                    displayName = null;
                } else {
                    displayName = Kd.getDisplayName(Kn.field_username);
                }
            }
            if (Util.isNullOrNil(displayName)) {
                displayName = Kn.field_conRemark;
            }
            if (Util.isNullOrNil(displayName)) {
                displayName = Kn.arI();
            }
            AppMethodBeat.o(233025);
            return displayName;
        }
        AppMethodBeat.o(233025);
        return null;
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        AppMethodBeat.i(35156);
        if (this.dom.gRL()) {
            this.OFo = v.C(this.dom.getTalkerUserName(), true);
        }
        AppMethodBeat.o(35156);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(35157);
        this.Pnm = true;
        doResume();
        AppMethodBeat.o(35157);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIo() {
        AppMethodBeat.i(233026);
        super.gIo();
        ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getOpenImMigrateService().Dw("");
        if (ab.Iy(this.dom.getTalkerUserName())) {
            ah Kd = ((c) g.af(c.class)).aSX().Kd(this.dom.getTalkerUserName());
            if (Kd == null) {
                Log.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate member is null");
            } else if (Kd.gBB()) {
                Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate start migrate");
                ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getOpenImMigrateService().af(Kd.field_associateOpenIMRoomName, this.dom.getTalkerUserName());
                AppMethodBeat.o(233026);
                return;
            }
        }
        AppMethodBeat.o(233026);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        AppMethodBeat.i(35159);
        if (!this.Pnm) {
            doResume();
        }
        this.Pnm = false;
        AppMethodBeat.o(35159);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35160);
        super.gOK();
        gOL();
        AppMethodBeat.o(35160);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35161);
        gOL();
        AppMethodBeat.o(35161);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(35162);
        Log.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " sceneType:" + qVar.getType());
        this.dom.dismissDialog();
        if (!this.dom.cQp) {
            Log.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd fragment not foreground, return");
            AppMethodBeat.o(35162);
        } else if (!Util.isTopActivity(this.dom.Pwc.getContext())) {
            AppMethodBeat.o(35162);
        } else if (b(this.dom.Pwc.getContext(), i2, i3, str)) {
            AppMethodBeat.o(35162);
        } else {
            if (i2 == 0 && i3 == 0) {
                switch (qVar.getType()) {
                    case 551:
                        Log.i("MicroMsg.ChattingUI.ChatroomComponent", "cpan[refresh top btn]");
                        this.OFo = v.HW(this.dom.getTalkerUserName());
                        ((com.tencent.mm.ui.chatting.d.b.aa) this.dom.bh(com.tencent.mm.ui.chatting.d.b.aa.class)).gQp();
                        break;
                }
            }
            AppMethodBeat.o(35162);
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(35163);
        if (this.dom == null) {
            Log.e("MicroMsg.ChattingUI.ChatroomComponent", "[onNotifyChange] mChattingContext is null!");
            AppMethodBeat.o(35163);
        } else if (((d) this.dom.bh(d.class)).gOQ()) {
            this.OFo = com.tencent.mm.al.a.e.c(((d) this.dom.bh(d.class)).gON());
            AppMethodBeat.o(35163);
        } else {
            this.OFo = v.HW(this.dom.getTalkerUserName());
            AppMethodBeat.o(35163);
        }
    }

    protected static boolean b(Activity activity, int i2, int i3, String str) {
        AppMethodBeat.i(35164);
        if (z.a.a(activity, i2, i3, str, 7)) {
            AppMethodBeat.o(35164);
            return true;
        } else if (com.tencent.mm.plugin.account.ui.a.a(activity, i2, i3, new Intent().setClass(activity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
            AppMethodBeat.o(35164);
            return true;
        } else {
            AppMethodBeat.o(35164);
            return false;
        }
    }

    private void a(ca caVar, int i2, LinkedList<String> linkedList, int i3, int i4, int i5, String str) {
        int i6;
        String str2;
        AppMethodBeat.i(233027);
        String talkerUserName = this.dom.getTalkerUserName();
        if (linkedList != null) {
            i6 = linkedList.size();
        } else {
            i6 = 0;
        }
        if (caVar != null) {
            str2 = caVar.field_historyId;
        } else {
            str2 = "";
        }
        com.tencent.mm.plugin.selectrecord.b.c.a(talkerUserName, i6, i3, i2, i4, i5, Util.safeParseLong(str2), str);
        AppMethodBeat.o(233027);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        boolean z;
        AppMethodBeat.i(35158);
        if (!ab.JE(this.dom.getTalkerUserName()) && ab.Eq(this.dom.getTalkerUserName())) {
            bg.aVF();
            az bjY = com.tencent.mm.model.c.aST().bjY(this.dom.getTalkerUserName());
            if (bjY == null || (bjY.field_showTips & 2) > 0) {
                Log.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : already tips");
            } else {
                bg.aVF();
                ah Kd = com.tencent.mm.model.c.aSX().Kd(this.dom.getTalkerUserName());
                if (Kd == null || Kd.bax().size() < 20) {
                    Log.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : member nums too few");
                } else if (Kd != null && !Kd.gBx()) {
                    v.a(this.dom.getTalkerUserName(), Kd, true);
                    bjY.field_showTips = 2;
                    bjY.fvy = true;
                    bg.aVF();
                    com.tencent.mm.model.c.aST().a(bjY, this.dom.getTalkerUserName());
                    Log.i("MicroMsg.ChattingUI.ChatroomComponent", "Jacks Show auto Display name tips");
                    u.a(this.dom.getTalkerUserName(), null, this.dom.Pwc.getMMResources().getString(R.string.b2q), false, "", 0);
                }
            }
        }
        bg.azz().a(610, this);
        bg.azz().a(551, this);
        bg.aVF();
        com.tencent.mm.model.c.aSN().add(this);
        bg.aVF();
        com.tencent.mm.model.c.aSX().add(this.Pnh);
        if (this.Pnk != null) {
            this.Pnk.dead();
        }
        this.Pnk = com.tencent.mm.roomsdk.a.b.bhF(this.dom.getTalkerUserName()).alV().e(new com.tencent.mm.roomsdk.a.b.b() {
            /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass14 */

            @Override // com.tencent.mm.roomsdk.a.b.a
            public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(233011);
                e.this.dom.dismissDialog();
                h.cD(e.this.dom.Pwc.getContext(), e.this.dom.Pwc.getMMResources().getString(R.string.g6v));
                AppMethodBeat.o(233011);
            }
        }).f(new com.tencent.mm.roomsdk.a.b.b() {
            /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass13 */

            @Override // com.tencent.mm.roomsdk.a.b.a
            public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(233010);
                e.this.dom.dismissDialog();
                h.a((Context) e.this.dom.Pwc.getContext(), e.this.dom.Pwc.getMMResources().getString(R.string.g77), (String) null, e.this.dom.Pwc.getMMResources().getString(R.string.x_), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass13.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(233010);
            }
        }).gvR();
        EventCenter.instance.addListener(this.Png);
        EventCenter.instance.addListener(this.Pni);
        if (ab.Iw(this.dom.getTalkerUserName()) && v.HX(this.dom.getTalkerUserName())) {
            Log.d("MicroMsg.ChattingUI.ChatroomComponent", "chattingui find chatroom contact need update %s", this.dom.getTalkerUserName());
            ay.a.iDq.aL(this.dom.getTalkerUserName(), "");
        }
        if (com.tencent.mm.bi.d.jpB != null && !this.dom.getTalkerUserName().equals(com.tencent.mm.bi.d.jpB.bgL())) {
            Log.i("MicroMsg.ChattingUI.ChatroomComponent", "chatting oncreate end track %s", com.tencent.mm.bi.d.jpB.bgL());
            fo foVar = new fo();
            foVar.dIN.username = this.dom.getTalkerUserName();
            EventCenter.instance.publish(foVar);
        }
        gPl();
        if (this.dom.GUe == null) {
            Log.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomInfoDetail() talker == null");
        } else if (ab.Iw(this.dom.getTalkerUserName())) {
            Log.i("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomInfoDetail() username:%s, isInChatRoom:%s, sw:%s", this.dom.getTalkerUserName(), Boolean.valueOf(this.OFo), Integer.valueOf(gPm()));
            if (this.OFo && gPm() == 1) {
                com.tencent.f.h.RTc.o(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass16 */

                    public final void run() {
                        AppMethodBeat.i(233014);
                        if (e.this.dom == null) {
                            Log.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomInfoDetail] mChattingContext is null!");
                            AppMethodBeat.o(233014);
                            return;
                        }
                        v.Ik(e.this.dom.getTalkerUserName());
                        AppMethodBeat.o(233014);
                    }
                }, 1000);
            }
        }
        if (ab.Ix(this.dom.getTalkerUserName())) {
            ah Kd2 = ((c) g.af(c.class)).aSX().Kd(this.dom.getTalkerUserName());
            if (Kd2 != null) {
                Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail %s status:%s", this.dom.getTalkerUserName(), Integer.valueOf(Kd2.field_chatroomStatus));
                if (Kd2.gBz()) {
                    Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate getRoomInfo %s", this.dom.getTalkerUserName());
                    com.tencent.mm.roomsdk.a.b.bhF(this.dom.getTalkerUserName()).Dt(this.dom.getTalkerUserName()).aJu();
                    final String talkerUserName = this.dom.getTalkerUserName();
                    boolean z2 = g.aAh().azQ().getBoolean(ar.a.USERINFO_OPEN_IM_MIGRATE_CHECK_ALL_CONVERSATION_BOOLEAN_SYNC, true);
                    Log.i("MicroMsg.ChattingUI.ChatroomComponent", "ifCheckAllConversation %s, excludeUsername %s", Boolean.valueOf(z2), talkerUserName);
                    if (z2) {
                        com.tencent.f.h.RTc.aX(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass17 */

                            public final void run() {
                                ah Kd;
                                AppMethodBeat.i(233015);
                                List<String> gCw = ((l) g.af(l.class)).aST().gCw();
                                Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForGetRoomInfo conversation size:%s", Integer.valueOf(gCw.size()));
                                for (String str : gCw) {
                                    if (!ab.Iy(str) && !Util.isEqual(talkerUserName, str) && (Kd = ((c) g.af(c.class)).aSX().Kd(str)) != null && Kd.gBz()) {
                                        com.tencent.mm.roomsdk.a.b.bhF(str).Dt(str).aJu();
                                        Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForGetRoomInfo %s", str);
                                    }
                                }
                                g.aAh().azQ().set(ar.a.USERINFO_OPEN_IM_MIGRATE_CHECK_ALL_CONVERSATION_BOOLEAN_SYNC, Boolean.FALSE);
                                AppMethodBeat.o(233015);
                            }
                        });
                    }
                    AppMethodBeat.o(35158);
                    return;
                } else if (Kd2.gBA()) {
                    Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate migration %s", this.dom.getTalkerUserName());
                    ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getOpenImMigrateService().af(this.dom.getTalkerUserName(), Kd2.field_associateOpenIMRoomName);
                    final String talkerUserName2 = this.dom.getTalkerUserName();
                    Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration %s", talkerUserName2);
                    com.tencent.f.h.RTc.aX(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass18 */

                        public final void run() {
                            ah Kd;
                            AppMethodBeat.i(233016);
                            List<String> gCw = ((l) g.af(l.class)).aST().gCw();
                            Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration conversation size:%s", Integer.valueOf(gCw.size()));
                            for (String str : gCw) {
                                if (!ab.Iy(str) && !Util.isEqual(talkerUserName2, str) && (Kd = ((c) g.af(c.class)).aSX().Kd(str)) != null && Kd.gBA()) {
                                    Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration %s", str);
                                    ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getOpenImMigrateService().ae(str, Kd.field_associateOpenIMRoomName);
                                }
                            }
                            AppMethodBeat.o(233016);
                        }
                    });
                    AppMethodBeat.o(35158);
                    return;
                }
            } else {
                Log.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail member is null");
            }
            AppMethodBeat.o(35158);
            return;
        }
        if (ab.Iy(this.dom.getTalkerUserName())) {
            ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getOpenImMigrateService().Dw(this.dom.getTalkerUserName());
            ah Kd3 = ((c) g.af(c.class)).aSX().Kd(this.dom.getTalkerUserName());
            if (Kd3 != null) {
                Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail %s status:%s", this.dom.getTalkerUserName(), Integer.valueOf(Kd3.field_chatroomStatus));
                if (Kd3.field_openIMRoomMigrateStatus == 3) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    String string = this.dom.Pwc.getMMResources().getString(R.string.awu);
                    String string2 = this.dom.Pwc.getMMResources().getString(R.string.aww);
                    String string3 = this.dom.Pwc.getMMResources().getString(R.string.awv);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(string);
                    stringBuffer.append("<_wc_custom_link_ href=\"weixin://jump/chatroom/").append(Kd3.field_associateOpenIMRoomName).append("\">").append(string2).append("</_wc_custom_link_>").append(string3);
                    ca caVar = new ca();
                    caVar.nv(0);
                    caVar.Cy(this.dom.getTalkerUserName());
                    caVar.setStatus(3);
                    caVar.setContent(stringBuffer.toString());
                    caVar.setCreateTime(bp.C(this.dom.getTalkerUserName(), System.currentTimeMillis() / 1000));
                    caVar.setType(10000);
                    caVar.setFlag(caVar.field_flag);
                    caVar.fRg = 1;
                    caVar.fqk = true;
                    bp.x(caVar);
                    Kd3.field_openIMRoomMigrateStatus = 4;
                    boolean replace = ((c) g.af(c.class)).aSX().replace(Kd3);
                    com.tencent.mm.chatroom.c.b.f(Kd3.field_associateOpenIMRoomName, this.dom.getTalkerUserName(), 2);
                    Log.i("MicroMsg.ChattingUI.ChatroomComponent", "insert migration finish system msg.(result:%s)", Boolean.valueOf(replace));
                    AppMethodBeat.o(35158);
                    return;
                } else if (Kd3.gBB()) {
                    com.tencent.mm.chatroom.c.b openImMigrateService = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getOpenImMigrateService();
                    String str = Kd3.field_associateOpenIMRoomName;
                    Log.i("MicroMsg.openIm.OpenImMigrateService", "removeMigrateTask %s %s, %s", Util.nullAs(str, ""), Util.nullAs(openImMigrateService.grS.get(str), ""), Boolean.valueOf(openImMigrateService.grR.contains(str)));
                    if (openImMigrateService.grR.contains(str)) {
                        openImMigrateService.grR.remove(str);
                    }
                    Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail remove from cur room");
                    AppMethodBeat.o(35158);
                    return;
                }
            } else {
                Log.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail member is null");
            }
        }
        AppMethodBeat.o(35158);
    }

    static /* synthetic */ void b(e eVar) {
        AppMethodBeat.i(233029);
        if (eVar.Pnf != null) {
            eVar.Pnf.dismiss();
        }
        AppMethodBeat.o(233029);
    }

    static /* synthetic */ void a(e eVar, final com.tencent.mm.roomsdk.a.c.d dVar) {
        AppMethodBeat.i(233031);
        if (eVar.Pnf == null) {
            Activity context = eVar.dom.Pwc.getContext();
            eVar.dom.Pwc.getContext().getString(R.string.zb);
            eVar.Pnf = h.a((Context) context, eVar.dom.Pwc.getContext().getString(R.string.giq), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(232998);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    AppMethodBeat.o(232998);
                }
            });
            AppMethodBeat.o(233031);
            return;
        }
        eVar.Pnf.show();
        AppMethodBeat.o(233031);
    }

    static /* synthetic */ void c(e eVar) {
        AppMethodBeat.i(233032);
        if (eVar.gvi != null) {
            eVar.gvi.dismiss();
        }
        AppMethodBeat.o(233032);
    }

    static /* synthetic */ com.tencent.mm.roomsdk.a.c.a a(e eVar, final ca caVar, final LinkedList linkedList, final LinkedList linkedList2, int i2, final int i3, final boolean z) {
        AppMethodBeat.i(233033);
        final com.tencent.mm.roomsdk.a.c.a a2 = com.tencent.mm.roomsdk.a.b.bhF(eVar.dom.getTalkerUserName()).a(eVar.dom.getTalkerUserName(), linkedList2, i2);
        a2.b(new com.tencent.mm.roomsdk.a.b.b() {
            /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass6 */

            @Override // com.tencent.mm.roomsdk.a.b.a
            public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                String string;
                AppMethodBeat.i(233004);
                e.c(e.this);
                if (z) {
                    string = e.this.dom.Pwc.getMMResources().getString(R.string.gil);
                } else {
                    string = e.this.dom.Pwc.getMMResources().getString(R.string.g71);
                }
                h.cD(e.this.dom.Pwc.getContext(), string);
                if (i3 == 1) {
                    e.a(e.this, caVar, e.this.Pnj.intValue(), linkedList, linkedList2.size(), 1, 2, (String) linkedList.get(0));
                }
                AppMethodBeat.o(233004);
            }
        });
        a2.c(new com.tencent.mm.roomsdk.a.b.b() {
            /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass7 */

            @Override // com.tencent.mm.roomsdk.a.b.a
            public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                String string;
                AppMethodBeat.i(233005);
                e.c(e.this);
                if (!(i2 == 0 && i3 == 0)) {
                    if (i3 == -2024) {
                        com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                        if (Dk != null) {
                            Dk.a(e.this.dom.Pwc.getContext(), null, null);
                            AppMethodBeat.o(233005);
                            return;
                        }
                        h.a((Context) e.this.dom.Pwc.getContext(), e.this.dom.Pwc.getMMResources().getString(R.string.g6x), (String) null, e.this.dom.Pwc.getMMResources().getString(R.string.g6y), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass7.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                    } else {
                        if (z) {
                            string = e.this.dom.Pwc.getMMResources().getString(R.string.gin);
                        } else {
                            string = e.this.dom.Pwc.getMMResources().getString(R.string.g77);
                        }
                        h.a((Context) e.this.dom.Pwc.getContext(), string, (String) null, e.this.dom.Pwc.getMMResources().getString(R.string.x_), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass7.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                    }
                    if (i3 == 1) {
                        e.a(e.this, caVar, e.this.Pnj.intValue(), linkedList, linkedList2.size(), 1, 3, (String) linkedList.get(0));
                    }
                }
                AppMethodBeat.o(233005);
            }
        });
        if (z) {
            a2.aJu();
        } else {
            a2.a(eVar.dom.Pwc.getContext(), eVar.dom.Pwc.getMMResources().getString(R.string.zb), eVar.dom.Pwc.getMMResources().getString(R.string.g6m), true, true, new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass8 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(233006);
                    a2.cancel();
                    AppMethodBeat.o(233006);
                }
            });
        }
        AppMethodBeat.o(233033);
        return a2;
    }

    static /* synthetic */ void b(e eVar, final com.tencent.mm.roomsdk.a.c.d dVar) {
        AppMethodBeat.i(233034);
        if (eVar.gvi == null) {
            Activity context = eVar.dom.Pwc.getContext();
            eVar.dom.Pwc.getContext().getString(R.string.zb);
            eVar.gvi = h.a((Context) context, eVar.dom.Pwc.getContext().getString(R.string.g6m), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.chatting.d.e.AnonymousClass5 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(233003);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (e.this.gvh != null) {
                        e.this.gvh.cancel();
                    }
                    AppMethodBeat.o(233003);
                }
            });
            AppMethodBeat.o(233034);
            return;
        }
        eVar.gvi.show();
        AppMethodBeat.o(233034);
    }
}
