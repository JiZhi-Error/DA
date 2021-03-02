package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.jsapi.u.c;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.gif.MMAnimateView;

public final class n implements b {
    @Override // com.tencent.mm.plugin.appbrand.widget.b.b
    public final com.tencent.mm.plugin.appbrand.widget.b.a ed(Context context) {
        AppMethodBeat.i(47492);
        a aVar = new a(context);
        AppMethodBeat.o(47492);
        return aVar;
    }

    public class a extends FrameLayout implements com.tencent.mm.plugin.appbrand.widget.b.a {
        private c cEN = null;
        private ImageView cIN;
        private MMAnimateView naj;
        private boolean nak;
        private ad.b nal;

        public a(Context context) {
            super(context);
            AppMethodBeat.i(47486);
            this.naj = new MMAnimateView(context);
            addView(this.naj, new ViewGroup.LayoutParams(-1, -1));
            this.naj.setVisibility(8);
            this.cIN = new ImageView(context);
            addView(this.cIN, new ViewGroup.LayoutParams(-1, -1));
            this.cIN.setVisibility(8);
            AppMethodBeat.o(47486);
        }

        public final void setImageFilePath(String str) {
            AppMethodBeat.i(47487);
            this.naj.setVisibility(0);
            this.cIN.setVisibility(8);
            this.naj.setImageFilePath(str);
            AppMethodBeat.o(47487);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.b.c
        public final void setImageByteArray(byte[] bArr) {
            AppMethodBeat.i(47488);
            this.naj.setVisibility(0);
            this.cIN.setVisibility(8);
            this.naj.g(bArr, "");
            AppMethodBeat.o(47488);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.b.d
        public final void setImageBitmap(Bitmap bitmap) {
            AppMethodBeat.i(47489);
            this.naj.setVisibility(8);
            this.cIN.setVisibility(0);
            this.cIN.setImageBitmap(bitmap);
            AppMethodBeat.o(47489);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.b.a
        public final View getView() {
            return this;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.b.d
        public final void setScaleType(ImageView.ScaleType scaleType) {
            AppMethodBeat.i(47490);
            this.cIN.setScaleType(scaleType);
            this.naj.setScaleType(scaleType);
            AppMethodBeat.o(47490);
        }

        public final void setInterceptEvent(boolean z) {
            this.nak = z;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.base.f
        public final boolean bEY() {
            return this.nak;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.u.b
        public final c getReferrerPolicy() {
            return this.cEN;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.u.b
        public final void setReferrerPolicy(c cVar) {
            this.cEN = cVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.b.a
        public final void setKeyValueSet(ad.b bVar) {
            this.nal = bVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.b.a
        public final ad.b getKeyValueSet() {
            return this.nal;
        }
    }
}
