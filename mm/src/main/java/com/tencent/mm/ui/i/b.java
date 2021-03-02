package com.tencent.mm.ui.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.p;

public final class b extends p {
    public long mDuration = 3000;
    @SuppressLint({"HandlerLeak"})
    private MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.ui.i.b.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(142860);
            switch (message.what) {
                case 256:
                    b.this.dismiss();
                    AppMethodBeat.o(142860);
                    return;
                default:
                    super.handleMessage(message);
                    AppMethodBeat.o(142860);
                    return;
            }
        }
    };

    private b(View view) {
        super(view);
        AppMethodBeat.i(142861);
        AppMethodBeat.o(142861);
    }

    public static b kz(Context context) {
        AppMethodBeat.i(142862);
        View inflate = LayoutInflater.from(context).inflate(R.layout.c3i, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.ird)).setVisibility(8);
        b bVar = new b(inflate);
        bVar.setFocusable(false);
        bVar.setContentView(inflate);
        bVar.setWidth(-1);
        bVar.setHeight(-1);
        bVar.setAnimationStyle(R.style.zj);
        bVar.mDuration = 1200;
        AppMethodBeat.o(142862);
        return bVar;
    }

    public final void showAsDropDown(View view, int i2, int i3) {
        AppMethodBeat.i(142863);
        super.showAsDropDown(view, i2, i3);
        this.mHandler.removeMessages(256);
        this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
        AppMethodBeat.o(142863);
    }

    public final void showAsDropDown(View view) {
        AppMethodBeat.i(142864);
        super.showAsDropDown(view);
        this.mHandler.removeMessages(256);
        this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
        AppMethodBeat.o(142864);
    }

    public final void showAtLocation(View view, int i2, int i3, int i4) {
        AppMethodBeat.i(142865);
        super.showAtLocation(view, i2, i3, i4);
        this.mHandler.removeMessages(256);
        this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
        AppMethodBeat.o(142865);
    }
}
