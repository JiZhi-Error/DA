package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class b extends BaseAdapter {
    private LayoutInflater kgB;
    private String[] kjQ;
    private Drawable kjR = null;
    private View.OnTouchListener kjS = new View.OnTouchListener() {
        /* class com.tencent.mm.plugin.account.ui.b.AnonymousClass1 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(127864);
            if (motionEvent.getAction() == 0) {
                ((TextView) view.findViewById(R.id.lq)).setTextColor(b.this.mContext.getResources().getColor(R.color.l4));
                AppMethodBeat.o(127864);
            } else if (motionEvent.getAction() == 1) {
                ((TextView) view.findViewById(R.id.lq)).setTextColor(b.this.mContext.getResources().getColor(R.color.ag2));
                AppMethodBeat.o(127864);
            } else {
                AppMethodBeat.o(127864);
            }
            return false;
        }
    };
    private Context mContext;

    public b(Context context, String[] strArr) {
        AppMethodBeat.i(127865);
        this.kjQ = strArr;
        this.mContext = context;
        this.kgB = LayoutInflater.from(context);
        this.kjR = context.getResources().getDrawable(R.drawable.bnv);
        this.kjR.setBounds(0, 0, this.kjR.getIntrinsicWidth(), this.kjR.getIntrinsicHeight());
        AppMethodBeat.o(127865);
    }

    public final int getCount() {
        return this.kjQ.length;
    }

    public final Object getItem(int i2) {
        return this.kjQ[i2];
    }

    private boolean vn(int i2) {
        if (i2 == this.kjQ.length - 1) {
            return true;
        }
        return false;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(127866);
        if (view == null) {
            view = this.kgB.inflate(R.layout.co, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.lq);
        view.setOnTouchListener(this.kjS);
        if (i2 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !vn(i2)) {
            if (i2 != 0) {
                z2 = false;
            }
            if (z2) {
                textView.setPadding(25, 0, 10, 10);
                textView.setCompoundDrawablePadding(10);
                textView.setCompoundDrawables(null, null, this.kjR, null);
            } else if (vn(i2)) {
                textView.setPadding(0, 0, 25, 10);
                textView.setCompoundDrawablePadding(0);
                textView.setCompoundDrawables(null, null, null, null);
            } else {
                textView.setPadding(0, 0, 10, 10);
                textView.setCompoundDrawablePadding(10);
                textView.setCompoundDrawables(null, null, this.kjR, null);
            }
        } else {
            textView.setPadding(25, 0, 25, 10);
            textView.setCompoundDrawablePadding(0);
            textView.setCompoundDrawables(null, null, null, null);
        }
        textView.setText(this.kjQ[i2]);
        AppMethodBeat.o(127866);
        return view;
    }
}
