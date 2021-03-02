package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.p;

public final class a {
    private static final int[] jxw = {R.drawable.b_l, R.drawable.b_m, R.drawable.b_n, R.drawable.b_o, R.drawable.b_p, R.drawable.b_q, R.drawable.b_r};
    private static final int[] tfe = {0, 15, 30, 45, 60, 75, 90, 100};
    private p FQS;
    private TextView FQT;
    private ImageView FQU;
    private View FQV;
    private int Ftf;
    private Context context;
    private final MMHandler qPx = new MMHandler() {
        /* class com.tencent.mm.plugin.talkroom.ui.a.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(29570);
            super.handleMessage(message);
            a.this.FQS.dismiss();
            AppMethodBeat.o(29570);
        }
    };
    private View teY;
    private View teZ;
    private ImageView tfa;
    private View tfc;

    public a(Context context2) {
        AppMethodBeat.i(29571);
        this.context = context2;
        this.Ftf = BackwardSupportUtil.BitmapFactory.fromDPToPix(context2, 180.0f);
        this.FQS = new p(((LayoutInflater) context2.getSystemService("layout_inflater")).inflate(R.layout.c6s, (ViewGroup) null), -1, -2);
        this.tfa = (ImageView) this.FQS.getContentView().findViewById(R.id.j_n);
        this.tfc = this.FQS.getContentView().findViewById(R.id.j_q);
        this.FQT = (TextView) this.FQS.getContentView().findViewById(R.id.j_s);
        this.FQU = (ImageView) this.FQS.getContentView().findViewById(R.id.j_r);
        this.FQV = this.FQS.getContentView().findViewById(R.id.j_t);
        this.teY = this.FQS.getContentView().findViewById(R.id.j_u);
        this.teZ = this.FQS.getContentView().findViewById(R.id.j_v);
        AppMethodBeat.o(29571);
    }
}
