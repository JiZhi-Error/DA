package android.arch.lifecycle;

import java.util.HashMap;
import java.util.Map;

public class MethodCallsLogger {
    private Map<String, Integer> da = new HashMap();

    public boolean approveCall(String str, int i2) {
        int i3;
        boolean z;
        Integer num = this.da.get(str);
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        if ((i3 & i2) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.da.put(str, Integer.valueOf(i3 | i2));
        return !z;
    }
}
