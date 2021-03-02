package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public class MMLoadMoreListView extends ListView {
    private boolean ORA = false;
    private boolean ORB = false;
    private a ORz = null;
    private View rfF = null;
    private TextView unG;

    public interface a {
        void onLoadMore();
    }

    public MMLoadMoreListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142039);
        init();
        AppMethodBeat.o(142039);
    }

    public MMLoadMoreListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142040);
        init();
        AppMethodBeat.o(142040);
    }

    private void gKK() {
        AppMethodBeat.i(142041);
        this.rfF = View.inflate(getContext(), R.layout.b84, null);
        this.unG = (TextView) this.rfF.findViewById(R.id.d8v);
        this.rfF.setVisibility(8);
        AppMethodBeat.o(142041);
    }

    private void init() {
        AppMethodBeat.i(142042);
        if (this.rfF == null) {
            gKK();
            addFooterView(this.rfF);
            this.rfF.setVisibility(8);
        }
        AppMethodBeat.o(142042);
    }

    public final void gKL() {
        AppMethodBeat.i(142043);
        if (this.rfF == null) {
            gKK();
        }
        try {
            removeFooterView(this.rfF);
            addFooterView(this.rfF);
            AppMethodBeat.o(142043);
        } catch (Exception e2) {
            AppMethodBeat.o(142043);
        }
    }

    public void setOnLoadMoreListener(a aVar) {
        this.ORz = aVar;
    }

    public final void gKM() {
        AppMethodBeat.i(142044);
        this.ORA = true;
        setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.ui.base.MMLoadMoreListView.AnonymousClass1 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(142037);
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && MMLoadMoreListView.this.ORz != null) {
                    MMLoadMoreListView.this.ORz.onLoadMore();
                }
                AppMethodBeat.o(142037);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(142038);
                if (i2 == 0 && MMLoadMoreListView.this.getChildAt(0) != null && MMLoadMoreListView.this.getChildAt(0).getTop() == MMLoadMoreListView.this.getPaddingTop()) {
                    MMLoadMoreListView.this.ORB = true;
                } else {
                    MMLoadMoreListView.this.ORB = false;
                }
                Log.d("MMLoadMoreListView", "newpoi scroll2Top %s", new StringBuilder().append(MMLoadMoreListView.this.ORB).toString());
                AppMethodBeat.o(142038);
            }
        });
        AppMethodBeat.o(142044);
    }

    public boolean getScroll2Top() {
        AppMethodBeat.i(142045);
        if (getFirstVisiblePosition() == 0 && getChildAt(0) != null && getChildAt(0).getTop() == getPaddingTop()) {
            AppMethodBeat.o(142045);
            return true;
        }
        AppMethodBeat.o(142045);
        return false;
    }

    public void setOnFootrClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(142046);
        this.unG.setOnClickListener(onClickListener);
        AppMethodBeat.o(142046);
    }

    public void setFooterTips(String str) {
        AppMethodBeat.i(142047);
        this.unG.setText(str);
        AppMethodBeat.o(142047);
    }

    public final void gKN() {
        AppMethodBeat.i(142048);
        if (this.rfF != null) {
            this.unG.setVisibility(8);
            this.rfF.setVisibility(8);
        }
        AppMethodBeat.o(142048);
    }

    public final void gKO() {
        AppMethodBeat.i(142049);
        if (this.rfF.getParent() == null) {
            gKL();
        }
        this.unG.setVisibility(0);
        this.rfF.setVisibility(0);
        AppMethodBeat.o(142049);
    }

    public final void gKP() {
        AppMethodBeat.i(142050);
        removeFooterView(this.rfF);
        AppMethodBeat.o(142050);
    }
}
