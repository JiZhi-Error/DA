package com.tencent.mm.plugin.game.ui.chat_tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.b.g;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.game.report.c;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.v;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import org.json.JSONObject;

public class GameTabWidget2 extends LinearLayout {
    private static final String xXo = (com.tencent.mm.plugin.game.commlib.util.b.a(b.a.PERMANENT) + "tabnav/");
    private Activity mActivity;
    private a xXp;
    private boolean xXq = true;
    private boolean xXr = false;
    boolean xXs = true;
    private GameTabData2.TabItem xXt;
    private boolean xXu = false;

    static {
        AppMethodBeat.i(204275);
        AppMethodBeat.o(204275);
    }

    public GameTabWidget2(Context context) {
        super(context);
        AppMethodBeat.i(204264);
        bh(context);
        AppMethodBeat.o(204264);
    }

    public GameTabWidget2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(204265);
        bh(context);
        AppMethodBeat.o(204265);
    }

    public GameTabWidget2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(204266);
        bh(context);
        AppMethodBeat.o(204266);
    }

    public final void a(GameTabData2 gameTabData2, String str) {
        int i2;
        AppMethodBeat.i(204267);
        if (gameTabData2 == null) {
            AppMethodBeat.o(204267);
            return;
        }
        a aVar = new a(getContext());
        setAdapter(aVar);
        aVar.a(gameTabData2, str, this.mActivity.getIntent().getStringExtra("game_red_dot_tab_key"));
        int parseColor = c.parseColor(gameTabData2.lco);
        int parseColor2 = c.parseColor(gameTabData2.xWZ);
        if (ao.isDarkMode()) {
            if (parseColor2 != 0) {
                setBackgroundColor(parseColor2);
            }
        } else if (parseColor != 0) {
            setBackgroundColor(parseColor);
        }
        if (this.mActivity.getIntent().getBooleanExtra("game_tab_exposure", true)) {
            this.mActivity.getIntent().putExtra("game_tab_exposure", false);
            String stringExtra = this.mActivity.getIntent().getStringExtra("game_tab_key");
            int intExtra = this.mActivity.getIntent().getIntExtra("game_report_from_scene", 0);
            c.a aVar2 = com.tencent.mm.game.report.c.hhl;
            c.a.t(stringExtra, (long) intExtra);
            int i3 = 0;
            for (Map.Entry entry : gameTabData2.xWX.entrySet()) {
                GameTabData2.TabItem tabItem = (GameTabData2.TabItem) entry.getValue();
                if (tabItem != null) {
                    i2 = i3 + 1;
                    if (tabItem.xHB.equals(gameTabData2.dWA())) {
                        this.xXt = tabItem;
                        this.xXu = true;
                        i3 = i2;
                    } else {
                        c.a aVar3 = com.tencent.mm.game.report.c.hhl;
                        c.a.a(i2, 0, tabItem.xHB, 0, (long) intExtra);
                    }
                } else {
                    i2 = i3;
                }
                i3 = i2;
            }
        }
        AppMethodBeat.o(204267);
    }

    public final void dWE() {
        AppMethodBeat.i(204268);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(204245);
                if (GameTabWidget2.this.xXp != null) {
                    GameTabWidget2.this.xXp.notifyDataSetInvalidated();
                }
                AppMethodBeat.o(204245);
            }
        });
        AppMethodBeat.o(204268);
    }

    public final void hP(String str, String str2) {
        AppMethodBeat.i(204269);
        if (this.xXp != null) {
            this.xXp.hQ(str, str2);
        }
        AppMethodBeat.o(204269);
    }

    public final void aA(int i2, boolean z) {
        AppMethodBeat.i(204270);
        if (this.xXu && this.xXt != null) {
            this.xXu = false;
            int intExtra = this.mActivity.getIntent().getIntExtra("game_report_from_scene", 0);
            c.a aVar = com.tencent.mm.game.report.c.hhl;
            c.a.a(this.xXt.position, i2, this.xXt.xHB, 6, (long) intExtra);
        }
        if (this.xXp != null) {
            this.xXp.aA(i2, z);
        }
        AppMethodBeat.o(204270);
    }

    public void setTabSwitchEnable(boolean z) {
        this.xXq = z;
    }

    public void setPageChanging(boolean z) {
        this.xXr = z;
    }

    private void bh(Context context) {
        AppMethodBeat.i(204271);
        this.mActivity = (Activity) context;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setBackgroundResource(R.color.st);
        setOrientation(0);
        AppMethodBeat.o(204271);
    }

    private void setAdapter(a aVar) {
        AppMethodBeat.i(204272);
        this.xXp = aVar;
        aVar.registerDataSetObserver(new DataSetObserver() {
            /* class com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2.AnonymousClass2 */

            public final void onInvalidated() {
                AppMethodBeat.i(204246);
                GameTabWidget2.b(GameTabWidget2.this);
                AppMethodBeat.o(204246);
            }

            public final void onChanged() {
                AppMethodBeat.i(204247);
                GameTabWidget2.b(GameTabWidget2.this);
                AppMethodBeat.o(204247);
            }
        });
        aVar.notifyDataSetChanged();
        AppMethodBeat.o(204272);
    }

    public static void a(Activity activity, GameTabData2.TabItem tabItem, boolean z) {
        Bundle bundle;
        int i2;
        AppMethodBeat.i(204273);
        if (activity == null || tabItem == null) {
            AppMethodBeat.o(204273);
            return;
        }
        Intent intent = activity.getIntent();
        if (intent == null) {
            AppMethodBeat.o(204273);
            return;
        }
        if (Util.nullAsNil(tabItem.xHB).equalsIgnoreCase(Util.nullAsNil(intent.getStringExtra("game_red_dot_tab_key")))) {
            intent.putExtra("game_red_dot_tab_key", "");
            h.a(MainProcessIPCService.dkO, new IPCString(Util.nullAsNil(intent.getStringExtra("game_tab_red_dot_msgid"))), b.class, null);
        }
        int intExtra = intent.getIntExtra("game_report_from_scene", 0);
        if (!z) {
            if (tabItem.dLS == 1) {
                i2 = 6;
            } else {
                i2 = 0;
            }
            c.a aVar = com.tencent.mm.game.report.c.hhl;
            int i3 = tabItem.position;
            int i4 = tabItem.xXm;
            String str = tabItem.xHB;
            p.h(str, "tabKey");
            eq a2 = c.a.a(1, 101, (long) i3, 2, (long) intExtra);
            a2.eEm = (long) i4;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("red_dot", i2);
            jSONObject.put("tab_key", str);
            a2.rQ(URLEncoder.encode(jSONObject.toString()));
            a2.bfK();
        } else {
            intent.putExtra("disable_minimize", true);
        }
        if (tabItem.dLS == 3) {
            c.a aVar2 = com.tencent.mm.game.report.c.hhl;
            int i5 = tabItem.position;
            String str2 = tabItem.xHB;
            p.h(str2, "tabKey");
            eq a3 = c.a.a(1, 101, (long) i5, 71, (long) intExtra);
            a3.eEm = 0;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("red_dot", 0);
            jSONObject2.put("tab_key", str2);
            a3.rQ(URLEncoder.encode(jSONObject2.toString()));
            a3.bfK();
            com.tencent.mm.plugin.game.e.c.E(activity, tabItem.xXi.jfi, tabItem.xXi.xut);
            AppMethodBeat.o(204273);
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            bundle = new Bundle();
        } else {
            bundle = extras;
        }
        String string = bundle.getString("from_source_activity");
        if (!Util.isNullOrNil(string)) {
            Log.i("MicroMsg.GameTabWidget2", "fromSourceActivity: %s", string);
            Intent intent2 = new Intent();
            intent2.addFlags(65536);
            intent2.addFlags(131072);
            intent2.setClassName(activity, string);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.overridePendingTransition(R.anim.cd, R.anim.cd);
        }
        Intent intent3 = new Intent();
        intent3.putExtras(bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("from_game_tab", true);
        bundle2.putString("game_tab_key", tabItem.xHB);
        bundle2.putInt("game_tab_type", tabItem.dLS);
        bundle2.putLong("turn_page_time", System.currentTimeMillis());
        bundle2.putString("rawUrl", tabItem.jumpUrl);
        bundle2.putBoolean("from_find_more_friend", true);
        intent3.putExtras(bundle2);
        intent3.setClassName(activity, tabItem.xHI);
        intent3.addFlags(65536);
        intent3.addFlags(131072);
        try {
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl2.axQ(), "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2", "jumpToTab", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/game/ui/chat_tab/GameTabData2$TabItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if (z) {
                activity.overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
                AppMethodBeat.o(204273);
                return;
            }
            activity.overridePendingTransition(R.anim.cd, R.anim.cd);
            AppMethodBeat.o(204273);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.GameTabWidget2", e2, "className:[%s]", tabItem.xHI);
            AppMethodBeat.o(204273);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private Context mContext;
        Map<String, C1408a> xXA = new HashMap();
        int xXB = 0;
        boolean xXC = false;
        private GameTabData2 xXx;
        private String xXy;
        private String xXz;

        public a(Context context) {
            AppMethodBeat.i(204252);
            this.mContext = context;
            AppMethodBeat.o(204252);
        }

        public final void a(GameTabData2 gameTabData2, String str, String str2) {
            AppMethodBeat.i(204253);
            this.xXx = gameTabData2;
            this.xXy = str;
            this.xXz = str2;
            notifyDataSetChanged();
            AppMethodBeat.o(204253);
        }

        public final void aA(int i2, final boolean z) {
            C1408a aVar;
            AppMethodBeat.i(204254);
            this.xXB = i2;
            this.xXC = z;
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                com.tencent.f.h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(204250);
                        a.this.aA(a.this.xXB, z);
                        AppMethodBeat.o(204250);
                    }
                });
                AppMethodBeat.o(204254);
                return;
            }
            if (!(this.xXx == null || (aVar = this.xXA.get(this.xXx.dWA())) == null)) {
                aVar.xXG.setTag(Integer.valueOf(i2));
                aVar.xXF.setVisibility(8);
                if (i2 > 0) {
                    l(aVar.xXG, i2);
                    AppMethodBeat.o(204254);
                    return;
                }
                aVar.xXG.setVisibility(4);
                if (z) {
                    aVar.xXF.setVisibility(0);
                }
            }
            AppMethodBeat.o(204254);
        }

        private void l(TextView textView, int i2) {
            AppMethodBeat.i(204255);
            if (i2 >= 100) {
                textView.setText("");
                textView.setBackgroundResource(R.raw.badge_count_more);
                textView.setTextSize(0, (float) com.tencent.mm.cb.a.aH(GameTabWidget2.this.getContext(), R.dimen.ane));
                textView.setVisibility(0);
                AppMethodBeat.o(204255);
                return;
            }
            textView.setText(String.valueOf(i2));
            textView.setBackgroundResource(v.aQ(GameTabWidget2.this.getContext(), i2));
            textView.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(GameTabWidget2.this.getContext(), R.dimen.ane)) * com.tencent.mm.cb.a.ji(GameTabWidget2.this.getContext()));
            textView.setVisibility(0);
            AppMethodBeat.o(204255);
        }

        public final void hQ(String str, String str2) {
            AppMethodBeat.i(204256);
            this.xXz = str2;
            for (Map.Entry<String, C1408a> entry : this.xXA.entrySet()) {
                String key = entry.getKey();
                C1408a value = entry.getValue();
                GameTabData2.TabItem tabItem = (GameTabData2.TabItem) this.xXx.xWX.get(key);
                if (!(value == null || tabItem == null)) {
                    a(value, tabItem, Util.nullAsNil(str).equalsIgnoreCase(key), this.xXz);
                }
            }
            AppMethodBeat.o(204256);
        }

        public final int getCount() {
            AppMethodBeat.i(204257);
            if (this.xXx == null) {
                AppMethodBeat.o(204257);
                return 0;
            }
            int size = this.xXx.avn().size();
            AppMethodBeat.o(204257);
            return size;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(204258);
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.apj, viewGroup, false);
            C1408a aVar = new C1408a(inflate);
            if (com.tencent.mm.cb.a.jk(GameTabWidget2.this.getContext())) {
                aVar.hbb.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(GameTabWidget2.this.getContext(), R.dimen.fx)) * com.tencent.mm.cb.a.ji(GameTabWidget2.this.getContext()));
                aVar.xXG.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(GameTabWidget2.this.getContext(), R.dimen.fx)) * com.tencent.mm.cb.a.ji(GameTabWidget2.this.getContext()));
            }
            GameTabData2.TabItem tabItem = this.xXx.avn().get(i2);
            if (tabItem != null) {
                aVar.hbb.setText(tabItem.title);
                a(aVar, tabItem, Util.nullAsNil(this.xXy).equalsIgnoreCase(tabItem.xHB), this.xXz);
                this.xXA.put(tabItem.xHB, aVar);
            }
            inflate.setTag(tabItem);
            AppMethodBeat.o(204258);
            return inflate;
        }

        private static void c(String str, ImageView imageView) {
            AppMethodBeat.i(204259);
            if (Util.isNullOrNil(str) || imageView == null) {
                AppMethodBeat.o(204259);
                return;
            }
            if (!Util.isNullOrNil(str)) {
                c.a aVar = new c.a();
                aVar.jbf = true;
                aVar.fullPath = GameTabWidget2.xXo + g.getMessageDigest(str.getBytes());
                com.tencent.mm.av.a.a.bdb().a(str, imageView, aVar.bdv());
            }
            AppMethodBeat.o(204259);
        }

        private void a(C1408a aVar, GameTabData2.TabItem tabItem, boolean z, String str) {
            AppMethodBeat.i(204260);
            if (!tabItem.dWC()) {
                aVar.xXF.setVisibility(8);
                if (Util.nullAsNil(tabItem.xHB).equalsIgnoreCase(str)) {
                    aVar.xXF.setVisibility(0);
                }
            }
            if (ao.isDarkMode()) {
                int bI = bI(tabItem.xXd, z);
                int bI2 = bI(tabItem.xXe, z);
                String str2 = tabItem.xXg;
                String str3 = tabItem.xXh;
                if (Util.isNullOrNil(str3)) {
                    str3 = str2;
                }
                if (Util.isNullOrNil(str2)) {
                    str2 = tabItem.iconUrl;
                    str3 = tabItem.xXf;
                }
                if (z) {
                    c(str3, aVar.kc);
                    aVar.hbb.setTextColor(bI2);
                    AppMethodBeat.o(204260);
                    return;
                }
                c(str2, aVar.kc);
                aVar.hbb.setTextColor(bI);
                AppMethodBeat.o(204260);
                return;
            }
            int bI3 = bI(tabItem.iyd, z);
            int bI4 = bI(tabItem.xXc, z);
            String str4 = tabItem.iconUrl;
            String str5 = tabItem.xXf;
            if (Util.isNullOrNil(str5)) {
                str5 = str4;
            }
            if (z) {
                c(str5, aVar.kc);
                aVar.hbb.setTextColor(bI4);
                AppMethodBeat.o(204260);
                return;
            }
            c(str4, aVar.kc);
            aVar.hbb.setTextColor(bI3);
            AppMethodBeat.o(204260);
        }

        private int bI(String str, boolean z) {
            AppMethodBeat.i(204261);
            int parseColor = com.tencent.mm.plugin.game.e.c.parseColor(str);
            if (parseColor == 0) {
                if (z) {
                    parseColor = GameTabWidget2.this.getResources().getColor(R.color.ts);
                } else {
                    parseColor = GameTabWidget2.this.getResources().getColor(R.color.s5);
                }
            }
            AppMethodBeat.o(204261);
            return parseColor;
        }

        /* renamed from: com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2$a$a  reason: collision with other inner class name */
        public class C1408a {
            TextView hbb;
            ImageView kc;
            ImageView xXF;
            TextView xXG;

            public C1408a(View view) {
                AppMethodBeat.i(204251);
                this.hbb = (TextView) view.findViewById(R.id.abf);
                this.kc = (ImageView) view.findViewById(R.id.abc);
                this.xXF = (ImageView) view.findViewById(R.id.h7e);
                this.xXG = (TextView) view.findViewById(R.id.abe);
                AppMethodBeat.o(204251);
            }
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(204262);
            GameTabData2.TabItem tabItem = this.xXx.avn().get(i2);
            AppMethodBeat.o(204262);
            return tabItem;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCString iPCString, d<IPCVoid> dVar) {
            AppMethodBeat.i(204263);
            IPCString iPCString2 = iPCString;
            if (iPCString2 != null) {
                s dSK = ((f) com.tencent.mm.kernel.g.af(f.class)).dSK();
                String str = iPCString2.value;
                if (!Util.isNullOrNil(str)) {
                    o aAk = dSK.aAk(str);
                    if (aAk != null) {
                        aAk.field_redDotExpireTime = 0;
                        dSK.update(aAk, new String[0]);
                    }
                    Log.i("MicroMsg.GameMessageStorage", "removeTabRedDot gameMsgId:%s", str);
                }
            }
            AppMethodBeat.o(204263);
        }
    }

    static /* synthetic */ void b(GameTabWidget2 gameTabWidget2) {
        AppMethodBeat.i(204274);
        gameTabWidget2.removeAllViews();
        int count = gameTabWidget2.xXp.getCount();
        if (count != 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.jn(gameTabWidget2.mActivity) / count, -1);
            for (int i2 = 0; i2 < count; i2++) {
                View view = gameTabWidget2.xXp.getView(i2, null, gameTabWidget2);
                if (view != null) {
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2.AnonymousClass3 */

                        public final void onClick(View view) {
                            int i2;
                            Object tag;
                            AppMethodBeat.i(204249);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            GameTabData2.TabItem tabItem = (GameTabData2.TabItem) view.getTag();
                            try {
                                String stringExtra = GameTabWidget2.this.mActivity.getIntent().getStringExtra("game_tab_key");
                                if (Util.nullAsNil(tabItem.xHB).equals(stringExtra)) {
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(204249);
                                    return;
                                }
                                Log.i("MicroMsg.GameTabWidget2", "currentTabKey:%s, nextTabKey:%s", stringExtra, tabItem.xHB);
                                if (!GameTabWidget2.this.xXq || GameTabWidget2.this.xXr) {
                                    Log.i("MicroMsg.GameTabWidget2", "tab switch disable");
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(204249);
                                    return;
                                }
                                int intExtra = GameTabWidget2.this.mActivity.getIntent().getIntExtra("game_tab_type", -1);
                                long longExtra = GameTabWidget2.this.mActivity.getIntent().getLongExtra("turn_page_time", 0);
                                if (tabItem.dLS == intExtra || System.currentTimeMillis() - longExtra >= 500) {
                                    if (tabItem.dLS != intExtra) {
                                        GameTabWidget2.this.xXs = false;
                                        com.tencent.f.h.RTc.n(new Runnable() {
                                            /* class com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2.AnonymousClass3.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(204248);
                                                GameTabWidget2.this.xXs = true;
                                                AppMethodBeat.o(204248);
                                            }
                                        }, 500);
                                    }
                                    a.C1408a aVar = GameTabWidget2.this.xXp.xXA.get(tabItem.xHB);
                                    if (aVar == null || (tag = aVar.xXG.getTag()) == null || !(tag instanceof Integer)) {
                                        i2 = 0;
                                    } else {
                                        i2 = ((Integer) tag).intValue();
                                    }
                                    tabItem.xXm = i2;
                                    GameTabWidget2.a(GameTabWidget2.this.mActivity, tabItem, false);
                                    if (Util.isNullOrNil(GameTabWidget2.this.mActivity.getIntent().getStringExtra("game_red_dot_tab_key")) && !tabItem.dWC()) {
                                        a.C1408a aVar2 = GameTabWidget2.this.xXp.xXA.get(tabItem.xHB);
                                        if (aVar2 != null) {
                                            aVar2.xXF.setVisibility(8);
                                        }
                                    }
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(204249);
                                    return;
                                }
                                Log.i("MicroMsg.GameTabWidget2", "switch interval > %d", 500L);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/chat_tab/GameTabWidget2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(204249);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.GameTabWidget2", "selectTab err:%s", e2.getMessage());
                            }
                        }
                    });
                    view.setLayoutParams(layoutParams);
                    gameTabWidget2.addView(view);
                }
            }
            Log.i("MicroMsg.GameTabWidget2", "bindLayout");
            a aVar = gameTabWidget2.xXp;
            aVar.aA(aVar.xXB, aVar.xXC);
        }
        AppMethodBeat.o(204274);
    }
}
