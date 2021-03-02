package com.tencent.toybrick.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.toybrick.c.f;
import java.util.HashMap;

public abstract class BaseToyUI<T extends f> extends BaseActivity {
    private HashMap<String, f> mMap = new HashMap<>();

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.BaseActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public enum a {
        CHANGE,
        INSERT,
        REMOVE;

        public static a valueOf(String str) {
            AppMethodBeat.i(159983);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(159983);
            return aVar;
        }

        static {
            AppMethodBeat.i(159984);
            AppMethodBeat.o(159984);
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        this.mMap.clear();
    }
}
