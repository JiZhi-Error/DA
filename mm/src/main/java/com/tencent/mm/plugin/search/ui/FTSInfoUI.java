package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.Calendar;
import java.util.List;

public class FTSInfoUI extends MMActivity implements l {
    private Button CVJ;
    private Button CVK;
    private Button CVL;
    private Button CVM;
    private View.OnClickListener CVN = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.search.ui.FTSInfoUI.AnonymousClass3 */

        public final void onClick(View view) {
            List<Pair<String, String>> Ci;
            AppMethodBeat.i(28075);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/search/ui/FTSInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue == 1) {
                FTSInfoUI.eCQ();
                Ci = ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).cAL();
            } else if (intValue == 2) {
                Ci = ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).Cj(FTSInfoUI.eCQ());
            } else if (intValue == 3) {
                Ci = ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).Ci(FTSInfoUI.eCQ());
            } else {
                a.a(this, "com/tencent/mm/plugin/search/ui/FTSInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28075);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (Pair<String, String> pair : Ci) {
                stringBuffer.append("[");
                stringBuffer.append(((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName((String) pair.first));
                stringBuffer.append("]\n");
                stringBuffer.append((String) pair.second);
                stringBuffer.append("\n");
            }
            FTSInfoUI.this.xcX.setText(stringBuffer.toString());
            a.a(this, "com/tencent/mm/plugin/search/ui/FTSInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28075);
        }
    };
    private q nUq;
    private TextView xcX;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FTSInfoUI() {
        AppMethodBeat.i(28076);
        AppMethodBeat.o(28076);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(28077);
        super.onCreate(bundle);
        setMMTitle(R.string.dk6);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.search.ui.FTSInfoUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(28072);
                FTSInfoUI.this.finish();
                AppMethodBeat.o(28072);
                return false;
            }
        });
        this.CVJ = (Button) findViewById(R.id.dxs);
        this.xcX = (TextView) findViewById(R.id.dy9);
        this.CVJ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.search.ui.FTSInfoUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(28074);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/search/ui/FTSInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (FTSInfoUI.this.nUq == null) {
                    FTSInfoUI.this.nUq = h.a((Context) FTSInfoUI.this, FTSInfoUI.this.getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.search.ui.FTSInfoUI.AnonymousClass2.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(28073);
                            FTSInfoUI.this.finish();
                            AppMethodBeat.o(28073);
                        }
                    });
                }
                FTSInfoUI.this.nUq.show();
                j jVar = new j();
                jVar.kXb = 65526;
                jVar.wWZ = FTSInfoUI.this;
                ((n) g.ah(n.class)).search(10000, jVar);
                a.a(this, "com/tencent/mm/plugin/search/ui/FTSInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28074);
            }
        });
        this.CVK = (Button) findViewById(R.id.gh2);
        this.CVL = (Button) findViewById(R.id.gh4);
        this.CVM = (Button) findViewById(R.id.gh3);
        this.CVK.setTag(1);
        this.CVL.setTag(2);
        this.CVM.setTag(3);
        this.CVK.setOnClickListener(this.CVN);
        this.CVL.setOnClickListener(this.CVN);
        this.CVM.setOnClickListener(this.CVN);
        AppMethodBeat.o(28077);
    }

    public static long eCQ() {
        AppMethodBeat.i(28078);
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        AppMethodBeat.o(28078);
        return timeInMillis;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.anf;
    }

    @Override // com.tencent.mm.plugin.fts.a.l
    public final void b(k kVar) {
        AppMethodBeat.i(28079);
        if (this.nUq != null) {
            this.nUq.dismiss();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[DBSize]=" + Util.getSizeMB(e.wVl.wVo * 1048576));
        stringBuffer.append("\n");
        stringBuffer.append("[WXContact]=" + e.wVl.wVp);
        stringBuffer.append("\n");
        stringBuffer.append("[WXChatroom]=" + e.wVl.wVq);
        stringBuffer.append("\n");
        stringBuffer.append("[Favorite]=" + e.wVl.wVs);
        stringBuffer.append("\n");
        stringBuffer.append("[Message]=" + e.wVl.wVr);
        stringBuffer.append("\n");
        stringBuffer.append("[WebSearchH5Version]=" + ai.aft(0));
        stringBuffer.append("\n");
        stringBuffer.append("[TopStoryH5Version]=" + ai.aft(1));
        stringBuffer.append("\n");
        stringBuffer.append("[WxAppH5Version]=" + ai.aft(3));
        stringBuffer.append("\n");
        stringBuffer.append("[BoxH5Version]=" + ai.aft(2));
        stringBuffer.append("\n");
        stringBuffer.append("[TopStoryWebViewCore]=" + ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType());
        stringBuffer.append("\n");
        stringBuffer.append("[PardusH5Version]=" + ai.aft(5));
        stringBuffer.append("\n");
        this.xcX.setText(stringBuffer.toString());
        AppMethodBeat.o(28079);
    }
}
