package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class PreViewListGridView extends ListView {
    private MMHandler mHandler = new MMHandler();
    private int mOrientation;
    private WindowManager mWindowManager;
    private boolean rnf = true;
    private WindowManager.LayoutParams rnl;
    private int rnm;
    private int rnn;
    private int rno;
    private boolean rnp;
    private volatile int rnq = -1;
    private String rnr;
    private PopEmojiView rns;
    private a rnt;

    @Override // android.widget.AbsListView, android.widget.ListView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter adapter) {
        AppMethodBeat.i(109427);
        setAdapter((ListAdapter) adapter);
        AppMethodBeat.o(109427);
    }

    public PreViewListGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(109421);
        init(context);
        AppMethodBeat.o(109421);
    }

    public PreViewListGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(109422);
        init(context);
        AppMethodBeat.o(109422);
    }

    private void init(Context context) {
        AppMethodBeat.i(109423);
        this.rns = new PopEmojiView(getContext());
        this.rnm = context.getResources().getDimensionPixelSize(R.dimen.a3d);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.rnl = new WindowManager.LayoutParams(-1, -1, 2, 8, 1);
        this.rnl.width = this.rnm;
        this.rnl.height = this.rnm;
        this.rnl.gravity = 17;
        this.mOrientation = getResources().getConfiguration().orientation;
        if (this.mOrientation == 2) {
            this.rnn = this.mWindowManager.getDefaultDisplay().getHeight();
            this.rno = this.mWindowManager.getDefaultDisplay().getWidth();
            AppMethodBeat.o(109423);
            return;
        }
        this.rnn = this.mWindowManager.getDefaultDisplay().getWidth();
        this.rno = this.mWindowManager.getDefaultDisplay().getHeight();
        AppMethodBeat.o(109423);
    }

    @Override // android.widget.AbsListView, android.widget.ListView
    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.i(109424);
        super.setAdapter(listAdapter);
        this.rnt = (a) listAdapter;
        AppMethodBeat.o(109424);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(109425);
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (this.rnp) {
                    cIq();
                    AppMethodBeat.o(109425);
                    return true;
                }
                break;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(109425);
        return onInterceptTouchEvent;
    }

    public final void cIq() {
        AppMethodBeat.i(109426);
        if (this.rnp) {
            this.mWindowManager.removeView(this.rns);
            this.rnp = false;
        }
        this.rnr = "";
        AppMethodBeat.o(109426);
    }

    public void setEnablePreView(boolean z) {
        this.rnf = z;
    }
}
