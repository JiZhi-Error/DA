package android.support.v4.app;

import android.app.RemoteInput;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

public final class x {
    final String II;
    final CharSequence IJ;
    final CharSequence[] IK;
    final boolean IL;
    final Set<String> IM;
    final Bundle mExtras;

    public x(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle, Set<String> set) {
        this.II = str;
        this.IJ = charSequence;
        this.IK = charSequenceArr;
        this.IL = z;
        this.mExtras = bundle;
        this.IM = set;
    }

    public static final class a {
        public final String II;
        public CharSequence IJ;
        public CharSequence[] IK;
        public boolean IL = true;
        public final Set<String> IM = new HashSet();
        public final Bundle mExtras = new Bundle();

        public a(String str) {
            this.II = str;
        }
    }

    static RemoteInput[] b(x[] xVarArr) {
        if (xVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[xVarArr.length];
        for (int i2 = 0; i2 < xVarArr.length; i2++) {
            x xVar = xVarArr[i2];
            remoteInputArr[i2] = new RemoteInput.Builder(xVar.II).setLabel(xVar.IJ).setChoices(xVar.IK).setAllowFreeFormInput(xVar.IL).addExtras(xVar.mExtras).build();
        }
        return remoteInputArr;
    }
}
