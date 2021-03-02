package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class MMCallBackScrollView extends ScrollView {
    private int Bpm;
    private a Bpn;
    private MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(27678);
            int scrollY = MMCallBackScrollView.this.getScrollY();
            if (scrollY == MMCallBackScrollView.this.Bpm) {
                MMCallBackScrollView.a(MMCallBackScrollView.this, 0);
                AppMethodBeat.o(27678);
                return;
            }
            MMCallBackScrollView.this.Bpm = scrollY;
            MMCallBackScrollView.this.mHandler.sendMessageDelayed(MMCallBackScrollView.this.mHandler.obtainMessage(), 5);
            MMCallBackScrollView.a(MMCallBackScrollView.this, 1);
            AppMethodBeat.o(27678);
        }
    };
    private int mState = 0;

    public interface a {
        void onScrollStateChanged(int i2);
    }

    static /* synthetic */ void a(MMCallBackScrollView mMCallBackScrollView, int i2) {
        AppMethodBeat.i(27683);
        mMCallBackScrollView.Vd(i2);
        AppMethodBeat.o(27683);
    }

    public void setMMOnScrollListener(a aVar) {
        this.Bpn = aVar;
    }

    private void Vd(int i2) {
        AppMethodBeat.i(27679);
        if (!(this.Bpn == null || this.mState == i2)) {
            this.mState = i2;
            this.Bpn.onScrollStateChanged(i2);
        }
        AppMethodBeat.o(27679);
    }

    public MMCallBackScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27680);
        AppMethodBeat.o(27680);
    }

    public MMCallBackScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27681);
        AppMethodBeat.o(27681);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(27682);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        this.Bpm = getScrollY();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.mHandler != null) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(), 5);
                    break;
                }
                break;
            case 2:
                Vd(1);
                break;
        }
        AppMethodBeat.o(27682);
        return onTouchEvent;
    }
}
