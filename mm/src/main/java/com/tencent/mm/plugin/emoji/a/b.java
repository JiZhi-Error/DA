package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;

public final class b {
    private final String TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    public View kHq;
    public Context mContext;
    public String qXi;
    public ImageView qXj;
    public ImageView qXk;
    public TextView qbV;

    public b(Context context) {
        AppMethodBeat.i(108295);
        this.mContext = context;
        this.kHq = aa.jQ(this.mContext).inflate(R.layout.a35, (ViewGroup) null);
        cFi();
        AppMethodBeat.o(108295);
    }

    public b(Context context, View view) {
        AppMethodBeat.i(108296);
        this.mContext = context;
        this.kHq = view;
        cFi();
        AppMethodBeat.o(108296);
    }

    private void cFi() {
        AppMethodBeat.i(108297);
        if (this.kHq == null) {
            Log.w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
            AppMethodBeat.o(108297);
            return;
        }
        this.qXj = (ImageView) this.kHq.findViewById(R.id.e2f);
        this.qbV = (TextView) this.kHq.findViewById(R.id.e40);
        this.qXk = (ImageView) this.kHq.findViewById(R.id.e2c);
        AppMethodBeat.o(108297);
    }
}
