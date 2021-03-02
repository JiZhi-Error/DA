package com.tencent.mm.plugin.lite.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WxaLiteAppListUI extends MMActivity {
    private static String TAG = "MicroMsg.WxaLiteAppListUI";
    private static Map<String, String> yFk = new HashMap<String, String>() {
        /* class com.tencent.mm.plugin.lite.ui.WxaLiteAppListUI.AnonymousClass1 */

        {
            AppMethodBeat.i(198939);
            put("wxalited0d6cb88ac866bcdf3b738f1f3df8872", "游戏中心视频流");
            put("wxalite57af7e6c7eea13b5e789762aecade923", "测试用例页面");
            put("wxalitecce81f5fba338df4dd5f74df8229c600", "游戏中心攻略页");
            put("wxalitea95723728764364c6f996b4bdab3af52", "游戏中心福利页");
            AppMethodBeat.o(198939);
        }
    };
    private ListView mListView;
    private b yFj;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(198948);
        AppMethodBeat.o(198948);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.azw;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(198947);
        super.onCreate(bundle);
        this.mListView = (ListView) findViewById(R.id.ecm);
        this.yFj = new b();
        this.mListView.setAdapter((ListAdapter) this.yFj);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.lite.ui.WxaLiteAppListUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(198940);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/lite/ui/WxaLiteAppListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                WxaLiteAppInfo Pw = WxaLiteAppListUI.this.yFj.Pw(i2);
                if (Pw != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("appId", Pw.appId);
                    if (!LiteAppCenter.LITE_APP_BASE_LIB.equals(Pw.appId)) {
                        ((com.tencent.mm.plugin.lite.a.a) g.af(com.tencent.mm.plugin.lite.a.a.class)).a(MMApplicationContext.getContext(), bundle, false, null);
                    } else {
                        Toast.makeText(WxaLiteAppListUI.this.getContext(), "Is Base Lib ", 0).show();
                    }
                } else {
                    Log.d(WxaLiteAppListUI.TAG, "info is null.");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/lite/ui/WxaLiteAppListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(198940);
            }
        });
        AppMethodBeat.o(198947);
    }

    /* access modifiers changed from: package-private */
    public class b extends BaseAdapter {
        private List<WxaLiteAppInfo> qXp = f.ecD();

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(198946);
            WxaLiteAppInfo Pw = Pw(i2);
            AppMethodBeat.o(198946);
            return Pw;
        }

        b() {
            AppMethodBeat.i(198942);
            f.ecC();
            AppMethodBeat.o(198942);
        }

        public final int getCount() {
            AppMethodBeat.i(198943);
            if (this.qXp == null) {
                AppMethodBeat.o(198943);
                return 0;
            }
            int size = this.qXp.size();
            AppMethodBeat.o(198943);
            return size;
        }

        public final WxaLiteAppInfo Pw(int i2) {
            AppMethodBeat.i(198944);
            if (this.qXp == null || this.qXp.size() <= i2) {
                AppMethodBeat.o(198944);
                return null;
            }
            WxaLiteAppInfo wxaLiteAppInfo = this.qXp.get(i2);
            AppMethodBeat.o(198944);
            return wxaLiteAppInfo;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            a aVar;
            String str;
            AppMethodBeat.i(198945);
            WxaLiteAppInfo wxaLiteAppInfo = this.qXp.get(i2);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(WxaLiteAppListUI.this.getContext()).inflate(R.layout.azv, (ViewGroup) null, false);
                aVar = new a(view);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            String str2 = wxaLiteAppInfo.appId;
            if (WxaLiteAppListUI.yFk.containsKey(wxaLiteAppInfo.appId)) {
                str = (String) WxaLiteAppListUI.yFk.get(wxaLiteAppInfo.appId);
            } else {
                str = str2;
            }
            aVar.vr.setText(str);
            AppMethodBeat.o(198945);
            return view;
        }
    }

    class a {
        public TextView vr;

        public a(View view) {
            AppMethodBeat.i(198941);
            this.vr = (TextView) view.findViewById(R.id.ipm);
            AppMethodBeat.o(198941);
        }
    }
}
