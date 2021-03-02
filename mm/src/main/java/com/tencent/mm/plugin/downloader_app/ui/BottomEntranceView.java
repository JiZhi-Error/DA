package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;

public class BottomEntranceView extends RelativeLayout {
    private f qLT;
    private TextView qLU;
    private int qLV;
    private int qLW;

    public BottomEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(8973);
        super.onFinishInflate();
        this.qLU = (TextView) findViewById(R.id.c4d);
        int displayHeight = getDisplayHeight();
        int eu = au.eu(getContext());
        this.qLW = ((displayHeight - eu) - au.getStatusBarHeight(getContext())) - au.aD(getContext());
        this.qLV = getResources().getDimensionPixelSize(R.dimen.tu);
        Log.d("MicroMsg.BottomEntranceView", "mContentH = %d", Integer.valueOf(this.qLW));
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.plugin.downloader_app.ui.BottomEntranceView.AnonymousClass1 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(8971);
                BottomEntranceView.a(BottomEntranceView.this);
                AppMethodBeat.o(8971);
            }
        });
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.downloader_app.ui.BottomEntranceView.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(8972);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/downloader_app/ui/BottomEntranceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (BottomEntranceView.this.qLT != null && !Util.isNullOrNil(BottomEntranceView.this.qLT.pTL)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("rawUrl", BottomEntranceView.this.qLT.pTL);
                    ((c) g.af(c.class)).e(BottomEntranceView.this.getContext(), bundle);
                    com.tencent.mm.plugin.downloader_app.b.a.a(10, 1005, 1, 40, "", "", "");
                }
                a.a(this, "com/tencent/mm/plugin/downloader_app/ui/BottomEntranceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(8972);
            }
        });
        AppMethodBeat.o(8973);
    }

    public void setData(f fVar) {
        AppMethodBeat.i(8974);
        if (fVar == null || Util.isNullOrNil(fVar.desc) || Util.isNullOrNil(fVar.pTL)) {
            setVisibility(8);
            AppMethodBeat.o(8974);
            return;
        }
        this.qLT = fVar;
        setVisibility(0);
        this.qLU.setText(this.qLT.desc);
        AppMethodBeat.o(8974);
    }

    private int getDisplayHeight() {
        AppMethodBeat.i(8975);
        int i2 = au.az(getContext()).y;
        AppMethodBeat.o(8975);
        return i2;
    }

    static /* synthetic */ void a(BottomEntranceView bottomEntranceView) {
        AppMethodBeat.i(8976);
        if (bottomEntranceView.getVisibility() != 8) {
            for (ViewParent parent = bottomEntranceView.getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof TaskListView) {
                    int computeVerticalScrollRange = ((TaskListView) parent).computeVerticalScrollRange();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bottomEntranceView.getLayoutParams();
                    if (computeVerticalScrollRange < bottomEntranceView.qLW) {
                        layoutParams.topMargin += bottomEntranceView.qLW - computeVerticalScrollRange;
                        bottomEntranceView.setLayoutParams(layoutParams);
                    } else if (computeVerticalScrollRange > bottomEntranceView.qLW) {
                        if (layoutParams.topMargin > bottomEntranceView.qLV) {
                            layoutParams.topMargin -= computeVerticalScrollRange - bottomEntranceView.qLW;
                            bottomEntranceView.setLayoutParams(layoutParams);
                        } else if (layoutParams.topMargin < bottomEntranceView.qLV) {
                            layoutParams.topMargin = bottomEntranceView.qLV;
                            bottomEntranceView.setLayoutParams(layoutParams);
                        }
                    }
                    Log.d("MicroMsg.BottomEntranceView", "listH = %d, mContentH = %d, topMargin = %d, bottomMargin = %d", Integer.valueOf(computeVerticalScrollRange), Integer.valueOf(bottomEntranceView.qLW), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.bottomMargin));
                    AppMethodBeat.o(8976);
                    return;
                }
            }
        }
        AppMethodBeat.o(8976);
    }
}
