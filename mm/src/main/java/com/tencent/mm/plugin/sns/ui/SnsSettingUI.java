package com.tencent.mm.plugin.sns.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsSettingUI extends MMActivity {
    private a EJb = new a();
    private String TAG = "MicroMsg.SnsSettingUI";
    private LinkedList hUG = new LinkedList();
    private ListView hUI = null;

    interface d {
        String auk();

        void cp(View view);

        String value();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsSettingUI() {
        AppMethodBeat.i(203651);
        AppMethodBeat.o(203651);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bx4;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(203652);
        super.onCreate(bundle);
        this.hUI = (ListView) findViewById(R.id.hzz);
        this.hUI.setAdapter((ListAdapter) this.EJb);
        this.hUG.add(new c("清空朋友圈漏读提醒", "点我", new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSettingUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(203637);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                try {
                    s.deleteFile(aj.faZ().DNm);
                } catch (Exception e2) {
                    Log.w("MicroMsg.SnsUnreadTipManager", "removeLastFault error:%s", e2.getMessage());
                }
                u.makeText(MMApplicationContext.getContext(), "好了", 1).show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203637);
            }
        }));
        this.hUG.add(new c("朋友圈缩略图下载", "进行套图下载", new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSettingUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(203638);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                be.EGH = 1;
                h.c(SnsSettingUI.this, "已调整到套图下载，即刻生效！", "", true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203638);
            }
        }));
        this.hUG.add(new c("朋友圈缩略图下载", "进行单图下载", new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSettingUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(203639);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                be.EGH = 2;
                h.c(SnsSettingUI.this, "已调整到单图下载，即刻生效！", "", true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203639);
            }
        }));
        this.hUG.add(new c("朋友圈缩略图下载", "目前状态", new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSettingUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(203640);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                switch (be.EGH) {
                    case 1:
                        h.c(SnsSettingUI.this, "套图下载", "", true);
                        break;
                    case 2:
                        h.c(SnsSettingUI.this, "单图下载", "", true);
                        break;
                    default:
                        if (!be.fiv()) {
                            h.c(SnsSettingUI.this, "单图下载", "", true);
                            break;
                        } else {
                            h.c(SnsSettingUI.this, "套图下载", "", true);
                            break;
                        }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203640);
            }
        }));
        this.hUG.add(new c("朋友圈预加载cgi触发", "点我", new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSettingUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(203641);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g.aAi();
                g.aAg().hqi.a(new com.tencent.mm.plugin.sns.model.u(), 0);
                h.c(SnsSettingUI.this, "妥了", "", true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203641);
            }
        }));
        this.hUG.add(new b("朋友圈微商折叠辅助工具", ar.a.USERINFO_SNS_WS_FOLD_DEBUG_INT_SYNC, P("关", "开"), L(0, 1)));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSettingUI.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(203642);
                SnsSettingUI.this.finish();
                AppMethodBeat.o(203642);
                return false;
            }
        });
        AppMethodBeat.o(203652);
    }

    class c implements d {
        private View.OnClickListener EJh = null;
        private String title = null;
        private String value = null;

        public c(String str, String str2, View.OnClickListener onClickListener) {
            this.title = str;
            this.value = str2;
            this.EJh = onClickListener;
        }

        @Override // com.tencent.mm.plugin.sns.ui.SnsSettingUI.d
        public final void cp(View view) {
            AppMethodBeat.i(203650);
            this.EJh.onClick(view);
            u.makeText(MMApplicationContext.getContext(), "ClickItem Done", 1).show();
            AppMethodBeat.o(203650);
        }

        @Override // com.tencent.mm.plugin.sns.ui.SnsSettingUI.d
        public final String auk() {
            return this.title;
        }

        @Override // com.tencent.mm.plugin.sns.ui.SnsSettingUI.d
        public final String value() {
            return this.value;
        }
    }

    class b implements d {
        String hUN = "";
        ar.a hUO = null;
        Object hUQ = null;
        List<String> vQe = null;

        public b(String str, ar.a aVar, List<String> list, Object obj) {
            this.hUN = str;
            this.hUO = aVar;
            this.vQe = list;
            this.hUQ = obj;
        }

        @Override // com.tencent.mm.plugin.sns.ui.SnsSettingUI.d
        public final String value() {
            int i2 = 0;
            AppMethodBeat.i(203648);
            String str = "";
            if (this.hUQ instanceof int[]) {
                int i3 = g.aAh().azQ().getInt(this.hUO, 0);
                str = this.vQe.get(0);
                while (true) {
                    if (i2 < ((int[]) this.hUQ).length) {
                        if (i3 == ((int[]) this.hUQ)[i2] && i2 < this.vQe.size()) {
                            str = this.vQe.get(i2);
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            } else if (this.hUQ instanceof long[]) {
                long a2 = g.aAh().azQ().a(this.hUO, 0);
                str = this.vQe.get(0);
                while (true) {
                    if (i2 < ((long[]) this.hUQ).length) {
                        if (a2 == ((long[]) this.hUQ)[i2] && i2 < this.vQe.size()) {
                            str = this.vQe.get(i2);
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
            AppMethodBeat.o(203648);
            return str;
        }

        @Override // com.tencent.mm.plugin.sns.ui.SnsSettingUI.d
        public final String auk() {
            return this.hUN;
        }

        @Override // com.tencent.mm.plugin.sns.ui.SnsSettingUI.d
        public final void cp(View view) {
            AppMethodBeat.i(203649);
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < this.vQe.size(); i2++) {
                linkedList.add(this.vQe.get(i2));
                linkedList2.add(Integer.valueOf(i2));
            }
            h.a(SnsSettingUI.this, "", linkedList, linkedList2, "", new h.e() {
                /* class com.tencent.mm.plugin.sns.ui.SnsSettingUI.b.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.h.e
                public final void cy(int i2, int i3) {
                    AppMethodBeat.i(203647);
                    try {
                        if (b.this.hUQ instanceof int[]) {
                            g.aAh().azQ().set(b.this.hUO, Integer.valueOf(((int[]) b.this.hUQ)[i2]));
                        } else if (b.this.hUQ instanceof long[]) {
                            g.aAh().azQ().set(b.this.hUO, Long.valueOf(((long[]) b.this.hUQ)[i2]));
                        }
                        SnsSettingUI.this.EJb.notifyDataSetChanged();
                        AppMethodBeat.o(203647);
                    } catch (Exception e2) {
                        Log.printErrStackTrace(SnsSettingUI.this.TAG, e2, "", new Object[0]);
                        AppMethodBeat.o(203647);
                    }
                }
            });
            AppMethodBeat.o(203649);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        a() {
        }

        public final int getCount() {
            AppMethodBeat.i(203644);
            int size = SnsSettingUI.this.hUG.size();
            AppMethodBeat.o(203644);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(203645);
            Object obj = SnsSettingUI.this.hUG.get(i2);
            AppMethodBeat.o(203645);
            return obj;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(203646);
            final TextView textView = new TextView(SnsSettingUI.this);
            final d dVar = (d) getItem(i2);
            textView.setTag(dVar);
            textView.setText(dVar.auk() + "->:" + dVar.value());
            textView.setGravity(17);
            textView.setTextSize(1, 20.0f);
            textView.setHeight(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50));
            if (i2 % 2 == 1) {
                textView.setBackgroundColor(Color.parseColor("#e2efda"));
            }
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsSettingUI.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(203643);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$ChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    dVar.cp(textView);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$ChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203643);
                }
            });
            AppMethodBeat.o(203646);
            return textView;
        }
    }

    private static List<String> P(String... strArr) {
        AppMethodBeat.i(203653);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            arrayList.add(strArr[i2]);
        }
        AppMethodBeat.o(203653);
        return arrayList;
    }

    private static int[] L(int... iArr) {
        int[] iArr2 = new int[2];
        for (int i2 = 0; i2 < 2; i2++) {
            iArr2[i2] = iArr[i2];
        }
        return iArr2;
    }
}
