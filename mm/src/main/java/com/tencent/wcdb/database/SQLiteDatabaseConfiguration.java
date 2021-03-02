package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.extension.SQLiteExtension;
import java.util.LinkedHashSet;
import java.util.Locale;

public final class SQLiteDatabaseConfiguration {
    public static final String MEMORY_DB_PATH = ":memory:";
    public boolean customWALHookEnabled;
    public final LinkedHashSet<SQLiteExtension> extensions = new LinkedHashSet<>();
    public boolean foreignKeyConstraintsEnabled;
    public final String label;
    public Locale locale;
    public int maxSqlCacheSize;
    public int openFlags;
    public final String path;
    public int synchronousMode;
    public boolean updateNotificationEnabled;
    public boolean updateNotificationRowID;
    public String vfsName;

    public SQLiteDatabaseConfiguration(String str, int i2) {
        AppMethodBeat.i(3226);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("path must not be null.");
            AppMethodBeat.o(3226);
            throw illegalArgumentException;
        }
        this.path = str;
        this.label = str;
        this.openFlags = i2;
        this.synchronousMode = 2;
        this.maxSqlCacheSize = 25;
        this.locale = Locale.getDefault();
        this.vfsName = (i2 & 256) != 0 ? "vfslog" : null;
        AppMethodBeat.o(3226);
    }

    public SQLiteDatabaseConfiguration(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        AppMethodBeat.i(3227);
        if (sQLiteDatabaseConfiguration == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("other must not be null.");
            AppMethodBeat.o(3227);
            throw illegalArgumentException;
        }
        this.path = sQLiteDatabaseConfiguration.path;
        this.label = sQLiteDatabaseConfiguration.label;
        updateParametersFrom(sQLiteDatabaseConfiguration);
        AppMethodBeat.o(3227);
    }

    public final void updateParametersFrom(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        AppMethodBeat.i(3228);
        if (sQLiteDatabaseConfiguration == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("other must not be null.");
            AppMethodBeat.o(3228);
            throw illegalArgumentException;
        } else if (!this.path.equals(sQLiteDatabaseConfiguration.path)) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("other configuration must refer to the same database.");
            AppMethodBeat.o(3228);
            throw illegalArgumentException2;
        } else {
            this.openFlags = sQLiteDatabaseConfiguration.openFlags;
            this.maxSqlCacheSize = sQLiteDatabaseConfiguration.maxSqlCacheSize;
            this.locale = sQLiteDatabaseConfiguration.locale;
            this.foreignKeyConstraintsEnabled = sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled;
            this.customWALHookEnabled = sQLiteDatabaseConfiguration.customWALHookEnabled;
            this.updateNotificationEnabled = sQLiteDatabaseConfiguration.updateNotificationEnabled;
            this.updateNotificationRowID = sQLiteDatabaseConfiguration.updateNotificationRowID;
            this.synchronousMode = sQLiteDatabaseConfiguration.synchronousMode;
            this.vfsName = sQLiteDatabaseConfiguration.vfsName;
            this.extensions.clear();
            this.extensions.addAll(sQLiteDatabaseConfiguration.extensions);
            AppMethodBeat.o(3228);
        }
    }

    public final boolean isInMemoryDb() {
        AppMethodBeat.i(3229);
        boolean equalsIgnoreCase = this.path.equalsIgnoreCase(MEMORY_DB_PATH);
        AppMethodBeat.o(3229);
        return equalsIgnoreCase;
    }
}
