package com.tencent.mm.plugin.account.friend.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.b.g;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.ui.g;
import com.tencent.mm.plugin.account.friend.ui.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class InviteFriendUI extends MMActivity implements e.a {
    private ImageView keC;
    private String kgK;
    private int kgL;
    private String kgM;
    private String kgN;
    private String kgO;
    private Button kgP;
    private int kgQ;
    private int kgR;
    private String kgS = null;
    private String kgT = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(131241);
        super.onCreate(bundle);
        setMMTitle(R.string.e42);
        Intent intent = getIntent();
        this.kgL = intent.getIntExtra("friend_type", -1);
        this.kgM = intent.getStringExtra("friend_nick");
        this.kgK = intent.getStringExtra("friend_num");
        this.kgN = intent.getStringExtra("friend_googleID");
        this.kgO = intent.getStringExtra("friend_googleItemID");
        this.kgK = Util.nullAsNil(this.kgK);
        this.kgS = intent.getStringExtra("friend_linkedInID");
        this.kgT = intent.getStringExtra("friend_linkedInPicUrl");
        initView();
        this.kgQ = intent.getIntExtra("search_kvstat_scene", 0);
        this.kgR = intent.getIntExtra("search_kvstat_position", 0);
        AppMethodBeat.o(131241);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(131242);
        super.onPause();
        p.aYn().e(this);
        AppMethodBeat.o(131242);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(131243);
        super.onResume();
        p.aYn().d(this);
        AppMethodBeat.o(131243);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aw4;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(131244);
        super.onDestroy();
        AppMethodBeat.o(131244);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        Bitmap LV;
        Bitmap bitmap;
        AppMethodBeat.i(131245);
        this.keC = (ImageView) findViewById(R.id.dzm);
        TextView textView = (TextView) findViewById(R.id.dzr);
        TextView textView2 = (TextView) findViewById(R.id.dzt);
        TextView textView3 = (TextView) findViewById(R.id.dzs);
        this.kgP = (Button) findViewById(R.id.dzp);
        Button button = (Button) findViewById(R.id.dzu);
        textView.setText(this.kgM);
        textView3.setText(getString(R.string.e40, new Object[]{this.kgM}));
        if (this.kgL == 1) {
            this.keC.setBackgroundDrawable(a.l(this, R.raw.default_mobile_avatar));
            textView2.setText(getString(R.string.un) + this.kgK);
            String messageDigest = g.getMessageDigest(this.kgK.getBytes());
            if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
                bitmap = p.aYn().cW(MMApplicationContext.getContext());
            } else {
                com.tencent.mm.plugin.account.friend.a.a SU = ((b) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).SU(messageDigest);
                if (SU != null) {
                    bitmap = l.a(SU.bnJ(), this);
                } else {
                    bitmap = null;
                }
            }
            if (bitmap != null) {
                this.keC.setImageBitmap(bitmap);
            } else {
                this.keC.setImageDrawable(a.l(this, R.raw.default_mobile_avatar));
            }
        }
        if (this.kgL == 0) {
            this.keC.setBackgroundDrawable(a.l(this, R.raw.default_qq_avatar));
            textView2.setText(getString(R.string.us) + this.kgK);
            long fd = (long) com.tencent.mm.b.p.fd(this.kgK);
            Bitmap bitmap2 = null;
            if (fd != 0) {
                bitmap2 = c.Ah(fd);
            }
            if (bitmap2 == null) {
                this.keC.setImageDrawable(a.l(this, R.raw.default_qq_avatar));
            } else {
                this.keC.setImageBitmap(bitmap2);
            }
            button.setVisibility(0);
        }
        if (this.kgL == 2) {
            this.kgP.setText(R.string.du7);
            this.keC.setBackgroundDrawable(a.l(this, R.drawable.bcc));
            textView2.setText(getString(R.string.ub) + this.kgK);
            if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
                LV = p.aYn().cW(MMApplicationContext.getContext());
            } else {
                LV = c.LV(this.kgN);
            }
            if (LV != null) {
                this.keC.setImageBitmap(LV);
            } else {
                this.keC.setImageDrawable(a.l(this, R.drawable.bcc));
            }
            if (TextUtils.isEmpty(this.kgM)) {
                textView.setText(Util.subStringEmail(this.kgK));
                textView3.setText(getString(R.string.e40, new Object[]{Util.subStringEmail(this.kgK)}));
            }
        }
        if (this.kgL == 3) {
            this.kgP.setText(R.string.e3z);
            Bitmap a2 = u.a(new com.tencent.mm.pluginsdk.ui.tools.e(this.kgT, this.kgT));
            if (a2 != null) {
                this.keC.setImageBitmap(a2);
            } else {
                this.keC.setImageResource(R.raw.default_avatar);
            }
            button.setVisibility(8);
        }
        this.kgP.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(131238);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                switch (InviteFriendUI.this.kgL) {
                    case 0:
                        new g(InviteFriendUI.this, new g.a() {
                            /* class com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.AnonymousClass1.AnonymousClass5 */

                            @Override // com.tencent.mm.plugin.account.friend.ui.g.a
                            public final void i(boolean z, String str) {
                                AppMethodBeat.i(131236);
                                if (z) {
                                    InviteFriendUI.this.finish();
                                }
                                AppMethodBeat.o(131236);
                            }
                        }).t(new int[]{com.tencent.mm.b.p.fd(InviteFriendUI.this.kgK)});
                        break;
                    case 1:
                        String str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(42, "");
                        if (str == null || str.length() == 0) {
                            str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(2, "");
                        }
                        final String string = InviteFriendUI.this.getString(R.string.e4h, new Object[]{str});
                        final Uri parse = Uri.parse("smsto:" + InviteFriendUI.this.kgK);
                        Intent intent = new Intent("android.intent.action.SENDTO", parse);
                        intent.putExtra("sms_body", string);
                        final PackageManager packageManager = InviteFriendUI.this.getPackageManager();
                        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
                        final HashMap hashMap = new HashMap();
                        for (ResolveInfo resolveInfo : queryIntentActivities) {
                            if (!resolveInfo.activityInfo.packageName.equals("com.whatsapp")) {
                                hashMap.put(resolveInfo.activityInfo.name, resolveInfo);
                            }
                        }
                        if (hashMap.size() != 1) {
                            if (hashMap.size() > 1) {
                                com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(InviteFriendUI.this);
                                lVar.HMa = new o.b() {
                                    /* class com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.AnonymousClass1.AnonymousClass1 */

                                    @Override // com.tencent.mm.ui.base.o.b
                                    public final void a(ImageView imageView, MenuItem menuItem) {
                                        AppMethodBeat.i(131232);
                                        imageView.setImageDrawable(((ResolveInfo) hashMap.get(new StringBuilder().append((Object) menuItem.getTitle()).toString())).loadIcon(packageManager));
                                        AppMethodBeat.o(131232);
                                    }
                                };
                                lVar.HMb = new o.c() {
                                    /* class com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.AnonymousClass1.AnonymousClass2 */

                                    @Override // com.tencent.mm.ui.base.o.c
                                    public final void a(TextView textView, MenuItem menuItem) {
                                        AppMethodBeat.i(131233);
                                        CharSequence loadLabel = ((ResolveInfo) hashMap.get(new StringBuilder().append((Object) menuItem.getTitle()).toString())).loadLabel(packageManager);
                                        if (loadLabel != null) {
                                            textView.setText(loadLabel.toString());
                                            AppMethodBeat.o(131233);
                                            return;
                                        }
                                        textView.setText("");
                                        AppMethodBeat.o(131233);
                                    }
                                };
                                lVar.HLX = new o.f() {
                                    /* class com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.AnonymousClass1.AnonymousClass3 */

                                    @Override // com.tencent.mm.ui.base.o.f
                                    public final void onCreateMMMenu(m mVar) {
                                        AppMethodBeat.i(131234);
                                        for (String str : hashMap.keySet()) {
                                            mVar.add(str);
                                        }
                                        AppMethodBeat.o(131234);
                                    }
                                };
                                lVar.HLY = new o.g() {
                                    /* class com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.AnonymousClass1.AnonymousClass4 */

                                    @Override // com.tencent.mm.ui.base.o.g
                                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                        AppMethodBeat.i(131235);
                                        String sb = new StringBuilder().append((Object) menuItem.getTitle()).toString();
                                        Intent intent = new Intent();
                                        intent.setComponent(new ComponentName(((ResolveInfo) hashMap.get(sb)).activityInfo.packageName, ((ResolveInfo) hashMap.get(sb)).activityInfo.name));
                                        intent.setAction("android.intent.action.SENDTO");
                                        intent.setData(parse);
                                        intent.putExtra("sms_body", string);
                                        InviteFriendUI inviteFriendUI = InviteFriendUI.this;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                        com.tencent.mm.hellhoundlib.a.a.a(inviteFriendUI, bl.axQ(), "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        inviteFriendUI.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(inviteFriendUI, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        AppMethodBeat.o(131235);
                                    }
                                };
                                lVar.gXI();
                                InviteFriendUI.c(InviteFriendUI.this);
                                break;
                            } else {
                                Toast.makeText(InviteFriendUI.this, (int) R.string.giz, 1).show();
                                break;
                            }
                        } else {
                            Iterator it = hashMap.keySet().iterator();
                            if (it.hasNext()) {
                                String str2 = (String) it.next();
                                Intent intent2 = new Intent();
                                intent2.setComponent(new ComponentName(((ResolveInfo) hashMap.get(str2)).activityInfo.packageName, ((ResolveInfo) hashMap.get(str2)).activityInfo.name));
                                intent2.setAction("android.intent.action.SENDTO");
                                intent2.setData(parse);
                                intent2.putExtra("sms_body", string);
                                InviteFriendUI inviteFriendUI = InviteFriendUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                                com.tencent.mm.hellhoundlib.a.a.a(inviteFriendUI, bl.axQ(), "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                inviteFriendUI.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(inviteFriendUI, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                InviteFriendUI.c(InviteFriendUI.this);
                                break;
                            }
                        }
                        break;
                    case 2:
                        h hVar = new h(InviteFriendUI.this, new h.a() {
                            /* class com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.AnonymousClass1.AnonymousClass6 */

                            @Override // com.tencent.mm.plugin.account.friend.ui.h.a
                            public final void gn(boolean z) {
                                AppMethodBeat.i(131237);
                                if (z) {
                                    ((com.tencent.mm.plugin.account.friend.a.o) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aF(InviteFriendUI.this.kgO, 1);
                                }
                                AppMethodBeat.o(131237);
                            }
                        });
                        String str3 = InviteFriendUI.this.kgN;
                        String str4 = InviteFriendUI.this.kgK;
                        com.tencent.mm.kernel.g.azz().a(489, hVar);
                        Cursor Td = ((com.tencent.mm.plugin.account.friend.a.o) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).Td(str3);
                        if (Td == null || Td.getCount() <= 1) {
                            hVar.Tl(str4);
                        } else {
                            hVar.c(Td);
                        }
                        if (Td != null) {
                            Td.close();
                            break;
                        }
                        break;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(131238);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(131239);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                qc qcVar = new qc();
                qcVar.dWm.opType = 0;
                qcVar.dWm.dWo = InviteFriendUI.this.kgK + "@qqim";
                qcVar.dWm.dWp = InviteFriendUI.this.kgM;
                EventCenter.instance.publish(qcVar);
                if (qcVar.dWn.dFE) {
                    com.tencent.mm.plugin.account.a.a.jRt.d(new Intent().putExtra("Chat_User", InviteFriendUI.this.kgK + "@qqim"), InviteFriendUI.this);
                }
                InviteFriendUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(131239);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(131240);
                InviteFriendUI.this.finish();
                AppMethodBeat.o(131240);
                return true;
            }
        });
        AppMethodBeat.o(131245);
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        AppMethodBeat.i(131246);
        if (this.kgK == null || this.kgK.equals("")) {
            AppMethodBeat.o(131246);
            return;
        }
        long Ma = c.Ma(str);
        if (Ma > 0 && this.kgK.equals(String.valueOf(Ma)) && this.kgL == 0) {
            this.keC.setImageBitmap(c.a(str, false, -1, null));
        }
        AppMethodBeat.o(131246);
    }

    static /* synthetic */ void c(InviteFriendUI inviteFriendUI) {
        AppMethodBeat.i(131247);
        if (inviteFriendUI.kgQ > 0 && inviteFriendUI.kgR > 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10991, Integer.valueOf(inviteFriendUI.kgQ), 7, Integer.valueOf(inviteFriendUI.kgR));
        }
        AppMethodBeat.o(131247);
    }
}
