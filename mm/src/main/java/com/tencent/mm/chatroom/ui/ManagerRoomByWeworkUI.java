package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.chatroom.d.k;
import com.tencent.mm.chatroom.d.w;
import com.tencent.mm.g.b.a.et;
import com.tencent.mm.g.b.a.ev;
import com.tencent.mm.g.b.a.ew;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bik;
import com.tencent.mm.protocal.protobuf.emv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ManagerRoomByWeworkUI extends MMActivity implements i {
    private int gwE;
    private String gwF;
    private List<String> gwG = new ArrayList();
    private List<as> gwH = new ArrayList();
    private List<String> gwI = new ArrayList();
    private HashMap<String, Boolean> gwJ = new HashMap<>();
    private HashMap<String, Boolean> gwK = new HashMap<>();
    private int gwL = 0;
    private int gwM = 0;
    private int gwN = 0;
    public Button gwO;
    public Button gwP;
    private CdnImageView gwQ;
    public TextView gwR;
    public TextView gwS;
    public LinearLayout gwT;
    private LinearLayout gwU;
    private LinearLayout gwV;
    private RecyclerView gwW;
    private LinearLayout gwX;
    private TextView gwY;
    private ImageView gwZ;
    private String gwx;
    private LinearLayoutManager gxa;
    private a gxb;
    private b gxc;
    private int gxd = 0;
    private int gxe = 0;
    private q tipDialog = null;
    public TextView titleTv;

    public interface c {
        void amQ();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ManagerRoomByWeworkUI() {
        AppMethodBeat.i(194151);
        AppMethodBeat.o(194151);
    }

    static /* synthetic */ void h(ManagerRoomByWeworkUI managerRoomByWeworkUI) {
        AppMethodBeat.i(194163);
        managerRoomByWeworkUI.amP();
        AppMethodBeat.o(194163);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        k kVar;
        boolean z2 = true;
        AppMethodBeat.i(182212);
        super.onCreate(bundle);
        setMMTitle("");
        this.gwx = getIntent().getStringExtra("RoomInfo_Id");
        this.gwE = getIntent().getIntExtra("upgrade_openim_room_from_scene", 0);
        this.gwF = getIntent().getStringExtra("ticket");
        Log.i("MicroMsg.ManagerRoomByWeworkUI", "mFromScene:%s", Integer.valueOf(this.gwE));
        if (this.gwE == 3) {
            if (Util.isNullOrNil(this.gwF)) {
                Log.e("MicroMsg.ManagerRoomByWeworkUI", "mTicket is null");
                finish();
                z = false;
            }
            z = true;
        } else {
            if (Util.isNullOrNil(this.gwx)) {
                Log.e("MicroMsg.ManagerRoomByWeworkUI", "mRoomId is null");
                finish();
                z = false;
            }
            z = true;
        }
        if (!z) {
            AppMethodBeat.o(182212);
            return;
        }
        g.azz().a(3553, this);
        g.azz().a(3927, this);
        Log.i("MicroMsg.ManagerRoomByWeworkUI", "doFetchCollectPubFill() roomId:%s", this.gwx);
        if (this.gwE == 3) {
            kVar = new k(this.gwF, (byte) 0);
        } else {
            kVar = new k(this.gwx);
        }
        g.azz().a(kVar, 0);
        if (this.gwE == 3) {
            z2 = false;
        }
        a(kVar, z2);
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.f3045c));
        setBackGroundColorResource(R.color.f3045c);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(182207);
                Log.i("MicroMsg.ManagerRoomByWeworkUI", "onMenuItemClick click");
                WeworkRoomUpgradeResultUI.cr(ManagerRoomByWeworkUI.this);
                ManagerRoomByWeworkUI.this.finish();
                if (ManagerRoomByWeworkUI.this.gwE != 3) {
                    ManagerRoomByWeworkUI.c(ManagerRoomByWeworkUI.this.gwx, ManagerRoomByWeworkUI.this.gwE, 0, 0);
                } else {
                    ManagerRoomByWeworkUI.this.ok(0);
                }
                AppMethodBeat.o(182207);
                return true;
            }
        });
        AppMethodBeat.o(182212);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.pm;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        emv emv;
        String string;
        boolean z;
        AppMethodBeat.i(182213);
        Log.i("MicroMsg.ManagerRoomByWeworkUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(qVar.getType()));
        if (this.gwE == 3 && !(qVar instanceof k)) {
            try {
                Log.i("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom %s", ((w) qVar).dOe);
            } catch (Exception e2) {
                Log.e("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            }
            this.gwL++;
            if (this.gwL == this.gwM && this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
        } else if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof k) {
                k kVar = (k) qVar;
                bik bik = kVar.gsa == null ? null : kVar.gsa;
                if (bik != null) {
                    super.initView();
                    this.gwO = (Button) findViewById(R.id.j16);
                    this.gwP = (Button) findViewById(R.id.hhw);
                    this.titleTv = (TextView) findViewById(R.id.art);
                    this.gwQ = (CdnImageView) findViewById(R.id.arb);
                    this.gwR = (TextView) findViewById(R.id.arq);
                    this.gwS = (TextView) findViewById(R.id.bfd);
                    this.gwT = (LinearLayout) findViewById(R.id.bf0);
                    this.gwU = (LinearLayout) findViewById(R.id.dll);
                    this.gwV = (LinearLayout) findViewById(R.id.arg);
                    this.gwW = (RecyclerView) findViewById(R.id.ux);
                    this.gwX = (LinearLayout) findViewById(R.id.hhy);
                    this.gwY = (TextView) findViewById(R.id.hhz);
                    this.gwZ = (ImageView) findViewById(R.id.hhx);
                    findViewById(R.id.be8).setVisibility(0);
                    this.gwO.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(194137);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.ManagerRoomByWeworkUI", "click use");
                            if (ManagerRoomByWeworkUI.this.gwE == 3) {
                                ManagerRoomByWeworkUI.c(ManagerRoomByWeworkUI.this);
                            } else {
                                ManagerRoomByWeworkUI.d(ManagerRoomByWeworkUI.this);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(194137);
                        }
                    });
                    if (this.gwE == 1 || this.gwE == 2) {
                        this.gwV.setVisibility(0);
                        this.gwU.setVisibility(8);
                        a(this.gwx, this.gwQ);
                        String str2 = this.gwx;
                        TextView textView = this.gwR;
                        as Kn = ((l) g.af(l.class)).aSN().Kn(str2);
                        if (!Util.isNullOrNil(Kn.field_nickname)) {
                            string = getString(R.string.dea, Kn.arI(), Integer.valueOf(v.Ie(Kn.field_username)));
                        } else if (v.Ie(Kn.field_username) == 0) {
                            string = getString(R.string.ey1);
                        } else {
                            string = getString(R.string.dea, getString(R.string.ey1), Integer.valueOf(v.Ie(Kn.field_username)));
                        }
                        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.d(this, com.tencent.mm.pluginsdk.ui.span.l.e((Context) this, (CharSequence) string, com.tencent.mm.cb.a.aG(this, R.dimen.l))));
                    } else if (this.gwE == 3) {
                        this.gwV.setVisibility(8);
                        this.gwU.setVisibility(0);
                        AnonymousClass3 r1 = new View.OnClickListener() {
                            /* class com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI.AnonymousClass3 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(194138);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Log.i("MicroMsg.ManagerRoomByWeworkUI", "select_group_ll click");
                                ManagerRoomByWeworkUI.this.gxe = 1;
                                if (ManagerRoomByWeworkUI.this.gxb.gxk == 5) {
                                    u.makeText(ManagerRoomByWeworkUI.this, (int) R.string.hu6, 0).show();
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(194138);
                                    return;
                                }
                                Intent intent = new Intent();
                                intent.setClassName(ManagerRoomByWeworkUI.this, "com.tencent.mm.ui.contact.GroupCardSelectUI");
                                intent.putExtra("group_select_type", true);
                                intent.putExtra("group_select_need_result", true);
                                intent.putExtra("group_select_only_need_self_owner", true);
                                ArrayList<String> arrayList = new ArrayList<>();
                                for (as asVar : ManagerRoomByWeworkUI.this.gwH) {
                                    arrayList.add(asVar.field_username);
                                }
                                intent.putStringArrayListExtra("group_select_block_chatroom", arrayList);
                                intent.putExtra("group_select_chatroom_max_num", v.aTT());
                                ManagerRoomByWeworkUI.this.startActivityForResult(intent, 0);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(194138);
                            }
                        };
                        this.gwX.setOnClickListener(r1);
                        this.gwP.setOnClickListener(r1);
                        List<as> aUV = ab.aUV();
                        if (aUV.size() == 0) {
                            z = false;
                        } else {
                            for (as asVar : aUV) {
                                if (ab.ID(asVar.field_username)) {
                                    ah Kd = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(asVar.field_username);
                                    if (Kd == null) {
                                        Log.e("MicroMsg.ManagerRoomByWeworkUI", "initContactList %s member is null", asVar.field_username);
                                    } else if (Kd.field_memberCount < v.aTT() && Util.isEqual(Kd.field_roomowner, z.aTY())) {
                                        this.gwH.add(asVar);
                                        this.gwI.add(asVar.field_username);
                                        this.gwG.add(asVar.field_username);
                                    }
                                }
                            }
                            this.gxd = this.gwH.size();
                            HashMap<String, Long> gCt = ((l) g.af(l.class)).aST().gCt();
                            LinkedList linkedList = new LinkedList();
                            List<as> aUV2 = ab.aUV();
                            if (aUV2.size() == 0) {
                                this.gwN = 0;
                            } else {
                                for (as asVar2 : aUV2) {
                                    if (!ab.Iz(asVar2.field_username)) {
                                        if (gCt.containsKey(asVar2.field_username)) {
                                            ah Kd2 = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(asVar2.field_username);
                                            if (Kd2 == null) {
                                                Log.e("MicroMsg.ManagerRoomByWeworkUI", "iniOtherChatroomNum %s member is null", Util.nullAs(asVar2.field_username, ""));
                                            } else if (Kd2.JO(z.aTY()) && c(asVar2)) {
                                                linkedList.add(asVar2);
                                            }
                                        } else if (com.tencent.mm.contact.c.oR(asVar2.field_type)) {
                                            ah Kd3 = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(asVar2.field_username);
                                            if (Kd3 == null) {
                                                Log.e("MicroMsg.ManagerRoomByWeworkUI", "iniOtherChatroomNum %s member is null", Util.nullAs(asVar2.field_username, ""));
                                            } else if (Kd3.JO(z.aTY()) && c(asVar2)) {
                                                linkedList.add(asVar2);
                                            }
                                        }
                                    }
                                }
                                aUV2.clear();
                                this.gwN = linkedList.size() - this.gxd;
                            }
                            this.gxa = new LinearLayoutManager();
                            this.gxa.setOrientation(1);
                            this.gwW.setLayoutManager(this.gxa);
                            this.gxc = new b(getContext(), 96.0f);
                            this.gwW.a(this.gxc);
                            this.gxb = new a(getContext(), this.gwH, this.gwJ, this.gwG, new c() {
                                /* class com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI.AnonymousClass4 */

                                @Override // com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI.c
                                public final void amQ() {
                                    AppMethodBeat.i(194139);
                                    ManagerRoomByWeworkUI.h(ManagerRoomByWeworkUI.this);
                                    AppMethodBeat.o(194139);
                                }
                            });
                            this.gwW.setAdapter(this.gxb);
                            this.gwW.setNestedScrollingEnabled(false);
                            this.gxb.atj.notifyChanged();
                            if (this.gwH.size() == 0) {
                                z = false;
                            } else {
                                z = true;
                            }
                        }
                        if (!z && !amN()) {
                            findViewById(R.id.c3d).setVisibility(0);
                            findViewById(R.id.j16).setVisibility(8);
                            this.gwU.setVisibility(8);
                        }
                    }
                    amP();
                    this.titleTv.setText(bik.title);
                    this.gwS.setText(com.tencent.mm.pluginsdk.ui.span.l.g(getContext(), Util.nullAsNil(bik.qGG), (int) this.gwS.getTextSize()));
                    if (bik.LSA != null && bik.LSA.size() > 0) {
                        this.gwT.removeAllViews();
                        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
                        Iterator<String> it = bik.LSA.iterator();
                        int i4 = 0;
                        while (it.hasNext()) {
                            View inflate = layoutInflater.inflate(R.layout.po, (ViewGroup) this.gwT, false);
                            int i5 = i4 + 1;
                            ((TextView) inflate.findViewById(R.id.g6b)).setText(i5 + ".");
                            ((TextView) inflate.findViewById(R.id.bn6)).setText(it.next());
                            this.gwT.addView(inflate);
                            i4 = i5;
                        }
                    }
                    p.a(this, (NestedScrollView) findViewById(R.id.h9a), findViewById(R.id.be8), findViewById(R.id.j0e), findViewById(R.id.aau));
                    AppMethodBeat.o(182213);
                    return;
                }
                AppCompatActivity context = getContext();
                if (Util.isNullOrNil(str)) {
                    str = getString(R.string.hu4);
                }
                u.makeText(context, str, 0).show();
                finish();
                AppMethodBeat.o(182213);
                return;
            } else if (qVar instanceof w) {
                w wVar = (w) qVar;
                if (wVar.gsu == null) {
                    emv = null;
                } else {
                    emv = wVar.gsu;
                }
                if (this.gwE == 3) {
                    if (emv != null) {
                        this.gwK.put(((w) qVar).dOe, Boolean.TRUE);
                    } else {
                        this.gwK.put(((w) qVar).dOe, Boolean.FALSE);
                    }
                } else if (emv != null) {
                    c(this.gwx, this.gwE, 1, 0);
                    Intent intent = new Intent();
                    intent.setClass(this, WeworkRoomUpgradeResultUI.class);
                    intent.putExtra("RoomInfo_Id", this.gwx);
                    intent.putExtra("popup_wording", Util.nullAs(emv.NkR, ""));
                    intent.putExtra("upgrade_openim_room_from_scene", this.gwE);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    finish();
                    super.overridePendingTransition(R.anim.eq, R.anim.en);
                    AppMethodBeat.o(182213);
                    return;
                } else {
                    AppCompatActivity context2 = getContext();
                    if (Util.isNullOrNil(str)) {
                        str = getString(R.string.hu4);
                    }
                    u.makeText(context2, str, 0).show();
                    c(this.gwx, this.gwE, 2, 4);
                    finish();
                    AppMethodBeat.o(182213);
                    return;
                }
            }
        } else if (qVar instanceof k) {
            AppCompatActivity context3 = getContext();
            if (Util.isNullOrNil(str)) {
                str = getString(R.string.hu4);
            }
            u.makeText(context3, str, 0).show();
            finish();
            AppMethodBeat.o(182213);
            return;
        } else if (qVar instanceof w) {
            if (this.gwE == 3) {
                this.gwK.put(((w) qVar).dOe, Boolean.FALSE);
            } else {
                c(this.gwx, this.gwE, 2, 4);
                AppCompatActivity context4 = getContext();
                if (Util.isNullOrNil(str)) {
                    str = getString(R.string.hu4);
                }
                u.makeText(context4, str, 0).show();
                AppMethodBeat.o(182213);
                return;
            }
        }
        if (this.gwE == 3 && (qVar instanceof w) && this.gwL == this.gwM) {
            Log.i("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom finish");
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry<String, Boolean> entry : this.gwK.entrySet()) {
                if (entry.getValue().booleanValue()) {
                    arrayList.add(entry.getKey());
                } else {
                    arrayList2.add(entry.getKey());
                }
            }
            Intent intent2 = new Intent();
            intent2.setClass(this, WeworkRoomUpgradeResultUI.class);
            intent2.putExtra("upgrade_openim_room_from_scene", this.gwE);
            intent2.putExtra("wework_upgrade_success_list", arrayList);
            intent2.putExtra("wework_upgrade_fail_list", arrayList2);
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
            super.overridePendingTransition(R.anim.eq, R.anim.en);
            i(arrayList);
        }
        AppMethodBeat.o(182213);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(182214);
        g.azz().b(3553, this);
        g.azz().b(3927, this);
        super.onDestroy();
        AppMethodBeat.o(182214);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(194152);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.ManagerRoomByWeworkUI", "requestCode=%d | resultCode=%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 != -1) {
            AppMethodBeat.o(194152);
            return;
        }
        if (i2 == 0) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            for (as asVar : this.gwH) {
                if (Util.isEqual(asVar.field_username, stringExtra)) {
                    Log.i("MicroMsg.ManagerRoomByWeworkUI", "onActivityResult contain");
                    AppMethodBeat.o(194152);
                    return;
                }
            }
            as Kn = ((l) g.af(l.class)).aSN().Kn(stringExtra);
            this.gwH.add(Kn);
            this.gwI.add(stringExtra);
            this.gwJ.put(Kn.field_username, Boolean.TRUE);
            this.gxb.atj.notifyChanged();
            amN();
            this.gxb.gxn++;
            this.gxb.gxk++;
            p.a(this, (NestedScrollView) findViewById(R.id.h9a), findViewById(R.id.be8), findViewById(R.id.j0e), findViewById(R.id.aau));
            amP();
        }
        AppMethodBeat.o(194152);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(182215);
        if (this.gwE != 3) {
            c(this.gwx, this.gwE, 0, 0);
        } else {
            ok(0);
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(182215);
        return onKeyUp;
    }

    private boolean amN() {
        AppMethodBeat.i(194153);
        if (!(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_wework_select_other_room_switch, 1) == 1) || !amO()) {
            this.gwX.setVisibility(8);
            this.gwZ.setVisibility(8);
            AppMethodBeat.o(194153);
            return false;
        }
        if (this.gwG.size() == 0 && this.gwI.size() == 0) {
            this.gwX.setVisibility(8);
        } else {
            this.gwX.setVisibility(0);
        }
        AppMethodBeat.o(194153);
        return true;
    }

    private boolean amO() {
        AppMethodBeat.i(194154);
        HashMap<String, Long> gCt = ((l) g.af(l.class)).aST().gCt();
        LinkedList linkedList = new LinkedList();
        List<as> aUV = ab.aUV();
        if (aUV.size() == 0) {
            AppMethodBeat.o(194154);
            return false;
        }
        for (as asVar : aUV) {
            if (!ab.Iz(asVar.field_username) && !this.gwI.contains(asVar.field_username)) {
                if (gCt.containsKey(asVar.field_username)) {
                    ah Kd = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(asVar.field_username);
                    if (Kd == null) {
                        Log.e("MicroMsg.ManagerRoomByWeworkUI", "%s member is null", Util.nullAs(asVar.field_username, ""));
                    } else if (Kd.JO(z.aTY()) && c(asVar)) {
                        linkedList.add(asVar);
                    }
                } else if (com.tencent.mm.contact.c.oR(asVar.field_type)) {
                    ah Kd2 = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(asVar.field_username);
                    if (Kd2 == null) {
                        Log.e("MicroMsg.ManagerRoomByWeworkUI", "%s member is null", Util.nullAs(asVar.field_username, ""));
                    } else if (Kd2.JO(z.aTY()) && c(asVar)) {
                        linkedList.add(asVar);
                    }
                }
            }
        }
        aUV.clear();
        if (linkedList.size() > 0) {
            AppMethodBeat.o(194154);
            return true;
        }
        AppMethodBeat.o(194154);
        return false;
    }

    private static boolean c(as asVar) {
        AppMethodBeat.i(194155);
        if (asVar == null) {
            AppMethodBeat.o(194155);
            return false;
        }
        ah Kd = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(asVar.field_username);
        if (Kd == null) {
            Log.e("MicroMsg.ManagerRoomByWeworkUI", "isValidByMaxNum %s member is null", asVar.field_username);
            AppMethodBeat.o(194155);
            return false;
        } else if (Kd.field_memberCount < v.aTT()) {
            AppMethodBeat.o(194155);
            return true;
        } else {
            AppMethodBeat.o(194155);
            return false;
        }
    }

    private void a(final com.tencent.mm.ak.q qVar, boolean z) {
        AppMethodBeat.i(194156);
        if (this.tipDialog == null) {
            getString(R.string.zb);
            this.tipDialog = h.a(this, getString(R.string.wc), z, new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI.AnonymousClass5 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(182211);
                    if (qVar == null) {
                        Log.i("MicroMsg.ManagerRoomByWeworkUI", "dialog onCancel scene is null");
                        AppMethodBeat.o(182211);
                        return;
                    }
                    Log.i("MicroMsg.ManagerRoomByWeworkUI", "dialog onCancel scene:%s", Integer.valueOf(qVar.getType()));
                    g.azz().a(qVar);
                    if (qVar instanceof k) {
                        ManagerRoomByWeworkUI.this.finish();
                    }
                    AppMethodBeat.o(182211);
                }
            });
            AppMethodBeat.o(194156);
            return;
        }
        if (!this.tipDialog.isShowing()) {
            this.tipDialog.show();
        }
        AppMethodBeat.o(194156);
    }

    public static void c(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(182217);
        et etVar = new et();
        etVar.rR(str);
        etVar.erW = (long) i2;
        etVar.eEt = (long) i3;
        etVar.eEu = (long) i4;
        etVar.bfK();
        AppMethodBeat.o(182217);
    }

    public final void ok(int i2) {
        long j2;
        long j3 = 0;
        AppMethodBeat.i(194157);
        ew ewVar = new ew();
        ewVar.eEB = (long) this.gxd;
        ewVar.eEC = (long) this.gxe;
        if (this.gxb == null) {
            j2 = 0;
        } else {
            j2 = (long) this.gxb.gxm;
        }
        ewVar.eED = j2;
        if (this.gxb != null) {
            j3 = (long) this.gxb.gxn;
        }
        ewVar.eEE = j3;
        ewVar.ewL = (long) i2;
        ewVar.rT(Util.nullAs(this.gwF, ""));
        ewVar.eEG = (long) this.gwN;
        ewVar.bfK();
        AppMethodBeat.o(194157);
    }

    private void i(ArrayList<String> arrayList) {
        long j2;
        long j3 = 0;
        AppMethodBeat.i(194158);
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = arrayList.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            String next = it.next();
            if (this.gwG.contains(next)) {
                i3++;
            } else {
                i2++;
            }
            sb.append(next).append("|");
        }
        if (sb.length() - 1 >= 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        ev evVar = new ev();
        evVar.eEv = (long) i3;
        if (this.gxb == null) {
            j2 = 0;
        } else {
            j2 = (long) (this.gxb.gxm - i3);
        }
        evVar.eEw = j2;
        evVar.eEx = (long) i2;
        if (this.gxb != null) {
            j3 = (long) (this.gxb.gxn - i2);
        }
        evVar.eEy = j3;
        evVar.eEz = evVar.x("sucRoomList", sb.toString(), true);
        evVar.eEA = evVar.x("ticketId", Util.nullAs(this.gwF, ""), true);
        evVar.bfK();
        AppMethodBeat.o(194158);
    }

    private void amP() {
        AppMethodBeat.i(194159);
        if (this.gwE == 3) {
            if (!(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_wework_select_other_room_switch, 1) == 1) || !amO() || this.gwG.size() != 0 || this.gwI.size() != 0) {
                this.gwO.setVisibility(0);
                this.gwP.setVisibility(8);
                if (this.gxb == null || this.gxb.gxk <= 0) {
                    this.gwO.setEnabled(false);
                    AppMethodBeat.o(194159);
                    return;
                }
                this.gwO.setEnabled(true);
                AppMethodBeat.o(194159);
                return;
            }
            this.gwO.setVisibility(8);
            this.gwP.setVisibility(0);
            AppMethodBeat.o(194159);
            return;
        }
        this.gwO.setVisibility(0);
        this.gwP.setVisibility(8);
        AppMethodBeat.o(194159);
    }

    public static void a(final String str, final CdnImageView cdnImageView) {
        AppMethodBeat.i(194160);
        if (Util.isNullOrNil(str) || cdnImageView == null) {
            Log.e("MicroMsg.ManagerRoomByWeworkUI", "username or avatarIv null");
            AppMethodBeat.o(194160);
            return;
        }
        final AnonymousClass6 r0 = new Runnable() {
            /* class com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(194140);
                Bitmap a2 = com.tencent.mm.aj.c.a(str, false, -1, null);
                if (a2 == null) {
                    cdnImageView.setImageResource(R.drawable.bca);
                    AppMethodBeat.o(194140);
                    return;
                }
                cdnImageView.setImageBitmap(a2);
                AppMethodBeat.o(194140);
            }
        };
        if (MMHandlerThread.isMainThread()) {
            r0.run();
            AppMethodBeat.o(194160);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(194141);
                r0.run();
                AppMethodBeat.o(194141);
            }
        });
        AppMethodBeat.o(194160);
    }

    public static void a(Context context, String str, TextView textView, TextView textView2, boolean z) {
        AppMethodBeat.i(194161);
        CharSequence e2 = com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) aa.getDisplayName(str), com.tencent.mm.cb.a.aG(context, R.dimen.is));
        if (z) {
            e2 = com.tencent.mm.pluginsdk.ui.span.l.d(context, e2);
        }
        textView.setText(e2);
        int Ie = v.Ie(((l) g.af(l.class)).aSN().Kn(str).field_username);
        if (Ie == 0) {
            textView2.setVisibility(8);
            AppMethodBeat.o(194161);
            return;
        }
        textView2.setVisibility(0);
        textView2.setText(context.getString(R.string.hu8, String.valueOf(Ie)));
        AppMethodBeat.o(194161);
    }

    public static class a extends RecyclerView.a {
        private Context context;
        private List<as> gxh;
        private List<String> gxi;
        private HashMap<String, Boolean> gxj;
        int gxk = 0;
        private c gxl;
        int gxm = 0;
        int gxn = 0;

        static /* synthetic */ int d(a aVar) {
            int i2 = aVar.gxk;
            aVar.gxk = i2 + 1;
            return i2;
        }

        static /* synthetic */ int f(a aVar) {
            int i2 = aVar.gxm;
            aVar.gxm = i2 + 1;
            return i2;
        }

        static /* synthetic */ int g(a aVar) {
            int i2 = aVar.gxn;
            aVar.gxn = i2 + 1;
            return i2;
        }

        static /* synthetic */ int h(a aVar) {
            int i2 = aVar.gxk;
            aVar.gxk = i2 - 1;
            return i2;
        }

        static /* synthetic */ int i(a aVar) {
            int i2 = aVar.gxm;
            aVar.gxm = i2 - 1;
            return i2;
        }

        static /* synthetic */ int j(a aVar) {
            int i2 = aVar.gxn;
            aVar.gxn = i2 - 1;
            return i2;
        }

        public a(Context context2, List<as> list, HashMap<String, Boolean> hashMap, List<String> list2, c cVar) {
            AppMethodBeat.i(194143);
            this.context = context2;
            this.gxh = list;
            this.gxj = hashMap;
            this.gxi = list2;
            this.gxl = cVar;
            for (as asVar : list) {
                hashMap.put(asVar.field_username, Boolean.FALSE);
            }
            AppMethodBeat.o(194143);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(194144);
            d dVar = new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pn, viewGroup, false));
            AppMethodBeat.o(194144);
            return dVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(194145);
            Log.d("MicroMsg.ManagerRoomByWeworkUI", "onBindViewHolder() count:%s i:%s ", Integer.valueOf(this.gxh.size()), Integer.valueOf(i2));
            if (this.gxh != null && i2 >= 0 && i2 < this.gxh.size()) {
                d dVar = (d) vVar;
                as asVar = this.gxh.get(i2);
                Log.d("MicroMsg.ManagerRoomByWeworkUI", "onBindViewHolder() count:%s i:%s username:%s", Integer.valueOf(this.gxh.size()), Integer.valueOf(i2), asVar.field_username);
                dVar.gvQ.setVisibility(0);
                ManagerRoomByWeworkUI.a(asVar.field_username, dVar.gwQ);
                ManagerRoomByWeworkUI.a(this.context, asVar.field_username, dVar.gxs, dVar.gxt, false);
                Boolean bool = this.gxj.get(asVar.field_username);
                dVar.gxr.setEnabled(true);
                dVar.gxr.setChecked(bool == null ? false : bool.booleanValue());
                dVar.gvQ.setTag(asVar);
                dVar.gvQ.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI.a.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(194142);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        as asVar = (as) view.getTag();
                        if (asVar == null) {
                            Log.e("MicroMsg.ManagerRoomByWeworkUI", "click:contact is nul");
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(194142);
                            return;
                        }
                        Boolean bool = (Boolean) a.this.gxj.get(asVar.field_username);
                        if (bool.booleanValue() || a.this.gxk != 5) {
                            a.this.gxj.put(asVar.field_username, Boolean.valueOf(bool == null || !bool.booleanValue()));
                            if (bool == null || !bool.booleanValue()) {
                                a.d(a.this);
                                if (a.this.gxi.contains(asVar.field_username)) {
                                    a.f(a.this);
                                } else {
                                    a.g(a.this);
                                }
                            } else {
                                a.h(a.this);
                                if (a.this.gxi.contains(asVar.field_username)) {
                                    a.i(a.this);
                                } else {
                                    a.j(a.this);
                                }
                            }
                            a.this.atj.notifyChanged();
                            if (a.this.gxl != null) {
                                a.this.gxl.amQ();
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(194142);
                            return;
                        }
                        u.makeText(a.this.context, (int) R.string.hu6, 0).show();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(194142);
                    }
                });
            }
            AppMethodBeat.o(194145);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            return 0;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(194146);
            int size = this.gxh.size();
            AppMethodBeat.o(194146);
            return size;
        }
    }

    public static class b extends RecyclerView.h {
        private int dividerHeight;
        private Paint gwh = new Paint();
        private Paint gxp;
        private int gxq;

        public b(Context context, float f2) {
            AppMethodBeat.i(194147);
            this.dividerHeight = com.tencent.mm.cb.a.fromDPToPix(context, 0.5f);
            this.gxq = com.tencent.mm.cb.a.fromDPToPix(context, f2);
            this.gwh.setColor(context.getResources().getColor(R.color.BW_0_Alpha_0_1));
            this.gxp = new Paint();
            this.gxp.setColor(context.getResources().getColor(R.color.BW_93));
            AppMethodBeat.o(194147);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(194148);
            super.a(canvas, recyclerView, sVar);
            int childCount = recyclerView.getChildCount();
            int paddingLeft = recyclerView.getPaddingLeft();
            int i2 = paddingLeft + this.gxq;
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                float bottom = (float) childAt.getBottom();
                float bottom2 = (float) (childAt.getBottom() + this.dividerHeight);
                if (i3 == childCount - 1) {
                    canvas.drawRect((float) paddingLeft, bottom, (float) width, bottom2, this.gxp);
                } else {
                    canvas.drawRect((float) i2, bottom, (float) width, bottom2, this.gwh);
                }
            }
            AppMethodBeat.o(194148);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(194149);
            super.a(rect, view, recyclerView, sVar);
            rect.bottom = this.dividerHeight;
            AppMethodBeat.o(194149);
        }
    }

    public static class d extends RecyclerView.v {
        View gvQ;
        CdnImageView gwQ;
        CheckBox gxr;
        TextView gxs;
        TextView gxt;

        public d(View view) {
            super(view);
            AppMethodBeat.i(194150);
            this.gvQ = view;
            this.gxr = (CheckBox) view.findViewById(R.id.hhc);
            this.gwQ = (CdnImageView) view.findViewById(R.id.arh);
            this.gxs = (TextView) view.findViewById(R.id.arp);
            this.gxt = (TextView) view.findViewById(R.id.arr);
            AppMethodBeat.o(194150);
        }
    }

    static /* synthetic */ void c(ManagerRoomByWeworkUI managerRoomByWeworkUI) {
        w wVar;
        AppMethodBeat.i(194162);
        StringBuilder sb = new StringBuilder();
        managerRoomByWeworkUI.a((com.tencent.mm.ak.q) null, false);
        managerRoomByWeworkUI.gwL = 0;
        managerRoomByWeworkUI.gwM = 0;
        for (Map.Entry<String, Boolean> entry : managerRoomByWeworkUI.gwJ.entrySet()) {
            if (entry.getValue().booleanValue()) {
                managerRoomByWeworkUI.gwM++;
                sb.append(entry.getKey()).append(",");
                if (managerRoomByWeworkUI.gwG.contains(entry.getKey())) {
                    wVar = new w(entry.getKey(), Util.nullAs(managerRoomByWeworkUI.gwF, ""), 1);
                } else {
                    wVar = new w(entry.getKey(), Util.nullAs(managerRoomByWeworkUI.gwF, ""), 2);
                }
                managerRoomByWeworkUI.gwK.put(entry.getKey(), Boolean.FALSE);
                g.azz().a(wVar, 0);
            }
        }
        managerRoomByWeworkUI.ok(1);
        Log.i("MicroMsg.ManagerRoomByWeworkUI", "doUpgradeAssociateChatRooms() :%s", sb);
        AppMethodBeat.o(194162);
    }

    static /* synthetic */ void d(ManagerRoomByWeworkUI managerRoomByWeworkUI) {
        AppMethodBeat.i(182218);
        Log.i("MicroMsg.ManagerRoomByWeworkUI", "doUpgradeAssociateChatRoom() roomId:%s", managerRoomByWeworkUI.gwx);
        w wVar = new w(managerRoomByWeworkUI.gwx, Util.nullAs(managerRoomByWeworkUI.gwF, ""), 0);
        g.azz().a(wVar, 0);
        managerRoomByWeworkUI.a((com.tencent.mm.ak.q) wVar, true);
        AppMethodBeat.o(182218);
    }
}
