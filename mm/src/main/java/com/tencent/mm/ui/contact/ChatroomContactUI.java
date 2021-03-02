package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;
import com.tencent.mm.ui.voicesearch.b;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.ui.z;
import java.io.IOException;

public class ChatroomContactUI extends MMActivity implements i, MStorage.IOnStorageChange {
    private b PSM;
    private String PSO;
    private ContactCountView PTa;
    private VoiceSearchLayout PUl;
    private View PUm;
    private com.tencent.mm.modelvoiceaddr.ui.b PUn;
    private d PUo;
    private e gup = new e(new AbsListView.OnScrollListener() {
        /* class com.tencent.mm.ui.contact.ChatroomContactUI.AnonymousClass6 */

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }
    });
    private TextView hSx;
    private int ppd = 0;
    private int ppe = 0;
    private a pqr;
    private o.g rJj = new o.g() {
        /* class com.tencent.mm.ui.contact.ChatroomContactUI.AnonymousClass1 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(37691);
            switch (menuItem.getItemId()) {
                case 1:
                    ChatroomContactUI.bns(ChatroomContactUI.this.PSO);
                    AppMethodBeat.o(37691);
                    return;
                default:
                    AppMethodBeat.o(37691);
                    return;
            }
        }
    };
    private ListView yCT;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ChatroomContactUI() {
        AppMethodBeat.i(37708);
        AppMethodBeat.o(37708);
    }

    static /* synthetic */ void g(ChatroomContactUI chatroomContactUI) {
        AppMethodBeat.i(37720);
        chatroomContactUI.eco();
        AppMethodBeat.o(37720);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.pf;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(37709);
        super.onCreate(bundle);
        setMMTitle(R.string.e6);
        initView();
        bg.azz().a(138, this);
        bg.aVF();
        c.aSN().add(this.PUo);
        AppMethodBeat.o(37709);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(37710);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        bg.aVF();
        if (c.aSN().Kn(this.PSO) == null) {
            Log.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.PSO);
            AppMethodBeat.o(37710);
        } else if (ab.IQ(this.PSO)) {
            contextMenu.setHeaderTitle(l.c(view.getContext(), aa.getDisplayName(this.PSO)));
            contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.string.ew);
            AppMethodBeat.o(37710);
        } else {
            AppMethodBeat.o(37710);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(37712);
        super.onResume();
        if (this.PTa != null) {
            this.PTa.setContactType(2);
            this.PTa.gUw();
        }
        bg.aVF();
        c.aSX().add(this);
        if (!(this.PUn == null || this.PUl == null)) {
            com.tencent.mm.br.c.gsX();
            if (com.tencent.mm.aw.b.isOverseasUser() || !LocaleUtil.getApplicationLanguage().equals(LocaleUtil.CHINA)) {
                this.PUn.jxF = false;
            } else {
                this.PUn.jxF = false;
                com.tencent.mm.modelvoiceaddr.ui.b bVar = this.PUn;
                bVar.jxJ = this.PUl;
                bVar.jxH = 1;
                if (1 == bVar.jxH) {
                    bVar.jxG = 2;
                } else {
                    bVar.jxG = 1;
                }
            }
        }
        if (this.PSM != null) {
            this.PSM.onResume();
        }
        AppMethodBeat.o(37712);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(37713);
        super.onPause();
        bg.aVF();
        c.aSX().remove(this);
        if (this.PUn != null) {
            this.PUn.onPause();
        }
        if (this.PSM != null) {
            this.PSM.onPause();
        }
        AppMethodBeat.o(37713);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(37714);
        super.onDestroy();
        bg.azz().b(138, this);
        bg.aVF();
        c.aSN().remove(this.PUo);
        d dVar = this.PUo;
        if (dVar.kex != null) {
            dVar.kex.detach();
            dVar.kex = null;
        }
        this.PUo.ebf();
        this.PUo.gGV();
        this.PSM.detach();
        this.PSM.ebf();
        AppMethodBeat.o(37714);
    }

    private void eco() {
        AppMethodBeat.i(37715);
        if (this.PUo != null) {
            this.PUo.onNotifyChange(null, null);
        }
        if (this.PSM != null) {
            this.PSM.onNotifyChange(null, null);
        }
        AppMethodBeat.o(37715);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(37716);
        if (!Util.isTopActivity(this)) {
            AppMethodBeat.o(37716);
        } else if (z.a.a(this, i2, i3, str, 4)) {
            AppMethodBeat.o(37716);
        } else if (i2 == 0 && i3 == 0) {
            switch (qVar.getType()) {
                case 138:
                    eco();
                    break;
            }
            AppMethodBeat.o(37716);
        } else {
            AppMethodBeat.o(37716);
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(37717);
        if (this.PTa != null) {
            this.PTa.setContactType(2);
            this.PTa.gUw();
        }
        AppMethodBeat.o(37717);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(37711);
        ((TextView) findViewById(R.id.c3h)).setVisibility(8);
        this.yCT = (ListView) findViewById(R.id.h4);
        this.yCT.setAdapter((ListAdapter) null);
        this.hSx = (TextView) findViewById(R.id.c3h);
        this.hSx.setText(R.string.f0);
        this.PUm = findViewById(R.id.it4);
        this.PUm.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.contact.ChatroomContactUI.AnonymousClass7 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(37697);
                ChatroomContactUI.this.PUn.onPause();
                AppMethodBeat.o(37697);
                return true;
            }
        });
        this.PUo = new d(this, "@all.chatroom.contact");
        this.PUo.Bh(true);
        this.PSM = new b(getContext(), 1);
        this.PSM.PSf = "@all.chatroom.contact";
        this.PUn = new com.tencent.mm.modelvoiceaddr.ui.b((byte) 0);
        this.PUn.a((b.a) new b.a() {
            /* class com.tencent.mm.ui.contact.ChatroomContactUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnA() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnB() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void SO(String str) {
                AppMethodBeat.i(37698);
                Log.d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", str);
                ChatroomContactUI.a(ChatroomContactUI.this, Util.escapeSqlValue(str));
                AppMethodBeat.o(37698);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bny() {
                AppMethodBeat.i(37699);
                ChatroomContactUI.this.yCT.setAdapter((ListAdapter) ChatroomContactUI.this.PUo);
                ChatroomContactUI.this.PUo.notifyDataSetChanged();
                ChatroomContactUI.this.PSM.CQ(false);
                ChatroomContactUI.this.PUm.setVisibility(8);
                AppMethodBeat.o(37699);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnz() {
                AppMethodBeat.i(37700);
                ChatroomContactUI.this.PUm.setVisibility(0);
                AppMethodBeat.o(37700);
            }

            @Override // com.tencent.mm.modelvoiceaddr.ui.b.a
            public final void biM() {
                AppMethodBeat.i(37701);
                Log.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
                ChatroomContactUI.this.hideVKB();
                AppMethodBeat.o(37701);
            }

            @Override // com.tencent.mm.modelvoiceaddr.ui.b.a
            public final void a(boolean z, String[] strArr, long j2, int i2) {
                AppMethodBeat.i(37702);
                Log.v("MicroMsg.ChatroomContactUI", "onVoiceReturn");
                if (z) {
                    Intent intent = new Intent(ChatroomContactUI.this.getContext(), VoiceSearchResultUI.class);
                    intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
                    intent.putExtra("VoiceSearchResultUI_VoiceId", j2);
                    intent.putExtra("VoiceSearchResultUI_ShowType", i2);
                    AppCompatActivity context = ChatroomContactUI.this.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(37702);
                    return;
                }
                Intent intent2 = new Intent(ChatroomContactUI.this.getContext(), VoiceSearchResultUI.class);
                intent2.putExtra("VoiceSearchResultUI_Resultlist", new String[0]);
                intent2.putExtra("VoiceSearchResultUI_Error", ChatroomContactUI.this.getContext().getString(R.string.dep));
                intent2.putExtra("VoiceSearchResultUI_VoiceId", j2);
                intent2.putExtra("VoiceSearchResultUI_ShowType", i2);
                AppCompatActivity context2 = ChatroomContactUI.this.getContext();
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context2.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(37702);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final boolean SN(String str) {
                return false;
            }
        });
        addSearchMenu(true, this.PUn);
        this.PUo.setGetViewPositionCallback(new MMSlideDelView.c() {
            /* class com.tencent.mm.ui.contact.ChatroomContactUI.AnonymousClass9 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.c
            public final int dr(View view) {
                AppMethodBeat.i(37703);
                int positionForView = ChatroomContactUI.this.yCT.getPositionForView(view);
                AppMethodBeat.o(37703);
                return positionForView;
            }
        });
        this.PUo.setPerformItemClickListener(new MMSlideDelView.g() {
            /* class com.tencent.mm.ui.contact.ChatroomContactUI.AnonymousClass10 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.g
            public final void r(View view, int i2, int i3) {
                AppMethodBeat.i(37704);
                ChatroomContactUI.this.yCT.performItemClick(view, i2, (long) i3);
                AppMethodBeat.o(37704);
            }
        });
        this.PUo.a(new MMSlideDelView.f() {
            /* class com.tencent.mm.ui.contact.ChatroomContactUI.AnonymousClass11 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.f
            public final void cZ(Object obj) {
                AppMethodBeat.i(37705);
                if (obj == null) {
                    Log.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
                    AppMethodBeat.o(37705);
                    return;
                }
                ChatroomContactUI.bns(obj.toString());
                ChatroomContactUI.g(ChatroomContactUI.this);
                AppMethodBeat.o(37705);
            }
        });
        this.yCT.setOnScrollListener(this.gup);
        this.PUo.KfF = this.gup;
        this.pqr = new a(getContext());
        this.yCT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.contact.ChatroomContactUI.AnonymousClass12 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                String searchContent;
                AppMethodBeat.i(37706);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Log.d("MicroMsg.ChatroomContactUI", "onItemClick " + i2 + (ChatroomContactUI.this.PSM == null ? ChatroomContactUI.this.PSM : Boolean.valueOf(ChatroomContactUI.this.PSM.QBl)));
                if (i2 < ChatroomContactUI.this.yCT.getHeaderViewsCount()) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(37706);
                    return;
                }
                int headerViewsCount = i2 - ChatroomContactUI.this.yCT.getHeaderViewsCount();
                if (ChatroomContactUI.this.PSM == null || !ChatroomContactUI.this.PSM.QBl) {
                    as asVar = (as) ChatroomContactUI.this.PUo.getItem(headerViewsCount);
                    if (asVar == null) {
                        Log.e("MicroMsg.ChatroomContactUI", "position=%s cont is null", Integer.valueOf(headerViewsCount));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(37706);
                        return;
                    }
                    if (ab.Iy(asVar.field_username)) {
                        gq gqVar = new gq();
                        gqVar.us(asVar.field_username);
                        gqVar.erw = 2;
                        gqVar.bfK();
                    }
                    ChatroomContactUI.b(ChatroomContactUI.this, asVar.field_username);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(37706);
                    return;
                }
                boolean Ox = ChatroomContactUI.this.PSM.Ox(headerViewsCount);
                boolean aot = ChatroomContactUI.this.PSM.aot(headerViewsCount);
                Log.d("MicroMsg.ChatroomContactUI", "onItemClick ".concat(String.valueOf(aot)));
                if (aot) {
                    com.tencent.mm.ui.voicesearch.b bVar2 = ChatroomContactUI.this.PSM;
                    if (ChatroomContactUI.this.PUn == null) {
                        searchContent = "";
                    } else {
                        searchContent = ChatroomContactUI.this.PUn.getSearchContent();
                    }
                    bVar2.boh(searchContent);
                } else if (Ox) {
                    drr aos = ChatroomContactUI.this.PSM.aos(headerViewsCount);
                    String str = aos.Lqk.MTo;
                    bg.aVF();
                    as Kn = c.aSN().Kn(str);
                    if (com.tencent.mm.contact.c.oR(Kn.field_type)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        intent.putExtra("Contact_Scene", 3);
                        if (str != null && str.length() > 0) {
                            if (Kn.gBM()) {
                                h.INSTANCE.kvStat(10298, str + ",3");
                            }
                            e.a(intent, str);
                            com.tencent.mm.br.c.b(ChatroomContactUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        }
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", aos.Lqk.MTo);
                        intent2.putExtra("Contact_Alias", aos.ked);
                        intent2.putExtra("Contact_Nick", aos.Mjj.MTo);
                        intent2.putExtra("Contact_Signature", aos.keb);
                        intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(aos.keh, aos.kdZ, aos.kea));
                        intent2.putExtra("Contact_Sex", aos.kdY);
                        intent2.putExtra("Contact_VUser_Info", aos.MmL);
                        intent2.putExtra("Contact_VUser_Info_Flag", aos.MmK);
                        intent2.putExtra("Contact_KWeibo_flag", aos.MmO);
                        intent2.putExtra("Contact_KWeibo", aos.MmM);
                        intent2.putExtra("Contact_KWeiboNick", aos.MmN);
                        intent2.putExtra("Contact_KSnsIFlag", aos.MmQ.kej);
                        intent2.putExtra("Contact_KSnsBgId", aos.MmQ.kel);
                        intent2.putExtra("Contact_KSnsBgUrl", aos.MmQ.kek);
                        if (aos.MmR != null) {
                            try {
                                intent2.putExtra("Contact_customInfo", aos.MmR.toByteArray());
                            } catch (IOException e2) {
                                Log.printErrStackTrace("MicroMsg.ChatroomContactUI", e2, "", new Object[0]);
                            }
                        }
                        if ((aos.MmK & 8) > 0) {
                            h.INSTANCE.kvStat(10298, str + ",3");
                        }
                        com.tencent.mm.br.c.b(ChatroomContactUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                    }
                } else {
                    as Ln = ChatroomContactUI.this.PSM.Ln(headerViewsCount);
                    if (Ln == null) {
                        Log.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", Integer.valueOf(ChatroomContactUI.this.PSM.getCount()), Integer.valueOf(headerViewsCount));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(37706);
                        return;
                    }
                    ac.u(ChatroomContactUI.this.PUn.getSearchContent(), 9, 3, headerViewsCount + 1);
                    String str2 = Ln.field_username;
                    if (ab.Iy(str2)) {
                        gq gqVar2 = new gq();
                        gqVar2.us(str2);
                        gqVar2.erw = 2;
                        gqVar2.bfK();
                    }
                    Intent intent3 = new Intent(ChatroomContactUI.this.getContext(), ChattingUI.class);
                    intent3.addFlags(67108864);
                    intent3.putExtra("Chat_User", str2);
                    intent3.putExtra("Chat_Mode", 1);
                    AppCompatActivity context = ChatroomContactUI.this.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/contact/ChatroomContactUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(37706);
            }
        });
        this.yCT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.ui.contact.ChatroomContactUI.AnonymousClass13 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(37707);
                Log.d("MicroMsg.ChatroomContactUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(i2)));
                if (i2 < ChatroomContactUI.this.yCT.getHeaderViewsCount()) {
                    Log.w("MicroMsg.ChatroomContactUI", "on item long click, but match header view");
                    AppMethodBeat.o(37707);
                    return true;
                } else if (ChatroomContactUI.this.PSM == null || !ChatroomContactUI.this.PSM.QBl) {
                    as asVar = (as) ChatroomContactUI.this.PUo.getItem(i2 - ChatroomContactUI.this.yCT.getHeaderViewsCount());
                    if (asVar == null) {
                        Log.w("MicroMsg.ChatroomContactUI", "null == ct position=%s", Integer.valueOf(i2));
                        AppMethodBeat.o(37707);
                        return false;
                    }
                    String str = asVar.field_username;
                    if (ab.Js(str) || ab.Jt(str)) {
                        AppMethodBeat.o(37707);
                        return true;
                    }
                    ChatroomContactUI.this.PSO = str;
                    ChatroomContactUI.this.pqr.a(view, i2, j2, ChatroomContactUI.this, ChatroomContactUI.this.rJj, ChatroomContactUI.this.ppd, ChatroomContactUI.this.ppe);
                    AppMethodBeat.o(37707);
                    return true;
                } else {
                    AppMethodBeat.o(37707);
                    return true;
                }
            }
        });
        this.yCT.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.contact.ChatroomContactUI.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(37692);
                switch (motionEvent.getAction()) {
                    case 0:
                        ChatroomContactUI.this.hideVKB();
                        ChatroomContactUI.this.ppd = (int) motionEvent.getRawX();
                        ChatroomContactUI.this.ppe = (int) motionEvent.getRawY();
                        break;
                }
                if (ChatroomContactUI.this.PUo != null) {
                    d dVar = ChatroomContactUI.this.PUo;
                    if (dVar.kex != null) {
                        dVar.kex.onTouchEvent(motionEvent);
                    }
                }
                if (ChatroomContactUI.this.PSM != null) {
                    com.tencent.mm.ui.voicesearch.b bVar = ChatroomContactUI.this.PSM;
                    if (bVar.kex != null) {
                        bVar.kex.onTouchEvent(motionEvent);
                    }
                }
                AppMethodBeat.o(37692);
                return false;
            }
        });
        ListView listView = this.yCT;
        ContactCountView contactCountView = new ContactCountView(this);
        this.PTa = contactCountView;
        listView.addFooterView(contactCountView, null, false);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.ChatroomContactUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(37693);
                ChatroomContactUI.this.finish();
                AppMethodBeat.o(37693);
                return false;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.ChatroomContactUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(37694);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ChatroomContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(ChatroomContactUI.this.yCT);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/ui/contact/ChatroomContactUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/ui/contact/ChatroomContactUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37694);
            }
        });
        this.yCT.setAdapter((ListAdapter) this.PUo);
        this.PSM.CQ(false);
        this.yCT.setVisibility(0);
        this.PUl = new VoiceSearchLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        this.PUl.setLayoutParams(layoutParams);
        this.PUl.setTopMargin(BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 100.0f));
        this.PUl.setVisibility(8);
        ((ViewGroup) findViewById(R.id.jai)).addView(this.PUl);
        if (this.PUl != null) {
            this.PUl.setOnVisibleChangeListener(new VoiceSearchLayout.b() {
                /* class com.tencent.mm.ui.contact.ChatroomContactUI.AnonymousClass5 */

                @Override // com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.b
                public final void fX(boolean z) {
                    AppMethodBeat.i(37696);
                    Log.d("MicroMsg.ChatroomContactUI", "visible ".concat(String.valueOf(z)));
                    if (z) {
                        int firstVisiblePosition = ChatroomContactUI.this.yCT.getFirstVisiblePosition();
                        Log.d("MicroMsg.ChatroomContactUI", "getFirstVisiblePosition  ".concat(String.valueOf(firstVisiblePosition)));
                        if (firstVisiblePosition > 0) {
                            ChatroomContactUI.this.yCT.post(new Runnable() {
                                /* class com.tencent.mm.ui.contact.ChatroomContactUI.AnonymousClass5.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(37695);
                                    ChatroomContactUI.this.yCT.setSelection(0);
                                    AppMethodBeat.o(37695);
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(37696);
                }
            });
        }
        if (this.PUo.getCount() == 0) {
            this.hSx.setSingleLine(false);
            this.hSx.setPadding(40, 0, 40, 0);
            this.hSx.setVisibility(0);
        }
        AppMethodBeat.o(37711);
    }

    static /* synthetic */ void bns(String str) {
        AppMethodBeat.i(37718);
        bg.aVF();
        as Kn = c.aSN().Kn(str);
        if (Kn == null) {
            Log.e("MicroMsg.ChatroomContactUI", "userName=%s get Contact is null", str);
            AppMethodBeat.o(37718);
        } else if (ab.Iy(str)) {
            Kn.aqR();
            ((r) g.af(r.class)).EI(Kn.field_username);
            bg.aVF();
            c.aSN().c(str, Kn);
            AppMethodBeat.o(37718);
        } else {
            Kn.aqR();
            ab.G(Kn);
            if (ab.Eq(str)) {
                bg.aVF();
                c.aSN().aNa(str);
                bg.aVF();
                c.aSX().Kj(str);
                AppMethodBeat.o(37718);
                return;
            }
            bg.aVF();
            c.aSN().c(str, Kn);
            AppMethodBeat.o(37718);
        }
    }

    static /* synthetic */ void a(ChatroomContactUI chatroomContactUI, String str) {
        AppMethodBeat.i(37719);
        if (str == null || str.length() <= 0) {
            if (chatroomContactUI.PTa != null) {
                chatroomContactUI.PTa.setVisible(true);
            }
        } else if (chatroomContactUI.PTa != null) {
            chatroomContactUI.PTa.setVisible(false);
        }
        if (str == null || str.length() == 0) {
            chatroomContactUI.yCT.setAdapter((ListAdapter) chatroomContactUI.PUo);
            chatroomContactUI.yCT.setBackgroundColor(chatroomContactUI.getResources().getColor(R.color.a74));
            chatroomContactUI.PUo.notifyDataSetChanged();
            chatroomContactUI.PSM.CQ(false);
            chatroomContactUI.PUo.anp();
            AppMethodBeat.o(37719);
            return;
        }
        chatroomContactUI.PUm.setVisibility(8);
        chatroomContactUI.yCT.setAdapter((ListAdapter) chatroomContactUI.PSM);
        chatroomContactUI.yCT.setBackgroundColor(chatroomContactUI.getResources().getColor(R.color.afz));
        chatroomContactUI.PSM.CQ(true);
        com.tencent.mm.ui.voicesearch.b bVar = chatroomContactUI.PSM;
        String boi = com.tencent.mm.ui.voicesearch.b.boi(str);
        if (boi != null && !boi.equals(bVar.BZP)) {
            bVar.aO(new Runnable() {
                /* class com.tencent.mm.ui.voicesearch.b.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(39542);
                    b.this.QBk = true;
                    b.this.iAd.clear();
                    AppMethodBeat.o(39542);
                }
            });
        }
        bVar.BZP = boi;
        bVar.Paj = null;
        if (bVar.BZP == null) {
            bVar.BZP = "";
        }
        bVar.ebf();
        bVar.vw(true);
        chatroomContactUI.PSM.notifyDataSetChanged();
        AppMethodBeat.o(37719);
    }

    static /* synthetic */ void b(ChatroomContactUI chatroomContactUI, String str) {
        AppMethodBeat.i(37721);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(37721);
        } else if (ab.Js(str)) {
            Log.e("MicroMsg.ChatroomContactUI", "error, 4.5 do not contain this contact %s", str);
            AppMethodBeat.o(37721);
        } else {
            Intent intent = new Intent(chatroomContactUI.getContext(), ChattingUI.class);
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", str);
            intent.putExtra("Chat_Mode", 1);
            intent.putExtra("specific_chat_from_scene", 10);
            intent.putExtra("chat_from_scene_for_group_chats", 4);
            AppCompatActivity context = chatroomContactUI.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/contact/ChatroomContactUI", "dealSelectContact", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/contact/ChatroomContactUI", "dealSelectContact", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if (str != null && str.length() > 0) {
                e.a(intent, str);
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(chatroomContactUI, bl2.axQ(), "com/tencent/mm/ui/contact/ChatroomContactUI", "dealSelectContact", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                chatroomContactUI.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(chatroomContactUI, "com/tencent/mm/ui/contact/ChatroomContactUI", "dealSelectContact", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(37721);
        }
    }
}
