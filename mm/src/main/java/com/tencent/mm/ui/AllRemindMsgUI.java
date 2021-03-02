package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bul;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.protocal.protobuf.dwg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

public class AllRemindMsgUI extends MMActivity implements i {
    private static final f<Integer, com.tencent.mm.protocal.b.a.c> gAU = new com.tencent.mm.memory.a.c(32);
    private View OwX;
    private b OwY;
    private a OwZ = new a();
    private ProgressBar krF;
    private RecyclerView mRecyclerView;
    private LinkedList<d> pYH;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AllRemindMsgUI() {
        AppMethodBeat.i(32953);
        AppMethodBeat.o(32953);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(32954);
        super.onCreate(bundle);
        bg.azz().a(866, this.OwZ);
        bg.azz().a(525, this);
        h.INSTANCE.idkeyStat(795, 3, 1, false);
        initView();
        ThreadPool.post(new a(), "load remind data!");
        AppMethodBeat.o(32954);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(32955);
        super.onDestroy();
        bg.azz().b(866, this.OwZ);
        bg.azz().b(525, this);
        AppMethodBeat.o(32955);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(32956);
        setMMTitle(R.string.g1f);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.lv);
        this.krF = (ProgressBar) findViewById(R.id.gl_);
        this.OwX = findViewById(R.id.dpi);
        this.mRecyclerView.setVisibility(8);
        RecyclerView recyclerView = this.mRecyclerView;
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.OwY = new b();
        this.mRecyclerView.setAdapter(this.OwY);
        this.OwY.a(new RecyclerView.c() {
            /* class com.tencent.mm.ui.AllRemindMsgUI.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.c
            public final void onChanged() {
                AppMethodBeat.i(32936);
                super.onChanged();
                Log.i("MicroMsg.emoji.AllRemindMsgUI", "[onChanged] size:%s", Integer.valueOf(AllRemindMsgUI.this.OwY.getItemCount()));
                if (AllRemindMsgUI.this.OwY.getItemCount() == 0) {
                    AllRemindMsgUI.this.OwX.setVisibility(0);
                    AllRemindMsgUI.this.mRecyclerView.setVisibility(8);
                    AppMethodBeat.o(32936);
                    return;
                }
                AllRemindMsgUI.this.OwX.setVisibility(8);
                AllRemindMsgUI.this.mRecyclerView.setVisibility(0);
                AppMethodBeat.o(32936);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.AllRemindMsgUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(32937);
                AllRemindMsgUI.this.onBackPressed();
                AppMethodBeat.o(32937);
                return true;
            }
        });
        AppMethodBeat.o(32956);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(32957);
        finish();
        AppMethodBeat.o(32957);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cp;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(32958);
        Log.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 != 0 || i3 != 0) {
            Toast.makeText(getContext(), Util.nullAs(str, getString(R.string.fh8)), 0).show();
            AppMethodBeat.o(32958);
        } else if (qVar.getType() != 525) {
            AppMethodBeat.o(32958);
        } else {
            dwg dwg = (dwg) ((z) qVar).iUB.iLK.iLR;
            ListIterator<d> listIterator = this.pYH.listIterator();
            while (listIterator.hasNext()) {
                if (listIterator.next().Oxi == dwg.MWJ.MQb) {
                    listIterator.remove();
                }
            }
            this.OwY.atj.notifyChanged();
            AppMethodBeat.o(32958);
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends RecyclerView.a {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(32942);
            c cVar = new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bmk, viewGroup, false));
            AppMethodBeat.o(32942);
            return cVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(32943);
            d dVar = (d) AllRemindMsgUI.this.pYH.get(i2);
            ((c) vVar).aus.setTag(dVar);
            ((c) vVar).pIN.setText(l.b(AllRemindMsgUI.this.getContext(), dVar.nickname, ((c) vVar).pIN.getTextSize()));
            ((c) vVar).titleTv.setText(l.b(AllRemindMsgUI.this.getContext(), dVar.title, ((c) vVar).titleTv.getTextSize()));
            long currentTimeMillis = System.currentTimeMillis();
            if (dVar.timestamp - currentTimeMillis < Util.MILLSECONDS_OF_MINUTE) {
                ((c) vVar).Oxd.setText(AllRemindMsgUI.this.getContext().getString(R.string.des, new Object[]{1}));
            } else if (dVar.timestamp - currentTimeMillis < Util.MILLSECONDS_OF_HOUR) {
                ((c) vVar).Oxd.setText(AllRemindMsgUI.this.getContext().getString(R.string.des, new Object[]{Long.valueOf((dVar.timestamp - currentTimeMillis) / Util.MILLSECONDS_OF_MINUTE)}));
            } else if (dVar.timestamp - currentTimeMillis < 10800000) {
                ((c) vVar).Oxd.setText(AllRemindMsgUI.this.getContext().getString(R.string.der, new Object[]{Long.valueOf((dVar.timestamp - currentTimeMillis) / Util.MILLSECONDS_OF_HOUR), Long.valueOf(((dVar.timestamp - currentTimeMillis) - (((dVar.timestamp - currentTimeMillis) / Util.MILLSECONDS_OF_HOUR) * Util.MILLSECONDS_OF_HOUR)) / Util.MILLSECONDS_OF_MINUTE)}));
            } else {
                ((c) vVar).Oxd.setText(com.tencent.mm.pluginsdk.i.f.c(AllRemindMsgUI.this.getContext(), dVar.timestamp, true));
            }
            if (dVar.subType == 2) {
                ((c) vVar).keC.setImageDrawable(AllRemindMsgUI.this.getContext().getResources().getDrawable(R.drawable.bxb));
                AppMethodBeat.o(32943);
                return;
            }
            a.b.c(((c) vVar).keC, dVar.username);
            AppMethodBeat.o(32943);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(32944);
            if (AllRemindMsgUI.this.pYH == null) {
                AppMethodBeat.o(32944);
                return 0;
            }
            int size = AllRemindMsgUI.this.pYH.size();
            AppMethodBeat.o(32944);
            return size;
        }
    }

    class c extends RecyclerView.v {
        TextView Oxd;
        View aus;
        ImageView keC;
        TextView pIN;
        TextView titleTv;

        public c(View view) {
            super(view);
            AppMethodBeat.i(32950);
            this.aus = view;
            this.titleTv = (TextView) view.findViewById(R.id.ipm);
            this.Oxd = (TextView) view.findViewById(R.id.inr);
            this.pIN = (TextView) view.findViewById(R.id.fzc);
            this.keC = (ImageView) view.findViewById(R.id.wm);
            this.aus.setOnClickListener(new View.OnClickListener(AllRemindMsgUI.this) {
                /* class com.tencent.mm.ui.AllRemindMsgUI.c.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(32945);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/AllRemindMsgUI$RemindHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d dVar = (d) view.getTag();
                    Log.i("MicroMsg.emoji.AllRemindMsgUI", "[onClick] :%s", dVar);
                    c.f(AllRemindMsgUI.this, dVar.username, dVar.msgId);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/AllRemindMsgUI$RemindHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(32945);
                }
            });
            this.aus.setOnTouchListener(new View.OnTouchListener(AllRemindMsgUI.this) {
                /* class com.tencent.mm.ui.AllRemindMsgUI.c.AnonymousClass2 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(32946);
                    view.setTag(R.id.iu_, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
                    AppMethodBeat.o(32946);
                    return false;
                }
            });
            this.aus.setOnLongClickListener(new View.OnLongClickListener(AllRemindMsgUI.this) {
                /* class com.tencent.mm.ui.AllRemindMsgUI.c.AnonymousClass3 */

                public final boolean onLongClick(final View view) {
                    AppMethodBeat.i(32949);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/AllRemindMsgUI$RemindHolder$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(AllRemindMsgUI.this.getContext());
                    int[] iArr = new int[2];
                    if (view.getTag(R.id.iu_) instanceof int[]) {
                        iArr = (int[]) view.getTag(R.id.iu_);
                    }
                    aVar.a(view, new View.OnCreateContextMenuListener() {
                        /* class com.tencent.mm.ui.AllRemindMsgUI.c.AnonymousClass3.AnonymousClass1 */

                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                            AppMethodBeat.i(32947);
                            contextMenu.add(0, 0, 0, AllRemindMsgUI.this.getContext().getString(R.string.b06));
                            AppMethodBeat.o(32947);
                        }
                    }, new o.g() {
                        /* class com.tencent.mm.ui.AllRemindMsgUI.c.AnonymousClass3.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(32948);
                            d dVar = (d) view.getTag();
                            Log.i("MicroMsg.emoji.AllRemindMsgUI", "[onMMMenuItemSelected] delete item:%s", dVar);
                            bg.azz().a(new z(2, dVar.Oxh), 0);
                            AppMethodBeat.o(32948);
                        }
                    }, iArr[0], iArr[1]);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/AllRemindMsgUI$RemindHolder$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(32949);
                    return true;
                }
            });
            AppMethodBeat.o(32950);
        }

        static /* synthetic */ void f(Context context, String str, long j2) {
            AppMethodBeat.i(32951);
            if (str == null) {
                Log.e("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] username is null");
                AppMethodBeat.o(32951);
                return;
            }
            bg.aVF();
            long j3 = com.tencent.mm.model.c.aSQ().aJ(str, j2).field_msgId;
            Log.i("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] msgLocalId:%s", Long.valueOf(j3));
            if (str.contains("@")) {
                bg.aVF();
                if (com.tencent.mm.model.c.aSX().Kd(str) == null) {
                    Log.w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] member is null! username:%s", str);
                    com.tencent.mm.ui.base.h.d(context, context.getString(R.string.g1b), context.getString(R.string.hoz), null);
                    AppMethodBeat.o(32951);
                    return;
                }
            } else {
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
                if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                    if (Kn == null) {
                        Log.w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] contact is null! username:%s", str);
                    } else {
                        Log.w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] isContact not ! username:%s", str);
                    }
                    com.tencent.mm.ui.base.h.d(context, context.getString(R.string.g1b), context.getString(R.string.hoz), null);
                    AppMethodBeat.o(32951);
                    return;
                }
            }
            Intent putExtra = new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", j3);
            putExtra.setClass(context, ChattingUI.class);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(putExtra);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/AllRemindMsgUI$RemindHolder", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/AllRemindMsgUI$RemindHolder", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(32951);
        }
    }

    /* access modifiers changed from: package-private */
    public class d {
        String Gah;
        dmn Oxh;
        String Oxi;
        long msgId;
        String nickname;
        int sourceType;
        int subType;
        long timestamp;
        String title;
        String username;

        d() {
        }

        public final String toString() {
            AppMethodBeat.i(32952);
            String str = "RemindItem{username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", title='" + Util.secPrint(this.title) + '\'' + ", timestamp=" + this.timestamp + ", subType=" + this.subType + ", msgId=" + this.msgId + ", sourceType=" + this.sourceType + ", sourceId='" + this.Gah + '\'' + '}';
            AppMethodBeat.o(32952);
            return str;
        }
    }

    class a implements i, Runnable {
        a() {
        }

        public final void run() {
            AppMethodBeat.i(32940);
            bg.azz().a(new com.tencent.mm.modelsimple.q(), 0);
            AppMethodBeat.o(32940);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, final q qVar) {
            AppMethodBeat.i(32941);
            Log.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (i2 != 0 || i3 != 0) {
                Log.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                AllRemindMsgUI.this.mRecyclerView.setVisibility(0);
                AllRemindMsgUI.this.krF.setVisibility(8);
                AppMethodBeat.o(32941);
            } else if (qVar.getType() != 866) {
                AppMethodBeat.o(32941);
            } else {
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.ui.AllRemindMsgUI.a.AnonymousClass1 */

                    public final void run() {
                        String str;
                        String str2;
                        AppMethodBeat.i(32939);
                        LinkedList<dmn> linkedList = ((bul) ((com.tencent.mm.modelsimple.q) qVar).iUB.iLL.iLR).MaU;
                        LinkedList linkedList2 = new LinkedList();
                        if (linkedList != null) {
                            for (dmn dmn : linkedList) {
                                d dVar = new d();
                                dVar.Oxh = dmn;
                                dVar.timestamp = ((long) dmn.rBX) * 1000;
                                dVar.subType = dmn.MJT;
                                dVar.Oxi = dmn.MQb;
                                if (dmn.MJT == 1) {
                                    crk crk = new crk();
                                    try {
                                        crk.parseFrom(dmn.Lqr.zy);
                                    } catch (IOException e2) {
                                        Log.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", e2.toString());
                                    }
                                    dVar.title = crk.Title;
                                    dVar.username = crk.UserName;
                                    dVar.msgId = crk.Brn;
                                    if (dVar.username != null) {
                                        if (ab.Eq(dVar.username)) {
                                            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(dVar.username);
                                            if (Kn != null) {
                                                if (Util.isNullOrNil(Kn.field_conRemark)) {
                                                    str2 = Kn.field_nickname;
                                                } else {
                                                    str2 = Kn.field_conRemark;
                                                }
                                                dVar.nickname = str2;
                                            }
                                            if (Util.isNullOrNil(dVar.nickname)) {
                                                str = AllRemindMsgUI.this.getString(R.string.b25);
                                            } else {
                                                str = dVar.nickname;
                                            }
                                            dVar.nickname = str;
                                        } else {
                                            as Kn2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(dVar.username);
                                            dVar.nickname = Kn2.arJ() == null ? Kn2.arI() : Kn2.arJ();
                                        }
                                    }
                                } else if (dmn.MJT == 2) {
                                    anc anc = new anc();
                                    try {
                                        anc.parseFrom(dmn.Lqr.zy);
                                    } catch (IOException e3) {
                                        Log.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", e3.toString());
                                    }
                                    dVar.title = anc.Title;
                                    dVar.sourceType = anc.KHd;
                                    dVar.Gah = anc.KHe;
                                }
                                Log.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] getRemind:%s", dVar);
                                linkedList2.add(dVar);
                            }
                            AllRemindMsgUI.this.pYH = linkedList2;
                        }
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.ui.AllRemindMsgUI.a.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(32938);
                                AllRemindMsgUI.this.mRecyclerView.setVisibility(0);
                                AllRemindMsgUI.this.krF.setVisibility(8);
                                AllRemindMsgUI.this.OwY.atj.notifyChanged();
                                AppMethodBeat.o(32938);
                            }
                        });
                        AppMethodBeat.o(32939);
                    }
                }, "MicroMsg.emoji.AllRemindMsgUI[onSceneEnd]");
                AppMethodBeat.o(32941);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static String a(Context context, int i2, String str, int i3) {
        AppMethodBeat.i(32959);
        String str2 = "";
        k.b HD = k.b.HD(str);
        switch (i2) {
            case -1879048186:
                str2 = context.getString(R.string.fwp, "");
                break;
            case -1879048185:
            case -1879048183:
            case -1879048176:
                str2 = context.getString(R.string.fvh, "");
                break;
            case 1:
                str2 = context.getString(R.string.z_);
                break;
            case 3:
            case 23:
            case 33:
                str2 = context.getString(R.string.xr);
                break;
            case 34:
                str2 = context.getString(R.string.fx7, Integer.valueOf((int) s.AO(new p(str).time)));
                break;
            case 37:
                if (str != null && str.length() > 0) {
                    ca.d bkD = ca.d.bkD(str);
                    if (bkD.dkU != null && bkD.dkU.length() > 0) {
                        switch (bkD.scene) {
                            case 18:
                                str2 = context.getString(R.string.dg2, bkD.getDisplayName());
                                break;
                            case 19:
                            case 20:
                            case 21:
                            default:
                                str2 = context.getString(R.string.dgk, bkD.getDisplayName());
                                break;
                            case 22:
                            case 23:
                            case 24:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                                str2 = context.getString(R.string.dgb, bkD.getDisplayName());
                                break;
                            case 25:
                                str2 = context.getString(R.string.de6, bkD.getDisplayName());
                                break;
                        }
                    }
                }
            case 42:
            case 66:
                str2 = context.getString(R.string.vp);
                break;
            case 43:
            case 62:
                str2 = context.getString(62 == i2 ? R.string.z1 : R.string.zv);
                break;
            case 47:
                str2 = context.getString(R.string.tu);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                bg.aVF();
                com.tencent.mm.model.c.aSQ().aEL(str);
                str2 = context.getString(R.string.fwb, "");
                break;
            case 49:
            case 553648177:
            case 587202609:
                if (HD != null) {
                    switch (HD.type) {
                        case 2:
                            str2 = context.getString(R.string.xr);
                            break;
                        case 3:
                            str2 = context.getString(R.string.fwh, "");
                            break;
                        case 4:
                            str2 = context.getString(R.string.fx3, "");
                            break;
                        case 5:
                        case 7:
                            str2 = context.getString(R.string.fx2, "");
                            break;
                        case 6:
                            str2 = context.getString(R.string.fvu, HD.title);
                            break;
                        case 8:
                            str2 = context.getString(R.string.tv);
                            break;
                        case 15:
                        case 26:
                        case 27:
                            str2 = context.getString(R.string.tu);
                            break;
                        case 17:
                            str2 = context.getString(R.string.fwb, "");
                            break;
                        case 19:
                            str2 = context.getString(R.string.fwj, "");
                            break;
                        case 24:
                            str2 = context.getString(R.string.fwi, "");
                            break;
                        case 25:
                            str2 = context.getString(R.string.ti);
                            break;
                        case 33:
                            str2 = context.getString(R.string.jz);
                            break;
                        case 44:
                            if (!Util.isNullOrNil(HD.w(context, true))) {
                                str2 = HD.w(context, true) + " " + HD.title;
                                break;
                            }
                            str2 = context.getString(R.string.fdz);
                            break;
                        default:
                            Log.i("MicroMsg.emoji.AllRemindMsgUI", "default type:%s", Integer.valueOf(HD.type));
                            str2 = context.getString(R.string.fdz);
                            break;
                    }
                } else {
                    Log.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                    AppMethodBeat.o(32959);
                    return "";
                }
            case 369098801:
            case 452984881:
                str2 = context.getString(R.string.fvp, "");
                break;
            case 419430449:
                str2 = context.getString(R.string.fwk);
                break;
            case 436207665:
            case 469762097:
                if (HD != null) {
                    if (i3 != 1) {
                        str2 = context.getString(R.string.fvo, HD.iyo, "");
                        break;
                    } else {
                        str2 = context.getString(R.string.fvo, HD.iyo, "");
                        break;
                    }
                } else {
                    Log.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                    AppMethodBeat.o(32959);
                    return "";
                }
            case 503316529:
                if (HD != null) {
                    str2 = context.getString(R.string.fvo, HD.iyo, "");
                    break;
                } else {
                    Log.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                    AppMethodBeat.o(32959);
                    return "";
                }
            case 520093745:
                str2 = context.getString(R.string.fvp, "");
                break;
            case 805306417:
            case 822083633:
                str2 = context.getString(R.string.z_);
                break;
            default:
                str2 = context.getString(R.string.fdz);
                break;
        }
        AppMethodBeat.o(32959);
        return str2;
    }

    static {
        AppMethodBeat.i(32960);
        AppMethodBeat.o(32960);
    }
}
