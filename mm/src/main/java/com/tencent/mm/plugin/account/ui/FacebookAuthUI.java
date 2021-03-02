package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.i;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.h.a.b;
import com.tencent.mm.ui.h.a.c;
import com.tencent.mm.ui.h.a.d;
import com.tencent.mm.ui.h.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FacebookAuthUI extends MMPreference implements i {
    private static final String[] kkg = {"public_profile", Scopes.EMAIL, "user_location"};
    private c kiu;
    private d kkF;
    private boolean kkG = false;
    private boolean kkH = false;
    private String kkI = "";
    private final Map<String, Preference> kkJ = new HashMap();
    private IListener kkK = new IListener<lz>() {
        /* class com.tencent.mm.plugin.account.ui.FacebookAuthUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161699);
            this.__eventId = lz.class.getName().hashCode();
            AppMethodBeat.o(161699);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lz lzVar) {
            AppMethodBeat.i(127927);
            lz lzVar2 = lzVar;
            if (lzVar2 == null || lzVar2.dRz == null) {
                AppMethodBeat.o(127927);
                return false;
            }
            Log.i("MicroMsg.FacebookAuthUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", lzVar2.dRz.content, lzVar2.dRz.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", lzVar2.dRz.content);
            intent.putExtra("key_disaster_url", lzVar2.dRz.url);
            intent.setClass(MMApplicationContext.getContext(), DisasterUI.class).addFlags(268435456);
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/account/ui/FacebookAuthUI$1", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/account/ui/FacebookAuthUI$1", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(127927);
            return true;
        }
    };
    private ProgressDialog kkd;
    private DialogInterface.OnCancelListener kke;
    private w kkf;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FacebookAuthUI() {
        AppMethodBeat.i(127938);
        AppMethodBeat.o(127938);
    }

    static /* synthetic */ void boZ() {
        AppMethodBeat.i(127951);
        gp(false);
        AppMethodBeat.o(127951);
    }

    static /* synthetic */ void d(FacebookAuthUI facebookAuthUI) {
        AppMethodBeat.i(127950);
        facebookAuthUI.boX();
        AppMethodBeat.o(127950);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127939);
        super.onCreate(bundle);
        this.screen = getPreferenceScreen();
        initView();
        AppMethodBeat.o(127939);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(127940);
        EventCenter.instance.addListener(this.kkK);
        super.onResume();
        g.azz().a(183, this);
        g.azz().a(254, this);
        boY();
        AppMethodBeat.o(127940);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(127941);
        super.onPause();
        EventCenter.instance.removeListener(this.kkK);
        g.azz().b(183, this);
        g.azz().b(254, this);
        AppMethodBeat.o(127941);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.aw;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(127942);
        this.kkG = getIntent().getBooleanExtra("is_force_unbind", false);
        this.kke = new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.FacebookAuthUI.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(127928);
                if (FacebookAuthUI.this.kkf != null) {
                    g.azz().a(FacebookAuthUI.this.kkf);
                }
                AppMethodBeat.o(127928);
            }
        };
        setMMTitle(R.string.ad7);
        this.screen.addPreferencesFromResource(R.xml.aw);
        Preference bmg = this.screen.bmg("facebook_auth_tip");
        if (bmg != null) {
            this.kkJ.put("facebook_auth_tip", bmg);
        }
        Preference bmg2 = this.screen.bmg("facebook_auth_cat");
        if (bmg2 != null) {
            this.kkJ.put("facebook_auth_cat", bmg2);
        }
        Preference bmg3 = this.screen.bmg("facebook_auth_bind_btn");
        if (bmg3 != null) {
            this.kkJ.put("facebook_auth_bind_btn", bmg3);
        }
        Preference bmg4 = this.screen.bmg("facebook_auth_account");
        if (bmg4 != null) {
            this.kkJ.put("facebook_auth_account", bmg4);
        }
        Preference bmg5 = this.screen.bmg("facebook_auth_cat2");
        if (bmg5 != null) {
            this.kkJ.put("facebook_auth_cat2", bmg5);
        }
        Preference bmg6 = this.screen.bmg("facebook_auth_unbind_btn");
        if (bmg6 != null) {
            this.kkJ.put("facebook_auth_unbind_btn", bmg6);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.FacebookAuthUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127929);
                Intent intent = FacebookAuthUI.this.getIntent();
                intent.putExtra("bind_facebook_succ", FacebookAuthUI.this.kkH);
                FacebookAuthUI.this.setResult(-1, intent);
                FacebookAuthUI.this.finish();
                AppMethodBeat.o(127929);
                return true;
            }
        });
        AppMethodBeat.o(127942);
    }

    private void boX() {
        AppMethodBeat.i(127944);
        this.kkd = ProgressDialog.show(this, getString(R.string.zb), getString(R.string.c75), true);
        this.kkd.setOnCancelListener(this.kke);
        this.kkf = new w(1, this.kkI);
        g.azz().a(this.kkf, 0);
        gp(true);
        h.INSTANCE.idkeyStat(582, 1, 1, false);
        AppMethodBeat.o(127944);
    }

    private void boY() {
        AppMethodBeat.i(127945);
        this.screen.removeAll();
        boolean aUF = this.kkG ? false : z.aUF();
        if (this.kkJ.containsKey("facebook_auth_tip")) {
            Preference preference = this.kkJ.get("facebook_auth_tip");
            preference.setTitle(aUF ? R.string.c7d : R.string.c74);
            this.screen.c(preference);
        }
        if (this.kkJ.containsKey("facebook_auth_cat")) {
            this.screen.c(this.kkJ.get("facebook_auth_cat"));
        }
        if (aUF) {
            if (this.kkJ.containsKey("facebook_auth_account")) {
                Preference preference2 = this.kkJ.get("facebook_auth_account");
                preference2.setTitle(getString(R.string.c76) + g.aAh().azQ().get(65826, (Object) null));
                this.screen.c(preference2);
            }
            if (this.kkJ.containsKey("facebook_auth_cat2")) {
                this.screen.c(this.kkJ.get("facebook_auth_cat2"));
            }
            if (this.kkJ.containsKey("facebook_auth_unbind_btn")) {
                this.screen.c(this.kkJ.get("facebook_auth_unbind_btn"));
            }
        } else if (this.kkJ.containsKey("facebook_auth_bind_btn")) {
            this.screen.c(this.kkJ.get("facebook_auth_bind_btn"));
            AppMethodBeat.o(127945);
            return;
        }
        AppMethodBeat.o(127945);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        int i4 = 0;
        AppMethodBeat.i(127946);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Boolean.valueOf(intent == null);
        Log.i("MicroMsg.FacebookAuthUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", objArr);
        if (i3 == -1 && i2 == 1024 && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(Util.isNullOrNil(stringExtra));
            if (!Util.isNullOrNil(stringExtra)) {
                i4 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i4);
            objArr2[2] = Integer.valueOf(intExtra);
            Log.i("MicroMsg.FacebookAuthUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", objArr2);
            if (intExtra == -217) {
                boX();
                AppMethodBeat.o(127946);
                return;
            }
        }
        if (this.kiu != null) {
            this.kiu.j(i2, i3, intent);
        }
        if (this.kkF != null) {
            this.kkF.j(i2, i3, intent);
        }
        AppMethodBeat.o(127946);
    }

    private static void gp(boolean z) {
        AppMethodBeat.i(127947);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i.a(32, z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1"));
        ((l) g.af(l.class)).aSM().d(new com.tencent.mm.ba.i(arrayList));
        AppMethodBeat.o(127947);
    }

    final class a implements c.a {
        private a() {
        }

        /* synthetic */ a(FacebookAuthUI facebookAuthUI, byte b2) {
            this();
        }

        @Override // com.tencent.mm.ui.h.a.c.a
        public final void E(Bundle bundle) {
            AppMethodBeat.i(127934);
            FacebookAuthUI.this.kkI = FacebookAuthUI.this.kiu.jZX;
            g.aAh().azQ().set(65830, FacebookAuthUI.this.kkI);
            if (FacebookAuthUI.this.kiu.QjF != 0) {
                g.aAh().azQ().set(65832, Long.valueOf(FacebookAuthUI.this.kiu.QjF));
            }
            FacebookAuthUI.d(FacebookAuthUI.this);
            AppMethodBeat.o(127934);
        }

        @Override // com.tencent.mm.ui.h.a.c.a
        public final void a(e eVar) {
            AppMethodBeat.i(127935);
            Log.d("MicroMsg.FacebookAuthUI", "onFacebookError:" + eVar.QjS);
            com.tencent.mm.ui.base.h.c(FacebookAuthUI.this, eVar.getMessage(), FacebookAuthUI.this.getString(R.string.bat), true);
            FacebookAuthUI.boZ();
            h.INSTANCE.idkeyStat(582, 2, 1, false);
            AppMethodBeat.o(127935);
        }

        @Override // com.tencent.mm.ui.h.a.c.a
        public final void a(b bVar) {
            AppMethodBeat.i(127936);
            Log.d("MicroMsg.FacebookAuthUI", "onError:" + bVar.getMessage());
            com.tencent.mm.ui.base.h.c(FacebookAuthUI.this, bVar.getMessage(), FacebookAuthUI.this.getString(R.string.bat), true);
            FacebookAuthUI.boZ();
            h.INSTANCE.idkeyStat(582, 3, 1, false);
            AppMethodBeat.o(127936);
        }

        @Override // com.tencent.mm.ui.h.a.c.a
        public final void onCancel() {
            AppMethodBeat.i(127937);
            Log.d("MicroMsg.FacebookAuthUI", "onCancel");
            FacebookAuthUI.boZ();
            h.INSTANCE.idkeyStat(582, 4, 1, false);
            AppMethodBeat.o(127937);
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(127948);
        if (qVar.getType() != 254) {
            if (qVar.getType() == 183) {
                if (this.kkd != null) {
                    this.kkd.dismiss();
                }
                int i4 = ((w) qVar).opType;
                if (i2 == 0 && i3 == 0) {
                    Toast.makeText(this, i4 == 0 ? R.string.bay : R.string.bau, 1).show();
                    this.kkG = false;
                    boY();
                    if (i4 == 1) {
                        ((l) g.af(l.class)).aST().bjW("facebookapp");
                        ((l) g.af(l.class)).eiy().aEE("facebookapp");
                        this.kkH = true;
                    }
                    AppMethodBeat.o(127948);
                    return;
                } else if (i2 == 4 && i3 == -67) {
                    Toast.makeText(this, (int) R.string.c78, 1).show();
                    AppMethodBeat.o(127948);
                    return;
                } else if (i2 == 4 && i3 == -5) {
                    Toast.makeText(this, i4 == 1 ? R.string.c72 : R.string.c7a, 1).show();
                    AppMethodBeat.o(127948);
                    return;
                } else if (i3 == -106) {
                    y.g(this, str, 0);
                    AppMethodBeat.o(127948);
                    return;
                } else {
                    com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                    if (Dk != null) {
                        Dk.a(this, null, null);
                        AppMethodBeat.o(127948);
                        return;
                    }
                    Toast.makeText(this, i4 == 0 ? R.string.bax : R.string.bat, 1).show();
                }
            }
            AppMethodBeat.o(127948);
        } else if (i2 == 0 && i3 == 0) {
            this.kkf = new w(0, "");
            g.azz().a(this.kkf, 0);
            AppMethodBeat.o(127948);
        } else {
            if (this.kkd != null) {
                this.kkd.dismiss();
            }
            if (i3 == -82) {
                com.tencent.mm.ui.base.h.a(this, (int) R.string.gmd, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.FacebookAuthUI.AnonymousClass9 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(127948);
            } else if (i3 == -83) {
                com.tencent.mm.ui.base.h.a(this, (int) R.string.gma, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.FacebookAuthUI.AnonymousClass10 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(127948);
            } else if (i3 == -84) {
                com.tencent.mm.ui.base.h.a(this, (int) R.string.gmb, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.FacebookAuthUI.AnonymousClass11 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(127948);
            } else if (i3 == -85) {
                com.tencent.mm.ui.base.h.a(this, (int) R.string.gm_, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.FacebookAuthUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(127948);
            } else if (i3 == -86) {
                com.tencent.mm.ui.base.h.a(this, (int) R.string.gmf, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.FacebookAuthUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(127948);
            } else if (i3 == -106) {
                y.g(this, str, 0);
                AppMethodBeat.o(127948);
            } else if (i3 == -217) {
                y.a(this, com.tencent.mm.platformtools.e.a((t) qVar), i3);
                AppMethodBeat.o(127948);
            } else {
                com.tencent.mm.h.a Dk2 = com.tencent.mm.h.a.Dk(str);
                if (Dk2 != null) {
                    Dk2.a(this, null, null);
                    AppMethodBeat.o(127948);
                    return;
                }
                AppMethodBeat.o(127948);
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(127949);
        if (i2 == 4) {
            Intent intent = getIntent();
            intent.putExtra("bind_facebook_succ", this.kkH);
            setResult(-1, intent);
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(127949);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(127943);
        String str = preference.mKey;
        if (str == null) {
            Log.e("MicroMsg.FacebookAuthUI", "onPreferenceTreeClick, key is null");
            AppMethodBeat.o(127943);
            return true;
        } else if (str.equals("facebook_auth_bind_btn")) {
            if (r.s(this, "com.facebook.katana")) {
                if (this.kkF == null) {
                    this.kkF = new d(getString(R.string.c71));
                    this.kkF.gWp();
                }
                if (!this.kkF.gWo()) {
                    this.kkF.logout();
                    this.kkF.a(this, new d.b() {
                        /* class com.tencent.mm.plugin.account.ui.FacebookAuthUI.AnonymousClass6 */

                        @Override // com.tencent.mm.ui.h.a.d.b
                        public final void onSuccess() {
                            AppMethodBeat.i(127930);
                            Log.i("MicroMsg.FacebookAuthUI", "facebook-android login success!");
                            FacebookAuthUI.this.kkI = FacebookAuthUI.this.kkF.QjM.getToken();
                            FacebookAuthUI.d(FacebookAuthUI.this);
                            AppMethodBeat.o(127930);
                        }

                        @Override // com.tencent.mm.ui.h.a.d.b
                        public final void onCancel() {
                            AppMethodBeat.i(127931);
                            Log.i("MicroMsg.FacebookAuthUI", "facebook-android login cancel!");
                            AppMethodBeat.o(127931);
                        }

                        @Override // com.tencent.mm.ui.h.a.d.b
                        public final void onError(String str) {
                            AppMethodBeat.i(127932);
                            Log.i("MicroMsg.FacebookAuthUI", "facebook-android login error! %s", str);
                            com.tencent.mm.ui.base.h.c(FacebookAuthUI.this, FacebookAuthUI.this.getString(R.string.c77), "", true);
                            AppMethodBeat.o(127932);
                        }
                    }, kkg);
                } else {
                    boX();
                }
            } else {
                try {
                    this.kiu.kx(this);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FacebookAuthUI", e2, "", new Object[0]);
                }
                this.kiu = new c(getString(R.string.c71));
                this.kiu.a(this, kkg, new a(this, (byte) 0));
            }
            AppMethodBeat.o(127943);
            return true;
        } else if (str.equals("facebook_auth_unbind_btn")) {
            com.tencent.mm.ui.base.h.a(this, (int) R.string.c7b, (int) R.string.zb, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.FacebookAuthUI.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(127933);
                    String string = FacebookAuthUI.this.getString(R.string.zb);
                    String string2 = FacebookAuthUI.this.getString(R.string.c7e);
                    FacebookAuthUI.this.kkd = ProgressDialog.show(FacebookAuthUI.this, string, string2, true);
                    FacebookAuthUI.this.kkd.setOnCancelListener(FacebookAuthUI.this.kke);
                    g.azz().a(new aa(aa.kfj), 0);
                    AppMethodBeat.o(127933);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.FacebookAuthUI.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(127943);
            return true;
        } else {
            AppMethodBeat.o(127943);
            return false;
        }
    }
}
