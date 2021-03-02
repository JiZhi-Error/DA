package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.ui.a;
import com.tencent.mm.plugin.account.friend.a.ah;
import com.tencent.mm.plugin.account.friend.a.ai;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.appbrand.jsapi.y.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.s;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleFriendUI extends MMActivity implements AdapterView.OnItemClickListener, e.a, i, a.AbstractC0519a {
    private boolean jZE = false;
    private String jZG;
    private ProgressDialog jZH;
    private int jZJ;
    private TextView jZO;
    private String kab;
    private ArrayList<n> kcA = new ArrayList<>();
    private HashMap<String, n> kcB = new HashMap<>();
    private ListView kcw;
    private a kcx;
    private String kcy;
    private ai kcz;
    private boolean mCanceled = false;
    private String mToken;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GoogleFriendUI() {
        AppMethodBeat.i(110094);
        AppMethodBeat.o(110094);
    }

    static /* synthetic */ void a(GoogleFriendUI googleFriendUI, n nVar, n nVar2) {
        AppMethodBeat.i(110117);
        googleFriendUI.a(nVar, nVar2);
        AppMethodBeat.o(110117);
    }

    public enum a {
        SUCCESS,
        NO_CONTACT,
        ACCESS_DEDY,
        OTHER;

        public static a valueOf(String str) {
            AppMethodBeat.i(110080);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(110080);
            return aVar;
        }

        static {
            AppMethodBeat.i(110081);
            AppMethodBeat.o(110081);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ate;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(110095);
        super.onCreate(bundle);
        this.jZG = (String) g.aAh().azQ().get(208903, (Object) null);
        if (TextUtils.isEmpty(this.jZG)) {
            finish();
        }
        this.jZJ = getIntent().getIntExtra("enter_scene", 0);
        this.kcx = new a(this, this.jZG);
        this.kcx.kco = this;
        initView();
        this.jZE = m.dB(this);
        if (this.jZE) {
            Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "startActivityCheckGooglePlayServices");
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
        } else {
            bnt();
        }
        ((o) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).clear();
        AppMethodBeat.o(110095);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(110096);
        super.onResume();
        g.azz().a(f.CTRL_INDEX, this);
        g.azz().a(489, this);
        p.aYn().d(this);
        if (this.kcx != null) {
            this.kcx.anp();
        }
        AppMethodBeat.o(110096);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(110097);
        super.onStop();
        g.azz().b(f.CTRL_INDEX, this);
        g.azz().b(489, this);
        p.aYn().e(this);
        AppMethodBeat.o(110097);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(110098);
        super.onDestroy();
        ((o) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).clear();
        AppMethodBeat.o(110098);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(110099);
        setMMTitle(R.string.dtz);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(110074);
                GoogleFriendUI.this.finish();
                AppMethodBeat.o(110074);
                return true;
            }
        });
        this.jZO = (TextView) findViewById(R.id.c2g);
        this.kcw = (ListView) findViewById(R.id.djf);
        this.kcw.setAdapter((ListAdapter) this.kcx);
        this.kcw.setOnItemClickListener(this);
        s sVar = new s((byte) 0);
        sVar.Qwi = new s.b() {
            /* class com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.tools.s.b
            public final boolean SN(String str) {
                return false;
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void SO(String str) {
                AppMethodBeat.i(110075);
                GoogleFriendUI.this.kcy = Util.escapeSqlValue(str);
                if (GoogleFriendUI.this.kcx != null) {
                    GoogleFriendUI.this.kcx.SM(GoogleFriendUI.this.kcy);
                }
                AppMethodBeat.o(110075);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bny() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnz() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnA() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnB() {
            }
        };
        addSearchMenu(true, sVar);
        AppMethodBeat.o(110099);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(110100);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "onItemClick position:%d,", Integer.valueOf(i2));
        if (this.kcx != null) {
            n nVar = (n) this.kcx.getItem(i2 - this.kcw.getHeaderViewsCount());
            if (nVar != null) {
                String str = nVar.field_username;
                Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "jumpToProfile email:%s, username:%s", nVar.field_googlegmail, str);
                as Kn = ((l) g.af(l.class)).aSN().Kn(str);
                if ((Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) && TextUtils.isEmpty(nVar.field_nickname)) {
                    Intent intent = new Intent(this, InviteFriendUI.class);
                    intent.putExtra("friend_type", 2);
                    intent.putExtra("friend_user_name", str);
                    intent.putExtra("friend_num", nVar.field_googlegmail);
                    intent.putExtra("friend_nick", nVar.field_googlename);
                    intent.putExtra("friend_weixin_nick", nVar.field_nickname);
                    intent.putExtra("friend_googleID", nVar.field_googleid);
                    intent.putExtra("friend_googleItemID", nVar.field_googleitemid);
                    intent.putExtra("friend_scene", 58);
                    intent.putExtra("Contact_Scene", 58);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "jumpToProfile", "(Lcom/tencent/mm/plugin/account/friend/model/GoogleFriendInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "jumpToProfile", "(Lcom/tencent/mm/plugin/account/friend/model/GoogleFriendInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", str);
                    intent2.putExtra("Contact_Nick", nVar.field_nickname);
                    intent2.putExtra("Contact_ShowFMessageList", true);
                    intent2.putExtra("verify_gmail", nVar.field_googlegmail);
                    intent2.putExtra("profileName", nVar.field_googlename);
                    intent2.putExtra("Contact_Source_FMessage", 58);
                    intent2.putExtra("Contact_Scene", 58);
                    if (str != null && str.length() > 0) {
                        com.tencent.mm.plugin.account.a.a.jRt.c(intent2, getContext());
                    }
                }
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(110100);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(110101);
        Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 2005) {
            if (i3 == -1) {
                this.jZE = intent.getBooleanExtra("gpservices", false);
                bnt();
                AppMethodBeat.o(110101);
                return;
            }
            this.jZE = intent.getBooleanExtra("gpservices", false);
            finish();
        }
        AppMethodBeat.o(110101);
    }

    private void bnt() {
        AppMethodBeat.i(110102);
        Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "updateToken");
        bnu();
        if (TextUtils.isEmpty(this.mToken) || (!this.jZE && TextUtils.isEmpty(this.kab))) {
            startActivity(BindGoogleContactUI.class);
            finish();
            AppMethodBeat.o(110102);
            return;
        }
        bnv();
        AppMethodBeat.o(110102);
    }

    @Override // com.tencent.mm.plugin.account.bind.ui.a.AbstractC0519a
    public final void vd(int i2) {
        AppMethodBeat.i(110103);
        if (this.kcx == null) {
            AppMethodBeat.o(110103);
            return;
        }
        n nVar = (n) this.kcx.getItem(i2);
        if (nVar == null) {
            AppMethodBeat.o(110103);
            return;
        }
        switch (nVar.field_status) {
            case 0:
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this, new a.AbstractC2025a() {
                    /* class com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI.AnonymousClass3 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
                    public final void a(boolean z, boolean z2, String str, String str2) {
                        AppMethodBeat.i(110076);
                        Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "MicroMsg.AddContact ok:%b hasSentVerify:%b", Boolean.valueOf(z), Boolean.valueOf(z2));
                        if (z || z2) {
                            Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", str2);
                            ((o) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aF(str2, 1);
                        } else {
                            ((o) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aF(str2, 2);
                        }
                        GoogleFriendUI.this.kcx.anp();
                        AppMethodBeat.o(110076);
                    }
                });
                String str = nVar.field_googleitemid;
                aVar.Kee = false;
                aVar.Ked = true;
                aVar.khI = str;
                aVar.Kee = false;
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(58);
                aVar.b(nVar.field_username, linkedList, true);
                nVar.field_googlecgistatus = 0;
                ((o) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(nVar);
                this.kcx.anp();
                AppMethodBeat.o(110103);
                return;
            case 1:
                Cursor Td = ((o) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).Td(nVar.field_googleid);
                if (Td == null || Td.getCount() <= 1) {
                    a(nVar, (n) null);
                } else {
                    a(Td, nVar);
                }
                if (Td != null) {
                    Td.close();
                    break;
                }
                break;
        }
        AppMethodBeat.o(110103);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(110104);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = TextUtils.isEmpty(str) ? "" : str;
        Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", objArr);
        int type = qVar.getType();
        if (i2 != 0 || i3 != 0) {
            switch (type) {
                case 30:
                case 137:
                    if (i3 == -87) {
                        h.c(this, getString(R.string.b_d), "", true);
                    } else if ((i3 == -24 || i3 == -101) && !Util.isNullOrNil(str)) {
                        Toast.makeText(this, str, 1).show();
                    }
                    if (this.kcx != null) {
                        String str2 = ((com.tencent.mm.pluginsdk.model.p) qVar).kfu;
                        Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", str2);
                        ((o) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aF(str2, 2);
                        this.kcx.anp();
                        break;
                    }
                    break;
                case f.CTRL_INDEX /*{ENCODED_INT: 488}*/:
                    gj(false);
                    break;
                case 489:
                    if (this.kcx != null) {
                        ah ahVar = (ah) qVar;
                        Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", Integer.valueOf(ahVar.bop().oTz));
                        String str3 = ahVar.kfu;
                        Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", str3);
                        ((o) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aF(str3, 1);
                        this.kcx.anp();
                        break;
                    }
                    break;
                default:
                    Log.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
                    break;
            }
        } else {
            switch (type) {
                case 30:
                case 137:
                    if (this.kcx != null) {
                        String str4 = ((com.tencent.mm.pluginsdk.model.p) qVar).kfu;
                        Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", str4);
                        ((o) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aF(str4, 1);
                        this.kcx.anp();
                        break;
                    }
                    break;
                case f.CTRL_INDEX /*{ENCODED_INT: 488}*/:
                    a(((ai) qVar).boq());
                    break;
                case 489:
                    if (this.kcx != null) {
                        ah ahVar2 = (ah) qVar;
                        Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", Integer.valueOf(ahVar2.bop().oTz));
                        String str5 = ahVar2.kfu;
                        Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", str5);
                        ((o) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aF(str5, 1);
                        this.kcx.anp();
                        break;
                    }
                    break;
                default:
                    Log.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
                    break;
            }
        }
        bnk();
        AppMethodBeat.o(110104);
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        AppMethodBeat.i(110105);
        if (this.kcx != null) {
            this.kcx.notifyDataSetChanged();
        }
        AppMethodBeat.o(110105);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(110106);
        super.onBackPressed();
        AppMethodBeat.o(110106);
    }

    private void bnu() {
        AppMethodBeat.i(110107);
        if (this.jZE) {
            this.mToken = (String) g.aAh().azQ().get(208901, (Object) null);
            AppMethodBeat.o(110107);
            return;
        }
        this.mToken = (String) g.aAh().azQ().get(208902, (Object) null);
        this.kab = (String) g.aAh().azQ().get(208904, (Object) null);
        AppMethodBeat.o(110107);
    }

    private void bnv() {
        AppMethodBeat.i(110108);
        if (this.jZE) {
            bnx();
            AppMethodBeat.o(110108);
            return;
        }
        bnw();
        AppMethodBeat.o(110108);
    }

    private void a(Cursor cursor, final n nVar) {
        AppMethodBeat.i(110109);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                n nVar2 = new n();
                nVar2.convertFrom(cursor);
                arrayList.add(nVar2.field_googlegmail);
                arrayList2.add(Integer.valueOf(i2));
                arrayList3.add(nVar2);
                cursor.moveToNext();
            }
            arrayList2.add(-1);
        }
        AppCompatActivity context = getContext();
        String string = getResources().getString(R.string.du6);
        getResources().getString(R.string.sz);
        h.a(context, string, arrayList, arrayList2, new h.e() {
            /* class com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.h.e
            public final void cy(int i2, int i3) {
                AppMethodBeat.i(110077);
                if (i3 != -1) {
                    GoogleFriendUI.a(GoogleFriendUI.this, (n) arrayList3.get(i3), nVar);
                }
                AppMethodBeat.o(110077);
            }
        });
        AppMethodBeat.o(110109);
    }

    private void a(n nVar, n nVar2) {
        AppMethodBeat.i(110110);
        ArrayList arrayList = new ArrayList();
        arrayList.add(nVar.field_googlegmail);
        ah ahVar = new ah(arrayList);
        Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", nVar.field_googleitemid);
        g.azz().a(ahVar, 0);
        if (nVar2 == null) {
            ahVar.kfu = nVar.field_googleitemid;
            nVar.field_googlecgistatus = 0;
            ((o) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(nVar);
        } else {
            ahVar.kfu = nVar2.field_googleitemid;
            nVar2.field_googlecgistatus = 0;
            ((o) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(nVar2);
        }
        this.kcx.anp();
        AppMethodBeat.o(110110);
    }

    private void bnw() {
        AppMethodBeat.i(110111);
        bnj();
        new c(this.kab).execute(new Void[0]);
        AppMethodBeat.o(110111);
    }

    private void bnx() {
        AppMethodBeat.i(110112);
        this.mCanceled = false;
        bnj();
        new b(this, this, this.mToken, (byte) 0).execute(new Void[0]);
        AppMethodBeat.o(110112);
    }

    private synchronized void a(cij cij) {
        AppMethodBeat.i(110113);
        Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "handleListGoogleContactCGIResponse Count:%d", Integer.valueOf(cij.oTz));
        if (this.kcx != null) {
            this.kcx.anp();
        }
        AppMethodBeat.o(110113);
    }

    private void gj(boolean z) {
        String string;
        AppMethodBeat.i(110114);
        this.jZO.setVisibility(0);
        if (!NetStatusUtil.isConnected(this)) {
            string = getString(R.string.du5);
        } else if (z) {
            string = getString(R.string.dty);
        } else {
            string = getString(R.string.dtx);
        }
        this.jZO.setText(string);
        AppMethodBeat.o(110114);
    }

    private void bnj() {
        AppMethodBeat.i(110115);
        if (this.jZH == null || !this.jZH.isShowing()) {
            getString(R.string.zb);
            this.jZH = h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI.AnonymousClass5 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(110078);
                    GoogleFriendUI.this.mCanceled = true;
                    g.azz().a(GoogleFriendUI.this.kcz);
                    AppMethodBeat.o(110078);
                }
            });
        }
        AppMethodBeat.o(110115);
    }

    private void bnk() {
        AppMethodBeat.i(110116);
        if (this.jZH != null && this.jZH.isShowing()) {
            this.jZH.dismiss();
        }
        AppMethodBeat.o(110116);
    }

    /* access modifiers changed from: package-private */
    public class c extends AsyncTask<Void, Void, Void> {
        private String jZX;
        private boolean jZZ;
        private String kab;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ Void doInBackground(Void[] voidArr) {
            AppMethodBeat.i(110093);
            Void bnl = bnl();
            AppMethodBeat.o(110093);
            return bnl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(Void r5) {
            AppMethodBeat.i(110092);
            super.onPostExecute(r5);
            Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "onPostExecute");
            GoogleFriendUI.a(GoogleFriendUI.this, this.jZZ, this.jZX);
            AppMethodBeat.o(110092);
        }

        public c(String str) {
            this.kab = str;
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            AppMethodBeat.i(110089);
            super.onPreExecute();
            Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "onPreExecute");
            this.jZZ = false;
            AppMethodBeat.o(110089);
        }

        private Void bnl() {
            AppMethodBeat.i(110090);
            Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "doInBackground");
            try {
                String bnC = bnC();
                Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "refresh response:%s", bnC);
                this.jZX = new JSONObject(bnC).optString("access_token");
                this.jZZ = true;
            } catch (ProtocolException e2) {
                Log.e("MicroMsg.GoogleContact.GoogleFriendUI", "ProtocolException:%s", e2.getMessage());
            } catch (MalformedURLException e3) {
                Log.e("MicroMsg.GoogleContact.GoogleFriendUI", "MalformedURLException:%s", e3.getMessage());
            } catch (IOException e4) {
                Log.e("MicroMsg.GoogleContact.GoogleFriendUI", "IOException:%s", e4.getMessage());
            } catch (JSONException e5) {
                Log.e("MicroMsg.GoogleContact.GoogleFriendUI", "JSONException:%s", e5.getMessage());
            }
            AppMethodBeat.o(110090);
            return null;
        }

        private String bnC() {
            AppMethodBeat.i(110091);
            String str = "";
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/token").openConnection();
            httpURLConnection.setRequestProperty("Charset", MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
            httpURLConnection.setReadTimeout(com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("refresh_token", this.kab));
            arrayList.add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
            arrayList.add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
            arrayList.add(new BasicNameValuePair("grant_type", "refresh_token"));
            String aY = m.aY(arrayList);
            Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "QueryString:%s".concat(String.valueOf(aY)));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            bufferedWriter.write(aY);
            bufferedWriter.flush();
            bufferedWriter.close();
            int responseCode = httpURLConnection.getResponseCode();
            Log.e("MicroMsg.GoogleContact.GoogleFriendUI", "responseCode:".concat(String.valueOf(responseCode)));
            if (200 == responseCode) {
                StringBuffer stringBuffer = new StringBuffer();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                bufferedReader.close();
                str = stringBuffer.toString();
                Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "exchange token respone:%s".concat(String.valueOf(str)));
            }
            try {
                httpURLConnection.getInputStream().close();
            } catch (Exception e2) {
                Log.e("MicroMsg.GoogleContact.GoogleFriendUI", e2.getMessage());
            }
            httpURLConnection.disconnect();
            AppMethodBeat.o(110091);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends AsyncTask<Void, Void, Void> {
        private a kcK;
        private Context mContext;
        private String mToken;

        /* synthetic */ b(GoogleFriendUI googleFriendUI, Context context, String str, byte b2) {
            this(context, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ Void doInBackground(Void[] voidArr) {
            AppMethodBeat.i(110088);
            Void bnl = bnl();
            AppMethodBeat.o(110088);
            return bnl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(Void r5) {
            AppMethodBeat.i(110087);
            super.onPostExecute(r5);
            Log.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPostExecute");
            if (this.kcK != a.SUCCESS) {
                GoogleFriendUI.a(GoogleFriendUI.this, this.kcK, (ArrayList) null);
                AppMethodBeat.o(110087);
            } else if (GoogleFriendUI.this.kcA == null || GoogleFriendUI.this.kcA.size() <= 0) {
                GoogleFriendUI.a(GoogleFriendUI.this, a.NO_CONTACT, (ArrayList) null);
                AppMethodBeat.o(110087);
            } else {
                GoogleFriendUI.a(GoogleFriendUI.this, a.SUCCESS, GoogleFriendUI.this.kcA);
                AppMethodBeat.o(110087);
            }
        }

        private b(Context context, String str) {
            this.kcK = a.OTHER;
            this.mContext = context;
            this.mToken = str;
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            AppMethodBeat.i(110082);
            super.onPreExecute();
            Log.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPreExecute");
            GoogleFriendUI.this.kcA.clear();
            GoogleFriendUI.this.kcB.clear();
            AppMethodBeat.o(110082);
        }

        private Void bnl() {
            boolean z;
            AppMethodBeat.i(110083);
            Log.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "doInBackground");
            int i2 = 0;
            int i3 = 1;
            while (true) {
                try {
                    Log.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "startInde:%d, totalCount:%d", Integer.valueOf(i3), Integer.valueOf(i2));
                    String m = m("json", i3, this.mToken);
                    int i4 = new JSONObject(m).getJSONObject("feed").getJSONObject("openSearch$totalResults").getInt("$t");
                    if (i4 > 0) {
                        SP(m);
                    }
                    if (i4 - i3 > 100) {
                        i3 += 100;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z || GoogleFriendUI.this.mCanceled) {
                        this.kcK = a.SUCCESS;
                    } else {
                        i2 = i4;
                    }
                } catch (IOException e2) {
                    this.kcK = a.ACCESS_DEDY;
                    Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "IOException" + e2.getMessage());
                } catch (JSONException e3) {
                    this.kcK = a.OTHER;
                    Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "JSONException" + e3.getMessage());
                }
            }
            this.kcK = a.SUCCESS;
            AppMethodBeat.o(110083);
            return null;
        }

        private static String m(String str, int i2, String str2) {
            AppMethodBeat.i(110084);
            URL url = new URL("https://www.google.com/m8/feeds/contacts/default/property-email?alt=" + str + "&max-results=100&start-index=" + i2 + "&access_token=" + str2);
            Log.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "requestURL:%s", url.toString());
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
            int responseCode = httpURLConnection.getResponseCode();
            Log.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "responseCode:%d", Integer.valueOf(responseCode));
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                String A = A(inputStream);
                inputStream.close();
                AppMethodBeat.o(110084);
                return A;
            }
            if (responseCode == 401) {
                Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Server OAuth Error,Please Try Again.");
            } else {
                Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Unknow Error.");
            }
            try {
                httpURLConnection.getInputStream().close();
            } catch (Exception e2) {
                Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", e2.getMessage());
            }
            httpURLConnection.disconnect();
            AppMethodBeat.o(110084);
            return null;
        }

        private static String A(InputStream inputStream) {
            AppMethodBeat.i(110085);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[20480];
            while (true) {
                int read = inputStream.read(bArr, 0, 20480);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    AppMethodBeat.o(110085);
                    return str;
                }
            }
        }

        private void SP(String str) {
            String str2;
            String str3;
            String string;
            int lastIndexOf;
            AppMethodBeat.i(110086);
            JSONArray jSONArray = new JSONObject(str).getJSONObject("feed").getJSONArray("entry");
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String str4 = "";
                    JSONObject optJSONObject = jSONArray.getJSONObject(i2).optJSONObject("id");
                    JSONObject optJSONObject2 = jSONArray.getJSONObject(i2).optJSONObject("title");
                    JSONArray optJSONArray = jSONArray.getJSONObject(i2).optJSONArray("gd$email");
                    JSONArray optJSONArray2 = jSONArray.getJSONObject(i2).optJSONArray("link");
                    if (optJSONObject == null || (lastIndexOf = (string = optJSONObject.getString("$t")).lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP)) <= 0) {
                        str2 = "";
                    } else {
                        str2 = string.substring(lastIndexOf + 1);
                    }
                    if (optJSONObject2 != null) {
                        str3 = optJSONObject2.getString("$t");
                    } else {
                        str3 = "";
                    }
                    if (optJSONArray2 != null) {
                        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            String string2 = optJSONArray2.getJSONObject(i3).getString("rel");
                            int lastIndexOf2 = string2.lastIndexOf("#");
                            if (lastIndexOf2 > 0) {
                                String substring = string2.substring(lastIndexOf2 + 1);
                                if (!TextUtils.isEmpty(substring) && "photo".equals(substring)) {
                                    str4 = optJSONArray2.getJSONObject(i3).getString(ShareConstants.WEB_DIALOG_PARAM_HREF);
                                }
                            }
                        }
                    }
                    if (optJSONArray != null) {
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            String string3 = optJSONArray.getJSONObject(i4).getString("address");
                            if (!TextUtils.isEmpty(string3) && Util.isValidEmail(string3) && !string3.equals(GoogleFriendUI.this.jZG)) {
                                n nVar = new n();
                                nVar.field_googleid = str2;
                                nVar.field_googleitemid = str2 + string3;
                                nVar.field_googlename = str3;
                                nVar.field_googlephotourl = str4;
                                nVar.field_googlegmail = string3;
                                if (!GoogleFriendUI.this.kcB.containsKey(string3)) {
                                    GoogleFriendUI.this.kcA.add(nVar);
                                    GoogleFriendUI.this.kcB.put(string3, nVar);
                                }
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(110086);
        }
    }

    static /* synthetic */ void a(GoogleFriendUI googleFriendUI, boolean z, String str) {
        AppMethodBeat.i(110118);
        if (!z || TextUtils.isEmpty(str)) {
            googleFriendUI.bnk();
            googleFriendUI.gj(false);
            AppMethodBeat.o(110118);
            return;
        }
        googleFriendUI.mToken = str;
        g.aAh().azQ().set(208902, str);
        googleFriendUI.bnx();
        AppMethodBeat.o(110118);
    }

    static /* synthetic */ void a(GoogleFriendUI googleFriendUI, a aVar, ArrayList arrayList) {
        AppMethodBeat.i(110119);
        Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "[handleGetGoogleContactListTaskReturn] success:%s", aVar);
        if (aVar == a.SUCCESS && !googleFriendUI.mCanceled) {
            googleFriendUI.kcz = new ai(arrayList, googleFriendUI.jZJ, googleFriendUI.kcB, googleFriendUI.mToken);
            g.azz().a(googleFriendUI.kcz, 0);
            AppMethodBeat.o(110119);
        } else if (aVar == a.NO_CONTACT) {
            googleFriendUI.bnk();
            Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "Google Contact is Empty.");
            googleFriendUI.gj(true);
            AppMethodBeat.o(110119);
        } else if (aVar == a.ACCESS_DEDY) {
            googleFriendUI.bnk();
            if (NetStatusUtil.isConnected(googleFriendUI)) {
                Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "[handleGetGoogleContactListTaskReturn] start bindGoogleContactUI No Login or network unavaile.");
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(googleFriendUI, BindGoogleContactUI.class));
                com.tencent.mm.hellhoundlib.a.a.a(googleFriendUI, bl.axQ(), "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "handleGetGoogleContactListTaskReturn", "(Lcom/tencent/mm/plugin/account/bind/ui/GoogleFriendUI$FetchContactStatus;Ljava/util/ArrayList;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                googleFriendUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(googleFriendUI, "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "handleGetGoogleContactListTaskReturn", "(Lcom/tencent/mm/plugin/account/bind/ui/GoogleFriendUI$FetchContactStatus;Ljava/util/ArrayList;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                googleFriendUI.finish();
                AppMethodBeat.o(110119);
                return;
            }
            googleFriendUI.gj(false);
            AppMethodBeat.o(110119);
        } else {
            if (!googleFriendUI.mCanceled) {
                Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "[handleGetGoogleContactListTaskReturn] start bindGoogleContactUI unknow error");
                googleFriendUI.bnk();
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(googleFriendUI, BindGoogleContactUI.class));
                com.tencent.mm.hellhoundlib.a.a.a(googleFriendUI, bl2.axQ(), "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "handleGetGoogleContactListTaskReturn", "(Lcom/tencent/mm/plugin/account/bind/ui/GoogleFriendUI$FetchContactStatus;Ljava/util/ArrayList;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                googleFriendUI.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(googleFriendUI, "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "handleGetGoogleContactListTaskReturn", "(Lcom/tencent/mm/plugin/account/bind/ui/GoogleFriendUI$FetchContactStatus;Ljava/util/ArrayList;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                googleFriendUI.finish();
            }
            AppMethodBeat.o(110119);
        }
    }
}
