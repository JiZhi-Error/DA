package com.tencent.mm.ui.voicesearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.s;
import java.util.LinkedList;

public class SearchConversationResultUI extends MMActivity {
    private ListView QBe;
    private a QBf;
    private String QBg = null;
    private TextView qqJ;
    private String username;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SearchConversationResultUI searchConversationResultUI, Class cls, Intent intent) {
        AppMethodBeat.i(39529);
        searchConversationResultUI.startActivity(cls, intent);
        AppMethodBeat.o(39529);
    }

    static /* synthetic */ void b(SearchConversationResultUI searchConversationResultUI, Class cls, Intent intent) {
        AppMethodBeat.i(39530);
        searchConversationResultUI.startActivity(cls, intent);
        AppMethodBeat.o(39530);
    }

    static /* synthetic */ void c(SearchConversationResultUI searchConversationResultUI, Class cls, Intent intent) {
        AppMethodBeat.i(39531);
        searchConversationResultUI.startActivity(cls, intent);
        AppMethodBeat.o(39531);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39525);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(39525);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(39526);
        this.QBe = (ListView) findViewById(R.id.ja1);
        this.qqJ = (TextView) findViewById(R.id.c3h);
        this.QBf = new a(getApplicationContext(), new s.a() {
            /* class com.tencent.mm.ui.voicesearch.SearchConversationResultUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.s.a
            public final void bnE() {
            }
        });
        if (this.QBf != null) {
            this.QBf.jB(new LinkedList());
        }
        this.QBe.setAdapter((ListAdapter) this.QBf);
        this.qqJ.setVisibility(8);
        this.username = getIntent().getStringExtra("SearchConversationResult_User");
        this.QBg = getIntent().getStringExtra("SearchConversationResult_Error");
        setMMTitle(getString(R.string.i06));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.voicesearch.SearchConversationResultUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39523);
                SearchConversationResultUI.this.finish();
                AppMethodBeat.o(39523);
                return true;
            }
        });
        this.QBe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.voicesearch.SearchConversationResultUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(39524);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/ui/voicesearch/SearchConversationResultUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (i2 < SearchConversationResultUI.this.QBe.getHeaderViewsCount()) {
                    a.a(this, "com/tencent/mm/ui/voicesearch/SearchConversationResultUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(39524);
                    return;
                }
                int headerViewsCount = i2 - SearchConversationResultUI.this.QBe.getHeaderViewsCount();
                az azVar = (az) SearchConversationResultUI.this.QBf.getItem(headerViewsCount);
                if (azVar == null) {
                    Log.e("MicroMsg.VoiceSearchResultUI", "null user at position = ".concat(String.valueOf(headerViewsCount)));
                    a.a(this, "com/tencent/mm/ui/voicesearch/SearchConversationResultUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(39524);
                    return;
                }
                Log.d("MicroMsg.VoiceSearchResultUI", "username " + azVar.field_username);
                if (ab.IY(azVar.field_username)) {
                    if (z.aUw()) {
                        c.b(SearchConversationResultUI.this.getContext(), "tmessage", ".ui.TConversationUI", new Intent().putExtra("finish_direct", true));
                    } else {
                        c.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
                    }
                } else if (ab.Ja(azVar.field_username)) {
                    if (z.aUt()) {
                        c.b(SearchConversationResultUI.this.getContext(), "qmessage", ".ui.QConversationUI", new Intent().putExtra("finish_direct", true));
                    } else {
                        c.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
                    }
                } else if (ab.IZ(azVar.field_username)) {
                    c.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
                } else if (ab.Je(azVar.field_username)) {
                    MMAppMgr.cancelNotification(azVar.field_username);
                    c.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
                } else if (ab.IW(azVar.field_username)) {
                    if (z.aUH()) {
                        SearchConversationResultUI.a(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", azVar.field_username).putExtra("finish_direct", true));
                    } else {
                        c.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
                    }
                } else if (ab.Jj(azVar.field_username)) {
                    if (z.aUA()) {
                        Intent intent = new Intent();
                        intent.putExtra("type", 20);
                        c.b(SearchConversationResultUI.this, "readerapp", ".ui.ReaderAppUI", intent);
                    } else {
                        c.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
                    }
                } else if (ab.Jr(azVar.field_username)) {
                    if (z.aUB()) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("type", 11);
                        c.b(SearchConversationResultUI.this, "readerapp", ".ui.ReaderAppUI", intent2);
                    } else {
                        c.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
                    }
                } else if (ab.Jb(azVar.field_username)) {
                    c.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
                } else if (ab.Jc(azVar.field_username)) {
                    if (z.aUD()) {
                        c.b(SearchConversationResultUI.this, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                    } else {
                        c.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
                    }
                } else if (ab.Ji(azVar.field_username)) {
                    if (z.aUx()) {
                        SearchConversationResultUI.b(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", azVar.field_username).putExtra("finish_direct", true));
                    } else {
                        c.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
                    }
                } else if (ab.Jg(SearchConversationResultUI.this.username) || ab.Jh(SearchConversationResultUI.this.username) || ab.Jd(SearchConversationResultUI.this.username) || ab.Jl(SearchConversationResultUI.this.username) || ab.Jm(SearchConversationResultUI.this.username) || ab.IX(SearchConversationResultUI.this.username) || ab.Ju(SearchConversationResultUI.this.username)) {
                    c.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", azVar.field_username));
                } else {
                    SearchConversationResultUI.c(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", azVar.field_username).putExtra("finish_direct", true));
                }
                a.a(this, "com/tencent/mm/ui/voicesearch/SearchConversationResultUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(39524);
            }
        });
        String str = this.username;
        this.qqJ.setVisibility(8);
        if (this.QBf != null) {
            this.QBf.SM(str);
        }
        AppMethodBeat.o(39526);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(39527);
        super.onDestroy();
        this.QBf.ebf();
        AppMethodBeat.o(39527);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(39528);
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(39528);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c6u;
    }
}
