package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.b;

public class ActivityTestMultilineEllipse extends HellActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(97665);
        super.onCreate(bundle);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        addContentView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.addView(scrollView);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(-1);
        scrollView.addView(linearLayout2);
        QTextView qTextView = new QTextView(this);
        qTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        qTextView.setEllipsis("...");
        qTextView.setEllipsisMore(" Read More!");
        qTextView.setText("This is some short text. It won't need to be ellipsized.");
        qTextView.setMaxLines(3);
        qTextView.setPadding(10, 10, 10, 10);
        qTextView.setBackgroundColor(-1786127);
        linearLayout2.addView(qTextView);
        final QTextView qTextView2 = new QTextView(this);
        qTextView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        qTextView2.setEllipsis("...");
        qTextView2.setEllipsisMore(" Read More!");
        qTextView2.setMaxLines(3);
        qTextView2.setText("This is some longer text. It should wrap and then eventually be ellipsized once it gets way too long for the horizontal width of the current application screen. We should be fixed to max [N] lines height.");
        qTextView2.setPadding(10, 10, 10, 10);
        qTextView2.setBackgroundColor(-204878);
        qTextView2.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.ActivityTestMultilineEllipse.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(97664);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sns/ui/ActivityTestMultilineEllipse$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (qTextView2.getIsExpanded()) {
                    QTextView qTextView = qTextView2;
                    qTextView.pMC = false;
                    qTextView.requestLayout();
                    qTextView.invalidate();
                } else {
                    QTextView qTextView2 = qTextView2;
                    qTextView2.pMC = true;
                    qTextView2.requestLayout();
                    qTextView2.invalidate();
                }
                a.a(this, "com/tencent/mm/plugin/sns/ui/ActivityTestMultilineEllipse$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97664);
            }
        });
        linearLayout2.addView(qTextView2);
        AppMethodBeat.o(97665);
    }
}
