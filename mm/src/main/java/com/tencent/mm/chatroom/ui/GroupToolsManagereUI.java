package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.a.a;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.chatroom.d.ab;
import com.tencent.mm.chatroom.d.s;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.protocal.protobuf.dqc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GroupToolsManagereUI extends MMActivity implements i {
    private LinkedList<GroupToolItem> gtx = new LinkedList<>();
    private LinearLayout gvA;
    private RecyclerView gvB;
    private LinearLayoutManager gvC;
    private e gvD;
    private android.support.v7.widget.a.a gvE;
    private f gvF;
    private LinearLayoutManager gvG;
    private e gvH;
    private com.tencent.mm.chatroom.storage.e gvI = null;
    private String gvJ;
    private boolean gvK = false;
    private int gvL = 0;
    private c gvM = new c() {
        /* class com.tencent.mm.chatroom.ui.GroupToolsManagereUI.AnonymousClass1 */

        @Override // com.tencent.mm.chatroom.ui.GroupToolsManagereUI.c
        public final void K(View view, int i2) {
            AppMethodBeat.i(184789);
            Object tag = view.getTag();
            if (tag instanceof GroupToolItem) {
                boolean booleanValue = ((Boolean) ((ViewGroup) view.getParent()).getTag()).booleanValue();
                GroupToolItem groupToolItem = (GroupToolItem) tag;
                Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "iRecentUseToolsCallback click stick:%s", Boolean.valueOf(booleanValue));
                if (booleanValue) {
                    groupToolItem.crj = cl.aWz();
                    GroupToolsManagereUI.this.gvI.gtw.remove(groupToolItem);
                    GroupToolsManagereUI.this.gtx.addFirst(groupToolItem);
                    GroupToolsManagereUI.this.gvD.ck(i2);
                    GroupToolsManagereUI.this.gvH.cj(0);
                } else if (GroupToolsManagereUI.this.gvI.amo()) {
                    h.a((Context) GroupToolsManagereUI.this, GroupToolsManagereUI.this.getString(R.string.avs), "", GroupToolsManagereUI.this.getString(R.string.w0), false, (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(184789);
                    return;
                } else {
                    GroupToolsManagereUI.this.gvI.gtw.addLast(groupToolItem);
                    GroupToolsManagereUI.this.gtx.remove(groupToolItem);
                    GroupToolsManagereUI.this.gvD.cj(GroupToolsManagereUI.this.gvI.gtw.size() - 1);
                    GroupToolsManagereUI.this.gvH.ck(i2);
                }
                if (booleanValue && !GroupToolsManagereUI.this.gvI.amo()) {
                    GroupToolsManagereUI.this.gvH.gwa = true;
                    GroupToolsManagereUI.this.gvH.atj.notifyChanged();
                } else if (!booleanValue && GroupToolsManagereUI.this.gvI.amo()) {
                    GroupToolsManagereUI.this.gvH.gwa = false;
                    GroupToolsManagereUI.this.gvH.atj.notifyChanged();
                }
                GroupToolsManagereUI.this.gvK = true;
                GroupToolsManagereUI.f(GroupToolsManagereUI.this);
                GroupToolsManagereUI.g(GroupToolsManagereUI.this);
                AppMethodBeat.o(184789);
                return;
            }
            Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "iRecentUseToolsCallback click");
            AppMethodBeat.o(184789);
        }

        @Override // com.tencent.mm.chatroom.ui.GroupToolsManagereUI.c
        public final void O(RecyclerView.v vVar) {
            AppMethodBeat.i(182168);
            android.support.v7.widget.a.a aVar = GroupToolsManagereUI.this.gvE;
            if (aVar.aAp.c(aVar.mRecyclerView, vVar) && vVar.aus.getParent() == aVar.mRecyclerView) {
                aVar.no();
                aVar.aAm = 0.0f;
                aVar.aAl = 0.0f;
                aVar.e(vVar, 2);
            }
            AppMethodBeat.o(182168);
        }
    };
    private LinearLayout gvy;
    private RecyclerView gvz;
    private q tipDialog = null;

    public interface b {
        void amL();
    }

    public interface c {
        void K(View view, int i2);

        void O(RecyclerView.v vVar);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GroupToolsManagereUI() {
        AppMethodBeat.i(182194);
        AppMethodBeat.o(182194);
    }

    static /* synthetic */ void f(GroupToolsManagereUI groupToolsManagereUI) {
        AppMethodBeat.i(182203);
        groupToolsManagereUI.amJ();
        AppMethodBeat.o(182203);
    }

    static /* synthetic */ void g(GroupToolsManagereUI groupToolsManagereUI) {
        AppMethodBeat.i(182204);
        groupToolsManagereUI.amK();
        AppMethodBeat.o(182204);
    }

    static /* synthetic */ boolean i(GroupToolsManagereUI groupToolsManagereUI) {
        AppMethodBeat.i(182205);
        boolean amI = groupToolsManagereUI.amI();
        AppMethodBeat.o(182205);
        return amI;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.pr;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(182195);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(32);
        this.gvJ = getIntent().getStringExtra("key_chatroomname");
        if (Util.isNullOrNil(this.gvJ)) {
            Log.e("MicroMsg.roomtools.GroupToolsManagereUI", "mChatRoomName is null");
            finish();
        } else {
            this.gvI = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().DE(this.gvJ);
            if (this.gvI == null) {
                Log.e("MicroMsg.roomtools.GroupToolsManagereUI", "tools is null");
                finish();
            } else {
                ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_recent_use_tools");
                if (parcelableArrayListExtra == null) {
                    this.gtx = new LinkedList<>();
                } else {
                    this.gtx.addAll(parcelableArrayListExtra);
                }
                Iterator<GroupToolItem> it = this.gvI.gtw.iterator();
                while (it.hasNext()) {
                    GroupToolItem next = it.next();
                    if (this.gtx.contains(next)) {
                        this.gtx.remove(next);
                    }
                }
                this.gvL = this.gvI.gtw.size();
                Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "mChatRoomName is %s, recentUseToolItemList:%s", this.gvJ, Integer.valueOf(this.gtx.size()));
            }
        }
        initView();
        g.azz().a(3546, this);
        AppMethodBeat.o(182195);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(182196);
        Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(qVar.getType()));
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "onSceneEnd result:%s", Boolean.valueOf(((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(this.gvI, new String[0])));
            ab.b(this.gvJ, 3, this.gvL, this.gvI.gtw.size());
            finish();
            AppMethodBeat.o(182196);
            return;
        }
        AppCompatActivity context = getContext();
        if (Util.isNullOrNil(str)) {
            str = getString(R.string.hu4);
        }
        u.makeText(context, str, 0).show();
        AppMethodBeat.o(182196);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(182197);
        super.initView();
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.f3045c));
        setBackGroundColorResource(R.color.f3045c);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.GroupToolsManagereUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(182169);
                GroupToolsManagereUI.i(GroupToolsManagereUI.this);
                AppMethodBeat.o(182169);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.avm), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.GroupToolsManagereUI.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(182173);
                Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "menu click");
                com.tencent.mm.chatroom.storage.e eVar = GroupToolsManagereUI.this.gvI;
                eVar.field_stickToollist = com.tencent.mm.chatroom.storage.e.W(eVar.gtw);
                GroupToolsManagereUI.l(GroupToolsManagereUI.this);
                AppMethodBeat.o(182173);
                return true;
            }
        }, null, t.b.GREEN);
        amJ();
        this.gvy = (LinearLayout) findViewById(R.id.f_n);
        this.gvz = (RecyclerView) findViewById(R.id.f_o);
        this.gvA = (LinearLayout) findViewById(R.id.f_l);
        this.gvB = (RecyclerView) findViewById(R.id.f_m);
        this.gvF = new f(getContext());
        this.gvC = new LinearLayoutManager();
        this.gvz.setLayoutManager(this.gvC);
        this.gvz.a(this.gvF);
        this.gvD = new e(getContext(), true, this.gvI.gtw, this.gvM);
        this.gvz.setAdapter(this.gvD);
        this.gvD.atj.notifyChanged();
        this.gvG = new LinearLayoutManager();
        this.gvB.setLayoutManager(this.gvG);
        this.gvB.a(this.gvF);
        this.gvH = new e(getContext(), false, this.gtx, this.gvM);
        if (this.gvI.amo()) {
            this.gvH.gwa = false;
        }
        this.gvB.setAdapter(this.gvH);
        this.gvH.atj.notifyChanged();
        amK();
        this.gvE = new android.support.v7.widget.a.a(new a(this.gvI.gtw, new b() {
            /* class com.tencent.mm.chatroom.ui.GroupToolsManagereUI.AnonymousClass3 */

            @Override // com.tencent.mm.chatroom.ui.GroupToolsManagereUI.b
            public final void amL() {
                AppMethodBeat.i(182170);
                GroupToolsManagereUI.this.gvK = true;
                GroupToolsManagereUI.f(GroupToolsManagereUI.this);
                AppMethodBeat.o(182170);
            }
        }));
        this.gvE.f(this.gvz);
        AppMethodBeat.o(182197);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(182198);
        if (i2 == 4) {
            amI();
            AppMethodBeat.o(182198);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(182198);
        return onKeyUp;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(182199);
        g.azz().b(3546, this);
        super.onDestroy();
        AppMethodBeat.o(182199);
    }

    private boolean amI() {
        AppMethodBeat.i(182200);
        if (this.gvK) {
            h.a((Context) this, getString(R.string.avj), "", getString(R.string.avl), getString(R.string.avk), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.chatroom.ui.GroupToolsManagereUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(182171);
                    Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "back_dialot ok");
                    ab.b(GroupToolsManagereUI.this.gvJ, 2, GroupToolsManagereUI.this.gvL, GroupToolsManagereUI.this.gvI.gtw.size());
                    GroupToolsManagereUI.this.finish();
                    AppMethodBeat.o(182171);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.chatroom.ui.GroupToolsManagereUI.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(182172);
                    Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "back_dialot cancel");
                    AppMethodBeat.o(182172);
                }
            });
        } else {
            ab.b(this.gvJ, 1, this.gvL, this.gvI.gtw.size());
            finish();
        }
        AppMethodBeat.o(182200);
        return true;
    }

    private void amJ() {
        AppMethodBeat.i(182201);
        if (this.gvK) {
            enableOptionMenu(0, true);
            AppMethodBeat.o(182201);
            return;
        }
        enableOptionMenu(0, false);
        AppMethodBeat.o(182201);
    }

    private void amK() {
        AppMethodBeat.i(182202);
        if (this.gvI.gtw.size() > 0) {
            this.gvy.setVisibility(0);
        } else {
            this.gvy.setVisibility(8);
        }
        if (this.gtx.size() > 0) {
            this.gvA.setVisibility(0);
            AppMethodBeat.o(182202);
            return;
        }
        this.gvA.setVisibility(8);
        AppMethodBeat.o(182202);
    }

    public static class e extends RecyclerView.a {
        private Context context;
        private boolean gvZ;
        boolean gwa = true;
        private List<GroupToolItem> gwb;
        private c gwc;

        static /* synthetic */ void b(d dVar, WxaAttributes wxaAttributes) {
            AppMethodBeat.i(184790);
            a(dVar, wxaAttributes);
            AppMethodBeat.o(184790);
        }

        public e(Context context2, boolean z, List<GroupToolItem> list, c cVar) {
            this.context = context2;
            this.gvZ = z;
            this.gwb = list;
            this.gwc = cVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(182186);
            d dVar = new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ps, viewGroup, false));
            AppMethodBeat.o(182186);
            return dVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(182187);
            if (this.gwb != null && i2 >= 0 && i2 < this.gwb.size()) {
                final d dVar = (d) vVar;
                GroupToolItem groupToolItem = this.gwb.get(i2);
                Log.d("MicroMsg.roomtools.GroupToolsManagereUI", "onBindViewHolder() i:%s", Integer.valueOf(i2));
                dVar.gvQ.setVisibility(0);
                if (this.gvZ) {
                    dVar.gvS.setVisibility(8);
                    dVar.gvT.setVisibility(0);
                    dVar.gvW.setVisibility(0);
                } else {
                    dVar.gvS.setVisibility(0);
                    dVar.gvT.setVisibility(8);
                    dVar.gvW.setVisibility(4);
                }
                if (groupToolItem.amm()) {
                    dVar.gvU.setImageResource(R.drawable.bg2);
                    dVar.gvV.setText(R.string.avr);
                } else if (groupToolItem.amn()) {
                    dVar.gvU.setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.drawable.bg3));
                    dVar.gvV.setText(R.string.uj);
                } else {
                    WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(groupToolItem.username);
                    if (Xk == null) {
                        ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).a(groupToolItem.username, new q.a() {
                            /* class com.tencent.mm.chatroom.ui.GroupToolsManagereUI.e.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.appbrand.service.q.a
                            public final void b(final WxaAttributes wxaAttributes) {
                                AppMethodBeat.i(182183);
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.chatroom.ui.GroupToolsManagereUI.e.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(182182);
                                        e.b(dVar, wxaAttributes);
                                        AppMethodBeat.o(182182);
                                    }
                                });
                                AppMethodBeat.o(182183);
                            }
                        });
                    } else {
                        a(dVar, Xk);
                    }
                }
                if (this.gwa) {
                    dVar.gvQ.setAlpha(1.0f);
                } else {
                    dVar.gvQ.setAlpha(0.3f);
                }
                ((ViewGroup) dVar.gvR.getParent()).setTag(Boolean.valueOf(this.gvZ));
                dVar.gvR.setTag(groupToolItem);
                dVar.gvR.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.chatroom.ui.GroupToolsManagereUI.e.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(182184);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (e.this.gwc != null) {
                            e.this.gwc.K(view, dVar.lR());
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(182184);
                    }
                });
                if (this.gvZ) {
                    dVar.gvW.setOnLongClickListener(new View.OnLongClickListener() {
                        /* class com.tencent.mm.chatroom.ui.GroupToolsManagereUI.e.AnonymousClass3 */

                        public final boolean onLongClick(View view) {
                            AppMethodBeat.i(182185);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                            e.this.gwc.O(dVar);
                            dVar.gvW.performHapticFeedback(0, 2);
                            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                            AppMethodBeat.o(182185);
                            return true;
                        }
                    });
                    AppMethodBeat.o(182187);
                    return;
                }
                dVar.gvW.setOnLongClickListener(null);
            }
            AppMethodBeat.o(182187);
        }

        private static void a(d dVar, WxaAttributes wxaAttributes) {
            AppMethodBeat.i(182188);
            com.tencent.mm.av.q.bcV().a(wxaAttributes != null ? wxaAttributes.field_smallHeadURL : "", dVar.gvU, d.gvY);
            dVar.gvV.setText(wxaAttributes != null ? wxaAttributes.field_nickname : "");
            AppMethodBeat.o(182188);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            return 0;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(182189);
            int size = this.gwb.size();
            AppMethodBeat.o(182189);
            return size;
        }
    }

    public static class d extends RecyclerView.v {
        static final com.tencent.mm.av.a.a.c gvY;
        View gvQ;
        RelativeLayout gvR;
        ImageView gvS;
        ImageView gvT;
        ImageView gvU;
        TextView gvV;
        RelativeLayout gvW;
        ImageView gvX;

        static {
            AppMethodBeat.i(182181);
            c.a aVar = new c.a();
            aVar.jbq = R.raw.app_brand_app_default_icon_for_tail;
            c.a dr = aVar.dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20));
            dr.iaT = true;
            dr.jbf = true;
            dr.jbd = true;
            gvY = aVar.bdv();
            AppMethodBeat.o(182181);
        }

        public d(View view) {
            super(view);
            AppMethodBeat.i(182180);
            this.gvQ = view;
            this.gvR = (RelativeLayout) view.findViewById(R.id.is5);
            this.gvS = (ImageView) view.findViewById(R.id.iry);
            this.gvT = (ImageView) view.findViewById(R.id.is1);
            this.gvU = (ImageView) view.findViewById(R.id.rq);
            this.gvV = (TextView) view.findViewById(R.id.is7);
            this.gvW = (RelativeLayout) view.findViewById(R.id.is3);
            this.gvX = (ImageView) view.findViewById(R.id.is2);
            AppMethodBeat.o(182180);
        }
    }

    public static class f extends RecyclerView.h {
        private int dividerHeight;
        private Paint gwh = new Paint();

        public f(Context context) {
            AppMethodBeat.i(182191);
            this.dividerHeight = com.tencent.mm.cb.a.fromDPToPix(context, 8);
            this.gwh.setColor(context.getResources().getColor(R.color.f3045c));
            AppMethodBeat.o(182191);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(182192);
            super.a(canvas, recyclerView, sVar);
            int childCount = recyclerView.getChildCount();
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                canvas.drawRect((float) paddingLeft, (float) childAt.getBottom(), (float) width, (float) (childAt.getBottom() + this.dividerHeight), this.gwh);
            }
            AppMethodBeat.o(182192);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(182193);
            super.a(rect, view, recyclerView, sVar);
            rect.bottom = this.dividerHeight;
            AppMethodBeat.o(182193);
        }
    }

    public static class a extends a.AbstractC0053a {
        private List bXV;
        private boolean dAd = false;
        private b gvO;
        private boolean gvP = true;

        public a(List list, b bVar) {
            this.bXV = list;
            this.gvO = bVar;
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final int a(RecyclerView recyclerView, RecyclerView.v vVar) {
            AppMethodBeat.i(182175);
            int db = db(3);
            AppMethodBeat.o(182175);
            return db;
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final boolean a(RecyclerView recyclerView, RecyclerView.v vVar, RecyclerView.v vVar2) {
            AppMethodBeat.i(182176);
            int lR = vVar.lR();
            int lR2 = vVar2.lR();
            Log.d("MicroMsg.roomtools.GroupToolsManagereUI", "onMove fromIndex:%s toIndex:%s", Integer.valueOf(lR), Integer.valueOf(lR2));
            if (lR < lR2) {
                for (int i2 = lR; i2 < lR2; i2++) {
                    Collections.swap(this.bXV, i2, i2 + 1);
                }
            } else {
                for (int i3 = lR; i3 > lR2; i3--) {
                    Collections.swap(this.bXV, i3, i3 - 1);
                }
            }
            recyclerView.getAdapter().ar(lR, lR2);
            if (this.gvO != null) {
                this.gvO.amL();
            }
            vVar.aus.performHapticFeedback(0, 2);
            AppMethodBeat.o(182176);
            return true;
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final void N(RecyclerView.v vVar) {
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final void f(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(182177);
            super.f(vVar, i2);
            AppMethodBeat.o(182177);
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final void d(RecyclerView recyclerView, RecyclerView.v vVar) {
            AppMethodBeat.i(182178);
            super.d(recyclerView, vVar);
            this.dAd = true;
            AppMethodBeat.o(182178);
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.v vVar, float f2, float f3, int i2, boolean z) {
            AppMethodBeat.i(182179);
            if (this.gvP) {
                ViewPropertyAnimator animate = vVar.aus.animate();
                if (Build.VERSION.SDK_INT >= 21) {
                    vVar.aus.setTranslationZ(20.0f);
                    animate.start();
                }
                this.gvP = false;
            }
            if (this.dAd) {
                ViewPropertyAnimator animate2 = vVar.aus.animate();
                if (Build.VERSION.SDK_INT >= 21) {
                    vVar.aus.setTranslationZ(0.0f);
                    animate2.start();
                }
                this.dAd = false;
                this.gvP = true;
            }
            super.a(canvas, recyclerView, vVar, f2, f3, i2, z);
            AppMethodBeat.o(182179);
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final boolean nq() {
            return false;
        }
    }

    static /* synthetic */ void l(GroupToolsManagereUI groupToolsManagereUI) {
        AppMethodBeat.i(184791);
        Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "doAlterWxApp()");
        LinkedList linkedList = new LinkedList();
        if (groupToolsManagereUI.gvI.gtw.size() > 0) {
            Iterator<GroupToolItem> it = groupToolsManagereUI.gvI.gtw.iterator();
            while (it.hasNext()) {
                dqc dqc = new dqc();
                dqc.Username = it.next().username;
                dqc.xut = "";
                linkedList.add(dqc);
            }
        }
        final s sVar = new s(groupToolsManagereUI.gvJ, linkedList);
        g.azz().a(sVar, 0);
        if (groupToolsManagereUI.tipDialog == null) {
            groupToolsManagereUI.getString(R.string.zb);
            groupToolsManagereUI.tipDialog = h.a((Context) groupToolsManagereUI, groupToolsManagereUI.getString(R.string.wc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.chatroom.ui.GroupToolsManagereUI.AnonymousClass7 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(182174);
                    Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "dialog onCancel scene:%s", Integer.valueOf(sVar.getType()));
                    g.azz().a(sVar);
                    AppMethodBeat.o(182174);
                }
            });
            AppMethodBeat.o(184791);
            return;
        }
        if (!groupToolsManagereUI.tipDialog.isShowing()) {
            groupToolsManagereUI.tipDialog.show();
        }
        AppMethodBeat.o(184791);
    }
}
