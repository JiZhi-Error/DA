package com.tencent.mm.plugin.topstory.ui.debug;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Process;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.y;
import com.tencent.mm.vfs.s;

public class TopStoryDebugUI extends MMActivity {
    private TextView Gki;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125896);
        super.onCreate(bundle);
        setMMTitle(R.string.hpm);
        setBackBtn(new y() {
            /* class com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.y
            public final void ane() {
                AppMethodBeat.i(125893);
                TopStoryDebugUI.this.finish();
                AppMethodBeat.o(125893);
            }
        });
        final at afr = ai.afr(1);
        this.Gki = (TextView) findViewById(R.id.j3_);
        this.Gki.setText(getString(R.string.hpk, new Object[]{String.valueOf(afr.bbw())}));
        findViewById(R.id.b3k).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(125894);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                s.dy(afr.fYs(), true);
                com.tencent.mm.hellhoundlib.b.a a2 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                Object obj = new Object();
                a.a(obj, a2.axQ(), "com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$2", "onClick", "(Landroid/view/View;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                Process.killProcess(((Integer) a2.pG(0)).intValue());
                a.a(obj, "com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$2", "onClick", "(Landroid/view/View;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                a.a(this, "com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(125894);
            }
        });
        findViewById(R.id.gh1).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(125895);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                try {
                    TopStoryDebugUI.bG(TopStoryDebugUI.this, s.boY(com.tencent.mm.loader.j.b.aKJ() + "topstory/trace.info"));
                } catch (Exception e2) {
                }
                a.a(this, "com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(125895);
            }
        });
        AppMethodBeat.o(125896);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c3n;
    }

    static /* synthetic */ void bG(Context context, String str) {
        AppMethodBeat.i(125897);
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        textView.setTextColor(context.getResources().getColor(R.color.FG_0));
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.hs);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        h.a(context, (String) null, textView, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(125897);
    }
}
