package com.tencent.mm.ui.bizchat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.a.c;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.h;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.a.o;
import com.tencent.mm.al.a.v;
import com.tencent.mm.al.a.y;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.d;
import com.tencent.mm.al.p;
import com.tencent.mm.av.q;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.g.a.yr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.j;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BizChatroomInfoUI extends MMPreference implements i, p {
    private static boolean guv = false;
    private k BeV = null;
    private boolean FCj;
    private int KVI;
    private d PaO;
    private d.a PaQ = new d.a() {
        /* class com.tencent.mm.ui.bizchat.BizChatroomInfoUI.AnonymousClass3 */

        @Override // com.tencent.mm.al.a.d.a
        public final void a(d.a.b bVar) {
            AppMethodBeat.i(34051);
            if (!(bVar == null || bVar.iPP == null || bVar.iPE != BizChatroomInfoUI.this.ppv || bVar.iPO == d.a.EnumC0249a.DELETE)) {
                Log.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
                BizChatroomInfoUI.this.Pag = ag.baj().bs(BizChatroomInfoUI.this.ppv);
                BizChatroomInfoUI.h(BizChatroomInfoUI.this);
            }
            AppMethodBeat.o(34051);
        }
    };
    private c Pag = null;
    private String PbX;
    private boolean PbY = false;
    private boolean PbZ;
    private k Pca = null;
    private int fromScene;
    private ProgressDialog gtM = null;
    private ContactListExpandPreference gtU;
    private CheckBoxPreference gtV;
    private CheckBoxPreference gtW;
    private CheckBoxPreference gtX;
    private boolean gue = false;
    private int gug;
    private boolean guh;
    private e gup = new e(new AbsListView.OnScrollListener() {
        /* class com.tencent.mm.ui.bizchat.BizChatroomInfoUI.AnonymousClass1 */

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(34048);
            q.bcV().onScrollStateChanged(i2);
            AppMethodBeat.o(34048);
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }
    });
    boolean guq = false;
    private SignaturePreference gyv;
    private boolean isDeleteCancel = false;
    private String ppO;
    private long ppv;
    private f screen;
    private SharedPreferences sp = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BizChatroomInfoUI() {
        AppMethodBeat.i(34063);
        AppMethodBeat.o(34063);
    }

    static /* synthetic */ void h(BizChatroomInfoUI bizChatroomInfoUI) {
        AppMethodBeat.i(34091);
        bizChatroomInfoUI.onDataChanged();
        AppMethodBeat.o(34091);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34064);
        super.onCreate(bundle);
        ag.baj().a(this.PaQ, Looper.getMainLooper());
        this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
        this.ppO = getIntent().getStringExtra("Chat_User");
        this.ppv = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.Pag = ag.baj().bs(this.ppv);
        this.PbX = this.Pag.field_chatName;
        this.PbY = com.tencent.mm.al.a.e.NG(this.Pag.field_bizChatServId);
        if (!this.PbY) {
            this.BeV = ag.bal().fB(this.Pag.field_bizChatServId);
        }
        this.Pca = ag.bal().NQ(this.ppO);
        initView();
        if (this.Pag == null || this.Pag.field_bizChatServId == null || this.ppO == null) {
            AppMethodBeat.o(34064);
        } else if (this.Pag.isGroup()) {
            ag.baq();
            h.bn(this.Pag.field_bizChatServId, this.ppO);
            AppMethodBeat.o(34064);
        } else {
            ag.baq();
            h.a(this.Pag.field_bizChatServId, this.ppO, this);
            AppMethodBeat.o(34064);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(34065);
        amA();
        updateTitle();
        amy();
        eEu();
        gMj();
        amx();
        this.screen.notifyDataSetChanged();
        super.onResume();
        if (!this.guq) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!Util.isNullOrNil(stringExtra)) {
                final int bmj = this.screen.bmj(stringExtra);
                setSelection(bmj - 3);
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.mm.ui.bizchat.BizChatroomInfoUI.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(34052);
                        View a2 = ((a) BizChatroomInfoUI.this.screen).a(bmj, BizChatroomInfoUI.this.getListView());
                        if (a2 != null) {
                            com.tencent.mm.ui.i.a.c(BizChatroomInfoUI.this.getContext(), a2);
                        }
                        AppMethodBeat.o(34052);
                    }
                }, 10);
            }
            this.guq = true;
        }
        AppMethodBeat.o(34065);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(34066);
        super.onPause();
        AppMethodBeat.o(34066);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(34067);
        com.tencent.mm.ui.i.a.dismiss();
        com.tencent.mm.ui.i.a.dismiss();
        ag.baj().a(this.PaQ);
        super.onDestroy();
        AppMethodBeat.o(34067);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        AppMethodBeat.i(34068);
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            AppMethodBeat.o(34068);
            return;
        }
        switch (i2) {
            case 1:
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra != null) {
                    Log.i("MicroMsg.BizChatroomInfoUI", "bundle != null");
                    String string = bundleExtra.getString("enterprise_members");
                    Log.i("MicroMsg.BizChatroomInfoUI", "enterprise_members:%s", string);
                    if (this.PbY) {
                        z = bms(string);
                    } else {
                        bfs bfs = new bfs();
                        c cVar = new c();
                        cVar.field_addMemberUrl = this.Pca != null ? this.Pca.field_addMemberUrl : null;
                        cVar.field_brandUserName = this.ppO;
                        if (com.tencent.mm.al.a.e.a(cVar, string, this.BeV.field_userId, bfs)) {
                            ag.baq();
                            final o a2 = h.a(this.ppO, bfs, this);
                            getString(R.string.zb);
                            this.gtM = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dw), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.ui.bizchat.BizChatroomInfoUI.AnonymousClass5 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(34053);
                                    bg.azz().a(a2);
                                    AppMethodBeat.o(34053);
                                }
                            });
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    Toast.makeText(this, getString(R.string.g69), 0).show();
                    AppMethodBeat.o(34068);
                    return;
                }
                AppMethodBeat.o(34068);
                return;
            default:
                AppMethodBeat.o(34068);
                return;
        }
    }

    private boolean bms(String str) {
        k kVar;
        AppMethodBeat.i(34069);
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                nw nwVar = new nw();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String string = jSONObject.getString("id");
                    k fB = ag.bal().fB(string);
                    if (fB == null) {
                        k kVar2 = new k();
                        kVar2.field_userId = string;
                        kVar = kVar2;
                    } else {
                        kVar = fB;
                    }
                    kVar.field_userName = jSONObject.getString("nick_name");
                    kVar.field_brandUserName = this.ppO;
                    kVar.field_headImageUrl = jSONObject.getString("head_img_url");
                    kVar.field_profileUrl = jSONObject.getString("profile_url");
                    kVar.field_UserVersion = jSONObject.getInt("ver");
                    kVar.field_addMemberUrl = this.Pca != null ? this.Pca.field_addMemberUrl : null;
                    if (!ag.bal().b(kVar)) {
                        ag.bal().a(kVar);
                    }
                    nv nvVar = new nv();
                    nvVar.KTu = kVar.field_userId;
                    nwVar.KTv.add(nvVar);
                }
                a(nwVar, (nw) null);
                AppMethodBeat.o(34069);
                return true;
            } catch (JSONException e2) {
                Log.i("MicroMsg.BizChatroomInfoUI", "parse memberJson Exception:%s", e2.getMessage());
                Log.printErrStackTrace("MicroMsg.BizChatroomInfoUI", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(34069);
        return false;
    }

    private void a(nw nwVar, nw nwVar2) {
        AppMethodBeat.i(34070);
        Log.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
        String string = nwVar == null ? getString(R.string.g6m) : getString(R.string.dw);
        ag.baq();
        final y a2 = h.a(this.Pag.field_brandUserName, this.Pag.field_bizChatServId, nwVar, nwVar2, this);
        getString(R.string.zb);
        this.gtM = com.tencent.mm.ui.base.h.a((Context) this, string, true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.bizchat.BizChatroomInfoUI.AnonymousClass6 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(34054);
                bg.azz().a(a2);
                AppMethodBeat.o(34054);
            }
        });
        AppMethodBeat.o(34070);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.r;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(34071);
        this.screen = getPreferenceScreen();
        String str = this.Pag.field_ownerUserId;
        this.gug = this.Pag.bax().size();
        if (Util.isNullOrNil(str)) {
            this.gue = false;
        } else {
            this.gue = str.equals(ag.bal().fC(this.ppO));
        }
        com.tencent.mm.api.c MT = ag.bah().MT(this.ppO);
        this.PaO = ag.bar().MO(MT.UN());
        Log.i("MicroMsg.BizChatroomInfoUI", "getMainBrandAttr father %s", MT.UN());
        Log.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
        this.gtU = (ContactListExpandPreference) this.screen.bmg("roominfo_contact_anchor");
        this.gtU.a(this.screen, this.gtU.mKey);
        this.gyv = (SignaturePreference) this.screen.bmg("room_name");
        this.gtV = (CheckBoxPreference) this.screen.bmg("room_notify_new_msg");
        this.gtX = (CheckBoxPreference) this.screen.bmg("room_placed_to_the_top");
        this.gtW = (CheckBoxPreference) this.screen.bmg("room_save_to_contact");
        ContactListExpandPreference contactListExpandPreference = this.gtU;
        boolean z = this.PbY;
        if (contactListExpandPreference.KfY != null) {
            contactListExpandPreference.KfY.Kfo.KfB = z;
        }
        ContactListExpandPreference contactListExpandPreference2 = this.gtU;
        boolean z2 = this.gue;
        if (contactListExpandPreference2.KfY != null) {
            contactListExpandPreference2.KfY.Kfo.KfA = z2;
        }
        if (this.gue) {
            this.gtU.zU(true).zV(true);
        } else {
            this.gtU.zU(true).zV(false);
        }
        if (this.PaO.field_hide_mod_chat_member) {
            this.gtU.zU(false).zV(false);
        }
        this.gtU.beT(this.Pag.field_ownerUserId);
        this.gtU.gpG();
        this.gtU.gpA();
        if (!this.PbY) {
            this.screen.m38do("room_save_to_contact", true);
            this.screen.m38do("room_name", true);
            this.screen.m38do("room_del_quit", true);
        }
        gMj();
        eEu();
        amy();
        if (this.gtU != null) {
            getListView().setOnScrollListener(this.gup);
            this.gtU.a(this.gup);
            this.gtU.a(new ContactListExpandPreference.a() {
                /* class com.tencent.mm.ui.bizchat.BizChatroomInfoUI.AnonymousClass7 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
                public final void og(int i2) {
                    AppMethodBeat.i(34055);
                    BizChatroomInfoUI.a(BizChatroomInfoUI.this, i2);
                    AppMethodBeat.o(34055);
                }

                @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
                public final void e(ViewGroup viewGroup, int i2) {
                    boolean z = true;
                    AppMethodBeat.i(232794);
                    k alT = BizChatroomInfoUI.this.alT(i2);
                    if (alT == null || Util.isNullOrNil(alT.field_profileUrl)) {
                        Object[] objArr = new Object[1];
                        if (alT != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        Log.w("MicroMsg.BizChatroomInfoUI", "onItemNormalClick userInfo == null:%s", objArr);
                        AppMethodBeat.o(232794);
                        return;
                    }
                    Log.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", alT.field_profileUrl);
                    ag.baq();
                    h.a(alT.field_userId, alT.field_brandUserName, BizChatroomInfoUI.this);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", alT.field_profileUrl);
                    intent.putExtra("useJs", true);
                    com.tencent.mm.br.c.b(BizChatroomInfoUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(232794);
                }

                @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
                public final void amF() {
                    AppMethodBeat.i(34057);
                    if (BizChatroomInfoUI.this.gtU != null) {
                        BizChatroomInfoUI.this.gtU.gpE();
                    }
                    AppMethodBeat.o(34057);
                }

                @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
                public final void oh(int i2) {
                    AppMethodBeat.i(34058);
                    BizChatroomInfoUI.c(BizChatroomInfoUI.this);
                    AppMethodBeat.o(34058);
                }
            });
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.bizchat.BizChatroomInfoUI.AnonymousClass8 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(34059);
                BizChatroomInfoUI.this.finish();
                AppMethodBeat.o(34059);
                return true;
            }
        });
        AppMethodBeat.o(34071);
    }

    private void ad(boolean z, int i2) {
        AppMethodBeat.i(34073);
        this.KVI = this.Pag.field_bitFlag;
        this.PbX = this.Pag.field_chatName;
        if (this.PbY) {
            if (z) {
                this.Pag.field_bitFlag |= i2;
            } else {
                this.Pag.field_bitFlag &= i2 ^ -1;
            }
            Log.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", Integer.valueOf(this.Pag.field_bitFlag));
            ag.baj().b(this.Pag);
        } else {
            if (z) {
                this.BeV.field_bitFlag |= i2;
            } else {
                this.BeV.field_bitFlag &= i2 ^ -1;
            }
            ag.bal().b(this.BeV);
            this.Pag.field_bitFlag = this.BeV.field_bitFlag;
            ag.baj().b(this.Pag);
        }
        nt ntVar = new nt();
        ntVar.KTl = this.Pag.field_bizChatServId;
        ntVar.KTn = this.Pag.field_bitFlag;
        ag.baq();
        h.a(this.Pag.field_brandUserName, ntVar, this);
        AppMethodBeat.o(34073);
    }

    public final k alT(int i2) {
        AppMethodBeat.i(34074);
        if (this.gtU.getItem(i2) instanceof k) {
            k kVar = (k) this.gtU.getItem(i2);
            AppMethodBeat.o(34074);
            return kVar;
        }
        AppMethodBeat.o(34074);
        return null;
    }

    private void amx() {
        List<String> linkedList;
        AppMethodBeat.i(34075);
        if (this.gtU != null) {
            if (this.PbY) {
                linkedList = com.tencent.mm.al.a.e.As(this.ppv);
            } else {
                linkedList = new LinkedList<>();
                linkedList.add(this.Pag.field_bizChatServId);
            }
            if (linkedList != null) {
                this.gug = linkedList.size();
            } else {
                this.gug = 0;
            }
            if (this.gug <= 1) {
                this.gtU.zU(true).zV(false);
            } else {
                this.gtU.zU(true).zV(this.gue);
            }
            if (this.PaO.field_hide_mod_chat_member) {
                this.gtU.zU(false).zV(false);
            }
            this.gtU.H(this.ppO, linkedList);
        }
        AppMethodBeat.o(34075);
    }

    private void gMj() {
        AppMethodBeat.i(34076);
        Log.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
        if (this.sp == null) {
            this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.PbY) {
            this.FCj = this.Pag.iE(8);
            this.KVI = this.Pag.field_bitFlag;
        } else {
            this.FCj = this.BeV.iE(8);
            this.KVI = this.BeV.field_bitFlag;
        }
        if (this.FCj) {
            if (this.gtW != null) {
                this.sp.edit().putBoolean("room_save_to_contact", true).commit();
            }
        } else if (this.gtW != null) {
            this.sp.edit().putBoolean("room_save_to_contact", false).commit();
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(34076);
    }

    private void eEu() {
        AppMethodBeat.i(34077);
        Log.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
        if (this.sp == null) {
            this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.PbY) {
            this.PbZ = this.Pag.iE(16);
            this.KVI = this.Pag.field_bitFlag;
        } else {
            this.PbZ = this.BeV.iE(16);
            this.KVI = this.BeV.field_bitFlag;
        }
        if (this.gtX != null) {
            this.sp.edit().putBoolean("room_placed_to_the_top", this.PbZ).commit();
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(34077);
    }

    private void amy() {
        AppMethodBeat.i(34078);
        if (this.sp == null) {
            this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.PbY) {
            this.guh = this.Pag.iE(1);
            this.KVI = this.Pag.field_bitFlag;
        } else {
            this.guh = this.BeV.iE(1);
            this.KVI = this.BeV.field_bitFlag;
        }
        if (this.guh) {
            setTitleMuteIconVisibility(0);
            if (this.gtV != null) {
                this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
            }
        } else {
            setTitleMuteIconVisibility(8);
            if (this.gtV != null) {
                this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
            }
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(34078);
    }

    private void amA() {
        AppMethodBeat.i(34079);
        if (this.gyv != null) {
            if (amB()) {
                String str = this.Pag.field_chatName;
                if (str != null && str.length() > 50) {
                    str = str.substring(0, 32);
                }
                Log.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", str);
                SignaturePreference signaturePreference = this.gyv;
                if (str == null || str.length() <= 0) {
                    str = getString(R.string.gu1);
                }
                signaturePreference.setSummary(l.c(this, str));
                AppMethodBeat.o(34079);
                return;
            }
            this.gyv.setSummary(getString(R.string.g7e));
        }
        AppMethodBeat.o(34079);
    }

    private void updateTitle() {
        AppMethodBeat.i(34080);
        if (this.PbY) {
            this.gug = com.tencent.mm.al.a.e.Ar(this.ppv);
            if (this.gug != 0) {
                setMMTitle(getString(R.string.dea, new Object[]{getString(R.string.g_b), Integer.valueOf(this.gug)}));
                AppMethodBeat.o(34080);
                return;
            }
        }
        setMMTitle(getString(R.string.g_b));
        AppMethodBeat.o(34080);
    }

    private boolean amB() {
        AppMethodBeat.i(34081);
        if (Util.isNullOrNil(this.PbY ? this.Pag.field_chatName : this.BeV.field_userName)) {
            AppMethodBeat.o(34081);
            return false;
        }
        AppMethodBeat.o(34081);
        return true;
    }

    @Override // com.tencent.mm.al.p
    public final void a(int i2, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(34082);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (qVar.getType() == 1355) {
            aec baD = ((o) qVar).baD();
            aeb baE = ((o) qVar).baE();
            c NE = ag.baj().NE(baD.Lpw.LPp.KTl);
            if (NE == null) {
                Toast.makeText(MMApplicationContext.getContext(), getString(R.string.g69), 0).show();
                AppMethodBeat.o(34082);
            } else if (this.fromScene == 2) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
                intent.putExtra("Contact_User", baE.KTt);
                intent.putExtra("biz_chat_chat_id", NE.field_bizChatLocalId);
                com.tencent.mm.br.c.f(this, ".ui.bizchat.BizChatConversationUI", intent);
                AppMethodBeat.o(34082);
            } else {
                Intent intent2 = new Intent();
                intent2.addFlags(67108864);
                intent2.putExtra("Chat_User", baE.KTt);
                intent2.putExtra("key_biz_chat_id", NE.field_bizChatLocalId);
                intent2.putExtra("finish_direct", true);
                intent2.putExtra("key_need_send_video", false);
                intent2.putExtra("key_is_biz_chat", true);
                intent2.setClass(this, ChattingUI.class);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/bizchat/BizChatroomInfoUI", "onBizChatSceneEnd", "(ILcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatroomInfoUI", "onBizChatSceneEnd", "(ILcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(34082);
            }
        } else {
            if (qVar.getType() == 1356) {
                if (i2 != 0) {
                    gMk();
                    AppMethodBeat.o(34082);
                    return;
                }
            } else if (qVar.getType() == 1353 && i2 >= 0 && this.BeV != null) {
                this.BeV = ag.bal().fB(this.BeV.field_userId);
                onDataChanged();
            }
            AppMethodBeat.o(34082);
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(34083);
        if (qVar == null) {
            Log.e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", Integer.valueOf(i2), Integer.valueOf(i3), str);
            AppMethodBeat.o(34083);
            return;
        }
        Log.i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(qVar.getType()));
        this.gug = com.tencent.mm.al.a.e.Ar(this.ppv);
        Log.d("MicroMsg.BizChatroomInfoUI", "now is " + this.gug);
        if (this.gtM != null) {
            this.gtM.dismiss();
        }
        com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
        if (Dk != null) {
            Dk.a(this, null, null);
            AppMethodBeat.o(34083);
        } else if (i2 == 0 && i3 == 0) {
            qVar.getType();
            AppMethodBeat.o(34083);
        } else {
            Log.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
            gMk();
            AppMethodBeat.o(34083);
        }
    }

    private void onDataChanged() {
        AppMethodBeat.i(34084);
        if (this.gtU != null) {
            amA();
            updateTitle();
            amy();
            amx();
            gMj();
            eEu();
            this.gtU.notifyChanged();
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(34084);
    }

    private void gMk() {
        AppMethodBeat.i(34085);
        Log.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
        this.Pag.field_chatName = this.PbX;
        this.Pag.field_bitFlag = this.KVI;
        this.guh = this.Pag.iE(1);
        this.FCj = this.Pag.iE(8);
        this.PbZ = this.Pag.iE(16);
        ag.baj().b(this.Pag);
        if (this.PbZ) {
            ag.bak().Ap(this.Pag.field_bizChatLocalId);
        } else if (!this.PbZ) {
            ag.bak().Aq(this.Pag.field_bizChatLocalId);
        }
        this.sp.edit().putBoolean("room_placed_to_the_top", ag.bak().Ao(this.Pag.field_bizChatLocalId)).commit();
        amA();
        amy();
        eEu();
        gMj();
        Toast.makeText(this, getString(R.string.g6_), 0).show();
        AppMethodBeat.o(34085);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public com.tencent.mm.ui.base.preference.h createAdapter(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(34086);
        a aVar = new a(this, getListView(), sharedPreferences);
        AppMethodBeat.o(34086);
        return aVar;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(34072);
        String str = preference.mKey;
        if (str.equals("room_name")) {
            final String str2 = "";
            if (amB()) {
                str2 = this.Pag.field_chatName;
            }
            com.tencent.mm.ui.base.h.a(getContext(), getString(R.string.g8a), str2, "", 32, new h.b() {
                /* class com.tencent.mm.ui.bizchat.BizChatroomInfoUI.AnonymousClass9 */

                @Override // com.tencent.mm.ui.base.h.b
                public final boolean onFinish(CharSequence charSequence) {
                    AppMethodBeat.i(34060);
                    boolean a2 = BizChatroomInfoUI.a(BizChatroomInfoUI.this, str2, charSequence);
                    AppMethodBeat.o(34060);
                    return a2;
                }
            });
        } else if (str.equals("room_notify_new_msg")) {
            if (!this.guh) {
                z = true;
            } else {
                z = false;
            }
            this.guh = z;
            ad(this.guh, 1);
            amy();
        } else if (str.equals("room_placed_to_the_top")) {
            if (this.PbZ) {
                z2 = false;
            }
            this.PbZ = z2;
            ad(this.PbZ, 16);
            if (this.PbZ) {
                ag.bak().Ap(this.Pag.field_bizChatLocalId);
            } else {
                ag.bak().Aq(this.Pag.field_bizChatLocalId);
            }
        } else if (str.equals("room_del_quit")) {
            Log.d("MicroMsg.BizChatroomInfoUI", " quit " + this.ppv);
            com.tencent.mm.ui.base.h.a(getContext(), getString(R.string.bl7), "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.bizchat.BizChatroomInfoUI.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(34061);
                    BizChatroomInfoUI.d(BizChatroomInfoUI.this);
                    AppMethodBeat.o(34061);
                }
            }, (DialogInterface.OnClickListener) null);
        } else if (str.equals("room_save_to_contact")) {
            if (this.FCj) {
                z2 = false;
            }
            this.FCj = z2;
            ad(this.FCj, 8);
            gMj();
        }
        AppMethodBeat.o(34072);
        return false;
    }

    static /* synthetic */ void a(BizChatroomInfoUI bizChatroomInfoUI, int i2) {
        boolean z = true;
        AppMethodBeat.i(34087);
        k alT = bizChatroomInfoUI.alT(i2);
        if (alT == null) {
            Object[] objArr = new Object[1];
            if (alT != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.w("MicroMsg.BizChatroomInfoUI", "onItemNormalClick userInfo == null:%s", objArr);
            AppMethodBeat.o(34087);
            return;
        }
        Log.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick field_userId:%s", alT.field_userId);
        String str = alT.field_userId;
        nw nwVar = new nw();
        nv nvVar = new nv();
        nvVar.KTu = str;
        nwVar.KTv.add(nvVar);
        bizChatroomInfoUI.a((nw) null, nwVar);
        AppMethodBeat.o(34087);
    }

    static /* synthetic */ void c(BizChatroomInfoUI bizChatroomInfoUI) {
        AppMethodBeat.i(34088);
        Intent intent = new Intent();
        if (bizChatroomInfoUI.PbY) {
            if (Util.isNullOrNil(bizChatroomInfoUI.Pag.field_addMemberUrl)) {
                Log.w("MicroMsg.BizChatroomInfoUI", "dealAddMemberBtn: addMemberUrl is null");
                Toast.makeText(bizChatroomInfoUI, bizChatroomInfoUI.getString(R.string.ak0), 0).show();
                AppMethodBeat.o(34088);
                return;
            }
            intent.putExtra("rawUrl", bizChatroomInfoUI.Pag.field_addMemberUrl);
        } else if (bizChatroomInfoUI.BeV == null || Util.isNullOrNil(bizChatroomInfoUI.BeV.field_addMemberUrl)) {
            Log.w("MicroMsg.BizChatroomInfoUI", "dealAddMemberBtn: addMemberUrl is null");
            Toast.makeText(bizChatroomInfoUI, bizChatroomInfoUI.getString(R.string.ak0), 0).show();
            AppMethodBeat.o(34088);
            return;
        } else {
            intent.putExtra("rawUrl", bizChatroomInfoUI.BeV.field_addMemberUrl);
        }
        intent.putExtra("useJs", true);
        com.tencent.mm.br.c.b(bizChatroomInfoUI.getContext(), "webview", ".ui.tools.WebViewUI", intent, 1);
        AppMethodBeat.o(34088);
    }

    static /* synthetic */ boolean a(BizChatroomInfoUI bizChatroomInfoUI, String str, CharSequence charSequence) {
        String trim;
        AppMethodBeat.i(34089);
        if (charSequence == null) {
            trim = "";
        } else {
            trim = charSequence.toString().trim();
        }
        if (trim.equals(str)) {
            Log.d("MicroMsg.BizChatroomInfoUI", "same room name return");
            AppMethodBeat.o(34089);
            return true;
        } else if (trim.length() == 0) {
            com.tencent.mm.ui.base.h.cD(bizChatroomInfoUI.getContext(), bizChatroomInfoUI.getString(R.string.g6d));
            AppMethodBeat.o(34089);
            return false;
        } else {
            EventCenter.instance.publish(new yr());
            bizChatroomInfoUI.PbX = bizChatroomInfoUI.Pag.field_chatName;
            bizChatroomInfoUI.KVI = bizChatroomInfoUI.Pag.field_bitFlag;
            bizChatroomInfoUI.Pag.field_chatName = trim;
            ag.baj().b(bizChatroomInfoUI.Pag);
            nt ntVar = new nt();
            ntVar.KTl = bizChatroomInfoUI.Pag.field_bizChatServId;
            ntVar.name = trim;
            ntVar.KTn = bizChatroomInfoUI.KVI;
            ag.baq();
            com.tencent.mm.al.a.h.a(bizChatroomInfoUI.Pag.field_brandUserName, ntVar, bizChatroomInfoUI);
            bizChatroomInfoUI.amA();
            bizChatroomInfoUI.screen.notifyDataSetChanged();
            AppMethodBeat.o(34089);
            return true;
        }
    }

    static /* synthetic */ void d(BizChatroomInfoUI bizChatroomInfoUI) {
        AppMethodBeat.i(34090);
        Log.i("MicroMsg.BizChatroomInfoUI", "deleteChatroom");
        ag.baq();
        g.aAg().hqi.a(new v(bizChatroomInfoUI.ppO, bizChatroomInfoUI.Pag.field_bizChatServId), 0);
        bizChatroomInfoUI.isDeleteCancel = false;
        bizChatroomInfoUI.getString(R.string.zb);
        final com.tencent.mm.ui.base.q a2 = com.tencent.mm.ui.base.h.a((Context) bizChatroomInfoUI, bizChatroomInfoUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.bizchat.BizChatroomInfoUI.AnonymousClass11 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(34062);
                BizChatroomInfoUI.this.isDeleteCancel = true;
                AppMethodBeat.o(34062);
            }
        });
        j.a(bizChatroomInfoUI.ppO, bizChatroomInfoUI.ppv, new bp.a() {
            /* class com.tencent.mm.ui.bizchat.BizChatroomInfoUI.AnonymousClass2 */

            @Override // com.tencent.mm.model.bp.a
            public final boolean amG() {
                AppMethodBeat.i(34049);
                boolean z = BizChatroomInfoUI.this.isDeleteCancel;
                AppMethodBeat.o(34049);
                return z;
            }

            @Override // com.tencent.mm.model.bp.a
            public final void amH() {
                AppMethodBeat.i(34050);
                if (a2 != null) {
                    ag.bak().Am(BizChatroomInfoUI.this.ppv);
                    ag.baj().Am(BizChatroomInfoUI.this.ppv);
                    a2.dismiss();
                }
                AppMethodBeat.o(34050);
            }
        });
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Contact_User", bizChatroomInfoUI.ppO);
        com.tencent.mm.br.c.b(bizChatroomInfoUI.getContext(), "brandservice", ".ui.BizChatConversationUI", intent);
        bizChatroomInfoUI.finish();
        AppMethodBeat.o(34090);
    }
}
