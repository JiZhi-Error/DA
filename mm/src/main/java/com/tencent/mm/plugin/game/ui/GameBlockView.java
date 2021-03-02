package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class GameBlockView extends LinearLayout {
    LayoutInflater mInflater;
    LinearLayout tmh;
    LinearLayout.LayoutParams xOV;
    k xOW;
    a xOX;

    public GameBlockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(41910);
        super.onFinishInflate();
        setOrientation(1);
        this.mInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.xOV = new LinearLayout.LayoutParams(-1, -2);
        this.tmh = this;
        this.xOW = new k();
        Log.i("MicroMsg.GameBlockView", "initView finished");
        AppMethodBeat.o(41910);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public ImageView xOL;
        public TextView xOM;
        public ViewGroup xPa;
        public TextView xPb;
        public GameDownloadView xPc;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
