package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.plugin.account.model.l;
import com.tencent.mm.plugin.account.ui.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.h.a.c;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.s;

@Deprecated
public class FacebookFriendUI extends MMActivity implements e.a, i {
    private ProgressDialog gtM = null;
    private ListView kde;
    private View kdg;
    String kdi;
    private TextView kdj = null;
    private boolean khr = false;
    e kkQ;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127971);
        super.onCreate(bundle);
        setMMTitle(R.string.cem);
        g.azz().a(32, this);
        initView();
        AppMethodBeat.o(127971);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(127972);
        super.onResume();
        p.aYn().d(this);
        this.kkQ.notifyDataSetChanged();
        AppMethodBeat.o(127972);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(127973);
        super.onPause();
        p.aYn().e(this);
        AppMethodBeat.o(127973);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(127974);
        g.azz().b(32, this);
        this.kkQ.ebf();
        super.onDestroy();
        AppMethodBeat.o(127974);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a8g;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(127975);
        this.kde = (ListView) findViewById(R.id.fgs);
        this.kdj = (TextView) findViewById(R.id.c2r);
        this.kdj.setText(R.string.c7i);
        final TextView textView = (TextView) findViewById(R.id.c30);
        textView.setText(R.string.c7g);
        s sVar = new s((byte) 0);
        sVar.Qwi = new s.b() {
            /* class com.tencent.mm.plugin.account.ui.FacebookFriendUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.tools.s.b
            public final boolean SN(String str) {
                return false;
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void SO(String str) {
                AppMethodBeat.i(127958);
                FacebookFriendUI.this.kdi = Util.escapeSqlValue(str);
                FacebookFriendUI facebookFriendUI = FacebookFriendUI.this;
                if (facebookFriendUI.kkQ != null) {
                    facebookFriendUI.kkQ.SM(facebookFriendUI.kdi);
                }
                AppMethodBeat.o(127958);
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
        this.kkQ = new e(this, new s.a() {
            /* class com.tencent.mm.plugin.account.ui.FacebookFriendUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.s.a
            public final void bnE() {
                AppMethodBeat.i(127962);
                if (z.aUF() && FacebookFriendUI.this.khr) {
                    if (FacebookFriendUI.this.kkQ.getCount() == 0) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                }
                FacebookFriendUI.this.khr = false;
                AppMethodBeat.o(127962);
            }
        });
        this.kkQ.kkM = new e.a() {
            /* class com.tencent.mm.plugin.account.ui.FacebookFriendUI.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.account.ui.e.a
            public final void ve(int i2) {
                AppMethodBeat.i(127963);
                if (i2 > 0) {
                    FacebookFriendUI.this.kdj.setVisibility(8);
                    AppMethodBeat.o(127963);
                    return;
                }
                FacebookFriendUI.this.kdj.setVisibility(0);
                AppMethodBeat.o(127963);
            }
        };
        this.kde.setAdapter((ListAdapter) this.kkQ);
        this.kdg = findViewById(R.id.fgt);
        this.kde.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.FacebookFriendUI.AnonymousClass7 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(127964);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/account/ui/FacebookFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                com.tencent.mm.plugin.account.friend.a.g gVar = (com.tencent.mm.plugin.account.friend.a.g) FacebookFriendUI.this.kkQ.getItem(i2 - FacebookFriendUI.this.kde.getHeaderViewsCount());
                if (gVar.status == 100 || gVar.status == 101) {
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", gVar.getUsername());
                    intent.putExtra("Contact_Nick", gVar.getNickName());
                    intent.putExtra("Contact_KFacebookId", gVar.fuC);
                    intent.putExtra("Contact_KFacebookName", gVar.bnT());
                    intent.putExtra("Contact_Scene", 31);
                    com.tencent.mm.plugin.account.a.a.jRt.c(intent, FacebookFriendUI.this);
                }
                if (gVar.status == 102) {
                    a.a(this, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(127964);
                    return;
                }
                a.a(this, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(127964);
            }
        });
        Log.d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + z.aUF());
        if (z.aUF()) {
            this.kde.setVisibility(0);
            this.kdg.setVisibility(8);
            long nullAsNil = Util.nullAsNil((Long) g.aAh().azQ().get(65831, (Object) null));
            String nullAsNil2 = Util.nullAsNil((String) g.aAh().azQ().get(65830, (Object) null));
            if (Util.milliSecondsToNow(nullAsNil) > Util.MILLSECONDS_OF_DAY && nullAsNil2.length() > 0) {
                c cVar = new c(getString(R.string.c71));
                cVar.bnE(nullAsNil2);
                new k(cVar, new l() {
                    /* class com.tencent.mm.plugin.account.ui.FacebookFriendUI.AnonymousClass8 */

                    @Override // com.tencent.mm.plugin.account.model.l, com.tencent.mm.plugin.account.model.k.a
                    public final void E(Bundle bundle) {
                        AppMethodBeat.i(127965);
                        super.E(bundle);
                        AppMethodBeat.o(127965);
                    }

                    @Override // com.tencent.mm.plugin.account.model.l, com.tencent.mm.plugin.account.model.k.a
                    public final void onError(int i2, String str) {
                        AppMethodBeat.i(127966);
                        super.onError(i2, str);
                        if (i2 == 3) {
                            FacebookFriendUI.f(FacebookFriendUI.this);
                        }
                        AppMethodBeat.o(127966);
                    }
                }).bnw();
            }
            final ad adVar = new ad();
            adVar.bon();
            final MTimerHandler mTimerHandler = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.account.ui.FacebookFriendUI.AnonymousClass9 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(127967);
                    g.aAh().azQ().set(65829, (Object) 1);
                    g.azz().a(adVar, 0);
                    AppMethodBeat.o(127967);
                    return false;
                }
            }, false);
            if (Util.nullAsNil((Integer) g.aAh().azQ().get(65829, (Object) null)) > 0) {
                g.aAh().azQ().set(65829, (Object) 1);
                g.azz().a(adVar, 0);
            } else {
                mTimerHandler.startTimer(5000);
            }
            AppCompatActivity context = getContext();
            getString(R.string.zb);
            this.gtM = h.a((Context) context, getString(R.string.fr3), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.ui.FacebookFriendUI.AnonymousClass10 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(127968);
                    mTimerHandler.stopTimer();
                    g.azz().a(adVar);
                    AppMethodBeat.o(127968);
                }
            });
            addTextOptionMenu(0, getString(R.string.cen), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.account.ui.FacebookFriendUI.AnonymousClass11 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(127969);
                    FacebookFriendUI facebookFriendUI = FacebookFriendUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(FacebookFriendUI.this, InviteFacebookFriendsUI.class));
                    a.a(facebookFriendUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/FacebookFriendUI$8", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    facebookFriendUI.startActivity((Intent) bl.pG(0));
                    a.a(facebookFriendUI, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$8", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(127969);
                    return true;
                }
            });
        } else {
            this.kde.setVisibility(8);
            this.kdg.setVisibility(0);
            ((TextView) findViewById(R.id.fgu)).setText(R.string.cda);
            this.kdg.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.FacebookFriendUI.AnonymousClass12 */

                public final void onClick(View view) {
                    AppMethodBeat.i(127970);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/account/ui/FacebookFriendUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    FacebookFriendUI facebookFriendUI = FacebookFriendUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(FacebookFriendUI.this, FacebookAuthUI.class));
                    a.a(facebookFriendUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/FacebookFriendUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    facebookFriendUI.startActivity((Intent) bl.pG(0));
                    a.a(facebookFriendUI, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    a.a(this, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(127970);
                }
            });
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.FacebookFriendUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127959);
                FacebookFriendUI.this.hideVKB();
                FacebookFriendUI.this.finish();
                AppMethodBeat.o(127959);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.FacebookFriendUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(127960);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/ui/FacebookFriendUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(FacebookFriendUI.this.kde);
                Object obj = new Object();
                a.a(obj, bl.axQ(), "com/tencent/mm/plugin/account/ui/FacebookFriendUI$11", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                a.a(obj, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$11", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                a.a(this, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(127960);
            }
        });
        AppMethodBeat.o(127975);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(127976);
        Log.i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (qVar.getType() != 32) {
            AppMethodBeat.o(127976);
            return;
        }
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (i2 == 4 && i3 == -68) {
            if (Util.isNullOrNil(str)) {
                str = "error";
            }
            cb(getString(R.string.zb), str);
            AppMethodBeat.o(127976);
        } else if (i2 == 0 && i3 == 0) {
            this.kkQ.onNotifyChange(null, null);
            AppMethodBeat.o(127976);
        } else {
            Toast.makeText(this, (int) R.string.f19, 0).show();
            AppMethodBeat.o(127976);
        }
    }

    private void cb(String str, String str2) {
        AppMethodBeat.i(127977);
        h.a(this, str2, str, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.FacebookFriendUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(127961);
                Intent intent = new Intent(FacebookFriendUI.this.getContext(), FacebookAuthUI.class);
                intent.putExtra("is_force_unbind", true);
                AppCompatActivity context = FacebookFriendUI.this.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(context, bl.axQ(), "com/tencent/mm/plugin/account/ui/FacebookFriendUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                a.a(context, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                FacebookFriendUI.this.finish();
                AppMethodBeat.o(127961);
            }
        }, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(127977);
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        AppMethodBeat.i(127978);
        this.kkQ.notifyDataSetChanged();
        AppMethodBeat.o(127978);
    }

    static /* synthetic */ void f(FacebookFriendUI facebookFriendUI) {
        AppMethodBeat.i(127979);
        Log.e("MicroMsg.FacebookFriendUI", "dealWithRefreshTokenFail");
        facebookFriendUI.cb(facebookFriendUI.getString(R.string.zb), facebookFriendUI.getString(R.string.c7h));
        AppMethodBeat.o(127979);
    }
}
