package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.config.ae;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.conversation.e;
import com.tencent.mm.ui.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class ServiceNotifyConversationUI extends MMActivity {
    private String Qbv;
    private ListView Qhj;
    private a Qhk;
    private i.a Qhl;
    private az conversation;
    private TextView emptyTipTv;
    private String iNV;
    private String talker = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(234275);
        super.onCreate(bundle);
        if (!bg.aAc()) {
            Log.e("MicroMsg.ServiceNotifyConversationUI", "onCreate acc not ready!!!");
            finish();
            AppMethodBeat.o(234275);
            return;
        }
        this.iNV = "notifymessage";
        this.Qbv = getIntent().getStringExtra("enterprise_biz_display_name");
        if (Util.isNullOrNil(this.Qbv)) {
            this.Qbv = getString(R.string.dyf);
        }
        initView();
        removeAllOptionMenu();
        addIconOptionMenu(0, R.string.d0, R.raw.actionbar_setting_icon, false, (MenuItem.OnMenuItemClickListener) new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.conversation.ServiceNotifyConversationUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(234258);
                Intent intent = new Intent(ServiceNotifyConversationUI.this.getContext(), ServiceNotifySettingsUI.class);
                intent.putExtra("mode", 0);
                intent.putExtra("from_scene", "scene_service_notify_conversation");
                ServiceNotifyConversationUI serviceNotifyConversationUI = ServiceNotifyConversationUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(serviceNotifyConversationUI, bl.axQ(), "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                serviceNotifyConversationUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(serviceNotifyConversationUI, "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                h.INSTANCE.a(21825, 2, null, Long.valueOf(Util.nowSecond()), null, null, 0, 0, 0);
                AppMethodBeat.o(234258);
                return true;
            }
        });
        bg.aVF();
        c.aST().add(this.Qhk);
        this.Qhl = new i.a() {
            /* class com.tencent.mm.ui.conversation.ServiceNotifyConversationUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i.a
            public final void a(i iVar, i.c cVar) {
                AppMethodBeat.i(234256);
                if (!(iVar == null || cVar.hIs == null)) {
                    Iterator<ca> it = cVar.hIs.iterator();
                    while (it.hasNext()) {
                        ca next = it.next();
                        if (next != null && "notifymessage".equals(cVar.talker)) {
                            bg.aVF();
                            c.getNotifyMessageRecordStorage();
                            String bc = cf.bc(next);
                            if (!Util.isNullOrNil(bc) && ServiceNotifyConversationUI.this.Qhk != null) {
                                ServiceNotifyConversationUI.this.Qhk.onNotifyChange(bc, null);
                            }
                        }
                    }
                }
                AppMethodBeat.o(234256);
            }
        };
        ((l) g.af(l.class)).eiy().a(this.Qhl, Looper.getMainLooper());
        AppMethodBeat.o(234275);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c3f;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(234276);
        if (this.Qhl != null) {
            ((l) g.af(l.class)).eiy().a(this.Qhl);
            this.Qhl = null;
        }
        if (bg.aAc()) {
            bg.aVF();
            c.aST().remove(this.Qhk);
        }
        if (this.Qhk != null) {
            this.Qhk.onDestroy();
        }
        super.onDestroy();
        AppMethodBeat.o(234276);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(234277);
        Log.v("MicroMsg.ServiceNotifyConversationUI", "on resume");
        if (this.Qhk != null) {
            this.Qhk.onResume();
        }
        super.onResume();
        AppMethodBeat.o(234277);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(234278);
        Log.i("MicroMsg.ServiceNotifyConversationUI", "on pause");
        if (this.Qhk != null) {
            this.Qhk.onPause();
        }
        super.onPause();
        AppMethodBeat.o(234278);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(234280);
        super.onActivityResult(i2, i3, intent);
        if (this.talker != null && !this.talker.isEmpty()) {
            this.talker = "";
        }
        if (i3 != -1) {
            AppMethodBeat.o(234280);
        } else {
            AppMethodBeat.o(234280);
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public int Qho;
        public int Qhp;
        public int Qhq;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends e {
        private Set<String> Qhn = new HashSet();
        private String username;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
        @Override // com.tencent.mm.ui.s, com.tencent.mm.ui.conversation.e
        public final /* bridge */ /* synthetic */ az a(az azVar, Cursor cursor) {
            AppMethodBeat.i(234274);
            az a2 = a(azVar, cursor);
            AppMethodBeat.o(234274);
            return a2;
        }

        public a(Context context, String str, s.a aVar) {
            super(context, aVar);
            AppMethodBeat.i(234266);
            this.username = str;
            AppMethodBeat.o(234266);
        }

        @Override // com.tencent.mm.ui.s, com.tencent.mm.ui.conversation.e
        public final void anp() {
            AppMethodBeat.i(234267);
            ebf();
            bg.aVF();
            setCursor(c.getNotifyMessageRecordStorage().gEk());
            if (this.OFI != null) {
                this.OFI.bnE();
            }
            super.notifyDataSetChanged();
            AppMethodBeat.o(234267);
        }

        @Override // com.tencent.mm.ui.conversation.e
        public final az a(az azVar, Cursor cursor) {
            long j2;
            String str;
            AppMethodBeat.i(234268);
            if (azVar == null) {
                azVar = new az();
            }
            azVar.setUsername(s(cursor));
            int columnIndex = cursor.getColumnIndex("createTime");
            if (columnIndex >= 0) {
                j2 = cursor.getLong(columnIndex);
            } else {
                j2 = 0;
            }
            azVar.yA(j2);
            int columnIndex2 = cursor.getColumnIndex("digest");
            if (columnIndex2 >= 0) {
                str = cursor.getString(columnIndex2);
            } else {
                str = null;
            }
            azVar.Cm(str);
            azVar.Co("notifymessage");
            azVar.setStatus(2);
            azVar.nv(1);
            azVar.nt(0);
            azVar.Cl(Integer.toString(1));
            azVar.Cn("");
            AppMethodBeat.o(234268);
            return azVar;
        }

        @Override // com.tencent.mm.ui.conversation.e
        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(234269);
            View view2 = super.getView(i2, view, viewGroup);
            e.g gVar = (e.g) view2.getTag();
            if (gVar.PaE.getText() == null) {
                AppMethodBeat.o(234269);
                return view2;
            }
            String charSequence = gVar.PaE.getText().toString();
            String str = null;
            if (as.HF(charSequence)) {
                ae Xr = y.Xr(charSequence);
                if (Xr != null) {
                    str = Xr.nickname;
                }
            } else {
                str = aa.getDisplayName(charSequence);
            }
            if (!Util.nullAsNil(charSequence).equals(str)) {
                gVar.PaE.setText(str);
            }
            AppMethodBeat.o(234269);
            return view2;
        }

        @Override // com.tencent.mm.ui.conversation.e
        public final void onDestroy() {
            b bVar;
            AppMethodBeat.i(234271);
            Cursor cursor = getCursor();
            if (cursor != null) {
                if (cursor == null || cursor.isClosed() || !cursor.moveToFirst()) {
                    bVar = null;
                } else {
                    HashSet<String> hashSet = new HashSet();
                    do {
                        String s = s(cursor);
                        if (!Util.isNullOrNil(s)) {
                            hashSet.add(s);
                        }
                    } while (cursor.moveToNext());
                    b bVar2 = new b((byte) 0);
                    if (!hashSet.isEmpty()) {
                        for (String str : hashSet) {
                            if (as.HF(str)) {
                                bVar2.Qho++;
                            } else if (Util.nullAsNil(str).startsWith("gh_")) {
                                bVar2.Qhp++;
                            } else {
                                bVar2.Qhq++;
                            }
                        }
                    }
                    bVar = bVar2;
                }
                if (bVar != null) {
                    h.INSTANCE.a(21825, 4, null, Long.valueOf(Util.nowSecond()), bVar == null ? null : String.format(Locale.US, "%d,%d,%d", Integer.valueOf(bVar.Qhp), Integer.valueOf(bVar.Qho), Integer.valueOf(bVar.Qhq)), null, 0, 0, 0);
                }
            }
            super.onDestroy();
            AppMethodBeat.o(234271);
        }

        public static void n(az azVar) {
            AppMethodBeat.i(234272);
            h.INSTANCE.a(21825, 5, azVar.field_username, Long.valueOf(Util.nowSecond()), null, null, 0, 0, 0);
            AppMethodBeat.o(234272);
        }

        private static String s(Cursor cursor) {
            AppMethodBeat.i(234273);
            int columnIndex = cursor.getColumnIndex("talker");
            if (columnIndex >= 0) {
                String string = cursor.getString(columnIndex);
                AppMethodBeat.o(234273);
                return string;
            }
            AppMethodBeat.o(234273);
            return null;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.conversation.e
        public final void a(az azVar, boolean z, int i2, boolean z2) {
            AppMethodBeat.i(234270);
            if (Util.isNullOrNil(azVar.field_username)) {
                AppMethodBeat.o(234270);
                return;
            }
            this.Qhn.add(azVar.field_username);
            AppMethodBeat.o(234270);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(234279);
        setMMTitle(this.Qbv);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.conversation.ServiceNotifyConversationUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(234259);
                ServiceNotifyConversationUI.this.finish();
                AppMethodBeat.o(234259);
                return true;
            }
        });
        setTitleBarDoubleClickListener(new Runnable() {
            /* class com.tencent.mm.ui.conversation.ServiceNotifyConversationUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(234260);
                if (ServiceNotifyConversationUI.this.activityHasDestroyed() || ServiceNotifyConversationUI.this.isFinishing()) {
                    AppMethodBeat.o(234260);
                    return;
                }
                ServiceNotifyConversationUI.b(ServiceNotifyConversationUI.this);
                AppMethodBeat.o(234260);
            }
        });
        this.Qhj = (ListView) findViewById(R.id.ir8);
        this.emptyTipTv = (TextView) findViewById(R.id.c30);
        this.emptyTipTv.setText(R.string.fgs);
        this.Qhk = new a(this, this.iNV, new s.a() {
            /* class com.tencent.mm.ui.conversation.ServiceNotifyConversationUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.s.a
            public final void bnE() {
                AppMethodBeat.i(234261);
                ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this, ServiceNotifyConversationUI.this.Qhk.getCount());
                AppMethodBeat.o(234261);
            }
        });
        this.Qhk.setGetViewPositionCallback(new MMSlideDelView.c() {
            /* class com.tencent.mm.ui.conversation.ServiceNotifyConversationUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.c
            public final int dr(View view) {
                AppMethodBeat.i(234262);
                int positionForView = ServiceNotifyConversationUI.this.Qhj.getPositionForView(view);
                AppMethodBeat.o(234262);
                return positionForView;
            }
        });
        this.Qhk.setPerformItemClickListener(new MMSlideDelView.g() {
            /* class com.tencent.mm.ui.conversation.ServiceNotifyConversationUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.g
            public final void r(View view, int i2, int i3) {
                AppMethodBeat.i(234263);
                ServiceNotifyConversationUI.this.Qhj.performItemClick(view, i2, (long) i3);
                AppMethodBeat.o(234263);
            }
        });
        this.Qhj.setAdapter((ListAdapter) this.Qhk);
        this.Qhj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.conversation.ServiceNotifyConversationUI.AnonymousClass9 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                String str;
                AppMethodBeat.i(234264);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                ServiceNotifyConversationUI.this.conversation = (az) ServiceNotifyConversationUI.this.Qhk.getItem(i2);
                ServiceNotifyConversationUI.this.talker = ServiceNotifyConversationUI.this.conversation.field_username;
                az azVar = ServiceNotifyConversationUI.this.conversation;
                if (azVar == null) {
                    Log.e("MicroMsg.ServiceNotifyConversationUI", "user should not be null. position:%d, size:%d", Integer.valueOf(i2), Integer.valueOf(ServiceNotifyConversationUI.this.Qhk.getCount()));
                    ServiceNotifyConversationUI.this.Qhk.notifyDataSetChanged();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(234264);
                    return;
                }
                Intent intent = new Intent(ServiceNotifyConversationUI.this, ChattingUI.class);
                if (Util.isNullOrNil(azVar.field_parentRef)) {
                    str = azVar.field_username;
                } else {
                    str = azVar.field_parentRef;
                }
                intent.putExtra("Chat_User", str);
                intent.putExtra("key_notify_message_real_username", azVar.field_username);
                intent.putExtra("finish_direct", true);
                intent.putExtra("biz_click_item_unread_count", ServiceNotifyConversationUI.this.conversation.field_unReadCount);
                intent.putExtra("biz_click_item_position", i2 + 1);
                intent.putExtra("KOpenArticleSceneFromScene", 92);
                intent.putExtra("specific_chat_from_scene", 6);
                ServiceNotifyConversationUI serviceNotifyConversationUI = ServiceNotifyConversationUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(serviceNotifyConversationUI, bl.axQ(), "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                serviceNotifyConversationUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(serviceNotifyConversationUI, "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                a unused = ServiceNotifyConversationUI.this.Qhk;
                a.n(azVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(234264);
            }
        });
        this.Qhk.setGetViewPositionCallback(new MMSlideDelView.c() {
            /* class com.tencent.mm.ui.conversation.ServiceNotifyConversationUI.AnonymousClass10 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.c
            public final int dr(View view) {
                AppMethodBeat.i(234265);
                int positionForView = ServiceNotifyConversationUI.this.Qhj.getPositionForView(view);
                AppMethodBeat.o(234265);
                return positionForView;
            }
        });
        this.Qhk.setPerformItemClickListener(new MMSlideDelView.g() {
            /* class com.tencent.mm.ui.conversation.ServiceNotifyConversationUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.g
            public final void r(View view, int i2, int i3) {
                AppMethodBeat.i(234257);
                ServiceNotifyConversationUI.this.Qhj.performItemClick(view, i2, (long) i3);
                AppMethodBeat.o(234257);
            }
        });
        AppMethodBeat.o(234279);
    }

    static /* synthetic */ void b(ServiceNotifyConversationUI serviceNotifyConversationUI) {
        AppMethodBeat.i(234281);
        if (!(serviceNotifyConversationUI.Qhk == null || serviceNotifyConversationUI.Qhj == null || serviceNotifyConversationUI.Qhk.getCount() <= 0)) {
            serviceNotifyConversationUI.Qhj.setSelection(0);
        }
        AppMethodBeat.o(234281);
    }

    static /* synthetic */ void a(ServiceNotifyConversationUI serviceNotifyConversationUI, int i2) {
        AppMethodBeat.i(234282);
        if (i2 <= 0) {
            serviceNotifyConversationUI.emptyTipTv.setVisibility(0);
            serviceNotifyConversationUI.Qhj.setVisibility(8);
            AppMethodBeat.o(234282);
            return;
        }
        serviceNotifyConversationUI.emptyTipTv.setVisibility(8);
        serviceNotifyConversationUI.Qhj.setVisibility(0);
        AppMethodBeat.o(234282);
    }
}
