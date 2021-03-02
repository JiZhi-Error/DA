package com.tencent.mm.ui.voicesearch;

import android.content.Intent;
import android.database.Cursor;
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
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class VoiceSearchResultUI extends MMActivity {
    private ListView QBe;
    private String QBg = null;
    private b QBr;
    private String[] QBs;
    private boolean QBt = false;
    boolean QBu = false;
    int dDG = 1;
    private int dYn = 2;
    private TextView qqJ;
    private int sOB = -1;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39576);
        super.onCreate(bundle);
        initView();
        this.QBt = false;
        AppMethodBeat.o(39576);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(39577);
        this.QBe = (ListView) findViewById(R.id.ja1);
        this.qqJ = (TextView) findViewById(R.id.c3h);
        this.QBs = getIntent().getStringArrayExtra("VoiceSearchResultUI_Resultlist");
        this.QBg = getIntent().getStringExtra("VoiceSearchResultUI_Error");
        this.sOB = getIntent().getIntExtra("VoiceSearchResultUI_VoiceId", -1);
        this.dDG = getIntent().getIntExtra("VoiceSearchResultUI_ShowType", 1);
        this.dYn = this.dDG == 1 ? 2 : 1;
        this.QBu = getIntent().getBooleanExtra("VoiceSearchResultUI_IsVoiceControl", false);
        Log.i("MicroMsg.VoiceSearchResultUI", "showType = %s, isVoiceControl = %s", Integer.valueOf(this.dDG), Boolean.valueOf(this.QBu));
        this.QBr = new b(getApplicationContext(), this.dDG);
        this.QBr.CR(false);
        LinkedList linkedList = new LinkedList();
        switch (this.dDG) {
            case 2:
                linkedList.add("lbsapp");
                linkedList.add("shakeapp");
                linkedList.add("qqfriend");
                linkedList.add("facebookapp");
                linkedList.add("feedsapp");
                linkedList.add("fmessage");
                linkedList.add("voipapp");
                linkedList.add("voicevoipapp");
                linkedList.add("voiceinputapp");
                linkedList.add("linkedinplugin");
                linkedList.add("notifymessage");
                linkedList.add("appbrand_notify_message");
                int aUl = z.aUl();
                if ((aUl & 1) != 0) {
                    linkedList.add("qqmail");
                }
                if (!ab.aUY() || (aUl & 2) != 0) {
                    linkedList.add("tmessage");
                }
                if ((aUl & 32) != 0) {
                    linkedList.add("qmessage");
                }
                if ((aUl & 128) != 0) {
                    linkedList.add("qqsync");
                }
                if ((aUl & 16) != 0) {
                    linkedList.add("medianote");
                }
                if ((524288 & aUl) != 0) {
                    linkedList.add("newsapp");
                }
                if ((262144 & aUl) != 0 || !ab.aUX()) {
                    linkedList.add("blogapp");
                }
                if ((aUl & 65536) != 0) {
                    linkedList.add("masssendapp");
                }
                linkedList.add("voiceinputapp");
                break;
        }
        if (this.QBr != null) {
            this.QBr.jB(linkedList);
        }
        this.QBe.setAdapter((ListAdapter) this.QBr);
        this.qqJ.setVisibility(8);
        Log.d("MicroMsg.VoiceSearchResultUI", "voiceId  " + this.sOB);
        if (this.dDG == 2) {
            setMMTitle("");
            this.QBs = aa(this.QBs);
        } else {
            setMMTitle(getString(R.string.i06));
        }
        setMMTitle(getString(R.string.i06));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.voicesearch.VoiceSearchResultUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39574);
                if (!VoiceSearchResultUI.this.QBt) {
                    h.INSTANCE.kvStat(10452, VoiceSearchResultUI.this.dYn + "," + VoiceSearchResultUI.this.sOB + "," + (VoiceSearchResultUI.this.QBs == null ? 0 : VoiceSearchResultUI.this.QBs.length) + ",0");
                }
                if (VoiceSearchResultUI.this.QBu) {
                    VoiceSearchResultUI.this.moveTaskToBack(true);
                }
                VoiceSearchResultUI.this.finish();
                AppMethodBeat.o(39574);
                return true;
            }
        });
        this.QBe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.voicesearch.VoiceSearchResultUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                int length;
                AppMethodBeat.i(39575);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/ui/voicesearch/VoiceSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (!VoiceSearchResultUI.this.QBt) {
                    h hVar = h.INSTANCE;
                    StringBuilder append = new StringBuilder().append(VoiceSearchResultUI.this.dYn).append(",").append(VoiceSearchResultUI.this.sOB).append(",");
                    if (VoiceSearchResultUI.this.QBs == null) {
                        length = 0;
                    } else {
                        length = VoiceSearchResultUI.this.QBs.length;
                    }
                    hVar.kvStat(10452, append.append(length).append(",").append(i2).toString());
                }
                as Ln = VoiceSearchResultUI.this.QBr.Ln(i2);
                VoiceSearchResultUI voiceSearchResultUI = VoiceSearchResultUI.this;
                String str = Ln.field_username;
                String arJ = Ln.arJ();
                if (str != null && str.length() > 0) {
                    Log.d("MicroMsg.VoiceSearchResultUI", "dealSelectContact ".concat(String.valueOf(str)));
                    if (voiceSearchResultUI.dDG == 3) {
                        Intent intent = new Intent();
                        intent.putExtra("Select_Conv_User", str);
                        voiceSearchResultUI.setResult(-1, intent);
                        voiceSearchResultUI.finish();
                    } else if (voiceSearchResultUI.dDG != 1 && !ab.JF(str) && !ab.IT(str) && !ab.Eq(str) && !ab.IQ(str) && !VoiceSearchResultUI.bok(arJ)) {
                        Intent intent2 = new Intent(voiceSearchResultUI, SearchConversationResultUI.class);
                        intent2.putExtra("SearchConversationResult_User", arJ);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                        a.a(voiceSearchResultUI, bl.axQ(), "com/tencent/mm/ui/voicesearch/VoiceSearchResultUI", "dealSelectContact", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        voiceSearchResultUI.startActivity((Intent) bl.pG(0));
                        a.a(voiceSearchResultUI, "com/tencent/mm/ui/voicesearch/VoiceSearchResultUI", "dealSelectContact", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    } else if (voiceSearchResultUI.dDG == 1) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("Contact_User", str);
                        if (ab.IQ(str)) {
                            intent3.putExtra("Is_group_card", true);
                        }
                        if (str != null && str.length() > 0) {
                            e.a(intent3, str);
                            if (voiceSearchResultUI.QBu) {
                                voiceSearchResultUI.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                                voiceSearchResultUI.finish();
                            } else {
                                c.b(voiceSearchResultUI, Scopes.PROFILE, ".ui.ContactInfoUI", intent3);
                            }
                        }
                    } else if (voiceSearchResultUI.dDG == 2) {
                        if (Util.isNullOrNil(str)) {
                            Log.e("MicroMsg.VoiceSearchResultUI", "username is null ".concat(String.valueOf(str)));
                        } else if (ab.IY(str)) {
                            if (z.aUw()) {
                                c.b(voiceSearchResultUI.getContext(), "tmessage", ".ui.TConversationUI", new Intent().putExtra("finish_direct", true));
                            } else {
                                c.b(voiceSearchResultUI, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (ab.Ja(str)) {
                            if (z.aUt()) {
                                c.b(voiceSearchResultUI.getContext(), "qmessage", ".ui.QConversationUI", new Intent().putExtra("finish_direct", true));
                            } else {
                                c.b(voiceSearchResultUI, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (ab.IZ(str)) {
                            c.b(voiceSearchResultUI, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (ab.Je(str)) {
                            MMAppMgr.cancelNotification(str);
                            c.b(voiceSearchResultUI, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (ab.IW(str)) {
                            if (z.aUH()) {
                                voiceSearchResultUI.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                            } else {
                                c.b(voiceSearchResultUI, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (ab.Jj(str)) {
                            if (z.aUA()) {
                                Intent intent4 = new Intent();
                                intent4.putExtra("type", 20);
                                c.b(voiceSearchResultUI, "readerapp", ".ui.ReaderAppUI", intent4);
                            } else {
                                c.b(voiceSearchResultUI, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (ab.Jr(str)) {
                            if (z.aUB()) {
                                Intent intent5 = new Intent();
                                intent5.putExtra("type", 11);
                                c.b(voiceSearchResultUI, "readerapp", ".ui.ReaderAppUI", intent5);
                            } else {
                                c.b(voiceSearchResultUI, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (ab.Jb(str)) {
                            c.b(voiceSearchResultUI, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (ab.Jc(str)) {
                            if (z.aUD()) {
                                c.b(voiceSearchResultUI, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                            } else {
                                c.b(voiceSearchResultUI, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (ab.Ji(str)) {
                            if (z.aUx()) {
                                voiceSearchResultUI.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                            } else {
                                c.b(voiceSearchResultUI, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (ab.Jg(str) || ab.Jh(str) || ab.Jd(str) || ab.Jl(str) || ab.Jm(str) || ab.IX(str) || ab.Ju(str)) {
                            c.b(voiceSearchResultUI, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else {
                            voiceSearchResultUI.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                        }
                    }
                }
                a.a(this, "com/tencent/mm/ui/voicesearch/VoiceSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(39575);
            }
        });
        ab(this.QBs);
        AppMethodBeat.o(39577);
    }

    private static String[] aa(String[] strArr) {
        AppMethodBeat.i(39578);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(39578);
            return strArr;
        }
        Log.d("MicroMsg.VoiceSearchResultUI", "oldlist.length " + strArr.length);
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            String displayName = aa.getDisplayName(str);
            Log.d("MicroMsg.VoiceSearchResultUI", "displayname ".concat(String.valueOf(displayName)));
            if (!hashMap.containsValue(displayName) || !ab.Eq(str)) {
                Log.d("MicroMsg.VoiceSearchResultUI", "username ".concat(String.valueOf(str)));
                hashMap.put(displayName, str);
                arrayList.add(str);
            }
        }
        String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
        AppMethodBeat.o(39578);
        return strArr2;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(39579);
        super.onDestroy();
        this.QBr.ebf();
        AppMethodBeat.o(39579);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(39580);
        super.onPause();
        this.QBt = true;
        AppMethodBeat.o(39580);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(39581);
        if (4 == i2) {
            if (!this.QBt) {
                h.INSTANCE.kvStat(10452, this.dYn + "," + this.sOB + "," + (this.QBs == null ? 0 : this.QBs.length) + ",0");
            }
            if (this.QBu) {
                moveTaskToBack(true);
                finish();
                AppMethodBeat.o(39581);
                return true;
            }
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(39581);
        return onKeyDown;
    }

    static boolean bok(String str) {
        AppMethodBeat.i(39582);
        Cursor[] cursorArr = new Cursor[2];
        cursorArr[0] = bg.aVF().iBo.a(ab.iCF, null, str);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (cursorArr[0].moveToNext()) {
            try {
                String string = cursorArr[0].getString(cursorArr[0].getColumnIndex(ch.COL_USERNAME));
                arrayList.add(string);
                if (!ab.Eq(string)) {
                    arrayList2.add(string);
                }
                Log.d("MicroMsg.VoiceSearchResultUI", "block user ".concat(String.valueOf(string)));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VoiceSearchResultUI", e2, "", new Object[0]);
            }
        }
        cursorArr[1] = bg.aVF().iBp.a(str, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
        int count = cursorArr[1].getCount();
        int count2 = cursorArr[0].getCount();
        cursorArr[0].close();
        cursorArr[1].close();
        Log.d("MicroMsg.VoiceSearchResultUI", "contactCount " + count + " conversationCount " + count2);
        if (count + count2 <= 1) {
            AppMethodBeat.o(39582);
            return true;
        }
        AppMethodBeat.o(39582);
        return false;
    }

    private void ab(String[] strArr) {
        AppMethodBeat.i(39583);
        ArrayList arrayList = new ArrayList();
        if (!(strArr == null || this.QBr == null)) {
            for (String str : strArr) {
                if (this.QBr.boj(str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList.size() == 0) {
            this.qqJ.setVisibility(0);
            if (this.QBg != null) {
                this.qqJ.setText(this.QBg);
            } else {
                this.qqJ.setText(getString(R.string.f1));
            }
        } else {
            this.qqJ.setVisibility(8);
        }
        if (this.QBr != null) {
            b bVar = this.QBr;
            bVar.Paj = (String[]) arrayList.toArray(new String[arrayList.size()]);
            bVar.BZP = null;
            bVar.ebf();
            bVar.vw(false);
        }
        AppMethodBeat.o(39583);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c6u;
    }
}
