package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.smtt.sdk.WebView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class a extends RecyclerView.a {
    private static final SimpleDateFormat oFA = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    LayoutInflater mInflater;
    List<LogInfo> oFB = new LinkedList();

    static {
        AppMethodBeat.i(121614);
        AppMethodBeat.o(121614);
    }

    a(Context context) {
        AppMethodBeat.i(121609);
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.o(121609);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(121610);
        C0827a aVar = new C0827a(this.mInflater.inflate(R.layout.w9, viewGroup, false), i2);
        AppMethodBeat.o(121610);
        return aVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(121612);
        int size = this.oFB.size();
        AppMethodBeat.o(121612);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(121613);
        int i3 = this.oFB.get(i2).level;
        AppMethodBeat.o(121613);
        return i3;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.a$a  reason: collision with other inner class name */
    static class C0827a extends RecyclerView.v {
        TextView hXC;
        TextView oFC;

        public C0827a(View view, int i2) {
            super(view);
            AppMethodBeat.i(121608);
            this.oFC = (TextView) view.findViewById(R.id.ear);
            this.hXC = (TextView) view.findViewById(R.id.bfe);
            switch (i2) {
                case 1:
                    this.oFC.setText("L");
                    this.hXC.setTextColor(-7829368);
                    AppMethodBeat.o(121608);
                    return;
                case 2:
                    this.oFC.setText("I");
                    this.hXC.setTextColor(WebView.NIGHT_MODE_COLOR);
                    AppMethodBeat.o(121608);
                    return;
                case 3:
                    this.oFC.setText(QLog.TAG_REPORTLEVEL_COLORUSER);
                    this.hXC.setTextColor(Color.rgb(0, 0, 204));
                    AppMethodBeat.o(121608);
                    return;
                case 4:
                    this.oFC.setText(QLog.TAG_REPORTLEVEL_USER);
                    this.hXC.setTextColor(-65536);
                    AppMethodBeat.o(121608);
                    return;
                default:
                    this.oFC.setText("L");
                    this.hXC.setTextColor(-7829368);
                    AppMethodBeat.o(121608);
                    return;
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2) {
        AppMethodBeat.i(121611);
        LogInfo logInfo = this.oFB.get(i2);
        ((C0827a) vVar).hXC.setText(String.format("[%s] %s", oFA.format(new Date(logInfo.ts)), logInfo.message));
        AppMethodBeat.o(121611);
    }
}
