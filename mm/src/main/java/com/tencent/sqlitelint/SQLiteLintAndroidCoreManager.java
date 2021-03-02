package com.tencent.sqlitelint;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLint;
import com.tencent.sqlitelint.behaviour.BaseBehaviour;
import com.tencent.sqlitelint.util.SLog;
import java.util.concurrent.ConcurrentHashMap;

public enum SQLiteLintAndroidCoreManager {
    INSTANCE;
    
    private static final String TAG = "SQLiteLint.SQLiteLintAndroidCoreManager";
    private ConcurrentHashMap<String, SQLiteLintAndroidCore> mCoresMap = new ConcurrentHashMap<>();

    private SQLiteLintAndroidCoreManager() {
        AppMethodBeat.i(52847);
        AppMethodBeat.o(52847);
    }

    public static SQLiteLintAndroidCoreManager valueOf(String str) {
        AppMethodBeat.i(52846);
        SQLiteLintAndroidCoreManager sQLiteLintAndroidCoreManager = (SQLiteLintAndroidCoreManager) Enum.valueOf(SQLiteLintAndroidCoreManager.class, str);
        AppMethodBeat.o(52846);
        return sQLiteLintAndroidCoreManager;
    }

    static {
        AppMethodBeat.i(52853);
        AppMethodBeat.o(52853);
    }

    public final void install(Context context, SQLiteLint.InstallEnv installEnv, SQLiteLint.Options options) {
        AppMethodBeat.i(52848);
        String concernedDbPath = installEnv.getConcernedDbPath();
        if (this.mCoresMap.containsKey(concernedDbPath)) {
            SLog.w(TAG, "install twice!! ignore", new Object[0]);
            AppMethodBeat.o(52848);
            return;
        }
        this.mCoresMap.put(concernedDbPath, new SQLiteLintAndroidCore(context, installEnv, options));
        AppMethodBeat.o(52848);
    }

    public final void addBehavior(BaseBehaviour baseBehaviour, String str) {
        AppMethodBeat.i(52849);
        if (get(str) == null) {
            AppMethodBeat.o(52849);
            return;
        }
        get(str).addBehavior(baseBehaviour);
        AppMethodBeat.o(52849);
    }

    public final void removeBehavior(BaseBehaviour baseBehaviour, String str) {
        AppMethodBeat.i(52850);
        if (get(str) == null) {
            AppMethodBeat.o(52850);
            return;
        }
        get(str).removeBehavior(baseBehaviour);
        AppMethodBeat.o(52850);
    }

    public final SQLiteLintAndroidCore get(String str) {
        AppMethodBeat.i(52851);
        SQLiteLintAndroidCore sQLiteLintAndroidCore = this.mCoresMap.get(str);
        AppMethodBeat.o(52851);
        return sQLiteLintAndroidCore;
    }

    public final void remove(String str) {
        AppMethodBeat.i(52852);
        this.mCoresMap.remove(str);
        AppMethodBeat.o(52852);
    }
}
