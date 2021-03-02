package android.support.v4.media;

import android.support.v4.e.j;
import android.support.v4.media.d;
import android.text.TextUtils;

class g {
    private static final boolean DEBUG = d.DEBUG;

    /* access modifiers changed from: package-private */
    public static class a implements d.b {
        private int Mq;
        private int Mr;
        private String mPackageName;

        a(String str, int i2, int i3) {
            this.mPackageName = str;
            this.Mq = i2;
            this.Mr = i3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.mPackageName, aVar.mPackageName) && this.Mq == aVar.Mq && this.Mr == aVar.Mr;
        }

        public final int hashCode() {
            return j.hash(this.mPackageName, Integer.valueOf(this.Mq), Integer.valueOf(this.Mr));
        }
    }
}
