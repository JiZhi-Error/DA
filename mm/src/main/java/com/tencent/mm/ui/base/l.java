package com.tencent.mm.ui.base;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class l extends AlertDialog {
    private CharSequence Hn;
    public AdapterView.OnItemClickListener Kth;
    private View jBN;
    private Context mContext;
    private ListView mListView;
    public BaseAdapter pXY;

    public l(Context context) {
        super(context, R.style.a66);
        AppMethodBeat.i(142033);
        this.mContext = context;
        if (a.jk(this.mContext)) {
            this.jBN = View.inflate(this.mContext, R.layout.b8e, null);
        } else {
            this.jBN = View.inflate(this.mContext, R.layout.b8d, null);
        }
        this.mListView = (ListView) this.jBN.findViewById(R.id.ecm);
        AppMethodBeat.o(142033);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(142034);
        super.onCreate(bundle);
        setContentView(this.jBN);
        AppMethodBeat.o(142034);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.Hn = charSequence;
        } else {
            this.Hn = null;
        }
    }

    public final void show() {
        AppMethodBeat.i(142035);
        if (this.Hn != null) {
            this.Hn.length();
        }
        if (this.Kth != null) {
            this.mListView.setOnItemClickListener(this.Kth);
        }
        if (this.pXY != null) {
            this.mListView.setAdapter((ListAdapter) this.pXY);
        }
        super.show();
        AppMethodBeat.o(142035);
    }

    public final void dismiss() {
        AppMethodBeat.i(142036);
        try {
            super.dismiss();
            AppMethodBeat.o(142036);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMListDialog", "dismiss exception, e = " + e2.getMessage());
            AppMethodBeat.o(142036);
        }
    }
}
