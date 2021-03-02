package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

public class TXLogView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    StringBuffer f1655a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f1656b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f1657c;

    /* renamed from: d  reason: collision with root package name */
    private ScrollView f1658d;

    /* renamed from: e  reason: collision with root package name */
    private ScrollView f1659e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1660f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1661g;

    public TXLogView(Context context) {
        this(context, null);
    }

    public TXLogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(14285);
        this.f1655a = new StringBuffer("");
        this.f1660f = 3000;
        this.f1661g = false;
        setOrientation(1);
        this.f1656b = new TextView(context);
        this.f1657c = new TextView(context);
        this.f1658d = new ScrollView(context);
        this.f1659e = new ScrollView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 0.2f;
        this.f1658d.setLayoutParams(layoutParams);
        this.f1658d.setBackgroundColor(1627389951);
        this.f1658d.setVerticalScrollBarEnabled(true);
        this.f1658d.setScrollbarFadingEnabled(true);
        this.f1656b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f1656b.setTextSize(2, 11.0f);
        this.f1656b.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.f1656b.setTypeface(Typeface.MONOSPACE, 1);
        this.f1656b.setLineSpacing(4.0f, 1.0f);
        this.f1656b.setPadding(a(context, 2.0f), a(context, 2.0f), a(context, 2.0f), a(context, 2.0f));
        this.f1658d.addView(this.f1656b);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 0.8f;
        layoutParams2.topMargin = a(context, 2.0f);
        this.f1659e.setLayoutParams(layoutParams2);
        this.f1659e.setBackgroundColor(1627389951);
        this.f1659e.setVerticalScrollBarEnabled(true);
        this.f1659e.setScrollbarFadingEnabled(true);
        this.f1657c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f1657c.setTextSize(2, 13.0f);
        this.f1657c.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.f1657c.setPadding(a(context, 2.0f), a(context, 2.0f), a(context, 2.0f), a(context, 2.0f));
        this.f1659e.addView(this.f1657c);
        addView(this.f1658d);
        addView(this.f1659e);
        setVisibility(8);
        AppMethodBeat.o(14285);
    }

    public static int a(Context context, float f2) {
        AppMethodBeat.i(14286);
        int i2 = (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
        AppMethodBeat.o(14286);
        return i2;
    }
}
