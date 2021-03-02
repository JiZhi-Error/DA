package com.tencent.kinda.framework.widget.base;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KLink;
import com.tencent.kinda.gen.KText;
import com.tencent.kinda.gen.LinkStyle;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.widget.h.c;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class MMKRichText implements KText {
    public boolean hasLinkAndCanCallback = false;
    private SpannableStringBuilder spanText = new SpannableStringBuilder("");

    public MMKRichText() {
        AppMethodBeat.i(19109);
        AppMethodBeat.o(19109);
    }

    @Override // com.tencent.kinda.gen.KText
    public void appendText(String str) {
        AppMethodBeat.i(19110);
        if (str != null) {
            this.spanText.append((CharSequence) l.c(MMApplicationContext.getContext(), str));
        }
        AppMethodBeat.o(19110);
    }

    @Override // com.tencent.kinda.gen.KText
    public void appendLink(KLink kLink) {
        AppMethodBeat.i(19111);
        if (kLink != null && (kLink instanceof MMKLink)) {
            MMKLink mMKLink = (MMKLink) kLink;
            this.spanText.append((CharSequence) mMKLink.get());
            this.hasLinkAndCanCallback = mMKLink.hasCallBack;
        }
        AppMethodBeat.o(19111);
    }

    public CharSequence get() {
        return this.spanText;
    }

    public static class MMKLink implements KLink {
        private DynamicColor bgColor;
        private int bgRadius;
        private VoidCallback clickCallback;
        public boolean hasCallBack = false;
        private int linkColor;
        private LinkStyle linkStyle;
        private boolean setLinkColor = false;
        private String text;
        private float textSize;

        @Override // com.tencent.kinda.gen.KLink
        public void setText(String str) {
            this.text = str;
        }

        @Override // com.tencent.kinda.gen.KLink
        public void setLinkColor(DynamicColor dynamicColor) {
            AppMethodBeat.i(19107);
            this.linkColor = MMKViewUtil.argbColor(ColorUtil.getColorByMode(dynamicColor));
            this.setLinkColor = true;
            AppMethodBeat.o(19107);
        }

        @Override // com.tencent.kinda.gen.KLink
        public void setLinkCallbackImpl(VoidCallback voidCallback) {
            if (voidCallback != null) {
                this.clickCallback = voidCallback;
                this.hasCallBack = true;
            }
        }

        @Override // com.tencent.kinda.gen.KLink
        public void setLinkStyle(LinkStyle linkStyle2) {
            this.linkStyle = linkStyle2;
        }

        public SpannableString get() {
            SpannableString spannableString;
            AppMethodBeat.i(19108);
            SpannableString spannableString2 = new SpannableString("");
            if (this.text != null) {
                spannableString = new SpannableString(this.text);
            } else {
                spannableString = spannableString2;
            }
            if (!this.setLinkColor && ColorUtil.ifCompatKindaDarkModeDefaultColor()) {
                this.linkColor = MMKViewUtil.argbColor(ColorUtil.getColorByMode(new DynamicColor(Long.parseLong("E6000000", 16), Long.parseLong("CCFFFFFF", 16))));
            }
            spannableString.setSpan(new ForegroundColorSpan(this.linkColor), 0, spannableString.length(), 33);
            if (this.clickCallback != null) {
                spannableString.setSpan(new LinkClickableSpan(this.linkColor, this.clickCallback), 0, spannableString.length(), 33);
            }
            if (this.linkStyle == LinkStyle.DELETED) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
            if (this.linkStyle == LinkStyle.UNDERLINE) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (this.bgColor != null) {
                long colorByMode = ColorUtil.getColorByMode(this.bgColor);
                int fromDPToPix = a.fromDPToPix(MMApplicationContext.getContext(), 4);
                spannableString.setSpan(new c(this.text, fromDPToPix, fromDPToPix, (int) this.textSize, this.linkColor, (int) colorByMode, this.bgRadius), 0, spannableString.length(), 33);
            }
            AppMethodBeat.o(19108);
            return spannableString;
        }

        /* access modifiers changed from: package-private */
        public static class LinkClickableSpan extends p {
            private VoidCallback clickCallback;
            private int linkColor;
            private LinkStyle linkStyle;

            public LinkClickableSpan(int i2, VoidCallback voidCallback) {
                super(2, (u) null);
                AppMethodBeat.i(19105);
                this.linkColor = i2;
                this.clickCallback = voidCallback;
                setColor(this.linkColor, MMApplicationContext.getContext().getResources().getColor(R.color.BW_0_Alpha_0_1));
                AppMethodBeat.o(19105);
            }

            @Override // com.tencent.mm.pluginsdk.ui.span.p
            public void onClick(View view) {
                AppMethodBeat.i(19106);
                if (this.clickCallback != null) {
                    this.clickCallback.call();
                }
                AppMethodBeat.o(19106);
            }
        }

        @Override // com.tencent.kinda.gen.KLink
        public void setLinkFont(String str) {
        }

        @Override // com.tencent.kinda.gen.KLink
        public void setBackground(DynamicColor dynamicColor, int i2) {
            AppMethodBeat.i(214558);
            this.bgColor = dynamicColor;
            this.bgRadius = a.fromDPToPix(MMApplicationContext.getContext(), i2);
            AppMethodBeat.o(214558);
        }

        @Override // com.tencent.kinda.gen.KLink
        public void setTextSize(float f2) {
            AppMethodBeat.i(214559);
            this.textSize = (float) a.fromDPToPix(MMApplicationContext.getContext(), f2);
            AppMethodBeat.o(214559);
        }
    }
}
