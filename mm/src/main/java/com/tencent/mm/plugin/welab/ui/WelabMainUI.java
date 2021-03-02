package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.welab.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@i
public class WelabMainUI extends MMActivity {
    private boolean JGg = false;
    private LinearLayout JGr;
    private LinearLayout JGs;
    private LinearLayout JGt;
    private LinearLayout JGu;
    private View JGv;
    private View JGw;
    private List<String> JGx;
    private View.OnClickListener JGy = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.welab.ui.WelabMainUI.AnonymousClass4 */

        public final void onClick(View view) {
            AppMethodBeat.i(146288);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/welab/ui/WelabMainUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Object tag = view.getTag();
            if (tag instanceof com.tencent.mm.plugin.welab.d.a.a) {
                com.tencent.mm.plugin.welab.d.a.a aVar = (com.tencent.mm.plugin.welab.d.a.a) tag;
                Intent intent = new Intent();
                intent.putExtra("para_appid", aVar.field_LabsAppId);
                intent.putExtra("para_from_with_red_point", com.tencent.mm.plugin.welab.e.b.gju().e(aVar) ? 1 : 0);
                intent.setClass(WelabMainUI.this, WelabAppInfoUI.class);
                WelabMainUI welabMainUI = WelabMainUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(welabMainUI, bl.axQ(), "com/tencent/mm/plugin/welab/ui/WelabMainUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                welabMainUI.startActivity((Intent) bl.pG(0));
                a.a(welabMainUI, "com/tencent/mm/plugin/welab/ui/WelabMainUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.plugin.welab.e.b gju = com.tencent.mm.plugin.welab.e.b.gju();
                String str = aVar.field_LabsAppId;
                gju.JFW.put(str, 1);
                gju.tag += "&" + str + "=1";
                g.aAh().azQ().set(ar.a.USERINFO_WELAB_REDPOINT_STRING, gju.tag);
                com.tencent.mm.plugin.welab.e.b.gjw();
                Log.i("MicroMsg.WelabMainUI", "click ".concat(String.valueOf(aVar)));
            }
            a.a(this, "com/tencent/mm/plugin/welab/ui/WelabMainUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(146288);
        }
    };
    private Comparator<com.tencent.mm.plugin.welab.d.a.a> nlt = new Comparator<com.tencent.mm.plugin.welab.d.a.a>() {
        /* class com.tencent.mm.plugin.welab.ui.WelabMainUI.AnonymousClass3 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(com.tencent.mm.plugin.welab.d.a.a aVar, com.tencent.mm.plugin.welab.d.a.a aVar2) {
            AppMethodBeat.i(146287);
            com.tencent.mm.plugin.welab.d.a.a aVar3 = aVar;
            com.tencent.mm.plugin.welab.d.a.a aVar4 = aVar2;
            if (aVar3 == aVar4) {
                AppMethodBeat.o(146287);
                return 0;
            }
            if (aVar3 != null) {
                if (aVar4 == null) {
                    AppMethodBeat.o(146287);
                    return 1;
                } else if (aVar3.field_Pos == aVar4.field_Pos) {
                    int safeParseInt = Util.safeParseInt(aVar3.field_expId);
                    int safeParseInt2 = Util.safeParseInt(aVar4.field_expId);
                    if (safeParseInt == safeParseInt2) {
                        AppMethodBeat.o(146287);
                        return 0;
                    } else if (safeParseInt2 > safeParseInt) {
                        AppMethodBeat.o(146287);
                        return 1;
                    } else {
                        AppMethodBeat.o(146287);
                        return -1;
                    }
                } else if (aVar3.field_Pos > aVar4.field_Pos) {
                    AppMethodBeat.o(146287);
                    return 1;
                }
            }
            AppMethodBeat.o(146287);
            return -1;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WelabMainUI() {
        AppMethodBeat.i(146289);
        AppMethodBeat.o(146289);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(146290);
        super.onCreate(bundle);
        setIsDarkActionbarBg(true);
        hideActionbarLine();
        if (getIntent() != null) {
            if (getIntent().getIntExtra("para_from_with_red_point", 0) == 1) {
                z = true;
            }
            this.JGg = z;
            this.JGx = getIntent().getStringArrayListExtra("key_exclude_apps");
        }
        initView();
        com.tencent.mm.plugin.welab.e.b.gju();
        MMApplicationContext.getDefaultPreference().edit().putBoolean("key_has_enter_welab", true).commit();
        com.tencent.mm.plugin.welab.e.b.gjw();
        d.y("", 1, this.JGg);
        AppMethodBeat.o(146290);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cc6;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(146291);
        setMMTitle(R.string.j2z);
        setTitleDividerColor(R.color.afz);
        setActionbarColor(getResources().getColor(R.color.afy));
        setActionbarElementColor(getResources().getColor(R.color.am));
        this.JGr = (LinearLayout) findViewById(R.id.g3y);
        this.JGt = (LinearLayout) findViewById(R.id.g3z);
        this.JGs = (LinearLayout) findViewById(R.id.i6o);
        this.JGu = (LinearLayout) findViewById(R.id.i6p);
        this.JGv = findViewById(R.id.gh5);
        this.JGw = findViewById(R.id.fzh);
        this.JGv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.welab.ui.WelabMainUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(146285);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/welab/ui/WelabMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("title", view.getResources().getString(R.string.j32));
                intent.putExtra("rawUrl", WelabMainUI.this.getContext().getString(R.string.j2x, new Object[]{LocaleUtil.getApplicationLanguage(), Integer.valueOf(com.tencent.mm.protocal.d.KyO)}));
                intent.putExtra("showShare", false);
                c.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                a.a(this, "com/tencent/mm/plugin/welab/ui/WelabMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(146285);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.welab.ui.WelabMainUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(146286);
                WelabMainUI.this.hideVKB();
                WelabMainUI.this.finish();
                AppMethodBeat.o(146286);
                return true;
            }
        });
        AppMethodBeat.o(146291);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(146292);
        super.onResume();
        this.JGt.removeAllViews();
        this.JGu.removeAllViews();
        List<com.tencent.mm.plugin.welab.d.a.a> gjh = com.tencent.mm.plugin.welab.a.gjg().gjh();
        if (gjh == null || gjh.isEmpty()) {
            this.JGr.setVisibility(8);
        } else {
            Iterator<com.tencent.mm.plugin.welab.d.a.a> it = gjh.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.welab.d.a.a next = it.next();
                if (!Util.isNullOrNil(next.field_LabsAppId) && this.JGx.contains(next.field_LabsAppId)) {
                    it.remove();
                }
            }
            if (gjh.isEmpty()) {
                this.JGr.setVisibility(8);
            } else {
                this.JGr.setVisibility(0);
                Collections.sort(gjh, this.nlt);
                for (com.tencent.mm.plugin.welab.d.a.a aVar : gjh) {
                    a(aVar, this.JGt);
                }
                Log.d("MicroMsg.WelabMainUI", "get online app count " + this.JGt.getChildCount());
            }
        }
        gjt();
        if (this.JGr.getVisibility() == 0 || this.JGs.getVisibility() == 0) {
            this.JGw.setVisibility(8);
            AppMethodBeat.o(146292);
            return;
        }
        this.JGw.setVisibility(0);
        AppMethodBeat.o(146292);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(146293);
        super.onPause();
        AppMethodBeat.o(146293);
    }

    private void gjt() {
        AppMethodBeat.i(146294);
        List<com.tencent.mm.plugin.welab.d.a.a> gjn = com.tencent.mm.plugin.welab.a.gjg().JFR.gjn();
        Iterator<com.tencent.mm.plugin.welab.d.a.a> it = gjn.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.welab.d.a.a next = it.next();
            if ((System.currentTimeMillis() / 1000) - next.field_endtime >= 2592000 || "labs1de6f3".equals(next.field_LabsAppId)) {
                it.remove();
                com.tencent.mm.plugin.welab.a.JFQ.JFR.delete(next, new String[0]);
            } else if (next.isExpired() && next.field_Switch != 3) {
                next.field_Switch = 3;
                com.tencent.mm.plugin.welab.a.JFQ.JFR.update(next, new String[0]);
            } else if (next.field_Switch != 3) {
                it.remove();
            }
        }
        Log.i("WelabMgr", "stopped lab %s", gjn.toString());
        if (gjn.isEmpty()) {
            this.JGs.setVisibility(8);
            AppMethodBeat.o(146294);
            return;
        }
        this.JGs.setVisibility(0);
        Collections.sort(gjn, this.nlt);
        for (com.tencent.mm.plugin.welab.d.a.a aVar : gjn) {
            a(aVar, this.JGu);
        }
        Log.d("MicroMsg.WelabMainUI", "get online app count " + this.JGu.getChildCount());
        AppMethodBeat.o(146294);
    }

    private void a(com.tencent.mm.plugin.welab.d.a.a aVar, LinearLayout linearLayout) {
        AppMethodBeat.i(146295);
        LinearLayout linearLayout2 = (LinearLayout) getLayoutInflater().inflate(R.layout.cc4, (ViewGroup) linearLayout, false);
        ImageView imageView = (ImageView) linearLayout2.findViewById(R.id.iqu);
        ImageView imageView2 = (ImageView) linearLayout2.findViewById(R.id.ry);
        TextView textView = (TextView) linearLayout2.findViewById(R.id.ipm);
        TextView textView2 = (TextView) linearLayout2.findViewById(R.id.ied);
        if (com.tencent.mm.plugin.welab.e.b.gju().e(aVar)) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        com.tencent.mm.av.a.a.bdb().a(aVar.bbH("field_ThumbUrl"), imageView2, com.tencent.mm.plugin.welab.a.gjg().IIu);
        com.tencent.mm.plugin.welab.a.gjg();
        textView.setText(com.tencent.mm.plugin.welab.a.a(aVar));
        textView2.setText(aVar.bbH("field_Desc"));
        linearLayout2.setTag(aVar);
        linearLayout2.setOnClickListener(this.JGy);
        linearLayout.addView(linearLayout2);
        AppMethodBeat.o(146295);
    }
}
