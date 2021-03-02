package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.graphics.drawable.Drawable;

public interface i {
    public static final a nvz = new a() {
        /* class com.tencent.mm.plugin.appbrand.page.capsulebar.i.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
        public final void setLogo(Drawable drawable) {
        }

        @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
        public final void setLogo(int i2) {
        }

        @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
        public final void setDescription(CharSequence charSequence) {
        }

        @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
        public final void yT(int i2) {
        }

        @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
        public final void setStatus(int i2) {
        }

        @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
        public final void dismiss() {
        }
    };

    public interface a {
        void dismiss();

        void setDescription(CharSequence charSequence);

        void setLogo(int i2);

        void setLogo(Drawable drawable);

        void setStatus(int i2);

        void yT(int i2);
    }
}
