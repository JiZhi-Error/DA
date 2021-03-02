package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.rtmp.TXLiveConstants;
import java.text.SimpleDateFormat;

public class TXDashBoard extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    protected TextView f1648a;

    /* renamed from: b  reason: collision with root package name */
    protected TextView f1649b;

    /* renamed from: c  reason: collision with root package name */
    protected ScrollView f1650c;

    /* renamed from: d  reason: collision with root package name */
    protected StringBuffer f1651d;

    /* renamed from: e  reason: collision with root package name */
    protected int f1652e;

    /* renamed from: f  reason: collision with root package name */
    private final SimpleDateFormat f1653f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1654g;

    public TXDashBoard(Context context) {
        this(context, null);
    }

    public TXDashBoard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(14271);
        this.f1651d = new StringBuffer("");
        this.f1652e = 3000;
        this.f1653f = new SimpleDateFormat("HH:mm:ss.SSS");
        this.f1654g = false;
        setOrientation(1);
        setVisibility(4);
        AppMethodBeat.o(14271);
    }

    public void setStatusTextSize(float f2) {
        AppMethodBeat.i(14272);
        if (this.f1648a != null) {
            this.f1648a.setTextSize(f2);
        }
        AppMethodBeat.o(14272);
    }

    public void a(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(14273);
        if (this.f1648a != null) {
            this.f1648a.setPadding(i2, i3, i4, 0);
        }
        if (this.f1650c != null) {
            this.f1650c.setPadding(i2, 0, i4, i5);
        }
        AppMethodBeat.o(14273);
    }

    public void setEventTextSize(float f2) {
        AppMethodBeat.i(14274);
        if (this.f1649b != null) {
            this.f1649b.setTextSize(f2);
        }
        AppMethodBeat.o(14274);
    }

    public void a(CharSequence charSequence) {
        AppMethodBeat.i(14275);
        if (this.f1648a != null) {
            this.f1648a.setText(charSequence);
        }
        AppMethodBeat.o(14275);
    }

    public void setLogMsgLenLimit(int i2) {
        this.f1652e = i2;
    }

    public void setShowLevel(int i2) {
        AppMethodBeat.i(14276);
        switch (i2) {
            case 0:
                if (this.f1648a != null) {
                    this.f1648a.setVisibility(4);
                }
                if (this.f1650c != null) {
                    this.f1650c.setVisibility(4);
                }
                setVisibility(4);
                AppMethodBeat.o(14276);
                return;
            case 1:
                b();
                this.f1648a.setVisibility(0);
                this.f1650c.setVisibility(4);
                setVisibility(0);
                AppMethodBeat.o(14276);
                return;
            default:
                b();
                this.f1648a.setVisibility(0);
                this.f1650c.setVisibility(0);
                setVisibility(0);
                AppMethodBeat.o(14276);
                return;
        }
    }

    private void b() {
        AppMethodBeat.i(14277);
        if (this.f1648a != null) {
            AppMethodBeat.o(14277);
            return;
        }
        this.f1648a = new TextView(getContext());
        this.f1649b = new TextView(getContext());
        this.f1650c = new ScrollView(getContext());
        this.f1648a.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f1648a.setTextColor(-49023);
        this.f1648a.setTypeface(Typeface.MONOSPACE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f1650c.setPadding(0, 10, 0, 0);
        this.f1650c.setLayoutParams(layoutParams);
        this.f1650c.setVerticalScrollBarEnabled(true);
        this.f1650c.setScrollbarFadingEnabled(true);
        this.f1649b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f1649b.setTextColor(-49023);
        this.f1650c.addView(this.f1649b);
        addView(this.f1648a);
        addView(this.f1650c);
        if (this.f1651d.length() <= 0) {
            this.f1651d.append("liteav sdk version:" + TXCCommonUtil.getSDKVersionStr() + "\n");
        }
        this.f1649b.setText(this.f1651d.toString());
        AppMethodBeat.o(14277);
    }

    public void a(String str) {
        AppMethodBeat.i(14278);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(14278);
            return;
        }
        String str2 = "[" + this.f1653f.format(Long.valueOf(System.currentTimeMillis())) + "]" + str + "\n";
        if (this.f1651d.length() <= 0) {
            this.f1651d.append("liteav sdk version:" + TXCCommonUtil.getSDKVersionStr() + "\n");
        }
        while (this.f1651d.length() > this.f1652e) {
            int indexOf = this.f1651d.indexOf("\n");
            if (indexOf == 0) {
                indexOf = 1;
            }
            this.f1651d = this.f1651d.delete(0, indexOf);
        }
        this.f1651d = this.f1651d.append(str2);
        if (this.f1649b != null) {
            this.f1649b.setText(this.f1651d.toString());
        }
        AppMethodBeat.o(14278);
    }

    public void a(boolean z) {
        this.f1654g = z;
    }

    public void a() {
        AppMethodBeat.i(14279);
        this.f1651d.setLength(0);
        if (this.f1648a != null) {
            this.f1648a.setText("");
        }
        if (this.f1649b != null) {
            this.f1649b.setText("");
        }
        AppMethodBeat.o(14279);
    }

    public void a(Bundle bundle, Bundle bundle2, int i2) {
        String string;
        AppMethodBeat.i(14280);
        if (this.f1654g) {
            AppMethodBeat.o(14280);
        } else if (i2 == 2011 || i2 == 2012) {
            AppMethodBeat.o(14280);
        } else {
            if (!(bundle == null || this.f1648a == null)) {
                this.f1648a.setText(a(bundle));
            }
            if (this.f1651d.length() <= 0) {
                this.f1651d.append("liteav sdk version:" + TXCCommonUtil.getSDKVersionStr() + "\n");
            }
            if (!(bundle2 == null || (string = bundle2.getString(TXLiveConstants.EVT_DESCRIPTION)) == null || string.isEmpty())) {
                a(i2, string);
                if (this.f1649b != null) {
                    this.f1649b.setText(this.f1651d.toString());
                }
                if (!(getVisibility() != 0 || this.f1650c == null || this.f1649b == null)) {
                    a(this.f1650c, this.f1649b);
                }
            }
            AppMethodBeat.o(14280);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, String str) {
        AppMethodBeat.i(14281);
        if (i2 == 1020) {
            AppMethodBeat.o(14281);
            return;
        }
        String format = new SimpleDateFormat("HH:mm:ss.SSS").format(Long.valueOf(System.currentTimeMillis()));
        while (this.f1651d.length() > this.f1652e) {
            int indexOf = this.f1651d.indexOf("\n");
            if (indexOf == 0) {
                indexOf = 1;
            }
            this.f1651d = this.f1651d.delete(0, indexOf);
        }
        this.f1651d = this.f1651d.append("\n[" + format + "]" + str);
        AppMethodBeat.o(14281);
    }

    /* access modifiers changed from: protected */
    public String a(Bundle bundle) {
        AppMethodBeat.i(14282);
        String format = String.format("%-16s %-16s %-16s\n%-12s %-12s %-12s %-12s\n%-14s %-14s %-14s\n%-16s %-16s", "CPU:" + bundle.getString(TXLiveConstants.NET_STATUS_CPU_USAGE), "RES:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH) + "*" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT), "SPD:" + bundle.getInt(TXLiveConstants.NET_STATUS_NET_SPEED) + "Kbps", "JIT:" + bundle.getInt(TXLiveConstants.NET_STATUS_NET_JITTER), "FPS:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS), "GOP:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_GOP) + "s", "ARA:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE) + "Kbps", "QUE:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE) + APLogFileUtil.SEPARATOR_LOG + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_V_SUM_CACHE_SIZE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE) + APLogFileUtil.SEPARATOR_LOG + bundle.getInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL) + "," + String.format("%.1f", Float.valueOf(bundle.getFloat(TXLiveConstants.NET_STATUS_AUDIO_CACHE_THRESHOLD))).toString(), "VRA:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "Kbps", "DRP:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_DROP) + "|" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_DROP), "SVR:" + bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP), "AUDIO:" + bundle.getString(TXLiveConstants.NET_STATUS_AUDIO_INFO));
        AppMethodBeat.o(14282);
        return format;
    }

    private void a(ScrollView scrollView, View view) {
        AppMethodBeat.i(14283);
        if (scrollView == null || view == null) {
            AppMethodBeat.o(14283);
            return;
        }
        int measuredHeight = view.getMeasuredHeight() - scrollView.getMeasuredHeight();
        if (measuredHeight < 0) {
            measuredHeight = 0;
        }
        scrollView.scrollTo(0, measuredHeight);
        AppMethodBeat.o(14283);
    }
}
