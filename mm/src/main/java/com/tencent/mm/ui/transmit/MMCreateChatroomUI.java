package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.u;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.transmit.a;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MMCreateChatroomUI extends MMBaseSelectContactUI {
    private boolean PZd;
    private List<String> QxQ;
    private boolean QxZ;
    a Qya;
    private b Qyb;
    private boolean Qyc;
    private int scene;

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        AppMethodBeat.i(39241);
        super.amZ();
        this.QxQ = getIntent().getStringArrayListExtra("query_phrase_list");
        this.QxZ = getIntent().getBooleanExtra("go_to_chatroom_direct", false);
        this.scene = getIntent().getIntExtra("scene_from", 0);
        AppMethodBeat.o(39241);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(39242);
        super.initView();
        a aVar = this.Qya;
        for (String str : aVar.QxQ) {
            j jVar = new j();
            jVar.handler = aVar.handler;
            jVar.wWZ = aVar.Bdt;
            jVar.query = str;
            jVar.wWY = b.wXy;
            jVar.wWU = new int[]{131072};
            jVar.wWX.add("filehelper");
            jVar.wWX.add(z.aTY());
            a search = ((n) g.ah(n.class)).search(2, jVar);
            aVar.QxR = new ArrayList();
            aVar.QxR.add(search);
        }
        addTextOptionMenu(1, getString(R.string.x_), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.transmit.MMCreateChatroomUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39237);
                if (!MMCreateChatroomUI.this.PZd) {
                    MMCreateChatroomUI.this.PZd = true;
                    MMCreateChatroomUI.b(MMCreateChatroomUI.this);
                    if (MMCreateChatroomUI.this.scene == 3) {
                        MMCreateChatroomUI.this.Qyc = true;
                        l.pv(true);
                    }
                }
                Log.i("MicroMsg.MMCreateChatroomUI", "Create the chatroom");
                AppMethodBeat.o(39237);
                return true;
            }
        }, null, t.b.GREEN);
        ani();
        AppMethodBeat.o(39242);
    }

    public final void ani() {
        AppMethodBeat.i(39243);
        List<String> gYd = this.Qya.gYd();
        if (gYd.size() > 0) {
            updateOptionMenuText(1, getString(R.string.x_) + "(" + gYd.size() + ")");
            if (gYd.size() > 1) {
                enableOptionMenu(1, true);
                AppMethodBeat.o(39243);
                return;
            }
            enableOptionMenu(1, false);
            AppMethodBeat.o(39243);
            return;
        }
        updateOptionMenuText(1, getString(R.string.x_));
        enableOptionMenu(1, false);
        AppMethodBeat.o(39243);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(39244);
        this.Qya.finish();
        if (!this.Qyc && this.scene == 3) {
            l.pv(false);
        }
        super.onDestroy();
        AppMethodBeat.o(39244);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmz() {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmA() {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final String bmB() {
        AppMethodBeat.i(39245);
        String string = getString(R.string.gi9);
        AppMethodBeat.o(39245);
        return string;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q bmC() {
        AppMethodBeat.i(39246);
        if (this.Qya == null) {
            this.Qya = new a(this, this.QxQ, super.scene);
        }
        a aVar = this.Qya;
        AppMethodBeat.o(39246);
        return aVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        AppMethodBeat.i(39247);
        if (this.Qyb == null) {
            this.Qyb = new b(this, super.scene);
        }
        b bVar = this.Qyb;
        AppMethodBeat.o(39247);
        return bVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        a.C2134a aVar2;
        AppMethodBeat.i(39248);
        if (aVar instanceof e) {
            a aVar3 = this.Qya;
            String str = ((e) aVar).lqW.wVX;
            int i2 = aVar.position;
            if (aVar3.jVV.contains(str)) {
                int size = aVar3.QxS.size() - 1;
                while (true) {
                    if (size < 0) {
                        aVar2 = null;
                        break;
                    }
                    aVar2 = aVar3.QxS.get(size);
                    if (i2 >= aVar2.wXD) {
                        break;
                    }
                    size--;
                }
                if (aVar2 == null) {
                    AppMethodBeat.o(39248);
                    return false;
                } else if (!str.equals(aVar2.QxV)) {
                    AppMethodBeat.o(39248);
                    return true;
                }
            }
            AppMethodBeat.o(39248);
            return false;
        }
        AppMethodBeat.o(39248);
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(39249);
        if (aVar instanceof e) {
            a aVar2 = this.Qya;
            if (aVar2.jVV.contains(((e) aVar).lqW.wVX)) {
                AppMethodBeat.o(39249);
                return true;
            }
            AppMethodBeat.o(39249);
            return false;
        }
        AppMethodBeat.o(39249);
        return false;
    }

    private void a(final com.tencent.mm.roomsdk.a.c.a aVar) {
        AppMethodBeat.i(39250);
        aVar.d(new c() {
            /* class com.tencent.mm.ui.transmit.MMCreateChatroomUI.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.roomsdk.a.b.a] */
            @Override // com.tencent.mm.roomsdk.a.b.a
            public final /* synthetic */ void a(int i2, int i3, String str, c cVar) {
                AppMethodBeat.i(39238);
                c cVar2 = cVar;
                MMCreateChatroomUI.this.PZd = false;
                if (!z.a.a(MMCreateChatroomUI.this, i2, i3, str, 4)) {
                    if (i2 == 0 && i3 == 0 && !Util.isNullOrNil(this.chatroomName)) {
                        if (aVar.gvP()) {
                            u.a(this.chatroomName, cVar2.grX, MMCreateChatroomUI.this.getString(R.string.awr), false, "");
                        }
                        List<String> list = cVar2.dTa;
                        if (list != null && list.size() > 0) {
                            LinkedList linkedList = new LinkedList();
                            for (int i4 = 0; i4 < list.size(); i4++) {
                                linkedList.add(list.get(i4));
                            }
                            String str2 = "weixin://findfriend/verifycontact/" + this.chatroomName + FilePathGenerator.ANDROID_DIR_SEP;
                            if (aVar.gvP()) {
                                u.a(this.chatroomName, linkedList, MMCreateChatroomUI.this.getString(R.string.aws), true, str2);
                            }
                        }
                        MMCreateChatroomUI.a(MMCreateChatroomUI.this, this.chatroomName);
                    } else {
                        MMCreateChatroomUI.a(MMCreateChatroomUI.this, i2, i3, cVar2);
                        AppMethodBeat.o(39238);
                        return;
                    }
                }
                AppMethodBeat.o(39238);
            }
        });
        aVar.a(this, getString(R.string.zb), getString(R.string.edv), true, true, new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.transmit.MMCreateChatroomUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(39239);
                MMCreateChatroomUI.this.PZd = false;
                aVar.cancel();
                AppMethodBeat.o(39239);
            }
        });
        AppMethodBeat.o(39250);
    }

    private static List<String> V(List<String> list) {
        AppMethodBeat.i(39251);
        LinkedList linkedList = new LinkedList();
        if (!bg.aAc()) {
            AppMethodBeat.o(39251);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.o(39251);
            return linkedList;
        } else {
            for (String str : list) {
                bg.aVF();
                as Kn = com.tencent.mm.model.c.aSN().Kn(str);
                if (!(Kn == null || ((int) Kn.gMZ) == 0)) {
                    str = Kn.arJ();
                }
                linkedList.add(str);
            }
            AppMethodBeat.o(39251);
            return linkedList;
        }
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean gUY() {
        return true;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        AppMethodBeat.i(234470);
        a aVar = this.Qya;
        k kVar = this.Qyb.wWP;
        String str = this.Qyb.query;
        if (kVar.wXb.size() != 1 || !kVar.wXb.get(0).wVX.equals("no_result​")) {
            a.C2134a aVar2 = new a.C2134a(aVar, (byte) 0);
            aVar2.wXb = kVar.wXb;
            aVar2.wWd = kVar.wWd;
            aVar2.query = str;
            aVar.QxS.add(aVar2);
            int headerViewsCount = i2 - aVar.PWg.getContentLV().getHeaderViewsCount();
            if (headerViewsCount >= 3) {
                kVar.wXb.add(0, kVar.wXb.remove(headerViewsCount));
                i2 = aVar.PWg.getContentLV().getHeaderViewsCount();
            }
            aVar.gYc();
            aVar.PWg.getContentLV().post(new Runnable(aVar2.wXD + i2 + 1) {
                /* class com.tencent.mm.ui.transmit.a.AnonymousClass2 */
                final /* synthetic */ int QxU;

                {
                    this.QxU = r2;
                }

                public final void run() {
                    AppMethodBeat.i(39221);
                    a.a(a.this, this.QxU);
                    AppMethodBeat.o(39221);
                }
            });
        }
        gUW();
        gUX();
        hideVKB();
        AppMethodBeat.o(234470);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c
    public final void T(int i2, String str) {
        AppMethodBeat.i(39253);
        if (i2 == 1) {
            a aVar = this.Qya;
            aVar.jVV.remove(str);
            for (a.C2134a aVar2 : aVar.QxS) {
                if (str.equals(aVar2.QxV)) {
                    aVar2.QxV = null;
                }
            }
            aVar.notifyDataSetChanged();
            ani();
        }
        AppMethodBeat.o(39253);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final /* bridge */ /* synthetic */ q gUQ() {
        return this.Qya;
    }

    static /* synthetic */ void b(MMCreateChatroomUI mMCreateChatroomUI) {
        boolean z;
        AppMethodBeat.i(39254);
        List<String> gYd = mMCreateChatroomUI.Qya.gYd();
        Iterator<String> it = gYd.iterator();
        while (true) {
            if (it.hasNext()) {
                if (as.bjp(it.next())) {
                    z = false;
                    break;
                }
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            mMCreateChatroomUI.a(com.tencent.mm.roomsdk.a.b.bhF("@chatroom").a("", gYd));
            AppMethodBeat.o(39254);
            return;
        }
        mMCreateChatroomUI.a(com.tencent.mm.roomsdk.a.b.bhF("@im.chatroom").a("", gYd));
        AppMethodBeat.o(39254);
    }

    static /* synthetic */ void a(MMCreateChatroomUI mMCreateChatroomUI, int i2, int i3, c cVar) {
        String str;
        boolean z;
        AppMethodBeat.i(39255);
        String str2 = "";
        String str3 = "";
        String string = MMApplicationContext.getContext().getString(R.string.awt);
        if (i3 == -23) {
            str2 = mMCreateChatroomUI.getString(R.string.g84);
            str3 = mMCreateChatroomUI.getString(R.string.g83);
        }
        List<String> list = cVar.dTa;
        List<String> list2 = cVar.grY;
        if (list == null || list.size() <= 0 || (list.size() != cVar.dRN && (list2 == null || list2.size() <= 0 || cVar.dRN != list.size() + list2.size()))) {
            List<String> list3 = cVar.grY;
            if (list3 == null || list3.size() <= 0 || cVar.dRN != list3.size()) {
                str = str3;
            } else {
                str2 = mMCreateChatroomUI.getString(R.string.edt);
                str = str3 + mMCreateChatroomUI.getString(R.string.deq, new Object[]{Util.listToString(V(list3), string)});
            }
            List<String> list4 = cVar.dSX;
            if (list4 != null && list4.size() > 0) {
                Iterator<String> it = list4.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (as.bjp(it.next())) {
                            str2 = mMCreateChatroomUI.getString(R.string.edt);
                            str = mMCreateChatroomUI.getString(R.string.edu);
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    str2 = mMCreateChatroomUI.getString(R.string.edt);
                    str = str + mMCreateChatroomUI.getString(R.string.det, new Object[]{Util.listToString(V(list4), string)});
                }
            }
            if (str2 == null || str2.length() <= 0) {
                Toast.makeText(mMCreateChatroomUI, mMCreateChatroomUI.getString(R.string.deb, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                AppMethodBeat.o(39255);
                return;
            }
            h.c(mMCreateChatroomUI, str, str2, true);
            AppMethodBeat.o(39255);
            return;
        }
        final LinkedList linkedList = new LinkedList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            linkedList.add(list.get(i4));
        }
        Assert.assertTrue(linkedList.size() > 0);
        String string2 = MMApplicationContext.getContext().getString(R.string.awt);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(linkedList);
        arrayList.addAll(list2);
        h.a((Context) mMCreateChatroomUI, mMCreateChatroomUI.getString(R.string.df2, new Object[]{Util.listToString(V(arrayList), string2)}), mMCreateChatroomUI.getString(R.string.edt), mMCreateChatroomUI.getString(R.string.df1), mMCreateChatroomUI.getString(R.string.df0), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.transmit.MMCreateChatroomUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(39240);
                MMCreateChatroomUI.a(MMCreateChatroomUI.this, linkedList);
                AppMethodBeat.o(39240);
            }
        }, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(39255);
    }

    static /* synthetic */ void a(MMCreateChatroomUI mMCreateChatroomUI, String str) {
        AppMethodBeat.i(39256);
        Intent intent = new Intent();
        if (mMCreateChatroomUI.QxZ) {
            intent.putExtra("Chat_User", str);
            com.tencent.mm.br.c.f(mMCreateChatroomUI, ".ui.chatting.ChattingUI", intent);
        } else {
            intent.putExtra("Select_Contact", str);
            intent.putExtra("Select_Conv_User", str);
            intent.putExtra("Select_Contact", str);
            intent.putExtra("need_delete_chatroom_when_cancel", true);
            mMCreateChatroomUI.setResult(-1, intent);
        }
        mMCreateChatroomUI.finish();
        AppMethodBeat.o(39256);
    }

    static /* synthetic */ void a(MMCreateChatroomUI mMCreateChatroomUI, LinkedList linkedList) {
        AppMethodBeat.i(39257);
        Assert.assertTrue(linkedList.size() > 0);
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            linkedList2.add(3);
        }
        new aa(mMCreateChatroomUI, new aa.a() {
            /* class com.tencent.mm.ui.transmit.MMCreateChatroomUI.AnonymousClass5 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.aa.a
            /* renamed from: do  reason: not valid java name */
            public final void m44do(boolean z) {
            }
        }).a(linkedList, linkedList2, null);
        AppMethodBeat.o(39257);
    }
}
