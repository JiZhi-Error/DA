package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.support.v4.view.b.b;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.ChattingAnimFrame;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.LinkedList;
import java.util.List;

public class ChattingScrollLayout extends LinearLayout {
    private Runnable KmR;
    private int KmS;
    private int KmT;
    private int KmU;
    private int KmV;
    private int KmW;
    private View KmX;
    MMChattingListView KmY;
    private final List<a> listeners;
    private View qdl;
    private OverScroller rW;

    public interface a {
        void gru();
    }

    public ChattingScrollLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChattingScrollLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(31733);
        this.KmS = 0;
        this.KmT = 0;
        this.KmU = 0;
        this.KmV = 0;
        this.listeners = new LinkedList();
        this.rW = new OverScroller(getContext(), new b());
        AppMethodBeat.o(31733);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(31734);
        super.onFinishInflate();
        this.qdl = findViewById(R.id.ftn);
        this.KmX = findViewById(R.id.auh);
        this.KmY = (MMChattingListView) findViewById(R.id.avl);
        AppMethodBeat.o(31734);
    }

    public final void c(int i2, final boolean z, final int i3, int i4) {
        AppMethodBeat.i(185854);
        Log.i("MicroMsg.ChattingScrollLayout", "scrollContentTo: %s", Integer.valueOf(i2));
        if (this.KmT == i2) {
            AppMethodBeat.o(185854);
            return;
        }
        this.KmT = i2;
        if (this.KmT != 0) {
            this.KmU = this.KmT;
        }
        this.KmW = i4;
        grt();
        this.rW.forceFinished(true);
        removeCallbacks(this.KmR);
        this.KmR = new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.chat.ChattingScrollLayout.AnonymousClass1 */

            public final void run() {
                int i2;
                int i3;
                AppMethodBeat.i(31732);
                Log.i("MicroMsg.ChattingScrollLayout", "scrollContentTo: in runnable");
                ChattingScrollLayout.this.KmR = null;
                int i4 = ChattingScrollLayout.this.KmT - ChattingScrollLayout.this.KmS;
                if (i3 == 0) {
                    i2 = 350;
                } else {
                    i2 = 175;
                }
                OverScroller overScroller = ChattingScrollLayout.this.rW;
                int i5 = ChattingScrollLayout.this.KmS;
                if (z) {
                    i3 = i2;
                } else {
                    i3 = 0;
                }
                overScroller.startScroll(0, i5, 0, i4, i3);
                u.X(ChattingScrollLayout.this);
                AppMethodBeat.o(31732);
            }
        };
        post(this.KmR);
        AppMethodBeat.o(185854);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(232331);
        if (aVar != null && !this.listeners.contains(aVar)) {
            this.listeners.add(aVar);
        }
        AppMethodBeat.o(232331);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(31736);
        Log.i("MicroMsg.ChattingScrollLayout", "onLayout: %s, %s, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        super.onLayout(z, i2, i3, i4, i5);
        if (this.KmR != null) {
            removeCallbacks(this.KmR);
            post(this.KmR);
        }
        if (this.rW != null && this.rW.isFinished()) {
            grs();
        }
        AppMethodBeat.o(31736);
    }

    public void computeScroll() {
        AppMethodBeat.i(31737);
        if (this.rW.computeScrollOffset()) {
            this.KmS = this.rW.getCurrY();
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt != this.KmX) {
                    childAt.setTranslationY((float) (-this.KmS));
                }
            }
            grs();
            u.X(this);
        }
        AppMethodBeat.o(31737);
    }

    private void grs() {
        float translationY;
        AppMethodBeat.i(31738);
        int bottomSpace = this.KmY.getBottomSpace();
        if (bottomSpace > 0) {
            translationY = ((float) bottomSpace) + this.qdl.getTranslationY();
        } else {
            translationY = this.qdl.getTranslationY();
        }
        float interTranslationY = translationY + ((float) getInterTranslationY());
        if (interTranslationY > 0.0f) {
            interTranslationY = 0.0f;
        }
        this.KmY.setTranslationY(interTranslationY);
        for (a aVar : this.listeners) {
            this.rW.isFinished();
            aVar.gru();
        }
        AppMethodBeat.o(31738);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(31739);
        if (motionEvent.getActionMasked() == 0) {
            this.KmV = this.KmS;
        } else {
            motionEvent.offsetLocation(0.0f, (float) (this.KmV - this.KmS));
            if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
                this.KmV = 0;
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(31739);
        return dispatchTouchEvent;
    }

    private void grt() {
        ChattingAnimFrame chattingAnimFrame;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        AppMethodBeat.i(31740);
        ChattingAnimFrame chattingAnimFrame2 = (ChattingAnimFrame) findViewById(R.id.arw);
        if (chattingAnimFrame2 == null) {
            View findViewById = findViewById(R.id.j7t);
            Log.i("MicroMsg.ChattingScrollLayout", "resizeChatAnimFrame: use view stub");
            chattingAnimFrame = findViewById;
        } else {
            Log.i("MicroMsg.ChattingScrollLayout", "resizeChatAnimFrame: use view");
            chattingAnimFrame = chattingAnimFrame2;
        }
        if (!(chattingAnimFrame == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) chattingAnimFrame.getLayoutParams()) == null)) {
            marginLayoutParams.bottomMargin = this.KmT;
            chattingAnimFrame.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(31740);
    }

    private int getInterTranslationY() {
        if (this.KmU != 0) {
            return (int) (((1.0d * ((double) this.KmS)) / ((double) this.KmU)) * ((double) this.KmW));
        }
        return 0;
    }
}
