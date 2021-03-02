package com.tencent.mm.ui.chatting.d;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.chatroom.d.t;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.d.z;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.d.b.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(gRF = y.class)
public class ab extends a implements y {
    private a Kjq = null;
    private RecyclerView Pqm;
    private ImageView Pqn;
    private ImageView Pqo;
    private e Pqp;
    private List<com.tencent.mm.chatroom.storage.c> Pqq = new ArrayList();
    private HashMap<String, com.tencent.mm.chatroom.storage.c> Pqr = new HashMap<>();
    private ArrayList<f> Pqs = new ArrayList<>();
    private boolean Pqt = true;
    private ObjectAnimator Pqu = null;
    private ObjectAnimator Pqv = null;
    private b Pqw = new b() {
        /* class com.tencent.mm.ui.chatting.d.ab.AnonymousClass7 */

        @Override // com.tencent.mm.ui.chatting.d.ab.b
        public final void K(View view, final int i2) {
            boolean z;
            AppMethodBeat.i(184977);
            Object tag = view.getTag();
            if (tag instanceof com.tencent.mm.chatroom.storage.c) {
                com.tencent.mm.chatroom.storage.c cVar = (com.tencent.mm.chatroom.storage.c) tag;
                if (cVar.aml()) {
                    com.tencent.mm.chatroom.d.y.f(ab.this.dom.Pwc.getContext(), cVar.field_roomname, false);
                } else {
                    g gVar = new g();
                    gVar.username = cVar.field_username;
                    gVar.kHw = cVar.field_path;
                    gVar.scene = 1160;
                    gVar.kHG = cVar.field_roomname;
                    gVar.cyr = cVar.field_shareKey;
                    gVar.cyq = cVar.field_shareName;
                    ((r) com.tencent.mm.kernel.g.af(r.class)).a(ab.this.dom.Pwc.getContext(), gVar);
                }
                final com.tencent.mm.chatroom.storage.c ai = ((PluginChatroomUI) com.tencent.mm.kernel.g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(cVar.field_roomname, cVar.field_todoid);
                boolean e2 = com.tencent.mm.chatroom.d.y.e(ai);
                if (ai != null) {
                    z = com.tencent.mm.chatroom.d.y.b(ai);
                    if (z) {
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.d.ab.AnonymousClass7.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(184971);
                                ab.this.Pqs.add(new f(ai, i2 + 1));
                                AppMethodBeat.o(184971);
                            }
                        }, 300);
                    }
                } else {
                    z = false;
                }
                z.a(ab.this.dom.getTalkerUserName(), cVar.aml() ? 1 : 0, 1, cVar.field_todoid, cVar.field_username);
                Object[] objArr = new Object[3];
                objArr[0] = ai == null ? BuildConfig.COMMAND : ai.field_todoid;
                objArr[1] = Boolean.valueOf(z);
                objArr[2] = Boolean.valueOf(e2);
                Log.i("MicroMsg.roomTodo.GroupTodoComponent", "click update to finish(%s %s %s)", objArr);
                AppMethodBeat.o(184977);
                return;
            }
            Object[] objArr2 = new Object[1];
            objArr2[0] = tag == null ? BuildConfig.COMMAND : tag.getClass().getSimpleName();
            Log.e("MicroMsg.roomTodo.GroupTodoComponent", "onClick %s", objArr2);
            AppMethodBeat.o(184977);
        }

        @Override // com.tencent.mm.ui.chatting.d.ab.b
        public final boolean aI(final View view, final int i2) {
            int i3;
            int i4;
            AppMethodBeat.i(184978);
            Object tag = view.getTag();
            if (tag instanceof com.tencent.mm.chatroom.storage.c) {
                final com.tencent.mm.chatroom.storage.c cVar = (com.tencent.mm.chatroom.storage.c) tag;
                com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(ab.this.dom.Pwc.getContext(), view);
                aVar.QSu = true;
                aVar.QSw = true;
                aVar.QSx = true;
                aVar.QSs = new View.OnCreateContextMenuListener() {
                    /* class com.tencent.mm.ui.chatting.d.ab.AnonymousClass7.AnonymousClass2 */

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(184972);
                        contextMenu.clear();
                        if (com.tencent.mm.model.ab.IE(ab.this.dom.getTalkerUserName())) {
                            contextMenu.add(0, 1, 0, ab.this.dom.Pwc.getContext().getResources().getString(R.string.b0i));
                        }
                        contextMenu.add(0, 2, 0, ab.this.dom.Pwc.getContext().getResources().getString(R.string.avf));
                        AppMethodBeat.o(184972);
                    }
                };
                aVar.HLY = new o.g() {
                    /* class com.tencent.mm.ui.chatting.d.ab.AnonymousClass7.AnonymousClass3 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        int i3;
                        AppMethodBeat.i(184975);
                        switch (menuItem.getItemId()) {
                            case 1:
                                Activity context = ab.this.dom.Pwc.getContext();
                                String talkerUserName = ab.this.dom.getTalkerUserName();
                                String str = cVar.field_todoid;
                                String str2 = cVar.field_username;
                                if (cVar.aml()) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                com.tencent.mm.chatroom.d.y.a(context, talkerUserName, str, str2, false, 1, i3, 0, new y.a() {
                                    /* class com.tencent.mm.ui.chatting.d.ab.AnonymousClass7.AnonymousClass3.AnonymousClass1 */

                                    @Override // com.tencent.mm.chatroom.d.y.a
                                    public final void amc() {
                                        AppMethodBeat.i(184973);
                                        Log.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp addtodo");
                                        AppMethodBeat.o(184973);
                                    }

                                    @Override // com.tencent.mm.chatroom.d.y.a
                                    public final void amd() {
                                        AppMethodBeat.i(184974);
                                        Pair<Boolean, String> a2 = com.tencent.mm.chatroom.d.y.a(cVar);
                                        if (((Boolean) a2.first).booleanValue()) {
                                            ab.d(ab.this, cVar);
                                            ab.this.Pqp.ck(i2);
                                            ab.c(ab.this);
                                        }
                                        Log.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp recall result:%s", a2);
                                        AppMethodBeat.o(184974);
                                    }
                                });
                                AppMethodBeat.o(184975);
                                return;
                            case 2:
                                boolean c2 = com.tencent.mm.chatroom.d.y.c(cVar);
                                Log.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp delete(%s) result:%s", cVar.field_todoid, Boolean.valueOf(c2));
                                if (c2) {
                                    ab.d(ab.this, cVar);
                                    ab.this.Pqp.ck(i2);
                                    ab.c(ab.this);
                                }
                                z.a(ab.this.dom.getTalkerUserName(), cVar.aml() ? 1 : 0, 2, 2, cVar.field_todoid, cVar.field_username);
                                break;
                        }
                        AppMethodBeat.o(184975);
                    }
                };
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int i5 = iArr[0];
                int i6 = iArr[1] - 32;
                if (i5 <= 0) {
                    i5 = 16;
                }
                if (i6 < 0) {
                    i6 = 16;
                }
                if (i5 > com.tencent.mm.ui.widget.textview.b.getScreenWidth(ab.this.dom.Pwc.getContext())) {
                    i3 = com.tencent.mm.ui.widget.textview.b.getScreenWidth(ab.this.dom.Pwc.getContext()) - 16;
                } else {
                    i3 = i5;
                }
                aVar.QwU = new PopupWindow.OnDismissListener() {
                    /* class com.tencent.mm.ui.chatting.d.ab.AnonymousClass7.AnonymousClass4 */

                    public final void onDismiss() {
                        AppMethodBeat.i(184976);
                        view.setBackgroundResource(R.drawable.nf);
                        AppMethodBeat.o(184976);
                    }
                };
                aVar.QSr = view;
                aVar.ez(i3, i6);
                view.setBackgroundResource(R.drawable.nh);
                String talkerUserName = ab.this.dom.getTalkerUserName();
                if (cVar.aml()) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                z.a(talkerUserName, i4, 4, 2, cVar.field_todoid, cVar.field_username);
            }
            AppMethodBeat.o(184978);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.d.ab.b
        public final boolean aJ(View view, int i2) {
            int i3 = 0;
            AppMethodBeat.i(184979);
            Object tag = view.getTag();
            if (tag instanceof com.tencent.mm.chatroom.storage.c) {
                com.tencent.mm.chatroom.storage.c cVar = (com.tencent.mm.chatroom.storage.c) tag;
                boolean c2 = com.tencent.mm.chatroom.d.y.c(cVar);
                Log.i("MicroMsg.roomTodo.GroupTodoComponent", "onFinish finish(%s %s)", cVar.field_todoid, Boolean.valueOf(c2));
                if (c2) {
                    ((PluginChatroomUI) com.tencent.mm.kernel.g.ah(PluginChatroomUI.class)).getRoomTodoMsgService();
                    com.tencent.mm.kernel.g.azz().a(new t(ab.this.dom.getTalkerUserName(), cVar.field_creator, cVar.field_todoid, com.tencent.mm.chatroom.d.y.d(cVar)), 0);
                    ab.d(ab.this, cVar);
                    ab.this.Pqp.ck(i2);
                    ab.c(ab.this);
                }
                String talkerUserName = ab.this.dom.getTalkerUserName();
                if (cVar.aml()) {
                    i3 = 1;
                }
                z.a(talkerUserName, i3, 1, 2, cVar.field_todoid, cVar.field_username);
            } else {
                Object[] objArr = new Object[1];
                objArr[0] = tag == null ? BuildConfig.COMMAND : tag.getClass().getSimpleName();
                Log.e("MicroMsg.roomTodo.GroupTodoComponent", "onFinish %s", objArr);
            }
            AppMethodBeat.o(184979);
            return true;
        }
    };
    private IListener<nt> gsQ = new IListener<nt>() {
        /* class com.tencent.mm.ui.chatting.d.ab.AnonymousClass1 */

        {
            AppMethodBeat.i(184964);
            this.__eventId = nt.class.getName().hashCode();
            AppMethodBeat.o(184964);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(nt ntVar) {
            AppMethodBeat.i(184965);
            nt ntVar2 = ntVar;
            if (ntVar2 != null) {
                Log.i("MicroMsg.roomTodo.GroupTodoComponent", "NotifyGroupTodoEvent %s %s %s", ntVar2.dTT.dOe, ntVar2.dTT.dTU, Integer.valueOf(ntVar2.dTT.op));
                if (Util.isEqual(ab.this.dom.getTalkerUserName(), ntVar2.dTT.dOe)) {
                    if (ntVar2.dTT.op != 3 && ab.this.Pqs.size() > 0) {
                        Iterator it = ab.this.Pqs.iterator();
                        while (it.hasNext()) {
                            f fVar = (f) it.next();
                            if (fVar.dDe == 1) {
                                ab.a(ab.this, fVar.PqM);
                                ab.this.Pqp.aq(fVar.ajZ, fVar.akb);
                            }
                        }
                        ab.this.Pqs.clear();
                    }
                    com.tencent.mm.chatroom.storage.c ai = ((PluginChatroomUI) com.tencent.mm.kernel.g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(ntVar2.dTT.dOe, ntVar2.dTT.dTU);
                    if (ntVar2.dTT.op == 0) {
                        ab.b(ab.this, ai);
                    } else if (ntVar2.dTT.op == 1) {
                        ab.a(ab.this, ntVar2.dTT.dTU);
                    } else if (ntVar2.dTT.op == 2) {
                        ab.b(ab.this, ai);
                    } else if (ntVar2.dTT.op == 3) {
                        ab.c(ab.this, ai);
                    }
                    ab.c(ab.this);
                }
            }
            AppMethodBeat.o(184965);
            return false;
        }
    };
    private LinearLayoutManager gxa;
    private View jBN;

    public interface a {
        void hide();

        void show();
    }

    /* access modifiers changed from: package-private */
    public interface b {
        void K(View view, int i2);

        boolean aI(View view, int i2);

        boolean aJ(View view, int i2);
    }

    public interface c {
        void BP(boolean z);

        void BQ(boolean z);

        int dYg();
    }

    public ab() {
        AppMethodBeat.i(184990);
        AppMethodBeat.o(184990);
    }

    static /* synthetic */ int a(ab abVar, com.tencent.mm.chatroom.storage.c cVar) {
        AppMethodBeat.i(233113);
        int j2 = abVar.j(cVar);
        AppMethodBeat.o(233113);
        return j2;
    }

    static /* synthetic */ void c(ab abVar) {
        AppMethodBeat.i(185877);
        abVar.updateView();
        AppMethodBeat.o(185877);
    }

    static /* synthetic */ void c(ab abVar, com.tencent.mm.chatroom.storage.c cVar) {
        AppMethodBeat.i(185876);
        abVar.a(cVar, true);
        AppMethodBeat.o(185876);
    }

    static /* synthetic */ int d(ab abVar, com.tencent.mm.chatroom.storage.c cVar) {
        AppMethodBeat.i(233114);
        int i2 = abVar.i(cVar);
        AppMethodBeat.o(233114);
        return i2;
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(184991);
        super.gIl();
        if (!com.tencent.mm.chatroom.d.y.ama()) {
            AppMethodBeat.o(184991);
            return;
        }
        Log.i("MicroMsg.roomTodo.GroupTodoComponent", "onChattingEnterAnimStart: user %s hashCode:%s", this.dom.getTalkerUserName(), Integer.valueOf(hashCode()));
        if (this.jBN == null) {
            long aWz = cl.aWz();
            this.jBN = this.dom.findViewById(R.id.av4);
            this.Pqm = (RecyclerView) this.jBN.findViewById(R.id.irt);
            this.Pqn = (ImageView) this.jBN.findViewById(R.id.iro);
            this.Pqo = (ImageView) this.jBN.findViewById(R.id.irs);
            this.Pqm.a(new RecyclerView.l() {
                /* class com.tencent.mm.ui.chatting.d.ab.AnonymousClass2 */

                @Override // android.support.v7.widget.RecyclerView.l
                public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                    AppMethodBeat.i(233108);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(recyclerView);
                    bVar.pH(i2);
                    bVar.pH(i3);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                    super.onScrolled(recyclerView, i2, i3);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                    AppMethodBeat.o(233108);
                }

                @Override // android.support.v7.widget.RecyclerView.l
                public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                    AppMethodBeat.i(184966);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(recyclerView);
                    bVar.pH(i2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                    super.onScrollStateChanged(recyclerView, i2);
                    Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onScrollStateChanged newState:%s canScrollHorizontally(-1):%s", Integer.valueOf(i2), Boolean.valueOf(recyclerView.canScrollHorizontally(-1)));
                    if (i2 != 0 || recyclerView.canScrollHorizontally(-1)) {
                        ab.this.Pqo.setVisibility(0);
                        ab.this.Pqn.setVisibility(0);
                    } else {
                        ab.this.Pqo.setVisibility(8);
                        ab.this.Pqn.setVisibility(8);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                    AppMethodBeat.o(184966);
                }
            });
            this.dom.Pwc.getContext();
            this.gxa = new LinearLayoutManager();
            this.gxa.setOrientation(0);
            this.Pqm.setLayoutManager(this.gxa);
            this.Pqp = new e(this.dom.Pwc.getContext(), this.Pqq, this.Pqw);
            this.Pqm.setAdapter(this.Pqp);
            this.Pqp.atj.notifyChanged();
            Log.i("MicroMsg.roomTodo.GroupTodoComponent", "constructor interTime:%s", Long.valueOf(cl.aWz() - aWz));
        }
        long aWz2 = cl.aWz();
        if (gQd()) {
            this.gsQ.alive();
            if (this.jBN != null) {
                gQf();
                for (com.tencent.mm.chatroom.storage.c cVar : ((PluginChatroomUI) com.tencent.mm.kernel.g.ah(PluginChatroomUI.class)).getGroupTodoStorage().DC(this.dom.getTalkerUserName())) {
                    this.Pqq.add(cVar);
                    this.Pqr.put(cVar.field_todoid, cVar);
                }
                Collections.sort(this.Pqq, new Comparator<com.tencent.mm.chatroom.storage.c>() {
                    /* class com.tencent.mm.ui.chatting.d.ab.AnonymousClass5 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* bridge */ /* synthetic */ int compare(com.tencent.mm.chatroom.storage.c cVar, com.tencent.mm.chatroom.storage.c cVar2) {
                        AppMethodBeat.i(233111);
                        int compare = Long.compare(cVar2.field_updatetime, cVar.field_updatetime);
                        AppMethodBeat.o(233111);
                        return compare;
                    }
                });
                this.Pqp.atj.notifyChanged();
                updateView();
            }
            gQe();
        } else {
            gQf();
            this.jBN.setVisibility(8);
        }
        Log.i("MicroMsg.roomTodo.GroupTodoComponent", "onResume chatroomUsername:%s interTime:%s", this.dom.getTalkerUserName(), Long.valueOf(cl.aWz() - aWz2));
        AppMethodBeat.o(184991);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIo() {
        AppMethodBeat.i(184992);
        super.gIo();
        if (!com.tencent.mm.chatroom.d.y.ama()) {
            AppMethodBeat.o(184992);
            return;
        }
        if (gQd()) {
            Log.i("MicroMsg.roomTodo.GroupTodoComponent", "onPause");
            this.gsQ.dead();
            if (this.jBN != null) {
                this.jBN.setVisibility(8);
            }
            gQe();
        }
        Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingExitAnimEnd");
        AppMethodBeat.o(184992);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        AppMethodBeat.i(185867);
        super.cFx();
        Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingResume");
        if (this.Pqs.size() > 0) {
            Iterator<f> it = this.Pqs.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next.dDe == 1) {
                    j(next.PqM);
                    this.Pqp.aq(next.ajZ, next.akb);
                }
            }
            this.Pqs.clear();
        }
        AppMethodBeat.o(185867);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(185868);
        super.cFy();
        Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingPause");
        AppMethodBeat.o(185868);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.y
    public final void a(a aVar) {
        this.Kjq = aVar;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.y
    public final void BQ(boolean z) {
        AppMethodBeat.i(185869);
        if (!com.tencent.mm.chatroom.d.y.ama()) {
            AppMethodBeat.o(185869);
        } else if (!gQd()) {
            AppMethodBeat.o(185869);
        } else {
            this.Pqt = false;
            if (this.jBN.getVisibility() != 0) {
                AppMethodBeat.o(185869);
                return;
            }
            if (this.Pqu == null) {
                this.Pqu = ObjectAnimator.ofFloat(this.jBN, "alpha", 1.0f, 0.0f);
                this.Pqu.addListener(new Animator.AnimatorListener() {
                    /* class com.tencent.mm.ui.chatting.d.ab.AnonymousClass3 */

                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(233109);
                        if (ab.this.jBN != null) {
                            ab.this.jBN.setVisibility(4);
                        }
                        AppMethodBeat.o(233109);
                    }

                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
            }
            if (z) {
                this.Pqu.setDuration(100L);
            } else {
                this.Pqu.setDuration(200L);
            }
            this.Pqu.start();
            AppMethodBeat.o(185869);
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.y
    public final void BP(boolean z) {
        AppMethodBeat.i(185870);
        if (!com.tencent.mm.chatroom.d.y.ama()) {
            AppMethodBeat.o(185870);
        } else if (!gQd()) {
            AppMethodBeat.o(185870);
        } else {
            this.Pqt = true;
            if (this.jBN.getVisibility() == 0) {
                AppMethodBeat.o(185870);
            } else if (this.Pqq.size() == 0) {
                AppMethodBeat.o(185870);
            } else {
                if (this.Pqv == null) {
                    this.Pqv = ObjectAnimator.ofFloat(this.jBN, "alpha", 0.0f, 1.0f);
                    this.Pqv.addListener(new Animator.AnimatorListener() {
                        /* class com.tencent.mm.ui.chatting.d.ab.AnonymousClass4 */

                        public final void onAnimationStart(Animator animator) {
                            AppMethodBeat.i(233110);
                            if (ab.this.jBN != null) {
                                ab.this.jBN.setVisibility(0);
                            }
                            AppMethodBeat.o(233110);
                        }

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(184968);
                            AppMethodBeat.o(184968);
                        }

                        public final void onAnimationCancel(Animator animator) {
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }
                    });
                }
                if (z) {
                    this.Pqv.setDuration(100L);
                } else {
                    this.Pqv.setDuration(200L);
                }
                this.Pqv.start();
                AppMethodBeat.o(185870);
            }
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.y
    public final int dYg() {
        AppMethodBeat.i(185871);
        if (!com.tencent.mm.chatroom.d.y.ama() || this.jBN == null || this.Pqq.size() <= 0) {
            AppMethodBeat.o(185871);
            return 0;
        }
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) this.dom.Pwc.getContext(), 48);
        AppMethodBeat.o(185871);
        return fromDPToPix;
    }

    private boolean gQd() {
        AppMethodBeat.i(184995);
        boolean Ix = com.tencent.mm.model.ab.Ix(this.dom.getTalkerUserName());
        AppMethodBeat.o(184995);
        return Ix;
    }

    private void gQe() {
        AppMethodBeat.i(184996);
        az bjY = ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bjY(this.dom.getTalkerUserName());
        if (bjY != null && bjY.field_hasTodo == 1) {
            bjY.nC(0);
            bg.aVF();
            com.tencent.mm.model.c.aST().a(bjY, bjY.field_username, false);
        }
        AppMethodBeat.o(184996);
    }

    private void updateView() {
        AppMethodBeat.i(184997);
        if (this.jBN != null) {
            if (this.Pqq.size() == 0) {
                this.jBN.setVisibility(8);
                if (this.Kjq != null) {
                    this.Kjq.hide();
                    AppMethodBeat.o(184997);
                    return;
                }
            } else if (this.Pqt) {
                this.jBN.setVisibility(0);
                if (this.Kjq != null) {
                    this.Kjq.show();
                }
            }
        }
        AppMethodBeat.o(184997);
    }

    private void a(com.tencent.mm.chatroom.storage.c cVar, boolean z) {
        AppMethodBeat.i(185872);
        if (!com.tencent.mm.chatroom.d.y.e(cVar)) {
            AppMethodBeat.o(185872);
        } else if (!this.Pqq.contains(cVar)) {
            if (cVar != null) {
                this.Pqq.add(0, cVar);
                this.Pqr.put(cVar.field_todoid, cVar);
                this.Pqp.cj(0);
            }
            if (this.Pqq.size() > 20) {
                h.RTc.n(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.ab.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(233112);
                        for (int size = ab.this.Pqq.size() - 1; size >= 20; size--) {
                            com.tencent.mm.chatroom.storage.c cVar = (com.tencent.mm.chatroom.storage.c) ab.this.Pqq.remove(size);
                            if (cVar != null) {
                                ab.this.Pqr.remove(cVar);
                            }
                        }
                        ab.this.Pqp.at(20, ab.this.Pqq.size() - 20);
                        AppMethodBeat.o(233112);
                    }
                }, 300);
            }
            AppMethodBeat.o(185872);
        } else if (z) {
            if (this.Pqq.indexOf(cVar) != -1) {
                this.Pqs.add(new f(cVar, this.Pqq.indexOf(cVar) + 1));
            }
            AppMethodBeat.o(185872);
        } else {
            int j2 = j(cVar);
            if (j2 != -1) {
                this.Pqp.aq(0, j2 + 1);
            }
            AppMethodBeat.o(185872);
        }
    }

    private int i(com.tencent.mm.chatroom.storage.c cVar) {
        AppMethodBeat.i(184998);
        if (cVar != null) {
            if (this.Pqq.contains(cVar)) {
                int indexOf = this.Pqq.indexOf(cVar);
                this.Pqq.remove(cVar);
                this.Pqr.remove(cVar.field_todoid);
                AppMethodBeat.o(184998);
                return indexOf;
            }
            Log.e("MicroMsg.roomTodo.GroupTodoComponent", "removeTodoItemList todo no exist???");
        }
        AppMethodBeat.o(184998);
        return -1;
    }

    private int j(com.tencent.mm.chatroom.storage.c cVar) {
        AppMethodBeat.i(184999);
        if (cVar != null) {
            if (this.Pqq.contains(cVar)) {
                int indexOf = this.Pqq.indexOf(cVar);
                this.Pqq.remove(indexOf);
                this.Pqq.add(0, cVar);
                this.Pqr.put(cVar.field_todoid, cVar);
                AppMethodBeat.o(184999);
                return indexOf;
            }
            Log.e("MicroMsg.roomTodo.GroupTodoComponent", "updateItem todo no exist???");
        }
        AppMethodBeat.o(184999);
        return -1;
    }

    private void gQf() {
        AppMethodBeat.i(185873);
        this.Pqq.clear();
        this.Pqr.clear();
        AppMethodBeat.o(185873);
    }

    /* access modifiers changed from: package-private */
    public static class e extends RecyclerView.a {
        private List<com.tencent.mm.chatroom.storage.c> PqI;
        private b Pqw;
        private Context context;

        public e(Context context2, List<com.tencent.mm.chatroom.storage.c> list, b bVar) {
            this.context = context2;
            this.PqI = list;
            this.Pqw = bVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(184987);
            d dVar = new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.qc, viewGroup, false));
            AppMethodBeat.o(184987);
            return dVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(184988);
            if (this.PqI != null && i2 >= 0 && i2 < this.PqI.size()) {
                final d dVar = (d) vVar;
                final com.tencent.mm.chatroom.storage.c cVar = this.PqI.get(i2);
                Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onBindViewHolder() i:%s", Integer.valueOf(i2));
                dVar.gvQ.setVisibility(0);
                if (cVar.aml()) {
                    dVar.gBZ.setImageResource(R.drawable.bb_);
                    dVar.PqE.setText(Util.nullAs(cVar.field_title, this.context.getString(R.string.ave)));
                } else {
                    WxaAttributes Xk = ((q) com.tencent.mm.kernel.g.af(q.class)).Xk(cVar.field_username);
                    if (Xk == null) {
                        ((q) com.tencent.mm.kernel.g.af(q.class)).a(cVar.field_username, new q.a() {
                            /* class com.tencent.mm.ui.chatting.d.ab.e.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.appbrand.service.q.a
                            public final void b(final WxaAttributes wxaAttributes) {
                                AppMethodBeat.i(184983);
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.ui.chatting.d.ab.e.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(184982);
                                        com.tencent.mm.av.q.bcV().a(wxaAttributes != null ? wxaAttributes.field_smallHeadURL : "", dVar.gBZ, d.gvY);
                                        if (Util.isNullOrNil(cVar.field_title) && wxaAttributes != null) {
                                            dVar.PqE.setText(wxaAttributes.field_nickname);
                                        }
                                        AppMethodBeat.o(184982);
                                    }
                                });
                                AppMethodBeat.o(184983);
                            }
                        });
                        if (!Util.isNullOrNil(cVar.field_title)) {
                            dVar.PqE.setText(Util.nullAs(cVar.field_title, ""));
                        }
                    } else {
                        com.tencent.mm.av.q.bcV().a(Xk != null ? Xk.field_smallHeadURL : "", dVar.gBZ, d.gvY);
                        dVar.PqE.setText(Util.nullAs(cVar.field_title, Xk.field_nickname));
                    }
                }
                if (i2 == 0) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dVar.PqD.getLayoutParams();
                    if (layoutParams.leftMargin == 0) {
                        layoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 2);
                        dVar.PqD.setLayoutParams(layoutParams);
                    }
                } else {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) dVar.PqD.getLayoutParams();
                    if (layoutParams2.leftMargin != 0) {
                        layoutParams2.leftMargin = 0;
                        dVar.PqD.setLayoutParams(layoutParams2);
                    }
                }
                if (cVar.field_state == 0) {
                    dVar.PqF.setVisibility(8);
                    if (cVar.field_nreply > 0) {
                        dVar.PqG.setVisibility(0);
                        dVar.PqH.setText(new StringBuilder().append(cVar.field_nreply).toString());
                    } else {
                        dVar.PqG.setVisibility(8);
                    }
                } else if (cVar.field_state == 1) {
                    dVar.PqF.setVisibility(0);
                    dVar.PqG.setVisibility(8);
                    dVar.PqF.setTag(cVar);
                    dVar.PqF.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.ab.e.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(184984);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (e.this.Pqw != null) {
                                e.this.Pqw.aJ(view, dVar.lR());
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(184984);
                        }
                    });
                }
                dVar.PqD.setTag(cVar);
                dVar.PqD.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.d.ab.e.AnonymousClass3 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(184985);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (e.this.Pqw != null) {
                            e.this.Pqw.K(view, dVar.lR());
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(184985);
                    }
                });
                dVar.PqD.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class com.tencent.mm.ui.chatting.d.ab.e.AnonymousClass4 */

                    public final boolean onLongClick(View view) {
                        AppMethodBeat.i(184986);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                        if (e.this.Pqw != null) {
                            boolean aI = e.this.Pqw.aI(view, dVar.lR());
                            com.tencent.mm.hellhoundlib.a.a.a(aI, this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                            AppMethodBeat.o(184986);
                            return aI;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(184986);
                        return false;
                    }
                });
            }
            AppMethodBeat.o(184988);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            return 0;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(184989);
            int size = this.PqI.size();
            AppMethodBeat.o(184989);
            return size;
        }
    }

    static class d extends RecyclerView.v {
        static final com.tencent.mm.av.a.a.c gvY;
        RelativeLayout PqD;
        TextView PqE;
        RelativeLayout PqF;
        RelativeLayout PqG;
        TextView PqH;
        ImageView gBZ;
        View gvQ;

        static {
            AppMethodBeat.i(184981);
            c.a aVar = new c.a();
            aVar.jbq = R.raw.app_brand_app_default_icon_for_tail;
            c.a dr = aVar.dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20));
            dr.iaT = true;
            dr.jbf = true;
            dr.jbd = true;
            gvY = aVar.bdv();
            AppMethodBeat.o(184981);
        }

        public d(View view) {
            super(view);
            AppMethodBeat.i(184980);
            this.gvQ = view;
            this.PqD = (RelativeLayout) view.findViewById(R.id.irh);
            this.gBZ = (ImageView) view.findViewById(R.id.irl);
            this.PqE = (TextView) view.findViewById(R.id.irv);
            this.PqF = (RelativeLayout) view.findViewById(R.id.irj);
            this.PqG = (RelativeLayout) view.findViewById(R.id.irp);
            this.PqH = (TextView) view.findViewById(R.id.irr);
            AppMethodBeat.o(184980);
        }
    }

    /* access modifiers changed from: package-private */
    public static class f {
        public com.tencent.mm.chatroom.storage.c PqM;
        public int ajZ;
        public int akb;
        public int dDe = 0;

        public f(com.tencent.mm.chatroom.storage.c cVar, int i2) {
            this.PqM = cVar;
            this.dDe = 1;
            this.ajZ = 0;
            this.akb = i2;
        }
    }

    static /* synthetic */ void b(ab abVar, com.tencent.mm.chatroom.storage.c cVar) {
        AppMethodBeat.i(185874);
        abVar.a(cVar, false);
        AppMethodBeat.o(185874);
    }

    static /* synthetic */ void a(ab abVar, String str) {
        int i2;
        AppMethodBeat.i(185875);
        if (!Util.isNullOrNil(str) && (i2 = abVar.i(abVar.Pqr.remove(str))) != -1) {
            abVar.Pqp.ck(i2);
        }
        AppMethodBeat.o(185875);
    }
}
