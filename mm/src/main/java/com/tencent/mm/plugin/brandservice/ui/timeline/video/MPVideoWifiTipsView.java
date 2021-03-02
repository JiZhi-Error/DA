package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "tipsTv", "Landroid/widget/TextView;", "getSizeMB", "bytes", "", "cRound", "", "setTipsText", "", "fileSize", "wordingType", "", "Companion", "plugin-brandservice_release"})
public final class MPVideoWifiTipsView extends RelativeLayout {
    public static final a pJW = new a((byte) 0);
    private final String TAG = "MicroMsg.MPVideoWifiTipsView";
    private TextView pJV;

    static {
        AppMethodBeat.i(175527);
        AppMethodBeat.o(175527);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MPVideoWifiTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(7273);
        View.inflate(context, R.layout.bby, this);
        View findViewById = findViewById(R.id.a_6);
        p.g(findViewById, "findViewById(R.id.biz_video_wifi_tips_tv)");
        this.pJV = (TextView) findViewById;
        AppMethodBeat.o(7273);
    }

    public final void n(long j2, int i2) {
        String string;
        AppMethodBeat.i(175526);
        if (i2 == 2) {
            string = getContext().getString(R.string.ajo, BN(j2));
        } else {
            string = getContext().getString(R.string.ajn);
        }
        p.g(string, "if (wordingType == 2) {\n…ideo_wifi_tips)\n        }");
        this.pJV.setText(string);
        AppMethodBeat.o(175526);
    }

    private static String BN(long j2) {
        AppMethodBeat.i(7272);
        String valueOf = String.valueOf(((double) Math.round((((double) j2) * 10.0d) / 1048576.0d)) / 10.0d);
        AppMethodBeat.o(7272);
        return valueOf;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView$Companion;", "", "()V", "canShowWording1OnFirstPlay", "", "showWifiTipsFlag", "", "canShowWording2OnFirstPlay", "canShowWording2OnNetChange", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean DK(int i2) {
            return (i2 & 1) != 0;
        }

        public static boolean DL(int i2) {
            return (i2 & 2) != 0;
        }

        public static boolean DM(int i2) {
            return (i2 & 4) != 0;
        }
    }
}
