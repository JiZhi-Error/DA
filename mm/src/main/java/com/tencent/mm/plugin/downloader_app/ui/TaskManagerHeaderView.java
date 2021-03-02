package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class TaskManagerHeaderView extends LinearLayout {
    private TextView qME = ((TextView) LayoutInflater.from(getContext()).inflate(R.layout.au9, (ViewGroup) this, true).findViewById(R.id.h7p));

    public TaskManagerHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(9085);
        setOrientation(1);
        this.qME.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.downloader_app.ui.TaskManagerHeaderView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(9084);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/downloader_app/ui/TaskManagerHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (TaskManagerHeaderView.this.getContext() instanceof DownloadMainUI) {
                    ((DownloadMainUI) TaskManagerHeaderView.this.getContext()).qMg.cCr();
                }
                a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskManagerHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(9084);
            }
        });
        View view = new View(getContext());
        view.setBackgroundColor(getResources().getColor(R.color.m7));
        addView(view, -1, 1);
        AppMethodBeat.o(9085);
    }
}
