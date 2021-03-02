package com.tencent.mm.plugin.scanner.ui.widget;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0011H\u0016R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTab;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tabId", "tabTitle", "Landroid/widget/TextView;", "getTabId", "getTabTitle", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "onTabSelected", "onTabUnselected", "setTabEnabled", "enable", "", "setTabId", "setTabTitle", "Companion", "plugin-scan_release"})
public final class ScrollTab extends LinearLayout implements a {
    public static final a CSW = new a((byte) 0);
    private TextView CSV;
    private int ehn;

    static {
        AppMethodBeat.i(52474);
        AppMethodBeat.o(52474);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTab$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScrollTab(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(52471);
        AppMethodBeat.o(52471);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScrollTab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(52472);
        AppMethodBeat.o(52472);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollTab(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(52473);
        this.ehn = -1;
        View findViewById = LayoutInflater.from(context).inflate(R.layout.az_, this).findViewById(R.id.hcq);
        p.g(findViewById, "view.findViewById(R.id.scroll_tab_title)");
        this.CSV = (TextView) findViewById;
        TextView textView = this.CSV;
        if (textView == null) {
            p.btv("tabTitle");
        }
        textView.setAlpha(0.5f);
        AppMethodBeat.o(52473);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.widget.a
    public final int getTabId() {
        return this.ehn;
    }

    public final String getTabTitle() {
        AppMethodBeat.i(52467);
        TextView textView = this.CSV;
        if (textView == null) {
            p.btv("tabTitle");
        }
        String obj = textView.getText().toString();
        AppMethodBeat.o(52467);
        return obj;
    }

    public final void setTabId(int i2) {
        this.ehn = i2;
    }

    public final void setTabTitle(String str) {
        AppMethodBeat.i(52468);
        p.h(str, "tabTitle");
        TextView textView = this.CSV;
        if (textView == null) {
            p.btv("tabTitle");
        }
        textView.setText(str);
        AppMethodBeat.o(52468);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.widget.a
    public final void eRu() {
        AppMethodBeat.i(52469);
        Object[] objArr = new Object[1];
        TextView textView = this.CSV;
        if (textView == null) {
            p.btv("tabTitle");
        }
        objArr[0] = textView.getText();
        Log.d("MicroMsg.ScrollTab", "alvinluo onTabSelected %s", objArr);
        TextView textView2 = this.CSV;
        if (textView2 == null) {
            p.btv("tabTitle");
        }
        textView2.setTextColor(getResources().getColor(R.color.a6c));
        TextView textView3 = this.CSV;
        if (textView3 == null) {
            p.btv("tabTitle");
        }
        textView3.setAlpha(1.0f);
        TextView textView4 = this.CSV;
        if (textView4 == null) {
            p.btv("tabTitle");
        }
        TextPaint paint = textView4.getPaint();
        if (paint != null) {
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        TextView textView5 = this.CSV;
        if (textView5 == null) {
            p.btv("tabTitle");
        }
        TextPaint paint2 = textView5.getPaint();
        if (paint2 != null) {
            paint2.setStrokeWidth(0.8f);
            AppMethodBeat.o(52469);
            return;
        }
        AppMethodBeat.o(52469);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.widget.a
    public final void eRv() {
        AppMethodBeat.i(52470);
        Object[] objArr = new Object[1];
        TextView textView = this.CSV;
        if (textView == null) {
            p.btv("tabTitle");
        }
        objArr[0] = textView.getText();
        Log.d("MicroMsg.ScrollTab", "alvinluo onTabUnselected %s", objArr);
        TextView textView2 = this.CSV;
        if (textView2 == null) {
            p.btv("tabTitle");
        }
        textView2.setTextColor(getResources().getColor(R.color.a6c));
        TextView textView3 = this.CSV;
        if (textView3 == null) {
            p.btv("tabTitle");
        }
        textView3.setAlpha(0.5f);
        TextView textView4 = this.CSV;
        if (textView4 == null) {
            p.btv("tabTitle");
        }
        TextPaint paint = textView4.getPaint();
        if (paint != null) {
            paint.setStyle(Paint.Style.FILL);
            AppMethodBeat.o(52470);
            return;
        }
        AppMethodBeat.o(52470);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.widget.a
    public final void setTabEnabled(boolean z) {
        AppMethodBeat.i(170093);
        Log.v("MicroMsg.ScrollTab", "alvinluo setTabEnabled %b", Boolean.valueOf(z));
        if (z) {
            setAlpha(1.0f);
            AppMethodBeat.o(170093);
            return;
        }
        setAlpha(0.3f);
        AppMethodBeat.o(170093);
    }
}
