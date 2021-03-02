package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;

public final class h {
    TextView Xy;
    Context context;
    private String gzn;
    ArrayList<String> hXt;
    MMHandler mHandler = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.location.ui.h.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(55922);
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    h.this.Xy.setText(h.this.yJu);
                    AppMethodBeat.o(55922);
                    return;
                case 2:
                    Log.d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", Boolean.valueOf(h.this.yIZ), Boolean.valueOf(h.this.yJt));
                    if (!h.this.yIZ && !h.this.yJt) {
                        h hVar = h.this;
                        hVar.Xy.setTextColor(hVar.yJq);
                        hVar.Xy.invalidate();
                        int intValue = ((Integer) message.obj).intValue();
                        if (intValue == 0) {
                            h.this.Xy.setText(h.this.context.getString(R.string.hr9));
                            AppMethodBeat.o(55922);
                            return;
                        }
                        h.this.Xy.setText(h.this.context.getResources().getQuantityString(R.plurals.a9, intValue, Integer.valueOf(intValue)));
                        AppMethodBeat.o(55922);
                        return;
                    }
                case 3:
                    if (h.this.yJt || h.this.yIZ) {
                        removeMessages(3);
                        Message obtain = Message.obtain();
                        obtain.what = 3;
                        obtain.obj = message.obj;
                        sendMessage(obtain);
                        AppMethodBeat.o(55922);
                        return;
                    }
                    h.this.yJu = h.this.Xy.getText().toString();
                    h.a(h.this);
                    String displayName = aa.getDisplayName((String) message.obj);
                    h.this.Xy.setText(h.this.context.getString(R.string.hre, displayName));
                    if (h.this.yIZ || h.this.yJt) {
                        h.b(h.this);
                        AppMethodBeat.o(55922);
                        return;
                    }
                    break;
                case 4:
                    if (h.this.yJt || h.this.yIZ) {
                        removeMessages(4);
                        Message obtain2 = Message.obtain();
                        obtain2.what = 4;
                        obtain2.obj = message.obj;
                        sendMessage(obtain2);
                        AppMethodBeat.o(55922);
                        return;
                    }
                    h.this.yJu = h.this.Xy.getText().toString();
                    h.a(h.this);
                    String displayName2 = aa.getDisplayName((String) message.obj);
                    h.this.Xy.setText(h.this.context.getString(R.string.hrf, displayName2));
                    if (h.this.yIZ || h.this.yJt) {
                        h.b(h.this);
                        AppMethodBeat.o(55922);
                        return;
                    }
                    break;
                case 5:
                    h.this.yJt = true;
                    h.this.yIZ = false;
                    h.a(h.this);
                    String displayName3 = aa.getDisplayName((String) message.obj);
                    h.this.Xy.setText(h.this.context.getString(R.string.hrg, displayName3));
                    AppMethodBeat.o(55922);
                    return;
                case 6:
                    h.this.yIZ = true;
                    h.this.yJt = false;
                    h.a(h.this);
                    h.this.Xy.setText(h.this.context.getString(R.string.hrd));
                    AppMethodBeat.o(55922);
                    return;
                case 7:
                    h.this.yJt = true;
                    h hVar2 = h.this;
                    hVar2.Xy.setTextColor(hVar2.yJr);
                    hVar2.Xy.invalidate();
                    h.this.Xy.setText(h.this.context.getString(R.string.hri));
                    h.this.yJu = h.this.Xy.getText().toString();
                    h.b(h.this);
                    AppMethodBeat.o(55922);
                    return;
                case 8:
                    h hVar3 = h.this;
                    hVar3.Xy.setTextColor(hVar3.yJs);
                    hVar3.Xy.invalidate();
                    h.this.Xy.setText(h.this.context.getString(R.string.hrj));
                    AppMethodBeat.o(55922);
                    return;
                case 9:
                    h.this.yIZ = false;
                    if (!h.this.yJt) {
                        h.this.qH(true);
                        AppMethodBeat.o(55922);
                        return;
                    }
                    break;
                case 10:
                    h.this.yJt = false;
                    h.this.qH(false);
                    break;
            }
            AppMethodBeat.o(55922);
        }
    };
    boolean yIZ = false;
    private ViewGroup yJc;
    private final int yJd = 100;
    private final int yJe = 1;
    private final int yJf = 2;
    private final int yJg = 3;
    private final int yJh = 4;
    private final int yJi = 5;
    private final int yJj = 6;
    private final int yJk = 7;
    private final int yJl = 8;
    private final int yJm = 9;
    private final int yJn = 10;
    boolean yJo = true;
    private int yJp = Color.parseColor("#44FEBB");
    int yJq = Color.parseColor("#FFFFFF");
    int yJr = Color.parseColor("#E54646");
    int yJs = Color.parseColor("#FFC90C");
    boolean yJt = false;
    String yJu = "";

    public h(Context context2, ViewGroup viewGroup, String str) {
        AppMethodBeat.i(55923);
        this.context = context2;
        this.yJc = viewGroup;
        this.Xy = (TextView) this.yJc.findViewById(R.id.ipm);
        this.gzn = str;
        init();
        AppMethodBeat.o(55923);
    }

    private void init() {
        AppMethodBeat.i(55924);
        Log.d("MicroMsg.ShareHeaderMsgMgr", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        this.Xy.invalidate();
        this.hXt = new ArrayList<>();
        for (String str : n.ecS().PY(this.gzn)) {
            this.hXt.add(str);
        }
        qH(false);
        AppMethodBeat.o(55924);
    }

    /* access modifiers changed from: package-private */
    public final void qH(boolean z) {
        AppMethodBeat.i(55925);
        this.mHandler.removeMessages(2);
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = Integer.valueOf(this.hXt.size());
        Log.d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", Integer.valueOf(this.hXt.size()), Boolean.valueOf(z));
        if (z) {
            this.mHandler.sendMessageDelayed(obtain, 100);
            AppMethodBeat.o(55925);
            return;
        }
        this.mHandler.sendMessage(obtain);
        AppMethodBeat.o(55925);
    }

    static /* synthetic */ void a(h hVar) {
        AppMethodBeat.i(55926);
        hVar.Xy.setTextColor(hVar.yJp);
        hVar.Xy.invalidate();
        AppMethodBeat.o(55926);
    }

    static /* synthetic */ void b(h hVar) {
        AppMethodBeat.i(55927);
        hVar.mHandler.removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 1;
        hVar.mHandler.sendMessageDelayed(obtain, 100);
        AppMethodBeat.o(55927);
    }
}
