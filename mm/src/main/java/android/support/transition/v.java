package android.support.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class v {
    final ArrayList<Transition> Df = new ArrayList<>();
    public final Map<String, Object> values = new HashMap();
    public View view;

    public final boolean equals(Object obj) {
        if (!(obj instanceof v) || this.view != ((v) obj).view || !this.values.equals(((v) obj).values)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.view.hashCode() * 31) + this.values.hashCode();
    }

    public final String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.view + "\n") + "    values:";
        for (String str2 : this.values.keySet()) {
            str = str + "    " + str2 + ": " + this.values.get(str2) + "\n";
        }
        return str;
    }
}
